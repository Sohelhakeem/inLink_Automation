package oldPomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SkillraryLoginPage {
	@FindBy(xpath="//a[text()=' GEARS ']")
	private WebElement gerasbtn;
	
	@FindBy(xpath="(//a[text()=' SkillRary Demo APP'])[2]")
    private WebElement skillraydemoapp;
	
	@FindBy(name="q")
	private WebElement serachtb;
	
	@FindBy(xpath="//input[@value='go']")
	private WebElement serachbtn;
	
	public SkillraryLoginPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public void gerasbutton() {
		gerasbtn.click();
	}
	
	public void skillrraydemoApplication() {
		skillraydemoapp.click();
	}
	
	public void searchtextbox(String name) {
		serachtb.sendKeys(name);
	}
	
	public void serachbutton() {
		serachbtn.click();
	}
	
}
