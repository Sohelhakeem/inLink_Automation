package CompanyScripts;


	import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericLib.BaseClass;
import pomPages.MarketingSystem_Certification;
import pomPages.QuestionBank_Certification;
import pomPages.Templates_Certification;
import pomPages.LoginPage;

	public class test extends BaseClass {
		@Test
		public void CreateTemplate() throws IOException, AWTException, InterruptedException {
			LoginPage l = new LoginPage(driver);
			l.email_TF(p.getPropertyFiledata("emailid"));
			l.password_TF(p.getPropertyFiledata("password"));
			l.LoginButton();
			MarketingSystem_Certification ms = new MarketingSystem_Certification(driver);
			ms.certificationModule();
			Templates_Certification ct = new Templates_Certification(driver);
			ct.TemplatesFeature();
			ms.New();
			ct.SelectTemplate();
			ct.EnterCerificateName(p.getPropertyFiledata("CerificateName"));
			ct.EnterCerificateProgramName(p.getPropertyFiledata("ProgramName"));
			ct.PresentedTo(p.getPropertyFiledata("PresentedTo"));
			ct.EnterNameOfBenificiary(p.getPropertyFiledata("BenificiaryName"));
			ct.EnterDescription(p.getPropertyFiledata("Description"));
			ct.logo(p.getPropertyFiledata("Logo"));
			ct.SaveImage();
			ct.sign(p.getPropertyFiledata("Sign"));
			ct.SaveImage();
			ct.stamp(p.getPropertyFiledata("Stamp"));
			ct.SaveImage();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", ct.PublishDisplay);
			js.executeScript("arguments[0].click()", ct.PublishDisplay);
			WebElement text2 = new WebDriverWait(driver, 10)
			         .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Published Successfully')]")));
			String actualText2 = text2.getText();
			Assert.assertEquals(actualText2, "Published Successfully");
			
			
			//Delete Template
			
			driver.navigate().refresh();
			ct.TemplatesFeature();
			ms.SearchMarketingSystem(p.getPropertyFiledata("CerificateName"));
			WebElement delete = driver.findElement(By.xpath("(//*[name()='svg'][contains(@aria-label,'Delete')])[1]"));
			delete.click();
			ms.ConfirmDelete();
			
			WebElement text  = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Deleted Successfully')]")));
			String actualText = text.getText();
			Assert.assertEquals(actualText, "Deleted Successfully");
			}
		
		
	}

