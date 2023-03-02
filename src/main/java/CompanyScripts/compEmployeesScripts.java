package CompanyScripts;

import java.io.IOException;

import org.testng.annotations.Test;

import genericLib.BaseClass;
import pomPages.LoginPage;

public class compEmployeesScripts extends BaseClass {
//Sign Up as a Employee Under the Company.
//reject and approve 1 for both
//keep in pending 1
	@Test
	public void tc1() throws IOException {
	LoginPage l=new LoginPage(driver);
	l.email_TF(p.getPropertyFiledata("emailid"));
	l.password_TF(p.getPropertyFiledata("password"));
	l.LoginButton();
	
	

	}
}