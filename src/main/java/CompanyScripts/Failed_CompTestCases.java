package CompanyScripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericLib.BaseClass;
import pomPages.LoginPage;
import pomPages.createNews;
import pomPages.homePage;

public class Failed_CompTestCases extends BaseClass {
	@Test(priority=7)
	//Company Create Post
	//UploadVideo
		public void UploadVideo_Multiple() throws IOException, InterruptedException {
			LoginPage l=new LoginPage(driver);
			l.email_TF(p.getPropertyFiledata("emailid"));
			l.password_TF(p.getPropertyFiledata("password"));
			l.LoginButton();
			
			homePage h=new homePage(driver);
			h.CreatePost();
			
			createNews cn = new createNews(driver);
			cn.textContentField(p.getPropertyFiledata("ContentText"));
			cn.UploadVideo("D:\\Upload\\Bird - 46026.mp4");
			cn.UploadVideo("D:\\Upload\\animal.mp4");
			Thread.sleep(3000);
			
			Point tf = cn.getPublicBtn().getLocation();
			 int x = tf.getX();
			 int y=tf.getY();
			driverutilies.scrollbar(driver, x, y);
			cn.PublicButton();
			cn.PublicButton();
			Thread.sleep(1000);
			String expected_Text = "Upload Count : 1";
	 		String actual_Text = driver.findElement(By.xpath("//span[@class='lightTxt headingSM pdngVXS']")).getText();
	 		Assert.assertEquals(expected_Text, actual_Text);
	 		cn.PostButton();
	 		Thread.sleep(2000);
	 		String expected_Text1 = "News Feed";
	 		String actual_Text1 = driver.findElement(By.xpath("//span[@class='mainHdngTxt']")).getText();
	 		Assert.assertEquals(expected_Text1, actual_Text1);
		}
	
	//News Feed
	@Test(priority=2)
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
