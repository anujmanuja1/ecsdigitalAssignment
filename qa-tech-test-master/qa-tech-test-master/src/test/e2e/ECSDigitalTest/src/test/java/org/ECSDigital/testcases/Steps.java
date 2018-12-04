package org.ECSDigital.testcases;

import java.util.ResourceBundle;

import org.ECSDigital.Generic.Compare;
import org.ECSDigital.Pages.TestPage;
import org.ECSDigital.base.CreateDriverInstance;
import org.openqa.selenium.WebDriver;

import cucumber.annotation.en.*;
import junit.framework.Assert;

public class Steps {
	
	WebDriver driver;
	TestPage page= new TestPage(driver);
	int [] index;
	ResourceBundle element = ResourceBundle.getBundle("PageElements");
	ResourceBundle config = ResourceBundle.getBundle("Config");
	
	CreateDriverInstance driverInstance = new CreateDriverInstance();
	
	@Given("^User is on ECSDigital Test page$")
	public void User_is_on_ECSDigital_Test_page() throws Throwable {
		driver = driverInstance.generateDriverInstance();   
		driver.get(config.getString("appURL"));
		Assert.assertTrue("Unexpected Url or 'Render the Challenge' button not found", Compare.validateElementExistByXpath(driver,element.getString("testpage_challenge_xpath") ));
	}

	@Given("^User clicks on Render the Challenge button$")
	public void User_clicks_on_Render_the_Challenge_button() throws Throwable {
	    page.clickRendertheChallenge(driver);
	    Assert.assertTrue("Table to be validated, not found", Compare.validateElementExistByXpath(driver,element.getString("testpage_table_xpath") ));
	}

	@Then("^User reads the table and find the index of each row$")
	public void User_reads_the_table_and_find_the_index_of_each_row() throws Throwable {
		index = page.readTableandFindIndex(driver);
	}

	@Then("^User submit the answers$")
	public void User_submit_the_answers() throws Throwable {
	    page.enterChallengeValues(driver, index);
	}

}
