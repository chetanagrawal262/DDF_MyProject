package pages.agreementManager;

import java.util.List;
import java.util.Map;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;
import extentReports.ExtentTestManager;

public class OwnershipAndAcresPrecisionPage extends BasePage {

	TestUtil util;
	CommonFunction commonFunction;
	public static int AcresPrecision, OwnershipPrecision ;
    public static String randomNumber;
	public static String SurfaceValue, CropValue, WindValue, OwnershipPer, AcresValue;

	public OwnershipAndAcresPrecisionPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	
		By navAdministration = By.xpath("//span[text()='Administration']");
		By navABS = By.xpath("//span[contains(text(),'Application Behavior Settings')]");
		By txtFilterKeyName = By.xpath("//input[@alt='Filter key_name column']");
		By btnFilterKeyName = By.xpath("//input[contains(@id,'Filter_key_name') and @type='button']");
		By optionFilter = By.xpath("//span[text()='Contains']");
		By acresPrecisionOrion = By.xpath("//td[text()='AcresPrecision']/..//td[3]/input[@value='3' and @type='text']");
		By txtAcresPrecisionOOTB = By.xpath("//td[text()='AcresPrecision']/..//td[3]/input[@type='text']");
		By txtOwnershipPrecisionOOTB = By.xpath("//td[text()='OwnershipPrecision']/..//td[3]/input[@type='text']");
		By ownershipPrecisionOOA = By.xpath("//td[text()='OwnershipPrecision']/..//td[3]/input[@value='6' and @type='text']");//orsted, akuoenergy, baywa
		By ownershipPrecisionOrion = By.xpath("//td[text()='OwnershipPrecision']/..//td[3]/input[@value='8' and @type='text']");
		By btnSubmitAll = By.xpath("//input[@title='Submit All']");
		
		public void NavigateToApplicationBehaviorSettings() {
	    	util.waitUntilElementDisplay(navAdministration);
	    	util.click(navAdministration);
	    	util.waitUntilElementDisplay(navABS);
	    	util.click(navABS);
	    }
		
		 public void enterKeyName(String value) {
				util.waitUntilElementDisplay(txtFilterKeyName);
				util.inputTextAndPressTab(txtFilterKeyName, value);
			}
		
		 public void selectFilter() {
				util.waitUntilElementDisplay(btnFilterKeyName);
				util.click(btnFilterKeyName);
				if(!util.isElementVisible(optionFilter)) {
					util.click(btnFilterKeyName);
				}
				util.click(optionFilter);
			}
		
		 public void setKeyValue(String key, String value) {
		    	By keyValue = By.xpath("//*[text()='"+key+"']/..//input[contains(@name,'txtValue')]");
		    	util.dummyWait(1);
				//util.waitUntilElementDisplay(keyValue);
				util.inputTextAndPressTab(keyValue, value);
			}
		 
		  public void clickOnSubmitAll() {
				util.waitUntilElementDisplay(btnSubmitAll);
				util.click(btnSubmitAll);;
			}
		  
		  By btnDocuments = By.xpath("//div[@id='idManageApproval_tabStrip']//span[contains(text(),'Documents')]");
		  public void ClickonDocumentsTab()
			{
				util.waitUntilElementDisplay(btnDocuments);
				util.click(btnDocuments);	    	
				    
			}
		public void checkPrecisionValue(Map<String, String> map, String testcaseName)
				throws InterruptedException {
			try {
	 		    NavigateToApplicationBehaviorSettings();
	  			log("STEP 1: User can navigate to Application Behavior Settings ", Status.PASS);
	  		} catch (Exception e) {
	  			log("STEP 1: User cannot navigate to Application Behavior Settings ", Status.FAIL);
	  			throw new RuntimeException("Failed in step 1");
	  		}
			 
//			 try {
//	 		    enterKeyName(map.get("ABSAcres"));
//	  			log("STEP 2: User can enter key name "+map.get("ABSAcres"), Status.PASS);
//	  		} catch (Exception e) {
//	  			log("STEP 2: User cannot enter key name "+map.get("ABSAcres"), Status.FAIL);
//	  			throw new RuntimeException("Failed in step 2");
//	  		} 
//			 
//			 try {
//	 		    selectFilter();
//	 		   util.waitFor(500);
//	  			log("STEP 3: User can click on Filter Icon", Status.PASS);
//	  		} catch (Exception e) {
//	  			log("STEP 3: User cannot click on Filter Icon", Status.FAIL);
//	  			throw new RuntimeException("Failed in step 3");
//	  		} 
			
			 if(environment.contains("ORION")) {
				 try {
					 String  precision = util.getAttributeValue(txtAcresPrecisionOOTB, "value");
				 		AcresPrecision =Integer.parseInt(precision);
			 		    Assert.assertTrue(util.isElementVisible(acresPrecisionOrion));
			  			log("STEP 2: Acres Precision Value is '3' for orion", Status.PASS);
			  		} catch (AssertionError e) {
			  			log("STEP 2: Acres Precision Value is not '3' for orion", Status.FAIL);
			  		} 
			 }else {
				 try {
			 		String  precision = util.getAttributeValue(txtAcresPrecisionOOTB, "value");
			 		AcresPrecision =Integer.parseInt(precision);
			  			log("STEP 2: User can get Acres Precision Value", Status.PASS);
			  		} catch (Exception e) {
			  			log("STEP 2: User cannot get Acres Precision Value", Status.FAIL);
			  			throw new RuntimeException("Failed in step 2");
			  		} 
			 }
			 ExtentTestManager.infoWithScreenshot("AcresPrecisionValue");
//			 try {
//		 		    enterKeyName(map.get("ABSOwnership"));
//		  			log("STEP 5: User can enter key name "+map.get("ABSOwnership"), Status.PASS);
//		  		} catch (Exception e) {
//		  			log("STEP 5: User cannot enter key name "+map.get("ABSOwnership"), Status.FAIL);
//		  			throw new RuntimeException("Failed in step 5");
//		  		} 
//				
//				 try {
//		 		    selectFilter();
//		 		   util.waitFor(500);
//		  			log("STEP 6: User can click on Filter Icon", Status.PASS);
//		  		} catch (Exception e) {
//		  			log("STEP 6: User cannot click on Filter Icon", Status.FAIL);
//		  			throw new RuntimeException("Failed in step 6");
//		  		} 
				 
				 if(environment.contains("AKUOENERGY")) {
					 try {
						 String  Oprecision = util.getAttributeValue(txtOwnershipPrecisionOOTB, "value");
					 		OwnershipPrecision =Integer.parseInt(Oprecision);
				 		    Assert.assertTrue(util.isElementVisible(ownershipPrecisionOOA));
				  			log("STEP 3: Ownership Precision Value is '6' ", Status.PASS);
				  		} catch (AssertionError e) {
				  			log("STEP 3: Ownership Precision Value is not '6'", Status.FAIL);
				  		} 
				 }else if( environment.contains("ORION") || environment.contains("ORSTED")  || environment.contains("BAYWA")) {
					 try {
						 String  Oprecision = util.getAttributeValue(txtOwnershipPrecisionOOTB, "value");
					 		OwnershipPrecision =Integer.parseInt(Oprecision);
				 		    Assert.assertTrue(util.isElementVisible(ownershipPrecisionOrion));
				  			log("STEP 3: Ownership Precision Value is '8' ", Status.PASS);
				  		} catch (AssertionError e) {
				  			log("STEP 3: Ownership Precision Value is not '8'", Status.FAIL);
				  		}
				 }else {
					 try {
					 		String  Oprecision = util.getAttributeValue(txtOwnershipPrecisionOOTB, "value");
					 		OwnershipPrecision =Integer.parseInt(Oprecision);
					  			log("STEP 3: User can get Acres Precision Value", Status.PASS);
					  		} catch (Exception e) {
					  			log("STEP 3: User cannot get Acres Precision Value", Status.FAIL);
					  			throw new RuntimeException("Failed in step 3");
					  		} 
				 }
		}
		
		
		
		By existingContactClose = By.xpath("//a[contains(@id,'LESSOR_Arrow')]");
		By existingContact = By.xpath("//Input[contains(@id,'LESSOR_Input')]");
		By addPayeeButton = By.xpath("//input[contains(@id,'btnAddLessor')]");
		By successMessage = By.xpath("//span[contains(@id,'usrLesseeMessage')]");
		By parcelTractInformationTab = By.xpath("//div[contains(@id,'RadTabStripLO')]//span[text()='Parcel Information' or text()='Tract Information' or text()='Record Information']");
		By availableTract = By.xpath("//div[contains(@id,'TRACTSPanel')]//*[contains(@id,'TRACTS_Arrow')]");
		By addAvailableTract = By.xpath("//input[contains(@id,'_ImageButton2')]");
		By successMessageAvailableTract = By.xpath("//span[contains(@id,'usrTractMessage')]");
		
		
		private void selectExistingContact(String value) {
			if (!commonFunction.checkNA(value)) {
				util.dummyWait(10);
				util.selectValueFromDropdownLandowner(existingContact, value);
				util.click(existingContactClose); // need to click on dropdown icon
			}
		}
		
		private void clickOnAddButton() {
			util.click(addPayeeButton);
		}
		
		private void verifySuccessPayeeMessage(String env) {
			util.waitForWebElementToBePresent(successMessage, 20);
			String message = util.getText(successMessage);
			if(env.contains("ATWELL") ||env.contains("ORION")  ) {
				Assert.assertEquals(message, "Landowner has been added to Lease", "Landowner success message mismatched");
			}else {
				Assert.assertEquals(message, "Landowner has been added to Agreement", "Landowner success message mismatched");
			}
		}
		
		private void clickOnParcelOrTractInfoTab(){
			util.click(parcelTractInformationTab);
		}
		
		private void selectAvailableTract(String value){
			util.selectValueFromDropdownCheckboxContains(availableTract, value);
			util.waitFor(1000);
			util.click(availableTract);
		}
		
		private void clickOnAddButtonAvailableTract(){
			util.click(addAvailableTract);
		}
		
		private void verifySuccessMessageAvailableTract(){
			util.waitUntilLoaderDisappear();
			util.waitForWebElementToBePresent(successMessageAvailableTract, IMPLICIT_WAIT);
			Assert.assertTrue(util.getText(successMessageAvailableTract).toLowerCase().contains("added to"),
					"Available tract is not added successfully.");
		}
		
		By landownerInformationTab = By.xpath("//div[contains(@id,'RadTabStripLO')]//span[text()='Landowner Information']");
		private void clickOnLandOwnerInfoTab(){
			util.click(landownerInformationTab);
			util.dummyWait(2);
		}
		
		By editOwnershipButton = By.xpath("//img[@alt='Edit Ownership'] | //input[contains(@id,'btnEditPayStatus')]");
		private void clickOnEditOwnershipButton() {
			util.click(editOwnershipButton);
		}
		
		By editLandOwnerIframe = By.xpath("//iframe[@name = 'LOOwnership']");
		private void switchToEditLandOwnerIframe() {
			util.waitForWebElementToBePresent(editLandOwnerIframe, IMPLICIT_WAIT);
			util.switchToIframe(editLandOwnerIframe);
		}
		
		By surfacePercentage = By.xpath("//input[contains(@id,'Surface_Ownership_All_Tracts') and @type='text']");
		private void addAllSurfacePercentage(String value) {
			List<WebElement> allEle = util.getWebElements(surfacePercentage);
			for(WebElement wb : allEle) {
				wb.click();
				wb.sendKeys(value);
			}
		}
		
		By windPercentage = By.xpath("//input[contains(@id,'Wind_Ownership_All_Tracts') and @type='text']");
		private void addAllWindPercentage(String value) {
			List<WebElement> allEle = util.getWebElements(windPercentage);
			for(WebElement wb : allEle) {
				wb.click();
				wb.sendKeys(value);
			}
		}
		
		By cropPercentage = By.xpath("//input[contains(@id,'Crop_Ownership_All_Tracts') and @type='text']");
		private void addAllCropPercentage(String value) {
			List<WebElement> allEle = util.getWebElements(cropPercentage);
			for(WebElement wb : allEle) {
				wb.click();
				wb.sendKeys(value);
			}
		}
		
		By ownershipPercentage = By.xpath("//input[contains(@id,'Ownership_Share_All_Tracts') and @type='text']");
		private void addAllOwnershipPercentage(String value) {
			List<WebElement> allEle = util.getWebElements(ownershipPercentage);
			for(WebElement wb : allEle) {
				wb.click();
				wb.sendKeys(value);
			}
		}
		
		
		
		public void addSurfaceWindCropInEditOwner() {
			generateRandomDecimalValue(OwnershipPrecision);
			SurfaceValue= randomNumber;
			addAllSurfacePercentage(SurfaceValue);
			
			generateRandomDecimalValue(OwnershipPrecision);
			WindValue= randomNumber;
			addAllWindPercentage(WindValue);
			
			generateRandomDecimalValue(OwnershipPrecision);
			CropValue= randomNumber;
			addAllCropPercentage(CropValue);
			
			generateRandomDecimalValue(OwnershipPrecision);
			OwnershipPer = randomNumber;
			addAllOwnershipPercentage(OwnershipPer);
		}
		
		By saveButtonAllocationLandownerTab = By.xpath("//table[contains(@id,'OwnershipByEntity')]//input[contains(@id,'btnUpdateAll')]");
		private void clickOnSaveButtonAllocationLandOwnerTab() {
			util.click(saveButtonAllocationLandownerTab);
		}
		
		By allocationByParcelTab = By.xpath("//span[text()='Allocation By Parcel']");
		private void clickOnAllocationByParcelTab() {
			util.click(allocationByParcelTab);
		}
		
		By paidAcres = By.xpath("//input[contains(@id,'_txtAcreage') and @type='text']");
		private void EnterPaidAcres(String Value) {
			util.waitUntilElementDisplay(paidAcres);
			util.inputTextAndPressTab(paidAcres, Value);
		}
		
		By saveButtonParcelTab = By.xpath("//table[contains(@id,'ProjectDetails')]//input[contains(@id,'btnUpdateAll')]");
		private void clickOnSaveButtonParcelTab() {
			util.click(saveButtonParcelTab);
		}
		
		By closeLandOwnershipForm = By.xpath("//div[contains(@id,'LOOwnership')]//a[@title='Close']");
		private void closeLandOwnershipIframe() {
			util.switchToDefaultContent();
			util.click(closeLandOwnershipForm);
			util.waitFor(1000);
		}
		
		public void generateRandomDecimalValue(int DecimalDigits) {
			Random random = new Random();
//			Double randomNumber1 = random.nextDouble();
//            double scale= Math.pow(10, DecimalDigits);
//            randomNumber = Math.floor(randomNumber1*scale)/scale;
			StringBuilder fractionalPart = new StringBuilder();
	        for (int i = 0; i < DecimalDigits; i++) {
	            fractionalPart.append(random.nextInt(9) + 1); // Ensures digits between 1 and 9
	        }
	        randomNumber = "0"+"."+fractionalPart;
		}
		
		public void generateRandomDecimalAcresValue(int DecimalDigits) {
			Random random = new Random();
//			Double randomNumber1 = random.nextDouble();
//            double scale= Math.pow(10, DecimalDigits);
//            randomAcres = 50+ Math.floor(randomNumber1*scale)/scale;
			StringBuilder fractionalPart = new StringBuilder();
	        for (int i = 0; i < DecimalDigits; i++) {
	            fractionalPart.append(random.nextInt(9) + 1); // Ensures digits between 1 and 9
	        }
	        AcresValue = "50"+"."+fractionalPart;
		}
		
		public void addPayeeInformation(Map<String, String> map, String testCaseName) {
			// Landowner Information tab
				try {
					selectExistingContact(map.get(Excel.LandownerName));
					log("STEP 1: Fill in Landowner DD", Status.PASS);
				} catch (Exception e) {
					log("STEP 1: User cannot select Existing Landowner", Status.FAIL);
					throw new RuntimeException("Failed in step 1");
				}
			
			try {
				clickOnAddButton();
				verifySuccessPayeeMessage(testCaseName);
				log("STEP 2: Click on Add", Status.PASS);
			} catch (Exception e) {
				log("STEP 2: User cannot click on Add", Status.FAIL);
				throw new RuntimeException("Failed in step 2");
			}
			
			// Parcel Information tab
			try {
				clickOnParcelOrTractInfoTab();
					selectAvailableTract(map.get(Excel.AvailableTract));
				log("STEP 3: Fill in Available Parcel(s) DD", Status.PASS);
			} catch (Exception e) {
				log("STEP 3: User cannot select Available Parcel(s) from the DD", Status.FAIL);
				throw new RuntimeException("Failed in step 3");
			}
			
			try {
				clickOnAddButtonAvailableTract();
				verifySuccessMessageAvailableTract();
				log("STEP 4: click on Add button", Status.PASS);
			} catch (Exception e) {
				log("STEP 4: User cannot click on Add button", Status.FAIL);
				throw new RuntimeException("Failed in step 4");
			}
		
			driver.navigate().refresh();
			clickOnLandOwnerInfoTab();
			
			if(util.isElementVisible(editOwnershipButton)) {
				try {
					clickOnEditOwnershipButton();
					switchToEditLandOwnerIframe();
					log("STEP 5: click on Edit Ownership button", Status.PASS);
				} catch (Exception e) {
					log("STEP 5: User cannot click on Edit Ownership button", Status.FAIL);
					throw new RuntimeException("Failed in step 5");
				}
				
				try {
					addSurfaceWindCropInEditOwner();
					log("STEP 6: Fill the value in 'Surface % , Wind % , Crop%' field for 'Allocation by Landowner", Status.PASS);
				} catch (Exception e) {
					log("STEP 6: User cannot fill the value in 'Surface % , Wind % , Crop%' field for 'Allocation by Landowner Tab" , Status.FAIL);
					throw new RuntimeException("Failed in step 6");
				}
				
				try {
					util.dummyWait(1);
					clickOnSaveButtonAllocationLandOwnerTab();
					util.dummyWait(1);
					ExtentTestManager.infoWithScreenshot("Edited Ownership");
					log("STEP 7: click on Save button", Status.PASS);
				} catch (Exception e) {
					log("STEP 7: User cannot click on Save button", Status.FAIL);
					throw new RuntimeException("Failed in step 7");
				}
				
					try {
						clickOnAllocationByParcelTab();
						log("STEP 8: User can click on Allocation By Parcel Tab", Status.PASS);
					} catch (Exception e) {
						log("STEP 8: User cannot click on Allocation By Parcel Tab", Status.FAIL);
						throw new RuntimeException("Failed in step 8");
					}
					
					try {
						generateRandomDecimalAcresValue(AcresPrecision);
						EnterPaidAcres(AcresValue);
						log("STEP 9: User can enter paid acres", Status.PASS);
					} catch (Exception e) {
						log("STEP 9: User cannot enter paid acres", Status.FAIL);
						throw new RuntimeException("Failed in step 8");
					}
					
					try {
						clickOnSaveButtonParcelTab();
						ExtentTestManager.infoWithScreenshot("Edited parcel Acres");
						log("STEP 10: click on Save button", Status.PASS);
					} catch (Exception e) {
						log("STEP 10: User cannot click on Save button", Status.FAIL);
						throw new RuntimeException("Failed in step 10");
					}
				closeLandOwnershipIframe();
				
				try {
					By surfaceOwn = By.xpath("//*[text()='"+map.get(Excel.LandownerName)+"']/../..//td[text()='"+SurfaceValue+"']");
					Assert.assertTrue(util.isElementVisible(surfaceOwn));
					log("STEP 11: User can see correct value for Surface Ownership as per ownership precision ", Status.PASS);
				} catch (AssertionError e) {
					log("STEP 11: User cannot see correct value for Surface Ownership as per ownership precision", Status.FAIL);
				}
				
				if(!environment.contains("ORION")) {
				try {
					By CropOwn = By.xpath("//*[text()='"+map.get(Excel.LandownerName)+"']/../..//td[text()='"+CropValue+"']");
					Assert.assertTrue(util.isElementVisible(CropOwn));
					log("STEP 12: User can see correct value for Crop Ownership as per ownership precision ", Status.PASS);
				} catch (AssertionError e) {
					log("STEP 12: User cannot see correct value for Crop Ownership as per ownership precision", Status.FAIL);
				}
				
				try {
					By WindOwn = By.xpath("//*[text()='"+map.get(Excel.LandownerName)+"']/../..//td[text()='"+WindValue+"']");
					Assert.assertTrue(util.isElementVisible(WindOwn));
					log("STEP 13: User can see correct value for Wind Ownership as per ownership precision ", Status.PASS);
				} catch (AssertionError e) {
					log("STEP 13: User cannot see correct value for Wind Ownership as per ownership precision", Status.FAIL);
				}
				
				if(!environment.contains("ORSTED")) {
				try {
					By OwnerPer = By.xpath("//*[text()='"+map.get(Excel.LandownerName)+"']/../..//td[text()='"+OwnershipPer+"']");
					Assert.assertTrue(util.isElementVisible(OwnerPer));
					log("STEP 13: User can see correct value for Ownership Percentage as per ownership precision ", Status.PASS);
				} catch (AssertionError e) {
					log("STEP 13: User cannot see correct value for Ownershi Percentagep as per ownership precision", Status.FAIL);
				}
				}
				}
				
				if(environment.contains("ORSTED")) {
				try {
					By updatedBy = By.xpath("//*[text()='"+map.get(Excel.LandownerName)+"']/../..//td[text()='"+map.get("UpdatedBy")+"']");
					Assert.assertTrue(util.isElementVisible(updatedBy));
					log("STEP 14: User can see correct Updated By value in the grid view ", Status.PASS);
				} catch (AssertionError e) {
					log("STEP 14: User cannot see correct Updated By value in the grid view", Status.FAIL);
				}
				
				try {
					String currentDate = util.getCurrentDateTime("M/d/yyyy");
					By lastUpdated = By.xpath("//*[text()='"+map.get(Excel.LandownerName)+"']/../..//td[contains(text(),'"+currentDate+"')]");
					Assert.assertTrue(util.isElementVisible(lastUpdated));
					log("STEP 15: User can see correct Last Update Date in the grid view ", Status.PASS);
				} catch (AssertionError e) {
					log("STEP 15: User cannot see correct Last Update Date in the grid view", Status.FAIL);
				}
				}
				
				util.scrollDownToPage();
				ExtentTestManager.infoWithScreenshot("Landowner Information Grid");
				try {
					clickOnParcelOrTractInfoTab();
					log("STEP 16: User can click on Tract/ Parcel Information Tab", Status.PASS);
				} catch (Exception e) {
					log("STEP 16: User cannot click on Tract/ Parcel Information Tab", Status.FAIL);
					throw new RuntimeException("Failed in step 14");
				}

				try {
					By acres = By.xpath("//td[text()='"+AcresValue+"']");
					Assert.assertTrue(util.isElementVisible(acres));
					log("STEP 17: User can see correct value for Acres as per Acres precision ", Status.PASS);
				} catch (AssertionError e) {
					log("STEP 17: User cannot see correct value for Acres as per Acres precision", Status.FAIL);
				}
				
				}
		}
}
