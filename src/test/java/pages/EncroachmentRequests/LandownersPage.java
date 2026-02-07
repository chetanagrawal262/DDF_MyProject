package pages.EncroachmentRequests;

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

public class LandownersPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;

	public LandownersPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		
	}
	
	By panelLandowners = By.xpath("//span[text()=\"Landowner's\"]");
	By LandownerInformtion = By.xpath("//span[contains(text(),'Landowner Information')]");
    By drpExistingContact = By.xpath("//input[contains(@id,'_LESSOR_Input') and @type='text']");
    By btnAdd = By.xpath("//input[contains(@id,'btnAddLessor') and @type='image']");
    By successMsg = By.xpath("//span[text()='Landowner has been added']");
	
    By ParcelInformation = By.xpath("//*[contains(@id,'_RadTabStripLO')]/..//span[text()='Parcel Information']");
    By drpExistingParcel = By.xpath("//input[contains(@id,'_TRACTS_Input') and @type='text']");
	By btnAddParcel = By.xpath("//input[contains(@id,'ImageButton2')]");
	By successMsgParcel = By.xpath("//span[text()='Selected parcel added to issue']");

    public void ExpandLandowner() {
		util.waitUntilElementDisplay(panelLandowners);
		util.click(panelLandowners);
	}
    
	public void ClickOnLandownerInformtion() {
		util.waitUntilElementDisplay(LandownerInformtion);
		util.click(LandownerInformtion);
	}
	
	public void SelectExistingContact(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpExistingContact,value);
	}
	
	public void ClickOnAddButton() {
		util.waitUntilElementDisplay(btnAdd);
		util.click(btnAdd);
		util.waitUntilPageLoad();
	}
	
	public void ClickOnParcelInformtion() {
		util.waitUntilElementDisplay(ParcelInformation);
		util.click(ParcelInformation);
	}
	
	public void SelectExistingParcel(String value) {
		if (!commonFunction.checkNA(value))
			if (!commonFunction.checkNA(value))
				util.waitUntilElementDisplay(drpExistingParcel);
				WebElement inputField = util.getElement(drpExistingParcel);
				inputField.click();
				util.dummyWait(5);
				util.clearInputField(inputField);
				util.dummyWait(5);
				inputField.sendKeys(value);
				util.dummyWait(5);
				inputField.sendKeys(Keys.TAB);
	}
	
	public void ClickOnAddParcel() {
		util.waitUntilElementDisplay(btnAddParcel);
		util.click(btnAddParcel);
		util.waitUntilPageLoad();
	}
	
	public void LandownerInformation(Map<String, String> map, String testcaseName) {
		
		try {
			ExpandLandowner();
			log("STEP 1: User can expand Landowner Panel ", Status.PASS);
		} catch (Exception e) {
			log("STEP 1:  User cannot expand Landowner Panel", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}

		try {
			ClickOnLandownerInformtion();
			log("STEP 2: User can navigate to Landowner Information Tab ", Status.PASS);
		} catch (Exception e) {
			log("STEP 2: User cannot navigate to Landowner Information Tab", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}

		try {
			SelectExistingContact(map.get(Excel.ExistingContact));
			log("STEP 3: User can select Existing Landowner  ", Status.PASS);
		} catch (Exception e) {
			log("STEP 3:User cannot select Existing Landowner ", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}

		try {
			ClickOnAddButton();
			log("STEP 4:  User can click on Add Button ", Status.PASS);
		} catch (Exception e) {
			log("STEP 4:  User cannot click on Add Button  ", Status.FAIL);
			throw new RuntimeException("Failed in step 4");
		}
		
		try {
			Assert.assertTrue(util.isElementVisible(successMsg));
			log("STEP 5:  User can see Success Message ", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 5:  User cannot see Success Message  ", Status.FAIL);
		}
		
		try {
			By loName = By.xpath("//tr[contains(@id,'_LOHDetails_radPanels_')]//td[contains(text(),'"+map.get(Excel.ExistingContact)+"')]");
			Assert.assertTrue(util.isElementVisible(loName));
			log("STEP 6:  User can see Added Landowner in the grid view ", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 6:  User cannot see Added Landowner in the grid view ", Status.FAIL);
		}
	    	
	    }
	
	
		public void AddParcelInformation(Map<String, String> map, String testcaseName) {

			try {
				ClickOnParcelInformtion();
				log("STEP 1: User can navigate to Parcel Information Tab ", Status.PASS);
			} catch (Exception e) {
				log("STEP 1: User cannot navigate to Parcel Information Tab", Status.FAIL);
				throw new RuntimeException("Failed in step 1");
			}

			try {
				SelectExistingParcel(map.get(Excel.Parcel));
				log("STEP 2: User can select Existing Parcel  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 2:User cannot select Existing Parcel ", Status.FAIL);
				throw new RuntimeException("Failed in step 3");
			}

			try {
				ClickOnAddParcel();
				log("STEP 3:  User can click on Add Button ", Status.PASS);
			} catch (Exception e) {
				log("STEP 3:  User cannot click on Add Button  ", Status.FAIL);
				throw new RuntimeException("Failed in step 3");
			}

			try {
				Assert.assertTrue(util.isElementVisible(successMsgParcel));
				log("STEP 4:  User can see Success Message ", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 4:  User cannot see Success Message  ", Status.FAIL);
			}

			String [] parts = map.get(Excel.Parcel).split("-");
			try {		
				By projectName = By.xpath("//tr[contains(@id,'_LOHDetails_radPanels_')]//td[contains(text(),'"+ parts[0].trim() + "')]");
				Assert.assertTrue(util.isElementVisible(projectName));
				log("STEP 5:  User can see Added Parcel's Project Name in the grid view ", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 5:  User cannot see Added Parcel's Project Name in the grid view ", Status.FAIL);
			}
			
			try {
				By tractNo = By.xpath("//tr[contains(@id,'_LOHDetails_radPanels_')]//a[contains(text(),'"+ parts[1].trim() + "')]");
				Assert.assertTrue(util.isElementVisible(tractNo));
				log("STEP 5:  User can see Added Parcel No in the grid view ", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 5:  User cannot see Added Parcel No in the grid view ", Status.FAIL);
			}

		}
}
