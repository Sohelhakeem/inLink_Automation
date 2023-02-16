package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
@FindBy(xpath="//div[@class='flexMinWidthCol pdngXS']")
private WebElement logoutBtn;

public LogoutPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

public void LogoutButton() {
	logoutBtn.click();
}
}
