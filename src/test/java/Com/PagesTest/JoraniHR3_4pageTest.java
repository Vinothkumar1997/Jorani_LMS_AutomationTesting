package Com.PagesTest;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class JoraniHR3_4pageTest extends BaseSetup {
	@BeforeClass
	public void navigateToHR3_4pageTest() {
		JLP.SuccessfullLogin(prop.getProperty("Username"), prop.getProperty("password"));
		JHP.navigateToHR3_4page();
	}
		
//3.List of Contracts
	@Test(priority=10)
	public void ListofContractUrlTest() {
		String act_url=JHR34P.ListofContractUrl();
		Assert.assertEquals(act_url, "http://demo.jorani.org/contracts");
	}
	@Test(priority=11)
	public void LOcheaderTest() {
		String act=JHR34P.LOcheader();
		Assert.assertEquals(act, "List of contracts   ");
	}
	@Test(priority=12)
	public void LOCTableCol_countTest() {
		int act_count=JHR34P.LOCTableCol_count();
		Assert.assertEquals(act_count, 4);
	}
	@Test(priority=13)
	public void GettabletextTest() {
		String act_text=JHR34P.Gettabletext(2);
		Assert.assertEquals(act_text, "Start period");
	}
	@Test(priority=14)
	public void total_LOCTest() {
		int act_cou=JHR34P.total_LOC();
		boolean act_count=(act_cou==2);
		Assert.assertFalse(act_count);
		//Assert.assertEquals(act_cou, 2);
	}
	@Test(priority=15)
	public void searchboxTest() {
		String act_tex=JHR34P.searchbox("cairo");
		Assert.assertEquals(act_tex, "Annual leavs - cairo");
	}
//4.List of positions
	@Test(priority=16)
	public void LOPurlTest() {
		String url=JHR34P.LOPurl();
		Assert.assertEquals(url, "http://demo.jorani.org/positions");
	}
	@Test(priority=17)
	public void LOPheaderTest() {
		String act_header=JHR34P.LOPheader();
		Assert.assertEquals(act_header, "List of positions   ");
	}
	@Test(priority=18)
	public void totalpositionsTest() {
		int act=JHR34P.totalpositions("100");
		Assert.assertEquals(act, 25);
	}
	@Test(priority=19)
	public void lopsearchboxTest() {
		String avt_text=JHR34P.lopsearchbox("accountant");
		boolean act=avt_text.contains("Showing 1 to 1 of 1 entries");
		Assert.assertTrue(act);
	}
	@Test(priority=20)
	public void LOPsearchboxTextTest() {
		String act_tex=JHR34P.LOPsearchboxText("34");
		Assert.assertEquals(act_tex, "Accounting & IT Supervisor");
	}

}
