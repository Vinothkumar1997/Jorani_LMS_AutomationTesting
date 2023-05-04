package Com.PagesTest;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Com.Jorani.Utils.Jorani_Contant_Utils;

public class JoraniHomepageTest extends BaseSetup {

	@BeforeClass
	public void navigatetoHomepageTest() {
		JLP.navigatetoHomepage(prop.getProperty("Username"), prop.getProperty("password"));
	}
	@Test(priority=-1)
	public void currenturlTest() {
		String Act_url=JHP.currenturl();
		Assert.assertEquals(Act_url, Jorani_Contant_Utils.JORANI_HOME_PAGE_URL);
	}
	@Test(priority=1)
	public void GetpagetitleTest() {
		String Act_title=JHP.Getpagetitle();
		Assert.assertEquals(Act_title, Jorani_Contant_Utils.JORANI_HOME_TITLE);
	}
	@Test(priority=2)
	public void headertextTest() {
		String Act_header_text=JHP.headertext();
		boolean text=Act_header_text.equals("Leave and Overtime Management System");
		Assert.assertTrue(text);
	}
	@Test(priority=3)
	public void linkscountTest() {
		int act_count=JHP.linkscount();
		Assert.assertEquals(act_count,Jorani_Contant_Utils.JORANI_HOMEPAGE_TOTALLINKS );
	}
	@Test(priority=4)
	public void linkstextTest() {
		String ACt_Text=JHP.linkstext(1);
		Assert.assertEquals(ACt_Text, "Admin");
	}
	@Test(priority=5)
	public void linkstextTest1() {
		String ACt_Text=JHP.linkstext(11);
		Assert.assertEquals(ACt_Text, "new leave");
	}
	@Test(priority=6)
	public void linkstextTest2() {
		String ACt_Text=JHP.linkstext(8);
		boolean text=ACt_Text.equals("Admin");
		Assert.assertFalse(text);
	}
	@Test(priority=7)
	public void linkIndexTest() {
		int Act_index=JHP.linkIndex("leave balance");
		Assert.assertEquals(Act_index, 9);
	}
	@Test(priority=8)
	public void linkIndexTest1() {
		int Act_index=JHP.linkIndex("Calendars");
		boolean index=(Act_index==5);
		Assert.assertTrue(index);
	}
	@Test(priority=9)
	public void linkIndexTest2() {
		int Act_index=JHP.linkIndex("overtime requests submitted to you");
		boolean index=(Act_index==13);
		Assert.assertTrue(index);
	}
	
	@Test(priority=10)
	public void linktextcontains() {
		boolean Act=JHP.linktextcontains();
		Assert.assertTrue(Act);
	}

}
