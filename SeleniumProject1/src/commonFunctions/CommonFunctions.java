package commonFunctions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class CommonFunctions {
	public static Properties property= null;
	public static WebDriver driver=null;
	static Logger logger=Logger.getLogger(CommonFunctions.class);
	
	public Properties loadproperty() throws IOException
	{
		FileInputStream file = new FileInputStream("config.properties");
		 property = new Properties();
		property.load(file);
		return property;
	}
	
	@BeforeSuite
public void lanchbrowser() throws IOException
{
		PropertyConfigurator.configure("log4j.properties");
		logger.info("Orange HRM test begins");
		logger.info("Loding the propertyfile");
		loadproperty();
	String browser=property.getProperty("browser");
	String Url = property.getProperty("url");
	String DriverLocation=property.getProperty("driverlocation");
	if(browser.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver",DriverLocation);
		logger.info("Lanching chrome browser");
		driver= new ChromeDriver();
	}
	else if(browser.equalsIgnoreCase("firefox")) {
		System.setProperty("webdriver.gecko.driver",DriverLocation);
		logger.info("Lanching Firefox browser");
		driver= new FirefoxDriver();
	}
	driver.manage().window().maximize();
	logger.info("Navigate to Application");
	driver.get(Url);
	driver.manage().timeouts().implicitlyWait(4000, TimeUnit.SECONDS);
}
	@AfterSuite
public void closing()
{
	logger.info("Execution done ...closing");	
	 driver.quit();
	
}
}
