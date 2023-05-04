package Com.Jorani.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Com.Jorani.Utils.Jorani_Element_Utils;

public class JoraniHR3_4pages {
	private WebDriver driver;
	private Jorani_Element_Utils eu;
	public JoraniHR3_4pages(WebDriver driver) {
		this.driver=driver;	
		eu=new Jorani_Element_Utils(driver);
	}
	
	private By hr=By.xpath("//ul[@class=\"nav\"]/li[3]");
	private By list_of_con=By.xpath("//a[@href=\"http://demo.jorani.org/contracts\"]");
	private By LOC_header=By.tagName("h2");
	private By LOC_table_count=By.xpath("//table/thead//th");
	private By total_LOC=By.xpath("//table/tbody/tr");
	private By searchh=By.xpath("//input[@type=\"search\"]");
	private By gettext=By.xpath("//table/tbody//td[2]");
		
	//3.List of contract
		public String ListofContractUrl() {
			eu.doclick(hr);
			eu.doclick(list_of_con);
			return eu.getcurrentURL();		
		}
		public String LOcheader() {
			return eu.GetelementText(LOC_header);
		}
		public int LOCTableCol_count() {//4
			return eu.getcountOfElements(LOC_table_count);
		}
		public String Gettabletext(int index) {
			return eu.GetlistelementsText(LOC_table_count, index);
		}
		public int total_LOC() {
			return eu.getcountOfElements(total_LOC);
		}
		public String searchbox(String value) {
			eu.dosendkeys(searchh, value);
			return eu.GetelementText(gettext);
		
		}
	//4.List of positions
		private By select_opt=By.tagName("select");
		private By total_pot=By.xpath("//table//tbody/tr");
		private By select_input=By.xpath("//input[@type=\"search\"]");
		private By check_id=By.xpath("//table//tbody//td[1]");
		private By page_info=By.id("positions_info");
		private By textt=By.xpath("//table//tbody//td[2]");
		private By hr_link=By.xpath("(//ul[@class=\"nav\"]/li/a)[3]");
		private By LOP=By.xpath("//a[@href=\"http://demo.jorani.org/positions\"]");
		private By LOP_header=By.tagName("h2");
		
		public String LOPurl() {
			eu.doclick(hr_link);
			eu.doclick(LOP);
			return eu.getcurrentURL();
		}
		public String LOPheader() {
			return eu.GetelementText(LOP_header);
		}
		public int totalpositions(String value) {
			eu.selectoption(select_opt, value);
			eu.keysEnter(select_opt, "");
			return eu.getcountOfElements(total_pot);	
		}
		public String lopsearchbox(String value) {	
			eu.dosendkeys(select_input, value);
			return eu.GetelementText(page_info);
		}
		public String LOPsearchboxText(String value) {
			eu.doclear(select_input);
			eu.dosendkeys(select_input, value);
			return eu.GetelementText(textt);
		}

}
