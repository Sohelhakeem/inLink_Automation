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
import pomPages.configurationPage;
import pomPages.employeesPage;

public class ConfigureDeptScripts extends BaseClass{

	@Test(priority=1)
	public void create_Dept() throws IOException, InterruptedException {
		LoginPage l=new LoginPage(driver);
		l.email_TF(p.getPropertyFiledata("ifurn"));
		l.password_TF(p.getPropertyFiledata("password"));
		l.LoginButton();
		configurationPage c = new configurationPage(driver);
		c.configurationModule();
		c.Departments();
		c.NewBtn();
		c.EnterName(p.getPropertyFiledata("DepartmentName"));
		c.EnterDiscription(p.getPropertyFiledata("Description"));
		c.Create();
		Thread.sleep(2000);
		c.searchDeptField(p.getPropertyFiledata("DepartmentName"));
		Thread.sleep(500);
		c.openDept();
		Thread.sleep(500);
		c.Divisions();
		c.NewBtn();
		c.EnterName(p.getPropertyFiledata("DivisionName"));
		c.EnterDiscription(p.getPropertyFiledata("Description"));
		c.Create();
		Thread.sleep(3000);
		c.Designations();
		c.NewBtn();
		c.EnterName(p.getPropertyFiledata("Designation"));
		c.EnterDiscription(p.getPropertyFiledata("Description"));
		Thread.sleep(500);
		c.Create();
		WebElement text = new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Designation Created Successfully')]")));
		String actualText = text.getText();
		Assert.assertEquals(actualText, "Designation Created Successfully");
		
	}
	@Test(priority=2)
	public void Edit_Dept() throws IOException, InterruptedException {
		LoginPage l=new LoginPage(driver);
		l.email_TF(p.getPropertyFiledata("ifurn"));
		l.password_TF(p.getPropertyFiledata("password"));
		l.LoginButton();
		configurationPage c = new configurationPage(driver);
		c.configurationModule();
		c.Departments();
		Thread.sleep(1000);
		c.searchDeptField(p.getPropertyFiledata("DepartmentName"));
		Thread.sleep(500);
		c.openDept();
		Thread.sleep(500);
		c.Divisions();
		c.EditDivision();
		c.EnterName(p.getPropertyFiledata("DivisionName"));
		c.EnterDiscription(p.getPropertyFiledata("Description"));
		c.Updata();
		Thread.sleep(3000);
		c.Designations();
		Thread.sleep(500);
		c.EditDesignation();
		c.EnterName(p.getPropertyFiledata("Designation"));
		c.EnterDiscription(p.getPropertyFiledata("Description"));
		c.Updata();
		c.configurationModule();
		c.EditDepartment();
		c.EnterName(p.getPropertyFiledata("DepartmentName"));
		c.EnterDiscription(p.getPropertyFiledata("Description"));
		c.Updata();
		WebElement text = new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Department Updated Successfully')]")));
		String actualText = text.getText();
		Assert.assertEquals(actualText, "Department Updated Successfully");
	}
	@Test(priority=3)
	public void Delete_Dept() throws IOException, InterruptedException {
		LoginPage l=new LoginPage(driver);
		l.email_TF(p.getPropertyFiledata("ifurn"));
		l.password_TF(p.getPropertyFiledata("password"));
		l.LoginButton();
		configurationPage c = new configurationPage(driver);
		c.configurationModule();
		c.Departments();
		Thread.sleep(1000);
		c.searchDeptField(p.getPropertyFiledata("DepartmentName"));
		c.openDept();
		Thread.sleep(1000);
		c.searchDivisionField(p.getPropertyFiledata("DivisionName"));
		c.DeleteDivision();
		c.ConfirmDeleteDivision();
		c.Designations();
		Thread.sleep(2000);
		c.searchDesignationField(p.getPropertyFiledata("Designation"));
		Thread.sleep(1000);
		c.DeleteDesignation();
		c.ConfirmDeleteDesignation();
		c.configurationModule();
		Thread.sleep(1000);
		c.searchDeptField(p.getPropertyFiledata("DepartmentName"));
		c.DeleteDepartment();
		c.ConfirmDeleteDepartment();
		WebElement text = new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Department Deleted Successfully')]")));
		String actualText = text.getText();
		Assert.assertEquals(actualText, "Department Deleted Successfully");
	}
		
}
