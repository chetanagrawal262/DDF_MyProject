package pages.Survey;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

public class SurveyRevisionsPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;
	public static String AGREEMENT_NUMBER;

	public SurveyRevisionsPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		
	}
	
	By navSurveyRevision = By.xpath("//span[contains(text(),'Survey Revisions')]");
	By btnAddNew = By.xpath("//img[@id='ctl00_ConPHRightTop_TRSR_UC_radPanels_i3_i0_SURVEYREVISIONS_radYALGridControl_ctl00_ctl02_ctl00_Img4']");
	By txtSentforRevision = By.xpath("//input[contains(@id,'_SENT_REVISION_ON_dateInput') and @type='text']");
	By txtRevisionReceived = By.xpath("//input[contains(@id,'_REVISION_RECVD_ON_dateInput') and @type='text']");
	By drpRevisionReason = By.xpath("//input[contains(@id,'_REVISION_REASON_ID_radYALDropDownList_Input') and @type='text']");
	By txtComment = By.xpath("//textarea[contains(@id,'_COMMENTS')]");
	By btnInsert = By.xpath("//input[@id='ctl00_ConPHRightTop_TRSR_UC_radPanels_i3_i0_SURVEYREVISIONS_radYALGridControl_ctl00_ctl02_ctl03_EditFormControl_btnInsert']");
	By btnCancel = By.xpath("//input[@id='ctl00_ConPHRightTop_TRSR_UC_radPanels_i3_i0_SURVEYREVISIONS_radYALGridControl_ctl00_ctl02_ctl03_EditFormControl_btnCancel']");
	
	public void ExpandSurveyRevision(){
		util.waitUntilElementDisplay(navSurveyRevision);
		util.click(navSurveyRevision);
	}
	
	public void ClickonAddNew(){
		util.waitUntilElementDisplay(btnAddNew);
		util.click(btnAddNew);
	}
	
	public void AddSentforRevision(String value) {
		util.dummyWait(2);
		if (!commonFunction.checkNA(value))
	    util.inputTextAndPressTab(txtSentforRevision, value);
    }
	
	public void AddRevisionReceived(String value) {
		if (!commonFunction.checkNA(value))
	util.inputTextAndPressTab(txtRevisionReceived, value);
    }
	
	public void SelectRevisionReason(String value) {
		if (!commonFunction.checkNA(value))
	util.inputTextAndPressTab(drpRevisionReason, value);
    }
	
	public void AddComment(String value) {
		if (!commonFunction.checkNA(value))
	util.inputTextAndPressTab(txtComment, value);
    }
	
	public void ClickonInsert(){
		util.waitUntilElementDisplay(btnInsert);
		util.click(btnInsert);
		util.dummyWait(3);
	}
	
	public void ClickonCancel(){
		util.waitUntilElementDisplay(btnAddNew);
		util.click(btnAddNew);
		util.waitUntilElementDisplay(btnCancel);
		util.click(btnCancel);
		util.dummyWait(2);
	}
	
	public void SurveyRevisions(Map<String, String> map, String testcaseName) {

		if (environment.contains("ALT") || environment.contains("ROW")) {
			log(" Survey Revisions  not applicable for ALT and ROW", Status.SKIP);
		}
		else {
		
		 try {
			 ExpandSurveyRevision();
  			 log("STEP 1:  Panel expands & field displays ", Status.PASS);
  		 } catch (Exception e) {
  			log("STEP  1:  user is unable to expand panel. ", Status.FAIL);
  			throw new RuntimeException("Failed in step 1");
  		 }
		
		 try {
			 ClickonAddNew();
  			 log("STEP 2:  User can click on add new record button  & field displays  ", Status.PASS);
  		 } catch (Exception e) {
  			log("STEP  2:  user is unable to click on add new record button ", Status.FAIL);
  			throw new RuntimeException("Failed in step 2");
  		 }
		
		
		 try {
			 AddSentforRevision(map.get(Excel.RevisionDate));
  			 log("STEP 3:  User can select date ", Status.PASS);
  		 } catch (Exception e) {
  			log("STEP  3:  user cannot select date ", Status.FAIL);
  			throw new RuntimeException("Failed in step 3");
  		 }
		 
		 
		 try {
			 AddRevisionReceived(map.get(Excel.RevisionReceivedDate));
  			 log("STEP 4:  User can select date ", Status.PASS);
  		 } catch (Exception e) {
  			log("STEP  4:  user cannot select date ", Status.FAIL);
  			throw new RuntimeException("Failed in step 4");
  		 }
		 
		 try {
			 SelectRevisionReason(map.get(Excel.RevisionReason));
  			 log("STEP 5:  Selected value display in the  revision reason id DD ", Status.PASS);
  		 } catch (Exception e) {
  			log("STEP  5:  selected value does not display in  revision reason id DD    ", Status.FAIL);
  			throw new RuntimeException("Failed in step 5");
  		 }
		 
		 try {
			 AddComment(map.get(Excel.Comment));
  			 log("STEP 6:  User can enter value in Comment textbox. ", Status.PASS);
  		 } catch (Exception e) {
  			log("STEP  6:  user cannot enter value in Comment textbox. ", Status.FAIL);
  			throw new RuntimeException("Failed in step 6");
  		 }
		 
		 try {
			 ClickonInsert();
  			 log("STEP 7:  User can click on insert button. ", Status.PASS);
  		 } catch (Exception e) {
  			log("STEP  7:  User cannot click on insert button. ", Status.FAIL);
  			throw new RuntimeException("Failed in step 7");
  		 }
		 
		 try {
			 ClickonCancel();
  			 log("STEP 8:  User can click on cancel button. ", Status.PASS);
  		 } catch (Exception e) {
  			log("STEP  8:  User cannot click on cancel button. ", Status.FAIL);
  			throw new RuntimeException("Failed in step 8");
  		 }
		 
	}
	
	}
}
