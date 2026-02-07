package testsuit.ProjectImport;

import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.ExcelUtils;
import com.util.ReadPropertyFile;
import page.Common.LoginPage;
import pages.projectImportALT.AgentNotesImportPage;
import pages.projectImportALT.AgreementContactsImportPage;
import pages.projectImportALT.AgreementDataImportPage;
import pages.projectImportALT.AgreementMilestoneDatesImportPage;
import pages.projectImportALT.AgreementParcelsImportPage;
import pages.projectImportALT.AgreementTermsImportPage;
import pages.projectImportALT.DocumentImportPage;
import pages.projectImportALT.LandDataImportPage;
import pages.projectImportALT.ParcelContactImportPage;
import pages.projectImportALT.ParcelOwnerImportPage;
import pages.projectImportALT.PaymentHistoryImportPage;
import pages.projectImportALT.ProductionTrackingImportPage;
import pages.projectImportALT.ProjectImportPage;
import pages.projectImportALT.TitleIssueImportPage;
import pages.projectImportORSTED.FacilitiesDataImportPage;
import pages.projectImportORSTED.TurbineDataImportPage;

@Listeners(com.listeners.MyListeners.class)
public class ProjectImportTestALT extends BasePage {

	LoginPage objLogin;
	ProjectImportPage objProjectImportPage;
	LandDataImportPage objLandDataImportPage;
	ParcelOwnerImportPage objParcelOwnerImportPage;
	ParcelContactImportPage objParcelContactImportPage;
	AgreementDataImportPage objAgreementDataImportPage;
	AgreementParcelsImportPage objAgreementParcelsImportPage;
	AgreementTermsImportPage objAgreementTermsImportPage;
	AgentNotesImportPage objAgentNotesImportPage;
	AgreementContactsImportPage objAgreementContactsImportPage;
	TitleIssueImportPage objTitleIssueImportPage;
	DocumentImportPage objDocumentImportPage;
	ProductionTrackingImportPage objProductionTrackingImportPage;
	TurbineDataImportPage objTurbineDataImportPage;
	FacilitiesDataImportPage objFacilitiesDataImportPage;
	AgreementMilestoneDatesImportPage objAgreementMilestoneDatesImportPage;
	PaymentHistoryImportPage objPaymentHisotryImport;
	ReadPropertyFile readPro = new ReadPropertyFile();
	Map<String, String> map = new HashMap<String, String>();
	String testcaseName;

	@BeforeClass
	public void setup() throws Exception {
		driver = getDriver();
		objLogin = new LoginPage(driver);
		objProjectImportPage = new ProjectImportPage(driver);
		objLandDataImportPage = new LandDataImportPage(driver);
		objParcelOwnerImportPage = new ParcelOwnerImportPage(driver);
		objParcelContactImportPage = new ParcelContactImportPage(driver);
		objAgreementContactsImportPage = new AgreementContactsImportPage(driver);
		objAgreementDataImportPage = new AgreementDataImportPage(driver);
		objAgreementParcelsImportPage = new AgreementParcelsImportPage(driver);
		objAgreementTermsImportPage = new AgreementTermsImportPage(driver);
		objAgentNotesImportPage = new AgentNotesImportPage(driver);
		objTitleIssueImportPage = new TitleIssueImportPage(driver);
		objDocumentImportPage = new DocumentImportPage(driver);
		objProductionTrackingImportPage = new ProductionTrackingImportPage(driver);
		objTurbineDataImportPage = new TurbineDataImportPage(driver);
		objFacilitiesDataImportPage = new FacilitiesDataImportPage(driver);
		objAgreementMilestoneDatesImportPage = new AgreementMilestoneDatesImportPage(driver);
		objPaymentHisotryImport = new PaymentHistoryImportPage(driver);
	}

	@Test(priority = 1, enabled = false)
	public void Download_Import_Templates_TC_01() throws Exception {
		log("TC01 :Download Import Templates");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		objProjectImportPage.downloadImportTemplates();
	}

	@Test(priority = 2, enabled = true)
	public void verifyLandDataMapping_TC_02() throws Exception {
		log("TC02 :Verify Land Data Mapping");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		if (environment.contains("CONNECTGEN")) {
			testcaseName = "LandDataImportCONNECTGEN";
		} else if (environment.contains("NOVA")) {
			testcaseName = "LandDataImportNOVA";
		} else {
			testcaseName = "LandDataImport" + clientName;
		}
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportALT,
				testcaseName);
		objLandDataImportPage.verifyLandDataMapping(map, testcaseName);
	}

	@Test(priority = 3, enabled = true)
	public void ValidLandDataImport_TC_03() throws Exception {
		log("TC03 :Import Valid Land Data");
		if (environment.contains("CONNECTGEN")) {
			testcaseName = "LandDataImportCONNECTGEN";
		} else if (environment.contains("NOVA")) {
			testcaseName = "LandDataImportNOVA";
		} else {
			testcaseName = "LandDataImport" + clientName;
		}
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportALT,
				testcaseName);
		objProjectImportPage.loadDataToProject(map, testcaseName);
		objProjectImportPage.projectSelection(map, testcaseName);
		objLandDataImportPage.verifyImportedData(testcaseName);

	}

	@Test(priority = 4, enabled = true)
	public void InvalidLandDataImport_TC_04() throws Exception {
		log("TC04 :Verify Validation messages");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		if (environment.contains("CONNECTGEN")) {
			testcaseName = "LandDataImportCONNECTGEN";
		} else if (environment.contains("NOVA")) {
			testcaseName = "LandDataImportNOVA";
		} else {
			testcaseName = "LandDataImport" + clientName;
		}
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportALT,
				testcaseName);
		objProjectImportPage.invalidProjectDataImport(map, testcaseName);
		objLandDataImportPage.errorLogValidation(testcaseName);
	}

	@Test(priority = 5, enabled = true)
	public void verifyParcelOwnersMapping_TC_05() throws Exception {
		log("TC05 :Verify Parcel Owners Mapping");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		if (environment.contains("CONNECTGEN")) {
			testcaseName = "ParcelOwnersImportCONNECTGEN";
		} else if (environment.contains("NOVA")) {
			testcaseName = "ParcelOwnersImportNOVA";
		} else {
			testcaseName = "ParcelOwnersImport" + clientName;
		}
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportALT,
				testcaseName);
		objParcelOwnerImportPage.verifyParcelOwnerMapping(map, testcaseName);
	}

	@Test(priority = 6, enabled = true)
	public void validParcelOwnersImport_TC_06() throws Exception {
		log("TC06 :Import valid Parcel Owner Data");
		if (environment.contains("CONNECTGEN")) {
			testcaseName = "ParcelOwnersImportCONNECTGEN";
		} else if (environment.contains("NOVA")) {
			testcaseName = "ParcelOwnersImportNOVA";
		} else {
			testcaseName = "ParcelOwnersImport" + clientName;
		}
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportALT,
				testcaseName);
		objProjectImportPage.loadDataToProject(map, testcaseName);
		objProjectImportPage.projectSelection(map, testcaseName);
		if (testcaseName.contains("NOVA")) {
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.NOVA_PROJECTIMPORT_FILE), Excel.ParcelOwners,
					testcaseName);
		} else if (testcaseName.contains("CONNECTGEN")) {
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.CONNECTGEN_PROJECTIMPORT_FILE),
					Excel.ParcelOwners, testcaseName);
		} else if (testcaseName.contains("ATWELL")) {
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ATWELL_PROJECTIMPORT_FILE), Excel.ParcelOwners,
					testcaseName);
		} else if (testcaseName.contains("ORSTED")) {
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ORSTED_PROJECTIMPORT_FILE), Excel.ParcelOwners,
					testcaseName);
		} else {
			if(environment.contains("STEELHEAD")) {
				map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.STEELHEAD_PROJECTIMPORT_FILE), Excel.ParcelOwners,
						testcaseName);
			}else {
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ALT_PROJECTIMPORT_FILE), Excel.ParcelOwners,
					testcaseName);
			}
		}
		objParcelOwnerImportPage.validationOfImportedData(map, testcaseName);
	}

	@Test(priority = 7, enabled = true)
	public void InvalidParcelOwnerImport_TC_07() throws Exception {
		log("TC07 :Importing Invalid parcel owner data");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		if (environment.contains("CONNECTGEN")) {
			testcaseName = "ParcelOwnersImportCONNECTGEN";
		} else if (environment.contains("NOVA")) {
			testcaseName = "ParcelOwnersImportNOVA";
		} else {
			testcaseName = "ParcelOwnersImport" + clientName;
		}
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportALT,
				testcaseName);
		objProjectImportPage.invalidProjectDataImport(map, testcaseName);
		objParcelOwnerImportPage.errorLogValidation(testcaseName);
	}

	@Test(priority = 8, enabled = true)
	public void verifyParcelContactsMapping_TC_08() throws Exception {
		log("TC08 :Verify Parcel Contacts Mapping");
		if (!environment.contains("CONNECTGEN")) {
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
			testcaseName = "ParcelContactsImport" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportALT,
				testcaseName);
		objParcelContactImportPage.verifyParcelContactsMapping(map, testcaseName);
		}else {
			log("Parcel contacts Import is not applicable for this client", Status.SKIP);
		}
	}

	@Test(priority = 9, enabled = true)
	public void validParcelContactsImport_TC_09() throws Exception {
		log("TC09 :Import valid Parcel Contacts Data");
		if (!environment.contains("CONNECTGEN")) {
			testcaseName = "ParcelContactsImport" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportALT,
				testcaseName);
		objProjectImportPage.loadDataToProject(map, testcaseName);
		objProjectImportPage.projectSelection(map, testcaseName);
		if(testcaseName.contains("ORSTED")) {
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ORSTED_PROJECTIMPORT_FILE), Excel.ParcelContacts,
					testcaseName);
		}else {
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ALT_PROJECTIMPORT_FILE), Excel.ParcelContacts,
					testcaseName);
		}
		objParcelContactImportPage.validationOfImportedData(map, testcaseName);
		}else {
			log("Parcel contacts Import is not applicable for this client", Status.SKIP);
		}
	}

	@Test(priority = 10, enabled = true)
	public void InvalidParcelcontactsImport_TC_10() throws Exception {
		log("TC10 :Importing Invalid parcel Contacts data");
		if (!environment.contains("CONNECTGEN")) {
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		testcaseName = "ParcelContactsImport" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportALT,
				testcaseName);
		objProjectImportPage.invalidProjectDataImport(map, testcaseName);
		objParcelContactImportPage.errorLogValidation(testcaseName);
		}else {
			log("Parcel contacts Import is not applicable for this client", Status.SKIP);
		}
	}
	
	@Test(priority = 11, enabled = true)
	public void verifyAgreementDataMapping_TC_11() throws Exception {
		log("TC11 :Verify Agreement Data Mapping");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		if (environment.contains("CONNECTGEN")) {
			testcaseName = "AgreementDataImportCONNECTGEN";
		} else if (environment.contains("NOVA")) {
			testcaseName = "AgreementDataImportNOVA";
		} else {
			testcaseName = "AgreementDataImport" + clientName;
		}
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportALT,
				testcaseName);
		objAgreementDataImportPage.verifyAgreementDataMapping(map, testcaseName);
	}

	@Test(priority = 12, enabled = true)
	public void validAgreementDataImport_TC_12() throws Exception {
		log("TC12 :Import valid Agreement Data");
		if (environment.contains("CONNECTGEN")) {
			testcaseName = "AgreementDataImportCONNECTGEN";
		} else if (environment.contains("NOVA")) {
			testcaseName = "AgreementDataImportNOVA";
		} else {
			testcaseName = "AgreementDataImport" + clientName;
		}
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportALT,
				testcaseName);
		objProjectImportPage.loadDataToProject(map, testcaseName);
		objProjectImportPage.projectSelectionAgreement(map, testcaseName);

		for (int i = 1; i < ExcelUtils.totalRows - 1; i++) {
			String rowName =  testcaseName+ i;
			if (testcaseName.contains("NOVA")) {
				map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.NOVA_PROJECTIMPORT_FILE),
						Excel.AgreementData, rowName);
			} else if (testcaseName.contains("CONNECTGEN")) {
				map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.CONNECTGEN_PROJECTIMPORT_FILE),
						Excel.AgreementData, rowName);
			} else if (testcaseName.contains("ATWELL")) {
				map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ATWELL_PROJECTIMPORT_FILE),
						Excel.AgreementData, rowName);
			}else if (testcaseName.contains("ORSTED")) {
				map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ORSTED_PROJECTIMPORT_FILE),
						Excel.AgreementData, rowName);
			} else {
				if(environment.contains("STEELHEAD")) {
                    map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.STEELHEAD_PROJECTIMPORT_FILE),
                            Excel.AgreementData, rowName);
				}else {
				map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ALT_PROJECTIMPORT_FILE),
						Excel.AgreementData, rowName);
				}
			}
			objAgreementDataImportPage.validationOfImportedData(map, rowName);
		}
	}

	@Test(priority = 13, enabled = true)
	public void InvalidAgreementDataImport_TC_13() throws Exception {
		log("TC13 :Importing Invalid Agreement Data");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		if (environment.contains("CONNECTGEN")) {
			testcaseName = "AgreementDataImportCONNECTGEN";
		} else if (environment.contains("NOVA")) {
			testcaseName = "AgreementDataImportNOVA";
		} else {
			testcaseName = "AgreementDataImport" + clientName;
		}
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportALT,
				testcaseName);
		objProjectImportPage.invalidProjectDataImport(map, testcaseName);
		objAgreementDataImportPage.errorLogValidation(testcaseName);
	}

	@Test(priority = 14, enabled = true)
	public void verifyAgreementParcelsMapping_TC_14() throws Exception {
		if(!environment.contains("VERDANTERRA")) {
		log("TC14 :Verify Agreement Data Mapping");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		if (environment.contains("CONNECTGEN")) {
			testcaseName = "AgreementParcelsImportCONNECTGEN";
		} else if (environment.contains("NOVA")) {
			testcaseName = "AgreementParcelsImportNOVA";
		} else {
			testcaseName = "AgreementParcelsImport" + clientName;
		}
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportALT,
				testcaseName);
		objAgreementParcelsImportPage.verifyAgreementParcelsMapping(map, testcaseName);
		}else {
			log("Agreement Import is not applicable for this client", Status.SKIP);
		}
	}

	@Test(priority = 15, enabled = true)
	public void validAgreementParcelsImport_TC_15() throws Exception {
		if(!environment.contains("VERDANTERRA")) {
		log("TC15 :Import valid Agreement Data");
		if (environment.contains("CONNECTGEN")) {
			testcaseName = "AgreementParcelsImportCONNECTGEN";
		} else if (environment.contains("NOVA")) {
			testcaseName = "AgreementParcelsImportNOVA";
		} else {
			testcaseName = "AgreementParcelsImport" + clientName;
		}
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportALT,
				testcaseName);
		objProjectImportPage.loadDataToProject(map, testcaseName);
		objProjectImportPage.projectSelectionAgreement(map, testcaseName);
		if (testcaseName.contains("NOVA")) {
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.NOVA_PROJECTIMPORT_FILE),
					Excel.AgreementParcels, testcaseName);
		} else if (testcaseName.contains("CONNECTGEN")) {
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.CONNECTGEN_PROJECTIMPORT_FILE),
					Excel.AgreementParcels, testcaseName);
		} else if (testcaseName.contains("ATWELL")) {
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ATWELL_PROJECTIMPORT_FILE),
					Excel.AgreementParcels, testcaseName);
		}else if (testcaseName.contains("ORSTED")) {
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ORSTED_PROJECTIMPORT_FILE),
					Excel.AgreementParcels, testcaseName);
		} else {
			if(environment.contains("STEELHEAD")) {
                map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.STEELHEAD_PROJECTIMPORT_FILE),
                        Excel.AgreementParcels, testcaseName);
			}else {
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ALT_PROJECTIMPORT_FILE), Excel.AgreementParcels,
					testcaseName);
			}
		}
		objAgreementParcelsImportPage.validationOfImportedData(map, testcaseName);
		}else {
			log("Agreement Import is not applicable for this client", Status.SKIP);
		}
	}

	@Test(priority = 16, enabled = true)
	public void InvalidAgreementParcelsImport_TC_16() throws Exception {
		if(!environment.contains("VERDANTERRA")) {
		log("TC16 :Importing Invalid Agreement Data");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		if (environment.contains("CONNECTGEN")) {
			testcaseName = "AgreementParcelsImportCONNECTGEN";
		} else if (environment.contains("NOVA")) {
			testcaseName = "AgreementParcelsImportNOVA";
		} else {
			testcaseName = "AgreementParcelsImport" + clientName;
		}
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportALT,
				testcaseName);
		objProjectImportPage.invalidProjectDataImport(map, testcaseName);
		objAgreementParcelsImportPage.errorLogValidation(testcaseName);
		}else {
			log("Agreement Import is not applicable for this client", Status.SKIP);
		}
	}

	@Test(priority = 17, enabled = true)
	public void verifyAgreementTermsMapping_TC_17() throws Exception {
		if(!environment.contains("VERDANTERRA")) {
		log("TC17 :Verify Agreement Terms Mapping");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		if (environment.contains("CONNECTGEN")) {
			testcaseName = "AgreementTermsImportCONNECTGEN";
		} else if (environment.contains("NOVA")) {
			testcaseName = "AgreementTermsImportNOVA";
		} else {
			testcaseName = "AgreementTermsImport" + clientName;
		}
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportALT,
				testcaseName);
		objAgreementTermsImportPage.verifyAgreementTermsMapping(map, testcaseName);
	}else {
		log("Agreement Import is not applicable for this client", Status.SKIP);
	}
	}

	@Test(priority = 18, enabled = true)
	public void validAgreementTermsImport_TC_18() throws Exception {
		if(!environment.contains("VERDANTERRA")) {
		log("TC18 :Import valid Agreement Terms");
		if (environment.contains("CONNECTGEN")) {
			testcaseName = "AgreementTermsImportCONNECTGEN";
		} else if (environment.contains("NOVA")) {
			testcaseName = "AgreementTermsImportNOVA";
		} else {
			testcaseName = "AgreementTermsImport" + clientName;
		}
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportALT,
				testcaseName);
		objProjectImportPage.loadDataToProject(map, testcaseName);
		objProjectImportPage.projectSelectionAgreement(map, testcaseName);
		for (int i = 1; i < ExcelUtils.totalRows - 1; i++) {
			String rowName = testcaseName + i;
			if (testcaseName.contains("NOVA")) {
				map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.NOVA_PROJECTIMPORT_FILE),
						Excel.AgreementTerms, rowName);
			} else if (testcaseName.contains("CONNECTGEN")) {
				map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.CONNECTGEN_PROJECTIMPORT_FILE),
						Excel.AgreementTerms, rowName);
			} else if (testcaseName.contains("ATWELL")) {
				map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ATWELL_PROJECTIMPORT_FILE),
						Excel.AgreementTerms, rowName);
			}else if (testcaseName.contains("ORSTED")) {
				map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ORSTED_PROJECTIMPORT_FILE),
						Excel.AgreementTerms, rowName);
			} else {
				if(environment.contains("STEELHEAD")) {
                    map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.STEELHEAD_PROJECTIMPORT_FILE),
                            Excel.AgreementTerms, rowName);
				}else {
				map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ALT_PROJECTIMPORT_FILE),
						Excel.AgreementTerms, rowName);
				}
			}
			objAgreementTermsImportPage.validationOfImportedData(map, rowName);
		}
		}else {
			log("Agreement Import is not applicable for this client", Status.SKIP);
		}
	}

	@Test(priority = 19, enabled = true)
	public void InvalidAgreementTermsImport_TC_19() throws Exception {
		if(!environment.contains("VERDANTERRA")) {
		log("TC19 :Importing Invalid Agreement Terms");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		if (environment.contains("CONNECTGEN")) {
			testcaseName = "AgreementTermsImportCONNECTGEN";
		} else if (environment.contains("NOVA")) {
			testcaseName = "AgreementTermsImportNOVA";
		} else {
			testcaseName = "AgreementTermsImport" + clientName;
		}
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportALT,
				testcaseName);
		objProjectImportPage.invalidProjectDataImport(map, testcaseName);
		objAgreementTermsImportPage.errorLogValidation(testcaseName);
	}else {
		log("Agreement Import is not applicable for this client", Status.SKIP);
	}
	}

	@Test(priority=20, enabled=true)
	public void verifyAgentNotesMapping_TC_20() throws Exception {
		log("TC20 :Verify Agent Notes Mapping");
		if (!environment.contains("CONNECTGEN")) {
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		String testcaseName = "AgentNotesImport" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportALT, testcaseName);
		objAgentNotesImportPage.verifyAgentNotesImportMapping(map, testcaseName);
		}else {
			log("Agent Notes Import is not applicable for this client", Status.SKIP);
		}
	}
	
	@Test(priority=21, enabled=true)
	public void ValidAgentNotesImport_TC_21() throws Exception {
		log("TC21 :Import Valid Agent Notes Data");
		if (!environment.contains("CONNECTGEN")) {
		String testcaseName = "AgentNotesImport" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportALT, testcaseName);
		objProjectImportPage.loadDataToProject(map, testcaseName);
		objProjectImportPage.NotesSelection(map, testcaseName);
		objAgentNotesImportPage.validationOfImportedData(testcaseName);
		}else {
			log("Agent Notes Import is not applicable for this client", Status.SKIP);
		}
	}
	
	@Test(priority=22, enabled=true)
	public void InvalidAgentNotesImport_TC_22() throws Exception {
		log("TC22 :Verify Validation messages");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		String testcaseName = "AgentNotesImport" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportALT, testcaseName);
		objProjectImportPage.invalidProjectDataImport(map, testcaseName);
		objAgentNotesImportPage.errorLogValidation(testcaseName);
	}
	
	@Test(priority = 23, enabled = true)
	public void verifyAgreementContactsMapping_TC_23() throws Exception {
		log("TC23 :Verify Agreement contacts Mapping");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		if (environment.contains("CONNECTGEN")) {
			testcaseName = "AgreementContactsImportCONNECTGEN";
		} else if (environment.contains("NOVA")) {
			testcaseName = "AgreementContactsImportNOVA";
		} else {
			testcaseName = "AgreementContactsImport" + clientName;
		}
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportALT,
				testcaseName);
		objAgreementContactsImportPage.verifyAgreementContactsMapping(map, testcaseName);
		
	}

	@Test(priority = 24, enabled = true)
	public void validAgreementContactsImport_TC_24() throws Exception {
		if(!environment.contains("VERDANTERRA")) {
		log("TC24 :Import valid Agreement Contacts Data");
		if (environment.contains("CONNECTGEN")) {
			testcaseName = "AgreementContactsImportCONNECTGEN";
		} else if (environment.contains("NOVA")) {
			testcaseName = "AgreementContactsImportNOVA";
		} else {
			testcaseName = "AgreementContactsImport" + clientName;
		}
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportALT,
				testcaseName);
		objProjectImportPage.loadDataToProject(map, testcaseName);
		objProjectImportPage.projectSelectionAgreement(map, testcaseName);
		if (testcaseName.contains("NOVA")) {
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.NOVA_PROJECTIMPORT_FILE),
					Excel.AgreementContacts, testcaseName);
		} else if (testcaseName.contains("CONNECTGEN")) {
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.CONNECTGEN_PROJECTIMPORT_FILE),
					Excel.AgreementContacts, testcaseName);
		} else if (testcaseName.contains("ATWELL")) {
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ATWELL_PROJECTIMPORT_FILE),
					Excel.AgreementContacts, testcaseName);
		}else if (testcaseName.contains("ORSTED")) {
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ORSTED_PROJECTIMPORT_FILE),
					Excel.AgreementContacts, testcaseName);
		} else {
			if(environment.contains("STEELHEAD")) {
                map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.STEELHEAD_PROJECTIMPORT_FILE),
                        Excel.AgreementContacts, testcaseName);
			}else {
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ALT_PROJECTIMPORT_FILE),
					Excel.AgreementContacts, testcaseName);
			}
		}
		objAgreementContactsImportPage.validationOfImportedData(map, testcaseName);
		}else {
			log("Agreement Import is not applicable for this client", Status.SKIP);
		}
	}

	@Test(priority = 25, enabled = true)
	public void InvalidAgreementContactsImport_TC_25() throws Exception {
		if(!environment.contains("VERDANTERRA")) {
		log("TC25 :Importing Invalid Agreement Contacts data");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		if (environment.contains("CONNECTGEN")) {
			testcaseName = "AgreementContactsImportCONNECTGEN";
		} else if (environment.contains("NOVA")) {
			testcaseName = "AgreementContactsImportNOVA";
		} else {
			testcaseName = "AgreementContactsImport" + clientName;
		}
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportALT,
				testcaseName);
		objProjectImportPage.invalidProjectDataImport(map, testcaseName);
		objAgreementContactsImportPage.errorLogValidation(testcaseName);
		}else {
			log("Agreement Import is not applicable for this client", Status.SKIP);
		}
	}

	@Test(priority=26, enabled=true)
	public void verifyTitleImportMapping_TC_26() throws Exception {
		if(!environment.contains("GRAYHAWKALT") & !environment.contains("ATWELL") & !environment.contains("ORSTED") & !environment.contains("AVANTUS") & !environment.contains("RAMACO")& !environment.contains("WSBALT")) {
		log("TC26 :Verify Title Import Mapping");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		String testcaseName = "TitleImport" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportALT, testcaseName);
		objTitleIssueImportPage.verifyTitleImportMapping(map, testcaseName);
		} else {
			log("Title Import is not applicable for " + environment, Status.SKIP);
		}
	}
	
	@Test(priority=27, enabled=true)
	public void ValidTitleImport_TC_27() throws Exception {
		if(!environment.contains("GRAYHAWKALT") & !environment.contains("ATWELL") & !environment.contains("ORSTED") & !environment.contains("AVANTUS") & !environment.contains("RAMACO") & !environment.contains("WSBALT")) {
		log("TC27 :Import Valid Title Import Data");
		String testcaseName = "TitleImport" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportALT, testcaseName);
		objProjectImportPage.loadDataToProject(map, testcaseName);
		objProjectImportPage.titleSelection(map, testcaseName);
		if(environment.contains("STEELHEAD")) {
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.STEELHEAD_PROJECTIMPORT_FILE), Excel.TitleImportALT,testcaseName);
		}else {
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ALT_PROJECTIMPORT_FILE), Excel.TitleImportALT,testcaseName);
		}
		objTitleIssueImportPage.validationOfImportedData(map,testcaseName);
		} else {
			log("Title Import is not applicable for " + environment, Status.SKIP);
		}
	}
	
	@Test(priority=28, enabled=true)
	public void InvalidTitleImport_TC_28() throws Exception {
		if(!environment.contains("GRAYHAWKALT") & !environment.contains("ATWELL") & !environment.contains("ORSTED") & !environment.contains("AVANTUS") & !environment.contains("RAMACO") & !environment.contains("WSBALT")) {
		log("TC28 :Verify Validation messages");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		String testcaseName = "TitleImport" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportALT, testcaseName);
		objProjectImportPage.invalidProjectDataImport(map, testcaseName);
		objTitleIssueImportPage.errorLogValidation(testcaseName);
		} else {
			log("Title Import is not applicable for " + environment, Status.SKIP);
		}
	}
	
	@Test(priority = 29, enabled = true)
	public void verifyAgreementMilestoneDatesMapping_TC_23() throws Exception {
		log("TC29 :Verify Agreement Milestone Dates Mapping");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		if (environment.contains("CONNECTGEN")) {
			testcaseName = "AgreementMilestoneDatesImportCONNECTGEN";
		} else if (environment.contains("NOVA")) {
			testcaseName = "AgreementMilestoneDatesImportNOVA";
		} else {
			testcaseName = "AgreementMilestoneDatesImport" + clientName;
		}
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportALT,
				testcaseName);
		objAgreementMilestoneDatesImportPage.verifyAgreementMilestoneDatesMapping(map, testcaseName);
	}
	
	@Test(priority = 30, enabled = true)
	public void validAgreementMilestoneDatesImport_TC_30() throws Exception {
		if(!environment.contains("TREATYOAK") & !environment.contains("NEXTERA")) {
		log("TC 30 :Import valid Agreement Milestone Dates Import");
		if (environment.contains("CONNECTGEN")) {
			testcaseName = "AgreementMilestoneDatesImportCONNECTGEN";
		} else if (environment.contains("NOVA")) {
			testcaseName = "AgreementMilestoneDatesImportNOVA";
		} else {
			testcaseName = "AgreementMilestoneDatesImport" + clientName;
		}
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportALT,
				testcaseName);
		objProjectImportPage.loadDataToProject(map, testcaseName);
		objProjectImportPage.projectSelectionAgreement(map, testcaseName);
		if (testcaseName.contains("NOVA")) {
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.NOVA_PROJECTIMPORT_FILE),
					Excel.AgreementMilestoneDates, testcaseName);
		} else if (testcaseName.contains("CONNECTGEN")) {
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.CONNECTGEN_PROJECTIMPORT_FILE),
					Excel.AgreementMilestoneDates, testcaseName);
		} else if (testcaseName.contains("ATWELL")) {
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ATWELL_PROJECTIMPORT_FILE),
					Excel.AgreementMilestoneDates, testcaseName);
		}else if (testcaseName.contains("ORSTED")) {
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ORSTED_PROJECTIMPORT_FILE),
					Excel.AgreementMilestoneDates, testcaseName);
		} else {
			if(environment.contains("STEELHEAD")) {
                map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.STEELHEAD_PROJECTIMPORT_FILE),
                        Excel.AgreementMilestoneDates, testcaseName);
			}else {
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ALT_PROJECTIMPORT_FILE),
					Excel.AgreementMilestoneDates, testcaseName);
			}
		}
		objAgreementMilestoneDatesImportPage.validationOfImportedData(map, testcaseName);
		}else {
			log("Agreement Import is not applicable for this client", Status.SKIP);
		}
	}
	
	@Test(priority = 31, enabled = true)
	public void InvalidAgreementMilestoneDatesImport_TC_31() throws Exception {
		log("TC 31 :Importing Invalid Agreement Milestone Dates Data");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		if (environment.contains("CONNECTGEN")) {
			testcaseName = "AgreementMilestoneDatesImportCONNECTGEN";
		} else if (environment.contains("NOVA")) {
			testcaseName = "AgreementMilestoneDatesImportNOVA";
		} else {
			testcaseName = "AgreementMilestoneDatesImport" + clientName;
		}
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportALT,
				testcaseName);
		objProjectImportPage.invalidProjectDataImport(map, testcaseName);
		objAgreementMilestoneDatesImportPage.errorLogValidation(testcaseName);
	}
	
	@Test(priority = 32, enabled = true)
	public void verifyPaymentHistoryImportMapping_TC_32() throws Exception {
		if(!environment.contains("CONNECTGEN")) {
		log("TC 32 :Verify Payment History Import Mapping");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		if (environment.contains("NOVA")) {
			testcaseName = "PaymentHistoryImportNOVA";
		} else{
		testcaseName = "PaymentHistoryImport" + clientName;
		}
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportALT,
				testcaseName);
		objPaymentHisotryImport.verifyPaymentHistoryMapping(map, testcaseName);
		}else {
			log("Agreement Import is not applicable for this client", Status.SKIP);
		}
	}
	
	@Test(priority = 33, enabled = true)
	public void validPaymentHistoryImport_TC_33() throws Exception {
		if(!environment.contains("CONNECTGEN")) {
		log("TC 33 :Import valid Payment History Import Data");
		if (environment.contains("NOVA")) {
			testcaseName = "PaymentHistoryImportNOVA";
		} else {
		testcaseName = "PaymentHistoryImport" + clientName;
		}
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportALT,
				testcaseName);
		objProjectImportPage.loadDataToProject(map, testcaseName);
		objProjectImportPage.projectSelectionAgreement(map, testcaseName);
		if (testcaseName.contains("NOVA")) {
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.NOVA_PROJECTIMPORT_FILE),
					Excel.PaymentHistory, testcaseName);
		} else if (testcaseName.contains("ATWELL")) {
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ATWELL_PROJECTIMPORT_FILE),
					Excel.PaymentHistory, testcaseName);
		}else if (testcaseName.contains("ORSTED")) {
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ORSTED_PROJECTIMPORT_FILE),
					Excel.PaymentHistory, testcaseName);
		} else {
			if(environment.contains("STEELHEAD")) {
                map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.STEELHEAD_PROJECTIMPORT_FILE),
                        Excel.PaymentHistory, testcaseName);
			}else {
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ALT_PROJECTIMPORT_FILE),
					Excel.PaymentHistory, testcaseName);
			}
		}
		objPaymentHisotryImport.validationOfImportedData(map, testcaseName);
		}else {
			log("Agreement Import is not applicable for this client", Status.SKIP);
		}
	}
	
	@Test(priority = 34, enabled = true)
	public void InvalidPaymentHistoryImport_TC_34() throws Exception {
		if(!environment.contains("CONNECTGEN")) {
		log("TC 34 :Importing Invalid Payment History Import Data");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		   testcaseName = "PaymentHistoryImport" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportALT,
				testcaseName);
		objProjectImportPage.invalidProjectDataImport(map, testcaseName);
		objPaymentHisotryImport.errorLogValidation(testcaseName);
		}else {
			log("Agreement Import is not applicable for this client", Status.SKIP);
		}
	}
	
	@Test(priority = 35, enabled = true)
	public void verifyDocumentLinksMapping_TC_35() throws Exception {
		if (environment.contains("CONNECTGEN")) {
			log("TC 35 :Verify Document Links Mapping");
			navigateToApplication(appURL);
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
			objLogin.login(map);
			String testcaseName = "DocumentLinksImportCONNECTGEN";
			log("Data picked : " + testcaseName);
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportALT,
					testcaseName);
			objDocumentImportPage.verifyDocumentImportMapping(map, testcaseName);
		} else {
			log("Document Link Import is not applicable for " + environment, Status.SKIP);
		}
	}

	@Test(priority = 36, enabled = true)
	public void validDocumentLinkImport_TC_36() throws Exception {
		if (environment.contains("CONNECTGEN")) {
			log("TC 36 :Import valid Document Link Data");
			String testcaseName = "DocumentLinksImportCONNECTGEN";
			log("Data picked : " + testcaseName);
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportALT,
					testcaseName);
			objProjectImportPage.loadDataToProject(map, testcaseName);
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.CONNECTGEN_PROJECTIMPORT_FILE),
					Excel.DocumentLinks, testcaseName);
			objDocumentImportPage.validationOfImportedData(map, testcaseName);
		} else {
			log("Document Link Import is not applicable for " + environment, Status.SKIP);
		}
	}

	@Test(priority = 37, enabled = true)
	public void InvalidDocumentLinkImport_TC_37() throws Exception {
		if (environment.contains("CONNECTGEN")) {
			log("TC 37 :Importing Invalid Document Links data");
			navigateToApplication(appURL);
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
			objLogin.login(map);
			String testcaseName = "DocumentLinksImportCONNECTGEN";
			log("Data picked : " + testcaseName);
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportALT,
					testcaseName);
			objProjectImportPage.invalidProjectDataImport(map, testcaseName);
			objDocumentImportPage.errorLogValidation(testcaseName);
		} else {
			log("Document Link Import is not applicable for " + environment, Status.SKIP);
		}
	}

	@Test(priority = 38, enabled = true)
	public void verifyProductionTrackingImportMapping_TC_38() throws Exception {
		if (environment.contains("CONNECTGEN") || environment.contains("ORION") || environment.contains("ORSTED")) {
			log("TC 38 :Verify Production Tracking Import Mapping");
			navigateToApplication(appURL);
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
			objLogin.login(map);
			if (environment.contains("CONNECTGEN")) {
				testcaseName = "ProductionTrackingImportCONNECTGEN";
			} else {
				testcaseName = "ProductionTrackingImport" + clientName;
			}
			log("Data picked : " + testcaseName);
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportALT,
					testcaseName);
			objProductionTrackingImportPage.verifyProductionTrackingImportMapping(map, testcaseName);
		} else {
			log("Production Tracking Import is not applicable for this client", Status.SKIP);
		}
	}

	@Test(priority = 39, enabled = true)
	public void validProductionTrackingImport_TC_39() throws Exception {
		if (environment.contains("CONNECTGEN") || environment.contains("ORSTED")) {
			log("TC 39 :Import valid Production Tracking Data");
			if (environment.contains("CONNECTGEN")) {
				testcaseName = "ProductionTrackingImportCONNECTGEN";
			} else {
				testcaseName = "ProductionTrackingImport" + clientName;
			}
			log("Data picked : " + testcaseName);
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportALT,
					testcaseName);
			objProjectImportPage.loadDataToProject(map, testcaseName);
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PRODUCTION_TRACKING_IMPORT_FILE),
					Excel.ProductionTrackingImport, testcaseName);
			objProductionTrackingImportPage.validationOfImportedData(map, testcaseName);
		} else {
			log("Production Tracking Import is not applicable for this client", Status.SKIP);
		}
	}

	@Test(priority = 40, enabled = true)
	public void InvalidProductionTrackingImport_TC_40() throws Exception {
		if (environment.contains("CONNECTGEN") || environment.contains("ORION") || environment.contains("ORSTED")) {
			log("TC 40 :Importing Invalid Production Tracking data");
			navigateToApplication(appURL);
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
			objLogin.login(map);
			if (environment.contains("CONNECTGEN")) {
				testcaseName = "ProductionTrackingImportCONNECTGEN";
			} else {
				testcaseName = "ProductionTrackingImport" + clientName;
			}
			log("Data picked : " + testcaseName);
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportALT,
					testcaseName);
			objProjectImportPage.invalidProjectDataImport(map, testcaseName);
			objProductionTrackingImportPage.errorLogValidation(testcaseName);
		} else {
			log("Production Tracking Import is not applicable for this client", Status.SKIP);
		}
	}

	@Test(priority=41, enabled=true)
	public void verifyFacilitiesDataMapping_TC_41() throws Exception {
		if (environment.contains("ORSTED")) {
		log("TC 41 :Verify Facilities Data Import Mapping");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		String testcaseName = "FacilitiesDataImport" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportALT, testcaseName);
		objFacilitiesDataImportPage.verifyFacilitiesDataImportMapping(map, testcaseName);
		} else {
			log("Facilities Data Import is not applicable for this client", Status.SKIP);
		}
	}
	
	@Test(priority=42, enabled=true)
	public void ValidFacilitiesData_TC_42() throws Exception {
		if (environment.contains("ORSTED")) {
		log("TC 42 :Import Valid Facilities Data");
		String testcaseName = "FacilitiesDataImport" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportALT, testcaseName);
		objProjectImportPage.loadDataToProject(map, testcaseName);
		objProjectImportPage.projectSelectionPermanentInfrastructure(map, testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ORSTED_PROJECTIMPORT_FILE), Excel.FacilitiesData,testcaseName);
		objFacilitiesDataImportPage.verifyImportedFacilitiesData(map,testcaseName);	
		} else {
			log("Facilities Data Import is not applicable for this client", Status.SKIP);
		}
	}
	
	@Test(priority=43, enabled=true)
	public void InvalidFacilitiesData_TC_43() throws Exception {
		if (environment.contains("ORSTED")) {
		log("TC 43 :Verify Validation messages");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		String testcaseName = "FacilitiesDataImport" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportALT, testcaseName);
		objProjectImportPage.invalidProjectDataImport(map, testcaseName);
		objFacilitiesDataImportPage.errorLogValidation(testcaseName);
		} else {
			log("Facilities Data Import is not applicable for this client", Status.SKIP);
		}
	}
	
	@Test(priority=44, enabled=true)
	public void verifyTurbineDataMapping_TC_44() throws Exception {
		if (environment.contains("ORSTED") || environment.contains("STEELHEAD")) {
		log("TC 44 :Verify Turbine Data Import Mapping");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		String testcaseName = "TurbineDataImport" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportALT, testcaseName);
		objTurbineDataImportPage.verifyTurbineDataImportMapping(map, testcaseName);
		} else {
			log("Turbine Data Import is not applicable for this client", Status.SKIP);
		}
	}
	
	@Test(priority=45, enabled=true)
	public void ValidTurbineData_TC_45() throws Exception {
		if (environment.contains("ORSTED") || environment.contains("STEELHEAD")) {
		log("TC 45 :Import Valid Turbine Data");
		String testcaseName = "TurbineDataImport" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportALT, testcaseName);
		objProjectImportPage.loadDataToProject(map, testcaseName);
		objProjectImportPage.projectSelectionPermanentInfrastructure(map, testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ORSTED_PROJECTIMPORT_FILE), Excel.TurbineData,testcaseName);
		objTurbineDataImportPage.verifyImportedTurbineData(map,testcaseName);
		} else {
			log("Turbine Data Import is not applicable for this client", Status.SKIP);
		}
	}
	
	@Test(priority=46, enabled=true)
	public void InvalidTurbineData_TC_46() throws Exception {
		if (environment.contains("ORSTED") || environment.contains("STEELHEAD")) {
		log("TC 46 :Verify Validation messages");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		String testcaseName = "TurbineDataImport" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportALT, testcaseName);
		objProjectImportPage.invalidProjectDataImport(map, testcaseName);
		objTurbineDataImportPage.errorLogValidation(testcaseName);
		} else {
			log("Turbine Data Import is not applicable for this client", Status.SKIP);
		}
	}

	@Test(priority = 47, enabled = true)
	public void verifyEasementDataMapping_TC_47() throws Exception {
		if (environment.contains("STEELHEAD")) {
			log("TC 47 :Verify Easement Data Import Mapping");
			navigateToApplication(appURL);
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
			objLogin.login(map);
			String testcaseName = "EasementDataImport" + clientName;
			log("Data picked : " + testcaseName);
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportALT,
					testcaseName);
			objFacilitiesDataImportPage.verifyFacilitiesDataImportMapping(map, testcaseName);
		} else {
			log("Easement Data Import is not applicable for " + environment, Status.SKIP);
		}
	}

	@Test(priority = 48, enabled = true)
	public void ValidEasementDataImport_TC_48() throws Exception {
		if (environment.contains("STEELHEAD")) {
			log("TC 48 :Import Valid Easement Data");
			String testcaseName = "EasementDataImport" + clientName;
			log("Data picked : " + testcaseName);
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportALT,
					testcaseName);
			objProjectImportPage.loadDataToProject(map, testcaseName);
			objProjectImportPage.projectSelectionPermanentInfrastructure(map, testcaseName);
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ORSTED_PROJECTIMPORT_FILE),
					Excel.FacilitiesData, testcaseName);
			objFacilitiesDataImportPage.verifyImportedFacilitiesData(map, testcaseName);
		} else {
			log("Easement Data Import is not applicable for " + environment, Status.SKIP);
		}
	}

	@Test(priority = 49, enabled = true)
	public void InvalidEasementData_TC_49() throws Exception {
		if (environment.contains("STEELHEAD")) {
			log("TC49 :Verify Validation messages of Easement Data Import");
			navigateToApplication(appURL);
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
			objLogin.login(map);
			String testcaseName = "EasementDataImport" + clientName;
			log("Data picked : " + testcaseName);
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportALT,
					testcaseName);
			objProjectImportPage.invalidProjectDataImport(map, testcaseName);
			objFacilitiesDataImportPage.errorLogValidation(testcaseName);
		} else {
			log("Easement Data Import is not applicable for " + environment, Status.SKIP);
		}
	}
	

}
