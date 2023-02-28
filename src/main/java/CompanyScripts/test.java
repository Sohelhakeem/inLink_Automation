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
import pomPages.NetworksPage;
import pomPages.createNews;
import pomPages.homePage;

	public class test extends BaseClass {
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
		    Thread.sleep(500);
		    n.Follow();
		    n.Unfollow();
		    Thread.sleep(2000);
		}
	}

