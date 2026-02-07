package pages.PropertyManagement;

import org.openqa.selenium.WebDriver;

import com.base.BasePage;
import com.util.CommonFunction;
import com.util.TestUtil;

public class PropertyManagementFormsPage extends BasePage {
	
	TestUtil util;
	CommonFunction commonFunction;
	

	public PropertyManagementFormsPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}	

}
