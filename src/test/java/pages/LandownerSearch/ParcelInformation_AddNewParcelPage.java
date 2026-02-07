package pages.LandownerSearch;

import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;
import extentReports.ExtentTestManager;

public class ParcelInformation_AddNewParcelPage extends BasePage
{
	TestUtil util;
	CommonFunction commonFunction;
	public static String PARCEL1,PARCEL2;

	public ParcelInformation_AddNewParcelPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	
	By navParcel = By.xpath("//span[text()='Parcel'] | //span[text()='Tract']");
	By navParcelInfo = By.xpath("//span[text()='Parcel Info'] | //span[text()='Tract Info']");
	By navParcelInformation = By.xpath("//span[contains(text(),'Parcel Information')] | //span[contains(text(),'Tract Information')] | //span[contains(text(),'Record Information')]");
	By addParcel = By.xpath("//img[@onclick='showMenu(event)']");
	By frmFull = By.xpath("//iframe[@name='TractMenu']");
	By frmFullALT = By.xpath("//iframe[@name='radwinAddNewTract']");
    By btnaddParcel = By.xpath("//li[contains(@class,'rmItem rmFirst rmLast')]/..//*[text()='Add Parcel' or text()='Tract' or text()='DocumentNumber' or text()='Parcel' or text()='Add Tract' or text()='Location' or text()='Add parcel' or text()='Parcel(Map/Lot)']"); 
    By btnaddReorder = By.xpath("//li[contains(@class,'rmLast')]/..//span[text()='Reorder']");
    By btnaddParcelOld = By.xpath("//li[contains(@class,'rmLast')]/..//*[text()='Add Parcel' or text()='Tract']");
    By drpParcelType = By.xpath("//input[contains(@id,'_Tract_Type_ID_radYALDropDownList_Input') and @type='text']");
    By drpPropertyType = By.xpath("//input[contains(@id,'_Property_Type_ID_radYALDropDownList_Input') and @type='text']");
    By drpAcquisitionPriority  = By.xpath("//input[contains(@id,'_Acquisition_type_ID_radYALDropDownList_Input') and @type='text']");	
    By txtParcelNo = By.xpath("//input[contains(@id,'TractType_TRACT_NUMBER') and @type='text']");
    By drpState = By.xpath("//input[contains(@id,'_TractType_STATE_Input') and @type='text']");
    By drpCounty = By.xpath("//input[contains(@id,'_TractType_County') and @type='text']");
    By txtCountyPID = By.xpath("//input[contains(@id,'_TractType_radGISID') and @type='text']");
    By txtParcelAcres = By.xpath("//*[text()='Parcel Acres:']/..//input[@type='text']");
    By txtGISAcres  = By.xpath("//*[text()='GIS Acres:']/..//input[@type='text']");
    By txtLeasedAcres = By.xpath("//*[contains(text(),'Leased Acres')]/..//input[@type='text']");	
    By btnSave = By.xpath("//input[contains(@id,'_TractType_btnInternalSave')]");
    By getStrParcelNo = By.xpath("(//input[contains(@id,'_TRACT_NUMBER')])[1]");
    By drpParcelTypePopUp = By.xpath("//input[@id='TractType_Tract_Type_ID_radYALDropDownList_Input' and @type='text']");
    By drpAcquisitionPriorityPopUp = By.xpath("//input[@id='TractType_Acquisition_type_ID_radYALDropDownList_Input' and @type='text']");
    By txtAcquisitionPriority = By.xpath("//input[contains(@id,'TractType_Acquisition_type_IDCMB_YALComboBox_Input') and @type='text']");
    By drpPropertyTypePopUp = By.xpath("//input[@id='TractType_Property_Type_ID_radYALDropDownList_Input' and @type='text']");
    By txtParcelNoPopUp = By.xpath("//input[@id='TractType_TRACT_NUMBER' and @type='text']");
    By drpStatePopUp = By.xpath("//input[@id='TractType_STATE_Input' and @type='text']");
    By drpCountyPopUp = By.xpath("//input[@id='TractType_County_Input' and @type='text']");
    By btnSavePopUp = By.xpath("//input[contains(@id,'TractType_btnSaveAndClose')]");
    By firstType = By.xpath("(//*[contains(@id,'TractType_Tract_Type_ID_radYALDropDownList_DropDown')]/..//li[not(contains(text(),'Select One'))])[1]");
    By firstProperty = By.xpath("(//*[contains(@id,'TractType_Property_Type_ID_radYALDropDownList_DropDown')]/..//li[not(contains(text(),'Select One'))])[1]");
    By firstAcqType = By.xpath("(//*[contains(@id,'TractType_Acquisition_type_ID_radYALDropDownList_DropDown')]/..//li[not(contains(text(),'Select One'))])[1]");
    By firstAcqPrio = By.xpath("(//*[contains(@id,'TractType_Acquisition_type_IDCMB_YALComboBox_DropDown')]/..//input)[1]");
    By closeAcqPrio = By.xpath("//*[contains(@id,'TractType_Acquisition_type_IDCMB_YALComboBox_Arrow')]");
	By firstParcelTypePopUp = By.xpath("(//*[@id='TractType_Tract_Type_ID_radYALDropDownList_DropDown']/..//li[not(contains(text(),'Select One'))])[1]");
	By firstAcquisitionPriorityPopUp = By.xpath("(//*[@id='TractType_Acquisition_type_ID_radYALDropDownList_DropDown']/..//li[not(contains(text(),'Select One'))])[1]");
	By firstPropertyTypePopUp = By.xpath("(//*[@id='TractType_Property_Type_ID_radYALDropDownList_DropDown']/..//li[not(contains(text(),'Select One'))])[1]");
	
	public void navigateParcelInformation() {
		util.waitUntilElementDisplay(navParcel);
		util.click(navParcel);
		util.waitUntilElementDisplay(navParcelInfo);
		util.click(navParcelInfo);
		util.waitUntilElementDisplay(navParcelInformation);
		util.click(navParcelInformation);
		commonFunction.projectSelection();
	}

	public void addParcel() {
		util.click(addParcel);
		if (util.isElementVisible(btnaddReorder)) {
			util.waitUntilElementDisplay(btnaddParcelOld);
			util.click(btnaddParcelOld);
		} else {
			util.waitUntilElementDisplay(btnaddParcel);
			util.click(btnaddParcel);
		}
	}

	public void selectParcelType(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpParcelType, value);
	}

	public void selectPropertyType(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpPropertyType, value);
	}

	public void addParcelNo(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtParcelNo, value);
	}

	public void addParcelNoPopUp(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtParcelNoPopUp, value);
	}

	public void selectState(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpState, value);
	}

	public void selectStatePopUp(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpStatePopUp, value);
	}

	public void selectCounty(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpCounty, value);
	}

	public void selectCountyPopUp(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpCountyPopUp, value);
	}

	public void addCountyPID(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtCountyPID, value);
	}

	public void addParcelAcres(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtParcelAcres, value);
	}

	public void addGISAcres(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtGISAcres, value);
	}

	public void addLeasedAcres(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtLeasedAcres, value);
	}

	public void clickOnSave() {
		util.waitUntilElementDisplay(btnSave);
		util.click(btnSave);
		util.dummyWait(2);
	}

	public void clickOnSavePopUp() {
		util.waitUntilElementDisplay(btnSavePopUp);
		util.click(btnSavePopUp);
		util.dummyWait(2);
		util.switchToDefaultContent();
	}

	private void VerifyParcelNumber() {
		String ParcelNo = util.getAttributeValue(getStrParcelNo, "value");
		ExtentTestManager.info("User typed: " + ParcelNo);
		util.dummyWait(2);
		ExtentTestManager.info("Verify Parcel Summary No: " + ParcelNo);
	}

	public void selectParcelTypePopUp() {
		util.click(drpParcelTypePopUp);
		util.click(firstParcelTypePopUp);
	}

	public void selectAcquisitionPriorityPopUp() {
		util.click(drpAcquisitionPriorityPopUp);
		util.click(firstAcquisitionPriorityPopUp);
	}

	public void selectPropertyTypePopUp() {
		util.click(drpPropertyTypePopUp);
		util.click(firstPropertyTypePopUp);
	}

	public void AddParcel(Map<String, String> map, String testcaseName) {

		try {
			navigateParcelInformation();
			log("STEP 1:  User can navigate to Parcel Page", Status.PASS);
		} catch (Exception e) {
			log("STEP 1:  User cannot navigate to Parcel Page", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}

		for (int i = 0; i <= 1; i++) {
			try {
				addParcel();
				log("STEP 2: User can click on the add Parcel button  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 2:  User cannot see the add Parcel button  ", Status.FAIL);
				throw new RuntimeException(" Failed in step 2 ");
			}

			if (util.isElementPresent(frmFullALT)) {
				util.switchToIframe(frmFullALT);

				try {
					selectParcelTypePopUp();
					log("STEP 3:  Added value displays in Parcel Type field ", Status.PASS);
				} catch (Exception e) {
					log("STEP 3:  User  cannot select  value  from Parcel Type DD  ", Status.FAIL);
					throw new RuntimeException("Failed in step 34");
				}

				if (!environment.contains("WOLFMIDSTREAM")) {
					try {
						selectPropertyTypePopUp();
						log("STEP 4:  Added value displays in Property Type field   ", Status.PASS);
					} catch (Exception e) {
						log("STEP 4: User  cannot select  value  from Property Type DD  ", Status.FAIL);
						throw new RuntimeException("Failed in step 4");
					}
				}

				if (util.isElementVisible(drpAcquisitionPriorityPopUp)) {
					try {
						selectAcquisitionPriorityPopUp();
						log("STEP 5:  Added value displays in Acquisition Priority field   ", Status.PASS);
					} catch (Exception e) {
						log("STEP 5: User  cannot select  value  from Acquisition Priority DD  ", Status.FAIL);
						throw new RuntimeException("Failed in step 5");
					}
				}

				if (i == 0) {
					try {
						PARCEL1 = "A-" + util.randomNumber();
						addParcelNoPopUp(PARCEL1);
						log("STEP 6:  User can enter a value in Parcel Number field    ", Status.PASS);
					} catch (Exception e) {
						log("STEP 6:  User cannot add a value in Parcel Number field ", Status.FAIL);
						throw new RuntimeException("Failed in step 6");
					}
				} else {
					try {
						PARCEL2 = "B-" + util.randomNumber();
						addParcelNoPopUp(PARCEL2);
						log("STEP 6:  User can enter a value in Parcel Number field    ", Status.PASS);
					} catch (Exception e) {
						log("STEP 6:  User cannot add a value in Parcel Number field ", Status.FAIL);
						throw new RuntimeException("Failed in step 6");
					}
				}

				if (util.isElementPresent(drpStatePopUp)) {
					try {
						selectStatePopUp(map.get(Excel.State));
						log("STEP 7:  User can select value from the State DD  ", Status.PASS);
					} catch (Exception e) {
						log("STEP 7: User  cannot select  value  from the State DD  ", Status.FAIL);
						throw new RuntimeException("Failed in step 8");
					}

					try {
						selectCountyPopUp(map.get(Excel.County));
						log("STEP 8:  User can select value from the County DD  ", Status.PASS);
					} catch (Exception e) {
						log("STEP 8: User  cannot select  value  from the County DD  ", Status.FAIL);
						throw new RuntimeException("Failed in step 8");
					}
				}

				try {
					clickOnSavePopUp();
					util.dummyWait(2);
					log("STEP 9: Parcel is created sucessfully    ", Status.PASS);
				} catch (Exception e) {
					log("STEP 9:  Parcel is not created    ", Status.FAIL);
					throw new RuntimeException("Failed in step 9");
				}

				if (util.isElementVisible(txtParcelAcres)) {

					try {
						addParcelAcres(map.get(Excel.ParcelAcres));
						log("STEP 10: User can enter a value in Parcel Acres field     ", Status.PASS);
					} catch (Exception e) {
						log("STEP 10:  User cannot enter a value in Parcel Acres field      ", Status.FAIL);
						throw new RuntimeException("Failed in step 10");
					}
				}

				if (util.isElementVisible(txtGISAcres)) {
					try {
						addGISAcres(map.get(Excel.GISAcres));
						log("STEP 11: User can enter a value in GIS Acres field     ", Status.PASS);
					} catch (Exception e) {
						log("STEP 11:   User cannot enter a value in GIS Acres field     ", Status.FAIL);
						throw new RuntimeException("Failed in step 11");
					}
				}
				if (util.isElementVisible(txtLeasedAcres)) {
					try {
						addLeasedAcres(map.get(Excel.LeasedAcres));
						log("STEP 12: User can enter a value in Leased Acres field   ", Status.PASS);
					} catch (Exception e) {
						log("STEP 12:  User cannot enter a value in Leased Acres field   ", Status.FAIL);
						throw new RuntimeException("Failed in step 12");
					}
				}

				try {
					clickOnSave();
					util.dummyWait(2);
					log("STEP 13: Parcel is created sucessfully    ", Status.PASS);
				} catch (Exception e) {
					log("STEP 13:  Parcel is not created    ", Status.FAIL);
					throw new RuntimeException("Failed in step 13");
				}
			} else {

				if (environment.contains("WOLFMIDSTREAM")) {
					selectParcelType("Adjacent");
				} else {
					try {
						util.waitUntilElementDisplay(drpParcelType);
						util.click(drpParcelType);
						util.click(firstType);
						log("STEP 2:  Added value displays in Parcel Type field ", Status.PASS);
					} catch (Exception e) {
						log("STEP 2:  User  cannot select  value  from Parcel Type DD  ", Status.FAIL);
						throw new RuntimeException("Failed in step 2");
					}
				}
				if (util.isElementPresent(drpState)) {
					try {
						selectState(map.get(Excel.State));
						log("STEP 3:  User can select value from the State DD  ", Status.PASS);
					} catch (Exception e) {
						log("STEP 3: User  cannot select  value  from the State DD  ", Status.FAIL);
						throw new RuntimeException("Failed in step 3");
					}

					try {
						selectCounty(map.get(Excel.County));
						log("STEP 4:  User can select value from the County DD  ", Status.PASS);
					} catch (Exception e) {
						log("STEP 4: User  cannot select  value  from the County DD  ", Status.FAIL);
						throw new RuntimeException("Failed in step 4");
					}
				}

				if (!environment.contains("WOLFMIDSTREAM")) {
					try {
						selectPropertyType(map.get(Excel.PropertyType));
						log("STEP 5:  Added value displays in Property Type field   ", Status.PASS);
					} catch (Exception e) {
						log("STEP 5: User  cannot select  value  from Property Type DD  ", Status.FAIL);
						throw new RuntimeException("Failed in step 5");
					}
				}

				try {
					if (util.isElementVisible(drpAcquisitionPriority)) {
						util.waitUntilElementDisplay(drpAcquisitionPriority);
						util.click(drpAcquisitionPriority);
						util.click(firstAcqType);
					} else {
						util.waitUntilElementDisplay(txtAcquisitionPriority);
						util.click(txtAcquisitionPriority);
						util.click(firstAcqPrio);
						util.click(closeAcqPrio);
					}
					log("STEP 6:  Added value displays in Acquisition Priority field   ", Status.PASS);
				} catch (Exception e) {
					log("STEP 6: User  cannot select  value  from Acquisition Priority DD  ", Status.FAIL);
					throw new RuntimeException("Failed in step 6");
				}

				if (i == 0) {
					try {
						PARCEL1 = "A-" + util.randomNumber();
						addParcelNo(PARCEL1);
						log("STEP 7:  User can enter a value in Parcel Number field    ", Status.PASS);
					} catch (Exception e) {
						log("STEP 7:  User cannot add a value in Parcel Number field ", Status.FAIL);
						throw new RuntimeException("Failed in step 7");
					}
				} else {
					try {
						PARCEL2 = "B-" + util.randomNumber();
						addParcelNo(PARCEL2);
						log("STEP 7:  User can enter a value in Parcel Number field    ", Status.PASS);
					} catch (Exception e) {
						log("STEP 7:  User cannot add a value in Parcel Number field ", Status.FAIL);
						throw new RuntimeException("Failed in step 7");
					}
				}

				if (testcaseName.contains("ORSTED") || testcaseName.contains("ORION")
						|| testcaseName.contains("NOVA")) {
					try {
						clickOnSave();
						util.dummyWait(2);
						log("STEP 8: Parcel is created sucessfully    ", Status.PASS);
					} catch (Exception e) {
						log("STEP 8:  Parcel is not created    ", Status.FAIL);
						throw new RuntimeException("Failed in step 8");
					}

					try {
						addCountyPID(map.get(Excel.CountyPID));
						log("STEP 9: User can enter a value in Parcel Acres field     ", Status.PASS);
					} catch (Exception e) {
						log("STEP 9:  User cannot enter a value in Parcel Acres field      ", Status.FAIL);
						throw new RuntimeException("Failed in step 91");
					}

					if (util.isElementVisible(txtParcelAcres)) {

						try {
							addParcelAcres(map.get(Excel.ParcelAcres));
							log("STEP 10: User can enter a value in Parcel Acres field     ", Status.PASS);
						} catch (Exception e) {
							log("STEP 10:  User cannot enter a value in Parcel Acres field      ", Status.FAIL);
							throw new RuntimeException("Failed in step 10");
						}
					}

					if (util.isElementVisible(txtGISAcres)) {
						try {
							addGISAcres(map.get(Excel.GISAcres));
							log("STEP 11: User can enter a value in GIS Acres field     ", Status.PASS);
						} catch (Exception e) {
							log("STEP 11:   User cannot enter a value in GIS Acres field     ", Status.FAIL);
							throw new RuntimeException("Failed in step 11");
						}
					}
					if (util.isElementVisible(txtLeasedAcres)) {
						try {
							addLeasedAcres(map.get(Excel.LeasedAcres));
							log("STEP 12: User can enter a value in Leased Acres field   ", Status.PASS);
						} catch (Exception e) {
							log("STEP 12:  User cannot enter a value in Leased Acres field   ", Status.FAIL);
							throw new RuntimeException("Failed in step 12");
						}
					}
				}

				try {
					clickOnSave();
					util.dummyWait(2);
					log("STEP 13: Parcel is created sucessfully    ", Status.PASS);
				} catch (Exception e) {
					log("STEP 13:  Parcel is not created    ", Status.FAIL);
					throw new RuntimeException("Failed in step 13");
				}
			}

			util.dummyWait(5);
		}
	}
}
