package pages.InfoByParcelReport;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

public class AddProjectPage extends BasePage {
	TestUtil util;
	CommonFunction commonFunction;
	public static String PN, AREA;

	public AddProjectPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}

	//On Page
	By txtProjectName = By.xpath("//input[contains(@id,'radPrjName')][1]");
	By txtProjectNamePopUp = By.xpath("//input[contains(@id,'prjInfo_radPrjName')][1]");
	By txtProjectNumber = By.xpath("(//input[contains(@id,'radPrjNum')])[1]");
	By txtProjectNumberPopUp = By.xpath("(//input[contains(@id,'prjInfo_radPrjNum')])[1]");
	By drpProjectType = By.xpath("(//input[contains(@id,'ProjType')])[1]");
	By drpProjectTypePopUp = By.xpath("(//input[contains(@id,'prjInfo_yalProjType_radYALDropDownList_Input')])[1]");
	By txtAbbreviation = By.xpath("//input[contains(@id,'OBJPROJECTINFO_ABBREVIATION')][1] | //input[contains(@id,'OBJPROJECTINFO_rtbPRJNO_1')][1]");
	By txtAbbreviationPopUp = By.xpath("//input[contains(@id,'prjInfo_ABBREVIATION')][1]");
	By drpArea = By.xpath("//input[contains(@id,'yalPrjArea_radYALDropDownList_Input')]");
	By drpAreaPopUp = By.xpath("//input[contains(@id,'prjInfo_yalPrjArea_radYALDropDownList_Input')]");
	By btnSave = By.xpath("//input[contains(@id,'btnSaveProject')]");
	By btnInsertAndClose = By.xpath("//input[contains(@id,'prjInfo_btnSaveAndClose')]");
	By btnArchieve = By.xpath("//input[@id='ctl00_ConPHRightTop_radPrjPanels_i0_i0_OBJPROJECTINFO_btnArchive']");
	By drpTemporaryRow = By.xpath("//input[contains(@name,'yalTempROWWidth$radYALDropDownList')]");
	By drpTemporaryRowPopUp = By.xpath("//input[contains(@name,'prjInfo$yalTempROWWidth$radYALDropDownList')]");
	By drpPermanentRow = By.xpath("//input[contains(@name,'yalPermROWWidth$radYALDropDownList')]");
	By drpPermanentRowPopUp = By.xpath("//input[contains(@name,'prjInfo$yalPermROWWidth$radYALDropDownList')]");
	By drpUnitRow = By.xpath("//input[contains(@name,'PERMROW_WIDTH_UNIT$radYALDropDownList')]");
	By drpUnitRowPopUp = By.xpath("//input[contains(@name,'PERMROW_WIDTH_UNIT$radYALDropDownList')]");
	By drpCompanyCode = By.xpath("//input[contains(@id,'1_YALComboBox_Input')]");
	By drpCompanyCodePopUp = By.xpath("//input[contains(@id,'prjInfo_customFields2_331_YALComboBox_Input')]");
	By drpPayingEntity = By.xpath("//input[contains(@id,'2_YALComboBox_Input')]");
	By drpPayingEntityPopUp = By.xpath("//input[contains(@id,'prjInfo_customFields2_372_YALComboBox_Input')]");
	By drpProjectEntity = By.xpath("//input[contains(@id,'3_YALComboBox_Input')]");
	By drpBoardResolution = By.xpath("//input[contains(@id,'OBJPROJECTINFO_customFieldsProjectInfo_200_YALComboBox_Input')]");
	By drpProjectEntityPopUp = By.xpath("//input[contains(@id,'prjInfo_customFields2_373_YALComboBox_Input')]");

	By archieveOk = By.xpath("//a[contains(@onClick,'confirm')][1]");
	By archieveOkbutton = By.xpath("(//div[contains(@id,'confirm')])[1]");
	By btnUnArchieve = By.xpath("//input[@name='ctl00$ConPHRightTop$radPrjPanels$i0$i0$OBJPROJECTINFO$btnUnarchive']");
	By btnUnArchievedot = By
			.xpath("//input[@name='ctl00$ConPHRightTop$PRDT_UC$radPrjPanels$i0$i0$OBJPROJECTINFO$btnUnarchive']");
	By drpClient = By.xpath("//input[contains(@id,'yalPrjArea_radYALDropDownList_Input')]");
	By drpClientPopUp = By.xpath("//input[contains(@id,'prjInfo_yalPrjArea_radYALDropDownList_Input')]");
	By drpProjectStatus = By.xpath("//input[contains(@id,'PROJECT_STATUS_ID_radYALDropDownList_Input')]");
	By drpProjectStatusPopUp = By.xpath("//input[contains(@id,'prjInfo_PROJECT_STATUS_ID_radYALDropDownList_Input')]");

	By txtProjectNameSummary = By.xpath("(//*[contains(text(),'Project Name')]/following::td/strong)[1]");
	By txtProjectCodeSummary = By.xpath("(//*[contains(text(),'Project #')]/following::td/strong)[1]");

	By btnArchieveDot = By
			.xpath("//input[@name='ctl00$ConPHRightTop$PRDT_UC$radPrjPanels$i0$i0$OBJPROJECTINFO$btnArchive']");
	By archieveokPopupFrame = By.xpath("//iframe[contains(@name,'confirm')]");
	By btnUnArchieveDot = By
			.xpath("//input[@name='ctl00$ConPHRightTop$PRDT_UC$radPrjPanels$i0$i0$OBJPROJECTINFO$btnUnarchive']");

	
	By clickOnStatus = By.xpath("//div[@id='ctl00_ConPHRightTop_PRDT_UC_radPrjPanels_i0_i0_OBJPROJECTINFO_yddtProjectStatus_RadDropDownTree1']");
	By addStatus = By.xpath("(//input[@value='Filtering...'])[1]");
	By clickOnStatusPopUp = By.xpath("//div[@id='prjInfo_yddtProjectStatus_RadDropDownTree1'] ");
	By addStatusPopUp = By.xpath("//*[@id=\"form1\"]/div[1]/div/div[1]/label/input");
	By selectStatus = By.xpath("");
	By closeStatus = By.xpath("//div[@id='ctl00_ConPHRightTop_PRDT_UC_radPrjPanels_i0_i0_OBJPROJECTINFO_yddtProjectStatus_RadDropDownTree1']//span[@class='rddtIcon']");
	By frmFull = By.xpath("//iframe[@name='radwinAddNewProject']");
	public void verifySummaryALT() {
    String getStrProjectName = driver
				.findElement(By.xpath("(//input[contains(@id,'OBJPROJECTINFO_radPrjName')])[1]")).getAttribute("value");

   String getProjectNameSummary = driver
				.findElement(By.xpath("//*[contains(@id,'RadPageView')]/..//*[contains(text(),'Project Name')]/..//strong")).getText();

System.out.println(getStrProjectName);

System.out.println(getProjectNameSummary);

		if (getProjectNameSummary.equals(getStrProjectName)) {
			System.out.println("Project Name Matched !!!");
			log("STEP 23: Project Name Matched !!!", Status.PASS);
		} else {
			System.out.println("Project Name not Matched");
			log("STEP 23: Project Name not Matched", Status.FAIL);
		}

	}

	public void setProjectNumber() {
		util.inputText(txtProjectNumber, util.randomNumber());
	}
	
	public void setProjectNumberPopUp() {
		util.inputText(txtProjectNumberPopUp, util.randomNumber());
	}
	
	public void setProjectName(String value) {
		if (!commonFunction.checkNA(value))
			util.inputText(txtProjectName, value);
	}
	
	public void setProjectNamePopUp(String value) {
		if (!commonFunction.checkNA(value))
			util.inputText(txtProjectNamePopUp, value);
	}

	By txtCostCenterPopUp = By.xpath("//input[contains(@id,'prjInfo_customFields2_53') and @type='text']");
	public void setCostCenterPopUp(String value) {
		if (!commonFunction.checkNA(value))
			util.inputText(txtCostCenterPopUp, value);
	}
	
	By txtCostCenter = By.xpath("//input[contains(@id,'OBJPROJECTINFO_customFields2_53') and @type='text']");
	public void setCostCenter(String value) {
		if (!commonFunction.checkNA(value))
			util.inputText(txtCostCenter, value);
	}
	
	By txtBudgetItemPopUp = By.xpath("//input[contains(@id,'prjInfo_customFields2_54') and @type='text']");
	public void setBudgetItemPopUp(String value) {
		if (!commonFunction.checkNA(value))
			util.inputText(txtBudgetItemPopUp, value);
	}
	
	By txtBudgetItem = By.xpath("//input[contains(@id,'OBJPROJECTINFO_customFields2_54') and @type='text']");
	public void setBudgetItem(String value) {
		if (!commonFunction.checkNA(value))
			util.inputText(txtBudgetItem, value);
	}
	
	public void setProjectType(String value) {
		if (!commonFunction.checkNA(value))
			util.selectValueFromDropdown(drpProjectType, value);
		util.pressENTERkey();
	}
	
	By firstType = By.xpath("(//*[contains(@id,'OBJPROJECTINFO_yalProjType_radYALDropDownList_DropDown')]/..//li[not(contains(text(),'Select One'))])[1]");
	By firstTypePopup = By.xpath("(//*[contains(@id,'prjInfo_yalProjType_radYALDropDownList_DropDown')]/..//li[not(contains(text(),'Select One'))])[1]");
	public void setProjectTypePopUp(String value) {
		if (!commonFunction.checkNA(value))
			util.selectValueFromDropdown(drpProjectTypePopUp, value);
		util.pressENTERkey();
	}
	
	public void setAbbreviation(String value) {
		if (!commonFunction.checkNA(value))
			util.inputText(txtAbbreviation, value);
	}

	public void setAbbreviationPopUp(String value) {
		if (!commonFunction.checkNA(value))
			util.inputText(txtAbbreviationPopUp, value);
	}
	
	By firstArea = By.xpath("(//*[contains(@id,'OBJPROJECTINFO_yalPrjArea_radYALDropDownList_DropDown')]/..//li[not(contains(text(),'Select One'))])[1]");
	By firstAreaPopup = By.xpath("(//*[contains(@id,'prjInfo_yalPrjArea_radYALDropDownList_DropDown')]/..//li[not(contains(text(),'Select One'))])[1]");
	By secondArea = By.xpath("(//*[contains(@id,'OBJPROJECTINFO_yalPrjArea_radYALDropDownList_DropDown')]/..//li[not(contains(text(),'Select One'))])[1]");
	By secondAreaPopup = By.xpath("(//*[contains(@id,'prjInfo_yalPrjArea_radYALDropDownList_DropDown')]/..//li[not(contains(text(),'Select One'))])[1]");
	public void setArea(String value) throws InterruptedException {
		if (!commonFunction.checkNA(value)) {
			util.selectValueFromDropdown(drpArea, value);
		util.waitFor(1000);
		util.pressENTERkey();}

	}

	public void setAreaPopUp(String value) throws InterruptedException {
		if (!commonFunction.checkNA(value)) {
			util.selectValueFromDropdown(drpAreaPopUp, value);
		util.waitFor(1000);
		util.pressENTERkey();}

	}
	
	public void setClient(String value) {
		if (!commonFunction.checkNA(value)) {
			util.selectValueFromDropdown(drpClient, value);
		util.pressENTERkey();}

	}

	public void setClientPopUp(String value) {
		if (!commonFunction.checkNA(value)) {
			util.selectValueFromDropdown(drpClientPopUp, value);
		util.pressENTERkey();}

	}
	public void setProjectStatus(String value) {
		if (!commonFunction.checkNA(value))
			util.selectValueFromDropdown(drpProjectStatus, value);
		util.pressENTERkey();

	}
	
	public void setProjectStatusPopUp(String value) {
		if (!commonFunction.checkNA(value))
			util.selectValueFromDropdown(drpProjectStatusPopUp, value);
		util.pressENTERkey();

	}
	
	By selectStatus1 = By.xpath("(//div[contains(@id,'yddtProjectStatus_RadDropDownTree1_EmbeddedTree')]/..//span[2])[1]");
	public void setProjectStatusROW() {
		util.click(clickOnStatus);
			util.click(selectStatus1);
			
	}

	public void setProjectStatusROWPopUp(String value) {
		if (!commonFunction.checkNA(value)) {
			util.click(clickOnStatusPopUp);
			util.inputText(addStatusPopUp, value);
			By selectStatus = By.xpath("//em[contains(text(),'"+value+"')]");
			util.click(selectStatus);
		}
	}
	
	By selectStatusPopUp1 = By.xpath("(//div[contains(@id,'yddtProjectStatus_RadDropDownTree1_EmbeddedTree')]/..//span[2])[1]");
	public void setProjectStatusROWPop() {
		util.click(clickOnStatusPopUp);
			util.click(selectStatusPopUp1);
			
	}
	public void setTemporaryROW(String value) {
		if (!commonFunction.checkNA(value))
			util.selectValueFromDropdown(drpTemporaryRow, value);
		util.pressENTERkey();

	}

	public void setTemporaryROWPopUp(String value) {
		if (!commonFunction.checkNA(value))
			util.selectValueFromDropdown(drpTemporaryRowPopUp, value);
		util.pressENTERkey();

	}
	public void setPermanentROW(String value) {
		if (!commonFunction.checkNA(value))
			util.selectValueFromDropdown(drpPermanentRow, value);
		util.pressENTERkey();

	}

	public void setPermanentROWPopUp(String value) {
		if (!commonFunction.checkNA(value))
			util.selectValueFromDropdown(drpPermanentRowPopUp, value);
		util.pressENTERkey();

	}
	public void setUnit(String value) {
		if (!commonFunction.checkNA(value))
			util.selectValueFromDropdown(drpUnitRow, value);
		util.pressENTERkey();
	}
	
	public void setUnitPopUp(String value) {
		if (!commonFunction.checkNA(value))
			util.selectValueFromDropdown(drpUnitRowPopUp, value);
		util.pressENTERkey();
	}
	
	public void setSAPCompanyCode(String value) {
		if (!commonFunction.checkNA(value))
			util.selectValueFromDropdown(drpCompanyCode, value);
		util.pressENTERkey();

	}
	
	public void setSAPCompanyCodePopUp(String value) {
		if (!commonFunction.checkNA(value))
			util.selectValueFromDropdown(drpCompanyCodePopUp, value);
		util.pressENTERkey();

	}
	
	public void setSAPPayingEntity(String value) {
		if (!commonFunction.checkNA(value))
			util.selectValueFromDropdown(drpPayingEntity, value);
		util.pressENTERkey();

	}
	
	public void setSAPPayingEntityPopUp(String value) {
		if (!commonFunction.checkNA(value))
			util.selectValueFromDropdown(drpPayingEntityPopUp, value);
		util.pressENTERkey();

	}
	
	public void setSAPProjectEntity(String value) {
		if (!commonFunction.checkNA(value))
			util.selectValueFromDropdown(drpProjectEntity, value);
		util.pressENTERkey();

	}
	
	public void setBoardResolution(String value) {
		if (!commonFunction.checkNA(value))
			util.selectValueFromDropdown(drpBoardResolution, value);
		util.pressENTERkey();

	}
	
	public void setSAPProjectEntityPopUp(String value) {
		if (!commonFunction.checkNA(value))
			util.selectValueFromDropdown(drpProjectEntityPopUp, value);
		util.pressENTERkey();

	}
	
	public void clickOnArchieveButtonROW() throws InterruptedException {
		Thread.sleep(1000);
		util.waitUntilElementDisplay(btnArchieveDot);
		util.click(btnArchieveDot);
		Thread.sleep(1000);
		util.waitUntilElementDisplay(archieveOk);
		util.click(archieveOk);

		if (util.isElementPresent(btnUnArchieveDot)) {
			log("UnArchieve Present !!!", Status.PASS);
		} else {
			log("UnArchieve not Present !!!", Status.FAIL);
		}
	}
	By drpWBS = By.xpath("//span[text()='Project/WBS:']/..//input[@type='text']");
	public void setWBS(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpWBS, value);
//		util.pressENTERkey();

	}
	
	By drpWBSPopUp = By.xpath("//span[text()='Project/WBS:']/..//input[@type='text' and contains(@id,'prjInfo')]");
	public void setWBSPopUp(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpWBS, value);
//		util.pressENTERkey();

	}
	
	By firstStatus = By.xpath("(//*[contains(@id,'OBJPROJECTINFO_PROJECT_STATUS_ID_radYALDropDownList_DropDown')]/..//li[not(contains(text(),'Select One'))])[1]");
	By firstStatusPopup = By.xpath("(//*[contains(@id,'prjInfo_PROJECT_STATUS_ID_radYALDropDownList_DropDown')]/..//li[not(contains(text(),'Select One'))])[1]");
	
	By drpAccumaticaBranch = By.xpath("//span[text()='Accumatica Branch']/..//input[@type='text']");
	By drpAccumaticaSubAccount = By.xpath("//span[text()='Accumatica Subaccount']/..//input[@type='text']");
	
	public void setAccumaticaBranch(String value) {
		if (!commonFunction.checkNA(value))
//			util.inputTextAndPressTab(drpAccumaticaBranch, value);
			util.inputText(drpAccumaticaBranch, value);
		util.pressDownkey();
		util.pressENTERkey();

	}
	
	public void setAccumaticaSubAccount(String value) {
		if (!commonFunction.checkNA(value))
//			util.inputTextAndPressTab(drpAccumaticaSubAccount, value);
			util.inputText(drpAccumaticaSubAccount, value);
		util.pressDownkey();
		util.pressENTERkey();

	}
	
	public void addProjectInformation(Map<String, String> map,String testCaseName) throws InterruptedException {
		try {
			commonFunction.navigateToProjectDeails();
			log("STEP 1: User can navigate to the Project details", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: User cannot see the option in Menu ", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}
		try {
			commonFunction.clickOnAddButton();
			log("STEP 2: User can click on the add button", Status.PASS);
		} catch (Exception e) {
			log("STEP 2: User cannot click on the add button  ", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}
		
		if(util.isElementPresent(frmFull)){
			util.switchToIframe(frmFull);
			
			try {
				if(testCaseName.contains("AddProjectUA")) {
				PN =map.get(Excel.ProjectName)+util.randomNumber();
				setProjectNamePopUp(PN);}
			else {
				PN =map.get(Excel.ProjectName);
				setProjectNamePopUp(PN);
			}
				
				log("STEP 3: User can enter the value in the Project Name field ", Status.PASS);
			} catch (Exception e) {
				log("STEP 3: User cannot add value in the Project Name field ", Status.FAIL);
				throw new RuntimeException("Failed in step 3");
			}
			try {
				setProjectNumberPopUp();
				log("STEP 4: User can enter the value in the Project number  field", Status.PASS);
			} catch (Exception e) {
				log("STEP 4:  User cannot add value in the Project Number field ", Status.FAIL);
				throw new RuntimeException("Failed in step 4");
			}
			try {
				//setProjectTypePopUp(map.get(Excel.ProjectType));
				util.waitUntilElementDisplay(drpProjectTypePopUp);
				util.click(drpProjectTypePopUp);	
				util.click(firstTypePopup);
				log("STEP 5:  User can select value from the Project Type DD", Status.PASS);
			} catch (Exception e) {
				log("STEP 5:  User cannot select value from the Project Type DD", Status.FAIL);
				throw new RuntimeException("Failed in step 5");
			}
			if(util.isElementPresent(txtAbbreviationPopUp)) {
			try {
				setAbbreviationPopUp(map.get(Excel.Abbreviation));
				log("STEP 6:  User can enter Abbreviation value in the field    ", Status.PASS);
			} catch (Exception e) {
				log("STEP 6: User cannot add Abbreviation value in the field  ", Status.FAIL);
				throw new RuntimeException("Failed in step 6");
			}
			}
			
			try {
				//setAreaPopUp(map.get(Excel.Area));
				util.waitUntilElementDisplay(drpAreaPopUp);
				util.click(drpAreaPopUp);	
				if(environment.contains("NEXTERA")) {
					util.click(secondAreaPopup);
				}else {
				util.click(firstAreaPopup);
				}
				log("STEP 7: User can select Area value from the DD", Status.PASS);
			} catch (Exception e) {
				log("STEP 7: User cannot select Area value from the DD ", Status.FAIL);
				throw new RuntimeException("Failed in step 7");
			}
		
			
			if(testCaseName.contains("ROW") || testCaseName.contains("TRA") || testCaseName.contains("DOM")) {
				if(!environment.contains("WOLFMIDSTREAM")) {
					try {
						setProjectStatusROWPop();
						log( "STEP 8 : Added Project Status value displays in the field", Status.PASS);
					} catch (Exception e) {
						log("STEP 8 : User cannot select Project Status value from the DD ", Status.FAIL);
						throw new RuntimeException("Failed in step 8");
					}
					}
			}
			else {
				try {
					util.waitUntilElementDisplay(drpProjectStatusPopUp);
					util.click(drpProjectStatusPopUp);	
					util.click(firstStatusPopup);
					//setProjectStatusPopUp(map.get(Excel.ProjectStatus));
					log( "STEP 9: Added Project Status value displays in the field", Status.PASS);
				} catch (Exception e) {
					log("STEP 9: User cannot Select Project Status value from the DD", Status.FAIL);
					throw new RuntimeException("Failed in step 9");
				}
				
			}
		
			if(testCaseName.contains("ROW") || testCaseName.contains("TRA") || testCaseName.contains("DOM")) {
				if(util.isElementPresent(drpTemporaryRowPopUp)) {
			try {
				setTemporaryROWPopUp(map.get(Excel.TemporaryROW));
				log("STEP 10 : Added TemporaryROW value displays in the field", Status.PASS);
			} catch (Exception e) {
				log("STEP 10 : User cannot select  TemporaryROW value from the DD", Status.FAIL);
				throw new RuntimeException("Failed in step 10");
			}
				}
				
				if(util.isElementPresent(drpPermanentRowPopUp)) {
			try {
				setPermanentROWPopUp(map.get(Excel.PermanentROW));
				log("STEP 11 : Added PermanentROW value displays in the field", Status.PASS);
			} catch (Exception e) {
				log("STEP 11 : User cannot Select PermanentROW value from the DD", Status.FAIL);
				throw new RuntimeException("Failed in step 11");
			}
				}
				if(util.isElementPresent(drpUnitRowPopUp)) {
			try {
				setUnitPopUp(map.get(Excel.Unit));
				log("STEP 12 : Added Unit value displays in the field", Status.PASS);
			} catch (Exception e) {
				log("STEP 12 : User cannot Select Unit value from the DD", Status.FAIL);
				throw new RuntimeException("Failed in step 12");
			}
				}
			}
			try {
				setSAPCompanyCodePopUp(map.get(Excel.CompanyCode));
				log("STEP 13 : Added SAP Company Code value displays in the field", Status.PASS);
			} catch (Exception e) {
				log("STEP 13 : User cannot Select SAP Company Code value from the DD ", Status.FAIL);
				throw new RuntimeException("Failed in step 13");
			}
			try {
				setSAPPayingEntityPopUp(map.get(Excel.PayingEntity));
				log("STEP 14 : Added SAP Paying Entity value displays in the field", Status.PASS);
			} catch (Exception e) {
				log("STEP 14 : User cannot select SAP Paying Entity value from the DD", Status.FAIL);
				throw new RuntimeException("Failed in step 14");
			}
			try {
				setSAPProjectEntityPopUp(map.get(Excel.ProjectEntity));
				log("STEP 15 : Added SAP Project Entity value displays in the field", Status.PASS);
			} catch (Exception e) {
				log("STEP 15 : User cannot Select SAP Project Entity value from the DD", Status.FAIL);
				throw new RuntimeException("Failed in step 15");
			}
			
			if(util.isElementVisible(drpWBS)) {
				try {
					setWBSPopUp(map.get("WBS"));
					log("STEP 16 : Added WBS value displays in the field", Status.PASS);
				} catch (Exception e) { 
					log("STEP 16 : User cannot select value from the WBS DD ", Status.FAIL);
					throw new RuntimeException("Failed in step 16");
				}
				}
			
			try {
				commonFunction.clickOnInsertAndClose();
				util.switchToDefaultContent();
				util.dummyWait(1);
				log("STEP 17: User can click on Insert and Close Button", Status.PASS);
			} catch (Exception e) {
				log("STEP 17: User cannot click on Insert and Close Button ", Status.FAIL);
				throw new RuntimeException("Failed in step 17");
			}
		}
		else 
		{
		try {
			
				if(testCaseName.contains("AddProjectUA")) {
				PN =map.get(Excel.ProjectName)+util.randomNumber();
				setProjectName(PN);}
			else {
				PN =map.get(Excel.ProjectName);
				setProjectName(PN);
			}
			
			log("STEP 3: User can enter the value in the Project Name field ", Status.PASS);
		} catch (Exception e) {
			log("STEP 3: User cannot add value  to the Project Name field ", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}
		try {
			setProjectNumber();
			log("STEP 4: User can enter value in the Project number  field", Status.PASS);
		} catch (Exception e) {
			log("STEP 4:  User cannot add value  to the Project Number field ", Status.FAIL);
			throw new RuntimeException("Failed in step 4");
		}
		try {
			util.waitUntilElementDisplay(drpProjectType);
			util.click(drpProjectType);	
			util.click(firstType);
			//setProjectType(map.get(Excel.ProjectType));
			log("STEP 5:  Added value displays in the Project Type field", Status.PASS);
		} catch (Exception e) {
			log("STEP 5:  User  cannot select  value  from the Project Type DD ", Status.FAIL);
			throw new RuntimeException("Failed in step 5");
		}
		
		if(util.isElementPresent(txtAbbreviation)) {
		try {
			setAbbreviation(map.get(Excel.Abbreviation));
			log("STEP 6:  User can enter Abbreviation value in the field    ", Status.PASS);
		} catch (Exception e) {
			log("STEP 6: User cannot add Abbreviation value in the field  ", Status.FAIL);
			throw new RuntimeException("Failed in step 6");
		}
		}
		
		try {
			util.waitUntilElementDisplay(drpArea);
			util.click(drpArea);	
			if(environment.contains("NEXTERA")) {
				util.click(secondArea);
			}else {
			util.click(firstArea);
			}
			//setClient(map.get(Excel.Client));
			log("STEP 7 : Added Client value displays in the field", Status.PASS);
		} catch (Exception e) {
			log("STEP 7 :  User cannot Select Client value from the DD ", Status.FAIL);
			throw new RuntimeException("Failed in step 7");
		}
		if(testCaseName.contains("ROW") || testCaseName.contains("TRA") || testCaseName.contains("DOM")) {
			if(!environment.contains("WOLFMIDSTREAM")) {
			try {
				setProjectStatusROW();
				log( "STEP 8 : Added Project Status value displays in the field", Status.PASS);
			} catch (Exception e) {
				log("STEP 8 : User cannot select Project Status value from the DD ", Status.FAIL);
				throw new RuntimeException("Failed in step 8");
			}
			}
		}
		else {
			if(!environment.contains("NOVA")) {
			try {
				util.waitUntilElementDisplay(drpProjectStatus);
				util.click(drpProjectStatus);	
				util.click(firstStatus);
//				setProjectStatus(map.get(Excel.ProjectStatus));
				log( "STEP 9 : Added Project Status value displays in the field", Status.PASS);
			} catch (Exception e) {
				log("STEP 9 : User cannot select Project Status value from the DD ", Status.FAIL);
				throw new RuntimeException("Failed in step 9");
			}
			}
		}
		if(testCaseName.contains("ROW") || testCaseName.contains("TRA") || testCaseName.contains("DOM")) {
			if(util.isElementVisible(drpTemporaryRow)) {
		try {
			setTemporaryROW(map.get(Excel.TemporaryROW));
			log("STEP 10 : Added TemporaryROW value displays in the field", Status.PASS);
		} catch (Exception e) {
			log("STEP 10 : User cannot select TemporaryROW value from the DD ", Status.FAIL);
			throw new RuntimeException("Failed in step 10");
		}
			}
			
			if(util.isElementVisible(drpPermanentRow)) {
		try {
			setPermanentROW(map.get(Excel.PermanentROW));
			log("STEP 11 : Added PermanentROW value displays in the field", Status.PASS);
		} catch (Exception e) {
			log("STEP 11 : User cannot select PermanentROW value from the DD ", Status.FAIL);
			throw new RuntimeException("Failed in step 11");
		}
			}
			
			if(util.isElementPresent(drpBoardResolution)) {
				try {
					setBoardResolution(map.get(Excel.BoardResolutionROW));
					log("STEP 12 : User should be able to select the Board Resolution", Status.PASS);
				} catch (Exception e) {
					log("STEP 12 : User cannot Select board resolution value from the DD", Status.FAIL);
					throw new RuntimeException("Failed in step 12");
				}
					}
			
			
			if(util.isElementVisible(drpUnitRow)) {
		try {
			setUnit(map.get(Excel.Unit));
			log("STEP 13 : Added Unit value displays in the field", Status.PASS);
		} catch (Exception e) {
			log("STEP 13 : User cannot select value from the Unit DD ", Status.FAIL);
			throw new RuntimeException("Failed in step 13");
		}
			}
		}
		
		if(!environment.contains("WOLFMIDSTREAM")) {
		try {
			setSAPCompanyCode(map.get(Excel.CompanyCode));
			log("STEP 14 : Added SAP Company Code value displays in the field", Status.PASS);
		} catch (Exception e) {
			log("STEP 14 : User cannot select value from the SAP Company code DD", Status.FAIL);
			throw new RuntimeException("Failed in step 14");
		}
		try {
			setSAPPayingEntity(map.get(Excel.PayingEntity));
			log("STEP 15 : Added SAP Paying Entity value displays in the field", Status.PASS);
		} catch (Exception e) {
			log("STEP 15 : User cannot select value from the SAP Paying Entity DD", Status.FAIL);
			throw new RuntimeException("Failed in step 15");
		}
		try {
			setSAPProjectEntity(map.get(Excel.ProjectEntity));
			log("STEP 16 : Added SAP Project Entity value displays in the field", Status.PASS);
		} catch (Exception e) { 
			log("STEP 16 : User cannot select value from the SAP Project Entity DD ", Status.FAIL);
			throw new RuntimeException("Failed in step 16");
		}
		}
		
		if(util.isElementVisible(drpWBS)) {
			try {
				setWBS(map.get("WBS"));
				log("STEP 17 : Added WBS value displays in the field", Status.PASS);
			} catch (Exception e) { 
				log("STEP 17 : User cannot select value from the WBS DD ", Status.FAIL);
				throw new RuntimeException("Failed in step 17");
			}
			}
		
		if(environment.contains("NOVA")) {
			try {
				setAccumaticaBranch("NOVA");
				log("STEP 18 : User can select accumatica branch", Status.PASS);
			} catch (Exception e) { 
				log("STEP 18 : User cannot select accumatica branch ", Status.FAIL);
				throw new RuntimeException("Failed in step 18");
			}
		
			try {
				setAccumaticaSubAccount("Solar");
				log("STEP 19 :  User can select accumatica sub account", Status.PASS);
			} catch (Exception e) { 
				log("STEP 19 : User cannot select accumatica sub account ", Status.FAIL);
				throw new RuntimeException("Failed in step 19");
			}
			}
		
		try {
			commonFunction.clickOnSaveButton();
			log("STEP 20: User can click on Save button", Status.PASS);
		} catch (Exception e) {
			log("STEP 20: User can not click on save button ", Status.FAIL);
			throw new RuntimeException("Failed in step 20");
		}
		}
		
		AREA=util.getAttributeValue(drpArea, "value").trim();
		System.out.println(AREA);
		if(! testCaseName.contains("DOM")) {
		util.dummyWait(5);
		verifySummaryALT();
		}
	}

}
