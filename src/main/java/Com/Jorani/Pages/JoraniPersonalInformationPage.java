package Com.Jorani.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Com.Jorani.Utils.Jorani_Element_Utils;


public class JoraniPersonalInformationPage {
	private WebDriver driver;
	private Jorani_Element_Utils eu;
	public JoraniPersonalInformationPage(WebDriver driver) {
		this.driver=driver;
		eu=new Jorani_Element_Utils(driver);
	}
	private By header=By.tagName("h2");
	private By details=By.xpath("//div[@class=\"span6\"]/strong");
	
	public String Pi_url() {
		return eu.getcurrentURL();
	}
	public String headertext() {
		return eu.GetelementText(header);
	}
	public int informationcount() {
		return eu.getcountOfElements(details);
	}

}
