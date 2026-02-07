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

import extentReports.ExtentTestManager;

public class ConditionsPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;

	public ConditionsPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		
	}
	
	By navEncroachmentInformation = By.xpath("//span[contains(text(),'Encroachment Information')]/..//span[@class='rpExpandHandle']");
	By navConditions = By.xpath("//span[text()='Conditions']");
	By txtConstructionDeadline = By.xpath("//input[contains(@id,'_dpLIIConstDl_dateInput') and @type='text']");
	By drpAgreementConditions = By.xpath("//input[contains(@id,'_ddLIIAgreemCondt_MSDropDown_Input') and @type='text']");
	By txtComments = By.xpath("//textarea[contains(@id,'_txtLIIComments')]");
	By btnAdd = By.xpath("//input[contains(@id,'_btnAddConditions') and @type='image']");
	By btnSave = By.xpath("//input[contains(@id,'_btnLLISave') and @type='image']");
    By SuccessMessage = By.xpath("//span[contains(@id,'_LIIErrorMsg') and text()='Changes saved successfully!']");
    By btnEdit = By.xpath("//input[contains(@id,'_YALENCHAGREEMENTCONDITION_radYALGridControl_ctl00_ctl04_EditButton') and @type='image']");
    By txtUpdateComments = By.xpath("//textarea[contains(@id,'_EditFormControl_txtLIIComments')]");
    By btnUpdate = By.xpath("//input[contains(@id,'_EditFormControl_btnUpdate')]");
    By linkViewHistory = By.xpath("//a[text()='View History']");
    By iframeExtendDate = By.xpath("//iframe[@name='ExtendDate']");
    By btnClose = By.xpath("//a[@title='Close']");
    By linkExtendConstructionDeadline = By.xpath("//a[text()='Extend Construction Deadline']");
    By txtNewConstructionDeadline = By.xpath("//input[@id='Date_Identified_dateInput' and @type='text']");
    By txtReasonForDeadlineExtension = By.xpath("//textarea[@id='txtReasonDExtension']");
    By btnOk = By.xpath("//input[@id='btnOK']");
    By SuccessMessageExtendDate = By.xpath("//span[contains(@id,'usrMessage') and text()='Changes saved successfully!']");
    
    public void ExpandEncroachmentInformation() {
    	util.waitUntilElementDisplay(navEncroachmentInformation);
    	util.click(navEncroachmentInformation);
    }
    
    public void NavigateToConditions() {
    	util.waitUntilElementDisplay(navConditions);
    	util.click(navConditions);
    }
    
	public void selectAgreementConditions(String value) {
		util.waitUntilElementDisplay(drpAgreementConditions);
		util.click(drpAgreementConditions);
		By selectValue = By
				.xpath("//div[contains(@id,'_ddLIIAgreemCondt_MSDropDown_DropDown')]/..//li[normalize-space()='" + value
						+ "']/.//input[@type='checkbox']");
		util.click(selectValue);
		util.click(drpAgreementConditions);
	}
    
    public void AddComments(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtComments, value);
    }
    
    public void clickOnAdd() {
    	util.waitUntilElementDisplay(btnAdd);
    	util.click(btnAdd);
    	util.waitUntilPageLoad();
    	util.dummyWait(1);
    }
    
    public void clickOnEdit() {
    	util.waitUntilElementDisplay(btnEdit);
    	util.click(btnEdit);
        util.waitUntilLoaderDisappear();
    }
    
   public void UpdateComments(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtUpdateComments, value);
    }
    
   public void clickOnUpdate() {
   	util.waitUntilElementDisplay(btnUpdate);
   	util.click(btnUpdate);
    util.waitUntilLoaderDisappear();
   }
   
   public void AddConstructionDeadline(String value) {
   	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtConstructionDeadline, value);
   }
   
   public void clickOnSave() {
	   	util.waitUntilElementDisplay(btnSave);
	   	util.click(btnSave);
	   	util.waitUntilPageLoad();
    	util.dummyWait(1);
	   }
   
   public void clickOnExtendConstructionDeadline() {
	   	util.waitUntilElementDisplay(linkExtendConstructionDeadline);
	   	util.click(linkExtendConstructionDeadline);
	    util.dummyWait(1);
	    util.switchToIframe(iframeExtendDate);
	   }
   
    public void AddNewConstructionDeadline(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtNewConstructionDeadline, value);
    }
    
    public void AddReasonForDeadlineExtension(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtReasonForDeadlineExtension, value);
    }
    
    public void clickOnOk() {
	   	util.waitUntilElementDisplay(btnOk);
	   	util.click(btnOk);
	    util.dummyWait(1);
	   }
    
    public void ClosePopup() {
    	util.switchToDefaultContent();
	   	util.waitUntilElementDisplay(btnClose);
	   	util.click(btnClose);
	    util.waitUntilPageLoad();
	   }
    
    public void clickOnViewHistory() {
	   	util.waitUntilElementDisplay(linkViewHistory);
	   	util.click(linkViewHistory);
	    util.dummyWait(1);
	    util.switchToIframe(iframeExtendDate);
	   }
    
    public void AddConditions(Map<String, String> map, String testcaseName) {

		try {
			NavigateToConditions();
			log("STEP 1: User can Navigate to Conditions Tab ", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: User cannot Navigate to Conditions Tab", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}

		try {
			selectAgreementConditions(map.get("AgreementConditions"));
			log("STEP 2: User can select Agreement Conditions", Status.PASS);
		} catch (Exception e) {
			log("STEP 2: User cannot select Agreement Conditions", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}

		try {
			AddComments(map.get(Excel.Comments));
			log("STEP 3: User can enter Comments ", Status.PASS);
		} catch (Exception e) {
			log("STEP 3: User cannot enter Comments", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}
		
		try {
			clickOnAdd();
			log("STEP 4: User can click on Add button ", Status.PASS);
		} catch (Exception e) {
			log("STEP 4: User cannot click on Add button ", Status.FAIL);
			throw new RuntimeException("Failed in step 4");
		}

		try {
			Assert.assertTrue(util.isElementVisible(SuccessMessage));
			log("STEP 5: User can see 'Changes saved Successfully!' Message ", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 5: User cannot see 'Changes saved Successfully!' Message ", Status.FAIL);
		}
		
		try {
			By condition = By.xpath("//tr[contains(@id,'_YALENCHAGREEMENTCONDITION_radYALGridControl')]/..//td[text()='"+map.get("AgreementConditions")+"']");
			Assert.assertTrue(util.isElementVisible(condition));
			log("STEP 6: User can see Added condition in the grid view ", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 6: User cannot see Added condition in the grid view", Status.FAIL);
		}

		try {
			By comment = By.xpath("//tr[contains(@id,'_YALENCHAGREEMENTCONDITION_radYALGridControl')]/..//td[text()='"+map.get(Excel.Comments)+"']");
			Assert.assertTrue(util.isElementVisible(comment));
			log("STEP 7: User can see Added Comments in the grid view ", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 7: User cannot see Added Comments in the grid view", Status.FAIL);
		}
		
    }
    
    
    public void EditConditions(Map<String, String> map, String testcaseName) {

		try {
			clickOnEdit();
			log("STEP 1: User can click on Edit Icon ", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: User cannot click on Edit Icon", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}

		try {
			UpdateComments(map.get(Excel.UpdateComment));
			log("STEP 2: User can update Comments ", Status.PASS);
		} catch (Exception e) {
			log("STEP 2: User cannot update Comments", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}
		
		try {
			clickOnUpdate();
			log("STEP 4: User can click on Update button ", Status.PASS);
		} catch (Exception e) {
			log("STEP 4: User cannot click on Update button ", Status.FAIL);
			throw new RuntimeException("Failed in step 4");
		}

		try {
			Assert.assertTrue(util.isElementVisible(SuccessMessage));
			log("STEP 5: User can see 'Changes saved Successfully!' Message ", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 5: User cannot see 'Changes saved Successfully!' Message ", Status.FAIL);
		}
		
		try {
			By comment = By.xpath("//tr[contains(@id,'_YALENCHAGREEMENTCONDITION_radYALGridControl')]/..//td[text()='"+map.get(Excel.UpdateComment)+"']");
			Assert.assertTrue(util.isElementVisible(comment));
			log("STEP 6: User can see updated Comments in the grid view ", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 6: User cannot see updated Comments in the grid view", Status.FAIL);
		}
		
    }
    
    public void SaveConstructionDeadline(Map<String, String> map, String testcaseName) {

		try {
			AddConstructionDeadline(map.get("ConstructionDeadline"));
			log("STEP 1: User can add Construction Deadline ", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: User cannot add ConstructionDeadline", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}

		try {
			clickOnSave();
			log("STEP 2: User can click on Save button ", Status.PASS);
		} catch (Exception e) {
			log("STEP 2: User cannot click on Save button ", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}

		try {
			Assert.assertTrue(util.isElementVisible(SuccessMessage));
			log("STEP 3: User can see 'Changes saved Successfully!' Message ", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 3: User cannot see 'Changes saved Successfully!' Message ", Status.FAIL);
		}
		
		
    }
    
    public void ExtendConstructionDeadline(Map<String, String> map, String testcaseName) {

    	try {
			clickOnExtendConstructionDeadline();
			log("STEP 1: User can click Extend Construction Deadline link", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: User cannot click Extend Construction Deadline link ", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}
    	
    	try {
		try {
			AddNewConstructionDeadline(map.get("NewConstructionDeadline"));
			log("STEP 2: User can add New Construction Deadline ", Status.PASS);
		} catch (Exception e) {
			log("STEP 2: User cannot add New ConstructionDeadline", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}

		try {
			AddReasonForDeadlineExtension(map.get("Reason"));
			log("STEP 3: User can add Reason For Deadline Extension ", Status.PASS);
		} catch (Exception e) {
			log("STEP 3: User cannot add Reason For Deadline Extension", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}
		
		try {
			clickOnOk();
			log("STEP 4: User can click on Ok button ", Status.PASS);
		} catch (Exception e) {
			log("STEP 4: User cannot click on Ok button ", Status.FAIL);
			throw new RuntimeException("Failed in step 4");
		}

		try {
			Assert.assertTrue(util.isElementVisible(SuccessMessageExtendDate));
			log("STEP 5: User can see 'Changes saved Successfully!' Message ", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 5: User cannot see 'Changes saved Successfully!' Message ", Status.FAIL);
		}
		
    	} catch (Exception e) {

		}finally {
			ExtentTestManager.infoWithScreenshot("Extend Construction Deadline Popup Details");
		try {
			ClosePopup();
			log("STEP 6: User can close popup ", Status.PASS);
		} catch (Exception e) {
			log("STEP 6: User cannot close popup ", Status.FAIL);
			throw new RuntimeException("Failed in step 6");
		}
		}
		
    }
    
    public void ViewHistory(Map<String, String> map, String testcaseName) {

    	try {
			ExpandEncroachmentInformation();
			log("STEP 1: User can expand Encroachment Information Panel", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: User cannot expand Encroachment Information Panel ", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}
    	
    	try {
			NavigateToConditions();
			log("STEP 2: User can navigate to Conditions Tab", Status.PASS);
		} catch (Exception e) {
			log("STEP 2: User cannot navigate to Conditions Tab ", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}
    	
    	try {
			clickOnViewHistory();
			log("STEP 3: User can click on View History Link", Status.PASS);
		} catch (Exception e) {
			log("STEP 3: User cannot click on View History Link ", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}
		
    	
    	try {
			By oldDeadline = By.xpath("//tr[contains(@id,'YALENCHDEADLINEHIST_radYALGridControl')]/..//td[text()='"+map.get("ConstructionDeadline")+"']");
			Assert.assertTrue(util.isElementVisible(oldDeadline));
			log("STEP 4: User can see Old Construction Deadline in the view History grid view ", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 4: User cannot see Old Construction Deadline in the view History grid view", Status.FAIL);
		}
    	
    	try {
			By reason = By.xpath("//tr[contains(@id,'YALENCHDEADLINEHIST_radYALGridControl')]/..//td[text()='"+map.get("Reason")+"']");
			Assert.assertTrue(util.isElementVisible(reason));
			log("STEP 5: User can see Extension Reason in the view History grid view ", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 5: User cannot see Extension Reason in the view History grid view", Status.FAIL);
		}
    	
    	try {
			By newDeadline = By.xpath("//tr[contains(@id,'YALENCHDEADLINEHIST_radYALGridControl')]/..//td[text()='"+map.get("NewConstructionDeadline")+"']");
			Assert.assertTrue(util.isElementVisible(newDeadline));
			log("STEP 6: User can see New Construction Deadline in the view History grid view ", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 6: User cannot see New Construction Deadline in the view History grid view", Status.FAIL);
		}
    	
    	
    	ExtentTestManager.infoWithScreenshot("View History Popup Details");
		try {
			ClosePopup();
			log("STEP 6: User can close popup ", Status.PASS);
		} catch (Exception e) {
			log("STEP 6: User cannot close popup ", Status.FAIL);
			throw new RuntimeException("Failed in step 6");
		}
		
    }
   
}
