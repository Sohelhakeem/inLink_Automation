package pomPages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class createNews {
@FindBy(xpath="//input[@id='imageType']")
private WebElement uploadimage;

@FindBy(xpath="//input[@id='videoType']")
private WebElement uploadvideo;



@FindBy(xpath="(//div[@class='flexInline pdngHXS positionRelative'])[2]")
private WebElement youtubeurlicon;

		@FindBy(xpath="//input[@placeholder='Paste URL here']")
		private WebElement youtubeurl;
		@FindBy(xpath="//button[normalize-space()='Done']")
		private WebElement doneBtn;
		@FindBy(xpath="//button[normalize-space()='Cancel']")
		private WebElement cancel;

@FindBy(xpath="//div[@class='flexAutoRow pdngRSM alignCntr']")
private WebElement youtubeurlarrow;

@FindBy(xpath="//textarea[@placeholder='Write something about your post !']")
private WebElement textcontentfield;

@FindBy(xpath="//button[normalize-space()='Post']")
private WebElement postbtn; 

@FindBy(xpath="//input[@id='public']")
private WebElement publicBtn; 
public WebElement getPublicBtn() {
	return publicBtn;
}

			@FindBy(xpath="(//input[@type='checkbox'])[6]")
			private WebElement employeesBtn; 
			@FindBy(xpath="(//input[@type='checkbox'])[8]")
			private WebElement share_Holder; 
			@FindBy(xpath="(//input[@type='checkbox'])[10]")
			private WebElement partner; 
			@FindBy(xpath="(//input[@type='checkbox'])[7]")
			private WebElement manufacturer; 
			@FindBy(xpath="(//input[@type='checkbox'])[9]")
			private WebElement vendor; 
			@FindBy(xpath="(//input[@type='checkbox'])[11]")
			private WebElement distribtor; 
			public WebElement getDistribtor() {
				return distribtor;
			}

@FindBy(xpath="//input[@id='activeType']")
private WebElement status;



public WebElement getStatus() {
	return status;
}

@FindBy(xpath="//div[@class='flexAutoRow alignCntr pdngHXS']")
private WebElement cancelbtn;

@FindBy(xpath="//div[contains(text(),'News Feed Created Successfully')]")
private WebElement verifypath;


public  createNews (WebDriver driver) {
	PageFactory.initElements(driver, this);
}

public WebElement getTextcontentfield() {
	return textcontentfield;
}

public void UploadImage(String UploadImage) {
	uploadimage.sendKeys(UploadImage);
}
public void UploadImages() {
	uploadimage.click();
}
public void UploadVideo(String UploadVideo) {
	uploadvideo.sendKeys(UploadVideo);
}

public void YoutubeUrlIcon() {
	youtubeurlicon.click();
}
			public void youTubeUrl(String youTubeUrl) {
				youtubeurl.sendKeys(youTubeUrl);
			}
			public void DoneButton() {
				doneBtn.click();
			}
			public void Cancel() {
				cancel.click();
			}

public void youtubeurlArrow() {
	youtubeurlarrow.click();
}

public void textContentField(String ContentText) {
	textcontentfield.sendKeys(ContentText);
}
public void CleartextContentField() {
	textcontentfield.clear();
}
public void PostButton() {
	postbtn.click();
}

public void PublicButton() {
	publicBtn.click();
	}
public void jspublic(WebDriver driver) {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[].click();", publicBtn);
	
}
public void PublicButtonDisplay() {
	publicBtn.isDisplayed();
}

public void MyEmployees() {
	employeesBtn.click();
}
public void Share_holder() {
	share_Holder.click();
}
public void Partner() {
	partner.click();
}
public void Manufacturer() {
	manufacturer.click();
}
public void Vendor() {
	vendor.click();
}
public void Distribtor() {
	distribtor.click();
}

public void Status() {
	status.click();
}

public void Cancel_Button() {
	cancelbtn.click();
}

public void verify() {
	String expected_Text1 = "News Feed Created Successfully";
	String actual_Text1 = verifypath.getText();
	System.out.println(actual_Text1);
	Assert.assertEquals(expected_Text1, actual_Text1);
}
}
