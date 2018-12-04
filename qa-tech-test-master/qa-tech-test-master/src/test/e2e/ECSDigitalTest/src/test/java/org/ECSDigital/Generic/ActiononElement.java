package org.ECSDigital.Generic;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class ActiononElement {
	
	public static void clickButton(WebDriver driver, String xpath) {
		
		try	{
			driver.findElement(By.xpath(xpath)).click();
		}
		catch (NoSuchElementException e) {
            e.printStackTrace();
		}
	}
	
	public static void enterText(WebDriver driver, String xpath, String value) {
		try	{
			driver.findElement(By.xpath(xpath)).sendKeys(value);
		}
		catch (NoSuchElementException e) {
            e.printStackTrace();
		}
		
	}

}
