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

public class AddNewTicketPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;
	public static String CATEGORY, TICKET_COUNT;
	int count;

	public AddNewTicketPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		
	}
	
	By navAdministration = By.xpath("//span[text()='Administration']");
	By navEncroachmentRequests = By.xpath("//span[contains(text(),'Encroachment Requests')]");
	By btnAddNew = By.xpath("//a[@title='Add New']");
	By txtIssue = By.xpath("//input[contains(@id,'_Ticket_Number') and @type='text']");
	By drpCategory = By.xpath("//input[contains(@id,'_Category_ID_radYALDropDownList_Input') and @type='text']");
	By drpEncroachments = By.xpath("//input[contains(@id,'_Communication_type_IDs_YALComboBox_Input') and @type='text']");
	By txtDateIdentified = By.xpath("//input[contains(@id,'_Date_Identified_dateInput') and @type='text']");
	By drpRequestFrom = By.xpath("//input[contains(@id,'_Created_By_radYALDropDownList_Input') and @type='text']");
	By txtAgreement = By.xpath("//input[contains(@id,'_Aggrement_No') and @type='text']");
	By checkboxOH = By.xpath("//input[contains(@id,'_chkOH') and @type='checkbox']");
	By checkboxUG = By.xpath("//input[contains(@id,'_chkUG') and @type='checkbox']");
	By drpStatus = By.xpath("//input[contains(@id,'_Status_ID_radYALDropDownList_Input') and @type='text']");
	By txtRequester = By.xpath("//input[contains(@id,'_Requester') and @type='text']");
	By txtCallerName = By.xpath("//input[contains(@id,'_Caller_Name') and @type='text']");
	By txtPhoneNo = By.xpath("//input[contains(@id,'_Phone_No') and @type='text']");
	By txtContactNo = By.xpath("//textarea[contains(@id,'_Contact_No')]");
    By txtIssueDescription = By.xpath("//textarea[contains(@id,'_Issue_Desc')]");
	By txtLocationProvided = By.xpath("//textarea[contains(@id,'_txtLocationProvided')]");
	By btnSave = By.xpath("//input[contains(@id,'_btnSaveJob') and @type='image']");
    By SuccessMessage = By.xpath("//span[contains(@id,'_usrMessage') and text()='Changes saved successfully!']");
    By panelIssueMetrics = By.xpath("//em[text()='Encroachment Requests Metrics']/..//span[@class='rdExpand']");
    
    public void NavigateToEncroachmentRequests() {
    	util.waitUntilElementDisplay(navAdministration);
    	util.click(navAdministration);
    	util.waitFor(200);
    	util.waitUntilElementDisplay(navEncroachmentRequests);
    	util.hoverOnElement(navEncroachmentRequests);
    	util.click(navEncroachmentRequests);
    	util.waitUntilPageLoad();
    }
    
    By drpRegion = By.xpath("(//div[contains(@id,'_DDT_RegionDistrict_RadDropDownTree1')])[1]");
    By filterRegion = By.xpath("(//input[contains(@value,'Filtering...')])[1]");
     public void selectRegion(String value) {
    	 util.click(drpRegion);
 	    	if (!commonFunction.checkNA(value))
 				util.inputText(filterRegion, value);
 	    	By selectValue = By.xpath("(//em[text()='"+value+"'])[1]");
 	    	util.click(selectValue);
 	    	util.waitUntilPageLoad();
     }
     
    public void ClickOnAddNewTicket() {
        util.waitUntilElementDisplay(btnAddNew);
    	util.click(btnAddNew);
    }
    
    public void AddIssueNo(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtIssue, util.randomNumber());
    }
    
    public void SelectCategory(String value) {
    	util.dummyWait(2);
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpCategory,value);
    }
    
    By drpMethod = By.xpath("(//div[contains(@id,'_DDT_Method_ID_RadDropDownTree1')])[1]");
    By filterMethod = By.xpath("(//input[contains(@value,'Filtering...')])[1]");
     public void selectMethod(String value) {
    	 util.click(drpMethod);
 	    	if (!commonFunction.checkNA(value))
 				util.inputText(filterMethod, value);
 	    	By selectValue = By.xpath("(//em[text()='"+value+"'])[1]");
 	    	util.click(selectValue);
     }
    
    public void SelectEncroachments(String value) {
    	if (!commonFunction.checkNA(value))
			util.selectValueFromDropdownCheckbox(drpEncroachments, value);
    }
    
    public void AddDateIdentified(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtDateIdentified,value);
    }
    
    public void SelectRequestFrom(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpRequestFrom,value);
    }
    
    public void AddAgreementNo(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtAgreement,value);
    }
    
    public void selectOHCheckbox() {
        util.waitUntilElementDisplay(checkboxOH);
    	util.click(checkboxOH);
    }
    
    public void selectUGCheckbox() {
        util.waitUntilElementDisplay(checkboxUG);
    	util.click(checkboxUG);
    }
    
    public void SelectStatus(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpStatus,value);
    }
    
    public void AddRequester(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtRequester,value);
    }
    
    public void AddCallerName(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtCallerName,value);
    }
    
    public void AddPhoneNo(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtPhoneNo,value);
    }
    
    public void AddContactNo(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtContactNo,value);
    }
    
    public void AddIssueDescription(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtIssueDescription,value);
    }
    
    public void AddLocationProvided(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtLocationProvided,value);
    }
    
    public void ClickonSaveButton() {
    	util.waitUntilElementDisplay(btnSave);
    	util.click(btnSave);
    }
    
	public void AddNewTicket(Map<String, String> map, String testcaseName) {

		try {
			NavigateToEncroachmentRequests();
			selectRegion(map.get(Excel.Method));
			log("STEP 1: User can navigate to Encroachement Requests ", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: User cannot navigate to Encroachement Requests", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}

		try {
			ClickOnAddNewTicket();
			log("STEP 2: User can click on Add New Button ", Status.PASS);
		} catch (Exception e) {
			log("STEP 2: User cannot click on Add New Button", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}

		try {
			if (util.isElementVisible(panelIssueMetrics)) {
				util.click(panelIssueMetrics);
			}
			log("STEP 3: User can expand Issue Metrics panel ", Status.PASS);
		} catch (Exception e) {
			log("STEP 3: User cannot expand Issue Metrics panel ", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}

		try {
			SelectCategory(map.get(Excel.Category));
			CATEGORY = map.get(Excel.Category);
			By category = By.xpath("//td[text()='" + CATEGORY + "']/..//td[4]");
			if (util.isElementVisible(category)) {
				TICKET_COUNT = driver.findElement(category).getText();
				count = Integer.parseInt(TICKET_COUNT);
			} else {
				count = 0;
			}
			log("STEP 4: User can select Category ", Status.PASS);
		} catch (Exception e) {
			log("STEP 4: User cannot select Category ", Status.FAIL);
			throw new RuntimeException("Failed in step 4");
		}

		try {
			selectMethod(map.get(Excel.Method));
			log("STEP 5: User can select Method ", Status.PASS);
		} catch (Exception e) {
			log("STEP 5: User cannot select Method ", Status.FAIL);
			throw new RuntimeException("Failed in step 5");
		}

		try {
			SelectEncroachments(map.get(Excel.Encroachments));
			log("STEP 6: User can select Encroachments ", Status.PASS);
		} catch (Exception e) {
			log("STEP 6: User cannot select Encroachments ", Status.FAIL);
			throw new RuntimeException("Failed in step 6");
		}

		try {
			AddDateIdentified(map.get(Excel.DateIdentified));
			log("STEP 7: User can select Date Identified ", Status.PASS);
		} catch (Exception e) {
			log("STEP 7: User cannot select Date Identified ", Status.FAIL);
			throw new RuntimeException("Failed in step 7");
		}

		try {
			SelectRequestFrom(map.get(Excel.RequestedFrom));
			log("STEP 8: User can select Request From", Status.PASS);
		} catch (Exception e) {
			log("STEP 8: User cannot select Request From ", Status.FAIL);
			throw new RuntimeException("Failed in step 8");
		}

		try {
			AddAgreementNo(map.get(Excel.AgreementNo));
			log("STEP 9: User can enter Agreement No ", Status.PASS);
		} catch (Exception e) {
			log("STEP 9: User cannot enter Agreement No ", Status.FAIL);
			throw new RuntimeException("Failed in step 9");
		}

		try {
			selectOHCheckbox();
			log("STEP 10: User can select OH Checkbox ", Status.PASS);
		} catch (Exception e) {
			log("STEP 10: User cannot select OH Checkbox", Status.FAIL);
			throw new RuntimeException("Failed in step 10");
		}

		try {
			selectUGCheckbox();
			log("STEP 11: User can select UG Checkbox ", Status.PASS);
		} catch (Exception e) {
			log("STEP 11: User cannot select UG Checkbox ", Status.FAIL);
			throw new RuntimeException("Failed in step 11");
		}

		try {
			SelectStatus(map.get(Excel.Status));
			log("STEP 12: User can select Status ", Status.PASS);
		} catch (Exception e) {
			log("STEP 12: User cannot select Status", Status.FAIL);
			throw new RuntimeException("Failed in step 12");
		}

		try {
			AddRequester(map.get(Excel.Requester));
			log("STEP 13: User can enter Requester ", Status.PASS);
		} catch (Exception e) {
			log("STEP 13: User cannot enter Requester", Status.FAIL);
			throw new RuntimeException("Failed in step 13");
		}

		try {
			AddCallerName(map.get(Excel.CallerName));
			log("STEP 14: User can enter Caller Name ", Status.PASS);
		} catch (Exception e) {
			log("STEP 14: User cannot enter Caller Name", Status.FAIL);
			throw new RuntimeException("Failed in step 14");
		}

		try {
			AddPhoneNo(map.get(Excel.PhoneNo));
			log("STEP 15: User can enter Phone No ", Status.PASS);
		} catch (Exception e) {
			log("STEP 15: User cannot enter Phone No ", Status.FAIL);
			throw new RuntimeException("Failed in step 15");
		}
		
		try {
			AddContactNo(map.get(Excel.Contact));
			log("STEP 16: User can enter Contact No ", Status.PASS);
		} catch (Exception e) {
			log("STEP 16: User cannot enter Contact No ", Status.FAIL);
			throw new RuntimeException("Failed in step 16");
		}

		try {
			AddIssueDescription(map.get(Excel.Description));
			log("STEP 17: User can enter Issue Description ", Status.PASS);
		} catch (Exception e) {
			log("STEP 17: User cannot enter Issue Description ", Status.FAIL);
			throw new RuntimeException("Failed in step 17");
		}
		
		try {
			AddLocationProvided(map.get(Excel.LocationProvided));
			log("STEP 18: User can enter Location Provided ", Status.PASS);
		} catch (Exception e) {
			log("STEP 18: User cannot enter Location Provided ", Status.FAIL);
			throw new RuntimeException("Failed in step 18");
		}

		try {
			ClickonSaveButton();
			util.dummyWait(1);
			log("STEP 19: User can click on Save button", Status.PASS);
		} catch (Exception e) {
			log("STEP 19: User cannot click on Save button  ", Status.FAIL);
			throw new RuntimeException("Failed in step 19");
		}

		try {
			Assert.assertTrue(util.isElementVisible(SuccessMessage));
			count++;
			log("STEP 20: User can see Success Message", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 20: User cannot see Success Message", Status.FAIL);
		}

		try {
			if (util.isElementVisible(panelIssueMetrics)) {
				util.click(panelIssueMetrics);
			}
			By actualCount = By.xpath("(//td[text()='" + CATEGORY + "']/..//td[text()='" + count + "'])[1]");
			Assert.assertTrue(util.isElementVisible(actualCount));
			log("STEP 21: Ticket count added in Encroachment Request Metrics ", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 21: Ticket count not added in Encroachment Request Metrics", Status.FAIL);
		}
		  
		 
    }
    
   
}
