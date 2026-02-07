package pages.TicketAssociation;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

public class ParticipatingStakeholdersParcelInformationPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;
	public static String AGREEMENT_NUMBER;

	public ParticipatingStakeholdersParcelInformationPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		
	}
	
	By ParcelInformation = By.xpath("//*[@id='idCustOutreach_LOHDetails_radPanels_i2_i0_RadTabStripLO']/.//span[text()='Parcel Information' or text()='Tract Information']");
	By drpParcelTo = By.xpath("//input[contains(@id,'PartiStackHolderTRACTS_Input')]");
	By closedrpParcelInformation = By.xpath("//a[contains(@id,'PartiStackHolderTRACTS_Arrow')]");
	By btnAdd = By.xpath("//input[contains(@id,'ImageButton2')]");
	By Checkbox = By.xpath("//input[contains(@id,'chkTractLimitLandowners')]");
	By ParcelNoLink = By.xpath("//tr[@id='idCustOutreach_LOHDetails_radPanels_i2_i0_RadGridTract_ctl00__0']//a");
    By btnDelete = By.xpath("(//input[contains(@id,'gbcDeleteTract')])[1]");
	By iframDelete = By.xpath("//td[@class='rwWindowContent']");
	By btnCancle = By.xpath("//span[text()='Cancel']");
	By btnOk = By.xpath("//span[text()='OK']");
	By changesSavedSuccessfully = By.xpath("//span[text()='Changes saved successfully!']");
	By Message = By.xpath("//span[text()='There are no landowners associated to this ticket.']");	
	By loader = By.xpath("//li[contains(@id,'_LoadingDiv')]");
	By pageSpinner = By.xpath("//*[@id='idCustOutreach_RALCustOutreachidCustOutreach_RadMultiPage1']/div[1]");
	By DefaultParcelMessage = By.xpath("(//*[text()='No Parcel are currently assigned to ticket'])[1] | (//*[text()='No Tract are currently assigned to ticket'])[1]");	
  
	public void ClickOnParcelInformation() {
	   util.waitUntilElementDisplay(ParcelInformation);
	   util.click(ParcelInformation);
	   util.dummyWait(2);
   }

   public void SelectParcelTo(String value) {
	   if (!commonFunction.checkNA(value))
		   util.waitUntilElementDisplay(drpParcelTo);
		WebElement inputField = util.getElement(drpParcelTo);
		inputField.click();
		util.dummyWait(20);
		util.clearInputField(inputField);
		util.dummyWait(20);
		inputField.sendKeys(value);
		util.dummyWait(20);
		inputField.sendKeys(Keys.DOWN);
		inputField.sendKeys(Keys.ENTER);
//	       util.inputTextAndPressEnter(drpParcelTo,value);
	  }

   public void ClickOnAddButton() {
	   util.waitFor(200);
	   util.waitUntilElementDisplay(btnAdd);
	   util.click(btnAdd);
	   util.waitUntilElementDisappear(pageSpinner);
   }
   
   public void ClickOnCheckbox() {
	   util.waitUntilElementDisplay(Checkbox);
	   util.click(Checkbox);
	   util.dummyWait(2);
   }
   
   By btnClose = By.xpath("//a[@title='Close']");
   public void ClickOnParcelNoLink() {
	   util.waitUntilElementDisplay(ParcelNoLink);
	   util.click(ParcelNoLink);
	   util.dummyWait(1);
	   util.click(btnClose);
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

   
	    public void ParcelInformation(Map<String, String> map, String testcaseName) {

	    	try {
	    		ClickOnParcelInformation();
    				log("STEP 1: Record Grid should expands below ", Status.PASS);
    			} catch (Exception e) {
    				log("STEP 1:  Record does not expand below", Status.FAIL);
    				throw new RuntimeException("Failed in step 1");
    			}
	    	
    
	    	if(environment.contains("STEELHEAD")) {
	    		try {
		    		 SelectParcelTo(map.get(Excel.SteelheadParcel));
		    			log("STEP 2:User can select Parcel from the Parcel Information DD and Parcel DD is Multiselected DD", Status.PASS);
		    		} catch (Exception e) {
		    			log("STEP 2: User cannot select Parcel from the Parcel Information DD or Parcel DD is not Multiselected DD", Status.FAIL);
		    			throw new RuntimeException("Failed in step 2");
		    		}	
	    	}else {
	    	try {
	    		 SelectParcelTo(map.get(Excel.Parcel));
	    			log("STEP 2: User can select Parcel from the Parcel Information DD and Parcel DD is Multiselected DD", Status.PASS);
	    		} catch (Exception e) {
	    			log("STEP 2: User cannot select Parcel from the Parcel Information DD or Parcel DD is not Multiselected DD", Status.FAIL);
	    			throw new RuntimeException("Failed in step 2");
	    		}
	    	}
	    	
	    	 try {
	    		 ClickOnAddButton();
	    			log("STEP 3:  Added value displays in the below grid ", Status.PASS);
	    		} catch (Exception e) {
	    			log("STEP 3:  Added value can not be display  ", Status.FAIL);
	    			throw new RuntimeException("Failed in step 3");
	    		}
	    	 
           try {
	    		 ClickOnParcelNoLink();
					log("STEP 4:  On click \"Parcel Information\" Pop Up should be appeared   ", Status.PASS);
				} catch (Exception e) {
					log("STEP 4:  Parcel Information Pop up should not be appeared ", Status.FAIL);
					throw new RuntimeException("Failed in step 4 ");
				}
	    	 
	    	 try {
				 ClickonDelete();
					log("STEP 5:  user can click on cross icon   ", Status.PASS);
				} catch (Exception e) {
					log("STEP 5:  Popup Delete does not open", Status.FAIL);
					throw new RuntimeException("Failed in step 5");
				}
		 
			 
			 
			 try {
				 ClickonCancle();
					log("STEP 6: User can click on cancel button  ", Status.PASS);
				} catch (Exception e) {
					log("STEP 6: User cannot click on cancel button", Status.FAIL);
					throw new RuntimeException("Failed in step 6 ");
				}
			 
			 try {
				 ClickonOk();
					log("STEP 7: Deleted record does not display in the grid and 2)Message- Changes saved suessfully! in green displays. ", Status.PASS);
				} catch (Exception e) {
					log("STEP 7: Message- Changes saved sucessfully' does not display", Status.FAIL);
					throw new RuntimeException("Failed in step 7 ");
				
				}
	    	
	    }


}
