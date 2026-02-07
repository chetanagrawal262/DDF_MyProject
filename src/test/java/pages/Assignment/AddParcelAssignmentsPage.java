package pages.Assignment;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

public class AddParcelAssignmentsPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;
	public static String PARCEL_NUMBER, AGENT_NAME, ROLE;

	public AddParcelAssignmentsPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		
	}
	
	By drpAgents = By.xpath("//input[contains(@id,'_MSUSERS_MSDropDown_Input') and @type='text']");
    By drpAgentsDot = By.xpath("//input[contains(@id,'_MSUSERS_YALComboBox_Input') and @type='text']");
    By drpAgentRow = By.xpath("//input[contains(@id,'_MSUSERS1_YALComboBox_Input')]");
    By drpAssignments = By.xpath("//input[contains(@id,'_MSASSIGNMENTS_MSDropDown_Input') and @type='text']");
    By drpAssignmentsDot = By.xpath("//input[contains(@id,'_MSASSIGNMENTS_YALComboBox_Input') and @type='text']");
    By drpAssignmentRow = By.xpath("//input[contains(@id,'_MSASSIGNMENTS_MSDropDown_Input') and @type='text']");
    By txtDueDate = By.xpath("//input[contains(@id,'_DUEDATE_dateInput') and @type='text']");
    By drpPriority = By.xpath("//input[contains(@id,'_Priority_ID_radYALDropDownList_Input') and @type='text']");
    By drpPriorityRow = By.xpath("//input[contains(@id,'_priority_id_radYALDropDownList_Input') and @type='text']");
    By btnAdd = By.xpath("//input[contains(@id,'_ImageButton1') and @type='image']");
    By successmessageforAlt = By.xpath("//span[text()='Selected users have been assigned!']");
    By successmessageforDot = By.xpath("//span[text()='Selected user(s) have been assigned!']");
  
    By navParcel = By.xpath("//span[text()='Parcel'] | //span[text()='Tract']");
	By navParcelInfo = By.xpath("//span[text()='Parcel Info'] | //span[text()='Tract Info']");
	By navAssignment = By.xpath("//div[contains(@id,'RadYALMenu')]/../..//span[text()='Assignments']");
	By navAssignmentdot = By.xpath("//div[contains(@id,'RadYALMenu')]/../..//span[text()='Assignments']");

	
	public void NavigateToAssignmentTab() {
		util.waitUntilElementDisplay(navParcel);
		util.click(navParcel);
		util.waitUntilElementDisplay(navParcelInfo);
		util.click(navParcelInfo);
		util.waitUntilElementDisplay(navAssignment);
		util.click(navAssignment);
		
	}
	
	public void NavigateToAssignmentTabDot() {
		util.waitUntilElementDisplay(navParcel);
		util.click(navParcel);
		util.waitUntilElementDisplay(navParcelInfo);
		util.click(navParcelInfo);
		util.waitUntilElementDisplay(navAssignmentdot);
		util.click(navAssignmentdot);
		
	}
    public void SelectAgentForAlt(String value) {
          if (!commonFunction.checkNA(value))
  			util.selectValueFromDropdown(drpAgents, value);
    	  util.click(drpAgents);
    	  util.pressENTERkey();
    }
    
    
    public void SelectAgentForDot(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpAgentsDot, value);
    	  util.click(drpAgentsDot);
    	  util.pressENTERkey();
    }
    
    public void SelectAgentForRow(String value) {
    	util.waitUntilElementDisplay(drpAgentRow);
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpAgentRow, value);
    	util.click(drpAgentRow);
  	  util.pressENTERkey();
    }
    
    
    By AssignmentCheckbox = By.xpath("(//input[@class='rcbCheckBox'])[2]");
    public void SelectAssignmentForAlt(String value) {
    	if (!commonFunction.checkNA(value))
			util.selectValueFromDropdown(drpAssignments, value);
    	util.click(drpAssignments);
  	  util.pressENTERkey();
    }
    
    
    public void SelectAssignmentForDot(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpAssignmentsDot, value);
    	 util.click(drpAssignmentsDot);
   	  util.pressENTERkey();
    }
    
    By AssignmentRow = By.xpath("//input[@id='ctl00_ConPHRightTop_TRAS_UC_radPanels_i1_i0_MSASSIGNMENTS_MSDropDown_Input']");
    By SelectAssignmet = By.xpath("//input[@id='ctl00_ConPHRightTop_TRAS_UC_radPanels_i1_i0_MSASSIGNMENTS_MSDropDown_i3_CheckBox']");
    By textRole = By.xpath("//input[@id='ctl00_ConPHRightTop_TRAS_UC_radPanels_i1_i0_MSASSIGNMENTS_MSDropDown_i3_CheckBox']/..");
    public void SelectAssignmentForRow() {
    	util.waitUntilElementDisplay(AssignmentRow);
    	util.click(AssignmentRow);
    	util.waitUntilElementDisplay(SelectAssignmet);
    	ROLE=driver.findElement(textRole).getText().trim();
    	log(ROLE);
    	util.click(SelectAssignmet);
    }
    
    public void AddDueDate(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtDueDate, value);
    }
    
    public void SelectPriority(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpPriority, value);
    }
    
    public void SelectPriorityRow(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpPriorityRow, value);
    }
    
    public void ClickOnAddButton() {
    	util.waitUntilElementDisplay(btnAdd);
    	util.click(btnAdd);
     	util.waitUntilElementDisplay(successmessageforAlt);
     	util.dummyWait(5);
    	Assert.assertTrue(util.isElementPresent(successmessageforAlt), "Selected users have been assigned!");
    	util.dummyWait(2);

    }
    
    public void ClickOnAddButtonForDot() {
    	util.waitUntilElementDisplay(btnAdd);
    	util.click(btnAdd);
    	util.dummyWait(10);
    	util.waitUntilElementDisplay(successmessageforDot);
    	Assert.assertTrue(util.isElementPresent(successmessageforDot), "Selected user(s) have been assigned!");
    	util.dummyWait(2);

    }
    
    public void ClickOnAddButtonForRow() {
    	util.waitUntilElementDisplay(btnAdd);
    	util.click(btnAdd);
    	util.dummyWait(2);

    }
    
    By parcelNumber = By.xpath("//input[contains(@id,'TRACT_NUMBER') and @type='text']");
    By btnDesignMode = By.xpath("//input[contains(@id,'btnDesignModeOff') and @type='image']");
	By drpUser= By.xpath("//input[contains(@id,'_YALHD_mockUserID_radYALDropDownList_Input')]");
	
    public void TurnOnDesignMode() {
    	util.waitUntilElementDisplay(btnDesignMode);
    	util.click(btnDesignMode);
    	util.waitFor(2000);
    }
   
   public void SelectUser(String value) {
		if (!commonFunction.checkNA(value)) {
				util.selectValueFromDropdown(drpUser, value);
				
			util.pressENTERkey();
			}
	  }
   
    public void AddParcelAssignments(Map<String, String> map, String testcaseName) {
    	
    	PARCEL_NUMBER = util.getAttributeValue(parcelNumber, "value");
    	
    	if(testcaseName.contains("ALT") || testcaseName.contains("ORSTED") || testcaseName.contains("ATWELL") || testcaseName.contains("ORION")) {
  	  try {
  		   SelectAgentForAlt(map.get(Excel.Agent));
  		 AGENT_NAME =map.get(Excel.Agent);
			log("STEP 1:  Selected value display in the Agents DD ", Status.PASS);
		} catch (Exception e) {
			log("STEP 1:  selected value does not display in Agents DD.", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}
  	  
  	  try {
  		   SelectAssignmentForAlt(map.get(Excel.ParcelAssignment));
  		   ROLE =map.get(Excel.ParcelAssignment);
			log("STEP 2: Selected value display in the Assignments DD ", Status.PASS);
		} catch (Exception e) {
			log("STEP 2: selected value does not display in Assignments DD.  ", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}
  	  
  	 try {
  		AddDueDate(map.get(Excel.DueDate));
			log("STEP 3: selected Due date should be display as selected ", Status.PASS);
		} catch (Exception e) {
			log("STEP 3: selected Due date does not display as selected ", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}
  	  
  	 
  	 try {
  		SelectPriority(map.get(Excel.Priority));
			log("STEP 4: Selected value display in the Priority DD  ", Status.PASS);
		} catch (Exception e) {
			log("STEP 4: selected value does not display in Priority DD.  ", Status.FAIL);
			throw new RuntimeException("Failed in step 4");
		}
  	  

  	 try {
  		ClickOnAddButton();
			log("STEP 5: Save successful message should be display above the add new button", Status.PASS);
		} catch (Exception e) {
			log("STEP 5: Save successful message does not display above the add new button ", Status.FAIL);
			throw new RuntimeException("Failed in step 5");
		} 
  	 
		try {
			TurnOnDesignMode();
			log("STEP 6:  user can turn on design mode", Status.PASS);
		} catch (Exception e) {
			log("STEP 6:  user cannot turn on design mode", Status.FAIL);
			throw new RuntimeException("Failed in step 6");
		}

		try {
			SelectUser(AGENT_NAME);
			util.waitFor(4000);
			log("STEP 7:  user can switch to assigned user", Status.PASS);
		} catch (Exception e) {
			log("STEP 7:  user cannot switch to assigned user", Status.FAIL);
			throw new RuntimeException("Failed in step 7");
		}
		
		try {
			NavigateToAssignmentTab();
			commonFunction.projectSelection();
			util.dummyWait(5);
			log("STEP 8: User can navigate to the Assignment tab  ", Status.PASS);
		} catch (Exception e) {
			log("STEP 8: Assignment tab does not load ", Status.FAIL);
			throw new RuntimeException("Failed in step 8");
		}
		
		try {
			By assignedParcel= By.xpath("(//td[text()='"+PARCEL_NUMBER.trim()+"']/parent::tr)[1]");
			util.click(assignedParcel);
			util.dummyWait(5);
			log("STEP 9: User can select the parcel from the parcel list ", Status.PASS);
		} catch (Exception e) {
			log("STEP 9: User cannot select the parcel from the parcel list", Status.FAIL);
			throw new RuntimeException("Failed in step 9");
		}
		
		try {
			By assignedAgentName= By.xpath("//tr[contains(@id,'_AGENTS_radYALGridControl')]/..//td[text()='"+AGENT_NAME+"']");
			By assignedRole= By.xpath("//tr[contains(@id,'_AGENTS_radYALGridControl')]/..//td[text()='"+AGENT_NAME+"']/..//td[text()='"+ROLE+"']");
			Assert.assertTrue(util.isElementVisible(assignedAgentName), "Agent not assigned on the parcel");
			Assert.assertTrue(util.isElementVisible(assignedRole), "Role not assigned to Agent");
			log("STEP 10: User can see assigned Agent Name and role ", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 10: User cannot see assigned Agent Name and role", Status.FAIL);
		}
		 
     }
    	
    	else if(testcaseName.contains("DOT"))
    	{
    		
    		try {
    	  		   SelectAgentForDot(map.get(Excel.Agent));
    	  		   AGENT_NAME=map.get(Excel.Agent);
    				log("STEP 1:  Selected value display in the Agents DD ", Status.PASS);
    			} catch (Exception e) {
    				log("STEP 1:  selected value does not display in Agents DD.", Status.FAIL);
    				throw new RuntimeException("Failed in step 1");
    			}
    	  	  
    	  	  try {
    	  		   SelectAssignmentForDot(map.get(Excel.ParcelAssignment));
    	  		   ROLE =map.get(Excel.ParcelAssignment);
    				log("STEP 2: Selected value display in the Assignments DD ", Status.PASS);
    			} catch (Exception e) {
    				log("STEP 2: selected value does not display in Assignments DD.  ", Status.FAIL);
    				throw new RuntimeException("Failed in step 2");
    			}
    	  	  
    	  	 try {
    	  		AddDueDate(map.get(Excel.DueDate));
    				log("STEP 3: selected Due date should be display as selected ", Status.PASS);
    			} catch (Exception e) {
    				log("STEP 3: selected Due date does not display as selected ", Status.FAIL);
    				throw new RuntimeException("Failed in step 3");
    			}
    	  	  
    	  	 
    	  	 try {
    	  		SelectPriority(map.get(Excel.Priority));
    				log("STEP 4: Selected value display in the Priority DD  ", Status.PASS);
    			} catch (Exception e) {
    				log("STEP 4: selected value does not display in Priority DD.  ", Status.FAIL);
    				throw new RuntimeException("Failed in step 4");
    			}
    	  	  

    	  	 try {
    	  		ClickOnAddButtonForDot();
    				log("STEP 5: Save successful message should be display above the add new button", Status.PASS);
    			} catch (Exception e) {
    				log("STEP 5: Save successful message does not display above the add new button ", Status.FAIL);
    				throw new RuntimeException("Failed in step 5");
    			} 
    	  	 
    	  	try {
    			TurnOnDesignMode();
    			log("STEP 6:  user can turn on design mode", Status.PASS);
    		} catch (Exception e) {
    			log("STEP 6:  user cannot turn on design mode", Status.FAIL);
    			throw new RuntimeException("Failed in step 6");
    		}

    		try {
    			SelectUser(AGENT_NAME);
    			util.dummyWait(1);
    			log("STEP 7:  user can switch to assigned user", Status.PASS);
    		} catch (Exception e) {
    			log("STEP 7:  user cannot switch to assigned user", Status.FAIL);
    			throw new RuntimeException("Failed in step 7");
    		}
    		
    		try {
    			NavigateToAssignmentTab();
    			commonFunction.projectSelection();
    			util.dummyWait(5);
    			log("STEP 8: User can navigate to the Assignment tab  ", Status.PASS);
    		} catch (Exception e) {
    			log("STEP 8: Assignment tab does not load ", Status.FAIL);
    			throw new RuntimeException("Failed in step 8");
    		}
    		
    		try {
    			By assignedParcel= By.xpath("(//td[text()='"+PARCEL_NUMBER.trim()+"']/parent::tr)[1]");
    			util.click(assignedParcel);
    			util.dummyWait(5);
    			log("STEP 9: User can select the parcel from the parcel list ", Status.PASS);
    		} catch (Exception e) {
    			log("STEP 9: User cannot select the parcel from the parcel list", Status.FAIL);
    			throw new RuntimeException("Failed in step 9");
    		}
    		
    		try {
    			By assignedAgentName= By.xpath("(//tr[contains(@id,'_AGENTS_radYALGridControl')]/..//td[text()='"+ROLE+"']/..//td[text()='"+AGENT_NAME+"'])[1]");
    			By assignedRole= By.xpath("(//tr[contains(@id,'_AGENTS_radYALGridControl')]/..//td[text()='"+AGENT_NAME+"']/..//td[text()='"+ROLE+"'])[1]");
    			Assert.assertTrue(util.isElementVisible(assignedAgentName), "Agent not assigned on the parcel");
    			Assert.assertTrue(util.isElementVisible(assignedRole), "Role not assigned to Agent");
    			log("STEP 10: User can see assigned Agent Name and role ", Status.PASS);
    		} catch (AssertionError e) {
    			log("STEP 10: User cannot see assigned Agent Name and role", Status.FAIL);
    		}
    	  	 
    	}
    	
    	else {
    		

    		try {
    			SelectAgentForRow(map.get(Excel.Agent));
    			AGENT_NAME=map.get(Excel.Agent);
    				log("STEP 1:  Selected value display in the Agents DD ", Status.PASS);
    			} catch (Exception e) {
    				log("STEP 1:  selected value does not display in Agents DD.", Status.FAIL);
    				throw new RuntimeException("Failed in step 1");
    			}
    	  	  
    	  	  try {
    	  		SelectAssignmentForRow();
    				log("STEP 2: Selected value display in the Assignments DD ", Status.PASS);
    			} catch (Exception e) {
    				log("STEP 2: selected value does not display in Assignments DD.  ", Status.FAIL);
    				throw new RuntimeException("Failed in step 2");
    			}
    	  	  
    	  	 try {
    	  		AddDueDate(map.get(Excel.DueDate));
    				log("STEP 3: selected Due date should be display as selected ", Status.PASS);
    			} catch (Exception e) {
    				log("STEP 3: selected Due date does not display as selected ", Status.FAIL);
    				throw new RuntimeException("Failed in step 3");
    			}
    	  	  
    	  	 
    	  	 try {
    	  		SelectPriorityRow(map.get(Excel.Priority));
    				log("STEP 4: Selected value display in the Priority DD  ", Status.PASS);
    			} catch (Exception e) {
    				log("STEP 4: selected value does not display in Priority DD.  ", Status.FAIL);
    				throw new RuntimeException("Failed in step 4");
    			}
    	  	  

    	  	 try {
    	  		ClickOnAddButtonForRow();
    				log("STEP 5: Save successful message should be display above the add new button", Status.PASS);
    			} catch (Exception e) {
    				log("STEP 5: Save successful message does not display above the add new button ", Status.FAIL);
    				throw new RuntimeException("Failed in step 5");
    			} 
    	  	 
    	  	try {
    			TurnOnDesignMode();
    			log("STEP 6:  user can turn on design mode", Status.PASS);
    		} catch (Exception e) {
    			log("STEP 6:  user cannot turn on design mode", Status.FAIL);
    			throw new RuntimeException("Failed in step 6");
    		}

    		try {
    			SelectUser(AGENT_NAME);
    			util.dummyWait(1);
    			log("STEP 7:  user can switch to assigned user", Status.PASS);
    		} catch (Exception e) {
    			log("STEP 7:  user cannot switch to assigned user", Status.FAIL);
    			throw new RuntimeException("Failed in step 7");
    		}
    		
    		try {
    			NavigateToAssignmentTab();
    			commonFunction.projectSelection();
    			util.dummyWait(5);
    			log("STEP 8: User can navigate to the Assignment tab  ", Status.PASS);
    		} catch (Exception e) {
    			log("STEP 8: Assignment tab does not load ", Status.FAIL);
    			throw new RuntimeException("Failed in step 8");
    		}
    		
    		try {
    			By assignedParcel= By.xpath("(//td[text()='"+PARCEL_NUMBER.trim()+"']/parent::tr)[1]");
    			util.click(assignedParcel);
    			util.dummyWait(5);
    			log("STEP 9: User can select the parcel from the parcel list ", Status.PASS);
    		} catch (Exception e) {
    			log("STEP 9: User cannot select the parcel from the parcel list", Status.FAIL);
    			throw new RuntimeException("Failed in step 9");
    		}
    		
    		try {
    			By assignedAgentName= By.xpath("(//tr[contains(@id,'_AGENTS_radYALGridControl')]/..//td[text()='"+ROLE+"']/..//td[text()='"+AGENT_NAME+"'])[1]");
    			By assignedRole= By.xpath("(//tr[contains(@id,'_AGENTS_radYALGridControl')]/..//td[text()='"+AGENT_NAME+"']/..//td[text()='"+ROLE+"'])[1]");
    			Assert.assertTrue(util.isElementVisible(assignedAgentName), "Agent not assigned on the parcel");
    			Assert.assertTrue(util.isElementVisible(assignedRole), "Role not assigned to Agent");
    			log("STEP 10: User can see assigned Agent Name and role ", Status.PASS);
    		} catch (AssertionError e) {
    			log("STEP 10: User cannot see assigned Agent Name and role", Status.FAIL);
    		}
    	  	 
    	}
    	
   }
	
}
