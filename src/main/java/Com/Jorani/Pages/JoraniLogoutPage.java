package Com.Jorani.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Com.Jorani.Utils.Jorani_Element_Utils;

public class JoraniLogoutPage {
	private WebDriver driver;
	private Jorani_Element_Utils eu;
	public JoraniLogoutPage(WebDriver driver) {
		this.driver=driver;
		eu=new Jorani_Element_Utils(driver);
	}
	private By logout=By.xpath("//a[@href=\"http://demo.jorani.org/session/logout\"]");
	
	public WebElement logout() {
		return eu.doclick(logout);
	}
	public String currenturl() {
		return eu.getcurrentURL();
	}
	public String gettitle() {
		return driver.getTitle();
	}

}
