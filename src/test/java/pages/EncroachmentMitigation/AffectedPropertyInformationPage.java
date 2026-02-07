package pages.EncroachmentMitigation;

import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

public class AffectedPropertyInformationPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;
	public String PARTY_TYPE, PARTY_NAME, CO_NAME, LEGAL_LOCATION,COMMENTS;

	public AffectedPropertyInformationPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	
	By panelAffectedPropertyInformation = By.xpath("//span[text()='Affected Property Information']");
	By btnAddNewRecord = By.xpath("//a[contains(@id,'_grdNPContacts_radYALGridControl_ctl00_ctl02_ctl00_lnkAddNewRecord')]");
	By drpType = By.xpath("//input[contains(@id,'_EditFormControl_Party_type_ID_radYALDropDownList_Input') and @type='text']");
	By txtLegalLocation = By.xpath("//input[contains(@id,'_EditFormControl_Legal_Location') and @type='text']");
	By txtLastName = By.xpath("//input[contains(@id,'Last_Name') and @type='text']");
	By txtFirstName = By.xpath("//input[contains(@id,'First_Name') and @type='text']");
	By txtMiddleName = By.xpath("//input[contains(@id,'Middle_Name') and @type='text']");
	By txtTitle = By.xpath("//input[contains(@id,'_Title') and @type='text']");
	By txtSuffix = By.xpath("//input[contains(@id,'_Suffix') and @type='text']");
	By txtCOName = By.xpath("//input[contains(@id,'_CO_Name') and @type='text']");
	By drpMaritalStatus = By.xpath("//input[contains(@id,'_EditFormControl_ENTITY_Marital_Status_ID_radYALDropDownList_Input') and @type='text']");
    By drpGender = By.xpath("//input[contains(@id,'_Gender') and @type='text']");
	By txtTaxSSN = By.xpath("//input[contains(@id,'_EditFormControl_ENTITY_Tax_SSN') and @type='text']");
	By txtEntityName = By.xpath("(//input[contains(@id,'_Corporation_Trust') and @type='text'])[1]");
	By drpEntityType = By.xpath("//input[contains(@id,'_EditFormControl_ENTITY_Entity_Type_ID_radYALDropDownList_Input') and @type='text']");
	By txtAddressLine1 = By.xpath("//input[contains(@id,'_Address_Line_1') and @type='text']");
	By txtAddressLine2 = By.xpath("//input[contains(@id,'_Address_Line_2') and @type='text']");
	By txtHomePhone = By.xpath("(//input[contains(@id,'_Home_Phone') and @type='text'])[1]");
	By txtCellPhone = By.xpath("//input[contains(@id,'_Cell_Phone') and @type='text']");
	By txtWorkPhone = By.xpath("//input[contains(@id,'_Work_Phone') and @type='text']");
	By txtFaxPhone  = By.xpath("//input[contains(@id,'_FAX_NUMBER') and @type='text']");
	By txtCity = By.xpath("//input[contains(@id,'_City') and @type='text']");
	By drpState = By.xpath("//input[contains(@id,'_RadState_Input') and @type='text']");
	By txtZipCode = By.xpath("(//input[contains(@id,'_Zip_Code') and @type='text'])[1]");
	By txtAddressLine3 = By.xpath("(//input[contains(@id,'_Address_Line_3') and @type='text'])[1]");
    By txtEmail = By.xpath("(//input[contains(@id,'_Email') and @type='text'])[1]");
    By txtComments = By.xpath("//textarea[contains(@id,'_EditFormControl_comments')]");
    By btnDelete = By.xpath("(//input[contains(@id,'_TREM_UC_radPanels_i3_i0_grdNPContacts_radYALGridControl_ctl00_ctl04_gbcDeleteAlignment')])[last()]");
	By btnOk = By.xpath("//span[text()='OK']");
	
	By btnInsert = By.xpath("//input[contains(@id,'EditFormControl_btnInsert')]");
    By SuccessMessage = By.xpath("//span[text()='Changes saved successfully!']");
  	By btnEdit = By.xpath("(//input[contains(@id,'_TREM_UC_radPanels_i3_i0_grdNPContacts_radYALGridControl_ctl00_ctl04_EditButton')])[last()]");
  	By btnUpdate = By.xpath("//input[contains(@id,'EditFormControl_btnUpdate')]"); 
    
    
  	public void ExpandAffectedPropertyInformatoin() {
  		util.waitUntilElementDisplay(panelAffectedPropertyInformation);
  		util.click(panelAffectedPropertyInformation);
  	}
  	
  	public void ClickOnAddNewRecord() {
  		util.waitUntilElementDisplay(btnAddNewRecord);
  		util.click(btnAddNewRecord);
  		util.waitUntilLoaderDisappear();
  	}
  	
  	public void ClickOnUpdateButton() {
		util.waitUntilElementDisplay(btnUpdate);
		util.click(btnUpdate);
		util.waitUntilLoaderDisappear();

	}
	
  	public void selectType(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpType, value);
    }
  	
  	public void AddLegalLocation(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtLegalLocation, value);
    }
  	
	public void AddLastName(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtLastName, value);
    }
    
    public void AddFirstName(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtFirstName, value);
    }
    
    public void AddMiddleName(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtMiddleName, value);
    }
    
    public void AddTitle(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtTitle, value);
    }
    
    public void AddSuffix(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtSuffix, value);
    }
    
    public void AddCOName(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtCOName, value);
    }
    
	public void SelectMaritalStatus(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpMaritalStatus, value);
	}
	
	public void SelectGender(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpGender, value);
    }
	
	public void AddTaxSSN(String value) {
    	if (!commonFunction.checkNA(value))
    util.inputTextAndPressTab(txtTaxSSN, value);
	}
	
	public void AddEntityName(String value) {
    	if (!commonFunction.checkNA(value))
    util.inputTextAndPressTab(txtEntityName, value);
	}
	
    public void selectEntityType(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpEntityType, value);
    }
   
     public void AddAddressLine1(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtAddressLine1, value);
    }
    
    public void AddAddressLine2(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtAddressLine2, value);
    }
    
    public void AddCity(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtCity, value);
    }
    
    public void SelectState(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpState, value);
    }
    
    public void AddZipCode(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtZipCode, value);
    }
    
    public void AddAddressLine3(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtAddressLine3, value);
    }
    
    public void AddEmail(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtEmail, value);
    }
    
    public void AddHomePhone(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtHomePhone, value);
    }
    
    public void AddCellPhone(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtCellPhone, value);
    }
    
    public void AddWorkPhone(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtWorkPhone, value);
    }
    
   public void AddFaxPhone(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtFaxPhone, value);
    }
    
   public void AddComments(String value) {
   	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtComments, value);
   }
   
    public void ClickOnInsertButton() {
		util.waitUntilElementDisplay(btnInsert);
		util.click(btnInsert);
		util.waitUntilLoaderDisappear();
	}
	
	public void ClickOnEditButton() {
		util.waitUntilElementDisplay(btnEdit);
		util.click(btnEdit);
		util.waitUntilLoaderDisappear();
	}
	
	public void ClickOnDeleteButton() {
		util.waitUntilElementDisplay(btnDelete);
		util.click(btnDelete);
		util.waitFor(200);
	}
	
	 public void ClickonOk()  {
		   util.waitUntilElementDisplay(btnOk);
	  		util.click(btnOk);
	  		util.waitUntilLoaderDisappear();
	    }
	 
		public void addAffectedPropertyInformation(Map<String, String> map, String testcaseName) {
			try {
				ExpandAffectedPropertyInformatoin();
				ClickOnAddNewRecord();
				log("STEP 1: User can click on Add New Record Button", Status.PASS);
			} catch (Exception e) {
				log("STEP 1: User cannot click on Add New Record Button", Status.FAIL);
				throw new RuntimeException("Failed in step 1");
			}

			try {
				selectType(map.get(Excel.Type));
				PARTY_TYPE = map.get(Excel.Type);
				log("STEP 2: User can select Type", Status.PASS);
			} catch (Exception e) {
				log("STEP 2: User cannot select Type", Status.FAIL);
				throw new RuntimeException("Failed in step 2");
			}

			try {
				AddLegalLocation(map.get(Excel.LegalLocation));
				LEGAL_LOCATION = map.get(Excel.LegalLocation);
				log("STEP 3: User can enter Legal Location", Status.PASS);
			} catch (Exception e) {
				log("STEP 3: User cannot enter Legal Location", Status.FAIL);
				throw new RuntimeException("Failed in step 3");
			}

			try {
				AddLastName(map.get(Excel.LastName));
				log("STEP 4: User can enter Last Name", Status.PASS);
			} catch (Exception e) {
				log("STEP 4: User cannot enter Last Name", Status.FAIL);
				throw new RuntimeException("Failed in step 4: AddLastName");
			}

			try {
				AddFirstName(map.get(Excel.FirstName));
				log("STEP 5: User can enter First Name", Status.PASS);
			} catch (Exception e) {
				log("STEP 5: User cannot enter First Name", Status.FAIL);
				throw new RuntimeException("Failed in step 5: AddFirstName");
			}

			try {
				AddMiddleName(map.get(Excel.MiddleName));
				log("STEP 6: User can enter Middle Name", Status.PASS);
			} catch (Exception e) {
				log("STEP 6: User cannot enter Middle Name", Status.FAIL);
				throw new RuntimeException("Failed in step 6: AddMiddleName");
			}

			try {
				AddTitle(map.get(Excel.Title));
				log("STEP 7: User can enter Title", Status.PASS);
			} catch (Exception e) {
				log("STEP 7: User cannot enter Title", Status.FAIL);
				throw new RuntimeException("Failed in step 7: AddTitle");
			}

			try {
				AddSuffix(map.get(Excel.Suffix));
				log("STEP 8: User can enter Suffix", Status.PASS);
			} catch (Exception e) {
				log("STEP 8: User cannot enter Suffix", Status.FAIL);
				throw new RuntimeException("Failed in step 8: AddSuffix");
			}

			try {
				AddCOName(map.get(Excel.COName));
				CO_NAME = map.get(Excel.COName);
				log("STEP 9: User can enter C/O Name", Status.PASS);
			} catch (Exception e) {
				log("STEP 9: User cannot enter C/O Name", Status.FAIL);
				throw new RuntimeException("Failed in step 9: AddCOName");
			}

			try {
				SelectMaritalStatus(map.get(Excel.MaritalStatus));
				log("STEP 10: User can select Marital Status", Status.PASS);
			} catch (Exception e) {
				log("STEP 10: User cannot select Marital Status", Status.FAIL);
				throw new RuntimeException("Failed in step 10: SelectMaritalStatus");
			}

			try {
				SelectGender(map.get(Excel.Gender));
				log("STEP 11: User can select Gender", Status.PASS);
			} catch (Exception e) {
				log("STEP 11: User cannot select Gender", Status.FAIL);
				throw new RuntimeException("Failed in step 11: SelectGender");
			}

			try {
				AddTaxSSN(map.get("TAX_SSN"));
				log("STEP 12: User can enter Tax SSN", Status.PASS);
			} catch (Exception e) {
				log("STEP 12: User cannot enter Tax SSN", Status.FAIL);
				throw new RuntimeException("Failed in step 12: AddTaxSSN");
			}

			try {
				AddEntityName(map.get(Excel.EntityName));
				PARTY_NAME = map.get(Excel.EntityName);
				log("STEP 13: User can enter Entity Name", Status.PASS);
			} catch (Exception e) {
				log("STEP 13: User cannot enter Entity Name", Status.FAIL);
				throw new RuntimeException("Failed in step 13: AddEntityName");
			}

			try {
				selectEntityType(map.get(Excel.EntityType));
				log("STEP 14: User can select Entity Type", Status.PASS);
			} catch (Exception e) {
				log("STEP 14: User cannot select Entity Type", Status.FAIL);
				throw new RuntimeException("Failed in step 14: selectEntityType");
			}

			try {
				AddAddressLine1(map.get(Excel.AddressLine1));
				log("STEP 15: User can enter Address Line 1", Status.PASS);
			} catch (Exception e) {
				log("STEP 15: User cannot enter Address Line 1", Status.FAIL);
				throw new RuntimeException("Failed in step 15: AddAddressLine1");
			}

			try {
				AddAddressLine2(map.get(Excel.AddressLine2));
				log("STEP 16: User can enter Address Line 2", Status.PASS);
			} catch (Exception e) {
				log("STEP 16: User cannot enter Address Line 2", Status.FAIL);
				throw new RuntimeException("Failed in step 16: AddAddressLine2");
			}

			try {
				AddCity(map.get(Excel.City));
				log("STEP 17: User can enter City", Status.PASS);
			} catch (Exception e) {
				log("STEP 17: User cannot enter City", Status.FAIL);
				throw new RuntimeException("Failed in step 17: AddCity");
			}

			try {
				SelectState(map.get(Excel.State));
				log("STEP 18: User can select State", Status.PASS);
			} catch (Exception e) {
				log("STEP 18: User cannot select State", Status.FAIL);
				throw new RuntimeException("Failed in step 18: SelectState");
			}

			try {
				AddZipCode(map.get(Excel.ZipCode));
				log("STEP 19: User can enter Zip Code", Status.PASS);
			} catch (Exception e) {
				log("STEP 19: User cannot enter Zip Code", Status.FAIL);
				throw new RuntimeException("Failed in step 19: AddZipCode");
			}

			try {
				AddAddressLine3(map.get(Excel.AddressLine3));
				log("STEP 20: User can enter Address Line 3", Status.PASS);
			} catch (Exception e) {
				log("STEP 20: User cannot enter Address Line 3", Status.FAIL);
				throw new RuntimeException("Failed in step 20: AddAddressLine3");
			}

			try {
				AddEmail(map.get(Excel.Email));
				log("STEP 21: User can enter Email", Status.PASS);
			} catch (Exception e) {
				log("STEP 21: User cannot enter Email", Status.FAIL);
				throw new RuntimeException("Failed in step 21: AddEmail");
			}

			try {
				AddHomePhone(map.get(Excel.HomePhone));
				log("STEP 22: User can enter Home Phone", Status.PASS);
			} catch (Exception e) {
				log("STEP 22: User cannot enter Home Phone", Status.FAIL);
				throw new RuntimeException("Failed in step 22: AddHomePhone");
			}

			try {
				AddCellPhone(map.get(Excel.CellPhone));
				log("STEP 23: User can enter Cell Phone", Status.PASS);
			} catch (Exception e) {
				log("STEP 23: User cannot enter Cell Phone", Status.FAIL);
				throw new RuntimeException("Failed in step 23: AddCellPhone");
			}

			try {
				AddWorkPhone(map.get(Excel.WorkPhone));
				log("STEP 24: User can enter Work Phone", Status.PASS);
			} catch (Exception e) {
				log("STEP 24: User cannot enter Work Phone", Status.FAIL);
				throw new RuntimeException("Failed in step 24: AddWorkPhone");
			}

			try {
				AddFaxPhone(map.get(Excel.FaxPhone));
				log("STEP 25: User can enter Fax Phone", Status.PASS);
			} catch (Exception e) {
				log("STEP 25: User cannot enter Fax Phone", Status.FAIL);
				throw new RuntimeException("Failed in step 25: AddFaxPhone");
			}

			try {
				AddComments(map.get(Excel.Comments));
				COMMENTS = map.get(Excel.Comments);
				log("STEP 26: User can enter Comments", Status.PASS);
			} catch (Exception e) {
				log("STEP 26: User cannot enter Comments", Status.FAIL);
				throw new RuntimeException("Failed in step 26: AddComments");
			}

			try {
				ClickOnInsertButton();
				log("STEP 27: User can click on Insert button", Status.PASS);
			} catch (Exception e) {
				log("STEP 27: User cannot click on Insert button", Status.FAIL);
				throw new RuntimeException("Failed in step 27: ClickOnInsertButton");
			}
			
			try {
				Assert.assertTrue(util.isElementVisible(SuccessMessage));
				log("STEP 28: User can see success message", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 28: User cannot see success message", Status.FAIL);
			}
			
			try {
				By entityName = By.xpath("//tr[contains(@id,'TREM_UC_radPanels_i3_i0_grdNPContacts_radYALGridControl')]/..//td[text()='"+PARTY_NAME+"']");
				Assert.assertTrue(util.isElementVisible(entityName));
				log("STEP 29: User can see added Entity Name in the grid veiw", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 29: User cannot see added Entity Name in the grid veiw", Status.FAIL);
			}
			
			try {
				By coName = By.xpath("//tr[contains(@id,'TREM_UC_radPanels_i3_i0_grdNPContacts_radYALGridControl')]/..//*[text()='C/O: "+CO_NAME+"']");
				Assert.assertTrue(util.isElementVisible(coName));
				log("STEP 30: User can see added CO Name in the grid veiw", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 30: User cannot see added CO Name in the grid veiw", Status.FAIL);
			}
			
			try {
				By partyType = By.xpath("//tr[contains(@id,'TREM_UC_radPanels_i3_i0_grdNPContacts_radYALGridControl')]/..//td[text()='"+PARTY_TYPE+"']");
				Assert.assertTrue(util.isElementVisible(partyType));
				log("STEP 31: User can see added Party Type in the grid veiw", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 31: User cannot see added Party Type in the grid veiw", Status.FAIL);
			}
			
			try {
				By legalLocation = By.xpath("//tr[contains(@id,'TREM_UC_radPanels_i3_i0_grdNPContacts_radYALGridControl')]/..//td[text()='"+LEGAL_LOCATION+"']");
				Assert.assertTrue(util.isElementVisible(legalLocation));
				log("STEP 32: User can see added Legal Location in the grid veiw", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 32: User cannot see added Legal Location in the grid veiw", Status.FAIL);
			}
			
			try {
				By comments = By.xpath("//tr[contains(@id,'TREM_UC_radPanels_i3_i0_grdNPContacts_radYALGridControl')]/..//td[text()='"+COMMENTS+"']");
				Assert.assertTrue(util.isElementVisible(comments));
				log("STEP 33: User can see added Comments in the grid veiw", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 33: User cannot see added Comments in the grid veiw", Status.FAIL);
			}
	        
	 }
	
		
		public void editAffectedPropertyInformation(Map<String, String> map, String testcaseName) {
			try {
				ClickOnEditButton();
				log("STEP 1: User can click on Edit Icon", Status.PASS);
			} catch (Exception e) {
				log("STEP 1: User cannot click on Edit Icon", Status.FAIL);
				throw new RuntimeException("Failed in step 1");
			}

			try {
				selectType(map.get(Excel.Type));
				PARTY_TYPE = map.get(Excel.Type);
				log("STEP 2: User can select Type", Status.PASS);
			} catch (Exception e) {
				log("STEP 2: User cannot select Type", Status.FAIL);
				throw new RuntimeException("Failed in step 2");
			}

			try {
				AddLegalLocation(map.get(Excel.LegalLocation));
				LEGAL_LOCATION = map.get(Excel.LegalLocation);
				log("STEP 3: User can enter Legal Location", Status.PASS);
			} catch (Exception e) {
				log("STEP 3: User cannot enter Legal Location", Status.FAIL);
				throw new RuntimeException("Failed in step 3");
			}

			try {
				AddLastName(map.get(Excel.LastName));
				log("STEP 4: User can enter Last Name", Status.PASS);
			} catch (Exception e) {
				log("STEP 4: User cannot enter Last Name", Status.FAIL);
				throw new RuntimeException("Failed in step 4: AddLastName");
			}

			try {
				AddFirstName(map.get(Excel.FirstName));
				log("STEP 5: User can enter First Name", Status.PASS);
			} catch (Exception e) {
				log("STEP 5: User cannot enter First Name", Status.FAIL);
				throw new RuntimeException("Failed in step 5: AddFirstName");
			}

			try {
				AddMiddleName(map.get(Excel.MiddleName));
				log("STEP 6: User can enter Middle Name", Status.PASS);
			} catch (Exception e) {
				log("STEP 6: User cannot enter Middle Name", Status.FAIL);
				throw new RuntimeException("Failed in step 6: AddMiddleName");
			}

			try {
				AddTitle(map.get(Excel.Title));
				log("STEP 7: User can enter Title", Status.PASS);
			} catch (Exception e) {
				log("STEP 7: User cannot enter Title", Status.FAIL);
				throw new RuntimeException("Failed in step 7: AddTitle");
			}

			try {
				AddSuffix(map.get(Excel.Suffix));
				log("STEP 8: User can enter Suffix", Status.PASS);
			} catch (Exception e) {
				log("STEP 8: User cannot enter Suffix", Status.FAIL);
				throw new RuntimeException("Failed in step 8: AddSuffix");
			}

			try {
				AddCOName(map.get(Excel.COName));
				CO_NAME = map.get(Excel.COName);
				log("STEP 9: User can enter C/O Name", Status.PASS);
			} catch (Exception e) {
				log("STEP 9: User cannot enter C/O Name", Status.FAIL);
				throw new RuntimeException("Failed in step 9: AddCOName");
			}

			try {
				SelectMaritalStatus(map.get(Excel.MaritalStatus));
				log("STEP 10: User can select Marital Status", Status.PASS);
			} catch (Exception e) {
				log("STEP 10: User cannot select Marital Status", Status.FAIL);
				throw new RuntimeException("Failed in step 10: SelectMaritalStatus");
			}

			try {
				SelectGender(map.get(Excel.Gender));
				log("STEP 11: User can select Gender", Status.PASS);
			} catch (Exception e) {
				log("STEP 11: User cannot select Gender", Status.FAIL);
				throw new RuntimeException("Failed in step 11: SelectGender");
			}

			try {
				AddTaxSSN(map.get("TAX_SSN"));
				log("STEP 12: User can enter Tax SSN", Status.PASS);
			} catch (Exception e) {
				log("STEP 12: User cannot enter Tax SSN", Status.FAIL);
				throw new RuntimeException("Failed in step 12: AddTaxSSN");
			}

			try {
				AddEntityName(map.get(Excel.EntityName));
				PARTY_NAME = map.get(Excel.EntityName);
				log("STEP 13: User can enter Entity Name", Status.PASS);
			} catch (Exception e) {
				log("STEP 13: User cannot enter Entity Name", Status.FAIL);
				throw new RuntimeException("Failed in step 13: AddEntityName");
			}

			try {
				selectEntityType(map.get(Excel.EntityType));
				log("STEP 14: User can select Entity Type", Status.PASS);
			} catch (Exception e) {
				log("STEP 14: User cannot select Entity Type", Status.FAIL);
				throw new RuntimeException("Failed in step 14: selectEntityType");
			}

			try {
				AddAddressLine1(map.get(Excel.AddressLine1));
				log("STEP 15: User can enter Address Line 1", Status.PASS);
			} catch (Exception e) {
				log("STEP 15: User cannot enter Address Line 1", Status.FAIL);
				throw new RuntimeException("Failed in step 15: AddAddressLine1");
			}

			try {
				AddAddressLine2(map.get(Excel.AddressLine2));
				log("STEP 16: User can enter Address Line 2", Status.PASS);
			} catch (Exception e) {
				log("STEP 16: User cannot enter Address Line 2", Status.FAIL);
				throw new RuntimeException("Failed in step 16: AddAddressLine2");
			}

			try {
				AddCity(map.get(Excel.City));
				log("STEP 17: User can enter City", Status.PASS);
			} catch (Exception e) {
				log("STEP 17: User cannot enter City", Status.FAIL);
				throw new RuntimeException("Failed in step 17: AddCity");
			}

			try {
				SelectState(map.get(Excel.State));
				log("STEP 18: User can select State", Status.PASS);
			} catch (Exception e) {
				log("STEP 18: User cannot select State", Status.FAIL);
				throw new RuntimeException("Failed in step 18: SelectState");
			}

			try {
				AddZipCode(map.get(Excel.ZipCode));
				log("STEP 19: User can enter Zip Code", Status.PASS);
			} catch (Exception e) {
				log("STEP 19: User cannot enter Zip Code", Status.FAIL);
				throw new RuntimeException("Failed in step 19: AddZipCode");
			}

			try {
				AddAddressLine3(map.get(Excel.AddressLine3));
				log("STEP 20: User can enter Address Line 3", Status.PASS);
			} catch (Exception e) {
				log("STEP 20: User cannot enter Address Line 3", Status.FAIL);
				throw new RuntimeException("Failed in step 20: AddAddressLine3");
			}

			try {
				AddEmail(map.get(Excel.Email));
				log("STEP 21: User can enter Email", Status.PASS);
			} catch (Exception e) {
				log("STEP 21: User cannot enter Email", Status.FAIL);
				throw new RuntimeException("Failed in step 21: AddEmail");
			}

			try {
				AddHomePhone(map.get(Excel.HomePhone));
				log("STEP 22: User can enter Home Phone", Status.PASS);
			} catch (Exception e) {
				log("STEP 22: User cannot enter Home Phone", Status.FAIL);
				throw new RuntimeException("Failed in step 22: AddHomePhone");
			}

			try {
				AddCellPhone(map.get(Excel.CellPhone));
				log("STEP 23: User can enter Cell Phone", Status.PASS);
			} catch (Exception e) {
				log("STEP 23: User cannot enter Cell Phone", Status.FAIL);
				throw new RuntimeException("Failed in step 23: AddCellPhone");
			}

			try {
				AddWorkPhone(map.get(Excel.WorkPhone));
				log("STEP 24: User can enter Work Phone", Status.PASS);
			} catch (Exception e) {
				log("STEP 24: User cannot enter Work Phone", Status.FAIL);
				throw new RuntimeException("Failed in step 24: AddWorkPhone");
			}

			try {
				AddFaxPhone(map.get(Excel.FaxPhone));
				log("STEP 25: User can enter Fax Phone", Status.PASS);
			} catch (Exception e) {
				log("STEP 25: User cannot enter Fax Phone", Status.FAIL);
				throw new RuntimeException("Failed in step 25: AddFaxPhone");
			}

			try {
				AddComments(map.get(Excel.Comments));
				COMMENTS = map.get(Excel.Comments);
				log("STEP 26: User can enter Comments", Status.PASS);
			} catch (Exception e) {
				log("STEP 26: User cannot enter Comments", Status.FAIL);
				throw new RuntimeException("Failed in step 26: AddComments");
			}

			try {
				ClickOnUpdateButton();
				log("STEP 27: User can click on Update button", Status.PASS);
			} catch (Exception e) {
				log("STEP 27: User cannot click on Update button", Status.FAIL);
				throw new RuntimeException("Failed in step 27");
			}
			
			try {
				Assert.assertTrue(util.isElementVisible(SuccessMessage));
				log("STEP 28: User can see success message", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 28: User cannot see success message", Status.FAIL);
			}
			
			try {
				By entityName = By.xpath("//tr[contains(@id,'TREM_UC_radPanels_i3_i0_grdNPContacts_radYALGridControl')]/..//td[text()='"+PARTY_NAME+"']");
				Assert.assertTrue(util.isElementVisible(entityName));
				log("STEP 29: User can see updated Entity Name in the grid veiw", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 29: User cannot see updated Entity Name in the grid veiw", Status.FAIL);
			}
			
			try {
				By coName = By.xpath("//tr[contains(@id,'TREM_UC_radPanels_i3_i0_grdNPContacts_radYALGridControl')]/..//*[text()='C/O: "+CO_NAME+"']");
				Assert.assertTrue(util.isElementVisible(coName));
				log("STEP 30: User can see updated CO Name in the grid veiw", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 30: User cannot see updated CO Name in the grid veiw", Status.FAIL);
			}
			
			try {
				By partyType = By.xpath("//tr[contains(@id,'TREM_UC_radPanels_i3_i0_grdNPContacts_radYALGridControl')]/..//td[text()='"+PARTY_TYPE+"']");
				Assert.assertTrue(util.isElementVisible(partyType));
				log("STEP 31: User can see updated Party Type in the grid veiw", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 31: User cannot see updated Party Type in the grid veiw", Status.FAIL);
			}
			
			try {
				By legalLocation = By.xpath("//tr[contains(@id,'TREM_UC_radPanels_i3_i0_grdNPContacts_radYALGridControl')]/..//td[text()='"+LEGAL_LOCATION+"']");
				Assert.assertTrue(util.isElementVisible(legalLocation));
				log("STEP 32: User can see updated Legal Location in the grid veiw", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 32: User cannot see updated Legal Location in the grid veiw", Status.FAIL);
			}
			
			try {
				By comments = By.xpath("//tr[contains(@id,'TREM_UC_radPanels_i3_i0_grdNPContacts_radYALGridControl')]/..//td[text()='"+COMMENTS+"']");
				Assert.assertTrue(util.isElementVisible(comments));
				log("STEP 33: User can see updated Comments in the grid veiw", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 33: User cannot see updated Comments in the grid veiw", Status.FAIL);
			}
	        
	 }
	
		public void deleteAffectedPropertyInformation(String testcaseName) {
			try {
				ClickOnDeleteButton();
				log("STEP 1: User can click on Delete Icon", Status.PASS);
			} catch (Exception e) {
				log("STEP 1: User cannot click on Delete Icon", Status.FAIL);
				throw new RuntimeException("Failed in step 1");
			}
			
			try {
				ClickonOk();
				log("STEP 2: User can click on Ok Button", Status.PASS);
			} catch (Exception e) {
				log("STEP 2: User cannot click on Ok Button", Status.FAIL);
				throw new RuntimeException("Failed in step 2");
			}
			
			try {
				Assert.assertTrue(util.isElementVisible(SuccessMessage));
				log("STEP 3: User can see success message", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 3: User cannot see success message", Status.FAIL);
			}
			
		}
  	
}
