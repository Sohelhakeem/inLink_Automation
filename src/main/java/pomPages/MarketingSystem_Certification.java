package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MarketingSystem_Certification {
	
	@FindBy (xpath ="//span[normalize-space()='Certification Programme']")
	private WebElement certificationModule;
	
	@FindBy (xpath ="//div[@class='flexRow whiteBg brdrRadiusXSM pdngSM hrztlScroll']//div[3]")
	private WebElement MarketingSystem;
	
	@FindBy (xpath ="//button[normalize-space()='Published']")
	private WebElement Published;
	
	@FindBy (xpath ="//input[@type='search']")
	private WebElement SearchMarketingSystem;
	
	@FindBy (xpath ="//button[normalize-space()='New']")
	private WebElement New;
	
	@FindBy (xpath ="(//*[name()='svg'][contains(@aria-label,'Edit')])[1]")
	private WebElement Edit;
	
	@FindBy (xpath ="(//*[name()='svg'][@aria-label='Delete'])[1]")
	private WebElement Delete;
	
	@FindBy (xpath ="//button[normalize-space()='Delete']")
	private WebElement ConfirmDelete;
	
	
	@FindBy (xpath ="(//input[@type='text'])[1]")
	private WebElement EnterEcronymField1;
	
	@FindBy (xpath ="//button[normalize-space()='Another Field']")
	private WebElement AnotherField;
	
	@FindBy (xpath ="(//input[@type='text'])[2]")
	private WebElement EnterEcronymField2;
	
	@FindBy (xpath ="(//input[@type='text'])[3]")
	private WebElement EnterEcronymField3;
	
	@FindBy (xpath ="(//input[@type='text'])[4]")
	private WebElement EnterEcronymField4;
	
	@FindBy (xpath ="//button[normalize-space()='Save']")
	private WebElement Save;
	
	@FindBy (xpath ="//button[normalize-space()='Publish']")
	private WebElement Publish;
	
	@FindBy (xpath ="//button[normalize-space()='UnPublish']")
	private WebElement UnPublish;
	
	
	public MarketingSystem_Certification (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void certificationModule() {
		certificationModule.click();
	}
	public void MarketingSystem() {
		MarketingSystem.click();
	}
	public void Published() {
		Published.click();
	}
	public void UnPublish() {
		UnPublish.click();
	}
	public void SearchMarketingSystem(String name) {
		SearchMarketingSystem.sendKeys(name);
	}
	public void New() {
		New.click();
	}
	public void Edit() {
		Edit.click();
	}
	public void EnterEcronymField1(String name) {
		EnterEcronymField1.sendKeys(name);
	}
	public void AnotherField() {
		AnotherField.click();
	}
	public void EnterEcronymField2(String name) {
		EnterEcronymField2.sendKeys(name);
	}
	public void EnterEcronymField3(String name) {
		EnterEcronymField3.sendKeys(name);
	}
	public void EnterEcronymField4(String name) {
		EnterEcronymField4.sendKeys(name);
	}
	public void Save() {
		Save.click();
	}
	public void Publish() {
		Publish.click();
	}
	public void Delete() {
		Delete.click();
	}
	public void ConfirmDelete() {
		ConfirmDelete.click();
	}

}
