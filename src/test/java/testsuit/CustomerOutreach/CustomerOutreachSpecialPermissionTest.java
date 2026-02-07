package testsuit.CustomerOutreach;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.ExcelUtils;

import page.Common.LoginPage;
import pages.SearchTickets.SerachCustomerOutreachTicketsPage;
import pages.TicketAssociation.AddNewTicketPage;
import pages.TicketAssociation.COSpecialPermissionPage;

@Listeners(com.listeners.MyListeners.class)

public class CustomerOutreachSpecialPermissionTest extends BasePage{

	LoginPage objLogin;
	COSpecialPermissionPage objCOSpecialPermission;
	AddNewTicketPage objAddNewTicket;
	public static String ROLE;
	Map<String, String> map = new HashMap<String, String>();

	@BeforeClass
	public void setup() throws Exception {
		driver = getDriver();
		objLogin = new LoginPage(driver);
		objCOSpecialPermission = new COSpecialPermissionPage(driver);
		objAddNewTicket = new AddNewTicketPage(driver);
	}
	
	
	@Test(priority=1)
	public void Add_New_Ticket_In_Closed_Status_TC_01() throws Exception {
		log("TC01 : Add new CO Ticket In Closed Status ");
		if (!environment.contains("ORION") & !environment.contains("CONNECTGEN")){
			navigateToApplication(appURL);
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
			objLogin.login(map);
			String testcaseName = "AddNewTicket" + clientName;
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.CUSTOMER_OUTREACH_TEST_DATA), Excel.ReopenClosedTicket,
					testcaseName);
			ROLE=map.get(Excel.Roles);
			objAddNewTicket.AddNewTicket(map, testcaseName);
			}else {
				log("Customer Outreach is not applicable for this client", Status.SKIP);
			}
	}
	
	@Test(priority=2)
	public void Reopen_Closed_Ticket_Special_Permission_TC_02() throws Exception {
		log("TC02 : Verify 'Reopen closed Ticket' Special Permission ");
		if (!environment.contains("ORION") & !environment.contains("CONNECTGEN")){
			String testcaseName = "ReopenClosedTicket" + clientName;
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
			objCOSpecialPermission.VerifyReopenClosedTicketSpecialPermission(map, testcaseName, ROLE);
			}else {
				log("Customer Outreach is not applicable for this client", Status.SKIP);
			}
	}
}
