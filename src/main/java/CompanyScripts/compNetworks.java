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
	
	@Test(priority=8)
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
	    Thread.sleep(1000);
	    n.Follow();
	    n.FollowingBtn();
	    n.Unfollow();
	    Thread.sleep(2000);
	}
	
	}
