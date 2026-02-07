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

public class AddNewOperatingCompanyPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;
	public String OperatingCompany;

	public AddNewOperatingCompanyPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	
	By navAdministration = By.xpath("//span[text()='Administration']");
	By navConfiguration = By.xpath("//span[text()='Configuration']");
	By navOperatingCompanies = By.xpath("//span[contains(text(),'Operating Companies')]");
	By btnAddNewRecord = By.xpath("(//a[contains(@id,'lnkAddNewRecord')])");
	By CompanyDetails = By.xpath("//span[contains(text(),'Company Details')]");
	By drpArea = By.xpath("//input[contains(@id,'EditFormControl_Area_ID_radYALDropDownList_Input')]");
	By txtOperatingCompany = By.xpath("//input[contains(@id,'EditFormControl_COMPANY_NAME')and @type='text']");
	By drpStateIncorporated = By.xpath("//input[contains(@id,'EditFormControl_STATE_INCORP_ABB_radYALDropDownList_Input')and @type='text']");
    By txtAbbrevation = By.xpath("//input[contains(@id,'EditFormControl_ABB')and @type='text']");
    By txtGLUnit = By.xpath("//input[contains(@id,'EditFormControl_G_L_Unit')and @type='text']");
    By txtComment = By.xpath("//textarea[contains(@id,'EditFormControl_Comments')]");
    By txtBlankInstruction = By.xpath("//textarea[contains(@id,'EditFormControl_Bank_Instructions')]");
    By btnInsert = By.xpath("//input[contains(@id,'EditFormControl_btnInsert')]");
	By SuccessMessage = By.xpath("//span[text()='Changes saved successfully!']");
	By btnCancel = By.xpath("//input[contains(@id,'EditFormControl_btnCancel') ]");
	By btnEdit = By.xpath("(//input[contains(@id,'EditButton')])[last()]");
	By btnUpdate = By.xpath("//input[contains(@id,'EditFormControl_btnUpdate')]");
    By Address = By.xpath("//span[contains(text(),'Address')]");
    By txtAddressLine1 = By.xpath("//input[contains(@id,'_Address_Line_1') and @type='text']");
	By txtAddressLine2 = By.xpath("//input[contains(@id,'_Address_Line_2') and @type='text']");
	By txtCity = By.xpath("//input[contains(@id,'_City') and @type='text']");
	By drpState = By.xpath("(//input[contains(@id,'Address_STATE_ID') and @type='text'])[1]");
	By txtZipCode = By.xpath("(//input[contains(@id,'Zip_Code') and @type='text'])[1]");
    By txtZipCodePlus = By.xpath("(//input[contains(@id,'_Zip_Code_Plus') and @type='text'])[1]");
	By txtAddressLine3 = By.xpath("//input[contains(@id,'_Line_3') and @type='text']");
    By txtEmail = By.xpath("(//input[contains(@id,'_Email') and @type='text'])[1]");
	By txtHomePhone = By.xpath("(//input[contains(@id,'_Home_Phone') and @type='text'])[1]");
	By txtCellPhone = By.xpath("//input[contains(@id,'_Cell_Phone') and @type='text']");
	By txtWorkPhone = By.xpath("//input[contains(@id,'_Work_Phone') and @type='text']");
    By txtInterationalPhone = By.xpath("(//input[contains(@id,'_Intl_Phone') and @type='text'])[1]");
	By txtFaxPhone  = By.xpath("//input[contains(@id,'FaxNumber') and @type='text']"); 
	By btnDelete = By.xpath("(//input[contains(@id,'gbcDeleteAlignment')])[last()]");
	By btncancel = By.xpath("//span[text()='Cancel']");
	By btnOk = By.xpath("//span[text()='OK']");
	By firstOC = By.xpath("(//*[contains(@id,'EditFormControl_Area_ID_radYALDropDownList_DropDown')]/..//li[not(contains(text(),'Select One'))])[1]");
	By btnOperatingComapnies =  By.xpath("(//a[normalize-space()='Operating Companies'])[2]");
    By drpLesses = By.xpath("//input[contains(@id,'ProjectGrantees_GRANTEES_ID_OnDemand_Input')]");
	
	public void NavigateToOperatingCompanies() {
		util.waitUntilElementDisplay(navAdministration);
		util.click(navAdministration);
		util.waitUntilElementDisplay(navConfiguration);
		util.click(navConfiguration);
		util.waitUntilElementDisplay(navOperatingCompanies);
		util.click(navOperatingCompanies);
	}
	
	public void ClickOnAddNewRecordButton() {
		util.waitUntilElementDisplay(btnAddNewRecord);
		util.click(btnAddNewRecord);
	}
	
	public void AddOperatingCompany(String value) {
		if (!commonFunction.checkNA(value)) 
			util.inputTextAndPressTab(txtOperatingCompany, value);
	}
	
	public void AddStateIncorporated(String value) {
		if (!commonFunction.checkNA(value)) 
			util.inputTextAndPressTab(drpStateIncorporated, value);
	}
	
	public void AddAbbrevation(String value) {
		if (!commonFunction.checkNA(value)) 
			util.inputTextAndPressTab(txtAbbrevation, value);
	}
	
	public void AddGLUnit(String value) {
		if (!commonFunction.checkNA(value)) 
			util.inputTextAndPressTab(txtGLUnit, value);
	}
	
	public void AddArea(String value) {
		if (!commonFunction.checkNA(value)) 
			util.inputTextAndPressTab(drpArea, value);
	}
	
	public void AddComment(String value) {
		if (!commonFunction.checkNA(value)) 
			util.inputTextAndPressTab(txtComment, value);
	}
	
	public void AddBlankInstruction(String value) {
		if (!commonFunction.checkNA(value)) 
			util.inputTextAndPressTab(txtBlankInstruction, value);
	}

	
	public void ClickOnInsertButton() {
		util.waitUntilElementDisplay(btnInsert);
		util.click(btnInsert);
		util.dummyWait(1);
	}
	
	public void ClickOnCancelButton() {
		util.waitUntilElementDisplay(btnAddNewRecord);
		util.click(btnAddNewRecord);
		util.dummyWait(1);
		util.waitUntilElementDisplay(btnCancel);
		util.click(btnCancel);
		util.dummyWait(1);
	}
	
	public void ClickOnEditButton() {
		util.waitUntilElementDisplay(btnEdit);
		util.click(btnEdit);
		util.dummyWait(1);
	}
	
	public void ClickOnUpdateButton() {
		util.waitUntilElementDisplay(btnUpdate);
		util.click(btnUpdate);
		util.dummyWait(1);
	}

	public void ClickOnAddress() {
		util.click(Address);
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
	
	public void Updatevalue(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtCity, value);
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

	 public void ClickonOk()  {
		    util.waitUntilElementDisplay(btnDelete);
	  		util.click(btnDelete);	
	  		util.waitUntilElementDisplay(btnOk);
	  		util.click(btnOk);
	  		util.dummyWait(2);
	  		util.waitUntilElementDisplay(SuccessMessage);
			Assert.assertTrue(util.isElementPresent(SuccessMessage), "Changes saved successfully!");
		
	    }
	 
	 public void verifyGrantees(String value) {
			util.inputText(drpLesses, value);
			By operatingComp = By.xpath("//div[contains(@id,'ProjectGrantees_GRANTEES_ID_OnDemand_DropDown')]/..//em[contains(text(),'"+value+"')]");
		    Assert.assertTrue(util.isElementVisible(operatingComp));
	 }
	 
	 public void AddNewOperatingCompany(Map<String, String> map, String testcaseName) {
			try {
				NavigateToOperatingCompanies();
				ClickOnAddNewRecordButton();
				log("STEP 1: Add new popup display with blank fields", Status.PASS);
			} catch (Exception e) {
				log("STEP 1: Popup up does not appear", Status.FAIL);
				throw new RuntimeException("Failed in step 1: Popup up does not appear");
			}

			try {
				AddOperatingCompany(map.get(Excel.OperatingCompany));
				OperatingCompany =map.get(Excel.OperatingCompany);
				log("STEP 2:   User can enter the value in Operating Company field", Status.PASS);
			} catch (Exception e) {
				log("STEP 2:    User cannot enter the value in Operating Company field", Status.FAIL);
				throw new RuntimeException("Failed in step 2");
			}
			try {
				AddStateIncorporated(map.get(Excel.State));
				log("STEP 3: User can enter the value in State field ", Status.PASS);
			} catch (Exception e) {
				log("STEP 3:  User cannot enter the value in State field", Status.FAIL);
				throw new RuntimeException("Failed in step 3");
			}
			
			try {
				AddAbbrevation(map.get(Excel.Abbreviation));
				log("STEP 4: User can enter the value in Abbreviation field", Status.PASS);
			} catch (Exception e) {
				log("STEP 4: User cannot enter the value in Abbreviation field", Status.FAIL);
				throw new RuntimeException("Failed in step 4");
			}
			
			try {
				AddGLUnit(map.get(Excel.GLUnit));
				log("STEP 5: User can enter the value in GLUnit field ", Status.PASS);
			} catch (Exception e) {
				log("STEP 5:  User cannot enter the value in GLUnit field ", Status.FAIL);
				throw new RuntimeException("Failed in step 5");
			}
			
			try {
				//AddArea(map.get(Excel.Area));
				util.waitUntilElementDisplay(drpArea);
    			util.click(drpArea);
    			util.click(firstOC);
				log("STEP 6: User can enter the value in Area field", Status.PASS);
			} catch (Exception e) {
				log("STEP 6: User cannot enter the value in Area field", Status.FAIL);
				throw new RuntimeException("Failed in step 6");
			}
			
			
			try {
				AddComment(map.get(Excel.Comment));
				log("STEP 7: User can enter the value in Comment field    ", Status.PASS);
			} catch (Exception e) {
				log("STEP 7: User cannot enter the value in Comment field  ", Status.FAIL);
				throw new RuntimeException("Failed in step 7");
			}
			try {
				AddBlankInstruction(map.get(Excel.BlankInstruction));
				log("STEP 8: User can enter the value in Blank Instruction field  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 8: User cannot enter the value in Blank Instruction field", Status.FAIL);
				throw new RuntimeException("Failed in step 8");
			}
			
		if(util.isElementVisible(Address)) {
			try {
				 ClickOnAddress();
					log("STEP 9: User can see the Address Tab", Status.PASS);
				} catch (Exception e) {
					log("STEP 9: User cannot see the Address Tab", Status.FAIL);
					throw new RuntimeException("Failed in step 9");
				}
			 
			 try {
					AddAddressLine1(map.get(Excel.AddressLine1));
					log("STEP 10: User can enter the value in Address Line1 field ", Status.PASS);
				} catch (Exception e) {
					log("STEP 10:  User cannot enter the value in Address Line1 field", Status.FAIL);
					throw new RuntimeException("Failed in step 10");
				}
				
				try {
					AddAddressLine2(map.get(Excel.AddressLine2));
					log("STEP 11: User can enter the value in Address Line2 field ", Status.PASS);
				} catch (Exception e) {
					log("STEP 11:  User cannot enter the value in Address Line2 field", Status.FAIL);
					throw new RuntimeException("Failed in step 11");
				}
				

				try {
					AddCity(map.get(Excel.City));
					log("STEP 12: User can enter the value in City field ", Status.PASS);
				} catch (Exception e) {
					log("STEP 12:  User cannot enter the value in City field", Status.FAIL);
					throw new RuntimeException("Failed in step 12");
				}
				
				try {
					SelectState(map.get(Excel.State));
					log("STEP 13: User can enter the value in State field ", Status.PASS);
				} catch (Exception e) {
					log("STEP 13:  User cannot enter the value in State field", Status.FAIL);
					throw new RuntimeException("Failed in step 13");
				}
				
				try {
					AddZipCode(map.get(Excel.ZipCode));
					log("STEP 14: User can enter the value in Zip Code field ", Status.PASS);
				} catch (Exception e) {
					log("STEP 14:  User cannot enter the value in Zip Code field", Status.FAIL);
					throw new RuntimeException("Failed in step 14");
				}
				
//				try {
//					AddZipCodePlus(map.get(Excel.ZipCodePlus));
//					log("STEP 15: User can enter the value in Zip Code Plus field ", Status.PASS);
//				} catch (Exception e) {
//					log("STEP 15:  User cannot enter the value in Zip Code Plus field", Status.FAIL);
//					throw new RuntimeException("Failed in step 15");
//				}
				
				try {
					AddAddressLine3(map.get(Excel.AddressLine3));
					log("STEP 16: User can enter the value in Address Line3 field ", Status.PASS);
				} catch (Exception e) {
					log("STEP 16:  User cannot enter the value in Address Line3 field", Status.FAIL);
					throw new RuntimeException("Failed in step 16");
				}
				
				try {
					AddEmail(map.get(Excel.Email));
					log("STEP 17: User can enter the value in Email field ", Status.PASS);
				} catch (Exception e) {
					log("STEP 17:  User cannot enter the value in Email field", Status.FAIL);
					throw new RuntimeException("Failed in step 17");
				}
				
				try {
					AddHomePhone(map.get(Excel.HomePhone));
					log("STEP 18: User can enter the value in Home Phone field ", Status.PASS);
				} catch (Exception e) {
					log("STEP 18:  User cannot enter the value in Home Phone field", Status.FAIL);
					throw new RuntimeException("Failed in step 18");
				}
				
				try {
					AddCellPhone(map.get(Excel.CellPhone));
					log("STEP 19: User can enter the value in CellPhone field ", Status.PASS);
				} catch (Exception e) {
					log("STEP 19:  User cannot enter the value in CellPhone field", Status.FAIL);
					throw new RuntimeException("Failed in step 19");
				}
				
				try {
					AddWorkPhone(map.get(Excel.WorkPhone));
					log("STEP 20: User can enter the value in Work Phone field ", Status.PASS);
				} catch (Exception e) {
					log("STEP 20:  User cannot enter the value in Work Phone field", Status.FAIL);
					throw new RuntimeException("Failed in step 20");
				}
		}
				if(testcaseName.contains("ROW") || testcaseName.contains("TRA")) {
					try {
						AddFaxPhone(map.get(Excel.CellPhone));
						log("STEP 21: User can enter the value in Cell Phone field ", Status.PASS);
					} catch (Exception e) {
						log("STEP 21:  User cannot enter the value in Cell Phone field", Status.FAIL);
						throw new RuntimeException("Failed in step 21");
					}
				}
					

				try {
					ClickOnInsertButton();
					log("STEP 22: Added address displays in the grid", Status.PASS);
				} catch (Exception e) {
					log("STEP 22: Added record does not display in the grid", Status.FAIL);
					throw new RuntimeException("Failed in step 22");
				}
				
				if (util.isElementPresent(SuccessMessage)) {
					   log("STEP 23 :Changes saved sucessfully ! message will be display in green color.   ", Status.PASS);
					} else {
					   log("STEP 23:  Error message should  be display."  , Status.FAIL);
				      throw new RuntimeException("Faild in STEP 23");
			   	} 
				
				try {
					ClickOnCancelButton();
					log("STEP 24: User should not be created and Window get  closed ", Status.PASS);
				} catch (Exception e) {
					log("STEP 24: Window should not be closed", Status.FAIL);
					throw new RuntimeException("Failed in step 24");
				}
				
				try {
					ClickOnEditButton();
					 ClickOnAddress();
					log("STEP 25: Existing User record should be open  ", Status.PASS);
				} catch (Exception e) {
					log("STEP 25: Existing User record should not be open", Status.FAIL);
					throw new RuntimeException("Failed in step 25");
				}
				
				try {
					Updatevalue(map.get(Excel.UpdatedValue));
					log("STEP 26: User can update a value in the field/s   ", Status.PASS);
				} catch (Exception e) {
					log("STEP 26: User cannot update a value in the field/s ", Status.FAIL);
					throw new RuntimeException("Failed in step 26");
				}
				
				try {
					ClickOnUpdateButton();
					log("STEP 27: Added Contact information should get display on the grid ", Status.PASS);
				} catch (Exception e) {
					log("STEP 27: Contact information not get displaying on the grid", Status.FAIL);
					throw new RuntimeException("Failed in step 27");
				}
				
				if(testcaseName.contains("ROW")) {
				try {
					commonFunction.navigateToProjectDeails();
					log("STEP 28: User can navigate to Project Details Page", Status.PASS);
				} catch (Exception e) {
					log("STEP 28: User cannot navigate to Project Details Page", Status.FAIL);
					throw new RuntimeException("Failed in step 28");
				}
				
				try {
					util.click(btnOperatingComapnies);
					log("STEP 29: User can expand Operating Companies panel", Status.PASS);
				} catch (Exception e) {
					log("STEP 29: User cannot expand Operating Companies panel", Status.FAIL);
					throw new RuntimeException("Failed in step 29");
				}
				
				try {
					verifyGrantees(OperatingCompany);
					log("STEP 30: User can see newly Created Operating company in Grantees DD", Status.PASS);
				} catch (Exception e) {
					log("STEP 30: User cannot see newly Created Operating company in Grantees DD", Status.FAIL);
				}
				
				try {
					NavigateToOperatingCompanies();
					log("STEP 31: User can navigate to Operating Companies menu", Status.PASS);
				} catch (Exception e) {
					log("STEP 31: User cannot navigate to Operating Companies menu", Status.FAIL);
					throw new RuntimeException("Failed in step 31");
				}
				}
				
				 try {
					 ClickOnDeleteButton();
						log("STEP 32:  Popup Delete should be open with OK and Cancel button    ", Status.PASS);
					} catch (Exception e) {
						log("STEP 32:  Popup Delete does not open", Status.FAIL);
						throw new RuntimeException("Failed in step 32 ");
					}

				 try {
					 ClickonCancle();
						log("STEP 33: User can click on cancel button  ", Status.PASS);
					} catch (Exception e) {
						log("STEP 33: User cannot click on cancel button", Status.FAIL);
						throw new RuntimeException("Failed in step 33 ");
					}
				 
				 try {
					 ClickonOk();
						log("STEP 34: User can delete the record ", Status.PASS);
					} catch (Exception e) {
						log("STEP 34: User cannot delete the record", Status.FAIL);
						throw new RuntimeException("Failed in step 34");
					}			
			
	 }
	
}
