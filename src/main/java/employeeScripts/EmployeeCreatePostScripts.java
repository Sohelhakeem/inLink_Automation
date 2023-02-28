package employeeScripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericLib.BaseClass;
import pomPages.LoginPage;
import pomPages.createNews;
import pomPages.homePage;

public class EmployeeCreatePostScripts extends BaseClass{
	
	@Test(priority =1,retryAnalyzer = MyRetry.class)
	//UploadImage
	public void UploadText() throws IOException, InterruptedException  {
		LoginPage l=new LoginPage(driver);
		l.email_TF(p.getPropertyFiledata("eemailid"));
		l.password_TF(p.getPropertyFiledata("password"));
		l.LoginButton();
		
		homePage h=new homePage(driver);
		h.CreatePost();
		
		createNews cn = new createNews(driver);
		cn.textContentField("“Being a great place to work is the difference between being a good company and a great company.”" );
		cn.PostButton();
		Thread.sleep(3000);
		String expected_Text1 = "News Feed Created Successfully";
		String actual_Text1 = driver.findElement(By.xpath("//div[contains(text(),'News Feed Created Successfully')]")).getText();
		Assert.assertEquals(expected_Text1, actual_Text1);
	}
	@Test(priority=2,retryAnalyzer = MyRetry.class)
	//UploadImage
	public void UploadImage() throws IOException, InterruptedException  {
		LoginPage l=new LoginPage(driver);
		l.email_TF(p.getPropertyFiledata("eemailid"));
		//l.email_TF("sohelhakeem@gmail.com");
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
	}
	
	@Test(priority=3)
	//UploadVideo
	public void UploadVideo() throws IOException, InterruptedException {
		LoginPage l=new LoginPage(driver);
		l.email_TF(p.getPropertyFiledata("eemailid"));
		l.password_TF(p.getPropertyFiledata("password"));
		l.LoginButton();
		
		homePage h=new homePage(driver);
		h.CreatePost();
		
		createNews cn = new createNews(driver);
		cn.UploadVideo(p.getPropertyFiledata("UploadVideo"));
		Point tf = cn.getTextcontentfield().getLocation();
		 int x = tf.getX();
		 int y=tf.getY();
		driverutilies.scrollbar(driver, x, y);
		cn.textContentField(p.getPropertyFiledata("ContentText"));
		cn.PostButton();
		Thread.sleep(3000);
		String expected_Text1 = "News Feed Created Successfully";
 		String actual_Text1 = driver.findElement(By.xpath("//div[contains(text(),'News Feed Created Successfully')]")).getText();
 		Assert.assertEquals(expected_Text1, actual_Text1);
	}
	
	@Test(priority=4,retryAnalyzer = MyRetry.class)
	public void Upload_youtube_Url() throws IOException, InterruptedException {
		LoginPage l=new LoginPage(driver);
		l.email_TF(p.getPropertyFiledata("eemailid"));
		l.password_TF(p.getPropertyFiledata("password"));
		l.LoginButton();
		homePage h=new homePage(driver);
		h.CreatePost();
		
		createNews cn = new createNews(driver);
		cn.textContentField(p.getPropertyFiledata("ContentText"));
		cn.YoutubeUrlIcon();
		cn.youTubeUrl(p.getPropertyFiledata("youTubeUrl"));
		cn.DoneButton();
		cn.PostButton();
		Thread.sleep(2000); 
		String expected_Text1 = "News Feed Created Successfully";
 		String actual_Text1 = driver.findElement(By.xpath("//div[contains(text(),'News Feed Created Successfully')]")).getText();
 		Assert.assertEquals(expected_Text1, actual_Text1);
	}
	@Test(priority=5,retryAnalyzer = MyRetry.class)
	//Upload 5 Images
	public void upload_Five_Images() throws IOException, InterruptedException  {
		LoginPage l=new LoginPage(driver);
		l.email_TF(p.getPropertyFiledata("eemailid"));
		//l.email_TF("sohelhakeem@gmail.com");
		l.password_TF(p.getPropertyFiledata("password"));
		l.LoginButton();
		
		homePage h=new homePage(driver);
		h.CreatePost();
		
		createNews cn = new createNews(driver);
		cn.textContentField("uploaded 5 Images");
		
		cn.UploadImage(p.getPropertyFiledata("UploadImage"));
		Thread.sleep(500);
		cn.UploadImage(p.getPropertyFiledata("UploadImage2"));
		Thread.sleep(500);
		cn.UploadImage(p.getPropertyFiledata("UploadImage3"));
		Thread.sleep(500);
		cn.UploadImage(p.getPropertyFiledata("UploadImage4"));
		Thread.sleep(500);
		cn.UploadImage(p.getPropertyFiledata("UploadImage5"));
		Thread.sleep(5000);
		Point status = cn.getStatus().getLocation();
		int x2 =status.getX();
		int y2 =status.getY();
		driverutilies.scrollbar(driver, x2, y2);
		cn.Status();
		cn.Status();
		Thread.sleep(1000);
		String expected_Text = "Upload Count : 5";
		String actual_Text = driver.findElement(By.xpath("//span[@class='lightTxt headingSM pdngVXS']")).getText();
		Assert.assertEquals(expected_Text, actual_Text);
		cn.PostButton();
		Thread.sleep(2000);
		String expected_Text1 = "News Feed";
		String actual_Text1 = driver.findElement(By.xpath("//span[@class='mainHdngTxt']")).getText();
		Assert.assertEquals(expected_Text1, actual_Text1);
 		
	}
	
	@Test(priority=6,retryAnalyzer=MyRetry.class)
	public void upload_FivePlus_Images() throws IOException, InterruptedException  {
		LoginPage l=new LoginPage(driver);
		l.email_TF(p.getPropertyFiledata("eemailid"));
		//l.email_TF("sohelhakeem@gmail.com");
		l.password_TF(p.getPropertyFiledata("password"));
		l.LoginButton();
		
		homePage h=new homePage(driver);
		h.CreatePost();
		
		createNews cn = new createNews(driver);
		cn.textContentField("uploading more than 5 image");
		cn.UploadImage(p.getPropertyFiledata("UploadImage4"));
		Thread.sleep(500);
		cn.UploadImage(p.getPropertyFiledata("UploadImage"));
		Thread.sleep(500);
		cn.UploadImage(p.getPropertyFiledata("UploadImage2"));
		Thread.sleep(500);
		cn.UploadImage(p.getPropertyFiledata("UploadImage3"));
		Thread.sleep(500);
		cn.UploadImage(p.getPropertyFiledata("UploadImage4"));
		Thread.sleep(500);
		cn.UploadImage(p.getPropertyFiledata("UploadImage5"));
		Thread.sleep(500);
		String expected_Text0 = "Cannot upload more then 5 Images";
		String actual_Text0 = driver.findElement(By.xpath("//div[contains(text(),'Cannot upload more then 5 Images')]")).getText();
		Assert.assertEquals(expected_Text0, actual_Text0);
		Point status = cn.getStatus().getLocation();
		int x2 =status.getX();
		int y2 =status.getY();
		driverutilies.scrollbar(driver, x2, y2);
		cn.Status();
		cn.Status();
		Thread.sleep(1000);
		String expected_Text = "Upload Count : 5";
		
		String actual_Text = driver.findElement(By.xpath("//span[@class='lightTxt headingSM pdngVXS']")).getText();
		Assert.assertEquals(expected_Text, actual_Text);
		cn.PostButton();
		Thread.sleep(2000);
		String expected_Text1 = "News Feed";
		String actual_Text1 = driver.findElement(By.xpath("//span[@class='mainHdngTxt']")).getText();
		Assert.assertEquals(expected_Text1, actual_Text1);
 		
	}
	@Test(priority=8)
	public void Status_archieve() throws IOException, InterruptedException {
		LoginPage l=new LoginPage(driver);
		l.email_TF(p.getPropertyFiledata("eemailid"));
		l.password_TF(p.getPropertyFiledata("password"));
		l.LoginButton();
		
		homePage h=new homePage(driver);
		h.CreatePost();
		
		createNews cn = new createNews(driver);
		cn.textContentField("Status Archived");
		cn.UploadImage(p.getPropertyFiledata("UploadImage"));
		Thread.sleep(1000);
		Point status = cn.getStatus().getLocation();
		int x2 =status.getX();
		int y2 =status.getY();
		driverutilies.scrollbar(driver, x2, y2);
		cn.Status();
		
		Thread.sleep(1000);
		cn.PostButton();
		Thread.sleep(2000); 
		String expected_Text1 = "News Feed Created Successfully";
 		String actual_Text1 = driver.findElement(By.xpath("//div[contains(text(),'News Feed Created Successfully')]")).getText();
 		Assert.assertEquals(expected_Text1, actual_Text1);
	}	
	
	@Test(priority=9,retryAnalyzer = MyRetry.class)
	//UploadImage
			public void UploadImageAndCancel() throws IOException, InterruptedException  {
				LoginPage l=new LoginPage(driver);
				l.email_TF(p.getPropertyFiledata("eemailid"));
				l.password_TF(p.getPropertyFiledata("password"));
				l.LoginButton();
				
				homePage h=new homePage(driver);
				h.CreatePost();
				
				createNews cn = new createNews(driver);
				cn.textContentField("uploading");
				cn.UploadImage(p.getPropertyFiledata("UploadImage"));
				Thread.sleep(2000);
		 		cn.Cancel_Button();
		 		String expected_Text1 = "News Feed";
		 		String actual_Text1 = driver.findElement(By.xpath("//span[@class='mainHdngTxt']")).getText();
		 		Assert.assertEquals(expected_Text1, actual_Text1);
			}
}
