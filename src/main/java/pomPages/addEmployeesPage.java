package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class addEmployeesPage {
	@FindBy(name="fullname")
	private WebElement fullname;
	
	@FindBy(name="email")
	private WebElement email;
	
	@FindBy(xpath="//input[@type='tel']")
	private WebElement phoneNumber;
	
	@FindBy(xpath="//div[@id='demo-simple-select']")
	private WebElement Department;
	
	@FindBy(xpath="(//div[contains(@role,'button')])[3]")
	private WebElement AddDivision;
	
	@FindBy(xpath="(//div[contains(@role,'button')])[4]")
	private WebElement Designation;
	
	@FindBy(xpath="(//input[@type='text'])[5]")
	private WebElement workLocation;
	
	public WebElement getWorkLocation() {
		return workLocation;
	}
	@FindBy(xpath="//button[normalize-space()='Add']")
	private WebElement addBtn;
	
	@FindBy(xpath="//button[normalize-space()='Cancel']")
	private WebElement cancelBtn;
	
	public addEmployeesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void fullname(String name) {
		fullname.sendKeys(name);
	}
	public void email(String name) {
		email.sendKeys(name);
	}
	public void phoneNumber(String name) {
		phoneNumber.sendKeys(name);
	}
	public void Department() {
		Department.click();
	}
	public void AddDivision() {
		AddDivision.click();
	}
	public void Designation() {
		Designation.click();
	}
	public void workLocation(String name) {
		workLocation.sendKeys(name);
	}
	public void workLocationDisplay() {
		workLocation.isDisplayed();
	}
	public void addBtn() {
		addBtn.click();
	}
	public void addBtnDisplay() {
		addBtn.isDisplayed();
	}
	public void cancelBtn() {
		cancelBtn.click();
	}

}
