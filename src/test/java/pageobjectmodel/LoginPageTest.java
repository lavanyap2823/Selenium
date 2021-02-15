package pageobjectmodel;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjectrepository.HomePage;
import pageobjectrepository.LandingPage;
import pageobjectrepository.LoginPage;

public class LoginPageTest extends BaseTest {

	LandingPage landingPage= new LandingPage();
	LoginPage loginPage= new LoginPage();
	HomePage homePage= new HomePage();
	
	@Test
	public void loginPage() throws IOException
	{
		driver=initializeDriver();
		landingPage.loginButton().click();
		loginPage.emailID().sendKeys(prop.getProperty("emailid"));
		loginPage.password().sendKeys(prop.getProperty("password"));
		loginPage.loginButton().click();
		String userName=homePage.userName().getText();
		Assert.assertEquals(userName, "Lavanya P");
		
		
		
	}
}
