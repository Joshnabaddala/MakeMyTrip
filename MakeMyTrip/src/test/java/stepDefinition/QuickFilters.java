package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import elementRepository.QuickFilters_Page;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilPackage.DriverFactory;
import utilityClasses.JavaScriptUtil;
import utilityClasses.WebDriverUtility;

public class QuickFilters {

	public WebDriver driver = DriverFactory.getDriver();
	QuickFilters_Page quickFilters_Page = new QuickFilters_Page(driver);
	WebDriverUtility webDriverUtility = new WebDriverUtility();
	JavaScriptUtil javaScriptUtil = new JavaScriptUtil(driver);

	@When("user clicks on AC checkBox")
	public void user_clicks_on_ac_check_box() {
		WebElement clickAcCheckBox = quickFilters_Page.getClickAcCheckBox();
		clickAcCheckBox.click();
		Assert.assertTrue(clickAcCheckBox.isEnabled(), "The AC checkBox should be selected after clicking.");
		Reporter.log("user clicks on AC checkBox", true);
	}

	@When("user clicks on AC trains")
	public void user_clicks_on_ac_trains() throws InterruptedException {
		Thread.sleep(5000);
		javaScriptUtil.jsScrollTo(0, 200);
		WebElement clickFirstDisplayTrain =quickFilters_Page.getClickFirstDisplayTrain();
		clickFirstDisplayTrain.click();
		Assert.assertTrue(driver.getTitle().contains("MakeMyTrip - Trains"));		
		Reporter.log("user clicks on AC trains", true);
	}
	@Then("user should click on OK! GO AHead button and it should navigate to Train Booking Page")
	public void user_should_click_on_ok_go_a_head_button_and_it_should_navigate_to_train_booking_page() {
		WebElement clickonGoAHead =quickFilters_Page.getClickonGoAHead();
		clickonGoAHead.click();
		Assert.assertTrue(driver.getTitle().contains("MakeMyTrip - Trains"));
		Reporter.log("user should click on OK! GO AHead button and it should navigate to Train Booking Page", true);
	}

	@Then("Select Travellers should display")
	public void select_travellers_should_display() throws InterruptedException {
		
		WebElement selectTravellersHeader = driver.findElement(By.xpath("//h2[text()='Select Travellers']"));
		// Wait until the element is visible
		webDriverUtility.waitForElementPresent(driver, selectTravellersHeader);
		// Assert that the element is visible
		Assert.assertTrue(selectTravellersHeader.isDisplayed(), "The 'Select Travellers' header should be visible.");
		Reporter.log("Select Travellers should display", true);
	}

	@When("user clicks on Available checkBox")
	public void user_clicks_on_available_check_box() {
		WebElement clickAvailableCheckBox = quickFilters_Page.getClickAvailableCheckBox();
		clickAvailableCheckBox.click();
		Assert.assertTrue(clickAvailableCheckBox.isEnabled(), "The AC checkBox should be selected after clicking.");
		Reporter.log("user clicks on Available checkBox", true);
	}

	@When("user clicks on Available trains")
	public void user_clicks_on_available_trains() {
		
		javaScriptUtil.jsScrollTo(0, 200);
		WebElement clickFirstDisplayTrain =quickFilters_Page.getClickFirstDisplayTrain();
		clickFirstDisplayTrain.click();
		Assert.assertTrue(driver.getTitle().contains("MakeMyTrip - Trains"));
		Reporter.log("user clicks on Available trains", true);
	}
	
}
