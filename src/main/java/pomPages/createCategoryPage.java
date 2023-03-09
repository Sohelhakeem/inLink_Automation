package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class createCategoryPage {
	
	//Create Category
			@FindBy (xpath="//input[@id='preview']")
			private WebElement UploadIage; 
	@FindBy (xpath="//input[@id='outlined-basic']")
	private WebElement categoryNameField; 
	
	@FindBy (xpath="//textarea[@placeholder='Write description about(120 characters)']")
	private WebElement DescriptionField; 
			@FindBy (xpath="//input[@type='checkbox']")
			private WebElement checkbox; 
			
	@FindBy (xpath="//button[normalize-space()='Cancel']")
	private WebElement Cancel; 
			
	@FindBy (xpath="//button[normalize-space()='Save']")
	private WebElement Save; 
	
	
			
	public createCategoryPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void UploadIage(String name) {
		UploadIage.sendKeys(name);
	}
	public void categoryNameField(String name) {
		categoryNameField.sendKeys(name);
	}
	public void DescriptionField(String name) {
		DescriptionField.sendKeys(name);
	}
	public void checkbox() {
		checkbox.click();
	}
	public void Cancel() {
		Cancel.click();
	}
	public void Save() {
		Save.click();
	}


}
