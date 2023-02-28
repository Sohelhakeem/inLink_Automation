package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConnectionRequestPage {
	@FindBy(xpath = "//div[@id='outlined-select-currency']")
	private WebElement selectRelationDD;
				@FindBy(xpath = "//span[normalize-space()='Manufacturer']")
				private WebElement manufacturer;
				@FindBy(xpath = "//span[normalize-space()='share holder']")
				private WebElement shareholder;
				@FindBy(xpath = "//span[normalize-space()='vendor']")
				private WebElement vendor;
				@FindBy(xpath = "//span[normalize-space()='partner']")
				private WebElement partner;
				@FindBy(xpath = "//span[normalize-space()='distributor']")
				private WebElement distributor;
	@FindBy(xpath="//input[@type='text']")
	private WebElement assignRMField;
	
	@FindBy(xpath="//input[@type='checkbox']")
	private WebElement checkBox;
	
	public WebElement getCheckBox() {
		return checkBox;
	}
	@FindBy(xpath="//button[normalize-space()='Cancel']")
	private WebElement cancel;
	
	@FindBy(xpath="(//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-disableElevation MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-disableElevation whiteTxt css-unu0yk'])[1]")
	private WebElement connect;
	
	@FindBy(xpath="(//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-disableElevation MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-disableElevation whiteTxt css-unu0yk'])[1]")
	private WebElement okBtn;
	
	public ConnectionRequestPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void SelectRelationDD() {
		selectRelationDD.click();
	}
	public void Manufacturer() {
		manufacturer.click();
	}
	public void Shareholder() {
		shareholder.click();
	}
	public void Vendor() {
		vendor.click();
	}
	public void Partner() {
		partner.click();
	}
	public void Distributor() {
		distributor.click();
	}

	public void AssignRMField(String name) {
		assignRMField.sendKeys(name);
	}
	
	public void CheckBox() {
		checkBox.click();;
	}
	public void Cancel() {
		cancel.click();;
	}
	public void Connect() {
		connect.click();;
	}
	public void OkButton() {
		okBtn.click();
	}
}
