package Com.Jorani.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Com.Jorani.Utils.Jorani_Element_Utils;

public class JoraniCalendarsPage {
	private WebDriver driver;
	private Jorani_Element_Utils eu;
	public JoraniCalendarsPage(WebDriver driver) {
		this.driver=driver;
		eu=new Jorani_Element_Utils(driver);
	}
	
//1.My calemdars	
	private By page_header=By.tagName("h2");
	private By next_month=By.id("cmdNext");
	private By next_header=By.xpath("//div[@class=\"fc-center\"]/h2");
	
	public String currentURL() {
		return eu.getcurrentURL();
	}
	public String page_header() {
		return eu.GetelementText(page_header);
	}
	public String nextmonthText() {
		eu.doclick(next_month);
		eu.WebDriver_Explicit_Wait(5, next_header);
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		return eu.GetelementText(next_header);
		
		}
//2.My yearly calendar
	private By cal_link=By.xpath("(//ul[@class=\"nav\"]/li/a)[6]");
	private By yearly_cal=By.xpath("//a[@href=\"http://demo.jorani.org/calendar/year\"]");
	private By yr_header=By.tagName("h2");
	private By days_count=By.xpath("//table/thead//td/following-sibling::td");
	private By month_Count=By.xpath("//table//tr//td[1][@rowspan=\"2\"]");
	
	public String Myyearlycalender_url() {
		eu.doclick(cal_link);
		eu.doclick(yearly_cal);
		return eu.getcurrentURL();		
	}
	public String yr_header() {
		return eu.GetelementText(yr_header);
	}
	public int dayscount() {
		return eu.getcountOfElements(days_count);
	}
	public int Month_count() {
		return eu.getcountOfElements(month_Count);
	}

}
