package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver driver;
	
	
	@FindBy(id = "Email")
	private WebElement Email;
	
	@FindBy(id="Password")
	private WebElement password;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement Login;
	
	@FindBy(linkText = "Logout")
	private WebElement Logout;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void Enter_Email(String mail) {
		Email.clear();
		Email.sendKeys(mail);
	}
	
	public void Enter_password(String passwordd) {
		password.clear();
		password.sendKeys(passwordd);
	}
	
	public void Click_Login() {
		Login.click();
	}
	
	public void Click_Logout() {
		Logout.click();
	}

}
