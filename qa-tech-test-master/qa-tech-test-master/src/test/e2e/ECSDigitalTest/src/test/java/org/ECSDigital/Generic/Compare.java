package org.ECSDigital.Generic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Compare {
	
	public static boolean validateElementExistByXpath(WebDriver driver, String xpath) {
		boolean output=false;
		try	{
			driver.findElement(By.xpath(xpath));
			output=true;
		}
		catch(Exception e){}
			return output;
	}
}
