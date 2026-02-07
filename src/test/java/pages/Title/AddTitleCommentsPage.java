package pages.Title;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

public class AddTitleCommentsPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;
	public static String AGREEMENT_NUMBER;

	public AddTitleCommentsPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		
	}
	
	By navTitleComment = By.xpath("(//span[contains(text(),'Title Comments')])[2]");
	By txtComment = By.xpath("//iframe[@id='ctl00_ConPHRightTop_TRTT_UC_radPanels_i10_i0_TitleNotes_contentIframe']");
	By btnSave = By.xpath("//input[@id='ctl00_ConPHRightTop_TRTT_UC_radPanels_i10_i0_saveTitleComments']");
    By changesSavedSuccessfully = By.xpath("//span[text()='Changes saved successfully!']"); 

	public void AddComment(String value) {
		util.waitUntilElementDisplay(navTitleComment);
		util.click(navTitleComment);
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtComment, value);	
	}
	
	public void ClickonSave() {
		util.waitUntilElementDisplay(btnSave);
		util.click(btnSave);
		util.waitUntilElementDisplay(changesSavedSuccessfully);
		Assert.assertTrue(util.isElementPresent(changesSavedSuccessfully), "Changes saved successfully!");
	}
	
	 public void AddTitleComments(Map<String, String> map, String testcaseName) {
		    
		   try {
			   AddComment(map.get(Excel.Comment));
	    	   log("STEP 1: Title comments pannel expands ", Status.PASS);
	    	} catch (Exception e) {
			   log("STEP 1: Title comments panel does not expands ", Status.FAIL);
			   throw new RuntimeException(" Failed in step 1 ");
		    }
		   
		   try {
			   ClickonSave();
		   			log("STEP 2: changes saved successfully message displays ", Status.PASS);
		   		} catch (Exception e) {
		   			log("STEP 2: changes saved successfully message not displays ", Status.FAIL);
		   			throw new RuntimeException("Failed in step 2");
		   		}
	 }
}
