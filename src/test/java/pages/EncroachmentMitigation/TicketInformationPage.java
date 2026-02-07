package pages.EncroachmentMitigation;

import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.util.CommonFunction;
import com.util.TestUtil;

public class TicketInformationPage extends BasePage
{
	TestUtil util;
	CommonFunction commonFunction;
	public static String ISSUE_NO;

	public TicketInformationPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	
	By navParcel = By.xpath("//span[text()='Parcel'] | //span[text()='Tract']");
	By navParcelInfo = By.xpath("//span[text()='Parcel Info'] | //span[text()='Tract Info']");
	By navEncroachmentMitigation = By.xpath("//span[contains(text(),'Encroachment Mitigation')]");
	By panelTicketInformation = By.xpath("//span[contains(text(),'Ticket Information')]");
	By txtIssueNo = By.xpath("//input[contains(@id,'_Tract_Name') and @type='text']");
	By drpCategory = By.xpath("//input[contains(@id,'_Category_ID_radYALDropDownList_Input') and @type='text']");
	By drpEncroachments = By.xpath("//input[contains(@id,'_Communication_Type_ID_YALComboBox_Input') and @type='text']");
	By drpFieldRep = By.xpath("//input[contains(@id,'_External_Party_radYALDropDownList_Input') and @type='text']");
	By txtDateIdentified = By.xpath("//input[contains(@id,'Date_Identified_dateInput') and @type='text']");
	By drpPrimaryOfficeRep = By.xpath("//input[contains(@id,'_Created_By_radYALDropDownList_Input') and @type='text']");
	By drpSecondaryOfficeRep = By.xpath("//input[contains(@id,'_Assigned_To_radYALDropDownList_Input') and @type='text']");
	By drpStatus = By.xpath("//input[contains(@id,'_Status_ID_radYALDropDownList_Input') and @type='text']");
	By checkboxCheckExceed = By.xpath("//input[contains(@id,'ChkExceed500') and @type='checkbox']");
	By txtFollowupDate = By.xpath("//input[contains(@id,'_Followup_Date_dateInput') and @type='text']");
	By txtIssueDescription = By.xpath("//textarea[contains(@id,'_Comments')]");
	By btnSave = By.xpath("//input[contains(@id,'_btnSaveJob')]");
	By successMessage = By.xpath("//span[text()='Changes saved successfully!']");
	
	
    public void navigateToEncroachmentMitigation() {
		util.waitUntilElementDisplay(navParcel);
		util.click(navParcel);
		util.waitUntilElementDisplay(navParcelInfo);
		util.click(navParcelInfo);
		util.waitUntilElementDisplay(navEncroachmentMitigation);
		util.click(navEncroachmentMitigation);
		commonFunction.projectSelection();
	}
    
    public void ExpandTicketInformation() {
    	util.waitUntilElementDisplay(panelTicketInformation);
		util.click(panelTicketInformation);
    }
    
    public void enterIssueNo(String value) {
        util.inputTextAndPressTab(txtIssueNo, value);
    }

    public void selectCategory(String value) {
        util.inputTextAndPressTab(drpCategory, value);
    }

    public void selectEncroachments(String value) {
        util.selectValueFromDropdownCheckbox(drpEncroachments, value);
    }

    public void selectFieldRep(String value) {
        util.inputTextAndPressTab(drpFieldRep, value);
    }

    public void enterDateIdentified(String value) {
        util.inputTextAndPressTab(txtDateIdentified, value);
    }

    public void selectPrimaryOfficeRep(String value) {
        util.inputTextAndPressTab(drpPrimaryOfficeRep, value);
    }

    public void selectSecondaryOfficeRep(String value) {
        util.inputTextAndPressTab(drpSecondaryOfficeRep, value);
    }

    public void selectStatus(String value) {
        util.inputTextAndPressTab(drpStatus, value);
    }

    public void setCheckExceed() {
         util.click(checkboxCheckExceed);
        
    }

    public void enterFollowupDate(String value) {
        util.inputTextAndPressTab(txtFollowupDate, value);
    }

    public void enterIssueDescription(String value) {
        util.inputTextAndPressTab(txtIssueDescription, value);
    }

    public void clickSave() {
        util.click(btnSave);
        util.dummyWait(2);
    }
    
    public void addEncroachmentMitigationTicket(Map<String, String> map, String testcaseName) {
        try {
            navigateToEncroachmentMitigation();
            ExpandTicketInformation();
            log("STEP 1: User can navigate to Encroachment Mitigation", Status.PASS);
        } catch (Exception e) {
            log("STEP 1: User cannot navigate to Encroachment Mitigation", Status.FAIL);
            throw new RuntimeException("Failed in step 1");
        }

        try {
        	ISSUE_NO = util.randomNumber();
            enterIssueNo(ISSUE_NO);
            log("STEP 2: User can enter Issue No", Status.PASS);
        } catch (Exception e) {
            log("STEP 2: User cannot enter Issue No", Status.FAIL);
            throw new RuntimeException("Failed in step 2");
        }

        try {
            selectCategory(map.get("Category"));
            log("STEP 3: User can select Category", Status.PASS);
        } catch (Exception e) {
            log("STEP 3: User cannot select Category", Status.FAIL);
            throw new RuntimeException("Failed in step 3");
        }

        try {
            selectEncroachments(map.get("Encroachments"));
            log("STEP 4: User can select Encroachments", Status.PASS);
        } catch (Exception e) {
            log("STEP 4: User cannot select Encroachments", Status.FAIL);
            throw new RuntimeException("Failed in step 4");
        }

        try {
            selectFieldRep(map.get("FieldRep"));
            log("STEP 5: User can select Field Rep", Status.PASS);
        } catch (Exception e) {
            log("STEP 5: User cannot select Field Rep", Status.FAIL);
            throw new RuntimeException("Failed in step 5");
        }

        try {
            enterDateIdentified(map.get("DateIdentified"));
            log("STEP 6: User can enter Date Identified", Status.PASS);
        } catch (Exception e) {
            log("STEP 6: User cannot enter Date Identified", Status.FAIL);
            throw new RuntimeException("Failed in step 6");
        }

        try {
            selectPrimaryOfficeRep(map.get("PrimaryOfficeRep"));
            log("STEP 7: User can select Primary Office Rep", Status.PASS);
        } catch (Exception e) {
            log("STEP 7: User cannot select Primary Office Rep", Status.FAIL);
            throw new RuntimeException("Failed in step 7");
        }

        try {
            selectSecondaryOfficeRep(map.get("SecondaryOfficeRep"));
            log("STEP 8: User can select Secondary Office Rep", Status.PASS);
        } catch (Exception e) {
            log("STEP 8: User cannot select Secondary Office Rep", Status.FAIL);
            throw new RuntimeException("Failed in step 8");
        }

        try {
            selectStatus(map.get("Status"));
            log("STEP 9: User can select Status", Status.PASS);
        } catch (Exception e) {
            log("STEP 9: User cannot select Status", Status.FAIL);
            throw new RuntimeException("Failed in step 9");
        }

        try {
            setCheckExceed();
            log("STEP 10: User can set Check Exceed", Status.PASS);
        } catch (Exception e) {
            log("STEP 10: User cannot set Check Exceed", Status.FAIL);
            throw new RuntimeException("Failed in step 10");
        }

        try {
            enterFollowupDate(map.get("FollowupDate"));
            log("STEP 11: User can enter Followup Date", Status.PASS);
        } catch (Exception e) {
            log("STEP 11: User cannot enter Followup Date", Status.FAIL);
            throw new RuntimeException("Failed in step 11");
        }

        try {
            enterIssueDescription(map.get("IssueDescription"));
            log("STEP 12: User can enter Issue Description", Status.PASS);
        } catch (Exception e) {
            log("STEP 12: User cannot enter Issue Description", Status.FAIL);
            throw new RuntimeException("Failed in step 12");
        }

        try {
            clickSave();
            log("STEP 13: User can click Save", Status.PASS);
        } catch (Exception e) {
            log("STEP 13: User cannot click Save", Status.FAIL);
            throw new RuntimeException("Failed in step 13");
        }

        try {
            Assert.assertTrue(util.isElementVisible(successMessage));
            log("STEP 14: User can see success message", Status.PASS);
        } catch (AssertionError e) {
            log("STEP 14: User cannot see success message", Status.FAIL);
        }
    }
    
    
    
	
}
