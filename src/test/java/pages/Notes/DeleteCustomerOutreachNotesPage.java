package pages.Notes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.util.CommonFunction;
import com.util.TestUtil;

public class DeleteCustomerOutreachNotesPage extends BasePage{
	
	TestUtil util;
	CommonFunction commonFunction;
	public static String AGREEMENT_NUMBER;

	public DeleteCustomerOutreachNotesPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		
	}
	
	By Delete = By.xpath("//span[text()='Delete']");
    By NoteGrid = By.xpath("//tr[@id='idCustOutreach_LOHTICKETNOTESSEARCH_AGENTNOTES_RadGrid1_ctl00__0']");
	 public void RightClickonNoteGrid() {
	    	WebElement web = driver.findElement(NoteGrid);
	    	util.waitUntilElementDisplay(NoteGrid);
	    	Actions act = new Actions(driver);
	    	act.moveToElement(web).contextClick().build().perform();
	}
	 
	 public void ClickOnDeleteButton() {
		 util.waitUntilElementDisplay(Delete);
		 util.click(Delete);
	 }
	 
	 public void DeleteCustomerOutreachNotes(String testcaseName) {
		 
		 try {
			 RightClickonNoteGrid();
		 			log("STEP 2: Delete button should be appeared  ", Status.PASS);
		 		 } catch (Exception e) {
		 			log("STEP 2: Delete button not appeared ", Status.FAIL);
		 			throw new RuntimeException("Failed in step 2");
		 		 }
	 	   
	 	   try {
	 		  ClickOnDeleteButton();
		 			log("STEP 3: Delete button should be clicked ", Status.PASS);
		 		 } catch (Exception e) {
		 			log("STEP 3: Ticket Note should not be deleted and not removed from grid  ", Status.FAIL);
		 			throw new RuntimeException("Failed in step 3");
		 		 }

	 }
	
}
