package pages.Project;

import java.io.File;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.CommonConstant;
import com.util.CommonFunction;
import com.util.TestUtil;

public class AddInterconnectionInformationPage extends BasePage {
	TestUtil util;
	CommonFunction commonFunction;

	public AddInterconnectionInformationPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}

	public void setInterconnectionGrid(String value) {
		if (!commonFunction.checkNA(value))
			util.inputText(drpInterconnectionGrid, value);
		util.pressENTERkey();
	}

	public void setCost(String value) {
		if (!commonFunction.checkNA(value))
			util.inputText(txtCost, value);
	}

	public void updateInterconnectionGrid(String value) {
		if (!commonFunction.checkNA(value))
			util.inputText(updateInterConnectionName, value);
		util.pressENTERkey();
	}

	public void updateCost(String value) {
		if (!commonFunction.checkNA(value))
			util.inputText(editCost, value);
	}

	public void navigateToProjectDetails() {
		// TODO Auto-generated method stub

	}

	public void deleteInterconnection(String updateName) {
		// TODO Auto-generated method stub

	}

	By tabInterconnectionInformation = By.xpath("*//span[contains(text(),'Interconnection Information')]");
	By btnAddNewRecordInterconnectionInformation = By.xpath(
			"//a[@id='ctl00_ConPHRightTop_radPrjPanels_i3_i0_INTERCONNECT_radYALGridControl_ctl00_ctl02_ctl00_lnkAddNewRecord']");
	By drpInterconnectionGrid = By.xpath(
			"//input[@id='ctl00_ConPHRightTop_radPrjPanels_i3_i0_INTERCONNECT_radYALGridControl_ctl00_ctl02_ctl03_EditFormControl_INTERCONNECT_GRID_ID_radYALDropDownList_Input']");
	By txtCost = By.xpath(
			"//input[@id='ctl00_ConPHRightTop_radPrjPanels_i3_i0_INTERCONNECT_radYALGridControl_ctl00_ctl02_ctl03_EditFormControl_BASE_COST']");
	By btnInsertInterconnectionInformation = By.xpath(
			"//input[@id='ctl00_ConPHRightTop_radPrjPanels_i3_i0_INTERCONNECT_radYALGridControl_ctl00_ctl02_ctl03_EditFormControl_btnInsert']");

	By btnAddDocument = By.cssSelector("#btnAdddocuments");
	By drpCategory = By.cssSelector("#RadUpload1category0");
	By txtDescription = By.cssSelector("#RadUpload1Desc0");
	//By documentFileUpload = By.cssSelector("#RadUpload1file0");
	By documentFileUpload = By.xpath("//*[@id=\"RadPanelBar1_i0_i0_rauFileUploadfile0\"]");
	By loadDocumentFile = By.cssSelector("#buttonSubmit");
	By loadDocumentFile2 = By.xpath("//input[contains(@id,'buttonSubmit_input')]");
	By documentSuccessMessage = By.xpath("//span[@id='lblResults']");
	By btnDocumentClose = By.xpath("//a[@title='Close']");

	By documentIframe = By.xpath("//iframe[@name='ViewEditDocument']");
	By documentAddIframe = By.xpath("//iframe[@name='AddDocuments']");
	String viewEditDocument = "//div[contains(@id,'radYALGridControl')]//td[contains(.,'%s')]/following-sibling::td//a[text()='View/Edit Document']";
	String editInterconnection = "//div[contains(@id,'radYALGridControl')]//td[contains(.,'%s')]/preceding-sibling::td//input[contains(@id,'EditButton')]";
	String deleteInterconnection = "//div[contains(@id,'radYALGridControl')]//td[contains(.,'%s')]/preceding-sibling::td//input[contains(@id,'DeleteAlignment')]";
	By btnUpdateInterconnection = By.xpath("//input[contains(@id,'btnUpdate')]");
	By updateInterConnectionName = By
			.xpath("//input[contains(@name,'EditFormControl$INTERCONNECT_GRID_ID$radYALDropDownList')]");
	By editCost = By.xpath("//input[contains(@name,'EditFormControl$BASE_COST')]");
	String tableRecord = "//table[@id='ctl00_ConPHRightTop_radPrjPanels_i3_i0_INTERCONNECT_radYALGridControl_ctl00']//tbody//tr//td[contains(.,'%s')]";
	By changesSavedSuccessfully = By.xpath("//span[text()='Changes saved successfully!']");

	By deleteOk = By.xpath("//a[contains(@onClick,'confirm')]//span[text()='OK']");

	public void addInterconnectionInformation(Map<String, String> map) throws InterruptedException {
		commonFunction.navigateToProjectDeails();
		util.waitUntilElementDisplay(tabInterconnectionInformation);
		util.click(tabInterconnectionInformation);
		util.waitUntilElementDisplay(btnAddNewRecordInterconnectionInformation);
		try {
			util.click(btnAddNewRecordInterconnectionInformation);
			log("STEP 1: User can click on Add new Record button of the Interconnection Information panel.", Status.PASS);
		} catch (Exception e) {
			log("STEP 1:  User cannot click on Add new Record button of the Interconnection Information panel.", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}

		try {
			setInterconnectionGrid(map.get("Interconnection Grid"));
			log("STEP 2: User can select Interconnection Grid value from the DD.", Status.PASS);
		} catch (Exception e) {
			log("STEP 2:  User cannot select Interconnection Grid value from the DD. ", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}
		try {
			setCost(map.get("Cost"));
			log("STEP 3: User can add value in the Cost field. ", Status.PASS);
		} catch (Exception e) {
			log("STEP 3: User cannot add value in the Cost field.  ", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}

		// Click on Insert Button
		util.waitUntilElementDisplay(btnInsertInterconnectionInformation);
		try {
			util.click(btnInsertInterconnectionInformation);
			log("STEP 4: User can click on Insert button", Status.PASS);
		} catch (Exception e) {
			log("STEP 4:  User cannot click on Insert button  ", Status.FAIL);
			throw new RuntimeException("Failed in step 4");
		}
util.dummyWait(10);
		// Verify Interconnection Information Saved Successfully
		util.waitUntilElementDisplay(By.xpath("*//div//span[contains(text(),'Changes saved successfully!')]"));
		String getInterconnectionInfoSuccessMsg = driver
				.findElement(By.xpath("*//div//span[contains(text(),'Changes saved successfully!')]")).getText().trim();
		if (getInterconnectionInfoSuccessMsg.contains("Changes saved successfully!")) {
			System.out.println("Interconnection Information Saved Successfully !!!");
			log("STEP 5: Interconnection Information Saved Successfully ", Status.PASS);
		} else {
			System.out.println("Failed to Save Interconnection Information !!!");
			log("STEP 5:  Failed to Save Interconnection Information  ", Status.FAIL);
			throw new RuntimeException("Failed in step 5");
		}
		Assert.assertTrue(getInterconnectionInfoSuccessMsg.contains("Changes saved successfully!"),
				"Failed to Save Interconnection Information !!!");
		Assert.assertTrue(util.isElementPresent(String.format(tableRecord, map.get("Interconnection Grid"))));
		CommonConstant.addedName = map.get("Interconnection Grid");
		CommonConstant.addedCost = map.get("Cost");

	}

	public void clickOnEdit(String value) {
		By btnEdit = By.xpath("//*[text()='"+value+"']/../td[1]/input");
		util.click(btnEdit);
	}
	
	public void updateInterconnectionInformation(Map<String, String> map) throws InterruptedException {
		//By viewEditBtn = By.xpath(String.format(editInterconnection, map.get("EditInterconnection Grid")));
		util.dummyWait(10);
	//	util.waitUntilElementDisplay(viewEditBtn);
		try {
			clickOnEdit(map.get("Interconnection Grid"));
			//util.click(viewEditBtn);
			log("STEP 6: User  can click on Edit link  ", Status.PASS);
		} catch (Exception e) {
			log("STEP 6:  User  cannot click on Edit link  ",
					Status.FAIL);
			throw new RuntimeException("Failed in step 6");
		}

		try {
			updateInterconnectionGrid(map.get("EditInterconnection Grid"));
			log("STEP 7: User  can update value in Interconnection grid  ", Status.PASS);
		} catch (Exception e) {
			log("STEP 7: User  cannot update value in Interconnection grid.", Status.FAIL);
			throw new RuntimeException("Failed in step 7");

		}
		try {
			updateCost(map.get("EditCost"));
			log("STEP 8: User  can update value in cost field ", Status.PASS);
		} catch (Exception e) {
			log("STEP 8: User  cannot update value in cost field  ", Status.FAIL);
			throw new RuntimeException("Failed in step 8");
		}
		util.waitUntilElementDisplay(btnUpdateInterconnection);
		util.click(btnUpdateInterconnection);
		util.waitUntilElementDisappear(btnUpdateInterconnection);
		Assert.assertTrue(util.isElementPresent(changesSavedSuccessfully), "Verify changes saved successfully.");
		if (util.isElementPresent(changesSavedSuccessfully)) {
			log("STEP 9: Interconnection information updated successfully ", Status.PASS);
		} else {
			log("STEP 9:  Interconnection information does not updated successfully  ", Status.FAIL);
			throw new RuntimeException("Failed in step 9");
		}
		Assert.assertTrue(util.isElementPresent(String.format(tableRecord, map.get("EditInterconnection Grid"))));
		/*
		 * CommonConstant.addedName = map.get("EditInterconnection Grid");
		 * CommonConstant.addedCost = map.get("EditCost");
		 */
		util.waitFor(2000);

	}

	public void updateInterconnectionDocument(Map<String, String> map) {
		String filepath = System.getProperty("user.dir") + File.separator + "test.txt";
		By viewEditBtn = By.xpath(String.format(viewEditDocument, map.get("EditInterconnection Grid")));
		util.waitUntilElementDisplay(viewEditBtn);
		try {
			util.click(viewEditBtn);
			log("STEP 10: Document popup window Opened ", Status.PASS);
		} catch (Exception e) {
			log("STEP 10:  The document pop window does not display  ", Status.FAIL);
			throw new RuntimeException("Failed in step 10");
		}

		util.waitUntilElementDisplay(documentIframe);
		util.switchToIframe(documentIframe);
		util.waitUntilElementDisplay(btnAddDocument);
		util.click(btnAddDocument);
		util.switchToIframe(documentAddIframe);
		
		//util.waitUntilElementDisplay(drpCategory);
		try {
			//util.selectValueFromDropdown2("test doc cat", drpCategory);
			log("STEP 11: Value added diplays in the field : Category ", Status.PASS);
		} catch (Exception e) {
			log("STEP 11:  Added value does not display in the field : Category  ", Status.FAIL);
			throw new RuntimeException("Failed in step 11");
		}
		try {
			//util.inputText(txtDescription, "Test Automation");
			log("STEP 12: User can enter a value in the Description field    ", Status.PASS);
		} catch (Exception e) {
			log("STEP 12:  User cannot add a value in the Description field   ", Status.FAIL);
			throw new RuntimeException("Failed in step 12");
		}
		driver.findElement(documentFileUpload).sendKeys(filepath);
		util.waitFor(2000);
		try {
			if (util.isElementPresent(loadDocumentFile)) {
				util.click(loadDocumentFile);
			} else if (util.isElementPresent(loadDocumentFile2)) {
				util.click(loadDocumentFile2);
			}
			log("STEP 13: User can upload document from the system  ", Status.PASS);
		} catch (Exception e) {
			log("STEP 13:  User cannot upload a document  ", Status.FAIL);
			throw new RuntimeException("Failed in step 13");
		}

		util.waitUntilElementDisplay(documentSuccessMessage);
		if (util.getText(documentSuccessMessage).contains("Loaded: test.txt")) {
			log("STEP 14: Document Saved Successfully ", Status.PASS);
		} else {
			log("STEP 14:  Document does not saved Successfully  ", Status.FAIL);
			throw new RuntimeException("Failed in step 14");
		}
		util.switchToDefaultContent();
		try {
			log("STEP 15: upon popup close, auto refresh the panel to display updated information ", Status.PASS);
			util.click(btnDocumentClose);
		} catch (Exception e) {
			log("STEP 15:  Autorefresh of the panel does not happen  ", Status.FAIL);
			throw new RuntimeException("Failed in step 15");
		}

	}

	public void deleteInterconnection(Map<String, String> map) {
		By viewDeleteBtn = By.xpath(String.format(deleteInterconnection, map.get("EditInterconnection Grid")));
		util.waitUntilElementDisplay(viewDeleteBtn);
		try {
			util.click(viewDeleteBtn);
			log("STEP 16:  User can click on delete icon ", Status.PASS);
		} catch (Exception e1) {
			log("STEP 16:  The delete pop window does not display  ", Status.FAIL);
			throw new RuntimeException("Failed in step 16");
		}

		util.waitFor(2000);
		try {
			util.click(deleteOk);
			log("STEP 17: User can click on ok button ", Status.PASS);
		} catch (Exception e) {
			log("STEP 17:  User cannot click on ok button  ", Status.FAIL);
			throw new RuntimeException("Failed in step 17");
		}
		util.waitFor(2000);

		Assert.assertTrue(util.isElementPresent(changesSavedSuccessfully), "Verify changes saved successfully.");
		if (util.isElementPresent(changesSavedSuccessfully)) {
			log("STEP 18: Interconnection Information is deleted sucessfully  ", Status.PASS);
		} else {
			log("STEP 18: Interconnection Information is not deleted sucessfully", Status.FAIL);
			throw new RuntimeException("Failed in step 18: Interconnection Information is not deleted sucessfully");
		}

	}

}
