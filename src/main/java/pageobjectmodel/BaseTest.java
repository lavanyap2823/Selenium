package pageobjectmodel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BaseTest {

	public static Properties prop;
	public static WebDriver driver;
	public void getProperties() throws IOException
	{
		try
		{
		prop= new Properties();
		FileInputStream fis= new FileInputStream("resources\\config.properties");
		prop.load(fis);
		//prop.getProperty("browser");
		System.out.println(prop.getProperty("browser"));
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	public WebDriver initializeDriver() throws IOException
	{
		getProperties();
		String browserName=prop.getProperty("browser");
		System.out.println(browserName);
		
		if("chrome".equalsIgnoreCase(browserName))
		{
			System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
			driver= new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "resources\\gechodriver.exe");
			driver=new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver", "resources\\IEDriverServer.exe");
			driver= new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		return driver;
		
	}
	
}
