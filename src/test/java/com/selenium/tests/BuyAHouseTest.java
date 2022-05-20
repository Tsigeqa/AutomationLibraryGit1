package com.selenium.tests;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.selenium.library.Base;

public class BuyAHouseTest extends Base {

	private String url = "https://www.mortgagecalculator.net/";

	@Test
	public void buyASignleHouseTest() {
		try {
			// Goto the website
			driver.get(url);

			// hard coded wait / pause
			Thread.sleep(2 * 1000);

			// Step1: locating mortgage amount text field
			WebElement amountTextElement = driver.findElement(By.id("amount"));
			amountTextElement.clear();
			amountTextElement.sendKeys("450000");

			// Step2: locating amortization years
			WebElement amortYear = driver.findElement(By.cssSelector("#amortizationYears"));
			amortYear.clear();
			amortYear.sendKeys("29");

			// Step2.1: locating amortization months
			WebElement amortMonth = driver.findElement(By.xpath("//*[@id='amortizationMonths']"));
			amortMonth.clear();
			amortMonth.sendKeys("12");

			// Step3: locating interest term years
			WebElement interTerYear = driver.findElement(By.cssSelector("#interestTermYears"));
			interTerYear.clear();
			interTerYear.sendKeys("2");

			// Step3.1: locating interest term months
			WebElement interTerMonth = driver.findElement(By.id("interestTermMonths"));
			interTerMonth.clear();
			interTerMonth.sendKeys("5");

			// Step4: locating interest type drop-down
			WebElement inteTypeDropDown = driver.findElement(By.cssSelector("#interestType"));
			Select dropdown1 = new Select(inteTypeDropDown);
			dropdown1.selectByVisibleText("Fixed");

			// Step5: locating interest rate
			WebElement intRateElem = driver.findElement(By.cssSelector("#rate"));
			intRateElem.clear();
			intRateElem.sendKeys("3.0");

			// Step6: locating start month
			WebElement startMo = driver.findElement(By.id("startMonth"));
			Select dropdownMo = new Select(startMo);
			dropdownMo.selectByIndex(1);

			// Step6.1: locating start year
			WebElement startYear = driver.findElement(By.id("startYear"));
			Select dropdownYear = new Select(startYear);
			dropdownYear.selectByValue("2023");

			// Step7: locating payment period
			WebElement paymentMode = driver.findElement(By.cssSelector("#paymentMode"));
			Select dropdownSemiMonthly = new Select(paymentMode);
			dropdownSemiMonthly.selectByVisibleText("Semi-Monthly");

			// Step8: locating calculate now button
			WebElement buttonElem = driver.findElement(By.id("button"));
			buttonElem.click();

			// Before Selenium Version 4
			// WebDriverWait wait = new WebDriverWait(driver, 30);

			// Thread.sleep(5 * 1000);
			// ExplicitWait
			// After Selenium Version 4
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			WebElement monthlyPaymentElem = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.id("summaryMonthly")));

			// Step9: locating the monthly payment and extract the amount text
			// WebElement monthlyPaymentElem = driver.findElement(By.id("summaryMonthly"));
			String resultText = monthlyPaymentElem.getAttribute("value");

			// String resultText = monthlyPaymentElem.getText();
			// System.out.println("Default monthly payment is: $1,073.64 ");
			System.out.println("Actual result monthly payment is: " + resultText);

			assertEquals(resultText, "$1,897.22");

			Thread.sleep(5 * 1000);

		} catch (Exception e) {
			e.printStackTrace();
			// we need to close the browser even if there is test step fails
			// if (driver != null) {
			// driver.close(); /// driver object is not null here and just close the browser
			// only.
			// driver.quit(); /// close the browser than program will terminate/kill the
			// driver object than
			/// driver become "null"
			assertEquals(true, false);
		}
		
	}
}