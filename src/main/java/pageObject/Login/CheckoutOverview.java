package pageObject.Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutOverview {

	public WebDriver driver;

	public CheckoutOverview(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//div[@class='summary_value_label'][1]")
	WebElement cardInfo;

	@FindBy(xpath = "//div[@class='summary_value_label'][2]")
	WebElement shippingInfo;

	@FindBy(css = "div.summary_subtotal_label")
	WebElement subTotal;

	@FindBy(css = "div.summary_tax_label")
	WebElement tax;

	@FindBy(css = "div.summary_total_label")
	WebElement totalPrice;

	@FindBy(css = "button#finish")
	WebElement finishButton;

	public WebElement getCardInfo() {
		return cardInfo;

	}

	public WebElement getShippingInfo() {
		return shippingInfo;

	}

	public WebElement getSubTotal() {
		return subTotal;

	}

	public WebElement getTax() {
		return tax;

	}

	public WebElement getTotalPrice() {
		return totalPrice;

	}

	public WebElement getFinishButton() {
		return finishButton;
	}

}
