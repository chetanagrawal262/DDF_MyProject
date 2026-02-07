package pages.TicketAssociation;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

public class AddNewParticipatingStakeholderLandownerInformationPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;
	public static String AGREEMENT_NUMBER;

	public AddNewParticipatingStakeholderLandownerInformationPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		
	}
	
	By LandownerInformtion = By.xpath("//span[contains(text(),'Landowner Information')]");
    By drpExistingContact = By.xpath("//input[contains(@id,'_LESSOR_Input') and @type='text']");
    By btnAdd = By.xpath("//input[contains(@id,'btnAddLessor') and @type='image']");
    By Checkbox = By.xpath("//input[contains(@id,'chkLOLimitLandowners') and @type='checkbox']");
    By Message = By.xpath("//span[text()='There are no parcels associated to this ticket']");
    By btnDelete = By.xpath("(//input[contains(@id,'gbcDeleteAlignment')])[1]");
	By iframDelete = By.xpath("//td[@class='rwWindowContent']");
	By btnCancle = By.xpath("//span[text()='Cancel']");
	By btnOk = By.xpath("//span[text()='OK']");
	By changesSavedSuccessfully = By.xpath("//span[text()='Changes saved successfully!']");
	By loader = By.xpath("(//div[contains(@id,'_LESSOR_DropDown')]/..//input[@type='checkbox'])[1]");
	By pageSpinner = By.xpath("//*[@id='idCustOutreach_RALCustOutreachidCustOutreach_RadMultiPage1']/div[1]");
	

	public void ClickOnLandownerInformtion() {
		util.waitUntilElementDisplay(LandownerInformtion);
		util.click(LandownerInformtion);
	}
	
	public void SelectExistingContact(String value) {
		if (!commonFunction.checkNA(value))
		util.waitUntilElementDisplay(drpExistingContact);
		WebElement inputField = util.getElement(drpExistingContact);
		inputField.click();
		util.dummyWait(20);
		util.clearInputField(inputField);
		util.dummyWait(20);
		inputField.sendKeys(value);
		util.dummyWait(20);
		inputField.sendKeys(Keys.DOWN);
		inputField.sendKeys(Keys.ENTER);
//			util.inputTextAndPressEnter(drpExistingContact,value);
	}
	
	public void ClickOnAddButton() {
		util.waitFor(200);
		util.waitUntilElementDisplay(btnAdd);
		util.click(btnAdd);
		util.waitUntilElementDisappear(pageSpinner);
	}
	
	public void ClickOnParcelCheckbox() {
		util.waitUntilElementDisplay(Checkbox);
		util.click(Checkbox);
	}
	
	
	 public void ClickonDelete() {
	  		util.waitUntilElementDisplay(btnDelete);
	  		util.click(btnDelete);
	    }
	
	 
	 public void ClickonCancle()  {
		 util.waitUntilElementDisplay(btnCancle);
	  		util.click(btnCancle);
	    }
	 
	 
	 public void ClickonOk()  {
		    util.waitUntilElementDisplay(btnDelete);
	  		util.click(btnDelete);	
	  		util.waitUntilElementDisplay(btnOk);
	  		util.click(btnOk);
	  		util.waitUntilElementDisappear(pageSpinner);
	  		
	    }
	 
	    public void LandownerInformation(Map<String, String> map, String testcaseName) {

	    	try {
	    		ClickOnLandownerInformtion();
    				log("STEP 1: Record Grid should expands below ", Status.PASS);
    			} catch (Exception e) {
    				log("STEP 1:  Record does not expand below", Status.FAIL);
    				throw new RuntimeException("Failed in step 1");
    			}
	    	
	    	 try {
	    		 SelectExistingContact(map.get(Excel.ExistingContact));
	    			log("STEP 2: User can select Existing Landowner and Landowner DD is Multiselected DD ", Status.PASS);
	    		} catch (Exception e) {
	    			log("STEP 2:User cannot select Existing Landowner or Landowner DD is not Multiselected DD", Status.FAIL);
	    			throw new RuntimeException("Failed in step 2");
	    		}
	    	
	    	 try {
	    		 ClickOnAddButton();
	    			log("STEP 3:  Added value displays in the below grid ", Status.PASS);
	    		} catch (Exception e) {
	    			log("STEP 3:  Added value can not be display  ", Status.FAIL);
	    			throw new RuntimeException("Failed in step 3");
	    		}
	    	 
	       try {
				 ClickonDelete();
					log("STEP 4:  user can click on cross icon   ", Status.PASS);
				} catch (Exception e) {
					log("STEP 4:  Popup Delete does not open", Status.FAIL);
					throw new RuntimeException("Failed in step 4 ");
				}
		 
			 
			 
			 try {
				 ClickonCancle();
					log("STEP 5: User can click on cancel button  ", Status.PASS);
				} catch (Exception e) {
					log("STEP 5: User cannot click on cancel button", Status.FAIL);
					throw new RuntimeException("Failed in step 5");
				}
			 
			 try {
				 ClickonOk();
					log("STEP 6: Deleted record does not display in the grid and 2)Message- Changes saved suessfully! in green displays. ", Status.PASS);
				} catch (Exception e) {
					log("STEP 6: Message- Changes saved sucessfully' does not display", Status.FAIL);
					throw new RuntimeException("Failed in step 8 ");
				
				}
	    	
	    }
}
