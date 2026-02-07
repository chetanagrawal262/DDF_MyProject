package page.toolsMyDashboard;

import static org.testng.Assert.assertEquals;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;
import extentReports.ExtentTestManager;

public class MyDashboardPage extends BasePage {

	TestUtil util;
	CommonFunction commonFunction;

	public MyDashboardPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}

	By navTool = By.xpath("*//a//span[@class='rmText rmExpandDown' and contains(text(),'Tools')] ");
	By navMyDashBoard = By.xpath("*//a//span[contains(text(),'Project Group') or contains(text(),'My Dashboard')] ");

	public void navigateToMyDashBoard() {
		util.waitUntilElementDisplay(navTool);
		util.click(navTool);
		util.waitUntilElementDisplay(navMyDashBoard);
		util.click(navMyDashBoard);
	}

	By firstCheckBox = By
			.xpath("//input[contains(@id,'ctl00_ConPHRightTop_YALCOM_InMessages_RadGrid1_ctl00_ctl04_CheckBox1')]");

	public void clickOnFirstCheckBox() {
		util.waitUntilElementDisplay(firstCheckBox);
		util.click(firstCheckBox);
		util.dummyWait(1);
	}

	By linkExcelIcon = By.xpath("//input[contains(@id,'ExportToExcelButton')]");

	public void clickOnExcelIcon() {
		util.waitUntilElementDisplay(linkExcelIcon);
		util.click(linkExcelIcon);
	}

	By linkCSVIcon = By.xpath("//input[contains(@id,'ExportToCsvButton')]");

	public void clickOnCSVIcon() {
		util.waitUntilElementDisplay(linkCSVIcon);
		util.click(linkCSVIcon);
	}

	By linkWordIcon = By.xpath("//input[contains(@id,'ExportToWordButton')]");

	public void clickOnWordIcon() {
		util.waitUntilElementDisplay(linkWordIcon);
		util.click(linkWordIcon);
	}

	By linkMessage = By.xpath("//*[contains(@id,'ctl00_ConPHRightTop_YALCOM_InMessages_RadGrid1_ctl00')]/td[3]/strong[1]/a");

	public void clickOnClickHereLink() {
		try {
			util.isElementPresent(linkMessage);
			util.click(linkMessage);
			ExtentTestManager.pass("Link is present inside Message");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			ExtentTestManager.pass("Link is not present inside Message");
		}

	}
	private void verifyMultipleWindow() {
		String parentWindow = driver.getWindowHandle();
		Set<String> allWindow = driver.getWindowHandles();
		if (allWindow.size() > 1) {
			for (String currentWindow : allWindow) {
				if (!currentWindow.equals(parentWindow)) {
					driver.switchTo().window(currentWindow);
					driver.close();
				}
			}
			driver.switchTo().window(parentWindow);
		}
	}

	public void verifyInboxDetails(Map<String, String> map, String testcaseName) {
		try {
			navigateToMyDashBoard();
			log("STEP 1:  Navigate to Tool - My Dashboard", Status.PASS);
		} catch (Exception e) {
			log("STEP 1:   User not Navigated to Tool - My Dashboard", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}
		try {
			clickOnFirstCheckBox();
			log("STEP 2:  User can able to select the message information checkbox :", Status.PASS);
		} catch (Exception e) {
			log("STEP 2:  User not able to select the message information checkbox :", Status.FAIL);
			throw new RuntimeException("STEP 2:  User not able to select the message information checkbox :");
		}
		try {
			Assert.assertTrue(util.isElementVisible(linkExcelIcon));
			log("STEP 3:  User can able to see on Excel icon :", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 3:  User not able to see on Excel icon :", Status.FAIL);
			
		}
		try {
			Assert.assertTrue(util.isElementVisible(linkCSVIcon));
			log("STEP 4:  User can able to see on CSV icon :", Status.PASS);
		} catch (Exception e) {
			log("STEP 4:  User not able to see on CSV icon :", Status.FAIL);
			
		}
		try {
			Assert.assertTrue(util.isElementVisible(linkWordIcon));
			log("STEP 5:  User can able to see on Word icon :", Status.PASS);
		} catch (Exception e) {
			log("STEP 5:  User not able to see on Word icon :", Status.FAIL);
			
		}
		try {
			clickOnClickHereLink();
			util.dummyWait(3);	
			verifyMultipleWindow();
			log("STEP 6:  User can able to click on Click here link :", Status.PASS);
		} catch (Exception e) {
			log("STEP 6:  User not able to click on Click here link  :", Status.FAIL);
			throw new RuntimeException("STEP 6:  User not able to click on Click here link  :");
		}
	}

	By btnAcknowledge = By.xpath("//input[contains(@id,'btnAcknowledge')]");
	By getAcknowledgeDateorg = By.xpath(
			"//tr[@id='ctl00_ConPHRightTop_YALCOM_InMessages_RadGrid1_ctl00__0']//*[text()='Acknowledgement : ']//br[2]//following::strong[1]");

	By getAcknowledgeDate = By.xpath(
			"//tr[@id='ctl00_ConPHRightTop_YALCOM_InMessages_RadGrid1_ctl00__0']//strong[3]");
	public void clickOnAcknowledge() {
		util.waitUntilElementDisplay(btnAcknowledge);
		util.click(btnAcknowledge);
	}
	
	public void verifyAcknowledgementDate() {
		util.waitUntilElementDisplay(getAcknowledgeDate);
		String AcknowledegDate = util.getText(getAcknowledgeDate);
		if(!AcknowledegDate.contains("N/A")) {
		DateFormat date = new SimpleDateFormat("MM/dd/yyyy");
		String ExpectedDate = date.format(new Date());
		assertEquals(AcknowledegDate, ExpectedDate, "Acknowledge Date match in Message details");
		}else {
			log("Acknowledgement Date is not applicable for this notification", Status.SKIP);
		}
	}

	public void verifyInboxAcknowledge(Map<String, String> map, String testcaseName) {
	
		try {
			util.dummyWait(2);
			navigateToMyDashBoard();
			log("STEP 1:  User can navigate to My Dashboard page", Status.PASS);
		} catch (Exception e) {
			log("STEP 1:  User cannot navigate to My Dashboard page", Status.FAIL);
			throw new RuntimeException("Failed in Step 1");
		}
		
		try {
			clickOnFirstCheckBox();
			log("STEP 2:  User can select message to acknowledge", Status.PASS);
		} catch (Exception e) {
			log("STEP 2:  User cannot select message to acknowledge", Status.FAIL);
			throw new RuntimeException("Failed in Step 2");
		}
		try {
			clickOnAcknowledge();
			log("STEP 3:  User can able to click on Acknowledge button", Status.PASS);
		} catch (Exception e) {
			log("STEP 3:  User not able to click on Acknowledge button", Status.FAIL);
			throw new RuntimeException("Failed in Step 3");
		}
		
		try {
			verifyAcknowledgementDate();
			log("STEP 4:  User can verify Acknowledgement Date", Status.PASS);
		} catch (Exception e) {
			log("STEP 4:  User cannot verify Acknowledgement Date", Status.FAIL);
			throw new RuntimeException("Failed in Step 4");
		}
	}

	By tabOutbox = By.xpath("//*[text()='Outbox']");

	public void clickOnOutBox() {
		util.waitUntilElementDisplay(tabOutbox);
		util.click(tabOutbox);
	}
	
	By txtClickHere = By.xpath("(//*[normalize-space()='here'])[1]");
	By ClickHereLink = By.xpath("//*[contains(@id,'OutMessage')]/td[3]/a");
	public void clickOnHere() {
		try {
			util.isElementPresent(ClickHereLink);
			util.click(ClickHereLink);
			ExtentTestManager.pass("Link is present inside Message");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			ExtentTestManager.pass("Link is not present inside Message");
		}
	}

	
	public void verifyOutbox(Map<String, String> map, String testcaseName) {
		try {
			util.dummyWait(1);
			clickOnOutBox();
			log("STEP 1:  User can click on Outbox Tab", Status.PASS);
		} catch (Exception e) {
			log("STEP 1:   User cannot click on Outbox Tab", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}
		try {
			clickOnHere();
			util.dummyWait(3);
			verifyMultipleWindow();
			log("STEP 2:  User can able click on Click Here :", Status.PASS);
		} catch (Exception e) {
			log("STEP 2:  User can not able click on Click Here :", Status.FAIL);
			throw new RuntimeException("STEP 2:  User can not able click on Click Here :");
		}

		String title=driver.getTitle();
		
	if(!title.contains("My Dashboard")) {
		driver.navigate().back();
		driver.navigate().refresh();
		util.waitFor(200);
	}
	}
	
	By tabNewMessage = By.xpath("//*[text()='New Message']");
	public void clickOnNewMessage() {
		util.waitUntilElementDisplay(tabNewMessage);
		util.click(tabNewMessage);
	}
	
	By sendCommunication = By.xpath("(//*[@id='ctl00_ConPHRightTop_YALCOM_Receiving_Agent_ID_radYALListBox']/..//input)[1]");
	public void clickOnSendCommunication(String value) {
		By sendCommunication = By.xpath("//*[text()='"+value+"']/preceding-sibling::input");
		util.click(sendCommunication);
		
	}
	By selectOne = By.xpath("//input[@id='ctl00_ConPHRightTop_YALCOM_Message_Priority_ID_radYALDropDownList_Input']");
	public void setSelectOne(String value) {
		util.waitUntilElementDisplay(selectOne);
		util.inputTextAndPressTab(selectOne, value);
	}
	By switchContentFrame = By.xpath("//iframe[@id='ctl00_ConPHRightTop_YALCOM_Message_Text_contentIframe']");
	public void switchToContentFrame() {
		util.waitUntilElementDisplay(switchContentFrame);
		util.switchToIframe(switchContentFrame);
	}
	//By txtSendMessage = By.xpath("//iframe[@id='ctl00_ConPHRightTop_YALCOM_Message_Text_contentIframe']//following-sibling::*");
	By txtSendMessage = By.xpath("//body");
	public void setSendMessage(String value) {
		util.waitUntilElementDisplay(txtSendMessage);
		util.inputText(txtSendMessage, value);
	}
	
	By btnPublish = By.xpath("//input[contains(@id,'SendCommunication')]");
	public void clickOnPublish() {
		util.waitUntilElementDisplay(btnPublish);
		util.click(btnPublish);
	}
	
	By btnDesignMode = By.xpath("//input[contains(@id,'btnDesignModeOff') and @type='image']");
	By drpUser= By.xpath("//input[contains(@id,'_YALHD_mockUserID_radYALDropDownList_Input')]");
	 public void TurnOnDesignMode() {
		 util.waitUntilPageLoad();
	    	util.waitUntilElementDisplay(btnDesignMode);
	    	util.click(btnDesignMode);
	    	util.dummyWait(2);
	    }
	   
	   public void SelectUser(String value) {
			if (!commonFunction.checkNA(value)) {
					util.selectValueFromDropdown(drpUser, value);
					
				util.pressENTERkey();
				}
		  }
	   
	public void addNewMessage(Map<String, String> map, String testcaseName) {
		try {
			navigateToMyDashBoard();
			util.dummyWait(1);
			clickOnNewMessage();
			log("STEP 1:  Navigate to Tool - My Dashboard - NewMessage", Status.PASS);
		} catch (Exception e) {
			log("STEP 1:   User cannot Navigate to Tool - My Dashboard - NewMessage", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}
		try {
			clickOnSendCommunication(map.get(Excel.SendCommunication));
			log("STEP 2:  User can enter Send Communication", Status.PASS);
		} catch (Exception e) {
			log("STEP 2:  User can not enter Send Communication", Status.FAIL);
			throw new RuntimeException("STEP 2:  User can not enter Send Communication :");
		}
		try {
			setSelectOne(map.get(Excel.SelectOne));
			log("STEP 3:  User can able select SelectOne", Status.PASS);
		} catch (Exception e) {
			log("STEP 3: User can not able  SelectOne", Status.FAIL);
			throw new RuntimeException("STEP 3: User can not able  SelectOne :");
		}
		try {
			switchToContentFrame();
			setSendMessage(map.get(Excel.Message));
			util.switchToDefaultContent();
			log("STEP 4:  User can able enter Message", Status.PASS);
		} catch (Exception e) {
			log("STEP 4: User can not able enter Message", Status.FAIL);
			throw new RuntimeException("STEP 4: User can not able enter Message :");
		}
		try {
			clickOnPublish();
			log("STEP 5:  User can able click on Publish", Status.PASS);
		} catch (Exception e) {
			log("STEP 5: User can not able click on Publish", Status.FAIL);
			throw new RuntimeException("STEP 5: User can not able click on Publish :");
		}

		try {
			TurnOnDesignMode();
			log("STEP 6:  user can turn on design mode", Status.PASS);
		} catch (Exception e) {
			log("STEP 6:  user cannot turn on design mode", Status.FAIL);
			throw new RuntimeException("Failed in step 5");
		} 
		
		try {
        	SelectUser(map.get(Excel.SendCommunication));
			log("STEP 7: User can switch the selected Agent", Status.PASS);
		} catch (Exception e) {
			log("STEP 7:  User cannot switch the selected Agent ", Status.FAIL);
			throw new RuntimeException("Failed in step 6");
		} 
		
		util.dummyWait(2);
		try {
			By drpUser= By.xpath("//strong[text()='"+map.get(Excel.Message)+"']");
			Assert.assertTrue(util.isElementVisible(drpUser));
			log("STEP 8:  User can see the sent message in receivers Inbox", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 8:  User cannot see the sent message in receivers Inbox", Status.FAIL);
			throw new RuntimeException("Failed in step 8");
		}
	}

}
