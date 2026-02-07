package pages.Survey;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

public class SurveyDocumentsPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;
	public static String AGREEMENT_NUMBER;

	public SurveyDocumentsPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		
	}
	
	By navSurveyDocuments = By.xpath("//span[contains(text(),'Survey Documents')]");
	By drpValue = By.xpath("//input[contains(@id,'_YALWF_WORKFLOWID_Input') and @type='text']");
	By drpCurrentWorkflow = By.xpath("//input[contains(@id,'_YALWF_WORKFLOWID_Input') and @type='text']");
	By btnStartWorkflow = By.xpath("//input[contains(@id,'_btnstartWorkflow') and @type='button']");
	By btnDownloadAll = By.xpath("//input[contains(@id,'_btnDownloadAll') and @type='image']");
	By btnDownloadSelected = By.xpath("//input[contains(@id,'_btnDownloadSelected') and @type='image']");
	
	
	public void ExpandSurveyDocuments(){
		util.waitUntilElementDisplay(navSurveyDocuments);
		util.click(navSurveyDocuments);
	}
	
	public void SelectValue(String value) {
		if (!commonFunction.checkNA(value))
	util.inputTextAndPressTab(drpValue, value);
    }
	
	public void SelectCurrentWorkflow(String value) {
		if (!commonFunction.checkNA(value))
	util.inputTextAndPressTab(drpCurrentWorkflow, value);
    }
	
	public void ClickonStartWorkflow(){
		util.waitUntilElementDisplay(btnStartWorkflow);
		util.click(btnStartWorkflow);
	}
	
	public void ClickonDownloadAll(){
		util.waitUntilElementDisplay(btnDownloadAll);
		util.click(btnDownloadAll);
	}
	
	public void ClickonDownloadSelected(){
		util.waitUntilElementDisplay(btnDownloadSelected);
		util.click(btnDownloadSelected);
	}
	
	public void SurveyDocuments(Map<String, String> map, String testcaseName) {
		if (testcaseName.contains("ROW") || testcaseName.contains("ALT")) {
			log(" Survey Documents not applicable for ROW and ALT", Status.SKIP);
		}
		else {	
		
		 try {
			 ExpandSurveyDocuments();
  			 log("STEP 1:  Panel expands & field displays ", Status.PASS);
  		 } catch (Exception e) {
  			log("STEP  1:  user is unable to expand panel. ", Status.FAIL);
  			throw new RuntimeException("Failed in step 1");
  		 }
		
		 try {
			 SelectValue(map.get(Excel.Value));
  			 log("STEP 2: Selected value diplays in the  DD ", Status.PASS);
  		 } catch (Exception e) {
  			log("STEP  2: selected value does not display in  DD. ", Status.FAIL);
  			throw new RuntimeException("Failed in step 2");
  		 }
		
		 try {
			 SelectCurrentWorkflow(map.get(Excel.CurrentWorkflow));
  			 log("STEP 3:  Selected value diplays in the  DD ", Status.PASS);
  		 } catch (Exception e) {
  			log("STEP  3:  selected value does not display in  DD. ", Status.FAIL);
  			throw new RuntimeException("Failed in step 3");
  		 }
		 
		 try {
			 ClickonStartWorkflow();
  			 log("STEP 4:  user can click on start workflow button. ", Status.PASS);
  		 } catch (Exception e) {
  			log("STEP  4:  user cannot click on start workflow button. ", Status.FAIL);
  			throw new RuntimeException("Failed in step 4");
  		 }
		 
		 try {
			 ClickonDownloadAll();
  			 log("STEP 5:  user can click on download all button ", Status.PASS);
  		 } catch (Exception e) {
  			log("STEP  5:  user cannot click on download all  button ", Status.FAIL);
  			throw new RuntimeException("Failed in step 5");
  		 }
		 
		 try {
			 ClickonDownloadSelected();
  			 log("STEP 6:  user can click on download selected button. ", Status.PASS);
  		 } catch (Exception e) {
  			log("STEP  6:  user cannot click on download selected button. ", Status.FAIL);
  			throw new RuntimeException("Failed in step 16");
  		 }
		
	}
  }
}
