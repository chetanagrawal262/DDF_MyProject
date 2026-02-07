package pages.PropertyManagement;

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

import extentReports.ExtentTestManager;

public class AgreementsPanelPage extends BasePage {

	TestUtil util;
	CommonFunction commonFunction;
	

	public AgreementsPanelPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}	
	
	By AddNewAgreement = By.xpath("//img[contains(@id,'_YALPMAGREEMENTMANAGEMENT')]");
	By DocumentTypeFilter = By.xpath("(//input[contains(@value,'Filtering...')])[1]");
	By DocumentType  = By.xpath("(//span[contains(@class,'rddtEmptyMessage')])[1]");
	By BtnInsert = By.xpath("//input[contains(@id,'EditFormControl_btnInsert')]");
	By LinkParcels =By.xpath("//a[contains(text(),' Link Parcels')]");
	By LinkLessees = By.xpath("//a[contains(text(),' Link Lessees ')]");
	By LinkDocument =By.xpath("//a[contains(text(),'View/Edit Document')]");
	By IFrame = By.xpath("//iframe[@name='geoPopUp2']");
	//By drpProjects = By.xpath("//input[@id='Projects_Input']");
	By drpProjects = By.xpath("//a[contains(@id,'Projects_Arrow')]");
	By BtnGo = By.xpath("//input[@id='btnLoadAgreements']");
	//By drpListOfTract = By.xpath("//*[@id='Tract_Agreement_Input']");
	By drpListOfTract = By.xpath("//a[contains(@id,'Tract_Agreement_Arrow')]");
	By BtnAdd = By.xpath("//input[@id='btnAddAgreementAssociation']");
	By SuccessMsg = By.xpath("//span[text()='Requested association created successfully']");
	//By selectCheckbox =By.xpath("//*[@id='t_container']//*[text()='Regression_LO']/../..//input[@type='checkbox']");
	By selectCheckbox =By.xpath("//*[@id='rptDataRepeater_ctl01_LOChecked']");
	By BtnSave = By.xpath("//input[@id='btnSave']");
	By MsgOnLessees = By.xpath("//span[@id='usrMessage']"); 
	By ClosePopup =By.xpath("//a[@title='Close']");
	
	By btnAddDocuments = By.xpath("//input[@id='btnAdddocuments']");
	By iframeDocument = By.xpath("//iframe[@name='AddDocuments']");
	By fileUpload = By.xpath("//input[contains(@id,'RadUpload1file') or contains(@id,'rauFileUploadfile')]");
	By drpCategory = By.xpath("//select[contains(@id,'_rauFileUploadcategory')] | //select[contains(@id,'Category')]");
	By description = By.xpath("//input[contains(@id,'RadUpload1Desc') or contains(@id,'rauFileUploadDesc')]");
	
	By loadDocumentFile = By.cssSelector("#buttonSubmit");
	By loadDocumentFile2 = By.xpath("//input[contains(@id,'buttonSubmit_input')]");
	By documentSuccessMessage = By.xpath("//span[@id='lblResults']");
	By btnCloseDocument = By.xpath("//div[contains(@id,'geoPopUp2')]//a[@title='Close']");
	
	//edit agreement panel
	
	By DeleteOnAgreementsPanel = By.xpath("//input[contains(@id,'gbcDeleteAlignment')]");
	By btnCancle = By.xpath("//span[text()='Cancel']");
	By btnOk = By.xpath("//span[text()='OK']");
	By btnDelete = By.xpath("(//input[contains(@id,'radYALGridControl_ctl00_ctl04_gbcDeleteAlignment')])[1]");
	By changesSavedSuccessfully = By.xpath("//span[text()='Changes saved successfully!']");
	By CollapsePanel = By.xpath("//span[text()='Participating Stakeholders']");
	
	
	
	public void clickOnAddAgreement() {
		util.waitForWebElementToBePresent(AddNewAgreement);
		util.click(AddNewAgreement);
		util.dummyWait(1);
	}
	
	public void SelectDocumentType(String value) {
   	 util.click(DocumentType);
	    	if (!commonFunction.checkNA(value))
				util.inputText(DocumentTypeFilter, value);
	    	util.dummyWait(1);
	    	util.pressDownkey();
	    	util.pressDownkey();
	    	util.pressENTERkey();
   }
	
	
	public void ClickOnParcelsLink() {
		util.waitUntilElementDisplay(LinkParcels);
		util.click(LinkParcels);
		
	}
	
//	public void selectProject(String value) {
//		util.switchToIframe(IFrame);
//		if (!commonFunction.checkNA(value))
//				util.inputTextAndPressTab(drpProjects, value);
//		}
	public void selectProject(String value) {
		util.switchToIframe(IFrame);
		if (!commonFunction.checkNA(value)) {
			util.selectValueFromDropdownCheckboxContains(drpProjects, value);
			util.waitFor(1000);
			util.click(drpProjects);	
		}
	}
	
		
	public void ClickOnGo() {
		util.waitUntilElementDisplay(BtnGo);
		util.click(BtnGo);
	}
	
//	public void selectTract(String value) {
//		if (!commonFunction.checkNA(value))
//		util.inputTextAndPressTab(drpListOfTract, value);
//	}
	public void selectTract(String value) {
		if (!commonFunction.checkNA(value)) {
			util.selectValueFromDropdownCheckboxContains(drpListOfTract, value);
			util.waitFor(1000);
			util.click(drpListOfTract);	
		}
	}
	
	
	public void ClickOnAdd() {
		util.waitUntilElementDisplay(BtnAdd);
		util.click(BtnAdd);
	}
	public void ClickOnLessessLink() {
		util.waitUntilElementDisplay(LinkLessees);
		util.click(LinkLessees);
		util.switchToIframe(IFrame);
		util.dummyWait(1);
	}
	public void Selectheckbox() {
		util.waitUntilElementDisplay(selectCheckbox);
		util.click(selectCheckbox);
	}
	public void ClickOnSave() {
	//	util.waitUntilElementDisplay(BtnSave);
		util.click(BtnSave);
		
	}
	
	public void ClickOnDocumentsLink() {
		util.waitUntilElementDisplay(LinkDocument);
		util.click(LinkDocument);
		util.switchToIframe(IFrame);
		util.dummyWait(1);
	}
	

	public void ClickOnAddDocument() {
    	util.waitUntilElementDisplay(btnAddDocuments);
    	util.click(btnAddDocuments);
      }
	public void uploadFile() {
		String filepath = System.getProperty("user.dir") + File.separator + "test.txt";
		driver.findElement(fileUpload).sendKeys(filepath);
	}

	public void selectCategory(String value) {
		if (!commonFunction.checkNA(value)) {
		if(util.isElementPresent(drpCategory)) {
			util.selectValueFromDropdown2(value, drpCategory);
		}
	}}

	By drpCategoryROWTree = By.xpath("//div[contains(@id,'rauFileUploadundefined')]");
	 
	public void selectCategoryTree(String value) {
		if (!commonFunction.checkNA(value)) {
			util.waitForWebElementToBePresent(drpCategoryROWTree);
			util.selectValueFromDropdown3(drpCategoryROWTree, value);			
		}
	}
	public void setDescription(String value) {
		if(util.isElementPresent(description)) {
			util.inputText(description, value);
		}
	}

	
	public void DeleteAgreementsPanelInfo() {
		util.waitUntilElementDisplay(DeleteOnAgreementsPanel);
		util.click(DeleteOnAgreementsPanel);
	}
	public void ClickonCancle()  {
		 util.waitUntilElementDisplay(btnCancle);
	  		util.click(btnCancle);
	    }
	 
	 
	 public void ClickonOk()  {
		    util.waitUntilElementDisplay(btnDelete);
	  		util.click(btnDelete);	
	  		 util.waitUntilElementDisplay(btnOk);
		  		util.click(btnOk);	
	  		util.waitUntilElementDisplay(changesSavedSuccessfully);
			Assert.assertTrue(util.isElementPresent(changesSavedSuccessfully), "Changes saved successfully!");
			util.dummyWait(2);
	  		
	    }
	
	
	public void AddNewRecordOnAgreementsPanel(Map<String, String> map,String TestcaseName) throws InterruptedException {
		try {
			clickOnAddAgreement();
			log("STEP 1:  User can able to click on add new record ", Status.PASS);
		} catch (Exception e) {
			log("STEP 1:  User cannot click on Add new record  ", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}
		try {
			SelectDocumentType(map.get(Excel.DocumentType));
			log("STEP 2:  User can able to select Document type ", Status.PASS);
		} catch (Exception e) {
			log("STEP 2:  User cannot select document type ", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}
		util.click(BtnInsert);
		util.dummyWait(1);
		try {
			ClickOnParcelsLink();
			log("STEP 3:  User can able to Click on parcel link ", Status.PASS);
		} catch (Exception e) {
			log("STEP 3:  User cannot click on parcel link ", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}
		try {
			selectProject(map.get(Excel.Projects));
			log("STEP 4:  User can able to select the project ", Status.PASS);
		} catch (Exception e) {
			log("STEP 4:  User cannot select the project ", Status.FAIL);
			throw new RuntimeException("Failed in step 4");
		}
		
		try {
			ClickOnGo();
			log("STEP 5:  User can able to select the Go button ", Status.PASS);
		} catch (Exception e) {
			log("STEP 5:  User cannot select go button ", Status.FAIL);
			throw new RuntimeException("Failed in step 5");
		}
		
		try {
			selectTract(map.get(Excel.Tract));
			log("STEP 6:  User can able to select the tract ", Status.PASS);
		} catch (Exception e) {
			log("STEP 6:  User cannot select the tract ", Status.FAIL);
			throw new RuntimeException("Failed in step 6");
		}
		util.click(BtnAdd);
		if(util.isElementVisible(SuccessMsg)) {
			log("STEP 7: Association created successfully", Status.PASS);
		} else {
			log("STEP 7:  Association does not  created successfully ", Status.FAIL);
			throw new RuntimeException("Failed in step 7");
		}
		util.switchToDefaultContent();
		try {
			ClickOnLessessLink();
			log("STEP 8:  User can click on Lessess Link ", Status.PASS);
		} catch (Exception e) {
			log("STEP 8:  User cannot click on Lessess Link ", Status.FAIL);
			throw new RuntimeException("Failed in step 8");
		}
		try {
			Selectheckbox();
			log("STEP 9:  User can select the checkbox ", Status.PASS);
		} catch (Exception e) {
			log("STEP 9:  User cannot select the checkbox ", Status.FAIL);
			throw new RuntimeException("Failed in step 9");
		}
		try {
			ClickOnSave();
			log("STEP 10:  User can click on save ", Status.PASS);
		} catch (Exception e) {
			log("STEP 10:  User cannot click on save button ", Status.FAIL);
			throw new RuntimeException("Failed in step 10");
		}
		if(util.isElementVisible(MsgOnLessees)) {
			log("STEP 11: Record gets added successfully", Status.PASS);
		} else {
			log("STEP 11:  Record not added successfully ", Status.FAIL);
			throw new RuntimeException("Failed in step 11");
		}	
		util.switchToDefaultContent();
		util.click(ClosePopup);
		}
	public void AddDocument(Map<String, String> map,String TestcaseName) throws InterruptedException {
		
		try {
			ClickOnDocumentsLink();
			log("STEP 1:  User can click on Documents Link ", Status.PASS);
		} catch (Exception e) {
			log("STEP 1:  User cannot click on Documents Link ", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}
		try {
			ClickOnAddDocument();
			log("STEP 2:  User can click on Add Document button ", Status.PASS);
		} catch (Exception e) {
			log("STEP 2:  User cannot click on Add Document button  ", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}
		try {
			util.waitForWebElementToBePresent(iframeDocument, IMPLICIT_WAIT);
			util.waitFor(5000);
			util.switchToIframe(iframeDocument);
			uploadFile();
			util.waitFor(2000);
			log("STEP 3: Document is uploaded", Status.PASS);
		} catch (Exception e) {
			log("STEP 3: Document is not uploaded", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}
		
		if(util.isElementPresent(drpCategory)) {
			try {
				util.dummyWait(10);
				 util.click(drpCategory);
				selectCategory(map.get(Excel.DocCategory));
				log("STEP 8: User can select the document category", Status.PASS);
			} catch (Exception e) {
				log("STEP 8: User cannot select the document category", Status.FAIL);
				throw new RuntimeException("Failed in step 8");
			}
			}else {
			try {
				util.dummyWait(10);
				selectCategoryTree(map.get(Excel.DocCategory));
				log("STEP 8: User can select the document category", Status.PASS);
			} catch (Exception e) {
				log("STEP 8: User cannot select the document category", Status.FAIL);
				throw new RuntimeException("Failed in step 8");
			}
			}
			try {
				setDescription(map.get(Excel.DocComments));
				log("STEP 9: User can enter the description of document", Status.PASS);
			} catch (Exception e) {
				log("STEP 9: User cannot enter the description of document", Status.FAIL);
				throw new RuntimeException("Failed in step 9");
			}

			try {
				if (util.isElementPresent(loadDocumentFile)) {
					util.click(loadDocumentFile);
				} else if (util.isElementPresent(loadDocumentFile2)) {
					util.click(loadDocumentFile2);
				}
				
				log("STEP 10: User can close the Add Document pop up", Status.PASS);
			} catch (Exception e) {
				log("STEP 10: User cannot close the Add Document pop up", Status.FAIL);
				throw new RuntimeException("Failed in step 10");
			}
			
			try {
				util.waitUntilElementDisplay(documentSuccessMessage);
				String msg = util.getText(documentSuccessMessage);
				Assert.assertEquals(msg, "Loaded: test.txt", "Success message is mismatch");
				log("STEP 11: User can see sucess Message", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 11: User cannot see sucess Message", Status.FAIL);
			}
			ExtentTestManager.infoWithScreenshot("Document Popup");
			util.switchToDefaultContent();
			util.dummyWait(1);
			util.click(btnCloseDocument);
		
		}
	public void DeleteAgreementsPanelInformation() {
		try {
			DeleteAgreementsPanelInfo();
			log("STEP 1:  User can able to click on delete icon ", Status.PASS);
		} catch (Exception e) {
			log("STEP 1:  User cannot click on delete icon ", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}
		
		 try {
			 ClickonCancle();
				log("STEP 2: User can click on cancel button  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 2: User cannot click on cancel button", Status.FAIL);
				throw new RuntimeException("Failed in step 2 ");
			}
		 
		 try {
			 ClickonOk();
				log("STEP 3: Deleted record does not display in the grid and Message- Changes saved suessfully! in green colour displays. ", Status.PASS);
			} catch (Exception e) {
				log("STEP 3: Message- Changes saved sucessfully' does not display", Status.FAIL);
				throw new RuntimeException("Failed in step 3 ");
			}
		
		 util.dummyWait(2);
			if (util.isElementPresent(By.xpath("//span[contains(@id,'_grdNPContacts_usrMessage')]"))) {
				log("STEP 4: Parcel is added successfully", Status.PASS);
			} else {
				log("STEP 4: Parcel is not added sucessfully ", Status.FAIL);
				throw new RuntimeException("Failed in step 4");
			}
            util.click(CollapsePanel);
	}
	
	
	
	}
	
	
