package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class configurationPage {

	@FindBy(xpath="//body/div[@id='root']/div[@class='baseBlockCntnr']/div[@class='flexCol fullHeight']/div[contains(@class,'flexCol resSideNav')]/ul[@class='flexMinHeightCol resSideNavGroup pdngVSM scrollXHidden scrollY']/li[7]/div[1]")
	private WebElement configurationModule;
	
	@FindBy(xpath="//input[@type='search']")
	private WebElement searchField;
	
	@FindBy(xpath="//button[normalize-space()='Departments']")
	private WebElement Departments;
	
	@FindBy (xpath = "//button[normalize-space()='Relations']")
	private WebElement Relations;
	
	@FindBy(xpath="//button[normalize-space()='New']")
	private WebElement NewBtn;
	
		@FindBy(xpath="//input[@id='outlined-basic']")
		private WebElement EnterName;
		@FindBy(xpath="//textarea[@placeholder='Write description about(120 characters)']")
		private WebElement EnterDiscription;
		@FindBy(xpath="//button[normalize-space()='Create']")
		private WebElement Create;
		@FindBy(xpath="//button[normalize-space()='Cancel']")
		private WebElement Cancel;
		@FindBy(xpath="//button[normalize-space()='Update']")
		private WebElement Updata;
		
			@FindBy(xpath="//div[@class='flexMinHeightCol pdngXS pointer']")
			private WebElement openDept;
			
	@FindBy(xpath="//button[normalize-space()='Divisions']")
	private WebElement Divisions;
			
	@FindBy(xpath="//button[normalize-space()='Designations']")
	private WebElement Designations;
	
	@FindBy(xpath="//span[normalize-space()='Edit']")
	private WebElement EditDepartment;
	
	@FindBy(xpath="//span[normalize-space()='Delete']")
	private WebElement DeleteDepartment;
		@FindBy(xpath="//button[normalize-space()='Cancel']")
		private WebElement CancelDeleteDepartment;
		@FindBy(xpath="//button[normalize-space()='Delete']")
		private WebElement ConfirmDeleteDepartment;
	
	@FindBy(xpath="(//*[name()='svg'][@aria-label='Delete'])[1]")
	private WebElement DeleteDivision;
		@FindBy(xpath="(//*[name()='svg'][contains(@aria-label,'Edit')])[1]")
		private WebElement EditDivision;
		
	
	public configurationPage (WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	public void configurationModule() {
		configurationModule.click();
	}
	public void searchDeptField(String name) {
		searchField.sendKeys(name);
	}
	public void searchDivisionField(String name) {
		searchField.sendKeys(name);
	}
	public void searchDesignationField(String name) {
		searchField.sendKeys(name);
	}
	public void Departments() {
		Departments.click();
	}
		
	public void Relations() {
		Relations.click();
	}
			public void NewBtn() {
				NewBtn.click();
			}
			public void EnterName(String name) {
				EnterName.sendKeys(name);
			}
			public void ClearName() {
				EnterName.clear();
			}
			public void EnterDiscription(String name) {
				EnterDiscription.sendKeys(name);
			}
			public void Create() {
				Create.click();
			}
			public void Cancel() {
				Cancel.click();
			}
			public void Updata() {
				Updata.click();
			}
					public void openDept() {
						openDept.click();
					}
	public void Divisions() {
		Divisions.click();
	}
	public void Designations() {
		Designations.click();
	}
	public void EditDepartment() {
		EditDepartment.click();
	}
	public void DeleteDepartment() {
		DeleteDepartment.click();
	}
			public void CancelDeleteDepartment() {
				CancelDeleteDepartment.click();
			}
			public void ConfirmDeleteDepartment() {
				ConfirmDeleteDepartment.click();
			}
	public void EditDivision() {
		EditDivision.click();
	}
	public void DeleteDivision() {
		DeleteDivision.click();
	}
			public void CancelDeleteDivision() {
				CancelDeleteDepartment.click();
			}
			public void ConfirmDeleteDivision() {
				ConfirmDeleteDepartment.click();
			}
	public void EditDesignation() {
		EditDivision.click();
	}
	public void DeleteDesignation() {
		DeleteDivision.click();
	}
			public void CancelDeleteDesignation() {
				CancelDeleteDepartment.click();
			}
			public void ConfirmDeleteDesignation() {
				ConfirmDeleteDepartment.click();
			}
	
	
}
