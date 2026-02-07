package pages.agreementManager;

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

public class DocumentGenerationPage extends BasePage {
	
	TestUtil util;
	CommonFunction commonFunction;
	AddNewInformationPage objAddInfo;
	public DocumentGenerationPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		objAddInfo = new AddNewInformationPage(driver);
	}
	
	By loaderIcon = By.xpath("//body/div[contains(@id,'Ajax')]");
	
	By generateDocumentTab = By.xpath("//div[contains(@id,'ConPHLeftTop_RadDockZone2') or contains(@id,'_CrossList_RDProjectDocGen_T')]//*[text()='Document Generation']/..//a[@title='Expand']");
	public void navigateToDocumentGenerationTab() {
		if(!util.isElementVisible(generateDocumentButton)) {
			util.click(generateDocumentTab);
		}
	}
	
	By generateDocumentButton = By.xpath("//input[contains(@id,'DocGen_btnSubmit')]");
	By previewDocumentButton = By.xpath("//input[contains(@id,'DocGen_btnPreview')]");
	By templateSelect = By.xpath("//select[contains(@name,'listTemplate')]");
	By adobePDFRadio = By.xpath("//input[contains(@id,'DocGen_rbPdf')]");
	By msWordRadio = By.xpath("//input[contains(@id,'DocGen_rbWord')]");
	By msExcelRadio = By.xpath("//input[contains(@id,'DocGen_rbSpread')]");
	
	
	private void selectTemplate(String value) {
		if (!commonFunction.checkNA(value)) {
			util.selectValueFromDropdown2(value, templateSelect);
			util.waitFor(5000);
		}
	}
	
	private void clickOnPDFRadioButton() {
		util.waitUntilElementDisappear(loaderIcon);
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

	By agreementNo = By.xpath("//td[text()='AG01']/parent::tr");
	
	public void verifyGenerateDocument(Map<String, String> map, String testcaseName) {
		try {
			if(testcaseName.contains("ROW") || testcaseName.contains("TRA")) {
				objAddInfo.navigateToAgreementInformationROW();
			} else {
				objAddInfo.navigateToAgreementInformationALT();
			}
			commonFunction.projectSelection();
			util.dummyWait(1);
			util.click(agreementNo);
			util.dummyWait(1);
			log("STEP 1: User can Navigate to Menu - Project>Agreement Manager>Agreement Information>Document Generation Panel", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: User cannot Navigate to Menu - Project>Agreement Manager>Agreement Information>Document Generation Panel", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}
		
		try {
			navigateToDocumentGenerationTab();
			log("STEP 2: Expand document generation panel", Status.PASS);
		} catch (Exception e) {
			log("STEP 2: User cannot Expand document generation panel", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}
		
		try {
			if(environment.contains("WOLFMIDSTREAM")) {
				selectTemplate("Ground Disturbance");
			}else {
			selectTemplate(map.get(Excel.Template));
			}
			log("STEP 3: User can select template from the dd", Status.PASS);
		} catch (Exception e) {
			log("STEP 3: User cannot select template from the dd", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}
		
		try {
			clickOnPDFRadioButton();
			clickOnGenerateDocumentButton();
			Assert.assertTrue(isPDFRadioSelected(), "PDF Radio button is not selected");
			util.switchToChildWindow();
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
			clickOnGenerateDocumentButton();
			Assert.assertTrue(isWordRadioSelected(), "Word Radio button is not selected");
			verifyMultipleWindow();
			log("STEP 5: select Word 2007  & newer report format radio buttton", Status.PASS);
		} catch (Exception e) {
			log("STEP 5: User cannot select Word 2007  & newer report format radio buttton", Status.FAIL);
			throw new RuntimeException("Failed in step 5");
		}
		
		try {
			clickOnExcelRadioButton();
			clickOnGenerateDocumentButton();
			Assert.assertTrue(isExcelRadioSelected(), "Word Radio button is not selected");
			verifyMultipleWindow();
			log("STEP 6: select Excel 2007  & newer report format radio buttton", Status.PASS);
		} catch (Exception e) {
			log("STEP 6: User cannot select Excel 2007  & newer report format radio buttton", Status.FAIL);
			throw new RuntimeException("Failed in step 6");
		}
		}
	
	public void verifyPreviewDocument(Map<String, String> map, String testcaseName) {
		
		try {
			navigateToDocumentGenerationTab();
			log("STEP 1: Expand document generation panel", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: User cannot Expand document generation panel", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}
		
		try {
			if(environment.contains("WOLFMIDSTREAM")) {
				selectTemplate("Ground Disturbance");
			}else {
			selectTemplate(map.get(Excel.Template));
			}
			log("STEP 2: User can select  template from the dd", Status.PASS);
		} catch (Exception e) {
			log("STEP 2: User cannot select template from the dd", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}
		
		try {
			clickOnPDFRadioButton();
			clickOnPreviewDocumentButton();
			util.switchToChildWindow();
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
