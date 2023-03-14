package CompanyScripts;

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
	public void CreateMarketing_SystemDelete() throws IOException {
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
	public void CreateQuestionBankDelete() throws IOException, AWTException, InterruptedException {
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
		WebElement Delete = new WebDriverWait(driver, 10)
		         .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='basic-menu']//li[4]")));
		js.executeScript("arguments[0].click();", Delete);
//		Delete.click();
		ms.ConfirmDelete();
		
		WebElement text = new WebDriverWait(driver, 10)
		         .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Deleted Successfully')]")));
		String actualText = text.getText();
		Assert.assertEquals(actualText, "Deleted Successfully");
		}
	
	@Test(priority=4)
	public void CreateTemplatDelete() throws IOException, AWTException, InterruptedException {
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
	
	@Test(priority=5)
	public void CreateCertificationDelete() throws IOException, AWTException, InterruptedException {
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
		
		//delete certification
		driver.navigate().refresh();
		cc.certification();
		Thread.sleep(2000);
		cc.search(p.getPropertyFiledata("ProgramName"));
		//open the certification
		driver.findElement(By.xpath("//div[@class='flexMinWidthCol titleHeading pdngHXS justifyCntr']")).click();
		//delete
		driver.findElement(By.xpath("(//*[name()='svg'][@aria-label='Delete'])[1]")).click();
		ms.ConfirmDelete();
		WebElement textt  = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Deleted Successfully')]")));
		String actualTextt = textt.getText();
		Assert.assertEquals(actualTextt, "Deleted Successfully");
		
	}
	
}
