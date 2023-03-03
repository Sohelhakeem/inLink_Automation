package CompanyScripts;


	import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericLib.BaseClass;
import pomPages.LoginPage;
import pomPages.employeesPage;

	public class test extends BaseClass {
		@Test(priority=1)
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
		Thread.sleep(200);
		e.GrantAdmin();
		Thread.sleep(5000);
		
		e.Backbtn();
		Thread.sleep(1000);
		e.ActiveSearchField(p.getPropertyFiledata("activeEmpName"));
		Thread.sleep(500);
		String actualText = driver.findElement(By.xpath("//span[@class='textActive titleHeading headingXSM firstLetter']")).getText();
		Assert.assertEquals(actualText, "(admin)");
		
		}
		@Test(priority=2)
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
			Thread.sleep(1000);
			String title = driver.getTitle();
			System.out.println(title);
			Assert.assertEquals(title, "Inlink");
		}
	}

