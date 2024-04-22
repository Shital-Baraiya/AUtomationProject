package pageObject.Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourCartPage {

	public WebDriver driver;

	public YourCartPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "div.inventory_item_name")
	WebElement itemName;

	@FindBy(css = "div.inventory_item_price")
	WebElement price;

	@FindBy(css = "button#checkout")
	WebElement checkoutButton;

	public WebElement getItemName() {

		return itemName;
	}

	public WebElement getPrice() {

		return price;
	}

	public WebElement doCheckout() {
		return checkoutButton;

	}

}
