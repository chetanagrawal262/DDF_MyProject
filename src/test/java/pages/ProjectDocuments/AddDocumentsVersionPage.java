package pages.ProjectDocuments;

import java.io.File;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

public class AddDocumentsVersionPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;
	public static String AGREEMENT_NUMBER;

	public AddDocumentsVersionPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	
	By navProject = By.xpath("//span[text()='Project']");
	By navProjectInformation = By.xpath("(//span[contains(text(),'Project Information')])[1]");
	By navDocumentManagement = By.xpath("(//span[text()='Document Management'])[1] | (//span[text()='Project Documents'])[1]");
	By DocumentGrid = By.xpath("//tr[contains(@id,'_DOCUMENT_radYALGridControl_ctl00__0')]");
	By btnAddVersion = By.xpath("//span[contains(text(),'Add Version')]");
	By iframeDocument = By.xpath("//iframe[@name='_blank']");
	By btnLoadDocument = By.xpath("//input[contains(@id,'_buttonSubmit_input')]");
	By txtTitleDot = By.xpath("//input[contains(@id,'RadPanelBar1_i0_i0_rauFileUploadTitle')]");
	By drpDraft = By.xpath("//select[contains(@class,'clsDraftFinal')] | //select[@id='DRAFTFINAL']");
	By drpCategory = By.xpath("//select[@class='clsDynamicDropDown'] | //select[contains(@id,'Category')]");
    By txtDescription = By.xpath("//input[contains(@id,'_rauFileUploadDesc')]");
    By txtDescriptionDot = By.xpath("//textarea[contains(@id,'RadPanelBar1_i0_i0_rauFileUploadDesc')]");
	By DocumentName = By.xpath("//span[@id='lblResults']");
	By drpDraftFinalExternalDoc = By.xpath("//select[contains(@id,'_rauFileUploadDraftFinal')]");
	By drpDraftFinalExternalLink = By.xpath("//input[contains(@id,'_ddlDynamicDocDraft1') and @type='text']");
	By txtExecutionDate = By.xpath("//input[contains(@id,'_dpExecDate1')]");
	By txtEffectiveDateExtDoc = By.xpath("//input[contains(@id,'_rauFileUploaddpEffecDate1')]");
	By txtEffectiveDateExtLink = By.xpath("//input[contains(@id,'_dpEffecDate1')]");
	
	 public void NavigateToDocumentManagement() {
	        util.waitUntilElementDisplay(navProject);
	        util.click(navProject);
	        util.waitUntilElementDisplay(navProjectInformation);
	        util.click(navProjectInformation);
	        util.waitUntilElementDisplay(navDocumentManagement);
	        util.click(navDocumentManagement);
	 	
	    }
    
	 public void RightClickonDocumentGrid() {
	    	WebElement web = driver.findElement(DocumentGrid);
	    	util.waitUntilElementDisplay(DocumentGrid);
	    	Actions act = new Actions(driver);
	    	act.moveToElement(web).contextClick().build().perform();
	}
    
    public void ClickonAddVersion() {
    	util.waitUntilElementDisplay(btnAddVersion);
    	util.click(btnAddVersion);
    	util.dummyWait(2);
    }
    

    By fileUpload = By.xpath("//input[contains(@id,'FileUploadfile')]");
		public void uploadFile() {
			String filepath = System.getProperty("user.dir") + File.separator + "test.txt";
			driver.findElement(fileUpload).sendKeys(filepath);
	}
    
		public void AddTitleDot(String value) {
			if (!commonFunction.checkNA(value))
  				util.inputTextAndPressTab(txtTitleDot, value);
		}
		
		public void AddDraft(String value) {
			if (!commonFunction.checkNA(value))
  				util.inputTextAndPressTab(drpDraft, value);
		}
		
		By drpCategoryROWTree = By.xpath("//div[contains(@id,'rauFileUploadundefined')]");
	    
	    public void selectCategoryTree(String value) {
			if (!commonFunction.checkNA(value)) {
				util.waitForWebElementToBePresent(drpCategoryROWTree);
				util.selectValueFromDropdown3(drpCategoryROWTree, value);			
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
	  	    
	  	  public void AddDescriptionDOT(String value) {
		    	if (!commonFunction.checkNA(value))
					util.inputTextAndPressTab(txtDescriptionDot, value);
				
	   }
	  	  
	  	By ExpandExternalLink = By.xpath("//span[text()='External Link']");
	  	 public void ExpandExternalLink() {
	     	util.waitUntilElementDisplay(ExpandExternalLink);
	     	util.click(ExpandExternalLink);
	     }
	  	 
	  	By btnClose = By.xpath("//a[@class='rwCloseButton']");
		  public void LoadDocument() {
			    util.waitUntilElementDisplay(btnLoadDocument);
	  	    	util.click(btnLoadDocument);
	  	    	util.dummyWait(2);
	  	    	util.waitUntilElementDisplay(DocumentName);
	  	    	Assert.assertTrue(util.isElementPresent(DocumentName));
	  	    	util.dummyWait(1);
	  }		
		  
	  public void AddDocumentsVersion(Map<String, String> map, String testcaseName) {
		  try {
	  			NavigateToDocumentManagement();
	  			util.dummyWait(1);
	  			commonFunction.projectSelection();
				log("STEP 1: User can navigate to the Document Management", Status.PASS);
			} catch (Exception e) {
				log("STEP 1:  User cannot see the option in Menu", Status.FAIL);
				throw new RuntimeException("Failed in step 1 ");
			}

	 	   try {
	 		  RightClickonDocumentGrid();
		 			log("STEP 2: User can see multiple options ", Status.PASS);
		 		 } catch (Exception e) {
		 			log("STEP 2: User cannot see multiple options ", Status.FAIL);
		 			throw new RuntimeException("Failed in step 2");
		 		 }
	 	   
	 	   try {
	 		  ClickonAddVersion();
		 			log("STEP 3: User can click on the Add Version button ", Status.PASS);
		 		 } catch (Exception e) {
		 			log("STEP 3: User cannot able to click on Add Version button   ", Status.FAIL);
		 			throw new RuntimeException("Failed in step 3");
		 		 }
	 	   
	 	   
	 	   
	 	  try {
	 		 util.switchToIframe(iframeDocument);
    		 util.dummyWait(5);
    		 uploadFile();
		 	   log("STEP 4: Document link display in the field ", Status.PASS);
		 	 } catch (Exception e) {
		 	   log("STEP 4: Document link not display in the field  ", Status.FAIL);
		 	   throw new RuntimeException("Failed in step 4");
		 	 }
	 	  
	 	  if(testcaseName.contains("DOT")) {
	 	  
	 	 try {
	 		AddTitleDot(map.get(Excel.TITLE));
	 		log("STEP 5: Added value displays in TITLE field  ", Status.PASS);
 		 } catch (Exception e) {
 			log("STEP 5: No value displays in TITLE Dropdown ", Status.FAIL);
 			throw new RuntimeException("Failed in step 5");
 		 }
	 	 
	 	try {
	 		AddDraft(map.get(Excel.Draft));
	 		log("STEP 6: Added value displays in Draft field  ", Status.PASS);
		 } catch (Exception e) {
			log("STEP 6: No value displays in Draft Dropdown ", Status.FAIL);
			throw new RuntimeException("Failed in step 6");
		 }
	 	
	 	try {
	 		SelectCategory(map.get(Excel.Category));
	 		log("STEP 7: Added value displays in Category field  ", Status.PASS);
		 } catch (Exception e) {
			log("STEP 7: No value displays in Category Dropdown ", Status.FAIL);
			throw new RuntimeException("Failed in step 7");
		 }
	 	
	 	try {
	 		AddDescriptionDOT(map.get(Excel.Description));
 			log("STEP 8: User can enter a value in Description field   ", Status.PASS);
 		 } catch (Exception e) {
 			log("STEP 8:  User cannot add a value in Description field    ", Status.FAIL);
 			throw new RuntimeException("Failed in step 8");
 		 }
	 	
	 	try {
	 		 util.dummyWait(2);
	 		LoadDocument();
		 	  log("STEP 9: Loaded 'Docuent Name.extension' should be display ", Status.PASS);
		 	} catch (Exception e) {
		 	  log("STEP 9: Document not added   ", Status.FAIL);
		 	  throw new RuntimeException("Failed in step 9");
		    }
	 	util.switchToDefaultContent();
    	util.click(btnClose);
    	
	 }  
	 	  else if(testcaseName.contains("ROW") || testcaseName.contains("TRA") || testcaseName.contains("DOM")) {
	 		 try {
	 	 		Assert.assertFalse(util.isElementVisible(drpDraftFinalExternalDoc));
	 	 		log("STEP 5: User cannot see Draft/Final DD if key setting 'DocDraftFinal' is false  ", Status.PASS);
	 		 } catch (AssertionError e) {
	 			log("STEP 5:User can see Draft/Final DD if key setting 'DocDraftFinal' is false ", Status.FAIL);
	 		 } 
	 		 
	 		try {
	 	 		Assert.assertFalse(util.isElementVisible(txtEffectiveDateExtDoc));
	 	 		log("STEP 6: User cannot see Effective Date field if key setting 'DocEffectiveDate' is false  ", Status.PASS);
	 		 } catch (AssertionError e) {
	 			log("STEP 6:User can see Effective Date field if key setting 'DocEffectiveDate' is false ", Status.FAIL);
	 		 } 
	 		
	 		if(util.isElementPresent(drpCategoryROWTree)) {
 	   			try {
 	   				selectCategoryTree(map.get(Excel.Category));
 	   				log("STEP 7: Value added diplays in Category field      ", Status.PASS);
 	   			} catch (Exception e) {
 	   				log("STEP 7:  Added value does not display in Category field    ", Status.FAIL);
 	   				throw new RuntimeException("Failed in step 7");
 	   			}
 	   		}else {
	 		try {
		 		SelectCategory(map.get(Excel.Category));
	 			log("STEP 7: Added value displays in Category field  ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 7: No value displays in Category Dropdown ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 7");
	 		 }
 	   		}
		 	
		 	try {
		 		AddDescription(map.get(Excel.Description));
	 			log("STEP 8: User can enter a value in Description field   ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 8:  User cannot add a value in Description field    ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 8");
	 		 }
		 	  
		 	try {
		 		 util.dummyWait(2);
		 		LoadDocument();
			 	  log("STEP 9: Loaded 'Docuent Name.extension' should be display ", Status.PASS);
			 	} catch (Exception e) {
			 	  log("STEP 9: Document not added   ", Status.FAIL);
			 	  throw new RuntimeException("Failed in step 9");
			    }
		  	 

		 	try {
		 		ExpandExternalLink();
			 	  log("STEP 10: User can expand External Link Panel ", Status.PASS);
			 	} catch (Exception e) {
			 	  log("STEP 10: User cannot expand External Link Panel   ", Status.FAIL);
			 	  throw new RuntimeException("Failed in step 10");
			    }
		 	
		 	try {
				Assert.assertFalse(util.isElementVisible(drpDraftFinalExternalLink));
				log("STEP 11: User cannot see Draft/Final DD if key setting 'DocDraftFinal' is false  ",Status.PASS);
			} catch (AssertionError e) {
				log("STEP 11:User can see Draft/Final DD if key setting 'DocDraftFinal' is false ", Status.FAIL);
			}

			try {
				Assert.assertFalse(util.isElementVisible(txtEffectiveDateExtLink));
				log("STEP 12: User cannot see Effective Date field if key setting 'DocEffectiveDate' is false  ",Status.PASS);
			} catch (AssertionError e) {
				log("STEP 12:User can see Effective Date field if key setting 'DocEffectiveDate' is false ",Status.FAIL);
			}
		    	util.switchToDefaultContent();
		    	util.click(btnClose);
	 	  }
	 	  else {
				try {
					SelectCategory(map.get(Excel.Category));
					log("STEP 5: Added value displays in Category field  ", Status.PASS);
				} catch (Exception e) {
					log("STEP 5: No value displays in Category Dropdown ", Status.FAIL);
					throw new RuntimeException("Failed in step 5");
				}

				try {
					AddDescription(map.get(Excel.Description));
					log("STEP 6: User can enter a value in Description field   ", Status.PASS);
				} catch (Exception e) {
					log("STEP 6:  User cannot add a value in Description field    ", Status.FAIL);
					throw new RuntimeException("Failed in step 6");
				}

				try {
					Assert.assertFalse(util.isElementVisible(drpDraftFinalExternalDoc));
					log("STEP 7: User cannot see Draft/Final DD if key setting 'DocDraftFinal' is false  ",Status.PASS);
				} catch (AssertionError e) {
					log("STEP 7:User can see Draft/Final DD if key setting 'DocDraftFinal' is false ", Status.FAIL);
				}

				try {
					Assert.assertFalse(util.isElementVisible(txtExecutionDate));
					log("STEP 8: User cannot see Effective Date field if key setting 'DocEffectiveDate' is false  ",Status.PASS);
				} catch (AssertionError e) {
					log("STEP 8:User can see Effective Date field if key setting 'DocEffectiveDate' is false ",Status.FAIL);
				}
				
				try {
			 		 util.dummyWait(2);
			 		LoadDocument();
				 	  log("STEP 9: Loaded 'Docuent Name.extension' should be display ", Status.PASS);
				 	} catch (Exception e) {
				 	  log("STEP 9: Document not added   ", Status.FAIL);
				 	  throw new RuntimeException("Failed in step 9");
				    }
			  	 

			 	try {
			 		ExpandExternalLink();
				 	  log("STEP 10: User can expand External Link Panel ", Status.PASS);
				 	} catch (Exception e) {
				 	  log("STEP 10: User cannot expand External Link Panel   ", Status.FAIL);
				 	  throw new RuntimeException("Failed in step 10");
				    }
			 	
			 	try {
					Assert.assertFalse(util.isElementVisible(drpDraftFinalExternalLink));
					log("STEP 11: User cannot see Draft/Final DD if key setting 'DocDraftFinal' is false  ",Status.PASS);
				} catch (AssertionError e) {
					log("STEP 11:User can see Draft/Final DD if key setting 'DocDraftFinal' is false ", Status.FAIL);
				}

				try {
					Assert.assertFalse(util.isElementVisible(txtExecutionDate));
					log("STEP 12: User cannot see Execution Date field if key setting 'DocEffectiveDate' is false  ",Status.PASS);
				} catch (AssertionError e) {
					log("STEP 12:User can see Execution Date field if key setting 'DocEffectiveDate' is false ",Status.FAIL);
				}
			    	util.switchToDefaultContent();
			    	util.click(btnClose);
			    	
	 	  }
	 	  
	 	 
	  }
}
