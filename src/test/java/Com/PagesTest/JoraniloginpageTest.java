package Com.PagesTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import Com.Jorani.Utils.Jorani_Contant_Utils;

public class JoraniloginpageTest extends BaseSetup {

	@Test(priority=-1)
	public void gettitleTest() {
		String Act_Title=JLP.gettitle();
		Assert.assertEquals(Act_Title, Jorani_Contant_Utils.JORANI_LOGIN_TITLE);
	}
	@Test(priority=1)
	public void pageheaderTest() {
		String header=JLP.pageheader();
		Assert.assertEquals(header, "Login ");
	}
	@Test(priority=2)
	public void applicationtitleTest() {
		String act_text=JLP.applicationtitle();
		Assert.assertEquals(act_text, Jorani_Contant_Utils.LOGIN_PAGE_TEXT);
	}
	@Test(priority=3)
	public void selectlanguagesTest() {
		JLP.selectlanguages();
	}
	
	@Test(priority=4)
	public void SuccessfullLoginTest() {
		JLP.SuccessfullLogin(prop.getProperty("Username"), prop.getProperty("password"));	
	}
	@Test(priority=5)
	public void getcurrenturlTest() {
		String url=JLP.getcurrenturl();
		Assert.assertEquals(url, Jorani_Contant_Utils.JORANI_HOME_PAGE_URL);
	}

}
