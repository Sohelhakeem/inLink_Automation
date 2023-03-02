package CompanyScripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericLib.BaseClass;
import pomPages.LoginPage;
import pomPages.NetworksPage;

public class compNetworks extends BaseClass {
	@Test(priority=7)
	public void CompanyProfile() throws IOException, InterruptedException {
		LoginPage l = new LoginPage(driver);
		l.email_TF(p.getPropertyFiledata("emailid"));
		l.password_TF(p.getPropertyFiledata("password"));
		l.LoginButton();
		NetworksPage n = new NetworksPage (driver);
		n.Networks();
		String expectedTitle = "Networks";
		String actualTitle = driver.findElement(By.xpath("//span[@class='mainHdngTxt']")).getText();
		Assert.assertEquals(expectedTitle, actualTitle);
		Thread.sleep(2000);
	    n.SearchFieldNetwork(p.getPropertyFiledata("searchNetworkCompany"));
	    driver.findElement(By.xpath("(//div[@class='flexMinWidthRow pdngXS'])[1]")).click();
	    Thread.sleep(500);
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	   WebElement scroll = driver.findElement(By.xpath("//h4[normalize-space()='Certification']"));
	   js.executeScript("arguments[0].scrollIntoView(true);", scroll);
	   Thread.sleep(500);
	    scroll.click();
	    String expTitle = "Certification";
	   String actTitle = driver.findElement(By.xpath("//h4[normalize-space()='Certification']")).getText();
	   Assert.assertEquals(expTitle, actTitle);
			   
	}
	@Test(priority=0)
	public void networksPage() throws IOException {
		LoginPage l = new LoginPage(driver);
		l.email_TF(p.getPropertyFiledata("emailid"));
		l.password_TF(p.getPropertyFiledata("password"));
		l.LoginButton();
		NetworksPage n = new NetworksPage (driver);
		n.Networks();
		String expectedTitle = "Networks";
		String actualTitle = driver.findElement(By.xpath("//span[@class='mainHdngTxt']")).getText();
		Assert.assertEquals(expectedTitle, actualTitle);
	}
	@Test(priority=1)
	public void nPendingFeature() throws IOException {
		LoginPage l = new LoginPage(driver);
		l.email_TF(p.getPropertyFiledata("emailid"));
		l.password_TF(p.getPropertyFiledata("password"));
		l.LoginButton();
		NetworksPage n = new NetworksPage (driver);
		n.Networks();
		n.Pending();
		String expectedTitle = "Networks";
		String actualTitle = driver.findElement(By.xpath("//span[@class='mainHdngTxt']")).getText();
		Assert.assertEquals(expectedTitle, actualTitle);
	}
	@Test(priority=2)
	public void nFollowFeature() throws IOException {
		LoginPage l = new LoginPage(driver);
		l.email_TF(p.getPropertyFiledata("emailid"));
		l.password_TF(p.getPropertyFiledata("password"));
		l.LoginButton();
		NetworksPage n = new NetworksPage (driver);
		n.Networks();
		n.Follow();
		String expectedTitle = "Networks";
		String actualTitle = driver.findElement(By.xpath("//span[@class='mainHdngTxt']")).getText();
		Assert.assertEquals(expectedTitle, actualTitle);
	}
	@Test(priority=3)
	public void nBlockList() throws IOException {
		LoginPage l = new LoginPage(driver);
		l.email_TF(p.getPropertyFiledata("emailid"));
		l.password_TF(p.getPropertyFiledata("password"));
		l.LoginButton();
		NetworksPage n = new NetworksPage (driver);
		n.Networks();
		n.BlockList();
		String expectedTitle = "Networks";
		String actualTitle = driver.findElement(By.xpath("//span[@class='mainHdngTxt']")).getText();
		Assert.assertEquals(expectedTitle, actualTitle);
	}
	@Test(priority=4)
	public void All_RelationsFilter() throws IOException {
		LoginPage l = new LoginPage(driver);
		l.email_TF(p.getPropertyFiledata("emailid"));
		l.password_TF(p.getPropertyFiledata("password"));
		l.LoginButton();
		NetworksPage n = new NetworksPage (driver);
		n.Networks();
		n.RelationsFilter();
		n.All();
		n.All();
		n.ApplyButton();
		String expectedTitle = "Networks";
		String actualTitle = driver.findElement(By.xpath("//span[@class='mainHdngTxt']")).getText();
		Assert.assertEquals(expectedTitle, actualTitle);
	}
	@Test(priority=5)
	public void HumanResorseOf_RelationsFilter() throws IOException {
		LoginPage l = new LoginPage(driver);
		l.email_TF(p.getPropertyFiledata("emailid"));
		l.password_TF(p.getPropertyFiledata("password"));
		l.LoginButton();
		NetworksPage n = new NetworksPage (driver);
		n.Networks();
		n.RelationsFilter();
		n.All();
		n.HumanResourseOf();
		n.ApplyButton();
		String expectedTitle = "Networks";
		String actualTitle = driver.findElement(By.xpath("//span[@class='mainHdngTxt']")).getText();
		Assert.assertEquals(expectedTitle, actualTitle);
	}
	@Test(priority=6)
	public void partenerOF_RelationsFilter() throws IOException {
		LoginPage l = new LoginPage(driver);
		l.email_TF(p.getPropertyFiledata("emailid"));
		l.password_TF(p.getPropertyFiledata("password"));
		l.LoginButton();
		NetworksPage n = new NetworksPage (driver);
		n.Networks();
		n.RelationsFilter();
		n.All();
		n.PartnerOf();
		n.ApplyButton();
		String expectedTitle = "Networks";
		String actualTitle = driver.findElement(By.xpath("//span[@class='mainHdngTxt']")).getText();
		Assert.assertEquals(expectedTitle, actualTitle);
	}
	
	@Test(priority=8,retryAnalyzer = MyRetry.class)
	public void CompanyFollow_Unfollow() throws IOException, InterruptedException {
		LoginPage l = new LoginPage(driver);
		l.email_TF(p.getPropertyFiledata("emailid"));
		l.password_TF(p.getPropertyFiledata("password"));
		l.LoginButton();
		NetworksPage n = new NetworksPage (driver);
		n.Networks();
		String expectedTitle = "Networks";
		String actualTitle = driver.findElement(By.xpath("//span[@class='mainHdngTxt']")).getText();
		Assert.assertEquals(expectedTitle, actualTitle);
	    n.SearchFieldNetwork(p.getPropertyFiledata("searchNetworkCompany"));
	    n.FollowButton();
	    driver.navigate().refresh();
	    n.Follow();
	    n.Unfollow();
	    Thread.sleep(1000);
	}
	@Test(priority=9)
	public void Recommanded_Industries() throws IOException, InterruptedException {
		 // Log into Account A
	    LoginPage l = new LoginPage(driver);
		l.email_TF(p.getPropertyFiledata("emailid"));
		l.password_TF(p.getPropertyFiledata("password"));
		l.LoginButton();
		
		NetworksPage n = new NetworksPage (driver);
		n.Networks();
		
		String expectedTitle = "Networks";
		String actualTitle = driver.findElement(By.xpath("//span[@class='mainHdngTxt']")).getText();
		Assert.assertEquals(expectedTitle, actualTitle);
		Thread.sleep(2000);
		n.ThreeDots();
		n.RecommendedIndustries();
		Thread.sleep(1000);
		n.RecIndsearhfiled(p.getPropertyFiledata("searchNetworkCompany"));
		Thread.sleep(500);
		driver.findElement(By.xpath("(//div[@class='flexMinWidthRow pdngXS'])[1]")).click();
	    Thread.sleep(500);
	    WebElement followers = driver.findElement(By.xpath("//span[@class='primaryTxt pdngHSM pointer']"));
	    followers.click();
	    //following
	    driver.findElement(By.xpath("(//button[@type='button'])[7]")).click();
	    //mutual
	    driver.findElement(By.xpath("(//button[@type='button'])[8]")).click();
	    //x - cancel
	    driver.findElement(By.xpath("(//div[@class='flexAutoRow pointer pdngHMD'])[1]")).click();
	    JavascriptExecutor js = (JavascriptExecutor) driver;
		   WebElement scroll = driver.findElement(By.xpath("//h4[normalize-space()='Certification']"));
		   js.executeScript("arguments[0].scrollIntoView(true);", scroll);
		   Thread.sleep(1000);
		    scroll.click();
		    String expTitle = "Certification";
		   String actTitle = driver.findElement(By.xpath("//h4[normalize-space()='Certification']")).getText();
		   Assert.assertEquals(expTitle, actTitle);
	}
	@Test(priority=10,retryAnalyzer = MyRetry.class)
	public void RecInd_NewsFeed() throws IOException, InterruptedException {
		 // Log into Account A
	    LoginPage l = new LoginPage(driver);
		l.email_TF(p.getPropertyFiledata("emailid"));
		l.password_TF(p.getPropertyFiledata("password"));
		l.LoginButton();
		
		NetworksPage n = new NetworksPage (driver);
		n.Networks();
		
		String expectedTitle = "Networks";
		String actualTitle = driver.findElement(By.xpath("//span[@class='mainHdngTxt']")).getText();
		Assert.assertEquals(expectedTitle, actualTitle);
		Thread.sleep(2000);
		n.ThreeDots();
		n.RecommendedIndustries();
		Thread.sleep(1000);
		n.RecIndsearhfiled(p.getPropertyFiledata("searchNetworkCompany"));
		Thread.sleep(500);
		driver.findElement(By.xpath("(//div[@class='flexMinWidthRow pdngXS'])[1]")).click();
	    Thread.sleep(500);
	    WebElement followers = driver.findElement(By.xpath("//span[@class='primaryTxt pdngHSM pointer']"));
	    followers.click();
	    //following
	    driver.findElement(By.xpath("(//button[@type='button'])[7]")).click();
	    //mutual
	    driver.findElement(By.xpath("(//button[@type='button'])[8]")).click();
	    //x - cancel
	    driver.findElement(By.xpath("(//div[@class='flexAutoRow pointer pdngHMD'])[1]")).click();
	    Thread.sleep(500);
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    WebElement newsFeedd = driver.findElement(By.xpath("(//button[normalize-space()='News Feed'])[1]"));
	    js.executeScript("arguments[0].scrollIntoView(true);", newsFeedd);
	    Thread.sleep(500);
	    js.executeScript("arguments[0].click();", newsFeedd);
//	    newsFeedd.click();
	    Thread.sleep(500);
	    js.executeScript("window.scrollBy(0, document.body.scrollHeight)");
	    Thread.sleep(500);
	}
	@Test(priority=11)
	public void InviteBusiness() throws IOException, InterruptedException {
		 // Log into Account A
	    LoginPage l = new LoginPage(driver);
		l.email_TF(p.getPropertyFiledata("emailid"));
		l.password_TF(p.getPropertyFiledata("password"));
		l.LoginButton();
		
		NetworksPage n = new NetworksPage (driver);
		n.Networks();
		
		String expectedTitle = "Networks";
		String actualTitle = driver.findElement(By.xpath("//span[@class='mainHdngTxt']")).getText();
		Assert.assertEquals(expectedTitle, actualTitle);
		Thread.sleep(2000);
		n.ThreeDots();
		n.InviteBusiness();
		driver.findElement(By.xpath("//button[normalize-space()='Copy']")).click();
		Thread.sleep(500);
		String expectedTitle1 = "Copied Successfully";
		String actualTitle1 = driver.findElement(By.xpath("(//div[contains(text(),'Copied Successfully')])[1]")).getText();
		Assert.assertEquals(expectedTitle1, actualTitle1);
	}
	
	@Test(priority=12)
	public void WhatsApp_InviteBusiness() throws IOException, InterruptedException {
		 // Log into Account A
	    LoginPage l = new LoginPage(driver);
		l.email_TF(p.getPropertyFiledata("emailid"));
		l.password_TF(p.getPropertyFiledata("password"));
		l.LoginButton();
		
		NetworksPage n = new NetworksPage (driver);
		n.Networks();
		
		String expectedTitle = "Networks";
		String actualTitle = driver.findElement(By.xpath("//span[@class='mainHdngTxt']")).getText();
		Assert.assertEquals(expectedTitle, actualTitle);
		Thread.sleep(2000);
		n.ThreeDots();
		n.InviteBusiness();
		driver.findElement(By.xpath("//button[normalize-space()='Copy']")).click();
		Thread.sleep(500);
		String expectedTitle1 = "Copied Successfully";
		String actualTitle1 = driver.findElement(By.xpath("(//div[contains(text(),'Copied Successfully')])[1]")).getText();
		Assert.assertEquals(expectedTitle1, actualTitle1);
		
		//whatsapp
		n.WhatsApp();
		driverutilies.switchTabs(driver);
		Thread.sleep(2000);
		String expUrl = "https://web.whatsapp.com/";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(expUrl, actualUrl);
		
	}
	@Test(priority=13)
	public void Facebook_InviteBusiness() throws IOException, InterruptedException {
		 // Log into Account A
	    LoginPage l = new LoginPage(driver);
		l.email_TF(p.getPropertyFiledata("emailid"));
		l.password_TF(p.getPropertyFiledata("password"));
		l.LoginButton();
		
		NetworksPage n = new NetworksPage (driver);
		n.Networks();
		
		String expectedTitle = "Networks";
		String actualTitle = driver.findElement(By.xpath("//span[@class='mainHdngTxt']")).getText();
		Assert.assertEquals(expectedTitle, actualTitle);
		Thread.sleep(2000);
		n.ThreeDots();
		n.InviteBusiness();
		driver.findElement(By.xpath("//button[normalize-space()='Copy']")).click();
		Thread.sleep(500);
		String expectedTitle1 = "Copied Successfully";
		String actualTitle1 = driver.findElement(By.xpath("(//div[contains(text(),'Copied Successfully')])[1]")).getText();
		Assert.assertEquals(expectedTitle1, actualTitle1);
		Thread.sleep(500);
		n.Facebook();
		driverutilies.switchTabs(driver);
		Thread.sleep(500);
		String expUrl = "https://www.facebook.com/login.php?skip_api_login=1&api_key=966242223397117&signed_next=1&next=https%3A%2F%2Fwww.facebook.com%2Fsharer%2Fsharer.php%3Fu%3Dhttps%253A%252F%252Ftestapp.inlink.pro%252Fcompany&cancel_url=https%3A%2F%2Fwww.facebook.com%2Fdialog%2Fclose_window%2F%3Fapp_id%3D966242223397117%26connect%3D0%23_%3D_&display=popup&locale=en_GB";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(expUrl, actualUrl);
		
	}
	@Test(priority=14)
	public void Twitter_InviteBusiness() throws IOException, InterruptedException {
		 // Log into Account A
	    LoginPage l = new LoginPage(driver);
		l.email_TF(p.getPropertyFiledata("emailid"));
		l.password_TF(p.getPropertyFiledata("password"));
		l.LoginButton();
		
		NetworksPage n = new NetworksPage (driver);
		n.Networks();
		
		String expectedTitle = "Networks";
		String actualTitle = driver.findElement(By.xpath("//span[@class='mainHdngTxt']")).getText();
		Assert.assertEquals(expectedTitle, actualTitle);
		Thread.sleep(2000);
		n.ThreeDots();
		n.InviteBusiness();
		driver.findElement(By.xpath("//button[normalize-space()='Copy']")).click();
		Thread.sleep(500);
		String expectedTitle1 = "Copied Successfully";
		String actualTitle1 = driver.findElement(By.xpath("(//div[contains(text(),'Copied Successfully')])[1]")).getText();
		Assert.assertEquals(expectedTitle1, actualTitle1);
		Thread.sleep(500);
		n.Twitter();
		driverutilies.switchTabs(driver);
		Thread.sleep(500);
		String expUrl = "https://twitter.com/intent/tweet?url=https%3A%2F%2Ftestapp.inlink.pro%2Fcompany";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(expUrl, actualUrl);
		
	}
	@Test(priority=15)
	public void Instagram_InviteBusiness() throws IOException, InterruptedException {
		 // Log into Account A
	    LoginPage l = new LoginPage(driver);
		l.email_TF(p.getPropertyFiledata("emailid"));
		l.password_TF(p.getPropertyFiledata("password"));
		l.LoginButton();
		
		NetworksPage n = new NetworksPage (driver);
		n.Networks();
		
		String expectedTitle = "Networks";
		String actualTitle = driver.findElement(By.xpath("//span[@class='mainHdngTxt']")).getText();
		Assert.assertEquals(expectedTitle, actualTitle);
		Thread.sleep(2000);
		n.ThreeDots();
		n.InviteBusiness();
		driver.findElement(By.xpath("//button[normalize-space()='Copy']")).click();
		Thread.sleep(500);
		String expectedTitle1 = "Copied Successfully";
		String actualTitle1 = driver.findElement(By.xpath("(//div[contains(text(),'Copied Successfully')])[1]")).getText();
		Assert.assertEquals(expectedTitle1, actualTitle1);
		Thread.sleep(500);
		n.Instagram();
		driverutilies.switchTabs(driver);
		Thread.sleep(500);
		String expUrl = "https://www.instagram.com/";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(expUrl, actualUrl);
		
	}
	@Test(priority=16)
	public void Linkedin_InviteBusiness() throws IOException, InterruptedException {
		 // Log into Account A
	    LoginPage l = new LoginPage(driver);
		l.email_TF(p.getPropertyFiledata("emailid"));
		l.password_TF(p.getPropertyFiledata("password"));
		l.LoginButton();
		
		NetworksPage n = new NetworksPage (driver);
		n.Networks();
		
		String expectedTitle = "Networks";
		String actualTitle = driver.findElement(By.xpath("//span[@class='mainHdngTxt']")).getText();
		Assert.assertEquals(expectedTitle, actualTitle);
		Thread.sleep(2000);
		n.ThreeDots();
		n.InviteBusiness();
		driver.findElement(By.xpath("//button[normalize-space()='Copy']")).click();
		Thread.sleep(500);
		String expectedTitle1 = "Copied Successfully";
		String actualTitle1 = driver.findElement(By.xpath("(//div[contains(text(),'Copied Successfully')])[1]")).getText();
		Assert.assertEquals(expectedTitle1, actualTitle1);
		Thread.sleep(500);
		n.Linkedin();
		driverutilies.switchTabs(driver);
		Thread.sleep(500);
		String expUrl = "https://www.linkedin.com/uas/login?session_redirect=https%3A%2F%2Fwww.linkedin.com%2FshareArticle%3Furl%3Dhttps%253A%252F%252Ftestapp.inlink.pro%252Fcompany%26mini%3Dtrue";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(expUrl, actualUrl);
		
	}
	@Test(priority=17)
	public void Telegram_InviteBusiness() throws IOException, InterruptedException {
		 // Log into Account A
	    LoginPage l = new LoginPage(driver);
		l.email_TF(p.getPropertyFiledata("emailid"));
		l.password_TF(p.getPropertyFiledata("password"));
		l.LoginButton();
		
		NetworksPage n = new NetworksPage (driver);
		n.Networks();
		
		String expectedTitle = "Networks";
		String actualTitle = driver.findElement(By.xpath("//span[@class='mainHdngTxt']")).getText();
		Assert.assertEquals(expectedTitle, actualTitle);
		Thread.sleep(2000);
		n.ThreeDots();
		n.InviteBusiness();
		driver.findElement(By.xpath("//button[normalize-space()='Copy']")).click();
		Thread.sleep(500);
		String expectedTitle1 = "Copied Successfully";
		String actualTitle1 = driver.findElement(By.xpath("(//div[contains(text(),'Copied Successfully')])[1]")).getText();
		Assert.assertEquals(expectedTitle1, actualTitle1);
		Thread.sleep(500);
		n.Telegram();
		driverutilies.switchTabs(driver);
		Thread.sleep(500);
		String expUrl = "https://telegram.me/share/url?url=https%3A%2F%2Ftestapp.inlink.pro%2Fcompany";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(expUrl, actualUrl);
		
	}
	@Test(priority=18)
	public void Gmail_InviteBusiness() throws IOException, InterruptedException {
		 // Log into Account A
	    LoginPage l = new LoginPage(driver);
		l.email_TF(p.getPropertyFiledata("emailid"));
		l.password_TF(p.getPropertyFiledata("password"));
		l.LoginButton();
		
		NetworksPage n = new NetworksPage (driver);
		n.Networks();
		
		String expectedTitle = "Networks";
		String actualTitle = driver.findElement(By.xpath("//span[@class='mainHdngTxt']")).getText();
		Assert.assertEquals(expectedTitle, actualTitle);
		Thread.sleep(2000);
		n.ThreeDots();
		n.InviteBusiness();
		driver.findElement(By.xpath("//button[normalize-space()='Copy']")).click();
		Thread.sleep(500);
		String expectedTitle1 = "Copied Successfully";
		String actualTitle1 = driver.findElement(By.xpath("(//div[contains(text(),'Copied Successfully')])[1]")).getText();
		Assert.assertEquals(expectedTitle1, actualTitle1);
		Thread.sleep(500);
		n.Gmail();
		driverutilies.switchTabs(driver);
		Thread.sleep(1000);
		String expTitle = "Gmail";
		String actualtitle = driver.getTitle();
		Assert.assertEquals(expTitle, actualtitle);
		
	}
	
	}
