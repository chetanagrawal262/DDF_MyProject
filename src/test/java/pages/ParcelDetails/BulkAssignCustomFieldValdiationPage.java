package pages.ParcelDetails;

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

public class BulkAssignCustomFieldValdiationPage extends BasePage {

	TestUtil util;
	CommonFunction commonFunction;
	public String createRole = "";
	public String viewRole = "";
	public String docName ="";

	public BulkAssignCustomFieldValdiationPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}

	By navParcel = By.xpath("//span[text()='Parcel'] | //span[text()='Tract']");
	By navParcelInfo = By.xpath("//span[text()='Parcel Info'] | //span[text()='Tract Info']");
	By navParcelInformation = By.xpath("//span[contains(text(),'Parcel Information')] | //span[contains(text(),'Tract Information')] | //span[contains(text(),'Record Information')]");
	By btnDesignMode = By.xpath("//input[contains(@id,'btnDesignModeOff') and @type='image']");
	By wfConfigurationIcon = By.xpath("//span[contains(@title,'WorkFlow Configuration')]");
	By btnAddNewRecord = By.xpath("//img[contains(@id,'YALWorkflows_radYALGridControl')]");
	By FullFrm = By.xpath("//iframe[@name='ManageApprovalDialog']");
	By drpApprovalType = By.xpath("//input[contains(@id,'_cbParcelApprovalType_YALComboBox_Input') and @type='text']");
	By comboBoxConfiguration = By.xpath("//span[contains(@id,'idManageParcelApprovals_cbParcelApprovalType_ManageComboID')]");
	By LinkAddNewRecord = By.xpath("(//a[contains(@id,'lnkAddNewRecord')])[1]");
	By DisplayOrder = By.xpath("(//input[contains(@id,'Lookup_Order')])[1]");
	By txtLookupDescription = By.xpath("(//textarea[contains(@id,'Lookup_Desc')])[1]");
	By Insertbtn = By.xpath("(//input[contains(@id,'btnInsert')])[1]");
	By Cancelbtn = By.xpath("(//input[contains(@id,'btnCancel')])[1]");
	By btnReload = By.xpath("//a[@class='rwReloadButton']");
	By securityOptions = By.xpath("//span[text()='Security Options']");
	By createRoleDD = By.xpath("//input[contains(@id,'_cbCreateRoles') and @type='text']");
	By viewRoleDD = By.xpath("//input[contains(@id,'_cbViewRoles') and @type='text']");
	By btnSave = By.xpath("//input[contains(@id,'_btnSaveHeader')]");
	By customFieldIcon = By.xpath("//span[contains(@id,'ManageAddFieldsID')]");
	By txtFieldName = By.xpath("//input[contains(@id,'editcc_Field_Name') and @type='text']");
	By drpFieldType = By.xpath("//input[contains(@id,'editcc_Field_Type_ID_radYALDropDownList_Input') and @type='text']");
	By txtDisplayOrder = By.xpath("//input[contains(@id,'editcc_Display_Order') and @type='text']");
	By btnCloseForm = By.xpath("//div[contains(@id,'ManageApprovalDialog')]//a[@title='Close']");
	By btnRefresh = By.xpath("//a[@title='Reload']");
	By linkConfigureFieldPermissions = By.xpath("//*[@id='idMngCustmAdnlFields_configpermlink']/a[text()='Configure Field Permissions']");
	By ifrmaePermissions = By.xpath("//iframe[@name='rwCC_Permissions']");
	By btnBulkEditMode = By.xpath("//input[@value='Bulk Edit Mode']");
	By permissionSingleDoc = By.xpath("(//table[contains(@id,'idManageCustomControlRolePermissions_rgGridDetails')]/..//td[count(//table/thead/tr/th[.='QA Role']/preceding-sibling::th)+1])[2]");
	By permissionMultiDoc = By.xpath("(//table[contains(@id,'idManageCustomControlRolePermissions_rgGridDetails')]/..//td[count(//table/thead/tr/th[.='QA Role']/preceding-sibling::th)+1])[3]");
	By ddArrowPermission = By.xpath("(//a[contains(@id,'templateColumnDD_Arrow')])[1]");
	By valueNoAccess = By.xpath("(//div[contains(@id,'templateColumnDD_DropDown')]/..//li[text()='NO ACCESS'])[1]");
	By valueRead = By.xpath("(//div[contains(@id,'templateColumnDD_DropDown')]/..//li[text()='READ'])[1]");
	By valueWrite = By.xpath("(//div[contains(@id,'templateColumnDD_DropDown')]/..//li[text()='WRITE'])[1]");
	By btnSaveChanges = By.xpath("//input[contains(@id,'_SaveChangesIcon')]");
	By btnClosePermission = By.xpath("//a[@title='Close']");
	
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
		util.dummyWait(2);
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

	public void ClickOnCancel() {
		util.waitUntilElementDisplay(Cancelbtn);
		util.click(Cancelbtn);
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
	    
	    By DocumentCategory = By.xpath("(//span[contains(@class,'rddtFakeInput rddtEmptyMessage')])[2]");
	    By txtDocumentCategory = By.xpath("(//input[contains(@class,'rddtFilterEmptyMessage') and @value='Filtering...'])[1]");
	    
	    public void SelectDocumentCategory(String value) {
	    	util.waitUntilElementDisplay(DocumentCategory);
	    	util.click(DocumentCategory);
	    	if (!commonFunction.checkNA(value)) 
				util.inputText(txtDocumentCategory, value);
	    	util.pressDownkey();
	    	util.pressDownkey();
	    	util.pressENTERkey();
	    	util.dummyWait(1);
	    }
    
	    By drpDraft_Final = By.xpath("//input[contains(@id,'_editcc_ddlDocDraftFinal_radYALDropDownList_Input') and @type='text']");
	    
	    public void SelectDraft_Final(String value) {
	    	if (!commonFunction.checkNA(value)) 
				util.inputTextAndPressTab(drpDraft_Final, value);
	    }
	    
	    By btnSaveHeader = By.xpath("//input[contains(@id,'btnSaveHeader')]");
	    By btnPublish = By.xpath("//input[contains(@id,'PublishViews')]");
	    public void ClickOnSaveHeader() {
	    	util.waitUntilElementDisplay(btnSaveHeader);
	    	util.click(btnSaveHeader);
	    	util.dummyWait(1);
	    }
	    
	    public void ClickOnPublish() {
	    	util.waitUntilElementDisplay(btnPublish);
	    	util.click(btnPublish);
	    	util.waitFor(200);
	    }
	    
	    By btnSaveApprovals = By.xpath("//input[contains(@id,'_btnSaveHeader')]");
	    By approved = By.xpath("//a[text()='Approved']");
	    public void clickOnSaveApprovals() {
			util.click(btnSaveApprovals);
			util.dummyWait(1);
		}
	   
		public void uploadFile(String value) {
			 By fileUpload2 = By.xpath("//*[text()='"+value+"']/..//input[contains(@id,'customFields') and @type='file']");
			 docName = "WorkflowDoc.txt";
			String filepath = System.getProperty("user.dir") + File.separator + docName;
			driver.findElement(fileUpload2).sendKeys(filepath);
		}
		
		By navAdministration = By.xpath("//span[text()='Administration']");
		By navABS = By.xpath("//span[contains(text(),'Application Behavior Settings')]");
		By txtFilterKeyName = By.xpath("//input[@alt='Filter key_name column']");
		By btnFilterKeyName = By.xpath("//input[contains(@id,'Filter_key_name') and @type='button']");
		By optionFilter = By.xpath("//span[text()='Contains']");
	    By btnSubmitAll = By.xpath("//input[@title='Submit All']");
		
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
			
			 util.click(btnFilterKeyName);
			 util.waitFor(500);
		    	if(!util.isElementVisible(optionFilter)) {
				util.waitUntilElementDisplay(btnFilterKeyName);
				util.click(btnFilterKeyName);
				util.click(optionFilter);
				}
			}
		 
		
		 public void setKeyValue(String key, String value) {
		    	By keyValue = By.xpath("//*[text()='"+key+"']/..//input[contains(@name,'txtValue')]");
		    	util.dummyWait(1);
				//util.waitUntilElementDisplay(keyValue);
				util.inputTextAndPressTab(keyValue, value);
			}
		 
		  public void clickOnSubmitAll() {
				util.waitUntilElementDisplay(btnSubmitAll);
				util.click(btnSubmitAll);;
			}
		  
		  By btnDocuments = By.xpath("//div[@id='idManageApproval_tabStrip']//span[contains(text(),'Documents')]");
		  public void ClickonDocumentsTab()
			{
				util.waitUntilElementDisplay(btnDocuments);
				util.click(btnDocuments);	    	
				    
			}
		  
		  public void ClickonConfigureFieldPermissions(){
				util.waitUntilElementDisplay(linkConfigureFieldPermissions);
				util.click(linkConfigureFieldPermissions);	    	
			}
		  
		  public void SwitchToIframePermission(){
				util.waitUntilElementDisplay(ifrmaePermissions);
				util.switchToIframe(ifrmaePermissions);	 
				util.waitFor(300);
			}
		  
		  public void ClickonBulkEditMode(){
				util.waitUntilElementDisplay(btnBulkEditMode);
				util.click(btnBulkEditMode);	    	    
			}
		  
		  public void ClickonSaveChanges(){
				util.waitUntilElementDisplay(btnSaveChanges);
				util.click(btnSaveChanges);	    	    
			}
		  
		public void SetDocDraftFinalSetting(Map<String, String> map, String testcaseName, String value)
				throws InterruptedException {
			try {
	 		    NavigateToApplicationBehaviorSettings();
	  			log("STEP 1: User can navigate to Application Behavior Settings ", Status.PASS);
	  		} catch (Exception e) {
	  			log("STEP 1: User cannot navigate to Application Behavior Settings ", Status.FAIL);
	  			throw new RuntimeException("Failed in step 1");
	  		}
			 
			 try {
	 		    enterKeyName(map.get("ABS"));
	  			log("STEP 2: User can enter key name "+map.get("KeyName"), Status.PASS);
	  		} catch (Exception e) {
	  			log("STEP 2: User cannot enter key name "+map.get("KeyName"), Status.FAIL);
	  			throw new RuntimeException("Failed in step 2");
	  		} 
			 
			 try {
	 		    selectFilter();
	  			log("STEP 3: User can click on Filter Icon", Status.PASS);
	  		} catch (Exception e) {
	  			log("STEP 3: User cannot click on Filter Icon", Status.FAIL);
	  			throw new RuntimeException("Failed in step 3");
	  		} 
			 
			 try {
		 		    setKeyValue(map.get("ABS"), value);
		  			log("STEP 4: User can set "+ value+" value for key name "+map.get("ABS"), Status.PASS);
		  		} catch (Exception e) {
		  			log("STEP 4: User cannot set "+ value+" value for key name "+map.get("ABS"), Status.FAIL);
		  			throw new RuntimeException("Failed in step 4");
		  		} 
			 
			 try {
	 		    clickOnSubmitAll();
	  			log("STEP 5: User can click on Submit All button ", Status.PASS);
	  		} catch (Exception e) {
	  			log("STEP 5: User cannot click on Submit All button", Status.FAIL);
	  			throw new RuntimeException("Failed in step 5");
	  		} 
		}
		
	public void parcelWorkflowConfiguration(Map<String, String> map, String testcaseName)
			throws InterruptedException {
		
		try {
			navigateParcelInformation();
			log("STEP 1:  user can navigate to Parcel Information Page", Status.PASS);
		} catch (Exception e) {
			log("STEP 1:  user cannot navigate to Parcel Information Page", Status.FAIL);
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
		
		try {
			util.click(customFieldIcon);
			util.switchToChildWindow();
			log("STEP 11: user can click on Manage Custom Field Icon", Status.PASS);
		} catch (Exception e) {
			log("STEP 11: user cannot click on Manage Custom Field Icon", Status.FAIL);
			throw new RuntimeException("Failed in step 11");
		}
		
    By customSingleDoc = By.xpath("(//*[contains(text(),'"+map.get("FieldName")+"')]/..)[1]");
		
		if(!util.isElementVisible(customSingleDoc)) {
	    	try {
	    		ClickOnAddNewRecordLink();
				log("STEP 12: user can able to click on the add new record (+)", Status.PASS);
			} catch (Exception e) {
				log("STEP 12: user can not able to click on the add new record (+) ", Status.FAIL);
				throw new RuntimeException("Failed in step 12");
			}
			
	    	try {
				AddFieldName(map.get("FieldName"));
				log("STEP 13: user can able to enter text in the 'Field Name' field     ", Status.PASS);
			} catch (Exception e) {
				log("STEP 13: user not able to enter text in the 'Field Name' field     ", Status.FAIL);
				throw new RuntimeException("Failed in step 13");
			}
			
	    	try {
				SelectFieldType(map.get("FieldType"));
				log("STEP 14: user can able to select the value 'DOCUMENTUPLOAD' from field type dd ", Status.PASS);
			} catch (Exception e) {
				log("STEP 14: user can not able to select the value 'DOCUMENTUPLOAD'  from field type dd ", Status.FAIL);
				throw new RuntimeException("Failed in step 14");
			}
			
			
			try {
				AddDisplayOrder(map.get("DisplayOrder"));
				log("STEP 15: user can able to enter value in Display order field ", Status.PASS);
			} catch (Exception e) {
				log("STEP 15: user can not able to enter value in Display order field ", Status.FAIL);
				throw new RuntimeException("Failed in step 15");
			}
			
			try {
				SelectDocumentCategory(map.get(Excel.DocumentCategory));
				log("STEP 16: user can able to select the value from document category dd ", Status.PASS);
			} catch (Exception e) {
				log("STEP 16: user cannot able to select the value from document category dd ", Status.FAIL);
				throw new RuntimeException("Failed in step 16");
			}
			
			try {
				SelectDraft_Final(map.get("DraftFinal"));
				log("STEP 17: user can see Draft/Final DD and  able to select value from the drop down", Status.PASS);
			} catch (Exception e) {
				log("STEP 17: user cannot see Draft/Final DD or  unable to select value from the drop down ", Status.FAIL);
				throw new RuntimeException("Failed in step 17");
			}
			
			try {
				ClickOnInsert();
				log("STEP 18: user can able to click on insert button ", Status.PASS);
			} catch (Exception e) {
				log("STEP 18: user cannot able to click on insert button  ", Status.FAIL);
				throw new RuntimeException("Failed in step 18");
			}
		}
		
		
		By customMultiDoc = By.xpath("(//*[contains(text(),'"+map.get("FieldName2")+"')]/..)[1]");
		
		if(!util.isElementVisible(customMultiDoc)) {
	    	try {
	    		ClickOnAddNewRecordLink();
				log("STEP 19: user can able to click on the add new record (+)", Status.PASS);
			} catch (Exception e) {
				log("STEP 19: user can not able to click on the add new record (+) ", Status.FAIL);
				throw new RuntimeException("Failed in step 19");
			}
			
	    	try {
				AddFieldName(map.get("FieldName2"));
				log("STEP 20: user can able to enter text in the 'Field Name' field     ", Status.PASS);
			} catch (Exception e) {
				log("STEP 20: user not able to enter text in the 'Field Name' field     ", Status.FAIL);
				throw new RuntimeException("Failed in step 20");
			}
			
	    	try {
				SelectFieldType(map.get("FieldType2"));
				log("STEP 21: user can able to select the value 'MULTIDOCUPLOAD' from field type dd ", Status.PASS);
			} catch (Exception e) {
				log("STEP 21: user can not able to select the value 'MULTIDOCUPLOAD'  from field type dd ", Status.FAIL);
				throw new RuntimeException("Failed in step 21");
			}
			
			
			try {
				AddDisplayOrder(map.get("DisplayOrder"));
				log("STEP 22: user can able to enter value in Display order field ", Status.PASS);
			} catch (Exception e) {
				log("STEP 22: user can not able to enter value in Display order field ", Status.FAIL);
				throw new RuntimeException("Failed in step 22");
			}
			
			try {
				SelectDocumentCategory(map.get(Excel.DocumentCategory));
				log("STEP 23: user can able to select the value from document category dd ", Status.PASS);
			} catch (Exception e) {
				log("STEP 23: user cannot able to select the value from document category dd ", Status.FAIL);
				throw new RuntimeException("Failed in step 23");
			}
			
			try {
				SelectDraft_Final(map.get("DraftFinal"));
				log("STEP 24: user can see Draft/Final DD and  able to select value from the drop down", Status.PASS);
			} catch (Exception e) {
				log("STEP 24: user cannot see Draft/Final DD or  unable to select value from the drop down ", Status.FAIL);
				throw new RuntimeException("Failed in step 24");
			}
			
			try {
				ClickOnInsert();
				log("STEP 25: user can able to click on insert button ", Status.PASS);
			} catch (Exception e) {
				log("STEP 25: user cannot able to click on insert button  ", Status.FAIL);
				throw new RuntimeException("Failed in step 25");
			}
		}
		
			
		try {
			ClickOnSaveHeader();
			log("STEP 26: user can able to click on Save Header button ", Status.PASS);
		} catch (Exception e) {
			log("STEP 26: user cannot able to click on Save Header button  ", Status.FAIL);
			throw new RuntimeException("Failed in step 26");
		}
		
		try {
			ClickOnPublish();
			driver.close();
			util.switchToParentWindow();
			util.click(btnRefresh);
			util.switchToIframe(FullFrm);
			log("STEP 27: user can able to click on Publish button ", Status.PASS);
		} catch (Exception e) {
			log("STEP 27: user cannot able to click on Publish button  ", Status.FAIL);
			throw new RuntimeException("Failed in step 27");
		}
		try {
			util.waitFor(200);
			util.click(securityOptions);
			log("STEP 28: user can click on Security Options Tab", Status.PASS);
		} catch (Exception e) {
			log("STEP 28: user can not click on Security Options Tab", Status.FAIL);
			throw new RuntimeException("Failed in step 28");
		}

		createRole = util.getAttributeValue(createRoleDD, "value");
		if (createRole.contains("Select One")) {
		try {
			selectCreatePermission(map.get("Reviewer"));
			log("STEP 29: user can select Role for Create", Status.PASS);
		} catch (Exception e) {
			log("STEP 29: user can not select Role for Create", Status.FAIL);
			throw new RuntimeException("Failed in step 29");
		}
		}
		
		viewRole = util.getAttributeValue(viewRoleDD, "value");
		if (viewRole.contains("Select One")) {
			try {
				selectViewPermission(map.get("Reviewer"));
				log("STEP 30: user can select Role for View", Status.PASS);
			} catch (Exception e) {
				log("STEP 30: user can not select Role for View", Status.FAIL);
				throw new RuntimeException("Failed in step 30");
			}
			}
		
		try {
			util.click(btnSave);
			util.dummyWait(1);
			log("STEP 31: user can click on Save button", Status.PASS);
		} catch (Exception e) {
			log("STEP 31: user can not click on Save button", Status.FAIL);
			throw new RuntimeException("Failed in step 31");
		}

		try {
			closeApprovalForm();
			util.reloadPage();
			log("STEP 32: user can close the popup", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 32: user can not close the popup", Status.FAIL);
			throw new RuntimeException("Failed in step 32");
		}
		
		try {
			ClickOnAddNewRecord();
			log("STEP 33: User can click on Add new record button", Status.PASS);
		} catch (Exception e) {
			log("STEP 33: User cannot click on Add new record button", Status.FAIL);
			throw new RuntimeException("Failed in step 33");
		}
		
		try {
			selectApprovalType(map.get(Excel.ApprovalType));
			log("STEP 34: User can Select Configured Work Flow from Approval Type DD", Status.PASS);
		} catch (Exception e) {
			log("STEP 34: User cannot select Configured Work Flow from Approval Type DD", Status.FAIL);
			throw new RuntimeException("Failed in step 34");
		}
		
		try {
			uploadFile(map.get("FieldName"));
			log("STEP 35: User can upload document in Single Select Document Upload Custom Control Field", Status.PASS);
		} catch (Exception e) {
			log("STEP 35: User cannot upload document in Single Select Document Upload Custom Control Field", Status.FAIL);
			throw new RuntimeException("Failed in step 35");
		}
		
		try {
			util.dummyWait(1);
			uploadFile(map.get("FieldName2"));
			log("STEP 36: User can upload first document in Multi Select Document Upload Custom Control Field", Status.PASS);
		} catch (Exception e) {
			log("STEP 36: User cannot upload first document in Multi Select Document Upload Custom Control Field", Status.FAIL);
			throw new RuntimeException("Failed in step 36");
		}
		
		try {
			util.dummyWait(1);
			uploadFile(map.get("FieldName2"));
			log("STEP 37: User can upload second document in Multi Select Document Upload Custom Control Field", Status.PASS);
		} catch (Exception e) {
			log("STEP 37: User cannot upload second document in Multi Select Document Upload Custom Control Field", Status.FAIL);
			throw new RuntimeException("Failed in step 37");
		}
		
		try {
			clickOnSaveApprovals();
			log("STEP 38: User can click on save button", Status.PASS);
		} catch (Exception e) {
			log("STEP 38: User cannot click on save button", Status.FAIL);
			throw new RuntimeException("Failed in step 38");
		}
		
		try {
		    By viewDocumentLink = By.xpath("(//*[text()='"+map.get("FieldName")+"']/..//a[text()='View Document'])[1]");
		    Assert.assertTrue(util.isElementVisible(viewDocumentLink));
		log("STEP 39 : User can see document link for the document uploaded from Single Select document custom control field", Status.PASS);
	} catch (AssertionError e) {
		log("STEP 39: User cannot see document link for the document uploaded from Single Select document custom control field", Status.FAIL);
	}
		
		try {
			    By viewDocumentLink1 = By.xpath("(//*[text()='"+map.get("FieldName2")+"']/..//a[text()='View Document'])[1]");
			    By viewDocumentLink2 = By.xpath("(//*[text()='"+map.get("FieldName2")+"']/..//a[text()='View Document'])[2]");
			Assert.assertTrue(util.isElementVisible(viewDocumentLink1));
			Assert.assertTrue(util.isElementVisible(viewDocumentLink2));
			ExtentTestManager.infoWithScreenshot("Multiple Documents link");
			log("STEP 40 : User can see document links for the documents uploaded from Multi Select document custom control field", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 40: User cannot see document links for the documents uploaded from Multi Select document custom control field", Status.FAIL);
		}
	
			try {
 	    		ClickonDocumentsTab();
 	    		util.dummyWait(2);
 				log("STEP 41: User Can Navigate to Documents Tab   ", Status.PASS);
 			} catch (Exception e) {
 				log("STEP 41:  User Cannot Navigate to Documents Tab", Status.FAIL);
 				throw new RuntimeException("Failed in step 41");
 			}
		
			try {
				By edit = By.xpath("(//div[@id='idManageApproval_DOCUMENT_radYALGridControl']/..//*[text()='" + docName+ "']/..//input[@title='Edit'])[1]");
				util.click(edit);
				util.waitFor(500);
				By doc = By.xpath("//input[contains(@id,'_EditFormControl_ddlDocDraftFinal_radYALDropDownList_Input') and @value='"+ map.get("DraftFinal") + "']");
				Assert.assertTrue(util.isElementVisible(doc));
				util.click(Cancelbtn);
				util.dummyWait(1);
				log("STEP 42 : User can see first added documents under the documents tab with DraftFinal Value", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 42: User cannot see first added documents under the documents tab with DraftFinal Value", Status.FAIL);
			}

			try {
				By edit = By.xpath("(//div[@id='idManageApproval_DOCUMENT_radYALGridControl']/..//*[text()='" + docName+ "']/..//input[@title='Edit'])[2]");
				util.click(edit);
				util.waitFor(500);
				By doc = By.xpath("//input[contains(@id,'_EditFormControl_ddlDocDraftFinal_radYALDropDownList_Input') and @value='"+ map.get("DraftFinal") + "']");
				Assert.assertTrue(util.isElementVisible(doc));
				util.click(Cancelbtn);
				util.dummyWait(1);
				log("STEP 43 : User can see second added documents under the documents tab with DraftFinal Value", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 43: User cannot see second added documents under the documents tab with DraftFinal Value", Status.FAIL);
			}
			
			try {
				By edit = By.xpath("(//div[@id='idManageApproval_DOCUMENT_radYALGridControl']/..//*[text()='" + docName+ "']/..//input[@title='Edit'])[3]");
				util.click(edit);
				util.waitFor(500);
				By doc = By.xpath("//input[contains(@id,'_EditFormControl_ddlDocDraftFinal_radYALDropDownList_Input') and @value='"+ map.get("DraftFinal") + "']");
				Assert.assertTrue(util.isElementVisible(doc));
				util.click(Cancelbtn);
				util.dummyWait(1);
				ExtentTestManager.infoWithScreenshot("Added documents");
				log("STEP 44 : User can see Third added documents under the documents tab with DraftFinal Value", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 44: User cannot see Third added documents under the documents tab with DraftFinal Value", Status.FAIL);
			}
			
			try {
				closeApprovalForm();
				log("STEP 45: user can close the popup", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 45: user can not close the popup", Status.FAIL);
				throw new RuntimeException("Failed in step 45");
			}
	
	}

	public void verifyDraftFinalDD(Map<String, String> map, String testcaseName)
			throws InterruptedException {
		
		try {
			navigateParcelInformation();
			log("STEP 6:  user can navigate to Parcel Information Page", Status.PASS);
		} catch (Exception e) {
			log("STEP 6:  user cannot navigate to Parcel Information Page", Status.FAIL);
			throw new RuntimeException("Failed in step 6");
		}
		
		try {
			ClickOnWFConfigurationIcon();
			log("STEP 7: User can click on WF Configuration Icon", Status.PASS);
		} catch (Exception e) {
			log("STEP 7: user can not click on WF Configuration Icon", Status.FAIL);
			throw new RuntimeException("Failed in step 7");
		}

		try {
			selectApprovalType(map.get(Excel.ApprovalType));
			log("STEP 8: user can select Approval Type", Status.PASS);
		} catch (Exception e) {
			log("STEP 8: user can not select the Approval Type", Status.FAIL);
			throw new RuntimeException("Failed in step 8");
		}
		
		try {
			util.click(customFieldIcon);
			util.switchToChildWindow();
			log("STEP 9: user can click on Manage Custom Field Icon", Status.PASS);
		} catch (Exception e) {
			log("STEP 9: user cannot click on Manage Custom Field Icon", Status.FAIL);
			throw new RuntimeException("Failed in step 9");
		}
		
		try {
	    	try {
	    		ClickOnAddNewRecordLink();
				log("STEP 10: user can able to click on the add new record (+)", Status.PASS);
			} catch (Exception e) {
				log("STEP 10: user can not able to click on the add new record (+) ", Status.FAIL);
				throw new RuntimeException("Failed in step 10");
			}
			
	    	try {
				SelectFieldType(map.get("FieldType"));
				log("STEP 11: user can able to select the value 'DOCUMENTUPLOAD' from field type dd ", Status.PASS);
			} catch (Exception e) {
				log("STEP 11: user can not able to select the value 'DOCUMENTUPLOAD'  from field type dd ", Status.FAIL);
				throw new RuntimeException("Failed in step 11");
			}
			
			try {
				Assert.assertFalse(util.isElementVisible(drpDraft_Final));
				log("STEP 12: user cannot see Draft/Final DD if key setting DOCDRAFTFINAL= False for 'DOCUMENTUPLOAD' field type", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 12: user can see Draft/Final DD even though the key setting DOCDRAFTFINAL= False for 'DOCUMENTUPLOAD' field type", Status.FAIL);
			}
			
	    	try {
				SelectFieldType(map.get("FieldType2"));
				log("STEP 13: user can able to select the value 'MULTIDOCUPLOAD' from field type dd ", Status.PASS);
			} catch (Exception e) {
				log("STEP 13: user can not able to select the value 'MULTIDOCUPLOAD'  from field type dd ", Status.FAIL);
				throw new RuntimeException("Failed in step 13");
			}
			
			
	    	try {
				Assert.assertFalse(util.isElementVisible(drpDraft_Final));
				log("STEP 14: user cannot see Draft/Final DD if key setting DOCDRAFTFINAL= False for 'MULTIDOCUPLOAD' field type", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 14: user can see Draft/Final DD even though the key setting DOCDRAFTFINAL= False for 'MULTIDOCUPLOAD' field type", Status.FAIL);
			}
			
			try {
				ClickOnCancel();
				log("STEP 15: user can able to click on cancel button ", Status.PASS);
			} catch (Exception e) {
				log("STEP 15: user cannot able to click on cancel button  ", Status.FAIL);
				throw new RuntimeException("Failed in step 15");
			}
		}catch(Exception e){
			
		}finally {
			ExtentTestManager.infoWithScreenshot("Custom Field Page");
			driver.close();
			util.switchToParentWindow();
		}
			try {
			util.switchToIframe(FullFrm);
			log("STEP 16: user can switch back to main page ", Status.PASS);
		} catch (Exception e) {
			log("STEP 16: user cannot switch back to main page ", Status.FAIL);
			throw new RuntimeException("Failed in step 16");
		}
		
		try {
			closeApprovalForm();
			log("STEP 17: user can close the popup", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 17: user can not close the popup", Status.FAIL);
			throw new RuntimeException("Failed in step 17");
		}
	}
	
	By drpUser= By.xpath("//input[contains(@id,'_YALHD_mockUserID_radYALDropDownList_Input')]");
	public void SelectUser(String value) {
		if (!commonFunction.checkNA(value)) {
				util.selectValueFromDropdown(drpUser, value);
				
			util.pressENTERkey();
			}
	  }
	
	public void bulkAssignCustomFieldPermission(Map<String, String> map, String testcaseName)
			throws InterruptedException {
		try {
			ClickOnWFConfigurationIcon();
			log("STEP 1: User can click on WF Configuration Icon", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: user can not click on WF Configuration Icon", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}

		try {
			selectApprovalType(map.get(Excel.ApprovalType));
			log("STEP 2: user can select Approval Type", Status.PASS);
		} catch (Exception e) {
			log("STEP 2: user can not select the Approval Type", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}
		
		try {
			util.click(customFieldIcon);
			util.switchToChildWindow();
			log("STEP 3: user can click on Manage Custom Field Icon", Status.PASS);
		} catch (Exception e) {
			log("STEP 3: user cannot click on Manage Custom Field Icon", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}
		
		try {
			ClickonConfigureFieldPermissions();
			SwitchToIframePermission();
			log("STEP 4: user can click on configure Field Permissions Link", Status.PASS);
		} catch (Exception e) {
			log("STEP 4: user cannot click on configure Field Permissions Link", Status.FAIL);
			throw new RuntimeException("Failed in step 4");
		}
		
		try {
			ClickonBulkEditMode();
			log("STEP 5: user can click on Bulk Edit Mode Button", Status.PASS);
		} catch (Exception e) {
			log("STEP 5: user cannot click on Bulk Edit Mode Button", Status.FAIL);
			throw new RuntimeException("Failed in step 5");
		}
		
		try {
			util.click(permissionSingleDoc);
			util.click(permissionSingleDoc);
			log("STEP 6: user can expand Permission dd for Single Select Doc Custom Field", Status.PASS);
		} catch (Exception e) {
			ExtentTestManager.infoWithScreenshot("Unable to update permission");
			util.switchToDefaultContent();
			util.click(btnClosePermission);
			driver.close();
			util.switchToParentWindow();
			util.click(btnCloseForm);
			util.waitFor(500);
			log("STEP 6: user cannot expand Permission dd for Single Select Doc Custom Field", Status.FAIL);
			throw new RuntimeException("Failed in step 6");
		}
		
		try {
			Assert.assertTrue(util.isElementVisible(valueNoAccess));
			log("STEP 7: user can see No ACCESS value in the permission dd", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 7: user cannot see No ACCESS value in the permission dd", Status.FAIL);
		}
		
		try {
			Assert.assertTrue(util.isElementVisible(valueRead));
			log("STEP 8: user can see READ value in the permission dd", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 8: user cannot see READ value in the permission dd", Status.FAIL);
		}
		
		try {
			Assert.assertTrue(util.isElementVisible(valueWrite));
			log("STEP 9: user can see WRITE value in the permission dd", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 9: user cannot see WRITE value in the permission dd", Status.FAIL);
		}
		
		try {
			util.click(valueWrite);
			log("STEP 10: user can select Write Access to Single Select Doc Custom Field", Status.PASS);
		} catch (Exception e) {
			log("STEP 10: user cannot select Write Access to Single Select Doc Custom Field", Status.FAIL);
			throw new RuntimeException("Failed in step 10");
		}
		
		try {
			util.click(permissionMultiDoc);
			util.click(permissionMultiDoc);
			log("STEP 11: user can expand Permission dd for Multi Select Doc Custom Field", Status.PASS);
		} catch (Exception e) {
			log("STEP 11: user cannot expand Permission dd for Multi Select Doc Custom Field", Status.FAIL);
			throw new RuntimeException("Failed in step 11");
		}
		
		try {
			util.click(valueNoAccess);
			log("STEP 12: user can select NO Access to Multi Select Doc Custom Field", Status.PASS);
		} catch (Exception e) {
			log("STEP 12: user cannot select NO Access to Multi Select Doc Custom Field", Status.FAIL);
			throw new RuntimeException("Failed in step 12");
		}
		
		try {
			ClickonSaveChanges();
			util.waitFor(500);
			ExtentTestManager.infoWithScreenshot("Bulk Assign Custom Field Permission");
			log("STEP 13: user can click on Save Changes button", Status.PASS);
		} catch (Exception e) {
			log("STEP 13: user cannot click on Save Changes button", Status.FAIL);
			throw new RuntimeException("Failed in step 13");
		}
		
		try {
			util.switchToDefaultContent();
			util.click(btnClosePermission);
			driver.close();
			util.switchToParentWindow();
			util.click(btnCloseForm);
			util.waitFor(500);
			log("STEP 14: user can close permissions popup and window", Status.PASS);
		} catch (Exception e) {
			log("STEP 14: user cannot close permissions popup and window", Status.FAIL);
			throw new RuntimeException("Failed in step 14");
		}
		
		try {
        	SelectUser(map.get(Excel.User));
        	util.dummyWait(2);
			log("STEP 15:  user can switch to Business Admin User", Status.PASS);
		} catch (Exception e) {
			log("STEP 15:  user cannot switch to Business Admin User ", Status.FAIL);
			throw new RuntimeException("Failed in step 15");
		} 
		
		try {
			navigateParcelInformation();
			log("STEP 16:  user can navigate to Parcel Information Page", Status.PASS);
		} catch (Exception e) {
			log("STEP 16:  user cannot navigate to Parcel Information Page", Status.FAIL);
			throw new RuntimeException("Failed in step 16");
		}
		
		try {
			ClickOnWFConfigurationIcon();
			log("STEP 17: User can click on WF Configuration Icon", Status.PASS);
		} catch (Exception e) {
			log("STEP 17: user can not click on WF Configuration Icon", Status.FAIL);
			throw new RuntimeException("Failed in step 17");
		}

		try {
			selectApprovalType(map.get(Excel.ApprovalType));
			log("STEP 18: user can select Approval Type", Status.PASS);
		} catch (Exception e) {
			log("STEP 18: user can not select the Approval Type", Status.FAIL);
			throw new RuntimeException("Failed in step 18");
		}
		
		try {
			By customSingleDoc = By.xpath("(//*[contains(text(),'"+map.get("FieldName")+"')]/..)[1]");
			Assert.assertTrue(util.isElementVisible(customSingleDoc));
			log("STEP 19: user can see Single Select Doc Custom Field", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 19: user can not see Single Select Doc Custom Field", Status.FAIL);
		}
		
		
		try {
			By customMultiDoc = By.xpath("(//*[contains(text(),'"+map.get("FieldName2")+"')]/..)[1]");
			Assert.assertFalse(util.isElementVisible(customMultiDoc));
			ExtentTestManager.infoWithScreenshot("Validation of set permission");
			log("STEP 20: user cannot see Multi Select Doc Custom Field", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 20: user can see Multi Select Doc Custom Field", Status.FAIL);
		}
		
		util.switchToDefaultContent();
		util.click(btnCloseForm);
		
	}
}
