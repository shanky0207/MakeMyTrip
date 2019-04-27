package com.makeMyTrip.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.makeMyTrip.util.BrowserSelection;
import com.makeMyTrip.util.WebEventListener;


public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static Logger log;
	public static WebDriverEventListener eventListener;
	public static EventFiringWebDriver eventfiringdriver;

	//to read the data from config.properties file
	public TestBase() {
		log = Logger.getLogger(this.getClass());
		FileInputStream propfile;
		prop = new Properties();
		try {

			propfile = new FileInputStream(".\\src\\main\\java\\com\\makeMyTrip\\config\\config.properties");
			prop.load(propfile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	//to do initilization of required browser
	public static void initilization() {
		driver = BrowserSelection.selectBrowser(prop.getProperty("browser"),prop.getProperty("platform"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		eventfiringdriver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		eventfiringdriver.register(eventListener);
		driver = eventfiringdriver;

		driver.get(prop.getProperty("url"));
		driver.manage().deleteAllCookies();

	}


	protected void waitForSeconds(long implicit_Wait) {
		try {
			Thread.sleep(implicit_Wait * 1000);
		} catch (InterruptedException e) {
		}
	}
}
