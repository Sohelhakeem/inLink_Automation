package CompanyScripts;

import java.io.IOException;

import org.testng.annotations.Test;

import genericLib.BaseClass;
import pomPages.LoginPage;
import pomPages.configurationPage;

public class ConfigureDeptScripts extends BaseClass{

	@Test
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
		Thread.sleep(1000);
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
		c.Create();
	}
}
