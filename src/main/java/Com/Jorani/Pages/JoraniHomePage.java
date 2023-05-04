package Com.Jorani.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Com.Jorani.Utils.Jorani_Element_Utils;

public class JoraniHomePage {
	private WebDriver driver;
	private Jorani_Element_Utils el;
	
	public JoraniHomePage(WebDriver driver) {
		this.driver=driver;
		el=new Jorani_Element_Utils(driver);
	}
	private By total_links=By.xpath("//div//div/ul/li");
	private By Home_title_text=By.tagName("h1");
	private By links_text=By.xpath("//div//div/ul/li/a");
	private By leavereq=By.xpath("(//a[@href='http://demo.jorani.org/leaves'])[1]");
	private By Admin_page=By.xpath("(//a[@href=\"#\"])[1]");
	private By LOU=By.xpath("//ul[@class='dropdown-menu']//a[text()='List of users']");
	private By apporval_page=By.xpath("(//ul[@class=\"nav\"]/li/a)[4]");
	private By App_delegations=By.xpath("//li[@class=\"dropdown open\"]/ul/li[1]");
	private By HR_page=By.xpath("//ul/li[@class='dropdown']/a[text()='HR ']");
	private By Hr_loe=By.xpath("//a[@href=\"http://demo.jorani.org/hr/employees\"]");
	private By req_page=By.xpath("(//ul[@class=\"nav\"]/li/a)[5]");
	private By overtime=By.xpath("//a[@href=\"http://demo.jorani.org/extra\"]");
	private By Calendars=By.xpath("(//ul[@class=\"nav\"]/li/a)[6]");
	private By My_cal=By.xpath("//a[@href=\"http://demo.jorani.org/calendar/individual\"]");
	private By PI=By.xpath("(//a[@href=\"http://demo.jorani.org/users/myprofile\"])[2]");
	
	public String currenturl() {
		return el.getcurrentURL();
	}
	public String Getpagetitle() {
		 return el.gettitle();		
	}
	
	public String headertext() {
		return el.GetelementText(Home_title_text);
	}
	public int linkscount() {
		return el.getcountOfElements(total_links);
	}
	public String linkstext(int index) {
		return el.GetlistelementsText(links_text, index);
	
	}
	public int linkIndex(String value) {//"leave balance"
		return el.GetelementsTextIndexno(links_text,value );
	}
	public boolean linktextcontains() {
		return el.GetelementsTextcontains(links_text, "leave requests submitted to you");
	}
	
//navugation
	
	public LeaveRequestPage navigateToLeaveRequestpage() {
		el.doclick(leavereq);
		return new LeaveRequestPage(driver);
	}
	
	public JoraniAdminPage navigatetoAdminpage() {
		el.doclick(Admin_page);
		el.doclick(LOU);
		return new JoraniAdminPage(driver);
		
	}
	public JoraniApprovalPages navigateToApprovalPage() {
		el.doclick(apporval_page);
		el.doclick(App_delegations);
		return new JoraniApprovalPages(driver);
	}
	public JoraniHR1_2pages navigateToHRpage() {
		el.doclick(HR_page);
		el.doclick(Hr_loe);
		return new JoraniHR1_2pages(driver);		
	}
	public JoraniHR3_4pages navigateToHR3_4page() {
		el.doclick(HR_page);
		el.doclick(Hr_loe);
		return new JoraniHR3_4pages(driver);		
	}
	public JoraniHR5_6pages navigateToHR5_6page() {
		el.doclick(HR_page);
		el.doclick(Hr_loe);
		return new JoraniHR5_6pages(driver);		
	}
	public JoraniOvertimeRequestPage navigateToOvertimeRequestPage() {
		el.doclick(req_page);
		el.doclick(overtime);
		return new JoraniOvertimeRequestPage(driver);
	}
	
	public JoraniCalendarsPage navigateTocalendarsPage() {
		el.doclick(Calendars);
		el.doclick(My_cal);
		return new JoraniCalendarsPage(driver);		
	}
	public JoraniPersonalInformationPage NavigateToPersonalInformationPage() {
		el.doclick(PI);
		return new JoraniPersonalInformationPage(driver);
	}

}
