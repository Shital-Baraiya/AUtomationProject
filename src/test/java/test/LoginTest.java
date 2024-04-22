package test;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.TestBase;
import pageObject.Login.CheckoutOverview;
import pageObject.Login.CheckoutPage;
import pageObject.Login.ConfirmationPage;
import pageObject.Login.HomePage;
import pageObject.Login.LoginPage;
import pageObject.Login.YourCartPage;

public class LoginTest extends TestBase {


	LoginPage login;
	HomePage home;
	YourCartPage yourcart;
	CheckoutPage checkout;
	CheckoutOverview overview;
	ConfirmationPage confirmation;

	@BeforeClass
	public void setupClass() {
		login = new LoginPage(driver);
		home = new HomePage(driver);
		yourcart = new YourCartPage(driver);
		checkout = new CheckoutPage(driver);
		overview = new CheckoutOverview(driver);
		confirmation = new ConfirmationPage(driver);

	}

	@Test(priority = 0)
	public void loginUser() {

		login.doLogin("performance_glitch_user", "secret_sauce");
		String actualText = home.getProductLabel().getText();
		Assert.assertEquals(actualText, "Products");
		test.log(LogStatus.INFO, "Login Test Passed");

	}

	@Test(priority = 1, dependsOnMethods = "loginUser")
	public void addItemToCart() {
		
	home.addToCart();
	test.log(LogStatus.INFO, "Navigated to Products page");

	}
	
	@Test(priority = 2, dependsOnMethods = "addItemToCart", enabled = true)
	public void verifyCartDetailsTest() {
		
		home.getShoppingLink().click();
		test.log(LogStatus.INFO, "Navigated to Products page");
	}
	
	@Test(priority = 3, dependsOnMethods = "verifyCartDetailsTest", enabled = true)
	public void enterCheckOutInfoTest() throws InterruptedException {
		
		yourcart.doCheckout().click();

		checkout.addCheckoutInfo("Automation", "TestUser", "122009");
		checkout.checkoutClick();
		
	}
	
	@Test(priority = 4, dependsOnMethods = "enterCheckOutInfoTest", enabled = true)
	public void verifyCheckOutOverviewTest() {
		Assert.assertEquals(overview.getCardInfo().getText(), "SauceCard #31337");
		Assert.assertEquals(overview.getTotalPrice().getText(), "Total: $32.39");
		overview.getFinishButton().click();

	}
	
	@Test(priority = 5, dependsOnMethods = "verifyCheckOutOverviewTest", enabled = true)
	public void checkOutConfirmationTest() {
		
//		throw new SkipException("Development is still in progress so skipping this test!!");
		Assert.assertEquals(confirmation.getThankYouMsg().getText(), "Thank you for your order!");
		Assert.assertEquals(confirmation.getThankYouDesc().getText(),
				"Your order has been dispatched, and will arrive just as fast as the pony can get there!");

	}

}
