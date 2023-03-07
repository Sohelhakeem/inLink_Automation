package CompanyScripts;


	import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericLib.BaseClass;
import pomPages.LoginPage;
import pomPages.addEmployeesPage;
import pomPages.employeesPage;

	public class test extends BaseClass {
		@Test(priority=1)
		public void createEmployeeValid_Add() throws IOException, InterruptedException, AWTException  {
			LoginPage l=new LoginPage(driver);
			l.email_TF(p.getPropertyFiledata("emailid"));
			l.password_TF(p.getPropertyFiledata("password"));
			l.LoginButton();
			employeesPage e = new employeesPage(driver);
			e.Employees();
			e.NewBtn();
			addEmployeesPage an = new addEmployeesPage(driver);
			an.fullname(p.getPropertyFiledata("fullname"));
			an.email(p.getPropertyFiledata("EmailID"));
			an.phoneNumber(p.getPropertyFiledata("Phone"));
			an.Department();
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
			an.AddDivision();
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
			an.Designation();
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(500);
			an.workLocation(p.getPropertyFiledata("Location"));
			an.addBtn();
//			an.addBtnDisplay();
			Thread.sleep(8000);
			
		}
	}

