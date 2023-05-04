package Com.PagesTest;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Com.Jorani.Utils.Jorani_Contant_Utils;

public class JoraniAdminpageTest extends BaseSetup {

	@BeforeClass
	public void navigatetoAdminpage() {
		JLP.SuccessfullLogin(prop.getProperty("Username"), prop.getProperty("password"));
		JHP.navigatetoAdminpage();
	}
	@Test(priority=2)
	public void currenturl() {
		String Act=JAP.currenturl();
		Assert.assertEquals(Act, Jorani_Contant_Utils.JORANI_ADMIN_LOU_URL);
	}
	@Test(priority=2)
	public void headerTest() {
		String act=JAP.header();
		Assert.assertEquals(act, Jorani_Contant_Utils.JORANI_LOU_HEADER);
	}
	@Test(priority=3)
	public void showfilterTest() {
		String act=JAP.showfilter("50");
		boolean act_text=act.contains("entries");
		//Assert.assertEquals(act, "Showing 1 to 36 of 36 entries");
	}
	@Test(priority=4)
	public void tableheadercountTest() {
		int act_count=JAP.tableheadercount();
		boolean total_count=(act_count==Jorani_Contant_Utils.JORANI_LISTOFLEAVE_TABLE_COL_COUNT);
		Assert.assertTrue(total_count);
	}
	@Test(priority=5)
	public void tableheadertextTest() {
		String Act_text=JAP.tableheadertext(4);
		Assert.assertEquals(Act_text,"E-mail");
	}
	@Test(priority=6)
	public void searchboxTest() {
		String Act_text=JAP.searchbox("FOAD");
		Assert.assertEquals(Act_text,"moamed");
	}
	
//leave type page test
	@Test(priority=7)
	public void ListofLeaveTest() {
		String act_head=JAP.ListofLeave();
		Assert.assertEquals(act_head,"Leave types ");

	}
	@Test(priority=8)
	public void loltableheadercountTest() {
		int act_cou=JAP.loltableheadercount();
		Assert.assertEquals(act_cou, 4);
	}
	@Test(priority=9)
	public void loltableheadertextTest() {
		boolean Act=JAP.loltableheadertext("Deduct non working days");
		Assert.assertTrue(Act);
	}
	@Test(priority=10)
	public void createleavetypeTest() {//keep changing
		JAP.createleavetype(Jorani_Contant_Utils.JORANI_LIST_OF_LEAVE_NAME);
	}
//3.diagonstic
	@Test(priority=11)
	public void diagonsticTest() {
		String act_url=JAP.diagonsticURL();
		Assert.assertEquals(act_url,Jorani_Contant_Utils.JORANI_DIAGNOSTIC_URL);
	}
	@Test(priority=12)
	public void Diagnos_headerTest() {
		String Act_header=JAP.Diagnos_header();
		Assert.assertEquals(Act_header,Jorani_Contant_Utils.JORANI_DIAGNOSTIC_HEADER_TEXT);
	}
	@Test(priority=13)
	public void Diagons_linksTest() {
		int act_count=JAP.Diagons_links();
		Assert.assertEquals(act_count,Jorani_Contant_Utils.JORANI_DIAGNOSTIC_LINKS );
	}
	@Test(priority=14)
	public void Diagons_textTest() {//Entitled days
		String Act_text=JAP.Diagons_text(3);
		Assert.assertEquals(Act_text,"Entitled days");

	}

}
