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

@Listeners(com.listeners.MyListeners.class)

public class SerachCustomerOutreachTicketsTest extends BasePage{

	LoginPage objLogin;
	SerachCustomerOutreachTicketsPage objSerachTickets;
	Map<String, String> map = new HashMap<String, String>();

	@BeforeClass
	public void setup() throws Exception {
		driver = getDriver();
		objLogin = new LoginPage(driver);
		objSerachTickets = new SerachCustomerOutreachTicketsPage(driver);
	}
	
	
	@Test(priority=1)
	public void SerachTickets_TC_01() throws Exception {
		log("TC01 : Serach Customer Outreach Tickets");
		if (!environment.contains("ORION") & !environment.contains("CONNECTGEN")){
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		String testcaseName = "SerachTickets" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.CUSTOMER_OUTREACH_TEST_DATA), Excel.SerachTickets,testcaseName);
		objSerachTickets.SerachTickets(map, testcaseName);
		}else {
			log("Customer Outreach is not applicable for this client", Status.SKIP);
		}
	}
	
	
}
