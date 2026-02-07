package page.Common;

import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.TestUtil;

public class LoginPage extends BasePage {
	TestUtil util;
	public static String projectName, VERSION;

	public LoginPage(WebDriver driver) {
	    this.driver = driver;
		util = new TestUtil(driver);
	}

	By txtUsernameOld = By.xpath("//input[@id='UCLogin_txtUserName']"); 
	By txtPasswordOld = By.xpath("//input[@id='UCLogin_txtPassword_ClientState']");    
	By txtUsername = By.xpath("//input[@id='UCLogin_inpTxtUserName']"); 
	By txtPassword = By.xpath("//input[@id='UCLogin_inpTxtPassword']");    
	By btnLogin = By.xpath("//input[@id='UCLogin_cmdSubmit_login']");
	By isLoginSuccess = By.xpath("//input[@id='ctl00_ContentPlaceHolderHeader_YALHD_LogStatus']");
	By version = By.xpath("//*[@id=\"ctl00_ContentPlaceHolderHeader_YALHD_goHome\"]");
	
	public void setUserName(String userName) {
		//util.inputText(txtUsername, userName);
		if(util.isElementVisible(txtUsername)) {
			util.inputTextAndPressTab(txtUsername, userName);
		}else {
			util.inputTextAndPressTab(txtUsernameOld, userName);
		}
	util.waitFor(200);	
	}

	public void setPassword(String password) {
		if(util.isElementVisible(txtPassword)) {
			util.inputTextAndPressTab(txtPassword, password);
		}else {
			util.inputText(txtPasswordOld, password);
		}
	}

	public void login(Map<String, String> map) {
		setUserName(map.get("NonSuperAdminUserName"));
		setPassword(map.get("Password2"));
		util.click(btnLogin);
		util.waitUntilPageLoad();
		if (util.isElementPresent(isLoginSuccess)) {
			log("Login Successfully !!!", Status.PASS);
			driver.navigate().refresh();
		} else {
			log("Failed Login !!!", Status.FAIL);
		}
		Assert.assertTrue((util.isElementPresent(isLoginSuccess)), "Failed Login !!!");
		VERSION = util.getAttributeValue(version, "title");
		log("Application "+VERSION);
		projectName=map.get(Excel.Project);
	}
	
	public void loginWithSuperAdmin(Map<String, String> map) {
		setUserName(map.get(Excel.UserName));
		setPassword(map.get(Excel.Password));
		util.click(btnLogin);
		util.waitUntilPageLoad();
		if (util.isElementPresent(isLoginSuccess)) {
			log("Login Successfully !!!", Status.PASS);
			driver.navigate().refresh();
		} else {
			log("Failed Login !!!", Status.FAIL);
		}
		Assert.assertTrue((util.isElementPresent(isLoginSuccess)), "Failed Login !!!");
		VERSION = util.getAttributeValue(version, "title");
		log("Application "+VERSION);
		projectName=map.get(Excel.Project);
	}

	
	public static boolean isApplicableVersion(String version) {
	    String[] parts = version.replace("Version No:", "").trim().split("\\.");
	    if (parts.length >= 2) {
	        int major = Integer.parseInt(parts[0]);
	        int minor = Integer.parseInt(parts[1]);
	        return (major > 25 || (major == 25 && minor >= 8));
	    }
	    return false;
	}
	
}

