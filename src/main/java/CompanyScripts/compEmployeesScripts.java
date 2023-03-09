package CompanyScripts;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
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
import pomPages.addEmployeesPage;
import pomPages.employeesPage;

public class compEmployeesScripts extends BaseClass {
//Sign Up as a Employee Under the Company.
//reject and approve 1 for both
//keep in pending 1
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
		
	@Test(priority=3,retryAnalyzer = MyRetry.class)
		public void Edit_Official_Details() throws IOException, InterruptedException, AWTException  {
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
		e.Editicon();
		e.EditDepartment();
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		e.EditDesignation();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(500);
		e.EditSave();
		Thread.sleep(2000);
		String message = driver.findElement(By.xpath("//div[contains(text(),'Profile Updated')]")).getText();
		Assert.assertEquals(message, "Profile Updated Successfully");
		
	}
	
	@Test(priority=4,retryAnalyzer = MyRetry.class)
		public void EmployeeProfile_NewsFeed() throws IOException, InterruptedException, AWTException  {
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
		e.NewsFeed();
		
	}
	
	@Test(priority=5,retryAnalyzer = MyRetry.class)
		public void EmployeeProfile() throws IOException, InterruptedException, AWTException  {
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
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement social = driver.findElement(By.xpath("//h4[normalize-space()='Social Media Links']"));
		js.executeScript("arguments[0].scrollIntoView();", social);
		Thread.sleep(500);
		String text = social.getText();
		System.out.println(text);
		
	}
	
	@Test(priority=6)
		public void Pendinf_Approve_Cancel() throws IOException, InterruptedException, AWTException  {
		LoginPage l=new LoginPage(driver);
		l.email_TF(p.getPropertyFiledata("emailid"));
		l.password_TF(p.getPropertyFiledata("password"));
		l.LoginButton();
		employeesPage e = new employeesPage(driver);
		e.Employees();
		e.Pending();
		e.PendingStatus();
		e.PendingApprove();
		Thread.sleep(1000);
		e.Pendingdepartment();
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(500);
		e.Pendingdevision();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		e.Pendingdesignation();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(500);
		e.WorkLocation("Hyderabad");
		Thread.sleep(500);
		e.PFinalApproveDisplayed();
		//e.PFinalApprove();
		e.pendingCancel();
		
	}
	
	@Test(priority=7)
		public void Pending_reject_Cancel() throws IOException, InterruptedException, AWTException  {
		LoginPage l=new LoginPage(driver);
		l.email_TF(p.getPropertyFiledata("emailid"));
		l.password_TF(p.getPropertyFiledata("password"));
		l.LoginButton();
		employeesPage e = new employeesPage(driver);
		e.Employees();
		e.Pending();
		e.PendingStatus();
		e.PendingReject();
		e.PendingConfrejectDisplay();
		e.PendingCancel();
	
	}
	
	@Test(priority=8)
		public void Pendinf_rejected() throws IOException, InterruptedException, AWTException  {
		LoginPage l=new LoginPage(driver);
		l.email_TF(p.getPropertyFiledata("emailid"));
		l.password_TF(p.getPropertyFiledata("password"));
		l.LoginButton();
		employeesPage e = new employeesPage(driver);
		e.Employees();
		e.Rejected();
	
	}
	@Test(priority=9)
	public void SortBy_Filter() throws IOException, InterruptedException, AWTException  {
		LoginPage l=new LoginPage(driver);
		l.email_TF(p.getPropertyFiledata("emailid"));
		l.password_TF(p.getPropertyFiledata("password"));
		l.LoginButton();
		employeesPage e = new employeesPage(driver);
		e.Employees();
		e.SortByfilter();
		Thread.sleep(500);
		String text = driver.findElement(By.xpath("(//span[@class='fontweight'])[1]")).getText();
		Assert.assertEquals(text, "Sort by");
		
	}
	
	@Test(priority=10,retryAnalyzer = MyRetry.class)
	public void InviteWithEmail_send() throws IOException, InterruptedException, AWTException  {
		LoginPage l=new LoginPage(driver);
		l.email_TF(p.getPropertyFiledata("emailid"));
		l.password_TF(p.getPropertyFiledata("password"));
		l.LoginButton();
		employeesPage e = new employeesPage(driver);
		e.Employees();
		e.Invite();
		Thread.sleep(500);
		String text = driver.findElement(By.xpath("//span[normalize-space()='Invite']")).getText();
		Assert.assertEquals(text, "Invite");
		driver.findElement(By.xpath("//button[normalize-space()='Copy']")).click();
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("iqra@yopmail.com");
		driver.findElement(By.xpath("//div[@class='flexRow mrgnBtmSM']//button[@type='button']")).click();
		driver.findElement(By.xpath("//button[normalize-space()='Send']")).click();
		//driver.findElement(By.xpath("//button[@class='Toastify__close-button Toastify__close-button--light']//*[name()='svg']")).click();
		Thread.sleep(2000);
		String text1 = driver.findElement(By.xpath("//div[contains(text(),'Invitation send Successfully')]")).getText();
		System.out.println(text1);
		Assert.assertEquals(text1, "Invitation send Successfully");
		
	}
	@Test(priority=11	)
	public void InviteWithEmail_Cancel() throws IOException, InterruptedException, AWTException  {
		LoginPage l=new LoginPage(driver);
		l.email_TF(p.getPropertyFiledata("emailid"));
		l.password_TF(p.getPropertyFiledata("password"));
		l.LoginButton();
		employeesPage e = new employeesPage(driver);
		e.Employees();
		e.Invite();
		Thread.sleep(500);
		String text = driver.findElement(By.xpath("//span[normalize-space()='Invite']")).getText();
		Assert.assertEquals(text, "Invite");
		driver.findElement(By.xpath("//button[normalize-space()='Copy']")).click();
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("iqra@yopmail.com");
		driver.findElement(By.xpath("//div[@class='flexRow mrgnBtmSM']//button[@type='button']")).click();
		driver.findElement(By.xpath("//button[normalize-space()='Cancel']")).click();
		driver.findElement(By.xpath("//button[@class='Toastify__close-button Toastify__close-button--light']//*[name()='svg']")).click();
		Thread.sleep(2000);
		String text1 = driver.getTitle();
		System.out.println(text1);
		Assert.assertEquals(text1, "Inlink");
		
		
	}
	@Test(priority = 12)
	public void createEmployeeInvalidDetails() throws IOException, InterruptedException, AWTException  {
		LoginPage l=new LoginPage(driver);
		l.email_TF(p.getPropertyFiledata("emailid"));
		l.password_TF(p.getPropertyFiledata("password"));
		l.LoginButton();
		employeesPage e = new employeesPage(driver);
		e.Employees();
		e.NewBtn();
		addEmployeesPage an = new addEmployeesPage(driver);
		an.fullname(";wleofi");
		an.email("q;lwdk");
		an.phoneNumber("9123456788");
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
		Thread.sleep(500);
		JavascriptExecutor js =(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-350)", " ");
		Thread.sleep(500);
		String error1 = driver.findElement(By.xpath("//div[@class='flexCol mrgnTMD']//p[@id='txtFirstName-error']")).getText();
		Assert.assertEquals(error1, "Please enter valid fullName");
		
		String error2 = driver.findElement(By.xpath("//p[normalize-space()='Enter valid Email Address']")).getText();
		Assert.assertEquals(error2, "Enter valid Email Address");
		
	}
	@Test(priority=13)
	public void createEmployeeValid_Cancel() throws IOException, InterruptedException, AWTException  {
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
		an.cancelBtn();
		String text = driver.findElement(By.xpath("//span[@class='mainHdngTxt']")).getText();
		Assert.assertEquals(text, "Employees List");
		
	}
	@Test(priority=14)
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
		//an.addBtn();
		an.addBtnDisplay();
		//Thread.sleep(8000);
		
		
	}
	
}