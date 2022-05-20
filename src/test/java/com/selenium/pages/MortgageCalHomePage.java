package com.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.selenium.library.Base;

public class MortgageCalHomePage extends Base {

	private String url = "https://www.mortgagecalculator.net/";
	private WebDriver driver;

	public MortgageCalHomePage(WebDriver _driver) {
		driver = _driver;
	}

	public MortgageCalHomePage gotoMortgageCalculatorWebsite() {
		// Goto the website
		driver.get(url);
		return this;
	}

	public MortgageCalHomePage enterMortgageAmount(String amount) {
		// Step1: locating mortgage amount text field
		WebElement amountTextElement = driver.findElement(By.id("amount"));
		amountTextElement.clear();
		amountTextElement.sendKeys(amount);

		return this;
	}

	public MortgageCalHomePage enterAmortYearMonth(String amortYear, String amortMonth) {
		// locating amortization years
		WebElement amortYearElem = driver.findElement(By.cssSelector("#amortizationYears"));
		amortYearElem.clear();
		amortYearElem.sendKeys(amortYear);

		// locating amortization month
		WebElement amortMonthElem = driver.findElement(By.xpath("//*[@id='amortizationMonths']"));
		amortMonthElem.clear();
		amortMonthElem.sendKeys(amortMonth);

		return this;
	}

	public MortgageCalHomePage enterIntYearMonth(String inteYear, String inteMonth) {
		// locating interest term years
		WebElement interTerYear = driver.findElement(By.cssSelector("#interestTermYears"));
		interTerYear.clear();
		interTerYear.sendKeys(inteYear);

		// locating interest term months
		WebElement interTerMonth = driver.findElement(By.id("interestTermMonths"));
		interTerMonth.clear();
		interTerMonth.sendKeys(inteMonth);

		return this;
	}

	public MortgageCalHomePage selectInterestType(String inteTypeVisibleText) {
		// locating interest type drop-down
		WebElement inteTypeDropDown = driver.findElement(By.cssSelector("#interestType"));
		Select dropdown1 = new Select(inteTypeDropDown);
		dropdown1.selectByVisibleText(inteTypeVisibleText);

		return this;
	}

	public MortgageCalHomePage enterInterestRate(String inteRate) {
		// locating interest rate
		WebElement intRateElem = driver.findElement(By.cssSelector("#rate"));
		intRateElem.clear();
		intRateElem.sendKeys(inteRate);

		return this;
	}

	public MortgageCalHomePage selectStartMonthYear(int startMonth, String startYear) {

		// locating start month
		WebElement startMo = driver.findElement(By.id("startMonth"));
		Select dropdownMo = new Select(startMo);
		dropdownMo.selectByIndex(startMonth);

		// locating start year
		WebElement startYearElem = driver.findElement(By.id("startYear"));
		Select dropdownYear = new Select(startYearElem);
		dropdownYear.selectByValue(startYear);

		return this;
	}

	public MortgageCalHomePage selectPaymentPeriod(String paymentMode) {
		// locating payment period
		WebElement paymentModeElem = driver.findElement(By.cssSelector("#paymentMode"));
		Select dropdownSemiMonthly = new Select(paymentModeElem);
		dropdownSemiMonthly.selectByVisibleText(paymentMode);

		return this;
	}

	public MortgageCalResultsPage clickCalculateNowBtn() {
		// locating calculate now button
		WebElement buttonElem = driver.findElement(By.id("button"));
		buttonElem.click();

		MortgageCalResultsPage tempResultPage = new MortgageCalResultsPage(driver);

		return tempResultPage;
	}

}
