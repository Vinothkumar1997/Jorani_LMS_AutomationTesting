package Com.PagesTest;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class JoraniOvertimeRequestPage_Test extends BaseSetup {
	@BeforeClass
	public void navigateToOvertimeRequestPageTest() {
		JLP.SuccessfullLogin(prop.getProperty("Username"), prop.getProperty("password"));
		JHP.navigateToOvertimeRequestPage();
	}
	@Test(priority=1)
	public void currenturlTest() {
		String act=JOP.currenturl();
		Assert.assertEquals(act, "http://demo.jorani.org/extra");
	}
	@Test(priority=2)
	public void pageheaderTest() {
		String Act=JOP.pageheader();
		Assert.assertEquals(Act, "My overtime requests");
	}
	@Test(priority=3)
	public void tablecol_count() {
		int act_count=JOP.tablecol_count();
		Assert.assertEquals(act_count, 5);
	}
	@Test(priority=4)
	public void tab_textTest() {
		String Act_text=JOP.tab_text(3);
		Assert.assertEquals(Act_text, "Reason");
	}
	@Test(priority=5)
	public void tab_textTest1() {
		String Act_text=JOP.tab_text(4);
		boolean text=Act_text.equals("Reason");
		Assert.assertFalse(text);
		//Assert.assertEquals(Act_text, "Reason");
	}
	@Test(priority=6)
	public void exportpageTest() {
		JOP.exportpage();
	}

}
