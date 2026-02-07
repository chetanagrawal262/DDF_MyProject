
package com.listeners;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.openqa.selenium.TakesScreenshot;
import com.aventstack.extentreports.ExtentReports;
import com.base.BasePage;
import com.base.DriverFactory;
import extentReports.ExtentManager;
import extentReports.ExtentTestManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;


public class ClientModuleSuiteFilter  extends BasePage implements ITestListener, ISuiteListener, IMethodInterceptor {

	private static class Rule {

final Set<String> allowedTests;
        final Map<String, Set<String>> allowedClassesByTest;

        Rule(Set<String> allowedTests, Map<String, Set<String>> allowedClassesByTest) {

        	// CHANGE #1: use baseLower(...) instead of plain lower
        	            this.allowedTests = (allowedTests == null)
        	                    ? Collections.emptySet()
        	                    : toLowerNames(allowedTests);
        	            // CHANGE #2: use freezeMap(...) that keys by baseLower(...)
        	            this.allowedClassesByTest = (allowedClassesByTest == null)
        	                    ? Collections.emptyMap()
        	                    : freezeMap(allowedClassesByTest);
        	        }

        	        static Rule passThrough() {
        	            return new Rule(Collections.emptySet(), Collections.emptyMap());
        	        }

        	        // ---------- ADD THESE 2 HELPERS (anywhere inside Rule is fine) ----------
        	        /** Strip trailing "-<digits>" that TestNG can append (e.g., "AdministrationSecurity-0"). */
        	        private static String baseTestName(String s) {
        	            if (s == null) return "";
        	            return s.replaceFirst("-\\d+$", ""); // "X-0" -> "X"
        	        }

        	        /** Normalize: strip suffix then lowercase. */
        	        private static String baseLower(String s) {
        	            return baseTestName(s).toLowerCase(Locale.ROOT);
        	        }
        	        // -----------------------------------------------------------------------

        	        // CHANGE #3: use baseLower(...) when storing allowed test names
        	        private static Set<String> toLowerNames(Set<String> names) {
        	            return names.stream()
        	                    .map(Rule::baseLower)
        	                    .collect(Collectors.toUnmodifiableSet());
        	        }

        	        // CHANGE #4: use baseLower(...) for keys when freezing the map
        	        private static Map<String, Set<String>> freezeMap(Map<String, Set<String>> src) {
        	            Map<String, Set<String>> out = new HashMap<>();
        	            for (Map.Entry<String, Set<String>> e : src.entrySet()) {
        	                out.put(baseLower(e.getKey()),
        	                        Collections.unmodifiableSet(new HashSet<>(e.getValue())));
        	            }
        	            return Collections.unmodifiableMap(out);
        	        }

        	        // CHANGE #5: use baseLower(...) when checking test names at runtime
        	        boolean isTestAllowed(String xmlTestName) {
        	            if (allowedTests.isEmpty()) return true;
        	            return allowedTests.contains(baseLower(xmlTestName));
        	        }

        	        // CHANGE #6: use baseLower(...) when retrieving allowed classes by test
        	        boolean isClassAllowed(String xmlTestName, String className) {
        	            if (allowedClassesByTest.isEmpty()) return true;
        	            Set<String> allowedClasses = allowedClassesByTest.get(baseLower(xmlTestName));
        	            if (allowedClasses == null || allowedClasses.isEmpty()) return true;
        	            return allowedClasses.contains(className); // FQCN is case-sensitive
        	        }

        	        // (kept for other callers—unused after our changes, but harmless)
        	        @SuppressWarnings("unused")
        	        private static String safeLower(String s) {
        	            return (s == null) ? "" : s.toLowerCase(Locale.ROOT);
        	        }
        	    }

        	    // moduleKey(lower) -> (clientKey(lower) -> Rule)
        	    private static final Map<String, Map<String, Rule>> MODULE_CLIENT_RULES = new HashMap<>();

        	    private static String norm(String s) { return (s == null) ? "" : s.trim().toLowerCase(Locale.ROOT); }

        	    private static void putModule(String moduleName, Map<String, Rule> clientRules) {
        	        // Store with .xml (lower) and alias without .xml
        	        String k = norm(moduleName);
        	        Map<String, Rule> readonly = Collections.unmodifiableMap(new LinkedHashMap<>(clientRules));
        	        MODULE_CLIENT_RULES.put(k, readonly);

        	        if (k.endsWith(".xml")) {
        	            String alias = k.substring(0, k.length() - 4); // drop ".xml"
        	            MODULE_CLIENT_RULES.put(alias, readonly);
        	        }
        	    }

    static {
    	


        // =============================================================================
        // ========== MODULE: Administration.xml  (rich filtering; your existing rules)
        // =============================================================================

        // <test name="..."> (keys stored lower-case by Rule)
        final String T_SEC   = "AdministrationSecurity";
        final String T_TPL   = "AdministrationTemplate";
        final String T_CONF  = "AdministrationConfiguration";
        final String T_IDX   = "Administration_IndexManager";

        // Fully qualified class names
        final String C_ACC   = "testsuit.adminSecurity.UserAccount_AddNewUserTest";
        final String C_MGMT  = "testsuit.adminSecurity.ManageUser_AddNewUserTest";
        final String C_PG    = "testsuit.adminSecurity.UserRole_PagePermissionTest";
        final String C_SP    = "testsuit.adminSecurity.UserRole_SpecialPermissionTest";
        final String C_TMP   = "testsuit.adminSecurity.UserRole_TemplatePermissionTest";
        final String C_PENC  = "testsuit.adminSecurity.PasswordEncryptionTest";

        final String C_T_ADD = "testsuit.AdministrationTemplate.AddNewTemplateTest";

        final String C_PMT   = "testsuit.AdministrationConfiguration.PermitAgenciesTest";
        final String C_OPC   = "testsuit.AdministrationConfiguration.OperatingCompaniesTest";
        final String C_CTC   = "testsuit.AdministrationConfiguration.ContractCompaniesTest";
        final String C_PDC   = "testsuit.AdministrationConfiguration.PredefinedClausesTest";
        final String C_GRP   = "testsuit.AdministrationConfiguration.GroupListTest";

        final String C_IDX   = "testsuit.Administration_IndexManager.IndexManagerTest";

        Map<String, Rule> adminClientRules = new LinkedHashMap<>();

        // NOTE: client keys are lowercase in the map
        adminClientRules.put("alt", new Rule(
                setOf(T_SEC, T_TPL, T_CONF, T_IDX),
                mapOf(
                    T_SEC, setOf(C_ACC, C_MGMT, C_PG, C_SP, C_TMP, C_PENC),
                    T_TPL, setOf(C_T_ADD),
                    T_CONF, setOf(C_PMT, C_OPC, C_CTC),
                    T_IDX, setOf(C_IDX)
                )
        ));

        adminClientRules.put("row", new Rule(
                setOf(T_SEC, T_TPL, T_CONF, T_IDX),
                mapOf(
                    T_SEC, setOf(C_ACC, C_MGMT, C_PG, C_SP, C_TMP),
                    T_TPL, setOf(C_T_ADD),
                    T_CONF, setOf(C_PMT, C_OPC, C_CTC, C_PDC),
                    T_IDX, setOf(C_IDX)
                )
        ));

        // Your UI shows WOLFMIDSTREAM (replacing previous WOLF)
        adminClientRules.put("wolfmidstream", new Rule(
                setOf(T_SEC, T_TPL, T_CONF),
                mapOf(
                    T_SEC, setOf(C_ACC, C_MGMT, C_SP, C_TMP),
                    T_TPL, setOf(C_T_ADD),
                    T_CONF, setOf(C_PMT, C_CTC, C_GRP)
                )
        ));

        putModule("Administration.xml", adminClientRules);

        // =============================================================================
        // ========== Other MODULES from your Active Choices (pass-through rules)
        // =============================================================================

        // Helper: pass-through Rule for clients (allows all tests/classes)
        Rule PT = Rule.passThrough();

        // Customer_Outreach.xml -> ALT, ROW
        putModule("Customer_Outreach.xml", new LinkedHashMap<String, Rule>() {{
            put("alt", PT);
            put("row", PT);
        }});

        // Imports.xml -> ALT, ORION, ROW
        putModule("Imports.xml", new LinkedHashMap<String, Rule>() {{
            put("alt", PT);
            put("orion", PT);
            put("row", PT);
        }});

        // Parcel.xml -> ALT, ORION, ORSTED, ROW, VALARD, DOMINION, WOLFMIDSTREAM
        putModule("Parcel.xml", new LinkedHashMap<String, Rule>() {{
            put("alt", PT);
            put("orion", PT);
            put("orsted", PT);
            put("row", PT);
            put("valard", PT);
            put("dominion", PT);
            put("wolfmidstream", PT);
        }});

        // Project.xml -> (not fully visible in your screenshot)
        // If your list is ALT, ROW, DOM(INION?), WOLFMIDSTREAM, add them all here:
        putModule("Project.xml", new LinkedHashMap<String, Rule>() {{
            put("alt", PT);
            put("row", PT);
            put("dom", PT);          // adjust to "dominion" if needed
            put("wolfmidstream", PT);
        }});

        // The rest of the modules from your MODULE dropdown (add clients as needed);
        // unknown clients will be allowed (pass-through) by the lenient behavior below.
        putModule("LeaseManager_Payments.xml", new LinkedHashMap<>());  // add clients when ready
        putModule("Reports.xml",               new LinkedHashMap<>());  // add clients when ready
        putModule("Tools.xml",                 new LinkedHashMap<>());  // add clients when ready
        putModule("Encroachment_Requests.xml",new LinkedHashMap<>());  // add clients when ready
        putModule("Third_Party_Agreements.xml",new LinkedHashMap<>());  // add clients when ready
    }

    @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {


String module = System.getProperty("module", context.getSuite().getParameter("module"));
String client = System.getProperty("client", context.getSuite().getParameter("client"));
String env    = System.getProperty("env",    context.getSuite().getParameter("env"));

System.out.printf("[ClientModuleSuiteFilter] Params: module='%s', client='%s', env='%s'%n",
        module, client, env);

// List first 10 methods before filtering
System.out.printf("[ClientModuleSuiteFilter] Discovered methods: %d%n", methods.size());
methods.stream().limit(10).forEach(m -> {
    String tn = m.getMethod().getXmlTest().getName();
    String cn = m.getMethod().getRealClass().getName();
    System.out.printf("  - test='%s' class='%s'%n", tn, cn);
});


//        String module = getParam("module", context);  // from -Dmodule or <parameter name="module"/>
//        String client = getParam("client", context);  // from -Dclient or <parameter name="client"/>
//        String env    = getParam("env", context);     // currently unused

        if (isBlank(module)) {
            throw new SkipException("[ClientModuleSuiteFilter] Missing -Dmodule or <parameter name=\"module\"/>. Aborting.");
        }
        if (isBlank(client)) {
            throw new SkipException("[ClientModuleSuiteFilter] Missing -Dclient or <parameter name=\"client\"/>. Aborting.");
        }

        String moduleKey = norm(module);
        String clientKey = norm(client);

        Map<String, Rule> clientRuleMap = MODULE_CLIENT_RULES.get(moduleKey);
        if (clientRuleMap == null) {
            // Lenient fallback: if module is unknown, allow everything
            System.out.printf("[ClientModuleSuiteFilter] No module rules for '%s' -> allowing all tests (no filtering).%n", module);
            return methods;
        }

        Rule rule = clientRuleMap.get(clientKey);
        if (rule == null) {
            // Lenient fallback: if client is not configured under the module, allow everything
            System.out.printf("[ClientModuleSuiteFilter] No client rule for module='%s', client='%s' -> allowing all tests (no filtering).%n",
                    module, client);
            return methods;
        }

        List<IMethodInstance> filtered = methods.stream()
                .filter(m -> {
                    String xmlTestName = safe(m.getMethod().getXmlTest().getName());
                    String className = m.getMethod().getRealClass().getName();
                    return rule.isTestAllowed(xmlTestName) && rule.isClassAllowed(xmlTestName, className);
                })
                .collect(Collectors.toList());

        if (filtered.isEmpty()) {
            throw new SkipException(String.format(
                    "[ClientModuleSuiteFilter] After applying rules for module='%s', client='%s', zero tests remain. " +
                            "Check <test> names and class FQCNs.", module, client));
        }

        System.out.printf("[ClientModuleSuiteFilter] module='%s', client='%s' -> kept %d/%d methods.%n",
                module, client, filtered.size(), methods.size());

        return filtered;
    }

    // -------- helpers --------
    private static String getParam(String key, ITestContext ctx) {
        String sys = System.getProperty(key);
        if (!isBlank(sys)) return sys;
        return ctx.getSuite().getParameter(key);
    }

    private static boolean isBlank(String s) { return s == null || s.trim().isEmpty(); }

    private static String safe(String s) { return (s == null) ? "" : s; }

    @SafeVarargs
    private static <T> Set<T> setOf(T... items) {
        Set<T> s = new LinkedHashSet<>();
        Collections.addAll(s, items);
        return Collections.unmodifiableSet(s);
    }

    @SafeVarargs
    private static <K, V> Map<K, V> mapOf(Object... kv) {
        if (kv.length % 2 != 0) throw new IllegalArgumentException("mapOf requires even number of arguments");
        Map<K, V> m = new LinkedHashMap<>();
        for (int i = 0; i < kv.length; i += 2) {
            @SuppressWarnings("unchecked") K k = (K) kv[i];
            @SuppressWarnings("unchecked") V v = (V) kv[i + 1];
            m.put(k, v);
        }
        return Collections.unmodifiableMap(m);
    }
    
    
    private static ExtentReports extent = ExtentManager.getInstance();
	int extentPassCount = 0;
	int extentFailCount = 0;
	int extentTestTotal = 0;
	int extentTestSkipped = 0;


	
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Test Case Started : "+result.getName());
		
		try {
			ExtentTestManager.createTest(result.getName());
			ExtentTestManager.info(result.getMethod().getMethodName() + " Started...");
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Case Passed : "+result.getName());
		
		ExtentTestManager.pass(result.getMethod().getMethodName() + " Passed...");
		extentPassCount++;
		WebDriver driverWithPass = DriverFactory.getTLDriver();
		try {
			ExtentTestManager.info("Adding screen capture for passed Test Case...");
			ExtentTestManager.getTest().addScreenCaptureFromBase64String(getBase64ScreenshotString(driverWithPass), result.getMethod().getMethodName());
		} catch (Exception e) {
			e.printStackTrace();
			ExtentTestManager.fail("Failed to get screenshot");
		}
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test Case Failed : "+result.getName());
		
		
		try {
			ExtentTestManager.fail(result.getMethod().getMethodName()+ " failed because of "+ result.getThrowable());
		}catch (Exception e) {
			e.printStackTrace();
		}
		extentFailCount++;
		WebDriver driverWithFailure = DriverFactory.getTLDriver();
		try {
			ExtentTestManager.info("Adding screen capture...");
			ExtentTestManager.getTest().addScreenCaptureFromBase64String(getBase64ScreenshotString(driverWithFailure), result.getMethod().getMethodName());
		} catch (Exception e) {
			e.printStackTrace();
			ExtentTestManager.fail("Failed to get screenshot");
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test Case Skipped : "+result.getName());
		
		try {
			ExtentTestManager.createTest(result.getMethod().getMethodName(), result.getMethod().getDescription());
			ExtentTestManager.skip(result.getMethod().getMethodName()+ " skipped because of "+ result.getThrowable());
			extentTestSkipped++;
			try {
				ExtentTestManager.info("Adding screen capture...");
				ExtentTestManager.getTest().addScreenCaptureFromBase64String(getBase64ScreenshotString(DriverFactory.getTLDriver()), result.getMethod().getMethodName());
			} catch (Exception e2) {
				e2.printStackTrace();
				ExtentTestManager.fail("Failed to get screenshot");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}


	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Test Suite Finished : "+context.getName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	private synchronized static String getScreenshotAsBase64(WebDriver driver) throws IOException {
		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/target/Screenshots/image.png";
		FileUtils.copyFile(source, new File(path));
		byte[] imageBytes = IOUtils.toByteArray(new FileInputStream(path));
		return Base64.getEncoder().encodeToString(imageBytes);
	}
	
	public synchronized String getBase64ScreenshotString(WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		byte[] fileContent = FileUtils.readFileToByteArray(source);
		String base64StringofScreenshot = "data:image/png;base64,"+Base64.getEncoder().encodeToString(fileContent);
		return base64StringofScreenshot;
	}

	@Override
	public void onStart(ISuite suite) {
		Map<String, String> parameters = suite.getXmlSuite().getParameters();
        for (Map.Entry<String, String> parameter : parameters.entrySet()) {
            String env = System.getenv(parameter.getKey());
            if (env != null && ! env.trim().isEmpty()) {
                parameter.setValue(env);
            }
        }
		
	}

	

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
}


