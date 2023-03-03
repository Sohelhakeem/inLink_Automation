package CompanyScripts;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericLib.BaseClass;
import pomPages.LoginPage;
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
	public void Pendinf_reject() throws IOException, InterruptedException, AWTException  {
	LoginPage l=new LoginPage(driver);
	l.email_TF(p.getPropertyFiledata("emailid"));
	l.password_TF(p.getPropertyFiledata("password"));
	l.LoginButton();
	employeesPage e = new employeesPage(driver);
	e.Employees();
	e.Rejected();
	
}
	
}