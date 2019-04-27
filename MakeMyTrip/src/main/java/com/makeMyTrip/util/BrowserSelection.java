package com.makeMyTrip.util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.makeMyTrip.base.TestBase;


public class BrowserSelection extends TestBase {

	//to select the browser on which we want to execute the test cases.
	public static WebDriver selectBrowser(String browserName, String platform) {

		if (browserName.equalsIgnoreCase("chrome") && platform.equalsIgnoreCase("WINDOWS")) {
			System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver_win32\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			capabilities.setPlatform(org.openqa.selenium.Platform.WINDOWS);
			driver = new ChromeDriver(capabilities);
			
		}
		else if(browserName.equalsIgnoreCase("chrome") && platform.equalsIgnoreCase("MAC")) {
				System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver_win32\\chromedriver.exe");
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--incognito");
				DesiredCapabilities capabilities = DesiredCapabilities.chrome();
				capabilities.setCapability(ChromeOptions.CAPABILITY, options);
				capabilities.setPlatform(org.openqa.selenium.Platform.MAC);
				driver = new ChromeDriver(capabilities);
				//driver = new ChromeDriver();

			}
		
		else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", ".\\lib\\geckodriver-v0.21.0-win32\\geckodriver.exe");
			driver = new FirefoxDriver();

		} else if (browserName.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", ".\\lib\\IEDriverServer_Win32_3.13.0\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();

		} else {
			System.out.println("Unable to launch the browser=" + browserName);

		}

		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		return driver;
	}

}
