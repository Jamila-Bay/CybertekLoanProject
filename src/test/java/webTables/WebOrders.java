package webTables;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebOrders {
	static WebDriver driver;

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/cybertekchicago-1/Desktop/seleniumDependecy/drivers/chromedriver");
		 driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		
		driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
		
		WebElement username = driver.findElement(By.id("ctl00_MainContent_username"));
		WebElement pass = driver.findElement(By.id("ctl00_MainContent_password"));
		WebElement loginBtn = driver.findElement(By.id("ctl00_MainContent_login_button"));
		String usernameValue = "Tester";
		String passValue = "test";
		
		username.sendKeys(usernameValue);
		pass.sendKeys(passValue);
		loginBtn.click();
		
		printValues("Date");
		printValues("Street");
		
	}
	/**
	 * Please enter the header value
	 * By default for invalid header method prints out the names
	 * @param header
	 */
	public static void printValues(String header) {
		String xpath = "";
		switch(header) {
		case "Name":
			xpath = "//table[@class='SampleTable']//tr/td[2]";
			break;
		case "Product":
			xpath = "//table[@class='SampleTable']//tr/td[3]";
			break;
		case "Date":
			xpath = "//table[@class='SampleTable']//tr/td[5]";
			break;
		case "Street":
			xpath = "//table[@class='SampleTable']//tr/td[6]";
			break;
		case "City":
			xpath = "//table[@class='SampleTable']//tr/td[7]";
			break;
		default:
			xpath = "//table[@class='SampleTable']//tr/td[2]";
			break;
			
		}
		List<WebElement> data = driver.findElements(By.xpath(xpath));
		
		for(WebElement d: data) {
			System.out.println(header + ": " + d.getText());
		}
		
	}
}