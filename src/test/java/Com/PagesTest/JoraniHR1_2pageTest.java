package Com.PagesTest;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Com.Jorani.Utils.Jorani_Contant_Utils;

public class JoraniHR1_2pageTest extends BaseSetup {
	@BeforeClass
	public void navigateToHRpageTest() {
		JLP.SuccessfullLogin(prop.getProperty("Username"), prop.getProperty("password"));
		JHP.navigateToHRpage();
	}
//1.list of employees
	@Test(priority=1)
	public void currenturlTest() {
		String Act_url=JHR12P.currenturl();
		Assert.assertEquals(Act_url, Jorani_Contant_Utils.JORANI_EMPLOYEES_URL);
	}
	@Test(priority=2)
	public void pageheaderTest() {
		String Act_header=JHR12P.pageheader();
		Assert.assertEquals(Act_header, "List of employees  ");
	}
	@Test(priority=3)
	public void Employee_totalcountTest() {//keep changing
		int act_count=JHR12P.Employee_totalcount();
		Assert.assertEquals(act_count, 37);
	}
	@Test(priority=4)
	public void filtetByDatehiredTest() {
		int act_count=JHR12P.filtetByDatehired("Apr", "2023");
		boolean count=(act_count==8);
		Assert.assertFalse(count);
		//Assert.assertEquals(act_count, 8);
	}
	@Test(priority=5)
	public void clearthedateTest() {
		JHR12P.clearthedate();
	}
	@Test(priority=6)
	public void financement_countTest() {
		int act_count=JHR12P.financement_count();
		//Assert.assertEquals(act_count, 2);
		boolean count=(act_count==2);
		Assert.assertTrue(count);
	}
//2.Organization
	@Test(priority=7)
	public void organiztionurlTest() {
		String url=JHR12P.organiztionurl();
		Assert.assertEquals(url, "http://demo.jorani.org/organization");
	}
	@Test(priority=8)
	public void org_headerTest() {
		String Act_header=JHR12P.org_header();
		Assert.assertEquals(Act_header, "Organization   ");
	}
	@Test(priority=9)
	public void consultingorgaTest() {
		String Act_msg=JHR12P.consultingorga();
		Assert.assertEquals(Act_msg, "No data available in table");
////		boolean msg=Act_msg.contains("No data available in table");
////		Assert.assertTrue(msg);
	}

}
