package pages.AdministrationTemplate;

import java.io.File;
import java.util.Iterator;
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

public class EditNewTemplatePage extends BasePage{
	
	TestUtil util;
	CommonFunction commonFunction;
	AddNewTemplatePage template;
	public String TEMPLATE_NAME;

	public EditNewTemplatePage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		template = new AddNewTemplatePage(driver);
	}
	
	By btnEdit = By.xpath("(//input[contains(@id,'EditButton')])[last()]");
	By VerifyDocumnetName = By.xpath("//input[contains(@id,'txtDocName')and @type='text']");
	By drpCategory = By.xpath("(//input[contains(@id,'CATEGORY_radYALDropDownList_Input') and @type='text'])");
	By SelectCategoryDOT = By.xpath("(//span[contains(@class,'rddtFakeInput')])[1]");
	By txtCategory = By.xpath("(//input[contains(@class,'radPreventDecorate') and @value='Filtering...'])[1]");
	By txtDisplayName = By.xpath("//input[contains(@id,'DisplayName') and @type='text']");
    By ScreenOption = By.xpath("(//input[contains(@class,'rlbCheck') and @type='checkbox'])[3]");
    By GlobalRadiobtn = By.xpath("//label[contains(text(),'Global')]");
    By btnUpdate = By.xpath("(//input[contains(@id,'btnUpdate') and @type='submit'])");
    By btnCancel = By.xpath("(//input[contains(@id,'btnCancel') and @type='submit'])");
    By ClientRadiobtn = By.xpath("(//input[contains(@id,'EditFormControl_chkClient')])");
    By ProjectRadiobtn = By.xpath("(//input[contains(@id,'EditFormControl_chkProjectScope')])");
    By ActiveCheckbox = By.xpath("//input[contains(@id,'EditFormControl_chkActive') and @type='checkbox']");
    By btnUpdateTemplate = By.xpath("//input[contains(@id,'EditFormControl_lnkUpdateTemplate') and @type='image']");
    By btnUpdateTemplateDot = By.xpath("//input[contains(@id,'btnUploadTemplate') and @type='submit']");
    By btnUploadDocument = By.xpath("//input[@id='btnSave']");
	By PreviewDocumentDOT = By.xpath("//input[contains(@id,'EditFormControl_btnPreviewDocument') and @type='submit']");
	By PreviewDocument = By.xpath("//input[contains(@id,'EditFormControl_lnkPreview') and @type='image']");
	By SuccessMessage = By.xpath("//span[text()='Changes saved successfully!']");
	public void ClickOnEditButton() {
		util.waitUntilElementDisplay(btnEdit);
		util.click(btnEdit);
		util.dummyWait(1);
	}
	
	
	   public void getDocumentName() {
			String DocumentName = util.getText(VerifyDocumnetName);
			log("Doc name should be visible with filename.format :" + DocumentName);
		}
	   
	   public void AddDisplayName(String value) {
			if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtDisplayName, value);
		}
	  
       By fileUpload = By.xpath("//input[contains(@id,'RadUpload1file0')]");
		public void uploadFile() {
			util.dummyWait(1);
			String filepath = System.getProperty("user.dir") + File.separator + "1_Docusign Demo.docx";
			driver.findElement(fileUpload).sendKeys(filepath);
		}
		
		public void SelectCategory(String value) {
			if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(drpCategory, value);
		}
		
		public void SelectCategoryDOT(String value) {
            util.click(SelectCategoryDOT);
			if (!commonFunction.checkNA(value))
				util.inputText(txtCategory, value);
			util.pressDownkey();
			util.pressENTERkey();
		}
		
		public void SelectScreenOption() {
			util.waitUntilElementDisplay(ScreenOption);
			util.click(ScreenOption);
		}
		
		
		public void ClickOnGlobalRadioButton() {
			util.waitUntilElementDisplay(GlobalRadiobtn);
			util.click(GlobalRadiobtn);
		}
		
		public void ClickOnUpdateButton() {
			util.waitUntilElementDisplay(btnUpdate);
			util.click(btnUpdate);
			util.dummyWait(2);
		}
		
		public void ClickOnCancelButton() {
			util.waitUntilElementDisplay(btnEdit);
			util.click(btnEdit);
			util.dummyWait(2);
			util.waitUntilElementDisplay(btnCancel);
			util.click(btnCancel);
			util.dummyWait(1);
		}
		
		public void ClickOnClientCheckbox() {
			util.dummyWait(1);
			util.waitUntilElementDisplay(ClientRadiobtn);
			util.click(ClientRadiobtn);
			util.dummyWait(1);
		}
		
		public void ClickOnProjectCheckbox() {
			util.waitUntilElementDisplay(ProjectRadiobtn);
			util.click(ProjectRadiobtn);
		}
		
		public void ClickOnActiveCheckbox() {
			util.waitUntilElementDisplay(ActiveCheckbox);
			util.click(ActiveCheckbox);
			util.click(ActiveCheckbox);
			util.dummyWait(2);

		}
		
		By btnUpload = By.xpath("//input[@id='btnSave']"); 
		public void ClickOnUpdateTemplates() {
			util.waitUntilElementDisplay(btnUpdateTemplate);
		    util.click(btnUpdateTemplate);
		    util.dummyWait(3);
			Set<String> windowId = driver.getWindowHandles(); // get window id of current window
			Iterator<String> itererator = windowId.iterator();
			String mainWinID = itererator.next();
			String newAdwinID = itererator.next();
			driver.switchTo().window(newAdwinID);
			util.dummyWait(1);
			String filepath = System.getProperty("user.dir") + File.separator + "1_Docusign Demo.docx";
			driver.findElement(fileUpload).sendKeys(filepath);
			util.dummyWait(1);
			util.click(btnUpload);
			util.dummyWait(1);
			driver.close();
			driver.switchTo().window(mainWinID);
			util.dummyWait(2);
			
		}
		
		public void ClickOnUpdateTemplateDOT() {
			util.waitUntilElementDisplay(btnUpdateTemplateDot);
		    util.click(btnUpdateTemplateDot);
		    util.dummyWait(3);
			Set<String> windowId = driver.getWindowHandles(); // get window id of current window
			Iterator<String> itererator = windowId.iterator();
			String mainWinID = itererator.next();
			String newAdwinID = itererator.next();
			driver.switchTo().window(newAdwinID);
			util.dummyWait(1);
			String filepath = System.getProperty("user.dir") + File.separator + "1_Docusign Demo.docx";
			driver.findElement(fileUpload).sendKeys(filepath);
			util.click(btnUpload);
			util.dummyWait(1);
			driver.close();
			driver.switchTo().window(mainWinID);
			util.dummyWait(2);
		}
		
		
	public void ClickOnPreviewDocumentDOT() {
		util.waitUntilElementDisplay(PreviewDocumentDOT);
	    util.click(PreviewDocumentDOT);
	}
	
	public void ClickOnPreviewDocument() {
		util.waitUntilElementDisplay(PreviewDocument);
	    util.click(PreviewDocument);
	}
		
	By drpProject = By.xpath("//input[@id='ddlProject_radYALDropDownList_Input']");
	By LoadTract = By.xpath("//input[@id='btnLoadImportTracts']");
	By GenerateDocument = By.xpath("//input[@id='btnGenDoc']");
		
	public void SelectProject(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpProject, value);
	}
	
	public void ClickOnLoadTract() {
		util.waitUntilElementDisplay(LoadTract);
		util.click(LoadTract);
	}
	
	By Checkbox = By.xpath("(//input[contains(@id,'rblTracts')])[1]");
    public void SelectTractCheckbox() {
    	util.waitUntilElementDisplay(Checkbox);
    	util.click(Checkbox);
    }
	
	
	public void ClickOnGenerateDocument() {
		util.waitUntilElementDisplay(GenerateDocument);
		util.click(GenerateDocument);
	}
	
	public void setPagesize(){
		By pagesize = By.xpath("(//input[contains(@id,'ctl00_ConPHRightTop_YALTemplates1_DOCUMENT_radYALGridControl_ctl00_ctl03_ctl01_PageSizeComboBox')])[1]");
		System.out.println("");
		By pageSize50 = By.xpath("//div[contains(@id,'ctl00_ConPHRightTop_YALTemplates1_DOCUMENT_radYALGridControl_ctl00_ctl03_ctl01_PageSizeComboBox')]/div/ul/li[3]");
		if(util.isElementPresent(pagesize)){
			util.click(pagesize);
			util.click(pageSize50);
//			util.pressDownkey();
//			util.pressDownkey();
//			util.pressENTERkey();
		}
		else{
			System.out.println("Page Size option not shows");
		}
		
	}
	
	public void sortingAsPerDateAdded(){
		By linkDateAdded = By.xpath("//table[contains(@id,'_DOCUMENT_radYALGridControl_')]/..//a[text()='Date Added' or contains(text(),'Date_Added')]");
		if(util.isElementVisible(linkDateAdded)) {
		util.click(linkDateAdded);
		util.waitFor(1000);
		util.click(linkDateAdded);
		}
	}
	
	 public void EditNewTemplate(Map<String, String> map, String testcaseName) {
		 sortingAsPerDateAdded();
			util.dummyWait(5);
			try {
				By edit = By.xpath("//tr[contains(@id,'YALTemplates1_DOCUMENT_radYALGridControl')]/..//*[text()='"+template.templateName+"']/..//*[@title='Edit']");
				util.click(edit);
				getDocumentName();
				log("STEP 1: Doc name should be visible with filename.format  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 1: Doc name will be blank.", Status.FAIL);
				throw new RuntimeException("Failed in step 1: ");
			}

			try {
				TEMPLATE_NAME=map.get(Excel.DisplayName)+util.randomNumber(3);
				AddDisplayName(TEMPLATE_NAME);
				
				log("STEP 2: Enter value in Display Name  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 2: User is unable to enter value. ", Status.FAIL);
				throw new RuntimeException("Failed in step 2");
			}
			
			if(util.isElementVisible(SelectCategoryDOT)) {
			try {
				SelectCategoryDOT(map.get(Excel.Category));
				log("STEP 3: User can select value from Category dd  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 3: User cannot select value from Category dd ", Status.FAIL);
				throw new RuntimeException("Failed in step 3");
			}
		}
			else {
				try {
					SelectCategory(map.get(Excel.Category));
					log("STEP 3: User can select value from Category dd  ", Status.PASS);
				} catch (Exception e) {
					log("STEP 3: User cannot select value from Category dd ", Status.FAIL);
					throw new RuntimeException("Failed in step 3");
				}
			}
			
			util.waitFor(200);
			if(testcaseName.contains("DOT")) {
			try {
				ClickOnUpdateTemplateDOT();
				log("STEP 4: User can upload new template.  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 4: User cannot upload new template.  ", Status.FAIL);
				throw new RuntimeException("Failed in step 4");
			}
		}
			else {
				try {
					ClickOnUpdateTemplates();
					log("STEP 4: User can upload new template.   ", Status.PASS);
				} catch (Exception e) {
					log("STEP 4: User cannot upload new template.  ", Status.FAIL);
					throw new RuntimeException("Failed in step 4");
				}
			}
			
			if(testcaseName.contains("DOT")) {
			try {
				ClickOnPreviewDocumentDOT();
				log("STEP 5: User can click on preview document button ", Status.PASS);
			} catch (Exception e) {
				log("STEP 5: User  cannot click on  preview document button.", Status.FAIL);
				throw new RuntimeException("Failed in step 5");
			}
		}
			else {
				try {
					ClickOnPreviewDocument();
					log("STEP 6: User can click on preview document button  ", Status.PASS);
				} catch (Exception e) {
					log("STEP 6: User  cannot click on  preview document button. ", Status.FAIL);
					throw new RuntimeException("Failed in step 6");
				}
			}
			
			util.dummyWait(2);
			Set<String> windowId = driver.getWindowHandles(); // get window id of current window
			Iterator<String> itererator = windowId.iterator();
			String mainWinID = itererator.next();
			String newAdwinID = itererator.next();
			driver.switchTo().window(newAdwinID);
			
			try {
				SelectProject(map.get(Excel.Project));
				log("STEP 7: Enter value in Project DD  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 7: User is unable to enter Project DD. ", Status.FAIL);
				throw new RuntimeException("Failed in step 7");
			}
			
			try {
				ClickOnLoadTract();
				log("STEP 8: User can click on load tract button. ", Status.PASS);
			} catch (Exception e) {
				log("STEP 8: user cannot click on load tract ", Status.FAIL);
				throw new RuntimeException("Failed in step 8");
			}
			
			try {
				SelectTractCheckbox();
				util.dummyWait(1);
				ClickOnGenerateDocument();
				log("STEP 9: User can click on generate document button.  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 9: User  cannot click on generate document button. ", Status.FAIL);
				throw new RuntimeException("Failed in step 9");
			}
			
			util.dummyWait(1);
			driver.close();
			driver.switchTo().window(mainWinID);
			util.dummyWait(2);
			try {
				ClickOnUpdateButton();
				log("STEP 10:  User can update  sucessfully.    ", Status.PASS);
			} catch (Exception e) {
				log("STEP 10: User is unable to update.  ", Status.FAIL);
				throw new RuntimeException("Failed in step 10");
			}
			
			try {
//				ClickOnViewDocument();
				Assert.assertTrue(util.isElementVisible(ViewDocument));
//				util.dummyWait(1);
				log("STEP 11: On grid view document link will be displayed.  ", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 11: user is unable to see view document link.", Status.FAIL);
				throw new RuntimeException("Failed in step 11");
			}
	 }

	 By ViewDocument = By.xpath("(//a[text()='View Document'])[1]");
	 
	 public  void ClickOnViewDocument() {
		 util.waitUntilElementDisplay(ViewDocument);
		 util.click(ViewDocument);
	 }
	
	 
	    By loaderIcon = By.xpath("//body/div[contains(@id,'Ajax')]");
	    By navProject = By.xpath("//span[text()='Project']");
		By navProjectInfo = By.xpath("//span[contains(text(),'Project Information')]");
		By navDocumentManagement = By.xpath("(//span[text()='Document Management'])[1] | (//span[text()='Project Documents'])[1]");
		By expandDocument = By.xpath("//*[text()='Document Generation']/..//span[@class='rdExpand']");
		By drpTemplate  = By.xpath("//select[contains(@id,'_listTemplate1')]");
		By adobePDFRadio = By.xpath("//input[contains(@id,'DocGen_rbPdf')]");
		By generateDocumentButton = By.xpath("//input[contains(@id,'DocGen_btnSubmit')]");
	 
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
				util.waitFor(10000);
				util.waitUntilElementDisappear(loaderIcon);
			}
		}
	 
	 private void clickOnPDFRadioButton() {
			util.click(adobePDFRadio);
		}
	 
	 private void clickOnGenerateDocumentButton() {
			util.click(generateDocumentButton);
			util.waitUntilElementDisappear(loaderIcon);
		}
	 
	
	 public void verifyAsPerScreeningOption(String testcaseName) {
			try {
				nevigateToDocumentManagement();
				log("STEP 1: User can Navigate to Project Details ", Status.PASS);
			} catch (Exception e) {
				log("STEP 1: User cannot Navigate to Project Details", Status.FAIL);
				throw new RuntimeException("Failed in step 1");
			}
			
			try {
				ExpandsDocuments();
				log("STEP 2: User can Expand document generation panel", Status.PASS);
			} catch (Exception e) {
				log("STEP 2: User cannot Expand document generation panel", Status.FAIL);
				throw new RuntimeException("Failed in step 2");
			}
			
				try {
				selectTemplate(TEMPLATE_NAME);
				log("STEP 3: User can select template from the dd", Status.PASS);
			} catch (Exception e) {
				log("STEP 3: User cannot select template from the dd", Status.FAIL);
				throw new RuntimeException("Failed in step 3");
			}
			
			try {
				clickOnPDFRadioButton();
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
	 }
}
