package StepDefinations;

import static org.testng.Assert.*;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObjectModel.CustomerPage;
import PageObjectModel.LoginPage;
import PageObjectModel.SearchPage;
import io.cucumber.java.en.*;

public class Login extends Basee {
	
	
	@Given("user launch chrome browser")
	public void user_launch_chrome_browser() {
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		LP=new LoginPage(driver);
	   
	}

	@When("user opens url {string}")
	public void user_opens_url(String url) {
		driver.get(url);
	  
	}

	@When("user enters Email as {string} and password as {string}")
	public void user_enters_email_as_and_password_as(String string, String string2) {
	  LP.Enter_Email(string);
	  LP.Enter_password(string2);
	}

	@When("click login")
	public void click_login() {
		LP.Click_Login();
	   
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String string) {
	   if(!driver.getTitle().equalsIgnoreCase(string)) {
		   driver.close();
		   assertTrue(false);
	   }else {
		   assertTrue(true);
	   }
	}

	@When("user clicks logout button")
	public void user_clicks_logout_button() {
		LP.Click_Logout();
	}

	@Then("close browser")
	public void close_browser() {
	    driver.quit();
	}
	
	//Feature Customer step definations............................................
	
	@Then("user view dashboard")
	public void user_view_dashboard() {
		WebElement Dash= driver.findElement(By.xpath("//div[@class='content-header']//h1"));
		assertTrue(Dash.isDisplayed());
	}
	@When("user click on cutomer menu")
	public void user_click_on_cutomer_menu() {
		AddCust=new CustomerPage(driver);
		AddCust.click_Customers();
	    
	}
	@When("user clicks on customer menu item")
	public void user_clicks_on_customer_menu_item() {
	    AddCust.click_innerCustomer();
	}
	@When("click on add new button")
	public void click_on_add_new_button() {
	    AddCust.click_Addnew();
	}
	@Then("user can view Add new customer page")
	public void user_can_view_add_new_customer_page() {
		String t="Add a new customer / nopCommerce administration";
		assertEquals(driver.getTitle(), t);
	    
	}
	@When("user enter customer info")
	public void user_enter_customer_info() throws InterruptedException {
		
		AddCust.Enter_Email(AutoEmail());
		AddCust.Enter_password("Abzal@134");
		AddCust.Enter_firstname("Abzal");
		AddCust.Enter_lastname("Hussain");
		AddCust.select_gender_Male();
		AddCust.Enter_DOB("09/26/2001");
		AddCust.Enter_vendor();
	    
	}
	@When("click on save button")
	public void click_on_save_button() {
		AddCust.Click_save();
	    
	}
	@Then("user can view confirmation message")
	public void user_can_view_confirmation_message() {
		assertTrue(driver.findElement(By.xpath("//div[contains(@class,'alert-success')]")).isDisplayed());
	    
	}
	
	//search customer with mail id-------------------------------------------------------------
	@When("Enter customer mail")
	public void enter_customer_mail() {
		searchp=new SearchPage(driver);
		searchp.Search_By_mail(EMAIL);
	    
	}
	@When("click on search button")
	public void click_on_search_button() {
		
		searchp.click_serach();
	    
	}
	@Then("user should find email in the search table")
	public void user_should_find_email_in_the_search_table() {
		assertTrue(searchp.serach_by_mail_table(EMAIL)); 
	}
	//search customer in table with name-----------------------------------------------------------
	
	@When("Enter customer firstname")
	public void enter_customer_firstname() {
		searchp=new SearchPage(driver);
		String f="Abzal";
		searchp.Search_By_Fisrtname(f);
	    
	}
	@When("Enter cutomer lastname")
	public void enter_cutomer_lastname() {
		String l="Hussain";
		searchp.Search_By_LastName(l);
	    
	}
	@Then("user should find Name in the search table")
	public void user_should_find_name_in_the_search_table() {
		
	   assertTrue(searchp.search_by_name_intable("Abzal Hussain"));
	}

}
