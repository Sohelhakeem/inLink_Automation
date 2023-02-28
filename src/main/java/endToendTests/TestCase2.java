 package endToendTests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.testng.Assert;
import org.testng.annotations.Test;

import CompanyScripts.MyRetry;
import genericLib.BaseClass;
import pomPages.ConnectionRequestPage;
import pomPages.LoginPage;
import pomPages.LogoutPage;
import pomPages.NetworksPage;

public class TestCase2 extends BaseClass{
	@Test(retryAnalyzer = MyRetry.class)
	  public void testCase1() throws InterruptedException, IOException {
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
	    // Send a request
	    n.SearchFieldNetwork(p.getPropertyFiledata("searchNetworkCompany"));
	    n.ConnectButton();
	    String expectedTitle1 = "Connection Request";
		String actualTitle1 = driver.findElement(By.xpath("//span[@class='mainHdngTxt pdngHSM ellipsisTxt']")).getText();
		Assert.assertEquals(expectedTitle1, actualTitle1);
		Thread.sleep(500);
		ConnectionRequestPage cn = new ConnectionRequestPage(driver);
		cn.SelectRelationDD();
		cn.Manufacturer();
		//cn.AssignRMField("mallika");
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		Point cb = cn.getCheckBox().getLocation();
		int x =cb.getX();
		int y =cb.getY();
		driverutilies.scrollbar(driver, x, y);
		cn.CheckBox();
		cn.Connect();
		Thread.sleep(3000);
		 String expectedTitle2 = "Network Connections";
			String actualTitle2 = driver.findElement(By.xpath("(//span[@class='mainHdngTxt textCntr'])[1]")).getText();
			Assert.assertEquals(expectedTitle2, actualTitle2);
		
		cn.OkButton();
	    // Log out of Account A
		
	   LogoutPage l1 = new LogoutPage(driver);
	   l1.LogoutButton();
	   Thread.sleep(5000);
	    // Log into Account B
		l.email_TF(p.getPropertyFiledata("emailid1"));
		l.password_TF(p.getPropertyFiledata("password"));
		l.LoginButton();
		
		n.Networks();
		n.Pending();
		  // Approve and cancel the request
		n.Approve();
		Thread.sleep(500);
		n.CancelApprove();
//		n.AcceptApprove();
		//Reject The Request
		n.Reject();
		String expectedTitle3 = "Reject";
		String actualTitle3 = driver.findElement(By.xpath("//h2[@id='alert-dialog-title']")).getText();
		Assert.assertEquals(expectedTitle3, actualTitle3);
		
		n.RejectReasonField("Delaying for few days");
		n.RReject();
	    Thread.sleep(2000);
		String expectedTitle4 = "Connection Rejected";
		String actualTitle4 = driver.findElement(By.xpath("//div[@role='alert']")).getText();
		Assert.assertEquals(expectedTitle4, actualTitle4);
		
	  }
}
