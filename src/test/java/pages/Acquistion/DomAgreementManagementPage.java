package pages.Acquistion;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

import extentReports.ExtentTestManager;

public class DomAgreementManagementPage extends BasePage {

	TestUtil util;
	CommonFunction commonFunction;
	public static String DOCUMENT_TYPE;

	public DomAgreementManagementPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);

	}

	By navAgreementManagement = By.xpath("//span[text()='Agreement Management']");
	By btnAddNew = By.xpath("//img[contains(@id,'YALAGREEMENTMANAGEMENT_New_radYALGridControl_ctl00_ctl02_ctl00_Img4')]");
	By drpDocumentType = By.xpath("(//span[@class='rddtFakeInput'])[2]");
	By SelectDocumentType = By.xpath("(//span[@class='rtIn'])[2]");
	By drpState = By.xpath("//input[contains(@id,'EditFormControl_State_Abb_radYALDropDownList_Input')]");
	By txtDateExecuted = By.xpath("//input[contains(@id,'_DATE_EXECUTED_dateInput') and @type='text']");
	By txtLease = By.xpath("//input[contains(@id,'_EditFormControl_rtbLeaseNum') and @type='text']");
	By txtEfectiveDate = By.xpath("(//*[contains(@id,'_EditFormControl_CustFieldAGMNew')]/..//span[contains(text(),'Effective Date')]/..//input[@type='text'])[2]");
	By txtExpirationDate = By.xpath("(//*[contains(@id,'_EditFormControl_CustFieldAGMNew')]/..//span[contains(text(),'Expiration Date')]/..//input[@type='text'])[2]");
	By txtDateRecorded = By.xpath("(//*[contains(@id,'_EditFormControl_CustFieldAGMNew')]/..//span[contains(text(),'Date Recorded')]/..//input[@type='text'])[2]");
	By txtCommencementDate = By.xpath("(//*[contains(@id,'_EditFormControl_CustFieldAGMNew')]/..//span[contains(text(),'Commencement Date')]/..//input[@type='text'])[2]");
	By txtOldROW = By.xpath("//span[contains(text(), 'Old ROW')]/..//input[@type='text']");
	By txtPlanAndProfile = By.xpath("//span[contains(text(), 'Plan and Profile')]/..//input[@type='text']");
	By txtPhysicalFileLocation = By.xpath("//span[contains(text(), 'Physical File Location')]/..//input[@type='text']");
	By txtComment = By.xpath("//*[contains(@id,'_EditFormControl_CustFieldAGMNew')]/..//span[text()='Comments:']/..//textarea");
	By btnInsert = By.xpath("//input[contains(@id,'YALAGREEMENTMANAGEMENT_New_radYALGridControl_ctl00_ctl02_ctl03_EditFormControl_btnInsert')]");
	By changesSavedSuccessfully = By.xpath("//span[contains(@id,'YALAGREEMENTMANAGEMENT_New_usrMessage')]");
	By btnEdit = By.xpath("//input[contains(@id,'YALAGREEMENTMANAGEMENT_New_radYALGridControl_ctl00_ctl04_EditButton')]");
	By btnUpdate = By.xpath("//input[contains(@id,'_EditFormControl_btnUpdate')]");
	By btnDelete = By.xpath("//input[contains(@id,'YALAGREEMENTMANAGEMENT_New_radYALGridControl_ctl00_ctl04_gbcDeleteAlignment')]");
	By iframeDelete = By.xpath("//td[@class='rwWindowContent']");
	By btnOk = By.xpath("//span[text()='OK']");
	By linkAssets = By.xpath("//tr[contains(@id,'YALAGREEMENTMANAGEMENT_New_radYALGridControl')]//a[contains(text(),'Link Assets')]");
	By iframeLinkAssets = By.xpath("//iframe[@name='LAssets']");
	By drpAssetType = By.xpath("//input[@name='RCAssetType']");
	By btnGo = By.xpath("//input[@name='btnLoadAssets']");
	By drpSpecificAsset = By.xpath("//input[@name='RCSAsset']");
	By btnAdd = By.xpath("//input[@name='btnAddAssets']");
	By succesMsgLinkAsset = By.xpath("//span[contains(@id,'usrMessage') and text()='Selected Assets have been linked with agreement']");
	By btnclose = By.xpath("//a[@title='Close']");

	By linkRecordingInfo = By.xpath("//tr[contains(@id,'YALAGREEMENTMANAGEMENT_New_radYALGridControl')]//a[contains(text(),'Recording Info')]");
	By iframeRecordingInfo = By.xpath("//iframe[@name='Legals']");
	By btnAddNewRecord = By.xpath("//a[@id='AGMRecordingInfo_radYALGridControl_ctl00_ctl02_ctl00_lnkAddNewRecord']");
	By drpCounty = By.xpath("//input[contains(@id,'_EditFormControl_rcbCounty_Input') and @type='text']");
	By txtBook = By.xpath("//input[contains(@id,'_EditFormControl_Doc_Book') and @type='text']");
	By txtPage = By.xpath("//input[contains(@id,'_EditFormControl_Doc_Page') and @type='text']");
	By txtMicroFilm = By.xpath("//input[contains(@id,'_EditFormControl_Micro_Film') and @type='text']");
	By txtDocNo = By.xpath("//input[contains(@id,'_EditFormControl_DOC_NO') and @type='text']");
	By txtDateRecordedPopup = By.xpath("//input[contains(@id,'_EditFormControl_Date_Recorded_Info_dateInput') and @type='text']");
	By btnInsertRecordingInfo = By.xpath("//input[contains(@id,'AGMRecordingInfo_radYALGridControl_ctl00_ctl02_ctl03_EditFormControl_btnInsert')]");
	By successMsgRecordingInfo = By.xpath("//span[contains(@id,'AGMRecordingInfo_usrMessage') and text()='Changes saved successfully!']");

	public void ClickonAddNew() {
		util.waitUntilElementDisplay(navAgreementManagement);
		util.click(navAgreementManagement);
		util.waitUntilElementDisplay(btnAddNew);
		util.click(btnAddNew);
		util.waitUntilLoaderDisappear();
	}

	public void SelectDocumentType() {
		util.waitUntilElementDisplay(drpDocumentType);
		util.Doublecllick(drpDocumentType);
		util.click(drpDocumentType);
		util.click(SelectDocumentType);
		DOCUMENT_TYPE = driver.findElement(SelectDocumentType).getText();
	}

	public void SelectState(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpState, value);
	}

	public void SelectDateExecuted(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtDateExecuted, value);
	}

	public void AddLease(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtLease, value);
	}

	public void AddEfectiveDate(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtEfectiveDate, value);
	}

	public void AddExpirationDate(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtExpirationDate, value);
	}

	public void AddDateRecorded(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtDateRecorded, value);
	}

	public void AddCommencementDate(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtCommencementDate, value);
	}

	public void AddOldROW(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtOldROW, value);
	}

	public void AddPlanAndProfile(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtPlanAndProfile, value);
	}

	public void AddPhysicalFileLocation(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtPhysicalFileLocation, value);
	}

	public void AddComment(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtComment, value);
	}

	public void ClickonInsert() {
		util.waitUntilElementDisplay(btnInsert);
		util.click(btnInsert);
		util.waitUntilLoaderDisappear();

	}

	public void ClickoneEdit() {
		util.waitFor(500);
		util.waitUntilElementDisplay(btnEdit);
		util.click(btnEdit);
		util.waitUntilLoaderDisappear();
	}

	public void ClickonUpdate() {
		util.waitUntilElementDisplay(btnUpdate);
		util.click(btnUpdate);
		util.waitUntilLoaderDisappear();
	}

	public void ClickonDeleteButton() {
		util.dummyWait(1);
		util.waitUntilElementDisplay(btnDelete);
		util.click(btnDelete);
	}

	public void ClickonOk() {
		util.waitUntilElementDisplay(btnOk);
		util.click(btnOk);
		util.waitUntilLoaderDisappear();
	}

	public void ClickOnLinkAssets() {
		util.waitUntilElementDisplay(linkAssets);
		util.click(linkAssets);
		util.dummyWait(1);
	}

	public void SwitchToLinkAssetsFrame() {
		util.switchToIframe(iframeLinkAssets);
	}

	public void SelectAssetType(String value) {
		if (!commonFunction.checkNA(value)) {
			util.click(drpAssetType);
			By selectValue = By.xpath("//div[@id='RCAssetType_DropDown']//li[text()='" + value + "']");
			util.click(selectValue);
		}
	}

	public void ClickGoOnLinkAssets() {
		util.waitUntilElementDisplay(btnGo);
		util.click(btnGo);
		util.dummyWait(1);
	}

	public void SelectSpecificAsset(String value) {
		if (!commonFunction.checkNA(value)) {
			util.selectValueFromDropdownCheckbox(drpSpecificAsset, value);
		}
	}

	public void ClickAddAsset() {
		util.waitUntilElementDisplay(btnAdd);
		util.click(btnAdd);
		util.dummyWait(1);
	}

	public void ClosePopup() {
		util.switchToDefaultContent();
		util.waitUntilElementDisplay(btnclose);
		util.click(btnclose);
	}

	public void ClickOnRecordingInfo() {
		util.waitUntilElementDisplay(linkRecordingInfo);
		util.click(linkRecordingInfo);
		util.dummyWait(1);
	}

	public void SwitchToRecordingInfoFrame() {
		util.switchToIframe(iframeRecordingInfo);
	}

	public void ClickAddNewRecordingInfo() {
		util.waitUntilElementDisplay(btnAddNewRecord);
		util.click(btnAddNewRecord);
		util.dummyWait(1);
	}

	public void SelectCounty(String value) {
		if (!commonFunction.checkNA(value)) {
			util.inputTextAndPressTab(drpCounty, value);
		}
	}

	public void EnterBook(String value) {
		if (!commonFunction.checkNA(value)) {
			util.inputTextAndPressTab(txtBook, value);
		}
	}

	public void EnterPage(String value) {
		if (!commonFunction.checkNA(value)) {
			util.inputTextAndPressTab(txtPage, value);
		}
	}

	public void EnterMicroFilm(String value) {
		if (!commonFunction.checkNA(value)) {
			util.inputTextAndPressTab(txtMicroFilm, value);
		}
	}

	public void EnterDocNo(String value) {
		if (!commonFunction.checkNA(value)) {
			util.inputTextAndPressTab(txtDocNo, value);
		}
	}

	public void EnterDateRecorded(String value) {
		if (!commonFunction.checkNA(value)) {
			util.inputTextAndPressTab(txtDateRecordedPopup, value);
		}
	}

	public void ClickInsertRecordingInfo() {
		util.waitUntilElementDisplay(btnInsertRecordingInfo);
		util.click(btnInsertRecordingInfo);
		util.dummyWait(1);
	}

	public void AddAgreementManagement(Map<String, String> map, String testcaseName) {

		try {
			ClickonAddNew();
			log("STEP 1: User can expand the Agreement Manager Panel ", Status.PASS);
		} catch (Exception e) {
			log("STEP 1:  User cannot expand the Agreement Manager Panel", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}

		try {
			SelectDocumentType();
			log("STEP 2: User can select the document type ", Status.PASS);
		} catch (Exception e) {
			log("STEP 2: User cannot select the document type ", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}

		try {
			SelectState(map.get(Excel.State));
			log("STEP 3:  User can select State", Status.PASS);
		} catch (Exception e) {
			log("STEP 3:  User cannot select State ", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}

		try {
			SelectDateExecuted(map.get(Excel.DateExecuted));
			log("STEP 4:  User can select Executed Date", Status.PASS);
		} catch (Exception e) {
			log("STEP 4:  User cannot select Executed Date ", Status.FAIL);
			throw new RuntimeException("Failed in step 4");
		}

		try {
			AddLease(map.get(Excel.Lease));
			log("STEP 5:  User can enter the value in the Lease field.", Status.PASS);
		} catch (Exception e) {
			log("STEP 5:   User cannot enter the value in the Lease field.", Status.FAIL);
			throw new RuntimeException("Failed in step 5");
		}

		try {
			AddEfectiveDate(map.get(Excel.EfectiveDate));
			log("STEP 6:  User can select Effective Date", Status.PASS);
		} catch (Exception e) {
			log("STEP 6:   User can not select Effective Date", Status.FAIL);
			throw new RuntimeException("Failed in step 6");
		}

		try {
			AddExpirationDate(map.get(Excel.ExpirationDate));
			log("STEP 7:  User can enter the value in the Expiration Date field ", Status.PASS);
		} catch (Exception e) {
			log("STEP 7:  User cannot enter the value in the Expiration Date field", Status.FAIL);
			throw new RuntimeException("Failed in step 7");
		}

		try {
			AddDateRecorded(map.get("DateRecorded"));
			log("STEP 8:  User can select Date Recorded", Status.PASS);
		} catch (Exception e) {
			log("STEP 8:   User can not select Date Recorded", Status.FAIL);
			throw new RuntimeException("Failed in step 8");
		}

		try {
			AddCommencementDate(map.get("CommencementDate"));
			log("STEP 9:  User can enter the value in the Commencement Date field ", Status.PASS);
		} catch (Exception e) {
			log("STEP 9:  User cannot enter the value in the Commencement Date field", Status.FAIL);
			throw new RuntimeException("Failed in step 9");
		}

		try {
			AddOldROW(map.get("OldROW"));
			log("STEP 10: User can enter the value in the Old ROW", Status.PASS);
		} catch (Exception e) {
			log("STEP 10: User cannot enter the value in the Old ROW", Status.FAIL);
			throw new RuntimeException("Failed in step 10");
		}

		try {
			AddPlanAndProfile(map.get("PlanAndProfile"));
			log("STEP 11: User can enter the value in the Plan And Profile", Status.PASS);
		} catch (Exception e) {
			log("STEP 11: User cannot enter the value in the Plan And Profile", Status.FAIL);
			throw new RuntimeException("Failed in step 11");
		}

		try {
			AddPhysicalFileLocation(map.get("PhysicalFileLocation"));
			log("STEP 12: User can enter the value in the Physical File Location", Status.PASS);
		} catch (Exception e) {
			log("STEP 12: User cannot enter the value in the Physical File Location", Status.FAIL);
			throw new RuntimeException("Failed in step 12");
		}

		try {
			AddComment(map.get(Excel.Comment));
			log("STEP 13:  User can enter the value in the Comment field  ", Status.PASS);
		} catch (Exception e) {
			log("STEP 13:  User cannot enter the value in the Comment field", Status.FAIL);
			throw new RuntimeException("Failed in step 13");
		}

		try {
			ClickonInsert();
			log("STEP 14:   User can click on Insert button ", Status.PASS);
		} catch (Exception e) {
			log("STEP 14:   User cannot click on Insert button", Status.FAIL);
			throw new RuntimeException("Failed in step 14");
		}

	}

	public void EditAgreementManagement(Map<String, String> map, String testcaseName) {
		try {
			ClickoneEdit();
			log("STEP 1:  User can update comment ", Status.PASS);
		} catch (Exception e) {
			log("STEP 1:   User cannot update comment", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}

		try {
			AddComment(map.get("UpdateComment"));
			log("STEP 2:  User can update the Comment  ", Status.PASS);
		} catch (Exception e) {
			log("STEP 2:  User cannot update the Comment", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}

		try {
			ClickonUpdate();
			log("STEP 3: User can click on Update button ", Status.PASS);
		} catch (Exception e) {
			log("STEP 3: User cannot click on Update button ", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}

	}

	public void AddLinkAssets(Map<String, String> map, String testcaseName) {

		try {
			ClickOnLinkAssets();
			log("STEP 1: User clicked on 'Link Assets'", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: User could not click on 'Link Assets'", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}

		try {
		    SwitchToLinkAssetsFrame();
			log("STEP 2: Switched to 'Link Assets' iframe", Status.PASS);
		} catch (Exception e) {
			log("STEP 2: Could not switch to 'Link Assets' iframe", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}

		try {
			SelectAssetType(map.get("AssetType"));
			log("STEP 3: User can select Asset Type", Status.PASS);
		} catch (Exception e) {
			log("STEP 3: User cannot select Asset Type", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}

		try {
			ClickGoOnLinkAssets();
			log("STEP 4: User clicked 'Go' to load assets", Status.PASS);
		} catch (Exception e) {
			log("STEP 4: User could not click 'Go'", Status.FAIL);
			throw new RuntimeException("Failed in step 4");
		}

		try {
			SelectSpecificAsset(map.get("SpecificAsset"));
			log("STEP 5: User can select Specific Asset", Status.PASS);
		} catch (Exception e) {
			log("STEP 5: User cannot select Specific Asset", Status.FAIL);
			throw new RuntimeException("Failed in step 5");
		}

		try {
			ClickAddAsset();
			log("STEP 6: User clicked 'Add' to add selected asset", Status.PASS);
		} catch (Exception e) {
			log("STEP 6: User could not click 'Add'", Status.FAIL);
			throw new RuntimeException("Failed in step 6");
		}
		
		try {
			Assert.assertTrue(util.isElementVisible(succesMsgLinkAsset));
			log("STEP 7: User can see Success Message", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 7: User could not see Success Message", Status.FAIL);
		}
		
		try {
			By substationNo = By.xpath("//tr[contains(@id,'AGREEMENTLINKEDASSETS_radYALGridControl')]//td[text()='"+map.get("substationNo")+"']");
			Assert.assertTrue(util.isElementVisible(substationNo));
			log("STEP 8: User can see substation No in the grid view", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 8: User could not see substation No in the grid view", Status.FAIL);
		}
		
		try {
			By substationName = By.xpath("//tr[contains(@id,'AGREEMENTLINKEDASSETS_radYALGridControl')]//td[contains(normalize-space(),'Description: "+map.get("substationName")+"')]");
			Assert.assertTrue(util.isElementVisible(substationName));
			log("STEP 9: User can see substation Name in the grid view", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 9: User could not see substation Name in the grid view", Status.FAIL);
		}

		ExtentTestManager.infoWithScreenshot("Linked Assets");
		
		try {
			ClosePopup();
			log("STEP 10: User closed Link Assets popup and switched back", Status.PASS);
		} catch (Exception e) {
			log("STEP 10: User could not close Link Assets popup", Status.FAIL);
			throw new RuntimeException("Failed in step 10");
		}
	}

	public void AddRecordingInfo(Map<String, String> map, String testcaseName) {

		try {
			ClickOnRecordingInfo();
			log("STEP 1: User clicked on 'Recording Info'", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: User could not click on 'Recording Info'", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}

		try {
			SwitchToRecordingInfoFrame();
			log("STEP 2: Switched to 'Recording Info' iframe", Status.PASS);
		} catch (Exception e) {
			log("STEP 2: Could not switch to 'Recording Info' iframe", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}

		try {
			ClickAddNewRecordingInfo();
			log("STEP 3: User clicked 'Add New Record'", Status.PASS);
		} catch (Exception e) {
			log("STEP 3: User could not click 'Add New Record'", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}

		try {
			SelectCounty(map.get(Excel.County));
			log("STEP 4: User can select County", Status.PASS);
		} catch (Exception e) {
			log("STEP 4: User cannot select County", Status.FAIL);
			throw new RuntimeException("Failed in step 4");
		}

		try {
			EnterBook(map.get(Excel.Book));
			log("STEP 5: User can enter Book", Status.PASS);
		} catch (Exception e) {
			log("STEP 5: User cannot enter Book", Status.FAIL);
			throw new RuntimeException("Failed in step 5");
		}

		try {
			EnterPage(map.get(Excel.Page));
			log("STEP 6: User can enter Page", Status.PASS);
		} catch (Exception e) {
			log("STEP 6: User cannot enter Page", Status.FAIL);
			throw new RuntimeException("Failed in step 6");
		}

		try {
			EnterMicroFilm(map.get("MicroFilm"));
			log("STEP 7: User can enter Micro Film", Status.PASS);
		} catch (Exception e) {
			log("STEP 7: User cannot enter Micro Film", Status.FAIL);
			throw new RuntimeException("Failed in step 7");
		}

		try {
			EnterDocNo(map.get("DocNo"));
			log("STEP 8: User can enter Doc No", Status.PASS);
		} catch (Exception e) {
			log("STEP 8: User cannot enter Doc No", Status.FAIL);
			throw new RuntimeException("Failed in step 8");
		}

		try {
			EnterDateRecorded(map.get("DateRecorded"));
			log("STEP 9: User can enter Date Recorded", Status.PASS);
		} catch (Exception e) {
			log("STEP 9: User cannot enter Date Recorded", Status.FAIL);
			throw new RuntimeException("Failed in step 9");
		}

		try {
			ClickInsertRecordingInfo();
			log("STEP 10: User clicked 'Insert' to save Recording Info", Status.PASS);
		} catch (Exception e) {
			log("STEP 10: User could not click 'Insert' to save Recording Info", Status.FAIL);
			throw new RuntimeException("Failed in step 10");
		}

		try {
			Assert.assertTrue(util.isElementVisible(successMsgRecordingInfo));
			log("STEP 11: User can see Success Message", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 11: User could not see Success Message", Status.FAIL);
		}
		
		try {
			By book = By.xpath("//tr[contains(@id,'AGMRecordingInfo_radYALGridControl')]//td[text()='"+map.get(Excel.Book)+"']");
			Assert.assertTrue(util.isElementVisible(book));
			log("STEP 12: User can see Book in the grid view", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 12: User could not see Book in the grid view", Status.FAIL);
		}
		
		try {
			By page = By.xpath("//tr[contains(@id,'AGMRecordingInfo_radYALGridControl')]//td[text()='"+map.get(Excel.Page)+"']");
			Assert.assertTrue(util.isElementVisible(page));
			log("STEP 13: User can see Page in the grid view", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 13: User could not see Page in the grid view", Status.FAIL);
		}
		
		try {
			By docNo = By.xpath("//tr[contains(@id,'AGMRecordingInfo_radYALGridControl')]//td[text()='"+map.get("DocNo")+"']");
			Assert.assertTrue(util.isElementVisible(docNo));
			log("STEP 14: User can see Document Number in the grid view", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 14: User could not see Document Number in the grid view", Status.FAIL);
		}

		ExtentTestManager.infoWithScreenshot("Recording Info");
		try {
			ClosePopup();
			log("STEP 15: User closed Recording Info popup and switched back", Status.PASS);
		} catch (Exception e) {
			log("STEP 15: User could not close Recording Info popup", Status.FAIL);
			throw new RuntimeException("Failed in step 15");
		}
	}

	public void DeleteAgreementManagement(String testcaseName) {
		try {
			ClickonDeleteButton();
			log("STEP 1: User can click on Delete Button  ", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: User cannot click on Delete Button ", Status.FAIL);
			throw new RuntimeException("Failed in step 1 ");
		}

		try {
			ClickonOk();
			log("STEP 2: User can click on Ok Button", Status.PASS);
		} catch (Exception e) {
			log("STEP 2: User cannot click on Ok Button", Status.FAIL);
			throw new RuntimeException("Failed in step 2 ");

		}

		try {
			Assert.assertTrue(util.isElementVisible(changesSavedSuccessfully));
			log("STEP 3:   User can see success Message ", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 3:   User cannot see success Message", Status.FAIL);
		}
	}
}
