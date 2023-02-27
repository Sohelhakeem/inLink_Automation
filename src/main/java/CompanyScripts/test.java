package CompanyScripts;


	import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericLib.BaseClass;
import pomPages.LoginPage;
import pomPages.createNews;
import pomPages.homePage;

	public class test extends BaseClass {
		@Test//(priority=3,retryAnalyzer = MyRetry.class)
		//Deleting the uploaded post permanently.
		public void Delete_Post() throws IOException, InterruptedException  {
			LoginPage l=new LoginPage(driver);
			l.email_TF(p.getPropertyFiledata("emailid"));
			l.password_TF(p.getPropertyFiledata("password"));
			l.LoginButton();
			
			homePage h=new homePage(driver);
			h.CreatePost();
			
			createNews cn = new createNews(driver);
			cn.textContentField("Deleting news feed");
			cn.UploadImage(p.getPropertyFiledata("UploadImage2"));
			Thread.sleep(1000);
			cn.PostButton();
			Thread.sleep(3000);
			String expected_Text1 = "News Feed Created Successfully";
			String actual_Text1 = driver.findElement(By.xpath("//div[contains(text(),'News Feed Created Successfully')]")).getText();
			Assert.assertEquals(expected_Text1, actual_Text1);
			Thread.sleep(1000);
			
			h.ThreeDots();
			h.DeleteIcon();
			h.DeleteCheckbox();
			h.ConfirmDeleteButton();
			Thread.sleep(3000);
			String expected_Text2 = "News Feed Deleted Successfully!";
			String actual_Text2 = driver.findElement(By.xpath("//div[contains(text(),'News Feed Deleted Successfully!')]")).getText();
			Assert.assertEquals(expected_Text2, actual_Text2);
			
		}
	}

