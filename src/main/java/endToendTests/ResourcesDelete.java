package endToendTests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericLib.BaseClass;
import pomPages.LoginPage;
import pomPages.ResourcesPage;
import pomPages.createSubCategoryPage;

public class ResourcesDelete extends BaseClass {
	@Test(priority=2)
	public void Create_Content() throws IOException, InterruptedException {
		LoginPage l = new LoginPage(driver);
		l.email_TF(p.getPropertyFiledata("emailid"));
		l.password_TF(p.getPropertyFiledata("password"));
		l.LoginButton();
		
		ResourcesPage r = new ResourcesPage(driver);
		//search and select the category
		r.ResourcePage();
		r.Searchfield(p.getPropertyFiledata("categotyName"));
		String categoryname = p.getPropertyFiledata("categotyName");
		WebElement name = driver.findElement(By.xpath("//span[@aria-label='"+categoryname+"']"));
		name.isDisplayed();
		name.click();
		
		createSubCategoryPage cs = new createSubCategoryPage(driver);
		WebElement text0 = new WebDriverWait(driver, 10)
		         .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[normalize-space()='"+categoryname+"']")));
		text0.isDisplayed();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement deletesub = driver.findElement(By.xpath("//div[contains(@aria-label,'Delete')]//*[name()='svg']"));
		js.executeScript("arguments[0].scrollIntoView(true);", deletesub);
		Thread.sleep(500);
		//js.executeScript("arguments[0].click();", deletesub);
		deletesub.click();
		WebElement delete = driver.findElement(By.xpath("//button[normalize-space()='Delete']"));
		delete.click();
		
		WebElement text = new WebDriverWait(driver, 10)
		         .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Sub Category Deleted Succesfully')]")));
		String actualText = text.getText();
		Assert.assertEquals(actualText, "Sub Category Deleted Succesfully");
		
		driver.findElement(By.xpath("//*[name()='path' and contains(@fill-rule,'evenodd')]")).click();
		
		WebElement contentopen = driver.findElement(By.xpath("//span[@class='ellipseLen2 wordBreakWord']"));
		js.executeScript("arguments[0].scrollIntoView(true);", contentopen);
		Thread.sleep(500);
		//js.executeScript("arguments[0].click();", deletesub);
		contentopen.click();
		
		WebElement contentdelete = driver.findElement(By.xpath("//div[@aria-label='Delete']//*[name()='svg']"));
		js.executeScript("arguments[0].scrollIntoView(false);", contentdelete);
		Thread.sleep(1000);
		contentdelete.click();
		Thread.sleep(1000);
		WebElement deletee = driver.findElement(By.xpath("//button[normalize-space()='Delete']"));
		deletee.click();
		
		WebElement text1 = new WebDriverWait(driver, 10)
		         .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Content and its sections deleted succesfully')]")));
		String actualText1 = text1.getText();
		Assert.assertEquals(actualText1, "Content and its sections deleted succesfully");
		
        }

}
