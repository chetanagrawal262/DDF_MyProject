package pages.ManagePreferences;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

public class UserInformationManagementPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;

	public UserInformationManagementPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	
	By txtAddressLine1 = By.xpath("//input[contains(@id,'UserInfoAddressContact_Address_Line_1') and @type='text']");
    By txtAddressLine2 = By.xpath("//input[contains(@id,'UserInfoAddressContact_Address_Line_2') and @type='text']");
    By txtCity = By.xpath("//input[contains(@id,'UserInfoAddressContact_City') and @type='text']");
    By drpState = By.xpath("//input[contains(@id,'UserInfoAddressContact_STATE_ID_Input') and @type='text']");
    By txtZipCode = By.xpath("(//input[contains(@id,'UserInfoAddressContact_Zip_Code') and @type='text'])[1]");
    By txtPOBox = By.xpath("(//input[contains(@id,'UserInfoAddressContact_PO_Box') and @type='text'])[1]");
    By txtZipCode2 = By.xpath("(//input[contains(@id,'UserInfoAddressContact_Zip_Code2') and @type='text'])[1]");
    By txtAddressLine3 = By.xpath("//input[contains(@id,'UserInfoAddressContact_Address_Line_3') and @type='text']");
    By txtWorkPhone = By.xpath("//input[contains(@id,'Work_Phone') and @type='text']");
    By txtCellPhone = By.xpath("//input[contains(@id,'Cell_Phone') and @type='text']");
    By txtHomePhone = By.xpath("//input[contains(@id,'Home_Phone') and @type='text']");
    By btnSave = By.xpath("//input[contains(@id,'SaveUserAddressContact') and @type='image']");
    
   
    public void AddAddressLine1(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtAddressLine1,value);
    }
    
    public void AddAddressLine2(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtAddressLine2,value);
    }
    
    public void AddCity(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtCity,value);
    }

    public void SelectState(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpState,value);
    }

    public void AddZipCode(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtZipCode,value);
    }
    
    public void AddPOBox(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtPOBox,value);
    }
    
    public void AddZipCode2(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtZipCode2,value);
    }
    
    public void AddAddressLine3(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtAddressLine3,value);
    }
    
    public void AddWorkPhone(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtWorkPhone,value);
    }
    
    public void AddCellPhone(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtCellPhone,value);
    }
    
    public void AddHomePhone(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtHomePhone,value);
    }
    
    public void ClickOnSaveButton() {
    	util.waitUntilElementDisplay(btnSave);
    	util.click(btnSave);
    }
    
	public void  UserInformationManagement(Map<String, String> map,String testcaseName) throws InterruptedException  {

		 if (testcaseName.contains("ROW") || testcaseName.contains("ALT") || testcaseName.contains("ORSTED")||testcaseName.contains("ORION") || testcaseName.contains("ATWELL") || testcaseName.contains("TRA") || testcaseName.contains("DOM")) {
				log(" User Information Management not applicable for ROW and ALT", Status.SKIP);
			}
			else {
		
		try {
			AddAddressLine1(map.get(Excel.AddressLine1));
				log("STEP 1: User can enter the value in AddressLine1 field   ", Status.PASS);
			} catch (Exception e) {
				log("STEP 1: User cannot enter the value in AddressLine1 field  ", Status.FAIL);
				throw new RuntimeException("Failed in step 1");
			}
		
		try {
			AddAddressLine2(map.get(Excel.AddressLine2));
				log("STEP 2:  User can enter the value in AddressLine2 field  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 2:  User cannot enter the value in AddressLine2 field ", Status.FAIL);
				throw new RuntimeException("Failed in step 2");
			}
		
		try {
			AddCity(map.get(Excel.City));
				log("STEP 3:  User can enter the value in City field  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 3: User cannot enter the value in City field ", Status.FAIL);
				throw new RuntimeException("Failed in step 3");
			}
		
		try {
			SelectState(map.get(Excel.State));
				log("STEP 4:  User can enter the value in State field  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 4: User cannot enter the value in State field ", Status.FAIL);
				throw new RuntimeException("Failed in step 4");
			}
		
		try {
			AddZipCode(map.get(Excel.ZipCode));
				log("STEP 5: User can enter the value in ZipCode field  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 5: User cannot enter the value in ZipCode field  ", Status.FAIL);
				throw new RuntimeException("Failed in step 5");
			}
		
		try {
			AddPOBox(map.get(Excel.PObox));
				log("STEP 6: User can enter the value in PObox field  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 6: User cannot enter the value in PObox field", Status.FAIL);
				throw new RuntimeException("Failed in step 6");
			}
		
		try {
			AddZipCode2(map.get(Excel.ZipCodePlus));
				log("STEP 7: User can enter the value in ZipCodePlus field ", Status.PASS);
			} catch (Exception e) {
				log("STEP 7: User cannot enter the value in ZipCodePlus field ", Status.FAIL);
				throw new RuntimeException("Failed in step 7");
			}
		
		try {
			AddAddressLine3(map.get(Excel.AddressLine3));
				log("STEP 8: User can enter the value in AddressLine3 field  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 8: User cannot enter the value in AddressLine3 field ", Status.FAIL);
				throw new RuntimeException("Failed in step 8");
			}
		
		try {
			AddWorkPhone(map.get(Excel.WorkPhone));
				log("STEP 9: User can enter the value in WorkPhone field  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 9: User cannot enter the value in WorkPhone field ", Status.FAIL);
				throw new RuntimeException("Failed in step 9");
			}
		
		try {
			AddCellPhone(map.get(Excel.CellPhone));
				log("STEP 10: User can enter the value in CellPhone field   ", Status.PASS);
			} catch (Exception e) {
				log("STEP 10: User cannot enter the value in CellPhone field ", Status.FAIL);
				throw new RuntimeException("Failed in step 10");
			}
		
		try {
			AddHomePhone(map.get(Excel.HomePhone));
				log("STEP 11: User can enter the value in HomePhone field  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 11: User cannot enter the value in HomePhone field ", Status.FAIL);
				throw new RuntimeException("Failed in step 11");
			}
		
		try {
			ClickOnSaveButton();
				log("STEP 12:  user is able to click on Save button   ", Status.PASS);
			} catch (Exception e) {
				log("STEP 12: user not able to click on save button  ", Status.FAIL);
				throw new RuntimeException("Failed in step 12");
			}
		
		}
	}
}
