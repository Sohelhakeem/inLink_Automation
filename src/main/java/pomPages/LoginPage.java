package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	@FindBy(name="email")
	private WebElement emailtb;
	
	@FindBy(name="password")
	private WebElement passwordtb;
	
	@FindBy(xpath="//button[normalize-space()='Login']")
	private WebElement LoginBtn;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void email_TF(String emailid) {
		emailtb.click();
		emailtb.sendKeys(emailid);
	}
	
	public void password_TF (String password) {
		passwordtb.sendKeys(password);
	}
		public void LoginButton () {
			LoginBtn.click();
		}
	}
	

