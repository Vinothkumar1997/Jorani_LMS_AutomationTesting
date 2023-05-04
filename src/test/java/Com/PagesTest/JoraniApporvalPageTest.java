package Com.PagesTest;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Com.Jorani.Utils.Jorani_Contant_Utils;

public class JoraniApporvalPageTest extends BaseSetup {
	@BeforeClass
	public void navigateToApprovalPage() {
		JLP.SuccessfullLogin(prop.getProperty("Username"), prop.getProperty("password"));
		JHP.navigateToApprovalPage();
	}
//1.delegations
	@Test(priority=1)
	public void cureenturlTest() {
		String Act_url=JAPP.cureenturl();
		Assert.assertEquals(Act_url, Jorani_Contant_Utils.JORANI_DELEGATIONS_URL);
	}
	@Test(priority=2)
	public void headertextTest() {
		String Act_text=JAPP.headertext();
		boolean act=Act_text.contains(Jorani_Contant_Utils.JORANI_DELEGATIONS_HEADER_TEXT);
		Assert.assertTrue(act);
	}
	@Test(priority=3)
	public void tabletextTest() {
		String Act_text=JAPP.tabletext();
		Assert.assertEquals(Act_text, "No data available in table");
	}
//2.My subordinates
	@Test(priority=4)
	public void My_subordinates() {
		String ACt_url=JAPP.My_subordinates();
		Assert.assertEquals(ACt_url, Jorani_Contant_Utils.JORANI_COLLABORATORS_URL);
	}
	@Test(priority=5)
	public void tablerowtextTest() {
		boolean Act_text=JAPP.tablerowtext("Benjamin");
		Assert.assertTrue(Act_text);
		//Assert.assertEquals(Act_text, "Benjamin");
	}
//3.leaves
	@Test(priority=6)
	public void leavesTest() {
		String Act_url=JAPP.leaves();
		Assert.assertEquals(Act_url, Jorani_Contant_Utils.JORANI_LEAVE_REQUEST_URL);
	}
	@Test(priority=7)
	public void Leave_header() {
		String Act_header=JAPP.Leave_header();
		Assert.assertEquals(Act_header, "Leave Requests submitted to me ");
	}
	@Test(priority=8)
	public void rejectleaveTest() {
		String Act=JAPP.rejectleave("annual leave");
		boolean text=Act.equals("Benjamin BALET");
		Assert.assertFalse(text);
		//Assert.assertEquals(Act, "Benjamin BALET");// http://demo.jorani.org/overtime
	}
//Overtime
	@Test(priority=9)
	public void Overtime() {
		String Act_url=JAPP.Overtime();
		Assert.assertEquals(Act_url, "http://demo.jorani.org/overtime");
	}
	@Test(priority=10)
	public void over_headerTest() {
		String Act_header=JAPP.over_header();
		Assert.assertEquals(Act_header, "Overtime Requests submitted to me");
	}
	@Test(priority=11)
	public void overtime_table_table_rowcountTest() {
		 int Act_count=JAPP.overtime_table_table_rowcount();
		Assert.assertEquals(Act_count, Jorani_Contant_Utils.JORANI_OVERTIME_TABLE_ROWCOUNT);
	}

}
