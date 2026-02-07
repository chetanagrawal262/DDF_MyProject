package pages.ProjectSetup;

import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

public class PermissionPage extends BasePage {
	
	TestUtil util;
	CommonFunction commonFunction;

	public PermissionPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	
	By navAddminitstration = By.xpath("//a//span[@class='rmText rmExpandDown' and contains(text(),'Administration')] ");
	By navSecurity = By.xpath("//a//span[@class='rmText rmExpandRight' and contains(text(),'Security')]");
	By navUserRole = By.xpath("//a//span[@class='rmText' and contains(text(),'User Role')]");
	By checkedMyRequest = By.xpath("//*[text()='My Requests']/..//input[@checked='checked' and @value='W']");
	By uncheckedMyRequest = By.xpath("//*[text()='My Requests']/..//input[@type='radio' and @value='W']");
	By checkedMCF = By.xpath("//*[text()='Manage Custom Fields']/..//input[@checked='checked']");
	By uncheckedMCF = By.xpath("//*[text()='Manage Custom Fields']/..//input[@type='checkbox']");
	By labelArchiveProject = By.xpath("//label[text()='Archive Project']");
	By checkedAProject = By.xpath("//*[text()='Archive Project']/..//input[@checked='checked']");
	By uncheckedAProject = By.xpath("//*[text()='Archive Project']/..//input[@type='checkbox']");
	By checkedDeleteSearch = By.xpath("//*[text()='Can Use Global Search']/..//input[@checked='checked']");
	By uncheckedDeleteSearch = By.xpath("//*[text()='Can Use Global Search']/..//input[@type='checkbox']");
	By savePermission = By.xpath("//input[contains(@id,'savePermissions')]");

	By checkedPendingNotes = By.xpath("//*[text()='Edit Pending Notes']/..//input[@checked='checked']");
	By uncheckedPendingNotes = By.xpath("//*[text()='Edit Pending Notes']/..//input[@type='checkbox']");
	
	By checkedApprovedNotes = By.xpath("//*[text()='Edit Approved Notes']/..//input[@checked='checked']");
	By uncheckedApprovedNotes = By.xpath("//*[text()='Edit Approved Notes']/..//input[@type='checkbox']");
	
	By checkedUnassignedTicket = By.xpath("//*[text()='View Unassigned Tickets']/..//input[@checked='checked']");
	By uncheckedUnassignedTicket = By.xpath("//*[text()='View Unassigned Tickets']/..//input[@type='checkbox']");
	
	By checkedUnassignedProjects = By.xpath("//*[text()='View Unassigned Projects']/..//input[@checked='checked']");
	By uncheckedUnassignedProjects = By.xpath("//*[text()='View Unassigned Projects']/..//input[@type='checkbox']");
	
	By checkedDropDownConfiguration = By.xpath("//*[text()='Dropdown Configuration']/..//input[@checked='checked']");
	By uncheckedDropDownConfiguration = By.xpath("//*[text()='Dropdown Configuration']/..//input[@type='checkbox']");
	
	By checkedManageLabels = By.xpath("//*[text()='Manage Labels']/..//input[@checked='checked']");
	By uncheckedManageLabels = By.xpath("//*[text()='Manage Labels']/..//input[@type='checkbox']");
	
	public void navigateUserRoles() {
		util.waitUntilElementDisplay(navAddminitstration);
		util.click(navAddminitstration);
		util.waitUntilElementDisplay(navSecurity);
		util.click(navSecurity);
		util.waitUntilElementDisplay(navUserRole);
		util.click(navUserRole);
	}
	
	By drpRole = By.xpath("//input[contains(@id,'DISTRIBUTION_Input')]");
	public void selectRoleDD(String value) {
		if (!commonFunction.checkNA(value))
			util.selectDropDownValue(drpRole, value);
	}
	
	By tabSpecialPermission = By.xpath("//span[text()='Special Permissions']");
	public void clickOnSpecialPermission() {
		util.click(tabSpecialPermission);

	}

	By btnSavePermission = By.xpath("//input[contains(@id,'savePermissions')]");
	public void clickOnSavePermission() {
		util.waitUntilElementDisplay(btnSavePermission);
		util.click(btnSavePermission);
		util.dummyWait(2);
	}
	
	public void selectSpecialPermission(Map<String, String> map, String testcaseName) {
		try {
			navigateUserRoles();
			log("STEP 1:  Navigate to Menu - User Roles", Status.PASS);
		} catch (Exception e) {
			log("STEP 1:  Not Navigate to Menu - User Roles", Status.FAIL);
			throw new RuntimeException("Failed in step 1:  Not Navigate to Menu - User Roles");
		}
		try {
			selectRoleDD(map.get(Excel.Roles));
			log("STEP 2:  User can select Role", Status.PASS);
		} catch (Exception e) {
			log("STEP 2:  User can not select Role", Status.FAIL);
			throw new RuntimeException("Failed in step 2:  User can not select Role");
		}
		
		try {
			if(!util.isElementPresent(checkedMyRequest)) {
				util.click(uncheckedMyRequest);
			}
			log("STEP 3:  User can see My Request page Permission and update the permission", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 3:  User cannot see My Request page Permission", Status.FAIL);
		}
		
		try {
			clickOnSpecialPermission();
			log("STEP 4:  User can click on Special Permission", Status.PASS);
		} catch (Exception e) {
			log("STEP 4:  User can not click on Special Permission", Status.FAIL);
			throw new RuntimeException("Failed in step 4");
		}
		
		try {
			if(!util.isElementPresent(checkedAProject)) {
				util.click(uncheckedAProject);
			}
			log("STEP 5:  User can see Archive Project Special Permission and update the permission", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 5:  User cannot see Archive Project Special Permission", Status.FAIL);
		}
		
		try {
			if(!util.isElementPresent(checkedMCF)) {
				util.click(uncheckedMCF);
			}
			log("STEP 6:  User can update manage custom Field Special Permission", Status.PASS);
		} catch (Exception e) {
			log("STEP 6:  User cannot update manage custom Field Special Permission", Status.FAIL);
		}
		
		if(!testcaseName.contains("ROW") & !testcaseName.contains("TRA")) {
		try {
			if(!util.isElementPresent(checkedDeleteSearch)) {
				util.click(uncheckedDeleteSearch);
			}
			log("STEP 7:  User can update Can use global search Special Permission", Status.PASS);
		} catch (Exception e) {
			log("STEP 7:  User cannot update Can use global search Special Permission", Status.FAIL);
		}
		}
		
		try {
			if(!util.isElementPresent(checkedPendingNotes)) {
				util.click(uncheckedPendingNotes);
			}
			log("STEP 8:  User can update the Edit Pending Notes permission", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 8:  User cannot update the Edit Pending Notes permission", Status.FAIL);
		}
		
		try {
			if(!util.isElementPresent(checkedApprovedNotes)) {
				util.click(uncheckedApprovedNotes);
			}
			log("STEP 9:  User can update the Edit Approved Notes permission", Status.PASS);
		} catch (Exception e) {
			log("STEP 9:  User cannot update the Edit Approved Notes permission", Status.FAIL);
		}
		
		if(testcaseName.contains("ROW")  || testcaseName.contains("TRA")) {
		try {
			if(!util.isElementPresent(checkedUnassignedProjects)) {
				util.click(uncheckedUnassignedProjects);
			}
			log("STEP 10:  User can update the View Unassigned Project permission", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 10:  User cannot update the View Unassigned Project permission", Status.FAIL);
		}
		}
		
		try {
			if(!util.isElementPresent(checkedUnassignedTicket)) {
				util.click(uncheckedUnassignedTicket);
			}
			log("STEP 11:  User can update the View Unassigned Tickets permission", Status.PASS);
		} catch (Exception e) {
			log("STEP 11:  User cannot update the View Unassigned Tickets permission", Status.FAIL);
		}
		
		try {
			if(!util.isElementPresent(checkedDropDownConfiguration)) {
				util.click(uncheckedDropDownConfiguration);
			}
			log("STEP 12:  User can update the Drop Down Configurations permission", Status.PASS);
		} catch (Exception e) {
			log("STEP 12:  User cannot update the Drop Down Configurations permission", Status.FAIL);
		}
		
		try {
			if(!util.isElementPresent(checkedManageLabels)) {
				util.click(uncheckedManageLabels);
			}
			log("STEP 13:  User can update the Manage Labels permission", Status.PASS);
		} catch (Exception e) {
			log("STEP 13:  User cannot update the Manage Labels permission", Status.FAIL);
		}
		
		try {
			clickOnSavePermission();
			log("STEP 14:  User can click on Save", Status.PASS);
		} catch (Exception e) {
			log("STEP 14:  User can not click on Save", Status.FAIL);
			throw new RuntimeException("Failed in step 12 ");
		}

	}

	String role = "QA Role";

	By btnDuplicatePermission = By.xpath("//input[contains(@id,'btnDuplicatePermission')]");

	public void clickOnDuplication() {
		util.waitUntilElementDisplay(btnDuplicatePermission);
		util.click(btnDuplicatePermission);
	}

	By txtSaveAS = By.xpath("//input[contains(@id,'NEWDistribution_Duplicate')]");

	public void saveUserRole(String value) {
		util.waitUntilElementDisplay(txtSaveAS);
		util.inputTextAndPressTab(txtSaveAS, value);
	}

	By btnSave = By.xpath("//input[contains(@id,'btnSave_Duplicate')]");

	public void clickOnSave() {
		util.waitUntilElementDisplay(btnSave);
		util.click(btnSave);
	}
	public void createNewRole(Map<String, String> map, String testcaseName) {
		try {
			navigateUserRoles();
			log("STEP 1:  Navigate to Menu - User Roles", Status.PASS);
		} catch (Exception e) {
			log("STEP 1:  Not Navigate to Menu - User Roles", Status.FAIL);
			throw new RuntimeException("Failed in step 1:  Not Navigate to Menu - User Roles");
		}
		if(!testcaseName.contains("ROW") & !testcaseName.contains("TRA") & !testcaseName.contains("DOT") & !testcaseName.contains("DOM")) {
			util.inputText(drpRole, role);
		}else {
			util.click(drpRole);
		}
		By valueRole = By.xpath("(//*[@id='ctl00_ConPHRightTop_DISTRIBUTION_DropDown']/..//*[text()='"+role+"'])[1]");
		
		if (!util.isElementVisible(valueRole)) {
		try {
			selectRoleDD(map.get(Excel.Roles));
			log("STEP 2:  User can select Role", Status.PASS);
		} catch (Exception e) {
			log("STEP 2:  User can not select Role", Status.FAIL);
			throw new RuntimeException("Failed in step 2:  User can not select Role");
		}
		
		try {
			clickOnDuplication();
			log("STEP 3:  User can click on Duplicate Button", Status.PASS);
		} catch (Exception e) {
			log("STEP 3:  User can not click on Duplicate Button", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}
		
		try {
			saveUserRole(role);
			log("STEP 4:  User can enter Duplication User Role value", Status.PASS);
		} catch (Exception e) {
			log("STEP 4:  User can not enter Duplication User Role value", Status.FAIL);
			throw new RuntimeException("Failed in step 4");
		}
		
		try {
			clickOnSave();
			log("STEP 5:  User can click on Save Button", Status.PASS);
		} catch (Exception e) {
			log("STEP 5:  User can not click on Save Button", Status.FAIL);
			throw new RuntimeException("Failed in step 5");
		}
		
		}else {
			util.click(valueRole);
			log("User Role Already Present", Status.SKIP);
		}
		
	
	}
	
}
