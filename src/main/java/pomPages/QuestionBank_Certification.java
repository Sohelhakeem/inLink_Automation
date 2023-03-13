package pomPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QuestionBank_Certification {

	@FindBy (xpath ="//span[normalize-space()='Certification Programme']")
	private WebElement certificationModule;
	
	@FindBy (xpath ="//span[normalize-space()='Question Bank']")
	private WebElement Question_Bank;
	
	@FindBy (xpath ="(//input[@id='title'])[1]")
	private WebElement EnterQuestion;
	
	@FindBy (xpath ="//input[@id='basic']")
	private WebElement DefaultMarks;
	
	@FindBy (xpath ="(//div[@id='demo-simple-select'])[1]")
	private WebElement choiceQuestion;
	@FindBy (xpath ="//li[normalize-space()='Single Choice']")
	private WebElement Singlechoice;
	@FindBy (xpath ="//li[normalize-space()='Multiple Choice']")
	private WebElement Multiplechoice;
	
	@FindBy (xpath ="(//input[@id='title'])[2]")
	private WebElement AddAnswer01;
	
	@FindBy (xpath ="(//*[name()='svg'][@class='MuiSvgIcon-root MuiSvgIcon-fontSizeMedium css-q8lw68'])[1]")
	public WebElement SelectAnswer01;
	
		@FindBy (xpath ="//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-disableElevation MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-disableElevation css-191um2i']")
		private WebElement AddAnswerButton;
		
		@FindBy (xpath ="(//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-disableElevation MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-disableElevation css-191um2i'])[1]")
		public WebElement AddAnswerButtondisplay;
		
	@FindBy (xpath ="(//input[@placeholder='Type the answer 2'])[1]")
	private WebElement AddAnswer02;
	@FindBy (xpath ="//div[@class='QuestionBankLeft flexCol pdngHSM resPdngRQLG']//div[2]//div[1]//span[1]//span[1]//*[name()='svg']")
	public WebElement SelectAnswer02;
	@FindBy (xpath ="(//input[@placeholder='Type the answer 3'])[1]")
	private WebElement AddAnswer03;
	@FindBy (xpath ="//div[contains(@class,'QuestionBankLeft flexCol pdngHSM resPdngRQLG')]//div[3]//div[1]//span[1]//span[1]//*[name()='svg']")
	public WebElement SelectAnswer03;
	@FindBy (xpath ="//input[@placeholder='Type the answer 4']")
	private WebElement AddAnswer04;
	@FindBy (xpath ="//div[@class='flexCol pdngVXS']//div[4]//div[1]//span[1]//span[1]//*[name()='svg']")
	public WebElement SelectAnswer04;

	
	@FindBy (xpath ="(//div[@id='demo-simple-select'])[2]")
	private WebElement SelectMarketingSystem;
	
	@FindBy (xpath ="//button[normalize-space()='Save']")
	private WebElement Save;
	
	@FindBy (xpath ="//button[normalize-space()='Publish']")
	private WebElement Publish;
			@FindBy (xpath ="//button[normalize-space()='Publish']")
			public WebElement PublishDisplay;
	
	@FindBy (xpath ="//button[@class='MuiButtonBase-root MuiButton-root MuiButton-outlined MuiButton-outlinedPrimary MuiButton-sizeMedium MuiButton-outlinedSizeMedium MuiButton-disableElevation MuiButton-root MuiButton-outlined MuiButton-outlinedPrimary MuiButton-sizeMedium MuiButton-outlinedSizeMedium MuiButton-disableElevation capitalTxt css-1xio2w5']")
	private WebElement Filter;
	
	@FindBy (xpath ="//li[normalize-space()='All']")
	private WebElement FilterALL;
	
	@FindBy (xpath ="//li[normalize-space()='Un-categorised']")
	private WebElement FilterUnCatergorised;
	
	@FindBy (xpath ="//li[normalize-space()='Single Choice']")
	private WebElement FilterSingleChoice;
	
	@FindBy (xpath ="//li[normalize-space()='Multiple Choice']")
	private WebElement FilterMultipleChoice;
	
	
	
	
	
	
	public QuestionBank_Certification (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void certificationModule() {
		certificationModule.click();
	}
	public void EnterQuestion(String name) {
		EnterQuestion.sendKeys(name);
	}
	public void DefaultMarks(String data, String name) {
		DefaultMarks.sendKeys(data, name);
	}
	
	public void choiceQuestion() {
		choiceQuestion.click();
	}
	public void Singlechoice() {
		Singlechoice.click();
	}
	public void Multiplechoice() {
		Multiplechoice.click();
	}
	public void AddAnswer01(String name) {
		AddAnswer01.sendKeys(name);
	}
	public void AddAnswerButton() {
		AddAnswerButton.click();
	}
	public void AddAnswer02(String name) {
		AddAnswer02.sendKeys(name);
	}
	public void AddAnswer03(String name) {
		AddAnswer03.sendKeys(name);
	}
	public void AddAnswer04(String name) {
		AddAnswer04.sendKeys(name);
	}
	public void SelectMarketingSystem() {
		SelectMarketingSystem.click();
	}
	public void Save() {
		Save.click();
	}
	public void Publish() {
		Publish.click();
	}
	public void Filter() {
		Filter.click();	
	}
	public void FilterALL() {
		FilterALL.click();	
	}
	public void FilterUnCatergorised() {
		FilterUnCatergorised.click();	
	}
	public void FilterSingleChoice() {
		FilterSingleChoice.click();	
	}
	public void FilterMultipleChoice() {
		FilterMultipleChoice.click();	
	}
	public void Question_Bank() {
		Question_Bank.click();	
	}
	

}
