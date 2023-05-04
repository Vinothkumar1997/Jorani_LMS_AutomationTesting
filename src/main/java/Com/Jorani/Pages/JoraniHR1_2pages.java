package Com.Jorani.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Com.Jorani.Utils.Jorani_Element_Utils;


public class JoraniHR1_2pages {
	private WebDriver driver;
	private Jorani_Element_Utils eu;
	public JoraniHR1_2pages(WebDriver driver) {
		this.driver=driver;	
		eu=new Jorani_Element_Utils(driver);
	}
	private By page_header=By.tagName("h2");
	private By select_entity=By.id("cmdSelectEntity");
	private By Eir_thss=By.xpath("//div[@id=\"organization\"]//a[text()='EIR_THESS']");
	private By click_ok=By.xpath("//a[@onclick=\"select_entity();\"]");
	private By page_length=By.xpath("//span[text()='Page length']");
	private By show_all=By.xpath(" (//div/a[@tabindex=\"0\"]/span)[6]");
	private By total_EIR=By.xpath("//table/tbody/tr");
	private By select_date=By.id("viz_datehired1");//(//div[@class="btn-group"]//input)[1]
	private By select_mon=By.xpath("//select[@data-handler=\"selectMonth\"]");
	private By select_year=By.xpath("//select[@data-handler=\"selectYear\"]");
	private By date_hired=By.xpath("//table[@class=\"ui-datepicker-calendar\"]//tr[3]/td[1]");
	private By button_id=By.id("cmdResetDate1");//By.xpath("//div[@class=\"btn-group\"]/button[@id='cmdResetDate1']");
	private By filterby_dt=By.xpath("//table/tbody[@class=\"context\"]/tr");
	private By extend=By.xpath("(//div[@id=\"frmSelectEntity\"]//i)[1]");
	private By finacement=By.xpath("//div[@id=\"frmSelectEntity\"]//a[@id=\"184_anchor\"]");
	private By clear_date=By.xpath("//div[@class=\"btn-group\"]/button[@id='cmdResetDate1']");
	private By no_of_emp=By.xpath("//table/tbody[@class=\"context\"]/tr");
	private By ok=By.xpath("//div[@class=\"modal-footer\"]/a[@onclick=\"select_entity();\"]");
	private By select_entity1=By.xpath("//div[@class=\"input-append\"]/a");
	private By hr=By.xpath("//ul[@class=\"nav\"]/li[3]");
	private By org=By.xpath("//a[@href=\"http://demo.jorani.org/organization\"]");
	private By header_org=By.tagName("h2");
	private By extendd=By.xpath("//div//ul//i[@class=\"jstree-icon jstree-ocl\"]");
	private By consulting=By.xpath("(//div[@class=\"span4\"]//li/a)[3]");//By.xpath("//ul[@role=\"group\"]//li[@id='203']");
	private By table_text=By.xpath("//table/tbody//td");
	private By list_of_con=By.xpath("//a[@href=\"http://demo.jorani.org/contracts\"]");
	private By LOC_header=By.tagName("h2");
	private By LOC_table_count=By.xpath("//table/thead//th");
	private By total_LOC=By.xpath("//table/tbody/tr");
	private By searchh=By.xpath("//input[@type=\"search\"]");
	private By gettext=By.xpath("//table/tbody//td[2]");
	private By hr_link=By.xpath("(//ul[@class=\"nav\"]/li/a)[3]");
	private By LOP=By.xpath("//a[@href=\"http://demo.jorani.org/positions\"]");
	private By LOP_header=By.tagName("h2");
	
//1.list of employees
	
	public String currenturl() {
		return eu.getcurrentURL();
	}
	public String pageheader() {
		return eu.GetelementText(page_header);
	}
	public int Employee_totalcount() {
		eu.doclick(select_entity);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		eu.doclick(Eir_thss);
		 eu.doclick(click_ok);
		 try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		 eu.doclick(page_length);
		 eu.doclick(show_all);
		return eu.getcountOfElements(total_EIR);	
	}
	public int filtetByDatehired(String month, String year) {
		eu.doclick(select_date);
		eu.selectoption(select_mon, month);//Apr
		eu.selectoption(select_year, year);//2023
		 eu.doclick(date_hired);
		  eu.doclick(button_id);
		 return eu.getcountOfElements(filterby_dt);
	}
	public WebElement clearthedate() {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return eu.doclick(clear_date);
	}
	public int financement_count() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		eu.doclick(select_entity1);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		eu.doclick(extend);
		eu.doclick(finacement);
		 eu.doclick(ok);
		 try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		return eu.getcountOfElements(no_of_emp);
	}
//2.organization
	public String organiztionurl() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		eu.doclick(hr);
		eu.doclick(org);
		return eu.getcurrentURL();	
	}
	public String org_header() {
		return eu.GetelementText(header_org);
	}
	public String consultingorga() {
//		try {
//			Thread.sleep(4000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		//eu.doclick(extendd);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//eu.doclick(extendd);
		eu.doclick(consulting);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return eu.GetelementText(table_text);
	}

}
