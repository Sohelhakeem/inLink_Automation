package CompanyScripts;


	import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.testng.Assert;
import org.testng.annotations.Test;

import employeeScripts.MyRetry;
import genericLib.BaseClass;
import pomPages.LoginPage;
import pomPages.createNews;
import pomPages.homePage;

	public class test extends BaseClass {
		@Test(priority=5)
		//Deleting Uploaded post by saving the post in archive.
		public void Delete_Post_SaveArchieve() throws IOException, InterruptedException  {
			LoginPage l=new LoginPage(driver);
			l.email_TF(p.getPropertyFiledata("emailid"));
			l.password_TF(p.getPropertyFiledata("password"));
			l.LoginButton();
			
			homePage h=new homePage(driver);
			h.CreatePost();
			
			createNews cn = new createNews(driver);
			cn.textContentField("Updating documents");
			cn.UploadImage(p.getPropertyFiledata("UploadImage2"));
			Thread.sleep(2000);
			cn.PostButton();
			Thread.sleep(2000);
			String expected_Text1 = "News Feed Created Successfully";
			String actual_Text1 = driver.findElement(By.xpath("//div[contains(text(),'News Feed Created Successfully')]")).getText();
			Assert.assertEquals(expected_Text1, actual_Text1);
			Thread.sleep(1000);
			
			h.ThreeDots();
			h.DeleteIcon();
			h.ConfirmDeleteButton();
			Thread.sleep(2000);
			String expected_Text2 = "Feed Deleted Successfully, saved in Archived feed";
			String actual_Text2 = driver.findElement(By.xpath("//div[contains(text(),'Feed Deleted Successfully, saved in Archived feed')]")).getText();
			Assert.assertEquals(expected_Text2, actual_Text2);
			
		}
	}

