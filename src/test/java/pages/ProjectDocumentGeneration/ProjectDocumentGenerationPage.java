package pages.ProjectDocumentGeneration;

import java.util.List;
import java.util.Map;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
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

public class ProjectDocumentGenerationPage extends BasePage {
	
	TestUtil util;
	CommonFunction commonFunction;
	JavascriptExecutor js ;
	String documentVersion="";
	int initialDocVersion, FinalDocVersion;
	
	public ProjectDocumentGenerationPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		js = (JavascriptExecutor) driver;
	}
	
	By loaderIcon = By.xpath("//body/div[contains(@id,'Ajax')]");	
	By navProject = By.xpath("//span[text()='Project']");
	By navProjectInfo = By.xpath("//span[contains(text(),'Project Information')]");
	By navDocumentManagement = By.xpath("(//span[text()='Document Management'])[1] | (//span[text()='Project Documents'])[1]");
	By expandDocument = By.xpath("//*[text()='Document Generation']/..//span[@class='rdExpand']");
	By drpTemplate  = By.xpath("//select[contains(@id,'_listTemplate1')]");
	By selectTemplate = By.xpath("//option[text()='Parcel Summary']");
	By drpTemplateDot  = By.xpath("//span[@class='rddtFakeInput rddtEmptyMessage']");
	By selectTemplateDot = By.xpath("(//span[text()='Test Template'])[1]");
	By generateDocumentButton = By.xpath("//input[contains(@id,'DocGen_btnSubmit')]");
	By previewDocumentButton = By.xpath("//input[contains(@id,'DocGen_btnPreview')]");
	By templateSelect = By.xpath("//select[contains(@name,'listTemplate1')]");
	By adobePDFRadio = By.xpath("//input[contains(@id,'DocGen_rbPdf')]");
	By msWordRadio = By.xpath("//input[contains(@id,'DocGen_rbWord')]");
	By msExcelRadio = By.xpath("//input[contains(@id,'DocGen_rbSpread')]");
	

	 public void nevigateToDocumentManagement() {
            util.waitUntilElementDisplay(navProject);
	  		util.click(navProject);
	  		util.waitUntilElementDisplay(navProjectInfo);
	  		util.click(navProjectInfo);
	  		util.waitUntilElementDisplay(navDocumentManagement);
	  		util.click(navDocumentManagement);
	  		
	    }
	 
	
	 public void ExpandsDocuments() {
	  		util.waitUntilElementDisplay(expandDocument);
	  		util.click(expandDocument);
	  		
	    }
	
	 public void selectTemplate(String value) {
			if (!commonFunction.checkNA(value)) {
				util.inputTextAndPressTab(drpTemplate, value);
				util.waitFor(5000);
			}
		}
		
	    By btnPlus = By.xpath("(//span[@class='rtPlus'])[1]");
		By txtcategory = By.xpath("(//input[contains(@value,'Filtering...')])[1]");
				
	 public void SelectTemplateDot(String value) {
	  		util.click(drpTemplateDot);
	  		if (!commonFunction.checkNA(value))
					util.inputTextAndPressTab(txtcategory, value);
	  		util.pressDownkey();
	  		util.pressDownkey();
	  		util.pressENTERkey();
	  		util.dummyWait(2);
	  		
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
	
	private void getVersionNo(String template) {
		By version = By.xpath("(//table[contains(@id,'_DOCUMENT_radYALGridControl')]/..//td[text()='Generated Document']/..//td[contains(text(),'"+template+"')]/..//td[count(//table/thead/tr/th[.='Category']/preceding-sibling::th)+1])");
		if(util.isElementVisible(version)) {
		String versionText=driver.findElement(version).getText();
		System.out.println("Version Text "+versionText);
		documentVersion=versionText.replaceAll("[^0-9]", "");
		if(documentVersion != null) {
			initialDocVersion=Integer.parseInt(documentVersion);
		}
		else {
			initialDocVersion=1;
		}
		}else {
			initialDocVersion=0;
		}
		}
		
		public void rightClickOnGrid(String value) {
			By clickOnDocument = By.xpath("(//tr[contains(@id,'_DOCUMENT_radYALGridControl')]/..//td[text()='Generated Document']/..//td[text()='"+value+" (ver "+FinalDocVersion+")'])[1]");	
			
			WebElement RclickOnDocument = driver.findElement(clickOnDocument);
			util.click(clickOnDocument);
			util.Rcllick(RclickOnDocument);
		}
		
		 By btnViewHistory = By.xpath("(//span[text()='View History'])[1]");
	    public void ClickonViewHistory() {
	    	util.waitUntilElementDisplay(btnViewHistory);
	    	util.click(btnViewHistory);
	    }
	    
	public void GenerateDocument(Map<String, String> map, String testcaseName) {
		try {
			nevigateToDocumentManagement();
			commonFunction.projectSelection();
			log("STEP 1:User can navigate to document Management panel", Status.PASS);
		} catch (Exception e) {
			log("STEP 1:user not able to navigate to document Management Tab", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}
		
		try {
			getVersionNo(map.get(Excel.Template));
			System.out.println("Initial Document Version" + initialDocVersion);
			ExpandsDocuments();
			log("STEP 2: User can Expand document generation panel", Status.PASS);
		} catch (Exception e) {
			log("STEP 2: User cannot Expand document generation panel", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}
		
//		if(testcaseName.contains("DOT")) {
//			try {
//				SelectTemplateDot(map.get(Excel.Template));
//				log("STEP 3: User can select template from the dd", Status.PASS);
//			} catch (Exception e) {
//				log("STEP 3:User cannot select template from the dd", Status.FAIL);
//				throw new RuntimeException("Failed in step 3");
//			}
//		}
//		else {
			try {
			selectTemplate(map.get(Excel.Template));
			log("STEP 3: User can select template from the dd", Status.PASS);
		} catch (Exception e) {
			log("STEP 3: User cannot select template from the dd", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}
//	}
		
		try {
			clickOnPDFRadioButton();
			clickOnGenerateDocumentButton();
			Assert.assertTrue(isPDFRadioSelected(), "PDF Radio button is not selected");
			FinalDocVersion= ++initialDocVersion;
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
			FinalDocVersion= ++FinalDocVersion;
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
			FinalDocVersion= ++FinalDocVersion;
			verifyMultipleWindow();
			log("STEP 6: select Excel 2007  & newer report format radio buttton", Status.PASS);
		} catch (Exception e) {
			log("STEP 6: User cannot select Excel 2007  & newer report format radio buttton", Status.FAIL);
			throw new RuntimeException("Failed in step 6");
		}
		
		util.reloadPage();
		try {
			By updatedVersion = By.xpath(
					"(//tr[contains(@id,'_DOCUMENT_radYALGridControl')]/..//td[text()='Generated Document']/..//td[text()='"
							+ map.get(Excel.Template) + " (ver " + FinalDocVersion + ")'])[1]");
		Assert.assertTrue(util.isElementVisible(updatedVersion));	
			log("STEP 7: Document Version Updated on the document grid", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 7: Document Version not Updated on the document grid", Status.FAIL);
		}

		try {
			rightClickOnGrid(map.get(Excel.Template));
			log("STEP 8: User can right click on the document record ", Status.PASS);
		} catch (Exception e) {
			log("STEP 8: User cannot right click on the document record ", Status.FAIL);
			throw new RuntimeException("Failed in step 8");
		}

		try {
			ClickonViewHistory();
			log("STEP 9: User can click on the View History button ", Status.PASS);
		} catch (Exception e) {
			log("STEP 9: User cannot able to click on View History button  ", Status.FAIL);
			throw new RuntimeException("Failed in step 9");
		}
		
		try {
			List<WebElement> historyList = driver.findElements(By.xpath("//div[contains(@id,'_DOCUMENT_DOCSS_RadDock3_C')]/..//td[contains(text(),'Doc Name: "+map.get(Excel.Template)+"')] |  //div[contains(@id,'_DOCUMENT_DOCSS_RadDock3_C')]/..//td[contains(text(),'Doc Name:')]/.//*[contains(text(),'"+map.get(Excel.Template)+"')]"));
			int actualDocVerstions = historyList.size();
		Assert.assertEquals(actualDocVerstions, FinalDocVersion);	
			log("STEP 10: Document Version Updated on the document history panel", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 10: Document Version not Updated on the document history panel", Status.FAIL);
		}
	}
	
	public void PreviewDocument(Map<String, String> map, String testcaseName) {

    try {
				ExpandsDocuments();
			selectTemplate(map.get(Excel.Template));
			log("STEP 1: User can select Template from the DD", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: User cannot select Template from the DD", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
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
			log("STEP 2: select Adobe pdf report format radio buttton ", Status.PASS);
		} catch (Exception e) {
			log("STEP 2: User cannot select Adobe pdf report format radio buttton ", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}
		
		try {
			clickOnWordRadioButton();
			clickOnPreviewDocumentButton();
			verifyMultipleWindow();
			log("STEP 3: select Word 2007  & newer report format radio buttton", Status.PASS);
		} catch (Exception e) {
			log("STEP 3: User cannot select Word 2007  & newer report format radio buttton", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}
		
		try {
			clickOnExcelRadioButton();
			clickOnPreviewDocumentButton();
			verifyMultipleWindow();
			log("STEP 4: select Excel 2007  & newer report format radio buttton", Status.PASS);
		} catch (Exception e) {
			log("STEP 4: User cannot select Excel 2007  & newer report format radio buttton", Status.FAIL);
			throw new RuntimeException("Failed in step 4");
		}
		
		try {
			By documentVersion = By.xpath(
					"(//tr[contains(@id,'_DOCUMENT_radYALGridControl')]/..//td[text()='Generated Document']/..//td[text()='"
							+ map.get(Excel.Template) + " (ver " + FinalDocVersion + ")'])[1]");
		Assert.assertTrue(util.isElementVisible(documentVersion));	
			log("STEP 5: Preview Document does not add document version on the document grid", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 5: Preview Document adds document version on the document grid", Status.FAIL);
		}
		
		try {
			rightClickOnGrid(map.get(Excel.Template));
			log("STEP 6: User can right click on the document record ", Status.PASS);
		} catch (Exception e) {
			log("STEP 6: User cannot right click on the document record ", Status.FAIL);
			throw new RuntimeException("Failed in step 6");
		}

		try {
			ClickonViewHistory();
			log("STEP 7: User can click on the View History button ", Status.PASS);
		} catch (Exception e) {
			log("STEP 7: User cannot able to click on View History button  ", Status.FAIL);
			throw new RuntimeException("Failed in step 7");
		}
		
		try {
			List<WebElement> historyList = driver.findElements(By.xpath("//div[contains(@id,'_DOCUMENT_DOCSS_RadDock3_C')]/..//td[contains(text(),'Doc Name: "+map.get(Excel.Template)+"')] | //div[contains(@id,'_DOCUMENT_DOCSS_RadDock3_C')]/..//td[contains(text(),'Doc Name:')]/.//*[contains(text(),'"+map.get(Excel.Template)+"')]"));
			int actualDocVerstions = historyList.size();
            Assert.assertEquals(actualDocVerstions, FinalDocVersion);	
			log("STEP 8: Preview Document does not add document version on the document history panel", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 8: Preview Document adds document version on the document history panel", Status.FAIL);
		}
		
	}
}
