package pages.EncroachmentRequests;

import java.util.Map;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;
import extentReports.ExtentTestManager;

public class EncroachmentDocumentGenerationPage extends BasePage {
	
	TestUtil util;
	CommonFunction commonFunction;
	JavascriptExecutor js ;
	String documentVersion="";
	int initialDocVersion, FinalDocVersion;
	
	public EncroachmentDocumentGenerationPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		js = (JavascriptExecutor) driver;
	}
	
		
	By navAdministration = By.xpath("//span[text()='Administration']");
	By navEncroachmentRequests = By.xpath("//span[contains(text(),'Encroachment Requests')]");
	By expandDocumentGeneration = By.xpath("//*[text()='Document Generation']/..//span[@class='rdExpand']");
	By drpTemplate  = By.xpath("//select[contains(@id,'_listTemplate1')]");
	By loaderIcon = By.xpath("//body/div[contains(@id,'Ajax')]");
	By generateDocumentButton = By.xpath("//input[contains(@id,'DocGen_btnSubmit')]");
	By previewDocumentButton = By.xpath("//input[contains(@id,'DocGen_btnPreview')]");
	By adobePDFRadio = By.xpath("//input[contains(@id,'DocGen_rbPdf')]");
	By msWordRadio = By.xpath("//input[contains(@id,'DocGen_rbWord')]");
	By msExcelRadio = By.xpath("//input[contains(@id,'DocGen_rbSpread')]");
	

	public void NavigateToEncroachmentRequests() {
    	util.waitUntilElementDisplay(navAdministration);
    	util.click(navAdministration);
    	util.waitFor(200);
    	util.waitUntilElementDisplay(navEncroachmentRequests);
    	util.hoverOnElement(navEncroachmentRequests);
    	util.click(navEncroachmentRequests);
    	util.waitUntilPageLoad();
    }
	 
	
	 public void ExpandsDocumentGenerationPanel() {
	  		util.waitUntilElementDisplay(expandDocumentGeneration);
	  		util.click(expandDocumentGeneration);
	  		
	    }
	
	 By drpRegion = By.xpath("(//div[contains(@id,'_DDT_RegionDistrict_RadDropDownTree1')])[1]");
	    By filterRegion = By.xpath("(//input[contains(@value,'Filtering...')])[1]");
	     public void selectRegion(String value) {
	    	 util.click(drpRegion);
	 	    	if (!commonFunction.checkNA(value))
	 				util.inputText(filterRegion, value);
	 	    	By selectValue = By.xpath("(//em[text()='"+value+"'])[1]");
	 	    	util.click(selectValue);
	 	    	util.waitUntilPageLoad();
	     }
	     
	     public void selectTemplate(String value) {
	 		if (!commonFunction.checkNA(value)) {

	 WebElement dropdown = driver.findElement(drpTemplate);
	         Select select = new Select(dropdown);

	         // Select by visible text
	         select.selectByVisibleText(value);

	 			util.waitFor(10000);
	 			util.waitUntilElementDisappear(loaderIcon);
	 		}
	 	}
	
	private void clickOnPDFRadioButton() {
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
	
	
	    
	public void GenerateDocument(Map<String, String> map, String testcaseName) {
		try {
			NavigateToEncroachmentRequests();
			selectRegion(map.get("Region"));
			log("STEP 1: User can navigate to Encroachment Requests", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: User cannot navigate to Encroachment Requests", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}
		
		try {
			ExpandsDocumentGenerationPanel();
			log("STEP 2: User can Expand document generation panel", Status.PASS);
		} catch (Exception e) {
			log("STEP 2: User cannot Expand document generation panel", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}
		
		try {
			selectTemplate(map.get(Excel.Template));
			log("STEP 3: User can select template from the dd", Status.PASS);
		} catch (Exception e) {
			log("STEP 3: User cannot select template from the dd", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}

		try {
			clickOnPDFRadioButton();
			clickOnGenerateDocumentButton();
			Assert.assertTrue(isPDFRadioSelected(), "PDF Radio button is not selected");
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
			log("STEP 5: User cannot select Word 2007  & newer report format radio buttton", Status.FAIL);
			throw new RuntimeException("Failed in step 5");
		}
		
		try {
			clickOnExcelRadioButton();
			Assert.assertTrue(isExcelRadioSelected(), "Excel Radio button is not selected");
			clickOnGenerateDocumentButton();
			verifyMultipleWindow();
			log("STEP 6: select Excel 2007  & newer report format radio buttton", Status.PASS);
		} catch (Exception e) {
			log("STEP 6: User cannot select Excel 2007  & newer report format radio buttton", Status.FAIL);
			throw new RuntimeException("Failed in step 6");
		}
		
		util.reloadPage();
	}
	
	public void PreviewDocument(Map<String, String> map, String testcaseName) {

		try {
			ExpandsDocumentGenerationPanel();
			log("STEP 1: User can Expand document generation panel", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: User cannot Expand document generation panel", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}

		try {
			selectTemplate(map.get(Excel.Template));
			log("STEP 2: User can select Template from the DD", Status.PASS);
		} catch (Exception e) {
			log("STEP 2: User cannot select Template from the DD", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}
		
		try {
			clickOnPDFRadioButton();
			clickOnPreviewDocumentButton();
			util.dummyWait(5);
			util.switchToChildWindow();
			util.dummyWait(5);
			ExtentTestManager.infoWithScreenshot("Previewed in PDF Format");
			driver.close();
			util.switchToParentWindow();
			log("STEP 3: select Adobe pdf report format radio buttton ", Status.PASS);
		} catch (Exception e) {
			log("STEP 3: User cannot select Adobe pdf report format radio buttton ", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}
		
		try {
			clickOnWordRadioButton();
			clickOnPreviewDocumentButton();
			verifyMultipleWindow();
			log("STEP 4: select Word 2007  & newer report format radio buttton", Status.PASS);
		} catch (Exception e) {
			log("STEP 4: User cannot select Word 2007  & newer report format radio buttton", Status.FAIL);
			throw new RuntimeException("Failed in step 4");
		}
		
		try {
			clickOnExcelRadioButton();
			clickOnPreviewDocumentButton();
			verifyMultipleWindow();
			log("STEP 5: select Excel 2007  & newer report format radio buttton", Status.PASS);
		} catch (Exception e) {
			log("STEP 5: User cannot select Excel 2007  & newer report format radio buttton", Status.FAIL);
			throw new RuntimeException("Failed in step 5");
		}
		
	}
}
