package appModules;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
	
	public static WebDriver driver;
	public static Properties properties;
	private final String propertyFilePath = "configs//Configuration.properties";


	/**
	 * Author: Mayuri Otari
	 * Purpose: Method to initialize Property file
	 */
	public BaseTest() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}
	}
	
	/**
	 * Author: Mayuri Otari
	 * Purpose: Method to get the Chrome Driver
	 */
	public WebDriver getDriver() {
		if(driver==null)
			driver= new ChromeDriver();
		return driver;
	}
	
	/**
	 * Author: Mayuri Otari
	 * Purpose: Method to get the driver path
	 */
	public static String getDriverPath() {
		String driverPath = properties.getProperty("driverPath");
		if (driverPath != null)
			return driverPath;
		else
			throw new RuntimeException(
					"Driver Path not specified in the Configuration.properties file for the Key:driverPath");
	}
	
	
	/**
	 * Author: Mayuri Otari
	 * Purpose: Method to setup a driver
	 */
	public static void setUp() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + getDriverPath());
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(properties.getProperty("amazonURL"));
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

}
