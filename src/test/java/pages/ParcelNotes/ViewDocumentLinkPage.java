package pages.ParcelNotes;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.util.CommonFunction;
import com.util.TestUtil;

public class ViewDocumentLinkPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;
	public static String AGREEMENT_NUMBER;

	public ViewDocumentLinkPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	
	By navParcel = By.xpath("//span[text()='Parcel']");
	By navParcelInfo = By.xpath("//span[text()='Parcel Info']");
	By navParcelNotes = By.xpath("(//span[text()='Parcel Notes'])[1]");
	By navAgentNotes = By.xpath("(//span[text()='Agent Notes'])[1]");
	By ViewDocument = By.xpath("//a[contains(text(),'View Document')]");
	
	 public void NavigateToParcelNotesAlt() {
	        util.waitUntilElementDisplay(navParcel);
	        util.click(navParcel);
	        util.waitUntilElementDisplay(navParcelInfo);
	        util.click(navParcelInfo);
	        util.waitUntilElementDisplay(navParcelNotes);
	        util.click(navParcelNotes);	
	    }
	    
	    public void NavigateToParcelNotesRow() {
	        util.waitUntilElementDisplay(navParcel);
	        util.click(navParcel);
	        util.waitUntilElementDisplay(navParcelInfo);
	        util.click(navParcelInfo);
	        util.waitUntilElementDisplay(navAgentNotes);
	        util.click(navAgentNotes);	
	    }
	    
	    public void ClickOnViewDocument() {
	    	util.dummyWait(2);
	    	util.waitUntilElementDisplay(ViewDocument);
	    	util.click(ViewDocument);
	    	 util.dummyWait(3);
	 		Set<String> windowId = driver.getWindowHandles(); // get window id of current window
	 		Iterator<String> itererator = windowId.iterator();
	 		String mainWinID = itererator.next();
	 		String newAdwinID = itererator.next();
	 		driver.switchTo().window(newAdwinID);
	 		driver.close();
	 		driver.switchTo().window(mainWinID);
	 		util.dummyWait(2);
	    }
	    
	    By pendingStatus = By.xpath("(//tr[contains(@id,'_AGENTNOTES_radYALGridControl_ctl00__0')]/.//strong[text()='Pending'])[1]");
	    
      public void ViewDocument(String testcaseName) {
    	  if (testcaseName.contains("DOT")) {
    			log("View  Document not applicable for DOT ", Status.SKIP);
    		}
    	  
    	  else {
    		  if(util.isElementVisible(pendingStatus)) {
	  	 try {
	  		 util.reloadPage();
	  		 util.dummyWait(5);
	  			ClickOnViewDocument();
		 		log("STEP 1: User can click on view document link", Status.PASS);
		  } catch (Exception e) {
		 		log("STEP 1: User cannot click on view document link ", Status.FAIL);
		 		throw new RuntimeException("Failed in step 1");
		 }
    	  }
 		 else {
 			 log("Notes are not in pending status", Status.SKIP);
 		 }
      }
    }
}
