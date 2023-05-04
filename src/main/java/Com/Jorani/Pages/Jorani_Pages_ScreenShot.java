package Com.Jorani.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import Com.Jorani.Utils.Jorani_Element_Utils;

public class Jorani_Pages_ScreenShot {
	private WebDriver driver;
	private Jorani_Element_Utils el;
	private JoraniLoginPage lp;
	
	public Jorani_Pages_ScreenShot(WebDriver driver) {
		this.driver=driver;
		el=new Jorani_Element_Utils(driver);
		lp=new JoraniLoginPage(driver);
	}
	
	public TakesScreenshot Loginpage_Screenshot(String url) {
		driver.get(url);
		return el.Fullpage_screenshot(".//Screenshot_Joranipages//Jorani_Loginpage.png");	
	}
	private By click_login=By.id("send");
	
	public TakesScreenshot Homepage_Screenshot() {
		el.doclick(click_login);
		return el.Fullpage_screenshot(".//Screenshot_Joranipages//Jorani_Homepage.png");		
	}
	
	private By header_links=By.xpath("//div[@class=\"navbar-inner\"]");
	
	public TakesScreenshot Header_Page_Screenshot() {
		return el.Specific_page_Screenshot(header_links, ".//Screenshot_Joranipages//Jorani_Header_page.png");
	}
	
	private By Click_admin=By.xpath("//a[text()='Admin ']");//a[text()='Admin ']//ul[@class=\"nav\"]/li
	private By admin=By.xpath("(//ul[@class=\"dropdown-menu\"])[1]");
	
	public TakesScreenshot Admin_page_screenshot() {
		el.doclick(Click_admin);
		return el.Specific_page_Screenshot(admin, ".//Screenshot_Joranipages//Jorani_Adminpage.png");	
	}
	
	private By Click_HR=By.xpath("//a[text()='HR ']");
	private By HR=By.xpath("(//ul[@class=\"dropdown-menu\"])[2]");
	
	public TakesScreenshot HR_Page_Screenshot() {
		el.doclick(Click_HR);
		return el.Specific_page_Screenshot(HR, ".//Screenshot_Joranipages//Jorani_HRpage.png");
	}
	
	private By Click_APP=By.xpath("//a[contains(text(),'Approval')]");
	private By Approval=By.xpath("(//ul[@class=\"dropdown-menu\"])[3]");
	
	public TakesScreenshot Approval_Page_Screenshot() {
		el.doclick(Click_APP);
		return el.Specific_page_Screenshot(Approval, ".//Screenshot_Joranipages//Jorani_Approvalpage.png");
	}
	
	private By Click_req=By.xpath("//a[text()='Requests ']");
	private By Request=By.xpath("(//ul[@class=\"dropdown-menu\"])[4]");
	
	public TakesScreenshot Request_Page_Screenshot() {
		el.doclick(Click_req);
		return el.Specific_page_Screenshot(Request, ".//Screenshot_Joranipages//Jorani_Requestpage.png");
	}
	
	private By Click_cal=By.xpath("//a[text()='Calendars ']");
	private By Calendars=By.xpath("(//ul[@class=\"dropdown-menu\"])[5]");
	
	public TakesScreenshot Calendars_Page_Screenshot() {
		el.doclick(Click_cal);
		return el.Specific_page_Screenshot(Calendars, ".//Screenshot_Joranipages//Jorani_Calendarspage.png");
	}
	
	private By Username=By.xpath("//a[text()='Benjamin BALET']");
	
	public TakesScreenshot Username_Screenshot() {
		return el.Specific_page_Screenshot(Username, ".//Screenshot_Joranipages//Jorani_Username.png");
	}
	
	private By footer_area=By.xpath("//div[@class=\"span4 pull-right\"]");
	
	public TakesScreenshot Footer_area_Screenshot() {
		return el.Specific_page_Screenshot(footer_area, ".//Screenshot_Joranipages//Jorani_Footer_page.png");
	}
	

}
