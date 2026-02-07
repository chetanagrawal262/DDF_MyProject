package testsuit.TicketAssociation;

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
import pages.TicketAssociation.AddNewTicketPage;

@Listeners(com.listeners.MyListeners.class)
public class AddNewTicketTest extends BasePage{

	
		LoginPage objLogin;
		ReadPropertyFile readPro = new ReadPropertyFile();
		AddNewTicketPage objAddNewTicket;
		Map<String, String> map = new HashMap<String, String>();

		@BeforeClass
		public void setup() throws Exception {
			driver = getDriver();
			objLogin = new LoginPage(driver);
			objAddNewTicket = new AddNewTicketPage(driver);
		}

		@Test
		public void AddNewTicket_TC_01() throws Exception {
			if(!environment.contains("CRIMSON") & !environment.contains("MVEA") & !environment.contains("GRAYHAWKTCE") & !environment.contains("GRIDUNITED") & !environment.contains("TRA") & !environment.contains("VALARD")) {
			log("TC01 : Add a New Ticket ");
			navigateToApplication(appURL);
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
			objLogin.login(map);
			String testcaseName = "AddNewTicket" + clientName;
			log("Data picked : " + testcaseName);
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_DETAILS_TEST_DATA), Excel.TicketAssociation,
					testcaseName);
			objAddNewTicket.AddNewTicket(map, testcaseName);		   
			}else {
				log("Project Association is not applicable for this client", Status.SKIP);
			}
		}
		
		@Test
		public void Ticket_Association_TC_02() throws Exception {
			if(!environment.contains("CRIMSON") & !environment.contains("MVEA") & !environment.contains("GRAYHAWKTCE") & !environment.contains("GRIDUNITED") & !environment.contains("TRA") & !environment.contains("VALARD")) {
			log("TC02 : Ticket Associations");
			String testcaseName = "TicketAssociation" + clientName;
			log("Data picked : " + testcaseName);
			objAddNewTicket.TicketAssociation(testcaseName);   
		}else {
			log("Project Association is not applicable for this client", Status.SKIP);
		}
		}
}
