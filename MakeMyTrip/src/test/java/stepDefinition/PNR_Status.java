package stepDefinition;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import elementRepository.PNR_Status_Page;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilPackage.DriverFactory;
import utilityClasses.FileUtility;
import utilityClasses.JavaScriptUtil;
import utilityClasses.WebDriverUtility;

public class PNR_Status {

	public WebDriver driver = DriverFactory.getDriver();
	FileUtility fileUtility = new FileUtility();
	WebDriverUtility webDriverUtility = new WebDriverUtility();
	PNR_Status_Page pnrStatusPage=new PNR_Status_Page(driver);
	JavaScriptUtil javaScriptUtil = new JavaScriptUtil(driver);
	
	@When("user clicks on Check PNR Status")
	public void user_clicks_on_check_pnr_status() {
		WebElement clickCheckPnrStatus = pnrStatusPage.getClickCheckPnrStatus();
		webDriverUtility.waitForElementPresent(driver, clickCheckPnrStatus);
		javaScriptUtil.jsClick(clickCheckPnrStatus);
		Assert.assertTrue(clickCheckPnrStatus.isDisplayed(), "Check PNR Status should be visible.");
		Reporter.log("user clicks on Check PNR Status", true);
	}

	@Then("input field should display")
	public void input_field_should_display() {
	    WebElement inputField =pnrStatusPage.getInputForPnr() ;    
	    webDriverUtility.waitForElementPresent(driver, inputField);
	    Assert.assertTrue(inputField.isDisplayed(), "The input field should be visible.");    
	    Reporter.log("The input field is visible as expected.", true);
	}

	@When("user enters their {int} in input feild")
	public void user_enters_their_in_input_feild(int rowNum) throws Exception {
			
		WebElement phoneNumberInputField =pnrStatusPage.getEnterPnr();
		String pno=fileUtility.getDataFromExcel("sheet4",rowNum , 0);
		phoneNumberInputField.sendKeys(pno); 
		Reporter.log("User enters their phone number: " + pno, true); 
		Assert.assertEquals(phoneNumberInputField.getAttribute("value"), pno, "The entered phone number should match the expected phone number."); 

	}
	
	@When("click on Check Status")
	public void click_on_check_status() {
		WebElement clickCheckStatus = pnrStatusPage.getClickCheckStatus();
		clickCheckStatus.click();
		Reporter.log("click on Check Status", true);
	}

	@Then("it should navigate to the PNR Status Page")
	public void it_should_navigate_to_the_pnr_status_page() {
		
		Assert.assertTrue(driver.getTitle().contains("MakeMyTrip - #1 Travel Website 50% OFF on Hotels, Flights & Holiday"));
		Reporter.log("it should navigate to the PNR Status Page", true);
	}

	@Then("user should see the message like This PNR is either not generated or flushed")
	public void user_should_see_the_message_like_this_pnr_is_either_not_generated_or_flushed() {
		WebElement pnrFlushedText =pnrStatusPage.getPnrFlushedText();
		Reporter.log("User enters their phone number: " + pnrFlushedText, true); 
		Assert.assertTrue(pnrFlushedText.isDisplayed(), "The input field should be visible."); 
	}
}
