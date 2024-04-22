package pageObject.Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver driver;
	
	public LoginPage(WebDriver driver){
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//input[@placeholder='Username']")
	WebElement username;
	
	@FindBy(css = "input#password")
	WebElement password;
	
	@FindBy(id = "login-button")
	WebElement loginButton;
	
	public void doLogin(String uname, String pass) {
		
		username.sendKeys(uname);
		password.sendKeys(pass);
		loginButton.click();
		
	}

}
