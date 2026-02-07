package pages.Compensation;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

public class AddPaymentObligationRecordPage extends BasePage {

	TestUtil util;
	CommonFunction commonFunction;
	public static String AGREEMENT_NUMBER;

	public AddPaymentObligationRecordPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	
	By btnAddNew = By.xpath("//input[@id='ctl00_ConPHRightTop_TRCD2_UC_radPanels_i3_i0_btnAddPMObligation']");
	By iframePayment = By.xpath("//iframe[@name='AddPayment']");
	By txtAssocAgreement = By.xpath("//input[contains(@id,'Agreement_IDs_YALComboBox_Input') and @type='text']");
	By drpMethodofPayment = By.xpath("//input[contains(@id,'combo_CheckType_YALComboBox_Input') and @type='text']"); 
	By firstMethodofPayment = By.xpath("(//*[@id=\"combo_CheckType_YALComboBox_DropDown\"]/..//li)[1]");
	By txtDueDate = By.xpath("//input[contains(@id,'RAD_DUE_DATE_dateInput') and @type='text']");
	By txtAcquisitionPaymentComment = By.xpath("//textarea[contains(@id,'rptCompensation_ctl01_Comment')]");
	By txtAcquisitionPaymentArea = By.xpath("//input[@id='rptCompensation_ctl01_Area']");
	By drpAcquisitionPaymentUnits = By.xpath("//input[@id='rptCompensation_ctl01_Unit_ID_radYALDropDownList_Input']");
	By txtCostPerUnit = By.xpath("//input[@id='rptCompensation_ctl01_Cost_Per_Unit']");
	By txtAdditionalLinesPrepaymentComment = By.xpath("//textarea[contains(@id,'rptCompensation_ctl02_Comment')]");
	By txtAdditionalLinesPrepaymentArea = By.xpath("//input[@id='rptCompensation_ctl02_Area']");
	By drpAdditionalLinesPrepaymentUnits = By.xpath("//input[@id='rptCompensation_ctl02_Unit_ID_radYALDropDownList_Input']");
	By txtPrepaymentCostPerUnit = By.xpath("//input[@id='rptCompensation_ctl02_Cost_Per_Unit']");
	By txtConsiderationComment = By.xpath("//textarea[contains(@id,'rptCompensation_ctl03_Comment')]");
	By txtConsiderationArea = By.xpath("//input[@id='rptCompensation_ctl03_Area']");
	By drpConsiderationUnits = By.xpath("//input[@id='rptCompensation_ctl03_Unit_ID_radYALDropDownList_Input']");
	By txtConsiderationCostPerUnit = By.xpath("//input[@id='rptCompensation_ctl03_Cost_Per_Unit']");
	By txtCropDamagesComment = By.xpath("//textarea[contains(@id,'rptCompensation_ctl04_Comment')]");
	By txtCropDamagesArea = By.xpath("//input[@id='rptCompensation_ctl04_Area']");
	By drpCropDamagesUnits = By.xpath("//input[@id='rptCompensation_ctl04_Unit_ID_radYALDropDownList_Input']");
	By txtCropDamagesCostPerUnit = By.xpath("//input[@id='rptCompensation_ctl04_Cost_Per_Unit']");
	By txtFinalPaymentComment = By.xpath("//textarea[contains(@id,'rptCompensation_ctl05_Comment')]");
	By txtFinalPaymentArea = By.xpath("//input[@id='rptCompensation_ctl05_Area']");
	By drpFinalPaymentUnits = By.xpath("//input[@id='rptCompensation_ctl05_Unit_ID_radYALDropDownList_Input']");
	By txtFinalPaymentCostPerUnit = By.xpath("//input[@id='rptCompensation_ctl05_Cost_Per_Unit']");
	By txtOtherComment = By.xpath("//textarea[contains(@id,'rptCompensation_ctl06_Comment')]");
	By txtOtherArea = By.xpath("//input[@id='rptCompensation_ctl06_Area']");
	By drpOtherUnits = By.xpath("//input[@id='rptCompensation_ctl06_Unit_ID_radYALDropDownList_Input']");
	By txtOtherCostPerUnit = By.xpath("//input[@id='rptCompensation_ctl06_Cost_Per_Unit']");
	By txtRoadComment = By.xpath("//textarea[contains(@id,'rptCompensation_ctl07_Comment')]");
	By txtRoadArea = By.xpath("//input[@id='rptCompensation_ctl07_Area']");
	By drpRoadUnits = By.xpath("//input[@id='rptCompensation_ctl07_Unit_ID_radYALDropDownList_Input']");
	By txtRoadCostPerUnit = By.xpath("//input[@id='rptCompensation_ctl07_Cost_Per_Unit']");
	By txtWayPaymentComment = By.xpath("//textarea[contains(@id,'rptCompensation_ctl08_Comment')]");
	By txtWayPaymentArea = By.xpath("//input[@id='rptCompensation_ctl08_Area']");
	By drpWayPaymentUnits = By.xpath("//input[@id='rptCompensation_ctl08_Unit_ID_radYALDropDownList_Input']");
	By txtWayPaymentCostPerUnit = By.xpath("//input[@id='rptCompensation_ctl08_Cost_Per_Unit']");
	By txtTimberDamagesComment = By.xpath("//textarea[contains(@id,'rptCompensation_ctl09_Comment')]");
	By txtTimberDamagesArea = By.xpath("//input[@id='rptCompensation_ctl09_Area']");
	By drpTimberDamagesUnits = By.xpath("//input[@id='rptCompensation_ctl09_Unit_ID_radYALDropDownList_Input']");
	By txtTimberDamagesCostPerUnit = By.xpath("//input[@id='rptCompensation_ctl09_Cost_Per_Unit']"); 
	By btnSave = By.xpath("//input[@id='btnSave1']");
    By changesSavedSuccessfully = By.xpath("//span[text()='Changes saved successfully!']");

    
	public void ClickOnAddNewRecord() {
		util.waitUntilElementDisplay(btnAddNew);
		util.click(btnAddNew);
		util.switchToIframe(iframePayment);
		util.dummyWait(2);
	}
	
	public void AddAssocAgreement(String value) {
		
		if (!commonFunction.checkNA(value))
  			util.inputTextAndPressTab(txtAssocAgreement, value);
	}
	
	public void SelectMethodofPayment(String value) {
		if (!commonFunction.checkNA(value))
  			util.inputTextAndPressTab(drpMethodofPayment, value);
	}
	
	public void SelectMethodofPayment() {
		util.click(drpMethodofPayment);
		util.waitFor(100);
		util.click(firstMethodofPayment);
	}
	
	public void AddDueDate(String value) {
		if (!commonFunction.checkNA(value))
  			util.inputTextAndPressTab(txtDueDate, value);
	}
	
	public void AddAcquisitionPaymentComment(String value) {
		if (!commonFunction.checkNA(value))
  			util.inputTextAndPressTab(txtAcquisitionPaymentComment, value);
	}
	
	public void AddAcquisitionPaymentArea(String value) {
		if (!commonFunction.checkNA(value))
  			util.inputTextAndPressTab(txtAcquisitionPaymentArea, value);
	}
	
	public void SelectAcquisitionPaymentUnits(String value) {
		if (!commonFunction.checkNA(value))
  			util.inputTextAndPressTab(drpAcquisitionPaymentUnits, value);
	}
	
	public void AddCostPerUnit(String value) {
		if (!commonFunction.checkNA(value))
  			util.inputTextAndPressTab(txtCostPerUnit, value);
	}
	
	public void AddAdditionalLinesPrepaymentComment(String value) {
		if (!commonFunction.checkNA(value))
  			util.inputTextAndPressTab(txtAdditionalLinesPrepaymentComment, value);
	}
	
	public void AddAdditionalLinesPrepaymentArea(String value) {
		if (!commonFunction.checkNA(value))
  			util.inputTextAndPressTab(txtAdditionalLinesPrepaymentArea, value);
	}
	
	public void SelectAdditionalLinesPrepaymentUnits(String value) {
		if (!commonFunction.checkNA(value))
  			util.inputTextAndPressTab(drpAdditionalLinesPrepaymentUnits, value);
	}
	
	public void AddPrepaymentCostPerUnit(String value) {
		if (!commonFunction.checkNA(value))
  			util.inputTextAndPressTab(txtPrepaymentCostPerUnit, value);
	}
	
	
	public void AddConsiderationComment(String value) {
		if (!commonFunction.checkNA(value))
  			util.inputTextAndPressTab(txtConsiderationComment, value);
	}
	
	public void AddConsiderationArea(String value) {
		if (!commonFunction.checkNA(value))
  			util.inputTextAndPressTab(txtConsiderationArea, value);
	}
	
	public void SelectConsiderationUnits(String value) {
		if (!commonFunction.checkNA(value))
  			util.inputTextAndPressTab(drpConsiderationUnits, value);
	}
	
	public void AddConsiderationCostPerUnit(String value) {
		if (!commonFunction.checkNA(value))
  			util.inputTextAndPressTab(txtConsiderationCostPerUnit, value);
	}
	
	public void AddCropDamagesComment(String value) {
		if (!commonFunction.checkNA(value))
  			util.inputTextAndPressTab(txtCropDamagesComment, value);
	}
	
	public void AddCropDamagesArea(String value) {
		if (!commonFunction.checkNA(value))
  			util.inputTextAndPressTab(txtCropDamagesArea, value);
	}
	
	public void SelectCropDamagesUnits(String value) {
		if (!commonFunction.checkNA(value))
  			util.inputTextAndPressTab(drpCropDamagesUnits, value);
	}
	
	public void AddCropDamagesCostPerUnit(String value) {
		if (!commonFunction.checkNA(value))
  			util.inputTextAndPressTab(txtCropDamagesCostPerUnit, value);
	}

	public void AddFinalPaymentComment(String value) {
		if (!commonFunction.checkNA(value))
  			util.inputTextAndPressTab(txtFinalPaymentComment, value);
	}
	
	public void AddFinalPaymentArea(String value) {
		if (!commonFunction.checkNA(value))
  			util.inputTextAndPressTab(txtFinalPaymentArea, value);
	}
	
	public void SelectFinalPaymentUnits(String value) {
		if (!commonFunction.checkNA(value))
  			util.inputTextAndPressTab(drpFinalPaymentUnits, value);
	}
	
	public void AddFinalPaymentCostPerUnit(String value) {
		if (!commonFunction.checkNA(value))
  			util.inputTextAndPressTab(txtFinalPaymentCostPerUnit, value);
	}

	public void AddOtherComment(String value) {
		if (!commonFunction.checkNA(value))
  			util.inputTextAndPressTab(txtOtherComment, value);
	}
	
	public void AddOtherArea(String value) {
		if (!commonFunction.checkNA(value))
  			util.inputTextAndPressTab(txtOtherArea, value);
	}
	
	public void SelectOtherUnits(String value) {
		if (!commonFunction.checkNA(value))
  			util.inputTextAndPressTab(drpOtherUnits, value);
	}
	
	public void AddOtherCostPerUnit(String value) {
		if (!commonFunction.checkNA(value))
  			util.inputTextAndPressTab(txtOtherCostPerUnit, value);
	}

	
	public void AddRoadComment(String value) {
		if (!commonFunction.checkNA(value))
  			util.inputTextAndPressTab(txtRoadComment, value);
	}
	
	public void AddRoadArea(String value) {
		if (!commonFunction.checkNA(value))
  			util.inputTextAndPressTab(txtRoadArea, value);
	}
	
	public void SelectRoadUnits(String value) {
		if (!commonFunction.checkNA(value))
  			util.inputTextAndPressTab(drpRoadUnits, value);
	}
	
	public void AddRoadCostPerUnit(String value) {
		if (!commonFunction.checkNA(value))
  			util.inputTextAndPressTab(txtRoadCostPerUnit, value);
	}
	
	public void AddWayPaymentComment(String value) {
		if (!commonFunction.checkNA(value))
  			util.inputTextAndPressTab(txtWayPaymentComment, value);
	}
	
	public void AddWayPaymentArea(String value) {
		if (!commonFunction.checkNA(value))
  			util.inputTextAndPressTab(txtWayPaymentArea, value);
	}
	
	public void SelectWayPaymentUnits(String value) {
		if (!commonFunction.checkNA(value))
  			util.inputTextAndPressTab(drpWayPaymentUnits, value);
	}
	
	public void AddWayPaymentCostPerUnit(String value) {
		if (!commonFunction.checkNA(value))
  			util.inputTextAndPressTab(txtWayPaymentCostPerUnit, value);
	}
	
	public void AddTimberDamagesComment(String value) {
		if (!commonFunction.checkNA(value))
  			util.inputTextAndPressTab(txtTimberDamagesComment, value);
	}
	
	public void AddTimberDamagesArea(String value) {
		if (!commonFunction.checkNA(value))
  			util.inputTextAndPressTab(txtTimberDamagesArea, value);
	}
	
	public void SelectTimberDamagesUnits(String value) {
		if (!commonFunction.checkNA(value))
  			util.inputTextAndPressTab(drpTimberDamagesUnits, value);
	}
	
	public void AddTimberDamagesCostPerUnit(String value) {
		if (!commonFunction.checkNA(value))
  			util.inputTextAndPressTab(txtTimberDamagesCostPerUnit, value);
	}

	By btnClose = By.xpath("//a[@class='rwCloseButton']");
	public void ClickOnSaveButton() {
		util.waitUntilElementDisplay(btnSave);
		util.click(btnSave);
		if(!util.isElementPresent(btnSubmit)){
			util.click(btnSave);
		}
		util.dummyWait(1);
	}
	
	By btnSubmit = By.xpath("//input[@id='btnSubmit']");
	By btnRefresh = By.xpath("//a[contains(@id,'_DYNAMICCHECK_radYALGridControl_ctl00_ctl02_ctl00_Button1')]");
	public void ClickOnSubmitButton() {
		util.waitUntilElementDisplay(btnSubmit);
		util.click(btnSubmit);
		util.switchToDefaultContent();
		util.click(btnClose);
		util.click(btnRefresh);
		util.dummyWait(2);
		
	}
	
	public void AddPaymentObligationRecord(Map<String, String> map, String testcaseName) {
		
		try {
			ClickOnAddNewRecord();
				log("STEP 1: Manage Payment pop up should be open seperately ", Status.PASS);
			 } catch (Exception e) {
				log("STEP 1: Manage Payment pop up should not appear ", Status.FAIL);
				throw new RuntimeException("Failed in step 1");
			 }

		if(util.isElementVisible(txtAssocAgreement)) {
	   	 try {
	   		AddAssocAgreement(map.get(Excel.AssocAgreement));
				log("STEP 2: Selected value display in the  Assoc. Agreement DD  ", Status.PASS);
			 } catch (Exception e) {
				log("STEP 2: No value displays in the Dropdown  ", Status.FAIL);
				throw new RuntimeException("Failed in step 2");
			 }
	   	 
		}
	   	 try {
	   		SelectMethodofPayment();
				log("STEP 3: Selected value display in the  Method of Payment DD   ", Status.PASS);
			} catch (Exception e) {
				log("STEP 3: selected value does not display in  Method of Payment.  ", Status.FAIL);
				throw new RuntimeException("Failed in step 3");
			}
	   	 
	   	 
	   	try {
	   		AddDueDate(map.get(Excel.DueDate));
				log("STEP 4: User can select the  Date  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 4: User  cannot select  Date  from Date Picker  ", Status.FAIL);
				throw new RuntimeException("Failed in step 4");
			}
	   	
	   	try {
	   		AddAcquisitionPaymentComment(map.get(Excel.AcquisitionPaymentComment));
				log("STEP 5: Entered value should display in the comment  field   ", Status.PASS);
			} catch (Exception e) {
				log("STEP 5: Entered value does not display in comment field.  ", Status.FAIL);
				throw new RuntimeException("Failed in step 5");
			}
	   	
	   	if(util.isElementVisible(txtAcquisitionPaymentArea)) {
		try {
			AddAcquisitionPaymentArea(map.get(Excel.AcquisitionPaymentArea));
				log("STEP 6: Entered value should display in the area  field. ", Status.PASS);
			} catch (Exception e) {
				log("STEP 6: Entered value does not display in area  field.  ", Status.FAIL);
				throw new RuntimeException("Failed in step 6");
			}
	   	}
		
		if(util.isElementVisible(drpAcquisitionPaymentUnits)) {
		try {
			SelectAcquisitionPaymentUnits(map.get(Excel.AcquisitionPaymentUnit));
				log("STEP 7: Selected value display in the  units  DD   ", Status.PASS);
			} catch (Exception e) {
				log("STEP 7: selected value does not display in  units DD. ", Status.FAIL);
				throw new RuntimeException("Failed in step 7");
			}
		}
		
		try {
			AddCostPerUnit(map.get(Excel.AcquisitionPaymentCostperUnit));
				log("STEP 8: Entered value should display in the cost per unit field. ", Status.PASS);
			} catch (Exception e) {
				log("STEP 8: Entered value does not display in cost per unit field. ", Status.FAIL);
				throw new RuntimeException("Failed in step 8");
			}
		
		try {
			AddAdditionalLinesPrepaymentComment(map.get(Excel.PrepaymentComment));
			log("STEP 9: Entered value should display in the comment  field   ", Status.PASS);
		} catch (Exception e) {
			log("STEP 9: Entered value does not display in comment field.  ", Status.FAIL);
			throw new RuntimeException("Failed in step 9");
		}
		
		try {
			AddAdditionalLinesPrepaymentArea(map.get(Excel.PrepaymentArea));
			log("STEP 10: Entered value should display in the area  field. ", Status.PASS);
		} catch (Exception e) {
			log("STEP 10: Entered value does not display in area  field.  ", Status.FAIL);
			throw new RuntimeException("Failed in step 10");
		}
	
		
		try {
			SelectAdditionalLinesPrepaymentUnits(map.get(Excel.PrepaymentUnits));
			log("STEP 11: Selected value display in the  units  DD   ", Status.PASS);
		} catch (Exception e) {
			log("STEP 11: selected value does not display in  units DD. ", Status.FAIL);
			throw new RuntimeException("Failed in step 11");
		}
		
		try {
			AddPrepaymentCostPerUnit(map.get(Excel.PrepaymentCostPerUnit));
			log("STEP 12: Entered value should display in the cost per unit field. ", Status.PASS);
		} catch (Exception e) {
			log("STEP 12: Entered value does not display in cost per unit field. ", Status.FAIL);
			throw new RuntimeException("Failed in step 12");
		}
		
		
		try {
			AddConsiderationComment(map.get(Excel.ConsiderationComment));
			log("STEP 13: Entered value should display in the comment  field   ", Status.PASS);
		} catch (Exception e) {
			log("STEP 13: Entered value does not display in comment field.  ", Status.FAIL);
			throw new RuntimeException("Failed in step 13");
		}
	   	
		try {
			AddConsiderationArea(map.get(Excel.ConsiderationArea));
			log("STEP 14: Entered value should display in the area  field. ", Status.PASS);
		} catch (Exception e) {
			log("STEP 14: Entered value does not display in area  field.  ", Status.FAIL);
			throw new RuntimeException("Failed in step 14");
		}
	
		
		try {
			SelectConsiderationUnits(map.get(Excel.ConsiderationUnits));
			log("STEP 15: Selected value display in the  units  DD   ", Status.PASS);
		} catch (Exception e) {
			log("STEP 15: selected value does not display in  units DD. ", Status.FAIL);
			throw new RuntimeException("Failed in step 15");
		}
		
		try {
			AddConsiderationCostPerUnit(map.get(Excel.ConsiderationCostPerUnit));
			log("STEP 16: Entered value should display in the cost per unit field. ", Status.PASS);
		} catch (Exception e) {
			log("STEP 16: Entered value does not display in cost per unit field. ", Status.FAIL);
			throw new RuntimeException("Failed in step 16");
		}
		
		try {
			AddCropDamagesComment(map.get(Excel.CropDamagesComment));
			log("STEP 17: Entered value should display in the comment  field   ", Status.PASS);
		} catch (Exception e) {
			log("STEP 17: Entered value does not display in comment field.  ", Status.FAIL);
			throw new RuntimeException("Failed in step 17");
		}
	   	
		try {
			AddCropDamagesArea(map.get(Excel.CropDamagesArea));
			log("STEP 18: Entered value should display in the area  field. ", Status.PASS);
		} catch (Exception e) {
			log("STEP 18: Entered value does not display in area  field.  ", Status.FAIL);
			throw new RuntimeException("Failed in step 18");
		}
	
		
		try {
			SelectCropDamagesUnits(map.get(Excel.CropDamagesUnits));
			log("STEP 19: Selected value display in the  units  DD   ", Status.PASS);
		} catch (Exception e) {
			log("STEP 19: selected value does not display in  units DD. ", Status.FAIL);
			throw new RuntimeException("Failed in step 19");
		}
		
		try {
			AddCropDamagesCostPerUnit(map.get(Excel.CropDamagesCostPerUnit));
			log("STEP 20: Entered value should display in the cost per unit field. ", Status.PASS);
		} catch (Exception e) {
			log("STEP 20: Entered value does not display in cost per unit field. ", Status.FAIL);
			throw new RuntimeException("Failed in step 20");
		}
		
		try {
			AddFinalPaymentComment(map.get(Excel.FinalPaymentComment));
			log("STEP 21: Entered value should display in the comment  field   ", Status.PASS);
		} catch (Exception e) {
			log("STEP 21: Entered value does not display in comment field.  ", Status.FAIL);
			throw new RuntimeException("Failed in step 21");
		}
		
		try {
			AddFinalPaymentArea(map.get(Excel.FinalPaymentArea));
			log("STEP 22: Entered value should display in the area  field. ", Status.PASS);
		} catch (Exception e) {
			log("STEP 22: Entered value does not display in area  field.  ", Status.FAIL);
			throw new RuntimeException("Failed in step 22");
		}
	
		
		try {
			SelectFinalPaymentUnits(map.get(Excel.FinalPaymentUnits));
			log("STEP 23: Selected value display in the  units  DD   ", Status.PASS);
		} catch (Exception e) {
			log("STEP 23: selected value does not display in  units DD. ", Status.FAIL);
			throw new RuntimeException("Failed in step 23");
		}
		
		try {
			AddFinalPaymentCostPerUnit(map.get(Excel.FinalPaymentCostPerUnit));
			log("STEP 24: Entered value should display in the cost per unit field. ", Status.PASS);
		} catch (Exception e) {
			log("STEP 24: Entered value does not display in cost per unit field. ", Status.FAIL);
			throw new RuntimeException("Failed in step 24");
		}
		
		try {
			AddOtherComment(map.get(Excel.OtherComment));
			log("STEP 25: Entered value should display in the comment  field   ", Status.PASS);
		} catch (Exception e) {
			log("STEP 25: Entered value does not display in comment field.  ", Status.FAIL);
			throw new RuntimeException("Failed in step 25");
		}
		
		try {
			AddOtherArea(map.get(Excel.OtherArea));
			log("STEP 26: Entered value should display in the area  field. ", Status.PASS);
		} catch (Exception e) {
			log("STEP 26: Entered value does not display in area  field.  ", Status.FAIL);
			throw new RuntimeException("Failed in step 26");
		}
	
		
		try {
			SelectOtherUnits(map.get(Excel.OtherUnits));
			log("STEP 27: Selected value display in the  units  DD   ", Status.PASS);
		} catch (Exception e) {
			log("STEP 27: selected value does not display in  units DD. ", Status.FAIL);
			throw new RuntimeException("Failed in step 27");
		}
		
		try {
			AddOtherCostPerUnit(map.get(Excel.OtherCostPerUnit));
			log("STEP 28: Entered value should display in the cost per unit field. ", Status.PASS);
		} catch (Exception e) {
			log("STEP 28: Entered value does not display in cost per unit field. ", Status.FAIL);
			throw new RuntimeException("Failed in step 28");
		}

		try {
			AddRoadComment(map.get(Excel.RoadComment));
			log("STEP 29: Entered value should display in the comment  field   ", Status.PASS);
		} catch (Exception e) {
			log("STEP 29: Entered value does not display in comment field.  ", Status.FAIL);
			throw new RuntimeException("Failed in step 29");
		}
		
		try {
			AddRoadArea(map.get(Excel.RoadArea));
			log("STEP 30: Entered value should display in the area  field. ", Status.PASS);
		} catch (Exception e) {
			log("STEP 30: Entered value does not display in area  field.  ", Status.FAIL);
			throw new RuntimeException("Failed in step 30");
		}
	
		
		try {
			SelectRoadUnits(map.get(Excel.RoadUnits));
			log("STEP 31: Selected value display in the  units  DD   ", Status.PASS);
		} catch (Exception e) {
			log("STEP 31: selected value does not display in  units DD. ", Status.FAIL);
			throw new RuntimeException("Failed in step 31");
		}
		
		try {
			AddRoadCostPerUnit(map.get(Excel.RoadCostPerUnit));
			log("STEP 32: Entered value should display in the cost per unit field. ", Status.PASS);
		} catch (Exception e) {
			log("STEP 32: Entered value does not display in cost per unit field. ", Status.FAIL);
			throw new RuntimeException("Failed in step 32");
		}

		
		try {
			AddWayPaymentComment(map.get(Excel.WayPaymentComment));
			log("STEP 33: Entered value should display in the comment  field   ", Status.PASS);
		} catch (Exception e) {
			log("STEP 33: Entered value does not display in comment field.  ", Status.FAIL);
			throw new RuntimeException("Failed in step 33");
		}
		
		try {
			AddWayPaymentArea(map.get(Excel.WayPaymentArea));
			log("STEP 34: Entered value should display in the area  field. ", Status.PASS);
		} catch (Exception e) {
			log("STEP 34: Entered value does not display in area  field.  ", Status.FAIL);
			throw new RuntimeException("Failed in step 34");
		}
	
		
		try {
			SelectWayPaymentUnits(map.get(Excel.WayPaymentUnits));
			log("STEP 35: Selected value display in the  units  DD   ", Status.PASS);
		} catch (Exception e) {
			log("STEP 35: selected value does not display in  units DD. ", Status.FAIL);
			throw new RuntimeException("Failed in step 35");
		}
		
		try {
			AddWayPaymentCostPerUnit(map.get(Excel.WayPaymentCostPerUnit));
			log("STEP 36: Entered value should display in the cost per unit field. ", Status.PASS);
		} catch (Exception e) {
			log("STEP 36: Entered value does not display in cost per unit field. ", Status.FAIL);
			throw new RuntimeException("Failed in step 36");
		}
		
		try {
			AddTimberDamagesComment(map.get(Excel.TimberDamagesComment));
			log("STEP 37: Entered value should display in the comment  field   ", Status.PASS);
		} catch (Exception e) {
			log("STEP 37: Entered value does not display in comment field.  ", Status.FAIL);
			throw new RuntimeException("Failed in step 37");
		}
		
		try {
			AddTimberDamagesArea(map.get(Excel.TimberDamagesArea));
			log("STEP 38: Entered value should display in the area  field. ", Status.PASS);
		} catch (Exception e) {
			log("STEP 38: Entered value does not display in area  field.  ", Status.FAIL);
			throw new RuntimeException("Failed in step 38");
		}
	
		
		try {
			SelectTimberDamagesUnits(map.get(Excel.TimberDamagesUnits));
			log("STEP 39: Selected value display in the  units  DD   ", Status.PASS);
		} catch (Exception e) {
			log("STEP 39: selected value does not display in  units DD. ", Status.FAIL);
			throw new RuntimeException("Failed in step 39");
		}
		
		try {
			AddTimberDamagesCostPerUnit(map.get(Excel.TimberDamagesCostPerUnit));
			log("STEP 40: Entered value should display in the cost per unit field. ", Status.PASS);
		} catch (Exception e) {
			log("STEP 40: Entered value does not display in cost per unit field. ", Status.FAIL);
			throw new RuntimeException("Failed in step 40");
		}

		try {
			ClickOnSaveButton();
			log("STEP 41: Submit button should be display on the pop up ", Status.PASS);
		} catch (Exception e) {
			log("STEP 41: Updated fields value does not display ", Status.FAIL);
			throw new RuntimeException("Failed in step 41");
		}
		
		util.dummyWait(5);
		try {
			ClickOnSubmitButton();
			log("STEP 42: User can click on submit  button.  ", Status.PASS);
		} catch (Exception e) {
			log("STEP 42: User cannot click on submit  button. ", Status.FAIL);
			throw new RuntimeException("Failed in step 42");
		}
		
		
	}
	
}
