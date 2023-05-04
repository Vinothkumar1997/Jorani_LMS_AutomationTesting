package Com.Jorani.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Com.Jorani.Utils.Jorani_Element_Utils;

public class LeaveRequestPage {
	private WebDriver driver;
	private Jorani_Element_Utils el;
	
	public LeaveRequestPage(WebDriver driver) {
		this.driver=driver;
		el=new Jorani_Element_Utils(driver);
	}
	
	private By pageheader=By.tagName("h2");
	private By typeBox=By.id("cboLeaveType");
	private By Planned_button=By.id("chkPlanned");
	private By Accept_button=By.id("chkAccepted");
	private By Requested_button=By.id("chkRequested");
	private By Rejected_button=By.id("chkRejected");
	private By cancelleation_button=By.id("chkCancellation");
	private By canceled_button=By.id("chkCanceled");
	private By Request_filter_table=By.xpath("//table/tbody/tr[1]/td[1]/a");
	private By Request_filter_search=By.xpath("//table/tbody/tr/td");//table//tbody/tr/td
	private By search=By.xpath("//input[@type='search']");
	private By link=By.xpath("(//a[@href='http://demo.jorani.org/leaves/create'])[3]");
	private By leave_type=By.xpath("//span[@role='presentation']");
	private By leave_text=By.xpath("//input[@type='search']");
	private By click_ok=By.xpath("//div[@class=\"bootbox modal fade in\"]/div/a");
	private By Startdate=By.id("viz_startdate");
	private By SDC=By.xpath("//table//tr[4]/td[5]");
	private By enddate=By.id("viz_enddate");
	private By EDC=By.xpath("//table//tr[5]/td[4]");
	private By session=By.id("enddatetype");
	private By sub_mit=By.xpath("//button[@value='2']");
	private By popup=By.xpath("//div[@tabindex='-1']//div[@class='modal-footer']/a");
	private By verify=By.xpath("//table//tr[1]/td[7]/span");
	private By Table_header=By.xpath("//table/thead/tr/th");
	private By exportfile=By.xpath("//a/i[@class='mdi mdi-download']");
	private By new_req=By.xpath("//a[text()='1030']");
	private By alert_msg=By.xpath("//div[@id='flashbox']/button");
	private By edit=By.xpath("//a[@href=\"http://demo.jorani.org/leaves/edit/1030\"]");
	private By status=By.cssSelector(".dropdown-requested");
	private By update=By.xpath("//button[@type=\"submit\"]");
	private By succ_msg=By.id("flashbox");
	private By next=By.id("leaves_next");
	private By previous=By.id("leaves_previous");
	private By total_leave=By.id("leaves_info");
	private By filter_links=By.xpath("//div[@class='span8']/span");
	private By no_match=By.xpath("//table//tr/td");
	private By ICS_link=By.id("lnkICS");
	private By ICS_text=By.xpath("//h3[text()='ICS']");
	
	public String pageheadertext() {
		return el.GetelementText(pageheader);
	}
	
	public String Typebox(String value) {//"overtime"
		 el.selectoption(typeBox, value);
		return el.GetelementText(no_match);
		
	}
	public int tablecolumnscount() {
		return el.getcountOfElements(Table_header);
	}
	public int filteroptions() {
		return el.getcountOfElements(filter_links);
	}
	public String filterleavetype(int value) {
		el.selectoption(typeBox, "");
		el.doclick(Planned_button);
		el.doclick(Requested_button);
		el.doclick(Rejected_button);
		el.doclick(cancelleation_button);
		el.doclick(canceled_button);	
		return el.GetlistelementsText(Request_filter_table, value);
	}
	public int searchbox(String sendkeys, String value) {
		el.doclick(Planned_button);
		el.doclick(Requested_button);
		el.doclick(Rejected_button);
		el.doclick(cancelleation_button);
		el.doclick(canceled_button);
		el.dosendkeys(search, sendkeys);
		return el.GetelementsTextIndexno(Request_filter_search, value);
		
	}
	public void searchboxclear() {
		 el.doclear(search);
		 el.keysEnter(search, "");
	}
	public WebElement newrequest(String value) {
		el.doclick(link);
		el.doclick(leave_type);
		el.keysEnter(leave_text, value);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		el.doclick(click_ok);
		el.doclick(Startdate);
		el.doclick(SDC);
		el.doclick(enddate);
		el.doclick(EDC);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
			
		el.doclick(popup);
		return el.doclick(sub_mit);	

		//driver.switchTo().alert().accept();
	}
	public String updatedsuccessfull() {
		return el.GetelementText(succ_msg);
	}
	
	public WebElement Approvalrequest(String value) {
		el.doclick(next);
		el.doclick(new_req);
		el.doclick(edit);
		el.selectoption(status, value);
		return el.doclick(update);
	}
	
	
	public WebElement exportfile() {
		 el.doclear(search);
		return el.doclick(exportfile);
	}
	
	public String nextpage() {
		 el.doclick(next);
		return el.GetelementText(total_leave);
	}
	
	public String previouspage() {
		
		  el.doclick(previous);	
		return el.GetelementText(total_leave);
	}	
	
	public String ICSlink(String value) {
		el.doclick(ICS_link);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// el.GetelementText(ICS_text);
		return el.textcontains(ICS_text, value);
		
	}

}
