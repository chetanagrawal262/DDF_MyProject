package pages.Title;

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

import extentReports.ExtentTestManager;

public class AddDocumentLinkPage extends BasePage {

	TestUtil util;
	CommonFunction commonFunction;
	public static String DOCUMENT_NAME, DESCRIPTION, UPDATED_DESCRIPTION, UPDATED_DOCUMENT_VERSION;

	public AddDocumentLinkPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	By navDocumentVestingOwnership  = By.xpath("//span[contains(text(),'Document Vesting Ownership')]");
	By LinkAddDocument = By.xpath("//a[contains(text(),'Add Document')]");
	By iframeDocument = By.xpath("//iframe[@name='UserListDialog']");
	By iframeDocVersion = By.xpath("//iframe[@name='_blank']");
	By btnSelectDocumnet = By.xpath("//span[@class='ruButton ruBrowse']");
    By drpCategory = By.xpath("//select[contains(@id,'RadPanelBar1_i0_i0_rauFileUploadcategory')] | //select[@id='RadPanelBar1_i0_i0_rauFileUploadCategory0']") ;
	By txtDescription = By.xpath("//input[contains(@id,'RadPanelBar1_i0_i0_rauFileUploadDesc')]"); 
	By btnLoadDocuments = By.xpath("//input[contains(@id,'buttonSubmit_input') and @type='submit'] | //input[contains(@id,'buttonSubmit_input') and @type='button']");
    By message = By.xpath("//span[@id='lblResults']");
	By btnExternalLink = By.xpath("(//span[@class='rpExpandHandle'])[2]");
	By txtDocumentName = By.xpath("//input[contains(@id,'radReportConfigPanels_i0_i0_txtDynamic1') and @type='text'] | //input[contains(@id,'RadPanelBar2_i0_i0_txtname1')]");
    By txtExternalLink = By.xpath("//input[contains(@id,'radReportConfigPanels_i0_i0_link1') and @type='text'] | //input[contains(@id,'RadPanelBar2_i0_i0_txtlinkname1')]");
    By drpCategoryExelink = By.xpath("//div[@id='radReportConfigPanels_i0_i0_XYZ1_radYALDropDownList']");
    By selectCategoryExelink = By.xpath("//*[@id=\"radReportConfigPanels_i0_i0_XYZ1_radYALDropDownList_DropDown\"]/div/ul/li[1]");
	By txtDescriptionExelink = By.xpath("//input[contains(@id,'description1')]");
    By btnLoadDocumentsExeLink = By.xpath("//input[contains(@id,'radReportConfigPanels_i0_i0_btnSave_input') and @type='submit']");
    By btnAddExeLink = By.xpath("//input[@id='radReportConfigPanels_i0_i0_btnAdd_input']");
    By btnCloseDocuments = By.xpath("//a[@class='rwCloseButton']");
	
	By txtCategoryALT = By.xpath("//input[contains(@id,'_radYALDropDownList_Input')]");
	By txtDescriptionALT = By.xpath("//input[@id='RadPanelBar2_i0_i0_txtDynamic1']");
	By btnLoadDocumentALT = By.xpath("//input[@id='RadPanelBar2_i0_i0_btnSave_input']");
	
	 public void AddDocuments() {
	    	util.waitUntilElementDisplay(LinkAddDocument);
			util.click(LinkAddDocument);
	    }
	    
	    
	    By fileUpload = By.xpath("//input[contains(@id,'FileUploadfile')]");
		public void uploadFile() {
			DOCUMENT_NAME="test.txt";
			String filepath = System.getProperty("user.dir") + File.separator + DOCUMENT_NAME;
			driver.findElement(fileUpload).sendKeys(filepath);
		}
	    
		public void uploadFileVersion() {
			UPDATED_DOCUMENT_VERSION="WorkflowDoc.txt";
			String filepath = System.getProperty("user.dir") + File.separator + UPDATED_DOCUMENT_VERSION;
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
	    
	    public void selectCategory() {
			util.click(drpCategoryExtDoc);
			util.waitFor(100);
			util.pressDownkey();
			util.pressENTERkey();
		}
	    
	    By description = By.xpath("//input[contains(@id,'RadUpload1Desc') or contains(@id,'rauFileUploadDesc')] ");
	    public void setDescription(String value) {
 			if (util.isElementPresent(description)) {
 				util.inputText(description, value);
 			}
 		}
	    
	    public void LoadDocuments() {
	    	util.click(btnLoadDocuments);
			Assert.assertTrue(util.isElementPresent(message));

	    }
	    
	    public void ClickonExternalLink() {
	    	util.waitUntilElementDisplay(btnExternalLink);
	    	util.click(btnExternalLink);
			
	    }
	    
	    public void AddDocumentName(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtDocumentName, value);
			
	    }
	    
	    public void AddExternalLink(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtExternalLink, value);
			
	    }
	    
	    By selectCategory_ExternalLink = By.xpath("//input[contains(@id,'YALDropDownList_Input')]");
	    By firstCategory = By.xpath("//div[contains(@id,'radYALDropDownList_DropDown')]/..//li[1]");

		public void selectCategoryExternalLink(String value) {
			util.waitUntilElementDisplay(selectCategory_ExternalLink);
			util.inputTextAndPressTab(selectCategory_ExternalLink, value);
		}

		public void selectCategoryExternalLink() {
			util.click(selectCategory_ExternalLink);
			util.click(firstCategory);
		}
		
		By selectCategory_ExternalLinkDOT = By.xpath("//div[@id='radReportConfigPanels_i0_i0_XYZ1_RadDropDownTree1'] | //input[contains(@id,'XYZ1_radYALDropDownList_Input')]");

		public void selectCategoryExternalLinkDOT(String value) {
			if (!commonFunction.checkNA(value)) {
			util.waitUntilElementDisplay(selectCategory_ExternalLinkDOT);
			util.selectValueFromDropdown3(selectCategory_ExternalLinkDOT, value);}
		}
		
	    public void AddCategoryForExeLink() {
	    	util.click(drpCategoryExelink);
	    	util.waitUntilElementDisplay(selectCategoryExelink);
	    	util.click(selectCategoryExelink);
			
	    }
	    
	    public void AddCategoryALT(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtCategoryALT, value);
	    }
	    
	    public void AddDescriptionExelink(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtDescriptionExelink, value);
			
	    }
	    
	    public void AddDescriptionALT(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtDescriptionALT, value);
	    }
	    
	    public void ClickOnLoadDocumentsExeLink() {
	    	util.waitUntilElementDisplay(btnLoadDocumentsExeLink);
	    	util.click(btnLoadDocumentsExeLink);
			Assert.assertTrue(util.isElementPresent(message));

			
	    }
	    
	    public void ClickOnLoadDocumentALT() {
	    	util.waitUntilElementDisplay(btnLoadDocumentALT);
	    	util.click(btnLoadDocumentALT);
	    }
	    
	    public void ClickOnAddExeLink() {
	    	util.waitUntilElementDisplay(btnAddExeLink);
	    	util.click(btnAddExeLink);
			
	    }
	    
	    public void ClickOnCloseDocument() {
	    	util.switchToDefaultContent();
	    	util.dummyWait(2);
	    	util.waitUntilElementDisplay(btnCloseDocuments);
	    	util.click(btnCloseDocuments);
	        util.dummyWait(2);

	    }
	    
	    
	    public void AddDocumentLink(Map<String, String> map, String testcaseName) {
	    	
	    	
	    try {
   		 AddDocuments();
   		 util.dummyWait(5);
			log("STEP 1: Document popup window should display with external documents tab     ", Status.PASS);
		 } catch (Exception e) {
			log("STEP 1:  The document pop window does not display    ", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		 }
   	 
   	 try {
   		util.switchToIframe(iframeDocument);
   		 util.dummyWait(5);
   		 uploadFile();
			log("STEP 2: User can upload document from the system     ", Status.PASS);
		 } catch (Exception e) {
			 ExtentTestManager.infoWithScreenshot("Document does not upload");
			 ClickOnCloseDocument();
			log("STEP 2:  User cannot upload document from the system   ", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		 }

   	
   	if(util.isElementPresent(drpCategoryROWTree)) {
 			try {
 				selectCategoryTree(map.get(Excel.Category));
 				log("STEP 3:  User can select Category", Status.PASS);
 			} catch (Exception e) {
 				log("STEP 3:  User can not select Category", Status.FAIL);
 				throw new RuntimeException("STEP 3:  User can not select Category");
 			}
 		}else {
 		try {
 			//selectCategoryROW(map.get(Excel.Category));
 			selectCategory();
 			log("STEP 3:  User can select Category", Status.PASS);
 		} catch (Exception e) {
 			log("STEP 3:  User can not select Category", Status.FAIL);
 			throw new RuntimeException("STEP 3:  User can not select Category");
 		}
 		}
	    	 
  		try {
 			setDescription(map.get(Excel.Description));
 			DESCRIPTION= map.get(Excel.Description);
 			log("STEP 4: Fill in Description", Status.PASS);
 		} catch (Exception e) {
 			log("STEP 4: User cannot Fill in Description", Status.FAIL);
 			throw new RuntimeException("Failed in step 4");
 		}

   	 try {
   		 LoadDocuments();
			log("STEP 5: document is loaded     ", Status.PASS);
		 } catch (Exception e) {
			log("STEP 5:   docuemnt could not be uploaded.   ", Status.FAIL);
			throw new RuntimeException("Failed in step 5");
		 }
   	 
   	 if(!testcaseName.contains("ROW") & !testcaseName.contains("TRA")) {
   	 try {
   		 if(!util.isElementVisible(txtDocumentName)) {
   		 ClickonExternalLink();
   		 }
			log("STEP 6: panel is expanded & fields are visible.     ", Status.PASS);
		 } catch (Exception e) {
			log("STEP 6:  Panel is not expanded    ", Status.FAIL);
			throw new RuntimeException("Failed in step 6");
		 }
   	 
   	 try {
   		 AddDocumentName(map.get(Excel.DocumentName1));
			log("STEP 7: User can enter a value in Document Name field   ", Status.PASS);
		 } catch (Exception e) {
			log("STEP 7:  User cannot add a value in Document Name  field    ", Status.FAIL);
			throw new RuntimeException("Failed in step 7");
		 }
   	 
   	 
   	 try {
   		 AddExternalLink(map.get(Excel.ExternalLink1));
			log("STEP 8: User can enter a value in External Link field   ", Status.PASS);
		 } catch (Exception e) {
			log("STEP 8:  User cannot add a value in External Link field    ", Status.FAIL);
			throw new RuntimeException("Failed in step 8");
		 }
   	 
   	 if(testcaseName.contains("ROW") || testcaseName.contains("TRA")) {
   	 try {
   		 util.dummyWait(5);
   		 if (util.isElementPresent(selectCategory_ExternalLink)) {
				//selectCategoryExternalLink(map.get(Excel.Category));
   			selectCategoryExternalLink();
			} else {
				selectCategoryExternalLinkDOT(map.get(Excel.Category));}
			log("STEP 9: User can enter a value in the field   ", Status.PASS);
		 } catch (Exception e) {
			log("STEP 9:  User cannot add a value in the field    ", Status.FAIL);
			throw new RuntimeException("Failed in step 9");
		 }
   	 
   	 try {
   		 AddDescriptionExelink(map.get(Excel.DescriptionExelink));
			log("STEP 10: User can enter a value in Description field   ", Status.PASS);
		 } catch (Exception e) {
			log("STEP 10:  User cannot add a value in Description field    ", Status.FAIL);
			throw new RuntimeException("Failed in step 10");
		 }
   	 
   	 try {
   		 ClickOnLoadDocumentsExeLink();
			log("STEP 11:document is loaded     ", Status.PASS);
		 } catch (Exception e) {
			log("STEP 11:  document could not be uploaded   ", Status.FAIL);
			throw new RuntimeException("Failed in step 11");
		 }
   	 
   	try {
   	 ClickOnAddExeLink();
			log("STEP 12:  User can click on add button.      ", Status.PASS);
		 } catch (Exception e) {
			log("STEP 12:  User cannot click on add button.    ", Status.FAIL);
			throw new RuntimeException("Failed in step 12");
		 }
   	
   	 }else {
   		 try {
    		 AddCategoryALT(map.get(Excel.Category));
 			log("STEP 9: Added value displays in Category field  ", Status.PASS);
 		 } catch (Exception e) {
 			log("STEP 9: User  cannot select  value  from Category DD ", Status.FAIL);
 			throw new RuntimeException("Failed in step 9");
 		 }
			
    	 try {
    		 AddDescriptionALT(map.get(Excel.Description));
 			log("STEP 10:  User can enter a value in Description field  ", Status.PASS);
 		 } catch (Exception e) {
 			log("STEP 10: User cannot add a value in Description field   ", Status.FAIL);
 			throw new RuntimeException("Failed in step 10");
 		 }
    	 
    	 try {
    		 ClickOnLoadDocumentALT();
 			log("STEP 11: document is loaded AND message-' Loaded- documentname'  displays", Status.PASS);
 		 } catch (Exception e) {
 			log("STEP 11:   docuemnt could not be uploaded. AND message-' Loaded- documentname' does not display  ", Status.FAIL);
 			throw new RuntimeException("Failed in step 11");
 		 }
   	 }
   	 
   	 }
   	 
   	 try {
   		 ClickOnCloseDocument();
			log("STEP 13: POpup should get closed   ", Status.PASS);
		 } catch (Exception e) {
			log("STEP 13:  popup does not get closed    ", Status.FAIL);
			throw new RuntimeException("Failed in step 13");
		 }

    }
	  
	By navigateToDocumentsTab = By.xpath("//div[@id='ctl00_ConPHRightTop_RadTabStrip1']/..//span[text()='Documents']");

	public void NavigateToDocumentsTab() {
		util.waitUntilElementDisplay(navigateToDocumentsTab);
		util.click(navigateToDocumentsTab);

	}

	By navigateToTitleTab = By.xpath("//div[@id='ctl00_ConPHRightTop_RadTabStrip1']/..//span[text()='Title']");
	public void NavigateToTitleTab() {
		util.waitUntilElementDisplay(navigateToTitleTab);
		util.click(navigateToTitleTab);
	}
	
	
	By btnAddVersion = By.xpath("//span[contains(text(),'Add Version')]");
	By refreshDoc = By.xpath("//a[contains(@id,'DOCUMENT_radYALGridControl_ctl00_ctl02_ctl00_lnkRefresh')]");
	By refreshDocVestingPanel = By.xpath("//a[contains(@id,'VESTING_radYALGridControl_ctl00_ctl02_ctl00_lnkRefresh')]");
	public void RightClickonDocumentGrid(String value) {
		By docRecord = By.xpath("//tr[contains(@id,'_DOCUMENT_radYALGridControl')]//td[text()='"+value+"']/..");
		WebElement web = driver.findElement(docRecord);
		util.waitUntilElementDisplay(docRecord);
		Actions act = new Actions(driver);
		act.moveToElement(web).contextClick().build().perform();
	}

	public void ClickonAddVersion() {
		util.waitUntilElementDisplay(btnAddVersion);
		util.click(btnAddVersion);
		util.dummyWait(2);
	}

	 By btnViewHistory = By.xpath("(//span[text()='View History'])[1]");
	public void ClickonViewHistory() {
    	util.waitUntilElementDisplay(btnViewHistory);
    	util.click(btnViewHistory);
    }
	By firstParcel = By.xpath("//*[contains(@id,'TractList_RadGridTracts_ctl00__0')]");
	
	    public void verifyDocumentVersionAndHistory(Map<String, String> map, String testcaseName) {
	    	
			try {
				NavigateToDocumentsTab();
				util.dummyWait(2);
				log("STEP 1: User can navigate to Parcel Documents Tab", Status.PASS);
			} catch (Exception e) {
				log("STEP 1:  User cannot navigate to Parcel Documents Tab", Status.FAIL);
				throw new RuntimeException("Failed in step 1");
			}

			try {
				By titleDoc = By.xpath("//table[contains(@id,'DOCUMENT_radYALGridControl')]//td[text()='" + DESCRIPTION + "']");
				Assert.assertTrue(util.isElementVisible(titleDoc));
				log("STEP 2: User can see Title Documents on the Documents tab", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 2:  User cannot see Title Documents on the Documents tab", Status.FAIL);
			}

				try {
					RightClickonDocumentGrid(DESCRIPTION);
					log("STEP 3: User can right click on the added document", Status.PASS);
				} catch (Exception e) {
					log("STEP 3: User cannot right click on the added document", Status.FAIL);
					throw new RuntimeException("Failed in step 3");
				}

				try {
					ClickonAddVersion();
					log("STEP 4: User can click on the Add Version button ", Status.PASS);
				} catch (Exception e) {
					log("STEP 4: User cannot able to click on Add Version button   ", Status.FAIL);
					throw new RuntimeException("Failed in step 4");
				}

				try {
					util.switchToIframe(iframeDocVersion);
					util.dummyWait(5);
					uploadFileVersion();
					log("STEP 5: User can upload the new version of the document", Status.PASS);
				} catch (Exception e) {
					log("STEP 5: User cannot upload the new version of the document ", Status.FAIL);
					throw new RuntimeException("Failed in step 5");
				}

				if (util.isElementPresent(drpCategoryROWTree)) {
					try {
						selectCategoryTree(map.get(Excel.Category));
						log("STEP 6:  User can select Category", Status.PASS);
					} catch (Exception e) {
						log("STEP 6:  User can not select Category", Status.FAIL);
						throw new RuntimeException("STEP 6");
					}
				} else {
					try {
						selectCategory();
						log("STEP 7:  User can select Category", Status.PASS);
					} catch (Exception e) {
						log("STEP 7:  User can not select Category", Status.FAIL);
						throw new RuntimeException("STEP 7");
					}
				}

				try {
					setDescription(map.get("UpdateDescription"));
					UPDATED_DESCRIPTION = map.get("UpdateDescription");
					log("STEP 8: Fill in Description", Status.PASS);
				} catch (Exception e) {
					log("STEP 8: User cannot Fill in Description", Status.FAIL);
					throw new RuntimeException("Failed in step 8");
				}

				try {
					LoadDocuments();
					log("STEP 9: document is loaded     ", Status.PASS);
				} catch (Exception e) {
					log("STEP 9:   docuemnt could not be uploaded.   ", Status.FAIL);
					throw new RuntimeException("Failed in step 9");
				}

				try {
					ClickOnCloseDocument();
					log("STEP 10: POpup should get closed   ", Status.PASS);
				} catch (Exception e) {
					log("STEP 10:  popup does not get closed    ", Status.FAIL);
					throw new RuntimeException("Failed in step 10");
				}
				
				if(util.isElementVisible(refreshDoc)){
				try {
					util.click(refreshDoc);
					util.waitUntilLoaderDisappear();
					log("STEP 11: User can refresh the document grid", Status.PASS);
				} catch (Exception e) {
					log("STEP 11:  User cannot refresh the document grid", Status.FAIL);
					throw new RuntimeException("Failed in step 11");
				}
				}else {
					util.click(firstParcel);
		    		util.dummyWait(10);
				}
				
				try {
					RightClickonDocumentGrid(UPDATED_DESCRIPTION);
					log("STEP 12: User can see multiple options ", Status.PASS);
				} catch (Exception e) {
					log("STEP 12: User cannot see multiple options ", Status.FAIL);
					throw new RuntimeException("Failed in step 12");
				}

				try {
					ClickonViewHistory();
					log("STEP 13: User can click on the View History button ", Status.PASS);
				} catch (Exception e) {
					log("STEP 13: User cannot able to click on View History button  ", Status.FAIL);
					throw new RuntimeException("Failed in step 13");
				}

				util.scrollDownToPage();
				
				try {
					By priorVersion = By.xpath("//div[contains(@id,'_DOCUMENT_DOCSS_RadDock3_C')]/..//td[text()='Doc Name: "+ DOCUMENT_NAME + "'] | //div[contains(@id,'_DOCUMENT_DOCSS_RadDock3_C')]/..//td[contains(text(),'Doc Name')]/.//*[contains(text(),'"+ DOCUMENT_NAME + "')]");
					Assert.assertTrue(util.isElementVisible(priorVersion));
					log("STEP 14: User can see old version of the Title Document on the document history panel", Status.PASS);
				} catch (AssertionError e) {
					log("STEP 14: User cannot see old version of the Title Document on the document history panel", Status.FAIL);
				}
				
				try {
					By updatedVersion = By.xpath("//div[contains(@id,'_DOCUMENT_DOCSS_RadDock3_C')]/..//td[text()='Doc Name: "+ UPDATED_DOCUMENT_VERSION + "'] | //div[contains(@id,'_DOCUMENT_DOCSS_RadDock3_C')]/..//td[contains(text(),'Doc Name')]/.//*[contains(text(),'"+ UPDATED_DOCUMENT_VERSION + "')]");
					Assert.assertTrue(util.isElementVisible(updatedVersion));
					log("STEP 15: User can see updated version of the Title Document on the document history panel", Status.PASS);
				} catch (AssertionError e) {
					log("STEP 15: User cannot see updated version of the Title Document on the document history panel", Status.FAIL);
				}
				
	    }
	    
	    
	    
	    
	    
	    public void verifyDeletedDoc(String testcaseName) {
	    	ExtentTestManager.infoWithScreenshot("Document tab");
	    	try {
				NavigateToTitleTab();
				util.dummyWait(2);
				log("STEP 6: User can navigate to Title Tab", Status.PASS);
			} catch (Exception e) {
				log("STEP 6:  User cannot navigate to Title Tab", Status.FAIL);
				throw new RuntimeException("Failed in step 6");
			}
	    	
	    	try {
	    		if(!util.isElementVisible(refreshDocVestingPanel)) {
	    			                util.click(navDocumentVestingOwnership);
	    		}
				util.click(refreshDocVestingPanel);
				util.waitUntilLoaderDisappear();
				log("STEP 7: User can refresh the document vesting ownership grid", Status.PASS);
			} catch (Exception e) {
				log("STEP 7:  User cannot refresh the document vesting ownership  grid", Status.FAIL);
				throw new RuntimeException("Failed in step 7");
			}
	    	
	    	try {
				Assert.assertTrue(util.isElementVisible(LinkAddDocument));
				log("STEP 8: Document successfully deleted from document vesting ownership record and Add Document link displayed", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 8: Document not deleted from document vesting ownership record", Status.FAIL);
			}
	    	
	    }
	
}
