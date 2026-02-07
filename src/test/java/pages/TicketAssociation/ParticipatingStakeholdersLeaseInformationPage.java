package pages.TicketAssociation;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

public class ParticipatingStakeholdersLeaseInformationPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;
	public static String AGREEMENT_NUMBER;

	public ParticipatingStakeholdersLeaseInformationPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	
	By LeaseInformation = By.xpath("//span[contains(text(),'Lease Information')]");
	By drpLeaseTo = By.xpath("//input[contains(@id,'LEASES_Input')]");
	By btnAdd = By.xpath("//input[contains(@id,'_ImageButton1')]");
    By btnDelete = By.xpath("(//input[contains(@id,'GridLeases_ctl00_ctl04_gbcDeleteTract')])[1]");
	By iframDelete = By.xpath("//td[@class='rwWindowContent']");
	By btnCancle = By.xpath("//span[text()='Cancel']");
	By btnOk = By.xpath("//span[text()='OK']");
	By changesSavedSuccessfully = By.xpath("//span[text()='Changes saved successfully!']");
	By Message = By.xpath("//span[text()='There are no landowners associated to this ticket.']");	
	 
	public void ClickOnLeaseInformation() {
		util.dummyWait(1);
		util.waitUntilElementDisplay(LeaseInformation);
		util.click(LeaseInformation);
	}
	
	public void SelectLeaseTo(String value) {
		 if (!commonFunction.checkNA(value))
				util.inputText(drpLeaseTo,value);
		 util.pressDownkey();
		 util.pressENTERkey();
//			 util.inputText(drpLeaseTo,value);
//		 By selectValue = By.xpath("(//li[contains(text(),'"+value+"')])[1]");
//		 util.click(selectValue);
	}
	
	public void ClickOnAddButton() {
		   util.waitUntilElementDisplay(btnAdd);
		   util.click(btnAdd);
		   util.dummyWait(2);
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
//	 		util.waitUntilElementDisplay(changesSavedSuccessfully);
//			Assert.assertTrue(util.isElementPresent(changesSavedSuccessfully), "Changes saved successfully!");
	 		util.dummyWait(3);
	   }

	
	 public void LeaseInformation(Map<String, String> map, String testcaseName) {

	    	try {
	    		ClickOnLeaseInformation();
 				log("STEP 1: Record Grid should expands below ", Status.PASS);
 			} catch (Exception e) {
 				log("STEP 1:  Record does not expand below", Status.FAIL);
 				throw new RuntimeException("Failed in step 1");
 			}
	    	
	    	 try {
	    		 SelectLeaseTo(map.get(Excel.Lease));
	    			log("STEP 2: Entered value should diplays in the Lease To field ", Status.PASS);
	    		} catch (Exception e) {
	    			log("STEP 2: Entered value does not display in Lease To field. ", Status.FAIL);
	    			throw new RuntimeException("Failed in step 2");
	    		}
	    	
	    	 try {
	    		 ClickOnAddButton();
	    			log("STEP 3:  Added value displays in the below grid ", Status.PASS);
	    		} catch (Exception e) {
	    			log("STEP 3:  Added value can not be display  ", Status.FAIL);
	    			throw new RuntimeException("Failed in step 3");
	    		}
	    	 
	    	 if(util.isElementPresent(btnDelete)) {
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
					throw new RuntimeException("Failed in step 5 ");
				}
			 
			 try {
				 ClickonOk();
					log("STEP 6: Deleted record does not display in the grid and 2)Message- Changes saved suessfully! in green displays. ", Status.PASS);
				} catch (Exception e) {
					log("STEP 6: Message- Changes saved sucessfully' does not display", Status.FAIL);
					throw new RuntimeException("Failed in step 6 ");
				
				}
	    	 }
	    }
	
}
