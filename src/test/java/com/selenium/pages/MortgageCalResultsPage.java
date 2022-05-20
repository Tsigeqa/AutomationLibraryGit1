package com.selenium.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium.library.Base;

public class MortgageCalResultsPage extends Base {

	// Class instance variable
	private WebElement monthlyPaymentElem;
	private WebDriver driver;

	// constructor - special method

	public MortgageCalResultsPage(WebDriver _driver) {
		// Local object/variable
		driver = _driver;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		monthlyPaymentElem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("summaryMonthly")));
	}

	public MortgageCalResultsPage getMonthlyPayment() {

		//

		return this;
	}

	public String getMonthPaymentText() {
		String resultText = monthlyPaymentElem.getAttribute("value");
		System.out.println("Actual result monthly payment is: " + resultText);

		return resultText;
	}

}