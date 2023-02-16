package CompanyScripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericLib.BaseClass;
import pomPages.LoginPage;
import pomPages.NetworksPage;

public class Networks extends BaseClass {
@Test
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


}
