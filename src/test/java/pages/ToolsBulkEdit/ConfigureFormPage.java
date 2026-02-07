package pages.ToolsBulkEdit;

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

public class ConfigureFormPage extends BasePage {

	TestUtil util;
	CommonFunction commonFunction;
	public String gridConfig = "";
	public String createRole = "";
	public String viewRole = "";

	public ConfigureFormPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}

	By navParcel = By.xpath("//span[text()='Parcel'] | //span[text()='Tract']");
	By navParcelInfo = By.xpath("//span[text()='Parcel Info'] | //span[text()='Tract Info']");
	By navParcelInformation = By.xpath("//span[contains(text(),'Parcel Information')] | //span[contains(text(),'Tract Information')] | //span[contains(text(),'Record Information')]");
	By btnDesignMode = By.xpath("//input[contains(@id,'btnDesignModeOff') and @type='image']");
	By projectApprovals = By.xpath("//a[normalize-space()='Project Approvals' or normalize-space()='Project Forms']");
	By addProjectApprovals = By.xpath(
			"//*[normalize-space()='Project Approvals' or normalize-space()='Project Forms']/..//a[normalize-space()='Add new record']");
	By wfConfigurationIcon = By.xpath("//span[contains(@title,'WorkFlow Configuration')]");
	By btnAddNewRecord = By.xpath("//img[contains(@id,'YALWorkflows_radYALGridControl')]");
	By FullFrm = By.xpath("//iframe[@name='ManageApprovalDialog']");
	By drpApprovalType = By.xpath("//input[contains(@id,'_cbParcelApprovalType_YALComboBox_Input') and @type='text']");
	By comboBoxConfiguration = By.xpath("//span[contains(@id,'idManageParcelApprovals_cbParcelApprovalType_ManageComboID')]");
	By LinkAddNewRecord = By.xpath("(//a[contains(@id,'lnkAddNewRecord')])[1]");
	By DisplayOrder = By.xpath("(//input[contains(@id,'Lookup_Order')])[1]");
	By txtLookupDescription = By.xpath("(//textarea[contains(@id,'Lookup_Desc')])[1]");
	By Insertbtn = By.xpath("(//input[contains(@id,'btnInsert')])[1]");
	By btnReload = By.xpath("//a[@class='rwReloadButton']");
	By securityOptions = By.xpath("//span[text()='Security Options']");
	By summaryConfig = By.xpath("//span[text()='Summary Config']");
	By addNewStep = By.xpath("//img[contains(@id,'idManageParcelApprovals_gridParcelApprovalType_radYALGridControl') and @alt='Add new record']");
	By reviewer = By.xpath("//*[text()='Reviewer:']/..//div");
	By ddFilter = By.xpath("(//*[contains(@value,'Filtering...')])[1]");
	By stepName = By.xpath("//input[contains(@id,'_EditFormControl_idEditWorkflowReview_STATIC_STEP_NAME') and @type='text']");
	By rejectionDD = By.xpath("//input[contains(@id,'idEditWorkflowReview_REJECT_STEP_ID_YALComboBox_Input') and @type='text']");
	By createRoleDD = By.xpath("//input[contains(@id,'_cbCreateRoles') and @type='text']");
	By viewRoleDD = By.xpath("//input[contains(@id,'_cbViewRoles') and @type='text']");
	By summaryConfigDD = By.xpath("//input[contains(@id,'cbSummaryConfig') and @type='text']");
	By btnSave = By.xpath("//input[contains(@id,'_btnSaveHeader')]");
	By btnEdit = By.xpath("//*[@title='Edit']");
	By customFieldIcon = By.xpath("//span[contains(@id,'ManageAddFieldsID')]");
	By txtFieldName = By.xpath("//input[contains(@id,'editcc_Field_Name') and @type='text']");
	By drpFieldType = By.xpath("//input[contains(@id,'editcc_Field_Type_ID_radYALDropDownList_Input') and @type='text']");
	By txtDisplayOrder = By.xpath("//input[contains(@id,'editcc_Display_Order') and @type='text']");
	By txtMaxLengthValue = By.xpath("//input[contains(@id,'editcc_Max_Length_Value') and @type='text']");
	By txtHeight = By.xpath("//input[contains(@id,'editcc_radHeight') and @type='text']");
	By btnCloseForm = By.xpath("//div[contains(@id,'ManageApprovalDialog')]//a[@title='Close']");
	By btnRefresh = By.xpath("//a[@title='Reload']");
	By linkConfigureAdditionalNotifications = By.xpath("//a[text()='Configure Additional Notifications']");
	By iframeConfigureAdditionalNotifications = By.xpath("//iframe[contains(@name,'idManageParcelApprovals_gridParcelApprovalType_')]");
	By btnAddNewRecordsConfig = By.xpath("//img[contains(@id,'idWorkflowNotificationConfig_NOTIFICATIONCONFIGID_radYALGridControl') and @alt='Add new record']");
	By drpNotificationRecipients = By.xpath("//*[text()='Notification Recipient(s):']/..//div");
	By drpNotificationRecipientsFilter = By.xpath("//*[@id=\"form1\"]/div[1]/div//input[@value='Filtering...']");
	By drpReminderType = By.xpath("//input[contains(@id,'idEditWorkflowNotification_cbReminderType_radYALDropDownList_Input')]");
	By optionAfterSubmissionOfDays = By.xpath("//li[text()='After Submission of Step']");
	By optionBeforeSLA = By.xpath("//li[text()='Before SLA']");
	By txtNoOfDays = By.xpath("//input[contains(@id,'idEditWorkflowNotification_txtDaysForAction') and @type='text']");
	By drpType = By.xpath("//input[contains(@id,'_EditFormControl_idEditWorkflowNotification_cbType_radYALDropDownList_Input') and @type='text']");
	By drpDateType = By.xpath("//input[contains(@id,'_EditFormControl_idEditWorkflowNotification_cbWFDateType_radYALDropDownList_Input') and @type='text']");
	By btnInsert = By.xpath("//input[@id='idWorkflowNotificationConfig_NOTIFICATIONCONFIGID_radYALGridControl_ctl00_ctl02_ctl03_EditFormControl_btnInsert']");
	By colNotificationReciepients = By.xpath("//a[text()='Notification Recipients']");
	By colNotificationType = By.xpath("//a[text()='NotificationType'] | //a[text()='Notification Type']");
	By btnCloseNotificationForm = By.xpath("//div[contains(@id,'gridParcelApprovalType_RadWindowManager')]//a[@title='Close']");
	By btnUpdate = By.xpath("//input[contains(@id,'_EditFormControl_btnUpdate')]");
	
	 public void navigateParcelInformation() {
			util.waitUntilElementDisplay(navParcel);
			util.click(navParcel);
			util.waitUntilElementDisplay(navParcelInfo);
			util.click(navParcelInfo);
			util.waitUntilElementDisplay(navParcelInformation);
			util.click(navParcelInformation);
			commonFunction.projectSelection();
		}

	public void TurnOnDesignCode() {
		util.waitUntilElementDisplay(btnDesignMode);
		util.click(btnDesignMode);
	}

	public void ClickOnWFConfigurationIcon() {
		util.waitUntilElementDisplay(wfConfigurationIcon);
		util.click(wfConfigurationIcon);
		util.waitFor(100);
		util.switchToIframe(FullFrm);
	}

	public void ClickOnAddNewRecordLink() {
		util.waitUntilElementDisplay(LinkAddNewRecord);
		util.click(LinkAddNewRecord);
	}

	public void DisplayOrder(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(DisplayOrder, value);
	}

	public void AddLookupDescription(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtLookupDescription, value);
	}

	public void ClickOnInsert() {
		util.waitUntilElementDisplay(Insertbtn);
		util.click(Insertbtn);
	}

	public void selectApprovalType(String value) {
		util.selectValueFromDropdown(drpApprovalType, value);
	}

	public String getCreateRoles() {
		return util.getAttributeValue(createRoleDD, "value");
	}

	public String getViewRoles() {
		return util.getAttributeValue(viewRoleDD, "value");
	}

	public void ClickOnAddNewRecord() {
		util.waitUntilElementDisplay(btnAddNewRecord);
		util.click(btnAddNewRecord);
		util.waitFor(500);
		util.switchToIframe(FullFrm);
	}

    public void selectReviewer(String value) {
		util.waitUntilElementDisplay(reviewer);
		util.click(reviewer);
		util.inputText(ddFilter, value);
		By selectDD = By
				.xpath("(//div[contains(@id,'REVIEW_KEY_RadDropDownTree1_EmbeddedTree')]//*[contains(text(),'" + value + "')])[1]");
		util.click(selectDD);
		
    }

    public void StepName(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(stepName, value);
	}
    
    public void selectOnRejection(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(rejectionDD, value);
	}
    
    public void selectCreatePermission(String value) {
		if (!commonFunction.checkNA(value)) {
			util.click(createRoleDD);
				util.inputText(createRoleDD, value);
				By selectPermission = By.xpath("//*[contains(text(),'"+value+"')]//./../input");
				util.click(selectPermission);
			}
			
	}
    
    public void selectFieldsToDisplay(String value) {
		if (!commonFunction.checkNA(value)) {
			util.click(summaryConfigDD);
				util.inputText(summaryConfigDD, value);
				By selectField = By.xpath("//*[contains(text(),'"+value+"')]//./../input[@type='checkbox']");
				util.click(selectField);
			}
			
	}
    
    public void selectViewPermission(String value) {
		if (!commonFunction.checkNA(value))
			util.click(viewRoleDD);
		util.inputText(viewRoleDD, value);
		By selectPermission = By.xpath("//*[contains(text(),'"+value+"')]//./../input");
		util.click(selectPermission);
	}
    
	public void closeApprovalForm() {
		util.switchToDefaultContent();
		util.click(btnCloseForm);
		util.waitFor(500);
	}

	 public void AddFieldName(String value) {
	    	if (!commonFunction.checkNA(value)) 
				util.inputTextAndPressTab(txtFieldName, value);
	    }
	    
	    public void SelectFieldType(String value) {
	    	if (!commonFunction.checkNA(value)) 
				util.inputTextAndPressTab(drpFieldType, value);
	    }
	    public void AddDisplayOrder(String value) {
	    	if (!commonFunction.checkNA(value)) 
				util.inputTextAndPressTab(txtDisplayOrder, value);
	    }
	    
	    public void AddMaxLengthValue(String value) {
	    	if (!commonFunction.checkNA(value)) 
				util.inputTextAndPressTab(txtMaxLengthValue, value);
	    }
	    
	    public void AddHeight(String value) {
	    	if (!commonFunction.checkNA(value)) 
				util.inputTextAndPressTab(txtHeight, value);
	    }
	    
	    By txtNoOfColumn = By.xpath("//input[contains(@id,'editcc_No_of_Columns') and @type='text']");
	    public void AddNoOfColumn(String value) {
	    	if (!commonFunction.checkNA(value)) 
				util.inputTextAndPressTab(txtNoOfColumn, value);
	    }
	    
	    By btnSaveHeader = By.xpath("//input[contains(@id,'btnSaveHeader')]");
	    By btnPublish = By.xpath("//input[contains(@id,'PublishViews')]");
	    public void ClickOnSaveHeader() {
	    	util.waitUntilElementDisplay(btnSaveHeader);
	    	util.click(btnSaveHeader);
	    }
	    
	    public void ClickOnPublish() {
	    	util.waitUntilElementDisplay(btnPublish);
	    	util.click(btnPublish);
	    	util.waitFor(200);
	    }
	   
	    public void ClickOnConfigureAdditionalNotification() {
	    	util.waitUntilElementDisplay(linkConfigureAdditionalNotifications);
	    	util.click(linkConfigureAdditionalNotifications);
	    	util.waitFor(200);
	    }
	    
	    public void ClickOnAddNewRecordNotification() {
	    	util.waitUntilElementDisplay(btnAddNewRecordsConfig);
	    	util.click(btnAddNewRecordsConfig);
	    	util.waitFor(200);
	    }
	    
	    public void AddNoOfDays(String value) {
	    	if (!commonFunction.checkNA(value)) 
				util.inputTextAndPressTab(txtNoOfDays, value);
	    }
	    
	    public void AddType(String value) {
	    	if (!commonFunction.checkNA(value)) 
				util.inputTextAndPressTab(drpType, value);
	    }
	    
	    public void AddDateType(String value) {
	    	if (!commonFunction.checkNA(value)) 
				util.inputTextAndPressTab(drpDateType, value);
	    }
	    
	    public void selectNotificationRecipients(String value) {
	    	util.waitUntilElementDisplay(drpNotificationRecipients);
			util.click(drpNotificationRecipients);
			util.inputText(ddFilter, value);
			By selectDD = By
					.xpath("(//em[text()='"+value+"']/../..//input)[1]");
			util.click(selectDD);
	    	util.click(drpNotificationRecipients);
	    }
	    
	    public void ClickOnInsertNotification() {
	    	util.waitUntilElementDisplay(btnInsert);
	    	util.click(btnInsert);
	    	util.waitFor(200);
	    }
	    
	    By btnSaveApprovals = By.xpath("//input[contains(@id,'_btnSaveHeader')]");
	    By approved = By.xpath("//a[text()='Approved']");
	    public void clickOnSaveApprovals() {
			util.click(btnSaveApprovals);
		}
	    
	    By btnSubmitForReview = By.xpath("//input[contains(@id,'WorkflowApprove_btnSubmit')]");
		By btnSubmitForReviewNew = By.xpath("//input[@id='idManageApproval_YALInLineWorkflowApprove_btnSubmit']");
	    public void SubmitForReview() {
	    	util.dummyWait(1);
			if(util.isElementPresent(btnSubmitForReviewNew)) {
				util.click(btnSubmitForReviewNew);
			}else {
				util.click(btnSubmitForReview);
			}
			util.dummyWait(1);
		}
	    
	public void WorkflowConfiguration(Map<String, String> map, String testcaseName)
			throws InterruptedException {

		if(testcaseName.contains("ParcelFormConfig")) {
			try {
				navigateParcelInformation();
				log("STEP 1:  user can navigate to Parcel Information Page", Status.PASS);
			} catch (Exception e) {
				log("STEP 1:  user cannot navigate to Parcel Information Page", Status.FAIL);
				throw new RuntimeException("Failed in step 1");
			}
		}
		
		if(util.isElementVisible(btnDesignMode)) {
		try {
			TurnOnDesignCode();
			log("STEP 2: User can Turn on the Design mode", Status.PASS);
		} catch (Exception e) {
			log("STEP 2: User cannot Turn on the Design mode", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}
		}
		
		By workflowName = By.xpath("(//*[text()='"+map.get(Excel.ApprovalType)+"']/..//*[text()='In-Review'])[1]");
		if (!util.isElementVisible(workflowName)) {
		try {
			ClickOnWFConfigurationIcon();
			log("STEP 3: User can click on WF Configuration Icon", Status.PASS);
		} catch (Exception e) {
			log("STEP 3: user can not click on WF Configuration Icon", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}

		try {

			util.click(drpApprovalType);
			util.waitFor(200);
			log("STEP 4: user can click on Approval Type DD", Status.PASS);
		} catch (Exception e) {
			log("STEP 4: user can not click the Approval Type DD", Status.FAIL);
			throw new RuntimeException("Failed in step 4");
		}

		By WF = By.xpath("//*[contains(@id,'_cbParcelApprovalType_YALComboBox_DropDown')]/..//*[text()='"+map.get(Excel.ApprovalType)+"']");
		if (!util.isElementVisible(WF)) {
			try {
				util.click(comboBoxConfiguration);
				util.switchToChildWindow();
				log("STEP 5: user can click on DD configuration Icon", Status.PASS);
			} catch (Exception e) {
				log("STEP 5: user can not click on DD configuration Icon", Status.FAIL);
				throw new RuntimeException("Failed in step 5");
			}

			try {
				ClickOnAddNewRecordLink();
				log("STEP 6: user can click on Add new record button", Status.PASS);
			} catch (Exception e) {
				log("STEP 6: user can not click on Add new record button", Status.FAIL);
				throw new RuntimeException("Failed in step 6");
			}

			try {
				DisplayOrder(map.get(Excel.DisplayOrder));
				log("STEP 7: user can able to enter value in Display order field ", Status.PASS);
			} catch (Exception e) {
				log("STEP 7: user can not able to enter value in Display order field ", Status.FAIL);
				throw new RuntimeException("Failed in step 7");
			}

			try {
				AddLookupDescription(map.get(Excel.ApprovalType));
				log("STEP 8: user can able to enter value in Lookup Description field ", Status.PASS);
			} catch (Exception e) {
				log("STEP 8: user can not able to enter value in Lookup Description field ", Status.FAIL);
				throw new RuntimeException("Failed in step 8");
			}

			try {
				ClickOnInsert();
				util.waitFor(200);
				driver.close();
				util.switchToParentWindow();
				util.click(btnReload);
				util.switchToIframe(FullFrm);
				log("STEP 9: user can click on Insert button ", Status.PASS);
			} catch (Exception e) {
				log("STEP 9: user cannot click on Insert button ", Status.FAIL);
				throw new RuntimeException("Failed in step 9");
			}
		}
		try {
			selectApprovalType(map.get(Excel.ApprovalType));
			log("STEP 10: user can select Approval Type", Status.PASS);
		} catch (Exception e) {
			log("STEP 10: user can not select the Approval Type", Status.FAIL);
			throw new RuntimeException("Failed in step 10");
		}

		By btnEdit = By.xpath("//*[text()='"+map.get("Step Name")+"']/..//*[@title='Edit']");
		
		if(!util.isElementVisible(btnEdit)) {
		try {
			util.click(addNewStep);
			log("STEP 11: user can click on Add new record button", Status.PASS);
		} catch (Exception e) {
			log("STEP 11: user cannot click on Add new record button", Status.FAIL);
			throw new RuntimeException("Failed in step 11");
		}
		
		try {
			selectReviewer(map.get("Reviewer"));
			log("STEP 12: user can select the Reviewer", Status.PASS);
		} catch (Exception e) {
			log("STEP 12: user cannot select the Reviewer", Status.FAIL);
			throw new RuntimeException("Failed in step 12");
		}
		
		try {
			StepName(map.get("Step Name"));
			log("STEP 13: user can enter Step Name", Status.PASS);
		} catch (Exception e) {
			log("STEP 13: user cannot enter Step Name", Status.FAIL);
			throw new RuntimeException("Failed in step 13");
		}
		
		try {
			selectOnRejection(map.get("On Rejection"));
			log("STEP 14: user can select the on Rejection Step", Status.PASS);
		} catch (Exception e) {
			log("STEP 14: user cannot select on Rejection Step", Status.FAIL);
			throw new RuntimeException("Failed in step 14");
		}
			
		try {
			ClickOnInsert();
			util.waitFor(1000);
			log("STEP 15: user can click on Insert button ", Status.PASS);
		} catch (Exception e) {
			log("STEP 15: user cannot click on Insert button ", Status.FAIL);
			throw new RuntimeException("Failed in step 15");
		}
		}
		
		try {
			selectApprovalType(map.get(Excel.ApprovalType));
			util.click(customFieldIcon);
			util.switchToChildWindow();
			log("STEP 16: user can click on Manage Custom Field Icon", Status.PASS);
		} catch (Exception e) {
			log("STEP 16: user cannot click on Manage Custom Field Icon", Status.FAIL);
			throw new RuntimeException("Failed in step 16");
		}
		
		By approverName = By.xpath("(//*[contains(text(),'"+map.get("FieldName")+"')]/..)[1]");
		
		if(!util.isElementVisible(approverName)) {
		try {
			ClickOnAddNewRecordLink();
			log("STEP 17: user can click on Add new record button", Status.PASS);
		} catch (Exception e) {
			log("STEP 17: user can not click on Add new record button", Status.FAIL);
			throw new RuntimeException("Failed in step 17");
		}
		
		try {
			AddFieldName(map.get("FieldName"));
			log("STEP 18: user can able to enter text in the 'Field Name' field     ", Status.PASS);
		} catch (Exception e) {
			log("STEP 18: user not able to enter text in the 'Field Name' field     ", Status.FAIL);
			throw new RuntimeException("Failed in step 18");
		}
		
		try {
			SelectFieldType(map.get("FieldType"));
			log("STEP 19: user can able to select the value 'LTEXT' from field type dd ", Status.PASS);
		} catch (Exception e) {
			log("STEP 19: user can not able to select the value 'LTEXT'  from field type dd ", Status.FAIL);
			throw new RuntimeException("Failed in step 19");
		}
		
		
		try {
			AddDisplayOrder(map.get("DisplayOrder"));
			log("STEP 20: user can able to enter value in Display order field ", Status.PASS);
		} catch (Exception e) {
			log("STEP 20: user can not able to enter value in Display order field ", Status.FAIL);
			throw new RuntimeException("Failed in step 20");
		}
		
		try {
			AddMaxLengthValue("80");
			log("STEP 21: user can able to enter value in Max Length/Value field ", Status.PASS);
		} catch (Exception e) {
			log("STEP 21: user cannot able to enter value in Max Length/Value field   ", Status.FAIL);
			throw new RuntimeException("Failed in step 21");
		}
		
		try {
			AddHeight("25");
			log("STEP 22:  user can able to enter value in Height field", Status.PASS);
		} catch (Exception e) {
			log("STEP 22:  user cannot able to enter value in Height field ", Status.FAIL);
			throw new RuntimeException("Failed in step 22");
		}
		
		try {
			ClickOnInsert();
			util.waitFor(200);
			log("STEP 23: user can able to click on insert button ", Status.PASS);
		} catch (Exception e) {
			log("STEP 23: user cannot able to click on insert button  ", Status.FAIL);
			throw new RuntimeException("Failed in step 23");
		}
		}
		
		try {
			ClickOnSaveHeader();
			log("STEP 24: user can able to click on Save Header button ", Status.PASS);
		} catch (Exception e) {
			log("STEP 24: user cannot able to click on Save Header button  ", Status.FAIL);
			throw new RuntimeException("Failed in step 24");
		}
		
		try {
			ClickOnPublish();
			driver.close();
			util.switchToParentWindow();
			util.click(btnRefresh);
			util.switchToIframe(FullFrm);
			log("STEP 25: user can able to click on Publish button ", Status.PASS);
		} catch (Exception e) {
			log("STEP 25: user cannot able to click on Publish button  ", Status.FAIL);
			throw new RuntimeException("Failed in step 25");
		}
		try {
			util.waitFor(200);
			util.click(securityOptions);
			log("STEP 26: user can click on Security Options Tab", Status.PASS);
		} catch (Exception e) {
			log("STEP 26: user can not click on Security Options Tab", Status.FAIL);
			throw new RuntimeException("Failed in step 26");
		}

		createRole = util.getAttributeValue(createRoleDD, "value");
		if (createRole.contains("Select One")) {
		try {
			selectCreatePermission(map.get("Reviewer"));
			log("STEP 27: user can select Role for Create", Status.PASS);
		} catch (Exception e) {
			log("STEP 27: user can not select Role for Create", Status.FAIL);
			throw new RuntimeException("Failed in step 27");
		}
		}
		
		viewRole = util.getAttributeValue(viewRoleDD, "value");
		if (viewRole.contains("Select One")) {
			try {
				selectViewPermission(map.get("Reviewer"));
				log("STEP 28: user can select Role for View", Status.PASS);
			} catch (Exception e) {
				log("STEP 28: user can not select Role for View", Status.FAIL);
				throw new RuntimeException("Failed in step 28");
			}
			}
		
		
		try {
			util.click(btnSave);
			util.dummyWait(1);
			log("STEP 29: user can click on Save button", Status.PASS);
		} catch (Exception e) {
			log("STEP 29: user can not click on Save button", Status.FAIL);
			throw new RuntimeException("Failed in step 29");
		}

		try {
			closeApprovalForm();
			util.reloadPage();
			log("STEP 30: user can close the popup", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 30: user can not close the popup", Status.FAIL);
			throw new RuntimeException("Failed in step 30");
		}
		
		try {
			ClickOnAddNewRecord();
			log("STEP 31: User can click on Add new record button", Status.PASS);
		} catch (Exception e) {
			log("STEP 31: User cannot click on Add new record button", Status.FAIL);
			throw new RuntimeException("Failed in step 31");
		}
		
		try {
			selectApprovalType(map.get(Excel.ApprovalType));
			log("STEP 32: User can Select Configured Work Flow from Approval Type DD", Status.PASS);
		} catch (Exception e) {
			log("STEP 32: User cannot select Configured Work Flow from Approval Type DD", Status.FAIL);
			throw new RuntimeException("Failed in step 32");
		}
		
		try {
			By name = By.xpath("(//*[contains(text(),'"+map.get("FieldName")+"')]/..//textarea)[1]");
			util.inputTextAndPressTab(name, map.get("Approver Name"));
			log("STEP 33: User can enter value in Approver Name field", Status.PASS);
		} catch (Exception e) {
			log("STEP 33: User cannot enter value in Approver Name field", Status.FAIL);
			throw new RuntimeException("Failed in step 33");
		}
		
		try {
			clickOnSaveApprovals();
			log("STEP 34: User can click on save button", Status.PASS);
		} catch (Exception e) {
			log("STEP 34: User cannot click on save button", Status.FAIL);
			throw new RuntimeException("Failed in step 34");
		}
		
		try {
			SubmitForReview();
			log("STEP 35: User can click on Submit For Review button", Status.PASS);
		} catch (Exception e) {
			log("STEP 35: User cannot click on Submit For Review button", Status.FAIL);
			throw new RuntimeException("Failed in step 35");
		}
		
		try {
			closeApprovalForm();
			log("STEP 36: user can close the popup", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 36: user can not close the popup", Status.FAIL);
			throw new RuntimeException("Failed in step 36");
		}
		}
	}

}
