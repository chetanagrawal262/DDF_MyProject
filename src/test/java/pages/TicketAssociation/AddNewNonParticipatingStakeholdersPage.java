package pages.TicketAssociation;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

public class AddNewNonParticipatingStakeholdersPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;
	public static String AGREEMENT_NUMBER;

	public AddNewNonParticipatingStakeholdersPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	
	By NonParticipatingStakeholders = By.xpath("//span[contains(text(),'Non-Participating Stakeholders')]");
	
	By btnAddNew = By.xpath("(//a[contains(@id,'lnkAddNewRecord')])[2]");
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
	By drpEntityName = By.xpath("(//input[contains(@id,'ENTITY_Corporation_Trust') and @type='text'])[1]");
	By txtEntityType = By.xpath("//input[contains(@id,'ENTITY_Entity_Type_ID') and @type='text']");
	By txtAddressLine1 = By.xpath("//input[contains(@id,'ENTITY_Address_Line_1') and @type='text']");
	By txtAddressLine2 = By.xpath("//input[contains(@id,'ENTITY_Address_Line_2') and @type='text']");
	By txtCity = By.xpath("//input[contains(@id,'ENTITY_City') and @type='text']");
	By drpState = By.xpath("//input[contains(@id,'ENTITY_RadState_Input') and @type='text']");
	By txtZipCode = By.xpath("(//input[contains(@id,'ENTITY_Zip_Code') and @type='text'])[1]");
    By txtZipCodePlus = By.xpath("(//input[contains(@id,'ENTITY_Zip_Code_Plus') and @type='text'])[1]");
	By txtFaxPhone  = By.xpath("//input[contains(@id,'ENTITY_FAX_NUMBER') and @type='text']");
    By txtHomePhone = By.xpath("(//input[contains(@id,'ENTITY_Home_Phone') and @type='text'])[1]");
	By txtCellPhone = By.xpath("//input[contains(@id,'ENTITY_Cell_Phone') and @type='text']");
	By txtWorkPhone = By.xpath("//input[contains(@id,'ENTITY_Work_Phone') and @type='text']");
	By txtAddressLine3 = By.xpath("//input[contains(@id,'ENTITY_Address_Line_3') and @type='text']");
    By txtEmail = By.xpath("(//input[contains(@id,'ENTITY_Email') and @type='text'])[1]");
    By txtComment = By.xpath("(//textarea[contains(@id,'_EditFormControl_idEditNPParty_comments')])[1]");
    By btnInsert = By.xpath("(//input[contains(@id,'EditFormControl_btnInsert') and @type='submit'])[1]");
	By btnEdit = By.xpath("(//input[contains(@id,'EditButton')])[last()]"); 
	By btnUpdate = By.xpath("(//input[contains(@id,'EditFormControl_btnUpdate')])");
    By btnCancel = By.xpath("(//input[contains(@id,'EditFormControl_btnCancel')])");


    public void ClickOnNonParticipatingStakeholders() {
       	util.dummyWait(1);
    	util.waitUntilElementDisplay(btnAddNew);
    	util.click(btnAddNew);
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
    
    By W9Flag = By.xpath("(//input[contains(@id,'ENTITY_W9_STATUS_ID')])[1]");
	
    public void SelectW9Flag(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(W9Flag, value);
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
    
    public void AddZipCodePlus(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtZipCodePlus, value);
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
	By changesSavedSuccessfully = By.xpath("//span[text()='Changes saved successfully!']");

	
	public void ClickOnCancelButton() {
		util.waitUntilElementDisplay(btnEdit);
		util.click(btnEdit);
		util.waitUntilLoaderDisappear();
		util.waitUntilElementDisplay(btnCancel);
		util.click(btnCancel);
		util.waitUntilLoaderDisappear();
		
	}
    
	 public void AddNewNonParticipatingStakeholders(Map<String, String> map, String testcaseName) {
			try {
				ClickOnNonParticipatingStakeholders();
				log("STEP 1: Add new popup display with blank fields", Status.PASS);
			} catch (Exception e) {
				log("STEP 1: Popup up does not appear", Status.FAIL);
				throw new RuntimeException("Failed in step 1: Popup up does not appear");
			}
			
			
			try {
				SelectType(map.get(Excel.Type));
				log("STEP 2: Added value displays in the Type field", Status.PASS);
			} catch (Exception e) {
				log("STEP 2: Added value does not displays in the Type field", Status.FAIL);
				throw new RuntimeException("Failed in step 2: ");
			}
			
			try {
				AddLegalLocation(map.get(Excel.LegalLocation));
				log("STEP 3: Added value displays in the Legal Location field", Status.PASS);
			} catch (Exception e) {
				log("STEP 3: Added value does not displays in the Legal Location field", Status.FAIL);
				throw new RuntimeException("Failed in step 3:");
			}

			try {
				AddLastName(map.get(Excel.LastName));
				log("STEP 4:   Added value displays in the Last Name field :", Status.PASS);
			} catch (Exception e) {
				log("STEP 4:   Added value does not displays in the Last Name field", Status.FAIL);
				throw new RuntimeException("Failed in step 4");
			}
			try {
				AddFirstName(map.get(Excel.FirstName));
				log("STEP 5: User can enter the value in First Name field ", Status.PASS);
			} catch (Exception e) {
				log("STEP 5:  User cannot enter the value in First Name field", Status.FAIL);
				throw new RuntimeException("Failed in step 5");
			}
			
			try {
				AddMiddleName(map.get(Excel.MiddleName));
				log("STEP 6: User can enter the value in Middle Name field ", Status.PASS);
			} catch (Exception e) {
				log("STEP 6:  User cannot enter the value in Middle Name field", Status.FAIL);
				throw new RuntimeException("Failed in step 6");
			}
			
			try {
				AddTitle(map.get(Excel.Title));
				log("STEP 7: User can enter the value in Title field ", Status.PASS);
			} catch (Exception e) {
				log("STEP 7:  User cannot enter the value in Title field", Status.FAIL);
				throw new RuntimeException("Failed in step 7");
			}
			
			if(testcaseName.contains("ALT") || testcaseName.contains("ORSTED")||testcaseName.contains("ORION") || testcaseName.contains("ATWELL")) {
			try {
				AddSuffix(map.get(Excel.Suffix));
				log("STEP 8: User can enter the value in Suffix field ", Status.PASS);
			} catch (Exception e) {
				log("STEP 8:  User cannot enter the value in Suffix field", Status.FAIL);
				throw new RuntimeException("Failed in step 8");
			}
		}
			
			
			try {
				AddCOName(map.get(Excel.COName));
				log("STEP 9: User can enter the value in CO Name field ", Status.PASS);
			} catch (Exception e) {
				log("STEP 9:  User cannot enter the value in CO Name field", Status.FAIL);
				throw new RuntimeException("Failed in step 9");
			}
			
			try {
				SelectMaritalStatus(map.get(Excel.MaritalStatus));
				log("STEP 10: User can enter the value in Gender field ", Status.PASS);
			} catch (Exception e) {
				log("STEP 10:  User cannot enter the value in Gender field", Status.FAIL);
				throw new RuntimeException("Failed in step 10");
			}
			
			try {
				SelectGender(map.get(Excel.Gender));
				log("STEP 11: User can enter the value in Gender field ", Status.PASS);
			} catch (Exception e) {
				log("STEP 11:  User cannot enter the value in Gender field", Status.FAIL);
				throw new RuntimeException("Failed in step 11");
			}
			
			if(testcaseName.contains("ALT") || testcaseName.contains("ORSTED")||testcaseName.contains("ORION") || testcaseName.contains("ATWELL")) {
			try {
				SelectW9Flag(map.get(Excel.W9Flag));
				log("STEP 12: User can enter the value in W9Flag field ", Status.PASS);
			} catch (Exception e) {
				log("STEP 12:  User cannot enter the value in W9Flag field", Status.FAIL);
				throw new RuntimeException("Failed in step 12");
			}
		}
			
			try {
				AddEntityName(map.get(Excel.EntityName));
				log("STEP 13: User can enter the value in Entity Name field ", Status.PASS);
			} catch (Exception e) {
				log("STEP 13:  User cannot enter the value in Entity Name field", Status.FAIL);
				throw new RuntimeException("Failed in step 13");
			}
			
			try {
				AddEntityType(map.get(Excel.EntityType));
				log("STEP 14: User can enter the value in Entity Type field ", Status.PASS);
			} catch (Exception e) {
				log("STEP 14:  User cannot enter the value in Entity Type field", Status.FAIL);
				throw new RuntimeException("Failed in step 14");
			}
			
			
			try {
				AddAddressLine1(map.get(Excel.AddressLine1));
				log("STEP 15: User can enter the value in Address Line1 field ", Status.PASS);
			} catch (Exception e) {
				log("STEP 15:  User cannot enter the value in Address Line1 field", Status.FAIL);
				throw new RuntimeException("Failed in step 15");
			}
			
			try {
				AddAddressLine2(map.get(Excel.AddressLine2));
				log("STEP 16: User can enter the value in Address Line2 field ", Status.PASS);
			} catch (Exception e) {
				log("STEP 16:  User cannot enter the value in Address Line2 field", Status.FAIL);
				throw new RuntimeException("Failed in step 16");
			}
			

			try {
				AddCity(map.get(Excel.City));
				log("STEP 17: User can enter the value in City field ", Status.PASS);
			} catch (Exception e) {
				log("STEP 17:  User cannot enter the value in City field", Status.FAIL);
				throw new RuntimeException("Failed in step 17");
			}
			
			try {
				SelectState(map.get(Excel.State));
				log("STEP 18: User can enter the value in State field ", Status.PASS);
			} catch (Exception e) {
				log("STEP 18:  User cannot enter the value in State field", Status.FAIL);
				throw new RuntimeException("Failed in step 18");
			}
			
			try {
				AddZipCode(map.get(Excel.ZipCode));
				log("STEP 19: User can enter the value in Zip Code field ", Status.PASS);
			} catch (Exception e) {
				log("STEP 19:  User cannot enter the value in Zip Code field", Status.FAIL);
				throw new RuntimeException("Failed in step 19");
			}
			
//			try {
//				AddZipCodePlus(map.get(Excel.ZipCodePlus));
//				log("STEP 20: User can enter the value in Zip Code Plus field ", Status.PASS);
//			} catch (Exception e) {
//				log("STEP 20:  User cannot enter the value in Zip Code Plus field", Status.FAIL);
//				throw new RuntimeException("Failed in step 20");
//			}
			
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
				AddComment(map.get(Excel.Comment));
				log("STEP 27: User can enter the value in Comment field ", Status.PASS);
			} catch (Exception e) {
				log("STEP 27:  User cannot enter the value in Comment field", Status.FAIL);
				throw new RuntimeException("Failed in step 27");
			}
			

			try {
				ClickOnInsertButton();
				log("STEP 28: User can click on Insert button", Status.PASS);
			} catch (Exception e) {
				log("STEP 28: User cannot click on Insert button", Status.FAIL);
				throw new RuntimeException("Failed in step 28");
			}
			
			try {
				ClickOnEditButton();
				log("STEP 29: Existing User record should be open  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 29: Existing User record should not be open", Status.FAIL);
				throw new RuntimeException("Failed in step 29");
			}
			
			try {
				Updatevalue(map.get(Excel.UpdatedComment));
				log("STEP 30: User can update a value in the field/s   ", Status.PASS);
			} catch (Exception e) {
				log("STEP 30: User cannot update a value in the field/s ", Status.FAIL);
				throw new RuntimeException("Failed in step 30");
			}
			
			try {
				ClickOnUpdateButton();
				log("STEP 31: User can click on Update Button ", Status.PASS);
			} catch (Exception e) {
				log("STEP 31: User cannot click on Update Button", Status.FAIL);
				throw new RuntimeException("Failed in step 31");
			}
			
			 if (util.isElementPresent(changesSavedSuccessfully)) {
				  log("STEP 31:  User can see 'Changes saved successfully'" , Status.PASS);
			   } else {
				  log("STEP 31: Message - 'Changes saved successfully' does not displays ", Status.FAIL);
				throw new RuntimeException("Faild in STEP 31:");
			   }
			
			try {
				ClickOnCancelButton();
				log("STEP 32: Expanded Grid  should close and Contact record should not delete", Status.PASS);
			} catch (Exception e) {
				log("STEP 32: unable to click Cancel button OR popup does not close", Status.FAIL);
				throw new RuntimeException("Failed in step 32");
			}
			
	 }
	 
	   By btnDelete = By.xpath("(//input[contains(@id,'radYALGridControl_ctl00_ctl04_gbcDeleteAlignment')])[1]");
		By iframDelete = By.xpath("//td[@class='rwWindowContent']");
		By btnCancle = By.xpath("//span[text()='Cancel']");
		By btnOk = By.xpath("//span[text()='OK']");
	

		public void ClickonDelete() {
	  		util.waitUntilElementDisplay(btnDelete);
	  		util.click(btnDelete);
	    }
	
	 
	 public void ClickonCancle()  {
		 util.waitUntilElementDisplay(btnCancle);
	  		util.click(btnCancle);
	    }
	 
	 
	 public void ClickonOk()  {
		    util.waitUntilElementDisplay(btnDelete);
	  		util.click(btnDelete);	
	  		 util.waitUntilElementDisplay(btnOk);
		  		util.click(btnOk);	
		  		util.waitUntilLoaderDisappear();
	  		util.waitUntilElementDisplay(changesSavedSuccessfully);
			Assert.assertTrue(util.isElementPresent(changesSavedSuccessfully), "Changes saved successfully!");
	  		
	    }
	 
	 
 public void DeleteNonParticipatingStakeholders(String testcaseName) { 
		 try {
			 ClickonDelete();
				log("STEP 1:  user can click on cross icon   ", Status.PASS);
			} catch (Exception e) {
				log("STEP 1:  Popup Delete does not open", Status.FAIL);
				throw new RuntimeException("Failed in step 1 ");
			}
	 
		 
		 
		 try {
			 ClickonCancle();
				log("STEP 2: User can click on cancel button  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 2: User cannot click on cancel button", Status.FAIL);
				throw new RuntimeException("Failed in step 2 ");
			}
		 
		 try {
			 ClickonOk();
				log("STEP 3: Deleted record does not display in the grid and 2)Message- Changes saved suessfully! in green displays. ", Status.PASS);
			} catch (Exception e) {
				log("STEP 3: Message- Changes saved sucessfully' does not display", Status.FAIL);
				throw new RuntimeException("Failed in step 3 ");
			
			}
		 
    }
	
}
