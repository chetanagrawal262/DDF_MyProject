package pages.tools;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.util.CommonFunction;
import com.util.TestUtil;

import extentReports.ExtentTestManager;

public class HelpPage extends BasePage {

	TestUtil util;
	CommonFunction commonFunction ;

	public HelpPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}

	By navToolsMenu = By.xpath("//a//span[@class='rmText rmExpandDown' and contains(text(),'Tools')] ");
	By navLearnMenu = By.xpath("//a//span[@class='rmText rmExpandDown' and contains(text(),'Learn')] ");
	By navHelp = By.xpath("//a//span[@class='rmText rmExpandRight' and contains(text(),'Help')] ");
	By navAdminManual = By.xpath("//a//span[@class='rmText rmExpandRight' and contains(text(),'Admin Manuals')]");
	By navWebAdminManual = By.xpath("//a//span[@class='rmText' and contains(text(),'WEB Admin Manual')] ");
	By navGisviewerAdminManual = By.xpath("//a//span[@class='rmText' and contains(text(),'GISViewer Admin Manual')]");
	By navMobileAdminManual = By.xpath("//a//span[@class='rmText' and contains(text(),'Mobile Admin Manual')]");
	By navReportConfigurationManual = By.xpath("//a//span[@class='rmText' and contains(text(),'Reports Configuration Manual')]");
	
	By navProductManual = By.xpath("//a//span[@class='rmText rmExpandRight' and contains(text(),'Product Manuals')]");
	By navWEBProductManual = By.xpath("//a//span[@class='rmText' and contains(text(),'WEB Product Manual')]");
	By navWEBAddOnManual = By.xpath("//a//span[@class='rmText' and contains(text(),'WEB Add-On Manual')]");
	By navGISViewerProductManual = By.xpath("//a//span[@class='rmText' and contains(text(),'GISViewer Product Manual')]");
	By navMobileProductManual = By.xpath("//a//span[@class='rmText' and contains(text(),'Mobile Product Manual')]");
	By navMobileAddOnManual = By.xpath("//a//span[@class='rmText' and contains(text(),'Mobile Add-On Manual')]");
	By navImportsMappingManual = By.xpath("//a//span[@class='rmText' and contains(text(),'Imports Mapping Manual')]");
	By navReportsMappingManual = By.xpath("//a//span[@class='rmText' and contains(text(),'Reports Mapping Manual')]");
	By trainingPage = By.cssSelector("body > embed");
	
	By navDevManual = By.xpath("//a//span[@class='rmText rmExpandRight' and contains(text(),'Dev Manuals')]");
	By navReportsDevelopmentGuide = By.xpath("//a//span[@class='rmText' and contains(text(),'Reports Development Guide')] ");
	By navDocgenDevelopmentGuide = By.xpath("//a//span[@class='rmText' and contains(text(),'Docgen Development Guide')]");
	
	By navProcessManual = By.xpath("//a//span[@class='rmText rmExpandRight' and contains(text(),'Process Manuals')]");
	By navGISViewerProcessManual = By.xpath("//a//span[@class='rmText' and contains(text(),'GISViewer Process Manual')] ");

	public void navigateToHelpManuals() {
		
		if(!util.isElementVisible(navToolsMenu)) {
			driver.close();
			util.switchToParentWindow();
			driver.navigate().refresh();
		}
		if(util.isElementVisible(navLearnMenu)) {
			util.waitUntilElementDisplay(navLearnMenu);
			util.click(navLearnMenu);
		}else {
			util.waitUntilElementDisplay(navToolsMenu);
			util.click(navToolsMenu);
		}
		util.dummyWait(1);
		util.hoverOnElement(navHelp);			
	}
	
By fileNotFoundError = By.xpath("//*[@data-role='dialog']");
By version = By.xpath("((//span[contains(text(),'www.irthsolutions.com')])[1]/..//span[contains(text(),'2')]/..//span[contains(text(),'5.07')])[1] | ((//span[contains(text(),'www.irthsolutions.com')])[1]/..//span[contains(text(),'2')]/..//span[contains(text(),'5.0')]/..//span[contains(text(),'7')])[1] |  ((//span[contains(text(),'www.irthsolutions.com')])[1]/..//span[contains(text(),'2')]/..//span[contains(text(),'5.')]/..//span[contains(text(),'07')])[2] | ((//span[contains(text(),'www.irthsolutions.com')])[1]/..//span[contains(text(),'2')]/..//span[contains(text(),'5.')]/..//span[contains(text(),'0')]/..//span[contains(text(),'7')])[1]");
By zoomOut = By.xpath("(//a[@aria-label='Zoom Out'])[1]");
public void verifyHelpDoc() {	
	util.switchToChildWindow();
	util.click(zoomOut);
	util.click(zoomOut);
  		if(!util.isElementVisible(fileNotFoundError)) {
  			util.dummyWait(5);}
  		//util.scrollDownToPage();
  		ExtentTestManager.infoWithScreenshot("Manual Name and Version");
//  		util.waitUntilElementDisplay(version);
  		//Assert.assertTrue(util.isElementPresent(version));
  			
}
	
	
	By NavTrainingCourse = By.xpath("//span[text()='Training Courses']");
	By MyTraing = By.xpath("//span[text()='My Training']");
	By ToDo = By.xpath("//*[@id='mat-tab-label-0-0']/span[2]");
	By Completed = By.xpath("//span[text()='Completed']");

	
	
	public void NavigateToTrainingCourses() {
		if(!util.isElementVisible(navLearnMenu)) {
			driver.close();
			util.switchToParentWindow();
			driver.navigate().refresh();
		}
		util.waitUntilElementDisplay(navLearnMenu);
		util.click(navLearnMenu);
		util.waitFor(300);
		util.hoverOnElement(NavTrainingCourse);	
		util.click(NavTrainingCourse);
		util.waitFor(300);
		util.switchToChildWindow();
		}

	By NavFeedback = By.xpath("//span[text()='Feedback']");
	By NavSubmitAnIdea = By.xpath("//span[text()='Submit an idea']");
	By irthSupport = By.xpath("//*[text()='Irth Support']");
	
	public void NavigateToFeedback() {
		if(!util.isElementVisible(navLearnMenu)) {
			driver.close();
			util.switchToParentWindow();
			driver.navigate().refresh();
		}
		util.waitUntilElementDisplay(navLearnMenu);
		util.click(navLearnMenu);
		util.waitFor(300);
		util.hoverOnElement(NavFeedback);	
		util.click(NavFeedback);
		util.waitFor(300);
		util.waitUntilElementDisplay(NavSubmitAnIdea);
		util.click(NavSubmitAnIdea);
		util.switchToChildWindow();
		}
	
	public void VerifyTraingCoursePage() {
		util.switchToChildWindow();
		util.waitUntilElementDisplay(MyTraing);
		util.dummyWait(1);
		
	}
	
	
	public void verifyWebAdminManual() {
		
		try {
			navigateToHelpManuals();
			util.waitUntilElementDisplay(navAdminManual);
			//util.hoverOnElement(navAdminManual);
			util.click(navAdminManual);
			util.waitUntilElementDisplay(navWebAdminManual);
			util.click(navWebAdminManual);
			log("STEP 1: User can navigate to Web Admin Manual", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: User cannot navigate to Web Admin Manual ", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}
		
		try {
			verifyHelpDoc();
			log("STEP 2: Help Manual Available", Status.PASS);
		} catch (Exception e) {
			log("STEP 2: Help Manual not Available", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}		
	}
	
	public void verifyGisviewerAdminManual() {
		
		try {
			navigateToHelpManuals();
			util.waitUntilElementDisplay(navAdminManual);
			//util.hoverOnElement(navAdminManual);
			util.click(navAdminManual);
			util.waitUntilElementDisplay(navGisviewerAdminManual);
			util.click(navGisviewerAdminManual);
			log("STEP 1: User can navigate to Gisviewer Admin Manual", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: User cannot navigate to Gisviewer Admin Manual ", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}
		
		try {
			verifyHelpDoc();
			log("STEP 2: Help Manual Available", Status.PASS);
		} catch (Exception e) {
			log("STEP 2: Help Manual not Available", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}
					
	}
	
	public void verifyMobileAdminManual() {
		
		try {
			navigateToHelpManuals();
			util.waitUntilElementDisplay(navAdminManual);
			//util.hoverOnElement(navAdminManual);
			util.click(navAdminManual);
			util.waitUntilElementDisplay(navMobileAdminManual);
			util.click(navMobileAdminManual);
			log("STEP 1: User can navigate to Mobile Admin Manual", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: User cannot navigate to Mobile Admin Manual ", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}
		
		try {
			verifyHelpDoc();
			log("STEP 2: Help Manual Available", Status.PASS);
		} catch (Exception e) {
			log("STEP 2: Help Manual not Available", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}
					
	}
	
	public void verifyReportConfigurationManual() {
		
		try {
			navigateToHelpManuals();
			util.waitUntilElementDisplay(navAdminManual);
			//util.hoverOnElement(navAdminManual);
			util.click(navAdminManual);
			util.waitUntilElementDisplay(navReportConfigurationManual);
			util.click(navReportConfigurationManual);
			log("STEP 1: User can navigate to Report Configuration Manual", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: User cannot navigate to Report Configuration Manual ", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}
		
		try {
			verifyHelpDoc();
			log("STEP 2: Help Manual Available", Status.PASS);
		} catch (Exception e) {
			log("STEP 2: Help Manual not Available", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}
					
	}
	
	public void verifyWEBProductManual() {
		
		try {
			navigateToHelpManuals();
			util.waitUntilElementDisplay(navProductManual);
			//util.hoverOnElement(navProductManual);
			util.click(navProductManual);
			util.waitUntilElementDisplay(navWEBProductManual);		
			util.click(navWEBProductManual);
			log("STEP 1: User can navigate to Web Product Manual", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: User cannot navigate to Web Product Manual ", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}	
		
		try {
			verifyHelpDoc();
			log("STEP 2: Help Manual Available", Status.PASS);
		} catch (Exception e) {
			log("STEP 2: Help Manual not Available", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}
	}
	
	public void verifyWEBAddOnManual() {
		
		try {
			navigateToHelpManuals();
			util.waitUntilElementDisplay(navProductManual);
			//util.hoverOnElement(navProductManual);
			util.click(navProductManual);
			util.waitUntilElementDisplay(navWEBAddOnManual);
			util.click(navWEBAddOnManual);
			log("STEP 1: User can navigate to Web AddOn Manual", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: User cannot navigate to Web AddOn Manual ", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}		
		
		try {
			verifyHelpDoc();
			log("STEP 2: Help Manual Available", Status.PASS);
		} catch (Exception e) {
			log("STEP 2: Help Manual not Available", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}
	}
	
	public void verifyGISViewerProductManual() {
		
		try {
			navigateToHelpManuals();
			util.waitUntilElementDisplay(navProductManual);
			//util.hoverOnElement(navProductManual);
			util.click(navProductManual);
			util.waitUntilElementDisplay(navGISViewerProductManual);
			util.click(navGISViewerProductManual);
			log("STEP 1: User can navigate to GISViewer Product Manual", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: User cannot navigate to GISViewer Product Manual ", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}
		
		try {
			verifyHelpDoc();
			log("STEP 2: Help Manual Available", Status.PASS);
		} catch (Exception e) {
			log("STEP 2: Help Manual not Available", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}
					
	}
	
	public void verifyMobileProductManual() {
		
		try {
			navigateToHelpManuals();
			util.waitUntilElementDisplay(navProductManual);
//			util.hoverOnElement(navProductManual);
			util.click(navProductManual);
			util.waitUntilElementDisplay(navMobileProductManual);
			util.click(navMobileProductManual);
			log("STEP 1: User can navigate to Mobile Product Manual", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: User cannot navigate to Mobile Product Manual ", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}	
		
		try {
			verifyHelpDoc();
			log("STEP 2: Help Manual Available", Status.PASS);
		} catch (Exception e) {
			log("STEP 2: Help Manual not Available", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}
	}
	
	public void verifyMobileAddOnManual() {
		
		try {
			navigateToHelpManuals();
			util.hoverOnElement(navProductManual);
			util.click(navProductManual);
			util.click(navMobileAddOnManual);
			log("STEP 1: User can navigate to Mobile AddOn Manual", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: User cannot navigate to Mobile AddOn Manual ", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}
		
		try {
			verifyHelpDoc();
			log("STEP 2: Help Manual Available", Status.PASS);
		} catch (Exception e) {
			log("STEP 2: Help Manual not Available", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}
					
	}
	
	public void verifyImportsMappingManual() {
		
		try {
			navigateToHelpManuals();
			util.hoverOnElement(navProductManual);
			util.click(navProductManual);
			util.click(navImportsMappingManual);
			log("STEP 1: User can navigate to Imports Mapping Manual", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: User cannot navigate to Imports Mapping Manual ", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}	
		
		try {
			verifyHelpDoc();
			log("STEP 2: Help Manual Available", Status.PASS);
		} catch (Exception e) {
			log("STEP 2: Help Manual not Available", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}
	}
	
	public void verifyReportsMappingManual() {
		
		try {
			navigateToHelpManuals();
			util.hoverOnElement(navProductManual);
			util.click(navProductManual);
			util.click(navReportsMappingManual);
			log("STEP 1: User can navigate to Reports Mapping Manual", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: User cannot navigate to Reports Mapping Manual ", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}
		
		try {
			verifyHelpDoc();
			log("STEP 2: Help Manual Available", Status.PASS);
		} catch (Exception e) {
			log("STEP 2: Help Manual not Available", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}
	}
	
	public void verifyReportsDevelopmentGuide() {
		
		try {
			navigateToHelpManuals();
			util.hoverOnElement(navDevManual);
			util.click(navDevManual);
			util.click(navReportsDevelopmentGuide);
			log("STEP 1: User can navigate to Reports Development Guide", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: User cannot navigate to Reports Development Guide ", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}
			
		try {
			verifyHelpDoc();
			log("STEP 2: Help Manual Available", Status.PASS);
		} catch (Exception e) {
			log("STEP 2: Help Manual not Available", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}
	}
	
	public void verifyDocgenDevelopmentGuide() {
		
		try {
			navigateToHelpManuals();
			util.hoverOnElement(navDevManual);
			util.click(navDevManual);
			util.click(navDocgenDevelopmentGuide);
			log("STEP 1: User can navigate to Docgen Development Guide", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: User cannot navigate to Docgen Development Guide ", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}	
		try {
			verifyHelpDoc();
			log("STEP 2: Help Manual Available", Status.PASS);
		} catch (Exception e) {
			log("STEP 2: Help Manual not Available", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}
	}
	
	public void verifyGISViewerProcessManual() {
		
		try {
			navigateToHelpManuals();
			util.hoverOnElement(navProcessManual);
			util.click(navProcessManual);
			util.click(navGISViewerProcessManual);
			log("STEP 1: User can navigate to GISViewer Process Manual", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: User cannot navigate to GISViewer Process Manual", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}	
		
		try {
			verifyHelpDoc();
			log("STEP 2: Help Manual Available", Status.PASS);
		} catch (Exception e) {
			log("STEP 2: Help Manual not Available", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}
	}
	
	public void TraingCourses() {
		
		try {
			NavigateToTrainingCourses();
			log("STEP 1: User can navigate to Training courses", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: User unable to navigate to Traing courses ", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}
		util.switchToIframe(trainingPage);
		util.waitUntilPageLoad();
		util.dummyWait(30);
		ExtentTestManager.infoWithScreenshot("To Do");
		util.waitUntilElementDisplay(MyTraing);
		if(util.isElementVisible(MyTraing))	{
			util.dummyWait(1);
			
			log("STEP 2: User can see training videos on To do link", Status.PASS);
			} else{
				log("STEP 2: User cannot see training videos on To do link ", Status.FAIL);
			}
				
		try {
			util.click(Completed);
			ExtentTestManager.infoWithScreenshot("Completed Tab");
			log("STEP 3: User can see completed sessions on Completed tab", Status.PASS);
		} catch(Exception e){
			log("STEP 3: User cannot see completed sessions on Completed tab", Status.FAIL);
			
		}
	
       driver.close();
       util.switchToParentWindow();
	
	
	
	
	
	
	
}
	
	
	
    public void submitAnIdea() {
	try {
		NavigateToFeedback();
		log("STEP 1: User can navigate to Submit An Idea", Status.PASS);
	} catch (Exception e) {
		log("STEP 1: User unable to navigate to Submit An Idea ", Status.FAIL);
		throw new RuntimeException("Failed in step 1");
	}
	ExtentTestManager.infoWithScreenshot("Irth Land Support");

	if (util.isElementVisible(irthSupport)) {
		util.dummyWait(1);

		log("STEP 2: User can see Feedback Page", Status.PASS);
	} else {
		log("STEP 2: User cannot see Feedback Page", Status.FAIL);
	}

	
	driver.close();
	util.switchToParentWindow();

   }
	
	
	
	
	
	
	
	
	
	
	
}
