package pages.ProjectSetup;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
	By drpSelectRole = By.xpath("//input[contains(@id,'PrjRole_radYALDropDownList_Input')]");
	By btnAdd = By.xpath("//input[@alt='Add']");
	
	public void setUser(String value) {
		if (!commonFunction.checkNA(value)) {
			util.inputTextAndPressEnter(drpSelectUser, value);
		}
	}
	
	public void setRole(String value) {
		if (!commonFunction.checkNA(value)) {
			util.inputTextAndPressTab(drpSelectRole, value);
		}
	}

	public void clickOnAdd() {
			util.click(btnAdd);
	}

   
	public void addProjectAssignment(Map<String, String> map,String testCaseName) throws InterruptedException {
		
		try {
			util.click(addProjectAssigment);
			log("STEP 1: User can expand Project Assignment panel", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: User cannot expand project Assignment Panel", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}

		try {
			setUser(map.get(Excel.SelectUser));
			log("STEP 2: User can select User Name from the DD", Status.PASS);
		} catch (Exception e) {
			log("STEP 2: User cannot select User Name from the DD ", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}

		try {
			setRole(map.get(Excel.SelectRole));
			log("STEP 3: User can select Role from the DD", Status.PASS);
		} catch (Exception e) {
			log("STEP 3: User cannot select Role from the DD ", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}

		try {
			util.click(btnAdd);
			log("STEP 4: User can click on Add button", Status.PASS);
		} catch (Exception e) {
			log("STEP 4: User cannot click on Add button ", Status.FAIL);
			throw new RuntimeException("Failed in step 4");
		}

		util.dummyWait(10);
		if (util.isElementPresent(By.xpath("//span[contains(@id,'ProjectAssignments_usrMessage')]"))) {
			log("STEP 5: ProjectAssignment is added sucessfully", Status.PASS);
		} else {
			log("STEP 5: ProjectAssignment is not added sucessfully ", Status.FAIL);
			throw new RuntimeException("Failed in step 5");
		}
		
//		if(environment.contains("CONNECTGEN")) {
//			try {
//				setUser(map.get("SecondUser"));
//				log("STEP 6: User can select User Name from the DD", Status.PASS);
//			} catch (Exception e) {
//				log("STEP 6: User cannot select User Name from the DD ", Status.FAIL);
//				throw new RuntimeException("Failed in step 6");
//			}
//
//			try {
//				setRole(map.get(Excel.SelectRole));
//				log("STEP 7: User can select Role from the DD", Status.PASS);
//			} catch (Exception e) {
//				log("STEP 7: User cannot select Role from the DD ", Status.FAIL);
//				throw new RuntimeException("Failed in step 7");
//			}
//
//			try {
//				util.click(btnAdd);
//				log("STEP 8: User can click on Add button", Status.PASS);
//			} catch (Exception e) {
//				log("STEP 8: User cannot click on Add button ", Status.FAIL);
//				throw new RuntimeException("Failed in step 8");
//			}
//		}
	}


}
