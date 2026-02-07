package pages.EncroachmentRequests;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

public class EncroachmentAssignmentsPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;
	public static String AGENT_NAME, ROLE;

	public EncroachmentAssignmentsPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		
	}
	
	By panelAssignment = By.xpath("//a[contains(@class,'rpExpandable ')]/../..//span[text()='Assignments']");
	By drpRole = By.xpath("//input[contains(@id,'_cbRole_Input') and @type='text']");
    By drpAssignedTo = By.xpath("//input[contains(@id,'_cbAssignedTo') and @type='text']");
    By drpStatus = By.xpath("//input[contains(@id,'_ddlTAStatus_radYALDropDownList_Input') and @type='text']");
    By txtDueDate = By.xpath("//input[contains(@id,'_rdpTADueDate_dateInput') and @type='text']");
    By btnAdd = By.xpath("//input[contains(@id,'_btnAssignTicket') and @type='image']");
    By successMessage = By.xpath("//span[text()='Selected queue/ user  assigned to ticket.']");
    
    
    By txtExtentedDate = By.xpath("//input[contains(@id,'_EditFormControl_rdpExtendedDate_dateInput') and @type='text']");
    By txtDateCompleted = By.xpath("//input[contains(@id,'_EditFormControl_rdpDateCompleted_dateInput') and @type='text']");
    By drpPriority = By.xpath("//input[contains(@id,'EditFormControl_ddlPriority_radYALDropDownList_Input') and @type='text']");
    By txtComments = By.xpath("//textarea[contains(@id,'_EditFormControl_txtComments')]");
    By btnUpdate = By.xpath("//input[contains(@id,'_EditFormControl_btnUpdate')]");
    By changesSavedSuccessfully = By.xpath("//span[text()='Changes saved successfully!']");
    
    
	public void ExpandAssignmentPanel() {
		util.waitUntilElementDisplay(panelAssignment);
		util.click(panelAssignment);
		util.waitFor(200);
	}
    
	public void SelectRole(String value) {
		if (!commonFunction.checkNA(value))
			util.click(drpRole);
		util.waitFor(200);
		By selectValue = By.xpath("//div[contains(@id,'_cbRole_DropDown')]/..//li[text()='" + value + "']");
		util.click(selectValue);
		util.waitUntilPageLoad();
	}
    
	public void SelectAssignedTo(String value) {
		if (!commonFunction.checkNA(value))
			util.click(drpAssignedTo);
		By selectValue = By.xpath("//div[contains(@id,'_cbAssignedTo_DropDown')]/..//li[text()='" + value + "']");
		util.click(selectValue);
	}
	
    public void selectStatus(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpStatus, value);
    }
    
    public void AddDueDate(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtDueDate, value);
    }
    
    public void ClickOnAdd() {
    	util.waitUntilElementDisplay(btnAdd);
    	util.click(btnAdd);
    	util.waitUntilPageLoad();
    	util.dummyWait(1);
    }
    
    public void AddExtentedDate(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtExtentedDate, value);
    }
    
    public void AddDateCompleted(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtDateCompleted, value);
    }
    
    public void AddPriority(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpPriority, value);
    }
    
    public void AddComment(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtComments, value);
    }
    
    public void ClickOnUpdate() {
    	util.waitUntilElementDisplay(btnUpdate);
    	util.click(btnUpdate);
    	util.waitUntilLoaderDisappear();
    	util.dummyWait(1);
    }
    
    
	public void AddAssignments(Map<String, String> map, String testcaseName) {

		try {
			ExpandAssignmentPanel();
			log("STEP 1:  User can expand Assignment Panel ", Status.PASS);
		} catch (Exception e) {
			log("STEP 1:  selected value does not display in Agents DD.", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}

		try {
			SelectRole(map.get(Excel.Roles));
			ROLE =map.get(Excel.Roles);
			log("STEP 2: User can select Role ", Status.PASS);
		} catch (Exception e) {
			log("STEP 2: User cannot select Role ", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}
    	 
		try {
			SelectAssignedTo(map.get(Excel.AssignedTo));

			String original = map.get(Excel.AssignedTo);
			String[] parts = original.split(",");
			AGENT_NAME = parts[1].trim() + ", " + parts[0].trim();
			log("STEP 3: User can select Assigned To ", Status.PASS);
		} catch (Exception e) {
			log("STEP 3: User cannot select Assigned To ", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}
		
		try {
			selectStatus(map.get(Excel.Status));
			log("STEP 4: User can select Status ", Status.PASS);
		} catch (Exception e) {
			log("STEP 4: User cannot select Status ", Status.FAIL);
			throw new RuntimeException("Failed in step 4");
		}

		try {
			AddDueDate(map.get(Excel.DueDate));
			log("STEP 5: User can enter Due Date ", Status.PASS);
		} catch (Exception e) {
			log("STEP 5: User cannot enter Due Date ", Status.FAIL);
			throw new RuntimeException("Failed in step 5");
		}

		try {
			ClickOnAdd();
			log("STEP 5: User can click on Add Button", Status.PASS);
		} catch (Exception e) {
			log("STEP 5: User cannot click on Add Button ", Status.FAIL);
			throw new RuntimeException("Failed in step 5");
		}
		
		try {
			Assert.assertTrue(util.isElementVisible(successMessage));
			log("STEP 6: User can see Success Message ", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 6: User cannot see Success Message", Status.FAIL);
		}
    	  	
		try {
			By assignedAgentName= By.xpath("(//tr[contains(@id,'_yalticketassignedlandownerhotline_radYALGridControl')]/..//td[text()='"+AGENT_NAME+"'])[1]");
			Assert.assertTrue(util.isElementVisible(assignedAgentName));
			log("STEP 7: User can see assigned Agent Name in the grid view ", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 7: User cannot see assigned Agent Name in the grid view", Status.FAIL);
		}
		
		try {
			By status= By.xpath("(//tr[contains(@id,'_yalticketassignedlandownerhotline_radYALGridControl')]/..//td[text()='"+AGENT_NAME+"']/..//td[text()='"+map.get(Excel.Status)+"'])[1]");
			Assert.assertTrue(util.isElementVisible(status));
			log("STEP 8: User can see assigned Status in the grid view ", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 8: User cannot see assigned Status in the grid view", Status.FAIL);
		}
		
		try {
			By dueDate= By.xpath("(//tr[contains(@id,'_yalticketassignedlandownerhotline_radYALGridControl')]/..//td[text()='"+AGENT_NAME+"']/..//td[text()='"+map.get(Excel.DueDate)+"'])[1]");
			Assert.assertTrue(util.isElementVisible(dueDate));
			log("STEP 9: User can see assigned Due Date in the grid view ", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 9: User cannot see assigned Due Date in the grid view", Status.FAIL);
		}
		
    	  	
   }
	
	public void EditAssignments(Map<String, String> map, String testcaseName) {

		try {
			By edit= By.xpath("(//tr[contains(@id,'_yalticketassignedlandownerhotline_radYALGridControl')]/..//td[text()='"+AGENT_NAME+"']/..//input[@title='Edit'])[1]");
			util.click(edit);
			util.waitUntilLoaderDisappear();
			log("STEP 1:  User can click on Edit Icon", Status.PASS);
		} catch (Exception e) {
			log("STEP 1:  User cannot click on Edit Icon", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}

		try {
			By queue= By.xpath("//input[contains(@id,'_EditFormControl_ddlQueue_radYALDropDownList_Input') and @type='text' and @value='"+ROLE+"']");
			Assert.assertTrue(util.isElementVisible(queue));
			log("STEP 2: User can see selected Role in the Queue dd", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 2: User cannot see selected Role in the Queue dd", Status.FAIL);
		}
    	 
		try {
			AddExtentedDate(map.get("ExtentedDate"));
			log("STEP 3: User can enter Extented Date ", Status.PASS);
		} catch (Exception e) {
			log("STEP 3: User cannot enter Extented Date", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}
		
		try {
			AddDateCompleted(map.get("DateCompleted"));
			log("STEP 4: User can enter Date Completed ", Status.PASS);
		} catch (Exception e) {
			log("STEP 4: User cannot enter Date Completed ", Status.FAIL);
			throw new RuntimeException("Failed in step 4");
		}

		try {
			AddPriority(map.get(Excel.Priority));
			log("STEP 5: User can select Priotiy ", Status.PASS);
		} catch (Exception e) {
			log("STEP 5: User cannot select Priotiy ", Status.FAIL);
			throw new RuntimeException("Failed in step 5");
		}

		try {
			AddComment(map.get(Excel.Comment));
			log("STEP 6: User can enter Comment ", Status.PASS);
		} catch (Exception e) {
			log("STEP 6: User cannot enter Comment ", Status.FAIL);
			throw new RuntimeException("Failed in step 6");
		}
		
		try {
			ClickOnUpdate();
			log("STEP 7: User can click on Update Button", Status.PASS);
		} catch (Exception e) {
			log("STEP 7: User cannot click on Update Button ", Status.FAIL);
			throw new RuntimeException("Failed in step 7");
		}
		
		try {
			Assert.assertTrue(util.isElementVisible(changesSavedSuccessfully));
			log("STEP 8: User can see Success Message ", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 8: User cannot see Success Message", Status.FAIL);
		}
    	  	
		try {
			By extentedDate= By.xpath("(//tr[contains(@id,'_yalticketassignedlandownerhotline_radYALGridControl')]/..//td[text()='"+AGENT_NAME+"']/..//td[text()='"+map.get("ExtentedDate")+"'])[1]");
			Assert.assertTrue(util.isElementVisible(extentedDate));
			log("STEP 9: User can see updated Extented Date in the grid view ", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 9: User cannot see updated Extented Date in the grid view", Status.FAIL);
		}
		
		try {
			By dateCompleted= By.xpath("(//tr[contains(@id,'_yalticketassignedlandownerhotline_radYALGridControl')]/..//td[text()='"+AGENT_NAME+"']/..//td[text()='"+map.get("DateCompleted")+"'])[1]");
			Assert.assertTrue(util.isElementVisible(dateCompleted));
			log("STEP 10: User can see updated Date Completed in the grid view ", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 10: User cannot see updated Date Completed  in the grid view", Status.FAIL);
		}
		
		try {
			By priority= By.xpath("(//tr[contains(@id,'_yalticketassignedlandownerhotline_radYALGridControl')]/..//td[text()='"+AGENT_NAME+"']/..//td[text()='"+map.get(Excel.Priority)+"'])[1]");
			Assert.assertTrue(util.isElementVisible(priority));
			log("STEP 11: User can see updated Priority in the grid view ", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 11: User cannot see updated Priority  in the grid view", Status.FAIL);
		}
		
		try {
			By Comments= By.xpath("(//tr[contains(@id,'_yalticketassignedlandownerhotline_radYALGridControl')]/..//td[text()='"+AGENT_NAME+"']/..//td[text()='"+map.get(Excel.Comment)+"'])[1]");
			Assert.assertTrue(util.isElementVisible(Comments));
			log("STEP 12: User can see updated Comments in the grid view ", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 12: User cannot see updated Comments  in the grid view", Status.FAIL);
		}
		
    	  	
   }
	
}
