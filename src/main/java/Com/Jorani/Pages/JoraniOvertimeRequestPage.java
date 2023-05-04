package Com.Jorani.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Com.Jorani.Utils.Jorani_Element_Utils;

public class JoraniOvertimeRequestPage {
	private WebDriver driver;
	private Jorani_Element_Utils eu;
	public JoraniOvertimeRequestPage(WebDriver driver) {
		this.driver=driver;
		eu=new Jorani_Element_Utils(driver);
	}
	
	private By header=By.tagName("h2");
	private By tab_count=By.xpath("//table//thead//th");
	private By export=By.xpath("//a[@href=\"http://demo.jorani.org/extra/export\"]");
	
	public String currenturl() {
		return eu.getcurrentURL();
	}
	public String pageheader() {
		return eu.GetelementText(header);
	}
	public int tablecol_count() {
		return eu.getcountOfElements(tab_count);
	}
	public String tab_text(int index) {
		return eu.GetlistelementsText(tab_count, index);
	}
	public WebElement exportpage() {
		return eu.doclick(export);
	}

}
