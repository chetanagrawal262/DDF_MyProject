package pages.ProjectPayTemplate;

import java.util.Map;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;
import extentReports.ExtentTestManager;

public class DocumentGenerationPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;
	public static String AGREEMENT_NUMBER;

	public DocumentGenerationPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		
	}
	
	By navProject = By.xpath("//span[text()='Project']");
	By navProjectPayTemplate = By.xpath("//span[contains(text(),'Project Pay Templates')]");
	 
	//for ROW
	By navAdministration = By.xpath("//span[text()='Administration']");
	By navPaymentTemplates = By.xpath("//span[contains(text(),'Payment Templates')]");
	By navProjectPayTemplates = By.xpath("//span[contains(text(),'Project Pay Templates')]"); 
	
	By DocumentGeneration = By.xpath("(//a[@title='Expand'])[1]");
	By drpTemplate = By.xpath("//select[@id='ctl00_ConPHLeftTop_RadDock1_C_DocGen_listTemplate1']");
	By SelectReportFormat = By.xpath("//label[contains(text(),'Word 2007 & Newer')]");
	By btnGenerateDocument = By.xpath("//input[contains(@id,'_DocGen_btnSubmit') and @Type='image']");
	By btnPreviewDocument = By.xpath("//input[contains(@id,'_DocGen_btnPreview') and @Type='image']");
	
	By generateDocumentButton = By.xpath("//input[contains(@id,'DocGen_btnSubmit')]");
	By previewDocumentButton = By.xpath("//input[contains(@id,'DocGen_btnPreview')]");
	By templateSelect = By.xpath("//select[contains(@name,'listTemplate1')]");
	By adobePDFRadio = By.xpath("//input[contains(@id,'DocGen_rbPdf')]");
	By msWordRadio = By.xpath("//input[contains(@id,'DocGen_rbWord')]");
	By msExcelRadio = By.xpath("//input[contains(@id,'DocGen_rbSpread')]");
	
	 public void nevigateToProjectPayTemplate() {
	  		util.waitUntilElementDisplay(navProject);
	  		util.click(navProject);
	  		util.waitUntilElementDisplay(navProjectPayTemplate);
	  		util.click(navProjectPayTemplate);
	  	}
	  	
	  	public void nevigateToProjectPayTemplateRow() {
	  		util.waitUntilElementDisplay(navAdministration);
	  		util.click(navAdministration);
	  		util.waitUntilElementDisplay(navPaymentTemplates);
	  		util.click(navPaymentTemplates);
	  		util.waitUntilElementDisplay(navProjectPayTemplates);
	  		util.click(navProjectPayTemplates);
	  	}
	  	
	  	public void ExpandDocumentGeneration() {
	  		util.waitUntilElementDisplay(DocumentGeneration);
	  		util.click(DocumentGeneration);
	  	}
	  	
		By loaderIcon = By.xpath("//body/div[contains(@id,'Ajax')]");

	  	private void selectTemplate(String value) {
	  		if (!commonFunction.checkNA(value)) {
				util.inputTextAndPressTab(drpTemplate, value);
				util.waitFor(10000);
				util.waitUntilElementDisappear(loaderIcon);
			}
		}
	  	
	  	
	  	private void clickOnPDFRadioButton() {
			util.waitUntilElementDisappear(loaderIcon);
			util.waitForWebElementToBeClickable(adobePDFRadio, PAGE_LOAD_TIMEOUT);
			util.click(adobePDFRadio);
		}
		
		private boolean isPDFRadioSelected() {
			try {
				return util.getAttributeValue(adobePDFRadio, "checked").equals("true");
			} catch (Exception e) {
				return false;
			}
		}
		
		private void clickOnWordRadioButton() {
			util.click(msWordRadio);
		}
		
		private boolean isWordRadioSelected() {
			try {
				return util.getAttributeValue(msWordRadio, "checked").equals("true");
			} catch (Exception e) {
				return false;
			}
		}
		
		private void clickOnExcelRadioButton() {
			util.click(msExcelRadio);
		}
		
		private boolean isExcelRadioSelected() {
			try {
				return util.getAttributeValue(msExcelRadio, "checked").equals("true");
			} catch (Exception e) {
				return false;
			}
		}
		
		private void clickOnGenerateDocumentButton() {
			util.click(generateDocumentButton);
			util.waitUntilElementDisappear(loaderIcon);
		}
		
		private void clickOnPreviewDocumentButton() {
			util.click(previewDocumentButton);
			util.waitUntilElementDisappear(loaderIcon);
		}
		
		private void verifyMultipleWindow() {
			String parentWindow = driver.getWindowHandle();
			Set<String> allWindow = driver.getWindowHandles();
			if(allWindow.size()>1) {
				for(String currentWindow : allWindow) {
					if(!currentWindow.equals(parentWindow)) {
						driver.switchTo().window(currentWindow);
						driver.close();
					}
				}
				driver.switchTo().window(parentWindow);
			}
		}
	  	
	  	 public void GenerateDocument(Map<String, String> map,String testCaseName)  {
	  		 
//			 if(testCaseName.contains("ALT")|| testCaseName.contains("ORSTED") || testCaseName.contains("ORION") || testCaseName.contains("ATWELL")) {
//				 driver.navigate().refresh();
//					try {
//						nevigateToProjectPayTemplate();
//						log("STEP 1: User can navigate to project pay template page.", Status.PASS);
//					} catch (Exception e) {
//						log("STEP 1: User cannot navigate to project pay template page. ", Status.FAIL);
//						throw new RuntimeException("Failed in step 1");
//					}
//			    }
//			    	else {
//					try {
//						nevigateToProjectPayTemplateRow();
//						log("STEP 1: User can navigate to project pay template page.", Status.PASS);
//					} catch (Exception e) {
//						log("STEP 1: User cannot navigate to project pay template page. ", Status.FAIL);
//						throw new RuntimeException("Failed in step 1");
//					}
//			    }
			    		    	
		    	try {
		    		ExpandDocumentGeneration();
					log("STEP 2: user can expand document generation panel ", Status.PASS);
				} catch (Exception e) {
					log("STEP 2: user cannot expand document generation panel.    ", Status.FAIL);
					throw new RuntimeException("Failed in step 2");
				}
		    	
		    	try {
		    		selectTemplate(map.get(Excel.Template));
					log("STEP 3: User can select value from Template dd ", Status.PASS);
				} catch (Exception e) {
					log("STEP 3: User cannot select value from Template dd ", Status.PASS);
					throw new RuntimeException("Failed in step 3");
				}
		    	
		    	try {
					clickOnPDFRadioButton();
					Assert.assertTrue(isPDFRadioSelected(), "PDF Radio button is not selected");
					clickOnGenerateDocumentButton();
					util.dummyWait(5);
					util.switchToChildWindow();
					util.dummyWait(5);
					ExtentTestManager.infoWithScreenshot("Generated in PDF Format");
					driver.close();
					util.switchToParentWindow();
					log("STEP 4: select Adobe pdf report format radio buttton ", Status.PASS);
				} catch (Exception e) {
					log("STEP 4: User cannot select Adobe pdf report format radio buttton ", Status.FAIL);
					throw new RuntimeException("Failed in step 4");
				}
				
				try {
					clickOnWordRadioButton();
					Assert.assertTrue(isWordRadioSelected(), "Word Radio button is not selected");
					clickOnGenerateDocumentButton();
					verifyMultipleWindow();
					log("STEP 5: select Word 2007  & newer report format radio buttton", Status.PASS);
				} catch (Exception e) {
					log("STEP 5:User cannot select Word 2007  & newer report format radio buttton", Status.FAIL);
					throw new RuntimeException("Failed in step 5");
				}
				
				try {
					clickOnExcelRadioButton();
					Assert.assertTrue(isExcelRadioSelected(), "Word Radio button is not selected");
					clickOnGenerateDocumentButton();
					verifyMultipleWindow();
					log("STEP 6: select Excel 2007  & newer report format radio buttton", Status.PASS);
				} catch (Exception e) {
					log("STEP 6: User cannot select Excel 2007  & newer report format radio buttton", Status.FAIL);
					throw new RuntimeException("Failed in step 6");
				}
				util.dummyWait(2);
				util.reloadPage();
				util.dummyWait(5);
				
	  	 }	
	  	 
	  	 
	  	public void PreviewDocument(Map<String, String> map, String testcaseName) {

		    	try {
		    		ExpandDocumentGeneration();
					log("STEP 1: user can expand document generation panel ", Status.PASS);
				} catch (Exception e) {
					log("STEP 1: user cannot expand document generation panel.    ", Status.FAIL);
					throw new RuntimeException("Failed in step 1");
				}
		    	
		    	try {
		    		selectTemplate(map.get(Excel.Template));
					log("STEP 2: User can select value from Template dd ", Status.PASS);
				} catch (Exception e) {
					log("STEP 2: User cannot select value from Template dd ", Status.PASS);
					throw new RuntimeException("Failed in step 2");
				}
			
			try {
				clickOnPDFRadioButton();
				Assert.assertTrue(isPDFRadioSelected(), "PDF Radio button is not selected");
				clickOnPreviewDocumentButton();
				util.dummyWait(5);
				util.switchToChildWindow();
				util.dummyWait(5);
				ExtentTestManager.infoWithScreenshot("Generated in PDF Format");
				driver.close();
				util.switchToParentWindow();
				log("STEP 3: select Adobe pdf report format radio buttton ", Status.PASS);
			} catch (Exception e) {
				log("STEP 3: User cannot select Adobe pdf report format radio buttton ", Status.FAIL);
				throw new RuntimeException("Failed in step 3");
			}
			
			try {
				clickOnWordRadioButton();
				Assert.assertTrue(isWordRadioSelected(), "Word Radio button is not selected");
				clickOnPreviewDocumentButton();
				verifyMultipleWindow();
				log("STEP 4: select Word 2007  & newer report format radio buttton", Status.PASS);
			} catch (Exception e) {
				log("STEP 4: User cannot select Word 2007  & newer report format radio buttton", Status.FAIL);
				throw new RuntimeException("Failed in step 4");
			}
			
			try {
				clickOnExcelRadioButton();
				Assert.assertTrue(isExcelRadioSelected(), "Word Radio button is not selected");
				clickOnPreviewDocumentButton();
				verifyMultipleWindow();
				log("STEP 5: select Excel 2007  & newer report format radio buttton", Status.PASS);
			} catch (Exception e) {
				log("STEP 5: User cannot select Excel 2007  & newer report format radio buttton", Status.FAIL);
				throw new RuntimeException("Failed in step 5");
			}
			
		}

	  	 
}
