package pages.ParcelDetails;

import static org.junit.Assert.assertTrue;

import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;
import extentReports.ExtentTestManager;

public class Valard_ParcelInformation_Page extends BasePage
{
	TestUtil util;
	CommonFunction commonFunction;
	public static String RecordNo, CrownLandRecordNo, PARCEL_TYPE, AUTHORIZATION_STATUS;

	public Valard_ParcelInformation_Page(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	
	//Navigation
	By navParcel = By.xpath("//span[text()='Parcel'] | //span[text()='Tract']");
	By navParcelInfo = By.xpath("//span[text()='Parcel Info'] | //span[text()='Tract Info']");
	By navParcelInformation = By.xpath("//span[contains(text(),'Parcel Information')] | //span[contains(text(),'Tract Information')] | //span[contains(text(),'Record Information')]");
	//add Parcel
	By addParcel = By.xpath("//img[@onclick='showMenu(event)']");
	By frmFull = By.xpath("//iframe[@name='TractMenu']");
	By frmFullALT = By.xpath("//iframe[@name='radwinAddNewTract'] | //iframe[@name='TractMenu']");
    By btnaddParcel = By.xpath("//li[contains(@class,'rmItem rmFirst')]/..//*[text()='Record'] | //li[contains(@class,'rmItem rmFirst')]/..//*[text()='Document' or text()='DocumentNumber']");                                                                                                               
    By btnaddReorder = By.xpath("//li[contains(@class,'rmItem rmFirst rmLast')]/..//*[text()='Add Parcel']");
    By btnaddParcelOld = By.xpath("//li[contains(@class,'rmLast')]/..//*[text()='Add Parcel']");
    By drpParcelType = By.xpath("//input[contains(@id,'_Tract_Type_ID_radYALDropDownList_Input') and @type='text']");
    By privatePT = By.xpath("//li[text()='Private']");
    By permitPT = By.xpath("//li[text()='Permit']");
    By crownLandPT = By.xpath("//li[text()='Crown Land']");
    By thirdPartyPT = By.xpath("//li[text()='Third Party']");
    By txtParcelNo = By.xpath("//input[contains(@id,'TractType_TRACT_NUMBER') and @type='text']");
    By drpState = By.xpath("//input[contains(@id,'_TractType_STATE_Input') and @type='text']");
    By txtTotalParcelAcres = By.xpath("//*[text()='Total Parcel Acres:']/..//input[@type='text']");
    By txtComments = By.xpath("//textarea[@id='ctl00_ConPHRightTop_TRPI_UC_radPrjPanels_i0_i0_TractType_radComments']");
    By drpCounty = By.xpath("//input[contains(@id,'_TractType_County') and @type='text']");
    By drpPropertyType = By.xpath("//input[contains(@id,'_Property_Type_ID_radYALDropDownList_Input') and @type='text']");
    By drpAcquisitionType  = By.xpath("//input[contains(@id,'_Acquisition_type_ID_radYALDropDownList_Input') and @type='text']");
    By txtDocumentNumberSummary  = By.xpath("//*[contains(@id,'tractInfo')]/..//*[contains(text(),'Document Number: #:')]/..");
    By btnSave = By.xpath("//input[contains(@id,'_TractType_btnInternalSave')]");
    By btnActive = By.xpath("//input[contains(@id,'_RadDockTractSS_C_takeOffline')]");
   //Crown Land Class Custom Control Fields
    By txtMunicipality = By.xpath("//*[text()='Municipality']/..//input[@type='text']");
    By drpDepartment = By.xpath("//*[text()='Department']/..//input[@type='text']");
    By closeDrpDepartment = By.xpath("//*[text()='Department']/..//td[contains(@class,'rcbArrow')]");
    By txtName = By.xpath("//*[text()='Name or Title']/..//input[@type='text']");
    By firstDDValue = By.xpath("(//*[contains(@id,'_YALComboBox_DropDown')]/..//li[1])[1]");
    By drpCrownLandJurisdiction = By.xpath("//*[contains(text(),'Crown Land Jurisdiction')]/..//input[@type='text']");
    By drpAgreementGrantor = By.xpath("//*[contains(text(),'Agreement Grantor')]/..//input[@type='text']");
    By drpApplicationType = By.xpath("//*[contains(text(),'Application/Request Type')]/..//input[@type='text']");
    By drpAgreementType = By.xpath("//*[contains(text(),'Agreement Type')]/..//input[@type='text']");
    By drpAuthorizationStatus = By.xpath("//*[contains(text(),'Authorization Status')]/..//input[@type='text']");
    By radioButtonOutOfScope = By.xpath("//*[contains(text(),'Out of Scope')]/..//*");
    By btnNo = By.xpath("(//*[contains(text(),'Out of Scope')]/..//input)[2]");
    By txtCrownLandApplicationNumber = By.xpath("//*[text()='Crown Land Application Number']/..//input[@type='text']");
    By txtCrownLandApprovalNumber = By.xpath("//*[text()='Crown Land Approval Number']/..//input[@type='text']");
    By drpDocumentAuthor = By.xpath("//*[text()='Document Author']/..//input[@type='text']");
    By drpAuthorizationHolder = By.xpath("//*[text()='Authorization Holder']/..//input[@type='text']");
    By drpAuthorizationSource = By.xpath("//*[text()='Authorization Source']/..//input[@type='text']");
    By txtSpecialCondition = By.xpath("//*[text()='Special Conditions or Commitments']/..//textarea");
    By drpFieldContact = By.xpath("//*[text()='Field Contact']/..//input[@type='text']");
    By drpFacilityGroup = By.xpath("//*[text()='Facility Group']/..//input[@type='text']");
    By closeDrpFacilityGroup = By.xpath("//*[text()='Facility Group']/..//td[contains(@class,'rcbArrow')]");
    By txtClientID = By.xpath("//*[text()='Client ID VL']/..//input[@type='text']");
    By txtKeywords = By.xpath("//*[text()='Keywords']/..//input[@type='text']");
    By headerRelationships = By.xpath("//*[text()='Relationships']");
    By drpReleatedCrownLandAuthorization = By.xpath("//*[text()='Related Crown Land Authorization']/..//input[@type='text']");
    By closeDrpRCLADD = By.xpath("//*[text()='Related Crown Land Authorization']/..//td[contains(@class,'rcbArrow')]");
    By drpRelatedPrivateLandAuthorization = By.xpath("//*[text()='Related Private Land Authorization']/..//input[@type='text']");
    By closeDrpRPLADD = By.xpath("//*[text()='Related Private Land Authorization']/..//td[contains(@class,'rcbArrow')]");
    By drpRelatedThirdPartyAuthorization = By.xpath("//*[text()='Related Third Party Authorization']/..//input[@type='text']");
    By closeDrpRTPADD = By.xpath("//*[text()='Related Third Party Authorization']/..//td[contains(@class,'rcbArrow')]");
    By drpRelatedPermitAuthorization = By.xpath("//*[text()='Related Permit Authorization']/..//input[@type='text']");
    By closeDrpRPADD = By.xpath("//*[text()='Related Permit Authorization']/..//td[contains(@class,'rcbArrow')]");
    By headerLocationProperties = By.xpath("//*[text()='Location Properties']");
    By txtLocationPIN = By.xpath("//*[text()='Location - PIN/PIN Number']/..//input[@type='text']");
    By txtPointLocation = By.xpath("//*[contains(text(),'Point Location')]/..//input[@type='text']");
    By drpGroupNumber = By.xpath("//*[contains(text(),'Group Number')]/..//input[@type='text']");
    By drpBatch = By.xpath("//*[contains(text(),'Batch')]/..//input[@type='text']");
    By drpSubstations = By.xpath("//*[contains(text(),'Substations')]/..//input[@type='text']");
    By drpLines = By.xpath("//*[contains(text(),'Lines')]/..//input[@type='text']");
    By drpWorkfront = By.xpath("//*[contains(text(),'Workfront')]/..//input[@type='text']");
    By drpRoadObject = By.xpath("//*[contains(text(),'Road Object')]/..//input[@type='text']");
    By drpLandObject = By.xpath("//*[contains(text(),'Land (Parcel) Object')]/..//input[@type='text']");
    By drpCrossingObject = By.xpath("//*[contains(text(),'Crossing Object')]/..//input[@type='text']");
    By drpStructureNumber = By.xpath("//*[contains(text(),'Structure Number')]/..//input[@type='text']");
    By txtAccessComments = By.xpath("//*[contains(text(),'Access Comments')]/..//textarea");
    By msgWarning = By.xpath("//*[contains(text(),'WARNING: SAVE YOUR WORK BEFORE MOVING ON TO THE NEXT SECTION')]");
    //Private Land Class Custom Control Fields
    By drpPrivateLandJurisdiction = By.xpath("//*[contains(text(),'Private Land Jurisdiction')]/..//input[@type='text']");
    By drpOwnershipName = By.xpath("//*[contains(text(),'Ownership Name')]/..//input[@type='text']");
    By drpOwnershipType = By.xpath("//*[contains(text(),'Ownership Type')]/..//input[@type='text']");
    By txtOwnershipOccupancyNotes = By.xpath("//*[contains(text(),'Ownership Occupancy Notes')]/..//textarea");
    By drpPrivateLandRequestNumber = By.xpath("//*[contains(text(),'Private Land Request Number')]/..//input[@type='text']");
    By txtNotes = By.xpath("//*[text()='Notes']/..//textarea");
    //Permit Class Custom Control Fields
    By drpPermitJurisdiction = By.xpath("//*[contains(text(),'Permit Jurisdiction')]/..//input[@type='text']");
    By txtPermitApprovalNo = By.xpath("//*[contains(text(),'Permit Approval Number')]/..//input[@type='text']");
    By txtPermitApplicationNo = By.xpath("//*[contains(text(),'Permit Application Number')]/..//input[@type='text']");
  //Third Party Class Custom Control Fields
    By drpThirdPartyJurisdiction = By.xpath("//*[contains(text(),'Third Party Jurisdiction')]/..//input[@type='text']");
    By txtThirdPartyRequestNumber = By.xpath("//*[contains(text(),'Third Party Request Number')]/..//input[@type='text']");
    By txtThirdPartyAgreementNumber = By.xpath("//*[contains(text(),'Third Party Agreement Number')]/..//input[@type='text']");
    
    public void navigateParcelInformation() {
		util.waitUntilElementDisplay(navParcel);
		util.click(navParcel);
		util.waitUntilElementDisplay(navParcelInfo);
		util.click(navParcelInfo);
		util.waitUntilElementDisplay(navParcelInformation);
		util.click(navParcelInformation);
		commonFunction.projectSelection();
		
		
	}
    public void addParcel() {
    	util.click(addParcel);
    		util.waitUntilElementDisplay(btnaddParcel);
    		util.click(btnaddParcel);
    
    }
    
    public void verifyParcelType() {
    	util.click(drpParcelType);
    	SoftAssert sf= new SoftAssert();
		sf.assertTrue(util.isElementVisible(crownLandPT), "Crown Land Class Type not visible");
		sf.assertTrue(util.isElementVisible(permitPT), "Permit Class Type not visible");
		sf.assertTrue(util.isElementVisible(privatePT), "Private Class Type not visible");
		sf.assertTrue(util.isElementVisible(thirdPartyPT), "Third Party Class Type not visible");
		sf.assertAll();
}
    
    public void selectParcelType(String value) {
    	
    			if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpParcelType, value);
	}
    
    By drpParcelTypePopUp = By.xpath("//input[@id='TractType_Tract_Type_ID_radYALDropDownList_Input' and @type='text']");
    By firstParcelTypePopUp = By.xpath("//*[@id='TractType_Tract_Type_ID_radYALDropDownList_DropDown']/..//li[1]");
    public void selectParcelTypePopUp(String value) {
		if (!commonFunction.checkNA(value))
	util.inputTextAndPressTab(drpParcelTypePopUp, value);
}
    
    public void selectParcelTypePopUp() {
		util.click(drpParcelTypePopUp);
		util.click(firstParcelTypePopUp);
}
    
    public void addParcelNo(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtParcelNo, util.randomNumber());
	}
    
    By txtParcelNoPopUp = By.xpath("//input[@id='TractType_TRACT_NUMBER' and @type='text']");
    
    public void addParcelNoPopUp(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtParcelNoPopUp, util.randomNumber());
	}
    
    public void selectState(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpState, value);
	}
    
     By drpStatePopUp = By.xpath("//input[@id='TractType_STATE_Input' and @type='text']");
     public void selectStatePopUp(String value) {
 		if (!commonFunction.checkNA(value))
 			util.inputTextAndPressTab(drpStatePopUp, value);
 	}
     
    public void addTotalParcelAcres(String value) {
  		if (!commonFunction.checkNA(value))
  			util.inputTextAndPressTab(txtTotalParcelAcres, value);
  	}
  
    By txtTotalParcelAcresPopUp = By.xpath("//input[@id='TractType_TractTAcres' and @type='text']");
    public void addTotalParcelAcresPopUp(String value) {
  		if (!commonFunction.checkNA(value))
  			util.inputTextAndPressTab(txtTotalParcelAcresPopUp, value);
  	}
    
    public void addComments(String value) {
  		if (!commonFunction.checkNA(value))
  			util.inputTextAndPressTab(txtComments, value);
  	}
   
    By txtCommentsPopUp = By.xpath("//textarea[contains(@id,'TractType_radComments')]");
    public void addCommentsPopUp(String value) {
  		if (!commonFunction.checkNA(value))
  			util.inputTextAndPressTab(txtCommentsPopUp, value);
  	}
    
    public void clickOnSave() {
    	util.waitUntilElementDisplay(btnSave);
		util.click(btnSave);
		util.dummyWait(2);
		util.waitUntilLoaderDisappearValard();

	}
    
    By btnSavePopUp = By.xpath("//input[contains(@id,'btnSaveAndClose')]");
    public void clickOnSavePopUp() {
    	util.waitUntilElementDisplay(btnSavePopUp);
		util.click(btnSavePopUp);
		util.dummyWait(2);
	}
   
    public void clickOnActive() {
    	util.waitUntilElementDisplay(btnActive);
		util.click(btnActive);
		util.dummyWait(3);
	}
    
    By firstType = By.xpath("//*[contains(@id,'TractType_Tract_Type_ID_radYALDropDownList_DropDown')]/..//li[1]");
    By firstProperty = By.xpath("//*[contains(@id,'TractType_Property_Type_ID_radYALDropDownList_DropDown')]/..//li[1]");
    By firstAcqType = By.xpath("//*[contains(@id,'TractType_Acquisition_type_ID_radYALDropDownList_DropDown')]/..//li[1]");
    By firstAcqPrio = By.xpath("(//*[contains(@id,'TractType_Acquisition_type_IDCMB_YALComboBox_DropDown')]/..//input)[1]");
    By closeAcqPrio = By.xpath("//*[contains(@id,'TractType_Acquisition_type_IDCMB_YALComboBox_Arrow')]");
    
    public void AddParcel(Map<String, String> map, String testcaseName) {
    	if(testcaseName.contains("Private")) {
    	try {
    		navigateParcelInformation();
			log("STEP 1: User can navigate to the Parcel Information ", Status.PASS);
		} catch (Exception e) {
			log("STEP 1:  User cannot see the Parcel Information option in Menu", Status.FAIL);
			throw new RuntimeException("User cannot see the Parcel Information option in Menu");
		}
    	}
    	
    	  try {
    	   addParcel();
    	   log("STEP 2: User can click on the add Parcel button  ", Status.PASS);
    	} catch (Exception e) {
		   log("STEP 2:  User cannot see the add Parcel button  ", Status.FAIL);
		   throw new RuntimeException(" Failed in step 2 ");
	   }
    	 
    	   if(util.isElementPresent(frmFullALT)) {
    		   util.switchToIframe(frmFullALT);
    		   
    		   try {
    	      		 selectParcelTypePopUp();
    	  			 log("STEP 3:  Added value displays in Parcel Type field ", Status.PASS);
    	  		 } catch (Exception e) {
    	  			log("STEP 3:  User  cannot select  value  from Parcel Type DD  ", Status.FAIL);
    	  			throw new RuntimeException("Failed in step 3");
    	  		 }
    		   
    		   try {
	            	addParcelNoPopUp(map.get(Excel.ParcelNo));
	            	RecordNo=map.get(Excel.ParcelNo);
	            	ExtentTestManager.info("Enter Record No: " +map.get(Excel.ParcelNo));
	    			log("STEP 4:  User can enter a value in Parcel Number field    ", Status.PASS);
	    		} catch (Exception e) {
	    			log("STEP 4:  User cannot add a value in Parcel Number field ", Status.FAIL);
	    			throw new RuntimeException("Failed in step 4");
	    		}
    	          
    	    	    if(util.isElementPresent(drpStatePopUp)) {
    	            	try {
    	            	     selectStatePopUp(map.get(Excel.State));                                         
    	           		     log("STEP 5:  User can select value from the State DD  ", Status.PASS);
    	           	    } catch (Exception e) {
    	           		     log("STEP 5: User  cannot select  value  from the State DD  ", Status.FAIL);
    	           		     throw new RuntimeException("Failed in step 5");
    	           	    }
    	            	
    	            }
    	        
    	        	
    	      
    	        try {
    	        	addTotalParcelAcresPopUp(map.get(Excel.TotalParcelAcres));
    				log("STEP 6: user can able to enter total tract acers     ", Status.PASS);
    			} catch (Exception e) {
    				log("STEP 6:  user not able to enter total tract acers     ", Status.FAIL);
    				throw new RuntimeException("Failed in step 6");
    			}
    	    	
    	        try {
    	        	Assert.assertFalse(util.isElementVisible(txtCommentsPopUp));
    				log("STEP 7: user cannot see comments field    ", Status.PASS);
    			} catch (AssertionError e) {
    				log("STEP 7:  user can see Comments Field   ", Status.FAIL);
    			 }

    	        try {
    	        	clickOnSavePopUp();
    				log("STEP 8: Parcel is created sucessfully    ", Status.PASS);
    			} catch (Exception e) {
    				log("STEP 8:  Parcel is not created    ", Status.FAIL);
    				throw new RuntimeException("Failed in step 8");
    			}
    		   
    	   }else {
    		   
    		   if(testcaseName.contains("Private")) {
    		   try {
    			   verifyParcelType();
    	  			 log("STEP 3:  User can verify Classes", Status.PASS);
    	  		 } catch (Exception e) {
    	  			log("STEP 3:  User  cannot verify Classes", Status.FAIL);
    	  			throw new RuntimeException("Failed in step 3");
    	  		 }
    		   }
    		   
    	   
    	    try {
      		 selectParcelType(map.get(Excel.ParcelType));
      		PARCEL_TYPE=map.get(Excel.ParcelType);
      		RecordNo= util.getAttributeValue(txtParcelNo, "value");
  			 log("STEP 4:  User can select the Class", Status.PASS);
  		 } catch (Exception e) {
  			log("STEP 4:  User  cannot select  the Class", Status.FAIL);
  			throw new RuntimeException("Failed in step 4");
  		 }
    	    if(testcaseName.contains("CrownLand")){
    	    	CrownLandRecordNo= util.getAttributeValue(txtParcelNo, "value");
    	    }
          
    	    if(util.isElementPresent(drpState)) {
            	try {
            	     selectState(map.get(Excel.State));                                         
           		     log("STEP 5:  User can select value from the State DD  ", Status.PASS);
           	    } catch (Exception e) {
           		     log("STEP 5: User  cannot select  value  from the State DD  ", Status.FAIL);
           		     throw new RuntimeException("Failed in step 5");
           	    }
            }
       
      
    	try {
        	addTotalParcelAcres(map.get(Excel.TotalParcelAcres));
			log("STEP 6: user can able to enter total tract acers     ", Status.PASS);
		} catch (Exception e) {
			log("STEP 6:  user not able to enter total tract acers     ", Status.FAIL);
			throw new RuntimeException("Failed in step 6");
		}
    	
    	 if(testcaseName.contains("Private")) {
        try {
        	Assert.assertFalse(util.isElementVisible(txtComments));
			log("STEP 7: user cannot see comments field    ", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 7:  user can see Comments Field   ", Status.FAIL);
		 }
        
        try {
        	Assert.assertFalse(util.isElementVisible(drpPropertyType));
			log("STEP 8: user cannot see Property Type DD Field", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 8:  user can see Property Type DD Field", Status.FAIL);
		 }
        
        try {
        	Assert.assertFalse(util.isElementVisible(drpAcquisitionType));
			log("STEP 9: user cannot see Acquisition Type DD Field ", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 9:  user can see Acquisition Type DD Field  ", Status.FAIL);
		 }
        
        try {
        	Assert.assertFalse(util.isElementVisible(drpCounty));
			log("STEP 10: user cannot see County DD Field ", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 10:  user can see County DD Field  ", Status.FAIL);
		 }
        
        
    	 }
        
      try {
        	clickOnSave();
        	ExtentTestManager.infoWithScreenshot("Custom fields.");
			log("STEP 11: Parcel is created sucessfully    ", Status.PASS);
		} catch (Exception e) {
			log("STEP 11:  Parcel is not created    ", Status.FAIL);
			throw new RuntimeException("Failed in step 11");
		}
      
      
      if(testcaseName.contains("Private")) {
    	  try {
          	Assert.assertFalse(util.isElementVisible(txtDocumentNumberSummary));
  			log("STEP 12: user cannot see Document Number Configured in the Parcel Summary ", Status.PASS);
  		} catch (AssertionError e) {
  			log("STEP 12:  user can see Document Number Configured in the Parcel Summary ", Status.FAIL);
  		 }
      }
      }
   
        util.dummyWait(5);
    }
	
    public void addValue(By by, String value) {
  		if (!commonFunction.checkNA(value))
  			util.inputTextAndPressTab(by, value);
  	}
    
    public void selectValue(By by, String value) {
  		if (!commonFunction.checkNA(value))
  			util.inputText(by, value);
  		util.pressDownkey();
  		util.pressENTERkey();
  	}
    
    public void verifyCustomFields(Map<String, String> map, String testcaseName) {
    	
    	try {
    		addValue(txtMunicipality, map.get("Municipalty"));
			log("STEP 9: User can add Municipalty", Status.PASS);
		} catch (Exception e) {
			log("STEP 9:   User cannot add Municipalty", Status.FAIL);
			throw new RuntimeException("Failed in step 9");
		}
    	
    	try {
    		selectValue(drpDepartment, map.get("Department"));
    		util.click(closeDrpDepartment);
			log("STEP 10: User can select Department", Status.PASS);
		} catch (Exception e) {
			log("STEP 10:   User cannot select Department ", Status.FAIL);
			throw new RuntimeException("Failed in step 10");
		}
    	
    	try {
    		addValue(txtName, map.get("Name"));
			log("STEP 11: User can add Name or Title", Status.PASS);
		} catch (Exception e) {
			log("STEP 11:   User cannot add Name or Title", Status.FAIL);
			throw new RuntimeException("Failed in step 11");
		}
    	
    	if(testcaseName.contains("Private")) {
    		try {
        		addValue(drpPrivateLandJurisdiction, map.get("LandJurisdiction"));
    			log("STEP 12: User can select Private Land Jurisdiction", Status.PASS);
    		} catch (Exception e) {
    			log("STEP 12:   User cannot select Private Land Jurisdiction", Status.FAIL);
    			throw new RuntimeException("Failed in step 12");
    		}
    	}else if(testcaseName.contains("CrownLand")){
    
    	try {
    		addValue(drpCrownLandJurisdiction, map.get("LandJurisdiction"));
			log("STEP 12: User can select Crown Land Jurisdiction", Status.PASS);
		} catch (Exception e) {
			log("STEP 12:   User cannot select Crown Land Jurisdiction", Status.FAIL);
			throw new RuntimeException("Failed in step 12");
		}
    	}else if(testcaseName.contains("Permit")){
    		try {
        		addValue(drpPermitJurisdiction, map.get("LandJurisdiction"));
    			log("STEP 12: User can select Permit Jurisdiction", Status.PASS);
    		} catch (Exception e) {
    			log("STEP 12:   User cannot select Permit Jurisdiction", Status.FAIL);
    			throw new RuntimeException("Failed in step 12");
    		}
    	}else if(testcaseName.contains("ThirdParty")){
    		try {
        		addValue(drpThirdPartyJurisdiction, map.get("LandJurisdiction"));
    			log("STEP 12: User can select Third Party Jurisdiction", Status.PASS);
    		} catch (Exception e) {
    			log("STEP 12:   User cannot select Third Party Jurisdiction", Status.FAIL);
    			throw new RuntimeException("Failed in step 12");
    		}
    	}
    	try {
    		util.click(drpAgreementGrantor);
    		util.click(firstDDValue);
			log("STEP 13: User can select Agreement Grantor / Issuer", Status.PASS);
		} catch (Exception e) {
			log("STEP 13:   User cannot select Agreement Grantor / Issuer", Status.FAIL);
			throw new RuntimeException("Failed in step 13");
		}
    	
    	try {
    		addValue(drpApplicationType, map.get("ApplicationType"));
			log("STEP 14: User can select Application / Request Type", Status.PASS);
		} catch (Exception e) {
			log("STEP 14:   User cannot select Application / Request Type", Status.FAIL);
			throw new RuntimeException("Failed in step 14");
		}
    	
    	try {
    		Assert.assertTrue(util.isElementVisible(drpAgreementType));
			log("STEP 15: User can see Agreement Type DD", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 15:   User cannot see Agreement Type DD", Status.FAIL);
		}
    	
    	try {
    		addValue(drpAuthorizationStatus, map.get("AuthorizationStatus"));
    		AUTHORIZATION_STATUS=map.get("AuthorizationStatus");
			log("STEP 15: User can select Authorization Status", Status.PASS);
		} catch (Exception e) {
			log("STEP 15:   User cannot select Authorization Status", Status.FAIL);
			throw new RuntimeException("Failed in step 15");
		}
    	
    	try {
    		Assert.assertTrue(util.isElementVisible(radioButtonOutOfScope));
    		util.click(btnNo);
			log("STEP 16: User can see Out of Scope radio buttons", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 16:   User cannot see Out of Scope radio buttons", Status.FAIL);
		}
    	
    	if(testcaseName.contains("Private")) {
    		try {
    			util.click(drpOwnershipName);
        		util.click(firstDDValue);
    			log("STEP 17: User can select Ownership Name", Status.PASS);
    		} catch (Exception e) {
    			log("STEP 17:   User cannot select Ownership Name", Status.FAIL);
    			throw new RuntimeException("Failed in step 17");
    		}
    		
    		try {
        		addValue(drpOwnershipType, map.get("OwnershipType"));
    			log("STEP 18: User can select Ownerhip Type", Status.PASS);
    		} catch (Exception e) {
    			log("STEP 18:   User cannot select Ownerhip Type", Status.FAIL);
    			throw new RuntimeException("Failed in step 18");
    		}
    		
    		if(util.isElementVisible(txtOwnershipOccupancyNotes)) {
    		try {
        		addValue(txtOwnershipOccupancyNotes, map.get("OwnershipOccupancyNote"));
    			log("STEP : User can add Ownership Occupancy Note", Status.PASS);
    		} catch (Exception e) {
    			log("STEP :   User cannot add Ownership Occupancy Note", Status.FAIL);
    			throw new RuntimeException("Failed to add Ownership Occupancy Note");
    		}
    		}
    		
    		try {
        		addValue(drpPrivateLandRequestNumber, map.get("PrivateLandRequestNo"));
    			log("STEP : User can add Private Land Request Number", Status.PASS);
    		} catch (Exception e) {
    			log("STEP :   User cannot add Private Land Request Number", Status.FAIL);
    			throw new RuntimeException("Failed to add Private Land Request Number");
    		}
    		
    	}else if(testcaseName.contains("CrownLand")) {
    	try {
    		addValue(txtCrownLandApplicationNumber, map.get("ApplicationNo"));
			log("STEP 17: User can enter value in  Crown Land Application Number field", Status.PASS);
		} catch (Exception e) {
			log("STEP 17:   User cannot enter value in  Crown Land Application Number field", Status.FAIL);
			throw new RuntimeException("Failed in step 17");
		}
    	
    	try {
    		addValue(txtCrownLandApprovalNumber, map.get("ApprovalNo"));
			log("STEP 18: User can enter value in  Crown Land Approval Number field", Status.PASS);
		} catch (Exception e) {
			log("STEP 18:   User cannot enter value in  Crown Land Approval Number field", Status.FAIL);
			throw new RuntimeException("Failed in step 18");
		}
    	}else if(testcaseName.contains("Permit")) {
    		
    		try {
        		addValue(txtPermitApplicationNo, map.get("ApplicationNo"));
    			log("STEP 17: User can enter value in  Permit Application Number field", Status.PASS);
    		} catch (Exception e) {
    			log("STEP 17:   User cannot enter value in  Permit Application Number field", Status.FAIL);
    			throw new RuntimeException("Failed in step 17");
    		}
    		
    		try {
        		addValue(txtPermitApprovalNo, map.get("ApprovalNo"));
    			log("STEP 18: User can enter value in  Permit Approval Number field", Status.PASS);
    		} catch (Exception e) {
    			log("STEP 18:   User cannot enter value in  Permit Approval Number field", Status.FAIL);
    			throw new RuntimeException("Failed in step 18");
    		}
    	}else if(testcaseName.contains("ThirdParty")) {
    		try {
        		addValue(txtThirdPartyRequestNumber, map.get("ApplicationNo"));
    			log("STEP 17: User can enter value in  Third Party Request Number field", Status.PASS);
    		} catch (Exception e) {
    			log("STEP 17:   User cannot enter value in  Third Party Request Number field", Status.FAIL);
    			throw new RuntimeException("Failed in step 17");
    		}
    		
    		try {
        		addValue(txtThirdPartyAgreementNumber, map.get("ApprovalNo"));
    			log("STEP 18: User can enter value in  Third Party Agreement Number field", Status.PASS);
    		} catch (Exception e) {
    			log("STEP 18:   User cannot enter value in  Third Party Agreement  Number field", Status.FAIL);
    			throw new RuntimeException("Failed in step 18");
    		}
    	}
    	
    	try {
    		util.click(drpDocumentAuthor);
    		util.click(firstDDValue);
			log("STEP 19: User can select Document Author", Status.PASS);
		} catch (Exception e) {
			log("STEP 19:   User cannot select Document Author", Status.FAIL);
			throw new RuntimeException("Failed in step 19");
		}
    	
    	try {
    		addValue(drpAuthorizationHolder, map.get("AuthorizationHolder"));
			log("STEP 20: User can select Authorization Holder", Status.PASS);
		} catch (Exception e) {
			log("STEP 20:   User cannot select Authorization Holder", Status.FAIL);
			throw new RuntimeException("Failed in step 20");
		}
    	
    	try {
    		addValue(drpAuthorizationSource, map.get("AuthorizationSource"));
			log("STEP 21: User can select Authorization Source", Status.PASS);
		} catch (Exception e) {
			log("STEP 21:   User cannot select Authorization Source", Status.FAIL);
			throw new RuntimeException("Failed in step 21");
		}
    	
    	try {
    		addValue(txtSpecialCondition, map.get("SpecialConditions"));
			log("STEP 22: User can enter Special Conditions/ Commitments", Status.PASS);
		} catch (Exception e) {
			log("STEP 22:   User cannot enter Special Conditions/ Commitments", Status.FAIL);
			throw new RuntimeException("Failed in step 22");
		}
    	
    	try {
    		util.click(drpFieldContact);
    		util.click(firstDDValue);
			log("STEP 23: User can select Field Contact", Status.PASS);
		} catch (Exception e) {
			log("STEP 23:   User cannot select Field Contact", Status.FAIL);
			throw new RuntimeException("Failed in step 23");
		}
    	
    	
    	try {
    		selectValue(drpFacilityGroup, map.get("FacilityGroup"));
    		util.click(closeDrpFacilityGroup);
			log("STEP 24: User can select Facility Group", Status.PASS);
		} catch (Exception e) {
			log("STEP 24:   User cannot select Facility Group ", Status.FAIL);
			throw new RuntimeException("Failed in step 24");
		}
    	
    	try {
    		addValue(txtClientID, map.get("ClientID"));
			log("STEP 25: User can enter Client ID", Status.PASS);
		} catch (Exception e) {
			log("STEP 25:   User cannot enter Client ID ", Status.FAIL);
			throw new RuntimeException("Failed in step 25");
		}
    	
    	try {
    		addValue(txtKeywords, map.get("Keywords"));
			log("STEP 26: User can enter Keywords", Status.PASS);
		} catch (Exception e) {
			log("STEP 26:   User cannot enter Keywords ", Status.FAIL);
			throw new RuntimeException("Failed in step 26");
		}
    	
    	if(testcaseName.contains("Private") || testcaseName.contains("Permit")) {
    	try {
    		addValue(txtNotes, map.get("Notes"));
			log("STEP : User can enter Notes", Status.PASS);
		} catch (Exception e) {
			log("STEP :   User cannot enter Notes ", Status.FAIL);
			throw new RuntimeException("Failed in step 26");
		}
    	}
    	
    	try {
    		Assert.assertTrue(util.isElementVisible(headerRelationships));
			log("STEP 27: User can see Relationships Header", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 27:   User cannot see Relationships Header", Status.FAIL);
		}
    	
    	if(testcaseName.contains("CrownLand")) {
    	try {
    		selectValue(drpReleatedCrownLandAuthorization, RecordNo);
    		util.click(closeDrpRCLADD);
			log("STEP 28: User can select Related Crown Land Authorization", Status.PASS);
		} catch (Exception e) {
			log("STEP 28:   User cannot select Related Crown Land Authorization ", Status.FAIL);
			throw new RuntimeException("Failed in step 28");
		}
    	}else {
    	try {
    			Assert.assertTrue(util.isElementVisible(drpReleatedCrownLandAuthorization));
			log("STEP 28: User can select Related Crown Land Authorization", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 28:   User cannot select Related Crown Land Authorization ", Status.FAIL);
			
		}
    	}
    	
    	if(testcaseName.contains("Private")) {
    	try {
    		selectValue(drpRelatedPrivateLandAuthorization, RecordNo);
            util.click(closeDrpRPLADD);
			log("STEP 29: User can see Related Private Land Authorization DD", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 29:   User cannot see Related Private Land Authorization DD", Status.FAIL);
		}
        }else {
    	try {
    		Assert.assertTrue(util.isElementVisible(drpRelatedPrivateLandAuthorization));
			log("STEP 29: User can see Related Private Land Authorization DD", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 29:   User cannot see Related Private Land Authorization DD", Status.FAIL);
		}
        }
    	
    	if(testcaseName.contains("ThirdParty")) {
    		try {
        		selectValue(drpRelatedThirdPartyAuthorization, RecordNo);
                util.click(closeDrpRTPADD);
    			log("STEP 29: User can see Related Third Party Authorization DD", Status.PASS);
    		} catch (AssertionError e) {
    			log("STEP 29:   User cannot see Related Third Party Authorization DD", Status.FAIL);
    		}
    	}else {
    	try {
    		Assert.assertTrue(util.isElementVisible(drpRelatedThirdPartyAuthorization));
			log("STEP 30: User can see Related Third Party Authorization DD", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 30:   User cannot see Related Third Party Authorization DD", Status.FAIL);
		}
    	}
    	
    	if(testcaseName.contains("Permit")) {
    		try {
        		selectValue(drpRelatedPermitAuthorization, RecordNo);
                util.click(closeDrpRPADD);
    			log("STEP 29: User can see Related Permit Authorization DD", Status.PASS);
    		} catch (AssertionError e) {
    			log("STEP 29:   User cannot see Related Permit Authorization DD", Status.FAIL);
    		}
    	}else {
    	try {
    		Assert.assertTrue(util.isElementVisible(drpRelatedPermitAuthorization));
			log("STEP 31: User can see Related Permit Authorization DD", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 31:   User cannot see Related Permit Authorization DD", Status.FAIL);
		}
    	}
    	
    	
    	try {
    		Assert.assertTrue(util.isElementVisible(headerLocationProperties));
			log("STEP 32: User can see Location Properties Title", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 32:   User cannot see Location Properties Title", Status.FAIL);
		}
    	
    	try {
    		addValue(txtLocationPIN, map.get("PINNumber"));
			log("STEP 33: User can enter Location PIN", Status.PASS);
		} catch (Exception e) {
			log("STEP 33:   User cannot enter Location PIN ", Status.FAIL);
			throw new RuntimeException("Failed in step 33");
		}
    	
    	try {
    		addValue(txtPointLocation, map.get("PointLocation"));
			log("STEP 34: User can enter Point Location ", Status.PASS);
		} catch (Exception e) {
			log("STEP 34:   User cannot enter Point Location  ", Status.FAIL);
			throw new RuntimeException("Failed in step 34");
		}
    	
    	try {
    		Assert.assertTrue(util.isElementVisible(drpGroupNumber));
			log("STEP 35: User can see Group Number DD", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 35:   User cannot see Group Number DD", Status.FAIL);
		}
    	
    	try {
    		Assert.assertTrue(util.isElementVisible(drpBatch));
			log("STEP 36: User can see Batch DD", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 36:   User cannot see Batch DD", Status.FAIL);
		}
    	
    	try {
    		Assert.assertTrue(util.isElementVisible(drpSubstations));
			log("STEP 37: User can see Substations DD", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 37:   User cannot see Substations DD", Status.FAIL);
		}
    	
    	try {
    		Assert.assertTrue(util.isElementVisible(drpLines));
			log("STEP 38: User can see Lines DD", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 38:   User cannot see Lines DD", Status.FAIL);
		}
    	
    	try {
    		Assert.assertTrue(util.isElementVisible(drpWorkfront));
			log("STEP 39: User can see Workfront DD", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 39:   User cannot see Workfront DD", Status.FAIL);
		}
    	
    	try {
    		Assert.assertTrue(util.isElementVisible(drpRoadObject));
			log("STEP 40: User can see Road Object DD", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 40:   User cannot see Road Object DD", Status.FAIL);
		}
    	
    	try {
    		Assert.assertTrue(util.isElementVisible(drpLandObject));
			log("STEP 41: User can see Land Object DD", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 41:   User cannot see Land Object DD", Status.FAIL);
		}
    	
    	try {
    		Assert.assertTrue(util.isElementVisible(drpCrossingObject));
			log("STEP 42: User can see Crossing Object DD", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 42: User cannot see Crossing Object DD", Status.FAIL);
		}
    	
    	try {
    		Assert.assertTrue(util.isElementVisible(drpStructureNumber));
			log("STEP 43: User can see Structure Number DD", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 43: User cannot see Structure Number DD", Status.FAIL);
		}
    	
    	try {
    		addValue(txtAccessComments, map.get("AccessComments"));
			log("STEP 44: User can enter Access comments ", Status.PASS);
		} catch (Exception e) {
			log("STEP 44:   User cannot enter Access comments ", Status.FAIL);
			throw new RuntimeException("Failed in step 44");
		}
    	
    	try {
    		Assert.assertTrue(util.isElementVisible(msgWarning));
			log("STEP 45: User can see Warning", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 45: User cannot see Warning", Status.FAIL);
		}
    	ExtentTestManager.infoWithScreenshot("Custom fields");
    	try {
    		clickOnSave();
			log("STEP 46: User can click on Save button", Status.PASS);
		} catch (Exception e) {
			log("STEP 46:   User cannot click on Save button ", Status.FAIL);
			throw new RuntimeException("Failed in step 46");
		}
    	
    	try {
   		 By authorizationStatusParcelList = By.xpath("(//strong[text()='"+PARCEL_TYPE+"']/..//*[text()='"+AUTHORIZATION_STATUS+"'])[1]");
   		 assertTrue(util.isElementVisible(authorizationStatusParcelList));
			log("STEP 47: User can see Authorization Status in Parcel List Data Points", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 47:  User cannot see Authorization Status in Parcel List Data Points", Status.FAIL);
			throw new RuntimeException("Failed in step 47");
		}
    }
    
}
