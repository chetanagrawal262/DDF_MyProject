package pages.EncroachmentDocuments;

import java.io.File;
import java.util.Map;

import org.openqa.selenium.By;
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

public class DocumentPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;

	public DocumentPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	
	//Navigation
	By navAdministration = By.xpath("//span[text()='Administration']");
	By navEncroachmentRequests = By.xpath("//span[contains(text(),'Encroachment Requests')]");
	By navDocuments = By.xpath("(//*[@id='ctl00_ConPHRightTop_RadTabStrip1']/..//*[text()='Documents'])[1]");
	
	//External Document
	By btnAddDocument = By.xpath("//input[contains(@onclick,'ShowTicketAddDocForm') and @id='ctl00_ConPHRightTop_BtnAddDocument']");
	By iframeDocument = By.xpath("//iframe[@name='AddIssueDocuments']");
	By txtDescription = By.xpath("//input[contains(@id,'RadPanelBar1_i0_i0_rauFileUploadDesc') and @type='text']"); 
	By btnLoadDocuments = By.xpath("//input[contains(@id,'buttonSubmit_input') and @type='button']");
    By DocumentName = By.xpath("//span[@id='lblResults']");
	By btnClose = By.xpath("//a[@class='rwCloseButton']");
	
	//External Link
	By ExpandExternalLink = By.xpath("//span[text()='External Link']");
    By txtDocumentName = By.xpath("//input[contains(@id,'radReportConfigPanels_i0_i0_txtDynamic1')]");
    By txtExternalLink = By.xpath("//input[contains(@id,'radReportConfigPanels_i0_i0_link1')]");
    By Category = By.xpath("//div[@id='radReportConfigPanels_i0_i0_XYZ1_RadDropDownTree1']");
	By txtDescriptionExtLink = By.xpath("//input[contains(@id,'radReportConfigPanels_i0_i0_description')]");
	By btnLoadDocument = By.xpath("//input[@id='radReportConfigPanels_i0_i0_btnSave_input']");
	By btnRefresh = By.xpath("//img[@alt='refresh']/../..//a[contains(@id,'_DOCUMENT_radYALGridControl_ctl00_ctl02_ctl00_Button1')]");
	
	//Document Version
	
	By btnAddVersion = By.xpath("//span[contains(text(),'Add Version')]");
	By iframeDocumentVersion = By.xpath("//iframe[@name='_blank']");
	
	//Download All
	By btnDownloadAll = By.xpath("//img[@alt='Download Zip File']");
    By iframe = By.xpath("//iframe[@name='HistoryDialog']");
    By btnDownloadNow = By.xpath("//input[contains(@id,'btnDownloadNow') and @type='submit']");
	
	public void NavigateToEncroachmentDocuments() {
		util.waitUntilElementDisplay(navAdministration);
		util.click(navAdministration);
		util.waitUntilElementDisplay(navEncroachmentRequests);
		util.click(navEncroachmentRequests);
		util.waitUntilElementDisplay(navDocuments);
		util.click(navDocuments);

	}

	public void ClickOnAddDocument() {
		util.waitUntilElementDisplay(btnAddDocument);
		util.click(btnAddDocument);

	}

	By fileUpload = By.xpath("//input[contains(@id,'FileUploadfile')]");
	public void uploadFile() {
		util.dummyWait(1);
		String filepath = System.getProperty("user.dir") + File.separator + "test.txt";
		driver.findElement(fileUpload).sendKeys(filepath);
	}

	By drpCategoryROWTree = By.xpath("//div[contains(@id,'rauFileUploadundefined')]");
	public void selectCategoryTree() {
		util.waitUntilElementDisplay(drpCategoryROWTree);
			util.click(drpCategoryROWTree);
			util.waitUntilElementDisplay(SelectCategory);
			util.click(SelectCategory);
		
	}

	public void AddDescription(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtDescription, value);
	}

	public void LoadDocuments() {
		util.click(btnLoadDocuments);
		util.dummyWait(1);
	}

	public void ClickOnCloseButton() {
		util.switchToDefaultContent();
		util.waitUntilElementDisplay(btnClose);
		util.click(btnClose);

	}

	public void ExpandExternalLink() {
		util.waitUntilElementDisplay(ExpandExternalLink);
		util.click(ExpandExternalLink);
	}

	public void AddDocumentName(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtDocumentName, value);
	}

	public void AddExternalLink(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtExternalLink, value);
	}

	By SelectCategory = By.xpath("(//span[contains(text(),'Docusign Demo') and @class='rtIn'])[1]");
	public void SelectCategory() {
		util.waitUntilElementDisplay(Category);
		util.click(Category);
		util.waitUntilElementDisplay(SelectCategory);
		util.click(SelectCategory);

	}

	public void AddDescriptionExtLink(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtDescriptionExtLink, value);
	}

	public void ClickOnLoadDocument() {
		util.waitUntilElementDisplay(btnLoadDocument);
		util.click(btnLoadDocument);
	}
	
	public void ClickOnRefresh() {
		util.waitUntilElementDisplay(btnRefresh);
		util.click(btnRefresh);
        util.waitUntilLoaderDisappear();    
	}
	
	public void clickOnViewDocument(String value) {
		By btnViewDocument = By.xpath("(//*[text()='" + value + "']/..//a[text()='View Document'])[1]");
		util.dummyWait(3);
		util.click(btnViewDocument);
	}

	public void RightClickonDocumentGrid(String value) {
		By DocumentGrid = By.xpath("(//*[text()='" + value + "']/..)[1]");
		WebElement web = driver.findElement(DocumentGrid);
		util.waitUntilElementDisplay(DocumentGrid);
		Actions act = new Actions(driver);
		act.moveToElement(web).contextClick().build().perform();
	}

	public void ClickonAddVersion() {
		util.waitUntilElementDisplay(btnAddVersion);
		util.click(btnAddVersion);
		util.dummyWait(2);
	}
	
	public void ClickonDownloadAll() {
    	util.waitUntilElementDisplay(btnDownloadAll);
    	util.click(btnDownloadAll);
    	util.dummyWait(2);
    	util.switchToIframe(iframe);
    	util.waitUntilElementDisplay(btnDownloadNow);
    	util.switchToDefaultContent();
    	util.dummyWait(1);
    	util.click(btnClose);
    	util.dummyWait(1);
    }
	
	public void AddExternalDocument(Map<String, String> map, String testcaseName) {

		try {
			NavigateToEncroachmentDocuments();
			log("STEP 1: User can navigate to the Encroachment Documents", Status.PASS);
		} catch (Exception e) {
			log("STEP 1:  User cannot navigate to the Encroachment Documents", Status.FAIL);
			throw new RuntimeException("Failed in step 1 ");
		}

		try {
			ClickOnAddDocument();
			util.switchToIframe(iframeDocument);
			util.dummyWait(5);
			log("STEP 2: User can click on the add document button", Status.PASS);
		} catch (Exception e) {
			log("STEP 2: User cannot see the add document button", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}

		try {
			uploadFile();
			log("STEP 3: User can upload document from the system ", Status.PASS);
		} catch (Exception e) {
			log("STEP 3:  User cannot upload document from the system   ", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}

		if (util.isElementPresent(drpCategoryROWTree)) {
			try {
				selectCategoryTree();
				log("STEP 4: Value added diplays in Category field      ", Status.PASS);
			} catch (Exception e) {
				log("STEP 4:  Added value does not display in Category field    ", Status.FAIL);
				throw new RuntimeException("Failed in step 4");
			}
		}

		try {
			AddDescription(map.get(Excel.Description));
			log("STEP 5: User can enter a value in Description field   ", Status.PASS);
		} catch (Exception e) {
			log("STEP 5:  User cannot add a value in Description field    ", Status.FAIL);
			throw new RuntimeException("Failed in step 5");
		}

		try {
			LoadDocuments();
			log("STEP 6: User can click on the Load Documents Button", Status.PASS);
		} catch (Exception e) {
			log("STEP 6:  User cannot click on the Load Documents Button",Status.FAIL);
			throw new RuntimeException("Failed in step 6");
		}
		
		try {
			Assert.assertTrue(util.isElementVisible(DocumentName));
			log("STEP 7: User can see sucess message", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 7:  User cannot see sucess message",Status.FAIL);
		}
	}
	    
	    
	public void AddExternalLink(Map<String, String> map, String testcaseName) {
		
		try {
			if (!util.isElementVisible(txtDocumentName)) {
				ExpandExternalLink();
			}
			log("STEP 1: User can expand External Link Panel", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: User cannot expand External Link Panel ", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}

		try {
			AddDocumentName(map.get(Excel.DocumentName));
			log("STEP 2: User can enter a value in Document Name field  ", Status.PASS);
		} catch (Exception e) {
			log("STEP 2: User cannot add a value in Document Name field ", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}

		try {
			AddExternalLink(map.get(Excel.ExternalLink));
			log("STEP 3: User can enter a value in External Link field   ", Status.PASS);
		} catch (Exception e) {
			log("STEP 3:  User cannot add a value in External Link field    ", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}

		if (util.isElementPresent(Category)) {
			try {
				SelectCategory();
				log("STEP 4: Added value displays in Category field  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 4: User  cannot select  value  from Category DD ", Status.FAIL);
				throw new RuntimeException("Failed in step 4");
			}
		}
		
		try {
			AddDescriptionExtLink(map.get(Excel.Description));
			log("STEP 5:  User can enter a value in Description field  ", Status.PASS);
		} catch (Exception e) {
			log("STEP 5: User cannot add a value in Description field   ", Status.FAIL);
			throw new RuntimeException("Failed in step 5");
		}

		try {
			ClickOnLoadDocument();
			log("STEP 6: User can click on Load Document button", Status.PASS);
		} catch (Exception e) {
			log("STEP 6: User cannot click on Load Document button ",Status.FAIL);
			throw new RuntimeException("Failed in step 6");
		}
		
		try {
			ClickOnCloseButton();
			log("STEP 7: User can close the document popup", Status.PASS);
		} catch (Exception e) {
			log("STEP 7: User cannot close the document popup ",Status.FAIL);
			throw new RuntimeException("Failed in step 7");
		}
		
		try {
			ClickOnRefresh();
			log("STEP 8: User can click on Refresh button", Status.PASS);
		} catch (Exception e) {
			log("STEP 8: User cannot click on Refresh button ", Status.FAIL);
			throw new RuntimeException("Failed in step 8");
		}
	}
	
	public void ViewDocument(Map<String, String> map, String testcaseName) {

		

		try {
			clickOnViewDocument(map.get(Excel.DocumentName));
			util.dummyWait(1);
			util.switchToChildWindow();
			ExtentTestManager.infoWithScreenshot("Viewed Document");
			driver.close();
			util.switchToParentWindow();
			log("STEP 1:  User can Click on View Document", Status.PASS);
		} catch (Exception e) {
			log("STEP 1:  User can not Click on View Document", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}

	}
	
	public void AddDocumentsVersion(Map<String, String> map, String testcaseName) {

		try {
			RightClickonDocumentGrid(map.get(Excel.DocumentName));
			log("STEP 1: User can Right click on the Document Record ", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: User cannot Right click on the Document Record ", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}

		try {
			ClickonAddVersion();
			util.switchToIframe(iframeDocumentVersion);
			util.dummyWait(5);
			log("STEP 2: User can click on the Add Version button ", Status.PASS);
		} catch (Exception e) {
			log("STEP 2: User cannot able to click on Add Version button   ", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}

		try {
			uploadFile();
			log("STEP 3: User can upload the file ", Status.PASS);
		} catch (Exception e) {
			log("STEP 3: User cannot upload the file ", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}
		
		if (util.isElementPresent(drpCategoryROWTree)) {
			try {
				selectCategoryTree();
				log("STEP 4: Value added diplays in Category field      ", Status.PASS);
			} catch (Exception e) {
				log("STEP 4:  Added value does not display in Category field    ", Status.FAIL);
				throw new RuntimeException("Failed in step 4");
			}
		}

		try {
			AddDescription(map.get("UpdatedDescription"));
			log("STEP 5: User can enter a value in Description field   ", Status.PASS);
		} catch (Exception e) {
			log("STEP 5:  User cannot add a value in Description field    ", Status.FAIL);
			throw new RuntimeException("Failed in step 5");
		}

		try {
			LoadDocuments();
			log("STEP 6: User can click on the Load Documents Button", Status.PASS);
		} catch (Exception e) {
			log("STEP 6:  User cannot click on the Load Documents Button",Status.FAIL);
			throw new RuntimeException("Failed in step 6");
		}
		
		try {
			Assert.assertTrue(util.isElementVisible(DocumentName));
			log("STEP 7: User can see sucess message", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 7:  User cannot see sucess message",Status.FAIL);
		}
		
		try {
			ClickOnCloseButton();
			log("STEP 8: User can close the document popup", Status.PASS);
		} catch (Exception e) {
			log("STEP 8: User cannot close the document popup ",Status.FAIL);
			throw new RuntimeException("Failed in step 8");
		}
		
		try {
			ClickOnRefresh();
			log("STEP 9: User can click on Refresh button", Status.PASS);
		} catch (Exception e) {
			log("STEP 9: User cannot click on Refresh button ", Status.FAIL);
			throw new RuntimeException("Failed in step 9");
		}

	}
	
	
	public void DownloadAllDocuments(String testcaseName) {

		util.dummyWait(3);
		try {
			ClickonDownloadAll();
			log("STEP 1: User can click on the Download All button  ", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: User cannot able to click on Download All button ", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}

	}
	
	By btnRequestDelete = By.xpath("//span[contains(text(),'Request Delete')]");
	public void ClickonRequestDelete(String value) {
		By clickOnDocument = By.xpath("(//*[text()='" + value + "'])[1]");
		WebElement RclickOnDocument = driver.findElement(clickOnDocument);
		util.click(clickOnDocument);
		util.Rcllick(RclickOnDocument);
		util.dummyWait(1);
		if (util.isElementVisible(btnRequestDelete)) {
			util.waitUntilElementDisplay(btnRequestDelete);
			util.click(btnRequestDelete);
			util.dummyWait(3);
		} else {
			log("Request Delete Option not visible ", Status.SKIP);
		}
	}

	public void DeleteDocument(Map<String, String> map, String testcaseName) {

		try {
			ClickonRequestDelete(map.get(Excel.DocumentName));
			log("STEP 1: User can Request Delete Document ", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: User cannot Request Delete Document ", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}

	}
	
}
