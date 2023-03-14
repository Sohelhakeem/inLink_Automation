package endToendTests;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericLib.BaseClass;
import pomPages.MarketingSystem_Certification;
import pomPages.QuestionBank_Certification;
import pomPages.Templates_Certification;
import pomPages.Certification_Certification;
import pomPages.LoginPage;

public class Certifications extends BaseClass {
	@Test(priority=1)
	public void CreateMarketing_System() throws IOException {
		LoginPage l = new LoginPage(driver);
		l.email_TF(p.getPropertyFiledata("emailid"));
		l.password_TF(p.getPropertyFiledata("password"));
		l.LoginButton();
		//Create Certification_MarketingSystem
		MarketingSystem_Certification ms = new MarketingSystem_Certification(driver);
		ms.certificationModule();
		ms.MarketingSystem();
		ms.New();
		ms.EnterEcronymField1(p.getPropertyFiledata("EnterEcronymField1"));
		ms.EnterEcronymField2(p.getPropertyFiledata("EnterEcronymField2"));
		ms.AnotherField();
		ms.EnterEcronymField3(p.getPropertyFiledata("EnterEcronymField3"));
		ms.EnterEcronymField4(p.getPropertyFiledata("EnterEcronymField4"));
		ms.Publish();
		WebElement text2 = new WebDriverWait(driver, 10)
		         .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Acronym created and published successfully')]")));
		String actualText2 = text2.getText();
		Assert.assertEquals(actualText2, "Acronym created and published successfully");
		ms.SearchMarketingSystem("EnterEcronymField1");
	}
	@Test(priority=2)
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
		
		WebElement text2 = new WebDriverWait(driver, 10)
		         .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Question created and published successfully')]")));
		String actualText2 = text2.getText();
		Assert.assertEquals(actualText2, "Question created and published successfully");
		
		}
	@Test(priority=3)
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
	
		}
	@Test(priority=4)
	public void CreateCertificate() throws IOException, AWTException, InterruptedException {
		LoginPage l = new LoginPage(driver);
		l.email_TF(p.getPropertyFiledata("emailid"));
		l.password_TF(p.getPropertyFiledata("password"));
		l.LoginButton();
		MarketingSystem_Certification ms = new MarketingSystem_Certification(driver);
		ms.certificationModule();
		Certification_Certification cc = new Certification_Certification(driver);
		cc.certification();
		ms.New();
		cc.programName(p.getPropertyFiledata("ProgramName"));
		cc.Editor(p.getPropertyFiledata("ProgramName"));
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement text = new WebDriverWait(driver, 10)
		         .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@class,'lightTxt pdngVXS')]")));
		js.executeScript("arguments[0].scrollIntoView(true);", text);
		text.isDisplayed();
		Thread.sleep(1000);
		WebElement marketing =driver.findElement(By.id("demo-simple-select"));
		
		Actions actions = new Actions(driver);
		actions.click().perform();
		Thread.sleep(500);
		marketing.click();
		
		Robot r = new Robot ();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(500);
		
		cc.NeedField1(Keys.chord(Keys.CONTROL,"a"),"1");
		
		WebElement text1 = new WebDriverWait(driver, 10)
		         .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Duration - in minutes']")));
		js.executeScript("arguments[0].scrollIntoView(true);", text1);
		text1.isDisplayed();
		cc.defaultPercentage("35");
		cc.defaultReApplyDay("5");
		
		Thread.sleep(500);
		WebElement text2 = new WebDriverWait(driver, 10)
		         .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='lightTxt headingSM pdngXS']")));
		js.executeScript("arguments[0].scrollIntoView(true);", text2);
		Thread.sleep(500);
		text2.isDisplayed();
		
		cc.durationHrsDD();
		Thread.sleep(500);
		cc.Select00Hrs();
		cc.durationMinDD();
		Thread.sleep(500);
		cc.Select05min();
		
		cc.QuestionChoiceTypeDD();
		cc.QuestionChoiceTypeAB();
		cc.Template();
		cc.selectTemplate();
		driver.findElement(By.xpath("//li[normalize-space()='Core Java Programming']")).click();
		cc.previewTemplate();
		cc.CancelpreviewTemplate();
		
		WebElement publish = driver.findElement(By.xpath("//button[normalize-space()='Publish']"));
		js.executeScript("arguments[0].scrollIntoView(true);", publish);
		Thread.sleep(500);
		publish.click();
		
		cc.ConfirmPublish();
		WebElement text5 = new WebDriverWait(driver, 10)
		         .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Published Successfully')]")));
		String actualText5 = text5.getText();
		Assert.assertEquals(actualText5, "Published Successfully");
		
	}
	@Test(priority=5)
	public void testDisplayed() throws IOException, AWTException, InterruptedException {
		LoginPage l = new LoginPage(driver);
		l.email_TF("elon1@yopmail.com");
		l.password_TF("Inlink@123");
		l.LoginButton();
		MarketingSystem_Certification ms = new MarketingSystem_Certification(driver);
		ms.certificationModule();
		Thread.sleep(2000);
		WebElement search = driver.findElement(By.xpath("//input[@type='search']"));
		search.sendKeys(p.getPropertyFiledata("ProgramName"));
		
		WebElement getCertificate = driver.findElement(By.xpath("(//button[@type='button'][normalize-space()='GET CERTIFICATE'])[1]"));
		getCertificate.click();
		
		WebElement SelectCheckbox = driver.findElement(By.xpath("//input[@type='checkbox']"));
		SelectCheckbox.click();
		
		WebElement TakeTestBtn = driver.findElement(By.xpath("//button[normalize-space()='TAKE A TEST']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", TakeTestBtn);
		TakeTestBtn.isDisplayed();
		
		}
	
}
