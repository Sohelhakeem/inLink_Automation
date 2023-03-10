package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class createSubCategoryPage {
	
	@FindBy(xpath = "//button[@title='To create sub-category click on this button.']")
	public WebElement NewBtn;
	
		@FindBy(xpath = "//input[@id='preview']")
		private WebElement UploadBanner;
	
		@FindBy(name = "subCategoryName")
		private WebElement subCategoryNameField;
		
		@FindBy(xpath = "//textarea[@placeholder='Write description about(120 characters)']")
		private WebElement subCategoryDiscriptionField;
		
		@FindBy(xpath = "//input[@type='checkbox']")
		private WebElement checkboxBtn;
			@FindBy(xpath = "//input[@type='checkbox']")
			public WebElement checkboxBtnPath;
		
		public WebElement getCheckboxBtn() {
			return checkboxBtn;
		}
		@FindBy(xpath = "//button[normalize-space()='Cancel']")
		private WebElement CancelCategory;
		
		@FindBy(xpath = "//button[normalize-space()='Save']")
		private WebElement SaveCategory;
			@FindBy(xpath = "//button[normalize-space()='Save']")
			public WebElement SaveCategoryPath;
		
	public WebElement getSaveCategory() {
			return SaveCategory;
		}
	
	
//Create Content
	@FindBy (xpath="//button[@title='To create content click on this button']")
	private  WebElement Newcontent;
		@FindBy (xpath="//button[@title='To create content click on this button']")
		public  WebElement NewcontentPath;
		
		@FindBy (xpath="//input[@id='preview']")
		private  WebElement uploadPic;
		
		@FindBy (xpath="//div[@class='flexCol pdngVXS']//div[@class='MuiFormControl-root MuiFormControl-fullWidth MuiTextField-root css-feqhe6']//input[@id='outlined-basic']")
		private  WebElement contentTitileField;
		
		@FindBy (xpath="//textarea[@placeholder='Write description about(250 characters)']")
		private  WebElement contentDescriptionField;
		
		@FindBy (xpath="//input[@id='public']")
		private  WebElement publicButton;
		
		@FindBy (xpath="//div[@title='Type section name']//input[@id='outlined-basic']")
		private  WebElement sectionNameField;
			@FindBy (xpath="//div[@title='Type section name']//input[@id='outlined-basic']")
			public WebElement sectionNameFieldpath;
		
		@FindBy (xpath="//div[@class='ql-editor ql-blank']//p")
		private  WebElement Description;
		
		@FindBy (name="marketingImages")
		private  WebElement UploadImages;
				@FindBy (name="marketingImages")
				public  WebElement UploadImagespath;
		
		@FindBy (xpath="(//input[@type='text'])[4]")
		public  WebElement youtubeUrlPath;
		@FindBy (xpath="(//input[@type='text'])[4]")
		private  WebElement youtubeUrl;
				@FindBy (xpath="//button[normalize-space()='Upload']")
				private  WebElement UploadyoutubeUrlButton;
				@FindBy (xpath="//button[normalize-space()='Upload']")
				public  WebElement youtubeUrlbuttonPath;
		
		@FindBy (xpath="//input[@id='videoType']")
		private  WebElement Uploadvideo;
			@FindBy (xpath="//input[@id='videoType']")
			public  WebElement UploadvideoPath;
		
		@FindBy (xpath="(//input[@id='logo'])[2]")
		private  WebElement UploadDocument;
			@FindBy (xpath="(//input[@id='logo'])[2]")
			public  WebElement UploadDocumentPath;
		
		@FindBy (xpath="//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-disableElevation MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-disableElevation whiteTxt css-unu0yk']")
		private  WebElement SaveContent;
			@FindBy (xpath="//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-disableElevation MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-disableElevation whiteTxt css-unu0yk']")
			public  WebElement SaveContentPath;
		
		@FindBy (xpath="//button[normalize-space()='Cancel']")
		private  WebElement CancelContent;
		
		@FindBy (xpath="//button[normalize-space()='CREATE NEW SECTION']")
		private  WebElement createNewSection;
		
	@FindBy (xpath="//button[normalize-space()='Save']")
	private  WebElement Save;
		
	@FindBy (xpath="//button[normalize-space()='Publish']")
	private  WebElement Publish;
	
		
		
	public createSubCategoryPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Create subCategory
	
	public void NewBtn() {
		NewBtn.click();
	}
	public void UploadBanner(String name) {
		UploadBanner.sendKeys(name);
	}
	public void subCategoryNameField(String name) {
		subCategoryNameField.sendKeys(name);
	}
	public void subCategoryDiscriptionField(String name) {
		subCategoryDiscriptionField.sendKeys(name);
	}
	public void checkboxButton() {
		checkboxBtn.click();
	}
	public void CancelCategory() {
		CancelCategory.click();
	}
	public void SaveCategoryDisplayed() {
		SaveCategory.isDisplayed();
	}
	public void SaveCategory() {
		SaveCategory.click();
	}
	
	//Create Content
	public void Newcontent() {
		Newcontent.click();
	}
		public void publicButton() {
			publicButton.click();
		}
		public void uploadPic(String name) {
			uploadPic.sendKeys(name);
		}
		public void contentDescriptionField(String name) {
			contentDescriptionField.sendKeys(name);
		}
		public void contentTitileField(String name) {
			contentTitileField.sendKeys(name);
		}
		public void sectionNameField(String name) {
			sectionNameField.sendKeys(name);
		}
		public void Description(String name) {
			Description.sendKeys(name);
		}
		public void UploadImages(String name) {
			UploadImages.sendKeys(name);
		}
		public void youtubeUrlField(String name) {
			youtubeUrl.sendKeys(name);
		}
				public void UploadyoutubeUrlButton() {
					UploadyoutubeUrlButton.click();
				}
		public void Uploadvideo(String name) {
			Uploadvideo.sendKeys(name);
		}
		public void UploadDocument(String name) {
			UploadDocument.sendKeys(name);
		}
		public void SaveContent() {
			SaveContent.click();
		}
		public void CancelContent() {
			CancelContent.click();
		}
		public void createNewSection() {
			createNewSection.click();
		}
		public void Save() {
			Save.click();
		}
		public void Publish() {
			Publish.click();
		}
}
