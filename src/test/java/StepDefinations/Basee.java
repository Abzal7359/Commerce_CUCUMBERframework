package StepDefinations;

import java.util.Date;

import org.openqa.selenium.WebDriver;

import PageObjectModel.CustomerPage;
import PageObjectModel.LoginPage;
import PageObjectModel.SearchPage;

public class Basee {
	
	public WebDriver driver;
	public LoginPage LP;
	public CustomerPage AddCust;
	public SearchPage searchp;
	static String EMAIL;
	
	
	public static String AutoEmail() {
		Date d=new Date();
		String mail=d.toString().replace(":", "_").replace(" ", "_")+"@gmail.com";
		EMAIL=mail;
		return(mail);
	}
	
	

}
