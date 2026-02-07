package pages.ProjectSetup;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;
import extentReports.ExtentTestManager;

public class AddNewParcelPage extends BasePage
{
	TestUtil util;
	CommonFunction commonFunction;
	public static String PARCEL_NUMBER;
	public int count1=0;
	public int count2=1;
	
	public AddNewParcelPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	
	By navParcel = By.xpath("//span[text()='Parcel'] | //span[text()='Tract']");
	By navParcelInfo = By.xpath("//span[text()='Parcel Info'] | //span[text()='Tract Info']");
	By navParcelInformation = By.xpath("//span[contains(text(),'Parcel Information')] | //span[contains(text(),'Tract Information')] | //span[contains(text(),'Record Information')]");
	By addParcel = By.xpath("//img[@onclick='showMenu(event)']");
	By frmFull = By.xpath("//iframe[@name='TractMenu']");
	By frmFullALT = By.xpath("//iframe[@name='radwinAddNewTract'] | //iframe[@name='TractMenu']");
    By btnaddParcel = By.xpath("//li[contains(@class,'rmItem rmFirst rmLast')]/..//*[text()='Add Parcel' or text()='Tract' or text()='DocumentNumber' or text()='Parcel' or text()='Add Tract' or text()='Location' or text()='Add parcel' or text()='Parcel(Map/Lot)']"); 
                                                                                                                  
    By btnaddReorder = By.xpath("//li[contains(@class,'rmLast')]/..//span[text()='Reorder']");
    By btnaddParcelOld = By.xpath("//li[contains(@class,'rmLast')]/..//*[text()='Add Parcel' or text()='Tract']");
    By drpParcelType = By.xpath("//input[contains(@id,'_Tract_Type_ID_radYALDropDownList_Input') and @type='text']");
    By drpPropertyType = By.xpath("//input[contains(@id,'_Property_Type_ID_radYALDropDownList_Input') and @type='text']");
   // Step No 5
    By drpAcquisitionPriority  = By.xpath("//input[contains(@id,'_Acquisition_type_ID_radYALDropDownList_Input') and @type='text']");	
    By txtParcelNo = By.xpath("//input[contains(@id,'TractType_TRACT_NUMBER') and @type='text']");
    By drpLineSegment = By.xpath("//input[contains(@id,'_msddlLineSeg_YALComboBox_Input') and @type='text']");
    By drpProjectPackage = By.xpath("//input[contains(@id,'_TRACT_PACKAGE_radYALDropDownList_Input') and @type='text']");
    By drpState = By.xpath("//input[contains(@id,'_TractType_STATE_Input') and @type='text']");
    By firstState = By.xpath("(//div[contains(@id,'_TractType_STATE_DropDown')]/..//li[not(contains(text(),'Select One'))])[1]");
    By drpCounty = By.xpath("//input[contains(@id,'_TractType_County') and @type='text']");
    By firstCounty = By.xpath("(//div[contains(@id,'_TractType_STATE_DropDown')]/..//li[not(contains(text(),'Select One'))])[1]");
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
    By firstParcelTypePopUp = By.xpath("(//*[@id='TractType_Tract_Type_ID_radYALDropDownList_DropDown']/..//li[not(contains(text(),'Select One'))])[1]");
    public void selectParcelTypePopUp(String value) {
		if (!commonFunction.checkNA(value))
	util.inputTextAndPressTab(drpParcelTypePopUp, value);
}
    
    public void selectParcelTypePopUp() {
		util.click(drpParcelTypePopUp);
		util.click(firstParcelTypePopUp);
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
    
    By firstAcquisitionPriorityPopUp = By.xpath("(//*[@id='TractType_Acquisition_type_ID_radYALDropDownList_DropDown']/..//li[not(contains(text(),'Select One'))])[1]");
    public void selectAcquisitionPriorityPopUp() {
		util.click(drpAcquisitionPriorityPopUp);
		util.click(firstAcquisitionPriorityPopUp);
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
   
    By firstPropertyTypePopUp = By.xpath("(//*[@id='TractType_Property_Type_ID_radYALDropDownList_DropDown']/..//li[not(contains(text(),'Select One'))])[1]");
    public void selectPropertyTypePopUp() {
		util.click(drpPropertyTypePopUp);
		util.click(firstPropertyTypePopUp);
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
    
    By firstTitleStatusPopUp = By.xpath("(//*[@id='TractType_TITLE_STATUS_ID_radYALDropDownList_DropDown']/..//li[not(contains(text(),'Select One'))])[1]");
    
    public void selectTitleStatusPopUp() {
		util.click(drpTitleStatusPopUp);
		util.click(firstTitleStatusPopUp);
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
		util.dummyWait(3);
		util.switchToDefaultContent();
//			String getStrParcelNo = driver
//					.findElement(By.xpath("(//input[contains(@id,'_TRACT_NUMBER')])[1]")).getAttribute("value");
//			
//			String getParcelNoSummary = driver
//					.findElement(By.xpath("//*[contains(@id,'tractInfo')]/..//*[contains(text(),'Parcel #') or contains(text(),'Tract #') or contains(text(),'Orion PID')  or contains(text(),'Orsted ')]/../..//td[2]")).getText();
//
//			if (getStrParcelNo.equals(getParcelNoSummary)) {
//				System.out.println(" Parcel Number  Matched !!!");
//				log("STEP 19: Parcel Number  Matched !!!", Status.PASS);
//			} else {
//				System.out.println("Parcel Number Not Matched !!!");
//				log("STEP 19: Parcel Number Not Matched !!!", Status.FAIL);
//			}

	}
    
    By btnSavePopUp = By.xpath("//input[contains(@id,'btnSaveAndClose')]");
    public void clickOnSavePopUp() {
    	util.waitUntilElementDisplay(btnSavePopUp);
		util.click(btnSavePopUp);
		util.dummyWait(2);
		util.switchToDefaultContent();;
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
				.findElement(By.xpath("//td[contains(@id,'tractInfo')]/..//*[text()='Parcel #:']/../..//td[2] | //td[contains(@id,'tractInfo')]/..//*[text()='Nova Parcel ID:']/../..//td[2]")).getText();

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
    
    By firstType = By.xpath("(//*[contains(@id,'TractType_Tract_Type_ID_radYALDropDownList_DropDown')]/..//li[not(contains(text(),'Select One'))])[1]");
    By firstProperty = By.xpath("(//*[contains(@id,'TractType_Property_Type_ID_radYALDropDownList_DropDown')]/..//li[not(contains(text(),'Select One'))])[1]");
    By firstAcqType = By.xpath("(//*[contains(@id,'TractType_Acquisition_type_ID_radYALDropDownList_DropDown')]/..//li[not(contains(text(),'Select One'))])[1]");
    By firstAcqPrio = By.xpath("(//*[contains(@id,'TractType_Acquisition_type_IDCMB_YALComboBox_DropDown')]/..//input)[1]");
    By closeAcqPrio = By.xpath("//*[contains(@id,'TractType_Acquisition_type_IDCMB_YALComboBox_Arrow')]");
    
    By checkParcelAvailability = By.xpath("(//tr[contains(@id,'ctl00_ConPHLeftTop_TractList_RadGridTracts')])[1]");
    By parcelList = By.xpath("//tr[contains(@id,'ctl00_ConPHLeftTop_TractList_RadGridTracts')]");
	By btnDelete = By.xpath("(//div[@id='ctl00_ConPHLeftTop_TractList_RadMenuTL_detached']/..//span[text()='Delete'])[1]");
	
	
	
    public void AddParcel(Map<String, String> map, String testcaseName) {
    	try {
    		navigateParcelInformation();
			log("STEP 1: User can navigate to the Parcel Information ", Status.PASS);
		} catch (Exception e) {
			log("STEP 1:  User cannot see the Parcel Information option in Menu", Status.FAIL);
			throw new RuntimeException("User cannot see the Parcel Information option in Menu");
		}
    	
    	
    	
    	if(util.isElementVisible(checkParcelAvailability)) {
			try {
				Actions act = new Actions(driver);
				List<WebElement> agreements=driver.findElements(parcelList);
				for(WebElement var: agreements) {
					By deleteParcel = By.xpath("(//tr[contains(@id,'ctl00_ConPHLeftTop_TractList_RadGridTracts')])["+count2+"]//td[2]");
			    	By parcelNotToDelete = By.xpath("//tr[contains(@id,'ctl00_ConPHLeftTop_TractList_RadGridTracts_ctl00__"+count1+"')]//td[text()='5522' or text()='7464']");
					if(!util.isElementPresent(parcelNotToDelete)) {
					WebElement web = driver.findElement(deleteParcel);
			    	util.waitUntilElementDisplay(deleteParcel);
			    	act.moveToElement(web).contextClick().build().perform();
			    	util.waitFor(300);
			    	util.click(btnDelete);
			    	util.waitFor(1000);
			    	try {    
			            Alert alert = driver.switchTo().alert();
			            alert.accept();
			        } catch (NoAlertPresentException e) {
			            System.out.println("No alert present!");
			        }
			    	util.waitFor(1000);
					}else {
						count1++;
						count2++;
					}
				}
				log("STEP 2:  User can delete all the existing parcels", Status.PASS);
			} catch (Exception e) {
				log("STEP 2: User cannot delete all the existing parcels", Status.FAIL);
				throw new RuntimeException("Failed in step 2");
			}
		
		}
    	
    	for(int i=1; i<=3; i++) {
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
	            	selectPropertyTypePopUp();
	    			log("STEP 4:  Added value displays in Property Type field   ", Status.PASS);
	    		} catch (Exception e) {
	    			log("STEP 4: User  cannot select  value  from Property Type DD  ", Status.FAIL);
	    			throw new RuntimeException("Failed in step 4");
	    		}
	        	
    		   if(util.isElementVisible(drpAcquisitionPriorityPopUp)) {
	        	try {
	            	selectAcquisitionPriorityPopUp();
	    			log("STEP 5:  Added value displays in Acquisition Priority field   ", Status.PASS);
	    		} catch (Exception e) {
	    			log("STEP 5: User  cannot select  value  from Acquisition Priority DD  ", Status.FAIL);
	    			throw new RuntimeException("Failed in step 5");
	    		}
    		   }
	            try {
	            	addParcelNoPopUp(map.get("Parcel_"+i));
	    			log("STEP 6:  User can enter a value in Parcel Number field    ", Status.PASS);
	    		} catch (Exception e) {
	    			log("STEP 6:  User cannot add a value in Parcel Number field ", Status.FAIL);
	    			throw new RuntimeException("Failed in step 6");
	    		}
    	          
    	    	    if(util.isElementPresent(drpStatePopUp)) {
    	            	try {
    	            	     selectStatePopUp(map.get(Excel.State));                                         
    	           		     log("STEP 7:  User can select value from the State DD  ", Status.PASS);
    	           	    } catch (Exception e) {
    	           		     log("STEP 7: User  cannot select  value  from the State DD  ", Status.FAIL);
    	           		     throw new RuntimeException("Failed in step 7");
    	           	    }
    	            	
    	            	try {
    	            	     selectCountyPopUp(map.get(Excel.County));                                         
    	           		     log("STEP 8:  User can select value from the County DD  ", Status.PASS);
    	           	    } catch (Exception e) {
    	           		     log("STEP 8: User  cannot select  value  from the County DD  ", Status.FAIL);
    	           		     throw new RuntimeException("Failed in step 8");
    	           	    }
    	            }
    	        
    	        	
    	      
    	        if(testcaseName.contains("ALT"))
    	        {
    	      try {
    	        	selectTitleStatusPopUp(map.get(Excel.TitleStatus));
    				log("STEP 9: Added value displays in Title Status field   ", Status.PASS);
    			} catch (Exception e) {
    				log("STEP 9:  User  cannot select  value  from Title Status DD  ", Status.FAIL);
    				throw new RuntimeException("Failed in step 9");
    			}
    	      
    	     }  
    	        if(testcaseName.contains("ROW") || testcaseName.contains("TRA") || testcaseName.contains("DOM"))
    	      {
    	    	try {
    	        	addTotalParcelAcresPopUp(map.get(Excel.TotalParcelAcres));
    				log("STEP 10: user can able to enter total tract acers     ", Status.PASS);
    			} catch (Exception e) {
    				log("STEP 10:  user not able to enter total tract acers     ", Status.FAIL);
    				throw new RuntimeException("Failed in step 10");
    			}
    	    	
    	    	if(!environment.contains("VALARD")) {
    	        try {
    	        	addCommentsPopUp(map.get(Excel.Comments));
    				log("STEP 11: user can able to enter text in comment field    ", Status.PASS);
    			} catch (Exception e) {
    				log("STEP 11:  user not able to enter text in comment field   ", Status.FAIL);
    				throw new RuntimeException("Failed in step 11");
    			 }
    	    	}
    	        }
    	        try {
    	        	clickOnSavePopUp();
    				log("STEP 12: Parcel is created sucessfully    ", Status.PASS);
    			} catch (Exception e) {
    				log("STEP 12:  Parcel is not created    ", Status.FAIL);
    				throw new RuntimeException("Failed in step 12");
    			}
    		   
    	        if(util.isElementVisible(txtParcelAcres)) {
    	           	
    	            try {
    	             	addParcelAcres(map.get(Excel.ParcelAcres));                                   
    	     			log("STEP 13: User can enter a value in Parcel Acres field     ", Status.PASS);
    	     		} catch (Exception e) {
    	     			log("STEP 13:  User cannot enter a value in Parcel Acres field      ", Status.FAIL);
    	     		   throw new RuntimeException("Failed in step 13");
    	     		} 
    	           }
    	           
    	           if(util.isElementVisible(txtGISAcres)) {
    	             try {
    	             	addGISAcres(map.get(Excel.GISAcres));
    	     			log("STEP 14: User can enter a value in GIS Acres field     ", Status.PASS);
    	     		} catch (Exception e) {
    	     			log("STEP 14:   User cannot enter a value in GIS Acres field     ", Status.FAIL);
    	     			throw new RuntimeException("Failed in step 14");
    	     		}
    	           }
    	           if(util.isElementVisible(txtLeasedAcres)) {
    	             try {
    	             	addLeasedAcres(map.get(Excel.LeasedAcres));
    	     			log("STEP 15: User can enter a value in Leased Acres field   ", Status.PASS);
    	     		} catch (Exception e) {
    	     			log("STEP 15:  User cannot enter a value in Leased Acres field   ", Status.FAIL);
    	     			throw new RuntimeException("Failed in step 15");
    	     		}
    	           }
    	            
    	             if(testcaseName.contains("ROW") || testcaseName.contains("TRA") || testcaseName.contains("DOM"))
    	           {
    	         	try {
    	             	addTotalParcelAcres(map.get(Excel.TotalParcelAcres));
    	     			log("STEP 16: user can able to enter total tract acers     ", Status.PASS);
    	     		} catch (Exception e) {
    	     			log("STEP 16:  user not able to enter total tract acers     ", Status.FAIL);
    	     			throw new RuntimeException("Failed in step 16");
    	     		}
    	         	
    	         	if(!environment.contains("VALARD")) {
    	             try {
    	             	addComments(map.get(Excel.Comments));
    	     			log("STEP 17: user can able to enter text in comment field    ", Status.PASS);
    	     		} catch (Exception e) {
    	     			log("STEP 17:  user not able to enter text in comment field   ", Status.FAIL);
    	     			throw new RuntimeException("Failed in step 17");
    	     		 }
    	         	}
    	             }
    	            
    	             
    	           try {
    	             	clickOnSave();
    	     			log("STEP 18: Parcel is created sucessfully    ", Status.PASS);
    	     		} catch (Exception e) {
    	     			log("STEP 18:  Parcel is not created    ", Status.FAIL);
    	     			throw new RuntimeException("Failed in step 18");
    	     		}
    	        
    	             util.dummyWait(5);
    	             
    	   }else {
    		   
    	   
    	    try {
    	    	util.waitUntilElementDisplay(drpParcelType);
    			util.click(drpParcelType);
    			util.click(firstType);
  			 log("STEP 3:  Added value displays in Parcel Type field ", Status.PASS);
  		 } catch (Exception e) {
  			log("STEP 3:  User  cannot select  value  from Parcel Type DD  ", Status.FAIL);
  			throw new RuntimeException("Failed in step 3");
  		 }
          
    	    if(util.isElementPresent(drpState)) {
    	    	if(environment.contains("VALARD")) {
    	    		
    	    		try {
               	     selectState("British Columbia");                                         
              		     log("STEP 4:  User can select value from the State DD  ", Status.PASS);
              	    } catch (Exception e) {
              		     log("STEP 4: User  cannot select  value  from the State DD  ", Status.FAIL);
              		     throw new RuntimeException("Failed in step 4");
              	    }
    	    	}else {
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
            }
        if(testcaseName.contains("ROW") || testcaseName.contains("TRA") || testcaseName.contains("DOM")) {
        try {
        	util.waitUntilElementDisplay(drpPropertyType);
			util.click(drpPropertyType);
			util.click(firstProperty);
			log("STEP 6:  Added value displays in Property Type field   ", Status.PASS);
		} catch (Exception e) {
			log("STEP 6: User  cannot select  value  from Property Type DD  ", Status.FAIL);
			throw new RuntimeException("Failed in step 6");
		}
     
        try {
        	selectProjectPackage(map.get(Excel.ProjectPackage));
			log("STEP 7:  user is able to select value from Project Package dd    ", Status.PASS);
		} catch (Exception e) {
			log("STEP 7: user not able to select value from  Project Package dd   ", Status.FAIL);
			throw new RuntimeException("Failed in step 7");
		}
        
        try {
        	addParcelNo(map.get("Parcel_"+i));
        	clickOnSave();
			log("STEP 8:  User can enter a value in Parcel Number field    ", Status.PASS);
		} catch (Exception e) {
			log("STEP 8:  User cannot add a value in Parcel Number field ", Status.FAIL);
			throw new RuntimeException("Failed in step 8");
		}
        
      }
       
        else {
        	try {
        		util.waitUntilElementDisplay(drpPropertyType);
    			util.click(drpPropertyType);
    			util.click(firstProperty);
    			log("STEP 6:  Added value displays in Property Type field   ", Status.PASS);
    		} catch (Exception e) {
    			log("STEP 6: User  cannot select  value  from Property Type DD  ", Status.FAIL);
    			throw new RuntimeException("Failed in step 6");
    		}
        	
        	try {
        		if(util.isElementVisible(drpAcquisitionPriority)) {
        		util.waitUntilElementDisplay(drpAcquisitionPriority);
    			util.click(drpAcquisitionPriority);
    			util.click(firstAcqType);
        		}
        		else {
        			util.waitUntilElementDisplay(txtAcquisitionPriority);
        			util.click(txtAcquisitionPriority);
        			util.click(firstAcqPrio);
        			util.click(closeAcqPrio);
        		}
    			log("STEP 7:  Added value displays in Acquisition Priority field   ", Status.PASS);
    		} catch (Exception e) {
    			log("STEP 7: User  cannot select  value  from Acquisition Priority DD  ", Status.FAIL);
    			throw new RuntimeException("Failed in step 7");
    		}
            
            try {
            	addParcelNo(map.get("Parcel_"+i));
            	clickOnSave();
    			log("STEP 8:  User can enter a value in Parcel Number field    ", Status.PASS);
    		} catch (Exception e) {
    			log("STEP 8:  User cannot add a value in Parcel Number field ", Status.FAIL);
    			throw new RuntimeException("Failed in step 8");
    		}
        	
        }
    	   }
    
        if(testcaseName.contains("ALT"))
        {
      try {
        	selectTitleStatus(map.get(Excel.TitleStatus));
			log("STEP 9: Added value displays in Title Status field   ", Status.PASS);
		} catch (Exception e) {
			log("STEP 9:  User  cannot select  value  from Title Status DD  ", Status.FAIL);
			throw new RuntimeException("Failed in step 9");
		}
        }
        
      if(util.isElementVisible(txtParcelAcres)) {
   	
       try {
        	addParcelAcres(map.get(Excel.ParcelAcres));                                   
			log("STEP 10: User can enter a value in Parcel Acres field     ", Status.PASS);
		} catch (Exception e) {
			log("STEP 10:  User cannot enter a value in Parcel Acres field      ", Status.FAIL);
		   throw new RuntimeException("Failed in step 10");
		} 
      }
      
      if(util.isElementVisible(txtGISAcres)) {
        try {
        	addGISAcres(map.get(Excel.GISAcres));
			log("STEP 11: User can enter a value in GIS Acres field     ", Status.PASS);
		} catch (Exception e) {
			log("STEP 11:   User cannot enter a value in GIS Acres field     ", Status.FAIL);
			throw new RuntimeException("Failed in step 11");
		}
      }
      if(util.isElementVisible(txtLeasedAcres)) {
        try {
        	addLeasedAcres(map.get(Excel.LeasedAcres));
			log("STEP 12: User can enter a value in Leased Acres field   ", Status.PASS);
		} catch (Exception e) {
			log("STEP 12:  User cannot enter a value in Leased Acres field   ", Status.FAIL);
			throw new RuntimeException("Failed in step 12");
		}
      }
       
        if(testcaseName.contains("ROW") || testcaseName.contains("TRA") || testcaseName.contains("DOM"))
      {
    	try {
        	addTotalParcelAcres(map.get(Excel.TotalParcelAcres));
			log("STEP 9: user can able to enter total tract acers     ", Status.PASS);
		} catch (Exception e) {
			log("STEP 9:  user not able to enter total tract acers     ", Status.FAIL);
			throw new RuntimeException("Failed in step 9");
		}
    	
        try {
        	addComments(map.get(Excel.Comments));
			log("STEP 10: user can able to enter text in comment field    ", Status.PASS);
		} catch (Exception e) {
			log("STEP 10:  user not able to enter text in comment field   ", Status.FAIL);
			throw new RuntimeException("Failed in step 10");
		 }
        }
       
        
      try {
        	clickOnSave();
			log("STEP 13: Parcel is created sucessfully    ", Status.PASS);
		} catch (Exception e) {
			log("STEP 13:  Parcel is not created    ", Status.FAIL);
			throw new RuntimeException("Failed in step 13");
		}
      }
   
        util.dummyWait(5);
    	}
 
	
}
