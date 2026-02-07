package pages.ProjectPayTemplate;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

public class ProjectAllowancesPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;
	public static String AGREEMENT_NUMBER;

	public ProjectAllowancesPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		
	}
	
	By navProject = By.xpath("//span[text()='Project']");
	By navProjectPayTemplate = By.xpath("//span[contains(text(),'Project Pay Templates')] | //span[contains(text(),'Payment Terms Manager')]");
	By SelectProject = By.xpath("//tr[@id='ctl00_ConPHLeftTop_PAYLST_RadGridTracts_ctl00__0']");
    By ExpandProjectAllowances = By.xpath("(//a[@title='Expand'])[2]"); 
    By txtCollectionLine = By.xpath("(//input[contains(@id,'prjAllowables') and @type='text'])[1]");
    By txtTransmissionLine = By.xpath("(//input[contains(@id,'prjAllowables') and @type='text'])[2]");
    By txtTransmissionRoads = By.xpath("(//input[contains(@id,'prjAllowables') and @type='text'])[3]");
    By txtAccessRoads = By.xpath("(//input[contains(@id,'prjAllowables') and @type='text'])[4]");
    By txtADLS = By.xpath("(//input[contains(@id,'prjAllowables') and @type='text'])[5]");
    By txtBelowGroundCollectionLine = By.xpath("(//input[contains(@id,'prjAllowables') and @type='text'])[6]");
    By txtBelowGroundTransmissionLine = By.xpath("(//input[contains(@id,'prjAllowables') and @type='text'])[7]");
    By txtBelowGroundTransmissionRoads = By.xpath("(//input[contains(@id,'prjAllowables') and @type='text'])[8]");
    By txtLaydownYard = By.xpath("(//input[contains(@id,'prjAllowables') and @type='text'])[9]");
    By txtOandMBuilding = By.xpath("(//input[contains(@id,'prjAllowables') and @type='text'])[10]");
    By txtEasementRoads = By.xpath("(//input[contains(@id,'prjAllowables') and @type='text'])[11]");
    By txtSolarPanels = By.xpath("(//input[contains(@id,'prjAllowables') and @type='text'])[12]");
    By txtSubStation = By.xpath("(//input[contains(@id,'prjAllowables') and @type='text'])[13]");
    By txtSwitchyard = By.xpath("(//input[contains(@id,'prjAllowables') and @type='text'])[14]");
    By btnSave = By.xpath("//input[contains(@id,'_btnSaveRoyaltySummary') and @type='image']");
    By SucessfulMessage = By.xpath("//span[text()='Changed Saved!']");
    
    public void nevigateToProjectPayTemplate() {
  		util.waitUntilElementDisplay(navProject);
  		util.click(navProject);
  		util.waitUntilElementDisplay(navProjectPayTemplate);
  		util.click(navProjectPayTemplate);
 }
    
    public void SelectProject() {
    	util.waitUntilElementDisplay(SelectProject);
    	util.click(SelectProject);
    }
    
    public void ExpandProjectAllowances() {
    	util.waitUntilElementDisplay(ExpandProjectAllowances);
    	util.click(ExpandProjectAllowances);
    }
    
    public void AddCollectionLine(String value) {
  		if (!commonFunction.checkNA(value))
  			util.inputTextAndPressTab(txtCollectionLine, value);
  	}
    
    public void AddTransmissionLine(String value) {
  		if (!commonFunction.checkNA(value))
  			util.inputTextAndPressTab(txtTransmissionLine, value);
  	}
    
    public void AddTransmissionRoads(String value) {
  		if (!commonFunction.checkNA(value))
  			util.inputTextAndPressTab(txtTransmissionRoads, value);
  	}
    
    public void AddAccessRoads(String value) {
  		if (!commonFunction.checkNA(value))
  			util.inputTextAndPressTab(txtAccessRoads, value);
  	}
    	
    public void AddADLS(String value) {
  		if (!commonFunction.checkNA(value))
  			util.inputTextAndPressTab(txtADLS, value);
  	}
    
    public void AddBelowGroundCollectionLine(String value) {
  		if (!commonFunction.checkNA(value))
  			util.inputTextAndPressTab(txtBelowGroundCollectionLine, value);
  	}
    
    public void AddBelowGroundTransmissionLine(String value) {
  		if (!commonFunction.checkNA(value))
  			util.inputTextAndPressTab(txtBelowGroundTransmissionLine, value);
  	}
    
    public void AddBelowGroundTransmissionRoads(String value) {
  		if (!commonFunction.checkNA(value))
  			util.inputTextAndPressTab(txtBelowGroundTransmissionRoads, value);
  	}
    
    public void AddLaydownYard(String value) {
  		if (!commonFunction.checkNA(value))
  			util.inputTextAndPressTab(txtLaydownYard, value);
  	}
    
    public void AddOandMBuilding(String value) {
  		if (!commonFunction.checkNA(value))
  			util.inputTextAndPressTab(txtOandMBuilding, value);
  	}
    
    public void AddEasementRoads(String value) {
  		if (!commonFunction.checkNA(value))
  			util.inputTextAndPressTab(txtEasementRoads, value);
  	}
    
    public void AddSolarPanels(String value) {
  		if (!commonFunction.checkNA(value))
  			util.inputTextAndPressTab(txtSolarPanels, value);
  	}
    
    public void AddSubStation(String value) {
  		if (!commonFunction.checkNA(value))
  			util.inputTextAndPressTab(txtSubStation, value);
  	}
    
    public void AddSwitchyard(String value) {
  		if (!commonFunction.checkNA(value))
  			util.inputTextAndPressTab(txtSwitchyard, value);
  	}
    
    public void ClickOnSaveButton() {
    	util.waitUntilElementDisplay(btnSave);
    	util.click(btnSave);
    }
    
    
    public void ProjectAllowances(Map<String, String> map,String testcaseName)  {
    	 if (testcaseName.contains("ROW") || testcaseName.contains("TRA")){
				log(" Project Allowances not applicable for ROW ", Status.SKIP);
			}
			else {
    	try {
			nevigateToProjectPayTemplate();
			log("STEP 1: User can navigate to project pay template page.", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: User cannot navigate to project pay template page. ", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}
		
		try {
			SelectProject();	
			log("STEP 2:User can select value from dd  ", Status.PASS);
		} catch (Exception e) {
			log("STEP 2:User cannot select value from dd   ", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}
		
		try {
			ExpandProjectAllowances();
			log("STEP 3:  user can expand project allowances panel ", Status.PASS);
		} catch (Exception e) {
			log("STEP 3: User cannot expand project allowances panel ", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}
		
		try {
			AddCollectionLine(map.get(Excel.CollectionLine));
			log("STEP 4:  user can enter value in collection line", Status.PASS);
		} catch (Exception e) {
			log("STEP 4: User cannot enter value in collection line", Status.FAIL);
			throw new RuntimeException("Failed in step 4");
		}
		
		try {
			AddTransmissionLine(map.get(Excel.TransmissionLine));
			log("STEP 5:  user can enter value in Transmission line", Status.PASS);
		} catch (Exception e) {
			log("STEP 5: User cannot enter value in Transmission line", Status.FAIL);
			throw new RuntimeException("Failed in step 5");
		}
		
		try {
			AddTransmissionRoads(map.get(Excel.TransmissionRoads));
			log("STEP 6:  user can enter value in Transmission Roads", Status.PASS);
		} catch (Exception e) {
			log("STEP 6: User cannot enter value in Transmission Roads", Status.FAIL);
			throw new RuntimeException("Failed in step 6");
		}
		
		try {
			AddAccessRoads(map.get(Excel.AccessRoads));
			log("STEP 7:  user can enter value in Access Roads", Status.PASS);
		} catch (Exception e) {
			log("STEP 7: User cannot enter value in Access Roads", Status.FAIL);
			throw new RuntimeException("Failed in step 7");
		}
		
		try {
			AddADLS(map.get(Excel.ADLS));
			log("STEP 8:  user can enter value in ADLS", Status.PASS);
		} catch (Exception e) {
			log("STEP 8: User cannot enter value in ADLS", Status.FAIL);
			throw new RuntimeException("Failed in step 8");
		}
		
		try {
			AddBelowGroundCollectionLine(map.get(Excel.GroundCollectionLine));
			log("STEP 9:  user can enter value in Below Ground Collection Line", Status.PASS);
		} catch (Exception e) {
			log("STEP 9: User cannot enter value in Below Ground Collection Line", Status.FAIL);
			throw new RuntimeException("Failed in step 9");
		}
		
		try {
			AddBelowGroundTransmissionLine(map.get(Excel.GroundTransmissionLine));
			log("STEP 10:  user can enter value in Below Ground Transmission Line", Status.PASS);
		} catch (Exception e) {
			log("STEP 10: User cannot enter value in Below Ground Transmission Line", Status.FAIL);
			throw new RuntimeException("Failed in step 10");
		}
		
		try {
			AddBelowGroundTransmissionRoads(map.get(Excel.GroundTransmissionRoads));
			log("STEP 11:  user can enter value in Below Ground Transmission Roads", Status.PASS);
		} catch (Exception e) {
			log("STEP 11: User cannot enter value in Below Ground Transmission Roads", Status.FAIL);
			throw new RuntimeException("Failed in step 11");
		}
		
		try {
			AddLaydownYard(map.get(Excel.LaydownYard));
			log("STEP 12:  user can enter value in Laydown Yard", Status.PASS);
		} catch (Exception e) {
			log("STEP 12: User cannot enter value in Laydown Yard", Status.FAIL);
			throw new RuntimeException("Failed in step 12");
		}
		
		try {
			AddOandMBuilding(map.get(Excel.OandMBuilding));
			log("STEP 13:  user can enter value in O and M Building", Status.PASS);
		} catch (Exception e) {
			log("STEP 13: User cannot enter value in O and M Building", Status.FAIL);
			throw new RuntimeException("Failed in step 13");
		}
		
		try {
			AddEasementRoads(map.get(Excel.EasementRoads));
			log("STEP 14:  user can enter value in Easement Roads", Status.PASS);
		} catch (Exception e) {
			log("STEP 14: User cannot enter value in Easement Roads", Status.FAIL);
			throw new RuntimeException("Failed in step 14");
		}
		
		try {
			AddSolarPanels(map.get(Excel.SolarPanels));
			log("STEP 15:  user can enter value in Solar Panels", Status.PASS);
		} catch (Exception e) {
			log("STEP 15: User cannot enter value in Solar Panels", Status.FAIL);
			throw new RuntimeException("Failed in step 15");
		}
		
		try {
			AddSubStation(map.get(Excel.SubStation));
			log("STEP 16:  user can enter value in Sub Station", Status.PASS);
		} catch (Exception e) {
			log("STEP 16: User cannot enter value in Sub Station", Status.FAIL);
			throw new RuntimeException("Failed in step 16");
		}
		
		if(util.isElementPresent(txtSwitchyard)) {
		try {
			AddSwitchyard(map.get(Excel.Switchyard));
			log("STEP 17: User can enter value in Switchyard textbox. ", Status.PASS);
		} catch (Exception e) {
			log("STEP 17: User cannot enter value in Switchyard textbox. ", Status.FAIL);
			throw new RuntimeException("Failed in step 17");
		}
		}
		
		try {
			ClickOnSaveButton();
			log("STEP 18: User can click on save button.", Status.PASS);
		} catch (Exception e) {
			log("STEP 18: User cannot click on save button.", Status.FAIL);
			throw new RuntimeException("Failed in step 18");
		}
		
		Assert.assertTrue(util.isElementPresent(SucessfulMessage), "Changed Saved!");
		if (util.isElementPresent(SucessfulMessage)) {
			log("STEP 19:Changes saved sucessfully!' message will be displayed in green color.", Status.PASS);
		} else {
			log("STEP 19:User cannot click on save button.", Status.FAIL);
			throw new RuntimeException("Faild in STEP 19 :User cannot click on save button.");
		}
	}
    	 
    }
}
