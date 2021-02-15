package pageobjectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pageobjectmodel.BaseTest;

public class HomePage extends BaseTest {

	By userName=By.cssSelector(".user-display");
	
	public WebElement userName()
	{
		return driver.findElement(userName);
	}
}
