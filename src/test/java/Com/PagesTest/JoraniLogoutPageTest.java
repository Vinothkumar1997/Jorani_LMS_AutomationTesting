package Com.PagesTest;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Com.Jorani.Utils.Jorani_Contant_Utils;

public class JoraniLogoutPageTest extends BaseSetup {
	@BeforeClass
	public void navigatetohomepage() {
		JLP.SuccessfullLogin(prop.getProperty("Username"), prop.getProperty("password"));
	}
	@Test(priority=1)
	public void logoutTest() {
		JLTP.logout();
	}
	@Test(priority=2)
	public void currenturlTest() {
		String act_url=JLTP.currenturl();
		Assert.assertEquals(act_url, prop.getProperty("url"));
	}
	@Test(priority=3)
	public void gettitleTest() {
		String Act_title=JLTP.gettitle();
		Assert.assertEquals(Act_title, Jorani_Contant_Utils.JORANI_LOGIN_TITLE);
	}

}
