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

public class compCreatePostScripts extends BaseClass{
	
	@Test(priority =1,retryAnalyzer = MyRetry.class)
	//UploadImage
	public void UploadText() throws IOException, InterruptedException  {
		LoginPage l=new LoginPage(driver);
		l.email_TF(p.getPropertyFiledata("emailid"));
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
		l.email_TF(p.getPropertyFiledata("emailid"));
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
		l.email_TF(p.getPropertyFiledata("emailid"));
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
		l.email_TF(p.getPropertyFiledata("emailid"));
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
		l.email_TF(p.getPropertyFiledata("emailid"));
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
		cn.PublicButton();
		cn.PublicButton();
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
		l.email_TF(p.getPropertyFiledata("emailid"));
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
//		String expected_Text0 = "Cannot upload more then 20 images";
//		String actual_Text0 = driver.findElement(By.xpath("//div[contains(text(),'Cannot upload more then 20 images')]")).getText();
//		Assert.assertEquals(expected_Text0, actual_Text0);
		Thread.sleep(5000);
		cn.PublicButton();
		cn.PublicButton();
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
	public void public_Employees() throws IOException, InterruptedException {
		LoginPage l=new LoginPage(driver);
		l.email_TF(p.getPropertyFiledata("emailid"));
		l.password_TF(p.getPropertyFiledata("password"));
		l.LoginButton();
		
		homePage h=new homePage(driver);
		h.CreatePost();
		
		createNews cn = new createNews(driver);
		cn.UploadImage(p.getPropertyFiledata("UploadImage2"));
		Point tf = cn.getTextcontentfield().getLocation();
		 int x = tf.getX();
		 int y=tf.getY();
		driverutilies.scrollbar(driver, x, y);
		cn.textContentField("My Employees");
		Thread.sleep(3000);
		Point pblc = cn.getPublicBtn().getLocation();
		 int x1 = pblc.getX();
		 int y1 =pblc.getY();
		driverutilies.scrollbar(driver, x1, y1);
		cn.PublicButton();
		Thread.sleep(500);
		Point status = cn.getStatus().getLocation();
		int x2 =status.getX();
		int y2 =status.getY();
		driverutilies.scrollbar(driver, x2, y2);
		cn.Status();
		
		cn.Status();
		cn.PostButton();
		String expected_Text1 = "News Feed";
 		String actual_Text1 = driver.findElement(By.xpath("//span[@class='mainHdngTxt']")).getText();
 		Assert.assertEquals(expected_Text1, actual_Text1);
	}	
	@Test(priority=9,retryAnalyzer=MyRetry.class)
	public void public_Manaufacturer() throws IOException, InterruptedException {
		LoginPage l=new LoginPage(driver);
		l.email_TF(p.getPropertyFiledata("emailid"));
		l.password_TF(p.getPropertyFiledata("password"));
		l.LoginButton();
		
		homePage h=new homePage(driver);
		h.CreatePost();
		
		createNews cn = new createNews(driver);
		cn.UploadImage(p.getPropertyFiledata("UploadImage3"));
		Point tf = cn.getTextcontentfield().getLocation();
		 int x = tf.getX();
		 int y=tf.getY();
		driverutilies.scrollbar(driver, x, y);
		cn.textContentField("Manufacturer");
		Point pblc = cn.getPublicBtn().getLocation();
		 int x1 = pblc.getX();
		 int y1 =pblc.getY();
		driverutilies.scrollbar(driver, x1, y1);
		cn.PublicButton();
		Thread.sleep(500);
		Point status = cn.getStatus().getLocation();
		int x2 =status.getX();
		int y2 =status.getY();
		driverutilies.scrollbar(driver, x2, y2);
		cn.Status();
		cn.MyEmployees();
		cn.Manufacturer();
		cn.Status();
		cn.PostButton();
		String expected_Text1 = "News Feed";
 		String actual_Text1 = driver.findElement(By.xpath("//span[@class='mainHdngTxt']")).getText();
 		Assert.assertEquals(expected_Text1, actual_Text1);
	}	
	@Test(priority=10)
	public void public_Share_holder() throws IOException, InterruptedException {
		LoginPage l=new LoginPage(driver);
		l.email_TF(p.getPropertyFiledata("emailid"));
		l.password_TF(p.getPropertyFiledata("password"));
		l.LoginButton();
		
		homePage h=new homePage(driver);
		h.CreatePost();
		
		createNews cn = new createNews(driver);
		cn.UploadImage(p.getPropertyFiledata("UploadImage4"));
		Point tf = cn.getTextcontentfield().getLocation();
		 int x = tf.getX();
		 int y=tf.getY();
		driverutilies.scrollbar(driver, x, y);
		cn.textContentField("public_Share_holder");
		Point pblc = cn.getPublicBtn().getLocation();
		 int x1 = pblc.getX();
		 int y1 =pblc.getY();
		driverutilies.scrollbar(driver, x1, y1);
		cn.PublicButton();
		Thread.sleep(500);
		Point status = cn.getStatus().getLocation();
		int x2 =status.getX();
		int y2 =status.getY();
		driverutilies.scrollbar(driver, x2, y2);
		cn.Status();
		
		cn.Share_holder();
		cn.Status();
		cn.PostButton();
		String expected_Text1 = "News Feed";
 		String actual_Text1 = driver.findElement(By.xpath("//span[@class='mainHdngTxt']")).getText();
 		Assert.assertEquals(expected_Text1, actual_Text1);
	}	
	@Test(priority=11,retryAnalyzer = MyRetry.class)
	public void public_Vendor() throws IOException, InterruptedException {
		LoginPage l=new LoginPage(driver);
		l.email_TF(p.getPropertyFiledata("emailid"));
		l.password_TF(p.getPropertyFiledata("password"));
		l.LoginButton();
		
		homePage h=new homePage(driver);
		h.CreatePost();
		
		createNews cn = new createNews(driver);
		cn.UploadImage(p.getPropertyFiledata("UploadImage5"));
		Point tf = cn.getTextcontentfield().getLocation();
		 int x = tf.getX();
		 int y=tf.getY();
		driverutilies.scrollbar(driver, x, y);
		cn.textContentField("public_Vendor");
		Thread.sleep(3000);
		Point pblc = cn.getPublicBtn().getLocation();
		 int x1 = pblc.getX();
		 int y1 =pblc.getY();
		driverutilies.scrollbar(driver, x1, y1);
		cn.PublicButton();
		Thread.sleep(500);
		Point status = cn.getStatus().getLocation();
		int x2 =status.getX();
		int y2 =status.getY();
		driverutilies.scrollbar(driver, x2, y2);
		cn.Status();
		
		cn.Vendor();
		cn.Status();
		cn.PostButton();
		String expected_Text1 = "News Feed";
 		String actual_Text1 = driver.findElement(By.xpath("//span[@class='mainHdngTxt']")).getText();
 		Assert.assertEquals(expected_Text1, actual_Text1);
	}	

	
	  @Test(priority =16,retryAnalyzer = MyRetry.class)
	  public void public_Distribtor() throws IOException,  InterruptedException {
	  LoginPage l=new LoginPage(driver);
	  l.email_TF(p.getPropertyFiledata("emailid"));
	  l.password_TF(p.getPropertyFiledata("password")); l.LoginButton();
	  
	  homePage h=new homePage(driver);
	  h.CreatePost();
	  
	  createNews cn = new createNews(driver);
	  cn.UploadImage(p.getPropertyFiledata("UploadImage6"));
	  Point tf =
	  cn.getTextcontentfield().getLocation();
	  int x = tf.getX();
	  int y=tf.getY();
	  driverutilies.scrollbar(driver, x, y);
	  cn.textContentField("public_Distribtor");
	  Point pblc =
	  cn.getPublicBtn().getLocation();
	  int x1 = pblc.getX();
	  int y1 =pblc.getY();
	  driverutilies.scrollbar(driver, x1, y1);
	  Thread.sleep(3000);
	  cn.PublicButton();
	  Thread.sleep(500);
	  Point status = cn.getStatus().getLocation();
	  int x2 =status.getX();
	  int y2 =status.getY();
	  driverutilies.scrollbar(driver, x2, y2); cn.Status();
	  
	  cn.Distribtor();
	  cn.Status();
	  cn.PostButton(); 
	  String expected_Text1 ="News Feed";
	  String actual_Text1 = driver.findElement(By.xpath("//span[@class='mainHdngTxt']")).getText();
	  Assert.assertEquals(expected_Text1, actual_Text1);
	  }
	 
	@Test(priority=12,retryAnalyzer = MyRetry.class)
	public void public_ALL_Man_Vend_Dist() throws IOException, InterruptedException {
		LoginPage l=new LoginPage(driver);
		l.email_TF(p.getPropertyFiledata("emailid"));
		l.password_TF(p.getPropertyFiledata("password"));
		l.LoginButton();
		
		homePage h=new homePage(driver);
		h.CreatePost();
		
		createNews cn = new createNews(driver);
		cn.UploadImage(p.getPropertyFiledata("UploadImage7"));
		Point tf = cn.getTextcontentfield().getLocation();
		 int x = tf.getX();
		 int y=tf.getY();
		driverutilies.scrollbar(driver, x, y);
		cn.textContentField("public_ALL_Manufacturer_Vendor_Distributors");
		Thread.sleep(3000);
		Point pblc = cn.getPublicBtn().getLocation();
		 int x1 = pblc.getX();
		 int y1 =pblc.getY();
		driverutilies.scrollbar(driver, x1, y1);
		cn.PublicButton();
		Thread.sleep(500);
		Point status = cn.getStatus().getLocation();
		int x2 =status.getX();
		int y2 =status.getY();
		driverutilies.scrollbar(driver, x2, y2);
		cn.Status();
		
		cn.Manufacturer();
		cn.Vendor();
		cn.Distribtor();
		cn.Status();
		cn.PostButton();
		String expected_Text1 = "News Feed";
 		String actual_Text1 = driver.findElement(By.xpath("//span[@class='mainHdngTxt']")).getText();
 		Assert.assertEquals(expected_Text1, actual_Text1);
	}	
	@Test(priority=13,retryAnalyzer = MyRetry.class)
	public void public_ALL_Emp_Part_Share() throws IOException, InterruptedException {
			LoginPage l=new LoginPage(driver);
			l.email_TF(p.getPropertyFiledata("emailid"));
			l.password_TF(p.getPropertyFiledata("password"));
			l.LoginButton();
			
			homePage h=new homePage(driver);
			h.CreatePost();
			
			createNews cn = new createNews(driver);
			cn.UploadImage(p.getPropertyFiledata("UploadImage5"));
			Point tf = cn.getTextcontentfield().getLocation();
			 int x = tf.getX();
			 int y=tf.getY();
			driverutilies.scrollbar(driver, x, y);
			cn.textContentField("public_Vendor");
			Thread.sleep(500);
			Point pblc = cn.getPublicBtn().getLocation();
			 int x1 = pblc.getX();
			 int y1 =pblc.getY();
			driverutilies.scrollbar(driver, x1, y1);
			cn.PublicButton();
			Thread.sleep(500);
			Point status = cn.getStatus().getLocation();
			int x2 =status.getX();
			int y2 =status.getY();
			driverutilies.scrollbar(driver, x2, y2);
			cn.Status();
			
			cn.Partner();
			cn.Share_holder();
			String expected_Text1 = "News Feed";
	 		String actual_Text1 = driver.findElement(By.xpath("//span[@class='mainHdngTxt']")).getText();
	 		Assert.assertEquals(expected_Text1, actual_Text1);
		}	
	@Test(priority=14,retryAnalyzer = MyRetry.class)
	public void Status_archieve() throws IOException, InterruptedException {
		LoginPage l=new LoginPage(driver);
		l.email_TF(p.getPropertyFiledata("emailid"));
		l.password_TF(p.getPropertyFiledata("password"));
		l.LoginButton();
		
		homePage h=new homePage(driver);
		h.CreatePost();
		
		createNews cn = new createNews(driver);
		cn.textContentField("Status archieve");
		cn.UploadImage(p.getPropertyFiledata("UploadImage7"));
		
		Thread.sleep(4000);
		cn.PublicButton();
	
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
	@Test(priority=15,retryAnalyzer = MyRetry.class)
	//UploadImage
			public void UploadImageAndCancel() throws IOException, InterruptedException  {
				LoginPage l=new LoginPage(driver);
				l.email_TF(p.getPropertyFiledata("emailid"));
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
