package CompanyScripts;


	import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericLib.BaseClass;
import pomPages.LoginPage;
import pomPages.employeesPage;

	public class test extends BaseClass {
		@Test(priority=4)
		public void ChangeRoleAs_Admin() throws IOException, InterruptedException {
		LoginPage l=new LoginPage(driver);
		l.email_TF(p.getPropertyFiledata("emailid"));
		l.password_TF(p.getPropertyFiledata("password"));
		l.LoginButton();
		employeesPage e = new employeesPage(driver);
		e.Employees();
		e.Active();
		Thread.sleep(1000);
		e.ActiveSearchField(p.getPropertyFiledata("activeEmpName"));
		Thread.sleep(500);
		e.EmployeeProfile();
		e.RoleEmployee();
		e.Admin();
		Thread.sleep(500);
		e.GrantAdmin();
		 
		String name = p.getPropertyFiledata("activeEmpName");
		String verify =" is an Admin now";
		String expText= name+verify;
		System.out.println(expText);
		WebElement element = new WebDriverWait(driver, 10)
		         .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'"+name+" is an Admin now')]")));
		String actualText = element.getText();
		System.out.println(actualText);
		Assert.assertEquals(expText, actualText);
		//Thread.sleep(500);
		 WebElement element1 = new WebDriverWait(driver, 10)
		         .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[name()='svg'][@aria-label='Back'])[1]")));

		      element1.click();
		Thread.sleep(1000);
		e.ActiveSearchField(p.getPropertyFiledata("activeEmpName"));
		Thread.sleep(500);
		String actualText1 =driver.findElement(By.xpath("//span[normalize-space()='(admin)']")).getText();
		Assert.assertEquals(actualText1, "(admin)");
		

	}
		@Test(priority=5)
		public void ChangeRoleAs_Employee() throws IOException, InterruptedException {
			LoginPage l=new LoginPage(driver);
			l.email_TF(p.getPropertyFiledata("emailid"));
			l.password_TF(p.getPropertyFiledata("password"));
			l.LoginButton();
			employeesPage e = new employeesPage(driver);
			e.Employees();
			e.Active();
			Thread.sleep(1000);
			e.ActiveSearchField(p.getPropertyFiledata("activeEmpName"));
			Thread.sleep(500);
			e.EmployeeProfile();
			e.RoleAdmin();
			e.EmployeesRole();
			e.RemoveAdmin();
			Thread.sleep(2000);
			String name = p.getPropertyFiledata("activeEmpName");
			String verify =" is removed as Admin";
			String expText= name+verify;
			String actualText =driver.findElement(By.xpath("//div[contains(text(),'"+name+" is removed as Admin')]")).getText();
			Assert.assertEquals(expText, actualText);
			Thread.sleep(500);
			String title = driver.getTitle();
			System.out.println(title);
			Assert.assertEquals(title, "Inlink");
		}
	}

