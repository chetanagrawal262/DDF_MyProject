package pages.ParcelDetails;

import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.util.CommonFunction;
import com.util.TestUtil;

public class Grantor_GranteePage extends BasePage {

	TestUtil util;
	CommonFunction commonFunction;
	public static String COUNTRY;
	public static boolean isCountryPresent;

	public Grantor_GranteePage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		
	}
	

	By navGrantor = By.xpath("//span[text()='Grantor/Grantee' and @class='rpText'] | //span[text()='Original Grantor' and @class='rpText']");
	By btnSave = By.xpath("//input[contains(@id,'_GRANTOR_btnSaveTract')]");
	By txtGrantor = By.xpath("//textarea[contains(@id,'_GRANTOR_Grantor')]");
	By txtAddressLine1 = By.xpath("//input[contains(@id,'_GRANTOR_PROPADD_Address_Line_1') and @type='text']");
	By txtAddressLine2 = By.xpath("//input[contains(@id,'_GRANTOR_PROPADD_Address_Line_2') and @type='text']");
	By txtAddressLine3 = By.xpath("//input[contains(@id,'_GRANTOR_PROPADD_Address_Line_3') and @type='text']");
	By txtCity = By.xpath("//input[contains(@id,'_GRANTOR_PROPADD_City') and @type='text']");
	By drpState = By.xpath("//input[contains(@id,'_GRANTOR_PROPADD_STATE_ID_radYALDropDownList_Input') and @type='text']");
	By txtPostalCode = By.xpath("//input[contains(@id,'_GRANTOR_PROPADD_Zip_Code') and @type='text']");
	By txtPostalCodePlus = By.xpath("//input[contains(@id,'_GRANTOR_PROPADD_Zip_Code_Plus') and @type='text']");
	By txtHomePhone = By.xpath("//input[contains(@id,'_GRANTOR_PROPContact_Home_Phone') and @type='text']");
	By txtCellPhone = By.xpath("//input[contains(@id,'_GRANTOR_PROPContact_Cell_Phone') and @type='text']");
	By txtWorkPhone = By.xpath("//input[contains(@id,'_GRANTOR_PROPContact_Work_Phone') and @type='text']");
	By txtFaxPhone  = By.xpath("//input[contains(@id,'_GRANTOR_PROPContact_FaxNumber') and @type='text']");
	By txtEmail  = By.xpath("//input[contains(@id,'_GRANTOR_PROPContact_Email') and @type='text']"); 
	By txtCounty = By.xpath("//input[contains(@id,'_GRANTOR_PROPADD_County') and @type='text']");
	By txtTownship = By.xpath("//input[contains(@id,'_GRANTOR_PROPADD_Township') and @type='text']");
	
	
	     public void navigateGrantor() {
            util.waitUntilElementDisplay(navGrantor);
			util.click(navGrantor);
	    }
	   
	     public void addGrantor(String value) {
	        if (!commonFunction.checkNA(value))
	            util.inputTextAndPressTab(txtGrantor, value);
	    }

	    public void addAddressLine1(String value) {
	        if (!commonFunction.checkNA(value))
	            util.inputTextAndPressTab(txtAddressLine1, value);
	    }

	    public void addAddressLine2(String value) {
	        if (!commonFunction.checkNA(value))
	            util.inputTextAndPressTab(txtAddressLine2, value);
	    }

	    public void addAddressLine3(String value) {
	        if (!commonFunction.checkNA(value))
	            util.inputTextAndPressTab(txtAddressLine3, value);
	    }

	    public void addCity(String value) {
	        if (!commonFunction.checkNA(value))
	            util.inputTextAndPressTab(txtCity, value);
	    }

	    public void selectState(String value) {
	        if (!commonFunction.checkNA(value))
	            util.inputTextAndPressTab(drpState, value);
	    }

	    public void addPostalCode(String value) {
	        if (!commonFunction.checkNA(value))
	            util.inputTextAndPressTab(txtPostalCode, value);
	    }

	    public void addPostalCodePlus(String value) {
	        if (!commonFunction.checkNA(value))
	            util.inputTextAndPressTab(txtPostalCodePlus, value);
	    }

	    public void addCounty(String value) {
	        if (!commonFunction.checkNA(value))
	            util.inputTextAndPressTab(txtCounty, value);
	    }
	    
	    public void addTownship(String value) {
	        if (!commonFunction.checkNA(value))
	            util.inputTextAndPressTab(txtTownship, value);
	    }
	    
	    public void addFaxPhone(String value) {
	        if (!commonFunction.checkNA(value))
	            util.inputTextAndPressTab(txtFaxPhone, value);
	    }
	    
	    
	    public void addHomePhone(String value) {
	        if (!commonFunction.checkNA(value))
	            util.inputTextAndPressTab(txtHomePhone, value);
	    }

	    public void addCellPhone(String value) {
	        if (!commonFunction.checkNA(value))
	            util.inputTextAndPressTab(txtCellPhone, value);
	    }

	    public void addWorkPhone(String value) {
	        if (!commonFunction.checkNA(value))
	            util.inputTextAndPressTab(txtWorkPhone, value);
	    }

	    public void addEmail(String value) {
	        if (!commonFunction.checkNA(value))
	            util.inputTextAndPressTab(txtEmail, value);
	    }

	    
	    
	    public void Save() {
	    	util.waitUntilElementDisplay(btnSave);
			util.click(btnSave);
			util.dummyWait(2);	
	    }
	    
	     public void AddRecord(Map<String, String> map, String testcaseName) {
	    	
	    	 try {
	    		 navigateGrantor();
	    		 log("Step 1: User can expand the Grantor/Grantee section", Status.PASS);
				} catch (Exception e) {
					log("Step 1: User cannot expand the Grantor/Grantee section", Status.FAIL);
					throw new RuntimeException("Failed in step 1 ");
				}
	    	 
	    	 try {
	    		    addGrantor(map.get("Grantor"));
	    		    log("Step 2: Grantor added successfully", Status.PASS);
	    		} catch (Exception e) {
	    		    log("Step 2: Failed to add Grantor", Status.FAIL);
	    		    throw new RuntimeException("Failed in step 2");
	    		}

	    		try {
	    		    addAddressLine1(map.get("AddressLine1"));
	    		    log("Step 3: Address Line 1 added successfully", Status.PASS);
	    		} catch (Exception e) {
	    		    log("Step 3: Failed to add Address Line 1", Status.FAIL);
	    		    throw new RuntimeException("Failed in step 3");
	    		}

	    		try {
	    		    addAddressLine2(map.get("AddressLine2"));
	    		    log("Step 4: Address Line 2 added successfully", Status.PASS);
	    		} catch (Exception e) {
	    		    log("Step 4: Failed to add Address Line 2", Status.FAIL);
	    		    throw new RuntimeException("Failed in step 4");
	    		}

	    		try {
	    		    addAddressLine3(map.get("AddressLine3"));
	    		    log("Step 5: Address Line 3 added successfully", Status.PASS);
	    		} catch (Exception e) {
	    		    log("Step 5: Failed to add Address Line 3", Status.FAIL);
	    		    throw new RuntimeException("Failed in step 5");
	    		}

	    		try {
	    		    addCity(map.get("City"));
	    		    log("Step 6: City added successfully", Status.PASS);
	    		} catch (Exception e) {
	    		    log("Step 6: Failed to add City", Status.FAIL);
	    		    throw new RuntimeException("Failed in step 6");
	    		}

	    		try {
	    		    selectState(map.get("State"));
	    		    log("Step 7: State selected successfully", Status.PASS);
	    		} catch (Exception e) {
	    		    log("Step 7: Failed to select State", Status.FAIL);
	    		    throw new RuntimeException("Failed in step 7");
	    		}

	    		try {
	    		    addPostalCode(map.get("PostalCode"));
	    		    log("Step 8: Postal Code added successfully", Status.PASS);
	    		} catch (Exception e) {
	    		    log("Step 8: Failed to add Postal Code", Status.FAIL);
	    		    throw new RuntimeException("Failed in step 8");
	    		}

	    		if(util.isElementVisible(txtPostalCodePlus)) {
	    		try {
	    		    addPostalCodePlus(map.get("PostalCodePlus"));
	    		    log("Step 9: Postal Code Plus added successfully", Status.PASS);
	    		} catch (Exception e) {
	    		    log("Step 9: Failed to add Postal Code Plus", Status.FAIL);
	    		    throw new RuntimeException("Failed in step 9");
	    		}
	    		}

	    		try {
	    		    addCounty(map.get("County"));
	    		    log("Step 10: County added successfully", Status.PASS);
	    		} catch (Exception e) {
	    		    log("Step 10: Failed to add County", Status.FAIL);
	    		    throw new RuntimeException("Failed in step 10");
	    		}

	    		try {
	    		    addTownship(map.get("Township"));
	    		    log("Step 11: Township added successfully", Status.PASS);
	    		} catch (Exception e) {
	    		    log("Step 11: Failed to add Township", Status.FAIL);
	    		    throw new RuntimeException("Failed in step 11");
	    		}

	    		try {
	    		    addFaxPhone(map.get("FaxPhone"));
	    		    log("Step 12: Fax Phone added successfully", Status.PASS);
	    		} catch (Exception e) {
	    		    log("Step 12: Failed to add Fax Phone", Status.FAIL);
	    		    throw new RuntimeException("Failed in step 12");
	    		}

	    		try {
	    		    addHomePhone(map.get("HomePhone"));
	    		    log("Step 13: Home Phone added successfully", Status.PASS);
	    		} catch (Exception e) {
	    		    log("Step 13: Failed to add Home Phone", Status.FAIL);
	    		    throw new RuntimeException("Failed in step 13");
	    		}

	    		try {
	    		    addCellPhone(map.get("CellPhone"));
	    		    log("Step 14: Cell Phone added successfully", Status.PASS);
	    		} catch (Exception e) {
	    		    log("Step 14: Failed to add Cell Phone", Status.FAIL);
	    		    throw new RuntimeException("Failed in step 14");
	    		}

	    		try {
	    		    addWorkPhone(map.get("WorkPhone"));
	    		    log("Step 15: Work Phone added successfully", Status.PASS);
	    		} catch (Exception e) {
	    		    log("Step 15: Failed to add Work Phone", Status.FAIL);
	    		    throw new RuntimeException("Failed in step 15");
	    		}

	    		try {
	    		    addEmail(map.get("Email"));
	    		    log("Step 16: Email added successfully", Status.PASS);
	    		} catch (Exception e) {
	    		    log("Step 16: Failed to add Email", Status.FAIL);
	    		    throw new RuntimeException("Failed in step 16");
	    		}
	    		
	    		try {
	    		    Save();
	    		    log("Step 17: User can click on save button", Status.PASS);
	    		} catch (Exception e) {
	    		    log("Step 17: User cannot click on save button", Status.FAIL);
	    		    throw new RuntimeException("Failed in step 17");
	    		}
	    	
	  }
}
