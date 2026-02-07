package pages.Survey;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.util.CommonFunction;
import com.util.TestUtil;

public class SurveyTitleChainPage extends BasePage {

	TestUtil util;
	CommonFunction commonFunction;
	public static String AGREEMENT_NUMBER;

	public SurveyTitleChainPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		
	}
	
	By expandTitleChainPanel = By.xpath("//span[contains(text(),'Title Chain')]");
	By btnPDF = By.xpath("//img[contains(@id,'_radYALGridControl_ctl00_ctl02_ctl00_Img2')]");
	By btnExcel = By.xpath("//img[contains(@id,'_radYALGridControl_ctl00_ctl02_ctl00_Img3')]");
	
	public void ExpandTitleChain() {
		util.waitUntilElementDisplay(expandTitleChainPanel);
		util.click(expandTitleChainPanel);
	}
	
	public void ClickonPDF() {
		util.waitUntilElementDisplay(expandTitleChainPanel);
		util.click(expandTitleChainPanel);
		util.dummyWait(2);
	}
	
	public void ClickonExcel() {
		util.waitUntilElementDisplay(expandTitleChainPanel);
		util.click(expandTitleChainPanel);
		util.dummyWait(2);
	}
	
	 public void SurveyTitleChain(String testcaseName) {
		 
		 try {
			 ExpandTitleChain();
				log("STEP 1: Panel expands & field displays ", Status.PASS);
			} catch (Exception e) {
				log("STEP 1: user is unable to expand panel.", Status.FAIL);
				throw new RuntimeException("Failed in step 1 ");
			}
		 
		 
		 try {
			 ClickonPDF();
				log("STEP 2:  User can download document in PDF format. ", Status.PASS);
			} catch (Exception e) {
				log("STEP 2: User cannot  download document in PDF format.", Status.FAIL);
				throw new RuntimeException("Failed in step 2 ");
			}
		 
		 try {
			 ClickonExcel();
				log("STEP 3:  User can download document in excel format. ", Status.PASS);
			} catch (Exception e) {
				log("STEP 3:  User cannot  download document in excel  format.", Status.FAIL);
				throw new RuntimeException("Failed in step 3 ");
			}
		 
	 }
	
}
