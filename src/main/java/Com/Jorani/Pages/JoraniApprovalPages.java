package Com.Jorani.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import Com.Jorani.Utils.Jorani_Element_Utils;

public class JoraniApprovalPages {
	private WebDriver driver;
	private Jorani_Element_Utils eu;
	
	public JoraniApprovalPages(WebDriver driver) {
		this.driver=driver;
		eu=new Jorani_Element_Utils(driver);
	}
	
	private By header=By.tagName("h2");
	private By table_text=By.xpath("//table//tr[@class=\"odd\"]/td[@class=\"dataTables_empty\"]");
	private By app_link=By.xpath("(//a[@href=\"#\"])[3]");
	private By My_sub=By.xpath("//a[@href=\"http://demo.jorani.org/requests/collaborators\"]");
	private By sub_tab=By.xpath("//table//tr//td[2]");
	private By leave=By.xpath("//a[@href=\"http://demo.jorani.org/requests\"]");
	private By leave_header=By.tagName("h2");
	private By search=By.xpath("//input[@type=\"search\"]");
	private By reject=By.xpath("//table//tr/td/div/a[@class=\"lnkReject\"]");
	private By comment=By.xpath("//div[@class=\"bootbox modal fade in\"]//input");
	private By click_reject=By.xpath("//div[@class=\"bootbox modal fade in\"]//a[@data-handler=\"1\"]");
	private By text=By.xpath("//table//tr/td[1]");
	private By overtime_link=By.xpath("//a[@href=\"http://demo.jorani.org/overtime\"]");
	private By overtime_header=By.tagName("h2");
	
//1.delegations
	public String cureenturl() {
		return eu.getcurrentURL();
	}	
	public String headertext() {
		return eu.GetelementText(header);
	}	
	public String tabletext() {
		return eu.GetelementText(table_text);
	}
//2.My subordinates
	public String My_subordinates() {// http://demo.jorani.org/requests/collaborators
		eu.doclick(app_link);
		eu.doclick(My_sub);
		return eu.getcurrentURL();
	}
	public boolean tablerowtext(String text) {
		return eu.GetelementsTextcontains(sub_tab, text);
	}
//3.leaves
	public String leaves() {
		eu.doclick(app_link);
		eu.doclick(leave);
		return eu.getcurrentURL();
	}
	public String Leave_header() {
		return eu.GetelementText(leave_header);
	}
	public String rejectleave(String search_name) {
		eu.dosendkeys(search, search_name);
		return eu.GetelementText(text);		
	}
//4.Overtime
	public String Overtime() {
		eu.doclick(app_link);
		eu.doclick(overtime_link);
		return eu.getcurrentURL();		
	}
	public String over_header() {
		return eu.GetelementText(overtime_header);
	}
	private By overtime_table_row=By.xpath("//table//th");
	
	public int overtime_table_table_rowcount() {
		eu.WebDriver_Explicit_Wait(5, overtime_table_row);
		return eu.getcountOfElements(overtime_table_row);
	}

}
