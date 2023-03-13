package CompanyScripts;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericLib.BaseClass;
import pomPages.MarketingSystem_Certification;
import pomPages.QuestionBank_Certification;
import pomPages.Templates_Certification;
import pomPages.LoginPage;

public class compCertification extends BaseClass {
	
	@Test(priority=1)
	public void CertificationPage() throws IOException {
		LoginPage l = new LoginPage(driver);
		l.email_TF(p.getPropertyFiledata("emailid"));
		l.password_TF(p.getPropertyFiledata("password"));
		l.LoginButton();
		MarketingSystem_Certification ms = new MarketingSystem_Certification(driver);
		ms.certificationModule();
		String actual = driver.findElement(By.xpath("//span[@class='capitalTxt mainHdngTxt']")).getText();
		Assert.assertEquals(actual, "Certification Programme");
	}
	@Test(priority=2)
	public void Marketing_System() throws IOException {
		LoginPage l = new LoginPage(driver);
		l.email_TF(p.getPropertyFiledata("emailid"));
		l.password_TF(p.getPropertyFiledata("password"));
		l.LoginButton();
		MarketingSystem_Certification ms = new MarketingSystem_Certification(driver);
		ms.certificationModule();
		ms.MarketingSystem();
		ms.New();
		ms.EnterEcronymField1(p.getPropertyFiledata("EnterEcronymField1"));
		ms.EnterEcronymField2(p.getPropertyFiledata("EnterEcronymField2"));
		ms.AnotherField();
		ms.EnterEcronymField3(p.getPropertyFiledata("EnterEcronymField3"));
		ms.EnterEcronymField4(p.getPropertyFiledata("EnterEcronymField4"));
//		//When u Click on save
//		ms.Save();
//		String text = driver.findElement(By.xpath("//div[contains(text(),'Acronym created and unpublished successfully')]")).getText();
//		Assert.assertEquals(text, "Acronym created and unpublished successfully");
		ms.Publish();
		WebElement text2 = new WebDriverWait(driver, 10)
		         .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Acronym created and published successfully')]")));
		String actualText2 = text2.getText();
		Assert.assertEquals(actualText2, "Acronym created and published successfully");
		
		//delete marketing system
		ms.SearchMarketingSystem("EnterEcronymField1");
		ms.Delete();
		ms.ConfirmDelete();
		WebElement text3 = new WebDriverWait(driver, 10)
		         .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Acronym deleted successfully')]")));
		String actualText3 = text3.getText();
		Assert.assertEquals(actualText3, "Acronym deleted successfully");
		driver.findElement(By.xpath("//button[@class='Toastify__close-button Toastify__close-button--light']")).click();
	}
	@Test(priority=3)
	public void CreateQuestionBank() throws IOException, AWTException, InterruptedException {
		LoginPage l = new LoginPage(driver);
		l.email_TF(p.getPropertyFiledata("emailid"));
		l.password_TF(p.getPropertyFiledata("password"));
		l.LoginButton();
		MarketingSystem_Certification ms = new MarketingSystem_Certification(driver);
		ms.certificationModule();
	
		QuestionBank_Certification qb = new QuestionBank_Certification(driver);
		qb.Question_Bank();
		ms.New();
		qb.EnterQuestion(p.getPropertyFiledata("EnterQuestion"));	
		
		qb.DefaultMarks(Keys.chord(Keys.CONTROL,"a"),p.getPropertyFiledata("DefaultMarks"));
		qb.choiceQuestion();
		qb.Singlechoice();
		qb.AddAnswer01(p.getPropertyFiledata("AddAnswer01"));
		//qb.SelectAnswer01.click();
//		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", qb.AddAnswerButtondisplay);
		Thread.sleep(500);
		qb.AddAnswerButton();
		qb.SelectAnswer01.click();
		qb.AddAnswer02(p.getPropertyFiledata("AddAnswer02"));
		qb.AddAnswerButton();
		qb.AddAnswer03(p.getPropertyFiledata("AddAnswer03"));
		qb.AddAnswerButton();
		qb.AddAnswer04(p.getPropertyFiledata("AddAnswer04"));
		qb.SelectMarketingSystem();
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		//select marketing system.
		driver.findElement(By.xpath("//span[@class='flexInline headingSM pointer brdrBlackSM brdrRadiusXSM mcPdng']")).click();
		js.executeScript("arguments[0].scrollIntoView(true);",qb.PublishDisplay);
		js.executeScript("arguments[0].click()", qb.PublishDisplay);
//		qb.Publish();
		
		WebElement text2 = new WebDriverWait(driver, 10)
		         .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Question created and published successfully')]")));
		String actualText2 = text2.getText();
		Assert.assertEquals(actualText2, "Question created and published successfully");
		
		//delete question Bank
		driver.navigate().refresh();
		ms.certificationModule();
		qb.Question_Bank();
		WebElement threedots = driver.findElement(By.xpath("(//*[name()='svg'][@class='MuiSvgIcon-root MuiSvgIcon-colorPrimary MuiSvgIcon-fontSizeMedium pointer css-19h30gq'])[1]"));
		threedots.click();
		WebElement preview = driver.findElement(By.xpath("//div[@id='basic-menu']//li[1]//span[1]"));
		preview.isDisplayed();
		WebElement duplicate = driver.findElement(By.xpath("//div[@id='basic-menu']//li[1]"));
		duplicate.isDisplayed();
		WebElement Edit = driver.findElement(By.xpath("//div[@id='basic-menu']//li[1]"));
		Edit.isDisplayed();
		Thread.sleep(500);
		WebElement Delete = driver.findElement(By.xpath("(//li[@role='menuitem'])[4]"));
		Delete.click();
		ms.ConfirmDelete();
		
		WebElement text = new WebDriverWait(driver, 10)
		         .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Deleted Successfully')]")));
		String actualText = text.getText();
		Assert.assertEquals(actualText, "Deleted Successfully");
		}
	@Test(priority=4)
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
