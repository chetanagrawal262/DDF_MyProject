package pages.TicketAssociation;

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

import extentReports.ExtentTestManager;

public class AddNewTicketPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;
	public static String CATEGORY, STATUS, TICKET_COUNT;
	int count;

	public AddNewTicketPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		
	}
	
	By navAdministration = By.xpath("//span[text()='Administration']");
	By navCustomerOutreach = By.xpath("//span[contains(text(),'Customer Outreach')]");
	By navTicketInformation = By.xpath("(//span[contains(text(),'Ticket Information')])[1]");
	By btnNew = By.xpath("//img[@alt='New']");
	By btnAddNew = By.xpath("//span[contains(text(),'Add Ticket')]");
	By txtIssue = By.xpath("//input[contains(@id,'_Ticket_Number') and @type='text']");
	By drpCategory = By.xpath("//input[contains(@id,'_Category_ID_radYALDropDownList_Input') and @type='text']");
	By drpSubcategory = By.xpath("//input[contains(@id,'_SubCategory_ID_radYALDropDownList_Input') and @type='text']");
	By drpMethod = By.xpath("//input[contains(@id,'_Method_ID_radYALDropDownList_Input') and @type='text']");
	By drpPriority = By.xpath("//input[contains(@id,'_Priority_ID_radYALDropDownList_Input') and @type='text']");
	By txtDateIdentified = By.xpath("//input[contains(@id,'_Date_Identified_dateInput') and @type='text']");
	By drpCreatedBy = By.xpath("//input[contains(@id,'_Created_By_radYALDropDownList_Input') and @type='text']");
	By drpStatus = By.xpath("//input[contains(@id,'_Status_ID_radYALDropDownList_Input') and @type='text']");
	By txtFollowupDate = By.xpath("//input[contains(@id,'_Followup_Date_dateInput') and @type='text']");
	By txtCallerName = By.xpath("//input[contains(@id,'_Caller_Name') and @type='text']");
	By txtPhoneNo = By.xpath("//input[contains(@id,'_Phone_No') and @type='text']");
	By NoCheckbox = By.xpath("//input[contains(@id,'_No_Phone') and @type='checkbox']");
	By txtGeneralLocation = By.xpath("//*[text()='General Location:']/..//input[contains(@id,'CustControlTicketInfo') and contains(@class,'TextBox')]");
	By drpContactType = By.xpath("//*[text()='Contact Type:']/..//input[contains(@id,'CustControlTicketInfo') and @type='text']");
    By drpContactSource = By.xpath("//*[text()='Contact Source:']/..//input[contains(@id,'CustControlTicketInfo') and @type='text']");
    By txtEmail = By.xpath("//*[text()='Email:']/..//input[contains(@id,'CustControlTicketInfo') and contains(@class,'TextBox')]");
    By txtAdditionContactInformation = By.xpath("//*[text()='Additional Contact Information:']/..//input[contains(@id,'CustControlTicketInfo') and contains(@class,'TextBox')]");
    By txtAddressLine1 = By.xpath("//input[contains(@id,'_Address_Line_1') and @type='text']");
    By txtAddressLine2 = By.xpath("//input[contains(@id,'_Address_Line_2') and @type='text']");		
	By txtCity = By.xpath("//input[contains(@id,'City') and @type='text']");
	By drpState = By.xpath("//input[contains(@id,'_STATE_ID_Input') and @type='text']");
	By drpCounty = By.xpath("//input[contains(@id,'_COUNTY_ID_Input') and @type='text']");
	By txtZipCode = By.xpath("(//*[text()='Zip Code:']/..//input[contains(@id,'CustControlTicketInfo') and contains(@class,'TextBox')])[1]");
	By txtPObox = By.xpath("//*[text()='PO Box :']/..//input[contains(@id,'CustControlTicketInfo') and contains(@class,'TextBox')]");
	By txtZipcode2 = By.xpath("(//input[contains(@id,'Zip_Code2') and @type='text'])[1]");
	By txtAddressLine3 = By.xpath("//input[contains(@id,'_Address_Line_3') and @type='text']");
	By txtTownShip = By.xpath("//input[contains(@id,'_Township') and @type='text']");
	By drpAreaTeam = By.xpath("(//span[@class='rddtFakeInput rddtEmptyMessage'])[1]");
	By drpProject = By.xpath("(//span[@class='rddtIcon'])[2]");
	By ImmediateActionCheckbox =By.xpath("//*[text()='Immediate Action Required:']/..//input[contains(@id,'CustControlTicketInfo') and @type='checkbox']");
	By drpSensitiveTicket = By.xpath("//*[text()='Sensitive Ticket:']/..//input[contains(@id,'CustControlTicketInfo') and @type='text']");
	By txtResolutionDate = By.xpath("//*[text()='Resolution Date:']/..//input[contains(@id,'CustControlTicketInfo') and contains(@class,'TextBox')] | //*[text()='Target Resolution Date:']/..//input[contains(@id,'CustControlTicketInfo') and contains(@class,'TextBox')]");
	By txtSpecialCircumstances = By.xpath("//*[text()='Special Circumstances:']/..//textarea[contains(@id,'CustControlTicketInfo') and contains(@class,'TextBox')]");
	By txtActionTaken = By.xpath("//*[text()='Action Taken:']/..//textarea[contains(@id,'CustControlTicketInfo') and contains(@class,'TextBox')]");
	By txtVoiceOfCustomer = By.xpath("//*[text()='Voice of Customer']/..//textarea[contains(@id,'CustControlTicketInfo') and contains(@class,'TextBox')]");
    By txtResolution = By.xpath("//*[text()='Resolution:']/..//textarea[contains(@id,'CustControlTicketInfo') and contains(@class,'TextBox')]");
    By txtIssueDescription = By.xpath("//textarea[contains(@id,'_Issue_Desc')]");
    By btnSave = By.xpath("//input[contains(@id,'_btnSaveJob') and @type='button']");
    By btnSaveandAdd = By.xpath("(//input[contains(@id,'_btnSaveAddNew') and @type='button'])[1]");
    By SuccessMessage = By.xpath("(//span[contains(@id,'_usrMessage')])[1]");
    By ParcelInformation = By.xpath("(//span[text()='Parcel Information' and @class='rtsTxt'])[1] | (//span[text()='Tract Information'])[2]");
    By DefaultParcelMessage = By.xpath("(//*[text()='No Parcel are currently assigned to ticket'])[1] | (//*[text()='No Tract are currently assigned to ticket'])[1] | (//*[text()='No parcel are currently assigned to ticket'])[1] ");	
    By panelIssueMetrics = By.xpath("//em[text()='Issues Metrics']/..//span[@class='rdExpand']");
    By LeaseInformtion = By.xpath("//span[contains(text(),'Lease Information')]");
    By DefaultLeaseMessage = By.xpath("//div[text()='No Lease are currently assigned to ticket'] | //div[text()='No Agreement are currently assigned to ticket'] | //div[text()='No Entity are currently assigned to ticket']");	
    
    public void AddTicket() {
    	util.waitUntilElementDisplay(navAdministration);
    	util.click(navAdministration);
    	util.waitFor(200);
    	util.waitUntilElementDisplay(navCustomerOutreach);
    	util.hoverOnElement(navCustomerOutreach);
    	//util.waitUntilElementDisplay(navTicketInformation);
    	util.click(navTicketInformation);
    	util.waitUntilElementDisplay(btnNew);
    	util.click(btnNew);
    	util.waitUntilElementDisplay(btnAddNew);
    	util.click(btnAddNew);
    }
    
    public void AddTicketRow() {
//    	util.waitUntilElementDisplay(navAdministration);
//    	util.click(navAdministration);
    	util.waitUntilElementDisplay(navCustomerOutreach);
    	util.click(navCustomerOutreach);
    	util.waitUntilElementDisplay(navTicketInformation);
    	util.click(navTicketInformation);
    	util.waitUntilElementDisplay(btnNew);
    	util.click(btnNew);
    	util.waitUntilElementDisplay(btnAddNew);
    	util.click(btnAddNew);
    }
    
    public void ClickOnLeaseInformtion() {
		util.waitUntilElementDisplay(LeaseInformtion);
		util.click(LeaseInformtion);
	}
    
    public void AddIssue(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtIssue, util.randomNumber());
    }
    
    public void SelectCategory(String value) {
    	util.dummyWait(2);
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpCategory,value);
    }
    
    public void SelectSubcategory(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpSubcategory,value);
    }
    
    public void SelectMethod(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpMethod,value);
    }
    
    By firstMethod = By.xpath("(//div[contains(@id,'_Method_ID_radYALDropDownList_DropDown')]/..//li[not(contains(text(),'Select One'))])[1]");
    public void SelectMethod() {
    	util.click(drpMethod);
    	util.click(firstMethod);
    }
    
    public void SelectPriority(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpPriority,value);
    }
    
    public void AddDateIdentified(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtDateIdentified,value);
    }
    
    public void SelectCreatedBy(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpCreatedBy,value);
    }
    
    public void SelectStatus(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpStatus,value);
    }
    
    public void AddFollowupDate(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtFollowupDate,value);
    }
    
    public void AddCallerName(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtCallerName,value);
    }
    
    public void AddPhoneNo(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtPhoneNo,value);
    }
    
    public void ClickonNoCheckbox() {
    	util.waitUntilElementDisplay(NoCheckbox);
    	util.click(NoCheckbox);
    }
    
    public void AddGeneralLocation(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtGeneralLocation,value);
    }
    
    public void SelectContactType(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpContactType,value);
    }
    
    public void SelectContactSource(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpContactSource,value);
    }
    
    public void AddEmail(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtEmail,value);
    }
    
    public void AddAdditionContactInformation(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtAdditionContactInformation,value);
    }
    
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
    	util.dummyWait(2);
    }
    
    public void SelectCounty(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpCounty,value);
    }
    
    public void AddZipCode(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtZipCode,value);
    }
    
    public void AddPObox(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtPObox,value);
    }
    
    public void AddZipcode2(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtZipcode2,value);
    }
    
    public void AddAddressLine3(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtAddressLine3,value);
    }
    
    public void AddTownShip(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtTownShip,value);
    }
    
    By Area = By.xpath("(//span[contains(@class,'rddtEmptyMessage')])[1]");
    By txtArea = By.xpath("(//input[contains(@value,'Filtering...')])[1]");
     public void SelectAreaTeam(String value) {
    	 util.click(Area);
 	    	if (!commonFunction.checkNA(value))
 				util.inputText(txtArea, value);
 	    	util.pressDownkey();
 	    	util.pressDownkey();
 	    	util.pressENTERkey();
 	    	util.dummyWait(2);
     	
     }
    // By AreaROW = By.xpath("//span[contains(@class,'rddtInner rddtFocused')]");
     By AreaROW = By.xpath("//*[contains(text(),'Area')]/..//div[contains(@id,'RadDropDownTree')]");
     By txtAreaROW = By.xpath("(//input[contains(@value,'Filtering...')])[1]");

     public void SelectAreaTeamRow(String value) {
    	if(util.isElementVisible(AreaROW)) {
    	 util.click(AreaROW);
  	    	if (!commonFunction.checkNA(value))
  				util.inputText(txtAreaROW, value);
  	    	util.pressDownkey();
  	    	util.pressDownkey();
  	    	util.pressENTERkey();
  	    	util.dummyWait(2);
    	}
      }
 
    
     By Project = By.xpath("(//span[contains(@class,'rddtEmptyMessage')])[1]");
     By ProjectClose = By.xpath("//*[text()='Project']/..//span[@class='rddtIcon'] | //*[text()='Line/Project:']/..//span[@class='rddtIcon']");
     By txtProject = By.xpath("(//input[contains(@value,'Filtering...')])[1]");
      public void SelectProject(String value) {
      	 util.click(Project);
 	    	if (!commonFunction.checkNA(value))
 	    		util.inputText(txtProject, value);
 	    	String drpSelectName = "//ul//li[normalize-space()='" + value + "']//input";
 	    	 util.click(drpSelectName);
 	    	 util.click(ProjectClose);
      }
     
     
      By ProjectSteelhead = By.xpath("//span[text()='Project']/..//input[@type='text']");
       public void SelectProjectSteelhead(String value) {
  	    	if (!commonFunction.checkNA(value))
  	    		util.inputTextAndPressTab(ProjectSteelhead, value);
       }
      
     
     
     
     
    public void ClickonImmediateActionCheckbox() {
    	util.waitUntilElementDisplay(ImmediateActionCheckbox);
    	util.click(ImmediateActionCheckbox);
    }
    
    public void SelectSensitiveTicket(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpSensitiveTicket,value);
    }
    
    public void AddResolutionDate(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtResolutionDate,value);
    }
    
    public void AddSpecialCircumstances(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtSpecialCircumstances,value);
    }
    
    public void AddActionTaken(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtActionTaken,value);
    }
    
    public void AddResolution(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtResolution,value);
    }
    
    public void AddIssueDescription(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtIssueDescription,value);
    }
    
    public void AddVoiceOfCustomer(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtVoiceOfCustomer,value);
    }
    
    public void ClickonSaveButton() {
    	util.waitUntilElementDisplay(btnSave);
    	util.click(btnSave);
    }
    
    By btnOk = By.xpath("//span[text()='OK']");
    public void ClickonSaveAndAddNew() {
    	util.waitUntilElementDisplay(btnSaveandAdd);
    	util.click(btnSaveandAdd);
    }
    
    public void ClickOnParcelInformation() {
 	   util.waitUntilElementDisplay(ParcelInformation);
 	   util.click(ParcelInformation);
 	   util.dummyWait(1);
    }  
    
    
    
    
    public void AddNewTicket(Map<String, String> map, String testcaseName) {
    	if(testcaseName.contains("ROW") || testcaseName.contains("TRA")) {
    		try {
    	  		AddTicketRow();
    				log("STEP 1: Record Grid should expands below ", Status.PASS);
    			} catch (Exception e) {
    				log("STEP 1:  Record does not expand below", Status.FAIL);
    				throw new RuntimeException("Failed in step 1");
    			}
    	}
    	else {
    		try {
    	  		AddTicket();
    				log("STEP 1: Record Grid should expands below ", Status.PASS);
    			} catch (Exception e) {
    				log("STEP 1:  Record does not expand below", Status.FAIL);
    				throw new RuntimeException("Failed in step 1");
    			}
    	}
  	  
  	  
  	  try {
  	if(util.isElementVisible(panelIssueMetrics)) {
  		util.click(panelIssueMetrics);
  	}
			log("STEP 2: User can expand Issue Metrics panel ", Status.PASS);
		} catch (Exception e) {
			log("STEP 2: User cannot expand Issue Metrics panel ", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}
  	  
  	  try {
  		SelectCategory(map.get(Excel.Category));
  		CATEGORY=map.get(Excel.Category);
  		 By category = By.xpath("//td[text()='"+CATEGORY+"']/..//td[4]");
  		 if(util.isElementVisible(category)) {
  			 TICKET_COUNT=driver.findElement(category).getText();
  			 count=Integer.parseInt(TICKET_COUNT);
  		 }else {
  			count=0;
  		 }
			log("STEP 3: Entered value should diplays in the Category ", Status.PASS);
		} catch (Exception e) {
			log("STEP 3: Entered value does not display in Category ", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}
  	  
  	 try {
  		SelectSubcategory(map.get(Excel.Subcategory));
 			log("STEP 4: Entered value should diplays in the Subcategory field ", Status.PASS);
 		} catch (Exception e) {
 			log("STEP 4: Entered value does not display in Subcategory field. ", Status.FAIL);
 			throw new RuntimeException("Failed in step 4");
 		}
  	 
  	try {
  		SelectMethod();
 			log("STEP 5: Entered value should diplays in the Method field ", Status.PASS);
 		} catch (Exception e) {
 			log("STEP 5: Entered value does not display in Method field. ", Status.FAIL);
 			throw new RuntimeException("Failed in step 5");
 		}
  	
	try {
		SelectPriority(map.get(Excel.Priority));
 			log("STEP 6: Entered value should diplays in the Priority field ", Status.PASS);
 		} catch (Exception e) {
 			log("STEP 6: Entered value does not display in Priority field. ", Status.FAIL);
 			throw new RuntimeException("Failed in step 6");
 		}
	
	try {
		AddDateIdentified(map.get(Excel.DateIdentified));
 			log("STEP 7: Entered value should diplays in the Date Identified field ", Status.PASS);
 		} catch (Exception e) {
 			log("STEP 7: Entered value does not display in Date Identified field. ", Status.FAIL);
 			throw new RuntimeException("Failed in step 7");
 		}
	
	try {
		SelectCreatedBy(map.get(Excel.CreatedBy));
 			log("STEP 8: Entered value should diplays in the Created By field ", Status.PASS);
 		} catch (Exception e) {
 			log("STEP 8: Entered value does not display in Created By field. ", Status.FAIL);
 			throw new RuntimeException("Failed in step 8");
 		}
	
	try {
//		if(environment.contains("GRAYHAWKTCE")) {
			util.inputText(drpStatus, map.get(Excel.Status));
			util.pressENTERkey();
//			SelectStatus(map.get(Excel.Status).toUpperCase());
//			STATUS=map.get(Excel.Status).toUpperCase();
//		}else {
//			SelectStatus(map.get(Excel.Status));
//			STATUS=map.get(Excel.Status);
//		}
		
 			log("STEP 9: Entered value should diplays in the Status field ", Status.PASS);
 		} catch (Exception e) {
 			log("STEP 9: Entered value does not display in Status field. ", Status.FAIL);
 			throw new RuntimeException("Failed in step 9");
 		}
  	  
	try {
		AddFollowupDate(map.get(Excel.FollowupDate));
 			log("STEP 10: Entered value should diplays in the Followup Date field ", Status.PASS);
 		} catch (Exception e) {
 			log("STEP 10: Entered value does not display in Followup Date field. ", Status.FAIL);
 			throw new RuntimeException("Failed in step 10");
 		}
	
	try {
		AddCallerName(map.get(Excel.CallerName));
 			log("STEP 11: Entered value should diplays in the Caller Name field ", Status.PASS);
 		} catch (Exception e) {
 			log("STEP 11: Entered value does not display in Caller Name field. ", Status.FAIL);
 			throw new RuntimeException("Failed in step 11");
 		}
	
	try {
		AddPhoneNo(map.get(Excel.PhoneNo));
 			log("STEP 12: Entered value should diplays in the Phone No field ", Status.PASS);
 		} catch (Exception e) {
 			log("STEP 12: Entered value does not display in Phone No field. ", Status.FAIL);
 			throw new RuntimeException("Failed in step 12");
 		}
	
	try {
		ClickonNoCheckbox();
 			log("STEP 13: No Phone Check box should be checked ", Status.PASS);
 		} catch (Exception e) {
 			log("STEP 13:  No Phone Check box should not be checked ", Status.FAIL);
 			throw new RuntimeException("Failed in step 13");
 		}
	
	if(!environment.contains("STEELHEAD")) {
	try {
		AddGeneralLocation(map.get(Excel.GeneralLocation));
 			log("STEP 14: User can enter the value in  General Location field   ", Status.PASS);
 		} catch (Exception e) {
 			log("STEP 14: User cannot enter the value in  General Location field  ", Status.FAIL);
 			throw new RuntimeException("Failed in step 14");
 		}
	}
	
	if(environment.contains("STEELHEAD")) {
		try {
		SelectContactType(map.get("ContactTypeSteelhead"));
			log("STEP 15: Entered value should diplays in the ContactT ype field ", Status.PASS);
		} catch (Exception e) {
			log("STEP 15: Entered value does not display in Contact Type field. ", Status.FAIL);
			throw new RuntimeException("Failed in step 15");
		}
	}else {
	try {
		SelectContactType(map.get(Excel.ContactType));
 			log("STEP 15: Entered value should diplays in the ContactT ype field ", Status.PASS);
 		} catch (Exception e) {
 			log("STEP 15: Entered value does not display in Contact Type field. ", Status.FAIL);
 			throw new RuntimeException("Failed in step 15");
 		}
	}
	
	try {
		SelectContactSource(map.get(Excel.ContactSource));
 			log("STEP 16: Entered value should diplays in the Contact Source field ", Status.PASS);
 		} catch (Exception e) {
 			log("STEP 16: Entered value does not display in Contact Source field. ", Status.FAIL);
 			throw new RuntimeException("Failed in step 16");
 		}
	
	try {
		AddEmail(map.get(Excel.Email));
 			log("STEP 17: Entered value should diplays in the Email field ", Status.PASS);
 		} catch (Exception e) {
 			log("STEP 17: Entered value does not display in Email field. ", Status.FAIL);
 			throw new RuntimeException("Failed in step 17");
 		}
	
	try {
		AddAdditionContactInformation(map.get(Excel.ContactInformation));
 			log("STEP 18: Entered value should diplays in the Contact Information field ", Status.PASS);
 		} catch (Exception e) {
 			log("STEP 18: Entered value does not display in Contact Information field. ", Status.FAIL);
 			throw new RuntimeException("Failed in step 18");
 		}
	
	if(!environment.contains("STEELHEAD")) {
	try {
		AddAddressLine1(map.get(Excel.AddressLine1));
 			log("STEP 19: Entered value should diplays in the AddressLine1 field ", Status.PASS);
 		} catch (Exception e) {
 			log("STEP 19: Entered value does not display in AddressLine1 field. ", Status.FAIL);
 			throw new RuntimeException("Failed in step 19");
 		}
	
	try {
		AddAddressLine2(map.get(Excel.AddressLine2));
 			log("STEP 20: Entered value should diplays in the AddressLine2 field ", Status.PASS);
 		} catch (Exception e) {
 			log("STEP 20: Entered value does not display in AddressLine2 field. ", Status.FAIL);
 			throw new RuntimeException("Failed in step 20");
 		}
	
	try {
		AddCity(map.get(Excel.City));
 			log("STEP 21: Entered value should diplays in the City field ", Status.PASS);
 		} catch (Exception e) {
 			log("STEP 21: Entered value does not display in City field. ", Status.FAIL);
 			throw new RuntimeException("Failed in step 21");
 		}
	
	try {
		SelectState(map.get(Excel.State));
 			log("STEP 22: Entered value should diplays in the State field ", Status.PASS);
 		} catch (Exception e) {
 			log("STEP 22: Entered value does not display in State field. ", Status.FAIL);
 			throw new RuntimeException("Failed in step 22");
 		}
	

	try {
		SelectCounty(map.get(Excel.County));
 			log("STEP 23: Entered value should diplays in the County field ", Status.PASS);
 		} catch (Exception e) {
 			log("STEP 23: Entered value does not display in County field. ", Status.FAIL);
 			throw new RuntimeException("Failed in step 23");
 		}
	
	try {
		AddZipCode(map.get(Excel.ZipCode));
 			log("STEP 24: Entered value should diplays in the ZipCode field ", Status.PASS);
 		} catch (Exception e) {
 			log("STEP 24: Entered value does not display in ZipCode field. ", Status.FAIL);
 			throw new RuntimeException("Failed in step 24");
 		}
	
		if (util.isElementVisible(txtPObox)) {
	try {
		AddPObox(map.get(Excel.PObox));
 			log("STEP 25: Entered value should diplays in the PObox field ", Status.PASS);
 		} catch (Exception e) {
 			log("STEP 25: Entered value does not display in PObox field. ", Status.FAIL);
 			throw new RuntimeException("Failed in step 25");
 		}
		}
		
		if (util.isElementVisible(txtZipcode2)) {
	try {
		AddZipcode2(map.get(Excel.ZipCode));
 			log("STEP 26: Entered value should diplays in the ZipCode field ", Status.PASS);
 		} catch (Exception e) {
 			log("STEP 26: Entered value does not display in ZipCode field. ", Status.FAIL);
 			throw new RuntimeException("Failed in step 26");
 		}
		}
	
	try {
		AddAddressLine3(map.get(Excel.AddressLine3));
 			log("STEP 27: Entered value should diplays in the AddressLine3 field ", Status.PASS);
 		} catch (Exception e) {
 			log("STEP 27: Entered value does not display in AddressLine3 field. ", Status.FAIL);
 			throw new RuntimeException("Failed in step 27");
 		}
	

	try {
		AddTownShip(map.get(Excel.TownShip));
 			log("STEP 28: Entered value should diplays in the TownShip field ", Status.PASS);
 		} catch (Exception e) {
 			log("STEP 28: Entered value does not display in TownShip field. ", Status.FAIL);
 			throw new RuntimeException("Failed in step 28");
 		}
	
	if(testcaseName.contains("ALT") || testcaseName.contains("ORSTED")||testcaseName.contains("ORION") || testcaseName.contains("ATWELL")) {
	try {
		SelectAreaTeam(map.get(Excel.Area));
 			log("STEP 29: Added value displays in the Area field  ", Status.PASS);
 		} catch (Exception e) {
 			log("STEP 29: User  cannot select  value  from the Area DD  ", Status.FAIL);
 			throw new RuntimeException("Failed in step 29");
 		}
	}
	else
	{
		try {
			SelectAreaTeamRow(map.get(Excel.Area));
	 			log("STEP 29: Added value displays in the Area field  ", Status.PASS);
	 		} catch (Exception e) {
	 			log("STEP 29: User  cannot select  value  from the Area DD  ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 29");
	 		}
	}
	
	try {
		SelectProject(map.get(Excel.Project));
 			log("STEP 30: Added value displays in the Project field   ", Status.PASS);
 		} catch (Exception e) {
 			log("STEP 30: User  cannot select  value  from the DD  ", Status.FAIL);
 			throw new RuntimeException("Failed in step 30");
 		}
	}
	else {
		if(util.isElementVisible(AreaROW)) {
		try {
			SelectAreaTeamRow(map.get(Excel.Area));
	 			log("STEP 29: Added value displays in the Area field  ", Status.PASS);
	 		} catch (Exception e) {
	 			log("STEP 29: User  cannot select  value  from the DD  ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 29");
	 		}
		}
		
		try {
			SelectProjectSteelhead(map.get(Excel.Project));
	 			log("STEP 30: Added value displays in the Project field   ", Status.PASS);
	 		} catch (Exception e) {
	 			log("STEP 30: User  cannot select  value  from the DD  ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 30");
	 		}
	}
	
	
	try {
		ClickonImmediateActionCheckbox();
 			log("STEP 31: Immediate Action Required Check box should be checked", Status.PASS);
 		} catch (Exception e) {
 			log("STEP 31: Immediate Action Required Check box should not be checked ", Status.FAIL);
 			throw new RuntimeException("Failed in step 31");
 		}
	
	try {
		SelectSensitiveTicket(map.get(Excel.SensitiveTicket));
 			log("STEP 32: Entered value should diplays in the Sensitive Ticket field ", Status.PASS);
 		} catch (Exception e) {
 			log("STEP 32: Entered value does not display in Sensitive Ticket field. ", Status.FAIL);
 			throw new RuntimeException("Failed in step 32");
 		}
	
	try {
		AddResolutionDate(map.get(Excel.ResolutionDate));
 			log("STEP 33: Entered value should diplays in the Resolution Date field ", Status.PASS);
 		} catch (Exception e) {
 			log("STEP 33: Entered value does not display in Resolution Date field. ", Status.FAIL);
 			throw new RuntimeException("Failed in step 33");
 		}
	
	try {
		AddSpecialCircumstances(map.get(Excel.SpecialCircumstances));
 			log("STEP 34: Entered value should diplays in the Special Circumstances field ", Status.PASS);
 		} catch (Exception e) {
 			log("STEP 34: Entered value does not display in Special Circumstances field. ", Status.FAIL);
 			throw new RuntimeException("Failed in step 34");
 		}
	

	try {
		AddActionTaken(map.get(Excel.ActionTaken));
 			log("STEP 35: Entered value should diplays in the Action Taken field ", Status.PASS);
 		} catch (Exception e) {
 			log("STEP 35: Entered value does not display in Action Taken field. ", Status.FAIL);
 			throw new RuntimeException("Failed in step 35");
 		}
	
	if(environment.contains("ATWELL")) {
		try {
			AddVoiceOfCustomer(map.get(Excel.Description));
	 			log("STEP : USer can enter value in Voice of Customer field ", Status.PASS);
	 		} catch (Exception e) {
	 			log("STEP : USer cannot enter value in Voice of Customer field ", Status.FAIL);
	 			throw new RuntimeException("Failed in step ");
	 		}
	}
	try {
		AddResolution(map.get(Excel.Resolution));
 			log("STEP 36: Entered value should diplays in the Resolution field ", Status.PASS);
 		} catch (Exception e) {
 			log("STEP 36: Entered value does not display in Resolution field. ", Status.FAIL);
 			throw new RuntimeException("Failed in step 36");
 		}
	

	try {
		AddIssueDescription(map.get(Excel.Description));
 			log("STEP 37: Entered value should diplays in the Description field ", Status.PASS);
 		} catch (Exception e) {
 			log("STEP 37: Entered value does not display in Description field. ", Status.FAIL);
 			throw new RuntimeException("Failed in step 37");
 		}
	
	try {
		ClickonSaveButton();
		util.dummyWait(1);
 			log("STEP 38: New Ticket should be Saved Successfully ", Status.PASS);
 		} catch (Exception e) {
 			log("STEP 38: New Ticket can not be Saved Successfully  ", Status.FAIL);
 			throw new RuntimeException("Failed in step 38");
 		}
	
	util.dummyWait(1);
	
	   if (util.isElementPresent(SuccessMessage)) {
		   count++;
		log("STEP 38: Successful Message should be display ", Status.PASS);
	   } else {
		log("STEP 38: Error / Validation message should be display", Status.FAIL);
	   }
	   STATUS=util.getAttributeValue(drpStatus, "value");
	   System.out.println("Ticket Status "+STATUS);
		   util.dummyWait(2);
		   
		   if(!environment.contains("STEELHEAD")) {
		   try {
	    		if(util.isElementVisible(panelIssueMetrics)) {
	    	  		util.click(panelIssueMetrics);
	    	  	}
	    		System.out.println(count);
	    		By actualCount = By.xpath("(//td[text()='"+CATEGORY+"']/..//td[text()='"+count+"'])[1]");
	    		Assert.assertTrue(util.isElementVisible(actualCount));
	    		log("STEP 39: User can see ticket added in Issue Metrics ", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 39:  User cannot see ticket added in Issue Metrics ", Status.FAIL);
	    	}
		   ExtentTestManager.infoWithScreenshot("Issue Metrics");
		   }
		   
		   try {
	    		ClickOnParcelInformation();
   				log("STEP 40: Record Grid should expands below ", Status.PASS);
   			} catch (Exception e) {
   				log("STEP 40:  Record does not expand below", Status.FAIL);
   				throw new RuntimeException("Failed in step 40");
   			}
	    	
	    	try {
	    		Assert.assertTrue(util.isElementVisible(DefaultParcelMessage));
	    		log("STEP 41: Default Parcel Message 'No Parcel/Tract are currently assigned to ticket' is display correctly ", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 41:  Default Parcel Message 'No Parcel/Tract are currently assigned to ticket' is not display correctly ", Status.FAIL);
	    	}
	
	    	try {
	    		ClickOnLeaseInformtion();
   				log("STEP 42: Landowner Grid should Display ", Status.PASS);
   			} catch (Exception e) {
   				log("STEP 42:  Landowner Grid does not Display", Status.FAIL);
   				throw new RuntimeException("Failed in step 42");
   			}
	    	
	    	try {
	    		Assert.assertTrue(util.isElementVisible(DefaultLeaseMessage));
	    		log("STEP 43: Default Parcel Message 'No Lease/Agreement are currently assigned to ticket' is display correctly ", Status.PASS);
			} catch (Exception e) {
				log("STEP 42:  Default Parcel Message 'No Lease/Agreement are currently assigned to ticket' is not display correctly ", Status.FAIL);
				throw new RuntimeException("Failed in step 42");
	    	}
	    	
    }
    
    By navProject = By.xpath("//span[text()='Project']");
    By ProjectInformation = By.xpath("//span[contains(text(),'Project Information')]");
    By navTicketAssociation = By.xpath("(//span[contains(text(),'Ticket Associations')])[1]");
    By TicketAssociationPanel = By.xpath("(//span[contains(text(),'Ticket Associations')])[4]");
    By Record = By.xpath("//tr[@id='ctl00_ConPHRightTop_PTAS_UC_rpTicketProject_i0_i0_TicketAssociation_radYALGridControl_ctl00__0']");
    By btnRefresh = By.xpath("//img[@id='Img1']");
    public void NavigatetToTicketAssociation() {
    	util.waitUntilElementDisplay(navProject);
    	util.click(navProject);
    	util.waitUntilElementDisplay(ProjectInformation);
    	util.click(ProjectInformation);
    	util.waitUntilElementDisplay(navTicketAssociation);
    	util.click(navTicketAssociation);
    	util.dummyWait(1);
    	util.click(btnRefresh);
    }
    
    By TicketNo = By.xpath("//*[contains(@id,'TicketAssociation_radYALGridControl_ctl00__0')]/.//a");
    public void ClickOnTicketNo() {
    	util.waitUntilElementDisplay(TicketNo);
    	util.click(TicketNo);
    	 util.dummyWait(3);
 		Set<String> windowId = driver.getWindowHandles(); // get window id of current window
 		Iterator<String> itererator = windowId.iterator();
 		String mainWinID = itererator.next();
 		String newAdwinID = itererator.next();
 		driver.switchTo().window(newAdwinID);
 		driver.close();
 		driver.switchTo().window(mainWinID);
 		util.dummyWait(2);
    }
    
    public void TicketAssociation(String testcaseName) {
    	 try {
    		 NavigatetToTicketAssociation();
    		 commonFunction.projectSelection();
    				log("STEP 1: User can navigate to the Ticket Association", Status.PASS);
    			} catch (Exception e) {
    				log("STEP 1: User cannot see the option in Menu ", Status.FAIL);
    				throw new RuntimeException("Failed in step 1");
    		}
    	 
    	 if (util.isElementPresent(Record)) {
				log("STEP 2: New record added and displayed in grid  ", Status.PASS);
			} else {
				log("STEP 2:  Record does display ", Status.FAIL);
				throw new RuntimeException("Faild in STEP 2  ");
			}
    	 
    	 try {
    		 ClickOnTicketNo();
    				log("STEP 3: New popup will be opened which contains detail information. ", Status.PASS);
    			} catch (Exception e) {
    				log("STEP 3:  user cannot  click on Ticket No ", Status.FAIL);
    				throw new RuntimeException("Failed in step 3");
    		}
    }
}
