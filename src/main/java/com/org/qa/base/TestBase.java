package com.org.qa.base;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.org.qa.utility.ExtentReport;
import com.org.qa.utility.Log;
import com.org.qa.utility.PropertyFileReader;
import com.org.qa.utility.WebEventListener;
import com.relevantcodes.extentreports.ExtentReports;

/**
 * @author Gopal Pandey
 *
 */
public class TestBase {

	public static WebDriver driver;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	public static Logger log;

	public TestBase() {

	}

	public static WebDriver initization() {
		
		String browserName = PropertyFileReader.browser();
	
		if (browserName.equals("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			System.setProperty("webdriver.chrome.driver", PropertyFileReader.getCromeDriver());
			Log.info("Opening in Crome Browser", log);
			driver = new ChromeDriver(options);
			
		} else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", PropertyFileReader.getFireFoxDriver());
			driver = new FirefoxDriver();
			
		} else if (browserName.equals("ie")) {
			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
			System.setProperty("webdriver.ie.driver", PropertyFileReader.getIEDriver());
			driver = new InternetExplorerDriver(capabilities);
		}
		e_driver = new EventFiringWebDriver(driver);

		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		driver.manage().window().maximize();
//		driver.manage().deleteAllCookies();
//		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		Log.LogFunc(log);		
		return driver;
	}

	public static ExtentReports getReport() {
		ExtentReports report = ExtentReport.generateReport();	
		return report;
	}

	public static Logger getLogger() {
		log = Log.logg(TestBase.class);
		PropertyConfigurator.configure("Log4j.properties");	
		return log;
	}

}
