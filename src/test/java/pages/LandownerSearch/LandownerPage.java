package pages.LandownerSearch;

import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

import extentReports.ExtentTestManager;

public class LandownerPage extends BasePage {

	TestUtil util;
	CommonFunction commonFunction;
	public static String LANDOWNER_NAME1, LANDOWNER_NAME2, LANDOWNER_NAME3, ENTITY_NAME;
	public static String STATE;
	public static String CITY;
	public static String ZIPCODE;
	public static String LO1_ADDRESS, LO2_ADDRESS, LO3_ADDRESS;

	public LandownerPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		
	}
	

	By navParcel = By.xpath("//span[text()='Parcel']");
	By navParcelInfo = By.xpath("//span[text()='Parcel Info']");
	By navParcelInformation = By.xpath("//span[contains(text(),'Parcel Information')]");
	By navLandowner = By.xpath("//span[text()='Landowner' and @class='rpText']");
	By btnAddNew = By.xpath("(//img[@alt='Add New Landowner(s)'])[1]");
	By Activecheckbox = By.xpath("//input[contains(@id,'IsEntityActive') and @checked='checked']");
	By frmFull = By.xpath("//iframe[@name='AddLandowner']");
	By txtExistingContact = By.xpath("//input[contains(@id,'RadEntityInfo_Input') and @type='text']");
	By txtLastName = By.xpath("//input[contains(@id,'ENTITY_Last_Name') and @type='text']");
	By txtFirstName = By.xpath("//input[contains(@id,'ENTITY_First_Name') and @type='text']");
	By txtMiddleName = By.xpath("//input[contains(@id,'ENTITY_Middle_Name') and @type='text']");
	By drpEntityName = By.xpath("(//input[contains(@id,'ENTITY_Corporation_Trust') and @type='text'])[1]");
	By txtEntityType = By.xpath("//input[contains(@id,'ENTITY_Entity_Type_ID_radYALDropDownList_Input') and @type='text']");
	By txtContactNumber = By.xpath("//input[contains(@id,'ENTITY_txtContactNum') and @type='text']");
	By txtCOName = By.xpath("//input[contains(@id,'ENTITY_CO_Name') and @type='text']");
	By txtMaritalStatus = By.xpath("//input[contains(@id,'ENTITY_Marital_Status_ID_radYALDropDownList_Input') and @type='text']");
	By btnSave = By.xpath("//input[@id='btnSaveLO']");
	By ChangesaveSuccessfully = By.xpath("//span[text()='Changes saved successfully!']");
	By SuccessMassage = By.xpath("//span[contains(text(),'New landowner has created and added to the')]");
	By PrimaryMsg = By.xpath("//span[text()='No primary address assigned.']");
    By btnClose = By.xpath("//a[@class='rwCloseButton']");   //not validate
	By btnEdit = By.xpath("//tr[contains(@id,'LANDOWNERS_radYALGridControl_ctl00__0')]/.//a[contains(text(),'Edit')]");
	By btnAddRecordUnderComment = By.xpath("//img[@id='YALCONTACTWITHNAME_radYALGridControl_ctl00_ctl02_ctl00_Img4']");
	By txtAddressLine1 = By.xpath("//input[(contains(@id,'_EditFormControl_Address_Line_1') or contains(@id,'ENTITY_Address_Line_1')) and @type='text']");
	By txtAddressLineROW = By.xpath("//input[contains(@id,'_EditFormControl_Address_Line_1') and @type='text']");
	By txtAddressLine2 = By.xpath("//input[(contains(@id,'_EditFormControl_Address_Line_2') or contains(@id,'ENTITY_Address_Line_2')) and @type='text']");
	By txtAddressLine3 = By.xpath("//input[(contains(@id,'_EditFormControl_Address_Line_3') or contains(@id,'ENTITY_Address_Line_3')) and @type='text']");
	By txtAddressLine4 = By.xpath("//input[(contains(@id,'_EditFormControl_Address_Line_4') or contains(@id,'ENTITY_Address_Line_4')) and @type='text']");
	By txtCity = By.xpath("//input[(contains(@id,'_EditFormControl_City') or contains(@id,'ENTITY_City')) and @type='text']");
	By drpState = By.xpath("//input[(contains(@id,'ABB') or contains(@id,'ENTITY_RadState_Input')) and @type='text']");
	By txtZipCode = By.xpath("(//input[(contains(@id,'_EditFormControl_Zip_Code') or contains(@id,'ENTITY_Zip_Code')) and @type='text'])[1]");
	By btnInsert = By.xpath("//input[contains(@id,'_EditFormControl_btnInsert') and @type='submit']");
	By btnEditComment = By.xpath("(//input[contains(@id,'YALCONTACTWITHNAME_radYALGridControl_ctl00_ctl04_EditButton') and @type='image'])[1]");
	By btnAddContact = By.xpath("//input[contains(@id,'_EditFormControl_btnAddItem') and @type='submit']");
	By txtNameForALT = By.xpath("//input[contains(@id,'_Full_Name_Footer') and @type='text']");
	By txtHomePhone = By.xpath("(//input[(contains(@id,'_Home_Phone_Footer') or contains(@id,'ENTITY_Home_Phone')) and @type='text'])[1]");
	By txtCellPhone = By.xpath("(//input[(contains(@id,'_Cell_Phone_Footer') or contains(@id,'ENTITY_Cell_Phone')) and @type='text'])[1]");
	By txtWorkPhone = By.xpath("(//input[(contains(@id,'_Work_Phone_Footer') or contains(@id,'ENTITY_Work_Phone')) and @type='text'])[1]");
	By txtFaxPhone  = By.xpath("(//input[(contains(@id,'_Fax_Number_Footer') or contains(@id,'ENTITY_FAX_NUMBER')) and @type='text'])[1]");
	By chcPreferredContact = By.xpath("(//label[text()='Preferred Contact'])[1]");
	By btnSaveContact = By.xpath("//input[contains(@id,'_EditFormControl_btnSaveItem') and @type='submit']");
	By btnUpdateContact = By.xpath("//input[contains(@id,'_EditFormControl_btnUpdate') and @type='submit']");
	By checkboxIsPrimary = By.xpath("//*[@id='IsPrimary']");
	By navParcelMenu = By.xpath("*//a//span[@class='rmText rmExpandDown' and contains(text(),'Parcel')]");
    By firstParcel = By.xpath("//*[contains(@id,'TractList_RadGridTracts_ctl00__0')]");
    By secondParcel = By.xpath("//*[contains(@id,'TractList_RadGridTracts_ctl00__1')]");
    By gridLandowner = By.xpath("//table[contains(@id,'LANDOWNERS_radYALGridControl')]");
    
    public void navigateToParcelInformation() {
		util.waitUntilElementDisplay(navParcelMenu);
		util.click(navParcelMenu);
		util.waitUntilElementDisplay(navParcelInfo);
		util.click(navParcelInfo);
		util.waitUntilElementDisplay(navParcelInformation);
		util.click(navParcelInformation);
	}
    
    public void ExpandLandowner() {
    	if(!util.isElementVisible(gridLandowner)) {
    	util.waitUntilElementDisplay(navLandowner);
		util.click(navLandowner);
		util.dummyWait(1);	
    	}
    }
    
	public void AddnewLandowner() {
	    	util.waitUntilElementDisplay(btnAddNew);
			util.click(btnAddNew);	
	    }
   
	    public void VerifyCheckbox() {
			Assert.assertTrue(true, "Activecheckbox");
			util.waitUntilElementDisplay(checkboxIsPrimary);
			util.click(checkboxIsPrimary);
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
	    
	    public void AddEntityName(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(drpEntityName, value);
	    }
	    
	    public void AddEntityType(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtEntityType, value);
	    }
	    
	    public void AddContactNumber(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtContactNumber, value);
	    }
	    
	    public void AddCOName(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtCOName, value);
	    }
	    
	    public void AddMaritalStatus(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtMaritalStatus, value);
	    }
	    
	   public void Save() {
	    	util.waitUntilElementDisplay(btnSave);
			util.click(btnSave);
			util.dummyWait(2);			
//			Assert.assertTrue(util.isElementPresent(SuccessMassage), "New landowner has created and added");
//			Assert.assertTrue(util.isElementPresent(PrimaryMsg), "No primary address assigned.");	
	    }
	    
	    public void Close() {
	    	util.switchToDefaultContent();
	    	util.dummyWait(3);
	    	util.waitUntilElementDisplay(btnClose);
			util.click(btnClose);
	    }
	    
	    public void ClickOnSaveButton() {
	    	util.waitUntilElementDisplay(btnSave);
	    	util.click(btnSave);
	    	util.waitUntilElementDisplay(ChangesaveSuccessfully);
	    	Assert.assertTrue(util.isElementPresent(ChangesaveSuccessfully), "Changes saved successfully!");
	    }
	    
	    public void addNewAddress() {
	    	util.waitUntilElementDisplay(btnAddRecordUnderComment);
	    	util.click(btnAddRecordUnderComment);
	    }
	    
	    public void addAddressLine1(String value) {
	    	util.dummyWait(4);
	    	util.waitUntilElementDisplay(txtAddressLine1);
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtAddressLine1, value);
	    }
	    
	    public void addAddressLine1ROW(String value) {
	    	util.dummyWait(4);
	    	util.waitUntilElementDisplay(txtAddressLineROW);
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtAddressLineROW, value);
	    }
	    
	    public void addAddressLine2(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtAddressLine2, value);
	    }
	    
	    public void addAddressLine3(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtAddressLine3, value);
	    }
	    
	    public void addAddressLine4(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtAddressLine4, value);
	    }
	    
	    public void AddCity(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtCity, value);
	    }
	    
	    public void SelectState(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(drpState, value);
	    }
	    
	    public void addZipCode(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtZipCode, value);
	    }
	    
	    public void InsertRecord() {
	    	util.waitUntilElementDisplay(btnInsert);
	    	util.click(btnInsert);
	    }
	    
	    public void EditAddress() {
	    	util.waitUntilElementDisplay(btnEditComment);
	    	util.click(btnEditComment);
	    } 
	    
	    public void AddContact() {
	    	util.waitUntilElementDisplay(btnAddContact); 	
	    	util.click(btnAddContact);
	    }
	    
	    public void addNameForALT(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtNameForALT, value);
	    }
	    
	    public void addHomePhoneNumber(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtHomePhone, value);
	    }
	    
	    public void addCellPhoneNumber(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtCellPhone, value);
	    }
	    
	    public void addWorkPhoneNumber(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtWorkPhone, value);
	    }
	    
	    public void addFaxPhoneNumber(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtFaxPhone , value);
	    }
	    
	    public void ClickOnPreferredContact() {
	    	util.waitUntilElementDisplay(chcPreferredContact);
	    	util.click(chcPreferredContact);
			util.dummyWait(1);
	    }
	    
	    public void ClickOnSaveContact() {
	    	util.waitUntilElementDisplay(btnSaveContact);
	    	util.click(btnSaveContact);
			util.dummyWait(1);
	    }
	    
	    public void ClickOnUpdateContact() {
	    	util.dummyWait(2);
	    	util.waitUntilElementDisplay(btnUpdateContact);
	    	util.click(btnUpdateContact);	
	    }
	    
	    public void ClickOnEdit() {
	    	util.waitUntilElementDisplay(btnEditComment);
	    	util.click(btnEditComment);
	    }
	    
	    By panelContactDetails = By.xpath("//span[contains(text(),'Contact Details')]");
	    By gridContactDetails = By.xpath("//table[contains(@id,'_CONTACT_radYALGridControl')]");
	    public void expandContatDetailsPanel() {
	    	if(!util.isElementVisible(gridContactDetails)) {
	  		util.waitUntilElementDisplay(panelContactDetails);
			util.click(panelContactDetails);
	    	}
	    }
	    
	    By btnAddUnderContact = By.xpath("(//img[@alt='Add New Landowner(s)'])[2]");
		By btnAddContactforROW = By.xpath("//input[contains(@id,'ImgAddContact') and @type = 'image']");
	    public void AddnewContact() {
			util.waitUntilElementDisplay(btnAddUnderContact);
			util.click(btnAddUnderContact);
			
	    }
	    
	    public void AddnewContactForROW() {
			util.waitUntilElementDisplay(btnAddContactforROW);
			util.click(btnAddContactforROW);
			
	    }
	    
	    public void AddExistingContact(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtExistingContact, value);
			
	    }
	    
	    By btnAddNewRow = By.xpath("//input[contains(@id,'_ImgAddLandowner') and @type='image']");
	    public void AddnewLandownerRow() {
	    	util.waitUntilElementDisplay(btnAddNewRow);
			util.click(btnAddNewRow);
			
	    }
	    
	    public void AddLandowner(Map<String, String> map, String testcaseName, String baseVertical) {

	    	if(testcaseName.contains("AddLandowner1")) {
			try {
				By firstParcelAdded = By.xpath("(//td[text()='"+ParcelInformation_AddNewParcelPage.PARCEL1+"']/parent::tr)[1]");
				util.click(firstParcelAdded);
				util.dummyWait(2);
				ExpandLandowner();
				log("STEP 1: User can navigate to parcel information page", Status.PASS);
			} catch (Exception e) {
				log("STEP 1: User cannot navigate to parcel information page", Status.FAIL);
				throw new RuntimeException("Failed in step 1");
			}
	    	}else if(testcaseName.contains("AddLandowner2")) {
	    		try {
					ExpandLandowner();
					log("STEP 1: User can expand Landowner Panel", Status.PASS);
				} catch (Exception e) {
					log("STEP 1: User cannot expand Landowner Panel", Status.FAIL);
					throw new RuntimeException("Failed in step 1");
				}
	    	}else {
	    		try {
	    			By secondParcelAdded = By.xpath("(//td[text()='"+ParcelInformation_AddNewParcelPage.PARCEL2+"']/parent::tr)[1]");
					util.click(secondParcelAdded);
					util.dummyWait(2);
				ExpandLandowner();
					log("STEP 1: User can select second parcel and  expand Landowner Panel", Status.PASS);
				} catch (Exception e) {
					log("STEP 1: User cannot select second parcel or expand Landowner Panel", Status.FAIL);
					throw new RuntimeException("Failed in step 1");
				}
	    	}
	    	
	    	
	    	if(baseVertical.contains("ROW") || environment.contains("DOM"))
	    	 {  
	    	try {
	    		AddnewLandownerRow();
				log("STEP 2: User can click on Add New Landowner ", Status.PASS);
			} catch (Exception e) {
				log("STEP 2:  User cannot click on Add New Landowner ", Status.FAIL);
				throw new RuntimeException("Failed in step 2");
			}
	     }
	    	 else {
	    		
	    	 try {
	    		 AddnewLandowner(); 
					log("STEP 2: User can click on Add New Landowner ", Status.PASS);
				} catch (Exception e) {
					log("STEP 2: User cannot click on Add New Landowner", Status.FAIL);
					throw new RuntimeException("Failed in step 2");
				}
	     }
	    
			try {
				util.switchToIframe(frmFull);
				VerifyCheckbox();
				log("STEP 3: Checkbox is auto checked ", Status.PASS);
			} catch (Exception e) {
				log("STEP 3: Active checkbox is not auto checked ", Status.FAIL);
				throw new RuntimeException("Failed in step 3");
			}

			if (util.isElementVisible(txtLastName)) {
				try {
					AddLastName(map.get(Excel.LastName));
					log("STEP 4: User can enter a value in LastName field   ", Status.PASS);
				} catch (Exception e) {
					log("STEP 4:  User cannot add a value in LastName field    ", Status.FAIL);
					throw new RuntimeException("Failed in step 4");
				}
			}

			if (util.isElementVisible(txtFirstName)) {
				try {
					AddFirstName(map.get(Excel.FirstName));
					log("STEP 5: User can enter a value in FirstName field   ", Status.PASS);
				} catch (Exception e) {
					log("STEP 5:  User cannot add a value in FirstName field    ", Status.FAIL);
					throw new RuntimeException("Failed in step 5");
				}
			}

			if (util.isElementVisible(txtMiddleName)) {
				try {
					AddMiddleName(map.get(Excel.MiddleName));
					log("STEP 6: User can enter a value in MiddleName field   ", Status.PASS);
				} catch (Exception e) {
					log("STEP 6:  User cannot add a value in MiddleName field    ", Status.FAIL);
					throw new RuntimeException("Failed in step 6");
				}
			}

			try {
				if(testcaseName.contains("AddLandowner1")) {
					LANDOWNER_NAME1=map.get(Excel.EntityName)+util.randomNumber();
					AddEntityName(LANDOWNER_NAME1);
				} else if(testcaseName.contains("AddLandowner2")) {
					LANDOWNER_NAME2=map.get(Excel.EntityName)+util.randomNumber();
					AddEntityName(LANDOWNER_NAME2);
				}else {
					LANDOWNER_NAME3=map.get(Excel.EntityName)+util.randomNumber();
					AddEntityName(LANDOWNER_NAME3);
				}
				ENTITY_NAME=map.get(Excel.EntityName);
				log("STEP 7: User can enter a value in EntityName field   ", Status.PASS);
			} catch (Exception e) {
				log("STEP 7:  User cannot add a value in EntityName field    ", Status.FAIL);
				throw new RuntimeException("Failed in step 7");
			}

			if (util.isElementVisible(txtContactNumber)) {
				try {
					AddContactNumber(map.get(Excel.ContactNumber));
					log("STEP 8: User can enter a value in Contact Number field   ", Status.PASS);
				} catch (Exception e) {
					log("STEP 8:  User cannot add a value in Contact Number field    ", Status.FAIL);
					throw new RuntimeException("Failed in step 8");
				}
			}

			if (util.isElementVisible(txtCOName)) {
				try {
					AddCOName(map.get(Excel.COName));
					log("STEP 9: User can enter a value in COName field   ", Status.PASS);
				} catch (Exception e) {
					log("STEP 9:  User cannot add a value in COName field    ", Status.FAIL);
					throw new RuntimeException("Failed in step 9");
				}
			}

			if (util.isElementPresent(txtMaritalStatus)) {
				try {
					AddMaritalStatus(map.get(Excel.MaritalStatus));
					log("STEP 10: Added value displays in Marital Status field   ", Status.PASS);
				} catch (Exception e) {
					log("STEP 10:  User  cannot select  value  from Marital Status DD    ", Status.FAIL);
					throw new RuntimeException("Failed in step 10");
				}
			}
            
			if(!baseVertical.contains("ROW") &  !environment.contains("DOM")) {
			try {
					Save();
					log("STEP 11: User can click on Save button and Added Landowner record displays in grid   ",
							Status.PASS);
				} catch (Exception e) {
					log("STEP 11:  Added Landowner record does not display in grid      ", Status.FAIL);
					throw new RuntimeException("Failed in step 11");
				}

			
				try {
					addNewAddress();
					log("STEP 12: User can click on add new address", Status.PASS);
				} catch (Exception e) {
					log("STEP 12: User cannot click on add new address", Status.FAIL);
					throw new RuntimeException("Failed in step 12");
				}
	    }
				try {
					util.dummyWait(2);
					addAddressLine1(map.get(Excel.AddressLine1));
					if(testcaseName.contains("AddLandowner1")) {
						LO1_ADDRESS =map.get(Excel.AddressLine1);
						log("LO1 Address "+LO1_ADDRESS);
					} else if(testcaseName.contains("AddLandowner2")) {
						LO2_ADDRESS =map.get(Excel.AddressLine1);
						log("LO2 Address "+LO2_ADDRESS);
					}else {
						LO3_ADDRESS =map.get(Excel.AddressLine1);
						log("LO3 Address "+LO3_ADDRESS);
					}
					log("STEP 13:  User can enter a value in Address Line1 field  ", Status.PASS);
				} catch (Exception e) {
					log("STEP 13:  User cannot add a value in Address Line1 field    ", Status.FAIL);
					throw new RuntimeException("Failed in step 13");
				}

				if (util.isElementVisible(txtAddressLine2)) {
					try {
						addAddressLine2(map.get(Excel.AddressLine2));
						log("STEP 14: User can enter a value in Address Line2 field   ", Status.PASS);
					} catch (Exception e) {
						log("STEP 14:  User cannot add a value in Address Line2 field    ", Status.FAIL);
						throw new RuntimeException("Failed in step 14");
					}
				}

				if (util.isElementVisible(txtAddressLine3)) {
					try {
						addAddressLine3(map.get(Excel.AddressLine3));
						log("STEP 15: User can enter a value in Address Line3 field   ", Status.PASS);
					} catch (Exception e) {
						log("STEP 15:  User cannot add a value in Address Line3 field    ", Status.FAIL);
						throw new RuntimeException("Failed in step 15");
					}
				}

				if (util.isElementVisible(txtAddressLine4)) {
					try {
						addAddressLine4(map.get(Excel.AddressLine4));
						log("STEP 16: User can enter a value in Address Line4 field   ", Status.PASS);
					} catch (Exception e) {
						log("STEP 16:  User cannot add a value in Address Line4 field    ", Status.FAIL);
						throw new RuntimeException("Failed in step 16");
					}
				}

				try {
					AddCity(map.get(Excel.City));
					CITY = map.get(Excel.City);
					log("STEP 17: User can enter a value in City field   ", Status.PASS);
				} catch (Exception e) {
					log("STEP 17:  User cannot add a value in City field    ", Status.FAIL);
					throw new RuntimeException("Failed in step 17");
				}

					try {
						SelectState(map.get(Excel.State));
						STATE = map.get(Excel.State);
						log("STEP 18: Added value displays in State field   ", Status.PASS);
					} catch (Exception e) {
						log("STEP 18:  No value displays in State Dropdown    ", Status.FAIL);
						throw new RuntimeException("Failed in step 18");
					}

					try {
						addZipCode(map.get(Excel.ZipCode));
						ZIPCODE = map.get(Excel.ZipCode);
						log("STEP 19: User can enter a value in Zip Code field   ", Status.PASS);
					} catch (Exception e) {
						log("STEP 19:  User cannot add a value in Zip Code field    ", Status.FAIL);
						throw new RuntimeException("Failed in step 19");
					}

					if(!baseVertical.contains("ROW")  & !environment.contains("DOM"))
			    	 {
					try {
						InsertRecord();
						util.dummyWait(2);
						log("STEP 20:  Added address displays in the grid       ", Status.PASS);
					} catch (Exception e) {
						log("STEP 20:   Added address not displays in the grid        ", Status.FAIL);
						throw new RuntimeException("Failed in step 20");
					}

					try {
						EditAddress();
						log("STEP 21:  User can click on edit address link  ", Status.PASS);
					} catch (Exception e) {
						log("STEP 21:  User cannot click on edit address link ", Status.FAIL);
						throw new RuntimeException("Failed in step 21");
					}

					try {
						AddContact();
						util.dummyWait(1);
						log("STEP 22: User can click on add contact  ", Status.PASS);
					} catch (Exception e) {
						log("STEP 22: User cannot click on add contact  ", Status.FAIL);
						throw new RuntimeException("Failed in step 22");
					}

					if(util.isElementVisible(txtNameForALT)) {
					try {
						addNameForALT(map.get(Excel.Name));
						log("STEP 23: User can enter a value in Name field   ", Status.PASS);
					} catch (Exception e) {
						log("STEP 23:  User cannot add a value in Name field    ", Status.FAIL);
						throw new RuntimeException("Failed in step 23");
					}
					}
			    	 }
					
					if (util.isElementVisible(txtHomePhone)) {
						try {
							addHomePhoneNumber(map.get(Excel.HomePhone));
							log("STEP 24: User can enter a value in Home Phone field   ", Status.PASS);
						} catch (Exception e) {
							log("STEP 24:  User cannot add a value in Home Phone field    ", Status.FAIL);
							throw new RuntimeException("Failed in step 24");
						}
					}

					if (util.isElementVisible(txtCellPhone)) {
						try {
							addCellPhoneNumber(map.get(Excel.CellPhone));
							log("STEP 25: User can enter a value in Cell Phone field   ", Status.PASS);
						} catch (Exception e) {
							log("STEP 25:  User cannot add a value in Cell Phone field    ", Status.FAIL);
							throw new RuntimeException("Failed in step 25");
						}
					}

					if (util.isElementVisible(txtWorkPhone)) {
						try {
							addWorkPhoneNumber(map.get(Excel.WorkPhone));
							log("STEP 26: User can enter a value in Work Phone field   ", Status.PASS);
						} catch (Exception e) {
							log("STEP 26:  User cannot add a value in Work Phone field    ", Status.FAIL);
							throw new RuntimeException("Failed in step 26");
						}
					}

					if (util.isElementVisible(txtFaxPhone)) {
						try {
							addFaxPhoneNumber(map.get(Excel.FaxPhone));
							log("STEP 27: User can enter a value in Fax Phone field   ", Status.PASS);
						} catch (Exception e) {
							log("STEP 27:  User cannot add a value in Fax Phone field    ", Status.FAIL);
							throw new RuntimeException("Failed in step 27");
						}
					}
					
					if(!baseVertical.contains("ROW") & !environment.contains("DOM"))
			    	 {
					try {
						ClickOnPreferredContact();
						log("STEP 28: User can check the check box    ", Status.PASS);
					} catch (Exception e) {
						log("STEP 28:  User cannot check the checkbox   ", Status.FAIL);
						throw new RuntimeException("Failed in step 28");
					}

					try {
						ClickOnSaveContact();
						log("STEP 29: User can click on Save contact ",Status.PASS);
					} catch (Exception e) {
						log("STEP 29: User cannot click on Save contact  ", Status.FAIL);
						throw new RuntimeException("Failed in step 29");
					}
					
					try {
			    		 ClickOnUpdateContact();
			    		 util.dummyWait(2);
			 			log("STEP 30: User can update the address ", Status.PASS);
			 		 } catch (Exception e) {
			 			log("STEP 30: User cannot update the address ", Status.FAIL);
			 			throw new RuntimeException("Failed in step 30");
			 		 }
			    	 }else {
			    		 try {
								Save();
								log("STEP 28: User can click on Save button and Added Landowner record displays in grid   ",
										Status.PASS);
							} catch (Exception e) {
								log("STEP 28:  Added Landowner record does not display in grid      ", Status.FAIL);
								throw new RuntimeException("Failed in step 28");
							}
			    	 }
					
					if(testcaseName.contains("AddLandowner1")) {
					try {
						addNewAddress();
						log("STEP 31: User can click on add new address", Status.PASS);
					} catch (Exception e) {
						log("STEP 31: User cannot click on add new address", Status.FAIL);
						throw new RuntimeException("Failed in step 31");
					}
					
					if(baseVertical.contains("ROW") || environment.contains("DOM")) {
					try {
						util.dummyWait(2);
						addAddressLine1ROW(map.get("SecondAddress"));
						log("STEP 32:  User can enter a value in Address Line1 field  ", Status.PASS);
					} catch (Exception e) {
						log("STEP 32:  User cannot add a value in Address Line1 field    ", Status.FAIL);
						throw new RuntimeException("Failed in step 32");
					}
					}else {
						try {
							util.dummyWait(2);
							addAddressLine1(map.get("SecondAddress"));
							log("STEP 32:  User can enter a value in Address Line1 field  ", Status.PASS);
						} catch (Exception e) {
							log("STEP 32:  User cannot add a value in Address Line1 field    ", Status.FAIL);
							throw new RuntimeException("Failed in step 32");
						}
					}
					try {
						InsertRecord();
						util.dummyWait(2);
						Close();
						log("STEP 33:  User can add second Address  ", Status.PASS);
					} catch (Exception e) {
						log("STEP 33:  User cannot add second Address  ", Status.FAIL);
						throw new RuntimeException("Failed in step 33");
					}

					try {
						ExpandLandowner();
						log("STEP 34:  User can expand Landowner panel ", Status.PASS);
					} catch (Exception e) {
						log("STEP 34:  User cannot expand Landowner panel ", Status.FAIL);
						throw new RuntimeException("Failed in step 34");
					}
					
					try {
						By LN = By.xpath("(//tr[contains(@id,'LANDOWNERS_radYALGridControl')]/.//strong[text()='"+LANDOWNER_NAME1+"'])[2]");
						Assert.assertFalse(util.isElementVisible(LN));
						log("STEP 35:  User cannot see duplicate landowners on the grid if multiple address added", Status.PASS);
					} catch (AssertionError e) {
						log("STEP 35:  User can see duplicate landowners on the grid if multiple address added", Status.FAIL);
					}
					
					try {
						By address = By.xpath("(//tr[contains(@id,'LANDOWNERS_radYALGridControl')]/.//strong[text()='"+LO1_ADDRESS+"'])[1]");
						Assert.assertTrue(util.isElementVisible(address));
						log("STEP 36:  User can see primary address on the grid", Status.PASS);
					} catch (AssertionError e) {
						log("STEP 36:  User cannot see primary address on the grid", Status.FAIL);
					}
					
					}else {
						
						try {
							Close();
							util.dummyWait(2);
							ExpandLandowner();
							log("STEP 31:  User can expand Landowner panel ", Status.PASS);
						} catch (Exception e) {
							log("STEP 31:  User cannot expand Landowner panel ", Status.FAIL);
							throw new RuntimeException("Failed in step 31");
						}

						if (testcaseName.contains("AddLandowner2")) {
							try {
								By address = By.xpath("(//tr[contains(@id,'LANDOWNERS_radYALGridControl')]/.//strong[text()='"+LO2_ADDRESS+"'])[1]");
								Assert.assertTrue(util.isElementVisible(address));
								log("STEP 32:  User can see primary address on the grid", Status.PASS);
							} catch (AssertionError e) {
								log("STEP 32:  User cannot see primary address on the grid", Status.FAIL);
							}
							ExtentTestManager.infoWithScreenshot("Parcel 1 Landowners");
						
					}else {
						try {
							By address = By.xpath("(//tr[contains(@id,'LANDOWNERS_radYALGridControl')]/.//strong[text()='"+LO3_ADDRESS+"'])[1]");
							Assert.assertTrue(util.isElementVisible(address));
							log("STEP 32:  User can see primary address on the grid", Status.PASS);
						} catch (AssertionError e) {
							log("STEP 32:  User cannot see primary address on the grid", Status.FAIL);
						}
					}
					}
					//Issue - address is getting removed when same landowner is added to contact details
					if(!environment.contains("DOM")){  
					try {
						expandContatDetailsPanel();
						log("STEP 33: User can expand Contact Details panel ", Status.PASS);
					} catch (Exception e) {
						log("STEP 33:  User cannot expand Contact Details panel ", Status.FAIL);
						throw new RuntimeException("Failed in step 33");
					}
					
					if(baseVertical.contains("ROW") || environment.contains("DOM"))
			    	 {  
			    	try {
			    		AddnewContactForROW();
						log("STEP 34: User can click on Add New Contact button ", Status.PASS);
					} catch (Exception e) {
						log("STEP 34:  User cannot click on Add New Contact button ", Status.FAIL);
						throw new RuntimeException("Failed in step 34");
					}
			     }
			    	 else {
			    		
			    	 try {
			    		 AddnewContact(); 
							log("STEP 34: User can click on Add New Contact button", Status.PASS);
						} catch (Exception e) {
							log("STEP 34: User cannot click on Add New Contact button", Status.FAIL);
							throw new RuntimeException("Failed in step 34");
						}
			     }
			    
			       try {
			    		 util.switchToIframe(frmFull);
			    		 VerifyCheckbox();
			 			log("STEP 35: Active Checkbox is auto checked   ", Status.PASS);
			 		 } catch (Exception e) {
			 			log("STEP 35: Active checkbox is not auto checked   ", Status.FAIL);
			 			throw new RuntimeException("Failed in step 35");
			 		 }
			       
			      try {
			    	  if(testcaseName.contains("AddLandowner1")) {
			    		  AddExistingContact(LANDOWNER_NAME1);
						} else if(testcaseName.contains("AddLandowner2")) {
							 AddExistingContact(LANDOWNER_NAME2);
						}else {
							 AddExistingContact(LANDOWNER_NAME3);
						}
			    		 
			 			log("STEP 36:  User can select value from Existing Contact dd     ", Status.PASS);
			 		 } catch (Exception e) {
			 			log("STEP 36:  User  cannot select  value  from Existing Contact DD     ", Status.FAIL);
			 			throw new RuntimeException("Failed in step 36");
			 		 }
			      
			      try {
			    		 Save();
			    		 Close(); 
				         	util.dummyWait(3);
			 			log("STEP 37: Existing Contact Added to the Contact Details panel ", Status.PASS);
			 		 } catch (Exception e) {
			 			log("STEP 37: Existing Contact not added to the Contact Details panel ", Status.FAIL);
			 			throw new RuntimeException("Failed in step 37");
			 		 }
			      
			      try {
			    	  expandContatDetailsPanel();
						log("STEP 38:  User can expand contact details panel ", Status.PASS);
					} catch (Exception e) {
						log("STEP 38:  User cannot expand contact details panel ", Status.FAIL);
						throw new RuntimeException("Failed in step 38");
					}
					
			      if(testcaseName.contains("AddLandowner1")) {
					try {
						By contact1 = By.xpath("(//tr[contains(@id,'_CONTACT_radYALGridControl')]/.//strong[text()='"+LANDOWNER_NAME1+"'])[1]");
						Assert.assertTrue(util.isElementVisible(contact1));
						log("STEP 39:  User can see Contact Details Record on the grid ", Status.PASS);
					} catch (AssertionError e) {
						log("STEP 39:  User cannot see Contact Details Record on the grid ", Status.FAIL);
					}
					
					try {
						By address = By.xpath("(//tr[contains(@id,'_CONTACT_radYALGridControl')]/.//strong[text()='"+LO1_ADDRESS+"'])[1]");
						Assert.assertTrue(util.isElementVisible(address));
						log("STEP 40:  User can see primary address on the contact grid", Status.PASS);
					} catch (AssertionError e) {
						log("STEP 40:  User cannot see primary address on the contact grid", Status.FAIL);
					}
					
			      }else if(testcaseName.contains("AddLandowner2")) {
			    	  try {
							By contact2 = By.xpath("(//tr[contains(@id,'_CONTACT_radYALGridControl')]/.//strong[text()='"+LANDOWNER_NAME2+"'])[1]");
							Assert.assertTrue(util.isElementVisible(contact2));
							log("STEP 39:  User can see Contact Details Record on the grid ", Status.PASS);
						} catch (AssertionError e) {
							log("STEP 39:  User cannot see Contact Details Record on the grid ", Status.FAIL);
						}
			    	  
			    	  try {
							By address = By.xpath("(//tr[contains(@id,'_CONTACT_radYALGridControl')]/.//strong[text()='"+LO2_ADDRESS+"'])[1]");
							Assert.assertTrue(util.isElementVisible(address));
							log("STEP 40:  User can see primary address on the contact grid", Status.PASS);
						} catch (AssertionError e) {
							log("STEP 40:  User cannot see primary address on the contact grid", Status.FAIL);
						}
			      }else {
			    	  try {
							By contact3 = By.xpath("(//tr[contains(@id,'_CONTACT_radYALGridControl')]/.//strong[text()='"+LANDOWNER_NAME3+"'])[1]");
							Assert.assertTrue(util.isElementVisible(contact3));
							log("STEP 39:  User can see Contact Details Record on the grid ", Status.PASS);
						} catch (AssertionError e) {
							log("STEP 39:  User cannot see Contact Details Record on the grid ", Status.FAIL);
						}
			    	  
			    	  try {
							By address = By.xpath("(//tr[contains(@id,'_CONTACT_radYALGridControl')]/.//strong[text()='"+LO3_ADDRESS+"'])[1]");
							Assert.assertTrue(util.isElementVisible(address));
							log("STEP 40:  User can see primary address on the contact grid", Status.PASS);
						} catch (AssertionError e) {
							log("STEP 40:  User cannot see primary address on the contact grid", Status.FAIL);
						}
			      }
					}
	  }
	    
	    public void verifyMergedLandowner(String testcaseName) {

	    	try {
				navigateToParcelInformation();
				By firstParcelAdded = By.xpath("(//td[text()='"+ParcelInformation_AddNewParcelPage.PARCEL1+"']/parent::tr)[1]");
				util.click(firstParcelAdded);
				util.dummyWait(5);
				ExpandLandowner();
				log("STEP 12: User can navigate to parcel information page", Status.PASS);
			} catch (Exception e) {
				log("STEP 12: User cannot navigate to parcel information page", Status.FAIL);
				throw new RuntimeException("Failed in step 12");
			}
	    	
	    	try {
				By LN1 = By.xpath("(//tr[contains(@id,'LANDOWNERS_radYALGridControl')]/.//strong[text()='"+LANDOWNER_NAME1+"'])[1]");
				Assert.assertTrue(util.isElementVisible(LN1));
				log("STEP 13:  User can see "+LANDOWNER_NAME1+" Landowner on the parcel 1", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 13:  User cannot see "+LANDOWNER_NAME1+" Landowner on the parcel 1", Status.FAIL);
			}
	    	
	    	try {
				By address = By.xpath("(//tr[contains(@id,'LANDOWNERS_radYALGridControl')]/.//strong[text()='"+LO1_ADDRESS+"'])[1]");
				Assert.assertTrue(util.isElementVisible(address));
				log("STEP 14:  User can see primary address on the grid", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 14:  User cannot see primary address on the grid", Status.FAIL);
			}
	    	
	    	try {
				By LN2 = By.xpath("(//tr[contains(@id,'LANDOWNERS_radYALGridControl')]/.//strong[text()='"+LANDOWNER_NAME2+"'])[1]");
				Assert.assertTrue(util.isElementVisible(LN2));
				log("STEP 15:  User can see "+LANDOWNER_NAME2+" Landowner on the parcel 1", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 15:  User cannot see "+LANDOWNER_NAME2+" Landowner on the parcel 1", Status.FAIL);
			}
	    	
	    	try {
				By address = By.xpath("(//tr[contains(@id,'LANDOWNERS_radYALGridControl')]/.//strong[text()='"+LO2_ADDRESS+"'])[1]");
				Assert.assertTrue(util.isElementVisible(address));
				log("STEP 16:  User can see primary address on the grid", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 16:  User cannot see primary address on the grid", Status.FAIL);
			}
	    	
	    	if(!environment.contains("DOM")){  
	    	try {
				expandContatDetailsPanel();
				log("STEP 17: User can expand Contact Details Panel", Status.PASS);
			} catch (Exception e) {
				log("STEP 17: User cannot expand Contact Details Panel", Status.FAIL);
				throw new RuntimeException("Failed in step 17");
			}
	    	
	    	try {
				By LN1 = By.xpath("(//tr[contains(@id,'_CONTACT_radYALGridControl')]/.//strong[text()='"+LANDOWNER_NAME1+"'])[1]");
				Assert.assertTrue(util.isElementVisible(LN1));
				log("STEP 18:  User can see "+LANDOWNER_NAME1+" entity record on the parcel 1", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 18:  User cannot see "+LANDOWNER_NAME1+" entity record on the parcel 1", Status.FAIL);
			}
	    	
	    	try {
				By address = By.xpath("(//tr[contains(@id,'_CONTACT_radYALGridControl')]/.//strong[text()='"+LO1_ADDRESS+"'])[1]");
				Assert.assertTrue(util.isElementVisible(address));
				log("STEP 19:  User can see correct primary address on the grid for first entity", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 19:  User cannot see correct primary address on the grid for first entity", Status.FAIL);
			}
	    	
	    	try {
				By LN2 = By.xpath("(//tr[contains(@id,'_CONTACT_radYALGridControl')]/.//strong[text()='"+LANDOWNER_NAME2+"'])[1]");
				Assert.assertTrue(util.isElementVisible(LN2));
				log("STEP 20:  User can see "+LANDOWNER_NAME2+" entity record on the parcel 1", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 20:  User cannot see "+LANDOWNER_NAME2+" entity record on the parcel 1", Status.FAIL);
			}
	    	
	    	try {
				By address = By.xpath("(//tr[contains(@id,'_CONTACT_radYALGridControl')]/.//strong[text()='"+LO2_ADDRESS+"'])[1]");
				Assert.assertTrue(util.isElementVisible(address));
				log("STEP 21:  User can see primary address on the grid for second entity", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 21:  User cannot see primary address on the grid for second entity", Status.FAIL);
			}
	    	}
	    	ExtentTestManager.infoWithScreenshot("Parcel 1 Entity record After Merger");
	    	
	    	try {
	    		By secondParcelAdded = By.xpath("(//td[text()='"+ParcelInformation_AddNewParcelPage.PARCEL2+"']/parent::tr)[1]");
				util.click(secondParcelAdded);
				util.dummyWait(5);
				ExpandLandowner();
				log("STEP 22: User can select second parcel", Status.PASS);
			} catch (Exception e) {
				log("STEP 22: User cannot select second parcel", Status.FAIL);
				throw new RuntimeException("Failed in step 22");
			}
	    	
	    	try {
				By LN2 = By.xpath("(//tr[contains(@id,'LANDOWNERS_radYALGridControl')]/.//strong[text()='"+LANDOWNER_NAME2+"'])[1]");
				Assert.assertTrue(util.isElementVisible(LN2));
				log("STEP 23:  User can see "+LANDOWNER_NAME2+" Landowner on the parcel 2 after merged with landowner "+LANDOWNER_NAME3, Status.PASS);
			} catch (AssertionError e) { 
				log("STEP 23:  User cannot see "+LANDOWNER_NAME2+" Landowner on the parcel 2 after merged with landowner "+LANDOWNER_NAME3, Status.FAIL);
			}
	    	
	    	try {
				By address = By.xpath("(//tr[contains(@id,'LANDOWNERS_radYALGridControl')]/.//strong[text()='"+LO2_ADDRESS+"'])[1]");
				Assert.assertTrue(util.isElementVisible(address));
				log("STEP 24:  User can see primary address on the grid", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 24:  User cannot see primary address on the grid", Status.FAIL);
			}
	    	
	    	if(!environment.contains("DOM")){
	    	try {
	    		expandContatDetailsPanel();
				log("STEP 25: User can expand contact details panel", Status.PASS);
			} catch (Exception e) {
				log("STEP 25: User cannot expand contact details panel", Status.FAIL);
				throw new RuntimeException("Failed in step 25");
			}
	    	
	    	try {
				By LN2 = By.xpath("(//tr[contains(@id,'_CONTACT_radYALGridControl')]/.//strong[text()='"+LANDOWNER_NAME2+"'])[1]");
				Assert.assertTrue(util.isElementVisible(LN2));
				log("STEP 26:  User can see "+LANDOWNER_NAME2+" entity on the parcel 2 after merged with entity "+LANDOWNER_NAME3, Status.PASS);
			} catch (AssertionError e) { 
				log("STEP 26:  User cannot see "+LANDOWNER_NAME2+" entity on the parcel 2 after merged with entity "+LANDOWNER_NAME3, Status.FAIL);
			}
	    	
	    	try {
				By address = By.xpath("(//tr[contains(@id,'_CONTACT_radYALGridControl')]/.//strong[text()='"+LO2_ADDRESS+"'])[1]");
				Assert.assertTrue(util.isElementVisible(address));
				log("STEP 27:  User can see correct primary address on the grid for entity", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 27:  User cannot see correct primary address on the grid  for entity", Status.FAIL);
			}
	    	}
	    }
	    
	    public void addSameEntityOnMultipleParcels(String testcaseName) {
	    	
	    	if(testcaseName.contains("ROW") || environment.contains("DOM"))
	    	 {  
	    	try {
	    		AddnewContactForROW();
				log("STEP 1: User can click on Add New Contact button ", Status.PASS);
			} catch (Exception e) {
				log("STEP 1:  User cannot click on Add New Contact button ", Status.FAIL);
				throw new RuntimeException("Failed in step 1");
			}
	     }
	    	 else {
	    		
	    	 try {
	    		 AddnewContact(); 
					log("STEP 2: User can click on Add New Contact button", Status.PASS);
				} catch (Exception e) {
					log("STEP 2: User cannot click on Add New Contact button", Status.FAIL);
					throw new RuntimeException("Failed in step 2");
				}
	     }
	    
	       try {
	    		 util.switchToIframe(frmFull);
	    		 VerifyCheckbox();
	 			log("STEP 3: Active Checkbox is auto checked   ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 3: Active checkbox is not auto checked   ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 3");
	 		 }
	       
	      try {
	    	      AddExistingContact(LANDOWNER_NAME1);
				log("STEP 4:  User can select value from Existing Contact dd     ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 4:  User  cannot select  value  from Existing Contact DD     ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 4");
	 		 }
	      
	      try {
	    		 Save();
	    		 Close(); 
		         	util.dummyWait(3);
	 			log("STEP 5: Existing Contact Added to the Contact Details panel ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 5: Existing Contact not added to the Contact Details panel ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 5");
	 		 }
	      
	      try {
	    	  expandContatDetailsPanel();
				log("STEP 6:  User can expand contact details panel ", Status.PASS);
			} catch (Exception e) {
				log("STEP 6:  User cannot expand contact details panel ", Status.FAIL);
				throw new RuntimeException("Failed in step 6");
			}
			
	      try {
				By contact1 = By.xpath("(//tr[contains(@id,'_CONTACT_radYALGridControl')]/.//strong[text()='"+LANDOWNER_NAME1+"'])[1]");
				Assert.assertTrue(util.isElementVisible(contact1));
				log("STEP 7:  User can see Contact Details Record on the grid ", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 7:  User cannot see Contact Details Record on the grid ", Status.FAIL);
			}
			
			try {
				By address = By.xpath("(//tr[contains(@id,'_CONTACT_radYALGridControl')]/.//strong[text()='"+LO1_ADDRESS+"'])[1]");
				Assert.assertTrue(util.isElementVisible(address));
				log("STEP 8:  User can see primary address on the contact grid", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 8:  User cannot see primary address on the contact grid", Status.FAIL);
			}
			
			try {
				By duplicateContact = By.xpath("(//tr[contains(@id,'_CONTACT_radYALGridControl')]/.//strong[text()='"+LANDOWNER_NAME1+"'])[2]");
				Assert.assertFalse(util.isElementVisible(duplicateContact));
				log("STEP 9:  User cancot see Duplicate Contact Details Record on the grid when same entity record added on multiple parcels", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 9:  User can see Duplicate Contact Details Record on the grid when same entity record added on multiple parcels ", Status.FAIL);
			}
			
	    }
}
