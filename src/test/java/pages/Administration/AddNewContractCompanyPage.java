package pages.Administration;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

public class AddNewContractCompanyPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;
	public String NAME;

	public AddNewContractCompanyPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	
	By navAdministration = By.xpath("//span[text()='Administration']");
	By navConfiguration = By.xpath("//span[text()='Configuration']");
	By navContractCompanies = By.xpath("//span[contains(text(),'Contract Companies')]");
	By btnAddNewRecord = By.xpath("(//a[contains(@id,'lnkAddNewRecord')])");
	By ProvideInfo = By.xpath("//span[contains(text(),'Provide Info')]");
	By ProviderInfo = By.xpath("//span[contains(text(),'Provider Info')]");
	By txtName = By.xpath("//input[contains(@id,'EditFormControl_Name') and @type='text']");
	By ActiveCheckbox = By.xpath("//input[contains(@id,'EditFormControl_Active_ind') and @type='checkbox']");
	By txtAgreementDate = By.xpath("//input[contains(@id,'EditFormControl_Agreement_Date_dateInput') and @type='text']");
    By ServicesCheckbox = By.xpath("(//input[@class='rlbCheck'])[2]");
    By btnInsert = By.xpath("//input[contains(@id,'EditFormControl_btnInsert')]");
    By btnInsertDot = By.xpath("//input[contains(@value,'Insert') and @type='submit']");
  	By SuccessMessage = By.xpath("//span[text()='Changes saved successfully!']");
  	By btnCancel = By.xpath("//input[contains(@id,'EditFormControl_btnCancel') ]");
  	By btnEdit = By.xpath("(//input[contains(@id,'EditButton')])[last()]");
  	By btnUpdate = By.xpath("//input[contains(@id,'EditFormControl_btnUpdate')]"); 
    By PrimaryContact = By.xpath("//span[contains(text(),'Primary Contact')]");
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
	By drpState = By.xpath("//input[contains(@id,'PrimaryContact_RadState_Input') and @type='text']");
	By txtZipCode = By.xpath("(//input[contains(@id,'_PrimaryContact_Zip_Code') and @type='text'])[1]");
    By txtZipCodePlus = By.xpath("(//input[contains(@id,'_Zip_Code_Plus') and @type='text'])[1]");
	By txtAddressLine3 = By.xpath("(//input[contains(@id,'_Address_Line_3') and @type='text'])[1]");
    By txtEmail = By.xpath("(//input[contains(@id,'PrimaryContact_Email') and @type='text'])[1]");
	By txtHomePhone = By.xpath("(//input[contains(@id,'PrimaryContact_Home_Phone') and @type='text'])[1]");
	By txtCellPhone = By.xpath("//input[contains(@id,'PrimaryContact_Cell_Phone') and @type='text']");
	By txtWorkPhone = By.xpath("//input[contains(@id,'PrimaryContact_Work_Phone') and @type='text']");
    By txtInterationalPhone = By.xpath("(//input[contains(@id,'PrimaryContact_Intl_Phone') and @type='text'])[1]");
	By txtFaxPhone  = By.xpath("//input[contains(@id,'PrimaryContact_FAX_NUMBER') and @type='text']");
	By txtSecLastName = By.xpath("//input[contains(@id,'SecondaryContact_Last_Name') and @type='text']");
	By txtSecFirstName = By.xpath("//input[contains(@id,'SecondaryContact_First_Name') and @type='text']");
	By txtSecMiddleName = By.xpath("//input[contains(@id,'SecondaryContact_Middle_Name') and @type='text']");
	By btnDelete = By.xpath("(//input[contains(@id,'gbcDeleteAlignment')])[last()]");
	By btncancel = By.xpath("//span[text()='Cancel']");
	By btnOk = By.xpath("//span[text()='OK']");
	By drpContractCompany = By.xpath("//input[contains(@id,'_svc_Provider_ID_radYALDropDownList_Input') and @type='text']");
  	
  	public void ClickOnProvideInfo() {
  		util.waitUntilElementDisplay(navAdministration);
  		util.click(navAdministration);
  		util.waitUntilElementDisplay(navConfiguration);
  		util.click(navConfiguration);
  		util.waitUntilElementDisplay(navContractCompanies);
  		util.click(navContractCompanies);
  		util.waitUntilElementDisplay(btnAddNewRecord);
  		util.click(btnAddNewRecord);
  		util.waitUntilElementDisplay(ProvideInfo);
  		util.click(ProvideInfo);
  		
  	}
  	
  	By navVendorManagement = By.xpath("//span[contains(text(),'Vendor Management')]");
  	public void NavigateToVendorManagement() {
  		util.waitUntilElementDisplay(navAdministration);
  		util.click(navAdministration);
  		util.waitUntilElementDisplay(navConfiguration);
  		util.click(navConfiguration);
  		util.waitFor(200);
  		util.waitUntilElementDisplay(navVendorManagement);
  		util.click(navVendorManagement);
  	}
  	
  	public void ClickOnProvideInfoDOT() {
  		util.waitUntilElementDisplay(btnAddNewRecord);
  		util.click(btnAddNewRecord);	
  	}
  	
  	public void AddName(String value) {
  		if (!commonFunction.checkNA(value)) 
			util.inputTextAndPressTab(txtName, value);
  	}
  	
  	public void ClickOnActiveCheckbox() {
  		util.waitUntilElementDisplay(ActiveCheckbox);
  		util.click(ActiveCheckbox);
  	}
  	
  	public void AddAgreementDate(String value) {
  		if (!commonFunction.checkNA(value)) 
			util.inputTextAndPressTab(txtAgreementDate, value);
  	}
  	
  	public void ClickOnServicesCheckbox() {
  		util.waitUntilElementDisplay(ServicesCheckbox);
  		util.click(ServicesCheckbox);
  	}
	
	public void ClickOnCancelButton() {
		util.waitUntilElementDisplay(btnAddNewRecord);
		util.click(btnAddNewRecord);
		util.dummyWait(1);
		util.waitUntilElementDisplay(btnCancel);
		util.click(btnCancel);
		util.dummyWait(3);

	}
	
	public void ClickOnUpdateButton() {
		util.waitUntilElementDisplay(btnUpdate);
		util.click(btnUpdate);
		util.dummyWait(1);

	}
	
	By PrimaryACM = By.xpath("//a[contains(@id,'EditFormControl_Contract_Primary_ACM_ID_YALComboBox_Arrow')]");
	public void SelectPrimaryACM(String value) {
		if (!commonFunction.checkNA(value)) 
			util.selectValueFromDropdown(PrimaryACM, value);
  	}
    
	public void ClickOnPrimaryContact() {
		util.waitUntilElementDisplay(PrimaryContact);
		util.click(PrimaryContact);
	}
	
	public void ClickOnPrimaryContactDOT() {
		util.waitUntilElementDisplay(btnEdit);
		util.click(btnEdit);
		util.waitUntilElementDisplay(PrimaryContact);
		util.click(PrimaryContact);
	}

	By navManageContact = By.xpath("(//a[contains(text(),'Manage Contact(s)')])[last()]");
	public void ClickOnContactDetailROW() {
		util.waitUntilElementDisplay(navManageContact);
		util.click(navManageContact);
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
	
	public void ClickOnInsertButtonDOT() {
		util.waitUntilElementDisplay(btnInsertDot);
		util.click(btnInsertDot);
		util.dummyWait(1);
	}
	
	public void ClickOnEditButton() {
		util.waitUntilElementDisplay(btnEdit);
		util.click(btnEdit);
		util.dummyWait(2);
		util.waitUntilElementDisplay(PrimaryContact);
		util.click(PrimaryContact);
		util.dummyWait(1);
	}
	
	public void ClickOnEditButtonRow() {
		util.waitUntilElementDisplay(btnEdit);
		util.click(btnEdit);
		util.dummyWait(1);
	}
	
	public void Updatevalue(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtAddressLine3, value);
		util.dummyWait(1);
	}
	
	public void ClickOnDeleteButton() {
		util.waitUntilElementDisplay(btnDelete);
		util.click(btnDelete);
		util.waitFor(200);
	}
	
	 public void ClickonCancle()  {
	  		util.waitUntilElementDisplay(btncancel);
	  		util.click(btncancel);
	  		util.waitFor(500);
	    }
	 
	 public void ClickOnCancleRow() {
		 util.dummyWait(1);
			driver.switchTo().alert().dismiss();
		}
		
		 public void ClickonOkRow()  {	
			 driver.switchTo().alert().accept();
		
		 }

	 public void ClickonOk()  {
		    util.waitUntilElementDisplay(btnDelete);
	  		util.click(btnDelete);	
	  		util.waitUntilElementDisplay(btnOk);
	  		util.click(btnOk);
	  		util.waitUntilElementDisplay(SuccessMessage);
			Assert.assertTrue(util.isElementPresent(SuccessMessage), "Changes saved successfully!");
	    }
	 
	 
	
	 By ProjectManager = By.xpath("//input[contains(@id,'Primary_Contact_ID_YALComboBox_Input')]");
	 public void SelectProjectManager(String value) {
		 if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(ProjectManager, value);
	 }
	 
	 By AddressLine1 = By.xpath("(//input[contains(@id,'PrimaryContAddress_Address_Line_1') and @type='text'])[1]");
	 By AddressLine2 = By.xpath("(//input[contains(@id,'PrimaryContAddress_Address_Line_2') and @type='text'])[1]");
     By City = By.xpath("(//input[contains(@id,'PrimaryContAddress_City') and @type='text'])[1]");
     By State = By.xpath("(//input[contains(@id,'PrimaryContAddress_STATE_ID_Input') and @type='text'])[1]");
	 By ZipCode = By.xpath("(//input[contains(@id,'PrimaryContAddress_Zip_Code') and @type='text'])[1]");
	 By ZipcodePlus = By.xpath("(//input[contains(@id,'PrimaryContAddress_Zip_Code_Plus') and @type='text'])[1]");
	 By AddressLine3 = By.xpath("(//input[contains(@id,'PrimaryContAddress_Address_Line_3') and @type='text'])[1]");
	
     public void AddAddressLine1Dot(String value) {
     	if (!commonFunction.checkNA(value))
 			util.inputTextAndPressTab(AddressLine1, value);
     }
     
     public void AddAddressLine2Dot(String value) {
     	if (!commonFunction.checkNA(value))
 			util.inputTextAndPressTab(AddressLine2, value);
     }
     
     public void AddCityDot(String value) {
     	if (!commonFunction.checkNA(value))
 			util.inputTextAndPressTab(City, value);
     }
     
     public void SelectStateDot(String value) {
     	if (!commonFunction.checkNA(value))
 			util.inputTextAndPressTab(State, value);
     }
     
     public void AddZipCodeDot(String value) {
     	if (!commonFunction.checkNA(value))
 			util.inputTextAndPressTab(ZipCode, value);
     }
     
     public void AddZipCodePlusDot(String value) {
     	if (!commonFunction.checkNA(value))
 			util.inputTextAndPressTab(ZipcodePlus, value);
     }
     
     public void AddAddressLine3Dot(String value) {
     	if (!commonFunction.checkNA(value))
 			util.inputTextAndPressTab(AddressLine3, value);
     } 
     
     By navAddminitstration = By.xpath("//a//span[@class='rmText rmExpandDown' and contains(text(),'Administration')] ");
 	By navSecurity = By.xpath("//a//span[@class='rmText rmExpandRight' and contains(text(),'Security')]");
 	By navUserAccount = By.xpath("//a//span[@class='rmText' and contains(text(),'User Accounts')]");
 	
 	public void navigateUserAccount() {
 		util.waitUntilElementDisplay(navAddminitstration);
 		util.click(navAddminitstration);
 		util.waitUntilElementDisplay(navSecurity);
 		util.click(navSecurity);
 		util.waitUntilElementDisplay(navUserAccount);
 		util.click(navUserAccount);
 	}
 	
	public void AddNewContractCompany(Map<String, String> map, String testcaseName) {
		if(testcaseName.contains("DOT")) {
			try {
				NavigateToVendorManagement();
				ClickOnProvideInfoDOT();
				log("STEP 1: Add new popup display with blank fields", Status.PASS);
			} catch (Exception e) {
				log("STEP 1: Popup up does not appear", Status.FAIL);
				throw new RuntimeException("Failed in step 1: Popup up does not appear");
			}
		}
		  else
		{
			try {
				ClickOnProvideInfo();
				log("STEP 1: Add new popup display with blank fields", Status.PASS);
			} catch (Exception e) {
				log("STEP 1: Popup up does not appear", Status.FAIL);
				throw new RuntimeException("Failed in step 1: Popup up does not appear");
			}
		}

		try {
			AddName(map.get(Excel.Name));
			NAME = map.get(Excel.Name);
			log("STEP 2:   User can enter the value in Name field", Status.PASS);
		} catch (Exception e) {
			log("STEP 2:    User cannot enter the value in Name field", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}
		
		if(!testcaseName.contains("DOT")) {
		try {
			ClickOnActiveCheckbox();
			log("STEP 3: Active Check box should be checked   ", Status.PASS);
		} catch (Exception e) {
			log("STEP 3: Active Check box should not be checked  ", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}
		}
		
		try {
			AddAgreementDate(map.get(Excel.AgreementDate));
			log("STEP 4: User can enter the value in Agreement Date field", Status.PASS);
		} catch (Exception e) {
			log("STEP 4: User cannot enter the value in Agreement Date field", Status.FAIL);
			throw new RuntimeException("Failed in step 4");
		}
		
		if(testcaseName.contains("DOT")) {
			try {
				ClickOnServicesCheckbox();
				log("STEP 5: Services Check box should be checked   ", Status.PASS);
			} catch (Exception e) {
				log("STEP 5: Services Check box shouldnot be checked   ", Status.FAIL);
				throw new RuntimeException("Failed in step 5");
			}
			
			try {
				SelectPrimaryACM(map.get(Excel.PrimaryACM));
				log("STEP 6: User can select Primary ACM  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 6: User cannot select Primary ACM  ", Status.FAIL);
				throw new RuntimeException("Failed in step 6");
			}
			
		}
		else {
		try {
			ClickOnServicesCheckbox();
			log("STEP 5: Services Check box should be checked   ", Status.PASS);
		} catch (Exception e) {
			log("STEP 5: Services Check box shouldnot be checked   ", Status.FAIL);
			throw new RuntimeException("Failed in step 5");
		}
	}
		
		 if(testcaseName.contains("ROW") || testcaseName.contains("DOM")) {
			 
			 try {
					ClickOnInsertButton();
					log("STEP 6: User can click on Insert button", Status.PASS);
				} catch (Exception e) {
					log("STEP 6: User cannot click on Insert button", Status.FAIL);
					throw new RuntimeException("Failed in step 6");
				}
				
			 
				if (util.isElementPresent(SuccessMessage)) {
					   log("STEP 7 :Changes saved sucessfully ! message will be display in green color.   ", Status.PASS);
					} else {
					   log("STEP 7:  Success message does not display"  , Status.FAIL);
				      throw new RuntimeException("Faild in STEP 7 ");
			   	}
				
				if(util.isElementVisible(navManageContact)) {
			 try {
					ClickOnContactDetailROW();
					log("STEP 8: User can click on Manage Contact link", Status.PASS);
				} catch (Exception e) {
					log("STEP 8: User cannot click on Manage Contact link", Status.FAIL);
					throw new RuntimeException("Failed in step 8");
				}
			 
			 Set<String> windowId = driver.getWindowHandles(); // get window id of current window
				Iterator<String> itererator = windowId.iterator();
				String mainWinID = itererator.next();
				String newAdwinID = itererator.next();
				driver.switchTo().window(newAdwinID);

				try {
					util.click(btnAddNewRecord);
					AddLastName(map.get(Excel.LastName));
					log("STEP 9:   Added value displays in the Last Name field :", Status.PASS);
				} catch (Exception e) {
					log("STEP 9:   Added value does not displays in the Last Name field", Status.FAIL);
					throw new RuntimeException("Failed in step 9");
				}
				try {
					AddFirstName(map.get(Excel.FirstName));
					log("STEP 10: User can enter the value in First Name field ", Status.PASS);
				} catch (Exception e) {
					log("STEP 10:  User cannot enter the value in First Name field", Status.FAIL);
					throw new RuntimeException("Failed in step 10");
				}
				
				try {
					AddMiddleName(map.get(Excel.MiddleName));
					log("STEP 11: User can enter the value in Lookup Value field ", Status.PASS);
				} catch (Exception e) {
					log("STEP 11:  User cannot enter the value in Lookup Value field", Status.FAIL);
					throw new RuntimeException("Failed in step 11");
				}
				
				try {
					AddTitle(map.get(Excel.Title));
					log("STEP 12: User can enter the value in Title field ", Status.PASS);
				} catch (Exception e) {
					log("STEP 12:  User cannot enter the value in Title field", Status.FAIL);
					throw new RuntimeException("Failed in step 12");
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
				
				if(util.isElementVisible(drpGender)) {
				try {
					SelectGender(map.get(Excel.Gender));
					log("STEP 15: User can enter the value in Gender field ", Status.PASS);
				} catch (Exception e) {
					log("STEP 15:  User cannot enter the value in Gender field", Status.FAIL);
					throw new RuntimeException("Failed in step 15");
				}
				}
				
				if(util.isElementVisible(txtVendor)) {
					try {
						AddVendor(map.get(Excel.Vendor));
						log("STEP 16: User can enter the value in Vendor field ", Status.PASS);
					} catch (Exception e) {
						log("STEP 16:  User cannot enter the value in Vendor field", Status.FAIL);
						throw new RuntimeException("Failed in step 16");
					}
				}
				
				try {
					AddAddressLine1(map.get(Excel.AddressLine1));
					log("STEP 17: User can enter the value in Address Line1 field ", Status.PASS);
				} catch (Exception e) {
					log("STEP 17:  User cannot enter the value in Address Line1 field", Status.FAIL);
					throw new RuntimeException("Failed in step 17");
				}
				
				try {
					AddAddressLine2(map.get(Excel.AddressLine2));
					log("STEP 18: User can enter the value in Address Line2 field ", Status.PASS);
				} catch (Exception e) {
					log("STEP 18:  User cannot enter the value in Address Line2 field", Status.FAIL);
					throw new RuntimeException("Failed in step 18");
				}

				try {
					AddCity(map.get(Excel.City));
					log("STEP 19: User can enter the value in City field ", Status.PASS);
				} catch (Exception e) {
					log("STEP 19:  User cannot enter the value in City field", Status.FAIL);
					throw new RuntimeException("Failed in step 19");
				}
				
				try {
					SelectState(map.get(Excel.State));
					log("STEP 20: User can enter the value in State field ", Status.PASS);
				} catch (Exception e) {
					log("STEP 20:  User cannot enter the value in State field", Status.FAIL);
					throw new RuntimeException("Failed in step 20");
				}
				
				try {
					AddZipCode(map.get(Excel.ZipCode));
					log("STEP 21: User can enter the value in Zip Code field ", Status.PASS);
				} catch (Exception e) {
					log("STEP 21:  User cannot enter the value in Zip Code field", Status.FAIL);
					throw new RuntimeException("Failed in step 21");
				}
				
//				try {
//					AddZipCodePlus(map.get(Excel.ZipCodePlus));
//					log("STEP 22: User can enter the value in Zip Code Plus field ", Status.PASS);
//				} catch (Exception e) {
//					log("STEP 22:  User cannot enter the value in Zip Code Plus field", Status.FAIL);
//					throw new RuntimeException("Failed in step 22");
//				}
				
				try {
					AddAddressLine3(map.get(Excel.AddressLine3));
					log("STEP 23: User can enter the value in Address Line3 field ", Status.PASS);
				} catch (Exception e) {
					log("STEP 23:  User cannot enter the value in Address Line3 field", Status.FAIL);
					throw new RuntimeException("Failed in step 23");
				}
				
				try {
					AddEmail(map.get(Excel.Email));
					log("STEP 24: User can enter the value in Email field ", Status.PASS);
				} catch (Exception e) {
					log("STEP 24:  User cannot enter the value in Email field", Status.FAIL);
					throw new RuntimeException("Failed in step 24");
				}
				
				try {
					AddHomePhone(map.get(Excel.HomePhone));
					log("STEP 25: User can enter the value in Home Phone field ", Status.PASS);
				} catch (Exception e) {
					log("STEP 25:  User cannot enter the value in Home Phone field", Status.FAIL);
					throw new RuntimeException("Failed in step 25");
				}
				
				try {
					AddCellPhone(map.get(Excel.CellPhone));
					log("STEP 26: User can enter the value in CellPhone field ", Status.PASS);
				} catch (Exception e) {
					log("STEP 26:  User cannot enter the value in CellPhone field", Status.FAIL);
					throw new RuntimeException("Failed in step 26");
				}
				
				try {
					AddWorkPhone(map.get(Excel.WorkPhone));
					log("STEP 27: User can enter the value in Work Phone field ", Status.PASS);
				} catch (Exception e) {
					log("STEP 27:  User cannot enter the value in Work Phone field", Status.FAIL);
					throw new RuntimeException("Failed in step 27");
				}
				
				try {
					AddFaxPhone(map.get(Excel.CellPhone));
					log("STEP 28: User can enter the value in Cell Phone field ", Status.PASS);
				} catch (Exception e) {
					log("STEP 28:  User cannot enter the value in Cell Phone field", Status.FAIL);
					throw new RuntimeException("Failed in step 28");
				}
				
				try {
					ClickOnInsertButton();
					log("STEP 29: Added address displays in the grid", Status.PASS);
				} catch (Exception e) {
					log("STEP 29: Added record does not display in the grid", Status.FAIL);
					throw new RuntimeException("Failed in step 29");
				}
				
				try {
					ClickOnEditButtonRow();
					log("STEP 30: Existing User record should be open  ", Status.PASS);
				} catch (Exception e) {
					log("STEP 30: Existing User record should not be open", Status.FAIL);
					throw new RuntimeException("Failed in step 30");
				}
				
				try {
					Updatevalue(map.get(Excel.UpdatedComment));
					log("STEP 31: User can update a value in the field/s   ", Status.PASS);
				} catch (Exception e) {
					log("STEP 31: User cannot update a value in the field/s ", Status.FAIL);
					throw new RuntimeException("Failed in step 31");
				}
				
				try {
					ClickOnUpdateButton();
					log("STEP 32: User can click on update button", Status.PASS);
				} catch (Exception e) {
					log("STEP 32: User cannot click on update button", Status.FAIL);
					throw new RuntimeException("Failed in step 32");
				}
				 driver.close();
				 driver.switchTo().window(mainWinID);
					util.dummyWait(2);
				}
					try {
						navigateUserAccount();
						log("STEP 33:  User can Navigate to Menu - User Account", Status.PASS);
					} catch (Exception e) {
						log("STEP 33:  User cannot navigate to Menu - User Account", Status.FAIL);
						throw new RuntimeException("Failed in step 33");
					}
					
					try {
						commonFunction.clickOnNewRecord();
						log("STEP 34:  User can click on Add New Record button", Status.PASS);
					} catch (Exception e) {
						log("STEP 34:  User cannot click on Add New Record button", Status.FAIL);
						throw new RuntimeException("Failed in step 34");
					}
					
					try {
						util.click(drpContractCompany);
						By contractorComp = By.xpath("//div[contains(@id,'EditFormControl_svc_Provider_ID_radYALDropDownList_DropDown')]/..//li[text()='"+NAME+"']");
						Assert.assertTrue(util.isElementVisible(contractorComp));
						log("STEP 35:  User can see newly created Contract Company in User Account's Contract Company DD", Status.PASS);
					} catch (AssertionError e) {
						log("STEP 35:  User cannot see newly created Contract Company in User Account's Contract Company DD", Status.FAIL);
						throw new RuntimeException("Failed in step 35");
					}
					
		 }
		 
		 else if(testcaseName.contains("DOT")) { 
			 
			 util.dummyWait(2);
			 try {
					ClickOnInsertButtonDOT();
					log("STEP 7: User can click on Insert button", Status.PASS);
				} catch (Exception e) {
					log("STEP 7: User cannot click on Insert button", Status.FAIL);
					throw new RuntimeException("Failed in step 7");
				}
				
			 util.dummyWait(3);
				if (util.isElementPresent(SuccessMessage)) {
					   log("STEP 8 :Changes saved sucessfully ! message will be display in green color.   ", Status.PASS);
					} else {
					   log("STEP 8:  Success message does not display"  , Status.FAIL);
				      throw new RuntimeException("Faild in STEP 8 ");
			   	}
				
				 try {
						ClickOnPrimaryContactDOT();
						log("STEP 9: User can click on Primary contact Tab", Status.PASS);
					} catch (Exception e) {
						log("STEP 9: User cannot click on Primary contact Tab", Status.FAIL);
						throw new RuntimeException("Failed in step 9");
					}
				 
				 try {
					 SelectProjectManager(map.get(Excel.ProjectManager));
						log("STEP 10:   Added value displays in the Last Name field :", Status.PASS);
					} catch (Exception e) {
						log("STEP 10:   Added value does not displays in the Last Name field", Status.FAIL);
						throw new RuntimeException("Failed in step 10");
					}
				 
				 try {
						AddAddressLine1Dot(map.get(Excel.AddressLine1));
						log("STEP 11: User can enter the value in Address Line1 field ", Status.PASS);
					} catch (Exception e) {
						log("STEP 11:  User cannot enter the value in Address Line1 field", Status.FAIL);
						throw new RuntimeException("Failed in step 11");
					}
					
					try {
						AddAddressLine2Dot(map.get(Excel.AddressLine2));
						log("STEP 12: User can enter the value in Address Line2 field ", Status.PASS);
					} catch (Exception e) {
						log("STEP 12:  User cannot enter the value in Address Line2 field", Status.FAIL);
						throw new RuntimeException("Failed in step 12");
					}
					

					try {
						AddCityDot(map.get(Excel.City));
						log("STEP 13: User can enter the value in City field ", Status.PASS);
					} catch (Exception e) {
						log("STEP 13:  User cannot enter the value in City field", Status.FAIL);
						throw new RuntimeException("Failed in step 13");
					}
					
					try {
						SelectStateDot(map.get(Excel.State));
						log("STEP 14: User can enter the value in State field ", Status.PASS);
					} catch (Exception e) {
						log("STEP 14:  User cannot enter the value in State field", Status.FAIL);
						throw new RuntimeException("Failed in step 14");
					}
					
					try {
						AddZipCodeDot(map.get(Excel.ZipCode));
						log("STEP 15: User can enter the value in Zip Code field ", Status.PASS);
					} catch (Exception e) {
						log("STEP 15:  User cannot enter the value in Zip Code field", Status.FAIL);
						throw new RuntimeException("Failed in step 15");
					}
					
					try {
						AddZipCodePlusDot(map.get(Excel.ZipCodePlus));
						log("STEP 16: User can enter the value in Zip Code Plus field ", Status.PASS);
					} catch (Exception e) {
						log("STEP 16:  User cannot enter the value in Zip Code Plus field", Status.FAIL);
						throw new RuntimeException("Failed in step 16");
					}
					
					try {
						AddAddressLine3Dot(map.get(Excel.AddressLine3));
						log("STEP 17: User can enter the value in Address Line3 field ", Status.PASS);
					} catch (Exception e) {
						log("STEP 17:  User cannot enter the value in Address Line3 field", Status.FAIL);
						throw new RuntimeException("Failed in step 17");
					}
					
					try {
						ClickOnUpdateButton();
						log("STEP 18: User can click on update button", Status.PASS);
					} catch (Exception e) {
						log("STEP 18: User cannot click on update button", Status.FAIL);
						throw new RuntimeException("Failed in step 18");
					}
					
					try {
						navigateUserAccount();
						log("STEP 19:  User can Navigate to Menu - User Account", Status.PASS);
					} catch (Exception e) {
						log("STEP 19:  User cannot navigate to Menu - User Account", Status.FAIL);
						throw new RuntimeException("Failed in step 19");
					}
					
					try {
						commonFunction.clickOnNewRecord();
						log("STEP 20:  User can click on Add New Record button", Status.PASS);
					} catch (Exception e) {
						log("STEP 20:  User cannot click on Add New Record button", Status.FAIL);
						throw new RuntimeException("Failed in step 20");
					}
					
					try {
						util.click(drpContractCompany);
						By contractorComp = By.xpath("//div[contains(@id,'EditFormControl_svc_Provider_ID_radYALDropDownList_DropDown')]/..//li[text()='"+NAME+"']");
						Assert.assertTrue(util.isElementVisible(contractorComp));
						log("STEP 21:  User can see newly created Contract Company in User Account's Contract Company DD", Status.PASS);
					} catch (AssertionError e) {
						log("STEP 21:  User cannot see newly created Contract Company in User Account's Contract Company DD", Status.FAIL);
					}
					
					try {
						NavigateToVendorManagement();
						log("STEP 22: User can navigate to Vendor Management", Status.PASS);
					} catch (Exception e) {
						log("STEP 22: User cannot navigate to Vendor Management", Status.FAIL);
						throw new RuntimeException("Failed in step 22");
					}
					
					 try {
						 ClickOnDeleteButton();
							log("STEP 23:  Popup Delete should be open with OK and Cancel button    ", Status.PASS);
						} catch (Exception e) {
							log("STEP 23:  Popup Delete does not open", Status.FAIL);
							throw new RuntimeException("Failed in step 23 ");
						}

					 try {
						 ClickonCancle();
							log("STEP 24: User can click on cancel button  ", Status.PASS);
						} catch (Exception e) {
							log("STEP 24: User cannot click on cancel button", Status.FAIL);
							throw new RuntimeException("Failed in step 24");
						}
					 
					 try {
						 ClickonOk();
							log("STEP 25: Deleted record does not display in the grid and 2)Message- Changes saved suessfully! in green displays. ", Status.PASS);
						} catch (Exception e) {
							log("STEP 25: Message- Changes saved sucessfully' does not display", Status.FAIL);
							throw new RuntimeException("Failed in step 25");
						
						}
			
			 }
			 else {
		 
			try {
				ClickOnPrimaryContact();
				log("STEP 6: User can click on Primary Contact Tab", Status.PASS);
			} catch (Exception e) {
				log("STEP 6: User cannot click on Primary Contact Tab", Status.FAIL);
				throw new RuntimeException("Failed in step 6");
			}
			
			try {
				AddLastName(map.get(Excel.LastName));
				log("STEP 7:   Added value displays in the Last Name field :", Status.PASS);
			} catch (Exception e) {
				log("STEP 7:   Added value does not displays in the Last Name field", Status.FAIL);
				throw new RuntimeException("Failed in step 7");
			}
			try {
				AddFirstName(map.get(Excel.FirstName));
				log("STEP 8: User can enter the value in First Name field ", Status.PASS);
			} catch (Exception e) {
				log("STEP 8:  User cannot enter the value in First Name field", Status.FAIL);
				throw new RuntimeException("Failed in step 8");
			}
			
			try {
				AddMiddleName(map.get(Excel.MiddleName));
				log("STEP 9: User can enter the value in Lookup Value field ", Status.PASS);
			} catch (Exception e) {
				log("STEP 9:  User cannot enter the value in Lookup Value field", Status.FAIL);
				throw new RuntimeException("Failed in step 9");
			}
			
			try {
				AddTitle(map.get(Excel.Title));
				log("STEP 10: User can enter the value in Title field ", Status.PASS);
			} catch (Exception e) {
				log("STEP 10:  User cannot enter the value in Title field", Status.FAIL);
				throw new RuntimeException("Failed in step 10");
			}
			
			try {
				AddEntityName(map.get(Excel.EntityName));
				log("STEP 11: User can enter the value in Entity Name field ", Status.PASS);
			} catch (Exception e) {
				log("STEP 11:  User cannot enter the value in Entity Name field", Status.FAIL);
				throw new RuntimeException("Failed in step 11");
			}
			
			try {
				AddEntityType(map.get(Excel.EntityType));
				log("STEP 12: User can enter the value in Entity Type field ", Status.PASS);
			} catch (Exception e) {
				log("STEP 12:  User cannot enter the value in Entity Type field", Status.FAIL);
				throw new RuntimeException("Failed in step 12");
			}
			
			try {
				AddSuffix(map.get(Excel.Suffix));
				log("STEP 13: User can enter the value in Suffix field ", Status.PASS);
			} catch (Exception e) {
				log("STEP 13:  User cannot enter the value in Suffix field", Status.FAIL);
				throw new RuntimeException("Failed in step 13");
			}
			
			try {
				AddCOName(map.get(Excel.COName));
				log("STEP 14: User can enter the value in CO Name field ", Status.PASS);
			} catch (Exception e) {
				log("STEP 14:  User cannot enter the value in CO Name field", Status.FAIL);
				throw new RuntimeException("Failed in step 14");
			}
			
			if(util.isElementVisible(drpGender)) {
			try {
				SelectGender(map.get(Excel.Gender));
				log("STEP 15: User can enter the value in Gender field ", Status.PASS);
			} catch (Exception e) {
				log("STEP 15:  User cannot enter the value in Gender field", Status.FAIL);
				throw new RuntimeException("Failed in step 15");
			}
			}
			
				try {
					AddVendor(map.get(Excel.Vendor));
					log("STEP 16: User can enter the value in Vendor field ", Status.PASS);
				} catch (Exception e) {
					log("STEP 16:  User cannot enter the value in Vendor field", Status.FAIL);
					throw new RuntimeException("Failed in step 16");
				}
			
			
			try {
				AddAddressLine1(map.get(Excel.AddressLine1));
				log("STEP 17: User can enter the value in Address Line1 field ", Status.PASS);
			} catch (Exception e) {
				log("STEP 17:  User cannot enter the value in Address Line1 field", Status.FAIL);
				throw new RuntimeException("Failed in step 17");
			}
			
			try {
				AddAddressLine2(map.get(Excel.AddressLine2));
				log("STEP 18: User can enter the value in Address Line2 field ", Status.PASS);
			} catch (Exception e) {
				log("STEP 18:  User cannot enter the value in Address Line2 field", Status.FAIL);
				throw new RuntimeException("Failed in step 18");
			}
			

			try {
				AddCity(map.get(Excel.City));
				log("STEP 19: User can enter the value in City field ", Status.PASS);
			} catch (Exception e) {
				log("STEP 19:  User cannot enter the value in City field", Status.FAIL);
				throw new RuntimeException("Failed in step 19");
			}
			
			try {
				SelectState(map.get(Excel.State));
				log("STEP 20: User can enter the value in State field ", Status.PASS);
			} catch (Exception e) {
				log("STEP 20:  User cannot enter the value in State field", Status.FAIL);
				throw new RuntimeException("Failed in step 20");
			}
			
			try {
				AddZipCode(map.get(Excel.ZipCode));
				log("STEP 21: User can enter the value in Zip Code field ", Status.PASS);
			} catch (Exception e) {
				log("STEP 21:  User cannot enter the value in Zip Code field", Status.FAIL);
				throw new RuntimeException("Failed in step 21");
			}
			
			
			try {
				AddAddressLine3(map.get(Excel.AddressLine3));
				log("STEP 22: User can enter the value in Address Line3 field ", Status.PASS);
			} catch (Exception e) {
				log("STEP 22:  User cannot enter the value in Address Line3 field", Status.FAIL);
				throw new RuntimeException("Failed in step 22");
			}
			
			try {
				AddEmail(map.get(Excel.Email));
				log("STEP 23: User can enter the value in Email field ", Status.PASS);
			} catch (Exception e) {
				log("STEP 23:  User cannot enter the value in Email field", Status.FAIL);
				throw new RuntimeException("Failed in step 23");
			}
			
			try {
				AddHomePhone(map.get(Excel.HomePhone));
				log("STEP 24: User can enter the value in Home Phone field ", Status.PASS);
			} catch (Exception e) {
				log("STEP 24:  User cannot enter the value in Home Phone field", Status.FAIL);
				throw new RuntimeException("Failed in step 24");
			}
			
			try {
				AddCellPhone(map.get(Excel.CellPhone));
				log("STEP 25: User can enter the value in CellPhone field ", Status.PASS);
			} catch (Exception e) {
				log("STEP 25:  User cannot enter the value in CellPhone field", Status.FAIL);
				throw new RuntimeException("Failed in step 25");
			}
			
			try {
				AddWorkPhone(map.get(Excel.WorkPhone));
				log("STEP 26: User can enter the value in Work Phone field ", Status.PASS);
			} catch (Exception e) {
				log("STEP 26:  User cannot enter the value in Work Phone field", Status.FAIL);
				throw new RuntimeException("Failed in step 26");
			}
			
			try {
				AddInterationalPhone(map.get(Excel.InternationalPhone));
				log("STEP 27: User can enter the value in International Phone field ", Status.PASS);
			} catch (Exception e) {
				log("STEP 27:  User cannot enter the value in International Phone field", Status.FAIL);
				throw new RuntimeException("Failed in step 27");
			}
			
				try {
					AddFaxPhone(map.get(Excel.CellPhone));
					log("STEP 28: User can enter the value in Cell Phone field ", Status.PASS);
				} catch (Exception e) {
					log("STEP 28:  User cannot enter the value in Cell Phone field", Status.FAIL);
					throw new RuntimeException("Failed in step 28");
				}
			
			try {
				ClickOnInsertButton();
				log("STEP 29: Added address displays in the grid", Status.PASS);
			} catch (Exception e) {
				log("STEP 29: Added record does not display in the grid", Status.FAIL);
				throw new RuntimeException("Failed in step 29");
			}
			
			try {
				ClickOnEditButton();
				log("STEP 30: Existing User record should be open  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 30: Existing User record should not be open", Status.FAIL);
				throw new RuntimeException("Failed in step 30");
			}
			
			try {
				Updatevalue(map.get(Excel.UpdatedComment));
				log("STEP 31: User can update a value in the field/s   ", Status.PASS);
			} catch (Exception e) {
				log("STEP 31: User cannot update a value in the field/s ", Status.FAIL);
				throw new RuntimeException("Failed in step 31");
			}
			
			try {
				ClickOnUpdateButton();
				log("STEP 32: User can update a value in the field/s  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 32: User cannot update a value in the field/s", Status.FAIL);
				throw new RuntimeException("Failed in step 32");
			}
			
			try {
				ClickOnCancelButton();
				log("STEP 33: User can check the cancel button  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 33: User cannot check the cancel button ", Status.FAIL);
				throw new RuntimeException("Failed in step 33");
			}
				
			try {
				navigateUserAccount();
				log("STEP 34:  User can Navigate to Menu - User Account", Status.PASS);
			} catch (Exception e) {
				log("STEP 34:  User cannot navigate to Menu - User Account", Status.FAIL);
				throw new RuntimeException("Failed in step 34");
			}
			
			try {
				commonFunction.clickOnNewRecord();
				log("STEP 35:  User can click on Add New Record button", Status.PASS);
			} catch (Exception e) {
				log("STEP 35:  User cannot click on Add New Record button", Status.FAIL);
				throw new RuntimeException("Failed in step 35");
			}
			
			try {
				util.click(drpContractCompany);
				By contractorComp = By.xpath("//div[contains(@id,'EditFormControl_svc_Provider_ID_radYALDropDownList_DropDown')]/..//li[text()='"+NAME+"']");
				Assert.assertTrue(util.isElementVisible(contractorComp));
				log("STEP 36:  User can see newly created Contract Company in User Account's Contract Company DD", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 36:  User cannot see newly created Contract Company in User Account's Contract Company DD", Status.FAIL);
				throw new RuntimeException("Failed in step 36");
			}
			 }
		
	}
  	
}
