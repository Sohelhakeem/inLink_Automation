package CompanyScripts;


	import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericLib.BaseClass;
import pomPages.LoginPage;
import pomPages.ResourcesPage;
import pomPages.createCategoryPage;
import pomPages.createSubCategoryPage;
import pomPages.employeesPage;

	public class test extends BaseClass {
		@Test(priority=5)
		public void CreateSub_Category() throws IOException {
			LoginPage l = new LoginPage(driver);
			l.email_TF(p.getPropertyFiledata("emailid"));
			l.password_TF(p.getPropertyFiledata("password"));
			l.LoginButton();
			
			ResourcesPage r = new ResourcesPage(driver);
			r.ResourcePage();
		
			//search and select the category
			r.Searchfield(p.getPropertyFiledata("categotyName"));
			String categoryname = p.getPropertyFiledata("categotyName");
			WebElement name = driver.findElement(By.xpath("//span[@aria-label='"+categoryname+"']"));
			name.isDisplayed();
			name.click();
			
			createSubCategoryPage cs = new createSubCategoryPage(driver);
			WebElement text = new WebDriverWait(driver, 10)
			         .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[normalize-space()='"+categoryname+"']")));
			text.isDisplayed();
			
			//Create new SubCategory
//			cs.NewBtn();
//			cs.UploadBanner(p.getPropertyFiledata("UploadImage7"));
//			cs.subCategoryNameField(p.getPropertyFiledata("subCategotyName"));
//			cs.subCategoryDiscriptionField(p.getPropertyFiledata("catDescription"));
//			
			JavascriptExecutor js = (JavascriptExecutor) driver;
//			js.executeScript("arguments[0].scrollIntoView(true);",cs.SaveCategory );
//			cs.SaveCategoryDisplayed();
//			cs.checkboxButton();
//			cs.SaveCategory();
//			
//			WebElement text1 = new WebDriverWait(driver, 10)
//			         .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Sub Category Created Successfully')]")));
//			String actualText = text1.getText();
//			Assert.assertEquals(actualText, "Sub Category Created Successfully");
//			
			//Create Content
			js.executeScript("arguments[0].scrollIntoView(true);",cs.Newcontent);
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(cs.Newcontent));
			cs.Newcontent();
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
			cs.UploadyoutubeUrl();
			js.executeScript("arguments[0].scrollIntoView(true);",cs.UploadvideoPath );
			//wait.until(ExpectedConditions.elementToBeClickable(cs.UploadvideoPath));
			cs.Uploadvideo(p.getPropertyFiledata("UploadVideo"));
			js.executeScript("arguments[0].scrollIntoView(true);",cs.UploadDocumentPath );
			cs.UploadDocument(p.getPropertyFiledata("document"));
			js.executeScript("arguments[0].scrollIntoView(true);",cs.SaveContentPath );
			wait.until(ExpectedConditions.elementToBeClickable(cs.SaveContentPath));
			cs.SaveContent();
			
		}
	}

