package Com.Jorani.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Com.Jorani.Utils.Jorani_Element_Utils;

public class JoraniLoginPage {
	
	private WebDriver driver;
	private Jorani_Element_Utils el;
	public JoraniLoginPage(WebDriver driver) {
		this.driver=driver;
		el=new Jorani_Element_Utils(driver);
	}
	private By loginpage_header=By.tagName("h2");
	private By languages=By.id("select2-language-container");
	private By login=By.id("login");
	private By pwd=By.id("password");
	private By button=By.id("send");
	private By text=By.xpath("//center[text()='Leave Management System']");
	private By select_lang=By.xpath("//input[@type='search']");
	private By invalid_msg=By.id("flashbox");
	public String gettitle() {
		return el.gettitle();
	}
	public String applicationtitle() {
		return el.GetelementText(text);
	}
	public String pageheader() {
		return el.GetelementText(loginpage_header);
	}
	public void selectlanguages() {
		el.doclick(languages);
		el.keysEnter(select_lang, "English (UK)");	
	}
	public WebElement SuccessfullLogin(String Uname, String Pwd) {
		el.doclear(login);
		el.doclear(pwd);
		el.dosendkeys(login, Uname);
		el.dosendkeys(pwd, Pwd);
		return el.doclick(button);
		
	}
	public String getcurrenturl() {
		return el.getcurrentURL();
	}
	public JoraniHomePage navigatetoHomepage(String Uname, String Pwd) {
		SuccessfullLogin(Uname,Pwd);
		return new JoraniHomePage(driver);
	}

}
