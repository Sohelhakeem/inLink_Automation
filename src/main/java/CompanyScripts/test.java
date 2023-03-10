package CompanyScripts;


	import java.io.IOException;

import org.testng.annotations.Test;

import genericLib.BaseClass;
import pomPages.LoginPage;
import pomPages.ResourcesPage;

	public class test extends BaseClass {
		@Test(priority=1)
		public void AllFilter() throws IOException, InterruptedException {
			LoginPage l = new LoginPage(driver);
			l.email_TF(p.getPropertyFiledata("emailid"));
			l.password_TF(p.getPropertyFiledata("password"));
			l.LoginButton();
			
			ResourcesPage r = new ResourcesPage(driver);
			//search and select the category
			r.ResourcePage();
			r.Filter();
			r.AllFilter();
		}
		@Test(priority=2)
		public void EnabledFilter() throws IOException, InterruptedException {
			LoginPage l = new LoginPage(driver);
			l.email_TF(p.getPropertyFiledata("emailid"));
			l.password_TF(p.getPropertyFiledata("password"));
			l.LoginButton();
			
			ResourcesPage r = new ResourcesPage(driver);
			//search and select the category
			r.ResourcePage();
			r.Filter();
			r.EnabledFilter();
		}
		@Test(priority=3)
		public void DisableFilter() throws IOException, InterruptedException {
			LoginPage l = new LoginPage(driver);
			l.email_TF(p.getPropertyFiledata("emailid"));
			l.password_TF(p.getPropertyFiledata("password"));
			l.LoginButton();
			
			ResourcesPage r = new ResourcesPage(driver);
			//search and select the category
			r.ResourcePage();
			r.Filter();
			r.DisableFilter();
		}
	}

