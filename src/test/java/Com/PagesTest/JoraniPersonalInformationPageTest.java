package Com.PagesTest;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class JoraniPersonalInformationPageTest extends BaseSetup {
	@BeforeClass
	public void NavigateToPersonalInformationPage() {
		JLP.SuccessfullLogin(prop.getProperty("Username"), prop.getProperty("password"));
		JHP.NavigateToPersonalInformationPage();
	}
	@Test(priority=1)
	public void Pi_urlTest() {
		String Act=JPP.Pi_url();
		Assert.assertEquals(Act, "http://demo.jorani.org/users/myprofile");
	}
	@Test(priority=2)
	public void headertextTest() {
		String act_header=JPP.headertext();
		Assert.assertEquals(act_header, "My personal information");
	}
	@Test(priority=3)
	public void informationcountTest() {
		int act=JPP.informationcount();
		Assert.assertEquals(act, 9);
	}

}
