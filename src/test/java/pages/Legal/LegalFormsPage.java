package pages.Legal;


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

public class LegalFormsPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;
	public static String AGREEMENT_NUMBER;

	public LegalFormsPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		
	}
	
	
//	By btnAddNew = By.xpath("(//img[@alt='Add new record'])[2]");
	By btnAddNew = By.xpath("//img[contains(@id,'ctl00_ConPHRightTop_TRLG_UC_radPanels_i6_i0_YALWorkflows_radYALGridControl_ctl00_ctl02_ctl00_Img4')]");
	 By FullFrm = By.xpath("//iframe[@name='ManageApprovalDialog']");
		By drpApprovalType = By.xpath("//input[contains(@id,'idManageApproval_cbParcelApprovalType_YALComboBox_Input') and @type='text']");
		By radiobtnNo = By.xpath("//label[contains(text(),'No')]");
		By btnSave = By.xpath("//input[contains(@id,'idManageApproval_btnSaveHeader') and @type='image']");
		By SuccessfulMessage = By.xpath("//span[text()='Changes saved successfully.']");
//		By btnSubmitforReview = By.xpath("//input[contains(@id,'_btnSubmit') and @type='image']");
		By btnSubmitforReview = By.xpath("//input[contains(@id,'_btnSubmit') and @type='button']");
		By Step1Link = By.xpath("//a[contains(text(),'In-Review')]");
		By iframe = By.xpath("//iframe[@name='geoPopUpWF']");
		By save = By.xpath("//input[@id='idApproveInLineWorkflow_btnSaveReviewLogData']");
		By txtComment = By.xpath("//textarea[@id='idApproveInLineWorkflow_txtReviewerComments']");
		By btnApprove = By.xpath("//input[contains(@id,'_btnApprove') and @type='submit']");
		By linkApprove = By.xpath("//a[contains(text(),'Approved')]");
		By LinkRequester = By.xpath("//a[contains(text(),'Requestor')]");
		By btnClose = By.xpath("//a[@title='Close']");
		By btnDocuments = By.xpath("//span[text()='Documents']");
		By btnAddDocuments = By.xpath("//input[contains(@id,'idManageApproval_btnAddDocuments') and @type='button']");
		By iframeDocument = By.xpath("//iframe[@name='AddDocuments']");
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
		By btnLoadDocuments = By.xpath("//input[contains(@id,'RadPanelBar1_i0_i0_buttonSubmit_input') and @type='submit']");
		By btnExternalLink = By.xpath("(//span[@class='rpExpandHandle'])[2]");
//	    By drpCategoryROW = By.xpath("//select[contains(@id,'_rauFileUploadCategoryDD0')]");
//		By txtDescriptionROW = By.xpath("//input[@id='RadPanelBar1_i0_i0_rauFileUploadDesc0']");
		By txtDescriptionROW = By.xpath("//input[contains(@id,'RadPanelBar1_i0_i0_rauFileUploadDesc')]");
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
		By CategoryRow = By.xpath("//div[@id='RadPanelBar1_i0_i0_rauFileUploadundefined1']");
	    By CategoryFilter = By.xpath("//input[@class='rddtFilterInput radPreventDecorate rddtFilterEmptyMessage']");
//	    By CategoryFilter = By.xpath("(//span[contains(text(),'Docusign Demo') and @class='rtIn'])[1]");
	    
	
	
	public void ClickOnAddButton() {
		util.waitUntilElementDisplay(btnAddNew);
		util.click(btnAddNew);
	}
	public void SelectApprovalType(String value) {
		util.switchToIframe(FullFrm);
		util.dummyWait(2);
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpApprovalType, value);
	}
	
	public void ClickonSaveButton() {
		util.waitUntilElementDisplay(radiobtnNo);
		util.click(radiobtnNo);
		util.waitUntilElementDisplay(btnSave);
		util.click(btnSave);
		util.waitUntilElementDisplay(SuccessfulMessage);
		Assert.assertTrue(util.isElementPresent(SuccessfulMessage), "Changes saved successfully.");
	}
	
	public void ClickOnSubmitForReviewButton() {
		util.waitUntilElementDisplay(btnSubmitforReview);
		util.click(btnSubmitforReview);
		util.dummyWait(3);
	
	}
	
	public void ClickonDocumentsTab()
	{
		util.waitUntilElementDisplay(btnDocuments);
		util.click(btnDocuments);	    	
		    
	}
	 
	
	public void ClickonAddDocuments(){
		util.waitUntilElementDisplay(btnAddDocuments);
		util.click(btnAddDocuments);	    	
		    
	}
	
	By fileUpload = By.xpath("//input[contains(@id,'FileUploadfile')]");
	public void uploadFile() {
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
	  public void selectCategoryRow(String value) {
		     if (!commonFunction.checkNA(value)) 
		        util.waitUntilElementDisplay(CategoryRow);
		        util.click(CategoryRow);    
		        util.inputTextAndPressTab(CategoryFilter, value);
		        util.pressENTERkey();

		 }
	  
	  
	  public void ClickonLoadDocuments() {
			util.waitUntilElementDisplay(btnLoadDocuments);
			util.click(btnLoadDocuments);
			
		}
	  
	  public void ClickonExternalLink() {
			util.waitUntilElementDisplay(btnExternalLink);
			util.click(btnExternalLink);
		}
	
	 
	  public void AddDescriptionRow(String value) {
			if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtDescriptionROW, value);
		}
	
	  public void AddDocumentNameRow(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtDocumentNameRow, value);
	    }
	    
	    
	    
	    public void AddExternalLinkRow(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtExternalLinkRow, value);
	    }
	    
	    By selectCategory_ExternalLink = By.xpath("//input[contains(@id,'YALDropDownList_Input')]");

		public void selectCategoryExternalLink(String value) {
			util.waitUntilElementDisplay(selectCategory_ExternalLink);
			util.inputTextAndPressTab(selectCategory_ExternalLink, value);
		}

		By selectCategory_ExternalLinkDOT = By.xpath("//div[@id='radReportConfigPanels_i0_i0_XYZ1_RadDropDownTree1'] | //input[contains(@id,'XYZ1_radYALDropDownList_Input')]");

		public void selectCategoryExternalLinkDOT(String value) {
			if (!commonFunction.checkNA(value)) {
			util.waitUntilElementDisplay(selectCategory_ExternalLinkDOT);
			util.selectValueFromDropdown3(selectCategory_ExternalLinkDOT, value);}
		}
	    
	    
	    public void SelectCategory(String value) {
	    	util.waitUntilElementDisplay(Category);
	    	util.click(Category);
	    	util.waitUntilElementDisplay(SelectCategory);
	    	util.click(SelectCategory);
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
    
   
    public void ClickonAddNote() {
    	util.waitUntilElementDisplay(btnaddNotes);
    	util.click(btnaddNotes);
    	util.waitUntilElementDisplay(Successmsg);
    	Assert.assertTrue(util.isElementPresent(Successmsg), "Note submitted for review.");
    	util.dummyWait(1);
    }

   By Iframe= By.xpath("//iframe[@name='ManageApprovalDialog']");
    public void ClickonClose() {
		util.switchToDefaultContent();
    	util.dummyWait(1);
    	util.switchToIframe(Iframe);
        util.dummyWait(1);
	    util.waitUntilElementDisplay(btnCloseNotes);
    	util.click(btnCloseNotes);
        util.dummyWait(1);
        

    }
    
    By icon = By.xpath("//img[contains(@id,'_radYALGridControl_ctl00_ctl02_ctl00_Img3')]");
    public void ClickonLinkedApprovals() {
    	util.waitUntilElementDisplay(linkLinkedApprovals);
    	util.click(linkLinkedApprovals);
		util.dummyWait(1);
		util.waitUntilElementDisplay(icon);
		util.click(icon);
		util.dummyWait(1);
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
		util.dummyWait(2);
		util.click(btnApproval);
		util.waitUntilElementDisplay(Step1Link);
		util.click(Step1Link);
		util.switchToIframe(iframe);
	}
	
	
	
	public void ClickonRequesterLink() {
		util.waitUntilElementDisplay(LinkRequester);
		util.click(LinkRequester);
	}
	
	public void ClickonCloseButton() {
		util.switchToDefaultContent();
		util.click(btnClose);
		util.dummyWait(1);
	}
	
	 
    public void LegalForm(Map<String, String> map, String testcaseName) {
    
    	 if (testcaseName.contains("DOT") || testcaseName.contains("ALT") || testcaseName.contains("ORSTED")||testcaseName.contains("ORION") || testcaseName.contains("ATWELL")) {
				log(" Survey Approval not applicable for DOT and ALT", Status.SKIP);
			}
			else {
		 
    	 try {
    		 ClickOnAddButton();
 			log("STEP 1: The Pop up should be appear  ", Status.PASS);
 		 } catch (Exception e) {
 			log("STEP 1: The Pop Up should not appear  ", Status.FAIL);
 			throw new RuntimeException("Failed in step 1");
 		 }
    	 
    	 try {
    		 SelectApprovalType(map.get(Excel.ApprovalType));
 			log("STEP 2:  The selected Approval Form fields should be appears  ", Status.PASS);
 		 } catch (Exception e) {
 			log("STEP 2: The Workflow cannot be selected ", Status.FAIL);
 			throw new RuntimeException("Failed in step 2");
 		 }
    	 
    	 try {
    		 ClickonSaveButton();
 			log("STEP 3:Message - 'Changes saved sucessfully!' in green displays   ", Status.PASS);
 		 } catch (Exception e) {
 			log("STEP 3:  Added values are not saved  ", Status.FAIL);
 			throw new RuntimeException("Failed in step 3");
 		 }
    	 
    	 try {
	    		ClickonDocumentsTab();
	    		util.dummyWait(2);
				log("STEP 4: Document  window should display on documents tab    ", Status.PASS);
			} catch (Exception e) {
				log("STEP 4:  The document  window does not display ", Status.FAIL);
				throw new RuntimeException("Failed in step 4");
			}
	    	
	    	try {
	    		ClickonAddDocuments();
				log("STEP 5: Document popup window should display with external documents tab ", Status.PASS);
			} catch (Exception e) {
				log("STEP 5: The document pop window does not display ", Status.FAIL);
				throw new RuntimeException("Failed in step 5");
			}
	    
	    	try {
	    		util.switchToIframe(iframeDocument);
	    		 util.dummyWait(5);
	    		uploadFile();
				log("STEP 6: User can upload document from the system  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 6: User cannot upload a document ", Status.FAIL);
				throw new RuntimeException("Failed in step 6");
			}
	    	

 		 if(util.isElementPresent(drpCategoryROWTree)) {
	   			try {
	 	   				selectCategoryTree(map.get(Excel.DocCategory));
	 	   				log("STEP 7:  User can select Category", Status.PASS);
	 	   			} catch (Exception e) {
	 	   				log("STEP 7:  User can not select Category", Status.FAIL);
	 	   				throw new RuntimeException("STEP 7:  User can not select Category");
	 	   			}
	 	   		}else {
	 	   		try {
	 	   			selectCategoryROW(map.get(Excel.DocCategory));
	 	   			log("STEP 7:  User can select Category", Status.PASS);
	 	   		} catch (Exception e) {
	 	   			log("STEP 7:  User can not select Category", Status.FAIL);
	 	   			throw new RuntimeException("STEP 7:  User can not select Category");
	 	   		}
	 	   		}
	 		    	 
	 	    		try {
	 	   			setDescription(map.get(Excel.Description));
	 	   			log("STEP 8: Fill in Description", Status.PASS);
	 	   		} catch (Exception e) {
	 	   			log("STEP 8: Fill in Description", Status.FAIL);
	 	   			throw new RuntimeException("Failed in step 8");
	 	   		}
	    	 
	    	 try {
	    		 ClickonLoadDocuments();
	  			 log("STEP 9:  document is loaded  ", Status.PASS);
	  		 } catch (Exception e) {
	  			log("STEP 9:  docuemnt could not be uploaded.  ", Status.FAIL);
	  			throw new RuntimeException("Failed in step 9");
	  		 }
	    	 
	    	 
	    	 try {
	    		 ClickonExternalLink();
	  			 log("STEP 10: panel is expanded & fields are visible ", Status.PASS);
	  		 } catch (Exception e) {
	  			log("STEP 10:  Panel is not expanded  ", Status.FAIL);
	  			throw new RuntimeException("Failed in step 10");
	  		 }
	    	 
	    	 try {
	    		 AddDocumentNameRow(map.get(Excel.DocumentName));
	  			 log("STEP 11:  User can enter a value in Document Name field   ", Status.PASS);
	  		 } catch (Exception e) {
	  			log("STEP 11:  User cannot add a value in Document Name field   ", Status.FAIL);
	  			throw new RuntimeException("Failed in step 11");
	  		 }
	    
	    	 try {
	    		 AddExternalLinkRow(map.get(Excel.ExternalLink));
	  			 log("STEP 12:   User can enter a value in External Link field ", Status.PASS);
	  		 } catch (Exception e) {
	  			log("STEP 12:  User cannot add a value in External Link field  ", Status.FAIL);
	  			throw new RuntimeException("Failed in step 12");
	  		 }
	    	 
	    	 try {
	    		 if (util.isElementPresent(selectCategory_ExternalLink)) {
						selectCategoryExternalLink(map.get(Excel.DocCategory));
					} else {
						selectCategoryExternalLinkDOT(map.get(Excel.DocCategory));}
	  			 log("STEP 13: Added value displays in Category field ", Status.PASS);
	  		 } catch (Exception e) {
	  			log("STEP 13:  No value displays in Category Dropdown  ", Status.FAIL);
	  			throw new RuntimeException("Failed in step 13");
	  		 }
	    	 
	    	 try {
	    		 AddDescriptionROW(map.get(Excel.GroupDescription));
	  			 log("STEP 14:  User can enter a value in Description field ", Status.PASS);
	  		 } catch (Exception e) {
	  			log("STEP 14:  User cannot add a value in Description field  ", Status.FAIL);
	  			throw new RuntimeException("Failed in step 14");
	  		 }
	    	 
	    	 try {
	    		 ClickOnLoadDocumentsExeLink();
	  			 log("STEP 15:  document is loaded   ", Status.PASS);
	  		 } catch (Exception e) {
	  			log("STEP 15:  docuemnt could not be uploaded  ", Status.FAIL);
	  			throw new RuntimeException("Failed in step 15");
	  		 }
	    	 
	    	 try {
	    		 ClickOnAddExeLink();
	  			 log("STEP 16:  User can click on add button.   ", Status.PASS);
	  		 } catch (Exception e) {
	  			log("STEP 16:  User cannot click on add button  ", Status.FAIL);
	  			throw new RuntimeException("Failed in step 16");
	  		 }
	    	 
	    	 try {
	    		 ClickOnCloseDocument();
	  			 log("STEP 17:  POpup should get closed ", Status.PASS);
	  		 } catch (Exception e) {
	  			log("STEP 17:  popup does not get closed  ", Status.FAIL);
	  			throw new RuntimeException("Failed in step 17");
	  		 }
	    	 
	    	 try {
	    		 ClickOnDownloadSelected();
	    		 util.dummyWait(2);
	  			 log("STEP 18:  selected document will be downloaded  ", Status.PASS);
	  		 } catch (Exception e) {
	  			log("STEP 18:  selected document will not be downloaded   ", Status.FAIL);
	  			throw new RuntimeException("Failed in step 18");
	  		 }

	    	 try {
	    		 ClickOnEmailSelected();
	    		 util.dummyWait(1);
	  			 log("STEP 19:  email selected document will be downloaded    ", Status.PASS);
	  		 } catch (Exception e) {
	  			log("STEP 19: email selected document will not be downloaded   ", Status.FAIL);
	  			throw new RuntimeException("Failed in step 19");
	  		 }
 	 
 	 try {
 		 ClickOnNotes();
 		 util.dummyWait(2);
 		 ClickOnAddNotes();
			 log("STEP 20: User can click on the add Notes button  ", Status.PASS);
		 } catch (Exception e) {
			log("STEP 20:  User cannot see the add Notes button  ", Status.FAIL);
			throw new RuntimeException("Failed in step 20");
		 }
 	 
 	 
 	 try {
 		 AddActivityDate(map.get(Excel.ActivityDate));
			 log("STEP 21:  User can select the  Activity Date   ", Status.PASS);
		 } catch (Exception e) {
			log("STEP 21:  User  cannot select  Date  from Date Picker ", Status.FAIL);
			throw new RuntimeException("Failed in step 21");
		 }
 	 
 	 try {
 		 SelectAgent(map.get(Excel.Agent));	
	         log("STEP 22:   Added value displays in Agent field ", Status.PASS);
		 } catch (Exception e) {
			log("STEP 22:  User  cannot select  value  from Agent DD  ", Status.FAIL);
			throw new RuntimeException("Failed in step 22");
		 }
 	 
 	 try {
 		 SelectNotesCategory(map.get(Excel.Category));
			 log("STEP 23:  Added value displays in Category field ", Status.PASS);
		 } catch (Exception e) {
			log("STEP 23:  User  cannot select  value  from Category DD  ", Status.FAIL);
			throw new RuntimeException("Failed in step 23");
		 }

 	 
 	 try {
 		 SelectPriority(map.get(Excel.Priority));
			 log("STEP 24:  Added value displays in Priority field ", Status.PASS);
		 } catch (Exception e) {
			log("STEP 24:  User  cannot select  value  from Priority DD  ", Status.FAIL);
			throw new RuntimeException("Failed in step 24");
		 }
 	 
 	 try {
 		 AddNotesDescription(map.get(Excel.Description));
			 log("STEP 25:  User can enter a value in the description field ", Status.PASS);
		 } catch (Exception e) {
			log("STEP 25:  User cannot add a value in the field   ", Status.FAIL);
			throw new RuntimeException("Failed in step 25");
		 }
 	 
 	 try {
 		 ClickonAddNote();
			 log("STEP 26:  The added notes displays in the grid   ", Status.PASS);
		 } catch (Exception e) {
			log("STEP 26:  Added values does  not displayed in the grid.   ", Status.FAIL);
			throw new RuntimeException("Failed in step 26");
		 }
 	 ClickonClose();
 	 try {
 		 ClickonLinkedApprovals();
			 log("STEP 27: record will be visible on grid. ", Status.PASS);
		 } catch (Exception e) {
			log("STEP 27:   record will not be visible on grid.  ", Status.FAIL);
			throw new RuntimeException("Failed in step 27");
		 }
		 
	 try {
		 navigatetoAssociatedRecord();
			 log("STEP 28: The Record tab displays ;if field does not exists in the instance  and skip the step   ", Status.PASS);
		 } catch (Exception e) {
			log("STEP 28:  The Record tab does not load ", Status.FAIL);
			throw new RuntimeException("Failed in step 28");
		 }
	 
	try {
		selectProject(map.get(Excel.ProjectName));
		clickOnGoProject();
		log("STEP 29: Selected a project from DD and click on GO button", Status.PASS);
	} catch (Exception e) {
		log("STEP 29: Selected a project from DD and click on GO button", Status.FAIL);
		throw new RuntimeException("Failed in step 29");
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
		log("STEP 30: Select a Tract list from the DD and click on Add ", Status.PASS);
	} catch (Exception e) {
		log("STEP 30: Select a Tract list from the DD and click on Add ", Status.FAIL);
		throw new RuntimeException("Failed in step 16");
	}
	 
 	 try { util.click(btnApproval); 
		 util.dummyWait(2); 
  		 ClickOnSubmitForReviewButton();
			log("STEP 31:   User can click on submit for review button.  ", Status.PASS);
		 } catch (Exception e) {
			log("STEP 31:  User cannot click on submit for review button  ", Status.FAIL);
			throw new RuntimeException("Failed in step 31");
		 }
			
	    	 ClickonCloseButton();
		 util.dummyWait(2); 
      }  		
   }
    
}
