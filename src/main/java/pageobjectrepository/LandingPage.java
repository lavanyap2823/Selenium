package pageobjectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pageobjectmodel.BaseTest;


public class LandingPage extends BaseTest{

	//public WebDriver driver;
	By login=By.xpath("//span[text()='Log In']");
	
	public WebElement loginButton()
	{
		return driver.findElement(login);
	}
}
