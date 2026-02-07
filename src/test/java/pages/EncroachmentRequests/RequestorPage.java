package pages.EncroachmentRequests;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

public class RequestorPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;

	public RequestorPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	
	By panelRequestor = By.xpath("//span[contains(text(),'Requestor')]");
	By btnAddNew = By.xpath("(//a[contains(@id,'_grdNPContacts_radYALGridControl_ctl00_ctl02_ctl00_lnkAddNewRecord')])");
	By drpType = By.xpath("//input[contains(@id,'type_ID_radYALDropDownList_Input')]");
	By txtLegalLocation = By.xpath("(//input[contains(@id,'Legal_Location')])[1]"); 
	By txtLastName = By.xpath("//input[contains(@id,'ENTITY_Last_Name') and @type='text']");
	By txtFirstName = By.xpath("//input[contains(@id,'ENTITY_First_Name') and @type='text']");
	By txtMiddleName = By.xpath("//input[contains(@id,'ENTITY_Middle_Name') and @type='text']");
	By txtTitle = By.xpath("//input[contains(@id,'ENTITY_Title') and @type='text']");
	By txtSuffix = By.xpath("//input[contains(@id,'ENTITY_Suffix') and @type='text']");
	By txtCOName = By.xpath("//input[contains(@id,'ENTITY_CO_Name') and @type='text']");
	By drpMaterialStatus = By.xpath("//input[contains(@id,'Marital_Status_ID') and @type='text']");
	By drpGender = By.xpath("//input[contains(@id,'ENTITY_Gender') and @type='text']");
	By txtTax_SSN = By.xpath("//input[contains(@id,'_EditFormControl_idEditNPParty_ENTITY_Tax_SSN') and @type='text']");
	By drpEntityName = By.xpath("(//input[contains(@id,'ENTITY_Corporation_Trust') and @type='text'])[1]");
	By txtEntityType = By.xpath("//input[contains(@id,'ENTITY_Entity_Type_ID') and @type='text']");
	By txtAddressLine1 = By.xpath("//input[contains(@id,'ENTITY_Address_Line_1') and @type='text']");
	By txtAddressLine2 = By.xpath("//input[contains(@id,'ENTITY_Address_Line_2') and @type='text']");
	By txtCity = By.xpath("//input[contains(@id,'ENTITY_City') and @type='text']");
	By drpState = By.xpath("//input[contains(@id,'ENTITY_RadState_Input') and @type='text']");
	By txtZipCode = By.xpath("(//input[contains(@id,'ENTITY_Zip_Code') and @type='text'])[1]");
    By txtFaxPhone  = By.xpath("//input[contains(@id,'ENTITY_FAX_NUMBER') and @type='text']");
    By txtHomePhone = By.xpath("(//input[contains(@id,'ENTITY_Home_Phone') and @type='text'])[1]");
	By txtCellPhone = By.xpath("//input[contains(@id,'ENTITY_Cell_Phone') and @type='text']");
	By txtWorkPhone = By.xpath("//input[contains(@id,'ENTITY_Work_Phone') and @type='text']");
	By txtAddressLine3 = By.xpath("//input[contains(@id,'ENTITY_Address_Line_3') and @type='text']");
    By txtEmail = By.xpath("(//input[contains(@id,'ENTITY_Email') and @type='text'])[1]");
    By txtInternationalPhone = By.xpath("//input[contains(@id,'_EditFormControl_idEditNPParty_ENTITY_RadTextBox2') and @type='text']");
    By txtComment = By.xpath("(//textarea[contains(@id,'_EditFormControl_idEditNPParty_comments')])[1]");
    By btnInsert = By.xpath("(//input[contains(@id,'EditFormControl_btnInsert') and @type='submit'])[1]");
	By btnEdit = By.xpath("(//input[contains(@id,'_grdNPContacts_radYALGridControl_ctl00_ctl04_EditButton')])[last()]"); 
	By btnUpdate = By.xpath("(//input[contains(@id,'EditFormControl_btnUpdate')])");
	By changesSavedSuccessfully = By.xpath("//span[text()='Changes saved successfully!']");


    public void ExpandRequestorPanel() {
       util.waitUntilElementDisplay(panelRequestor);
    	util.click(panelRequestor);
    }
    
    public void ClickOnAddNewRecord() {
       	util.waitUntilElementDisplay(btnAddNew);
    	util.click(btnAddNew);
    	util.waitUntilLoaderDisappear();
    }
    
    
    public void SelectType(String value) {
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
			util.inputTextAndPressTab(drpMaterialStatus, value);
    }
    
    public void SelectGender(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpGender, value);
    }
    
     public void AddTax_SSN(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtTax_SSN, value);
    }
    
    public void AddEntityName(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpEntityName, value);
    }
   
    
    public void AddEntityType(String value) {
    	util.click(txtEntityType);
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtEntityType, value);
		
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
    
    public void AddInternationalPhone(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtInternationalPhone, value);
    }
    
    public void AddFaxPhone(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtFaxPhone, value);
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
    
    public void AddAddressLine3(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtAddressLine3, value);
    }
    
    public void AddEmail(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtEmail, value);
    }
    
    public void AddComment(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtComment, value);
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
	
	public void Updatevalue(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtComment, value);

	}
	
	public void ClickOnUpdateButton() {
		util.waitUntilElementDisplay(btnUpdate);
		util.click(btnUpdate);
		util.waitUntilLoaderDisappear();

	}
	
    
	public void AddNewRecord(Map<String, String> map, String testcaseName) {

		try {
			ExpandRequestorPanel();
			log("STEP 1: User can expand Requestor Panel", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: User cannot expand Requestor Panel", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}

		try {
			ClickOnAddNewRecord();
			log("STEP 2: User can click on Add New Record Button", Status.PASS);
		} catch (Exception e) {
			log("STEP 2: User cannot click on Add New Record Button", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}

		try {
			SelectType(map.get(Excel.Type));
			log("STEP 3: User can select Type", Status.PASS);
		} catch (Exception e) {
			log("STEP 3: User cannot select Type", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}

		try {
			AddLegalLocation(map.get(Excel.LegalLocation));
			log("STEP 4: User can enter Leagal Location", Status.PASS);
		} catch (Exception e) {
			log("STEP 4: User cannot enter Leagal Location", Status.FAIL);
			throw new RuntimeException("Failed in step 4");
		}

		try {
			AddLastName(map.get(Excel.LastName));
			log("STEP 5:  User can enter Last Name", Status.PASS);
		} catch (Exception e) {
			log("STEP 5:  User cannot enter Last Name", Status.FAIL);
			throw new RuntimeException("Failed in step 5");
		}
		try {
			AddFirstName(map.get(Excel.FirstName));
			log("STEP 6: User can enter the value in First Name field ", Status.PASS);
		} catch (Exception e) {
			log("STEP 6:  User cannot enter the value in First Name field", Status.FAIL);
			throw new RuntimeException("Failed in step 6");
		}

		try {
			AddMiddleName(map.get(Excel.MiddleName));
			log("STEP 7: User can enter the value in Middle Name field ", Status.PASS);
		} catch (Exception e) {
			log("STEP 7:  User cannot enter the value in Middle Name field", Status.FAIL);
			throw new RuntimeException("Failed in step 7");
		}

		try {
			AddTitle(map.get(Excel.Title));
			log("STEP 8: User can enter the value in Title field ", Status.PASS);
		} catch (Exception e) {
			log("STEP 8:  User cannot enter the value in Title field", Status.FAIL);
			throw new RuntimeException("Failed in step 8");
		}

		try {
			AddSuffix(map.get(Excel.Suffix));
			log("STEP 9: User can enter the value in Suffix field ", Status.PASS);
		} catch (Exception e) {
			log("STEP 9:  User cannot enter the value in Suffix field", Status.FAIL);
			throw new RuntimeException("Failed in step 9");
		}

		try {
			AddCOName(map.get(Excel.COName));
			log("STEP 10: User can enter the value in CO Name field ", Status.PASS);
		} catch (Exception e) {
			log("STEP 10:  User cannot enter the value in CO Name field", Status.FAIL);
			throw new RuntimeException("Failed in step 10");
		}

		try {
			SelectMaritalStatus(map.get(Excel.MaritalStatus));
			log("STEP 11: User can enter the value in Gender field ", Status.PASS);
		} catch (Exception e) {
			log("STEP 11:  User cannot enter the value in Gender field", Status.FAIL);
			throw new RuntimeException("Failed in step 11");
		}

		try {
			SelectGender(map.get(Excel.Gender));
			log("STEP 12: User can enter the value in Gender field ", Status.PASS);
		} catch (Exception e) {
			log("STEP 12:  User cannot enter the value in Gender field", Status.FAIL);
			throw new RuntimeException("Failed in step 12");
		}

		try {
			AddTax_SSN(map.get("Tax_SSN"));
			log("STEP 13: User can enter the value in Tax_SSN field ", Status.PASS);
		} catch (Exception e) {
			log("STEP 13:  User cannot enter the value in Tax_SSN field", Status.FAIL);
			throw new RuntimeException("Failed in step 13");
		}

		try {
			AddEntityName(map.get(Excel.EntityName));
			log("STEP 14: User can enter the value in Entity Name field ", Status.PASS);
		} catch (Exception e) {
			log("STEP 14:  User cannot enter the value in Entity Name field", Status.FAIL);
			throw new RuntimeException("Failed in step 14");
		}

		try {
			AddEntityType(map.get(Excel.EntityType));
			log("STEP 15: User can enter the value in Entity Type field ", Status.PASS);
		} catch (Exception e) {
			log("STEP 15:  User cannot enter the value in Entity Type field", Status.FAIL);
			throw new RuntimeException("Failed in step 15");
		}

		try {
			AddAddressLine1(map.get(Excel.AddressLine1));
			log("STEP 16: User can enter the value in Address Line1 field ", Status.PASS);
		} catch (Exception e) {
			log("STEP 16:  User cannot enter the value in Address Line1 field", Status.FAIL);
			throw new RuntimeException("Failed in step 16");
		}

		try {
			AddAddressLine2(map.get(Excel.AddressLine2));
			log("STEP 17: User can enter the value in Address Line2 field ", Status.PASS);
		} catch (Exception e) {
			log("STEP 17:  User cannot enter the value in Address Line2 field", Status.FAIL);
			throw new RuntimeException("Failed in step 17");
		}

		try {
			AddCity(map.get(Excel.City));
			log("STEP 18: User can enter the value in City field ", Status.PASS);
		} catch (Exception e) {
			log("STEP 18:  User cannot enter the value in City field", Status.FAIL);
			throw new RuntimeException("Failed in step 18");
		}

		try {
			SelectState(map.get(Excel.State));
			log("STEP 19: User can enter the value in State field ", Status.PASS);
		} catch (Exception e) {
			log("STEP 19:  User cannot enter the value in State field", Status.FAIL);
			throw new RuntimeException("Failed in step 19");
		}

		try {
			AddZipCode(map.get(Excel.ZipCode));
			log("STEP 20: User can enter the value in Zip Code field ", Status.PASS);
		} catch (Exception e) {
			log("STEP 20:  User cannot enter the value in Zip Code field", Status.FAIL);
			throw new RuntimeException("Failed in step 20");
		}

		try {
			AddFaxPhone(map.get(Excel.CellPhone));
			log("STEP 21: User can enter the value in Cell Phone field ", Status.PASS);
		} catch (Exception e) {
			log("STEP 21:  User cannot enter the value in Cell Phone field", Status.FAIL);
			throw new RuntimeException("Failed in step 21");
		}

		try {
			AddHomePhone(map.get(Excel.HomePhone));
			log("STEP 22: User can enter the value in Home Phone field ", Status.PASS);
		} catch (Exception e) {
			log("STEP 22:  User cannot enter the value in Home Phone field", Status.FAIL);
			throw new RuntimeException("Failed in step 22");
		}

		try {
			AddCellPhone(map.get(Excel.CellPhone));
			log("STEP 23: User can enter the value in CellPhone field ", Status.PASS);
		} catch (Exception e) {
			log("STEP 23:  User cannot enter the value in CellPhone field", Status.FAIL);
			throw new RuntimeException("Failed in step 23");
		}

		try {
			AddWorkPhone(map.get(Excel.WorkPhone));
			log("STEP 24: User can enter the value in Work Phone field ", Status.PASS);
		} catch (Exception e) {
			log("STEP 24:  User cannot enter the value in Work Phone field", Status.FAIL);
			throw new RuntimeException("Failed in step 24");
		}

		try {
			AddAddressLine3(map.get(Excel.AddressLine3));
			log("STEP 25: User can enter the value in Address Line3 field ", Status.PASS);
		} catch (Exception e) {
			log("STEP 25:  User cannot enter the value in Address Line3 field", Status.FAIL);
			throw new RuntimeException("Failed in step 25");
		}

		try {
			AddEmail(map.get(Excel.Email));
			log("STEP 26: User can enter the value in Email field ", Status.PASS);
		} catch (Exception e) {
			log("STEP 26:  User cannot enter the value in Email field", Status.FAIL);
			throw new RuntimeException("Failed in step 26");
		}

		try {
			AddInternationalPhone(map.get(Excel.InternationalPhone));
			log("STEP 27: User can enter the value in International Phone field ", Status.PASS);
		} catch (Exception e) {
			log("STEP 27:  User cannot enter the value in International Phone field", Status.FAIL);
			throw new RuntimeException("Failed in step 27");
		}

		try {
			AddComment(map.get(Excel.Comment));
			log("STEP 28: User can enter the value in Comment field ", Status.PASS);
		} catch (Exception e) {
			log("STEP 28:  User cannot enter the value in Comment field", Status.FAIL);
			throw new RuntimeException("Failed in step 28");
		}

		try {
			ClickOnInsertButton();
			log("STEP 29: User can click on Insert button", Status.PASS);
		} catch (Exception e) {
			log("STEP 29: User cannot click on Insert button", Status.FAIL);
			throw new RuntimeException("Failed in step 29");
		}
		
		try {
			Assert.assertTrue(util.isElementVisible(changesSavedSuccessfully));
			 log("STEP 30:  User can see 'Changes saved successfully' Message" , Status.PASS);
		} catch (AssertionError e) {
			  log("STEP 30: Message - 'Changes saved successfully' does not displays ", Status.FAIL);
		}
		
		try {
			By entiryName = By.xpath("//tr[contains(@id,'_grdNPContacts_radYALGridControl')]//td[text()='"+map.get(Excel.EntityName)+"']");
			Assert.assertTrue(util.isElementVisible(entiryName));
			 log("STEP 31:  User can see Entity Name in the grid view" , Status.PASS);
		} catch (AssertionError e) {
			  log("STEP 31: User cannot see Entity Name in the grid view ", Status.FAIL);
		}
		
		try {
			By coName = By.xpath("//tr[contains(@id,'_grdNPContacts_radYALGridControl')]//i[text()='C/O: "+map.get(Excel.COName)+"']");
			Assert.assertTrue(util.isElementVisible(coName));
			 log("STEP 32:  User can see CO Name in the grid view" , Status.PASS);
		} catch (AssertionError e) {
			  log("STEP 32: User cannot see CO Name in the grid view ", Status.FAIL);
		}
		
		try {
			By partyType = By.xpath("//tr[contains(@id,'_grdNPContacts_radYALGridControl')]//td[text()='"+map.get(Excel.Type)+"']");
			Assert.assertTrue(util.isElementVisible(partyType));
			 log("STEP 33:  User can see Party Type in the grid view" , Status.PASS);
		} catch (AssertionError e) {
			  log("STEP 33: User cannot see Party Type in the grid view ", Status.FAIL);
		}
		
		try {
			By legalLocation = By.xpath("//tr[contains(@id,'_grdNPContacts_radYALGridControl')]//td[text()='"+map.get(Excel.LegalLocation)+"']");
			Assert.assertTrue(util.isElementVisible(legalLocation));
			 log("STEP 34:  User can see Legal Location in the grid view" , Status.PASS);
		} catch (AssertionError e) {
			  log("STEP 34: User cannot see Legal Location in the grid view ", Status.FAIL);
		}
		
		try {
			By comment = By.xpath("//tr[contains(@id,'_grdNPContacts_radYALGridControl')]//td[text()='"+map.get(Excel.Comment)+"']");
			Assert.assertTrue(util.isElementVisible(comment));
			 log("STEP 35:  User can see Comment in the grid view" , Status.PASS);
		} catch (AssertionError e) {
			  log("STEP 35: User cannot see Comment in the grid view ", Status.FAIL);
		}
		

	}
	
	public void EditRecord(Map<String, String> map, String testcaseName) {
			try {
				ClickOnEditButton();
				log("STEP 1: User can click on Edit Icon ", Status.PASS);
			} catch (Exception e) {
				log("STEP 1: User cannot click on Edit Icon", Status.FAIL);
				throw new RuntimeException("Failed in step 1");
			}
			
			try {
				AddComment(map.get(Excel.Comment));
				log("STEP 2: User can update comment  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 2: User cannot update comment ", Status.FAIL);
				throw new RuntimeException("Failed in step 2");
			}
			
			try {
				ClickOnUpdateButton();
				log("STEP 3: User can click on Update Button ", Status.PASS);
			} catch (Exception e) {
				log("STEP 3: User cannot click on Update Button", Status.FAIL);
				throw new RuntimeException("Failed in step 3");
			}
			
			try {
				Assert.assertTrue(util.isElementVisible(changesSavedSuccessfully));
				 log("STEP 4:  User can see 'Changes saved successfully' Message" , Status.PASS);
			} catch (AssertionError e) {
				  log("STEP 4: Message - 'Changes saved successfully' does not displays ", Status.FAIL);
			}
			
			try {
				By comment = By.xpath("//tr[contains(@id,'_grdNPContacts_radYALGridControl')]//td[text()='"+map.get(Excel.Comment)+"']");
				Assert.assertTrue(util.isElementVisible(comment));
				 log("STEP 5:  User can see Updated Comment in the grid view" , Status.PASS);
			} catch (AssertionError e) {
				  log("STEP 5: User cannot see Updated Comment in the grid view ", Status.FAIL);
			}
			
	 }
	 
		By btnDelete = By.xpath("(//input[contains(@id,'_grdNPContacts_radYALGridControl_ctl00_ctl04_gbcDeleteAlignment')])[1]");
		By iframDelete = By.xpath("//td[@class='rwWindowContent']");
		By btnOk = By.xpath("//span[text()='OK']");

		public void ClickonDelete() {
			util.waitUntilElementDisplay(btnDelete);
			util.click(btnDelete);
		}

		public void ClickonOk() {
			util.waitUntilElementDisplay(btnOk);
			util.click(btnOk);
			util.waitUntilLoaderDisappear();
		}
	 
	 
		public void DeleteRecord(String testcaseName) {
			try {
				ClickonDelete();
				log("STEP 1:  user can click on delete icon   ", Status.PASS);
			} catch (Exception e) {
				log("STEP 1:   user cannot click on delete icon ", Status.FAIL);
				throw new RuntimeException("Failed in step 1 ");
			}

			try {
				ClickonOk();
				log("STEP 2: User can click on Ok button",Status.PASS);
			} catch (Exception e) {
				log("STEP 2: User cannot click on Ok button", Status.FAIL);
				throw new RuntimeException("Failed in step 2");
			}
			
			try {
				Assert.assertTrue(util.isElementVisible(changesSavedSuccessfully));
				 log("STEP 3:  User can see 'Changes saved successfully' Message" , Status.PASS);
			} catch (AssertionError e) {
				  log("STEP 3: Message - 'Changes saved successfully' does not displays ", Status.FAIL);
			}

		}
	
}
