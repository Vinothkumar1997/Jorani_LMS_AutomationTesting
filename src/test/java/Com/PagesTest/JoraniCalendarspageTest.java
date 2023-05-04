package Com.PagesTest;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Com.Jorani.Utils.Jorani_Contant_Utils;


public class JoraniCalendarspageTest extends BaseSetup {
	@BeforeClass
	public void navigateTocalendarsPageTest() {
		JLP.SuccessfullLogin(prop.getProperty("Username"), prop.getProperty("password"));
		JHP.navigateTocalendarsPage();
	}
//1.calendars
	@Test(priority=1)
	public void currentURLTest() {
		String act=JCP.currentURL();
		Assert.assertEquals(act, Jorani_Contant_Utils.JORANI_MY_CALENDAR_URL);
	}
	@Test(priority=2)
	public void page_headerTest() {
		String Act_header=JCP.page_header();
		Assert.assertEquals(Act_header, "My calendar  ");
	}
	@Test(priority=3)
	public void nextmonthTextTest() {
		String Act_header=JCP.nextmonthText();
		Assert.assertEquals(Act_header, "May 2023");
	}
//2.My yearly calendar
	@Test(priority=4)
	public void Myyearlycalender_urlTest() {
		String act_url=JCP.Myyearlycalender_url();
		Assert.assertEquals(act_url, "http://demo.jorani.org/calendar/year");
	}
	@Test(priority=5)
	public void yr_headerTest() {
		String Act_head=JCP.yr_header();
		Assert.assertEquals(Act_head, "Yearly calendar (Benjamin BALET) ");
	}
	@Test(priority=6)
	public void dayscountTest() {
		int act_count=JCP.dayscount();
		boolean count=(act_count==Jorani_Contant_Utils.JORANI_CALENDAR_DAYS_COUNT);
		Assert.assertTrue(count);
	}	
	@Test(priority=7)
	public void Month_countTest() {
		int act=JCP.Month_count();
		Assert.assertEquals(act, Jorani_Contant_Utils.JORANI_CALENDAR_MONTHS_COUNT);
	}

}
