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
import pomPages.Certification_Certification;
import pomPages.LoginPage;
import pomPages.MarketingSystem_Certification;
import pomPages.QuestionBank_Certification;

	public class test extends BaseClass {
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
//			Thread.sleep(1000);
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
			Thread.sleep(3000);
			}
		
	}
		

