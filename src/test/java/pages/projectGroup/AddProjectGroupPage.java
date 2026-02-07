package pages.projectGroup;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

public class AddProjectGroupPage extends BasePage {

	TestUtil util;
	CommonFunction commonFunction;
	String GroupName;

	public AddProjectGroupPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}

	By navProjectMenu = By.xpath("*//a//span[@class='rmText rmExpandDown' and contains(text(),'Project')] ");
	By navProjectGroup = By.xpath("*//a//span[contains(text(),'Project Group') or contains(text(),'Group Information')] ");
	By navAssetInformation = By.xpath("*//a//span[contains(text(),'Asset Information')] | *//a//span[contains(text(),'Project Group Information')] ");
	By navAssetDetails = By.xpath("*//a//span[contains(text(),'Asset Details')] | *//a//span[contains(text(),'Project Group Details')] ");
	By btnRemoveFromGroup = By.xpath("//input[contains(@id,'btnDeleteLink')] ");

	public void navigateToProjectGroup() {
		util.waitUntilElementDisplay(navProjectMenu);
		util.click(navProjectMenu);
		util.waitUntilElementDisplay(navProjectGroup);
		util.click(navProjectGroup);
	}

	public void navigateToAssetDetails() {
		util.waitUntilElementDisplay(navProjectMenu);
		util.click(navProjectMenu);
		util.waitUntilElementDisplay(navAssetInformation);
		util.click(navAssetInformation);
		util.waitUntilElementDisplay(navAssetDetails);
		util.click(navAssetDetails);
	}
	By txtGroupName = By.xpath("//input[contains(@id,'GROUPNAME')]");

	public void setGroupName(String value) {
		if (!commonFunction.checkNA(value))
		util.waitUntilElementDisplay(txtGroupName);
		GroupName =util.randomNumber();
		util.inputTextAndPressTab(txtGroupName,GroupName );
	}

	By txtGroupDescription = By.xpath("//textarea[contains(@id,'GROUPDESC')]");

	public void setGroupDescription(String value) {
		if (!commonFunction.checkNA(value))
		util.waitUntilElementDisplay(txtGroupDescription);
		util.inputTextAndPressTab(txtGroupDescription, value);
	}

	By btnAddNew = By.xpath("//input[contains(@id,'btnAddGroup')]");

	public void clickOnAddNew() {
		util.click(btnAddNew);
	}

	By btnSave = By.xpath("//input[contains(@id,'btnSaveGroup')]");

	public void clickOnSave() {
		util.click(btnSave);
	}

	public void selectProject(String value) {
		
		By selectProjectProject = By.xpath("//*[contains(text(),'" + value + "')]/../input");
		//util.inputTextAndPressTab(selectProjectProject, value);
		util.click(selectProjectProject);
	}

	By btnAddGroup = By.xpath("//input[contains(@id,'btnLinkLogs')]");

	public void clickOnAddGroup() {
		util.click(btnAddGroup);
	}

	public void isProjectGroupPresent(String value) {
		By selectProjectgroup = By.xpath(
				"//div[contains(@id,'LKNPROJECTS_radYALDropDownList')]//following-sibling::li//*[contains(text(),'"
						+ value + "')]");
		util.isElementPresent(selectProjectgroup);

	}
	
	By txtProjectName = By.xpath("//span/parent::div[contains(@id,'ProjectList')]");
	By CategoryFilter = By.xpath("//input[contains(@class,'rddtFilterEmptyMessage')]");
	
	public void checkProjectUnderProjectGroup(String value) {
		util.waitUntilElementDisplay(txtProjectName);
		util.click(txtProjectName);
		util.inputText(CategoryFilter, value);
	}

	public void addProjectGroup(Map<String, String> map, String testcaseName) {
		try {
			if(testcaseName.contains("ROW") & !environment.contains("WOLFMIDSTREAM")) {
				navigateToAssetDetails();
			}else {
			navigateToProjectGroup();
			}
			log("STEP 1:  Navigate to Menu - Project Group", Status.PASS);
		} catch (Exception e) {
			log("STEP 1:  User cannot Navigate to Menu - Project Group", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}
		try {
			clickOnAddNew();
			log("STEP 2:  User can Click on Add New ", Status.PASS);
		} catch (Exception e) {
			log("STEP 2:  User can not Click on Add New", Status.FAIL);
			throw new RuntimeException("Failed in step 2:  User can not Click on Add New");
		}
		
		try {
			setGroupName(map.get(Excel.ProjectGroupName));
			log("STEP 3:  User can enter Project Group", Status.PASS);
		} catch (Exception e) {
			log("STEP 3:  User can not enter Project Group", Status.FAIL);
			throw new RuntimeException("Failed in step 3:  User can not enter Project Group");
		}

		try {
			setGroupDescription(map.get(Excel.GroupDescription));
			log("STEP 4:  User can enter Group Description", Status.PASS);
		} catch (Exception e) {
			log("STEP 4:  User can not enter Group Description", Status.FAIL);
			throw new RuntimeException("Failed in step 4:  User can not enter Group Description");
		}
		
		try {
			clickOnSave();
			log("STEP 5:  User can Click on Add Save", Status.PASS);
		} catch (Exception e) {
			log("STEP 5:  User can not Click on Add Save", Status.FAIL);
			throw new RuntimeException("Failed in step 5:  User can not Click on Add Save");
		}
		try {
			selectProject(map.get(Excel.AvailableProjects));
			log("STEP 6:  User can Select available Project", Status.PASS);
		} catch (Exception e) {
			log("STEP 6:  User can not Select available Project", Status.FAIL);
			throw new RuntimeException("Failed in step 6:  User can not Select available Project");
		}
		try {
			util.dummyWait(3);
			clickOnAddGroup();
			util.dummyWait(3);
			isProjectGroupPresent(map.get(Excel.AvailableProjects));
			log("STEP 7:  User can Click on Add Group", Status.PASS);
			log("STEP 7:  Selected project dispalyed in Project Group field", Status.PASS);
		} catch (Exception e) {
			log("STEP 7:  User can not Click on Add Group", Status.FAIL);
			log("STEP 7:  Selected project dispalyed in Project Group field", Status.FAIL);
			throw new RuntimeException("Failed in step 7:  User can not Click on Add Group");
		}
		
		try {
			commonFunction.navigateToProjectDeails();
			log("STEP 8:  User can navigate to Project Details", Status.PASS);
		} catch (Exception e) {
			log("STEP 8:  User can navigate to Project Details", Status.FAIL);
			throw new RuntimeException("Failed in step 8");
		}
		
		try {
			checkProjectUnderProjectGroup(map.get(Excel.AvailableProjects));
			By projectGroup = By.xpath("//span[text()='"+GroupName+"']");
			Assert.assertTrue(util.isElementVisible(projectGroup));
			log("STEP 9:  User can see Group Name in the Project Name DD", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 9:  User cannot see Group Name in the Project Name DD", Status.FAIL);
		}
		
		try {
			By project = By.xpath("//span[text()='"+GroupName+"']/../..//*[text()='"+map.get(Excel.AvailableProjects)+"']");
			Assert.assertTrue(util.isElementVisible(project));
			log("STEP 10:  Project is Dispaying under the Project Group", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 10:  Project is not Dispaying under the Project Group", Status.FAIL);
		}
		
		try {
			if(testcaseName.contains("ROW") & !environment.contains("WOLFMIDSTREAM")) {
				navigateToAssetDetails();
			}else {
			navigateToProjectGroup();
			}
			log("STEP 11:  Navigate to Menu - Project Group", Status.PASS);
		} catch (Exception e) {
			log("STEP 11:  User cannot Navigate to Menu - Project Group", Status.FAIL);
			throw new RuntimeException("Failed in step 11");
		}
		
		try {
			By selectGroup = By.xpath("//tr[contains(@id,'ProjectGroup_RadGridTracts')]/..//td[text()='"+GroupName+"']");
			util.click(selectGroup);
			log("STEP 12:  USer can select Project Group", Status.PASS);
		} catch (Exception e) {
			log("STEP 12:  User cannot select Project Group", Status.FAIL);
			throw new RuntimeException("Failed in step 12");
		}
		
		try {
			selectProject(map.get(Excel.AvailableProjects));
			log("STEP 13:  User can see select Project Name", Status.PASS);
		} catch (Exception e) {
			log("STEP 13:  User cannot select Project Name", Status.FAIL);
			throw new RuntimeException("Failed in step 13");
		}
		
		try {
			util.click(btnRemoveFromGroup);
			log("STEP 14:  USer can click on Remove from Group ", Status.PASS);
		} catch (Exception e) {
			log("STEP 14:  USer cannot click on Remove from Group", Status.FAIL);
			throw new RuntimeException("Failed in step 14");
		}
	}
}
