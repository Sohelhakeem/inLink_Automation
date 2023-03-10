package endToendTests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import CompanyScripts.MyRetry;
import genericLib.BaseClass;
import pomPages.LoginPage;
import pomPages.ResourcesPage;
import pomPages.createCategoryPage;
import pomPages.createSubCategoryPage;

public class ResourcesCreateCategory extends BaseClass {
	@Test(retryAnalyzer = MyRetry.class)
	public void CreateSub_Category() throws IOException, InterruptedException {
		LoginPage l = new LoginPage(driver);
		l.email_TF(p.getPropertyFiledata("emailid"));
		l.password_TF(p.getPropertyFiledata("password"));
		l.LoginButton();
		
		ResourcesPage r = new ResourcesPage(driver);
		r.ResourcePage();
		//create Category
		r.NewBtn();
		
		createCategoryPage cc = new createCategoryPage(driver);
		cc.UploadIage(p.getPropertyFiledata("UploadImage"));
		cc.categoryNameField(p.getPropertyFiledata("categotyName"));
		cc.DescriptionField(p.getPropertyFiledata("catDescription"));
		cc.checkbox();
		cc.Save();
		WebElement text = new WebDriverWait(driver, 10)
		         .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Category Created Successfully')]")));
		String actualText = text.getText();
		Assert.assertEquals(actualText, "Category Created Successfully");
		r.ResourcePage();
	
		//search and select the category
		r.Searchfield(p.getPropertyFiledata("categotyName"));
		String categoryname = p.getPropertyFiledata("categotyName");
		WebElement name = driver.findElement(By.xpath("//span[@aria-label='"+categoryname+"']"));
		name.isDisplayed();
		name.click();
		
		createSubCategoryPage cs = new createSubCategoryPage(driver);
		WebElement text0 = new WebDriverWait(driver, 10)
		         .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[normalize-space()='"+categoryname+"']")));
		text0.isDisplayed();
		
		//Create new SubCategory
		cs.NewBtn();
		cs.UploadBanner(p.getPropertyFiledata("UploadImage7"));
		cs.subCategoryNameField(p.getPropertyFiledata("subCategotyName"));
		cs.subCategoryDiscriptionField(p.getPropertyFiledata("catDescription"));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);",cs.SaveCategoryPath );
		cs.SaveCategoryDisplayed();
		js.executeScript("arguments[0].click()", cs.checkboxBtnPath);
		//cs.checkboxButton();
		js.executeScript("arguments[0].click()", cs.SaveCategoryPath);
		//cs.SaveCategory();
		
		WebElement text1 = new WebDriverWait(driver, 10)
		         .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Sub Category Created Successfully')]")));
		String actualText4 = text1.getText();
		Assert.assertEquals(actualText4, "Sub Category Created Successfully");
		
		//Create Content
		js.executeScript("arguments[0].scrollIntoView(true);",cs.NewcontentPath);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(cs.NewcontentPath));
		js.executeScript("arguments[0].click();", cs.NewcontentPath);
		//cs.Newcontent();
		
		cs.UploadBanner(p.getPropertyFiledata("UploadImage8"));
		WebElement zoomin = driver.findElement(By.xpath("//span[@class='cropper-face cropper-move']"));
		js.executeScript("arguments[0].style.transform = 'scale(1.2)';", zoomin);
		driver.findElement(By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium css-1m44q5'][normalize-space()='Save']")).click();
		
		cs.contentTitileField(p.getPropertyFiledata("ContentTitle"));
		
		cs.contentDescriptionField(p.getPropertyFiledata("catDescription"));
		
		js.executeScript("arguments[0].scrollIntoView(true);",cs.sectionNameFieldpath );
		cs.sectionNameField(p.getPropertyFiledata("fullname"));
		
		cs.Description(p.getPropertyFiledata("catDescription"));
		
		js.executeScript("arguments[0].scrollIntoView(true);",cs.UploadImagespath );
		cs.UploadImages(p.getPropertyFiledata("UploadImage2"));
		
		js.executeScript("arguments[0].scrollIntoView(true);",cs.youtubeUrlPath );
		cs.youtubeUrlField(p.getPropertyFiledata("youTubeUrl"));
		js.executeScript("arguments[0].click();", cs.youtubeUrlPath);
		js.executeScript("arguments[0].click();", cs.youtubeUrlbuttonPath);
		//cs.UploadyoutubeUrlButton();
		
		js.executeScript("arguments[0].scrollIntoView(true);",cs.UploadvideoPath );
		//wait.until(ExpectedConditions.elementToBeClickable(cs.UploadvideoPath));
		cs.Uploadvideo(p.getPropertyFiledata("UploadVideo"));
		
		js.executeScript("arguments[0].scrollIntoView(true);",cs.UploadDocumentPath );
		cs.UploadDocument(p.getPropertyFiledata("document"));
		Thread.sleep(2000);
		
		js.executeScript("arguments[0].scrollIntoView(true);",cs.SaveContentPath );
		wait.until(ExpectedConditions.elementToBeClickable(cs.SaveContentPath));
		js.executeScript("arguments[0].click();", cs.SaveContentPath);
//		cs.SaveContent();
		
		WebElement text2 = new WebDriverWait(driver, 10)
		         .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Section Saved Successfully')]")));
		String actualText2 = text2.getText();
		Assert.assertEquals(actualText2, "Section Saved Successfully");
		
		cs.Publish();
		WebElement text3 = new WebDriverWait(driver, 10)
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Content created successfully')]")));
		String actualText3 = text3.getText();
		Assert.assertEquals(actualText3, "Content created successfully");
		
	}
}
