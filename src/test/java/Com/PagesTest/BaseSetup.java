package Com.PagesTest;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import Com.Jorani.Driverfactory.Jorani_Driverfactory;
import Com.Jorani.Pages.JoraniAdminPage;
import Com.Jorani.Pages.JoraniApprovalPages;
import Com.Jorani.Pages.JoraniCalendarsPage;
import Com.Jorani.Pages.JoraniHR1_2pages;
import Com.Jorani.Pages.JoraniHR3_4pages;
import Com.Jorani.Pages.JoraniHR5_6pages;
import Com.Jorani.Pages.JoraniHomePage;
import Com.Jorani.Pages.JoraniLoginPage;
import Com.Jorani.Pages.JoraniLogoutPage;
import Com.Jorani.Pages.JoraniOvertimeRequestPage;
import Com.Jorani.Pages.JoraniPersonalInformationPage;
import Com.Jorani.Pages.Jorani_Pages_ScreenShot;
import Com.Jorani.Pages.LeaveRequestPage;

public class BaseSetup {

	WebDriver driver;
	Jorani_Driverfactory df;
	JoraniLoginPage JLP;
	Properties prop;
	JoraniHomePage JHP;
	LeaveRequestPage LRP;
	JoraniAdminPage JAP;
	JoraniApprovalPages JAPP;
	JoraniHR1_2pages JHR12P;
	JoraniHR3_4pages JHR34P;
	JoraniHR5_6pages JHR56P;
	JoraniOvertimeRequestPage JOP;
	JoraniCalendarsPage JCP;
	JoraniPersonalInformationPage JPP;
	JoraniLogoutPage JLTP;
	Jorani_Pages_ScreenShot JPS;
	
	@BeforeTest
	public void setup() {
		df=new Jorani_Driverfactory();
		prop=new Properties();
		prop=df.initializeProperty();
		driver=df.launchbrowser(prop);
		JLP= new JoraniLoginPage(driver);
		JHP=new JoraniHomePage(driver);
		LRP=new LeaveRequestPage(driver);
		JAP=new JoraniAdminPage(driver);
		JAPP=new JoraniApprovalPages(driver);
		JHR12P=new JoraniHR1_2pages(driver);
		JHR34P=new JoraniHR3_4pages(driver);
		JHR56P=new JoraniHR5_6pages(driver);
		JOP=new JoraniOvertimeRequestPage(driver);
		JCP=new JoraniCalendarsPage(driver);
		JPP=new JoraniPersonalInformationPage(driver);
		JLTP=new JoraniLogoutPage(driver);
		JPS=new Jorani_Pages_ScreenShot(driver);
		
	}
	@AfterTest
	public void Toclosebrowser() {
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	driver.quit();
	}

}
