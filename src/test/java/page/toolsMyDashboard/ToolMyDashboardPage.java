package page.toolsMyDashboard;

import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;


public class ToolMyDashboardPage extends BasePage {

	TestUtil util;
	CommonFunction commonFunction;
	String docName="";

	public ToolMyDashboardPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}

	By navTool = By.xpath("*//a//span[@class='rmText rmExpandDown' and contains(text(),'Tools')] ");
	By navMyDashBoard = By.xpath("*//a//span[contains(text(),'Project Group') or contains(text(),'My Dashboard')] ");
	
	
	//Deleted Doc
	By navAdministration = By.xpath("//span[text()='Administration']");
	By navABS = By.xpath("//span[contains(text(),'Application Behavior Settings')]");
	By txtFilterKeyName = By.xpath("//input[@alt='Filter key_name column']");
	By btnFilterKeyName = By.xpath("//input[contains(@id,'Filter_key_name') and @type='button']");
	By optionFilter = By.xpath("//span[text()='Contains']");
    By btnSubmitAll = By.xpath("//input[@title='Submit All']");
    
  
	By navCustomerOutreach = By.xpath("//span[contains(text(),'Customer Outreach')]");
	By navTicketInformation = By.xpath("(//span[contains(text(),'Ticket Information')])[1]");
	By navSecurity = By.xpath("(//span[contains(text(),'Security')])[1]");
	By navUserRoles = By.xpath("(//span[contains(text(),'User Roles')])[1]");
	By navSpecialPermissions = By.xpath("(//span[contains(text(),'Special Permissions')])[1]");
	By approveDocDeletionChecked = By.xpath("//label[contains(text(),'Approve Doc Deletion')]/..//input[@checked='checked']");
	By approveDocDeletionUnchecked = By.xpath("//label[contains(text(),'Approve Doc Deletion')]/..//input[@type='checkbox']");
	By btnSavePermissions = By.xpath("//input[@id='ctl00_ConPHRightTop_savePermissions']");
	By btnLogOff = By.xpath("//input[@alt='Logout']");
	By hereLinkLogIn = By.xpath("//a[@id='UCLogoff_LoginUrl']");
	By txtUsername = By.xpath("//input[@id='UCLogin_inpTxtUserName']"); 
	By txtPassword = By.xpath("//input[@id='UCLogin_inpTxtPassword']");    
	By btnLogin = By.xpath("//input[@id='UCLogin_cmdSubmit_login']");
	By txtUsernameOld = By.xpath("//input[@id='UCLogin_txtUserName']"); 
    By txtPasswordOld = By.xpath("//input[@id='UCLogin_txtPassword']");    
	
    //deleted Doc-Add doc
    By navParcel = By.xpath("//span[text()='Parcel'] | //span[text()='Tract']");
	By navParcelInfo = By.xpath("(//span[text()='Parcel Info'])[1] | //span[text()='Tract Info']");
	By navDocumentManagement = By.xpath("//a[contains(@href,'TractInfo.aspx')]//span[text()='Documents'] | (//span[text()='Parcel Documents'])[1] | //span[text()='Record Information']/../../..//span[text()='Documents']");
	By btnAddDocumentAlt = By.xpath("(//*[contains(@id,'_TRACTTYPE_BtnHeader')]//img[@alt='Add Documents'])[1]");
	By btnAddDocumentDot = By.xpath("//input[contains(@id,'_TRACTTYPE_btnAgentDocs')]");
	By btnAddDocumentRow = By.xpath("//input[contains(@id,'TRACTTYPE_btnAdddocuments')]");
	By iframeDocument = By.xpath("//iframe[@name='AddDocuments'] | //iframe[@name='AddDocumentsNR']");
	By drpCategory = By.xpath("//select[contains(@id,'RadPanelBar1_i0_i0_rauFileUploadCategory')]");
	By txtDescription = By.xpath("//input[contains(@id,'RadPanelBar1_i0_i0_rauFileUploadDesc0') and @type='text']"); 
	By btnLoadDocuments = By.xpath("//input[contains(@id,'buttonSubmit_input') and @type='submit'] | //input[contains(@id,'buttonSubmit_input') and @type='button']");
    By DocumentName = By.xpath("//span[@id='lblResults']");
	By btnClose = By.xpath("//a[@class='rwCloseButton']");
    
    //DOT
    By drpCategoryDOT = By.xpath("//select[contains(@id,'Category')]");
    By txtDescriptionDOT = By.xpath("//textarea[contains(@id,'RadPanelBar1_i0_i0_rauFileUploadDesc')]");
   
    //ROW
    By drpCategoryROW = By.xpath("//select[contains(@id,'_rauFileUploadCategory')] | //select[contains(@id,'_rauFileUploadcategory')]");
    By txtDescriptionROW = By.xpath("//input[contains(@id,'RadUpload1Desc') or contains(@id,'rauFileUploadDesc')] ");
    
    
    //request Delete
    By navDocument = By.xpath("//span//span//span[text()='Documents']");
    By CheckBox = By.xpath("(//input[contains(@id,'_CheckBox1') and @type='checkbox'])[1]");
    By btnRequestDelete = By.xpath("//input[contains(@id,'_btnRequestDelete') and @type='image']");
    By tableRow = By.xpath("//tr[contains(@id,'_DOCUMENT_radYALGridControl_ctl00__0')]");
    By BtnRefresh = By.xpath("//*[contains(@id,'lnkRefresh')]");
    
    
    
    
    
    
    
    
	public void navigateToMyDashBoard() {
		util.waitUntilElementDisplay(navTool);
		util.click(navTool);
		util.waitUntilElementDisplay(navMyDashBoard);
		util.click(navMyDashBoard);
	}

	 public void NavigateToDocumentManagement() {
	        util.waitUntilElementDisplay(navParcel);
	        util.click(navParcel);
	        util.waitUntilElementDisplay(navParcelInfo);
	        util.click(navParcelInfo);
	        util.waitUntilElementDisplay(navDocumentManagement);
	        util.click(navDocumentManagement);
	 	
	    }
	    
	    public void ClickOnAddDocumentALT() {
	    	util.waitUntilElementDisplay(btnAddDocumentAlt);
	    	util.click(btnAddDocumentAlt);
	    	
	    }
	    
	    public void ClickOnAddDocumentDOT() {
	    	util.waitUntilElementDisplay(btnAddDocumentDot);
	    	util.click(btnAddDocumentDot);
	    	
	    }
	    
	    public void ClickOnAddDocumentROW() {
	    	util.waitUntilElementDisplay(btnAddDocumentRow);
	    	util.click(btnAddDocumentRow);
	    	
	      }
	    
	       By fileUpload = By.xpath("//input[contains(@id,'FileUploadfile')]");
	  		public void uploadFile() {
	  			util.dummyWait(1);
	  			docName="test.txt";
	  			String filepath = System.getProperty("user.dir") + File.separator + docName;
	  			driver.findElement(fileUpload).sendKeys(filepath);
	  		}
	  	    
	  	    public void SelectCategory(String value) {
	  	    	if (!commonFunction.checkNA(value))
	  				util.inputTextAndPressTab(drpCategory, value);
	  			
	  	    }
	  	    
	  	  public void SelectCategoryDOT(String value) {
		    	if (!commonFunction.checkNA(value))
					util.inputTextAndPressTab(drpCategoryDOT, value);
				
		    }
	  	    
	  	By drpCategoryROWTree = By.xpath("//div[contains(@id,'rauFileUploadundefined')]");
	    
	    public void selectCategoryTree(String value) {
			if (!commonFunction.checkNA(value)) {
				util.waitForWebElementToBePresent(drpCategoryROWTree);
				util.selectValueFromDropdown3(drpCategoryROWTree, value);			
			}
		}
	    
	  	  public void SelectCategoryROW(String value) {
		    	if (!commonFunction.checkNA(value))
					util.inputTextAndPressTab(drpCategoryROW, value);
				
		    }
	  	    
	  	    public void AddDescription(String value) {
	  	    	if (!commonFunction.checkNA(value))
	  				util.inputTextAndPressTab(txtDescription, value);
	  			
	  	    }
	  	    
	  	  public void AddDescriptionDOT(String value) {
		    	if (!commonFunction.checkNA(value))
					util.inputTextAndPressTab(txtDescriptionDOT, value);
				
		    }
	  	  
	  	public void AddDescriptionROW(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtDescriptionROW, value);
			
	    }
	  	    
	  	    public void LoadDocuments() {
	  	    	util.click(btnLoadDocuments);
	  	    	util.dummyWait(1);
	  	    	Assert.assertTrue(util.isElementPresent(DocumentName));
	  			
	  	    }
	  	    
	  	  public void ClickOnCloseButton() {
	  		  util.switchToDefaultContent();
	  		  util.waitUntilElementDisplay(btnClose);
		    	util.click(btnClose);
				
		    }
	
	
	
	
	
	
	
	
	By tabMyParcel = By.xpath("//*[text()='My Parcels'] | //*[text()='My Tracts'] | //*[text()='My Orion PIDs'] | //*[text()='My Nova Parcel IDs'] | //*[text()='My DocumentNumbers'] | //*[text()='My Parcel(Map/Lot)s']");

	public void clickOnMyParcel() {
		util.waitUntilElementDisplay(tabMyParcel);
		util.click(tabMyParcel);
	}

	//By firstCheckBoxParcel = By.xpath("//input[contains(@id,'ctl00_ConPHRightTop_YALCOM_InMessages_RadGrid1_ctl00_ctl04_CheckBox1')]");
	By firstCheckBoxParcel = By.xpath("//input[@id=\"ctl00_ConPHRightTop_GridDetails_RadGrid1_ctl00_ctl04_CheckBox1\"] | //input[@id=\"ctl00_ConPHRightTop_GridDetails_rgROGrid_ctl00_ctl04_CheckBox1\"]");
	public void clickOnFirstCheckBox() {
		util.waitUntilElementDisplay(firstCheckBoxParcel);
		util.click(firstCheckBoxParcel);
	}

	By btnPDF = By.xpath("(//a[contains(@id,'DownloadPDF')])[1]");

	public void clickOnPDF() {
		util.waitUntilElementDisplay(btnPDF);
		util.click(btnPDF);
	}

	
	//Deleted doc
	
	  public void NavigateToApplicationBehaviorSettings() {
	    	util.waitUntilElementDisplay(navAdministration);
	    	util.click(navAdministration);
	    	util.waitUntilElementDisplay(navABS);
	    	util.click(navABS);
	    }
	 
	    public void enterKeyName(String value) {
			util.waitUntilElementDisplay(txtFilterKeyName);
			util.inputTextAndPressTab(txtFilterKeyName, value);
		}
	    
	    public void selectFilter() {
	    	util.waitFor(300);
	    	if(!util.isElementVisible(optionFilter)) {
			util.waitUntilElementDisplay(btnFilterKeyName);
			util.click(btnFilterKeyName);
			util.click(optionFilter);
			}
		}
	    
	    public void setKeyValue(String key, String value) {
	    	By keyValue = By.xpath("//*[text()='"+key+"']/..//input[contains(@name,'txtValue')]");
	    	util.waitFor(200);
			//util.waitUntilElementDisplay(keyValue);
			util.inputTextAndPressTab(keyValue, value);
		}
	    
	    public void clickOnSubmitAll() {
			util.waitUntilElementDisplay(btnSubmitAll);
			util.click(btnSubmitAll);
			util.waitUntilPageLoad();
		}
	
	
	    public void NavigateToSpecialPermission() {
            util.waitUntilElementDisplay(navAdministration);
	    	util.click(navAdministration);
	    	util.waitUntilElementDisplay(navSecurity);
	    	util.click(navSecurity);
	    	util.waitUntilElementDisplay(navUserRoles);
	    	util.click(navUserRoles);

	    }
	    By drpRole = By.xpath("//input[contains(@id,'DISTRIBUTION_Input')]");
	    public void selectRoleDD(String value) {
			if (!commonFunction.checkNA(value))
				util.selectDropDownValue(drpRole, value);
	    	util.waitUntilElementDisplay(navSpecialPermissions);
	    	util.click(navSpecialPermissions);
		}   
	    
	    
	
	    public void login(String uname, String pass) {
			setUserName(uname);
			setPassword(pass);
			util.click(btnLogin);
		}
	    
	    public void setUserName(String userName) {
			if(util.isElementVisible(txtUsername)) {
			util.inputTextAndPressTab(txtUsername, userName);
			}else {
				util.inputTextAndPressTab(txtUsernameOld, userName);
			}
			
		}

		public void setPassword(String password) {
			if(util.isElementVisible(txtPassword)) {
				util.inputText(txtPassword, password);
			}else {
				util.inputText(txtPasswordOld, password);
			}
		}
	//Delete Doc
	
		  public void SelectCheckBox() {
		    	util.waitUntilElementDisplay(CheckBox);
		    	util.click(CheckBox);
		    }
		    
		    public void ClickonRequestDelete() {
		    	util.waitUntilElementDisplay(btnRequestDelete);
		    	util.click(btnRequestDelete);
		    	
		    }
		    
		     By iframe = By.xpath("//iframe[@name='RadWindowDocRequestDeleteMulti']"); 
		     By drpReason = By.xpath("//input[contains(@id,'idDocRequestDeletion_ddlDeletionReason_radYALDropDownList_Input') and @type='text']");
		     By txtComment = By.xpath("//textarea[@id='idDocRequestDeletion_DeletionReasonComments']");
		     By btnRequestDeletion = By.xpath("//input[@id='idDocRequestDeletion_btnRequestDeletion']");
		    public void ClickonRequestDeleteROW() {
		    	util.waitUntilElementDisplay(btnRequestDelete);
		    	util.click(btnRequestDelete);
		    	util.switchToIframe(iframe);
		    	util.dummyWait(1);
		    }
		    
			By DocumentGrid = By.xpath("(//tr[contains(@id,'_DOCUMENT_radYALGridControl')])[1]");
			By btnRequestDeleteDot = By.xpath("//span[contains(text(),'Request Delete')]");
		    public void ClickonRequestDeleteDOT(String value) {
		    	
		    	By clickOnDocument = By.xpath("(//*[text()='" + value + "'])[1]");
				WebElement RclickOnDocument = driver.findElement(clickOnDocument);
				util.click(clickOnDocument);
				util.Rcllick(RclickOnDocument);
//		    	WebElement web = driver.findElement(DocumentGrid);
//		    	util.waitUntilElementDisplay(DocumentGrid);
//		    	Actions act = new Actions(driver);
//		    	act.moveToElement(web).contextClick().build().perform();
		    	util.dummyWait(1);
		    	util.waitUntilElementDisplay(btnRequestDeleteDot);
		    	util.click(btnRequestDeleteDot);
		    	util.dummyWait(3);
		    }
		    
		    
		    
		    public void SelectReason(String value) {
		    	if (!commonFunction.checkNA(value))
					util.inputTextAndPressTab(drpReason, value);
		    }
		    
		    public void AddComment(String value) {
		    	if (!commonFunction.checkNA(value))
					util.inputTextAndPressTab(txtComment, value);
		    }
		    
		    public void ClickonRequestDeletionButton() {
		    	util.waitUntilElementDisplay(btnRequestDeletion);
		    	util.click(btnRequestDeletion);
		    	util.switchToDefaultContent();
		    	util.dummyWait(2);
		    }
		    
		    By btnCancel = By.xpath("//input[contains(@id,'_btnCancel') and @type='submit']");
		    public void ClickonCancelButton() {
		    	util.waitUntilElementDisplay(btnRequestDelete);
		    	util.click(btnRequestDelete);
		    	util.switchToIframe(iframe);
		    	util.dummyWait(1);
		    	util.waitUntilElementDisplay(btnCancel);
		    	util.click(btnCancel);

		    }
	
	
	
	
	
	public void verifyMyParcel( String testcaseName) {
		navigateToMyDashBoard();
		if (!environment.contains("PRIMERGY") & !environment.contains("ORSTED") & !environment.contains("ALYESKA")& !environment.contains("CONNECTGEN")) {
		try {
			
			clickOnMyParcel();
			log("STEP 1:  Navigate to Tool - My Dashboard - My Parcels", Status.PASS);
		} catch (Exception e) {
			log("STEP 1:  User cannot Navigate to Tool - My Dashboard - My Parcels", Status.FAIL);
			throw new RuntimeException("Failed in step 1: Popup up does not appear");
		}
		
		if(!util.isElementPresent(NoRecords)) {
		try {
			clickOnFirstCheckBox();
			log("STEP 2:  User can able to select Parcel checkbox:", Status.PASS);
		} catch (Exception e) {
			log("STEP 2:  User not able to select Parcel checkbox :", Status.FAIL);
			throw new RuntimeException("STEP 2:  User not able to select Parcel checkbox :");
		}
		try {
			util.dummyWait(1);
			Assert.assertTrue(util.isElementVisible(btnPDF));
//			clickOnPDF();
//			util.dummyWait(1);
			log("STEP 3:  User can able to see on PDF icon :", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 3:  User not able to see on PDF icon :", Status.FAIL);
		}
		}
		else {
			log(" No records available ", Status.SKIP);
		}
		}
		else {
			log(" My Parcel is not  applicable for this client", Status.SKIP);
		}

	}

	By tabMyProject = By.xpath("//*[text()='My Projects']");

	public void clickOnMyProject() {
		util.waitUntilElementDisplay(tabMyProject);
		util.click(tabMyProject);
	}

	By selecFirsttRow = By.xpath("//table[@id='ctl00_ConPHRightTop_radGridAgents_ctl00']/tbody/tr[1]");

	public void clickOnFirstProjectRow() {
		util.click(selecFirsttRow);
		WebElement selecFirsttRow = driver.findElement(By.xpath("//table[@id='ctl00_ConPHRightTop_radGridAgents_ctl00']/tbody/tr[1]"));
		util.Rcllick(selecFirsttRow);
System.out.println();
	}

	By clickNavigate = By.xpath("//*[text()='Navigate to']");

	public void clickOnNavigate() {
		util.waitUntilElementDisplay(clickNavigate);
		util.click(clickNavigate);
	}

	By navProjectDetails = By.xpath("*//a//span[contains(text(),'Project Details')] ");

	public void isProjectDetialsPresent() {
		util.isElementPresent(navProjectDetails);
	}

	public void verifyMyProject(String testcaseName) {
		if (testcaseName.contains("DOT") || testcaseName.contains("ROW") || testcaseName.contains("TRA") || testcaseName.contains("DOM")) {
			log(" My Project is not  applicable for DOT and ROW", Status.SKIP);
		} else {
			try {
				navigateToMyDashBoard();
				clickOnMyProject();
				log("STEP 1:  User can able to click on MyProject :", Status.PASS);
			} catch (Exception e) {
				log("STEP 1:  User not able to click on MyProject :", Status.FAIL);
				throw new RuntimeException("STEP 1:  User not able to click on MyProject :");
			}
			try {
				clickOnFirstProjectRow();
				log("STEP 2:  User can able to Right click on Project :", Status.PASS);
			} catch (Exception e) {
				log("STEP 2:  User not able to Right on Project :", Status.FAIL);
				throw new RuntimeException("STEP 2:  User not able to Right on Project :");
			}
			try {
				clickOnNavigate();
				log("STEP 3:  User can able to click on Navigate :", Status.PASS);
				isProjectDetialsPresent();
				log("Successfully navigate to Project details");
			} catch (Exception e) {
				log("STEP 3:  User not able to click on Navigate :", Status.FAIL);
				throw new RuntimeException("STEP 3:  User not able to click on Navigate :");
			}
		}
	}

	By tabNoteToReview = By.xpath("//*[contains(text(),'Notes to Review')]");
	By NoteToReviewCount = By.xpath("//*[text()='Notes to Review (0)']");
	By NoRecords = By.xpath("//*[contains(@id,'ctl00_ConPHRightTop_GridDetails')]/tbody/tr/td/div");

	public void clickNotesToReview() {
		util.waitUntilElementDisplay(tabNoteToReview);
		util.click(tabNoteToReview);
	}

	By selecNoteToReviewRow = By.xpath("//input[contains(@id,'AGENTNOTES_RadGrid1_ctl00_ctl04_CheckBox1')]");

	public void clickOnNoteToReviewRow() {
		util.waitUntilElementDisplay(selecNoteToReviewRow);
		util.click(selecNoteToReviewRow);
	}

	By clickHere = By.xpath("//a[contains(@id,'NotesToEdit')]");

	public void clickHere() {
		if (util.isElementPresent(clickHere)) {
			util.waitUntilElementDisplay(clickHere);
			util.click(clickHere);
			log("Click HerePresent :");
			util.switchToWindow();
		} else {
			log("Click Here is not present");
		}

	}

	By btnApprove = By.xpath("//input[contains(@id,'btnApprove')]");
	By hereLink = By.xpath("//a[contains(@id,'NotesReview') and text()='here']");
	By hereLinkNotesEdit = By.xpath("//a[contains(@id,'NotesToEdit') and text()='here']");
	
	public void clickOnApprove() {
		util.waitUntilElementDisplay(btnApprove);
		util.click(btnApprove);
	}

	public void verifyNoteToReview(String testcaseName) {
		navigateToMyDashBoard();
		
		if (!util.isElementPresent(NoteToReviewCount)) {
			
			try {
				
				clickNotesToReview();
				log("STEP 1:  Navigate to Tool - My Dashboard- NoteToReview", Status.PASS);
			} catch (Exception e) {
				log("STEP 1:  User cannot Navigate to Tool - My Dashboard - NoteToReview", Status.FAIL);
				throw new RuntimeException("Failed in step 1: Popup up does not appear");
			}
			
			if(util.isElementPresent(hereLink)) {
				util.click(hereLink);
				
				  Set<String> windowId = driver.getWindowHandles(); // get window id of current window
			  		Iterator<String> itererator = windowId.iterator();

			  		String mainWinID = itererator.next();
			  		String newAdwinID = itererator.next();

			  		driver.switchTo().window(newAdwinID);
			  		
			  		try {
						clickOnNoteToReviewRow();
						log("STEP 2:  User can able to select NoteToReview :", Status.PASS);
					} catch (Exception e) {
						log("STEP 2:  User not able to select on NoteToReview :", Status.FAIL);
						throw new RuntimeException("STEP 2:  User not able to select on NoteToReview :");
					}

					try {
						clickOnApprove();
						util.dummyWait(1);
						log("STEP 3:  User can able to click on Approve :", Status.PASS);
					} catch (Exception e) {
						log("STEP 3:  User not able to click on Approve :", Status.FAIL);
						throw new RuntimeException("STEP 3:  User not able to click on Approve  :");
					}
					
					 driver.close();
		    		 driver.switchTo().window(mainWinID);
			  		
			}else {
			try {
				clickOnNoteToReviewRow();
				log("STEP 2:  User can able to select NoteToReview :", Status.PASS);
			} catch (Exception e) {
				log("STEP 2:  User not able to select on NoteToReview :", Status.FAIL);
				throw new RuntimeException("STEP 2:  User not able to select on NoteToReview :");
			}

			try {
				clickOnApprove();
				util.dummyWait(1);
				log("STEP 3:  User can able to click on Approve :", Status.PASS);
			} catch (Exception e) {
				log("STEP 3:  User not able to click on Approve :", Status.FAIL);
				throw new RuntimeException("STEP 3:  User not able to click on Approve  :");
			}
			}
		}
		else {
			log("Notes to review tab has no records", Status.SKIP);
		}
		
		
		
	}

	By tabEditNote = By.xpath("//*[contains(text(),'Notes to Edit')]");
	By editNoteCount = By.xpath("//*[text()='Notes to Edit (0)']");

	public void clickEditNotesToReview() {
		util.waitUntilElementDisplay(tabEditNote);
		util.click(tabEditNote);
	}

	public void clickOnEditRow(String value) {
		By clickEditRow = By.xpath("*//td/strong[text()='" + value + "']//following-sibling::a[text()='Edit']");
		util.waitUntilElementDisappear(clickEditRow);
		util.click(clickEditRow);
	}

	By btnEdit = By.xpath("(//a[text()='Edit'])[1]");
	
	public void ClickonEditButton() {
    	util.waitUntilElementDisplay(btnEdit);
    	util.click(btnEdit);
    }
	
	public void editNoteToReview(Map<String, String> map, String testcaseName) {
		
		if (!util.isElementPresent(editNoteCount)) {
			try {
				clickEditNotesToReview();
				log("STEP 1:  Navigate to Tool - My Dashboard- NoteToReview", Status.PASS);
			} catch (Exception e) {
				log("STEP 1:  User cannot Navigate to Tool - My Dashboard - NoteToReview", Status.FAIL);
				throw new RuntimeException("Failed in step 1");
			}
			
			if(util.isElementPresent(hereLinkNotesEdit)) {
				util.click(hereLinkNotesEdit);
				
				 Set<String> windowId = driver.getWindowHandles(); // get window id of current window
			  		Iterator<String> itererator = windowId.iterator();

			  		String mainWinID = itererator.next();
			  		String newAdwinID = itererator.next();

			  		driver.switchTo().window(newAdwinID);
			  		
//			  		try {
//			   
//			    		 util.dummyWait(2);
//			    		 ClickonEditButton();
//			 			log("STEP 2: User can click on the Edit Notes Link  ", Status.PASS);
//			 		 } catch (Exception e) {
//			 			log("STEP 2: User cannot see the Edit Link   ", Status.FAIL);
//			 			throw new RuntimeException("Failed in step 2");
//			 		 }
			  		 driver.close();
		    		 driver.switchTo().window(mainWinID);
			  		 
				
			}else {
//				try {
//					   
//		    		 util.dummyWait(2);
//		    		 ClickonEditButton();
//		 			log("STEP 2: User can click on the Edit Notes Link  ", Status.PASS);
//		 		 } catch (Exception e) {
//		 			log("STEP 2: User cannot see the Edit Link   ", Status.FAIL);
//		 			throw new RuntimeException("Failed in step 2");
//		 		 }
			}
		}
		else {
			log("Edit Note to Review tab has no records", Status.SKIP);
		}
		
	}

	By txtAgentName = By.xpath("//input[contains(@id,'MSDELAGENT_YALComboBox_Input')]");
	By btnSearch = By.xpath("//input[contains(@id,'btnFilterDelDocs')]");
	
	By tabDeleteDoc = By.xpath("//*[contains(text(),'Deleted Doc(s)')]");
	By linkDeleteDoc = By.xpath("//div[contains(@id,'DeletedDocs')]//a[normalize-space()='here']");

	public void selectAgent(String value) {
		util.inputText(txtAgentName, value);
		util.pressDownkey();
		util.pressENTERkey();
	}
	
	public void clickDeleteDoc() {
		util.waitUntilElementDisplay(tabDeleteDoc);
		util.click(tabDeleteDoc);
	}

	public void deleteDoc(Map<String, String> map, String testcaseName, String uName, String pass) {
		
			// 1)key DefaultDeleteInd=-1 and 2)APPROVE DOC DELETION special permission-->unchecked
				 try {
		    		    NavigateToApplicationBehaviorSettings();
		     			log("STEP 1: User can navigate to Application Behavior Settings ", Status.PASS);
		     		} catch (Exception e) {
		     			log("STEP 1: User cannot navigate to Application Behavior Settings ", Status.FAIL);
		     			throw new RuntimeException("Failed in step 1");
		     		}
		     	
		    	 try {
		    		    enterKeyName(map.get("KeyName"));
		     			log("STEP 2: User can enter key name "+map.get("KeyName"), Status.PASS);
		     		} catch (Exception e) {
		     			log("STEP 2: User cannot enter key name "+map.get("KeyName"), Status.FAIL);
		     			throw new RuntimeException("Failed in step 2");
		     		}
		    	 
		    	 try {
		    		 util.waitFor(500);
		    		    selectFilter();
		     			log("STEP 3: User can click on Filter Icon", Status.PASS);
		     		} catch (Exception e) {
		     			log("STEP 3: User cannot click on Filter Icon", Status.FAIL);
		     			throw new RuntimeException("Failed in step 3");
		     		}
		 		
		    	 
		    	 try {
		    		    setKeyValue(map.get("KeyName"), map.get("Value1"));
		     			log("STEP 4: User can set "+ map.get("Value1")+" value for key name "+map.get("KeyName"), Status.PASS);
		     		} catch (Exception e) {
		     			log("STEP 4: User cannot set "+ map.get("Value1")+" value for key name "+map.get("KeyName"), Status.FAIL);
		     			throw new RuntimeException("Failed in step 4");
		     		}
		    	 
		    	 try {
		    		    clickOnSubmitAll();
		     			log("STEP 5: User can click on Submit All button ", Status.PASS);
		     		} catch (Exception e) {
		     			log("STEP 5: User cannot click on Submit All button", Status.FAIL);
		     			throw new RuntimeException("Failed in step 5");
		     		}		
				

		     	try {
		 	  		NavigateToSpecialPermission();
		 				log("STEP 6: User can Navigate to Special Permission", Status.PASS);
		 			} catch (Exception e) {
		 				log("STEP 6:  User cannot Navigate to Special Permission", Status.FAIL);
		 				throw new RuntimeException("Failed in step 6");
		 			}
		     	
		     	
		     	try {
					selectRoleDD(map.get(Excel.Roles));
					log("STEP 7:  User can select Role", Status.PASS);
				} catch (Exception e) {
					log("STEP 7:  User can not select Role", Status.FAIL);
					throw new RuntimeException("Failed in step 7:  User can not select Role");
				}
		     	
				if (util.isElementVisible(approveDocDeletionChecked)) {

					try {
						util.click(approveDocDeletionUnchecked);
						log("STEP 8: User can uncheck the Approve Doc Deletion Special Permission", Status.PASS);
					} catch (Exception e) {
						log("STEP 8:  User cannot uncheck the Approve Doc Deletion Special Permission", Status.FAIL);
						throw new RuntimeException("Failed in step 8");
					}
				}

				try {
					util.click(btnSavePermissions);
					util.waitFor(500);
					log("STEP 9: User can save the Reopen Closed Ticket Special Permission", Status.PASS);
				} catch (Exception e) {
					log("STEP 9:  User cannot save the Reopen Closed Ticket Special Permission", Status.FAIL);
					throw new RuntimeException("Failed in step 9");
				}

				try {
					util.click(btnLogOff);
					log("STEP 10: User can log off the application", Status.PASS);
				} catch (Exception e) {
					log("STEP 10:  User cannot log off the application", Status.FAIL);
					throw new RuntimeException("Failed in step 10");
				}

				try {
					navigateToApplication(appURL);
					login(uName, pass);
					log("STEP 11: User can logIn the application again", Status.PASS);
				} catch (Exception e) {
					log("STEP 11:  User cannot logIn the application again", Status.FAIL);
					throw new RuntimeException("Failed in step 11");
				}

				try {
					navigateToMyDashBoard();
					log("STEP 12: User can navigate to My Dashboard Page", Status.PASS);
				} catch (Exception e) {
					log("STEP 12:  User cannot navigate to My Dashboard Page", Status.FAIL);
					throw new RuntimeException("Failed in step 12");
				}
				
				try {
					Assert.assertFalse(util.isElementVisible(tabDeleteDoc));
					log("STEP 13: User cannot see Deleted Doc tab", Status.PASS);
				} catch (AssertionError e) {
					log("STEP 13:  User can see Deleted Doc tab", Status.FAIL);
				}
				
		     // 1)key DefaultDeleteInd=0 and 2)APPROVE DOC DELETION special permission-->checked			
				
				try {
					NavigateToApplicationBehaviorSettings();
					log("STEP 14: User can navigate to Application Behavior Settings ", Status.PASS);
				} catch (Exception e) {
					log("STEP 14: User cannot navigate to Application Behavior Settings ", Status.FAIL);
					throw new RuntimeException("Failed in step 14");
				}

				try {
					enterKeyName(map.get("KeyName"));
					log("STEP 15: User can enter key name " + map.get("KeyName"), Status.PASS);
				} catch (Exception e) {
					log("STEP 15: User cannot enter key name " + map.get("KeyName"), Status.FAIL);
					throw new RuntimeException("Failed in step 15");
				}

				try {
					selectFilter();
					log("STEP 16: User can click on Filter Icon", Status.PASS);
				} catch (Exception e) {
					log("STEP 16: User cannot click on Filter Icon", Status.FAIL);
					throw new RuntimeException("Failed in step 16");
				}

				try {
					setKeyValue(map.get("KeyName"), map.get("Value2"));
					log("STEP 17: User can set " + map.get("Value2") + " value for key name " + map.get("KeyName"),Status.PASS);
				} catch (Exception e) {
					log("STEP 17: User cannot set " + map.get("Value2") + " value for key name " + map.get("KeyName"),Status.FAIL);
					throw new RuntimeException("Failed in step 17");
				}

				try {
					clickOnSubmitAll();
					log("STEP 18: User can click on Submit All button ", Status.PASS);
				} catch (Exception e) {
					log("STEP 18: User cannot click on Submit All button", Status.FAIL);
					throw new RuntimeException("Failed in step 18");
				}

				try {
					NavigateToSpecialPermission();
					log("STEP 19: User can Navigate to Special Permission", Status.PASS);
				} catch (Exception e) {
					log("STEP 19:  User cannot Navigate to Special Permission", Status.FAIL);
					throw new RuntimeException("Failed in step 19");
				}

				try {
					selectRoleDD(map.get(Excel.Roles));
					log("STEP 20:  User can select Role", Status.PASS);
				} catch (Exception e) {
					log("STEP 20:  User can not select Role", Status.FAIL);
					throw new RuntimeException("Failed in step 20:  User can not select Role");
				}

				if (util.isElementVisible(approveDocDeletionUnchecked)) {

					try {
						util.click(approveDocDeletionUnchecked);
						log("STEP 21: User can check the Approve Doc Deletion Special Permission", Status.PASS);
					} catch (Exception e) {
						log("STEP 21:  User cannot check the Approve Doc Deletion Special Permission", Status.FAIL);
						throw new RuntimeException("Failed in step 21");
					}
				}

				try {
					util.click(btnSavePermissions);
					util.waitFor(500);
					log("STEP 22: User can save the Approve Doc Deletion Special Permission", Status.PASS);
				} catch (Exception e) {
					log("STEP 22:  User cannot save the Approve Doc Deletion Special Permission", Status.FAIL);
					throw new RuntimeException("Failed in step 22");
				}

				try {
					util.click(btnLogOff);
					log("STEP 23: User can log off the application", Status.PASS);
				} catch (Exception e) {
					log("STEP 23:  User cannot log off the application", Status.FAIL);
					throw new RuntimeException("Failed in step 23");
				}

				try {
					navigateToApplication(appURL);
					login(uName, pass);
					log("STEP 24: User can logIn the application again", Status.PASS);
				} catch (Exception e) {
					log("STEP 24:  User cannot logIn the application again", Status.FAIL);
					throw new RuntimeException("Failed in step 24");
				}
		     
		     	
			//Add Parcel Document	
				
			try {
				NavigateToDocumentManagement();
				commonFunction.projectSelection();
				log("STEP 25: User can navigate to the Document Management", Status.PASS);
			} catch (Exception e) {
				log("STEP 25:  User cannot see the option in Menu", Status.FAIL);
				throw new RuntimeException("Failed in step 25 ");
			}

			try {
				ClickOnAddDocumentROW();
				log("STEP 26: User can click on the add document button", Status.PASS);
			} catch (Exception e) {
				log("STEP 26: User cannot see the add document button", Status.FAIL);
				throw new RuntimeException("Failed in step 26");
			}

			try {
				util.switchToIframe(iframeDocument);
				util.dummyWait(5);
				uploadFile();
				log("STEP 27: User can upload document from the system ", Status.PASS);
			} catch (Exception e) {
				log("STEP 27:  User cannot upload document from the system   ", Status.FAIL);
				throw new RuntimeException("Failed in step 27");
			}

			if (util.isElementPresent(drpCategoryROWTree)) {
				try {
					selectCategoryTree(map.get(Excel.Category));
					log("STEP 28: Value added diplays in Category field      ", Status.PASS);
				} catch (Exception e) {
					log("STEP 28:  Added value does not display in Category field    ", Status.FAIL);
					throw new RuntimeException("Failed in step 28");
				}
			} else {

				try {
					util.dummyWait(5);
					util.click(drpCategoryROW);
					SelectCategoryROW(map.get(Excel.Category));
					log("STEP 28: Value added diplays in Category field      ", Status.PASS);
				} catch (Exception e) {
					log("STEP 28:  Added value does not display in Category field    ", Status.FAIL);
					throw new RuntimeException("Failed in step 28");
				}
			}

			try {
				AddDescriptionROW(map.get(Excel.Description));
				log("STEP 29: User can enter a value in Description field   ", Status.PASS);
			} catch (Exception e) {
				log("STEP 29:  User cannot add a value in Description field    ", Status.FAIL);
				throw new RuntimeException("Failed in step 29");
			}

			try {
				LoadDocuments();
				ClickOnCloseButton();
				log("STEP 30: document is loaded AND message-' Loaded- documentname'  displays", Status.PASS);
			} catch (Exception e) {
				log("STEP 30:   docuemnt could not be uploaded. AND message-' Loaded- documentname' does not display  ",
						Status.FAIL);
				throw new RuntimeException("Failed in step 30");
			}

			// Request Delete

			try {
				driver.navigate().refresh();
				By DocCheckbox = By.xpath("//*[text()='" + map.get("DocName") + "']/..//input[@type='checkbox']");
				util.waitUntilElementDisplay(DocCheckbox);
				util.click(DocCheckbox);
				log("STEP 31: User can Checked check box ", Status.PASS);
			} catch (Exception e) {
				log("STEP 31: User cannot able to click on Check Boxes ", Status.FAIL);
				throw new RuntimeException("Failed in step 31");
			}

			try {
				ClickonRequestDeleteROW();
				log("STEP 32: User can click on the Request Delete button  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 32: User cannot able to click on Request Delete button ", Status.FAIL);
				throw new RuntimeException("Failed in step 32");
			}

			try {
				SelectReason(map.get(Excel.Reason));
				log("STEP 33: user should be able to select the value from Reason dd  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 33: user not able to select the value from Reason dd    ", Status.FAIL);
				throw new RuntimeException("Failed in step 33");
			}

			try {
				AddComment(map.get(Excel.Comment));
				log("STEP 34: user should be able enter text in the comments field  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 34: user not able to enter text in the comments field    ", Status.FAIL);
				throw new RuntimeException("Failed in step 34");
			}

			try {
				ClickonRequestDeletionButton();
				log("STEP 35: user should be able to click on request deletion button  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 35: user not able to click on request deletion button    ", Status.FAIL);
				throw new RuntimeException("Failed in step 35");
			}

			try {
				navigateToMyDashBoard();
				log("STEP 36: User can navigate to My Dashboard Page", Status.PASS);
			} catch (Exception e) {
				log("STEP 36:  User cannot navigate to My Dashboard Page", Status.FAIL);
				throw new RuntimeException("Failed in step 36");
			}
			
			try {
				Assert.assertTrue(util.isElementVisible(tabDeleteDoc));
				log("STEP 37: User can see Deleted Doc tab", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 37:  User cannot see Deleted Doc tab", Status.FAIL);
			}

			try {
				clickDeleteDoc();
				log("STEP 38:  Navigate to Delete Doc ", Status.PASS);
			} catch (Exception e) {
				log("STEP 38:   Not Navigate to Delete Doc :", Status.FAIL);
				throw new RuntimeException("Failed in step 38:");
			}
			util.dummyWait(1);
			if(util.isElementVisible(linkDeleteDoc)) {
				util.click(linkDeleteDoc);
				util.switchToChildWindow();
				try {
					selectAgent(map.get(Excel.User));
					log("STEP 39: User can select Agent ", Status.PASS);
				} catch (Exception e) {
					log("STEP 39:   User cannot select Agent", Status.FAIL);
					throw new RuntimeException("Failed in step 39");
				}
				
				try {
					util.click(btnSearch);
					util.dummyWait(3);
					log("STEP 40: User can click on Search Button", Status.PASS);
				} catch (Exception e) {
					log("STEP 40:   User cannot click on Search Button", Status.FAIL);
					throw new RuntimeException("Failed in step 40");
				}
				
				try {
					By DeltedDoc = By.xpath("(//*[text()='" + docName + "'])[1]");
					Assert.assertTrue(util.isElementVisible(DeltedDoc));
					log("STEP 41: User can see Deleted Document under Deleted Doc(s) tab", Status.PASS);
				} catch (AssertionError e) {
					log("STEP 41:  User cannot see Deleted Document under Deleted Doc(s) tab", Status.FAIL);
				}
				driver.close();
				util.switchToParentWindow();
			}else {
			try {
				selectAgent(map.get(Excel.User));
				log("STEP 39: User can select Agent ", Status.PASS);
			} catch (Exception e) {
				log("STEP 39:   User cannot select Agent", Status.FAIL);
				throw new RuntimeException("Failed in step 39");
			}
			
			try {
				util.click(btnSearch);
				util.dummyWait(3);
				log("STEP 40: User can click on Search Button", Status.PASS);
			} catch (Exception e) {
				log("STEP 40:   User cannot click on Search Button", Status.FAIL);
				throw new RuntimeException("Failed in step 40");
			}
			
			try {
				By DeltedDoc = By.xpath("(//*[text()='" + docName + "'])[1]");
				Assert.assertTrue(util.isElementVisible(DeltedDoc));
				log("STEP 41: User can see Deleted Document under Deleted Doc(s) tab", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 41:  User cannot see Deleted Document under Deleted Doc(s) tab", Status.FAIL);
			}
			}	
		}
	
}
