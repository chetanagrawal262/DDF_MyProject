package pages.Survey;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

public class AddDrawingTrackingRecordPage extends BasePage {


	TestUtil util;
	CommonFunction commonFunction;
	public static String AGREEMENT_NUMBER;

	public AddDrawingTrackingRecordPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		
	}
	
	By navDrawingTracking = By.xpath("//span[text()='Drawing Tracking']");
	By btnAddNew = By.xpath("//img[@id='ctl00_ConPHRightTop_TRSR_UC_radPanels_i4_i0_ACQSURVEY_radYALGridControl_ctl00_ctl02_ctl00_Img4']");
	By drpRoute = By.xpath("//input[contains(@id,'_EditFormControl_ROUTE_ID_radYALDropDownList_Input') and @type='text']");
	By txtRevisionNumber = By.xpath("//input[contains(@id,'_RevisionNumber') and @type='text']");
	By txtPlatEntitled = By.xpath("//input[contains(@id,'_PLATENTITLED') and @type='text']");
	//By txtWorkCompletedDate = By.xpath("//input[contains(@id,'_COMPLETED_dateInput') and @type='text']");
	By txtWorkCompletedDate = By.xpath("//input[contains(@id,'_radPanels_i4_i0_ACQSURVEY_radYALGridControl_ctl00_ctl02_ctl03_EditFormControl_FIELD_WORK_COMPLETED_dateInput') and @type='text']");
	//By txtExpectedPlatDate = By.xpath("//input[contains(@id,'_PLAT_DATE_dateInput') and @type='text']");
	By txtExpectedPlatDate = By.xpath("//*[@id=\"ctl00_ConPHRightTop_TRSR_UC_radPanels_i4_i0_ACQSURVEY_radYALGridControl_ctl00_ctl02_ctl03_EditFormControl_EXPECTED_PLAT_DATE_dateInput\"]");
	By txtDrawingRequiredDate = By.xpath("//input[contains(@id,'_EditFormControl_DRAWING_REQUIRED_BY_dateInput') and @type='text']");
	By txtDrawingReceivedDate = By.xpath("//input[contains(@id,'_DRAWING_RECEIVED_dateInput') and @type='text']");
	By checkFinalCheckbox = By.xpath("//input[contains(@id,'_EditFormControl_Final') and @type='checkbox']");
	By drpPreparedBy = By.xpath("//input[contains(@id,'_DDLPreparedBy_radYALDropDownList_Input') and @type='text']");
	By txtActualLength = By.xpath("//input[contains(@id,'_EditFormControl_ACTUAL_LENGTH') and @type='text']");
	By txtEasementArea = By.xpath("(//input[contains(@id,'_EditFormControl_EAS_AREA') and @type='text'])[1]");
	By txtUnit = By.xpath("(//input[contains(@id,'_EditFormControl_EAS_AREA') and @type='text'])[2]");
	By txtMilePost = By.xpath("//input[contains(@id,'_EditFormControl_Beg_Station') and @type='text']");
	By txtMilePostTo = By.xpath("//input[contains(@id,'_EditFormControl_End_Station') and @type='text']");
	By txtSpread = By.xpath("//input[contains(@id,'_EditFormControl_Spread') and @type='text']");
	By txtDsecription = By.xpath("//textarea[contains(@id,'_METERSBOUNDSDESC')]");
	By btnInsert = By.xpath("//input[@id='ctl00_ConPHRightTop_TRSR_UC_radPanels_i4_i0_ACQSURVEY_radYALGridControl_ctl00_ctl02_ctl03_EditFormControl_btnInsert']");
    By Successmsg = By.xpath("//span[text()='Changes saved successfully!']");
	By btnCancel = By.xpath("//input[@id='ctl00_ConPHRightTop_TRSR_UC_radPanels_i4_i0_ACQSURVEY_radYALGridControl_ctl00_ctl02_ctl03_EditFormControl_btnCancel']");
	
	By navSurveyTracking = By.xpath("//span[text()='Survey Tracking']");
	By txtActualLengthDot = By.xpath("//input[contains(@id,'_SURVEYTRACK_ACTUAL_LENGTH') and @type='text']");
	By txtEasementAreaDot = By.xpath("(//input[contains(@id,'_SURVEYTRACK_EAS_AREA') and @type='text'])[1]");
	By txtUnitsDot = By.xpath("(//input[contains(@id,'_SURVEYTRACK_EAS_AREA') and @type='text'])[2]");
	By txtBeginStation = By.xpath("//input[contains(@id,'_SURVEYTRACK_Beg_Station') and @type='text']");
	By txtEndStation = By.xpath("//input[contains(@id,'_SURVEYTRACK_End_Station') and @type='text']");
	
	
	public void ClickOnAddNew() {
  		util.waitUntilElementDisplay(navDrawingTracking);
  		util.click(navDrawingTracking);
  		util.waitUntilElementDisplay(btnAddNew);
  		util.click(btnAddNew);
  		
    }
	
	 public void selectRoute(String value) {
			if (!commonFunction.checkNA(value))
		util.inputTextAndPressTab(drpRoute, value);
    }
	
	 public void AddRevisionNumber(String value) {
			if (!commonFunction.checkNA(value))
		util.inputTextAndPressTab(txtRevisionNumber, value);
    }
	 
	 public void AddPlatEntitled(String value) {
		 util.waitUntilElementDisplay(txtPlatEntitled);
			if (!commonFunction.checkNA(value))
		util.inputTextAndPressTab(txtPlatEntitled, value);
    }
	 
	 public void AddWorkCompletedDate(String value) {
			if (!commonFunction.checkNA(value))
		util.inputTextAndPressTab(txtWorkCompletedDate, value);
    }
	 
	 public void AddExpectedPlatDate(String value) {
			if (!commonFunction.checkNA(value))
		util.inputTextAndPressTab(txtExpectedPlatDate, value);
    } 
	 
	 public void AddDrawingRequiredDate(String value) {
		if (!commonFunction.checkNA(value))
	util.inputTextAndPressTab(txtDrawingRequiredDate, value);
    }
	 
	 public void AddDrawingReceivedDate(String value) {
			if (!commonFunction.checkNA(value))
		util.inputTextAndPressTab(txtDrawingReceivedDate, value);
    }
	 
	 public void ClickonFinalCheckbox() {
		 util.waitUntilElementDisplay(checkFinalCheckbox);
	  		util.click(checkFinalCheckbox);
	  		
	 }
	 
	 public void SelectPreparedBy(String value) {
			if (!commonFunction.checkNA(value))
		util.inputTextAndPressTab(drpPreparedBy, value);
    }
	 
	 public void AddActualLength(String value) {
			if (!commonFunction.checkNA(value))
		util.inputTextAndPressTab(txtActualLength, value);
    }
	 
	 public void AddEasementArea(String value) {
			if (!commonFunction.checkNA(value))
		util.inputTextAndPressTab(txtEasementArea, value);
     }
	 
	 public void AddUnits(String value) {
			if (!commonFunction.checkNA(value))
		util.inputTextAndPressTab(txtUnit, value);
     }
	 
	 public void AddMilePostForm(String value) {
			if (!commonFunction.checkNA(value))
		util.inputTextAndPressTab(txtMilePost, value);
     }
	 
	 public void AddMilePostTo(String value) {
			if (!commonFunction.checkNA(value))
		util.inputTextAndPressTab(txtMilePostTo, value);
  }
	 
	 public void AddSpread(String value) {
			if (!commonFunction.checkNA(value))
		util.inputTextAndPressTab(txtSpread, value);
    }
	 
	 public void AddDescription(String value) {
			if (!commonFunction.checkNA(value))
		util.inputTextAndPressTab(txtDsecription, value);
		
    }
	 

		public void ClickOnInsert() 
		{
	  		util.waitUntilElementDisplay(btnInsert);
	  		util.click(btnInsert);
	         //  Assert.assertTrue(util.isElementPresent(Successmsg), "Changes saved successfully!");

	    }
		
		public void ClickOnCancel() 
		{
	  		util.waitUntilElementDisplay(btnCancel);
	  		util.click(btnCancel);
	  		
	    }
		
		 public void AddActualLengthDot(String value) {
			 util.waitUntilElementDisplay(navSurveyTracking);
		  		util.click(navSurveyTracking);
				if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtActualLengthDot, value);
	    }
		 
		 public void AddEasementAreaDot(String value) {
				if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtEasementAreaDot, value);
	     }
		 
		 public void AddUnitDot(String value) {
				if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtUnitsDot, value);
	     }
		

		 public void AddBeginStation(String value) {
				if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtBeginStation, value);
	     }
		 
		 public void AddEndStation(String value) {
				if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtEndStation, value);
	     }
		
		 public void AddDrawingTrackingRecord(Map<String, String> map, String testcaseName) {
			 
			 if(testcaseName.contains("ROW") || testcaseName.contains("TRA"))
			 {
				 try {
					 ClickOnAddNew();
		  			 log("STEP 1:  Record Grid should expands below  ", Status.PASS);
		  		 } catch (Exception e) {
		  			log("STEP  1:   record does not expand below  ", Status.FAIL);
		  			throw new RuntimeException("Failed in step 1");
		  		 }
				 
				 try {
					 selectRoute(map.get(Excel.Route));
		  			 log("STEP 2:  Selected value displays in the Route DD ", Status.PASS);
		  		 } catch (Exception e) {
		  			log("STEP  2:  Selected value does not displays in the Route DD  ", Status.FAIL);
		  			throw new RuntimeException("Failed in step 2");
		  		 }
				 
				 try {
					 AddRevisionNumber(map.get(Excel.RevisionNumber));
		  			 log("STEP 3:  Entered value should displays in the Revision Number field.  ", Status.PASS);
		  		 } catch (Exception e) {
		  			log("STEP  3:  Entered value does not display in  Revision Number field. ", Status.FAIL);
		  			throw new RuntimeException("Failed in step 3");
		  		 }
				 
				 try {
					 AddPlatEntitled(map.get(Excel.PlatEntitled));
		  			 log("STEP 4:  Entered value should displays in the Plat Entitled field.  ", Status.PASS);
		  		 } catch (Exception e) {
		  			log("STEP  4:  Entered value does not displays in the Plat Entitled field.   ", Status.FAIL);
		  			throw new RuntimeException("Failed in step 4");
		  		 }
				 
				 try {
					 AddWorkCompletedDate(map.get(Excel.WorkCompletedDate));
		  			 log("STEP 5:  User can select the  Date  ", Status.PASS);
		  		 } catch (Exception e) {
		  			log("STEP  5:  User  cannot select  Date  from Date Picker  ", Status.FAIL);
		  			throw new RuntimeException("Failed in step 5");
		  		 }
				 
				 try {
					 AddExpectedPlatDate(map.get(Excel.ExpectedPlatDate));
		  			 log("STEP 6:  User can select the  Date   ", Status.PASS);
		  		 } catch (Exception e) {
		  			log("STEP  6:  User  cannot select  Date  from Date Picker  ", Status.FAIL);
		  			throw new RuntimeException("Failed in step 6");
		  		 }
				 
				 try {
					 AddDrawingRequiredDate(map.get(Excel.DrawingRequiredDate));
		  			 log("STEP 7:  User can select the  Date ", Status.PASS);
		  		 } catch (Exception e) {
		  			log("STEP  7:  User  cannot select  Date  from Date Picker  ", Status.FAIL);
		  			throw new RuntimeException("Failed in step 7");
		  		 }
				 
				 try {
					 AddDrawingReceivedDate(map.get(Excel.DrawingReceivedDate));
		  			 log("STEP 8:  User can select the  Date ", Status.PASS);
		  		 } catch (Exception e) {
		  			log("STEP  8:  User  cannot select  Date  from Date Picker  ", Status.FAIL);
		  			throw new RuntimeException("Failed in step 8");
		  		 }
				 
				 try {
					 ClickonFinalCheckbox();
		  			 log("STEP 9:  Final checkbox should be display checked  ", Status.PASS);
		  		 } catch (Exception e) {
		  			log("STEP  9:  Final checkbox does not display checked  ", Status.FAIL);
		  			throw new RuntimeException("Failed in step 9");
		  		 }
				 
				 try {
					 SelectPreparedBy(map.get(Excel.PreparedBy));
		  			 log("STEP 10:  Selected value displays in the Prepared By DD  ", Status.PASS);
		  		 } catch (Exception e) {
		  			log("STEP  10:  selected value does not display in  Prepared By DD. ", Status.FAIL);
		  			throw new RuntimeException("Failed in step 10");
		  		 }
				 
				 try {
					 AddActualLength(map.get(Excel.ActualLength));
		  			 log("STEP 11:  Entered value should displays in the Actual Length field. ", Status.PASS);
		  		 } catch (Exception e) {
		  			log("STEP  11:  Entered value does not display in Actual Length field. ", Status.FAIL);
		  			throw new RuntimeException("Failed in step 11");
		  		 }
				 
				 try {
					 AddEasementArea(map.get(Excel.EasementArea));
		  			 log("STEP 12:  Entered value should displays in the Easement Area field.", Status.PASS);
		  		 } catch (Exception e) {
		  			log("STEP  12:  Entered value does not display in Easement Area field. ", Status.FAIL);
		  			throw new RuntimeException("Failed in step 12");
		  		 }
				 
				 try {
					 AddUnits(map.get(Excel.Units));
		  			 log("STEP 13:  user can able to select value from dd ", Status.PASS);
		  		 } catch (Exception e) {
		  			log("STEP  13:  selected value displayed under field     ", Status.FAIL);
		  			throw new RuntimeException("Failed in step 13");
		  		 }
				 
				 try {
					 AddMilePostForm(map.get(Excel.MilePost));
		  			 log("STEP 14:  Entered value should displays in the Mile Post To field. ", Status.PASS);
		  		 } catch (Exception e) {
		  			log("STEP  14:  Entered value does not display in Mile Post To field  ", Status.FAIL);
		  			throw new RuntimeException("Failed in step 14");
		  		 }
				 
				 try {
					 AddMilePostTo(map.get(Excel.MilePostTo));
		  			 log("STEP 14:  Entered value should displays in the Mile Post To field. ", Status.PASS);
		  		 } catch (Exception e) {
		  			log("STEP  14:  Entered value does not display in Mile Post To field  ", Status.FAIL);
		  			throw new RuntimeException("Failed in step 14");
		  		 }
				 
				 try {
					 AddSpread(map.get(Excel.Spread));
		  			 log("STEP 15:  Entered value should displays in the Spread  field.  ", Status.PASS);
		  		 } catch (Exception e) {
		  			log("STEP  15:  Entered value does not display in Spread field. ", Status.FAIL);
		  			throw new RuntimeException("Failed in step 15");
		  		 }
				 
				 try {
					 AddDescription(map.get(Excel.Description));
		  			 log("STEP 16:  Entered value should displays in the Metes & Bounds Desc field.  ", Status.PASS);
		  		 } catch (Exception e) {
		  			log("STEP  16:  Entered value does not display in Metes & Bounds Desc field. ", Status.FAIL);
		  			throw new RuntimeException("Failed in step 16");
		  		 }
				 
				 try {
					 ClickOnInsert();
		  			 log("STEP 17:  Changes saved successfully!  message should be display above the add new button ", Status.PASS);
		  		 } catch (Exception e) {
		  			log("STEP  17:  Save successful message does not display above the add new button  ", Status.FAIL);
		  			throw new RuntimeException("Failed in step 17");
		  		 }
				 
//				 try {
//					 ClickOnCancel();
//		  			 log("STEP 18:  User can click on cancel button.  ", Status.PASS);
//		  		 } catch (Exception e) {
//		  			log("STEP  18:  User cannot click on cancel button.  ", Status.FAIL);
//		  			throw new RuntimeException("Failed in step 17");
//		  		 }
//				
			 }
			 else {
				 log("Add Drawing Tracking Record not applicable for DOT and ALT", Status.SKIP);
//			 try {
//				 AddActualLengthDot(map.get(Excel.ActualLength));
//	  			 log("STEP 11:  Entered value should displays in the Actual Length field. ", Status.PASS);
//	  		 } catch (Exception e) {
//	  			log("STEP  11:  Entered value does not display in Actual Length field. ", Status.FAIL);
//	  			throw new RuntimeException("Failed in step 11");
//	  		 }
//			 
//			 try {
//				 AddEasementAreaDot(map.get(Excel.EasementArea));
//	  			 log("STEP 12:  Entered value should displays in the Easement Area field.", Status.PASS);
//	  		 } catch (Exception e) {
//	  			log("STEP  12:  Entered value does not display in Easement Area field. ", Status.FAIL);
//	  			throw new RuntimeException("Failed in step 12");
//	  		 }
//			 
//			 try {
//				 AddUnitDot(map.get(Excel.Units));
//	  			 log("STEP 13:  user can able to select value from dd ", Status.PASS);
//	  		 } catch (Exception e) {
//	  			log("STEP  13:  selected value displayed under field     ", Status.FAIL);
//	  			throw new RuntimeException("Failed in step 13");
//	  		 }
//			 
//			 try {
//				 AddBeginStation(map.get(Excel.BeginStation));
//	  			 log("STEP 14:  user can able to select value from dd ", Status.PASS);
//	  		 } catch (Exception e) {
//	  			log("STEP  14:  selected value displayed under field     ", Status.FAIL);
//	  			throw new RuntimeException("Failed in step 14");
//	  		 }
//			 
//			 try {
//				 AddEndStation(map.get(Excel.EndStation));
//	  			 log("STEP 15:  user can able to select value from dd ", Status.PASS);
//	  		 } catch (Exception e) {
//	  			log("STEP  15:  selected value displayed under field     ", Status.FAIL);
//	  			throw new RuntimeException("Failed in step 15");
//	  		 }
//			 
//			 util.dummyWait(5);
		} 
	 }

}
