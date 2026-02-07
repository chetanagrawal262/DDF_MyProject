package pages.tools;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

public class ConfiguredApplicationLevelWorkflow extends BasePage {

	TestUtil util;
	CommonFunction commonFunction;
	public String wf = "";
	public String createRole = "";
	public String viewRole = "";
	public String ApprovalType = "";

	public ConfiguredApplicationLevelWorkflow(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}

	By navToolsMenu = By.xpath("//a//span[@class='rmText rmExpandDown' and contains(text(),'Tools')] ");
	By navCreateApplicationRequest = By.xpath("//a//span[@class='rmText' and contains(text(),'Create Application Requests')] ");
	By btnDesignMode = By.xpath("//input[contains(@id,'btnDesignModeOff') and @type='image']");
	By wfConfigurationIcon = By.xpath("//span[contains(@id,'ApplicationWorkFlow1_YALWorkflows_ManageWFConfigID')]");
	By btnAddNewRecord = By.xpath("//img[contains(@id,'YALWorkflows_radYALGridControl')]");
	By FullFrm = By.xpath("//iframe[@name='ManageApprovalDialog']");
	By drpApprovalType = By.xpath("//input[contains(@id,'_cbParcelApprovalType_YALComboBox_Input') and @type='text']");
	By FirstWorkFlow = By.xpath("//*[contains(@id,'_cbParcelApprovalType_YALComboBox_DropDown')]//li[1]");
	By comboBoxConfiguration = By.xpath("//span[contains(@id,'idManageParcelApprovals_cbParcelApprovalType_ManageComboID')]");
	By LinkAddNewRecord = By.xpath("(//a[contains(@id,'lnkAddNewRecord')])[1]");
	By DisplayOrder = By.xpath("(//input[contains(@id,'Lookup_Order')])[1]");
	By txtLookupDescription = By.xpath("(//textarea[contains(@id,'Lookup_Desc')])[1]");
	By Insertbtn = By.xpath("(//input[contains(@id,'btnInsert')])[1]");
	By btnReload = By.xpath("//a[@class='rwReloadButton']");
	By securityOptions = By.xpath("//span[text()='Security Options']");
	By checkBoxValidateOnSubmit = By.xpath("//input[contains(@id,'idManageParcelApprovals_WFSubmitNotifier_chkValidateOnSubmit')]");
	By addNewStep = By.xpath("//img[contains(@id,'idManageParcelApprovals_gridParcelApprovalType_radYALGridControl') and @alt='Add new record']");
	By reviewer = By.xpath("//*[text()='Reviewer:']/..//div");
	By ddFilter = By.xpath("(//*[contains(@value,'Filtering...')])[1]");
	By stepName = By.xpath("//input[contains(@id,'_EditFormControl_idEditWorkflowReview_STATIC_STEP_NAME') and @type='text']");
	By rejectionDD = By.xpath("//input[contains(@id,'idEditWorkflowReview_REJECT_STEP_ID_YALComboBox_Input') and @type='text']");
	By checkBoxAutoProcessing = By.xpath("//input[contains(@id,'idEditWorkflowReview_REJECT_STEP_ID_YALComboBox_Input') and @type='text']");
	By checkBoxAllowEdit = By.xpath("//input[contains(@id,'EditFormControl_idEditWorkflowReview_chkEditFormFields') and @type='checkbox']");
	By ddNotificationOnApproval = By.xpath("//*[contains(text(),'Approval Notification')]/..//div");
	By ddNotificationOnRejection = By.xpath("//*[contains(text(),'RejectionNotification')]/..//div");
	By daysForAction = By.xpath("//input[contains(@id,'EditFormControl_idEditWorkflowReview_txtDaysForAction') and @type='text']");
	By DateType = By.xpath("//input[contains(@id,'idEditWorkflowReview_cbWFDateType_radYALDropDownList_Input') and @type='text']");
	By createRoleDD = By.xpath("//input[contains(@id,'_cbCreateRoles') and @type='text']");
	By viewRoleDD = By.xpath("//input[contains(@id,'_cbViewRoles') and @type='text']");
	By btnSave = By.xpath("//input[contains(@id,'_btnSaveHeader')]");
	By btnEdit = By.xpath("//*[@title='Edit']");
	By customFieldIcon = By.xpath("//span[contains(@id,'ManageAddFieldsID')]");
	By approverEmail = By.xpath("(//*[contains(text(),'Approver Email:')]/..)[1]");
	By approverName = By.xpath("(//*[contains(text(),'Approver Name:')]/..)[1]");
	By commentsTextBox = By.xpath("(//*[contains(text(),'Comments:')]/..)[1]");
	By txtFieldName = By.xpath("//input[contains(@id,'editcc_Field_Name') and @type='text']");
	By drpFieldType = By.xpath("//input[contains(@id,'editcc_Field_Type_ID_radYALDropDownList_Input') and @type='text']");
	 By txtDisplayOrder = By.xpath("//input[contains(@id,'editcc_Display_Order') and @type='text']");
	 By txtMaxLengthValue = By.xpath("//input[contains(@id,'editcc_Max_Length_Value') and @type='text']");
	 By txtHeight = By.xpath("//input[contains(@id,'editcc_radHeight') and @type='text']");
	By btnCloseForm = By.xpath("//div[contains(@id,'ManageApprovalDialog')]//a[@title='Close']");

	public void navigateToCreateApplicationRequests() {
		util.waitUntilElementDisplay(navToolsMenu);
		util.click(navToolsMenu);
		util.waitUntilElementDisplay(navCreateApplicationRequest);
		util.click(navCreateApplicationRequest);
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
    
    public void selectApprovalNotification(String value) {
		util.waitUntilElementDisplay(ddNotificationOnApproval);
		util.click(ddNotificationOnApproval);
		util.inputText(ddFilter, value);
		By selectDD = By
				.xpath("(//div[contains(@id,'ddApprovalNotificationReviewers')]//*[text()='" + value + "']/../..//input)[1]");
		util.click(selectDD);
		
    }
    public void selectRejectionNotification(String value) {
		util.waitUntilElementDisplay(ddNotificationOnRejection);
		util.click(ddNotificationOnRejection);
		util.inputText(ddFilter, value);
		By selectDD = By
				.xpath("(//div[contains(@id,'_ddRejectionNotificationReviewers_RadDropDownTree')]//*[text()='" + value + "']/../..//input)[1]");
		util.click(selectDD);
		
    }
    
    public void DaysForAction(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(daysForAction, value);
	}
    
    public void selectDateType(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(DateType, value);
	}
    
    public void selectCreatePermission(String value) {
		if (!commonFunction.checkNA(value)) {
			util.click(createRoleDD);
				util.inputText(createRoleDD, value);
				By selectPermission = By.xpath("//*[contains(text(),'"+value+"')]//./../input");
				util.click(selectPermission);
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
		util.waitFor(200);
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
	    	util.waitUntilPageLoad();
	    }
	    
	    public void ClickOnPublish() {
	    	util.waitUntilElementDisplay(btnPublish);
	    	util.click(btnPublish);
	    	util.waitFor(2000);
	    	util.waitUntilPageLoad();
	    }
	public void ConfiguredApplicationLevelWF(Map<String, String> map, String testcaseName, String scenario)
			throws InterruptedException {
		
		if(scenario.contains("CalendarDays")) {
			ApprovalType = map.get("ApprovalType1");
		}else if(scenario.contains("BusinessDays")) {
			ApprovalType = map.get("ApprovalType2");
		}else {
			ApprovalType = map.get("ApprovalType3");
		}
		
		try {
			navigateToCreateApplicationRequests();
			log("STEP 1:  user can navigate to Application Work Flow Page", Status.PASS);
		} catch (Exception e) {
			log("STEP 1:  user cannot navigate to Application Work Flow Page", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}
		try {
			TurnOnDesignCode();
			log("STEP 2: User can Turn on the Design mode", Status.PASS);
		} catch (Exception e) {
			log("STEP 2: User cannot Turn on the Design mode", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}

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

		By WF = By.xpath("//*[contains(@id,'_cbParcelApprovalType_YALComboBox_DropDown')]/..//*[text()='"+ ApprovalType + "']");
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
				AddLookupDescription(ApprovalType);
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
			selectApprovalType(ApprovalType);
			
			log("STEP 10: user can select Approval Type", Status.PASS);
		} catch (Exception e) {
			log("STEP 10: user can not select the Approval Type", Status.FAIL);
			throw new RuntimeException("Failed in step 10");
		}

		By btnEdit = By.xpath("//*[text()='"+map.get("Step Name")+"']/..//*[@title='Edit']");
		util.waitFor(500);
		if(!util.isElementVisible(btnEdit)) {
		try {
			util.click(addNewStep);
			util.dummyWait(1);
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
		
//		try {
//			selectApprovalNotification(map.get("Reviewer"));
//			log("STEP 15: user can select the Approval Notification User", Status.PASS);
//		} catch (Exception e) {
//			log("STEP 15: user cannot select Approval Notification User", Status.FAIL);
//			throw new RuntimeException("Failed in step 15");
//		}
//		
//		try {
//			selectRejectionNotification(map.get("Reviewer"));
//			log("STEP 16: user can select the Rejection Notification User", Status.PASS);
//		} catch (Exception e) {
//			log("STEP 16: user cannot select Rejection Notification User", Status.FAIL);
//			throw new RuntimeException("Failed in step 16");
//		}
		if(scenario.contains("CalendarDays") || scenario.contains("BusinessDays")){
		try {
			DaysForAction(map.get("Days"));
			log("STEP 17: user can enter days", Status.PASS);
		} catch (Exception e) {
			log("STEP 17: user cannot enter days", Status.FAIL);
			throw new RuntimeException("Failed in step 17");
		}
		}
		
		if(scenario.contains("CalendarDays")){
		try {
			selectDateType("Calendar days");
			log("STEP 18: user can select Date Type", Status.PASS);
		} catch (Exception e) {
			log("STEP 18: user cannot select Date Type", Status.FAIL);
			throw new RuntimeException("Failed in step 18");
		}
		}else if(scenario.contains("BusinessDays")) {
			try {
				selectDateType("Business days");
				log("STEP 18: user can select Date Type", Status.PASS);
			} catch (Exception e) {
				log("STEP 18: user cannot select Date Type", Status.FAIL);
				throw new RuntimeException("Failed in step 18");
			}
		}
				
		try {
			ClickOnInsert();
			util.waitFor(200);
			log("STEP 19: user can click on Insert button ", Status.PASS);
		} catch (Exception e) {
			log("STEP 19: user cannot click on Insert button ", Status.FAIL);
			throw new RuntimeException("Failed in step 19");
		}
		}
		
		try {
			selectApprovalType(ApprovalType);
			util.click(customFieldIcon);
			util.switchToChildWindow();
			log("STEP 20: user can click on Manage Custom Field Icon", Status.PASS);
		} catch (Exception e) {
			log("STEP 20: user cannot click on Manage Custom Field Icon", Status.FAIL);
			throw new RuntimeException("Failed in step 20");
		}

        util.waitFor(500);
		if(!util.isElementVisible(approverName)) {
		try {
			ClickOnAddNewRecordLink();
			log("STEP 21: user can click on Add new record button", Status.PASS);
		} catch (Exception e) {
			log("STEP 21: user can not click on Add new record button", Status.FAIL);
			throw new RuntimeException("Failed in step 21");
		}
		
		try {
			AddFieldName(map.get("FieldName1"));
			log("STEP 22: user can able to enter text in the \"field name \" field     ", Status.PASS);
		} catch (Exception e) {
			log("STEP 22: user not able to enter text in the \"field name \" field     ", Status.FAIL);
			throw new RuntimeException("Failed in step 22");
		}
		
		try {
			SelectFieldType(map.get("FieldType1"));
			log("STEP 23: user can able to select the value \"TEXT\" from field type dd ", Status.PASS);
		} catch (Exception e) {
			log("STEP 23: user can not able to select the value \"TEXT\"  from field type dd ", Status.FAIL);
			throw new RuntimeException("Failed in step 23");
		}
		
		
		try {
			AddDisplayOrder(map.get("DisplayOrder"));
			log("STEP 24: user can able to enter value in Display order field ", Status.PASS);
		} catch (Exception e) {
			log("STEP 24: user can not able to enter value in Display order field ", Status.FAIL);
			throw new RuntimeException("Failed in step 24");
		}
		
		try {
			AddMaxLengthValue("50");
			log("STEP 25: user can able to enter value in Max Length/Value field ", Status.PASS);
		} catch (Exception e) {
			log("STEP 25: user cannot able to enter value in Max Length/Value field   ", Status.FAIL);
			throw new RuntimeException("Failed in step 25");
		}
		
		try {
			ClickOnInsert();
			util.waitFor(200);
			log("STEP 26: user can able to click on insert button ", Status.PASS);
		} catch (Exception e) {
			log("STEP 26: user cannot able to click on insert button  ", Status.FAIL);
			throw new RuntimeException("Failed in step 26");
		}
		}
		
		if(!util.isElementVisible(approverEmail)) {
		try {
			ClickOnAddNewRecordLink();
			log("STEP 27: user can click on Add new record button", Status.PASS);
		} catch (Exception e) {
			log("STEP 27: user can not click on Add new record button", Status.FAIL);
			throw new RuntimeException("Failed in step 27");
		}
		
		try {
			AddFieldName(map.get("FieldName2"));
			log("STEP 28: user can able to enter text in the \"field name \" field     ", Status.PASS);
		} catch (Exception e) {
			log("STEP 28: user not able to enter text in the \"field name \" field     ", Status.FAIL);
			throw new RuntimeException("Failed in step 28");
		}
		
		try {
			SelectFieldType(map.get("FieldType2"));
			log("STEP 29: user can able to select the value \"TEXT\" from field type dd ", Status.PASS);
		} catch (Exception e) {
			log("STEP 29: user can not able to select the value \"TEXT\"  from field type dd ", Status.FAIL);
			throw new RuntimeException("Failed in step 29");
		}
		
		
		try {
			AddDisplayOrder(map.get("DisplayOrder"));
			log("STEP 30: user can able to enter value in Display order field ", Status.PASS);
		} catch (Exception e) {
			log("STEP 30: user can not able to enter value in Display order field ", Status.FAIL);
			throw new RuntimeException("Failed in step 30");
		}
		
		try {
			AddNoOfColumn("2");
			log("STEP 31:  user can able to enter value in # of column field", Status.PASS);
		} catch (Exception e) {
			log("STEP 31: user cannot able to enter value in # of column field ", Status.FAIL);
			throw new RuntimeException("Failed in step 31");
		}
		
		try {
			ClickOnInsert();
			util.waitFor(200);
			log("STEP 32: user can able to click on insert button ", Status.PASS);
		} catch (Exception e) {
			log("STEP 32: user cannot able to click on insert button  ", Status.FAIL);
			throw new RuntimeException("Failed in step 32");
		}
		}
		
		if(!util.isElementVisible(commentsTextBox)) {
		try {
			ClickOnAddNewRecordLink();
			log("STEP 33: user can click on Add new record button", Status.PASS);
		} catch (Exception e) {
			log("STEP 33: user can not click on Add new record button", Status.FAIL);
			throw new RuntimeException("Failed in step 33");
		}
		
		try {
			AddFieldName(map.get("FieldName3"));
			log("STEP 34: user can able to enter text in the \"field name \" field     ", Status.PASS);
		} catch (Exception e) {
			log("STEP 34: user not able to enter text in the \"field name \" field     ", Status.FAIL);
			throw new RuntimeException("Failed in step 34");
		}
		
		try {
			SelectFieldType(map.get("FieldType3"));
			log("STEP 35: user can able to select the value \"TEXT\" from field type dd ", Status.PASS);
		} catch (Exception e) {
			log("STEP 35: user can not able to select the value \"TEXT\"  from field type dd ", Status.FAIL);
			throw new RuntimeException("Failed in step 35");
		}
		
		
		try {
			AddDisplayOrder(map.get("DisplayOrder"));
			log("STEP 36: user can able to enter value in Display order field ", Status.PASS);
		} catch (Exception e) {
			log("STEP 36: user can not able to enter value in Display order field ", Status.FAIL);
			throw new RuntimeException("Failed in step 36");
		}
		
		try {
			AddNoOfColumn("3");
			log("STEP 37:  user can able to enter value in # of column field", Status.PASS);
		} catch (Exception e) {
			log("STEP 37: user cannot able to enter value in # of column field ", Status.FAIL);
			throw new RuntimeException("Failed in step 37");
		}
		
		try {
			AddMaxLengthValue("100");
			log("STEP 38: user can able to enter value in Max Length/Value field ", Status.PASS);
		} catch (Exception e) {
			log("STEP 38: user cannot able to enter value in Max Length/Value field   ", Status.FAIL);
			throw new RuntimeException("Failed in step 38");
		}
		
		try {
			AddHeight("100");
			log("STEP 39:  user can able to enter value in Height field", Status.PASS);
		} catch (Exception e) {
			log("STEP 39:  user cannot able to enter value in Height field ", Status.FAIL);
			throw new RuntimeException("Failed in step 39");
		}
		
		try {
			ClickOnInsert();
			util.waitFor(200);
			log("STEP 40: user can able to click on insert button ", Status.PASS);
		} catch (Exception e) {
			log("STEP 40: user cannot able to click on insert button  ", Status.FAIL);
			throw new RuntimeException("Failed in step 40");
		}
		}
		try {
			ClickOnSaveHeader();
			log("STEP 41: user can able to click on Save Header button ", Status.PASS);
		} catch (Exception e) {
			log("STEP 41: user cannot able to click on Save Header button  ", Status.FAIL);
			throw new RuntimeException("Failed in step 41");
		}
		
		try {
			ClickOnPublish();
			driver.close();
			util.waitFor(200);
			util.switchToParentWindow();
			util.switchToIframe(FullFrm);
			log("STEP 42: user can able to click on Publish button ", Status.PASS);
		} catch (Exception e) {
			log("STEP 42: user cannot able to click on Publish button  ", Status.FAIL);
			throw new RuntimeException("Failed in step 42");
		}
		try {
			util.waitFor(200);
			util.click(securityOptions);
			log("STEP 43: user can click on Security Options Tab", Status.PASS);
		} catch (Exception e) {
			log("STEP 43: user can not click on Security Options Tab", Status.FAIL);
			throw new RuntimeException("Failed in step 43");
		}

		createRole = util.getAttributeValue(createRoleDD, "value");
		if (createRole.contains("Select One")) {
		try {
			selectCreatePermission(map.get("Reviewer"));
			log("STEP 44: user can select Role for Create", Status.PASS);
		} catch (Exception e) {
			log("STEP 44: user can not select Role for Create", Status.FAIL);
			throw new RuntimeException("Failed in step 44");
		}
		}
		
		viewRole = util.getAttributeValue(viewRoleDD, "value");
		if (viewRole.contains("Select One")) {
			try {
				selectViewPermission(map.get("Reviewer"));
				log("STEP 45: user can select Role for View", Status.PASS);
			} catch (Exception e) {
				log("STEP 45: user can not select Role for View", Status.FAIL);
				throw new RuntimeException("Failed in step 45");
			}
			}
		
		try {
			util.click(btnSave);
			log("STEP 46: user can click on Save button", Status.PASS);
		} catch (Exception e) {
			log("STEP 46: user can not click on Save button", Status.FAIL);
			throw new RuntimeException("Failed in step 46");
		}
		

		try {
			closeApprovalForm();
			util.reloadPage();
			log("STEP 47: user can close the popup", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 47: user can not close the popup", Status.FAIL);
			throw new RuntimeException("Failed in step 47");
		}


	}

}
