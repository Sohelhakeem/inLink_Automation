package CompanyScripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericLib.BaseClass;
import pomPages.LoginPage;
import pomPages.ResourcesPage;
import pomPages.createCategoryPage;

public class resourcesScripts extends BaseClass {
	@Test
	public void resourcesPage() throws IOException {
		LoginPage l = new LoginPage(driver);
		l.email_TF(p.getPropertyFiledata("emailid"));
		l.password_TF(p.getPropertyFiledata("password"));
		l.LoginButton();
		ResourcesPage r = new ResourcesPage(driver);
		r.ResourcePage();
		String text = driver.findElement(By.xpath("//span[@class='mainHdngTxt']")).getText();
		Assert.assertEquals(text, "Categories");
	}
	@Test(priority=2)
	public void Create_Category() throws IOException {
		LoginPage l = new LoginPage(driver);
		l.email_TF(p.getPropertyFiledata("emailid"));
		l.password_TF(p.getPropertyFiledata("password"));
		l.LoginButton();
		
		ResourcesPage r = new ResourcesPage(driver);
		r.ResourcePage();
		r.NewBtn();
		
		createCategoryPage cc = new createCategoryPage(driver);
		cc.UploadIage(p.getPropertyFiledata("UploadImage"));
		cc.categoryNameField(p.getPropertyFiledata("categotyName"));
		cc.DescriptionField(p.getPropertyFiledata("catDescription"));
		cc.checkbox();
		cc.Save();
		WebElement text = new WebDriverWait(driver, 10)
		         .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Category Created Successfully')]")));
		String actualText = text.getText();
		Assert.assertEquals(actualText, "Category Created Successfully");
	}
	@Test(priority=3)
	public void Update_Category() throws IOException {
		LoginPage l = new LoginPage(driver);
		l.email_TF(p.getPropertyFiledata("emailid"));
		l.password_TF(p.getPropertyFiledata("password"));
		l.LoginButton();
		
		ResourcesPage r = new ResourcesPage(driver);
		r.ResourcePage();
		r.Edit();
		
		createCategoryPage cc = new createCategoryPage(driver);
		cc.UploadIage(p.getPropertyFiledata("UploadImage"));
		cc.categoryNameField(p.getPropertyFiledata("categotyName"));
		cc.DescriptionField(p.getPropertyFiledata("catDescription"));
		cc.checkbox();
		cc.Save();
		WebElement text = new WebDriverWait(driver, 10)
		         .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Category Updated Successfully')]")));
		String actualText = text.getText();
		Assert.assertEquals(actualText, "Category Updated Successfully");
	}
	@Test(priority=4)
	public void Delete_Category() throws IOException {
		LoginPage l = new LoginPage(driver);
		l.email_TF(p.getPropertyFiledata("emailid"));
		l.password_TF(p.getPropertyFiledata("password"));
		l.LoginButton();
		
		ResourcesPage r = new ResourcesPage(driver);
		r.ResourcePage();
		r.Delete();
		r.ConfDelete();
		
		WebElement text = new WebDriverWait(driver, 10)
		         .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Category Deleted Succesfully')]")));
		String actualText = text.getText();
		
		//Assert.assertEquals(actualText, "Category Deleted Successfully");
		Assert.assertEquals(actualText, "Category Deleted Succesfully");
	}

}
