package pageObject.Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public WebDriver driver;

	public HomePage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[contains(text(), 'Swag Labs')]")
	WebElement swageLabsHeader;

	@FindBy(xpath = "//span[contains(text(), 'Products')]")
	WebElement productLabel;

	@FindBy(name = "add-to-cart-sauce-labs-backpack")
	WebElement addToCartButton;

	@FindBy(css = "a.shopping_cart_link")
	WebElement getCartLink;

	public WebElement getHeader() {

		return swageLabsHeader;
	}

	public WebElement getShoppingLink() {

		return getCartLink;
	}

	public WebElement getProductLabel() {

		return productLabel;
	}

	public void addToCart() {

		addToCartButton.click();
	}

}
