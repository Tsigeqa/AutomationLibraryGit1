package com.selenium.library;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

/***
 * This class is to create wrapper methods for basic selenium functions.
 * 
 * @author Musabay Class is created 01/15/2022
 *
 */
public class SeleniumGlobalLibrary {
	private WebDriver driver;

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	private int waitTimeInSec = 30;

	/***
	 * This enum is for browser options.
	 * 
	 * @author Musabay
	 * 
	 */
	public enum Browser {
		CHROME, FIREFOX, SAFARI, EDGE_CHROMIUM
	}

	/***
	 * This sleep method for hard pause for 5 seconds
	 */
	public void sleep() {
		try {
			Thread.sleep(5 * 1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/***
	 * This method starts browser and receives Browser enum as parameter.
	 * 
	 * @param browser
	 * @return WebDriver
	 */
	public WebDriver startABrowser(Browser browser) {
		try {
			switch (browser) {

			case CHROME:
				driver = startChromeBrowser();
				break;

			case FIREFOX:
				driver = startFirefoxBrowser();
				break;

			case SAFARI:
				driver = startSafariBrowser();
				break;

			case EDGE_CHROMIUM:
				driver = startEdgeChromiumBrowser();
				break;

			default:
				System.out.println("Currently framework do not support this type of browser !");
				System.out.println("Default browser set to 'Chrome' ");
				driver = startChromeBrowser();
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return driver;
	}

	/***
	 * This method starts Microsoft Edge Chromium Browser
	 * 
	 * @return WebDriver
	 */
	private WebDriver startEdgeChromiumBrowser() {
		System.setProperty("webdriver.edge.driver", "src/test/resources/drivers/msedgedriver.exe");
		driver = new EdgeDriver();
		sleep();

		setWebsiteWaits();
		return driver;
	}

	/***
	 * This method starts Apple Safari Browser
	 * 
	 * @return WebDriver
	 */
	private WebDriver startSafariBrowser() {
		System.err.println(" This method is not implemented yet! start Safari !");

		setWebsiteWaits();
		return driver;
	}

	/***
	 * This method starts Firefox Browser
	 * 
	 * @return WebDriver
	 */
	private WebDriver startFirefoxBrowser() {
		System.err.println(" This method is not implemented yet! start Firefox !");

		setWebsiteWaits();
		return driver;
	}

	/***
	 * This method starts Google Chrome Browser
	 * 
	 * @return WebDriver
	 */
	private WebDriver startChromeBrowser() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		// Start a Chrome browser
		driver = new ChromeDriver();
		// Maximize the browser window
		sleep();
		setWebsiteWaits();

		return driver;
	}

	/***
	 * This method combines Selenium pageLoadWait, impliciteWait, scriptTimeout
	 * waits.
	 */
	private void setWebsiteWaits() {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitTimeInSec));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(waitTimeInSec));
			driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(waitTimeInSec));
			driver.manage().window().maximize();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}