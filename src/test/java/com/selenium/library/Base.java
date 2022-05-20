package com.selenium.library;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.selenium.library.SeleniumGlobalLibrary.Browser;

public class Base {

	public WebDriver driver;
	public SeleniumGlobalLibrary myLibrary;

	@BeforeClass
	public void beforeAllTestMethods() {
		System.out.println("Automation Test suite started ...");
	}

	@AfterClass
	public void cleanAfterAllTestMethods() {
		if (driver != null) {
			driver.quit();
		}
		System.out.println("Automated Test suite ended ...");
	}

	// setupBeforeEachTest
	@BeforeMethod
	public void setUp() {
		try {
			System.out.println("Running before test setup ...");
			myLibrary = new SeleniumGlobalLibrary();
			// driver = myLibrary.startABrowser(Browser.CHROME);
			driver = myLibrary.startABrowser(Browser.EDGE_CHROMIUM);
			myLibrary.setDriver(driver);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// cleanUpAfterEachTest
	@AfterMethod
	public void cleanUp() {
		System.out.println("Running after test cleanup ...");
		if (driver != null) {
			driver.close();
		}
	}

}