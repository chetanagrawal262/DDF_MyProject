package pages.ProjectSetup;

import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.util.CommonFunction;
import com.util.TestUtil;

public class ABSPage extends BasePage {

	TestUtil util;
	CommonFunction commonFunction;

	public ABSPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}

	    By drpDraft_Final = By.xpath("//input[contains(@id,'_editcc_ddlDocDraftFinal_radYALDropDownList_Input') and @type='text']");
	    
	    public void SelectDraft_Final(String value) {
	    	if (!commonFunction.checkNA(value)) 
				util.inputTextAndPressTab(drpDraft_Final, value);
	    }
	    	
		By navAdministration = By.xpath("//span[text()='Administration']");
		By navABS = By.xpath("//span[contains(text(),'Application Behavior Settings')]");
		By txtFilterKeyName = By.xpath("//input[@alt='Filter key_name column']");
		By btnFilterKeyName = By.xpath("//input[contains(@id,'Filter_key_name') and @type='button']");
		By optionFilter = By.xpath("//span[text()='Contains']");
	    By btnSubmitAll = By.xpath("//input[@title='Submit All']");
		
		public void NavigateToApplicationBehaviorSettings() {
	    	util.waitUntilElementDisplay(navAdministration);
	    	util.click(navAdministration);
	    	util.waitUntilElementDisplay(navABS);
	    	util.click(navABS);
	    }
		
		 public void enterKeyName(String value) {
				util.waitUntilElementDisplay(txtFilterKeyName);
				util.inputTextAndPressTab(txtFilterKeyName, value);
			}
		
		 public void selectFilter() {
			 util.waitFor(300);
		    	if(!util.isElementVisible(optionFilter)) {
				util.waitUntilElementDisplay(btnFilterKeyName);
				util.click(btnFilterKeyName);
				util.click(optionFilter);
				}
			}
		 
		
		 public void setKeyValue(String key, String value) {
		    	By keyValue = By.xpath("//*[text()='"+key+"']/..//input[contains(@name,'txtValue')]");
		    	util.dummyWait(1);
				//util.waitUntilElementDisplay(keyValue);
				util.inputTextAndPressTab(keyValue, value);
			}
		 
		  public void clickOnSubmitAll() {
				util.waitUntilElementDisplay(btnSubmitAll);
				util.click(btnSubmitAll);;
			}
		  
		  
		public void SetKeySetting(Map<String, String> map, String testcaseName)
				throws InterruptedException {
			
			try {
				NavigateToApplicationBehaviorSettings();
				log("STEP 1: User can navigate to Application Behavior Settings ", Status.PASS);
			} catch (Exception e) {
				log("STEP 1: User cannot navigate to Application Behavior Settings ", Status.FAIL);
				throw new RuntimeException("Failed in step 1");
			}

			try {
				enterKeyName(map.get("ABS_1"));
				log("STEP 2: User can enter key name " + map.get("ABS_1"), Status.PASS);
			} catch (Exception e) {
				log("STEP 2: User cannot enter key name " + map.get("ABS_1"), Status.FAIL);
				throw new RuntimeException("Failed in step 2");
			}

			try {
				selectFilter();
				log("STEP 3: User can click on Filter Icon", Status.PASS);
			} catch (Exception e) {
				log("STEP 3: User cannot click on Filter Icon", Status.FAIL);
				throw new RuntimeException("Failed in step 3");
			}

			try {
				setKeyValue(map.get("ABS_1"), map.get("Value_1"));
				log("STEP 4: User can set " +  map.get("Value_1") + " value for key name " + map.get("ABS_1"), Status.PASS);
			} catch (Exception e) {
				log("STEP 4: User cannot set " +  map.get("Value_1") + " value for key name " + map.get("ABS_1"), Status.FAIL);
				throw new RuntimeException("Failed in step 4");
			}

			try {
				clickOnSubmitAll();
				log("STEP 5: User can click on Submit All button ", Status.PASS);
			} catch (Exception e) {
				log("STEP 5: User cannot click on Submit All button", Status.FAIL);
				throw new RuntimeException("Failed in step 5");
			}
			
			try {
				enterKeyName(map.get("ABS_2"));
				log("STEP 6: User can enter key name " + map.get("ABS_2"), Status.PASS);
			} catch (Exception e) {
				log("STEP 6: User cannot enter key name " + map.get("ABS_2"), Status.FAIL);
				throw new RuntimeException("Failed in step 6");
			}

			try {
				selectFilter();
				log("STEP 7: User can click on Filter Icon", Status.PASS);
			} catch (Exception e) {
				log("STEP 7: User cannot click on Filter Icon", Status.FAIL);
				throw new RuntimeException("Failed in step 7");
			}

			try {
				setKeyValue(map.get("ABS_2"), map.get("Value_2"));
				log("STEP 8: User can set " + map.get("Value_2") + " value for key name " + map.get("ABS_2"), Status.PASS);
			} catch (Exception e) {
				log("STEP 8: User cannot set " + map.get("Value_2") + " value for key name " + map.get("ABS_2"), Status.FAIL);
				throw new RuntimeException("Failed in step 8");
			}

			try {
				clickOnSubmitAll();
				log("STEP 9: User can click on Submit All button ", Status.PASS);
			} catch (Exception e) {
				log("STEP 9: User cannot click on Submit All button", Status.FAIL);
				throw new RuntimeException("Failed in step 9");
			}
			
			if(testcaseName.contains("ROW") || testcaseName.contains("TRA") || testcaseName.contains("DOM")) {
			try {
				enterKeyName(map.get("ABS_3"));
				log("STEP 10: User can enter key name " + map.get("ABS_3"), Status.PASS);
			} catch (Exception e) {
				log("STEP 10: User cannot enter key name " + map.get("ABS_3"), Status.FAIL);
				throw new RuntimeException("Failed in step 10");
			}

			try {
				selectFilter();
				log("STEP 11: User can click on Filter Icon", Status.PASS);
			} catch (Exception e) {
				log("STEP 11: User cannot click on Filter Icon", Status.FAIL);
				throw new RuntimeException("Failed in step 11");
			}

			try {
				setKeyValue(map.get("ABS_3"), map.get("Value_3"));
				log("STEP 12: User can set " + map.get("Value_3") + " value for key name " + map.get("ABS_3"), Status.PASS);
			} catch (Exception e) {
				log("STEP 12: User cannot set " + map.get("Value_3") + " value for key name " + map.get("ABS_3"), Status.FAIL);
				throw new RuntimeException("Failed in step 12");
			}

			try {
				clickOnSubmitAll();
				log("STEP 13: User can click on Submit All button ", Status.PASS);
			} catch (Exception e) {
				log("STEP 13: User cannot click on Submit All button", Status.FAIL);
				throw new RuntimeException("Failed in step 13");
			}
			}else if(testcaseName.contains("DOT")) {
				try {
					enterKeyName(map.get("ABS_4"));
					log("STEP 10: User can enter key name " + map.get("ABS_4"), Status.PASS);
				} catch (Exception e) {
					log("STEP 10: User cannot enter key name " + map.get("ABS_4"), Status.FAIL);
					throw new RuntimeException("Failed in step 10");
				}

				try {
					selectFilter();
					log("STEP 11: User can click on Filter Icon", Status.PASS);
				} catch (Exception e) {
					log("STEP 11: User cannot click on Filter Icon", Status.FAIL);
					throw new RuntimeException("Failed in step 11");
				}

				try {
					setKeyValue(map.get("ABS_4"), map.get("Value_4"));
					log("STEP 12: User can set " + map.get("Value_4") + " value for key name " + map.get("ABS_4"), Status.PASS);
				} catch (Exception e) {
					log("STEP 12: User cannot set " + map.get("Value_4") + " value for key name " + map.get("ABS_4"), Status.FAIL);
					throw new RuntimeException("Failed in step 12");
				}

				try {
					clickOnSubmitAll();
					log("STEP 13: User can click on Submit All button ", Status.PASS);
				} catch (Exception e) {
					log("STEP 13: User cannot click on Submit All button", Status.FAIL);
					throw new RuntimeException("Failed in step 13");
				}
				
				try {
					enterKeyName(map.get("ABS_5"));
					log("STEP 14: User can enter key name " + map.get("ABS_5"), Status.PASS);
				} catch (Exception e) {
					log("STEP 14: User cannot enter key name " + map.get("ABS_5"), Status.FAIL);
					throw new RuntimeException("Failed in step 14");
				}

				try {
					selectFilter();
					log("STEP 15: User can click on Filter Icon", Status.PASS);
				} catch (Exception e) {
					log("STEP 15: User cannot click on Filter Icon", Status.FAIL);
					throw new RuntimeException("Failed in step 15");
				}

				try {
					setKeyValue(map.get("ABS_5"), map.get("Value_5"));
					log("STEP 16: User can set " + map.get("Value_5") + " value for key name " + map.get("ABS_5"), Status.PASS);
				} catch (Exception e) {
					log("STEP 16: User cannot set " + map.get("Value_5") + " value for key name " + map.get("ABS_5"), Status.FAIL);
					throw new RuntimeException("Failed in step 16");
				}

				try {
					clickOnSubmitAll();
					log("STEP 17: User can click on Submit All button ", Status.PASS);
				} catch (Exception e) {
					log("STEP 17: User cannot click on Submit All button", Status.FAIL);
					throw new RuntimeException("Failed in step 17");
				}
			}
		}
		
}
