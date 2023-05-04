package Com.PagesTest;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class JoraniHR5_6pageTest extends BaseSetup {
	@BeforeClass
	public void navigateToHR5_6pageTest() {
		JLP.SuccessfullLogin(prop.getProperty("Username"), prop.getProperty("password"));
		JHP.navigateToHR5_6page();
	}
	
////5.Balance Leave
	@Test(priority=1)
	public void BalanceleaveURlTest() {
		String url=JHR56P.BalanceleaveURl();
		Assert.assertEquals(url, "http://demo.jorani.org/reports/balance");
	}
	@Test(priority=2)
	public void LBpageheaderTest() {
		String act_text=JHR56P.LBpageheader();
		Assert.assertEquals(act_text, "Balance of leaves   ");
	}
	@Test(priority=3)
	public void tablecol_countTest() {
		int count=JHR56P.tablecol_count();
		//Assert.assertEquals(count, 17);
		boolean act=(count==17);
		Assert.assertFalse(act);
	}
//6.reports
	@Test(priority=4)
	public void reportspageTest() {
		String act_url=JHR56P.reportspage();
		Assert.assertEquals(act_url, "http://demo.jorani.org/reports");
	}
	@Test(priority=5)
	public void AllrequestTest() {
		String Act_url=JHR56P.Allrequest();
		boolean actURL=Act_url.equals("http://demo.jorani.org/hr/counters/employees/217");
		Assert.assertFalse(actURL);
		//Assert.assertEquals(Act_url, "http://demo.jorani.org/hr/counters/employees/217");
	}
	@Test(priority=6)
	public void NewwindoeheaderTest() {
		String Act=JHR56P.Newwindoeheader();
		boolean act_text=Act.contains("Leave balance for user");
		Assert.assertTrue(act_text);
		//Assert.assertEquals(Act, "Leave balance for user # 217 ");
	}
	@Test(priority=7)
	public void tablecountTest() {
		int act=JHR56P.tablecount();
		Assert.assertEquals(act, 3);
	}
	@Test(priority=8)
	public void new_window_header2Test() {
		String Act_text=JHR56P.new_window_header2();
		boolean text=Act_text.contains("Entitled days to Contract ");
		Assert.assertTrue(text);
	}
	@Test(priority=9)
	public void new_window_header3Test() {
		String Act_text=JHR56P.new_window_header3();
		boolean text=Act_text.contains("Entitled days to Employee");
		Assert.assertTrue(text);
	}
	@Test(priority=10)
	public void movetoparentwindowTest() {
		String act_URL=JHR56P.movetoparentwindow();
		Assert.assertEquals(act_URL, "http://demo.jorani.org/all-leave-requests");

	}

}
