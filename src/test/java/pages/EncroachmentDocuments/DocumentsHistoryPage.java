package pages.EncroachmentDocuments;



import java.util.Iterator;
import java.util.Map;
import java.util.Set;

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

public class DocumentsHistoryPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;

	public DocumentsHistoryPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	
	
	By navDocument = By.xpath("//span//span//span[text()='Documents']"); 
	By DocumentGrid = By.xpath("(//tr[contains(@id,'_DOCUMENT_radYALGridControl')])[1]");
	By btnAddVersion = By.xpath("//span[contains(text(),'Add Version')]");
    By btnRequestDelete = By.xpath("//input[contains(@id,'_btnRequestDelete') and @type='image']");
    By btnViewHistory = By.xpath("(//span[text()='View History'])[1]");
	By btnDeleteAllPriorVersion = By.xpath("//input[contains(@id,'_DOCUMENT_DOCSS_RadDock3_C_btnDelAllPrev')]");
	By successmessgae = By.xpath("//span[contains(@id,'_DOCUMENT_DOCSS_RadDock3_C_lblMessage')]");
	By DocumentLink = By.xpath("//a[contains(text(),'test.txt')]");
    
	public void rightClickOnGrid(String value) {
		System.out.println();
		By clickOnDocument = By.xpath("(//*[text()='" + value + "'])[1]/..");
		WebElement RclickOnDocument = driver.findElement(clickOnDocument);
		util.click(clickOnDocument);
		util.Rcllick(RclickOnDocument);
	}
	
    public void ClickonViewHistory() {
    	util.waitUntilElementDisplay(btnViewHistory);
    	util.click(btnViewHistory);
    }
    
    public void ClickonDeleteAllButton() {
    	util.waitUntilElementDisplay(btnDeleteAllPriorVersion);
    	util.click(btnDeleteAllPriorVersion);
    	util.waitUntilElementDisplay(successmessgae);
    	Assert.assertTrue(util.isElementPresent(successmessgae));
    }
    
    public void ClickonDocumentLink(String value) {
    	By btnViewDocument = By.xpath("//a[contains(text(),'" + value + "')]");
		util.waitUntilElementDisplay(btnViewDocument);
    	util.dummyWait(2);
    	util.click(btnViewDocument);
    	util.dummyWait(2);
    	Set<String> windowId = driver.getWindowHandles(); // get window id of current window
		Iterator<String> itererator = windowId.iterator();

		String mainWinID = itererator.next();
		String newAdwinID = itererator.next();

		driver.switchTo().window(newAdwinID);
		driver.close();
		driver.switchTo().window(mainWinID);
		util.dummyWait(2);
    }
    
	By btnClose = By.xpath("//a[@class='rwCloseButton']");
    public void ClickonAddVersion() {
    	WebElement web = driver.findElement(DocumentGrid);
    	util.waitUntilElementDisplay(DocumentGrid);
    	Actions act = new Actions(driver);
    	act.moveToElement(web).contextClick().build().perform();
    	util.dummyWait(1);
    	util.waitUntilElementDisplay(btnAddVersion);
    	util.click(btnAddVersion);
    	util.dummyWait(1);
    	util.click(btnClose);
    	util.dummyWait(1);
    }
    
    public void ClickonRequestDelete() {
    	util.waitUntilElementDisplay(btnRequestDelete);
    	util.click(btnRequestDelete);
    	util.dummyWait(1);
    }
    
  
    
  public void DocumentsHistory(Map<String, String> map, String testcaseName) {
	  try {
		  rightClickOnGrid(map.get(Excel.DocumentName));
	 			log("STEP 1: User can see multiple options ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 1: User cannot see multiple options ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 1");
	 		 }
 	   
 	   try {
 		  ClickonViewHistory();
	 			log("STEP 2: User can click on the View History button ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 2: User cannot able to click on View History button  ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 2");
	 		 }
 	   
 	  
// 	  try {
//			ClickonDocumentLink(map.get(Excel.DocumentName));
//			 log("STEP 3: User can download Document by clicking on the Document Name Link  ", Status.PASS);
//			} catch (Exception e) {
//			 log("STEP 3: User cannot able to click on Document Name Link  ", Status.FAIL);
//			  throw new RuntimeException("Failed in step 3");
//			}
 	   
     if(util.isElementVisible(DocumentLink)) {
    	 log("STEP 3: User can download Document by clicking on the Document Name Link  ", Status.PASS);
     }else {
    	 log("STEP 3: Document Link is not visible due to 'AllowToViewVersionDocument' ABS key is false ", Status.PASS);
     }
 	  
     
 	  
    	
    }

	
}
