package pages.EncroachmentMitigation;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

public class AffectedParcelInformationPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;

	public AffectedParcelInformationPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		
	}
	
	By panelAffectedParcelInformation = By.xpath("//span[contains(text(),'Affected Parcel Information')]");
	By LandownerInformtion = By.xpath("//span[contains(text(),'Landowner Information')]");
    By drpExistingContact = By.xpath("//input[contains(@id,'_LESSOR_Input') and @type='text']");
    By btnAddLandowner = By.xpath("//input[contains(@id,'btnAddLessor') and @type='image']");
    By successMessage = By.xpath("//span[text()='Lessor has been added to lease']");
    
	By TractInformation = By.xpath("//*[@id='ctl00_ConPHRightTop_TREM_UC_radPanels_i2_i0_RadTabStripLO']/..//span[text()='Tract Information']");
	By drpAvailableTract = By.xpath("//input[contains(@id,'_TRACTS_Input')]");
	By successMessageTract = By.xpath("//span[text()='Selected Parcel added to issue']");
	By btnAddTract = By.xpath("//input[contains(@id,'ImageButton2')]");
	By TractNoLink = By.xpath("//tr[@id='ctl00_ConPHRightTop_TREM_UC_radPanels_i2_i0_RadGridTract_ctl00__0']//a");
    By btnDelete = By.xpath("(//input[contains(@id,'gbcDeleteTract')])[1]");
	By iframDelete = By.xpath("//td[@class='rwWindowContent']");
	By btnOk = By.xpath("//span[text()='OK']");
	
		
	By loader = By.xpath("//li[contains(@id,'_LoadingDiv')]");
	By pageSpinner = By.xpath("//*[@id='idCustOutreach_RALCustOutreachidCustOutreach_RadMultiPage1']/div[1]");
	
	public void ExpandAffectedParcelInformation() {
		util.waitUntilElementDisplay(panelAffectedParcelInformation);
		util.click(panelAffectedParcelInformation);
	}

	public void ClickOnLandownerInformtion() {
		util.waitUntilElementDisplay(LandownerInformtion);
		util.click(LandownerInformtion);
	}
	
	public void SelectExistingContact(String value) {
		if (!commonFunction.checkNA(value))
		util.waitUntilElementDisplay(drpExistingContact);
		WebElement inputField = util.getElement(drpExistingContact);
		inputField.click();
		util.dummyWait(5);
		util.clearInputField(inputField);
		util.dummyWait(5);
		inputField.sendKeys(value);
		util.dummyWait(5);
		inputField.sendKeys(Keys.TAB);
	}
	
	public void ClickOnAddLandownerButton() {
		util.waitFor(200);
		util.waitUntilElementDisplay(btnAddLandowner);
		util.click(btnAddLandowner);
	}
	
	public void ClickonDelete() {
	  		util.waitUntilElementDisplay(btnDelete);
	  		util.click(btnDelete);
	    }
	
	 
	 public void ClickonOk()  {
		    util.waitUntilElementDisplay(btnDelete);
	  		util.click(btnDelete);	
	  		util.waitUntilElementDisplay(btnOk);
	  		util.click(btnOk);
	  		
	    }
	 
	 public void ClickOnTractInformtion() {
			util.waitUntilElementDisplay(TractInformation);
			util.click(TractInformation);
		}
		
		public void SelectAvailableTract(String value) {
			if (!commonFunction.checkNA(value))
			util.waitUntilElementDisplay(drpAvailableTract);
			WebElement inputField = util.getElement(drpAvailableTract);
			inputField.click();
			util.dummyWait(5);
			util.clearInputField(inputField);
			util.dummyWait(5);
			inputField.sendKeys(value);
			util.dummyWait(5);
			inputField.sendKeys(Keys.TAB);
		}
		
		public void ClickOnAddTractButton() {
			util.waitFor(200);
			util.waitUntilElementDisplay(btnAddTract);
			util.click(btnAddTract);
		}
		
	    public void LandownerInformation(Map<String, String> map, String testcaseName) {

	    	try {
	    		ExpandAffectedParcelInformation();
    				log("STEP 1: User can expand Affected Parcel Information Panel", Status.PASS);
    			} catch (Exception e) {
    				log("STEP 1:  User cannot expand Affected Parcel Information Panel", Status.FAIL);
    				throw new RuntimeException("Failed in step 1");
    			}
	    	
	    	try {
	    		ClickOnLandownerInformtion();
    				log("STEP 2: User can click on Lanowner Information Tab", Status.PASS);
    			} catch (Exception e) {
    				log("STEP 2:  User cannot click on Lanowner Information Tab", Status.FAIL);
    				throw new RuntimeException("Failed in step 2");
    			}
	    	
	    	 try {
	    		 SelectExistingContact(map.get(Excel.ExistingContact));
	    			log("STEP 3: User can select Existing Landowner from the dd ", Status.PASS);
	    		} catch (Exception e) {
	    			log("STEP 3:User cannot select Existing Landowner from the dd", Status.FAIL);
	    			throw new RuntimeException("Failed in step 3");
	    		}
	    	
	    	 try {
	    		 ClickOnAddLandownerButton();
	    			log("STEP 4:  User can click on Add Button", Status.PASS);
	    		} catch (Exception e) {
	    			log("STEP 4:   User cannot click on Add Button ", Status.FAIL);
	    			throw new RuntimeException("Failed in step 4");
	    		}
	    	 
				try {
					Assert.assertTrue(util.isElementVisible(successMessage));
					log("STEP 5:  User can see Succes Message ", Status.PASS);
				} catch (AssertionError e) {
					log("STEP 5:  User cannot see Succes Message ", Status.FAIL);
				}
	    	
	    }
	    
	    public void TractInformation(Map<String, String> map, String testcaseName) {

	    	try {
	    		ClickOnTractInformtion();
    				log("STEP 1: User can click on Tract Information Tab", Status.PASS);
    			} catch (Exception e) {
    				log("STEP 1:  User cannot click on Tract Information Tab", Status.FAIL);
    				throw new RuntimeException("Failed in step 1");
    			}
	    	
	    	 try {
	    		 SelectAvailableTract(map.get(Excel.AvailableTract));
	    			log("STEP 2: User can select Available Tract from the dd ", Status.PASS);
	    		} catch (Exception e) {
	    			log("STEP 2:User cannot select Available Tract from the dd", Status.FAIL);
	    			throw new RuntimeException("Failed in step 2");
	    		}
	    	
	    	 try {
	    		 ClickOnAddTractButton();
	    			log("STEP 3:  User can click on Add Button", Status.PASS);
	    		} catch (Exception e) {
	    			log("STEP 3:   User cannot click on Add Button ", Status.FAIL);
	    			throw new RuntimeException("Failed in step 3");
	    		}
	    	 
				try {
					Assert.assertTrue(util.isElementVisible(successMessageTract));
					log("STEP 5:  User can see Succes Message ", Status.PASS);
				} catch (AssertionError e) {
					log("STEP 5:  User cannot see Succes Message ", Status.FAIL);
				}
	    	
	    }
}
