package Com.PagesTest;

import org.testng.annotations.Test;
import Com.Jorani.Utils.Jorani_Contant_Utils;

public class Jorani_pages_Screenshot_test extends BaseSetup {
	@Test(priority=1)
	public void Loginpage_ScreenshotTest() {
		JPS.Loginpage_Screenshot(Jorani_Contant_Utils.JORANI_LOGIN_URL);
	}
	@Test(priority=2)
	public void Homepage_ScreenshotTest() {
		JPS.Homepage_Screenshot();
	}
	@Test(priority=3)
	public void Header_Page_ScreenshotTest() {
		JPS.Header_Page_Screenshot();
	}
	@Test(priority=4)
	public void Admin_page_screenshotTest() {
		JPS.Admin_page_screenshot();
	}
	@Test(priority=5)
	public void HR_Page_ScreenshotTest() {
		JPS.HR_Page_Screenshot();
	}
	@Test(priority=6)
	public void Approval_Page_ScreenshotTest() {
		JPS.Approval_Page_Screenshot();
	}
	@Test(priority=7)
	public void Request_Page_ScreenshotTest() {
		JPS.Request_Page_Screenshot();
	}
	@Test(priority=8)
	public void Calendars_Page_ScreenshotTest() {
		JPS.Calendars_Page_Screenshot();
	}
	@Test(priority=9)
	public void Username_ScreenshotTest() {
		JPS.Username_Screenshot();
	}
	@Test(priority=10)
	public void Footer_area_ScreenshotTest() {
		JPS.Footer_area_Screenshot();
	}

}
