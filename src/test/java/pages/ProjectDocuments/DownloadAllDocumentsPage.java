package pages.ProjectDocuments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.util.CommonFunction;
import com.util.TestUtil;

public class DownloadAllDocumentsPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;
	public static String AGREEMENT_NUMBER;

	public DownloadAllDocumentsPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	

	By navDocument = By.xpath("//span//span//span[text()='Documents']");
    By CheckBox = By.xpath("(//input[contains(@id,'_CheckBox1') and @type='checkbox'])[1]");
    By btnDownloadAll = By.xpath("//img[@alt='Download Zip File']");
    By btnDownloadAllDot = By.xpath("//input[contains(@id,'DOCUMENT_btnDownloadAll')]");
    By iframe = By.xpath("//iframe[@name='HistoryDialog']");
    By iframeDot = By.xpath("//iframe[@name='RadWindowDownloadDocuments']");
    By btnDownloadNow = By.xpath("//input[contains(@id,'btnDownloadNow') and @type='submit']");
    
    
   
    public void SelectCheckBox() {
    	util.waitUntilElementDisplay(CheckBox);
    	util.click(CheckBox);
    	util.dummyWait(2);
    }
    By btnClose = By.xpath("(//a[@title='Close'])[1]");
    public void ClickonDownloadAll() {
    	util.waitUntilElementDisplay(btnDownloadAll);
    	util.click(btnDownloadAll);
    	util.dummyWait(2);
    	util.switchToIframe(iframe);
    	util.waitUntilElementDisplay(btnDownloadNow);
//    	util.click(btnDownloadNow);
    	util.switchToDefaultContent();
    	util.dummyWait(1);
    	util.click(btnClose);
    	util.dummyWait(1);
    }
    
    public void ClickonDownloadAllDOT() {
    	util.waitUntilElementDisplay(btnDownloadAllDot);
    	util.click(btnDownloadAllDot);
    	util.dummyWait(2);
    	util.switchToIframe(iframeDot);
    	util.waitUntilElementDisplay(btnDownloadNow);
//    	util.click(btnDownloadNow);
    	util.switchToDefaultContent();
    	util.dummyWait(1);
    	util.click(btnClose);
    	util.dummyWait(1);
    }
    
    public void UncheckedCheckbox() {
    	util.waitUntilElementDisplay(CheckBox);
    	util.click(CheckBox);
    	util.dummyWait(1);
    }
    
    public void ClickonDownloadAllButton() {
    	util.waitUntilElementDisplay(btnDownloadAll);
    	util.click(btnDownloadAll);
    	util.dummyWait(1);
    	util.click(btnClose);
    	util.dummyWait(1);
    }
    
    public void ClickonDownloadAllButtonDOT() {
    	util.waitUntilElementDisplay(btnDownloadAllDot);
    	util.click(btnDownloadAllDot);
    	util.dummyWait(1);
    	util.click(btnClose);
    	util.dummyWait(1);
    }
    
    public void DownloadAllDocuments(String testcaseName) {
    	
 	   util.dummyWait(3);
 	   if(testcaseName.contains("DOT")) {
 		  try {
 		  ClickonDownloadAllDOT();
			log("STEP 1: User can click on the Download All button  ", Status.PASS);
		 } catch (Exception e) {
			log("STEP 1: User cannot able to click on Download All button ", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		 }
 	   }
 	   else {
 		   
 	   try {
 		      ClickonDownloadAll();
	 			log("STEP 1: User can click on the Download All button  ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 1: User cannot able to click on Download All button ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 1");
	 		 }
 	   }
    }
	
}
