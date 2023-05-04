package Com.Jorani.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Com.Jorani.Utils.Jorani_Element_Utils;

public class JoraniAdminPage {
	private WebDriver driver;
	private Jorani_Element_Utils eu;
	
	public JoraniAdminPage (WebDriver driver) {
		this.driver=driver;
		eu=new Jorani_Element_Utils(driver);
	}
	
	private By page_header=By.tagName("h2");
	private By show_sele=By.name("users_length");
	private By overall_entry=By.id("users_info");
	private By table_header=By.xpath("//table//tr/th");
	private By search=By.xpath("//input[@type=\"search\"]");
	private By first_name=By.xpath("(//table//tr)[2]/td[2]");
	private By lol=By.xpath("//ul[@class='dropdown-menu']//a[text()='List of types']");
	private By admin=By.xpath("//ul/li[@class=\"dropdown\"][1]");
	private By lol_header=By.tagName("h2");
	private By lol_table_header=By.xpath("//table//tr/th");
	private By new_leave=By.xpath("//a[@href=\"http://demo.jorani.org/leavetypes/create\"]");
	private By leave_name=By.xpath("//div[@id='frmAddLeaveType']//input[2]");
	private By save_click=By.xpath("//div[@id='frmAddLeaveType']//button");
	private By diagons=By.xpath("//ul[@class=\"dropdown-menu\"]//a[text()='Diagnostic']");
	private By dia_header=By.xpath("//div[@class=\"span12\"]/h2");
	private By dia_links=By.xpath("//ul[@class=\"nav nav-tabs\"]/li");
	private By diag_text=By.xpath("//ul[@class=\"nav nav-tabs\"]/li/a");
	
//1.list of users
	
	public String currenturl() {
		return eu.getcurrentURL();
	}
	
	public String header() {
		return eu.GetelementText(page_header);
	}
	public String showfilter(String value) {
		 eu.selectoption(show_sele, value);
		 eu.doclick(show_sele);
		return eu.GetelementText(overall_entry);
	}
	public int tableheadercount() {
		return eu.getcountOfElements(table_header);
	}
	
	public String tableheadertext(int value) {
		return eu.GetlistelementsText(table_header, value);
	}
	public String searchbox(String value) {
		eu.dosendkeys(search, value);
		return eu.GetelementText(first_name);	
	}

//2.List of leave
	private By exists=By.xpath("//div[@class=\"bootbox modal fade in\"]//a");
	
	public String ListofLeave() {
		eu.doclick(admin);
		eu.doclick(lol);
		return eu.GetelementText(lol_header);
	}
	public int loltableheadercount() {
		return eu.getcountOfElements(lol_table_header);
	}
	public boolean loltableheadertext(String value) {
		return eu.GetelementsTextcontains(lol_table_header, value);
	}
	public WebElement createleavetype(String value) {
		eu.doclick(new_leave);
		eu.WebDriver_Explicit_Wait(5, leave_name);
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		eu.dosendkeys(leave_name, value);
		return eu.doclick(save_click);
//		 try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		//return eu.doclick(exists);
	}
	
	
	
//3.diagonstic
	
	public String diagonsticURL() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		eu.doclick(admin);
		WebElement dia_navigate=driver.findElement(diagons);
		dia_navigate.click();
//		try {
//		//eu.doclick(diagons).click();
//			dia_navigate.click();
//		}catch(StaleElementReferenceException e)
//		{
//			 dia_navigate=driver.findElement(diagons);
//			dia_navigate.click();
//		}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return eu.getcurrentURL();	
	}
	
	public String Diagnos_header() {
		return eu.GetelementText(dia_header);
	}
	public int Diagons_links() {
		return eu.getcountOfElements(dia_links);
	}
	public String Diagons_text(int index) {
		return eu.GetlistelementsText(diag_text, index);
	}
	

}
