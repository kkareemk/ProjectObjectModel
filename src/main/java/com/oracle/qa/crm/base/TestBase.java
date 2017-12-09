package com.oracle.qa.crm.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.oracle.qa.crm.utility.TestUtil;
import com.oracle.qa.crm.utility.WebEventListener;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver eventFiringWebDriver;
	public static WebEventListener webEventListener;
	
	
	
	public TestBase() {
		// TODO Auto-generated constructor stub
		
		try {
			prop = new Properties();
			FileInputStream io = new FileInputStream("C:\\AutomationWS\\FirstCRMTest\\src\\main\\java\\com\\oracle\\qa\\crm\\config\\config.properties");
			prop.load(io);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void initialization() {
		// TODO Auto-generated method stub		
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\karkhan.ORADEV\\Downloads\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}else if(browserName.equals("FF")){
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\karkhan.ORADEV\\Downloads\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		eventFiringWebDriver = new EventFiringWebDriver(driver);
		webEventListener = new WebEventListener();
		
		eventFiringWebDriver.register(webEventListener);
		driver = eventFiringWebDriver;
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_TIME_LOAD, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_TIMEOUT, TimeUnit.SECONDS);			
		driver.get(prop.getProperty("url"));

	}
	
	
	

}
