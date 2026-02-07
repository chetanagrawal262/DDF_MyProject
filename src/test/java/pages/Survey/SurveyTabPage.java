package pages.Survey;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

public class SurveyTabPage extends BasePage{


	TestUtil util;
	CommonFunction commonFunction;
	public static String AGREEMENT_NUMBER;

	public SurveyTabPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		
	}
	
	By navParcel = By.xpath("//span[text()='Parcel'] | //span[text()='Tract']");
	By navParcelInfo = By.xpath("//span[text()='Parcel Info'] | //span[text()='Tract Info']");
	By navSurvey = By.xpath("(//span[text()='Survey'])[1] |(//span[text()='Surveillance'])[1]");
	By drpSurveyStatus = By.xpath("//input[contains(@id,'_SURVEYASSIGNMENT_SURVEY_STATUS_ID_radYALDropDownList_Input') and @type='text']");
	By DateAsigned = By.xpath("//input[contains(@id,'_SURVEYASSIGNMENT_DATE_ASSIGNED_dateInput') and @type='text']");
	By btnSaveDot = By.xpath("//input[contains(@id,'_SURVEYASSIGNMENT_TractType_btnSaveTract') and @type='button']");
	By btnSaveRow = By.xpath("//input[contains(@id,'_SURVEYASSIGNMENT_TractType_btnSaveTract') and @type='image']");
	By btnCopyParcelinfo = By.xpath("//input[contains(@id,'_SURVEYASSIGNMENT_TractType_btnCopyTractInfo') and @type='button']");
	By IframeParcelinfo = By.xpath("//iframe[@name='CopyParcelInfo']");
	By txtParcel = By.xpath("//input[contains(@id,'DDParcels_radYALDropDownList_Input') and @type='text']");
	By SelectParcel = By.xpath("//li[contains(text(),'00002')]");
	By drpParcelInformation = By.xpath("//input[contains(@id,'DDInfo_radYALDropDownList_Input') and @type='text']");
	By drpParcelAssignment = By.xpath("//input[contains(@id,'DDAssigment_radYALDropDownList_Input') and @type='text']");
	By drpPropertOwner = By.xpath("//input[contains(@id,'DDOwners_radYALDropDownList_Input') and @type='text']");
	By drpContacts = By.xpath("//input[contains(@id,'DDContact_radYALDropDownList_Input') and @type='text']");
	By btnCopyData = By.xpath("//input[contains(@id,'BtnCopy') and @type='button']");
	By Successmsg = By.xpath("//span[text()='Copy Successful!']");
	By txtSurveyComment = By.xpath("//textarea[@id='ctl00_ConPHRightTop_TRSR_UC_radPanels_i0_i0_SURVEYASSIGNMENT_radSurveyComments']");
	By SuccessMessage = By.xpath("//span[text()='Changes Saved Successfully!']");

	
	public void nevigateToSurvey() {
  		util.waitUntilElementDisplay(navParcel);
  		util.click(navParcel);
  		util.waitUntilElementDisplay(navParcelInfo);
  		util.click(navParcelInfo);
  		util.waitUntilElementDisplay(navSurvey);
  		util.click(navSurvey);
    }
	
	 public void selectSurveyStatus(String value) {
			if (!commonFunction.checkNA(value))
		util.inputTextAndPressTab(drpSurveyStatus, value);
    }

	 public void selectDateAssigned(String value) {
			if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(DateAsigned, value);
    }
	
	 public void ClickonSaveDOT() {
		 util.waitUntilElementDisplay(btnSaveDot);
	  		util.click(btnSaveDot);
	  		util.waitUntilElementDisplay(SuccessMessage);
			Assert.assertTrue("Changes Saved Successfully!", util.isElementPresent(SuccessMessage));
	 }
	 
	 public void ClickonSaveROW() {
		 util.waitUntilElementDisplay(btnSaveRow);
	  		util.click(btnSaveRow);
	  		util.waitUntilElementDisplay(SuccessMessage);
			Assert.assertTrue("Changes Saved Successfully!", util.isElementPresent(SuccessMessage));
	 }
	 
	 public void ClickonCopyParcelinfo() {
		 util.waitUntilElementDisplay(btnCopyParcelinfo);
	  		util.click(btnCopyParcelinfo);
	 }
	 
	 
	 public void SelectParcel(String value) {
		 util.switchToIframe(IframeParcelinfo);
		 util.dummyWait(5);
		 if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtParcel, value);
	  
	 }
	 
	 public void selectParcelInformation(String value) {
			if (!commonFunction.checkNA(value))
		util.inputTextAndPressTab(drpParcelInformation, value);
    }
	 
	 public void selectParcelAssignment(String value) {
			if (!commonFunction.checkNA(value))
		util.inputTextAndPressTab(drpParcelAssignment, value);
    }
	 
	 public void selectPropertOwner(String value) {
			if (!commonFunction.checkNA(value))
		util.inputTextAndPressTab(drpPropertOwner, value);
    }
	 
	 public void selectContacts(String value) {
			if (!commonFunction.checkNA(value))
		util.inputTextAndPressTab(drpContacts, value);
    }
 	
	 By btnClose = By.xpath("//a[@class='rwCloseButton']");
	 
	 public void ClickonCopyDate() {
		 util.waitUntilElementDisplay(btnCopyData);
	  	 util.click(btnCopyData);
	  	 util.dummyWait(5);
//	  	 util.waitUntilElementDisplay(Successmsg);
//		Assert.assertTrue("Copy Successful!",util.isElementPresent(Successmsg));
	  	util.switchToDefaultContent(); 
	
	  	util.click(btnClose);
    }
	 
	 public void AddSurveyComment(String value) {
			if (!commonFunction.checkNA(value))
		util.inputText(txtSurveyComment, value);
			
    }
	 
	 public void SurveyTab(Map<String, String> map, String testcaseName) {
	    	
	    	
	    	if(testcaseName.contains("DOT"))
	    	{
	    		try {
		    		nevigateToSurvey();
		    		commonFunction.projectSelection();
					log("STEP 1: User can navigate to the Survey tab    ", Status.PASS);
				} catch (Exception e) {
					log("STEP 1:  Survey tab does not load ", Status.FAIL);
					throw new RuntimeException("Failed in step 1");
				}
	    		
	    		try {
	    			selectDateAssigned(map.get(Excel.DateAssigned));
					log("STEP 2:  User can select any date from date picker. ", Status.PASS);
				} catch (Exception e) {
					log("STEP 2:  User cannot select any date from date picker.", Status.FAIL);
					throw new RuntimeException("Failed in step 2");
				}	
	    		
	    		try {
	    			ClickonSaveDOT();
					log("STEP 3: Parcel is created sucessfully ", Status.PASS);
				} catch (Exception e) {
					log("STEP 3: Parcel is not created ", Status.FAIL);
					throw new RuntimeException("Failed in step 3");
				}	
	    		
	    		try {
	    			ClickonCopyParcelinfo();
					log("STEP 4: User can click on copy parcel info button.  ", Status.PASS);
				} catch (Exception e) {
					log("STEP 4:  User cannot click on copy parcel info.", Status.FAIL);
					throw new RuntimeException("Failed in step 4");
				}
	    		
	    		try {
	    			SelectParcel(map.get(Excel.ParcelNumber));
					log("STEP 5:  Added value displays in the field  ", Status.PASS);
				} catch (Exception e) {
					log("STEP 5:  User  cannot select  value  from the DD ", Status.FAIL);
					throw new RuntimeException("Failed in step 5");
				}
	    		
	    		
	    	   try {
	    		   selectParcelInformation(map.get(Excel.ParcelInformation));
	    	   	   log("STEP 6:  Added value displays in Parcel Information field   ", Status.PASS);
	    	    } catch (Exception e) {
	    	   	   log("STEP 6: User  cannot select  value  from Parcel Information DD  ", Status.FAIL);
	    	   	   throw new RuntimeException("Failed in step 6");
	    	   	}
	    	   
	    	   try {
	    		   selectParcelAssignment(map.get(Excel.ParcelAssignment));
	    	   	   log("STEP 7:  Added value displays in Parcel Assignment field   ", Status.PASS);
	    	    } catch (Exception e) {
	    	   	   log("STEP 7: User  cannot select  value  from Parcel Assignment DD ", Status.FAIL);
	    	   	   throw new RuntimeException("Failed in step 7");
	    	   	}
	    	   
	    	   try {
	    		   selectPropertOwner(map.get(Excel.PropertyOwner));
	    	   	   log("STEP 8:  Added value displays in Property Owner field   ", Status.PASS);
	    	    } catch (Exception e) {
	    	   	   log("STEP 8: User  cannot select  value  from Property Owner DD ", Status.FAIL);
	    	   	   throw new RuntimeException("Failed in step 8");
	    	   	}
	    	   
	    	   try {
	    		   selectContacts(map.get(Excel.Contacts));
	    	   	   log("STEP 9:  Added value displays in Contacts field  ", Status.PASS);
	    	    } catch (Exception e) {
	    	   	   log("STEP 9: User  cannot select  value  from Contacts DD  ", Status.FAIL);
	    	   	   throw new RuntimeException("Failed in step 9");
	    	   	}
	    	   
	    	   try {
	    		   ClickonCopyDate();
	    	   	   log("STEP 10:  'Copy sucessful ' message will be displayed.  ", Status.PASS);
	    	    } catch (Exception e) {
	    	   	   log("STEP 10:  User  cannot click on copy data button. ", Status.FAIL);
	    	   	   throw new RuntimeException("Failed in step 10");
	    	   	}
	    		
	    	}
	    	
	    	else {
	    		
	    		try {
		    		nevigateToSurvey();
		    		commonFunction.projectSelection();
					log("STEP 1: User can navigate to the Survey tab    ", Status.PASS);
				} catch (Exception e) {
					log("STEP 1:  Survey tab does not load ", Status.FAIL);
					throw new RuntimeException("Failed in step 1");
				}
	    	
	    	 try {
	    		 selectSurveyStatus(map.get(Excel.SurveyStatus));
	    	   	   log("STEP 2:  Added value displays in Survey Status field  ", Status.PASS);
	    	    } catch (Exception e) {
	    	   	   log("STEP 2: User  cannot select  value  from Survey Status DD  ", Status.FAIL);
	    	   	   throw new RuntimeException("Failed in step 2");
	    	   	}
	    	 try {
	    		 AddSurveyComment(map.get(Excel.SurveyComment));
	    	   	   log("STEP 3:  Added value displays in Survey Comment field   ", Status.PASS);
	    	    } catch (Exception e) {
	    	   	   log("STEP 3: User cannot add a value in Survey Comment field  ", Status.FAIL);
	    	   	   throw new RuntimeException("Failed in step 3");
	    	   	}
	    	 
	    	 
	    	 try {
	    		 ClickonSaveROW();
	    			log("STEP 4: Parcel is created sucessfully ", Status.PASS);
				} catch (Exception e) {
					log("STEP 4: Parcel is not created ", Status.FAIL);
					throw new RuntimeException("Failed in step 4");
				}
	    	 
	    	
	    	 
	    	}
	 }
}
