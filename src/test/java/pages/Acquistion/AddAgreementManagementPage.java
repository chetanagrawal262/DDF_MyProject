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

public class AddAgreementManagementPage extends BasePage{

	
	TestUtil util;
	CommonFunction commonFunction;
	public static String DOCUMENT_TYPE;

	public AddAgreementManagementPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		
	}
	
	By navAgreementManagement = By.xpath("//span[text()='Agreement Management']");
	By btnAddNew = By.xpath("//img[contains(@id,'YALAGREEMENTMANAGEMENT_New_radYALGridControl_ctl00_ctl02_ctl00_Img4')]");
	By drpDocumentType =By.xpath("(//span[@class='rddtFakeInput'])[2]");
	By SelectDocumentType = By.xpath("(//span[@class='rtIn'])[2]");
	By SelectDocumentTypeAvangrid = By.xpath("(//span[@class='rtIn'])[1]");
	By txtDateExecuted = By.xpath("//input[contains(@id,'_DATE_EXECUTED_dateInput') and @type='text']");
	By LeaseSetupCheckbox = By.xpath("//input[contains(@id,'_EditFormControl_recurring_payment_flag') and @type='checkbox']");
	By txtLease = By.xpath("//input[contains(@id,'_EditFormControl_rtbLeaseNum') and @type='text']");
	By txtEfectiveDate = By.xpath("(//*[contains(@id,'_EditFormControl_CustFieldAGMNew')]/..//span[contains(text(),'Effective Date')]/..//input[@type='text'])[2]");
	By txtExpirationDate = By.xpath("(//*[contains(@id,'_EditFormControl_CustFieldAGMNew')]/..//span[contains(text(),'Expiration Date')]/..//input[@type='text'])[2]");
	By txtDaysBeforeExp = By.xpath("//*[contains(text(),'Days Before')]/..//input[@type='text']");
	By txtExternalAgreement = By.xpath("//*[contains(text(),'External Agreement')]/..//input[@type='text']");
	By PerpetualCheckbox = By.xpath("//span[contains(text(), 'Perpetual')]/..//input");
	By UnrecordedCheckbox = By.xpath("//span[contains(text(),'Unrecorded')]/..//input");
	By ExtensionProvisionCheckbox = By.xpath("//span[contains(text(),'Extension Provision')]/..//input");
	By drpStandardAgreement  = By.xpath("//*[contains(text(),'Is Standard Agreement')]/..//input[@type='text']");
	By txtStructure = By.xpath("//*[contains(text(),'Structure')]/..//input[@type='text']");
    By txtGrantor = By.xpath("//*[contains(@id,'_EditFormControl_CustFieldAGMNew')]/..//span[text()='Grantor:']/..//textarea");
    By txtGrantee = By.xpath("//*[contains(@id,'_EditFormControl_CustFieldAGMNew')]/..//span[text()='Grantee:']/..//textarea");
    By txtComment = By.xpath("//*[contains(@id,'_EditFormControl_CustFieldAGMNew')]/..//span[text()='Comments:']/..//textarea");
    By btnInsert = By.xpath("//input[contains(@id,'YALAGREEMENTMANAGEMENT_New_radYALGridControl_ctl00_ctl02_ctl03_EditFormControl_btnInsert')]");
	By changesSavedSuccessfully = By.xpath("//span[contains(@id,'YALAGREEMENTMANAGEMENT_New_usrMessage')]");
    By btnEdit = By.xpath("//input[contains(@id,'YALAGREEMENTMANAGEMENT_New_radYALGridControl_ctl00_ctl04_EditButton')]");
    By btnUpdate = By.xpath("//input[contains(@id,'_EditFormControl_btnUpdate')]");
    By btnDelete = By.xpath("//input[contains(@id,'YALAGREEMENTMANAGEMENT_New_radYALGridControl_ctl00_ctl04_gbcDeleteAlignment')]");
    By iframeDelete = By.xpath("//td[@class='rwWindowContent']");
	By btnOk = By.xpath("//span[text()='OK']");
	
	By navParcel = By.xpath("//span[text()='Parcel'] | //span[text()='Tract']");
	By navParcelInfo = By.xpath("//span[text()='Parcel Info'] | //span[text()='Tract Info']");
	By navAcquistion = By.xpath("(//span[text()='Acquisition'])[1] | (//span[text()='ROW Components'])[1]");
	By drpAcquistionStatus = By.xpath("//input[contains(@id,'_ACQASSING_ACQUISITION_STATUS_ID_radYALDropDownList_Input') and @type='text'] ");
	By firstParcel = By.xpath("//*[contains(@id,'TractList_RadGridTracts_ctl00__0')]");
	
	
	By drpEasementCoverage = By.xpath("//*[contains(text(),'Easement Coverage:')]/..//input[@type='text']");
	 
	public void navigateToAcquistion() {
		util.waitUntilElementDisplay(navParcel);
		util.click(navParcel);
		util.waitUntilElementDisplay(navParcelInfo);
		util.click(navParcelInfo);
		util.waitUntilElementDisplay(navAcquistion);
		util.click(navAcquistion);
		
	}
	
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
	
	public void SelectDocumentTypeAvangrid() {
		util.waitUntilElementDisplay(drpDocumentType);
		util.click(drpDocumentType);
		DOCUMENT_TYPE = driver.findElement(SelectDocumentTypeAvangrid).getText();
		System.out.println("Document Type selected: " + DOCUMENT_TYPE);
		util.click(SelectDocumentTypeAvangrid);
		
	}
	
	public void SelectDateExecuted(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtDateExecuted, value);
	}
	
	public void ClickonLeaseSetupCheckbox() {
		util.click(LeaseSetupCheckbox);
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
	
	public void AddDaysBeforeExp(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtDaysBeforeExp, value);
	}
	
	public void AddExternalAgreement(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtExternalAgreement, value);
	}

	public void selectEasementCoverage(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpEasementCoverage, value);
	}
	
	public void ClickonPerpetualCheckbox() {
		util.waitUntilElementDisplay(PerpetualCheckbox);
		util.click(PerpetualCheckbox);
	}
	
	public void ClickonUnrecordedCheckbox() {
		util.waitUntilElementDisplay(UnrecordedCheckbox);
		util.click(UnrecordedCheckbox);
	}
	
	public void ClickonExtensionProvisionCheckbox() {
		util.waitUntilElementDisplay(ExtensionProvisionCheckbox);
		util.click(ExtensionProvisionCheckbox);
	}

	public void SelectStandardAgreement(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpStandardAgreement, value);
	}
	
	public void AddStructure(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtStructure, value);
	}
	
	public void AddGrantor(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtGrantor, value);
	}
	
	public void AddGrantee(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtGrantee, value);
	}
	
	public void AddComment(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtComment, value);
	}
	
	public void ClickonInsert() {
		util.waitUntilElementDisplay(btnInsert);
		util.click(btnInsert);
		util.waitUntilElementDisplay(changesSavedSuccessfully);
		Assert.assertTrue(util.isElementPresent(changesSavedSuccessfully), "Changes saved successfully!");

	}
	
	public void ClickoneEdit(String value) {
		util.waitFor(500);
		util.waitUntilElementDisplay(btnEdit);
		util.click(btnEdit);
		util.waitUntilElementDisplay(txtComment);
		if (!commonFunction.checkNA(value))
		util.inputTextAndPressTab(txtComment, value);	
	}
	
	public void ClickonUpdate() {
		util.waitUntilElementDisplay(btnUpdate);
		util.click(btnUpdate);
		util.dummyWait(2);
		util.waitUntilElementDisplay(changesSavedSuccessfully);
		Assert.assertTrue(util.isElementPresent(changesSavedSuccessfully), "Changes saved successfully!");
	}
	
	public void ClickonDeleteButton() {
		util.dummyWait(1);
		util.waitUntilElementDisplay(btnDelete);
		util.click(btnDelete);
	}
	
	public void ClickonOk() {
		util.waitUntilElementDisplay(btnOk);
		util.click(btnOk);
	}
	
	 public void AddAgreementManagement(Map<String, String> map, String testcaseName) {
		 try {
	    		navigateToAcquistion();
	    		commonFunction.projectSelection();
	    		util.dummyWait(3);    		
	    		util.waitUntilElementDisplay(firstParcel);
	    		util.click(firstParcel);
	    		util.dummyWait(5);
				log("STEP 1:  User can navigate to the Acquisition tab ", Status.PASS);
			} catch (Exception e) {
				log("STEP 1:  User cannot navigate to the Acquisition tab", Status.FAIL);
				throw new RuntimeException("Failed in step 1");
			}
		 
	    	
		 try {
			 ClickonAddNew();
				log("STEP 2: User can expand the Agreement Manager Panel ", Status.PASS);
			} catch (Exception e) {
				log("STEP 2:  User cannot expand the Agreement Manager Panel", Status.FAIL);
				throw new RuntimeException("Failed in step 2");
			}
		 
		 try {
			 if(environment.contains("AVANGRID")) {
                 SelectDocumentTypeAvangrid();
			 } else {
			 SelectDocumentType();
                 }
				log("STEP 3: User can select the document type ", Status.PASS);
			} catch (Exception e) {
				log("STEP 3: User cannot select the document type ", Status.FAIL);
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
			 ClickonLeaseSetupCheckbox();
				log("STEP 5:  User can check Lease Setup checkbox. ", Status.PASS);
			} catch (Exception e) {
				log("STEP 5:  User can not  check Lease Setup checkbox.", Status.FAIL);
				throw new RuntimeException("Failed in step 5");
			}
		 
		 try {
			 AddLease(map.get(Excel.Lease));
				log("STEP 6:  User can enter the value in the Lease field.", Status.PASS);
			} catch (Exception e) {
				log("STEP 6:   User cannot enter the value in the Lease field.", Status.FAIL);
				throw new RuntimeException("Failed in step 6");
			}
		 
		 try {
			 AddEfectiveDate(map.get(Excel.EfectiveDate));
				log("STEP 7:  User can select Effective Date", Status.PASS);
			} catch (Exception e) {
				log("STEP 7:   User can not select Effective Date", Status.FAIL);
				throw new RuntimeException("Failed in step 7");
			}
		 
		 try {
			 AddExpirationDate(map.get(Excel.ExpirationDate));
				log("STEP 8:  User can enter the value in the Expiration Date field ", Status.PASS);
			} catch (Exception e) {
				log("STEP 8:  User cannot enter the value in the Expiration Date field", Status.FAIL);
				throw new RuntimeException("Failed in step 8");
			}
		 
		 if(environment.contains("AVANGRID")) {
				try {
					selectEasementCoverage("Full Parcel");
					log("STEP 8a:  User can select value from the Easement Coverage dd ", Status.PASS);
				} catch (Exception e) {
					log("STEP 8a:  User cannot select value from the Easement Coverage dd", Status.FAIL);
					throw new RuntimeException("Failed in step 8a");
				}
		 }
		 
		 try {
			 AddDaysBeforeExp(map.get(Excel.DaysBeforeExp));
				log("STEP 9:  User can enter the value in the Days Before Exp field ", Status.PASS);
			} catch (Exception e) {
				log("STEP 9:  User cannot enter the value in the Days Before Exp field", Status.FAIL);
				throw new RuntimeException("Failed in step 9");
			}
		 
		 try {
			 AddExternalAgreement(map.get(Excel.ExternalAgreement));
				log("STEP 10: User can enter the value in the External Agreement field", Status.PASS);
			} catch (Exception e) {
				log("STEP 10: User cannot enter the value in the External Agreement field", Status.FAIL);
				throw new RuntimeException("Failed in step 10");
			}
		 
		 try {
			 ClickonPerpetualCheckbox();
				log("STEP 11: User can check perpetual checkbox ", Status.PASS);
			} catch (Exception e) {
				log("STEP 11:  User can not  check perpetual checkbox.", Status.FAIL);
				throw new RuntimeException("Failed in step 11");
			}
		 
		 try {
			 ClickonUnrecordedCheckbox();
				log("STEP 12: User can check Unrecorded checkbox.", Status.PASS);
			} catch (Exception e) {
				log("STEP 12: User can not  check Unrecorded checkbox.", Status.FAIL);
				throw new RuntimeException("Failed in step 12");
			}
		 
		 try {
			 ClickonExtensionProvisionCheckbox();
				log("STEP 13:  User can check Extension provision checkbox. ", Status.PASS);
			} catch (Exception e) {
				log("STEP 13:  User can not  check Extension provision checkbox.", Status.FAIL);
				throw new RuntimeException("Failed in step 13");
			}
		 
		 try {
			 SelectStandardAgreement(map.get(Excel.StandardAgreement));
				log("STEP 14:  User can select value from the standard agreement dd  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 14:  User cannot select value from the standard agreement dd", Status.FAIL);
				throw new RuntimeException("Failed in step 14");
			}
		 
//		 if(util.isElementVisible(txtStructure)) {
//		 try {
//			 AddStructure(map.get(Excel.Structure));
//				log("STEP 15:  User can enter the value in the Structure field  ", Status.PASS);
//			} catch (Exception e) {
//				log("STEP 15:  User cannot enter the value in the Structure field", Status.FAIL);
//				throw new RuntimeException("Failed in step 15");
//			}
//		 }
		 
		 try {
			 AddGrantor(map.get(Excel.Grantor));
				log("STEP 16:  User can enter the value in the Grantor field ", Status.PASS);
			} catch (Exception e) {
				log("STEP 16:  User cannot enter the value in the Grantor field", Status.FAIL);
				throw new RuntimeException("Failed in step 16");
			}
		 
		 try {
			 AddGrantee(map.get(Excel.Grantee));
				log("STEP 17:  User can enter the value in the Grantee field  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 17:  User cannot enter the value in the Grantee field", Status.FAIL);
				throw new RuntimeException("Failed in step 17");
			}
		 
		 try {
			 AddComment(map.get(Excel.Comment));
				log("STEP 18:  User can enter the value in the Comment field  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 18:  User cannot enter the value in the Comment field", Status.FAIL);
				throw new RuntimeException("Failed in step 18");
			}
		 
		 try {
			 ClickonInsert();
				log("STEP 19:   User can click on Insert button ", Status.PASS);
			} catch (Exception e) {
				log("STEP 19:   User cannot click on Insert button", Status.FAIL);
				throw new RuntimeException("Failed in step 19");
			}
		 
		 try {
			 ClickoneEdit(map.get(Excel.UpdateComment));
				log("STEP 20:  User can update comment ", Status.PASS);
			} catch (Exception e) {
				log("STEP 20:   User cannot update comment", Status.FAIL);
				throw new RuntimeException("Failed in step 20");
			}
		 
		 try {
			 ClickonUpdate();
				log("STEP 21: User can click on Update button ", Status.PASS);
			} catch (Exception e) {
				log("STEP 21: User cannot click on Update button ", Status.FAIL);
				throw new RuntimeException("Failed in step 21");
			}
		 
   }
}
