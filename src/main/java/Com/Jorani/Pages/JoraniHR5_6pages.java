package Com.Jorani.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Com.Jorani.Utils.Jorani_Element_Utils;

public class JoraniHR5_6pages {
	private WebDriver driver;
	private Jorani_Element_Utils eu;
	public JoraniHR5_6pages(WebDriver driver) {
		this.driver=driver;	
		eu=new Jorani_Element_Utils(driver);
	}
	
	//5.Balance Leave
		private By LB=By.xpath("//a[@href=\"http://demo.jorani.org/reports/balance\"]");
		private By LB_header=By.tagName("h2");
		private By launch=By.id("cmdLaunchReport");
		private By table_head=By.xpath("//table/thead//th");
		private By hr_link=By.xpath("(//ul[@class=\"nav\"]/li/a)[3]");
		
		public String BalanceleaveURl() {
			eu.doclick(hr_link);
			eu.doclick(LB);
			return eu.getcurrentURL();	
		}
		public String LBpageheader() {
			return eu.GetelementText(LB_header);
		}
		public int tablecol_count() {
			eu.doclick(launch);
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return eu.getcountOfElements(table_head);
		}
	//6.reports
		private By report_link=By.xpath("//a[@href=\"http://demo.jorani.org/reports\"]");
		private By All_request=By.xpath("//table/tbody//td/a[@href=\"http://demo.jorani.org/all-leave-requests\"]");
		//private By mohamed=By.xpath("//table/tbody/tr[1]/td/a[text()='mohamed MOUSTAFA']");
		private By new_window=By.xpath("(//table/tbody/tr[1]/td/a)[2]");
		private By new_header=By.tagName("h2");
		private By count_table=By.xpath("//table");
		private By new_header2=By.xpath("(//h3)[2]");
		private By new_header3=By.xpath("(//h3)[3]");
		
		public String reportspage() {
			eu.doclick(hr_link);
			eu.doclick(report_link);
			return eu.getcurrentURL();
		}
		public String Allrequest() {
			eu.doclick(All_request);
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			 eu.doclick(new_window);
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
//			Set<String> hand_window=driver.getWindowHandles();
//			ArrayList<String> windows=new ArrayList<String>();
//			for(String e:hand_window) {
//				windows.add(e);
//			}
//			driver.switchTo().window(windows.get(1));
			eu.Windows_handling(1);
			return eu.getcurrentURL();	
		}
		public String Newwindoeheader() {
			eu.Windows_handling(1);
			return eu.GetelementText(new_header);
		}
		public int tablecount() {
			eu.Windows_handling(1);
			return eu.getcountOfElements(count_table);
		}
		public String new_window_header2() {
			return eu.GetelementText(new_header2);
		}
		public String new_window_header3() {
			return eu.GetelementText(new_header3);
		}
		public String movetoparentwindow() {
			eu.Windows_handling(1);
			driver.close();
			eu.Windows_handling(0);
			return eu.getcurrentURL();
		}

}
