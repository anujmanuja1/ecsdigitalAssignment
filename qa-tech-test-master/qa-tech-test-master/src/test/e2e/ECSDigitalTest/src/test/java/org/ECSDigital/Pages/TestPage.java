package org.ECSDigital.Pages;

import java.util.List;
import java.util.ResourceBundle;

import org.ECSDigital.Generic.ActiononElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestPage {
	ResourceBundle element;
	WebDriver driver;

	public TestPage(WebDriver driver){
		this.driver=driver;
		element = ResourceBundle.getBundle("PageElements");
	}
	
	public void clickRendertheChallenge(WebDriver driver) {
		ActiononElement.clickButton(driver, element.getString("testpage_challenge_xpath"));
	}
	
	public int [] readTableandFindIndex(WebDriver driver) {
		// get the table webelement
		WebElement table = driver.findElement(By.xpath(element.getString("testpage_table_xpath")));
		// get all the rows in the table. Search by tr
		List<WebElement> allRows = table.findElements(By.tagName("tr"));
		int rowLength = allRows.size();
		int arrResult[]= new int[rowLength];
		// Iterate all rows and get each cell 
		for (int i = 0; i < rowLength; i++) {
		    List<WebElement> cells = allRows.get(i).findElements(By.tagName("td"));
		    int colLength =cells.size();
		    int arrIndex[] = new int[colLength];
		    //Iterate in each row for cell value
		    for (int j = 0; j< colLength; j++) {
		    	arrIndex[j]=Integer.parseInt(cells.get(j).getText());
		    }
		    //save the challenge answer in an array
		   arrResult[i] = returnIndex(arrIndex);
		 }
		 return arrResult;
	}
	
	public void enterChallengeValues(WebDriver driver, int [] values) {
		// Enter the values in the text fields and submit result
		ActiononElement.enterText(driver,element.getString("testpage_challenge1_xpath") , Integer.toString(values[0]));
		ActiononElement.enterText(driver,element.getString("testpage_challenge2_xpath") , Integer.toString(values[1]));
		ActiononElement.enterText(driver,element.getString("testpage_challenge3_xpath") , Integer.toString(values[2]));
		ActiononElement.enterText(driver,element.getString("testpage_name_xpath") , element.getString("inputname"));
		ActiononElement.clickButton(driver, element.getString("testpage_submit_xpath"));
	}
	
	public int returnIndex(int[] arrIndex) {
		int len = arrIndex.length;
		int result=0;
		//ignore rows which is only having one cell value
		if (len >2 ) {
			int sumleft=0,sumright=0, index=0;
			for (int i = 1; i<len-1;i++) {
				for (int j=0; j<len;j++) {
					if (j<i) {
						sumleft = sumleft + arrIndex[j];
					} else if (j>i) {
						sumright = sumright + arrIndex[j];
					}
				}
				if (sumleft==sumright) {
					index = i;
				}
				sumleft=0;
				sumright=0;
			}
			if (index==0) {
				result = 0;
			}else {
				result = index;
			}
		}
		return result;
	}
	
}

