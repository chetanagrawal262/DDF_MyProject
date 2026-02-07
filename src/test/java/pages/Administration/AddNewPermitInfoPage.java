package pages.Administration;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

public class AddNewPermitInfoPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;
	String NAME;

	public AddNewPermitInfoPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	
	By navAdministration = By.xpath("//span[text()='Administration']");
	By navConfiguration = By.xpath("//span[text()='Configuration']");
	By navPermitAgencies = By.xpath("//span[contains(text(),'Permit Agencies')]");
	By btnAddNewRecord = By.xpath("//a[contains(@id,'lnkAddNewRecord')]");
	By PermitInformation = By.xpath("//span[contains(text(),'Permit Information')]");
	By txtName = By.xpath("//input[contains(@id,'EditFormControl_Agency_NAME') and @type='text']");
	By txtPermitType = By.xpath("//input[contains(@id,'EditFormControl_TYPE_ID_radYALDropDownList_Input') and @type='text']");
    By drpPermitSubType = By.xpath("//input[contains(@id,'EditFormControl_SUB_TYPE_ID') and @type='text']");
    By drpState = By.xpath("//input[contains(@id,'EditFormControl_STATE_ABB') and @type='text']");
    By drpStateContact = By.xpath("//input[contains(@id,'PrimaryContact_RadState_Input') and @type='text']");
    By txtURL = By.xpath("//input[contains(@id,'EditFormControl_URL') and @type='text']");
    By permitTerm = By.xpath("//input[contains(@id,'EditFormControl_Permit_term_No') and @type='text']");
    By drpPermitTerm = By.xpath("//input[contains(@id,'EditFormControl_Permit_term_Period_ID') and @type='text']");
    By additionalRenewal = By.xpath("//input[contains(@id,'EditFormControl_Add_Renew_No') and @type='text']");
    By drpAdditionalRenewal = By.xpath("//input[contains(@id,'EditFormControl_Add_Renew_Period_ID') and @type='text']");
    By processTimeline = By.xpath("//input[contains(@id,'EditFormControl_Process_timeline_no') and @type='text']");
    By drpProcessTimeline = By.xpath("//input[contains(@id,'EditFormControl_Process_timeline_Period_ID') and @type='text']");
	By txtApplicationFee = By.xpath("//input[contains(@id,'EditFormControl_Application_Fee') and @type='text']");
	By txtExpeditingFee = By.xpath("//input[contains(@id,'EditFormControl_Expediting_Fee') and @type='text']");
	By txtRenewalFee = By.xpath("//input[contains(@id,'EditFormControl_Renewal_Fees') and @type='text']");
	By txtLicenseFee = By.xpath("//input[contains(@id,'EditFormControl_License_Fee') and @type='text']");
	By AsBuiltRequiredCheckbox = By.xpath("//input[contains(@id,'EditFormControl_As_Built_Required')]");
	By AlignentRequiredCheckbox = By.xpath("//input[contains(@id,'EditFormControl_Alignment_Required')]");
	By txtComment = By.xpath("//textarea[contains(@id,'EditFormControl_Notes')]");
	By btnInsert = By.xpath("//input[contains(@id,'EditFormControl_btnInsert')]");
	By btnCancel = By.xpath("//input[contains(@id,'EditFormControl_btnCancel') ]");
	By btnEdit = By.xpath("(//input[contains(@id,'EditButton')])[last()]");
	By btnUpdate = By.xpath("//input[contains(@id,'EditFormControl_btnUpdate')]");
	By txtFilter = By.xpath("//input[contains(@id,'FilterTextBox_Notes')]");
	By btnFilter = By.xpath("(//input[contains(@id,'Filter_Notes')])");
	By SelectFilter = By.xpath("//span[contains(text(),'Contains')]");
	By btnDelete = By.xpath("(//input[contains(@id,'gbcDeleteAlignment')])[last()]");
	By btncancel = By.xpath("//span[text()='Cancel']");
	By btnOk = By.xpath("//span[text()='OK']");
	By AddNewRecord = By.xpath("//a[contains(@id,'lnkAddNewRecord')]");
    By navContactDetail = By.xpath("//span[contains(text(),'Contact Details')]");
	By txtLastName = By.xpath("//input[contains(@id,'PrimaryContact_Last_Name') and @type='text']");
	By txtFirstName = By.xpath("//input[contains(@id,'PrimaryContact_First_Name') and @type='text']");
	By txtMiddleName = By.xpath("//input[contains(@id,'PrimaryContact_Middle_Name') and @type='text']");
	By txtTitle = By.xpath("//input[contains(@id,'PrimaryContact_Title') and @type='text']");
	By drpEntityName = By.xpath("(//input[contains(@id,'PrimaryContact_Corporation_Trust') and @type='text'])[1]");
	By txtEntityType = By.xpath("//input[contains(@id,'PrimaryContact_Entity_Type_ID_radYALDropDownList_Input') and @type='text']");
	By txtSuffix = By.xpath("//input[contains(@id,'PrimaryContact_Suffix') and @type='text']");
	By txtCOName = By.xpath("//input[contains(@id,'PrimaryContact_CO_Name') and @type='text']");
	By drpGender = By.xpath("//input[contains(@id,'PrimaryContact_Gender') and @type='text']");
	By txtVendor = By.xpath("//input[contains(@id,'PrimaryContact_Vendor_ID') and @type='text']");
	By txtAddressLine1 = By.xpath("//input[contains(@id,'_PrimaryContact_Address_Line_1') and @type='text']");
	By txtAddressLine2 = By.xpath("//input[contains(@id,'_PrimaryContact_Address_Line_2') and @type='text']");
	By txtCity = By.xpath("//input[contains(@id,'_PrimaryContact_City') and @type='text']");
	By txtZipCode = By.xpath("(//input[contains(@id,'_PrimaryContact_Zip_Code') and @type='text'])[1]");
    By txtZipCodePlus = By.xpath("(//input[contains(@id,'PrimaryContact_Zip_Code_Plus') and @type='text'])[1]");
	By txtAddressLine3 = By.xpath("//input[contains(@id,'_PrimaryContact_Address_Line_3') and @type='text']");
	By txtEmail = By.xpath("(//input[contains(@id,'PrimaryContact_Email') and @type='text'])[1]");
    By txtHomePhone = By.xpath("(//input[contains(@id,'PrimaryContact_Home_Phone') and @type='text'])[1]");
	By txtCellPhone = By.xpath("//input[contains(@id,'PrimaryContact_Cell_Phone') and @type='text']");
	By txtWorkPhone = By.xpath("//input[contains(@id,'PrimaryContact_Work_Phone') and @type='text']");
	By txtInterationalPhone = By.xpath("(//input[contains(@id,'PrimaryContact_Intl_Phone') and @type='text'])[1]");
	By txtFaxPhone  = By.xpath("//input[contains(@id,'PrimaryContact_FAX_NUMBER') and @type='text']");
	By txtSecLastName = By.xpath("//input[contains(@id,'SecondaryContact_Last_Name') and @type='text']");
	By txtSecFirstName = By.xpath("//input[contains(@id,'SecondaryContact_First_Name') and @type='text']");
	By txtSecMiddleName = By.xpath("//input[contains(@id,'SecondaryContact_Middle_Name') and @type='text']");
	By navManageContact = By.xpath("(//a[text()='Manage Contact(s)(1)'])[1]");
	
	public void NavigateToPermitInformation() {
		util.waitUntilElementDisplay(navAdministration);
		util.click(navAdministration);
		util.waitUntilElementDisplay(navConfiguration);
		util.click(navConfiguration);
		util.waitUntilElementDisplay(navPermitAgencies);
		util.click(navPermitAgencies);
	}
	
	public void ClickOnPermitInformation() {
		util.waitUntilElementDisplay(btnAddNewRecord);
		util.click(btnAddNewRecord);
		util.waitUntilElementDisplay(PermitInformation);
		util.click(PermitInformation);
		util.dummyWait(1);
	}

	public void AddName(String value) {
		if (!commonFunction.checkNA(value)) 
			util.inputTextAndPressTab(txtName, value);
	}

	public void SelectPermitType(String value) {
		if (!commonFunction.checkNA(value)) 
			util.inputTextAndPressTab(txtPermitType, value);
	}

	public void SelectPermitSubType(String value) {
		if (!commonFunction.checkNA(value)) 
			util.inputTextAndPressTab(drpPermitSubType, value);
	}
	
	public void AddURL(String value) {
		if (!commonFunction.checkNA(value)) 
			util.inputTextAndPressTab(txtURL, value);
	}
	
	public void SelectPermitTerm(String value) {
		if (!commonFunction.checkNA(value)) 
			util.inputText(permitTerm, value);
	}
	
	public void SelectPermitTermdrp(String value) {
		if (!commonFunction.checkNA(value)) 
			util.inputTextAndPressTab(drpPermitTerm, value);
	}
	
	public void SelectAdditionalRenewal(String value) {
		if (!commonFunction.checkNA(value)) 
			util.inputText(additionalRenewal, value);
	}
	
	public void SelectAdditionalRenewaldrp(String value) {
		if (!commonFunction.checkNA(value)) 
			util.inputTextAndPressTab(drpAdditionalRenewal, value);
	}
	
	public void SelectProcessTimeline(String value) {
		if (!commonFunction.checkNA(value)) 
			util.inputText(processTimeline, value);
	}
	
	public void SelectProcessTimelinedrp(String value) {
		if (!commonFunction.checkNA(value)) 
			util.inputTextAndPressTab(drpProcessTimeline, value);
	}
	
	public void SelectApplicationFee(String value) {
		if (!commonFunction.checkNA(value)) 
			util.inputTextAndPressTab(txtApplicationFee, value);
	}
	
	public void SelectExpeditingFee(String value) {
		if (!commonFunction.checkNA(value)) 
			util.inputTextAndPressTab(txtExpeditingFee, value);
	}
	
	public void SelectRenewalFee(String value) {
		if (!commonFunction.checkNA(value)) 
			util.inputTextAndPressTab(txtRenewalFee, value);
	}
	
	public void SelectLicenseFee(String value) {
		if (!commonFunction.checkNA(value)) 
			util.inputTextAndPressTab(txtLicenseFee, value);
	}

	public void ClickOnAsBuiltRequiredCheckbox() {
		util.waitUntilElementDisplay(AsBuiltRequiredCheckbox);
		util.click(AsBuiltRequiredCheckbox);	
	}
	
	public void ClickOnAsAlignentRequiredCheckbox() {
		util.waitUntilElementDisplay(AlignentRequiredCheckbox);
		util.click(AlignentRequiredCheckbox);	
	}
	
	public void AddComment(String value) {
		if (!commonFunction.checkNA(value)) 
			util.inputTextAndPressTab(txtComment, value);
	}
	
	public void ClickOnCancelButton() {
		util.waitUntilElementDisplay(btnAddNewRecord);
		util.click(btnAddNewRecord);
		util.dummyWait(1);
		util.waitUntilElementDisplay(btnCancel);
		util.click(btnCancel);
		util.dummyWait(1);

	}
	public void AddandApplyFilter(String value) {
		if (!commonFunction.checkNA(value)) 
			util.inputTextAndPressTab(txtFilter, value);
		util.waitFor(300);
		util.waitUntilElementDisplay(btnFilter);
		util.click(btnFilter);
		util.waitUntilElementDisplay(SelectFilter);
		util.click(SelectFilter);
		util.waitFor(500);
	}
		
		public void RemoveFilter() {
			util.waitUntilElementDisplay(btnFilter);
			util.click(btnFilter);
			util.waitUntilElementDisplay(SelectFilter);
			util.click(SelectFilter);
			util.dummyWait(1);
		}
		
		public void ClickOnContactDetailROW() {
			util.waitUntilElementDisplay(navManageContact);
			util.click(navManageContact);
		}
		
		public void ClickOnContactDetail() {
			util.waitUntilElementDisplay(navContactDetail);
			util.click(navContactDetail);
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
	   
	    
	    public void AddEntityName(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(drpEntityName, value);
			
	    }
	   
	    
	    public void AddEntityType(String value) {
	    	util.click(txtEntityType);
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtEntityType, value);
			
	    }
	    
	   
	    public void AddSuffix(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtSuffix, value);
			
	    }
	  
	    
	    public void AddCOName(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtCOName, value);
			
	    }
	    
	    public void SelectGender(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(drpGender, value);
	    }
		
	    public void AddVendor(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtVendor, value);
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
	    
	    public void SelectStateContact(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(drpStateContact, value);
	    }
	    
	    public void AddZipCode(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtZipCode, value);
	    }
	    
	    public void AddZipCodePlus(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtZipCodePlus, value);
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
	    
	    public void AddInterationalPhone(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtInterationalPhone, value);
	    }
	    
	    public void AddFaxPhone(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtFaxPhone, value);
	    }
	    
	    public void AddSecondaryLastName(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtSecLastName, value);
	    }
	    
	    public void AddSecondaryFirstName(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtSecFirstName, value);
	    }
	    
	    public void AddSecondaryMiddleName(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtSecMiddleName, value);
	    }
	    
		public void ClickOnInsertButton() {
			util.waitUntilElementDisplay(btnInsert);
			util.click(btnInsert);
			util.dummyWait(1);

		}
		
		public void ClickOnEditButton() {
			util.waitUntilElementDisplay(btnEdit);
			util.click(btnEdit);
			util.dummyWait(1);
			util.waitUntilElementDisplay(navContactDetail);
			util.click(navContactDetail);
			util.dummyWait(1);
		}
		
		public void Updatevalue(String value) {
			if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtAddressLine2, value);
			util.dummyWait(1);

		}
		
		public void ClickOnUpdateButton() {
			util.waitUntilElementDisplay(btnUpdate);
			util.click(btnUpdate);
			util.dummyWait(1);

		}
		
		public void ClickOnDeleteButton() {
			util.waitUntilElementDisplay(btnDelete);
			util.click(btnDelete);
			util.dummyWait(1);
		}
		
		 public void ClickonCancle()  {
		    util.dummyWait(3);
		  		util.waitUntilElementDisplay(btncancel);
		  		util.click(btncancel);
		
		    }
		 
			By SuccessMessage = By.xpath("//span[text()='Changes saved successfully!']");

		 public void ClickonOk()  {
			    util.waitUntilElementDisplay(btnDelete);
		  		util.click(btnDelete);	
		  		util.waitUntilElementDisplay(btnOk);
		  		util.click(btnOk);
		  		util.dummyWait(2);
		  		util.waitUntilElementDisplay(SuccessMessage);
				Assert.assertTrue(util.isElementPresent(SuccessMessage), "Changes saved successfully!");
			
		 }
		
		 By PrjectPermit = By.xpath("//a[normalize-space()='Project Permits']");
		 By addProjectPermit = By.xpath("//*[normalize-space()='Project Permits']/..//a[normalize-space()='Add new record']");
		 By drpAgencyName = By.xpath("//input[contains(@id,'EditFormControl_AGENCY_ID_radYALDropDownList_Input')]");
			
		 public void clickOnAddNewRecord() {
				util.click(addProjectPermit);
				util.waitUntilLoaderDisappear();
			}
		 
	 public void AddNewPermit(Map<String, String> map, String testcaseName) {
			try {
				NavigateToPermitInformation();
				ClickOnPermitInformation();
				log("STEP 1:  Add new popup display with blank fields", Status.PASS);
			} catch (Exception e) {
				log("STEP 1: Popup up does not appear", Status.FAIL);
				throw new RuntimeException("Failed in step 1: Popup up does not appear");
			}

			try {
				AddName(map.get(Excel.Name));
				NAME=map.get(Excel.Name);
				log("STEP 2:   Added value displays in the Name field :", Status.PASS);
			} catch (Exception e) {
				log("STEP 2:   Added value does not displays in the Name field", Status.FAIL);
				throw new RuntimeException("Failed in step 2");
			}
			try {
				SelectPermitType(map.get(Excel.PermitType));
				log("STEP 3: User can enter the value in Permit Type field ", Status.PASS);
			} catch (Exception e) {
				log("STEP 3:  User cannot enter the value in Permit Type field", Status.FAIL);
				throw new RuntimeException("Failed in step 3");
			}
			

			try {
				SelectPermitSubType(map.get(Excel.PermitSubType));
				log("STEP 4:   Added value displays in the Permit Sub Type field :", Status.PASS);
			} catch (Exception e) {
				log("STEP 4:   Added value does not displays in the Permit Sub Type field", Status.FAIL);
				throw new RuntimeException("Failed in step 4");
			}
			try {
				SelectState(map.get(Excel.State));
				log("STEP 5: User can enter the value in State field ", Status.PASS);
			} catch (Exception e) {
				log("STEP 5:  User cannot enter the value in State field", Status.FAIL);
				throw new RuntimeException("Failed in step 5");
			}
			
			try {
				AddURL(map.get(Excel.URL));
				log("STEP 6:   Added value displays in the URL field :", Status.PASS);
			} catch (Exception e) {
				log("STEP 6:   Added value does not displays in the URL field", Status.FAIL);
				throw new RuntimeException("Failed in step 6");
			}
			try {
				SelectPermitTerm(map.get(Excel.PermitTerm));
				SelectPermitTermdrp(map.get(Excel.PermitTermdrp));
				log("STEP 7: User can enter the value in Permit Term field ", Status.PASS);
			} catch (Exception e) {
				log("STEP 7:  User cannot enter the value in Permit Term field", Status.FAIL);
				throw new RuntimeException("Failed in step 7");
			}
			
			try {
				SelectAdditionalRenewal(map.get(Excel.AdditionalRenewal));
				SelectAdditionalRenewaldrp(map.get(Excel.AdditionalRenewaldrp));
				log("STEP 8:   Added value displays in the Additional Renewal field :", Status.PASS);
			} catch (Exception e) {
				log("STEP 8:   Added value does not displays in the Additional Renewal field", Status.FAIL);
				throw new RuntimeException("Failed in step 8");
			}
			try {
				SelectProcessTimeline(map.get(Excel.ProcessTimelines));
				SelectProcessTimelinedrp(map.get(Excel.ProcessTimelinesdrp));
				log("STEP 9: User can enter the value in Process Timelines field ", Status.PASS);
			} catch (Exception e) {
				log("STEP 9:  User cannot enter the value in Process Timelines field", Status.FAIL);
				throw new RuntimeException("Failed in step 9");
			}
			
			try {
				SelectApplicationFee(map.get(Excel.ApplicationFees));
				log("STEP 10:   Added value displays in the Application Fees field :", Status.PASS);
			} catch (Exception e) {
				log("STEP 10:   Added value does not displays in the Application Fees field", Status.FAIL);
				throw new RuntimeException("Failed in step 10");
			}
			try {
				SelectExpeditingFee(map.get(Excel.ExpeditingFee));
				log("STEP 11: User can enter the value in Expediting Fee field ", Status.PASS);
			} catch (Exception e) {
				log("STEP 11:  User cannot enter the value in Expediting Fee field", Status.FAIL);
				throw new RuntimeException("Failed in step 11");
			}
			
			try {
				SelectRenewalFee(map.get(Excel.RenewalFees));
				log("STEP 12:   Added value displays in the Renewal Fees field :", Status.PASS);
			} catch (Exception e) {
				log("STEP 12:   Added value does not displays in the Renewal Fees field", Status.FAIL);
				throw new RuntimeException("Failed in step 12");
			}
			try {
				SelectLicenseFee(map.get(Excel.LicenseFees));
				log("STEP 13: User can enter the value in License Fees field ", Status.PASS);
			} catch (Exception e) {
				log("STEP 13:  User cannot enter the value in License Fees field", Status.FAIL);
				throw new RuntimeException("Failed in step 13");
			}
			
			try {
				ClickOnAsBuiltRequiredCheckbox();
				log("STEP 14:  As-Built Required Check box should be checked ", Status.PASS);
			} catch (Exception e) {
				log("STEP 14:  As-Built Required Check box should not be checked ", Status.FAIL);
				throw new RuntimeException("Failed in step 14");
			}
			try {
				ClickOnAsAlignentRequiredCheckbox();
				log("STEP 15:  Alignment Required Check box should be checked ", Status.PASS);
			} catch (Exception e) {
				log("STEP 15:  Alignment Required Check box should not be checked", Status.FAIL);
				throw new RuntimeException("Failed in step 15");
			}
			
			try {
				AddComment(map.get(Excel.Comment));
				log("STEP 16: User can enter the value in Comment field ", Status.PASS);
			} catch (Exception e) {
				log("STEP 16:  User cannot enter the value in Comment field", Status.FAIL);
				throw new RuntimeException("Failed in step 16");
			}
			
			 if(testcaseName.contains("ROW") || testcaseName.contains("TRA") || testcaseName.contains("DOM")) {
				 if(util.isElementVisible(navContactDetail)) {
				 try {
					 ClickOnContactDetail();
						log("STEP 17: Add new popup display with blank fields", Status.PASS);
					} catch (Exception e) {
						log("STEP 17: Popup up does not appear", Status.FAIL);
						throw new RuntimeException("Failed in step 17: Popup up does not appear");
					} 
				 util.dummyWait(5);
     
				 if(util.isElementPresent(txtLastName)) {
					try {
						AddLastName(map.get(Excel.LastName));
						log("STEP 18:   Added value displays in the Last Name field :", Status.PASS);
					} catch (Exception e) {
						log("STEP 18:   Added value does not displays in the Last Name field", Status.FAIL);
						throw new RuntimeException("Failed in step 18");
					}
				 }
				 
				 if(util.isElementPresent(txtFirstName)) {
					try {
						AddFirstName(map.get(Excel.FirstName));
						log("STEP 19: User can enter the value in First Name field ", Status.PASS);
					} catch (Exception e) {
						log("STEP 19:  User cannot enter the value in First Name field", Status.FAIL);
						throw new RuntimeException("Failed in step 19");
					}
				 }
				 
				 if(util.isElementPresent(txtMiddleName)) {
					try {
						AddMiddleName(map.get(Excel.MiddleName));
						log("STEP 20: User can enter the value in Lookup Value field ", Status.PASS);
					} catch (Exception e) {
						log("STEP 20:  User cannot enter the value in Lookup Value field", Status.FAIL);
						throw new RuntimeException("Failed in step 20");
					}
				 }
				 
				 if(util.isElementPresent(txtTitle)) {
					try {
						AddTitle(map.get(Excel.Title));
						log("STEP 21: User can enter the value in Title field ", Status.PASS);
					} catch (Exception e) {
						log("STEP 21:  User cannot enter the value in Title field", Status.FAIL);
						throw new RuntimeException("Failed in step 21");
					}
				 }
				 
					try {
						AddEntityName(map.get(Excel.EntityName));
						log("STEP 22: User can enter the value in Entity Name field ", Status.PASS);
					} catch (Exception e) {
						log("STEP 22:  User cannot enter the value in Entity Name field", Status.FAIL);
						throw new RuntimeException("Failed in step 22");
					}
					
					try {
						AddEntityType(map.get(Excel.EntityType));
						log("STEP 23: User can enter the value in Entity Type field ", Status.PASS);
					} catch (Exception e) {
						log("STEP 23:  User cannot enter the value in Entity Type field", Status.FAIL);
						throw new RuntimeException("Failed in step 23");
					}
					
					 if(util.isElementPresent(drpGender)) {
					try {
						SelectGender(map.get(Excel.Gender));
						log("STEP 24: User can enter the value in Gender field ", Status.PASS);
					} catch (Exception e) {
						log("STEP 24:  User cannot enter the value in Gender field", Status.FAIL);
						throw new RuntimeException("Failed in step 24");
					}
					 }
						
					 if(!environment.contains("WOLFMIDSTREAM")) {
						try {
							AddVendor(map.get(Excel.Vendor));
							log("STEP 25: User can enter the value in Vendor field ", Status.PASS);
						} catch (Exception e) {
							log("STEP 25:  User cannot enter the value in Vendor field", Status.FAIL);
							throw new RuntimeException("Failed in step 25");
						}
					 }
					
					try {
						AddAddressLine1(map.get(Excel.AddressLine1));
						log("STEP 26: User can enter the value in Address Line1 field ", Status.PASS);
					} catch (Exception e) {
						log("STEP 26:  User cannot enter the value in Address Line1 field", Status.FAIL);
						throw new RuntimeException("Failed in step 26");
					}
					
					try {
						AddAddressLine2(map.get(Excel.AddressLine2));
						log("STEP 27: User can enter the value in Address Line2 field ", Status.PASS);
					} catch (Exception e) {
						log("STEP 27:  User cannot enter the value in Address Line2 field", Status.FAIL);
						throw new RuntimeException("Failed in step 27");
					}
					

					try {
						AddCity(map.get(Excel.City));
						log("STEP 28: User can enter the value in City field ", Status.PASS);
					} catch (Exception e) {
						log("STEP 28:  User cannot enter the value in City field", Status.FAIL);
						throw new RuntimeException("Failed in step 28");
					}
					
					try {
						SelectStateContact(map.get(Excel.State));
						log("STEP 29: User can enter the value in State field ", Status.PASS);
					} catch (Exception e) {
						log("STEP 29:  User cannot enter the value in State field", Status.FAIL);
						throw new RuntimeException("Failed in step 29");
					}
					
					try {
						AddZipCode(map.get(Excel.ZipCode));
						log("STEP 30: User can enter the value in Zip Code field ", Status.PASS);
					} catch (Exception e) {
						log("STEP 30:  User cannot enter the value in Zip Code field", Status.FAIL);
						throw new RuntimeException("Failed in step 30");
					}
					
					try {
						AddAddressLine3(map.get(Excel.AddressLine3));
						log("STEP 32: User can enter the value in Address Line3 field ", Status.PASS);
					} catch (Exception e) {
						log("STEP 32:  User cannot enter the value in Address Line3 field", Status.FAIL);
						throw new RuntimeException("Failed in step 32");
					}
					
					try {
						AddEmail(map.get(Excel.Email));
						log("STEP 33: User can enter the value in Email field ", Status.PASS);
					} catch (Exception e) {
						log("STEP 33:  User cannot enter the value in Email field", Status.FAIL);
						throw new RuntimeException("Failed in step 33");
					}
					
					try {
						AddHomePhone(map.get(Excel.HomePhone));
						log("STEP 34: User can enter the value in Home Phone field ", Status.PASS);
					} catch (Exception e) {
						log("STEP 34:  User cannot enter the value in Home Phone field", Status.FAIL);
						throw new RuntimeException("Failed in step 34");
					}
					
					try {
						AddCellPhone(map.get(Excel.CellPhone));
						log("STEP 35: User can enter the value in CellPhone field ", Status.PASS);
					} catch (Exception e) {
						log("STEP 35:  User cannot enter the value in CellPhone field", Status.FAIL);
						throw new RuntimeException("Failed in step 35");
					}
					
					try {
						AddWorkPhone(map.get(Excel.WorkPhone));
						log("STEP 36: User can enter the value in Work Phone field ", Status.PASS);
					} catch (Exception e) {
						log("STEP 36:  User cannot enter the value in Work Phone field", Status.FAIL);
						throw new RuntimeException("Failed in step 36");
					}
					
					try {
							AddFaxPhone(map.get(Excel.CellPhone));
							log("STEP 37: User can enter the value in Cell Phone field ", Status.PASS);
						} catch (Exception e) {
							log("STEP 37:  User cannot enter the value in Cell Phone field", Status.FAIL);
							throw new RuntimeException("Failed in step 37");
						}
					
					
					try {
						ClickOnInsertButton();
						log("STEP 38: Added address displays in the grid", Status.PASS);
					} catch (Exception e) {
						log("STEP 38: Added record does not display in the grid", Status.FAIL);
						throw new RuntimeException("Failed in step 38");
					}
					
					util.dummyWait(3);	
					
					try {
						AddandApplyFilter(map.get(Excel.SelectFilter));
						log("STEP 39: User should able to see the verious Filter option ", Status.PASS);
					} catch (Exception e) {
						log("STEP 39: Veripous Filter options not display", Status.FAIL);
						throw new RuntimeException("Failed in step 39");
					}
					
					try {
//						 RemoveFilter();
						 util.dummyWait(1);
						ClickOnEditButton();
						util.dummyWait(2);
						log("STEP 40: Existing User record should be open  ", Status.PASS);
					} catch (Exception e) {
						log("STEP 40: Existing User record should not be open", Status.FAIL);
						throw new RuntimeException("Failed in step 40");
					}
					
					try {
						Updatevalue(map.get(Excel.UpdatedComment));
						log("STEP 41: User can update a value in the field/s   ", Status.PASS);
					} catch (Exception e) {
						log("STEP 41: User cannot update a value in the field/s ", Status.FAIL);
						throw new RuntimeException("Failed in step 41");
					}
					
					try {
						ClickOnUpdateButton();
						log("STEP 42: User can update a value in the field/s  ", Status.PASS);
					} catch (Exception e) {
						log("STEP 42: User cannot update a value in the field/s", Status.FAIL);
						throw new RuntimeException("Failed in step 42");
					}
					
					util.dummyWait(2);
				 }
				 else {
					 log("Contact Details  Panel not visible");
					 
					 try {
							ClickOnInsertButton();
							log("STEP 17: Added address displays in the grid", Status.PASS);
						} catch (Exception e) {
							log("STEP 17: Added record does not display in the grid", Status.FAIL);
							throw new RuntimeException("Failed in step 17");
						}
				 }
				 
            if(!environment.contains("WOLFMIDSTREAM") &  !environment.contains("NEXTERA")) {
				 try {
					 commonFunction.navigateToProjectDeails();
						log("STEP 43: User can navigate to Project Details Page ", Status.PASS);
					} catch (Exception e) {
						log("STEP 34: User cannot navigate to Project Details Page", Status.FAIL);
						throw new RuntimeException("Failed in step 43 ");
					}
				 
				 try {
						util.click(PrjectPermit);
						log("STEP 44: User can expand Project Permit panel", Status.PASS);
					} catch (Exception e) {
						log("STEP 44: User cannot expand Project Permit panel ", Status.FAIL);
						throw new RuntimeException("Failed in step 44");
					}
				 
					
					try {
						clickOnAddNewRecord();
						log("STEP 45: User can click on Add new record button of Project Permit panel", Status.PASS);
					} catch (Exception e) {
						log("STEP 45: User cannot click on Add new record button of Project Permit panel ", Status.FAIL);
						throw new RuntimeException("Failed in step 45");
					}
					
					try {
						util.click(drpAgencyName);
						By agencyName = By.xpath("(//div[contains(@id,'_EditFormControl_AGENCY_ID_radYALDropDownList_DropDown')]/..//li[contains(text(),'"+NAME+"')])[1]");
						Assert.assertTrue(util.isElementVisible(agencyName));
						log("STEP 46: User can see added Permit Agency Name in the Agency Name DD", Status.PASS);
					} catch (AssertionError e) {
						log("STEP 46: User cannot see added Permit Agency Name in the Agency Name DD", Status.FAIL);
					}
            }
            
					try {
						NavigateToPermitInformation();
						log("STEP 47:  User can Navigate to Permit Agencies", Status.PASS);
					} catch (Exception e) {
						log("STEP 47: User cannot Navigate to Permit Agencies", Status.FAIL);
						throw new RuntimeException("Failed in step 47");
					}
					
					 try {
						 AddandApplyFilter(map.get(Excel.SelectFilter));
						 util.dummyWait(2);
						 ClickOnDeleteButton();
							log("STEP 48:  Popup Delete should be open with OK and Cancel button    ", Status.PASS);
						} catch (Exception e) {
							log("STEP 48:  Popup Delete does not open", Status.FAIL);
							throw new RuntimeException("Failed in step 48 ");
						}

					 try {
						 ClickonCancle();
							log("STEP 49: User can click on cancel button  ", Status.PASS);
						} catch (Exception e) {
							log("STEP 49: User cannot click on cancel button", Status.FAIL);
							throw new RuntimeException("Failed in step 49");
						}
					 
					 try {
						 ClickonOk();
							log("STEP 50: Deleted record does not display in the grid and 2)Message- Changes saved suessfully! in green displays. ", Status.PASS);
						} catch (Exception e) {
							log("STEP 50: Message- Changes saved sucessfully' does not display", Status.FAIL);
							throw new RuntimeException("Failed in step 50");
						
						}
				
			 }
			 
			 else
				 
			 {
				 try {
						ClickOnContactDetail();
						log("STEP 17: Add new popup display with blank fields", Status.PASS);
					} catch (Exception e) {
						log("STEP 17: Popup up does not appear", Status.FAIL);
						throw new RuntimeException("Failed in step 17");
					}
                     
				 util.dummyWait(3);
				 if(util.isElementPresent(txtLastName)) {
					try {
						AddLastName(map.get(Excel.LastName));
						log("STEP 18:   Added value displays in the Last Name field :", Status.PASS);
					} catch (Exception e) {
						log("STEP 18:   Added value does not displays in the Last Name field", Status.FAIL);
						throw new RuntimeException("Failed in step 18");
					}
			 }
			 
				 if(util.isElementPresent(txtFirstName)) {
					try {
						AddFirstName(map.get(Excel.FirstName));
						log("STEP 19: User can enter the value in First Name field ", Status.PASS);
					} catch (Exception e) {
						log("STEP 19:  User cannot enter the value in First Name field", Status.FAIL);
						throw new RuntimeException("Failed in step 19");
					}
				 }
				 
				 if(util.isElementPresent(txtMiddleName)) {
					try {
						AddMiddleName(map.get(Excel.MiddleName));
						log("STEP 20: User can enter the value in Lookup Value field ", Status.PASS);
					} catch (Exception e) {
						log("STEP 20:  User cannot enter the value in Lookup Value field", Status.FAIL);
						throw new RuntimeException("Failed in step 20");
					}
				 }
				 
				 if(util.isElementPresent(txtTitle)) {
					try {
						AddTitle(map.get(Excel.Title));
						log("STEP 21: User can enter the value in Title field ", Status.PASS);
					} catch (Exception e) {
						log("STEP 21:  User cannot enter the value in Title field", Status.FAIL);
						throw new RuntimeException("Failed in step 21");
					}
				 }
				 
					try {
						AddEntityName(map.get(Excel.EntityName));
						log("STEP 22: User can enter the value in Entity Name field ", Status.PASS);
					} catch (Exception e) {
						log("STEP 22:  User cannot enter the value in Entity Name field", Status.FAIL);
						throw new RuntimeException("Failed in step 22");
					}
					
					try {
						AddEntityType(map.get(Excel.EntityType));
						log("STEP 23: User can enter the value in Entity Type field ", Status.PASS);
					} catch (Exception e) {
						log("STEP 23:  User cannot enter the value in Entity Type field", Status.FAIL);
						throw new RuntimeException("Failed in step 23");
					}
					
					if(util.isElementPresent(txtSuffix)) {
					try {
						AddSuffix(map.get(Excel.Suffix));
						log("STEP 24: User can enter the value in Suffix field ", Status.PASS);
					} catch (Exception e) {
						log("STEP 24:  User cannot enter the value in Suffix field", Status.FAIL);
						throw new RuntimeException("Failed in step 24");
					}
					}
					
					try {
						AddCOName(map.get(Excel.COName));
						log("STEP 25: User can enter the value in CO Name field ", Status.PASS);
					} catch (Exception e) {
						log("STEP 25:  User cannot enter the value in CO Name field", Status.FAIL);
						throw new RuntimeException("Failed in step 25");
					}
					
					if(testcaseName.contains("ALT")|| testcaseName.contains("ORION") || testcaseName.contains("ATWELL")) {
						 if(util.isElementPresent(drpGender)) {
					try {
						SelectGender(map.get(Excel.Gender));
						log("STEP 26: User can enter the value in Gender field ", Status.PASS);
					} catch (Exception e) {
						log("STEP 26:  User cannot enter the value in Gender field", Status.FAIL);
						throw new RuntimeException("Failed in step 26");
					}
						 }
				}
					
					
					if(testcaseName.contains("ALT") || testcaseName.contains("ORSTED") || testcaseName.contains("ORION") || testcaseName.contains("ATWELL")) {
						
						try {
							AddVendor(map.get(Excel.Vendor));
							log("STEP 27: User can enter the value in Vendor field ", Status.PASS);
						} catch (Exception e) {
							log("STEP 27:  User cannot enter the value in Vendor field", Status.FAIL);
							throw new RuntimeException("Failed in step 27");
						}
					}
						
					
					try {
						AddAddressLine1(map.get(Excel.AddressLine1));
						log("STEP 28: User can enter the value in Address Line1 field ", Status.PASS);
					} catch (Exception e) {
						log("STEP 28:  User cannot enter the value in Address Line1 field", Status.FAIL);
						throw new RuntimeException("Failed in step 28");
					}
					
					try {
						AddAddressLine2(map.get(Excel.AddressLine2));
						log("STEP 29: User can enter the value in Address Line2 field ", Status.PASS);
					} catch (Exception e) {
						log("STEP 29:  User cannot enter the value in Address Line2 field", Status.FAIL);
						throw new RuntimeException("Failed in step 29");
					}
					

					try {
						AddCity(map.get(Excel.City));
						log("STEP 30: User can enter the value in City field ", Status.PASS);
					} catch (Exception e) {
						log("STEP 30:  User cannot enter the value in City field", Status.FAIL);
						throw new RuntimeException("Failed in step 30");
					}
					
					try {
						SelectStateContact(map.get(Excel.State));
						log("STEP 31: User can enter the value in State field ", Status.PASS);
					} catch (Exception e) {
						log("STEP 31:  User cannot enter the value in State field", Status.FAIL);
						throw new RuntimeException("Failed in step 31");
					}
					
					try {
						AddZipCode(map.get(Excel.ZipCode));
						log("STEP 32: User can enter the value in Zip Code field ", Status.PASS);
					} catch (Exception e) {
						log("STEP 32:  User cannot enter the value in Zip Code field", Status.FAIL);
						throw new RuntimeException("Failed in step 32");
					}
					
					try {
						AddAddressLine3(map.get(Excel.AddressLine3));
						log("STEP 34: User can enter the value in Address Line3 field ", Status.PASS);
					} catch (Exception e) {
						log("STEP 34:  User cannot enter the value in Address Line3 field", Status.FAIL);
						throw new RuntimeException("Failed in step 34");
					}
					
					try {
						AddEmail(map.get(Excel.Email));
						log("STEP 35: User can enter the value in Email field ", Status.PASS);
					} catch (Exception e) {
						log("STEP 35:  User cannot enter the value in Email field", Status.FAIL);
						throw new RuntimeException("Failed in step 35");
					}
					
					try {
						AddHomePhone(map.get(Excel.HomePhone));
						log("STEP 36: User can enter the value in Home Phone field ", Status.PASS);
					} catch (Exception e) {
						log("STEP 36:  User cannot enter the value in Home Phone field", Status.FAIL);
						throw new RuntimeException("Failed in step 36");
					}
					
					try {
						AddCellPhone(map.get(Excel.CellPhone));
						log("STEP 37: User can enter the value in CellPhone field ", Status.PASS);
					} catch (Exception e) {
						log("STEP 37:  User cannot enter the value in CellPhone field", Status.FAIL);
						throw new RuntimeException("Failed in step 37");
					}
					
					if(util.isElementVisible(txtWorkPhone)) {
					try {
						AddWorkPhone(map.get(Excel.WorkPhone));
						log("STEP 38: User can enter the value in Work Phone field ", Status.PASS);
					} catch (Exception e) {
						log("STEP 38:  User cannot enter the value in Work Phone field", Status.FAIL);
						throw new RuntimeException("Failed in step 38");
					}}
					
					
					try {
						AddInterationalPhone(map.get(Excel.InternationalPhone));
						log("STEP 39: User can enter the value in International Phone field ", Status.PASS);
					} catch (Exception e) {
						log("STEP 39:  User cannot enter the value in International Phone field", Status.FAIL);
						throw new RuntimeException("Failed in step 39");
					}
					
					if(testcaseName.contains("ALT") || testcaseName.contains("ORSTED") || testcaseName.contains("ORION") || testcaseName.contains("ATWELL")) {
						try {
							AddFaxPhone(map.get(Excel.CellPhone));
							log("STEP 40: User can enter the value in Cell Phone field ", Status.PASS);
						} catch (Exception e) {
							log("STEP 40:  User cannot enter the value in Cell Phone field", Status.FAIL);
							throw new RuntimeException("Failed in step 40");
						}
					}
						
					if(util.isElementPresent(txtSecLastName)) {
					try {
						AddSecondaryLastName(map.get(Excel.LastName));
						log("STEP 41: User can enter the value in  Secondary Last Name  field ", Status.PASS);
					} catch (Exception e) {
						log("STEP 41:  User cannot enter the value in  Secondary Last Name field", Status.FAIL);
						throw new RuntimeException("Failed in step 41");
					}
					}
					
					if(util.isElementPresent(txtSecFirstName)) {
					try {
						AddSecondaryFirstName(map.get(Excel.FirstName));
						log("STEP 42: User can enter the value in  Secondary First Name  field ", Status.PASS);
					} catch (Exception e) {
						log("STEP 42:  User cannot enter the value in  Secondary First Name field", Status.FAIL);
						throw new RuntimeException("Failed in step 42");
					}}
					
					
					if(util.isElementPresent(txtSecMiddleName)) {
					try {
						AddSecondaryMiddleName(map.get(Excel.MiddleName));
						log("STEP 43: User can enter the value in  Secondary Middle Name  field ", Status.PASS);
					} catch (Exception e) {
						log("STEP 43:  User cannot enter the value in  Secondary Middle Name  field", Status.FAIL);
						throw new RuntimeException("Failed in step 43");
					}
					}
					
					try {
						ClickOnInsertButton();
						log("STEP 44: Added address displays in the grid", Status.PASS);
					} catch (Exception e) {
						log("STEP 44: Added record does not display in the grid", Status.FAIL);
						throw new RuntimeException("Failed in step 44");
					}
					
					util.dummyWait(2);
					try {
						ClickOnCancelButton();
						log("STEP 45: User should not be created and Window get  closed ", Status.PASS);
					} catch (Exception e) {
						log("STEP 45: Window should not be closed", Status.FAIL);
						throw new RuntimeException("Failed in step 45");
					}
					
                     util.dummyWait(3);	
					
					try {
						AddandApplyFilter(map.get(Excel.SelectFilter));
						log("STEP 46: User should able to see the verious Filter option ", Status.PASS);
					} catch (Exception e) {
						log("STEP 46: Veripous Filter options not display", Status.FAIL);
						throw new RuntimeException("Failed in step 46");
					}
					
					util.dummyWait(3);
					try {
						ClickOnEditButton();
						log("STEP 47: User can click on Edit button  ", Status.PASS);
					} catch (Exception e) {
						log("STEP 47: User cannot click on Edit button", Status.FAIL);
						throw new RuntimeException("Failed in step 47");
					}
					util.dummyWait(2);
					try {
						Updatevalue(map.get(Excel.UpdatedComment));
						log("STEP 48: User can update a value in the Comments field/s   ", Status.PASS);
					} catch (Exception e) {
						log("STEP 48: User cannot update a value in the Comments  field/s ", Status.FAIL);
						throw new RuntimeException("Failed in step 48");
					}
					
					try {
						ClickOnUpdateButton();
						log("STEP 49: User can click on update button ", Status.PASS);
					} catch (Exception e) {
						log("STEP 49: User cannot click on update button", Status.FAIL);
						throw new RuntimeException("Failed in step 49");
					}
					
					if(!testcaseName.contains("DOT") & !environment.contains("NEXTERA")) {
					try {
						 commonFunction.navigateToProjectDeails();
							log("STEP 50: User can navigate to Project Details Page ", Status.PASS);
						} catch (Exception e) {
							log("STEP 50: User cannot navigate to Project Details Page", Status.FAIL);
							throw new RuntimeException("Failed in step 50 ");
						}
					 
					 try {
							util.click(PrjectPermit);
							log("STEP 51: User can expand Project Permit panel", Status.PASS);
						} catch (Exception e) {
							log("STEP 51: User cannot expand Project Permit panel ", Status.FAIL);
							throw new RuntimeException("Failed in step 51");
						}
					 
						
						try {
							clickOnAddNewRecord();
							log("STEP 52: User can click on Add new record button of Project Permit panel", Status.PASS);
						} catch (Exception e) {
							log("STEP 52: User cannot click on Add new record button of Project Permit panel ", Status.FAIL);
							throw new RuntimeException("Failed in step 52");
						}
						
						try {
							util.click(drpAgencyName);
							By agencyName = By.xpath("//div[contains(@id,'_EditFormControl_AGENCY_ID_radYALDropDownList_DropDown')]/..//li[text()='"+NAME+"']");
							Assert.assertTrue(util.isElementVisible(agencyName));
							log("STEP 53: User can see added Permit Agency Name in the Agency Name DD", Status.PASS);
						} catch (AssertionError e) {
							log("STEP 53: User cannot see added Permit Agency Name in the Agency Name DD", Status.FAIL);
						}
						
						try {
							NavigateToPermitInformation();
							 AddandApplyFilter(map.get(Excel.SelectFilter));
							log("STEP 54:  User can Navigate to Permit Agencies", Status.PASS);
						} catch (Exception e) {
							log("STEP 54: User cannot Navigate to Permit Agencies", Status.FAIL);
							throw new RuntimeException("Failed in step 54");
						}
					}
					util.dummyWait(2);
					 try {
						 ClickOnDeleteButton();
							log("STEP 55:  Popup Delete should be open with OK and Cancel button    ", Status.PASS);
						} catch (Exception e) {
							log("STEP 55:  Popup Delete does not open", Status.FAIL);
							throw new RuntimeException("Failed in step 55 ");
						}
				 
					 
					 
					 try {
						 ClickonCancle();
							log("STEP 56: User can click on cancel button  ", Status.PASS);
						} catch (Exception e) {
							log("STEP 56: User cannot click on cancel button", Status.FAIL);
							throw new RuntimeException("Failed in step 56");
						}
					 
					 try {
						 ClickonOk();
							log("STEP 57: Deleted record does not display in the grid and 2)Message- Changes saved suessfully! in green displays. ", Status.PASS);
						} catch (Exception e) {
							log("STEP 57: Message- Changes saved sucessfully' does not display", Status.FAIL);
							throw new RuntimeException("Failed in step 57");
						}	
			 }
			
			
				
					
	 }		

}
