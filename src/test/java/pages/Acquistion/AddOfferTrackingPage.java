package pages.Acquistion;

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

public class AddOfferTrackingPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;
	public static String AGREEMENT_NUMBER;

	public AddOfferTrackingPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	
	By navOfferTracking = By.xpath("//span[contains(text(),'Offer Tracking')] | //span[text()='Projected Offers']");
	By btnAddNew = By.xpath("//input[contains(@id,'_btnAddPMObligation') and @type='image']");
	By iframeAddOffer = By.xpath("//iframe[@name='AddOffers']");
	By txtOfferDate = By.xpath("//input[contains(@id,'dp_Offer_Date_dateInput') and @type='text']");
	By drpOfferType = By.xpath("//input[contains(@id,'ddOfferType_radYALDropDownList_Input') and @type='text']");
	By drpStatus = By.xpath("//input[contains(@id,'ddStatus_radYALDropDownList_Input')]");
	By txtAssocAgreement = By.xpath("//input[contains(@id,'Agreement_IDs_YALComboBox_Input')]");
	By txtAcquisitionPaymentComment = By.xpath("//textarea[@id='rptCompensation_ctl01_Comment']");
	By txtAcquisitionPaymentArea = By.xpath("//input[contains(@id,'rptCompensation_ctl01_Area') and @type='text']");
	By drpAcquisitionPaymentUnit = By.xpath("//input[contains(@id,'rptCompensation_ctl01_Unit_ID_radYALDropDownList_Input') and @type='text']");
	By txtAcquisitionPaymentCostperUnit =
			By.xpath("//input[contains(@id,'rptCompensation_ctl01_Cost_Per_Unit') and @type='text']");
	By AcquisitionPaymentTaxableCheckbox =
			By.xpath("//input[@id='rptCompensation_ctl01_Taxable']");
	By btnSave = By.xpath("//input[@id='btnSave1']");
	By changesSavedSuccessfully = By.xpath("//span[@id='ctl00_ConPHRightTop_TRAT_UC_radPanels_i2_i0_OFFERDETAILS_usrMessage']");
	By btnClose = By.xpath("//a[@class='rwCloseButton']");
    By linkEditOffer = By.xpath("//a[contains(text(),'Edit Offer')]");
    By linkViewHistory = By.xpath("//a[contains(text(),'View History')]");
    By iframeViewHistory = By.xpath("//iframe[@name='ViewHistory']");
    By ValidateStatus = By.xpath("//span[text()='Status:']");
    By Details = By.xpath("//div[@id='Offers_Details_radYALGridControl']");
    By btnCloseHistory = By.xpath("(//a[@class='rwCloseButton'])[1]");
    By linkViewEditDocument = By.xpath("//a[contains(text(),'View/Edit Document')]");
    By iframeDocument = By.xpath("//iframe[@name='ViewEditDocument']");
    By btnAddDocument = By.xpath("//input[contains(@id,'btnAdddocuments') and @type='image']");
    By iframeAddDocument = By.xpath("//iframe[@name='AddDocuments']");
	By btnSelectDocumnet = By.xpath("//span[contains(text(),'Select')]");
	By drpCategory = By.xpath("//select[@id='RadPanelBar1_i0_i0_rauFileUploadCategoryDD0']");
	By txtDescription = By.xpath("//input[contains(@id,'RadPanelBar1_i0_i0_rauFileUploadDesc0') and @type='Text']"); 
	By btnLoadDocuments = By.xpath("//input[contains(@id,'buttonSubmit_input') and @type='submit'] | //input[contains(@id,'buttonSubmit_input') and @type='button']");
    By message = By.xpath("//span[@id='lblResults']");
    By btnCloseDocuments = By.xpath("//a[@class='rwCloseButton']");
    By btnDelete = By.xpath("//input[contains(@id,'_gbcDeleteAlignment') and @type='image']");
    By iframeDelete = By.xpath("//td[@class='rwWindowContent']");
    By btnOk = By.xpath("//span[text()='OK']");
    By btnDownloadAll = By.xpath("//input[@id='btnDownloadAll']");
    By btnCloseAll = By.xpath("(//a[@class='rwCloseButton'])[1]");
	
    public void ClickonAddNewButton() {
    	util.waitUntilElementDisplay(navOfferTracking);
    	util.click(navOfferTracking);
    	util.waitUntilElementDisplay(btnAddNew);
    	util.click(btnAddNew);
    }
    
    public void AddOfferDate(String value) {
    	util.switchToIframe(iframeAddOffer);
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtOfferDate, value);	
    }
    
    public void AddOfferType(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpOfferType, value);	
    }
    
    public void SelectStatus(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpStatus, value);	
    }
    
    public void AddAssocAgreement(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtAssocAgreement, value);	
    }
    
    public void AddAcquisitionPaymentComment(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtAcquisitionPaymentComment, value);	
    }
    
    public void AddAcquisitionPaymentArea(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtAcquisitionPaymentArea, value);	
    }
    
    public void SelectAcquisitionPaymentUnit(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpAcquisitionPaymentUnit, value);	
    }
    
    public void AddAcquisitionPaymentCostperUnit(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtAcquisitionPaymentCostperUnit, value);	
    }
    
    public void ClickonTaxableCheckbox() {
    	util.click(AcquisitionPaymentTaxableCheckbox);
    }
    
    public void ClickonSave() {
    	util.waitUntilElementDisplay(btnSave);
    	util.click(btnSave);
    	
    	}
    
    public void ClickonClose() {
    	util.switchToDefaultContent();
    	util.waitUntilElementDisplay(btnClose);
    	util.click(btnClose);
    }
    
    public void ClickonEditOfferLink(String value) {
    	util.dummyWait(2);
    	util.waitUntilElementDisplay(linkEditOffer);
    	util.click(linkEditOffer);
    	Set<String> windowId = driver.getWindowHandles(); // get window id of current window
		Iterator<String> itererator = windowId.iterator();
		String mainWinID = itererator.next();
		String newAdwinID = itererator.next();
		driver.switchTo().window(newAdwinID);	
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtAcquisitionPaymentCostperUnit, value);	
    	util.dummyWait(2);
    	util.waitUntilElementDisplay(btnSave);
    	util.click(btnSave);
    	driver.close();
    	 driver.switchTo().window(mainWinID);
    }
    
    public void ClickonViewHistoryLink() {
    	util.dummyWait(2);
    	util.waitUntilElementDisplay(linkViewHistory);
    	util.click(linkViewHistory);
    	util.dummyWait(2);
    	util.switchToIframe(iframeViewHistory);
    	util.dummyWait(2);
    	Assert.assertTrue(util.isElementPresent(ValidateStatus), "Status:");
    	//Assert.assertTrue(util.isElementPresent(Details));
    	util.dummyWait(2);
    	util.switchToDefaultContent();
    	util.click(btnCloseHistory);

    }
    
    public void ClickonViewEditDocumentLink() {
    	util.waitUntilElementDisplay(linkViewEditDocument);
    	util.click(linkViewEditDocument);
    }
    
    public void ClickonAddDocumentButton() {
    	util.switchToIframe(iframeDocument);
    	util.waitUntilElementDisplay(btnAddDocument);
    	util.click(btnAddDocument);
    }
    
    By fileUpload = By.xpath("//input[contains(@id,'FileUploadfile')]");
    public void UploadDocument() {
    	util.switchToIframe(iframeAddDocument);
    	util.dummyWait(5);
    	String filepath = System.getProperty("user.dir") + File.separator + "test.txt";
		driver.findElement(fileUpload).sendKeys(filepath);
    }
    
    By drpCategoryROWTree = By.xpath("//div[contains(@id,'rauFileUploadundefined')]");
    
    public void selectCategoryTree(String value) {
		if (!commonFunction.checkNA(value)) {
			util.waitForWebElementToBePresent(drpCategoryROWTree);
			util.selectValueFromDropdown3(drpCategoryROWTree, value);			
		}
	}
    
    By drpCategoryExtDoc = By.xpath("//select[contains(@id,'_rauFileUploadcategory')] | //select[contains(@id,'_rauFileUploadCategory')]");
    
    public void selectCategoryROW(String value) {
		if (util.isElementPresent(drpCategoryExtDoc)) {
			util.selectValueFromDropdown2(value, drpCategoryExtDoc);
		}
	}
    
    By description = By.xpath("//input[contains(@id,'RadUpload1Desc') or contains(@id,'rauFileUploadDesc')] ");
    public void setDescription(String value) {
			if (util.isElementPresent(description)) {
				util.inputText(description, value);
			}
		}
    public void SelectCategory(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpCategory, value);
		
    }
    
    public void AddDescription(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtDescription, value);
		
    }
    
    public void LoadDocuments() {
    	util.click(btnLoadDocuments);	
		Assert.assertTrue(util.isElementPresent(message));

    }
    
    public void ClickonCloseDocument() {
    	util.switchToDefaultContent();
    	util.waitUntilElementDisplay(btnCloseDocuments);
    	util.click(btnCloseDocuments);
    	util.waitUntilElementDisplay(changesSavedSuccessfully);
    	Assert.assertTrue(util.isElementPresent(changesSavedSuccessfully), "Changes saved successfully!");
    }
    
    public void ClickonDelete() {
    //	util.switchToIframe(iframeDocument);
    	util.waitUntilElementDisplay(btnDelete);
    	util.click(btnDelete);
    	
    }
    
    public void ClickonOk() {
    	//util.switchToIframe(iframeDelete);
    	util.waitUntilElementDisplay(btnOk);
    	util.click(btnOk);
    	util.dummyWait(2);
    	util.waitUntilElementDisplay(changesSavedSuccessfully);
		Assert.assertTrue(util.isElementPresent(changesSavedSuccessfully), "Changes saved successfully!");
    	util.dummyWait(1);
    	util.click(navOfferTracking);
    	util.dummyWait(3);
    }
    
//    public void ClickonDownloadAll() {
//    	util.waitUntilElementDisplay(btnDownloadAll);
//    	util.click(btnDownloadAll);	
//    }
    
    public void AddOfferTracking(Map<String, String> map, String testcaseName) {
    	if (testcaseName.contains("DOT") || testcaseName.contains("ALT") || testcaseName.contains("ORSTED") || testcaseName.contains("ORION") || testcaseName.contains("ATWELL")) {
			log(" Add Offer Tracking not applicable for DOT and ALT", Status.SKIP);
		}
		else {
    	
    	try {
    		ClickonAddNewButton();
			log("STEP 1:  The '/rowAMPS_PIPE/Common/AddOffers.aspx' popup displays with fields  ", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: The panel does not expand  ", Status.FAIL);
			throw new RuntimeException("Failed in step 1 ");
		}
    
    	 try {
    		 AddOfferDate(map.get(Excel.OfferDate));
 			log("STEP 2:  User can enter a value in OfferDate field ", Status.PASS);
 		 } catch (Exception e) {
 			log("STEP 2: User cannot add a value in OfferDate field  ", Status.FAIL);
 			throw new RuntimeException("Failed in step 2");
 		 }
    	 
    	 try {
    		 AddOfferType(map.get(Excel.OfferType));
 			log("STEP 3: Value added display in OfferType field ", Status.PASS);
 		 } catch (Exception e) {
 			log("STEP 3: Added value does not display in OfferType field. ", Status.FAIL);
 			throw new RuntimeException("Failed in step 3");
 		 }
    	
    	 try {
    		 SelectStatus(map.get(Excel.Status));
 			log("STEP 4: added value display in the Status field  ", Status.PASS);
 		 } catch (Exception e) {
 			log("STEP 4: added  value does not displayed in Status field. ", Status.FAIL);
 			throw new RuntimeException("Failed in step 4");
 		 }
    	
    	 try {
    		 AddAssocAgreement(map.get(Excel.AssocAgreement));
 			log("STEP 5: Value added display in AssocAgreement field  ", Status.PASS);
 		 } catch (Exception e) {
 			log("STEP 5: No value displays in AssocAgreement Dropdown. ", Status.FAIL);
 			throw new RuntimeException("Failed in step 5");
 		 }
    	
    	 try {
    		 AddAcquisitionPaymentComment(map.get(Excel.AcquisitionPaymentComment));
 			log("STEP 6: added value display in the comment field ", Status.PASS);
 		 } catch (Exception e) {
 			log("STEP 6: added  value does not displayed in the field. ", Status.FAIL);
 			throw new RuntimeException("Failed in step 6");
 		 }
    	
    	 if(util.isElementPresent(txtAcquisitionPaymentArea)) {
    	 try {
    		 AddAcquisitionPaymentArea(map.get(Excel.AcquisitionPaymentArea));
 			log("STEP 7: added value display in the Area field ", Status.PASS);
 		 } catch (Exception e) {
 			log("STEP 7: added  value does not displayed in the field.  ", Status.FAIL);
 			throw new RuntimeException("Failed in step 7");
 		 }
    	 }
    	 
    	 if(util.isElementPresent(drpAcquisitionPaymentUnit)) {
    	
    	 try {
    		 SelectAcquisitionPaymentUnit(map.get(Excel.AcquisitionPaymentUnit));
 			log("STEP 8: Value added display in Acquisition Payment Unit field    ", Status.PASS);
 		 } catch (Exception e) {
 			log("STEP 8: added  value does not displayed in the field. ", Status.FAIL);
 			throw new RuntimeException("Failed in step 8");
 		 }
    	 }
    	
    	 try {
    		 AddAcquisitionPaymentCostperUnit(map.get(Excel.AcquisitionPaymentCostperUnit));
 			log("STEP 9: added value display in the Acquisition Payment Cost per Unit field  ", Status.PASS);
 		 } catch (Exception e) {
 			log("STEP 9: added  value does not displayed in the field. ", Status.FAIL);
 			throw new RuntimeException("Failed in step 9");
 		 }
    	
    	 if(util.isElementVisible(AcquisitionPaymentTaxableCheckbox)) {
    	 try {
    		 ClickonTaxableCheckbox();
 			log("STEP 10:  User can check Taxable checkbox.  ", Status.PASS);
 		 } catch (Exception e) {
 			log("STEP 10: User cannot check Taxable checkbox.  ", Status.FAIL);
 			throw new RuntimeException("Failed in step 10");
 		 }
    	 }
    	
    	 try {
    		 ClickonSave();
 			log("STEP 11: 'User can click on Save button", Status.PASS);
 		 } catch (Exception e) {
 			log("STEP 11: 'User cannot click on Save button", Status.FAIL);
 			throw new RuntimeException("Failed in step 11");
 		 }
    	
    	 try {
    		 ClickonClose();
 			log("STEP 12:  User can close the popup  ", Status.PASS);
 		 } catch (Exception e) {
 			log("STEP 12: User cannot close the popup  ", Status.FAIL);
 			throw new RuntimeException("Failed in step 12");
 		 }
    	
    	 util.dummyWait(5);
    	 try {
    		 ClickonEditOfferLink(map.get(Excel.AcquisitionPaymentCostperUnit));
 			log("STEP 13: User can update the record  ", Status.PASS);
 		 } catch (Exception e) {
 			log("STEP 13: User cannot update the record", Status.FAIL);
 			throw new RuntimeException("Failed in step 13");
 		 }
    	 util.dummyWait(2);
    	
    	 try {
    		 ClickonViewHistoryLink();
 			log("STEP 14: User can click on View History link", Status.PASS);
 		 } catch (Exception e) {
 			log("STEP 14: User cannot click on View History link ", Status.FAIL);
 			throw new RuntimeException("Failed in step 14");
 		 }
    	 util.dummyWait(2);
    	 try {
    		 ClickonViewEditDocumentLink();
 			log("STEP 15: User can click on Document link ", Status.PASS);
 		 } catch (Exception e) {
 			log("STEP 15: User cannot click on Document link ", Status.FAIL);
 			throw new RuntimeException("Failed in step 15");
 		 }
    	
    	 try {
    		 ClickonAddDocumentButton();
 			log("STEP 16: User can click on Add Document button ", Status.PASS);
 		 } catch (Exception e) {
 			log("STEP 16: User cannot click on Add Document button ", Status.FAIL);
 			throw new RuntimeException("Failed in step 16");
 		 }
    	
    	
    	 try {
    		 UploadDocument();
 			log("STEP 17: User can upload document from the system  ", Status.PASS);
 		 } catch (Exception e) {
 			 ExtentTestManager.infoWithScreenshot("Document does not upload");
 			ClickonClose();
 			log("STEP 17: User cannot upload a document ", Status.FAIL);
 			throw new RuntimeException("Failed in step 17");
 		 }
    	
    	 if(util.isElementPresent(drpCategoryROWTree)) {
	   			try {
	   				selectCategoryTree(map.get(Excel.Category));
	   				log("STEP 18:  User can select Category", Status.PASS);
	   			} catch (Exception e) {
	   				log("STEP 18:  User can not select Category", Status.FAIL);
	   				throw new RuntimeException("STEP 18:  User can not select Category");
	   			}
	   		}else {
	   		try {
	   			selectCategoryROW(map.get(Excel.Category));
	   			log("STEP 18:  User can select Category", Status.PASS);
	   		} catch (Exception e) {
	   			log("STEP 18:  User can not select Category", Status.FAIL);
	   			throw new RuntimeException("STEP 18:  User can not select Category");
	   		}
	   		}
		    	 
	    		try {
	   			setDescription(map.get(Excel.Description));
	   			log("STEP 19: User can enter Description", Status.PASS);
	   		} catch (Exception e) {
	   			log("STEP 19: User cannot enter Description", Status.FAIL);
	   			throw new RuntimeException("Failed in step 19");
	   		}

    	 try {
    		 LoadDocuments();
 			log("STEP 20:User can click on Load Documents button", Status.PASS);
 		 } catch (Exception e) {
 			log("STEP 20: User cannot click on Load Documents button ", Status.FAIL);
 			throw new RuntimeException("Failed in step 20");
 		 }
    	 
    	 
    	 try {
    		 ClickonClose();
 			log("STEP 21: USer can close the document popup ", Status.PASS);
 		 } catch (Exception e) {
 			log("STEP 21:  USer cannot close the document popup", Status.FAIL);
 			throw new RuntimeException("Failed in step 21");
 		 }
    	util.dummyWait(5);
    	 try {
    		 ClickonDelete();
 			log("STEP 22: User can click on Delete", Status.PASS);
 		 } catch (Exception e) {
 			log("STEP 22: User cannot click on Delete", Status.FAIL);
 			throw new RuntimeException("Failed in step 22");
 		 }
    	 
    	 try {
    		 ClickonOk();
 			log("STEP 23: User can click on ok ", Status.PASS);
 		 } catch (Exception e) {
 			log("STEP 23: User cannot click on ok ", Status.FAIL);
 			throw new RuntimeException("Failed in step 23");
 		 }
    	
		}
    }
}
