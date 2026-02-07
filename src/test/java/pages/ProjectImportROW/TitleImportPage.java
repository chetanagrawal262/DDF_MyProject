package pages.ProjectImportROW;

import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.ExcelUtils;
import com.util.TestUtil;
import extentReports.ExtentTestManager;
import pages.projectImportALT.ProjectImportPage;

public class TitleImportPage extends BasePage {

	TestUtil util;
	CommonFunction commonFunction;
	ProjectImportPage objProjectImportPage;
	ErrorLog objErrorLog;
	Map<String, String> map = new HashMap<String, String>();
	
	public TitleImportPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		objProjectImportPage = new ProjectImportPage(driver);
		objErrorLog = new ErrorLog(driver);
	}

	
	By tractNumber = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Tract #: ']/..//input[contains(@id,'Dest_Input')] | (//input[contains(@id,'TRACT_NUMBER') and @type='text'])[1]");
	public String getTractNumber() {
		return util.getAttributeValue(tractNumber, "value");
	}
	
	By documentType = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Document Type: ']/..//input[contains(@id,'Dest_Input')]");
	public String getDocumentType() {
		return util.getAttributeValue(documentType, "value");
	}
	
	By titleDocumentType = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Title Document Type: ']/..//input[contains(@id,'Dest_Input')] | (//input[contains(@id,'radYALGridControl') and @type='text'])[1]");
	public String getTitleDocumentType() {
		return util.getAttributeValue(titleDocumentType, "value");
	}
	
	By documentNo = By.xpath("(//span[contains(@id,'idYalImport_SourceCols') and text()='Document No: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'EditFormControl_DOCUMENT_NUMBER')])[1]");
	public String getDocumentNo() {
		return util.getAttributeValue(documentNo, "value");
	}
	
	By book = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Book: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'EditFormControl_Name_Of_Record') and @type='text']");
	public String getBook() {
		return util.getAttributeValue(book, "value");
	}
	
	By volume = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Volume: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'EditFormControl_VOLUME') and @type='text']");
	public String getVolume() {
		return util.getAttributeValue(volume, "value");
	}
	
	By page = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Page: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'EditFormControl_DPAGE') and @type='text']");
	public String getPage() {
		return util.getAttributeValue(page, "value");
	}
	
	
	By imageNo = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Image No: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'EditFormControl_IMAGE_NUMBER') and @type='text']");
	public String getImageNo() {
		return util.getAttributeValue(imageNo, "value");
	}
	
	By causeNumber = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Cause Number: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'EditFormControl_CLAUSE_NO') and @type='text'] ");
	public String getCauseNumber() {
		return util.getAttributeValue(causeNumber, "value");
	}
	
	By executedDate = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Executed Date: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'EditFormControl_EXECUTED_DATE_dateInput') and @type='text'] ");
	public String getExecutedDate() {
		return util.getAttributeValue(executedDate, "value");
	}
	
	By recordedDate = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Recorded Date: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'EditFormControl_RECORDED_DATE_dateInput') and @type='text'] ");
	public String getRecordedDate() {
		return util.getAttributeValue(recordedDate, "value");
	}
	
	By effectiveDate = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Effective Date: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'EditFormControl_EFFECTIVE_DATE_dateInput') and @type='text']");
	public String getEffectiveDate() {
		return util.getAttributeValue(effectiveDate, "value");
	}
	
	By expirationDate = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Expiration Date: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'EditFormControl_Expiration_Date_dateInput') and @type='text'] ");
	public String getExpirationDate() {
		return util.getAttributeValue(expirationDate, "value");
	}
	
	By grantor = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Grantor: ']/..//input[contains(@id,'Dest_Input')] | //textarea[contains(@id,'EditFormControl_GRANTOR')]");
	public String getGrantor() {
		return util.getAttributeValue(grantor, "value");
	}
	
	By grantee = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Grantee: ']/..//input[contains(@id,'Dest_Input')] | //textarea[contains(@id,'EditFormControl_GRANTEE')]");
	public String getGrantee() {
		return util.getAttributeValue(grantee, "value");
	}
	
	By comments = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Comments: ']/..//input[contains(@id,'Dest_Input')] | //textarea[contains(@id,'EditFormControl_COMMENTS')]");
	public String getComments() {
		return util.getAttributeValue(comments, "value");
	}
	
	By current = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Current: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'EditFormControl_isCurrent')]");
	public String getCurrent() {
		return util.getAttributeValue(current, "value");
	}
	
	By unrecorded = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Unrecorded: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'EditFormControl_UNRECORDED')] ");
	public String getUnrecorded() {
		return util.getAttributeValue(unrecorded, "value");
	}
	
	By includeinLTC = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Include in LTC: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'EditFormControl_INCLUDE_LTC')] ");
	public String getIncludeinLTC() {
		return util.getAttributeValue(includeinLTC, "value");
	}
	
	By state = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='State: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'EditFormControl_State') and @type='text']");
	public String getState() {
		return util.getAttributeValue(state, "value");
	}
	
	By county = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='County: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'EditFormControl_County') and @type='text']");
	public String getCounty() {
		return util.getAttributeValue(county, "value");
	}
	
	By plaintiff = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Plaintiff: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'EditFormControl_PLAINTIFF') and @type='text']");
	public String getPlaintiff() {
		return util.getAttributeValue(plaintiff, "value");
	}
	
	By defendant = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Defendant: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'EditFormControl_DEFENDANT') and @type='text']");
	public String getDefendant() {
		return util.getAttributeValue(defendant, "value");
	}
	
	By securedParty = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Secured Party: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'EditFormControl_SECURED_PARTY') and @type='text']");
	public String getSecuredParty() {
		return util.getAttributeValue(securedParty, "value");
	}
	
	By debtor = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Debtor: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'EditFormControl_DEBTOR') and @type='text']");
	public String getDebtor() {
		return util.getAttributeValue(debtor, "value");
	}
	
	By amount = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Amount: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'EditFormControl_AMOUNT') and @type='text']");
	public String getAmount() {
		return util.getAttributeValue(amount, "value");
	}

	

	Map<String, String> excelData;
	public void TitleImportMapping(String testcaseName) {
		SoftAssert assertion = new SoftAssert();
			excelData = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.TitleMapping, testcaseName);
				
				assertion.assertEquals(getTractNumber(), excelData.get("Tract #").trim(), "Tract # mapping mismatched");
				ExtentTestManager.log("Tract # Mapping : " +getTractNumber());
				
				assertion.assertEquals(getDocumentType(), excelData.get("Document Type").trim(), "Document Type mapping mismatched");
				ExtentTestManager.log("Document Type Mapping : "+getDocumentType());
				
				assertion.assertEquals(getTitleDocumentType(), excelData.get("Title Document Type").trim(), "Title Document Type mapping mismatched");
				ExtentTestManager.log("Title Document Type Mapping : "+getTitleDocumentType());
				
				assertion.assertEquals(getDocumentNo(), excelData.get("Document No").trim(), "Document No mapping mismatched");
				ExtentTestManager.log("Document No Mapping : "+getDocumentNo());
				
				assertion.assertEquals(getBook(), excelData.get("Book").trim(), "Book mapping mismatched");
				ExtentTestManager.log("Book Mapping : "+getBook());
				
				assertion.assertEquals(getVolume(), excelData.get("Volume").trim(), "Volume mapping mismatched");
				ExtentTestManager.log("Volume Mapping : "+getVolume());
				
				assertion.assertEquals(getPage(), excelData.get("Page").trim(), "Page mapping mismatched");
				ExtentTestManager.log("Page Mapping : "+getPage());
				
				assertion.assertEquals(getImageNo(), excelData.get("Image No").trim(), "Image No mapping mismatched");
				ExtentTestManager.log("Image No Mapping : "+getImageNo());
				
				assertion.assertEquals(getCauseNumber(), excelData.get("Cause Number").trim(), "Cause Number mapping mismatched");
				ExtentTestManager.log("Cause Number Mapping : "+getCauseNumber());
				
				assertion.assertEquals(getExecutedDate(), excelData.get("Executed Date").trim(), "Executed Date mapping mismatched");
				ExtentTestManager.log("Executed Date Mapping : "+getExecutedDate());
				
				assertion.assertEquals(getRecordedDate(), excelData.get("Recorded Date").trim(), "Recorded Date mapping mismatched");
				ExtentTestManager.log("Recorded Date Mapping : "+getRecordedDate());
				
				assertion.assertEquals(getEffectiveDate(), excelData.get("Effective Date").trim(), "Effective Date mapping mismatched");
				ExtentTestManager.log("Effective Date Mapping : "+getEffectiveDate());
				
				assertion.assertEquals(getExpirationDate(), excelData.get("Expiration Date").trim(), "Expiration Date mapping mismatched");
				ExtentTestManager.log("Expiration Date Mapping : "+getExpirationDate());
				
				assertion.assertEquals(getGrantor(), excelData.get("Grantor").trim(), "Grantor mapping mismatched");
				ExtentTestManager.log("Grantor Mapping : "+getGrantor());
				
				assertion.assertEquals(getGrantee(), excelData.get("Grantee").trim(), "Grantee mapping mismatched");
				ExtentTestManager.log("Grantee Mapping : "+getGrantee());
				
				assertion.assertEquals(getComments(), excelData.get("Comments").trim(), "Comments mapping mismatched");
				ExtentTestManager.log("Comments Mapping : "+getComments());
				
				assertion.assertEquals(getCurrent(), excelData.get("Current").trim(), "Current mapping mismatched");
				ExtentTestManager.log("Current Mapping : "+getCurrent());
				
				assertion.assertEquals(getUnrecorded(), excelData.get("Unrecorded").trim(), "Unrecorded mapping mismatched");
				ExtentTestManager.log("Unrecorded Mapping : "+getUnrecorded());
				
//				if(environment.contains("CRIMSON") || environment.contains("ROW") || environment.contains("CENTERPOINT") || environment.contains("PARPACIFIC") || environment.contains("AVANGRID") || environment.contains("SMUD")) {
//					assertion.assertEquals(getIncludeinLTC(), excelData.get("IncludeLTC").trim(), "Include in LTC mapping mismatched");
//					ExtentTestManager.log("Include in LTC Mapping : "+getIncludeinLTC());
//				}else {
//				assertion.assertEquals(getIncludeinLTC(), excelData.get("Include in LTC").trim(), "Include in LTC mapping mismatched");
//				ExtentTestManager.log("Include in LTC Mapping : "+getIncludeinLTC());
//				}

				if (getIncludeinLTC().equals(excelData.get("IncludeLTC").trim()) || getIncludeinLTC().equals(excelData.get("Include in LTC").trim())) {
					ExtentTestManager.log("Include in LTC Mapping matched: " + getIncludeinLTC());
				} else {
					assertion.fail("Include in LTC mapping mismatched. Expected: '" + excelData.get("IncludeLTC").trim() + "' or '"
							+ excelData.get("Include in LTC").trim() + "', but found: '" + getIncludeinLTC() + "'");
				}

				assertion.assertEquals(getState(), excelData.get("State").trim(), "State mapping mismatched");
				ExtentTestManager.log("State Mapping : "+getState());
				
				assertion.assertEquals(getCounty(), excelData.get("County").trim(), "County mapping mismatched");
				ExtentTestManager.log("County Mapping : "+getCounty());
				
				assertion.assertEquals(getPlaintiff(), excelData.get("Plaintiff").trim(), "Plaintiff mapping mismatched");
				ExtentTestManager.log("Plaintiff Mapping : "+getPlaintiff());
				
				assertion.assertEquals(getDefendant(), excelData.get("Defendant").trim(), "Defendant mapping mismatched");
				ExtentTestManager.log("Defendant Mapping : "+getDefendant());
				
				assertion.assertEquals(getSecuredParty(), excelData.get("Secured Party").trim(), "Secured Party mapping mismatched");
				ExtentTestManager.log("Secured Party Mapping : "+getSecuredParty());
				
				assertion.assertEquals(getDebtor(), excelData.get("Debtor").trim(), "Debtor mapping mismatched");
				ExtentTestManager.log("Debtor Mapping : "+getDefendant());
				
				assertion.assertEquals(getAmount(), excelData.get("Amount").trim(), "Amount mapping mismatched");
				ExtentTestManager.log("Amount Mapping : "+getAmount());
				
				assertion.assertAll();

			}
	
	public void verifyTitleImportMapping(Map<String, String> map, String testcaseName) throws Exception {
	objProjectImportPage.projectDataImport(map, testcaseName);
	try {
		TitleImportMapping(testcaseName);
		log("STEP 7:  All Land  Data Mappings are correct", Status.PASS);
	} catch (Exception e) {
		log("STEP 7:  Some Mappings are Missing or Incorrect", Status.FAIL);
		throw new RuntimeException("Failed in step 7");
	}
	util.dummyWait(10);
	
}

	By navDocumentVestingOwnership = By.xpath("//span[text()='Document Vesting Ownership']");
	By DocumentVestingOwnershipEdit = By.xpath("//input[contains(@id,'VESTING_radYALGridControl_ctl00_ctl04_EditButton')]");
	
	By navEasementPlatsOilGas = By.xpath("//span[text()='Easements, Plats, Oil & Gas Leases']");
	By EasementPlatsOilGasEdit = By.xpath("//input[contains(@id,'TEASEMENT_radYALGridControl_ctl00_ctl04_EditButton')]");
	
	By navInvoluntaryLiens = By.xpath("//span[text()='Involuntary Liens, Lis Pendens & Other Encumbrance']");
	By InvoluntaryLiensEdit = By.xpath("//input[contains(@id,'TLIEN_radYALGridControl_ctl00_ctl04_EditButton')]");
	By loaderIcon = By.xpath("(//div[contains(@id,'_RadMultiPage1')])[1]");

	public void validationOfImportedData(Map<String, String> map, String testcaseName) {
	
		SoftAssert assertion = new SoftAssert();
		
		util.dummyWait(2);
		
			
				 	By addedRecord = By.xpath("//td[text()='"+map.get("Tract #") +"']/parent::tr");
					Assert.assertTrue(util.isElementPresent(addedRecord, 30), "Record is not added yet");
					util.click(addedRecord);

					util.waitUntilElementDisappear(loaderIcon);
					assertion.assertEquals(getTractNumber(), map.get("Tract #").trim(), "Parcel number mismatched");
					ExtentTestManager.log("Parcel number matched : " +getTractNumber());
				
					if(map.get("Document Type").equalsIgnoreCase("Deeds")) {
					util.dummyWait(2);
					util.waitUntilElementDisplay(navDocumentVestingOwnership);
					util.click(navDocumentVestingOwnership);
					util.dummyWait(2);
					util.click(DocumentVestingOwnershipEdit);
					
					assertion.assertEquals(getTitleDocumentType(), map.get("Title Document Type").trim(), "Title Document Type mismatched");
					ExtentTestManager.log("Title Document Type  : "+getTitleDocumentType());
					
					assertion.assertEquals(getDocumentNo(), map.get("Document No").trim(), "Document No mismatched");
					ExtentTestManager.log("Document No  : "+getDocumentNo());	
					
					assertion.assertEquals(getImageNo(), map.get("Image No").trim(), "Image No mismatched");
					ExtentTestManager.log("Image No : "+getImageNo());
					
					assertion.assertEquals(getCauseNumber(), map.get("Cause Number").trim(), "Cause Number mismatched");
					ExtentTestManager.log("Cause Number : "+getCauseNumber());
					
					assertion.assertEquals(getVolume(), map.get("Volume").trim(), "Volume mismatched");
					ExtentTestManager.log("Volume  : "+getVolume());
					
					assertion.assertEquals(getPage(), map.get("Page").trim(), "Page mismatched");
					ExtentTestManager.log("Page : "+getPage());
					
					assertion.assertEquals(getExecutedDate(), map.get("Executed Date").trim(), "Executed Date mismatched");
					ExtentTestManager.log("Executed Date : "+getExecutedDate());
					
					assertion.assertEquals(getRecordedDate(), map.get("Recorded Date").trim(), "Recorded Date mismatched");
					ExtentTestManager.log("Recorded Date : "+getRecordedDate());
					
					assertion.assertEquals(getEffectiveDate(), map.get("Effective Date").trim(), "Effective Date mismatched");
					ExtentTestManager.log("Effective Date : "+getEffectiveDate());
					
					assertion.assertEquals(getState(), map.get("State").trim(), "State mismatched");
					ExtentTestManager.log("State : "+getState());
					
					assertion.assertEquals(getCounty(), map.get("County").trim(), "County mismatched");
					ExtentTestManager.log("County : "+getCounty());
					
					assertion.assertEquals(getBook(), map.get("Book").trim(), "Book value mismatched");
					ExtentTestManager.log("Book value  : "+getBook());
					
					assertion.assertEquals(getCurrent(), map.get("Current").trim(), "Current mismatched");
					ExtentTestManager.log("Current : "+getCurrent());
					
					assertion.assertEquals(getGrantor(), map.get("Grantor").trim(), "Grantor mismatched");
					ExtentTestManager.log("Grantor : "+getGrantor());
					
					assertion.assertEquals(getGrantee(), map.get("Grantee").trim(), "Grantee mismatched");
					ExtentTestManager.log("Grantee : "+getGrantee());
					
					assertion.assertEquals(getComments(), map.get("Comments").trim(), "Comments mismatched");
					ExtentTestManager.log("Comments : "+getComments());

					assertion.assertAll();
					
					}
					else 
						if(map.get("Document Type").equalsIgnoreCase("Easements")) {
							util.dummyWait(2);
							util.waitUntilElementDisplay(navEasementPlatsOilGas);
							util.click(navEasementPlatsOilGas);
							util.dummyWait(2);
							util.click(EasementPlatsOilGasEdit);
							
							assertion.assertEquals(getTitleDocumentType(), map.get("Title Document Type").trim(), "Title Document Type mismatched");
							ExtentTestManager.log("Title Document Type  : "+getTitleDocumentType());
							
						
							assertion.assertEquals(getDocumentNo(), map.get("Document No").trim(), "Document No mismatched");
							ExtentTestManager.log("Document No  : "+getDocumentNo());			
							
							assertion.assertEquals(getImageNo(), map.get("Image No").trim(), "Image No mismatched");
							ExtentTestManager.log("Image No : "+getImageNo());
							
							assertion.assertEquals(getVolume(), map.get("Volume").trim(), "Volume mismatched");
							ExtentTestManager.log("Volume  : "+getVolume());
							
							assertion.assertEquals(getPage(), map.get("Page").trim(), "Page mismatched");
							ExtentTestManager.log("Page : "+getPage());
							
							assertion.assertEquals(getExecutedDate(), map.get("Executed Date").trim(), "Executed Date mismatched");
							ExtentTestManager.log("Executed Date : "+getExecutedDate());
							
							assertion.assertEquals(getRecordedDate(), map.get("Recorded Date").trim(), "Recorded Date mismatched");
							ExtentTestManager.log("Recorded Date : "+getRecordedDate());
							
							assertion.assertEquals(getEffectiveDate(), map.get("Effective Date").trim(), "Effective Date mismatched");
							ExtentTestManager.log("Effective Date : "+getEffectiveDate());
							
							assertion.assertEquals(getExpirationDate(), map.get("Expiration Date").trim(), "Expiration Date mismatched");
							ExtentTestManager.log("Expiration Date : "+getExpirationDate());
							
							assertion.assertEquals(getState(), map.get("State").trim(), "State mismatched");
							ExtentTestManager.log("State : "+getState());
							
							assertion.assertEquals(getCounty(), map.get("County").trim(), "County mismatched");
							ExtentTestManager.log("County : "+getCounty());
							
							assertion.assertEquals(getUnrecorded(), map.get("Unrecorded").trim(), "Unrecorded mismatched");
							ExtentTestManager.log("Unrecorded : "+getUnrecorded());
							
							assertion.assertEquals(getBook(), map.get("Book").trim(), "Book value mismatched");
							ExtentTestManager.log("Book value  : "+getBook());
							
							assertion.assertEquals(getGrantor(), map.get("Grantor").trim(), "Grantor mismatched");
							ExtentTestManager.log("Grantor : "+getGrantor());
							
							assertion.assertEquals(getGrantee(), map.get("Grantee").trim(), "Grantee mismatched");
							ExtentTestManager.log("Grantee : "+getGrantee());
							
							assertion.assertEquals(getComments(), map.get("Comments").trim(), "Comments mismatched");
							ExtentTestManager.log("Comments : "+getComments());

							assertion.assertAll();
						}
						else {
								util.dummyWait(2);
								util.waitUntilElementDisplay(navInvoluntaryLiens);
								util.click(navInvoluntaryLiens);
								util.dummyWait(2);
								util.click(InvoluntaryLiensEdit);
								
								assertion.assertEquals(getTitleDocumentType(), map.get("Title Document Type").trim(), "Title Document Type mismatched");
								ExtentTestManager.log("Title Document Type  : "+getTitleDocumentType());
								
								assertion.assertEquals(getDocumentNo(), map.get("Document No").trim(), "Document No mismatched");
								ExtentTestManager.log("Document No  : "+getDocumentNo());		
								
								assertion.assertEquals(getImageNo(), map.get("Image No").trim(), "Image No mismatched");
								ExtentTestManager.log("Image No : "+getImageNo());
								
								assertion.assertEquals(getCauseNumber(), map.get("Cause Number").trim(), "Cause Number mismatched");
								ExtentTestManager.log("Cause Number : "+getCauseNumber());
								
								assertion.assertEquals(getVolume(), map.get("Volume").trim(), "Volume mismatched");
								ExtentTestManager.log("Volume  : "+getVolume());
								
								assertion.assertEquals(getPage(), map.get("Page").trim(), "Page mismatched");
								ExtentTestManager.log("Page : "+getPage());
								
								assertion.assertEquals(getExecutedDate(), map.get("Executed Date").trim(), "Executed Date mismatched");
								ExtentTestManager.log("Executed Date : "+getExecutedDate());
								
								assertion.assertEquals(getRecordedDate(), map.get("Recorded Date").trim(), "Recorded Date mismatched");
								ExtentTestManager.log("Recorded Date : "+getRecordedDate());
								
								assertion.assertEquals(getEffectiveDate(), map.get("Effective Date").trim(), "Effective Date mismatched");
								ExtentTestManager.log("Effective Date : "+getEffectiveDate());
								
								assertion.assertEquals(getPlaintiff(), map.get("Plaintiff").trim(), "Plaintiff mismatched");
								ExtentTestManager.log("Plaintiff : "+getPlaintiff());
								
								assertion.assertEquals(getDefendant(), map.get("Defendant").trim(), "Defendant mismatched");
								ExtentTestManager.log("Defendant : "+getDefendant());
								
								assertion.assertEquals(getSecuredParty(), map.get("Secured Party").trim(), "Secured Party mismatched");
								ExtentTestManager.log("Secured Party : "+getSecuredParty());
								
								assertion.assertEquals(getDebtor(), map.get("Debtor").trim(), "Debtor mismatched");
								ExtentTestManager.log("Debtor : "+getDebtor());
								
								assertion.assertEquals(getAmount(), map.get("Amount").trim(), "Amount mismatched");
								ExtentTestManager.log("Amount : "+getAmount());
								
								assertion.assertEquals(getState(), map.get("State").trim(), "State mismatched");
								ExtentTestManager.log("State : "+getState());
								
								assertion.assertEquals(getCounty(), map.get("County").trim(), "County mismatched");
								ExtentTestManager.log("County : "+getCounty());
								
								assertion.assertEquals(getBook(), map.get("Book").trim(), "Book value mismatched");
								ExtentTestManager.log("Book value  : "+getBook());
								
								assertion.assertEquals(getIncludeinLTC(), map.get("Include in LTC").trim(), "Include in LTC mismatched");
								ExtentTestManager.log("Include in LTC : "+getIncludeinLTC());
								
								assertion.assertEquals(getComments(), map.get("Comments").trim(), "Comments mismatched");
								ExtentTestManager.log("Comments : "+getComments());

								assertion.assertAll();
						}

					assertion.assertAll();
			 }
		
	By downlodPDF = By.xpath("//a[contains(@id,'DownloadPDF')]");
	By downloadExcel = By.xpath("//a[contains(@id,'DownloadEXCEL')]");
	public void errorLogValidation(String testcaseName) throws Exception {

		try {
			//objErrorLog.TitlevalidationMsg(testcaseName); 
			objErrorLog.printErrorLog();
	        log("STEP 12:  All Import validation Msg validated sucessfully", Status.PASS);
		} catch (Exception t) {
			  log("STEP 12:  Some Import Validation Msg are missing", Status.FAIL);
			  throw new RuntimeException("Failed in step 12");
		}
		
//		try {
//			  util.click(downlodPDF); 
//	        log("STEP 13:  User can click on PDF Icon", Status.PASS);
//		} catch (Exception t) {
//			  log("STEP 13:  User cannot click on PDF Icon", Status.FAIL);
//			  throw new RuntimeException("Failed in step 13");
//		}
		
		try {
			  driver.close();
			  util.switchToParentWindow(); 
			  util.dummyWait(1);
	        log("STEP 14:  User can close the popup", Status.PASS);
		} catch (Exception t) {
			  driver.close();
			  util.switchToParentWindow(); 
			  log("STEP 14:  User cannot close the popup", Status.FAIL);
			  throw new RuntimeException("Failed in step 14");
		}
	}
	
}
			
		
