package pages.projectImportALT;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.ExcelUtils;
import com.util.TestUtil;
import extentReports.ExtentTestManager;

public class ProductionTrackingImportPage extends BasePage {

	TestUtil util;
	CommonFunction commonFunction;
	ProjectImportPage objProjectImportPage;
	ErrorLog objErrorLog;
	
	public ProductionTrackingImportPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		objProjectImportPage = new ProjectImportPage(driver);
		objErrorLog = new ErrorLog(driver);
	}
	
	By date = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'Date')]/..//input[contains(@id,'Dest_Input')]");
	public String getDate() {
		return util.getAttributeValue(date, "value");
	}
	
	By turbineID = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'Turbine ID')]/..//input[contains(@id,'Dest_Input')]");
	public String getTurbineID() {
		return util.getAttributeValue(turbineID, "value");
	}
	
	By production = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'Production')]/..//input[contains(@id,'Dest_Input')]");
	public String getProduction() {
		return util.getAttributeValue(production, "value");
	}
	
	By pricePerTon = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'Price Per Ton')]/..//input[contains(@id,'Dest_Input')]");
	public String getPricePerTon() {
		return util.getAttributeValue(pricePerTon, "value");
	}
	
	By sales = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Sales: ']/..//input[contains(@id,'Dest_Input')]");
	public String getSales() {
		return util.getAttributeValue(sales, "value");
	}
	
	By salesPer = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Sales %: ']/..//input[contains(@id,'Dest_Input')]");
	public String getSalesPer() {
		return util.getAttributeValue(salesPer, "value");
	}
	
	Map<String, String> excelData;
	public void ProductionTrackingMapping(String testcaseName) {
		SoftAssert assertion = new SoftAssert();
			excelData = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProductionTrackingMapping, testcaseName);
				
				assertion.assertEquals(getDate(), excelData.get("Date").trim(), "Date mapping mismatched");
				ExtentTestManager.log("Date Mapping : "+getDate());
				
				assertion.assertEquals(getTurbineID(), excelData.get("Turbine ID").trim(), "Turbine ID mapping mismatched");
				ExtentTestManager.log("Turbine ID Mapping : "+getTurbineID());
				
				assertion.assertEquals(getProduction(), excelData.get("Production").trim(), "Production mapping mismatched");
				ExtentTestManager.log("Production Mapping : "+getProduction());
				
				if(environment.contains("RAMACO")) {
					assertion.assertEquals(getPricePerTon(), excelData.get("Price Per Ton").trim(), "Price Per Ton mapping mismatched");
					ExtentTestManager.log("Price Per Ton Mapping : "+getPricePerTon());
					
					assertion.assertEquals(getSales(), excelData.get("Sales").trim(), "Sales mapping mismatched");
					ExtentTestManager.log("Sales Mapping : "+getSales());
					
					assertion.assertEquals(getSalesPer(), excelData.get("Sales %").trim(), "Sales % mapping mismatched");
					ExtentTestManager.log("Sales % Mapping : "+getSalesPer());
				}
				assertion.assertAll();		
			
			}
	
	
	public void verifyProductionTrackingImportMapping(Map<String, String> map, String testcaseName) throws Exception {
		objProjectImportPage.projectDataImport(map, testcaseName);
		try {
			ProductionTrackingMapping(testcaseName);
			log("STEP 7:  All Agreement Contacts Mappings are correct", Status.PASS);
		} catch (Exception e) {
			log("STEP 7:  Some Mappings are Missing or Incorrect", Status.FAIL);
			throw new RuntimeException("Failed in step 7");
		}
		util.dummyWait(10);
		
	}
	
	By navProject = By.xpath("//span[text()='Project']");
	By navProductionTracking = By.xpath("//span[contains(text(),'Production Tracking')]");
	By drpYear = By.xpath("(//input[contains(@id,'ddlYear_radYALDropDownList_Input')])[1]");
	By drpPeriod = By.xpath("(//input[contains(@id,'ddlPD_radYALDropDownList_Input')])[1]");
	By btnView = By.xpath("(//input[contains(@id,'_btnView')])[2]");
	By navRoyaltyProcessing = By.xpath("//span[contains(text(),'Royalty Processing')]");
	By navProductionData = By.xpath("//span[contains(text(),'Production Data')]");
	
	public void NavigateToProductionTracking() {
    	util.waitUntilElementDisplay(navProject);
    	util.click(navProject);
    	util.waitFor(200);
  		util.waitUntilElementDisplay(navRoyaltyProcessing);
  		util.waitFor(200);
  		util.hoverOnElement(navRoyaltyProcessing);
  		util.waitUntilElementDisplay(navProductionData);
  		util.click(navProductionData);
    }
	
	public void SelectYear(String value) {
    	if (!commonFunction.checkNA(value)) 
			util.inputTextAndPressTab(drpYear, value);
    	util.dummyWait(2);
    }
    
    public void SelectPeriod(String value) {
    	if (!commonFunction.checkNA(value)) 
			util.inputTextAndPressTab(drpPeriod, value);
    	util.dummyWait(2);
    }
    
    public String month(String value) throws ParseException {
    	
    	SimpleDateFormat month_date = new SimpleDateFormat("MMMM", Locale.ENGLISH);
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		
		Date date = sdf.parse(value);

		String month_name = month_date.format(date);
		
		return month_name;	
		
    }
    
    public String year(String value) throws ParseException {
    	
    	SimpleDateFormat year = new SimpleDateFormat("yyyy", Locale.ENGLISH);
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		
		Date date = sdf.parse(value);

		String Year = year.format(date);
		
		return Year;	
    	
		
    }

    public void ClickOnView() {
    	util.waitUntilElementDisplay(btnView);
    	util.click(btnView);
    	
    }
    
    By navRevenueData = By.xpath("//span[contains(text(),'Revenue Data')]");
	By RevenuePeriods = By.xpath("(//a[@title='Expand'])[1]");
	By SelectOption = By.xpath("//label[contains(text(),'Quarterly')]");
	By btnSave = By.xpath("//input[contains(@id,'_PRODPD_btnSavePds') and @type='image']");
	By successmessage = By.xpath("//span[text()='Save successful']");
	By StartDate = By.xpath("//a[contains(text(),'Start Date')]");
	By EndDate = By.xpath("//a[contains(text(),'End Date')]");
	By txtYear = By.xpath("(//input[contains(@id,'PRODPD_dtPdStartDate_dateInput')])[1]");
	
	 public void navigateToRevenueData() {
	  		util.waitUntilElementDisplay(navProject);
	  		util.click(navProject);
	  		util.waitUntilElementDisplay(navRoyaltyProcessing);
	  		util.hoverOnElement(navRoyaltyProcessing);
	  		util.waitUntilElementDisplay(navRevenueData);
	  		util.click(navRevenueData);
	 }
	  	
	  public void ExpandRevenuePeriods() {
		  util.waitUntilElementDisplay(RevenuePeriods);
		  util.click(RevenuePeriods);
	  }
	  
	  public void SelectOption() {
		  util.waitUntilElementDisplay(SelectOption);
		  util.click(SelectOption);
	  }
	  
	  public void ClickonSaveButton() {
		  util.waitUntilElementDisplay(btnSave);
		  util.click(btnSave);
		  util.dummyWait(2);
	  }
	  
	  public void AddYear(String value) {
			if (!commonFunction.checkNA(value)) 
				util.inputTextAndPressTab(txtYear, value);
		}
    
	By prodIframe = By.xpath("//iframe[@name='ProdDailyProd']");
	
	public void validationOfImportedData(Map<String, String> map,String testcaseName) {	
		
		SoftAssert assertion = new SoftAssert();
		        
		        try {
					NavigateToProductionTracking();
					log("STEP 1: user can navigate to Production Tracking page ", Status.PASS);
				} catch (Exception e) {
					log("STEP 1: user cannot  navigate to Production Tracking page ", Status.FAIL);
					throw new RuntimeException("Failed in step 1");
				}
				
				try {
					commonFunction.projectSelection();
					log("STEP 2: User can select value from  Project dd    ", Status.PASS);
				} catch (Exception e) {
					log("STEP 2: User cannot select value from  Project dd ", Status.FAIL);
					throw new RuntimeException("Failed in step 2");
				}
				
				if(util.isElementVisible(RevenuePeriods)) {			
					try {
					 ExpandRevenuePeriods();
						log("STEP 3: user can  click on revenue periods panel ", Status.PASS);
					} catch (Exception e) {
						log("STEP 3: user cannot click on revenue periods panel ", Status.FAIL);
						throw new RuntimeException("Failed in step 3");
					}
				}

				if(util.isElementVisible(btnSave)) {
				 try {
					 SelectOption();
						log("STEP 4: user can select any one option from given options. ", Status.PASS);
					} catch (Exception e) {
						log("STEP 4: user cannot select  any one option from given options.", Status.FAIL);
						throw new RuntimeException("Failed in step 4");
					}
				
				 if(util.isElementVisible(txtYear)) {
					 try {
						 AddYear(map.get(Excel.Year));
							log("STEP 5: user can add year ", Status.PASS);
						} catch (Exception e) {
							log("STEP 5: user cannot add year", Status.FAIL);
							throw new RuntimeException("Failed in step 5");
						}
				 }else {
					 log("STEP 5: Year field is missing", Status.FAIL);
						throw new RuntimeException("Failed in step 5");
				 }

				 try {
					 ClickonSaveButton();
						log("STEP 6: user can click on save button.", Status.PASS);
					} catch (Exception e) {
						log("STEP 6: user cannot click on save button. ", Status.FAIL);
						throw new RuntimeException("Failed in step 6");
					}
				}
				try {
					SelectYear(year(map.get(Excel.Date)));
					log("STEP 7: User can select value from  Year dd    ", Status.PASS);
				} catch (Exception e) {
					log("STEP 7: User cannot select value from  Year dd ", Status.FAIL);
					throw new RuntimeException("Failed in step 7");
				}
				
				try {
					SelectPeriod(map.get(Excel.Period));
					log("STEP 8: User can select value from  Period dd    ", Status.PASS);
				} catch (Exception e) {
					log("STEP 8: User cannot select value from  Period dd ", Status.FAIL);
					throw new RuntimeException("Failed in step 8");
				}
				
				try {
					ClickOnView();
					log("STEP 9: user can able to click on view button  ", Status.PASS);
				} catch (Exception e) {
					log("STEP 9:  user cannot able to click on view button  ", Status.FAIL);
					throw new RuntimeException("Failed in step 9");
				}
				
				By turbine = By.xpath("//*[text()='"+map.get("Turbine ID")+"']");
				assertion.assertTrue(util.isElementVisible(turbine), "Turbine ID mismatched");
				ExtentTestManager.log("Turbine ID : "+driver.findElement(turbine).getText());
				
				util.dummyWait(1);
				
				try {
					String Month =month(map.get(Excel.Date));
					By linkVDD;
					
					if(Month.contains("Jan")||Month.contains("Apr") || Month.contains("Jul") || Month.contains("Oct")) {
						
						linkVDD = By.xpath("//*[text()='"+map.get("Turbine ID")+"']/..//td[2]/.//a[text()='View Daily Data']");
						
					}else if(Month.contains("Feb")||Month.contains("May") || Month.contains("Aug") || Month.contains("Nov")) {
						
						linkVDD = By.xpath("//*[text()='"+map.get("Turbine ID")+"']/..//td[3]/.//a[text()='View Daily Data']");

					}else {
						linkVDD = By.xpath("//*[text()='"+map.get("Turbine ID")+"']/..//td[4]/.//a[text()='View Daily Data']");
					}
					
					util.waitUntilElementDisplay(linkVDD);
					util.click(linkVDD);
					
					log("STEP 10: user can click on view Daily Data link of the imported record ", Status.PASS);
				} catch (Exception e) {
					log("STEP 10:  user cannot click on view Daily Data link of the imported record", Status.FAIL);
					throw new RuntimeException("Failed in step 10");
				}
			
				util.dummyWait(1);
				util.switchToIframe(prodIframe);
				
				By date = By.xpath("//*[contains(@id,'radGridDailyValues')]/.//*[contains(text(),'"+map.get("Date")+"')]");
				assertion.assertTrue(util.isElementVisible(date), "Date mismatched");
				ExtentTestManager.log("Date : "+driver.findElement(date).getText());
				
				By production = By.xpath("//*[contains(@id,'radGridDailyValues')]/.//*[text()='"+map.get("Production")+"']");
				assertion.assertTrue(util.isElementVisible(production), "Production mismatched");
				ExtentTestManager.log("Production : "+driver.findElement(production).getText());
				
				assertion.assertAll();
				log("All Imported Data Successfully matched");
			
		}
	
	By downlodPDF = By.xpath("//a[contains(@id,'DownloadPDF')]");
	By downloadExcel = By.xpath("//a[contains(@id,'DownloadEXCEL')]");
	public void errorLogValidation(String testcaseName) throws Exception {

		try {
			objErrorLog.printErrorLog();
			//objErrorLog.productionTrackingvalidationMsg(testcaseName); 
	        log("STEP 12:  All Import validation Msg validated sucessfully", Status.PASS);
		} catch (Exception t) {
			  log("STEP 12:  Some Import Validation Msg are missing", Status.FAIL);
			  throw new RuntimeException("Failed in step 12");
		}
		
//		try {
//			  util.click(downlodPDF); 
//	        log("STEP 13:  User can click on PDF Icon", Status.PASS);
//		} catch (Exception t) {
//			  log("STEP 13:  User cannot click on PDF Icon", Status.FAIL);
//			  throw new RuntimeException("Failed in step 13");
//		}
		
		try {
			  driver.close();
			  util.switchToParentWindow(); 
			  util.dummyWait(1);
	        log("STEP 14:  User can close the popup", Status.PASS);
		} catch (Exception t) {
			  driver.close();
			  util.switchToParentWindow(); 
			  log("STEP 14:  User cannot close the popup", Status.FAIL);
			  throw new RuntimeException("Failed in step 14");
		}
	}
	
	
	

}
