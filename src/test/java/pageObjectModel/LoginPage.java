package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="user_name")
	public WebElement username;
	
	@FindBy(id="username_password")
	public WebElement password;
	
	@FindBy(id="bigbutton")
	public WebElement loginBtn;

}
