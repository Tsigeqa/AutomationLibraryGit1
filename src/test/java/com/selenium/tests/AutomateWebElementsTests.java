package com.selenium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.selenium.library.Base;

public class AutomateWebElementsTests extends Base {

	@Test
	public void learningCheckBox() {
		String websiteUrl ="https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_input_type_checkbox";
		driver.get(websiteUrl);
		WebElement checkBox2= driver.findElement(By.cssSelector("vehicle2"));
		checkBox2.click();
		myLibrary.sleep();
	}
}

