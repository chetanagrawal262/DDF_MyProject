package pages.AdministrationTemplate;

import java.io.File;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

public class AddNewTemplatePage extends BasePage{
	
	TestUtil util;
	CommonFunction commonFunction;
	public static String templateName;

	public AddNewTemplatePage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	
	By navAdministration = By.xpath("//span[text()='Administration']");
	By navTemplates = By.xpath("//span[text()='Templates']");
    By btnAddNewRecord = By.xpath("//a[contains(@id,'lnkAddNewRecord')]");
    By iframe = By.xpath("//iframe[@name='rwAddTemplate']");
    By ActiveCheckbox = By.xpath("//label[contains(text(),'Active')]");
    By txtDisplayName = By.xpath("//input[contains(@id,'displayName') and @type='text']");
    By ScreenOptionProject = By.xpath("//li[contains(@id,'TEMPLATETYPE_radYALListBox')]//span[text()='Project']/..//input[@type='checkbox']");
    By drpUserRole = By.xpath("//input[contains(@id,'_cbRoles_YALComboBox_Input') and @type='text']");
    By GlobalRadiobtn = By.xpath("//label[contains(text(),'Global')]");
    By btnLoadDocument = By.xpath("//input[contains(@id,'buttonSubmit') and @type='image']");
     
    public void NavigateToTemplates() {
    	util.waitUntilElementDisplay(navAdministration);
    	util.click(navAdministration);
    	util.waitUntilElementDisplay(navTemplates);
    	util.click(navTemplates);
    }
    	
    public void ClickOnAddNewRecord() {
    	util.waitUntilElementDisplay(btnAddNewRecord);
    	util.click(btnAddNewRecord);
    	util.dummyWait(2);
    	util.switchToIframe(iframe);
    }

        By fileUpload = By.xpath("//input[contains(@id,'RadUpload1file0')]");
		public void uploadFile() {
			util.dummyWait(1);
			String filepath = System.getProperty("user.dir") + File.separator + "1_Docusign Demo.docx";
			driver.findElement(fileUpload).sendKeys(filepath);
		}
		
		public void ClickOnActiveCheckbox() {
			util.waitUntilElementDisplay(ActiveCheckbox);
	    	util.click(ActiveCheckbox);	
		}
		
		public void AddDisplayName(String value) {
			if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtDisplayName, value);
		}
		
		public void SelectScreenOption() {
			util.waitUntilElementDisplay(ScreenOptionProject);
			util.click(ScreenOptionProject);
		}
		
		public void SelectUserRole(String value) {
			if (!commonFunction.checkNA(value))
				util.inputText(drpUserRole, value);
			util.pressDownkey();
			util.pressDownkey();
			util.pressENTERkey();
		}
		
		public void ClickOnGlobalRadioButton() {
			util.waitUntilElementDisplay(GlobalRadiobtn);
			util.click(GlobalRadiobtn);
		}
    
		By SuccessMessage = By.xpath("//span[contains(@id,'_lblResults')]");
		public void ClickOnLoadDoument() {
			util.waitUntilElementDisplay(btnLoadDocument);
			util.click(btnLoadDocument);
		}
		
		By btnClose = By.xpath("//a[@title='Close']");
		public void ClosePopUp() {
			util.switchToDefaultContent();
			util.dummyWait(2);
			util.click(btnClose);
		}
		
		 public void AddNewTemplate(Map<String, String> map, String testcaseName) {
				try {
					NavigateToTemplates();
					log("STEP 1: Add template will display with blank fields", Status.PASS);
				} catch (Exception e) {
					log("STEP 1:  Template does not appear with Blank fields ", Status.FAIL);
					throw new RuntimeException("Failed in step 1: ");
				}

				try {
					ClickOnAddNewRecord();
					log("STEP 2:  When User can select any template & click on open button that file name should be display with file name & extension  ", Status.PASS);
				} catch (Exception e) {
					log("STEP 2:  User is unable to  select any template ", Status.FAIL);
					throw new RuntimeException("Failed in step 2");
				}
				try {
					uploadFile();
					log("STEP 3: User can click on the Select document button   ", Status.PASS);
				} catch (Exception e) {
					log("STEP 3: User cannot see the Select document button ", Status.FAIL);
					throw new RuntimeException("Failed in step 3");
				}
				
				try {
					ClickOnActiveCheckbox();
					log("STEP 4: When user click Checkbox should be selected. ", Status.PASS);
				} catch (Exception e) {
					log("STEP 4:  when user click  Checkbox should be deselected. ", Status.FAIL);
					throw new RuntimeException("Failed in step 4");
				}
				
				try {
					AddDisplayName(map.get(Excel.DisplayName));
					templateName =map.get(Excel.DisplayName);
					log("STEP 5: Enter value in Display Name  ", Status.PASS);
				} catch (Exception e) {
					log("STEP 5: User is unable to enter value.", Status.FAIL);
					throw new RuntimeException("Failed in step 5");
				}
				
				try {
					SelectScreenOption();
					log("STEP 6: Template will display in selected location  ", Status.PASS);
				} catch (Exception e) {
					log("STEP 6: Template will not display in selected location ", Status.FAIL);
					throw new RuntimeException("Failed in step 6");
				}
				
				try {
					SelectUserRole(map.get(Excel.UserRoles));
					log("STEP 7:  User  can select  value  from the User Roles DD ", Status.PASS);
				} catch (Exception e) {
					log("STEP 7:   User  cannot select  value  from the User Roles DD", Status.FAIL);
					throw new RuntimeException("Failed in step 7");
				}
				
				try {
					ClickOnGlobalRadioButton();
					log("STEP 8:  User can select the gloabal option ", Status.PASS);
				} catch (Exception e) {
					log("STEP 8:   User  cannot select  global option ", Status.FAIL);
					throw new RuntimeException("Failed in step 8");
				}
				
				try {
					ClickOnLoadDoument();
					log("STEP 9: User can click on load document button. ", Status.PASS);
				} catch (Exception e) {
					log("STEP 9:  User cannot click on load document button.", Status.FAIL);
					throw new RuntimeException("Failed in step 9");
				}
				
				try {
					util.waitUntilElementDisplay(SuccessMessage);
					Assert.assertTrue(util.isElementPresent(SuccessMessage));
					log("STEP 10: User can see the success message ", Status.PASS);
				} catch (AssertionError e) {
					log("STEP 10:  User cannot see the success message", Status.FAIL);
				}
				
				ClosePopUp();
				util.dummyWait(3);				
		 }
		
}
