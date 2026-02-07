package pages.Project;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

public class AddProjectAssignmentPage extends BasePage {

	TestUtil util;
	CommonFunction commonFunction;
	String userName, userRole, updatedRole;

	public AddProjectAssignmentPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}

	By addProjectAssigment = By.xpath("//a[normalize-space()='Project Assignments'] | //a[normalize-space()='Project Team']");
	By drpSelectUser = By.xpath("//input[contains(@id,'USERS_YALComboBox_Input')]");
	By drpSelectUserOsted = By.xpath("//input[contains(@id,'YALComboBox_Input')]");
	By drpSelectRole = By.xpath("//input[contains(@id,'PrjRole_radYALDropDownList_Input')]");
	By drpSelectAgent = By.xpath("(//div[contains(@id,'ProjectAssignments_DDTMsUsers_RadDropDownTree1')])[2]");
	By btnAddDOT = By.xpath("//input[contains(@name,'ProjectAssignment$AddBulkUsers')]");
	By btnAdd = By.xpath("//input[@alt='Add']");
	By btnUpdate = By.xpath("//input[contains(@id,'EditFormControl_btnUpdate')]");
	By btnEdit = By.xpath("//td[contains(text(),'%s')]/parent::tr/td");
	By drpEdituser = By.xpath("//input[contains(@id,'EditFormControl_USER_ID_radYALDropDownList_Input')]");
	By drpEditRole = By.xpath("//input[contains(@id,'EditFormControl_PROJECT_ROLE_ID_radYALDropDownList_Input')]");
	By drpEditAgent = By.xpath("//input[contains(@id,'EditFormControl_USER_ID_radYALDropDownList_Input')]");
	By sideclick = By.xpath("//a[normalize-space()='Project Assignments']//following::tr[1]");
	String tableValue = "//table//tbody//tr//td[text()='%s']";
	By drpUserClose = By.xpath(
			"//a[contains(@id,'ProjectAssignment_MSUSERS_YALComboBox_Arrow')]");

	By addUser = By.xpath("//input[contains(@id,'YALComboBox_Input')]");
	By closeUser = By.xpath("//a[contains(@id,'USERS_YALComboBox_Arrow')]");
	//By closeUser = By.xpath("//a[contains(@id,'YALComboBox_Arrow')]");
	
	By clickOnAgent = By.xpath("//span[text()='Select Agents']");
	By addAgent = By.xpath("(//input[contains(@value,'Filtering...')])[1]");
	By closeAgent = By.xpath("//div[contains(@id,'_ProjectAssignments_DDTMsUsers_RadDropDownTree1')]//span[@class='rddtIcon']");
	By expandAgent = By.xpath("//span[@class='rtPlus']");
	By secondAgent = By.xpath("(//span[@class='rtIn'])[2]");
	By firstAgent = By.xpath("(//span[@class='rtMinus']/../..//span[@class='rtIn'])[2]");
	By checkboxActive = By.xpath("//input[contains(@id,'_EditFormControl_ACTIVE_IND')]");
	By checkboxActiveChecked = By.xpath("//input[contains(@id,'_EditFormControl_ACTIVE_IND') and @checked='checked']");
	By checkboxViewAllAssignment = By.xpath("//input[contains(@id,'_ChkViewAllAssignments')]");
	By ViewAllAssignmentChecked = By.xpath("//input[contains(@id,'_ChkViewAllAssignments') and @checked='checked']");
	By ViewAllAssignmentLabel= By.xpath("//span[contains(@id,'lblViewAllAssignments_YALLabel') and text()='View all assignments']");
	By LabelconfigIcon= By.xpath("//span[contains(@id,'lblViewAllAssignments_ManageLabelID')]");
	By txtLabel= By.xpath("//input[@id='idManage_TXTLABEL']");
	
	public void setUser(String value) {
		if (!commonFunction.checkNA(value)) {
			util.click(drpSelectUser);
			util.inputText(drpSelectUser, value);
			By selectUser = By.xpath("//em[contains(text(),'"+value+"')]//./../input");
//			By selectUser = By.xpath("(//*[contains(@id,'MSUSERS_YALComboBox_DropDown')]/..//input)[1]");
			util.click(selectUser);
			util.click(closeUser);
		}
	}
	
	By selectUser = By.xpath("(//*[contains(@id,'MSUSERS_YALComboBox_DropDown')]/.//label)[1] | (//*[contains(@id,'CUSERS_YALComboBox_DropDown')]/.//label)[1]");
	public void setUser() {
			util.click(drpSelectUser);
			util.waitFor(200);	        
			util.click(selectUser);
	        userName= driver.findElement(selectUser).getText();
			util.click(closeUser);
		
	}
	
	public void userNameDot() {
		String arr[]=userName.split(" ");
		userName=arr[1]+", "+arr[0];
	
}
	
	public void setAgent(String value) {
		if (!commonFunction.checkNA(value)) {
			util.click(clickOnAgent);
			util.inputText(addAgent, value);
			By selectAgent = By.xpath("//em[contains(text(),'"+value+"')]/../../span[@class='rtUnchecked']");
			util.click(selectAgent);
			util.click(closeAgent);
		}
	}
	
	public void setAgent() {
			util.click(clickOnAgent);
			if(util.isElementVisible(expandAgent)) {
				util.click(expandAgent);
				util.waitUntilElementDisplay(firstAgent);	
				util.click(firstAgent);
				userName =driver.findElement(firstAgent).getText();
			}else {
				util.click(secondAgent);
				userName =driver.findElement(secondAgent).getText();
			}
			
			util.click(closeAgent);
	}

	public void setRole(String value) {
		if (!commonFunction.checkNA(value)) {
			util.selectValueFromDropdown(drpSelectRole, value);
			//util.inputText(drpSelectRole, value);
			util.pressENTERkey();
		}
	}

	By user = By.xpath("//*[contains(@id,'_PrjRole_radYALDropDownList_DropDown')]/.//li[last()-1]");
	public void setRole() {
		util.click(drpSelectRole);
		 userRole= driver.findElement(user).getText();
        util.click(user);
       
	}


	public void editUser(String value) {
		if (!commonFunction.checkNA(value)) {
			util.selectValueFromDropdown(drpEdituser, value);
			util.pressENTERkey();
		}
	}
	public void editAgent(String value) {
		if (!commonFunction.checkNA(value)) {
			util.selectValueFromDropdown(drpEditAgent, value);
			util.pressENTERkey();
		}
	}

	By updateRole = By.xpath("//*[contains(@id,'EditFormControl_PROJECT_ROLE_ID_radYALDropDownList')]/.//li[last()-2]");
	public void editRole() {
		util.click(drpEditRole);
		updatedRole= driver.findElement(updateRole).getText();
       util.click(updateRole);
	}

	public void editRole(String value) {
		if (!commonFunction.checkNA(value)) {
			util.selectValueFromDropdown(drpEditRole, value);
			util.pressENTERkey();
		}
	}
	
	public void clickOnAdd() {
		try {
			util.click(btnAddDOT);
		} catch (Exception e) {
			util.click(btnAdd);
		}
	}
	
	public void clickUpdate() {
		util.click(btnUpdate);
	}

	By btnDelete = By.xpath("//input[contains(@id,'ProjectAssignments_radYALGridControl_ctl00_ctl04_gbcDeleteAlignment')]");
	
	public void editProjectAssignment(String value1, String value2) throws InterruptedException {		
		if(environment.contains("DOT")) {
			By btnEdit = By.xpath("(//td[contains(text(),'" + value2 + "')]/..//input[@alt='Edit'])[1]");
			util.waitUntilElementDisplay(btnEdit);
			util.waitForWebElementToBeClickable(btnEdit);
			util.click(btnEdit);
			
			if(!util.isElementPresent(drpEditRole)) {
				util.click(btnEdit);
			}
		}else {
		By btnEdit= By.xpath("//td[contains(text(),'" + value2 + "')]/..//input[@alt='Edit']"); 
			util.waitUntilElementDisplay(btnEdit);
			util.waitForWebElementToBeClickable(btnEdit);
			util.click(btnEdit);
			
			if(!util.isElementPresent(drpEditRole)) {
				util.click(btnEdit);
			}
		}
		
		
	}
	
	public void editProjectAssignmentROW(String value) throws InterruptedException {		
		By btnEdit = By.xpath("//td[contains(text(),'" + value + "')]/parent::tr/td[2]");
		util.waitUntilElementDisplay(btnEdit);
		util.waitForWebElementToBeClickable(btnEdit);
		util.click(btnEdit);
		
		if(!util.isElementPresent(drpEditRole)) {
			util.click(btnEdit);
		}
		
	}
	
	
	public void setPagesize(){
		By pagesize = By.xpath("//input[contains(@id,'ProjectAssignments_radYALGridControl_ctl00_ctl03_ctl01_PageSizeComboBox_Input')]");
		System.out.println("");
		By pageSize50 = By.xpath("//div[contains(@id,'ProjectAssignments_radYALGridControl_ctl00_ctl03_ctl01_PageSizeComboBox_DropDown')]/div/ul/li[3]");
		if(util.isElementPresent(pagesize)){
			util.click(pagesize);
			util.click(pageSize50);
		}
		else{
			System.out.println("Page Size option not shows");
		}
		
	}

	By btnDesignMode = By.xpath("//input[contains(@id,'btnDesignModeOff') and @type='image']");
	By drpUser= By.xpath("//input[contains(@id,'_YALHD_mockUserID_radYALDropDownList_Input')]");
	By spinner= By.xpath("(//div[contains(@id,'_ProjectAssignments_pnlProjectAssignments') and @class='RadAjax RadAjax_WebBlue'])[1]");
	
	public void TurnOnDesignMode() {
    	util.waitUntilElementDisplay(btnDesignMode);
    	util.click(btnDesignMode);
    	util.dummyWait(2);
    }
   
   public void SwitchUser(String value) {
		if (!commonFunction.checkNA(value)) {
				util.selectValueFromDropdown(drpUser, value);
				
			util.pressENTERkey();
			}
	  }
   
	public void addProjectAssignment(Map<String, String> map,String testCaseName) throws InterruptedException {
		
		try {
			util.click(addProjectAssigment);
			log("STEP 1: User can expand Project Assignment panel", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: User cannot expand project Assignment Panel", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}
			
			if(util.isElementPresent(clickOnAgent))
			{
				try {
					setAgent(map.get(Excel.SelectAgent));
					userName =map.get(Excel.SelectAgent);
					util.dummyWait(3);
					log("STEP 2: User can able to select Agent Name from the DD", Status.PASS);
				} catch (Exception e) {
					log("STEP 2: User cannot select Agent Name from the DD ", Status.FAIL);
					throw new RuntimeException("Failed in step 2");
				}
				
			}
			else {
				try {
					setUser(map.get(Excel.SelectUser));
					userName =map.get(Excel.SelectUser);
					log("STEP 2: User can select User Name from the DD", Status.PASS);
				} catch (Exception e) {
					log("STEP 2: User cannot select User Name from the DD ", Status.FAIL);
					throw new RuntimeException("Failed in step 2");
				}	
			}
		
			if(!testCaseName.contains("ROW") & !testCaseName.contains("TRA") & !testCaseName.contains("DOT")) {
		try {
			setRole();
			log("STEP 3: User can select Role from the DD", Status.PASS);
		} catch (Exception e) {
			log("STEP 3: User cannot select Role from the DD ", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}
			}
			
		if(testCaseName.equals("ProjectAssignmentDOT")) {
			try {
				util.click(btnAddDOT);
				log("STEP 4: User can click on Add button", Status.PASS);
			} catch (Exception e) {
				log("STEP 4: User cannot click on Add button ", Status.FAIL);
				throw new RuntimeException("Failed in step 4");
			}
			
		}
		else {
			try {
				util.click(btnAdd);
				log("STEP 5: User can click on Add button", Status.PASS);
			} catch (Exception e) {
				log("STEP 5: User cannot click on Add button ", Status.FAIL);
				throw new RuntimeException("Failed in step 5");
			}

		}
		util.dummyWait(15);
		if (util.isElementPresent(By.xpath("//span[contains(@id,'usrAssignMessage')]"))) {
			log("STEP 6: ProjectAssignment is added sucessfully", Status.PASS);
		} else {
			log("STEP 6: ProjectAssignment is not added sucessfully ", Status.FAIL);
			throw new RuntimeException("Failed in step 6");
		}

		 try {
				TurnOnDesignMode();
				log("STEP 7:  user can turn on design mode", Status.PASS);
			} catch (Exception e) {
				log("STEP 7:  user cannot turn on design mode", Status.FAIL);
				throw new RuntimeException("Failed in step 7");
			} 
         
         try {
        	 if(testCaseName.contains("DOT")) {
                 userNameDot();       
        	 }
        	 SwitchUser(userName);
        	 log("STEP 8:  user can switch to Assigned User", Status.PASS);
			} catch (Exception e) {
				log("STEP 8:  user cannot switch to Assigned User", Status.FAIL);
				throw new RuntimeException("Failed in step 8");
			} 
         
         try {
        	  commonFunction.navigateToProjectDeails();
 				log("STEP 9:  user can navigate to Project Details", Status.PASS);
 			} catch (Exception e) {
 				log("STEP 9:  user cannot snavigate to Project Details", Status.FAIL);
 				throw new RuntimeException("Failed in step 9");
 			} 
         
         try {
       	      commonFunction.projectSelection();
				log("STEP 10:  user can see Assign Project in the Project List DD", Status.PASS);
			} catch (Exception e) {
				log("STEP 10:  user cannot see Assign Project in the Project List DD", Status.FAIL);
				throw new RuntimeException("Failed in step 10");
			} 
         
         try {
 			util.click(addProjectAssigment);
 			log("STEP 11: User can expand Project Assignment panel", Status.PASS);
 		} catch (Exception e) {
 			log("STEP 11: User cannot expand project Assignment Panel", Status.FAIL);
 			throw new RuntimeException("Failed in step 11");
 		}
	}

	public void UpdateProjectAssignment(Map<String, String> map) throws InterruptedException {
		
		try {
			setPagesize();
			util.dummyWait(5);
			log("STEP 12: User can set page size ", Status.PASS);
		} catch (Exception e) {
			log("STEP 12:  User cannot set page size ", Status.FAIL);
			throw new RuntimeException("Failed in step 12");
		}
		
		try {
			editProjectAssignment(userRole, userName);
			log("STEP 13: User can click on edit button of the added assignment ", Status.PASS);
		} catch (Exception e) {
			log("STEP 13:  User cannot click on edit button of the added assignment ", Status.FAIL);
			throw new RuntimeException("Failed in step 13");
		}
		util.dummyWait(2);
		if(util.isElementVisible(drpEditRole)) {
		try {
			editRole();
			log("STEP 14:User can update Role", Status.PASS);
		} catch (Exception e) {
			log("STEP 14: User cannot update Role", Status.FAIL);
			throw new RuntimeException("Failed in step 14");
		}
		}
		
//		if(util.isElementVisible(checkboxActiveChecked)) {
//			try {
//				util.click(checkboxActiveChecked);
//				log("STEP 15:User can Inactive assignment", Status.PASS);
//			} catch (Exception e) {
//				log("STEP 15: User cannot Inactive assignment", Status.FAIL);
//				throw new RuntimeException("Failed in step 15");
//			}
//		}
		try {
			clickUpdate();
			util.dummyWait(10);
			log("STEP 16:User can click on update button", Status.PASS);
		} catch (Exception e) {
			log("STEP 16: User cannot click on update button", Status.FAIL);
			throw new RuntimeException("Failed in step 16");
		}
		
		if(!util.isElementVisible(ViewAllAssignmentChecked)) {
		try {
			util.click(checkboxViewAllAssignment);
			util.dummyWait(5);
			log("STEP 17:User can check View all Assignment checkbox", Status.PASS);
		} catch (Exception e) {
			log("STEP 17: User cannot check View all Assignment checkbox", Status.FAIL);
			throw new RuntimeException("Failed in step 17");
		}
		}
		
		try {
				Assert.assertTrue(util.isElementVisible(ViewAllAssignmentLabel));
				log("STEP 18:User can see 'View all assignment' label", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 18: User cannot see 'View all assignment' label", Status.FAIL);
			}
		
		try {
			util.click(LabelconfigIcon);
			util.dummyWait(1);
			util.switchToChildWindow();
			log("STEP 19:User can click on Label Config Icon", Status.PASS);
		} catch (Exception e) {
			log("STEP 19: User cannot click on Label Config Icon", Status.FAIL);
			throw new RuntimeException("Failed in step 19");
		}
		
		try {
			Assert.assertTrue(util.isElementVisible(txtLabel));
			log("STEP 20:User can see Label Text Box", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 20: User cannot see Label Text Box", Status.FAIL);
		}
		
		driver.close();
		util.switchToParentWindow();
	}

}
