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

public class NewsFeed_Home extends BaseClass {
	@Test(priority=1,retryAnalyzer = MyRetry.class)
	//Edit the posted feed.
	public void Edit_Post() throws IOException, InterruptedException  {
		LoginPage l=new LoginPage(driver);
		l.email_TF(p.getPropertyFiledata("emailid"));
		l.password_TF(p.getPropertyFiledata("password"));
		l.LoginButton();
		
		homePage h=new homePage(driver);
		h.CreatePost();
		
		createNews cn = new createNews(driver);
		cn.textContentField("Updating documents");
		cn.UploadImage(p.getPropertyFiledata("UploadImage2"));
		Thread.sleep(500);
		cn.PostButton();
		Thread.sleep(2000);
		String expected_Text1 = "News Feed Created Successfully";
		String actual_Text1 = driver.findElement(By.xpath("//div[contains(text(),'News Feed Created Successfully')]")).getText();
		Assert.assertEquals(expected_Text1, actual_Text1);
		Thread.sleep(1000);
		
		h.ThreeDots();
		h.EditIcon();
		cn.CleartextContentField();
		cn.textContentField("Edited text");
		cn.UploadImage(p.getPropertyFiledata("UploadImage"));
		Thread.sleep(500);
		cn.PostButton();
	}
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
	@Test(priority=3,retryAnalyzer = MyRetry.class)
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
	
	@Test(priority=4)
	//UploadnewsFeed and add to BookMark.
	public void Add_to_bookmark() throws IOException, InterruptedException  {
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
		Thread.sleep(500);
		h.BookmarkIcon();
		Thread.sleep(2000);
		String expected_Text2 = "NewsFeed Bookmarked Successfully";
		String actual_Text2 = driver.findElement(By.xpath("//div[contains(text(),'NewsFeed Bookmarked Successfully')]")).getText();
		Assert.assertEquals(expected_Text2, actual_Text2);
		
	}
	@Test(priority=5)
	public void searchFeedwithCompany() throws IOException, InterruptedException  {
		LoginPage l=new LoginPage(driver);
		l.email_TF(p.getPropertyFiledata("emailid"));
		l.password_TF(p.getPropertyFiledata("password"));
		l.LoginButton();
		
		homePage h=new homePage(driver);
		Thread.sleep(7000);
		h.SearchFeedField("four");
		Thread.sleep(3000);
	}
//	@Test(priority=6)
//	public void SearchFeedFilter_Archieve() throws IOException, InterruptedException  {
//		LoginPage l=new LoginPage(driver);
//		l.email_TF(p.getPropertyFiledata("emailid"));
//		l.password_TF(p.getPropertyFiledata("password"));
//		l.LoginButton();
//		
//		homePage h=new homePage(driver);
//		h.Threedotsfilter();
//		h.FilterButton();
//		h.ArchivedCheckbox();
//		h.ApplyButton();
//		String expected_Text1 = "Archieved News";
//		String actual_Text1 = driver.findElement(By.xpath("//span[@class='lightTxt headingSM']")).getText();
//		Assert.assertEquals(expected_Text1, actual_Text1);
//		Thread.sleep(1000);
//	}
	@Test(priority=7)
	public void SearchFeedFilter_All() throws IOException, InterruptedException  {
		LoginPage l=new LoginPage(driver);
		l.email_TF(p.getPropertyFiledata("emailid"));
		l.password_TF(p.getPropertyFiledata("password"));
		l.LoginButton();
		
		homePage h=new homePage(driver);
		h.Threedotsfilter();
		h.FilterButton();
		h.AllCheckbox();
		h.ApplyButton();
		String expected_Text1 = "News Feed";
 		String actual_Text1 = driver.findElement(By.xpath("//span[@class='mainHdngTxt']")).getText();
 		Assert.assertEquals(expected_Text1, actual_Text1);
	}
	@Test(priority=8)
	public void SearchFeedFilter_SelfPost() throws IOException, InterruptedException  {
		LoginPage l=new LoginPage(driver);
		l.email_TF(p.getPropertyFiledata("emailid"));
		l.password_TF(p.getPropertyFiledata("password"));
		l.LoginButton();
		
		homePage h=new homePage(driver);
		h.Threedotsfilter();
		h.FilterButton();
		h.SelfPostCheckbox();
		h.ApplyButton();
		String expected_Text1 = "News Feed";
 		String actual_Text1 = driver.findElement(By.xpath("//span[@class='mainHdngTxt']")).getText();
 		Assert.assertEquals(expected_Text1, actual_Text1);
	}
	@Test(priority=9)
	public void SearchFeedFilter_Compitators() throws IOException, InterruptedException  {
		LoginPage l=new LoginPage(driver);
		l.email_TF(p.getPropertyFiledata("emailid"));
		l.password_TF(p.getPropertyFiledata("password"));
		l.LoginButton();
		
		homePage h=new homePage(driver);
		h.Threedotsfilter();
		h.FilterButton();
		h.Compitators();
		h.ApplyButton();
		String expected_Text1 = "News Feed";
 		String actual_Text1 = driver.findElement(By.xpath("//span[@class='mainHdngTxt']")).getText();
 		Assert.assertEquals(expected_Text1, actual_Text1);
	}
	@Test(priority=10)
	public void SearchFeedFilter_IndustrialRelationship() throws IOException, InterruptedException  {
		LoginPage l=new LoginPage(driver);
		l.email_TF(p.getPropertyFiledata("emailid"));
		l.password_TF(p.getPropertyFiledata("password"));
		l.LoginButton();
		
		homePage h=new homePage(driver);
		h.Threedotsfilter();
		h.FilterButton();
		h.IndustrialRelationship();
		h.ApplyButton();
		String expected_Text1 = "News Feed";
 		String actual_Text1 = driver.findElement(By.xpath("//span[@class='mainHdngTxt']")).getText();
 		Assert.assertEquals(expected_Text1, actual_Text1);
	}

	/*
	 * @Test public void SearchFeedFilter_Manufacturer() throws IOException,
	 * InterruptedException { LoginPage l=new LoginPage(driver);
	 * l.email_TF(p.getPropertyFiledata("emailid"));
	 * l.password_TF(p.getPropertyFiledata("password")); l.LoginButton();
	 * 
	 * homePage h=new homePage(driver); h.FilterButton(); h.Manufacturer();
	 * h.ApplyButton(); String expected_Text1 = "News Feed"; String actual_Text1 =
	 * driver.findElement(By.xpath("//span[@class='mainHdngTxt']")).getText();
	 * Assert.assertEquals(expected_Text1, actual_Text1); }
	 */
	@Test(priority=11)
	public void SearchFeedFilter_Partner() throws IOException, InterruptedException  {
		LoginPage l=new LoginPage(driver);
		l.email_TF(p.getPropertyFiledata("emailid"));
		l.password_TF(p.getPropertyFiledata("password"));
		l.LoginButton();
		
		homePage h=new homePage(driver);
		h.Threedotsfilter();
		h.FilterButton();
		h.PartnerCheckbox();
		h.ApplyButton();
		String expected_Text1 = "News Feed";
 		String actual_Text1 = driver.findElement(By.xpath("//span[@class='mainHdngTxt']")).getText();
 		Assert.assertEquals(expected_Text1, actual_Text1);
	}
	@Test(priority=12)
	public void SearchFeedFilter_ShareHolder() throws IOException, InterruptedException  {
		LoginPage l=new LoginPage(driver);
		l.email_TF(p.getPropertyFiledata("emailid"));
		l.password_TF(p.getPropertyFiledata("password"));
		l.LoginButton();
		
		homePage h=new homePage(driver);
		h.Threedotsfilter();
		h.FilterButton();
		h.ShareHolderCheckbox();
		h.ApplyButton();
		String expected_Text1 = "News Feed";
 		String actual_Text1 = driver.findElement(By.xpath("//span[@class='mainHdngTxt']")).getText();
 		Assert.assertEquals(expected_Text1, actual_Text1);
	}
	@Test(priority=13)
	//UploadnewsFeed and add to BookMark open the bookmarked post Like and Unlike the post.
		public void BookmaarkPost_Like() throws IOException, InterruptedException  {
			LoginPage l=new LoginPage(driver);
			l.email_TF(p.getPropertyFiledata("emailid"));
			l.password_TF(p.getPropertyFiledata("password"));
			l.LoginButton();
			
			homePage h=new homePage(driver);
			h.CreatePost();
			
			createNews cn = new createNews(driver);
			cn.textContentField("Like The Bookmarked Post");
			cn.UploadImage(p.getPropertyFiledata("UploadImage5"));
			Thread.sleep(2000);
			cn.PostButton();
			Thread.sleep(2000);
			String expected_Text1 = "News Feed Created Successfully";
			String actual_Text1 = driver.findElement(By.xpath("//div[contains(text(),'News Feed Created Successfully')]")).getText();
			Assert.assertEquals(expected_Text1, actual_Text1);
			Thread.sleep(1000);
			
			h.ThreeDots();
			Thread.sleep(500);
			h.BookmarkIcon();
			Thread.sleep(2000);
			String expected_Text2 = "NewsFeed Bookmarked Successfully";
			String actual_Text2 = driver.findElement(By.xpath("//div[contains(text(),'NewsFeed Bookmarked Successfully')]")).getText();
			Assert.assertEquals(expected_Text2, actual_Text2);
			Thread.sleep(3000);
			h.ExploreBookmark();
			//scroll up to load more
			
						JavascriptExecutor js = (JavascriptExecutor)driver;
						WebElement LikeBookmark = driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[5]/div[1]/div[1]"));

						js.executeScript("arguments[0].scrollIntoView(true);", LikeBookmark);
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						js.executeScript("arguments[0].click();", LikeBookmark);
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						Thread.sleep(2000);
						String expected_Text3 = "You liked the post";
						String actual_Text3 = driver.findElement(By.xpath("//div[contains(text(),'You liked the post')]")).getText();
						Assert.assertEquals(expected_Text3, actual_Text3);
						js.executeScript("arguments[0].click();", LikeBookmark);
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						Thread.sleep(2000);
						String expected_Text4 = "You unliked the post";
						String actual_Text4 = driver.findElement(By.xpath("//div[contains(text(),'You unliked the post')]")).getText();
						Assert.assertEquals(expected_Text4, actual_Text4);
		}
	@Test(priority=14,retryAnalyzer=MyRetry.class)
	//UploadnewsFeed and add to BookMark open the bookmarked post Like and Unlike the post Comment and reply.
			public void BookmaarkPost_Comment() throws IOException, InterruptedException  {
				LoginPage l=new LoginPage(driver);
				l.email_TF(p.getPropertyFiledata("emailid"));
				l.password_TF(p.getPropertyFiledata("password"));
				l.LoginButton();
				
				homePage h=new homePage(driver);
				h.CreatePost();
				
				createNews cn = new createNews(driver);
				cn.textContentField("Comment and reply Bookmarked Post");
				cn.UploadImage(p.getPropertyFiledata("UploadImage2"));
				Thread.sleep(2000);
				cn.PostButton();
				Thread.sleep(2000);
				String expected_Text1 = "News Feed Created Successfully";
				String actual_Text1 = driver.findElement(By.xpath("//div[contains(text(),'News Feed Created Successfully')]")).getText();
				Assert.assertEquals(expected_Text1, actual_Text1);
				Thread.sleep(1000);
				
				h.ThreeDots();
				Thread.sleep(500);
				h.BookmarkIcon();
				Thread.sleep(2000);
				String expected_Text2 = "NewsFeed Bookmarked Successfully";
				String actual_Text2 = driver.findElement(By.xpath("//div[contains(text(),'NewsFeed Bookmarked Successfully')]")).getText();
				Assert.assertEquals(expected_Text2, actual_Text2);
				Thread.sleep(3000);
				h.ExploreBookmark();
				//scroll up to load more
				
							JavascriptExecutor js = (JavascriptExecutor)driver;
							WebElement LikeBookmark = driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[5]/div[1]/div[1]"));

							js.executeScript("arguments[0].scrollIntoView(true);", LikeBookmark);
							driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
							js.executeScript("arguments[0].click();", LikeBookmark);
							driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
							Thread.sleep(2000);
							String expected_Text3 = "You liked the post";
							String actual_Text3 = driver.findElement(By.xpath("//div[contains(text(),'You liked the post')]")).getText();
							Assert.assertEquals(expected_Text3, actual_Text3);
							js.executeScript("arguments[0].click();", LikeBookmark);
							driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
							Thread.sleep(2000);
							String expected_Text4 = "You unliked the post";
							String actual_Text4 = driver.findElement(By.xpath("//div[contains(text(),'You unliked the post')]")).getText();
							Assert.assertEquals(expected_Text4, actual_Text4);
							
							WebElement CommentBookmark = driver.findElement(By.xpath("//body//div[@id='root']//div[@class='flexCol']//div[@class='flexCol']//div[1]//div[1]//div[5]//div[2]//div[1]//span[1]"));
							
							js.executeScript("arguments[0].scrollIntoView(true);", CommentBookmark);
							driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
							js.executeScript("arguments[0].click();", CommentBookmark);
							driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
							Thread.sleep(2000);
							WebElement CommentFieldBookmark = driver.findElement(By.xpath("//textarea[@id='outlined-basic']"));
							CommentFieldBookmark.sendKeys("Congratulatons");
							WebElement sendIcon = driver.findElement(By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium blueTxt css-1m44q5']"));
							sendIcon.click();
							
							WebElement ReplyComment = driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[7]/div[2]/div[1]/div[1]/div[2]/span[2]/span[1]"));
							ReplyComment.click();
							
							WebElement ReplyCommentTxt = driver.findElement(By.xpath("//textarea[@id='outlined-adornment-weight']"));
							ReplyCommentTxt.sendKeys("Thank You");
							Thread.sleep(4000);
							WebElement ReplyCommentTxtsend = driver.findElement(By.xpath("//div[@class='MuiInputAdornment-root MuiInputAdornment-positionEnd MuiInputAdornment-outlined MuiInputAdornment-sizeMedium pointer css-1nvf7g0']//*[name()='svg']"));
							ReplyCommentTxtsend.click();
							
			}
	@Test(priority=15)
	//UploadnewsFeed and add to BookMark open the bookmarked post Like and Unlike the post and share Post.
		public void BookmaarkPost_share() throws IOException, InterruptedException  {
			LoginPage l=new LoginPage(driver);
			l.email_TF(p.getPropertyFiledata("emailid"));
			l.password_TF(p.getPropertyFiledata("password"));
			l.LoginButton();
			
			homePage h=new homePage(driver);
			h.CreatePost();
			
			createNews cn = new createNews(driver);
			cn.textContentField("Like And Share the Bookmarked Post");
			cn.UploadImage(p.getPropertyFiledata("UploadImage"));
			Thread.sleep(3000);
			cn.PostButton();
			Thread.sleep(2000);
			String expected_Text1 = "News Feed Created Successfully";
			String actual_Text1 = driver.findElement(By.xpath("//div[contains(text(),'News Feed Created Successfully')]")).getText();
			Assert.assertEquals(expected_Text1, actual_Text1);
			Thread.sleep(1000);
			
			h.ThreeDots();
			Thread.sleep(500);
			h.BookmarkIcon();
			Thread.sleep(2000);
			String expected_Text2 = "NewsFeed Bookmarked Successfully";
			String actual_Text2 = driver.findElement(By.xpath("//div[contains(text(),'NewsFeed Bookmarked Successfully')]")).getText();
			Assert.assertEquals(expected_Text2, actual_Text2);
			Thread.sleep(3000);
			h.ExploreBookmark();
			//scroll up to load more
			
						JavascriptExecutor js = (JavascriptExecutor)driver;
						WebElement LikeBookmark = driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[5]/div[1]/div[1]"));

						js.executeScript("arguments[0].scrollIntoView(true);", LikeBookmark);
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						js.executeScript("arguments[0].click();", LikeBookmark);
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						Thread.sleep(2000);
						String expected_Text3 = "You liked the post";
						String actual_Text3 = driver.findElement(By.xpath("//div[contains(text(),'You liked the post')]")).getText();
						Assert.assertEquals(expected_Text3, actual_Text3);
						Thread.sleep(2000);
						
						WebElement ShareBookmark = driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[6]/div[3]/div[1]/span[1]"));
						
						js.executeScript("arguments[0].scrollIntoView(true);", ShareBookmark);
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						js.executeScript("arguments[0].click();", ShareBookmark);
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						Thread.sleep(2000);
						WebElement CopyLink = driver.findElement(By.xpath("//button[normalize-space()='Copy']"));
						CopyLink.click();
						Thread.sleep(2000);
						String expected_Text5 = "Copied Successfully";
						String actual_Text5 = driver.findElement(By.xpath("//div[contains(text(),'Copied Successfully')]")).getText();
						Assert.assertEquals(expected_Text5, actual_Text5);
		}
	@Test(priority=16)
	//Scroll Down The homePage Feed Until Load More Text display and Click on It.
		public void ScrollFeedUntilLoadmore() throws IOException, InterruptedException  {
			LoginPage l=new LoginPage(driver);
			l.email_TF(p.getPropertyFiledata("emailid"));
			l.password_TF(p.getPropertyFiledata("password"));
			l.LoginButton();
			Thread.sleep(1000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement LoadMore = driver.findElement(By.xpath("//button[normalize-space()='Load More']"));
			js.executeScript("arguments[0].scrollIntoView(true);", LoadMore);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			js.executeScript("arguments[0].click();", LoadMore);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Thread.sleep(2000);
		}
	@Test(priority=17)
	//Like and Share the feed Post.
			public void LikeAndShareFeedPost() throws IOException, InterruptedException  {
				LoginPage l=new LoginPage(driver);
				l.email_TF(p.getPropertyFiledata("emailid"));
				l.password_TF(p.getPropertyFiledata("password"));
				l.LoginButton();
				
				homePage h=new homePage(driver);
				h.CreatePost();
				
				createNews cn = new createNews(driver);
				cn.textContentField("Like, Comment and share the post in feed");
				cn.UploadImage(p.getPropertyFiledata("UploadImage5"));
				Thread.sleep(2000);
				cn.PostButton();
				Thread.sleep(3000);
				String expected_Text1 = "News Feed Created Successfully";
				String actual_Text1 = driver.findElement(By.xpath("//div[contains(text(),'News Feed Created Successfully')]")).getText();
				Assert.assertEquals(expected_Text1, actual_Text1);
				Thread.sleep(1000);
				JavascriptExecutor js = (JavascriptExecutor)driver;
				WebElement LikeBookmark = driver.findElement(By.xpath("(//span[@class='pdngHXS pointer'])[1]"));

				js.executeScript("arguments[0].scrollIntoView(true);", LikeBookmark);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				js.executeScript("arguments[0].click();", LikeBookmark);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				Thread.sleep(2000);
				String expected_Text3 = "You liked the post";
				String actual_Text3 = driver.findElement(By.xpath("//div[contains(text(),'You liked the post')]")).getText();
				Assert.assertEquals(expected_Text3, actual_Text3);
				
				WebElement Comment = driver.findElement(By.xpath("(//span[contains(text(),'Comment')])[2]"));
				
				js.executeScript("arguments[0].scrollIntoView(true);", Comment);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				js.executeScript("arguments[0].click();", Comment);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				Thread.sleep(2000);
				WebElement CommentField = driver.findElement(By.xpath("//textarea[@id='outlined-basic']"));
				CommentField.sendKeys("Congratulatons");
				WebElement sendIcon = driver.findElement(By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium blueTxt css-1m44q5']"));
				sendIcon.click();
				
				WebElement ReplyComment = driver.findElement(By.xpath("(//span[contains(text(),'Reply')])[1]"));
				ReplyComment.click();
				
				WebElement ReplyCommentTxt = driver.findElement(By.xpath("//textarea[@id='outlined-adornment-weight']"));
				ReplyCommentTxt.sendKeys("Thank You");
				
				WebElement ReplyCommentTxtsend = driver.findElement(By.xpath("//div[@class='MuiInputAdornment-root MuiInputAdornment-positionEnd MuiInputAdornment-outlined MuiInputAdornment-sizeMedium pointer css-1nvf7g0']//*[name()='svg']"));
				ReplyCommentTxtsend.click();
				
				WebElement CloseComment = driver.findElement(By.xpath("//div[@class='flexAutoRow pdngHSM pointer']"));
				CloseComment.click();
				
				String expected_Text = "News Feed";
		 		String actual_Text = driver.findElement(By.xpath("//span[@class='mainHdngTxt']")).getText();
		 		Assert.assertEquals(expected_Text, actual_Text);
				
		 		WebElement Share = driver.findElement(By.xpath("//div[@class='flexRow aligContentEnd justifyEnd']"));
				
				js.executeScript("arguments[0].scrollIntoView(true);", Share);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				js.executeScript("arguments[0].click();", Share);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				Thread.sleep(2000);
				WebElement CopyLink = driver.findElement(By.xpath("//button[normalize-space()='Copy']"));
				CopyLink.click();
				Thread.sleep(1000);
				String expected_Text5 = "Copied Successfully";
				String actual_Text5 = driver.findElement(By.xpath("//div[contains(text(),'Copied Successfully')]")).getText();
				Assert.assertEquals(expected_Text5, actual_Text5);
				driver.findElement(By.xpath("//*[name()='path' and contains(@fill-rule,'evenodd')]")).click();
				Thread.sleep(500);
				WebElement CloseShare = driver.findElement(By.xpath("//div[@class='flexAutoRow pdngHSM pointer']//*[name()='svg']"));
				CloseShare.click();
				
				String expected_Text2 = "News Feed";
		 		String actual_Text2 = driver.findElement(By.xpath("//span[@class='mainHdngTxt']")).getText();
		 		Assert.assertEquals(expected_Text2, actual_Text2);
				
			}
	@Test(priority=18)
	//Play posted video and pause and also Like The video.
		public void Play_Posted_Video() throws IOException, InterruptedException {
			LoginPage l=new LoginPage(driver);
			l.email_TF(p.getPropertyFiledata("emailid"));
			l.password_TF(p.getPropertyFiledata("password"));
			l.LoginButton();
			
			homePage h=new homePage(driver);
			h.CreatePost();
			
			createNews cn = new createNews(driver);
			cn.textContentField("Upload Video");
			cn.UploadVideo(p.getPropertyFiledata("UploadVideo"));
			Thread.sleep(2000);
			cn.PostButton();
			Thread.sleep(3000);
			String expected_Text1 = "News Feed Created Successfully";
	 		String actual_Text1 = driver.findElement(By.xpath("//div[contains(text(),'News Feed Created Successfully')]")).getText();
	 		Assert.assertEquals(expected_Text1, actual_Text1);
	 		
	 		driver.findElement(By.xpath("//div[@class='reactPlayerWidth']//video")).click();
	 		driver.findElement(By.xpath("//div[@class='imageCntnr aspectRatio16x9']//video")).click();
	 		Thread.sleep(6000);
	 		driver.findElement(By.xpath("//div[@class='imageCntnr aspectRatio16x9']//video")).click();
	 		//Like
	 		driver.findElement(By.xpath("//div[@class='flexMinWidthRow pdngHXS']//span[@class='pdngHXS pointer'][normalize-space()='Like']")).click();
	 		Thread.sleep(1000);
	 		String expected_Text3 = "You liked the post";
			String actual_Text3 = driver.findElement(By.xpath("//div[contains(text(),'You liked the post')]")).getText();
			Assert.assertEquals(expected_Text3, actual_Text3);
	 		//close
	 		driver.findElement(By.xpath("//button[@class='flexInline slidePostBtns slideCloseBtn alignCntr justifyCntr']")).click();
	 		String expected_Text2 = "News Feed";
	 		String actual_Text2 = driver.findElement(By.xpath("//span[@class='mainHdngTxt']")).getText();
	 		Assert.assertEquals(expected_Text2, actual_Text2);
	 		
	}
}
