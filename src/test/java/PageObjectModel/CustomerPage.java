package PageObjectModel;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomerPage {
	
	public WebDriver driver;
	
	@FindBy(xpath = "/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/a")
	private WebElement Customers;
	
	@FindBy(xpath = "/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/ul/li[1]/a/p")
	private WebElement innerCustomer;
	
	@FindBy(xpath = "/html/body/div[3]/div[1]/form[1]/div/div/a")
	private WebElement Addnew;
	
	@FindBy(id="Email")
	private WebElement Email;
	
	@FindBy(id="Password")
	private WebElement password;
	
	@FindBy(id="FirstName")
	private WebElement firstname;
	
	@FindBy(id="LastName")
	private WebElement lastname;
	
	@FindBy(id="Gender_Male")
	private WebElement gender;
	
	@FindBy(id="DateOfBirth")
	private WebElement DOB;
	
	@FindBy(xpath = "//*[@id=\"SelectedCustomerRoleIds_taglist\"]/li/span[2]")
	private WebElement cancell;
	
	@FindBy(xpath = "//div[@class='input-group-append input-group-required']//div[@role='listbox']")
	private WebElement CustomerRoles;
	
	@FindBy(id="VendorId")
	private WebElement vendor;
	
	@FindBy(xpath = "//button[@name='save']")
	private WebElement save;
	
	
	
	public CustomerPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void click_Customers() {
		Customers.click();
	}
	public void click_innerCustomer() {
		innerCustomer.click();
	}
	
	public void click_Addnew() {
		Addnew.click();
	}
	public void Enter_Email(String mail) {
		Email.sendKeys(mail);
	}
	public void Enter_password(String psd) {
		password.sendKeys(psd);
	}
	public void Enter_firstname(String first) {
		firstname.sendKeys(first);
	}
	public void Enter_lastname(String last) {
		lastname.sendKeys(last);
	}
	public void select_gender_Male() {
		gender.click();
	}
	public void Enter_DOB(String db) {
		DOB.sendKeys(db);
	}
	public void cancel() {
		cancell.click();
	}
	public void Enter_CustomerRoles() {
		CustomerRoles.click();
//		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='input-group-append input-group-required']//div[@role='listbox']")));
//		Select op1=new Select(CustomerRoles);
//		op1.selectByValue("4");
	}
	
	public void Enter_vendor() throws InterruptedException {
		vendor.click();
		Select op=new Select(vendor);
		
		op.selectByVisibleText("Vendor 2");
		
	}
	public void Click_save() {
		save.click();
	}

}
