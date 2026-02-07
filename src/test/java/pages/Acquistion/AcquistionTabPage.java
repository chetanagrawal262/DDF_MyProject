package pages.Acquistion;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

public class AcquistionTabPage extends BasePage{
	
	TestUtil util;
	CommonFunction commonFunction;
	public static String AGREEMENT_NUMBER;

	public AcquistionTabPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		
	}

	By navParcel = By.xpath("//span[text()='Parcel'] | //span[text()='Tract']");
	By navParcelInfo = By.xpath("//span[text()='Parcel Info'] | //span[text()='Tract Info']");
	By navAcquistion = By.xpath("(//span[text()='Acquisition'])[1] | (//span[text()='ROW Components'])[1]");
	By drpAcquistionStatus = By.xpath("//input[contains(@id,'_ACQASSING_ACQUISITION_STATUS_ID_radYALDropDownList_Input') and @type='text'] ");
	By btnSave = By.xpath("//input[contains(@id,'_ACQASSING_TractType_btnSaveTract') and @type='image']");
	By changesSavedSuccessfully = By.xpath("//span[text()='Changes Saved Successfully!']");
	
	By firstParcel = By.xpath("//*[contains(@id,'TractList_RadGridTracts_ctl00__0')]");
	 
	public void navigateToAcquistion() {
		util.waitUntilElementDisplay(navParcel);
		util.click(navParcel);
		util.waitUntilElementDisplay(navParcelInfo);
		util.click(navParcelInfo);
		util.waitUntilElementDisplay(navAcquistion);
		util.click(navAcquistion);
		
	}
	
	public void SelectAcquistionStatus(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpAcquistionStatus, value);
	}
	
	public void ClickonSave() {
		util.waitUntilElementDisplay(btnSave);
		util.click(btnSave);
		util.dummyWait(5);
	}
	
	public void AcquistionTab(Map<String, String> map, String testcaseName) {
    	try {
    		navigateToAcquistion();
    		commonFunction.projectSelection();
    		util.dummyWait(3);    		
    		util.waitUntilElementDisplay(firstParcel);
    		util.click(firstParcel);
    		util.dummyWait(3);
			log("STEP 1:  User can navigate to the Acquisition tab ", Status.PASS);
		} catch (Exception e) {
			log("STEP 1:  User cannot see the option in Menu", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}
    	util.dummyWait(10);
    	 try {
    		 SelectAcquistionStatus(map.get(Excel.AcquistionStatus));
    			log("STEP 2:  Added value displays in Acquistion Status field ", Status.PASS);
    		} catch (Exception e) {
    			log("STEP 2: User  cannot select  value  from Acquistion Status DD  ", Status.FAIL);
    			throw new RuntimeException("Failed in step 2");
    		}
    	 util.dummyWait(3);
    	 try {
    		 ClickonSave();
 			log("STEP 3: Message - 'Message - 'Changes saved successfully' in green displays ", Status.PASS);
 		} catch (Exception e) {
 			log("STEP 3: Message - 'Message - 'Changes saved successfully' does not displays ", Status.FAIL);
 			throw new RuntimeException("Failed in step 3");
 		}
    	 
	}
}
