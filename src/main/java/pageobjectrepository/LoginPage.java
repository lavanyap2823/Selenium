package pageobjectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pageobjectmodel.BaseTest;

public class LoginPage extends BaseTest {

	By emailID=By.cssSelector("[name='email']");
	By password=By.cssSelector("[name='password']");
	By loginButton=By.cssSelector("[class*='submit']");
	By forgotPassword=By.cssSelector(".ui.message");
	
	public WebElement emailID()
	{
		return driver.findElement(emailID);
	}
	public WebElement password()
	{
		return driver.findElement(password);
	}
	public WebElement loginButton()
	{
		return driver.findElement(loginButton);
	}
	public WebElement forgotPassword()
	{
		return driver.findElement(forgotPassword);
	}
}
