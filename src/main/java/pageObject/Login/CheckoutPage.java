package pageObject.Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {

	public WebDriver driver;

	public CheckoutPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = "input#first-name")
	WebElement firstname;

	@FindBy(css = "input#last-name")
	WebElement lastname;

	@FindBy(css = "input#postal-code")
	WebElement postalcode;

	@FindBy(css = "input.submit-button.btn.btn_primary.cart_button.btn_action")
	WebElement submitButton;

	public void addCheckoutInfo(String fname, String lname, String pcode) {
		firstname.sendKeys(fname);
		lastname.sendKeys(lname);
		postalcode.sendKeys(pcode);

	}

	public void checkoutClick() {
		submitButton.click();

	}

}
