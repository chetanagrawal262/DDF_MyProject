package pages.ProjectPayTemplate;

import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

import extentReports.ExtentTestManager;

public class PaymentTermsSummaryPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;
	public static String PAY_TERM;

	public PaymentTermsSummaryPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	
	By navProject = By.xpath("//span[text()='Project']");
	By navProjectPayTemplate = By.xpath("//span[contains(text(),'Project Pay Templates')] | //span[contains(text(),'Payment Terms Manager')]");
	 
	//for ROW
	By navAdministration = By.xpath("//span[text()='Administration']");
	By navPaymentTemplates = By.xpath("//span[contains(text(),'Payment Templates')]");
	By navProjectPayTemplates = By.xpath("//span[contains(text(),'Project Pay Templates')]"); 
	
	By txtDisplayName = By.xpath("//input[contains(@id,'_CTRINFO_RadDock1_C_Display_Name') and @type='text']");
	By linkDisplayName = By.xpath("//a[contains(text(),'Display Name:')]");
	By iframeDisplay = By.xpath("//iframe[@name='LeasePayTags']");
	By DisplayName = By.xpath("//input[contains(@id,'txtValueDisplayName') and @type='text']");
	By ValidFrom = By.xpath("//input[contains(@id,'txtValueValidFrom') and @type='text']");
	By btnSave = By.xpath("//input[contains(@id,'btnSaveNewValue') and @type='image']");
	By tableDisplayName = By.xpath("//tr[@id='DISPLAYNAMEVALUES_radYALGridControl_ctl00__0']");
	By btnDelete = By.xpath("//input[contains(@id,'DISPLAYNAMEVALUES_radYALGridControl_ctl00_ctl04_gbcDeleteAlignment') and @type='image']");
	By SuccessMessage = By.xpath("//span[text()='Changes saved successfully!']");
	By btnClose = By.xpath("//a[@title='Close']");
	By drpPaymentType = By.xpath("//input[contains(@id,'_Payment_type_ID_radYALDropDownList_Input') and @type='text']");
	By drpDistribution = By.xpath("//input[contains(@id,'_DISTRIBUTION_TYPE_ID_radYALDropDownList_Input') and @type='text']");
	By txtDescription = By.xpath("//textarea[contains(@id,'_Description')]");
	By updatedMessage = By.xpath("//span[contains(@id,'_lblLastUpdatedMsg')]");
	By btnDuplicate = By.xpath("//input[contains(@id,'_Duplicate')]"); 
	By btnDuplicateRow = By.xpath("//img[contains(@alt,'Duplicate')]");
	By iframeDuplicate = By.xpath("//iframe[@name='LeaseCopy']");
	By drpProject = By.xpath("//input[@id='ddlProject_Input']");
	By btnsave = By.xpath("//input[contains(@id,'btnLinkLogs')]");
	By message = By.xpath("//span[@id='usrMessageAdd']");
	By btnReload = By.xpath("//a[@title='Reload']");
	By btnPinon =By.xpath("//a[@title='Pin on']");
	By btnRecalculate = By.xpath("//input[contains(@id,'_btnRecal') and @type='submit']");

	
	public void nevigateToProjectPayTemplate() {
		util.waitUntilElementDisplay(navProject);
		util.click(navProject);
		util.waitUntilElementDisplay(navProjectPayTemplate);
		util.click(navProjectPayTemplate);
	}
	
	public void nevigateToProjectPayTemplateRow() {
		util.waitUntilElementDisplay(navAdministration);
		util.click(navAdministration);
		util.waitUntilElementDisplay(navPaymentTemplates);
		util.click(navPaymentTemplates);
		util.waitFor(200);
		util.waitUntilElementDisplay(navProjectPayTemplates);
		util.click(navProjectPayTemplates);
	}
	By btnPlus = By.xpath("//img[contains(@id,'_ctl00_Img2')]");	
	public void ClickOnPlus() {
		util.dummyWait(2);
		util.waitUntilElementDisplay(btnPlus);
		util.click(btnPlus);
	}
	public void AddDisplayName(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtDisplayName, value);
	}
	
	public void ClickOnDisplayNameLink() {
		util.waitUntilElementDisplay(linkDisplayName);
		util.click(linkDisplayName);
	}
	
	public void setDisplayName(String value) {
		util.switchToIframe(iframeDisplay);
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(DisplayName, value);
	}
	
	public void AddValidFrom(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(ValidFrom, value);
	}
	
	public void clickonSaveButton() {
		util.waitUntilElementDisplay(btnSave);
		util.click(btnSave);
	}
	
	public void clickonDeleteButton() {
		util.waitUntilElementDisplay(btnDelete);
		util.click(btnDelete);
	}
	
	public void clickonOkButton() {
	   driver.switchTo().alert().accept();
	}
	
	
	
	public void clickonCancelButton() {
		  util.switchToDefaultContent();
		   util.dummyWait(1);
		   util.click(btnClose);
	}
	
	public void setPaymentType(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpPaymentType, value);
	}
	
	
	By firstPaymentType = By.xpath("(//*[contains(@id,'_Payment_type_ID_radYALDropDownList')]/..//li[not(contains(text(),'Select One'))])[1]");
	
	public void setPaymentType() {
		 util.click(drpPaymentType);
		 util.click(firstPaymentType);
	}
	
	By selectDistributionType = By.xpath("(//*[contains(@id,'DISTRIBUTION_TYPE_ID_radYALDropDownList_')]/..//li)[2]");
	public void setDistribution(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpDistribution, value);
	}
	
	public void setDistribution() {
		util.click(drpDistribution);
		 util.click(selectDistributionType);
	}
	
	public void AddDescription(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtDescription, value);
	}

	By SaveBtn = By.xpath("//input[contains(@id,'CTRINFO_RadDock1_C_btnSave') and @type='image']");
	By SubmitBtn = By.xpath("//input[contains(@id,'btnSubmitPeerReview') and @type='image']");
	public void ClickonSaveButton() {
		util.waitUntilElementDisplay(SaveBtn);
		util.click(SaveBtn);
	}
	
	By ActiveCheckbox = By.xpath("//input[@id='ctl00_ConPHRightTop_CTRINFO_RadDock1_C_Active_Ind']");
	public void ClickOnSaveButtonRow() {
		if(!util.isElementPresent(activeChecked)) {
    		util.click(ActiveCheckbox);
    		util.dummyWait(2);
    	}
		util.waitUntilElementDisplay(SaveBtn);
		util.click(SaveBtn);
	}
	
	public void ClickOnDuplicateButton() {
		util.waitUntilElementDisplay(btnDuplicate);
	    util.click(btnDuplicate);
	    util.switchToIframe(iframeDuplicate);
	}
	
	public void ClickOnDuplicateButtonRow() {
		util.waitUntilElementDisplay(btnDuplicateRow);
	    util.click(btnDuplicateRow);
	    util.switchToIframe(iframeDuplicate);

	}
	
	public void SelectProject(String value) {
		util.waitUntilElementDisplay(drpProject);
		util.selectValueFromDropdown(drpProject, value);
	}
	
	public void ClickonSave() {
		util.dummyWait(2);
		util.waitUntilElementDisplay(btnsave);
		util.click(btnsave);	
		util.dummyWait(2);
	}
	
	
	
	public void ClickonReload() {
		util.switchToDefaultContent();
		util.waitUntilElementDisplay(btnReload);
		util.click(btnReload);	
		util.dummyWait(2);
	}
	
	public void closePopUp() {
		util.switchToDefaultContent();
		util.click(btnClose);
		util.dummyWait(2);
	}
	
	public void ClickonRecalculateButton() {
		util.waitUntilElementDisplay(btnRecalculate);
		util.click(btnRecalculate);
		util.dummyWait(2);
		util.switchToDefaultContent();
		util.waitUntilElementDisplay(btnClose);
		util.click(btnClose);
	}
	
	By getStrProjectName = By.xpath("//span[@class='rddtFakeInput']");		
	By activeChecked = By.xpath("//input[contains(@id,'Active_Ind') and @checked='checked']");
	By activeCheckBox = By.xpath("//input[contains(@id,'Active_Ind')]");
	By lableAgreementCount = By.xpath("//span[contains(@id,'_lblagreementCount')]");
	By zeroAgreements = By.xpath("//span[contains(text(),'Template is applied to 0 agreement(s).')]");
	By iframePayTerm = By.xpath("//iframe[@name='ManagePayTerm']");
	By successmsg = By.xpath("//span[text()='The selected payment term has been deleted.']");
	
	public void ProjectName() {
//		String ProjectName = util.getAttributeValue(getStrProjectName, "value");
//		log("Project Name :" + ProjectName);
//		util.dummyWait(2);
		
	}
	
	
	 public void PaymentTermsSummary(Map<String, String> map,String testCaseName)  {
	    	if(testCaseName.contains("ALT") || testCaseName.contains("ORSTED") || testCaseName.contains("ORION") || testCaseName.contains("ATWELL")) {
			try {
				nevigateToProjectPayTemplate();
				commonFunction.projectSelection();
				log("STEP 1: User can navigate to project pay template page.", Status.PASS);
			} catch (Exception e) {
				log("STEP 1: User cannot navigate to project pay template page. ", Status.FAIL);
				throw new RuntimeException("Failed in step 1");
			}
			
	    }
	    	else {
			try {
				nevigateToProjectPayTemplateRow();
				commonFunction.projectSelection();
				log("STEP 1: User can navigate to project pay template page.", Status.PASS);
			} catch (Exception e) {
				log("STEP 1: User cannot navigate to project pay template page. ", Status.FAIL);
				throw new RuntimeException("Failed in step 1");
			}

	    }
	    	WebElement projectName=driver.findElement(By.xpath("//*[@id=\"ctl00_ConPHLeftTop_PROJLST_ddt_ProjectList\"]"));
		     ExtentTestManager.info("Adding on Existing Project Name: " +projectName.getAttribute("title"));
	    	try {
				ClickOnPlus();
				util.dummyWait(2);
				AddDisplayName(map.get(Excel.DisplayName));
				log("STEP 2: user can enter value in Display Name textbox  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 2: User cannot enter value in Display Name textbox ", Status.FAIL);
				throw new RuntimeException("Failed in step 2");
			}
			
	    		
	    	try {
	    		if(testCaseName.contains("ORSTED")) {
	    			setPaymentType(map.get(Excel.PaymentType));
	    		}else {
	    		setPaymentType();
	    		}
				log("STEP 3: User can select value from Payment Type dd  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 3: User cannot select value from Payment Type dd  ", Status.FAIL);
				throw new RuntimeException("Failed in step 3");
			}
			
	    	if(util.isElementVisible(drpDistribution)) {
	    	try {
	    		setDistribution();
				log("STEP 4: User can select value from Distribution dd  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 4:  User cannot select value from Distribution dd ", Status.FAIL);
				throw new RuntimeException("Failed in step 4");
			}
	    	}
	    	
	    	try {
	    		AddDescription(map.get(Excel.Description));
				log("STEP 5: user can enter value in Description textbox  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 5: User cannot enter value in Description textbox ", Status.FAIL);
				throw new RuntimeException("Failed in step 5");
			}
	    	
	    	
	    	if(testCaseName.contains("ALT")|| testCaseName.contains("ORSTED") || testCaseName.contains("ORION") || testCaseName.contains("ATWELL")) {
	    	try {
	    		ClickonSaveButton();
				log("STEP 6: user can click on save button. ", Status.PASS);
			} catch (Exception e) {
				log("STEP 6: User cannot click on save button. ", Status.FAIL);
				throw new RuntimeException("Failed in step 6");
			}
	   	}
	    	else
	    	{
	    		try {
	    			ClickOnSaveButtonRow();
					log("STEP 6: user can click on save button. ", Status.PASS);
				} catch (Exception e) {
					log("STEP 6: User cannot click on save button. ", Status.FAIL);
					throw new RuntimeException("Failed in step 6");
				}
	    	}
	    	Assert.assertTrue(util.isElementPresent(SuccessMessage), "Changes saved successfully!");
			if (util.isElementPresent(SuccessMessage)) {
				log("STEP 7:'Changes saved successfully!'  message will be displayed & record will be deleted from grid..", Status.PASS);
			} else {
				log("STEP 7:User cannot click on Save button", Status.FAIL);
				throw new RuntimeException("Faild in STEP 7 :User cannot click on Save button");
			}
			
			if (util.isElementPresent(updatedMessage)) {
				log("STEP 8:Last Updated  message will be displayed in black color. ", Status.PASS);
			} else {
				log("STEP 8:User cannot click on Save button", Status.FAIL);
				throw new RuntimeException("Faild in STEP 8 :User cannot click on Save button");
			}
			
	    	  if(testCaseName.contains("ALT")|| testCaseName.contains("ORSTED") || testCaseName.contains("ORION") || testCaseName.contains("ATWELL")) {
		    		
		    		try {
		    			ClickOnDisplayNameLink();
		    			log("STEP 9: user can click on display name link.  ", Status.PASS);
		    		} catch (Exception e) {
		    			log("STEP 9: User cannot click on display name link. ", Status.FAIL);
		    			throw new RuntimeException("Failed in step 9");
		    		}
		    		
		    		try {
		    			setDisplayName(map.get(Excel.DisplayedName));
		    			log("STEP 10: User can enter the value in the text Displayed Name field ", Status.PASS);
		    		} catch (Exception e) {
		    			log("STEP 10: User cannot add value  to the Displayed Name field ", Status.FAIL);
		    			throw new RuntimeException("Failed in step 10");
		    		}
		    		
		    		try {
		    			AddValidFrom(map.get(Excel.ValidFrom));
		    			log("STEP 11: user can enter value in Valid From textbox  ", Status.PASS);
		    		} catch (Exception e) {
		    			log("STEP 11: User cannot enter value in Valid From textbox ", Status.FAIL);
		    			throw new RuntimeException("Failed in step 11");
		    		}
		    		
		    		try {
		    			clickonSaveButton();
		    			log("STEP 12: user can click on save button.", Status.PASS);
		    		} catch (Exception e) {
		    			log("STEP 12: User cannot click on save button. ", Status.FAIL);
		    			throw new RuntimeException("Failed in step 12");
		    		}
		    		util.dummyWait(5);
		    			
		    		if (util.isElementPresent(tableDisplayName)) {
		    			System.out.println("record  displayed in grid. !!!");
		    			log("STEP 13: Once you click on save button record will be displayed in grid.", Status.PASS);
		    		} else {
		    			log("STEP 13: Record not displayed in grid.", Status.FAIL);
		    			throw new RuntimeException("Faild in STEP 13 :Record not displayed in grid. ");
		    		}
		    		
		    		try {
		    			clickonDeleteButton();
		    			log("STEP 14: user can click on cross icon ", Status.PASS);
		    		} catch (Exception e) {
		    			log("STEP 14: user cannot click on cross icon.   ", Status.FAIL);
		    			throw new RuntimeException("Failed in step 14");
		    		}
		    		
		    		try {
		    			clickonOkButton();
		    			log("STEP 15: user can click on ok button ", Status.PASS);
		    		} catch (Exception e) {
		    			log("STEP 15: User cannot click on ok button ", Status.FAIL);
		    			throw new RuntimeException("Failed in step 15");
		    		}
		    		util.dummyWait(2);
		    		Assert.assertTrue(util.isElementPresent(SuccessMessage), "Changes saved successfully!");
		    		if (util.isElementPresent(SuccessMessage)) {
		    			log("STEP 16:'Changes saved successfully!'  message will be displayed & record will be deleted from grid..", Status.PASS);
		    		} else {
		    			log("STEP 16:User cannot click on ok button", Status.FAIL);
		    			throw new RuntimeException("Faild in STEP 16 :User cannot click on ok button");
		    		}
		    		
		    		try {
		    			clickonCancelButton();
		    			log("STEP 17: user can click on cancel button.   ", Status.PASS);
		    		} catch (Exception e) {
		    			log("STEP 17: User cannot click on cancel button.  ", Status.FAIL);
		    			throw new RuntimeException("Failed in step 17");
		    		}
			
			try {
				ClickOnDuplicateButton();
				log("STEP 18:user can click on duplicate button. ", Status.PASS);
			} catch (Exception e) {
				log("STEP 18: User cannot click on duplicate button. ", Status.FAIL);
				throw new RuntimeException("Failed in step 18");
			}
			
			try {
	    		SelectProject(map.get(Excel.Project));
				log("STEP 19: user can click on save Project button. ", Status.PASS);
			} catch (Exception e) {
				log("STEP 19: User cannot click on save Project button. ", Status.FAIL);
				throw new RuntimeException("Failed in step 19");
			}	
			
			try {
	    		ClickonSave();
				log("STEP 20: user can click on save button. ", Status.PASS);
			} catch (Exception e) {
				log("STEP 20: User cannot click on save button. ", Status.FAIL);
				throw new RuntimeException("Failed in step 20");
			}	
	    	
	    	if (util.isElementPresent(message)) {
				log("STEP 21:New agreement payment template has been created. Please close window to see/edit the newly created template message will be displayed.", Status.PASS);
			} else {
				log("STEP 21:User cannot click on Save button", Status.FAIL);
				
			}
			
	    	try {
	    		 closePopUp();
				log("STEP 23: User can close the popup", Status.PASS);
			} catch (Exception e) {
				log("STEP 23: User cannot close the popup ", Status.FAIL);
				throw new RuntimeException("Failed in step 23");
			}
	    	
	    }
	    	else {
	    		if(util.isElementVisible(btnDuplicateRow)) {
	    		try {
	    			ClickOnDuplicateButtonRow();
	    			log("STEP 9: user can click on duplicate button. ", Status.PASS);
	    		} catch (Exception e) {
	    			log("STEP 9: User cannot click on duplicate button. ", Status.FAIL);
	    			throw new RuntimeException("Failed in step 9");
	    		}
	    		
	    		try {
		    		ClickonSave();
					log("STEP 10: user can click on save button. ", Status.PASS);
				} catch (Exception e) {
					log("STEP 10: User cannot click on save button. ", Status.FAIL);
					throw new RuntimeException("Failed in step 10");
				}	
	    	    		
	    		try {
		    		 closePopUp();
					log("STEP 11: User can close the popup", Status.PASS);
				} catch (Exception e) {
					log("STEP 11: User cannot close the popup ", Status.FAIL);
					throw new RuntimeException("Failed in step 11");
				}
	    	}
	    	}
              
	    	 
	    	  
	    	  try {
					AddDisplayName(map.get("EditDisplayName"));
					PAY_TERM=map.get("EditDisplayName");
					log("STEP 24: user can enter value in Display Name textbox  ", Status.PASS);
				} catch (Exception e) {
					log("STEP 24: User cannot enter value in Display Name textbox ", Status.FAIL);
					throw new RuntimeException("Failed in step 24");
				}

	    	  if(testCaseName.contains("ALT")|| testCaseName.contains("ORSTED") || testCaseName.contains("ORION") || testCaseName.contains("ATWELL")) {
	  	    	try {
	  	    		ClickonSaveButton();
	  				log("STEP 25: user can click on save button. ", Status.PASS);
	  			} catch (Exception e) {
	  				log("STEP 25: User cannot click on save button. ", Status.FAIL);
	  				throw new RuntimeException("Failed in step 25");
	  			}
	  	   	}
	  	    	else
	  	    	{
	  	    		try {
	  	    			ClickOnSaveButtonRow();
	  					log("STEP 26: user can click on save button. ", Status.PASS);
	  				} catch (Exception e) {
	  					log("STEP 26: User cannot click on save button. ", Status.FAIL);
	  					throw new RuntimeException("Failed in step 26");
	  				}
	  	    	}
	    }
	
	 
	 public void DeletePaymentTemplate(Map<String, String> map,String testCaseName)  {
		
		 try {
				nevigateToProjectPayTemplate();
				commonFunction.projectSelection();
				log("STEP 1: User can navigate to project pay template page.", Status.PASS);
			} catch (Exception e) {
				log("STEP 1: User cannot navigate to project pay template page. ", Status.FAIL);
				throw new RuntimeException("Failed in step 1");
			}
		 
		 try {
			 By template = By.xpath("(//strong[text()='"+map.get("EditDisplayName")+"'])[1]");
			 util.click(template);
			 util.dummyWait(1);
				log("STEP 2: User can select "+map.get("EditDisplayName")+" Template", Status.PASS);
			} catch (Exception e) {
				log("STEP 2: User cannot select "+map.get("EditDisplayName")+" Template", Status.FAIL);
				throw new RuntimeException("Failed in step 2");
			}
		 
		 if(util.isElementVisible(zeroAgreements)) {
		 try {
			 By deletTemplate = By.xpath("(//strong[text()='"+map.get("EditDisplayName")+"']/..//a[text()='Delete'])[1]");
			Assert.assertTrue(util.isElementVisible(deletTemplate));
				log("STEP 3: User can see delete link for the Payment Template where zero agreement are linked ", Status.PASS);
			} catch (Exception e) {
				log("STEP 3: User cannot see delete link for the Payment Template where zero agreement are linked ", Status.FAIL);
				throw new RuntimeException("Failed in step 3");
			}
		 }else {
			 try {
				 By deletTemplate = By.xpath("(//strong[text()='"+map.get("EditDisplayName")+"']/..//a[text()='Delete'])[1]");
				Assert.assertFalse(util.isElementVisible(deletTemplate));
					log("STEP 3: User cannot see delete link for the Payment Template when agreement are linked to template", Status.PASS);
				} catch (Exception e) {
					log("STEP 3: User cannot see delete link for the Payment Template when agreement are linked to template ", Status.FAIL);
					throw new RuntimeException("Failed in step 3");
				}
		 }
		 
		 try {
			 By template = By.xpath("(//strong[text()='"+map.get("DisplayName")+"'])[1]");
			 util.click(template);
			 util.dummyWait(1);
				log("STEP 4: User can select "+map.get("DisplayName")+" Template", Status.PASS);
			} catch (Exception e) {
				log("STEP 4: User cannot select "+map.get("DisplayName")+" Template", Status.FAIL);
				throw new RuntimeException("Failed in step 4");
			}
		 
		 try {
			 By deleteTemplate = By.xpath("(//strong[text()='"+map.get("DisplayName")+"']/..//a[text()='Delete'])[1]");
			 util.click(deleteTemplate);
			 util.waitFor(200);
			 try {    
		            Alert alert = driver.switchTo().alert();
		            alert.accept();
		        } catch (NoAlertPresentException e) {
		            System.out.println("No alert present!");
		        }
				log("STEP 5: User can click on Delete link", Status.PASS);
			} catch (Exception e) {
				log("STEP 5: User cannot click on Delete link", Status.FAIL);
				throw new RuntimeException("Failed in step 5");
			}
		 
		 try {
			 util.switchToIframe(iframePayTerm);
			 Assert.assertTrue(util.isElementVisible(successmsg));
				log("STEP 6: User can 'The Selected Payment term has been deleted.' msessage", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 6: User cannot 'The Selected Payment term has been deleted.' msessage", Status.FAIL);
			}
		 
		 util.switchToDefaultContent();
		 util.click(btnClose);
		 
		
	 }
}
