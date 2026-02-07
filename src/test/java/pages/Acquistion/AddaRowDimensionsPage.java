package pages.Acquistion;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

public class AddaRowDimensionsPage extends BasePage {

	TestUtil util;
	CommonFunction commonFunction;
	public static String AGREEMENT_NUMBER;

	public AddaRowDimensionsPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		
	}
	
	By navRowDimension = By.xpath("(//span[contains(text(),'ROW Dimensions')])[last()]");
	By btnAddNew = By.xpath("//img[contains(@id,'ACQDIMENSIONS_radYALGridControl_ctl00_ctl02_ctl00_Img4')]");
	By drpAcquisitionType = By.xpath("//input[contains(@id,'_Acquisition_Type_ID_radYALDropDownList_Input') and @type='text']");
	By drpAssocAgreement = By.xpath("//input[contains(@id,'_EditFormControl_Recording_ID_radYALDropDownList_Input') and @type='text']");
	By txtLength = By.xpath("//input[contains(@id,'_LENGTH_AMOUNT') and @type='text']");
	By txtWidth = By.xpath("//input[contains(@id,'_WIDTH_AMOUNT') and @type='text']");
	By txtArea = By.xpath("//input[contains(@id,'_Area_Amount') and @type='text']");
	By txtDepth = By.xpath("//input[contains(@id,'_Depth_Amount') and @type='text']");
	By drpLengthUnit = By.xpath("//input[contains(@id,'_Length_Units_ID_radYALDropDownList_Input') and @type='text']");
	By drpWidthUnit = By.xpath("//input[contains(@id,'_Width_Units_ID_radYALDropDownList_Input') and @type='text']");
	By drpAreaUnit = By.xpath("//input[contains(@id,'_Area_Units_ID_radYALDropDownList_Input') and @type='text']");
	By drpDepthUnit = By.xpath("//input[contains(@id,'_Depth_Units_ID_radYALDropDownList_Input') and @type='text']");
	By txtDimension = By.xpath("//input[contains(@id,'_EditFormControl_Dim_Amount') and @type='text'] | (//input[contains(@id,'EditFormControl_Gross_Acres') and @type='text'])[1]");
	By drpDimensionUnit = By.xpath("//input[contains(@id,'_Dim_Units_ID_radYALDropDownList_Input') and @type='text']");
	By txtOffsetRow = By.xpath("//textarea[contains(@id,'_EditFormControl_OffsetROW')]");
	By txtComment = By.xpath("//textarea[contains(@id,'EditFormControl_Comments')]");
	By btnInsert = By.xpath("//input[contains(@id,'_btnInsert') and @type='submit']");
	By changesSavedSuccessfully = By.xpath("//span[contains(@id,'_i0_ACQDIMENSIONS_usrMessage')]");
	By btnEdit = By.xpath("//input[contains(@id,'_ACQDIMENSIONS_radYALGridControl_ctl00_ctl04_EditButton')]");
	By updateLength = By.xpath("//input[contains(@id,'_LENGTH_AMOUNT') and @type='text']");
	By updateWidth = By.xpath("//input[contains(@id,'_WIDTH_AMOUNT') and @type='text']");
	By updateArea = By.xpath("//input[contains(@id,'_Area_Amount') and @type='text']");
	By btnUpdate = By.xpath("//input[contains(@id,'_btnUpdate') and @type='submit']");
	By btnDelete = By.xpath("//input[contains(@id,'_ACQDIMENSIONS_radYALGridControl_ctl00_ctl04_gbcDeleteAlignment')]");
	By iframeDelete = By.xpath("//td[@class='rwWindowContent']");
	By btnOk = By.xpath("//span[text()='OK']");
	
	
	public void ClickonAddNewButton() {
		util.dummyWait(2);
		util.waitUntilElementDisplay(navRowDimension);
		util.click(navRowDimension);
		util.waitUntilElementDisplay(btnAddNew);
		util.click(btnAddNew);
	}
	
	
	public void SelectAcquisitionType(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpAcquisitionType, value);
	}
	
	public void SelectAssocAgreement(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpAssocAgreement, value);
	}
	
	public void AddLength(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtLength, value);
	}
	
	public void AddWidth(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtWidth, value);
	}
	
	public void AddArea(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtArea, value);
	}
	
	public void AddDepth(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtDepth, value);
	}
	
	public void SelectLengthUnit(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpLengthUnit, value);
	}
	
	public void SelectAreaUnit(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpAreaUnit, value);
	}
	
	public void SelectWidthUnit(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpWidthUnit, value);
	}
	
	public void SelectDepthUnit(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpDepthUnit, value);
	}
	
	public void AddDimension(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtDimension, value);
	}
	
	public void SelectDimensionUnit(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpDimensionUnit, value);
	}
	
	public void AddOffsetRow(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtOffsetRow, value);
	}
	
	public void AddComment(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtComment, value);
	}
	
	public void ClickonInsert() {
		util.click(btnInsert);
		util.waitUntilElementDisplay(changesSavedSuccessfully);
		util.dummyWait(3);
		Assert.assertTrue(util.isElementPresent(changesSavedSuccessfully), "Changes saved successfully!");
	util.dummyWait(3);
		
	}
	
	public void ClickonEditButton(String value) {
	
		util.waitUntilElementDisplay(btnEdit);
		util.click(btnEdit);
		util.dummyWait(5);
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(updateLength, value);
	}
	
	
	public void ClickonUpdateButton() {
		util.waitUntilElementDisplay(btnUpdate);
		util.click(btnUpdate);
		util.dummyWait(3);
		util.waitUntilElementDisplay(changesSavedSuccessfully);
		Assert.assertTrue(util.isElementPresent(changesSavedSuccessfully), "Changes saved successfully!");
		util.dummyWait(3);
	}
	
	public void ClickonDeleteButton() {
		util.waitUntilElementDisplay(btnDelete);
		util.click(btnDelete);
	}
	
	
	public void ClickonOk() {
//		util.switchToIframe(iframeDelete);
		util.waitUntilElementDisplay(btnOk);
		util.click(btnOk);
		util.dummyWait(1);
		util.click(navRowDimension);
		util.dummyWait(2);
	}
	
	 public void AddaRowDimensions(Map<String, String> map, String testcaseName) {
		 
		 if(testcaseName.contains("ALT") || testcaseName.contains("ORSTED") || testcaseName.contains("ORION") || testcaseName.contains("ATWELL") || testcaseName.contains("TRA")) {
//		 try {
//			 util.dummyWait(2);
//			 ClickonAddNewButton();
//				log("STEP 1: The panel fields displays  ", Status.PASS);
//			} catch (Exception e) {
//				log("STEP 1:  The panel does not expand ", Status.FAIL);
//				throw new RuntimeException("User cannot see the option in Menu");
//			}
//		 
//
//		 try {
//			 SelectAcquisitionType(map.get(Excel.AcquisitionType));
//				log("STEP 2:  Selected value display in the Acquisition Type dd field ", Status.PASS);
//			} catch (Exception e) {
//				log("STEP 2:   Added value does not display in the field.", Status.FAIL);
//				throw new RuntimeException("Failed in step 2");
//			}
//		 
//		 try {
//			 SelectAssocAgreement(map.get(Excel.AssocAgreement));
//				log("STEP 3: user can able to select value from AssocAgreement dd ", Status.PASS);
//			} catch (Exception e) {
//				log("STEP 3: user not able to select value from AssocAgreement dd ", Status.FAIL);
//				throw new RuntimeException("Failed in step 3");
//			}
//		 
//		 try {
//			 AddLength(map.get(Excel.Length));
//				log("STEP 4:Length Amount added display in the cost column field ", Status.PASS);
//			} catch (Exception e) {
//				log("STEP 4: Added value does not display in the field.", Status.FAIL);
//				throw new RuntimeException("Failed in step 4");
//			}
//		 
//		 try {
//			 AddWidth(map.get(Excel.Width));
//				log("STEP 5:Width Amount added display in the cost column field ", Status.PASS);
//			} catch (Exception e) {
//				log("STEP 5: Added value does not display in the field.", Status.FAIL);
//				throw new RuntimeException("Failed in step 5");
//			}
//		 
//		 try {
//			 AddArea(map.get(Excel.Area));
//				log("STEP 6:Area Amount added display in the cost column field ", Status.PASS);
//			} catch (Exception e) {
//				log("STEP 6: Added value does not display in the field.", Status.FAIL);
//				throw new RuntimeException("Failed in step 6");
//			}
//		 
//		 try {
//			 AddDepth(map.get(Excel.Depth));
//				log("STEP 7: Depth Amount added display in the cost column field ", Status.PASS);
//			} catch (Exception e) {
//				log("STEP 7: Added value does not display in the field.", Status.FAIL);
//				throw new RuntimeException("Failed in step 7");
//			}
//		 
//		 try {
//			 SelectLengthUnit(map.get(Excel.LengthUnit));
//				log("STEP 8:  Selected value display in the Length Units  dd field    ", Status.PASS);
//			} catch (Exception e) {
//				log("STEP 8:  Added value does not display in Length Units field.", Status.FAIL);
//				throw new RuntimeException("Failed in step 8");
//			}
//		 
//		 try {
//			 SelectWidthUnit(map.get(Excel.WidthUnit));
//				log("STEP 9:  Selected value display in the Width Units  dd field ", Status.PASS);
//			} catch (Exception e) {
//				log("STEP 9:  Added value does not display in Width Units field.", Status.FAIL);
//				throw new RuntimeException("Failed in step 9");
//			}
//		 
//		 try {
//			 SelectAreaUnit(map.get(Excel.AreaUnit));
//				log("STEP 10:  Selected value display in the Area Units  dd field ", Status.PASS);
//			} catch (Exception e) {
//				log("STEP 10:  Added value does not display in Area Units  field.", Status.FAIL);
//				throw new RuntimeException("Failed in step 10");
//			}
//		 
//		 try {
//			 SelectDepthUnit(map.get(Excel.DepthUnit));
//				log("STEP 11: Selected value display in the Depth Units  dd field ", Status.PASS);
//			} catch (Exception e) {
//				log("STEP 11:  Added value does not display in Depth Units field.", Status.FAIL);
//				throw new RuntimeException("Failed in step 11");
//			}
//		 
//		 
//		
//		 try {
//			 AddComment(map.get(Excel.Comment));
//				log("STEP 15: added value display in the comment field ", Status.PASS);
//			} catch (Exception e) {
//				log("STEP 15: added  value does not displayed in the field. ", Status.FAIL);
//				throw new RuntimeException("Failed in step 15");
//			}
//		 
//		 try {
//			 ClickonInsert();
//				log("STEP 16: Message - 'Changes saved sucessfully!' in green displays  ", Status.PASS);
//			} catch (Exception e) {
//				log("STEP 16: Added values does  not displayed in the grid.", Status.FAIL);
//				throw new RuntimeException("Failed in step 16");
//			}
//		 util.dummyWait(10);
//		
//			 try {
//				 ClickonEditButton(map.get(Excel.updateLength));
//					log("STEP 17: user can click on edit icon ", Status.PASS);
//				} catch (Exception e) {
//					log("STEP 17:  user cannot click on edit icon", Status.FAIL);
//					throw new RuntimeException("Failed in step 17");
//				}
//			 
//			 try {
//				 ClickonUpdateButton();
//					log("STEP 18: Message - 'Changes saved sucessfully' in green displays  ", Status.PASS);
//				} catch (Exception e) {
//					log("STEP 18: Message- Changes saved sucessfully' does not display", Status.FAIL);
//					throw new RuntimeException("Failed in step 18");
//				}
//			 util.dummyWait(5);
//			 try {
//				 ClickonDeleteButton();
//					log("STEP 19:  Delete popup window should display with two buttons 'OK' and 'cancel ' below the  Message    - Delete this record   ", Status.PASS);
//				} catch (Exception e) {
//					log("STEP 19:  The delete pop window does not display", Status.FAIL);
//					throw new RuntimeException("Failed in step 19");
//				}
//			 
//			 try {
//				 ClickonOk();
//					log("STEP 20: Message- Changes saved suessfully! in green displays", Status.PASS);
//				} catch (Exception e) {
//					log("STEP 20:  User cannot see the option in Menu", Status.FAIL);
//					throw new RuntimeException("Failed in step 20");
//				}
			 
			 log(" Add Row Dimensions panel has been removed", Status.SKIP);
		 
		 } 
		 else {

		 try {
			 ClickonAddNewButton();
				log("STEP 1: The panel fields displays  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 1:  The panel does not expand", Status.FAIL);
				throw new RuntimeException("Failed in step 1");
			}
		 
		 
		 try {
			 SelectAcquisitionType(map.get(Excel.AcquisitionType));
				log("STEP 2:  Selected value display in the Acquisition Type dd field ", Status.PASS);
			} catch (Exception e) {
				log("STEP 2:   Added value does not display in the field.", Status.FAIL);
				throw new RuntimeException("Failed in step 2");
			}
		 
		 try {
			 SelectAssocAgreement(map.get(Excel.AssocAgreement));
				log("STEP 3: user can able to select value from AssocAgreement dd ", Status.PASS);
			} catch (Exception e) {
				log("STEP 3: user not able to select value from AssocAgreement dd ", Status.FAIL);
				throw new RuntimeException("Failed in step 3");
			}
		 
		 try {
			 AddLength(map.get(Excel.Length));
				log("STEP 4:Length Amount added display in the cost column field ", Status.PASS);
			} catch (Exception e) {
				log("STEP 4: Added value does not display in the field.", Status.FAIL);
				throw new RuntimeException("Failed in step 4");
			}
		 
		 try {
			 AddWidth(map.get(Excel.Width));
				log("STEP 5:Width Amount added display in the cost column field ", Status.PASS);
			} catch (Exception e) {
				log("STEP 5: Added value does not display in the field.", Status.FAIL);
				throw new RuntimeException("Failed in step 5");
			}
		 
		 try {
			 AddArea(map.get(Excel.Area));
				log("STEP 6:Area Amount added display in the cost column field ", Status.PASS);
			} catch (Exception e) {
				log("STEP 6: Added value does not display in the field.", Status.FAIL);
				throw new RuntimeException("Failed in step 6");
			}
		 
		 if(util.isElementVisible(txtDepth)){
			 try {
			 AddDepth(map.get(Excel.Depth));
				log("STEP 7:Depth Amount added display in the cost column field ", Status.PASS);
			} catch (Exception e)  {
				log("STEP 7: Added value does not display in the field.", Status.FAIL);
				throw new RuntimeException("Failed in step 7");
			}
		 }
		 
		 try {
			 SelectLengthUnit(map.get(Excel.LengthUnit));
				log("STEP 8:  Selected value display in the Length Units  dd field    ", Status.PASS);
			} catch (Exception e) {
				log("STEP 8:  Added value does not display in Length Units field.", Status.FAIL);
				throw new RuntimeException("Failed in step 8");
			}
		 
		 try {
			 SelectWidthUnit(map.get(Excel.WidthUnit));
				log("STEP 9:  Selected value display in the Width Units  dd field ", Status.PASS);
			} catch (Exception e) {
				log("STEP 9:  Added value does not display in Width Units field.", Status.FAIL);
				throw new RuntimeException("Failed in step 9");
			}
		 
		 try {
			 SelectAreaUnit(map.get(Excel.AreaUnit));
				log("STEP 10:  Selected value display in the  Area Units  dd field ", Status.PASS);
			} catch (Exception e) {
				log("STEP 10:  Added value does not display in Area Units field.", Status.FAIL);
				throw new RuntimeException("Failed in step 10");
			}
		 
		 if(util.isElementVisible(drpDepthUnit)) {
			 try {
			 SelectDepthUnit(map.get(Excel.DepthUnit));
				log("STEP 11: Selected value display in the Depth Units  dd field ", Status.PASS);
			} catch (Exception e){
				log("STEP 11:  Added value does not display in Depth Units field.", Status.FAIL);
				throw new RuntimeException("Failed in step 11");
			}
		 }
		 
		 if(util.isElementVisible(txtDimension)) {
			 try {
			 AddDimension(map.get(Excel.Dimension));
				log("STEP 12: Selected value display in the Dimension  dd field ", Status.PASS);
			} catch (Exception e){
				log("STEP 12: Added value does not display in the field.", Status.FAIL);
				throw new RuntimeException("Failed in step 12");
			}
		 }
		 
		 if(util.isElementVisible(drpDimensionUnit)){
			 try {
			 SelectDimensionUnit(map.get(Excel.DimensionUnit));
				log("STEP 13: Selected value display in the Dimension Units  dd field ", Status.PASS);
			} catch (Exception e) {
				log("STEP 13: Added value does not display in the field.", Status.FAIL);
				throw new RuntimeException("Failed in step 13");
			}
		 }
		 
		 if(util.isElementVisible(txtOffsetRow)) {
		 try {
			 AddOffsetRow(map.get(Excel.OffsetRow));
				log("STEP 14: user can able to enter text in OffsetRow field ", Status.PASS);
			} catch (Exception e) {
				log("STEP 14:  user not able to enter text in OffsetRow field", Status.FAIL);
				throw new RuntimeException("Failed in step 14");
			}
		 }
		 
		 try {
			 AddComment(map.get(Excel.Comment));
				log("STEP 15: added value display in the comment field  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 15: added  value does not displayed in the field.", Status.FAIL);
				throw new RuntimeException("Failed in step 15");
			}
		 
		 try {
			 ClickonInsert();
				log("STEP 16: Message - 'Changes saved sucessfully!' in green displays  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 16: Added values does  not displayed in the grid.", Status.FAIL);
				throw new RuntimeException("Failed in step 16");
			}
		 
		
		 
		 try {
			 ClickonEditButton(map.get(Excel.updateLength));
				log("STEP 17: user can click on edit icon   ", Status.PASS);
			} catch (Exception e) {
				log("STEP 17: user cannot click on edit icon  ", Status.FAIL);
				throw new RuntimeException("Failed in step 17");
			}
		 
		 
		 try {
			 ClickonUpdateButton();
				log("STEP 18: Message - 'Changes saved sucessfully' in green displays  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 18: Message- Changes saved sucessfully' does not display", Status.FAIL);
				throw new RuntimeException("Failed in step 18");
			}
		 
		 try {
			 ClickonDeleteButton();
				log("STEP 19:  Delete popup window should display with two buttons 'OK' and 'cancel ' below the  Message    - Delete this record   ", Status.PASS);
			} catch (Exception e) {
				log("STEP 19:  The delete pop window does not display", Status.FAIL);
				throw new RuntimeException("Failed in step 19");
			}
		 
		 try {
			 ClickonOk();
				log("STEP 20: User can navigate to the Parcel Information ", Status.PASS);
			} catch (Exception e) {
				log("STEP 20:  User cannot see the option in Menu", Status.FAIL);
				throw new RuntimeException("Failed in step 20");
			}
		 
	 
		 
	    }
	
	 }
}

