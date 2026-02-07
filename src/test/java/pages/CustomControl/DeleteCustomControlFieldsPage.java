package pages.CustomControl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.ExcelUtils;
import com.util.TestUtil;

import extentReports.ExtentTestManager;

public class DeleteCustomControlFieldsPage extends BasePage {
	
	TestUtil util;
	CommonFunction commonFunction;
	int count=0;

	public DeleteCustomControlFieldsPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	
	By navParcel = By.xpath("//span[text()='Parcel'] | //span[text()='Tract']");
	By navParcelInfo = By.xpath("//span[text()='Parcel Info'] | //span[text()='Tract Info']");
	By navParcelInformation = By.xpath("//span[contains(text(),'Parcel Information')] | //span[contains(text(),'Tract Information')] | //span[contains(text(),'Record Information')]");
	By btnDesignMode = By.xpath("//input[contains(@id,'btnDesignModeOff') and @type='image']");
	By IconManageFiled = By.xpath("(//span[contains(@id,'ManageAddFieldsID')])[1]");
	
	
//    By CustomControlRecordOnPage = By.xpath("//*[contains(text(),'FieldName')]/..//*[@alt='Delete']");
//	
//    List<WebElement> templates = driver.findElements(CustomControlRecordOnPage);
//	ExtentTestManager.info("Total Number of Templates Available: " + templates.size());

	 By btnOk = By.xpath("//span[text()='OK']");
	    public void ClickOnOK() {
	    	util.waitUntilElementDisplay(btnOk);
	    	util.click(btnOk);
	    }
	
	
	public void NavigateToParcelInformation() {
    	util.waitUntilElementDisplay(navParcel);
    	util.click(navParcel);
    	util.waitUntilElementDisplay(navParcelInfo);
    	util.click(navParcelInfo);
    	util.waitUntilElementDisplay(navParcelInformation);
    	util.click(navParcelInformation);
    }
	
	public void TurnOnDesignCode() {
    	util.waitUntilElementDisplay(btnDesignMode);
    	util.click(btnDesignMode);
    	util.dummyWait(2);
    }
	public void DeleteCustomControlFields(Map<String, String> map, String testcaseName) {
		try {
    		NavigateToParcelInformation();
    		commonFunction.projectSelection();
			log("STEP 1:  user can navigate to parcel information page", Status.PASS);
		} catch (Exception e) {
			log("STEP 1:  user cannot navigate to parcel information page ", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}
		try {
    		TurnOnDesignCode();
			log("STEP 2: user can turn on design mode", Status.PASS);
		} catch (Exception e) {
			log("STEP 2:  user cannot turn on design mode ", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}
    	
    	try {
			 By customIcon = By.xpath("//span[@title='Manage custom field(s)' and contains(@onclick,'TRACTTYPEDATA')]| //a[@title='Manage custom field(s)' and contains(@href,'TRACTINFORMATION')]");
			util.click(customIcon);
			log("STEP 3:  user can able to click on the custom control icon", Status.PASS);
		} catch (Exception e) {
			log("STEP 3:  user cannot click on the custom control icon  ", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}
	
		Set<String> windowId = driver.getWindowHandles(); 
		Iterator<String> itererator = windowId.iterator();
		String mainWinID = itererator.next();
		String newAdwinID = itererator.next();
		driver.switchTo().window(newAdwinID);
		util.dummyWait(1);
		
		for (int i = 1; i < ExcelUtils.totalRows - 1; i++) {
	    String rowName = testcaseName+i;
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.CUSTOM_CONTROL_TEST_DATA),Excel.DeleteCustomControl, rowName);
		
		
		By delete = By.xpath("//*[text()='"+map.get(Excel.FieldName)+"']/..//*[@alt='Delete']");
	    
		if(util.isElementVisible(delete)) {
		try {
		util.click(delete);
		util.waitFor(500);
		util.click(btnOk);
		util.waitFor(500);
		ExtentTestManager.info("Deleted Field is: " +map.get(Excel.FieldName));
		log("STEP 4:  user can click on delete icon", Status.PASS);
	} catch (Exception e) {
		log("STEP 4:  user cannot click on delete icon ", Status.FAIL);
		throw new RuntimeException("Failed in step 4");
	}
	
	
			}
	
		
		
	}	
			
	}
		
	
}
	
	


