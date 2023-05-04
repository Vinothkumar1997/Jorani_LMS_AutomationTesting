package Com.Jorani.Driverfactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Jorani_Driverfactory {
	WebDriver driver;
	Properties prop;
	FileInputStream fl;
	
	public WebDriver launchbrowser(Properties prop) {
		
		prop=initializeProperty();
		String browser=prop.getProperty("browsername");
		System.out.println("Browser name :"+browser);
		if(browser.equalsIgnoreCase("Chrome")) {
			driver=new ChromeDriver();
		}else if(browser.equalsIgnoreCase("Firefox")) {
			driver=new FirefoxDriver();
		}else {
			System.out.println("check your browser");
		}
		
		driver.get(prop.getProperty("url"));
		return driver;
	}
	public Properties initializeProperty() {
		prop=new Properties();
		try {
			fl= new FileInputStream(new File("./src/test/resources/Properties/config.properties"));
			prop.load(fl);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}

}
