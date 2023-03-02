package TestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericLib.BaseClass;
import pomPages.LoginPage;
import pomPages.createNews;
import pomPages.homePage;

public class uploading_Image100 extends BaseClass {
	@Test(invocationCount = 100)
	//UploadImage
		public void UploadImage() throws IOException, InterruptedException  {
			LoginPage l=new LoginPage(driver);
			l.email_TF(p.getPropertyFiledata("ifurn"));
			l.password_TF(p.getPropertyFiledata("password"));
			l.LoginButton();
			
			homePage h=new homePage(driver);
			h.CreatePost();
			
			createNews cn = new createNews(driver);
			cn.textContentField("Uploaded 8 mb image");
			cn.UploadImage(p.getPropertyFiledata("ifurnImage"));
			Thread.sleep(3000);
	 		cn.PostButton();
	 		Thread.sleep(2000);
	 		String expected_Text1 = "News Feed Created Successfully";
	 		String actual_Text1 = driver.findElement(By.xpath("//div[contains(text(),'News Feed Created Successfully')]")).getText();
	 		Assert.assertEquals(expected_Text1, actual_Text1);
		}
}
