 package pages.ParcelDetails;

import java.io.File;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

public class ParcelWorkflow_AddDocumentsPage extends BasePage {
   
	
	TestUtil util;
	CommonFunction commonFunction;
	public static String AGREEMENT_NUMBER;

	public ParcelWorkflow_AddDocumentsPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		
	}
	
	By btnDocuments = By.xpath("//span[text()='Documents']");
	By btnAddDocuments = By.xpath("//input[contains(@id,'idManageApproval_btnAddDocuments') and @type='button']");
	By iframeDocument = By.xpath("//iframe[@name='AddDocuments']");
	By drpCategory = By.xpath("//select[@id='RadPanelBar1_i0_i0_rauFileUploadCategory0']");
	By txtDescription = By.xpath("//input[contains(@id,'RadPanelBar1_i0_i0_rauFileUploadDesc0') and @type='text']"); 
	
	 By drpCategoryROW = By.xpath("//select[contains(@id,'_rauFileUploadCategoryDD0')]");
	 By txtDescriptionROW = By.xpath("//input[@id='RadPanelBar1_i0_i0_rauFileUploadDesc0']");
	
	By btnLoadDocuments = By.xpath("//input[contains(@id,'RadPanelBar1_i0_i0_buttonSubmit_input') and @type='submit']");
	By btnExternalLink = By.xpath("(//span[@class='rpExpandHandle'])[2]");
	By txtDocumentName = By.xpath("//input[contains(@id,'RadPanelBar2_i0_i0_txtname1') and @type='text']");
	By txtExternalLink = By.xpath("//input[contains(@id,'RadPanelBar2_i0_i0_txtlinkname1') and @type='text']");
	By drpCategoryExelink = By.xpath("//input[contains(@id,'_ddlDynamic1_radYALDropDownList_Input') and @type='text']");
	By txtDescriptionExelink = By.xpath("//input[contains(@id,'RadPanelBar2_i0_i0_txtDynamic1') and @type='text']");
	
	By txtDocumentNameRow = By.xpath("//input[contains(@id,'radReportConfigPanels_i0_i0_txtDynamic1')]");
    By txtExternalLinkRow = By.xpath("//input[contains(@id,'radReportConfigPanels_i0_i0_link1')]");
    By Category = By.xpath("//div[@id='radReportConfigPanels_i0_i0_XYZ1_RadDropDownTree1']");
	By SelectCategory = By.xpath("(//span[contains(text(),'Docusign Demo') and @class='rtIn'])[1]");
	By txtDescriptionRow = By.xpath("//input[@id='radReportConfigPanels_i0_i0_description1']");

	By btnLoadDocumentsExeLink = By.xpath("//input[contains(@id,'_btnSave_input') and @type='submit']");
	By btnAddExeLink = By.xpath("//input[contains(@id,'_btnAdd_input') and @type='submit']");
	By btnCloseDocuments = By.xpath("//a[@class='rwCloseButton']");
	By refreshDocuments = By.xpath("//div[contains(@id,'Approval_DOCUMENT_radYALGridControlPanel')]//a[contains(@id,'_lnkRefresh')]");
	By btnDownloadSelected = By.xpath("//input[contains(@id,'_BtnDownload') and @type='button']");
	By btnEmailSelected = By.xpath("//input[contains(@id,'_btnEmailSelcted') and @type='button']");
	By btnNotes = By.xpath("//span[contains(text(),'Notes')]");
	By iframeNotes = By.xpath("//iframe[@name='radWinAgentNotes']");
	By btnAddNotes = By.xpath("//input[contains(@id,'_btnAddNotes') and  @type='submit']");
	By txtActivityDate = By.xpath("//input[contains(@id,'_AD_dateInput') and  @type='text']");
	By datePicker = By.xpath("//a[@class='rcCalPopup']");
	By SelectDate = By.xpath("//td[@title='Monday, February 27, 2023']");
	By drpAgent = By.xpath("(//input[contains(@id,'_radYALDropDownList_Input') and  @type='text'])[1]");
	By drpNotesCategory = By.xpath("(//input[contains(@id,'_radYALDropDownList_Input') and  @type='text'])[2]");
	By drpPriority = By.xpath("(//input[contains(@id,'_radYALDropDownList_Input') and  @type='text'])[3]");
	By txtNotesDescription = By.xpath("//iframe[@id='AgntNotes_RE1_contentIframe']");
	By btnaddNotes = By.xpath("//input[contains(@id,'AgntNotes_SN') and  @type='image']");
	By btnCloseNotes = By.xpath("//a[@class='rwCloseButton']");
	By linkLinkedApprovals = By.xpath("//span[contains(text(),'Linked Approvals')]");
	By navAssociatedRecord = By.xpath("//span[contains(text(),'Associated Records')]");
    By  Successmsg = By.xpath("//span[@id='AgntNotes_usrMessage']");
    By Step1Link = By.xpath("//a[contains(text(),'Upload Document')]");
	By Iframe = By.xpath("//iframe[@name='geoPopUpWF']");
	By save = By.xpath("//input[@id='idApproveInLineWorkflow_btnSaveReviewLogData']");
	By txtComment = By.xpath("//textarea[@id='idApproveInLineWorkflow_txtReviewerComments']");
	By btnApprove = By.xpath("//input[contains(@id,'_btnApprove') and @type='submit']");
	By linkApprove = By.xpath("//a[contains(text(),'Approved')]");
	By LinkRequester = By.xpath("//a[contains(text(),'Requestor')]");
	By btnClose = By.xpath("//a[@title='Close']");
	By FullFrm = By.xpath("//iframe[@name='ManageApprovalDialog']");
	By SuccessfulMessage = By.xpath("//span[text()='Changes saved successfully.']");

    By drpAddProjects = By.xpath(
			"//*[normalize-space()='Projects:']/../following-sibling::tr//input[@id='idManageApproval_Projects_Input']");
	By drpAddProjectsClose = By.xpath(
			"//*[normalize-space()='Projects:']/../following-sibling::tr//a[contains(@id,'Approval_Projects_Arrow')]");
	By drpListOfTrack = By.xpath(
			"//*[normalize-space()='List of Tract:']/../following-sibling::tr//input[@id='idManageApproval_Tract_Agreement_Input']");
	By drpListOfTrackClose = By.xpath(
			"//*[normalize-space()='List of Tract:']/../following-sibling::tr//a[contains(@id,'Tract_Agreement_Arrow')]");
	
	By drpListofLeases = By.xpath(
			"//*[normalize-space()='List of Leases:']/../following::div[@id='idManageApproval_Lease_Association']");
	By drpListofLeasesClose = By.xpath(
			"//*[normalize-space()='List of Leases:']/../following-sibling::tr//a[@id='idManageApproval_Lease_Association_Arrow']");
	
	
	By btnGoProject = By.xpath("//input[@id='idManageApproval_btnGo']");
	By btnAddListOfTract = By.xpath("//input[@id='idManageApproval_btnAddApprovalAssociation']");
	By btnRefreshListTract = By.xpath(
			"//table[contains(@id,'idManageApproval_ASSOCIATED_APPROVAL_TRACTS')]//a[contains(@id,'_lnkRefresh')]");
	By listTractMessage = By.xpath("//span[@id='idManageApproval_msgAgreement']");
	By btnDeleteListTract = By.xpath("//table[contains(@id,'ASSOCIATED_APPROVAL_TRACTS')]//input[@alt='Delete']");
	By btnDeleteOk = By.xpath("//div[contains(@class,'rwDialogPopup')]//span[text()='OK']");
	By listTractUsrMessage = By.xpath("//span[@id='idManageApproval_ASSOCIATED_APPROVAL_TRACTS_usrMessage']");
	
	public void ClickonDocumentsTab()
	{
		util.waitUntilElementDisplay(btnDocuments);
		util.click(btnDocuments);	    	
		    
	}
	 
	
	public void ClickonAddDocuments()
	{
		util.waitUntilElementDisplay(btnAddDocuments);
		util.click(btnAddDocuments);	    	
		    
	}
	
	By fileUpload = By.xpath("//input[contains(@id,'FileUploadfile')]");
	public void uploadFile() {
		String filepath = System.getProperty("user.dir") + File.separator + "test.txt";
		driver.findElement(fileUpload).sendKeys(filepath);
	}
	
	  public void selectCategory(String value) {
			if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(drpCategory, value);
		}	
	
	 
	  public void AddDescription(String value) {
			if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtDescription, value);
		}
	  
	  public void selectCategoryRow(String value) {
			if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(drpCategoryROW, value);
		}	
	
	 
	  public void AddDescriptionRow(String value) {
			if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtDescriptionROW, value);
		}
	  
	  public void ClickonLoadDocuments() {
			util.waitUntilElementDisplay(btnLoadDocuments);
			util.click(btnLoadDocuments);
			
		}
	  
	  public void ClickonExternalLink() {
			util.waitUntilElementDisplay(btnExternalLink);
			util.click(btnExternalLink);
		}
	  
	  public void AddDocumentName(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtDocumentName, value);
			
	    }
	  public void AddDocumentNameRow(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtDocumentNameRow, value);
	    }
	    
	    public void AddExternalLink(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtExternalLink, value);
			
	    }
	    
	    public void AddExternalLinkRow(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtExternalLinkRow, value);
	    }
	    
	    public void AddCategoryForExeLink(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(drpCategoryExelink, value);
			
	    }
	    
	    public void SelectCategory() {
	    	util.waitUntilElementDisplay(Category);
	    	util.click(Category);
	    	util.waitUntilElementDisplay(SelectCategory);
	    	util.click(SelectCategory);
	      }
	    
	    public void AddDescriptionExelink(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtDescriptionExelink, value);
			
	    }
	    
	    public void AddDescriptionROW(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtDescriptionRow, value);
	    }
	    
	    
	    public void ClickOnLoadDocumentsExeLink() {
	    	util.waitUntilElementDisplay(btnLoadDocumentsExeLink);
	    	util.click(btnLoadDocumentsExeLink);
			
	    }
	  
	    public void ClickOnAddExeLink() {
	    	util.waitUntilElementDisplay(btnAddExeLink);
	    	util.click(btnAddExeLink);
			
	    }
	    By iframeWorkflow = By.xpath("//iframe[@name='ManageApprovalDialog']");
	    public void ClickOnCloseDocument() {
	    	util.switchToDefaultContent();
	    	util.switchToIframe(iframeWorkflow);
	    	util.dummyWait(1);
	    	util.waitUntilElementDisplay(btnCloseDocuments);
	    	util.click(btnCloseDocuments);
			util.click(refreshDocuments);
			util.dummyWait(1);
	    }
	    
	    public void ClickOnDownloadSelected() {
	    	util.waitUntilElementDisplay(btnDownloadSelected);
	    	util.click(btnDownloadSelected);
			
	    }    
    
	    public void ClickOnEmailSelected() {
	    	util.waitUntilElementDisplay(btnEmailSelected);
	    	util.click(btnEmailSelected);
			
	    } 
	    
	    public void ClickOnNotes() {
	    	util.waitUntilElementDisplay(btnNotes);
	    	util.click(btnNotes);
			
	    } 
	    
	    public void ClickOnAddNotes() {
	    	util.waitUntilElementDisplay(btnAddNotes);
	    	util.click(btnAddNotes);
	    	util.switchToIframe(iframeNotes);
	    	util.dummyWait(3);
			
	    }
	    
	    public void AddActivityDate(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtActivityDate, value);
	    }
	    
	    public void SelectAgent(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(drpAgent, value);
			
	    }
	    
	    public void SelectNotesCategory(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(drpNotesCategory, value);
			
	    }
	    
	    public void SelectPriority(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(drpPriority, value);
			
	    }
	    
	    public void AddNotesDescription(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtNotesDescription, value);
			
	    }
	    
	    By btnSave = By.xpath("//input[contains(@id,'AgntNotes_SN') and  @type='button']");
	    public void ClickonAddNoteDot() {
	    	util.waitUntilElementDisplay(btnSave);
	    	util.click(btnSave);
	    	util.waitUntilElementDisplay(Successmsg);
	    	Assert.assertTrue(util.isElementPresent(Successmsg), "Note submitted and auto-approved.");
	    	util.dummyWait(1);
	    }
	    public void ClickonAddNote() {
	    	util.waitUntilElementDisplay(btnaddNotes);
	    	util.click(btnaddNotes);
	    	util.waitUntilElementDisplay(Successmsg);
	    	Assert.assertTrue(util.isElementPresent(Successmsg), "Note submitted for review.");
	    	util.dummyWait(1);
	    }
 
	   By iframe= By.xpath("//iframe[@name='ManageApprovalDialog']");
	    public void ClickonClose() {
			util.switchToDefaultContent();
	    	util.dummyWait(1);
	    	util.switchToIframe(iframe);
            util.dummyWait(1);
		    util.waitUntilElementDisplay(btnCloseNotes);
	    	util.click(btnCloseNotes);
            util.dummyWait(1);

	    }
	    
	    public void ClickonLinkedApprovals() {
	    	util.waitUntilElementDisplay(linkLinkedApprovals);
	    	util.click(linkLinkedApprovals);
			
	    }
	    
	    By btnApproval = By.xpath("//span[text()='Approvals ']");
	    
	    public void navigatetoAssociatedRecord() {
	    	util.waitUntilElementDisplay(navAssociatedRecord);
	    	util.click(navAssociatedRecord);
			
	    }


	    
	    public void selectProject(String value) {
			try {
				util.selectValueFromDropdown(drpAddProjects, value);
				util.click(drpAddProjectsClose);
			} catch (Exception e) {
				util.click(drpAddProjectsClose);
				By valueLocator = By.xpath("//ul//li[normalize-space()='"+value+"']//input");
				util.scrollToElement(valueLocator);
				util.click(valueLocator);
				util.click(drpAddProjectsClose);
			}
		}

		public void clickOnGoProject() {
			util.click(btnGoProject);
			util.waitFor(5000);
		}

		public void selectListOfTrack(String value) {
			try {
				util.selectValueFromDropdown(drpListOfTrack, value);
				util.click(drpListOfTrackClose);
			} catch (Exception e) {
				util.click(drpListOfTrackClose);
				util.click(By.xpath("//ul//li[normalize-space()='"+value+"']//input"));
				util.click(drpListOfTrackClose);
			}
		}
		public void selectListOfLeases(String value) {
			try {
				util.selectValueFromDropdown(drpListofLeases, value);
				util.click(drpListofLeasesClose);
			} catch (Exception e) {
				util.click(drpListofLeasesClose);
				util.click(By.xpath("//ul//li[normalize-space()='"+value+"']//input"));
				util.click(drpListofLeasesClose);
			}
		}
		

		public void clickOnListOfTract() {
			util.click(btnAddListOfTract);
		}

		public void refreshListOfTract() {
			util.click(btnRefreshListTract);
		}

		public String getListOfTractMessage() {
			return util.getText(listTractMessage);
		}

		public void ClickOnStep1Link() {
//			util.switchToIframe(FullFrm);
			util.waitUntilElementDisplay(Step1Link);
			util.click(Step1Link);
			util.switchToIframe(Iframe);
		}
		
		public void ClickOnSave() {
			util.waitUntilElementDisplay(save);
			util.click(save);
			util.waitUntilElementDisplay(SuccessfulMessage);
			Assert.assertTrue(util.isElementPresent(SuccessfulMessage), "Changes saved successfully.");
		}
		
		public void AddReviewerComment(String value) {
			if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtComment, value);
		}
		
		public void ClickonApproveButton() {
			util.waitUntilElementDisplay(btnApprove);
			util.click(btnApprove);
			util.switchToDefaultContent();
		}
		
		public void ClickonRequesterLink() {
			util.dummyWait(2);
			util.waitUntilElementDisplay(linkApprove);
			util.click(linkApprove);
			
			util.switchToIframe(Iframe);
			util.waitUntilElementDisplay(LinkRequester);
			util.click(LinkRequester);
		}
		
		public void ClickonCloseButton() {
			util.waitUntilElementDisplay(btnClose);
			util.click(btnClose);
			util.switchToDefaultContent();
			util.switchToIframe(iframeWorkflow);
			util.click(btnClose);
			
			
			
		}
	    
	 
	  
	    public void AddDocuments(Map<String, String> map, String testcaseName) {
	    if(testcaseName.contains("DOT")) {
	    	try {
	    		ClickonDocumentsTab();
	    		util.dummyWait(2);
				log("STEP 1: Document  window should display on documents tab    ", Status.PASS);
			} catch (Exception e) {
				log("STEP 1:  The document  window does not display ", Status.FAIL);
				throw new RuntimeException("Failed in step 1");
			}
	    }	
	    else {
	    	try {
	    		ClickonDocumentsTab();
	    		util.dummyWait(2);
				log("STEP 1: Document  window should display on documents tab    ", Status.PASS);
			} catch (Exception e) {
				log("STEP 1:  The document  window does not display ", Status.FAIL);
				throw new RuntimeException("Failed in step 1");
			}
	    	
	    	try {
	    		ClickonAddDocuments();
				log("STEP 2: Document popup window should display with external documents tab ", Status.PASS);
			} catch (Exception e) {
				log("STEP 2: The document pop window does not display ", Status.FAIL);
				throw new RuntimeException("Failed in step 2");
			}
	    
	    	try {
	    		util.switchToIframe(iframeDocument);
	    		 util.dummyWait(5);
	    		uploadFile();
				log("STEP 3: User can upload document from the system  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 3: User cannot upload a document ", Status.FAIL);
				throw new RuntimeException("Failed in step 3");
			}
	    	
	    	if(testcaseName.contains("ALT")) {
	    	 try {
	    		 util.dummyWait(10);
 	    		 util.click(drpCategory);
	    		 selectCategory(map.get(Excel.DocCategory));
	  			 log("STEP 4:  Value added display in Category field  ", Status.PASS);
	  		 } catch (Exception e) {
	  			log("STEP 4:  User  cannot select  value  from Category DD  ", Status.FAIL);
	  			throw new RuntimeException("Failed in step 4");
	  		 }
	    	 
	    	 try {
	    		 AddDescription(map.get(Excel.Description));
	  			 log("STEP 5:  User can enter a value in Description field   ", Status.PASS);
	  		 } catch (Exception e) {
	  			log("STEP 5:  User cannot add a value in Description field   ", Status.FAIL);
	  			throw new RuntimeException("Failed in step 5");
	  		 }
	    	 
	    	}
	    	
	    	else {
	    		
	    		 try {
		    		 util.dummyWait(10);
	 	    		 util.click(drpCategoryROW);
		    		 selectCategoryRow(map.get(Excel.DocCategory));
		  			 log("STEP 4:  Value added display in Category field  ", Status.PASS);
		  		 } catch (Exception e) {
		  			log("STEP 4:  User  cannot select  value  from Category DD  ", Status.FAIL);
		  			throw new RuntimeException("Failed in step 4");
		  		 }
		    	 
		    	 try {
		    		 AddDescriptionRow(map.get(Excel.Description));
		  			 log("STEP 5:  User can enter a value in Description field   ", Status.PASS);
		  		 } catch (Exception e) {
		  			log("STEP 5:  User cannot add a value in Description field   ", Status.FAIL);
		  			throw new RuntimeException("Failed in step 5");
		  		 }
		    	 
	    	}	
	    	
	    	
	    	 try {
	    		 ClickonLoadDocuments();
	  			 log("STEP 6:  document is loaded  ", Status.PASS);
	  		 } catch (Exception e) {
	  			log("STEP 6:  docuemnt could not be uploaded.  ", Status.FAIL);
	  			throw new RuntimeException("Failed in step 6");
	  		 }
	    	 
	    	 
	    	 try {
	    		 ClickonExternalLink();
	  			 log("STEP 7: panel is expanded & fields are visible ", Status.PASS);
	  		 } catch (Exception e) {
	  			log("STEP 7:  Panel is not expanded  ", Status.FAIL);
	  			throw new RuntimeException("Failed in step 7");
	  		 }
	    	 
	    	if(testcaseName.contains("ALT")) { 
	    	 
	    	 try {
	    		 AddDocumentName(map.get(Excel.DocumentName));
	  			 log("STEP 8:  User can enter a value in Document Name field   ", Status.PASS);
	  		 } catch (Exception e) {
	  			log("STEP 8:  User cannot add a value in Document Name field   ", Status.FAIL);
	  			throw new RuntimeException("Failed in step 8");
	  		 }
	    
	    	 try {
	    		 AddExternalLink(map.get(Excel.ExternalLink));
	  			 log("STEP 9:   User can enter a value in External Link field ", Status.PASS);
	  		 } catch (Exception e) {
	  			log("STEP 9:  User cannot add a value in External Link field  ", Status.FAIL);
	  			throw new RuntimeException("Failed in step 9");
	  		 }
	    	 
	    	 try {
	    		 AddCategoryForExeLink(map.get(Excel.DocCategory));
	  			 log("STEP 10: Added value displays in Category field ", Status.PASS);
	  		 } catch (Exception e) {
	  			log("STEP 10:  No value displays in Category Dropdown  ", Status.FAIL);
	  			throw new RuntimeException("Failed in step 10");
	  		 }
	    	 
	    	 try {
	    		 AddDescriptionExelink(map.get(Excel.GroupDescription));
	  			 log("STEP 11:  User can enter a value in Description field ", Status.PASS);
	  		 } catch (Exception e) {
	  			log("STEP 11:  User cannot add a value in Description field  ", Status.FAIL);
	  			throw new RuntimeException("Failed in step 11");
	  		 }
	    	 
	    	}
	    	
	    	else {
	    		
	    		try {
		    		 AddDocumentNameRow(map.get(Excel.DocumentName));
		  			 log("STEP 8:  User can enter a value in Document Name field   ", Status.PASS);
		  		 } catch (Exception e) {
		  			log("STEP 8:  User cannot add a value in Document Name field   ", Status.FAIL);
		  			throw new RuntimeException("Failed in step 8");
		  		 }
		    
		    	 try {
		    		 AddExternalLinkRow(map.get(Excel.ExternalLink));
		  			 log("STEP 9:   User can enter a value in External Link field ", Status.PASS);
		  		 } catch (Exception e) {
		  			log("STEP 9:  User cannot add a value in External Link field  ", Status.FAIL);
		  			throw new RuntimeException("Failed in step 9");
		  		 }
		    	 
		    	 try {
		    		SelectCategory();
		  			 log("STEP 10: Added value displays in Category field ", Status.PASS);
		  		 } catch (Exception e) {
		  			log("STEP 10:  No value displays in Category Dropdown  ", Status.FAIL);
		  			throw new RuntimeException("Failed in step 10");
		  		 }
		    	 
		    	 try {
		    		 AddDescriptionROW(map.get(Excel.GroupDescription));
		  			 log("STEP 11:  User can enter a value in Description field ", Status.PASS);
		  		 } catch (Exception e) {
		  			log("STEP 11:  User cannot add a value in Description field  ", Status.FAIL);
		  			throw new RuntimeException("Failed in step 11");
		  		 }
	    		
	    		
	    	}
	    	 
	    	 try {
	    		 ClickOnLoadDocumentsExeLink();
	  			 log("STEP 12:  document is loaded   ", Status.PASS);
	  		 } catch (Exception e) {
	  			log("STEP 12:  docuemnt could not be uploaded  ", Status.FAIL);
	  			throw new RuntimeException("Failed in step 12");
	  		 }
	    	 
	    	 try {
	    		 ClickOnAddExeLink();
	  			 log("STEP 13:  User can click on add button.   ", Status.PASS);
	  		 } catch (Exception e) {
	  			log("STEP 13:  User cannot click on add button  ", Status.FAIL);
	  			throw new RuntimeException("Failed in step 13");
	  		 }
	    	 
	    	 try {
	    		 ClickOnCloseDocument();
	  			 log("STEP 14:  POpup should get closed ", Status.PASS);
	  		 } catch (Exception e) {
	  			log("STEP 14:  popup does not get closed  ", Status.FAIL);
	  			throw new RuntimeException("Failed in step 14");
	  		 }
	    	 
	    	 try {
	    		 ClickOnDownloadSelected();
	  			 log("STEP 15:  selected document will be downloaded  ", Status.PASS);
	  		 } catch (Exception e) {
	  			log("STEP 15:  selected document will not be downloaded   ", Status.FAIL);
	  			throw new RuntimeException("Failed in step 15");
	  		 }
                 util.dummyWait(3);
	    	 try {
	    		 ClickOnEmailSelected();
	  			 log("STEP 16:  email selected document will be downloaded    ", Status.PASS);
	  		 } catch (Exception e) {
	  			log("STEP 16: email selected document will not be downloaded   ", Status.FAIL);
	  			throw new RuntimeException("Failed in step 16");
	  		 }
	    } 
	    	 try {
	    		 ClickOnNotes();
	    		 util.dummyWait(2);
	    		 ClickOnAddNotes();
	  			 log("STEP 17: User can click on the add Notes button  ", Status.PASS);
	  		 } catch (Exception e) {
	  			log("STEP 17:  User cannot see the add Notes button  ", Status.FAIL);
	  			throw new RuntimeException("Failed in step 17");
	  		 }
	    	 
	    	 
	    	 try {
	    		 AddActivityDate(map.get(Excel.ActivityDate));
	  			 log("STEP 18:  User can select Activity  Date   ", Status.PASS);
	  		 } catch (Exception e) {
	  			log("STEP 18:  User  cannot select Activity Date  from Date Picker ", Status.FAIL);
	  			throw new RuntimeException("Failed in step 18");
	  		 }
	    	 
	    	 try {
	    		 SelectAgent(map.get(Excel.Agent));	
		         log("STEP 19:   Added value displays in Agent field ", Status.PASS);
	  		 } catch (Exception e) {
	  			log("STEP 19:  User  cannot select  value  from Agent DD  ", Status.FAIL);
	  			throw new RuntimeException("Failed in step  19");
	  		 }
	    	 
	    	 try {
	    		 SelectNotesCategory(map.get(Excel.Category));
	  			 log("STEP 20:  Added value displays in Category field ", Status.PASS);
	  		 } catch (Exception e) {
	  			log("STEP 20:  User  cannot select  value  from Category DD  ", Status.FAIL);
	  			throw new RuntimeException("Failed in step 20");
	  		 }
	  
	    	 
	    	 try {
	    		 SelectPriority(map.get(Excel.Priority));
	  			 log("STEP 21:  Added value displays in Priority field ", Status.PASS);
	  		 } catch (Exception e) {
	  			log("STEP 21:  User  cannot select  value  from Priority DD  ", Status.FAIL);
	  			throw new RuntimeException("Failed in step 21");
	  		 }
	    	 
	    	 try {
	    		 AddNotesDescription(map.get(Excel.Description));
	  			 log("STEP 22:  User can enter a value in the description field ", Status.PASS);
	  		 } catch (Exception e) {
	  			log("STEP 22:  User cannot add a value in Description field   ", Status.FAIL);
	  			throw new RuntimeException("Failed in step 22");
	  		 }
	    	 
	    	 if(testcaseName.contains("DOT")) {
	    		 try {
	    		 ClickonAddNoteDot();
	  			 log("STEP 23:  The added notes displays in the grid    ", Status.PASS);
	  		 } catch (Exception e) {
	  			log("STEP 23:  Added values does  not displayed in the grid.   ", Status.FAIL);
	  			throw new RuntimeException("Failed in step 23");
	  		 }
	    		 
	     }
	    	 else {
	    	 try {
	    		 ClickonAddNote();
	  			 log("STEP 23:  The added notes displays in the grid   ", Status.PASS);
	  		 } catch (Exception e) {
	  			log("STEP 23:  Added values does  not displayed in the grid.   ", Status.FAIL);
	  			throw new RuntimeException("Failed in step 25");
	  		 }
	    }	 
	    	 
	   	 ClickonClose();
	  			
	    	 if(testcaseName.contains("DOT")) {
	    	 try {
	    		 ClickonLinkedApprovals();
	  			 log("STEP 24: record will be visible on grid. ", Status.PASS);
	  		 } catch (Exception e) {
	  			log("STEP 24:   record will not be visible on grid.  ", Status.FAIL);
	  			throw new RuntimeException("Failed in step 24");
	  		 }
	    	 
	    	 try {
	    	 util.click(btnApproval);   
    		 ClickOnStep1Link();
    		 log("STEP 25: These steps are from parcel workflow TC10 ", Status.PASS);
 			log("STEP 25: Step Name Link should be clicked successfully ", Status.PASS);
 		 } catch (Exception e) {
 			log("STEP 25:  Pop Up should not appeared   ", Status.FAIL);
 			throw new RuntimeException("Failed in step 25");
 		 }
    	 
    	 try {
    		 ClickOnSave();
 			log("STEP 26:Message - 'Changes saved sucessfully!' in green displays  ", Status.PASS);
 		 } catch (Exception e) {
 			log("STEP 26:  User cannot click on save button ", Status.FAIL);
 			throw new RuntimeException("Failed in step 26");
 		 }
    	 
    	 try {
    		 AddReviewerComment(map.get(Excel.Comment));
 			log("STEP 27: User can enter Comment ", Status.PASS);
 		 } catch (Exception e) {
 			log("STEP 27: User cannot enter Comment  ", Status.FAIL);
 			throw new RuntimeException("Failed in step 27");
 		 }
    	 
    	 try {
    		 ClickonApproveButton();
    		 util.switchToIframe(FullFrm);
    		 util.dummyWait(1);
 			log("STEP 28: User can click on Approve button successfully  ", Status.PASS);
 		 } catch (Exception e) {
 			log("STEP 28: Pop Up should not appeared   ", Status.FAIL);
 			throw new RuntimeException("Failed in step 28");
 		 }
    	 
    	 try {
    		 ClickonRequesterLink();
 			log("STEP 29: User can click on requestor link   ", Status.PASS);
 		 } catch (Exception e) {
 			log("STEP 29: User cannot click on requestor link  ", Status.FAIL);
 			throw new RuntimeException("Failed in step 29");
 		 }
    	 
    	 ClickonCloseButton();
 	 
	   	}
	    	 
	    	 
	    	 else {
	    		 
	    		 try {
		    		 ClickonLinkedApprovals();
		  			 log("STEP 24: record will be visible on grid. ", Status.PASS);
		  		 } catch (Exception e) {
		  			log("STEP 24:   record will not be visible on grid.  ", Status.FAIL);
		  			throw new RuntimeException("Failed in step 24");
		  		 }
	    		 
	    	 try {
	    		 navigatetoAssociatedRecord();
	  			 log("STEP 25: The Record tab displays ;if field does not exists in the instance  and skip the step   ", Status.PASS);
	  		 } catch (Exception e) {
	  			log("STEP 25:  The Record tab does not load ", Status.FAIL);
	  			throw new RuntimeException("Failed in step 25");
	  		 }
	    	 
			try {
				selectProject(map.get(Excel.ProjectName));
				clickOnGoProject();
				log("STEP 26: Selected a project from DD and click on GO button", Status.PASS);
			} catch (Exception e) {
				log("STEP 26: Selected a project from DD and click on GO button", Status.FAIL);
				throw new RuntimeException("Failed in step 26");
			}
			SoftAssert softAssert = new SoftAssert();
			try {
				selectListOfTrack(map.get(Excel.ListOfTrack));
				Thread.sleep(5000);
				selectListOfLeases(map.get(Excel.ListOfLeases));
				refreshListOfTract();
				Thread.sleep(5000);
				clickOnListOfTract();
				softAssert.assertEquals(getListOfTractMessage(), "Requested association created successfully",
						"Success message is mismatch");
				log("STEP 27: Select a Tract list from the DD and click on Add ", Status.PASS);
			} catch (Exception e) {
				log("STEP 27: Select a Tract list from the DD and click on Add ", Status.FAIL);
				throw new RuntimeException("Failed in step 27");
			}
	    } 
	 
    }    
	    
}
