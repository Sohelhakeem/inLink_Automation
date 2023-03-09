package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResourcesPage {

	@FindBy (xpath ="//span[normalize-space()='Resources']")
	private WebElement resourcePage;
	
	@FindBy (xpath ="//input[@type='search']")
	private WebElement Searchfield;
	
	@FindBy (xpath ="//button[normalize-space()='New']")
	private WebElement NewBtn;
	
	@FindBy (xpath ="//button[@id='fade-button']")
	private WebElement Filter;
		@FindBy (xpath ="//li[normalize-space()='All']")
		private WebElement AllFilter;
		@FindBy (xpath ="//li[normalize-space()='Enabled']")
		private WebElement EnabledFilter;
		@FindBy (xpath ="//li[@value='Disable']")
		private WebElement DisableFilter;
		
	@FindBy (xpath ="//div[@aria-label='Edit']//*[name()='svg']")
	private WebElement Edit;	
	@FindBy (xpath ="//div[@aria-label='Delete']//*[name()='svg']")
	private WebElement Delete;	
			@FindBy (xpath ="//button[normalize-space()='Delete']")
			private WebElement ConfDelete;	
			@FindBy (xpath ="//button[normalize-space()='Cancel']")
			private WebElement CancelDelete;
	@FindBy (xpath="//input[@value='false']")
	private WebElement EnableBtn;
		@FindBy (xpath="//button[normalize-space()='Disable']")
		private WebElement DisableBtn;
			@FindBy (xpath="//button[normalize-space()='Enable']")
			private WebElement EnableBtn2;
			@FindBy (xpath="//button[normalize-space()='Cancel']")
			private WebElement EnableBtnCancel;
	
	
	
	public ResourcesPage (WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	public void ResourcePage() {
		resourcePage.click();
	}
	public void NewBtn() {
		NewBtn.click();
	}
	public void Searchfield(String name) {
		Searchfield.sendKeys(name);
	}
	public void Filter() {
		Filter.click();
	}
			public void AllFilter() {
				AllFilter.click();
			}
			public void EnabledFilter() {
				EnabledFilter.click();
			}
			public void DisableFilter() {
				DisableFilter.click();
			}
	public void Edit() {
		Edit.click();
	}
	public void Delete() {
		Delete.click();
	}
	public void ConfDelete() {
		ConfDelete.click();
	}
	public void CancelDelete() {
		CancelDelete.click();
	}
			public void EnableBtn() {
				EnableBtn.click();
			}
			public void DisableBtn() {
				DisableBtn.click();
			}
			public void EnableBtn2() {
				EnableBtn2.click();
			}
			public void EnableBtnCancel() {
				EnableBtnCancel.click();
			}
	
}
