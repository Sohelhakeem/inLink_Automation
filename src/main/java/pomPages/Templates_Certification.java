package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Templates_Certification {

	@FindBy (xpath = "//div[@class='flexRow']//div[5]")
	private WebElement TemplatesFeature;
	
	@FindBy (xpath = "(//div[@class='templatemediaOverlay certHover'])[1]")
	private WebElement SelectTemplate;
	
	@FindBy (xpath = "(//input[@type='text'])[1]")
	private WebElement EnyterCerificateName;
	
	@FindBy (xpath = "(//input[@type='text'])[2]")
	private WebElement EnyterCerificateProgramName;
	
	@FindBy (xpath = "(//input[@type='text'])[3]")
	private WebElement EnyterCerificatePresentedToName;
	
	@FindBy (xpath = "(//input[@type='text'])[4]")
	private WebElement EnyterNameOfBenificiary;
	
	@FindBy (xpath = "(//input[@type='text'])[5]")
	private WebElement EnterDescription;
	
	@FindBy (xpath = "//input[@id='logo']")
	private WebElement logo;
		@FindBy (xpath = "//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium css-1m44q5'][normalize-space()='Save']")
		private WebElement SaveImage;
		@FindBy (xpath = "//button[normalize-space()='Cancel']")
		private WebElement CancelImage;
		
	@FindBy (xpath = "//input[@id='sign']")
	private WebElement sign;
	
	@FindBy (xpath = "//input[@id='stamp']")
	private WebElement stamp;
	
	@FindBy (xpath = "//button[normalize-space()='Save']")
	private WebElement Save;
	
	@FindBy (xpath = "//button[normalize-space()='Publish']")
	private WebElement Publish;
		@FindBy (xpath = "//button[normalize-space()='Publish']")
		public WebElement PublishDisplay;
	
	
	public Templates_Certification (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void TemplatesFeature() {
		TemplatesFeature.click();
	}
	public void SelectTemplate() {
		SelectTemplate.click();
	}
	public void EnterCerificateName(String name) {
		EnyterCerificateName.sendKeys(name);
	}
	public void EnterCerificateProgramName(String name) {
		EnyterCerificateProgramName.sendKeys(name);
	}
	public void PresentedTo(String name) {
		EnyterCerificatePresentedToName.sendKeys(name);
	}
	public void EnterNameOfBenificiary(String name) {
		EnyterNameOfBenificiary.sendKeys(name);
	}
	public void EnterDescription(String name) {
		EnterDescription.sendKeys(name);
	}
	public void logo(String name) {
		logo.sendKeys(name);
	}
	public void sign(String name) {
		sign.sendKeys(name);
	}
	public void stamp(String name) {
		stamp.sendKeys(name);
	}
	public void SaveImage() {
		SaveImage.click();
	}
	public void CancelImage(String name) {
		CancelImage.sendKeys(name);
	}
	public void Save() {
		Save.click();
	}
	public void Publish() {
		Publish.click();
	}
}
