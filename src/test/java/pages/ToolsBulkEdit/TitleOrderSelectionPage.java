package pages.ToolsBulkEdit;

import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

import extentReports.ExtentTestManager;

public class TitleOrderSelectionPage extends BasePage {

	TestUtil util;
	CommonFunction commonFunction;
	public static String ParcelNo, ProjectName;

	public TitleOrderSelectionPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}

	By addProjectAssigment = By
			.xpath("//a[normalize-space()='Project Assignments'] | //a[normalize-space()='Project Team']");
	By drpSelectUser = By.xpath("//input[contains(@id,'USERS_YALComboBox_Input')]");
	By drpSelectRole = By.xpath("//input[contains(@id,'PrjRole_radYALDropDownList_Input')]");
	By btnAdd = By.xpath("//input[@alt='Add']");
	By closeUser = By.xpath("//a[contains(@id,'USERS_YALComboBox_Arrow')]");

	public void setUser(String value) {
		if (!commonFunction.checkNA(value)) {
			util.click(drpSelectUser);
			util.inputText(drpSelectUser, value);
			By selectUser = By.xpath("//*[contains(text(),'" + value + "')]//./../input");
			util.click(selectUser);
			util.click(closeUser);
		}
	}

	public void setRole(String value) {
		if (!commonFunction.checkNA(value)) {
			util.selectValueFromDropdown(drpSelectRole, value);
			util.inputText(drpSelectRole, value);
			util.pressENTERkey();
		}
	}

	public void addProjectAssignment(Map<String, String> map, String testCaseName) throws InterruptedException {

		try {
			commonFunction.navigateToProjectDeails();
			util.dummyWait(2);
			commonFunction.projectSelection();
			util.dummyWait(2);
			util.click(addProjectAssigment);
			log("STEP 1: User can navigate to project details and expand Project Assignment panel", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: User cannot  navigate to project details or can not expand project Assignment Panel",
					Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}

		try {
			setUser(map.get(Excel.User));
			log("STEP 2: User can select User Name from the DD", Status.PASS);
		} catch (Exception e) {
			log("STEP 2: User cannot select User Name from the DD ", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}

		try {
			setRole(map.get(Excel.Roles));
			log("STEP 3: User can select Developer Role from the DD", Status.PASS);
		} catch (Exception e) {
			log("STEP 3: User cannot select Developer Role from the DD ", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}

		try {
			util.click(btnAdd);
			util.dummyWait(2);
			log("STEP 4: User can click on Add button", Status.PASS);
		} catch (Exception e) {
			log("STEP 4: User cannot click on Add button ", Status.FAIL);
			throw new RuntimeException("Failed in step 4");
		}
		
		if(testCaseName.contains("ORSTED")) {
			try {
				navigateParcelInformation();
				log("STEP 5: User can navigate to Parcel Information", Status.PASS);
			} catch (Exception e) {
				log("STEP 5: User cannot  navigate to Parcel Information", Status.FAIL);
				throw new RuntimeException("Failed in step 1");
			}

			util.waitUntilElementDisplay(txtParcelNo);
			ParcelNo = util.getAttributeValue(txtParcelNo, "value");
			ProjectName =util.getAttributeValue(projectNameDD, "title").trim();
		}
	}

	By navParcel = By.xpath("//span[text()='Parcel'] | //span[text()='Tract']");
	By navParcelInfo = By.xpath("//span[text()='Parcel Info'] | //span[text()='Tract Info']");
	By navParcelInformation = By.xpath(
			"//span[contains(text(),'Parcel Information')] | //span[contains(text(),'Tract Information')] | //span[contains(text(),'Record Information')]");
	By drpTitleOrderSelection = By.xpath("//*[contains(text(),'Title Order Status')]/..//input[@type='text']");
	By option1 = By.xpath("//li[text()='Do Not Order Title']");
	By option2 = By.xpath("//li[text()='Order Title']");
	By txtParcelNo = By.xpath("//input[contains(@id,'TractType_TRACT_NUMBER') and @type='text']");
	By btnSave = By.xpath("//input[contains(@id,'_TractType_btnInternalSave')]");
	By projectNameDD=By.xpath("//*[@id='ctl00_ConPHLeftTop_PROJLST_ddt_ProjectList']");
	
	public void navigateParcelInformation() {
		util.waitUntilElementDisplay(navParcel);
		util.click(navParcel);
		util.waitUntilElementDisplay(navParcelInfo);
		util.click(navParcelInfo);
		util.waitUntilElementDisplay(navParcelInformation);
		util.click(navParcelInformation);

	}

	public void verifyTitleOrderSelectionDD(String testCaseName) throws InterruptedException {

		try {
			navigateParcelInformation();
			log("STEP 1: User can navigate to Parcel Information", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: User cannot  navigate to Parcel Information", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}

		try {
			util.waitUntilElementDisplay(txtParcelNo);
			ParcelNo = util.getAttributeValue(txtParcelNo, "value");
			ProjectName =util.getAttributeValue(projectNameDD, "title").trim();
			Assert.assertTrue(util.isElementVisible(drpTitleOrderSelection));
			log("STEP 2: User can see Title Order Selection Drop Down", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 2: User cannot  see Title Order Selection Drop Down", Status.FAIL);
		}

		try {
			util.click(drpTitleOrderSelection);
			Assert.assertTrue(util.isElementVisible(option1));
			log("STEP 3: User can see Do Not Order Title Option in the DropDown", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 3: User cannot  see Do Not Order Title Option in the DropDown", Status.FAIL);
		}

		try {
			Assert.assertTrue(util.isElementVisible(option2));
			log("STEP 4: User can see Order Title Option in the DropDown", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 4: User cannot  see Order Title Option in the DropDown", Status.FAIL);
		}

		try {
			util.click(option1);
			log("STEP 5: User can select Do Not Order Title Option from the DD", Status.PASS);
		} catch (Exception e) {
			log("STEP 5: User cannot select Do Not Order Title Option from the DD", Status.FAIL);
		}

		try {
			util.click(btnSave);
			util.dummyWait(2);
			log("STEP 6: User can click on Save button", Status.PASS);
		} catch (Exception e) {
			log("STEP 6: User cannot click on Save button", Status.FAIL);
		}
	}

	By navTools = By.xpath("//span[text()='Tools']");
	By navBulkEdit = By.xpath("//span[contains(text(),'Bulk Edit')]");
	By navTitleOrderSelection = By.xpath("//span[contains(text(),'Title Order Selection')]");
	By navTitleStatusUpdate= By.xpath("//span[contains(text(),'Title Status Update')]");
	By navRequestedDocuments= By.xpath("//span[contains(text(),'Title Status Update')]");
	By btnBulkEdit = By.xpath("//input[contains(@id,'idBulkEdit_btnRemoveGrouping')]");
	By drpArrow = By.xpath("//a[contains(@id,'_TITLE_ORDER_SELECTION_templateColumnDD_Arrow')]");
	By btnSaveChanges = By.xpath("(//a[contains(@id,'_SaveChangesButton')])[1]");
	By txtFilterProjectName = By.xpath("//input[contains(@id,'_FilterTextBox_PROJECT_NAME')]");
	By filterIconProjectName = By.xpath("//input[contains(@id,'Filter_PROJECT_NAME') and @title='Filter']");
	By txtFilterParcelNo = By.xpath("//input[contains(@id,'FilterTextBox_ORION_PID')] | //input[contains(@id,'_FilterTextBox_PARCEL_#')]");
	By filterIconParcelNo = By.xpath("//input[contains(@id,'Filter_ORION_PID') and @title='Filter'] | //input[contains(@id,'Filter_PARCEL_#') and @title='Filter']");
	By selectContains = By.xpath("//span[text()='Contains']");
	By drpTitleOrderSelectionBE = By.xpath("//input[contains(@id,'idBulkEdit_EditGrid_ctl00_TITLE_ORDER_SELECTION_templateColumnDD_Input')]");
	
   By tabRequestedDocument = By.xpath("//span[text()='Requested Documents']");
   By refreshIcon = By.xpath("//img[contains(@id,'_YALCOM_blkQueue_grdDocumentQueue_')]");
	
	public void navigateToRequestedDocumentTab() {
		util.click(tabRequestedDocument);
		util.click(refreshIcon);
		util.dummyWait(2);
	}
	
	public boolean isJobCreated(String status) {
		By jobPath = By.xpath("//table[contains(@id,'Queue_grdDocumentQueue')]//td[text()='"+status+"']");
		return util.isElementPresent(jobPath);
	}
	public void NavigateToTitleOrderSelection() {
		util.waitUntilElementDisplay(navTools);
		util.click(navTools);
		util.waitUntilElementDisplay(navBulkEdit);
		util.click(navBulkEdit);
		if(!util.isElementVisible(navTitleOrderSelection)) {
			util.hoverOnElement(navBulkEdit);
		}
		util.waitUntilElementDisplay(navTitleOrderSelection);
		util.click(navTitleOrderSelection);
	}

	public void NavigateToTitleStatusUpdate() {
		util.waitUntilElementDisplay(navTools);
		util.click(navTools);
		util.waitUntilElementDisplay(navBulkEdit);
		util.click(navBulkEdit);
		if(!util.isElementVisible(navTitleStatusUpdate)) {
			util.hoverOnElement(navBulkEdit);
		}
		util.waitUntilElementDisplay(navTitleStatusUpdate);
		util.click(navTitleStatusUpdate);
	}

	
	public void addProjectName(String value) {
			util.inputText(txtFilterProjectName, value);
	}
	

	public void addParcelNo(String value) {
			util.inputText(txtFilterParcelNo, value);
	}
	
	public void verifyTitleOrderSelectionQV() throws InterruptedException {

		try {
			NavigateToTitleOrderSelection();
			log("STEP 1: User can navigate to Title Order Selection Quick View", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: User cannot  navigate to Title Order Selection Quick View", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}

		try {
			addProjectName(ProjectName);
			util.click(filterIconProjectName);
			util.click(selectContains);
			util.dummyWait(2);
			log("STEP 2: User can filter record using Project Name", Status.PASS);
		} catch (Exception e) {
			log("STEP 2: User cannot  filter record using Project Name", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}
		
		try {
			addParcelNo(ParcelNo);
			util.click(filterIconParcelNo);
			util.click(selectContains);
			util.dummyWait(2);
			log("STEP 3: User can filter record using Parcel No", Status.PASS);
		} catch (Exception e) {
			log("STEP 3: User cannot  filter record using Parcel No", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}
		
		try {
			By parcelNoRecord = By.xpath("//td[contains(text(),'"+ProjectName.trim()+"')]/..//td[text()='"+ParcelNo+"']");
			util.waitUntilElementDisplay(parcelNoRecord);
			Assert.assertTrue(util.isElementVisible(parcelNoRecord));
			log("STEP 4: User can see updated parcel no in Title Order Selection Quick View", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 4: User cannot  see updated parcel no in Title Order Selection Quick View", Status.FAIL);
		}
		
		try {
			util.click(btnBulkEdit);
			util.dummyWait(1);
			log("STEP 5: User can click on Bulk Edit button", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 5: User cannot  click on Bulk Edit button", Status.FAIL);
			throw new RuntimeException("Failed in step 5");
		}
		
		try {
			By updateTitleOrderSelection = By.xpath("//td[contains(text(),'"+ProjectName.trim()+"')]/..//td[text()='"+ParcelNo+"']/..//td[count(//table/thead/tr/th[.='Title Order Selection']/preceding-sibling::th)+1]");
			util.click(updateTitleOrderSelection);
			log("STEP 6: Title Order Selection Value is Editable", Status.PASS);
		} catch (Exception e) {
			log("STEP 6: Title Order Selection Value is not Editable", Status.FAIL);
			throw new RuntimeException("Failed in step 6");
		}
		
		try {
			util.click(drpArrow);
			Assert.assertTrue(util.isElementVisible(option1));
			log("STEP 7: User can see Do Not Order Title option in the dd", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 7: User cannot see Do Not Order Title option in the dd", Status.FAIL);
		}
		
		try {
			Assert.assertTrue(util.isElementVisible(option2));
			log("STEP 8: User can see Order Title option in the dd", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 8: User cannot see Order Title option in the dd", Status.FAIL);
		}
		
		try {
			util.inputTextAndPressTab(drpTitleOrderSelectionBE, "Order Title");
			log("STEP 9: User can select Order Title option from the dd", Status.PASS);
		} catch (Exception e) {
			log("STEP 9: User cannot select Order Title option from the dd", Status.FAIL);
			throw new RuntimeException("Failed in step 9");
		}
		
		try {
			util.waitFor(500);
			util.waitForWebElementToBeClickable(btnSaveChanges);
			util.click(btnSaveChanges);
			util.waitFor(500);
			try {    
	            Alert alert = driver.switchTo().alert();
	            alert.accept();
	        } catch (NoAlertPresentException e) {
	            System.out.println("No alert present!");
	        }
			log("STEP 10: User can click on Save Changes Button", Status.PASS);
		} catch (Exception e) {
			log("STEP 10: User cannot click on Save Changes Button", Status.FAIL);
			throw new RuntimeException("Failed in step 10");
		}
		
		try {
			By parcelNoRecord = By.xpath("//td[contains(text(),'"+ProjectName.trim()+"')]/..//td[text()='"+ParcelNo+"']");
			Assert.assertFalse(util.isElementVisible(parcelNoRecord));
			log("STEP 11: Record sucessfully removed from the Title Order Selection Quick View", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 11: Record does not remove from the Title Order Selection Quick View", Status.FAIL);
			throw new RuntimeException("Failed in step 11");
		}
	}
	
	
	public void verifyTitleStatusUpdateQV() throws InterruptedException {

		try {
			NavigateToTitleStatusUpdate();
			log("STEP 1: User can navigate to Title Status Update Quick View", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: User cannot  navigate to Title Status Update Quick View", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}

		try {
			addProjectName(ProjectName);
			util.click(filterIconProjectName);
			util.click(selectContains);
			util.dummyWait(2);
			log("STEP 2: User can filter record using Project Name", Status.PASS);
		} catch (Exception e) {
			log("STEP 2: User cannot  filter record using Project Name", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}
		
		if(util.isElementVisible(txtFilterParcelNo)) {
		try {
			addParcelNo(ParcelNo);
			util.click(filterIconParcelNo);
			util.click(selectContains);
			util.dummyWait(2);
			log("STEP 3: User can filter record using Parcel No", Status.PASS);
		} catch (Exception e) {
			log("STEP 3: User cannot  filter record using Parcel No", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}
		
		
		try {
			By parcelNoRecord = By.xpath("//td[contains(text(),'"+ProjectName.trim()+"')]/..//td[text()='"+ParcelNo+"']");
			util.waitUntilElementDisplay(parcelNoRecord);
			Assert.assertTrue(util.isElementVisible(parcelNoRecord));
			log("STEP 4: User can see updated parcel no in Title Status Update Quick View", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 4: User cannot  see updated parcel no in Title Status Update Quick View", Status.FAIL);
		}
		
		try {
			By parcelNoRecord = By.xpath("//td[contains(text(),'"+ProjectName.trim()+"')]/..//td[text()='"+ParcelNo+"']/..//*[text()='Order Title']");
			util.waitUntilElementDisplay(parcelNoRecord);
			Assert.assertTrue(util.isElementVisible(parcelNoRecord));
			log("STEP 5: User can see updated Title Order Selection value in Title Status Update Quick View", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 5: User cannot  see updated Title Order Selection value in Title Status Update Quick View", Status.FAIL);
		}
		}
		else {

			try {
				By parcelNoRecord = By.xpath("//td[contains(text(),'"+ProjectName.trim()+"')]");
				util.waitUntilElementDisplay(parcelNoRecord);
				Assert.assertTrue(util.isElementVisible(parcelNoRecord));
				log("STEP 4: User can see updated Project in Title Status Update Quick View", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 4: User cannot  see updated Project in Title Status Update Quick View", Status.FAIL);
			}
			
			try {
				By parcelNoRecord = By.xpath("//td[contains(text(),'"+ProjectName.trim()+"')]/..//*[text()='Order Title']");
				util.waitUntilElementDisplay(parcelNoRecord);
				Assert.assertTrue(util.isElementVisible(parcelNoRecord));
				log("STEP 5: User can see updated Title Order Selection value in Title Status Update Quick View", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 5: User cannot  see updated Title Order Selection value in Title Status Update Quick View", Status.FAIL);
			}
		}
//		try {   //job will not create for every title order update
//			commonFunction.navigateToMyDashboard();
//			navigateToRequestedDocumentTab();
//			log("STEP 6: User can navigate to Requested Documents Tab", Status.PASS);
//		} catch (Exception e) {
//			log("STEP 6: User cannot  navigate to Requested Documents Tab", Status.FAIL);
//			throw new RuntimeException("Failed in step 6");
//		}
//		
//		try {
//			Assert.assertTrue(isJobCreated("Requested"));
//			log("STEP 7: User can see Created Job", Status.PASS);
//		} catch (AssertionError e) {
//			log("STEP 7: Job not created", Status.FAIL);
//			throw new RuntimeException("Failed in step 7");
//		}
		
	}
	
	By navParcelSearch = By.xpath("//span[contains(text(),'Parcel Search')] | //span[contains(text(),'Tract Search')] | //span[contains(text(),'Record Search')]");
	By PlusButton = By.xpath("//img[contains(@id,'btnAddSearch')]");
	By Iframe = By.xpath("//iframe[@name='RadAddNewSearch']");
	By txtSavedSearch = By.xpath("//input[contains(@id,'ItemName') and @type='text']");
	By btnSaveMap = By.xpath("//input[contains(@id,'SaveNewMapping') and @type='image']");
    By btnClose = By.xpath("//a[@title='Close']");
	By drpSavedSearches = By.xpath("//input[contains(@id,'radPreFilter_Input') and @type='text']");
    By drpAddFilter = By.xpath("//input[contains(@id,'cbSearchOptions_Input') and @type='text']");
    By btnAddFilter = By.xpath("//input[contains(@id,'btnAddSearchOption') and @type='submit']");
	By btnSaveSearch = By.xpath("//input[contains(@id,'btnSaveFilter') and @type='button']");
    By dropdown = By.xpath("(//input[contains(@id,'idSearch_RadDock3') and @type='text'])[2]");
	
    public void NavigateToParcelSearch() {
    	util.waitUntilElementDisplay(navTools);
    	util.click(navTools);
    	util.waitUntilElementDisplay(navParcelSearch);
    	util.click(navParcelSearch);	
    }
	
	 public void ClickOnPlusButton() {
			util.waitUntilElementDisplay(PlusButton);
			util.click(PlusButton);
			util.switchToIframe(Iframe);
			util.dummyWait(2);
		}
			
		public void AddSavedSearch(String value) {
			if (!commonFunction.checkNA(value)) 
				util.inputTextAndPressTab(txtSavedSearch, value);
		}
		
		public void ClickOnSaveButton() {
			util.waitUntilElementDisplay(btnSaveMap);
			util.click(btnSaveMap);
			util.dummyWait(1);
			util.switchToDefaultContent();
		}
		
		 public void SelectSavedSearches(String value) {
		    	if (!commonFunction.checkNA(value)) 
					util.inputTextAndPressTab(drpSavedSearches, value);
	    }
		 public void AddFilterValue(String value) {
		    	if (!commonFunction.checkNA(value)) 
					util.inputTextAndPressTab(dropdown, value);
		    }
		    
		   public void ClickOnAddFilterButton(String value) {
		    	if (!commonFunction.checkNA(value)) 
					util.inputTextAndPressTab(drpAddFilter, value);
		    	util.dummyWait(2);
		    	util.waitUntilElementDisplay(btnAddFilter);
		    	util.click(btnAddFilter);
		  }
			By btnSearch = By.xpath("//input[contains(@id,'btnDoSearch') and @type='button']");
			
		   public void ClickOnSearch() {
		    	util.waitUntilElementDisplay(btnSearch);
		    	util.click(btnSearch);
		    	util.dummyWait(2);
		    }
	
		   By expandBulkUpdateOptions = By.xpath("//em[text()='Bulk Update Options']/..//a[@title='Expand']");
		   By checkBoxSearchResult = By.xpath("//input[contains(@id,'RadGrid1_ctl00_ctl04_CheckBox1')]");
		   
		   public void ExpandBulkUpdateOption() {
		    	util.waitUntilElementDisplay(expandBulkUpdateOptions);
		    	util.click(expandBulkUpdateOptions);
		    }
		   
		   By btnUpdate = By.xpath("//input[contains(@id,'idSearch_RadDock1_C_BLK_btnBulkUpdate')]");
		   public void ClickOnUpdateButton() {
		    	util.waitUntilElementDisplay(btnUpdate);
		    	util.click(btnUpdate);
		    }
		   
		   By btnDelete = By.xpath("//input[contains(@id,'DeleteSearch') and @type='image']");
		   public void ClickOnDeleteButton() {
				 util.waitUntilElementDisplay(btnDelete);
				 util.click(btnDelete);
				 util.dummyWait(2);
			 }
		   
	public void parcelSearch_BulkUpdate(Map<String, String> map, String testcaseName) throws InterruptedException {

		try {
			   NavigateToParcelSearch();
				log("STEP 1:  user can navigate to Parcel Search ", Status.PASS);
			} catch (Exception e) {
				log("STEP 1:  user can navigate to Parcel Search", Status.FAIL);
				throw new RuntimeException("Failed in step 1");
			}
	   
	   try {
			ClickOnPlusButton();
			log("STEP 2:  user can able to click the button ", Status.PASS);
		} catch (Exception e) {
			log("STEP 2:  user can able to click the button", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}
	   
		try {
			AddSavedSearch(map.get(Excel.SearchName));
			log("STEP 3:  user can enter the text in  SavedSearch field    ", Status.PASS);
		} catch (Exception e) {
			log("STEP 3: user cannot enter the text in  SavedSearch field ", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}
		
		try {
			ClickOnSaveButton();
			log("STEP 4:  user can click on save button", Status.PASS);
		} catch (Exception e) {
			log("STEP 4:  user not able to click on save button  ", Status.FAIL);
			throw new RuntimeException("Failed in step 4");
		}
		
		
		try {
			SelectSavedSearches(map.get(Excel.SearchName));
			log("STEP 5: user can able to select value from SavedSearches dd", Status.PASS);
		} catch (Exception e) {
			log("STEP 5: user not able to select value from SavedSearches dd  ", Status.FAIL);
			throw new RuntimeException("Failed in step 5");
		}
		
		
		try {
			ClickOnAddFilterButton(map.get(Excel.SelectFilter));
			log("STEP 6:   user can click on Add filter button", Status.PASS);
		} catch (Exception e) {
			log("STEP 6:   user cannot click on Add filter button ", Status.FAIL);
			throw new RuntimeException("Failed in step 6");
		}
		
		
		try {
			AddFilterValue(map.get("ProjectName"));
			log("STEP 7:   user can add Filter value", Status.PASS);
		} catch (Exception e) {
			log("STEP 7:   user cannot add Filter value ", Status.FAIL);
			throw new RuntimeException("Failed in step 7");
		}
		
		
		try {
			ClickOnSearch();
			log("STEP 8: user is able to click on save button ", Status.PASS);
		} catch (Exception e) {
			log("STEP 8: user not able to click on save button  ", Status.FAIL);
			throw new RuntimeException("Failed in step 8");
		}
		
		ExtentTestManager.infoWithScreenshot("Search Result");
		
		try {
			util.click(checkBoxSearchResult);
			log("STEP 9: user can select search result ", Status.PASS);
		} catch (Exception e) {
			log("STEP 9: user cannot select search result  ", Status.FAIL);
			throw new RuntimeException("Failed in step 9");
		}
		
		try {
			ExpandBulkUpdateOption();
			log("STEP 10: user can expand Bulk Update Options Panel ", Status.PASS);
		} catch (Exception e) {
			log("STEP 10: user cannot expand Bulk Update Options Panel", Status.FAIL);
			throw new RuntimeException("Failed in step 10");
		}
		
		try {
			Assert.assertTrue(util.isElementVisible(drpTitleOrderSelection));
			log("STEP 11: User can see Title Order Selection Drop Down", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 11: User cannot  see Title Order Selection Drop Down", Status.FAIL);
		}

		try {
			util.click(drpTitleOrderSelection);
			Assert.assertTrue(util.isElementVisible(option1));
			log("STEP 12: User can see Do Not Order Title Option in the DropDown", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 12: User cannot  see Do Not Order Title Option in the DropDown", Status.FAIL);
		}

		try {
			Assert.assertTrue(util.isElementVisible(option2));
			log("STEP 13: User can see Order Title Option in the DropDown", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 13: User cannot  see Order Title Option in the DropDown", Status.FAIL);
		}

		try {
			util.click(option1);
			log("STEP 14: User can select Do Not Order Title Option from the DD", Status.PASS);
		} catch (Exception e) {
			log("STEP 14: User cannot select Do Not Order Title Option from the DD", Status.FAIL);
		}
		
		try {
			ClickOnUpdateButton();
			util.dummyWait(1);
			log("STEP 15:  user can click on update button ", Status.PASS);
		} catch (Exception e) {
			log("STEP 15:  user cannot click on update button.  ", Status.FAIL);
			throw new RuntimeException("Failed in step 15");
		}
		
		try {
			util.click(drpTitleOrderSelection);
			util.click(option2);
			log("STEP 16: User can select Do Not Order Title Option from the DD", Status.PASS);
		} catch (Exception e) {
			log("STEP 16: User cannot select Do Not Order Title Option from the DD", Status.FAIL);
		}
		
		try {
			ClickOnUpdateButton();
			util.dummyWait(1);
			log("STEP 17:  user can click on update button ", Status.PASS);
		} catch (Exception e) {
			log("STEP 17:  user cannot click on update button.  ", Status.FAIL);
			throw new RuntimeException("Failed in step 17");
		}
		
		try {
			 ClickOnDeleteButton();
				log("STEP 18: user can able to click on delete icon ", Status.PASS);
			} catch (Exception e) {
				log("STEP 18: user can not click on delete icon", Status.FAIL);
				throw new RuntimeException("Failed in step 18");
			}
		
//		try {
//			commonFunction.navigateToMyDashboard();
//			navigateToRequestedDocumentTab();
//			log("STEP 19: User can navigate to Requested Documents Tab", Status.PASS);
//		} catch (Exception e) {
//			log("STEP 19: User cannot  navigate to Requested Documents Tab", Status.FAIL);
//			throw new RuntimeException("Failed in step 19");
//		}
//		
//		try {
//			Assert.assertTrue(isJobCreated("Requested"));
//			log("STEP 20: User can see Created Job", Status.PASS);
//		} catch (AssertionError e) {
//			log("STEP 20: Job not created", Status.FAIL);
//			throw new RuntimeException("Failed in step 20");
//		}
	}
}
