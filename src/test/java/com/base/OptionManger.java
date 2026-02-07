package com.base;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class OptionManger {
	public static ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
		 options.setPlatformName("Windows 10"); 
//        options.setHeadless(true);
//        options.addArguments("--headless");
//        options.addArguments("--start-maximized");
		 options.addArguments("--remote-allow-origins=*"); 
        options.setAcceptInsecureCerts(true);
//        options.addArguments("--ignore-certificate-errors");
//        options.addArguments("--disable-popup-blocking");
//        options.addArguments("--window-size=1820,980");
		 options.addArguments("--no-sandbox"); 
//		options.addArguments("--disable-notifications");
//		options.addArguments("--disable-infobars");
//		options.setExperimentalOption("useAutomationExtension", false);
//		options.setExperimentalOption("excludeSwitches",Collections.singletonList("enable-automation"));
		 options.setExperimentalOption("w3c", true); 
//		Map<String, Object> prefs = new HashMap<String, Object>();
//		prefs.put("credentials_enable_service", false);
//		prefs.put("profile.password_manager_enabled", false);
//		options.setExperimentalOption("prefs", prefs);
//		options.addArguments("--high-dpi-support=1");
//		options.addArguments("--force-device-scale-factor=0.65");
        return options;
        /*ChromeDriverService service = new ChromeDriverService.Builder()
                .usingAnyFreePort()
                .build();
        ChromeDriver driver = new ChromeDriver(service, options);*/

    }
	
	public static ChromeOptions getHeadlessChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--window-size=1820,980");
		options.addArguments("--no-sandbox");
		options.addArguments("--headless");
        return options;
        /*ChromeDriverService service = new ChromeDriverService.Builder()
                .usingAnyFreePort()
                .build();
        ChromeDriver driver = new ChromeDriver(service, options);*/
    }
 
    public static EdgeOptions getEdgeOptions () {
        EdgeOptions options = new EdgeOptions();
        //options.setAcceptInsecureCerts(true);
        options.setPlatformName("Windows 10");
        options.addArguments("--remote-allow-origins=*");
        options.setAcceptInsecureCerts(true);
        options.addArguments("--no-sandbox");
        options.setExperimentalOption("w3c", true);
        
     // Disable install app prompts and related banners
     options.addArguments("--disable-features=AppBannerPrompt");
     options.addArguments("--disable-notifications");
     options.addArguments("--disable-infobars");
     options.addArguments("--disable-popup-blocking");
        return options;
        
    }
    
    //Get Firefox Options
    public static FirefoxOptions getFirefoxOptions () {
        FirefoxOptions options = new FirefoxOptions();
        FirefoxProfile profile = new FirefoxProfile();
        options.setAcceptInsecureCerts(true);
        //Accept Untrusted Certificates
        profile.setAcceptUntrustedCertificates(true);
        profile.setAssumeUntrustedCertificateIssuer(false);
        //Use No Proxy Settings
        profile.setPreference("network.proxy.type", 0);
//        Set Firefox profile to capabilities
////        options.addPreference("network.cookie.cookieBehavior", 0); // 0 = Accept all cookies
////        options.addPreference("privacy.clearOnShutdown.cookies", false);
////        options.addPreference("network.cookie.lifetimePolicy", 0);
//      //options.setAcceptInsecureCerts(true);
//        options.setPlatformName("Windows 10");
//        options.setAcceptInsecureCerts(true);
        
        
//        FirefoxProfile profile = new FirefoxProfile();
//        profile.setPreference("browser.privatebrowsing.autostart", true);  // Disable Private Browsing
//        profile.setPreference("network.cookie.cookieBehavior", 0);  // Allow cookies
//        profile.setPreference("security.csp.enable", true); // disable content security policy
//        profile.setPreference("permissions.default.script", 1); // allow scripts
//        FirefoxOptions options = new FirefoxOptions();
//        options.setProfile(profile);
//        
//        options.setAcceptInsecureCerts(true);
        return options;
        
    }

}
