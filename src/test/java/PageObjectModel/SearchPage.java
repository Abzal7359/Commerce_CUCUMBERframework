package PageObjectModel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilis.WaitHelper;

public class SearchPage {
	public WebDriver driver;
	WaitHelper WH;
	
	public SearchPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		WH=new WaitHelper(driver);

	}
	
	@FindBy(xpath = "//input[@id='SearchEmail']")
	private WebElement email;
	
	@FindBy(xpath = "(//input[@id='SearchFirstName'])[1]")
	private WebElement Firstname;
	
	@FindBy(xpath = "(//input[@id='SearchLastName'])[1]")
	private WebElement lastname;
	
	@FindBy(xpath = "//button[@id='search-customers']")
	private WebElement search;
	
	@FindBy(xpath = "//table[@id='customers-grid']")
	private WebElement table;
	
	@FindBy(xpath = "//table[@id='customers-grid']/tbody/tr")
	List<WebElement> tr;
	
//	@FindBy(xpath = "//table[@id='customers-grid']//tbody/tr/td")
//	List<WebElement> tc;
	
	public void Search_By_mail(String maill) {
		WH.WaitForElement(email, 20);
		email.clear();
		email.sendKeys(maill);
	}
	public void Search_By_Fisrtname(String F) {
		Firstname.clear();
		Firstname.sendKeys(F);
	}
	public void Search_By_LastName(String L) {
		lastname.clear();
		lastname.sendKeys(L);
	}
	public void click_serach() {
		search.click();
	}
	
	public boolean  serach_by_mail_table(String m) {
		boolean flag=false;

		for (int i=1;i<=tr.size();i++) {

			String emailid=table.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr["+i+"]/td[2]")).getText();
			if(emailid.equalsIgnoreCase(m)) {
				flag=true;
				break;
			}
		}
		
		return flag;
		
	}
	public boolean search_by_name_intable(String n) {
		boolean flag=false;
		String[] Anames=n.split(" ");
		for (int i=1;i<=tr.size();i++) {

			String name=table.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr["+i+"]/td[3]")).getText();
			String[] Enames=name.split(" ");
			if(Anames[0].equals(Enames[0])&& Anames[1].equals(Enames[1]) ) {
				flag=true;
				break;
			}
		}
		
		return flag;
		
	}

}
