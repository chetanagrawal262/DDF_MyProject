package pages.RoyaltyPayment;

import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;
import extentReports.ExtentTestManager;
import pages.InfoByParcelReport.AddProjectPage;

public class ParcelInformation_AddNewParcelPage extends BasePage
{
	TestUtil util;
	CommonFunction commonFunction;
	public static String PARCEL1,PARCEL2;
	public static String COUNTY_PID;
	public static String PARCEL_ACRES;
	public static String GIS_ACRES;
	public static String LEASED_ACRES;
	public static String ACQUISITION_PRIORITY;

	public ParcelInformation_AddNewParcelPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	
	By navParcel = By.xpath("//span[text()='Parcel'] | //span[text()='Tract']");
	By navParcelInfo = By.xpath("//span[text()='Parcel Info'] | //span[text()='Tract Info']");
	By navParcelInformation = By.xpath("//span[contains(text(),'Parcel Information')] | //span[contains(text(),'Tract Information')] | //span[contains(text(),'Record Information')]");
	By addParcel = By.xpath("//img[@onclick='showMenu(event)']");
	By frmFull = By.xpath("//iframe[@name='TractMenu']");
	By frmFullALT = By.xpath("//iframe[@name='radwinAddNewTract']");
    By btnaddParcel = By.xpath("//li[contains(@class,'rmItem rmFirst rmLast')]/..//*[text()='Add Parcel'] | //li[contains(@class,'rmItem rmFirst rmLast')]/..//*[text()='Tract'] | //li[contains(@class,'rmItem rmFirst rmLast')]/..//*[text()='Document'] | //li[contains(@class,'rmItem rmFirst rmLast')]/..//*[text()='Parcel'] | //li[contains(@class,'rmItem rmFirst rmLast')]/..//*[text()='Add Tract']"); 
    By btnaddReorder = By.xpath("//li[contains(@class,'rmItem rmFirst rmLast')]/..//*[text()='Add Parcel']");
    By btnaddParcelOld = By.xpath("//li[contains(@class,'rmLast')]/..//*[text()='Add Parcel']");
    By drpParcelType = By.xpath("//input[contains(@id,'_Tract_Type_ID_radYALDropDownList_Input') and @type='text']");
    By drpPropertyType = By.xpath("//input[contains(@id,'_Property_Type_ID_radYALDropDownList_Input') and @type='text']");
   // Step No 5
    By drpAcquisitionPriority  = By.xpath("//input[contains(@id,'_Acquisition_type_ID_radYALDropDownList_Input') and @type='text']");	
    By txtParcelNo = By.xpath("//input[contains(@id,'TractType_TRACT_NUMBER') and @type='text']");
    By drpLineSegment = By.xpath("//input[contains(@id,'_msddlLineSeg_YALComboBox_Input') and @type='text']");
    By drpProjectPackage = By.xpath("//input[contains(@id,'_TRACT_PACKAGE_radYALDropDownList_Input') and @type='text']");
    By drpState = By.xpath("//input[contains(@id,'_TractType_STATE_Input') and @type='text']");
    By drpCounty = By.xpath("//input[contains(@id,'_TractType_County') and @type='text']");
    By txtCountyPID = By.xpath("//input[contains(@id,'_TractType_radGISID') and @type='text']");
    By drpTitleStatus = By.xpath("//input[contains(@id,'_STATUS_ID_radYALDropDownList_Input') and @type='text']"); 
    By txtParcelAcres = By.xpath("//*[text()='Parcel Acres:']/..//input[@type='text']");
    By txtGISAcres  = By.xpath("//*[text()='GIS Acres:']/..//input[@type='text']");
    By txtLeasedAcres = By.xpath("//*[contains(text(),'Leased Acres')]/..//input[@type='text']");	
    By txtNotes = By.xpath("//textarea[@id='TractType_tract_Notes']");
    By txtTotalParcelAcres = By.xpath("//input[contains(@id,'_TractType_TractTAcres') and @type='text']");
    By txtComments = By.xpath("//textarea[@id='ctl00_ConPHRightTop_TRPI_UC_radPrjPanels_i0_i0_TractType_radComments']");
    By btnSave = By.xpath("//input[contains(@id,'_TractType_btnInternalSave')]");
    By btnSaveDot = By.xpath("//input[@id='btnSaveAndClose']");
    By changesSavedSuccessfully = By.xpath("//span[text()='Changes saved successfully!']");
    By btnActive = By.xpath("//input[contains(@id,'_RadDockTractSS_C_takeOffline')]");
    By  getStrParcelNo = By.xpath("(//input[contains(@id,'_TRACT_NUMBER')])[1]");
	By getParcelNoSummary = By.xpath("//*[contains(@id,'TractSS_RadDockTractSS_C_tractInfo')]/..//*[contains(text(),'Parcel #') or contains(text(),'Tract #') or contains(text(),'Orion PID')  or contains(text(),'Orsted ')]/..//strong");
	By getStrParcelNoDot = By.xpath("(//input[contains(@id,'_TRACT_NUMBER')])[1]");
	By getParcelNoSummaryDot = By.xpath("(//td[@style='vertical-align: top; word-break: break-word;'])[1]");
    
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
    	if(util.isElementVisible(btnaddReorder)) {
    		util.waitUntilElementDisplay(btnaddParcelOld);
    		util.click(btnaddParcelOld);
    	}else {
    		util.waitUntilElementDisplay(btnaddParcel);
    		util.click(btnaddParcel);
    	}
    	
		
    }
    
    public void selectParcelType(String value) {
    	
    			if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpParcelType, value);
	}
    
    By drpParcelTypePopUp = By.xpath("//input[@id='TractType_Tract_Type_ID_radYALDropDownList_Input' and @type='text']");
    public void selectParcelTypePopUp(String value) {
		if (!commonFunction.checkNA(value))
	util.inputTextAndPressTab(drpParcelTypePopUp, value);
}
    
    public void selectAcquisitionPriority(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpAcquisitionPriority, value);
	}	
    
    By drpAcquisitionPriorityPopUp = By.xpath("//input[@id='TractType_Acquisition_type_ID_radYALDropDownList_Input' and @type='text']");
    public void selectAcquisitionPriorityPopUp(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpAcquisitionPriorityPopUp, value);
	}
    
    By txtAcquisitionPriority = By.xpath("//input[contains(@id,'TractType_Acquisition_type_IDCMB_YALComboBox_Input') and @type='text']");
    public void selectAcquisitionPriorityDot(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtAcquisitionPriority, value);
	}	
    
    public void selectPropertyType(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpPropertyType, value);
	}	
   
    By drpPropertyTypePopUp = By.xpath("//input[@id='TractType_Property_Type_ID_radYALDropDownList_Input' and @type='text']");
    public void selectPropertyTypePopUp(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpPropertyTypePopUp, value);
	}
   
    
    public void addParcelNo(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtParcelNo, value);
	}
    
    By txtParcelNoPopUp = By.xpath("//input[@id='TractType_TRACT_NUMBER' and @type='text']");
    
    public void addParcelNoPopUp(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtParcelNoPopUp, value);
	}
    
    public void selectLineSegment(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpLineSegment, value);
	}	
    
    public void selectProjectPackage(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpProjectPackage, value);
		
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
     
     public void selectCounty(String value) {
 		if (!commonFunction.checkNA(value))
 			util.inputTextAndPressTab(drpCounty, value);
 	}
    
     By drpCountyPopUp = By.xpath("//input[@id='TractType_County_Input' and @type='text']");
     public void selectCountyPopUp(String value) {
  		if (!commonFunction.checkNA(value))
  			util.inputTextAndPressTab(drpCountyPopUp, value);
  	}
     
    public void addCountyPID(String value) {
  		if (!commonFunction.checkNA(value))
  			util.inputTextAndPressTab(txtCountyPID, value);
  	}
   
    By txtCountyPIDPopUp = By.xpath("//input[@id='TractType_radGISID' and @type='text']");
    public void addCountyPIDPopUp(String value) {
  		if (!commonFunction.checkNA(value))
  			util.inputTextAndPressTab(txtCountyPIDPopUp, value);
  	}
    
    public void selectTitleStatus(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpTitleStatus, value);
	}	
    
    By drpTitleStatusPopUp = By.xpath("//input[@id='TractType_TITLE_STATUS_ID_radYALDropDownList_Input' and @type='text']");
    public void selectTitleStatusPopUp(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpTitleStatusPopUp, value);
	}
    
    public void addParcelAcres(String value) {
  		if (!commonFunction.checkNA(value))
  			util.inputTextAndPressTab(txtParcelAcres, value);
  		   
  	}
    
    public void addGISAcres(String value) {
  		if (!commonFunction.checkNA(value))
  			util.inputTextAndPressTab(txtGISAcres, value);
  	}
    
    public void addLeasedAcres(String value) {
  		if (!commonFunction.checkNA(value))
  			util.inputTextAndPressTab(txtLeasedAcres, value);
  	}
    
    public void addNotes(String value) {
  		if (!commonFunction.checkNA(value))
  			util.inputTextAndPressTab(txtNotes, value);
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
		if(!environment.contains("NOVA")) {
			String getStrParcelNo = driver
					.findElement(By.xpath("(//input[contains(@id,'_TRACT_NUMBER')])[1]")).getAttribute("value");
			
			String getParcelNoSummary = driver
					.findElement(By.xpath("//*[contains(@id,'tractInfo')]/..//*[contains(text(),'Parcel #') or contains(text(),'Tract #') or contains(text(),'Orion PID')  or contains(text(),'Orsted ')   or contains(text(),'Nova Parcel ID')]/../..//td[2]")).getText();

			if (getStrParcelNo.equals(getParcelNoSummary)) {
				System.out.println(" Parcel Number  Matched !!!");
				log("STEP 14: Parcel Number  Matched !!!", Status.PASS);
			} else {
				System.out.println("Parcel Number Not Matched !!!");
				log("STEP 14: Parcel Number Not Matched !!!", Status.FAIL);
			}
		}

	}
    
    By btnSavePopUp = By.xpath("//input[contains(@id,'TractType_btnSaveAndClose')]");
    public void clickOnSavePopUp() {
    	util.waitUntilElementDisplay(btnSavePopUp);
		util.click(btnSavePopUp);
		util.switchToDefaultContent();
		util.dummyWait(2);
	}
    private void VerifyParcelNumber() {
		String ParcelNo = util.getAttributeValue(getStrParcelNo, "value");
		ExtentTestManager.info("User typed: " + ParcelNo);
		util.dummyWait(2);
		ExtentTestManager.info("Verify Parcel Summary No: " + ParcelNo);
		
	}
    
    public void clickOnSaveDot() {
    	util.waitUntilElementDisplay(btnSaveDot);
		util.click(btnSaveDot);
		util.switchToDefaultContent();
		util.dummyWait(2);
		String getStrParcelNo = driver
				.findElement(By.xpath("(//input[contains(@id,'_TRACT_NUMBER')])[1]")).getAttribute("value");
		
		String getParcelNoSummary = driver
				.findElement(By.xpath("//td[contains(@id,'tractInfo')]/..//*[text()='Parcel #:']/../..//td[2]")).getText();

		if (getParcelNoSummary.equals(getStrParcelNo)) {
			System.out.println(" Parcel Number  Matched !!!");
			log("STEP 19: Parcel Number  Matched !!!", Status.PASS);
		} else {
			System.out.println("Parcel Number Not Matched !!!");
			log("STEP 19: Parcel Number Not Matched !!!", Status.FAIL);
		}

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
    
    
    By navParcelMenu = By.xpath("*//a//span[@class='rmText rmExpandDown' and contains(text(),'Parcel')]");

	public void navigateToParcelInformation() {
		util.waitUntilElementDisplay(navParcelMenu);
		util.click(navParcelMenu);
		util.waitUntilElementDisplay(navParcelInfo);
		util.click(navParcelInfo);
		util.waitUntilElementDisplay(navParcelInformation);
		util.click(navParcelInformation);
	}
    
	By txtProjectName = By.xpath("//span/parent::div[contains(@id,'ProjectList')]");
	By CategoryFilter = By.xpath("//input[contains(@class,'rddtFilterEmptyMessage')]");

	private void selectProjectNew(String value) {
		if (!commonFunction.checkNA(value)) {
			util.waitUntilElementDisplay(txtProjectName);
			util.click(txtProjectName);
			util.inputText(CategoryFilter, value);
			By selectDD = By
					.xpath("//div[contains(@id,'ProjectList_EmbeddedTree')]//*[contains(text(),'" + value + "')]");
			util.click(selectDD);

		}
	}
	
    public void AddParcel(Map<String, String> map, String testcaseName) {
    	
    	PARCEL1=map.get("ParcelNo");
    	
    	try {
			navigateToParcelInformation();
			log("STEP 1:  User can navigate to Parcel Page", Status.PASS);
		} catch (Exception e) {
			log("STEP 1:  User cannot navigate to Parcel Page", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}
		
    	try {
			selectProjectNew(AddProjectPage.PN);
			log("STEP 2:  User can select the project", Status.PASS);
		} catch (Exception e) {
			log("STEP 2:  User cannot select the project", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}
    	
		
    	  try {
    	   addParcel();
    	   log("STEP 3: User can click on the add Parcel button  ", Status.PASS);
    	} catch (Exception e) {
		   log("STEP 3:  User cannot see the add Parcel button  ", Status.FAIL);
		   throw new RuntimeException(" Failed in step 3 ");
	   }
    	 
    	   if(util.isElementPresent(frmFullALT)) {
    		   util.switchToIframe(frmFullALT);
    		   
    		   try {
    	      		 selectParcelTypePopUp(map.get(Excel.ParcelType));
    	  			 log("STEP 4:  Added value displays in Parcel Type field ", Status.PASS);
    	  		 } catch (Exception e) {
    	  			log("STEP 4:  User  cannot select  value  from Parcel Type DD  ", Status.FAIL);
    	  			throw new RuntimeException("Failed in step 4");
    	  		 }
    		   
    		   try {
	            	selectPropertyTypePopUp(map.get(Excel.PropertyType));
	    			log("STEP 5:  Added value displays in Property Type field   ", Status.PASS);
	    		} catch (Exception e) {
	    			log("STEP 5: User  cannot select  value  from Property Type DD  ", Status.FAIL);
	    			throw new RuntimeException("Failed in step 5");
	    		}
	        	
    		   if(util.isElementVisible(drpAcquisitionPriorityPopUp)) {
	        	try {
	            	selectAcquisitionPriorityPopUp(map.get(Excel.AcquisitionPriority));
	            	ACQUISITION_PRIORITY=map.get(Excel.AcquisitionPriority);
	    			log("STEP 6:  Added value displays in Acquisition Priority field   ", Status.PASS);
	    		} catch (Exception e) {
	    			log("STEP 6: User  cannot select  value  from Acquisition Priority DD  ", Status.FAIL);
	    			throw new RuntimeException("Failed in step 6");
	    		}
    		   }
    		   
    			   try {
      	            	addParcelNoPopUp(map.get("ParcelNo"));
      	    			log("STEP 7:  User can enter a value in Parcel Number field    ", Status.PASS);
      	    		} catch (Exception e) {
      	    			log("STEP 7:  User cannot add a value in Parcel Number field ", Status.FAIL);
      	    			throw new RuntimeException("Failed in step 7");
      	    		}
	            
    	          
    	    	    if(util.isElementPresent(drpStatePopUp)) {
    	            	try {
    	            	     selectStatePopUp(map.get(Excel.State));                                         
    	           		     log("STEP 8:  User can select value from the State DD  ", Status.PASS);
    	           	    } catch (Exception e) {
    	           		     log("STEP 8: User  cannot select  value  from the State DD  ", Status.FAIL);
    	           		     throw new RuntimeException("Failed in step 8");
    	           	    }
    	            	
    	            	try {
    	            	     selectCountyPopUp(map.get(Excel.County));                                         
    	           		     log("STEP 9:  User can select value from the County DD  ", Status.PASS);
    	           	    } catch (Exception e) {
    	           		     log("STEP 9: User  cannot select  value  from the County DD  ", Status.FAIL);
    	           		     throw new RuntimeException("Failed in step 9");
    	           	    }
    	            }
    	        
    	  
    	        try {
    	        	clickOnSavePopUp();
    	        	util.dummyWait(2);
    	        	VerifyParcelNumber();
    				log("STEP 10: Parcel is created sucessfully    ", Status.PASS);
    			} catch (Exception e) {
    				log("STEP 10:  Parcel is not created    ", Status.FAIL);
    				throw new RuntimeException("Failed in step 10");
    			}
    		   
    	        if(util.isElementVisible(txtParcelAcres)) {
    	           	
    	            try {
    	             	addParcelAcres(map.get(Excel.ParcelAcres)); 
    	             	PARCEL_ACRES=map.get(Excel.ParcelAcres);
    	     			log("STEP 11: User can enter a value in Parcel Acres field     ", Status.PASS);
    	     		} catch (Exception e) {
    	     			log("STEP 11:  User cannot enter a value in Parcel Acres field      ", Status.FAIL);
    	     		   throw new RuntimeException("Failed in step 11");
    	     		} 
    	           }
    	           
    	           if(util.isElementVisible(txtGISAcres)) {
    	             try {
    	             	addGISAcres(map.get(Excel.GISAcres));
    	             	GIS_ACRES=map.get(Excel.GISAcres);
    	     			log("STEP 12: User can enter a value in GIS Acres field     ", Status.PASS);
    	     		} catch (Exception e) {
    	     			log("STEP 12:   User cannot enter a value in GIS Acres field     ", Status.FAIL);
    	     			throw new RuntimeException("Failed in step 12");
    	     		}
    	           }
    	           if(util.isElementVisible(txtLeasedAcres)) {
    	             try {
    	             	addLeasedAcres(map.get(Excel.LeasedAcres));
    	             	LEASED_ACRES=map.get(Excel.LeasedAcres);
    	     			log("STEP 13: User can enter a value in Leased Acres field   ", Status.PASS);
    	     		} catch (Exception e) {
    	     			log("STEP 13:  User cannot enter a value in Leased Acres field   ", Status.FAIL);
    	     			throw new RuntimeException("Failed in step 13");
    	     		}
    	           }    
    	             
    	           try {
    	             	clickOnSave();
    	             	util.dummyWait(2);
    	     			log("STEP 14: Parcel is created sucessfully    ", Status.PASS);
    	     		} catch (Exception e) {
    	     			log("STEP 14:  Parcel is not created    ", Status.FAIL);
    	     			throw new RuntimeException("Failed in step 14");
    	     		}
    	   }else {
    		   
    	   
    	    try {
      		 selectParcelType(map.get(Excel.ParcelType));
  			 log("STEP 3:  Added value displays in Parcel Type field ", Status.PASS);
  		 } catch (Exception e) {
  			log("STEP 3:  User  cannot select  value  from Parcel Type DD  ", Status.FAIL);
  			throw new RuntimeException("Failed in step 3");
  		 }
          
    	    if(util.isElementPresent(drpState)) {
            	try {
            	     selectState(map.get(Excel.State));                                         
           		     log("STEP 4:  User can select value from the State DD  ", Status.PASS);
           	    } catch (Exception e) {
           		     log("STEP 4: User  cannot select  value  from the State DD  ", Status.FAIL);
           		     throw new RuntimeException("Failed in step 4");
           	    }
            	
            	try {
            	     selectCounty(map.get(Excel.County));                                         
           		     log("STEP 5:  User can select value from the County DD  ", Status.PASS);
           	    } catch (Exception e) {
           		     log("STEP 5: User  cannot select  value  from the County DD  ", Status.FAIL);
           		     throw new RuntimeException("Failed in step 5");
           	    }
            }
       
    
        	try {
            	selectPropertyType(map.get(Excel.PropertyType));
    			log("STEP 6:  Added value displays in Property Type field   ", Status.PASS);
    		} catch (Exception e) {
    			log("STEP 6: User  cannot select  value  from Property Type DD  ", Status.FAIL);
    			throw new RuntimeException("Failed in step 6");
    		}
        	
        	try {
            	selectAcquisitionPriority(map.get(Excel.AcquisitionPriority));
            	ACQUISITION_PRIORITY=map.get(Excel.AcquisitionPriority);
    			log("STEP 7:  Added value displays in Acquisition Priority field   ", Status.PASS);
    		} catch (Exception e) {
    			log("STEP 7: User  cannot select  value  from Acquisition Priority DD  ", Status.FAIL);
    			throw new RuntimeException("Failed in step 7");
    		}
            
        	
            	try {
                	addParcelNo(map.get("ParcelNo"));
        			log("STEP 8:  User can enter a value in Parcel Number field    ", Status.PASS);
        		} catch (Exception e) {
        			log("STEP 8:  User cannot add a value in Parcel Number field ", Status.FAIL);
        			throw new RuntimeException("Failed in step 8");
        		}
    		
    
        
    
        if(testcaseName.contains("ORSTED")|| testcaseName.contains("ORION") || environment.contains("NOVA"))
        {
        	try {
            	clickOnSave();
            	util.dummyWait(2);
    			log("STEP 9: Parcel is created sucessfully    ", Status.PASS);
    		} catch (Exception e) {
    			log("STEP 9:  Parcel is not created    ", Status.FAIL);
    			throw new RuntimeException("Failed in step 9");
    		}
      
      try {
    	  addCountyPID(map.get(Excel.CountyPID)); 
    	  COUNTY_PID=map.get(Excel.CountyPID);
			log("STEP 10: User can enter a value in Parcel Acres field     ", Status.PASS);
		} catch (Exception e) {
			log("STEP 10:  User cannot enter a value in Parcel Acres field      ", Status.FAIL);
		   throw new RuntimeException("Failed in step 10");
		}
      
      if(util.isElementVisible(txtParcelAcres)) {
   	
       try {
        	addParcelAcres(map.get(Excel.ParcelAcres)); 
        	PARCEL_ACRES=map.get(Excel.ParcelAcres);
			log("STEP 11: User can enter a value in Parcel Acres field     ", Status.PASS);
		} catch (Exception e) {
			log("STEP 11:  User cannot enter a value in Parcel Acres field      ", Status.FAIL);
		   throw new RuntimeException("Failed in step 11");
		} 
      }
      
      if(util.isElementVisible(txtGISAcres)) {
        try {
        	addGISAcres(map.get(Excel.GISAcres));
        	GIS_ACRES=map.get(Excel.GISAcres);
        	System.out.println(GIS_ACRES);
			log("STEP 12: User can enter a value in GIS Acres field     ", Status.PASS);
		} catch (Exception e) {
			log("STEP 12:   User cannot enter a value in GIS Acres field     ", Status.FAIL);
			throw new RuntimeException("Failed in step 12");
		}
      }
      if(util.isElementVisible(txtLeasedAcres)) {
        try {
        	addLeasedAcres(map.get(Excel.LeasedAcres));
        	LEASED_ACRES=map.get(Excel.LeasedAcres);
			log("STEP 13: User can enter a value in Leased Acres field   ", Status.PASS);
		} catch (Exception e) {
			log("STEP 13:  User cannot enter a value in Leased Acres field   ", Status.FAIL);
			throw new RuntimeException("Failed in step 13");
		}
      }
     }    
        
      try {
        	clickOnSave();
        	util.dummyWait(2);
			log("STEP 14: Parcel is created sucessfully    ", Status.PASS);
		} catch (Exception e) {
			log("STEP 14:  Parcel is not created    ", Status.FAIL);
			throw new RuntimeException("Failed in step 14");
		}
      }
   
        util.dummyWait(5);
    
    }
}
