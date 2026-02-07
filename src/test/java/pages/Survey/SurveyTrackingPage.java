package pages.Survey;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

public class SurveyTrackingPage extends BasePage {

	TestUtil util;
	CommonFunction commonFunction;
	public static String AGREEMENT_NUMBER;

	public SurveyTrackingPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		
	}
	
	By navSurveyTracking = By.xpath("//span[contains(text(),'Survey Tracking')]");
	By txtActualLength = By.xpath("//input[contains(@id,'_SURVEYTRACK_ACTUAL_LENGTH') and @type='text']");
	By txtEasementArea = By.xpath("(//input[contains(@id,'_SURVEYTRACK_EAS_AREA') and @type='text'])[1]");
	By txtUnits = By.xpath("(//input[contains(@id,'_SURVEYTRACK_EAS_AREA') and @type='text'])[2]");
	By txtBeginStation = By.xpath("//input[contains(@id,'_SURVEYTRACK_Beg_Station') and @type='text']");
	By txtEndStation = By.xpath("//input[contains(@id,'_SURVEYTRACK_End_Station') and @type='text']");
	By btnSave = By.xpath("//input[contains(@id,'_SURVEYASSIGNMENT_TractType_btnSaveTract') and @type='button']");
	 public void AddActualLength(String value) {
//		 util.waitUntilElementDisplay(navSurveyTracking);
			if (!commonFunction.checkNA(value))
		util.inputTextAndPressTab(txtActualLength, value);
    }
	
	 public void AddEasementArea(String value) {
			if (!commonFunction.checkNA(value))
		util.inputTextAndPressTab(txtEasementArea, value);
  }
	 
	 public void AddUnit(String value) {
			if (!commonFunction.checkNA(value))
		util.inputTextAndPressTab(txtUnits, value);
  }
	

	 public void AddBeginStation(String value) {
			if (!commonFunction.checkNA(value))
		util.inputTextAndPressTab(txtBeginStation, value);
  }
	 
	 public void AddEndStation(String value) {
			if (!commonFunction.checkNA(value))
		util.inputTextAndPressTab(txtEndStation, value);
			
  }
	
	 public void clickonSave() {
		 util.dummyWait(1);
		 util.waitUntilElementDisplay(btnSave);
		 util.click(btnSave);
		 util.dummyWait(2);
	 }
	 
	 public void SurveyTracking(Map<String, String> map, String testcaseName) {
		 if (environment.contains("ALT") || environment.contains("ROW")) {
				log(" Survey Tracking not applicable for ALT and ROW", Status.SKIP);
			}
			else {
		 
		 try {
			 AddActualLength(map.get(Excel.ActualLength));
  			 log("STEP 1:  Entered value should display in the Actual Length field. ", Status.PASS);
  		 } catch (Exception e) {
  			log("STEP  1:  Entered value does not display in Actual Length field. ", Status.FAIL);
  			throw new RuntimeException("Failed in step 1");
  		 }
		 
		 try {
			 AddEasementArea(map.get(Excel.EasementArea));
  			 log("STEP 2:  Entered value should display in the Easement Area field.", Status.PASS);
  		 } catch (Exception e) {
  			log("STEP  2:  Entered value does not display in Easement Area field. ", Status.FAIL);
  			throw new RuntimeException("Failed in step 2");
  		 }
		 
		 try {
			 AddUnit(map.get(Excel.Units));
  			 log("STEP 3:  user can able to select value from dd ", Status.PASS);
  		 } catch (Exception e) {
  			log("STEP  3:  selected value displayed under field     ", Status.FAIL);
  			throw new RuntimeException("Failed in step 3");
  		 }
		 
		 try {
			 AddBeginStation(map.get(Excel.BeginStation));
  			 log("STEP 4:  user can able to select value from dd ", Status.PASS);
  		 } catch (Exception e) {
  			log("STEP  4:  selected value displayed under field     ", Status.FAIL);
  			throw new RuntimeException("Failed in step 4");
  		 }
		 
		 try {
			 AddEndStation(map.get(Excel.EndStation));
  			 log("STEP 5:  user can able to select value from dd ", Status.PASS);
  		 } catch (Exception e) {
  			log("STEP  5:  selected value displayed under field     ", Status.FAIL);
  			throw new RuntimeException("Failed in step 5");
  		 }
	 }
		 
		 try {
			 clickonSave();
  			 log("STEP 5:  user can click on save button", Status.PASS);
  		 } catch (Exception e) {
  			log("STEP  5:  user can not click on save button ", Status.FAIL);
  			throw new RuntimeException("Failed in step 5");
  		 }
  } 
}
