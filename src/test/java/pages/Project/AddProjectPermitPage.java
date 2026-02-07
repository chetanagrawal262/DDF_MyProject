package pages.Project;

import java.io.File;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

public class AddProjectPermitPage extends BasePage {

	TestUtil util;
	CommonFunction commonFunction;

	public AddProjectPermitPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}

	By PrjectPermit = By.xpath("//a[normalize-space()='Project Permits']");
	By addProjectPermit = By
			.xpath("//*[normalize-space()='Project Permits']/..//a[normalize-space()='Add new record']");
	By drpAgentName = By.xpath("//input[contains(@id,'EditFormControl_AGENCY_ID_radYALDropDownList_Input')]");
	By txtPermitNumber = By.xpath("//input[contains(@name,'EditFormControl$PERMIT_NUMBER')]");
	By txtComment = By.xpath("//textarea[contains(@id,'EditFormControl_COMMENTS')]");
	By btnInsert = By.xpath("//input[@value='Insert']");
	By btnUpdate = By.xpath("//input[@value='Update']");
	By deleteOk = By.xpath("//a[contains(@onClick,'confirm')]//span[text()='OK']");
	By changesSavedSuccessfully = By.xpath("//span[text()='Changes saved successfully!']");	
	By iframeDocument = By.xpath("//iframe[@name='UserListDialog'] | //iframe[@name='AddDocuments']");
	By iframeDocument1 = By.xpath("//iframe[@name='ViewEditDocument']");
	By btnAddDocument = By.xpath("//input[@id='btnAdddocuments']");
	By drpCategory = By.cssSelector("#rddtFakeInput");
	By txtDescription = By.cssSelector("#RadUpload1Desc0");
	By documentFileUpload = By.xpath("//*[@id=\"RadPanelBar1_i0_i0_rauFileUploadfile0\"]");
	By loadDocumentFile = By.cssSelector("#buttonSubmit");
	By loadDocumentFile2 = By.xpath("//input[contains(@id,'buttonSubmit_input')]");
	By documentSuccessMessage = By.xpath("//span[@id='lblResults']");
	By btnDocumentClose = By.xpath("//a[@title='Close']");
	

	String tableValue = "//table//tbody//tr//td[text()='%s']";
	String addDocument = "//div[contains(@id,'radYALGridControl')]//td[contains(.,'%s')]/following-sibling::td//a[text()='Add Document']";
	String addDocumentALT = "//td[contains(text(),'Test Comment ALT')]/parent::tr//.//td[6] | //tr[contains(@id,'ProjPermits2_radYALGridControl_ctl00__0')]//a[text()='View/Edit Document']";
	public void clickOnAddNewRecord() {
		util.click(addProjectPermit);
		util.waitUntilLoaderDisappear();
	}

	public void setAgencyName(String value) {
		if (!commonFunction.checkNA(value))
			util.inputText(drpAgentName, value);
		util.pressENTERkey();
	}

	By firstAgencyName = By.xpath("//*[contains(@id,'EditFormControl_AGENCY_ID_radYALDropDownList_DropDown')]/..//li[1]");
	public void setAgencyName() {
		util.waitUntilElementDisplay(drpAgentName);
			util.click(drpAgentName);
			util.click(firstAgencyName);
			util.waitUntilLoaderDisappear();
	}
	
	
	
	By drpLegalAgent = By.xpath("//input[contains(@id,'_EditFormControl_LegalAgents_radYALDropDownList_Input')]");
	public void setLegalAgent(String value) {
		if (!commonFunction.checkNA(value))
			util.inputText(drpLegalAgent, value);
		util.pressENTERkey();
	}
	
	public void setPermitNumber(String value) {
		if (!commonFunction.checkNA(value))
			util.inputText(txtPermitNumber, value);
	}

	public void setComment(String value) {
		if (!commonFunction.checkNA(value))
			util.inputText(txtComment, value);
	}

	public void editProjectPermit(String value) {
		By btnEdit = By.xpath("//td[contains(text(),'" + value + "')]/parent::tr/td/input[@title='Edit']");
		util.click(btnEdit);
		util.waitUntilLoaderDisappear();
	}

	public void deleteProjectPermit(String value) {
		By btnDelete = By.xpath("(//td[contains(text(),'" + value + "')]/parent::tr/td/input[@title='Delete'])[1]");
		util.click(btnDelete);
	}

	public void addProjectPermit(Map<String, String> map) throws InterruptedException {
		
		try {
			util.click(PrjectPermit);
			log("STEP 1: User can expand Project Permit panel", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: User cannot expand Project Permit panel ", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}
		
		try {
			clickOnAddNewRecord();
			log("STEP 2: User can click on Add new record button of Project Permit panel", Status.PASS);
		} catch (Exception e) {
			log("STEP 2: User cannot click on Add new record button of Project Permit panel ", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}
		
		try {
			setAgencyName();
			util.dummyWait(IMPLICIT_WAIT);
			log("STEP 3: User can select value from the Agency Name DD", Status.PASS);
		} catch (Exception e) {
			log("STEP 3: User cannot select value from the Agency Name DD. ", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}
		try {
			setPermitNumber(map.get(Excel.PermitNumber));
			log("STEP 4: User can enter value in the Permit Number field", Status.PASS);
		} catch (Exception e) {
			log("STEP 4: User cannot enter value in the Permit Number field.  ", Status.FAIL);
			throw new RuntimeException("Failed in step 4");
		}
		
		if(util.isElementPresent(drpLegalAgent)) {
		try {
			setLegalAgent(map.get(Excel.LegalAgent));
			log("STEP 5: User can select value from the Legal Agent DD", Status.PASS);
		} catch (Exception e) {
			log("STEP 5: User cannot enter value in the Legal Agent field.  ", Status.FAIL);
			throw new RuntimeException("Failed in step 5");
		}
		}
		
		try {
			util.click(btnInsert);
			util.waitUntilLoaderDisappear();
			log("STEP 6: User can click on Inser button", Status.PASS);
		} catch (Exception e) {
			log("STEP 6: User cannot click on Insert button ", Status.FAIL);
			throw new RuntimeException("Failed in step 6");
		}
		
		if(environment.contains("TRA") || environment.contains("DOM")) {
			if (util.isElementVisible(By.xpath("//b[text()='"+map.get(Excel.PermitNumber)+"']"))){
				log("STEP 7: ProjectPermit is added sucessfully", Status.PASS);
			} else {
				log("STEP 7: ProjectPermit is not added sucessfully ", Status.FAIL);
				throw new RuntimeException("Failed in step 7");
			}
		}else {
			if (util.isElementVisible(By.xpath("//b[text()='"+map.get(Excel.PermitNumber)+"'] | //*[text()='"+map.get(Excel.PermitNumber)+"']"))){
				log("STEP 7: ProjectPermit is added sucessfully", Status.PASS);
			} else {
				log("STEP 7: ProjectPermit is not added sucessfully ", Status.FAIL);
				throw new RuntimeException("Failed in step 7");
			}
		}
		

	}

	public void updateProjectPermit(Map<String, String> map) throws InterruptedException {
		
		try {
			editProjectPermit(map.get(Excel.PermitNumber));
			log("STEP 8: User can click on edit button ", Status.PASS);
		} catch (Exception e) {
			log("STEP 8: User cannot click on edit button", Status.FAIL);
			throw new RuntimeException("Failed in step 8");
		}
		
		try {
			setComment(map.get("UpdatedComment"));
			log("STEP 9: User can add comment in the field ", Status.PASS);
		} catch (Exception e) {
			log("STEP 9: User cannot add comment in the field ", Status.FAIL);
			throw new RuntimeException("Failed in step 9");
		}
		
		try {
			util.click(btnUpdate);
			util.waitUntilLoaderDisappear();
			log("STEP 10: User can click on update button", Status.PASS);
		} catch (Exception e) {
			log("STEP 10: User cannot click on update button", Status.FAIL);
			throw new RuntimeException("Failed in step 10");
		}
       
		if(environment.contains("TRA") || environment.contains("DOM")) {
			if (util.isElementVisible(By.xpath("//b[text()='"+map.get(Excel.PermitNumber)+"']"))){
				log("STEP 11: ProjectPermit is Updated sucessfully ", Status.PASS);
			} else {
				log("STEP 11: ProjectPermit is not Edited sucessfully ", Status.FAIL);
				throw new RuntimeException("Failed in step 11");
			}
		}else {
		if (util.isElementVisible(By.xpath("(//b[text()='"+map.get(Excel.PermitNumber)+"'])[1] | (//*[text()='"+map.get(Excel.PermitNumber)+"'])[1]"))){
			log("STEP 11: ProjectPermit is Updated sucessfully ", Status.PASS);
		} else {
			log("STEP 11: ProjectPermit is not Edited sucessfully ", Status.FAIL);
			throw new RuntimeException("Failed in step 11");
		}
		}
	}
	public void addDocument(Map<String, String> map,String testcaseName) {

		if(testcaseName.contains("ALT") || testcaseName.contains("ORSTED") || testcaseName.contains("ORION") || testcaseName.contains("ATWELL") || testcaseName.contains("TRA")) {
			//By addDocumnetalt = By.xpath(String.format(addDocumentALT, map.get(Excel.PermitNumber)));
			By addDocumnetalt = By.xpath("//td[contains(text(),'"+map.get("UpdatedComment")+"')]/parent::tr//.//td[6] | //tr[contains(@id,'ProjPermits2_radYALGridControl_ctl00__0')]//a[text()='View/Edit Document']");
			util.waitUntilElementDisplay(addDocumnetalt);
			util.click(addDocumnetalt);
			
			util.waitForWebElementToBePresent(iframeDocument1);
			util.switchToIframe(iframeDocument1);
			
			util.waitForWebElementToBePresent(btnAddDocument);
			util.click(btnAddDocument);
			
			util.waitForWebElementToBePresent(iframeDocument);
			util.switchToIframe(iframeDocument);
		}else if(testcaseName.contains("DOM")){
			By addDocumnetalt = By.xpath("//tr[contains(@id,'ProjPermits_radYALGridControl_ctl00__0')]//a[text()='View/Edit Document']");
			util.waitUntilElementDisplay(addDocumnetalt);
			util.click(addDocumnetalt);
			
			util.waitForWebElementToBePresent(iframeDocument1);
			util.switchToIframe(iframeDocument1);
			
			util.waitForWebElementToBePresent(btnAddDocument);
			util.click(btnAddDocument);
			
			util.waitForWebElementToBePresent(iframeDocument);
			util.switchToIframe(iframeDocument);
		}else
		{
			//By addDocumnet = By.xpath(String.format(addDocument, map.get(Excel.PermitNumber)));
			By addDocumnet = By.xpath("//tr[contains(@id,'ProjPermits_radYALGridControl')]/..//*[text()='"+map.get("UpdatedComment")+"']/..//a[text()='Add Document']");
			util.waitUntilElementDisplay(addDocumnet);
			util.click(addDocumnet);
			util.waitForWebElementToBePresent(iframeDocument);
			util.switchToIframe(iframeDocument);
		}
		
		String filepath = System.getProperty("user.dir") + File.separator + "test.txt";
		driver.findElement(documentFileUpload).sendKeys(filepath);
		util.waitFor(2000);
		try {
			if (util.isElementPresent(loadDocumentFile)) {
				util.click(loadDocumentFile);
			} else if (util.isElementPresent(loadDocumentFile2)) {
				util.click(loadDocumentFile2);
			}

			log("STEP 12: User can upload document from the system  ", Status.PASS);
		} catch (Exception e) {
			log("STEP 12:  User cannot upload a document  ", Status.FAIL);
			throw new RuntimeException("Failed in step 12");
		}

		util.waitUntilElementDisplay(documentSuccessMessage);
		if (util.getText(documentSuccessMessage).contains("Loaded: test.txt")) {
			log("STEP 13: Document Saved Successfully ", Status.PASS);
		} else {
			log("STEP 13:  Document does not saved Successfully  ", Status.FAIL);
			throw new RuntimeException("Failed in step 13");
		}
		util.switchToDefaultContent();
		try {
			log("STEP 14: upon popup close, auto refresh the panel to display updated information ", Status.PASS);
			util.click(btnDocumentClose);
		} catch (Exception e) {
			log("STEP 14:  Autorefresh of the panel does not happen  ", Status.FAIL);
			throw new RuntimeException("Failed in step 14");
		}
	}

	public void deletProjectPermit(Map<String, String> map) {
		util.dummyWait(5);
		try {
			deleteProjectPermit(map.get(Excel.PermitNumber));
			log("STEP 15:User can click on delete icon  ", Status.PASS);
		} catch (Exception e) {
			log("STEP 15: User cannot click on delete icon ", Status.FAIL);
			throw new RuntimeException("Failed in step 15");
		}
		util.waitFor(1000);
		try {
			util.click(deleteOk);
			log("STEP 16: User can click on ok button ", Status.PASS);
		} catch (Exception e) {
			log("STEP 16: User cannot click on ok button ", Status.FAIL);
			throw new RuntimeException("Failed in step 16");
		}
		util.waitUntilLoaderDisappear();

		if (util.isElementPresent(changesSavedSuccessfully)) {
			log("STEP 17: ProjectPermit is deleted sucessfully ", Status.PASS);
		} else {
			log("STEP 17: ProjectPermit is not deleted sucessfully ", Status.FAIL);
			throw new RuntimeException("Failed in step 17");
		}

	}

}
