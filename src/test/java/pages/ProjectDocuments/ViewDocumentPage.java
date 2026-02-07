package pages.ProjectDocuments;

import java.util.Map;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

public class ViewDocumentPage extends BasePage{
	TestUtil util;
	CommonFunction commonFunction;
	public static String AGREEMENT_NUMBER;

	public ViewDocumentPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		
	}
	
	public void clickOnViewDocument(String value) {
		By btnViewDocument = By.xpath("//*[text()='" + value + "']/..//a[text()='View Document']");
		util.dummyWait(3);
		util.click(btnViewDocument);
	}
	
	public void clickOnViewDocumentDOT(String value) {
		By btnViewDocument = By.xpath("//*[text()='" + value + "']/..//a");
		util.click(btnViewDocument);
	}
	
	public void ViewDocument(Map<String,String >map ,String testcaseName) {
  
		driver.navigate().refresh();
		try {
		if(testcaseName.contains("ALT") || testcaseName.contains("ORION") || testcaseName.contains("ATWELL") || testcaseName.contains("ORSTED")) {
			clickOnViewDocument(map.get(Excel.DocumentName));
		}
		else {
			clickOnViewDocumentDOT(map.get(Excel.DocumentName));
		}
		util.dummyWait(1);		
		String parentWindow = driver.getWindowHandle();
		Set<String> allWindow = driver.getWindowHandles();
		if(allWindow.size()>1) {
			for(String currentWindow : allWindow) {
				if(!currentWindow.equals(parentWindow)) {
					driver.switchTo().window(currentWindow);
					driver.close();
				}
			}
			driver.switchTo().window(parentWindow);
		}
		log("STEP 1:  User can Click on View Document", Status.PASS);
	} catch (Exception e) {
		log("STEP 1:  User can not Click on View Document", Status.FAIL);
		throw new RuntimeException("STEP 1:  User can not Click on View Document");
	}
	    
	}
	
}
