package pages.ThirdPartyAgreement;

import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;
import extentReports.ExtentTestManager;

public class TractInformationPage extends BasePage {
	
	TestUtil util;
	CommonFunction commonFunction;
	public static String CROSSING_TYPE, TRACT_NUMBER, CROSSING_NUMBER;
	public TractInformationPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	
	By btnAddNewRecord = By.xpath("//a[contains(@id,'_lnkAddNewRecord')]");
	By drpTractNumber = By.xpath("//input[contains(@id,'_EditFormControl_rcbTracts_Input')]");
	By drpCrossingType = By.xpath("//input[contains(@id,'_EditFormControl_TRACT_CROSSING_TYPES_MSDropDown_Input')]");
	By drpCrossingTypeArrow = By.xpath("//A[contains(@id,'_EditFormControl_TRACT_CROSSING_TYPES_MSDropDown_Arrow')]");
	By txtComments = By.xpath("//textarea[contains(@id,'_EditFormControl_CROSS_COMMENT')]");
	By txtRequestDate = By.xpath("//input[contains(@id,'_EditFormControl_RequestDate_dateInput')]");
	By txtAgreementDate = By.xpath("//input[contains(@id,'_EditFormControl_AgreementDate_dateInput')]");
	By txtCAAANumber = By.xpath("//input[contains(@id,'CAAANumber') and @type='text']");
	By txtExpirationDate = By.xpath("//input[contains(@id,'_EditFormControl_ExpirationDate_dateInput') and @type='text']");
	By txtRequest = By.xpath("//textarea[contains(@id,'txtRequestComments')]");
	By txtAgreementConditions = By.xpath("//textarea[contains(@id,'txtAgreementConditions')]");
	By btnInsert = By.xpath("//input[contains(@id,'_EditFormControl_btnInsert')]");
	By successMessage = By.xpath("//span[text()='Changes saved successfully!']");
	By navParcel = By.xpath("//span[text()='Parcel'] | //span[text()='Tract']");
	By navParcelInfo = By.xpath("//span[text()='Parcel Info'] | //span[text()='Tract Info']");
	By navParcelInformation = By.xpath("//span[contains(text(),'Parcel Information')] | //span[contains(text(),'Tract Information')] | //span[contains(text(),'Record Information')]");
	By navCrossingDetails = By.xpath("//span[text()='Crossing Details']");
	By navProjectMenu = By.xpath("//a//span[@class='rmText rmExpandDown' and contains(text(),'Project')] ");
	By navThirdPartyAgreements = By.xpath("//a//span[contains(text(),'Third Party Agreements')] ");
	By txtCrossingNumber = By.xpath("//input[contains(@id,'OBJPROJECTINFO_CROSSING_NUMBER') and @type='text']");
	By btnUpdate = By.xpath("//input[contains(@id,'_EditFormControl_btnUpdate')]");
	By deleteOk = By.xpath("//a[contains(@onClick,'confirm')]//span[text()='OK']");
	By spinner = By.xpath("//img[contains(@id,'_Image2') and @alt='loading']");
	
	// Clicks the "Add New Record" button
	public void clickAddNewRecord() {
	    util.waitUntilElementDisplay(btnAddNewRecord);
	    util.click(btnAddNewRecord);
	}

	// Sets the Tract Number
	public void setTractNumber(String tractNumber) {
	    util.waitUntilElementDisplay(drpTractNumber);
	    util.inputText(drpTractNumber, tractNumber);
	    By selectDrpValue = By.xpath("//div[contains(@id,'EditFormControl_rcbTracts_DropDown')]/..//em[text()='"+tractNumber+"']");
	   util.click(selectDrpValue);
	}

	// Sets the Random Tract Number
	public void setTractNumber() {
	    util.waitUntilElementDisplay(drpTractNumber);
	   util.click(drpTractNumber);
	    By selectDrpValue = By.xpath("(//li[contains(@class, 'rcbItem')])[1]");
	    TRACT_NUMBER = util.getText(selectDrpValue);
	    System.out.println("TRACT_NUMBER: " + TRACT_NUMBER);
	   util.click(selectDrpValue);
	}
	
	// Sets the Crossing Type
	public void setCrossingType(String crossingType) {
	    util.waitUntilElementDisplay(drpCrossingType);
	    util.click(drpCrossingType);
	    By selectDrpValue = By.xpath("//div[contains(@id,'_EditFormControl_TRACT_CROSSING_TYPES_MSDropDown_DropDown')]/..//*[normalize-space()='"+crossingType+"']//input[@type='checkbox']");
	    CROSSING_TYPE = crossingType;
	    util.click(selectDrpValue);
	    util.click(drpCrossingTypeArrow); 
	}

	// Sets Comments
	public void setComments(String comments) {
	    util.waitUntilElementDisplay(txtComments);
	    util.inputTextAndPressTab(txtComments, comments);
	}

	// Sets Request Date
	public void setRequestDate(String requestDate) {
	    util.waitUntilElementDisplay(txtRequestDate);
	    util.inputTextAndPressTab(txtRequestDate, requestDate);
	}

	// Sets Agreement Date
	public void setAgreementDate(String agreementDate) {
	    util.waitUntilElementDisplay(txtAgreementDate);
	    util.inputTextAndPressTab(txtAgreementDate, agreementDate);
	}

	// Sets CAAANumber
	public void setCAAANumber(String caaaNumber) {
	    util.waitUntilElementDisplay(txtCAAANumber);
	    util.inputTextAndPressTab(txtCAAANumber, caaaNumber);
	}

	// Sets Expiration Date
	public void setExpirationDate(String expirationDate) {
	    util.waitUntilElementDisplay(txtExpirationDate);
	    util.inputTextAndPressTab(txtExpirationDate, expirationDate);
	}

	// Sets Request Comments
	public void setRequestComments(String requestComments) {
	    util.waitUntilElementDisplay(txtRequest);
	    util.inputTextAndPressTab(txtRequest, requestComments);
	}

	// Sets Agreement Conditions
	public void setAgreementConditions(String agreementConditions) {
	    util.waitUntilElementDisplay(txtAgreementConditions);
	    util.inputTextAndPressTab(txtAgreementConditions, agreementConditions);
	}

	// Clicks the Insert button
	public void clickInsert() {
	    util.waitUntilElementDisplay(btnInsert);
	    util.click(btnInsert);
	}
	
	public void navigateParcelInformation() {
		util.waitUntilElementDisplay(navParcel);
		util.click(navParcel);
		util.waitUntilElementDisplay(navParcelInfo);
		util.click(navParcelInfo);
		util.waitUntilElementDisplay(navParcelInformation);
		util.click(navParcelInformation);		
	}
	
	public void navigateCrossingDetails() {
		util.waitUntilElementDisplay(navCrossingDetails);
		util.click(navCrossingDetails);		
	}
	
	public void navigateToThirdPartyAgreement() {
		util.waitUntilElementDisplay(navProjectMenu);
		util.click(navProjectMenu);
		util.waitUntilElementDisplay(navThirdPartyAgreements);
		util.click(navThirdPartyAgreements);
		util.waitUntilPageLoad();
	}
	
	public void clickUpdate() {
	    util.waitUntilElementDisplay(btnUpdate);
	    util.click(btnUpdate);
	}
	
	public void addTractInformation(Map<String, String> map, String testCaseName) {
		  
		    try {
		    	CROSSING_NUMBER=util.getAttributeValue(txtCrossingNumber, "value");
		        clickAddNewRecord();
		        util.dummyWait(1);
		        log("STEP 1: User can Clicked Add New Record", Status.PASS);
		    } catch (Exception e) {
		        log("STEP 1: User Failed to click Add New Record", Status.FAIL);
		        throw new RuntimeException("Failed in step 1");
		    }
		    try {
		        setTractNumber();
		        log("STEP 2: User can Set Tract Number", Status.PASS);
		    } catch (Exception e) {
		        log("STEP 2: User Failed to set Tract Number", Status.FAIL);
		        throw new RuntimeException("Failed in step 2");
		    }
		    try {
		        setCrossingType(map.get(Excel.CrossingType));
		        log("STEP 3: User can Set Crossing Type", Status.PASS);
		    } catch (Exception e) {
		        log("STEP 3: User Failed to set Crossing Type", Status.FAIL);
		        throw new RuntimeException("Failed in step 3");
		    }
		    try {
		        setComments(map.get(Excel.Comments));
		        log("STEP 4: User can Set Comments", Status.PASS);
		    } catch (Exception e) {
		        log("STEP 4: User Failed to set Comments", Status.FAIL);
		        throw new RuntimeException("Failed in step 4");
		    }
		    try {
		        setRequestDate(map.get(Excel.RequestDate));
		        log("STEP 5: User can Set Request Date", Status.PASS);
		    } catch (Exception e) {
		        log("STEP 5: User Failed to set Request Date", Status.FAIL);
		        throw new RuntimeException("Failed in step 5");
		    }
		    try {
		        setAgreementDate(map.get(Excel.AgreementDate));
		        log("STEP 6: User can Set Agreement Date", Status.PASS);
		    } catch (Exception e) {
		        log("STEP 6: User Failed to set Agreement Date", Status.FAIL);
		        throw new RuntimeException("Failed in step 6");
		    }
		    try {
		        setCAAANumber(map.get(Excel.CAAANumber));
		        log("STEP 7: User can Set CAAANumber", Status.PASS);
		    } catch (Exception e) {
		        log("STEP 7: User Failed to set CAAANumber", Status.FAIL);
		        throw new RuntimeException("Failed in step 7");
		    }
		    try {
		        setExpirationDate(map.get(Excel.ExpirationDate));
		        log("STEP 8: User can Set Expiration Date", Status.PASS);
		    } catch (Exception e) {
		        log("STEP 8: User Failed to set Expiration Date", Status.FAIL);
		        throw new RuntimeException("Failed in step 8");
		    }
		    try {
		        setRequestComments(map.get(Excel.RequestComments));
		        log("STEP 9: User can Set Request Comments", Status.PASS);
		    } catch (Exception e) {
		        log("STEP 9: User Failed to set Request Comments", Status.FAIL);
		        throw new RuntimeException("Failed in step 9");
		    }
		    try {
		        setAgreementConditions(map.get(Excel.AgreementConditions));
		        log("STEP 10: User can Set Agreement Conditions", Status.PASS);
		    } catch (Exception e) {
		        log("STEP 10: User Failed to set Agreement Conditions", Status.FAIL);
		        throw new RuntimeException("Failed in step 10");
		    }
		    try {
		        clickInsert();
		        util.dummyWait(1);
		        log("STEP 11: User can Clicked Insert", Status.PASS);
		    } catch (Exception e) {
		        log("STEP 11: User Failed to click Insert", Status.FAIL);
		        throw new RuntimeException("Failed in step 11");
		    }
		    
			try {
				Assert.assertTrue(util.isElementVisible(successMessage));
				ExtentTestManager.infoWithScreenshot("Tract Information successfully Added");
				log("STEP 12: Success Message displayed", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 12: Success Message not displaying", Status.FAIL);
			}

			try {
				navigateParcelInformation();
				util.waitUntilPageLoad();
				log("STEP 13: User can navigate to Tract Information", Status.PASS);
			} catch (Exception e) {
				log("STEP 13: User cannot navigate to Tract Information", Status.FAIL);
				throw new RuntimeException("Failed in step 13");
			}

			try {
				By addedRecord = By.xpath("(//td[text()='" + TRACT_NUMBER + "']/parent::tr)[1]");
				util.click(addedRecord);
				util.waitUntilElementDisappear(spinner);
				log("STEP 14: User can select Tract", Status.PASS);
			} catch (Exception e) {
				log("STEP 14: User cannot select Tract", Status.FAIL);
				throw new RuntimeException("Failed in step 14");
			}
			
			try {
				navigateCrossingDetails();
				log("STEP 15: User can navigate to Crossing Details Panel", Status.PASS);
			} catch (Exception e) {
				log("STEP 15: User cannot navigate to Crossing Details Panel", Status.FAIL);
				throw new RuntimeException("Failed in step 15");
			}
			
			try {
				By crossingStatus = By.xpath("(//tr[contains(@id,'TRACTCROSSINGINFO_rgROGrid')]/..//td[text()='"+ThirdPartyInformationPage.CROSSING_STATUS+"'])[1]");
				Assert.assertTrue(util.isElementVisible(crossingStatus));
				log("STEP 16: User can Crossing Satus on the Crossing Details Panel", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 16: User cannot Crossing Satus on the Crossing Details Panel", Status.FAIL);
			}			
		}
	
	public void editTractInformation(Map<String, String> map, String testCaseName) {
		  
		try {
	    	navigateToThirdPartyAgreement();
	    	util.waitUntilPageLoad();
	    	By selectAgreement = By.xpath("//td[text()='"+CROSSING_NUMBER+"']/parent::tr");
			util.click(selectAgreement);
			util.waitUntilPageLoad();
	        log("STEP 1: User can navigate to Third Party Agreement", Status.PASS);
	    } catch (Exception e) {
	        log("STEP 1: User cannot navigate to Third Party Agreement", Status.FAIL);
	        throw new RuntimeException("Failed in step 1");
	    }
		
	    try {
	    	By editRecord = By.xpath("//tr[contains(@id,'CROSSTRACT_grdCrossingTracts_radYALGridControl')]/..//td[text()='"+TRACT_NUMBER+"']/..//input[@title='Edit']");
			util.click(editRecord);
	        util.dummyWait(1);
	        log("STEP 2: User can Clicked Edit Icon", Status.PASS);
	    } catch (Exception e) {
	        log("STEP 2: User Failed to click Edit Icon", Status.FAIL);
	        throw new RuntimeException("Failed in step 2");
	    }
	    
	    try {
	        setCrossingType(map.get(Excel.CrossingType));
	        log("STEP 3: User can Set Crossing Type", Status.PASS);
	    } catch (Exception e) {
	        log("STEP 3: User Failed to set Crossing Type", Status.FAIL);
	        throw new RuntimeException("Failed in step 3");
	    }
	    try {
	        setComments(map.get(Excel.Comments));
	        log("STEP 4: User can Set Comments", Status.PASS);
	    } catch (Exception e) {
	        log("STEP 4: User Failed to set Comments", Status.FAIL);
	        throw new RuntimeException("Failed in step 4");
	    }
	    try {
	        setRequestDate(map.get(Excel.RequestDate));
	        log("STEP 5: User can Set Request Date", Status.PASS);
	    } catch (Exception e) {
	        log("STEP 5: User Failed to set Request Date", Status.FAIL);
	        throw new RuntimeException("Failed in step 5");
	    }
	    try {
	        setAgreementDate(map.get(Excel.AgreementDate));
	        log("STEP 6: User can Set Agreement Date", Status.PASS);
	    } catch (Exception e) {
	        log("STEP 6: User Failed to set Agreement Date", Status.FAIL);
	        throw new RuntimeException("Failed in step 6");
	    }
	    try {
	        setCAAANumber(map.get(Excel.CAAANumber));
	        log("STEP 7: User can Set CAAANumber", Status.PASS);
	    } catch (Exception e) {
	        log("STEP 7: User Failed to set CAAANumber", Status.FAIL);
	        throw new RuntimeException("Failed in step 7");
	    }
	    try {
	        setExpirationDate(map.get(Excel.ExpirationDate));
	        log("STEP 8: User can Set Expiration Date", Status.PASS);
	    } catch (Exception e) {
	        log("STEP 8: User Failed to set Expiration Date", Status.FAIL);
	        throw new RuntimeException("Failed in step 8");
	    }
	    try {
	        setRequestComments(map.get(Excel.RequestComments));
	        log("STEP 9: User can Set Request Comments", Status.PASS);
	    } catch (Exception e) {
	        log("STEP 9: User Failed to set Request Comments", Status.FAIL);
	        throw new RuntimeException("Failed in step 9");
	    }
	    try {
	        setAgreementConditions(map.get(Excel.AgreementConditions));
	        log("STEP 10: User can Set Agreement Conditions", Status.PASS);
	    } catch (Exception e) {
	        log("STEP 10: User Failed to set Agreement Conditions", Status.FAIL);
	        throw new RuntimeException("Failed in step 10");
	    }
	    try {
	    	clickUpdate();
	        util.dummyWait(1);
	        log("STEP 11: User can Clicked Update button", Status.PASS);
	    } catch (Exception e) {
	        log("STEP 11: User Failed to click Update button", Status.FAIL);
	        throw new RuntimeException("Failed in step 11");
	    }
	    
		try {
			Assert.assertTrue(util.isElementVisible(successMessage));
			log("STEP 12: Success Message displayed", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 12: Success Message not displaying", Status.FAIL);
		}				
	}
	
	public void deleteTractInformation(String testCaseName) {
		
		try {
			By deleteRecord = By.xpath("//tr[contains(@id,'CROSSTRACT_grdCrossingTracts_radYALGridControl')]/..//td[text()='"+TRACT_NUMBER+"']/..//input[@title='Delete']");
			util.click(deleteRecord);
			log("STEP 1:User can click on delete icon  ", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: User cannot click on delete icon ", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}
		
		try {
			util.click(deleteOk);
			util.dummyWait(1);
			log("STEP 2: User can click on ok button ", Status.PASS);
		} catch (Exception e) {
			log("STEP 2: User cannot click on ok button ", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}

		try {
			Assert.assertTrue(util.isElementVisible(successMessage));
			log("STEP 3: Success Message displayed", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 3: Success Message not displaying", Status.FAIL);
		}

	}
}
