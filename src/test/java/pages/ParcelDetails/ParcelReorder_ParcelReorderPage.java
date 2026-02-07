package pages.ParcelDetails;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.util.CommonFunction;
import com.util.TestUtil;

public class ParcelReorder_ParcelReorderPage extends BasePage {
	
	TestUtil util;
	CommonFunction commonFunction;
	public static String AGREEMENT_NUMBER;

	public ParcelReorder_ParcelReorderPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}

	By navParcel = By.xpath("//span[text()='Parcel']");
	By navParcelInfo = By.xpath("//span[text()='Parcel Info']");
	By navParcelInformation = By.xpath("//span[contains(text(),'Parcel Information')]");
	By navDownArrow = By.xpath("//img[@onclick='showMenu(event)']");
	By btnReorder = By.xpath("//span[contains(text(),'Reorder')]");
	By iframe = By.xpath("//iframe[@name='TractMenu']");
	By ShowOffline = By.xpath("//input[contains(@id,'RadGridTracts_ctl00_ctl02_ctl00_chkShowOffline') and @type='checkbox']");
    By dragAlt = By.xpath("//tr[@id='RadGridTracts_ctl00__0']");
    By dropAlt = By.xpath("//tr[@id='RadGridTracts_ctl00__1']");
	By  Successfulmassage   = By.xpath("//span[text()='Reorder Saved successfully.']");
	By btnRefresh = By.xpath("//img[@id='RadGridTracts_ctl00_ctl02_ctl00_Img1']");


	public void navigateParcelInformation() {
		util.waitUntilElementDisplay(navParcel);
		util.click(navParcel);
		util.waitUntilElementDisplay(navParcelInfo);
		util.click(navParcelInfo);
		util.waitUntilElementDisplay(navParcelInformation);
		util.click(navParcelInformation);
		
		
	}
       public void navDownArrow() {
  	    util.waitUntilElementDisplay(navDownArrow);
		util.click(navDownArrow);
		
      }
  
       
     public void ShowOffline() {		
    	    util.waitUntilElementDisplay(ShowOffline);
			util.click(ShowOffline);
			
	 }
	
        

     public void Reorder() {
    	 util.waitUntilElementDisplay(btnReorder);
			util.click(btnReorder);
	 }
     
     public void draganddrop() {
    	 WebElement dropElement = driver.findElement(By.xpath("//tr[@id='RadGridTracts_ctl00__0']"));
    	 WebElement dragElement = driver.findElement(By.xpath("//tr[@id='RadGridTracts_ctl00__1']"));
		Actions act = new Actions(driver);
		act.dragAndDrop(dragElement, dropElement).build().perform();
		util.waitUntilElementDisplay(Successfulmassage);
		Assert.assertTrue(util.isElementPresent(Successfulmassage), "Reorder Saved successfully.");
	 }
     
     public void draganddropDot() {
    	 WebElement dropElement = driver.findElement(By.xpath("//tr[@id='RadGridTracts_ctl00__1']"));
    	 WebElement dragElement = driver.findElement(By.xpath("//tr[@id='RadGridTracts_ctl00__3']"));
		Actions act = new Actions(driver);
		act.dragAndDrop(dragElement, dropElement).build().perform();
	 }
  
     By btnClose = By.xpath("//a[@title='Close']");
    public void Refresh() {
    	util.waitUntilElementDisplay(btnRefresh);
		util.click(btnRefresh);
		util.switchToDefaultContent();
		util.waitUntilElementDisplay(btnClose);
		util.click(btnClose);
	}
    
    public void RefreshAlt() {
    	util.waitUntilElementDisplay(btnRefresh);
		util.click(btnRefresh);
		
	}

        public void ParcelReorder(String testcaseName)
       {	
        	util.dummyWait(3);
        	try {
        		navDownArrow();
    			log("STEP 1: User can click on downward arrow & menu should be displayed.    ", Status.PASS);
    		} catch (Exception e) {
    			log("STEP 1: User cannot click on downward arrow   ", Status.FAIL);
    			throw new RuntimeException("Failed in step 1");
    		}

    	 try {
        		Reorder();
        	     log("STEP 2:   User can click on reorder option  ", Status.PASS);
        	   } catch (Exception e) {
        	     log("STEP 2:  User cannot click on reorder option   ", Status.FAIL);
        	   	throw new RuntimeException("Failed in step 2");
        	  }
        	if(testcaseName.contains("DOT")) {    	 
         try {
        				  
        	  util.switchToIframe(iframe);
        	  	ShowOffline();
        	   	log("STEP 3:   User can check/uncheck show offline checkbox.    ", Status.PASS);
        	 } catch (Exception e) {
        	   	log("STEP 3:  User cannot check/uncheck show offline checkbox.  ", Status.FAIL);
        	   	throw new RuntimeException("Failed in step 3");
        	 }
         
         try {
        	 util.dummyWait(2);
            	draganddropDot();
            	log("STEP 4:   User can drag & drop any tract to up & down.  ", Status.PASS);
           } catch (Exception e) {
            	log("STEP 4:  User cannot drag & drop any tract to left & right side.   ", Status.FAIL);
            	throw new RuntimeException("Failed in step 4");
           	}
      
      try {
     	    Refresh();
         	log("STEP 5: User can click on refresh button ", Status.PASS);
        } catch (Exception e) {
         	log("STEP 5: User cannot click on refresh button. ", Status.FAIL);
         	throw new RuntimeException("Failed in step 5");
        	}
         
        }		
        
        	else {
        		 
        			Set<String> windowId = driver.getWindowHandles(); // get window id of current window
        			Iterator<String> itererator = windowId.iterator();
        			String mainWinID = itererator.next();
        			String newAdwinID = itererator.next();
        			System.out.println(mainWinID);
        			System.out.println(newAdwinID);
        			
        		  
                try {
                	util.dummyWait(3);
                	driver.switchTo().window(newAdwinID);
                   	draganddrop();
                   	log("STEP 3:   User can drag & drop any tract to up & down.  ", Status.PASS);
                  } catch (Exception e) {
                   	log("STEP 3:  User cannot drag & drop any tract to left & right side.   ", Status.FAIL);
                   	throw new RuntimeException("Failed in step 3");
                  	}
             
             try {
            	    RefreshAlt();
            	    util.dummyWait(2);
            	    driver.close();
        			driver.switchTo().window(mainWinID);
                	log("STEP 4: User can click on refresh button ", Status.PASS);
               } catch (Exception e) {
                	log("STEP 4: User cannot click on refresh button. ", Status.FAIL);
                	throw new RuntimeException("Failed in step 4");
               	}
        		
        	}
			  util.dummyWait(5);
         }

}
