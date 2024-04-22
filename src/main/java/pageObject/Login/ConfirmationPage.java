package pageObject.Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPage {

	public WebDriver driver;

	public ConfirmationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = "h2.complete-header")
	WebElement thankYouMsg;

	@FindBy(css = "div.complete-text")
	WebElement thankYouDesc;

	public WebElement getThankYouMsg() {

		return thankYouMsg;

	}

	public WebElement getThankYouDesc() {
		return thankYouDesc;

	}

}
