package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Certification_Certification {

	@FindBy (xpath = "//input[@type='text'])[1]")
	private WebElement programName;
	
	@FindBy (xpath = "//div[@class='ql-editor ql-blank']")
	private WebElement Editor;
	
	@FindBy (xpath = "//div[@class='flexRow respdngSM customResponsive']//div[2]//div[1]//div[1]//div[1]//div[1]//label[1]//span[1]//span[1]//*[name()='svg']")
	private WebElement SelectCategory;
	
	@FindBy (xpath = "(//div[@id='demo-simple-select'])[1]")
	private WebElement SelectMarketingSystem;
	
			@FindBy (xpath = "(//input[@type='text'])[3]")
			private WebElement NeedField1;
			
			@FindBy (xpath = "(//input[@type='text'])[4]")
			private WebElement NeedField2;
	
	@FindBy (xpath = "(//input[@type='text'])[5]")
	private WebElement defaultPercentage;
			
	@FindBy (xpath = "(//input[@type='text'])[6]")
	private WebElement defaultReApplyDay;
	
	@FindBy (xpath = "(//div[@id='demo-simple-select'])[2]")
	private WebElement durationHrsDD;
			@FindBy (xpath = "//li[normalize-space()='00']")
			private WebElement Select00Hrs;
	@FindBy (xpath = "(//div[@id='demo-simple-select'])[3]")
	private WebElement durationMinDD;
			@FindBy (xpath = "//li[normalize-space()='05']")
			private WebElement Select05min;
	
	@FindBy (xpath="(//div[@id='demo-simple-select'])[4]")
	private WebElement QuestionChoiceTypeDD;
			@FindBy (xpath="//li[normalize-space()='A , B']")
			private WebElement QuestionChoiceTypeAB;
	
	@FindBy (xpath="//div[@id='demo-simple-select-Template']")
	private WebElement Template;
		@FindBy (xpath="//li[normalize-space()='Core Java Programming']")
		private WebElement selectTemplate;
		@FindBy (xpath="//div[@class='templatemediaOverlay']")
		private WebElement previewTemplate;
		@FindBy (xpath="(//*[name()='svg'][@class='MuiSvgIcon-root MuiSvgIcon-fontSizeMedium css-vubbuv'])[6]")
		private WebElement CancelpreviewTemplate;
			
	@FindBy (xpath="//button[normalize-space()='SAVE']")
	private WebElement SAVE;
		
	@FindBy (xpath="//button[normalize-space()='Publish']")
	private WebElement Publish;
	
	@FindBy (xpath="//button[contains(@class,'MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium css-1m44q5')][normalize-space()='Publish']")
	private WebElement ConfirmPublish;
	
	public Certification_Certification (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void  programName(String name) {
		programName.sendKeys(name);
	}
	public void  Editor(String name) {
		Editor.sendKeys(name);
	}
	public void SelectCategory() {
		SelectCategory.click();
	}
	public void SelectMarketingSystem() {
		SelectMarketingSystem.click();
	}
	public void  NeedField1(String name) {
		NeedField1.sendKeys(name);
	}
	public void  NeedField2(String name) {
		NeedField2.sendKeys(name);
	}
	public void  defaultPercentage(String name) {
		defaultPercentage.sendKeys(name);
	}
	public void  defaultReApplyDay(String name) {
		defaultReApplyDay.sendKeys(name);
	}
	public void durationHrsDD() {
		durationHrsDD.click();
	}
	public void Select00Hrs() {
		Select00Hrs.click();
	}
	public void durationMinDD() {
		durationMinDD.click();
	}
	public void Select05min() {
		Select05min.click();
	}
	public void QuestionChoiceTypeDD() {
		QuestionChoiceTypeDD.click();
	}
	public void QuestionChoiceTypeAB() {
		QuestionChoiceTypeAB.click();
	}
	public void Template() {
		Template.click();
	}
	public void selectTemplate() {
		selectTemplate.click();
	}
	public void previewTemplate() {
		previewTemplate.click();
	}
	public void CancelpreviewTemplate() {
		CancelpreviewTemplate.click();
	}
	public void SAVE() {
		SAVE.click();
	}
	public void Publish() {
		Publish.click();
	}
	public void ConfirmPublish() {
		ConfirmPublish.click();
	}
	
	
	
}
