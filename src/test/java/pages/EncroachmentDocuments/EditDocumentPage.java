package pages.EncroachmentDocuments;

import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

public class EditDocumentPage extends BasePage {

	TestUtil util;
	CommonFunction commonFunction;

	public EditDocumentPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		
	}
	
	By btnEditRow = By.xpath("//input[@id='ctl00_ConPHRightTop_DOCUMENT_radYALGridControl_ctl00_ctl04_EditButton']");
	By txtDocumentName = By.xpath("//input[contains(@id,'_EditFormControl_txtDocName') and @type='text']");
	By txtDocumentDescription = By.xpath("//input[contains(@id,'_txtDocDesc') and @type='text']");
	By btnUpdate = By.xpath("//input[contains(@id,'_EditFormControl_btnUpdate') and @type='submit']");
	By btnCancel = By.xpath("//input[contains(@id,'_EditFormControl_btnCancel') and @type='submit']");
	
	public void ClickonEdit() {
		util.waitUntilElementDisplay(btnEditRow);
		util.click(btnEditRow);
		util.waitUntilLoaderDisappear();
	}
	
	public void AddDocumentName(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtDocumentName, value);
	  }
	 
	 public void AddDocumentDescription(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtDocumentDescription, value);
	  }
	 
	 public void ClickonUpdateButton() {
			util.waitUntilElementDisplay(btnUpdate);
			util.click(btnUpdate);
			util.waitUntilLoaderDisappear();
	 }
	 
		public void ClickonCancelButton() {
			util.waitUntilElementDisplay(btnCancel);
			util.click(btnCancel);
			util.waitUntilLoaderDisappear();
		}
	 
	 public void EditDocument(Map<String, String> map, String testcaseName) {

		try {
			ClickonEdit();
			log("STEP 1: User can click on the Edit document ", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: User cannot able to click on Edit document Link ", Status.FAIL);
			throw new RuntimeException("Failed in step 1 ");
		}

		try {
			AddDocumentName(map.get(Excel.DocumentName));
			log("STEP 2: User can enter a value in Document Name field ", Status.PASS);
		} catch (Exception e) {
			log("STEP 2: User cannot add a value in Document Name field ", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}

		try {
			AddDocumentDescription(map.get(Excel.Description));
			log("STEP 3: User can enter a value in the Description field  ", Status.PASS);
		} catch (Exception e) {
			log("STEP 3: User cannot add a value in the Description field ", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}

		try {
			ClickonCancelButton();
			log("STEP 4: User can verify the Cancel button", Status.PASS);
		} catch (Exception e) {
			log("STEP 4: User cannot verify the Cancel button ", Status.FAIL);
			throw new RuntimeException("Failed in step 4");
		}

	}
}