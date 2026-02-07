package pages.PMNotes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.util.CommonFunction;
import com.util.TestUtil;

public class DownloadAllDocumentPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;
	public static String AGREEMENT_NUMBER;

	public DownloadAllDocumentPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		
	}
	
	By linkAddView = By.xpath("//tbody/tr[@id='ctl00_ConPHRightTop_PRAN_UC_AGENTNOTES_radYALGridControl_ctl00__0']/td[12]/a[2]");
    By iframe = By.xpath("//iframe[@name='AddViewDocument']");
    By btnDownloadAll = By.xpath("//input[contains(@id,'_btnDownloadAll') and @type='image']");
    By iframeDownload = By.xpath("//iframe[@name='RadWindowDownloadDocuments']");
    By btnDownloadNow = By.xpath("//input[@id='btnDownloadNow']");
	By btnClose = By.xpath("//a[@title='Close']");
	
	public void ClickOnLinkAddView() {
		util.waitUntilElementDisplay(linkAddView);
		util.click(linkAddView);
	}
	
	public void ClickonDownloadAll() {
		util.switchToIframe(iframe);
		util.dummyWait(1);
		util.waitUntilElementDisplay(btnDownloadAll);
		util.click(btnDownloadAll);
	}
	
	public void ClickOnDownloadNowButton() {
		util.switchToIframe(iframeDownload);
		util.dummyWait(1);
		util.waitUntilElementDisplay(btnDownloadNow);
		util.click(btnDownloadNow);
		util.dummyWait(2);
	}
	
	public void DownloadAllDocument(String testcaseName) {
		
		if (testcaseName.contains("ROW") || testcaseName.contains("ALT") || testcaseName.contains("ORSTED")||testcaseName.contains("ORION") || testcaseName.contains("ATWELL") || testcaseName.contains("TRA")) {
			log(" Download All Document Link not applicable for ROW and ALT", Status.SKIP);
		}
		else {
		
		 try {
			 ClickOnLinkAddView();
	 			log("STEP 1: User can click on the Add/View Document Link  ;  if field does not exists in the instance  and skip the step", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 1: User cannot see the Add/View Document Link ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 1");
	 		 }
	    	 
	    	 try {
	    		 ClickonDownloadAll();
	 			log("STEP 2:Document Downlad Pop Up Should be appeared .", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 2:Document Downlad Pop Up Should not be appeared  ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 2");
	 		 }
	    	
	    	 try {
	    		 ClickOnDownloadNowButton();
	 			log("STEP 3:When User click on 'Download Now' button Document get dowload.", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 3:When user click on Download Now Nothing happened ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 3");
	 		 }
	    	 util.switchToDefaultContent();
	    	 util.dummyWait(1);
	    	 util.click(btnClose);

		}	 
	}
	
}
