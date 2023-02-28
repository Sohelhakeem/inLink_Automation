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

public class Failed_EmpTestCases extends BaseClass {
	@Test(priority=7)
	//UploadVideo
		public void UploadVideo_Multiple() throws IOException, InterruptedException {
			LoginPage l=new LoginPage(driver);
			l.email_TF(p.getPropertyFiledata("eemailid"));
			l.password_TF(p.getPropertyFiledata("password"));
			l.LoginButton();
			
			homePage h=new homePage(driver);
			h.CreatePost();
			
			createNews cn = new createNews(driver);
			cn.textContentField(p.getPropertyFiledata("ContentText"));
			cn.UploadVideo("D:\\Upload\\Bird - 46026.mp4");
			cn.UploadVideo("D:\\Upload\\animal.mp4");
			Thread.sleep(3000);
			
			Point status = cn.getStatus().getLocation();
			int x2 =status.getX();
			int y2 =status.getY();
			driverutilies.scrollbar(driver, x2, y2);
			cn.Status();
			cn.Status();
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
	

}
