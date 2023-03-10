package CompanyScripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class resourcesScripts extends BaseClass {
	@Test(priority=1)
	public void ResourcesPage() throws IOException {
		LoginPage l = new LoginPage(driver);
		l.email_TF(p.getPropertyFiledata("emailid"));
		l.password_TF(p.getPropertyFiledata("password"));
		l.LoginButton();
		ResourcesPage r = new ResourcesPage(driver);
		r.ResourcePage();
		String text = driver.findElement(By.xpath("//span[@class='mainHdngTxt']")).getText();
		Assert.assertEquals(text, "Categories");
	}
	@Test(priority=2)
	public void Create_Category() throws IOException {
		LoginPage l = new LoginPage(driver);
		l.email_TF(p.getPropertyFiledata("emailid"));
		l.password_TF(p.getPropertyFiledata("password"));
		l.LoginButton();
		
		ResourcesPage r = new ResourcesPage(driver);
		r.ResourcePage();
		r.NewBtn();
		
		createCategoryPage cc = new createCategoryPage(driver);
		cc.UploadIage(p.getPropertyFiledata("UploadImage"));
		cc.categoryNameField(p.getPropertyFiledata("categotyName1"));
		cc.DescriptionField(p.getPropertyFiledata("catDescription"));
		cc.checkbox();
		cc.Save();
		WebElement text = new WebDriverWait(driver, 10)
		         .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Category Created Successfully')]")));
		String actualText = text.getText();
		Assert.assertEquals(actualText, "Category Created Successfully");
	}
	@Test(priority=3)
	public void Update_Category() throws IOException {
		LoginPage l = new LoginPage(driver);
		l.email_TF(p.getPropertyFiledata("emailid"));
		l.password_TF(p.getPropertyFiledata("password"));
		l.LoginButton();
		
		ResourcesPage r = new ResourcesPage(driver);
		r.ResourcePage();
		r.Searchfield(p.getPropertyFiledata("categotyName1"));
		r.Edit();
		
		createCategoryPage cc = new createCategoryPage(driver);
		cc.UploadIage(p.getPropertyFiledata("UploadImage"));
		cc.categoryNameField(p.getPropertyFiledata("categotyName1"));
		cc.DescriptionField(p.getPropertyFiledata("catDescription"));
		cc.checkbox();
		cc.Save();
		WebElement text = new WebDriverWait(driver, 10)
		         .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Category Updated Successfully')]")));
		String actualText = text.getText();
		Assert.assertEquals(actualText, "Category Updated Successfully");
	}
	@Test(priority=4)
	public void Delete_Category() throws IOException {
		LoginPage l = new LoginPage(driver);
		l.email_TF(p.getPropertyFiledata("emailid"));
		l.password_TF(p.getPropertyFiledata("password"));
		l.LoginButton();
		
		ResourcesPage r = new ResourcesPage(driver);
		r.ResourcePage();
		r.Searchfield(p.getPropertyFiledata("categotyName1"));
		r.Delete();
		r.ConfDelete();
		
		WebElement text = new WebDriverWait(driver, 10)
		         .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Category Deleted Succesfully')]")));
		String actualText = text.getText();
		
		//Assert.assertEquals(actualText, "Category Deleted Successfully");
		Assert.assertEquals(actualText, "Category Deleted Succesfully");
	}
	@Test(priority=5)
	public void Create_category() throws IOException {
		LoginPage l = new LoginPage(driver);
		l.email_TF(p.getPropertyFiledata("emailid"));
		l.password_TF(p.getPropertyFiledata("password"));
		l.LoginButton();
		
		ResourcesPage r = new ResourcesPage(driver);
		r.ResourcePage();
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
	}
	@Test(priority=6)
	public void CreateSub_Category() throws IOException, InterruptedException {
		LoginPage l = new LoginPage(driver);
		l.email_TF(p.getPropertyFiledata("emailid"));
		l.password_TF(p.getPropertyFiledata("password"));
		l.LoginButton();
		
		ResourcesPage r = new ResourcesPage(driver);
		//search and select the category
		r.ResourcePage();
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
	}
	@Test(priority=7)
	public void Create_Content() throws IOException, InterruptedException {
		LoginPage l = new LoginPage(driver);
		l.email_TF(p.getPropertyFiledata("emailid"));
		l.password_TF(p.getPropertyFiledata("password"));
		l.LoginButton();
		
		ResourcesPage r = new ResourcesPage(driver);
		//search and select the category
		r.ResourcePage();
		r.Searchfield(p.getPropertyFiledata("categotyName"));
		String categoryname = p.getPropertyFiledata("categotyName");
		WebElement name = driver.findElement(By.xpath("//span[@aria-label='"+categoryname+"']"));
		name.isDisplayed();
		name.click();
		
		createSubCategoryPage cs = new createSubCategoryPage(driver);
		WebElement text0 = new WebDriverWait(driver, 10)
		         .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[normalize-space()='"+categoryname+"']")));
		text0.isDisplayed();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
//		//Create Content
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
	@Test(priority=8)
	public void Delete_Content() throws IOException, InterruptedException {
		LoginPage l = new LoginPage(driver);
		l.email_TF(p.getPropertyFiledata("emailid"));
		l.password_TF(p.getPropertyFiledata("password"));
		l.LoginButton();
		
		ResourcesPage r = new ResourcesPage(driver);
		//search and select the category
		r.ResourcePage();
		r.Searchfield(p.getPropertyFiledata("categotyName"));
		String categoryname = p.getPropertyFiledata("categotyName");
		WebElement name = driver.findElement(By.xpath("//span[@aria-label='"+categoryname+"']"));
		name.isDisplayed();
		name.click();
		
		//createSubCategoryPage cs = new createSubCategoryPage(driver);
		WebElement text0 = new WebDriverWait(driver, 10)
		         .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[normalize-space()='"+categoryname+"']")));
		text0.isDisplayed();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement deletesub = driver.findElement(By.xpath("//div[contains(@aria-label,'Delete')]//*[name()='svg']"));
		js.executeScript("arguments[0].scrollIntoView(true);", deletesub);
		Thread.sleep(500);
		//js.executeScript("arguments[0].click();", deletesub);
		deletesub.click();
		WebElement delete = driver.findElement(By.xpath("//button[normalize-space()='Delete']"));
		delete.click();
		
		WebElement text = new WebDriverWait(driver, 10)
		         .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Sub Category Deleted Succesfully')]")));
		String actualText = text.getText();
		Assert.assertEquals(actualText, "Sub Category Deleted Succesfully");
		
		driver.findElement(By.xpath("//*[name()='path' and contains(@fill-rule,'evenodd')]")).click();
		
		WebElement contentopen = driver.findElement(By.xpath("//span[@class='ellipseLen2 wordBreakWord']"));
		js.executeScript("arguments[0].scrollIntoView(true);", contentopen);
		Thread.sleep(500);
		//js.executeScript("arguments[0].click();", deletesub);
		contentopen.click();
		
		WebElement contentdelete = driver.findElement(By.xpath("//div[@aria-label='Delete']//*[name()='svg']"));
		js.executeScript("arguments[0].scrollIntoView(false);", contentdelete);
		Thread.sleep(1000);
		contentdelete.click();
		Thread.sleep(1000);
		WebElement deletee = driver.findElement(By.xpath("//button[normalize-space()='Delete']"));
		deletee.click();
		
		WebElement text1 = new WebDriverWait(driver, 10)
		         .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Content and its sections deleted succesfully')]")));
		String actualText1 = text1.getText();
		Assert.assertEquals(actualText1, "Content and its sections deleted succesfully");
		
        }
	@Test(priority=9,invocationCount= 0)
	public void Delete_Categoryy() throws IOException {
		LoginPage l = new LoginPage(driver);
		l.email_TF(p.getPropertyFiledata("emailid"));
		l.password_TF(p.getPropertyFiledata("password"));
		l.LoginButton();
		
		ResourcesPage r = new ResourcesPage(driver);
		r.ResourcePage();
		r.Searchfield(p.getPropertyFiledata("categotyName"));
		r.Delete();
		r.ConfDelete();
		
		WebElement text = new WebDriverWait(driver, 10)
		         .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Category Deleted Succesfully')]")));
		String actualText = text.getText();
		
		//Assert.assertEquals(actualText, "Category Deleted Successfully");
		Assert.assertEquals(actualText, "Category Deleted Succesfully");
	}
	@Test(priority=10)
	public void AllFilter() throws IOException, InterruptedException {
		LoginPage l = new LoginPage(driver);
		l.email_TF(p.getPropertyFiledata("emailid"));
		l.password_TF(p.getPropertyFiledata("password"));
		l.LoginButton();
		
		ResourcesPage r = new ResourcesPage(driver);
		//search and select the category
		r.ResourcePage();
		r.Filter();
		r.AllFilter();
	}
	@Test(priority=11)
	public void EnabledFilter() throws IOException, InterruptedException {
		LoginPage l = new LoginPage(driver);
		l.email_TF(p.getPropertyFiledata("emailid"));
		l.password_TF(p.getPropertyFiledata("password"));
		l.LoginButton();
		
		ResourcesPage r = new ResourcesPage(driver);
		//search and select the category
		r.ResourcePage();
		r.Filter();
		r.EnabledFilter();
	}
	@Test(priority=12)
	public void DisableFilter() throws IOException, InterruptedException {
		LoginPage l = new LoginPage(driver);
		l.email_TF(p.getPropertyFiledata("emailid"));
		l.password_TF(p.getPropertyFiledata("password"));
		l.LoginButton();
		
		ResourcesPage r = new ResourcesPage(driver);
		//search and select the category
		r.ResourcePage();
		r.Filter();
		r.DisableFilter();
	}

}
