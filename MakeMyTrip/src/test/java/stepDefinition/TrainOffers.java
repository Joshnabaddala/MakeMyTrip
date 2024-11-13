package stepDefinition;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import elementRepository.TrainOffers_Page;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilPackage.DriverFactory;
import utilityClasses.JavaScriptUtil;
import utilityClasses.WebDriverUtility;

public class TrainOffers {

	public WebDriver driver = DriverFactory.getDriver();
	TrainOffers_Page trainOffers_Page=new TrainOffers_Page(driver);
	JavaScriptUtil javaScriptUtil=new JavaScriptUtil(driver);
	WebDriverUtility webDriverUtility = new WebDriverUtility();
	
	@When("user clicks on View All and Filters Page should be visible")
	public void user_clicks_on_view_all_and_filters_page_should_be_visible() throws InterruptedException {
	    WebElement viewAll = trainOffers_Page.getClickViewAll();
	    webDriverUtility.waitForElementPresent(driver, viewAll); 
	    javaScriptUtil.jsClick(viewAll);
	    webDriverUtility.switchToTabOnTitle(driver, "MakeMyTrip - #1 Travel Website 50% OFF on Hotels, Flights & Holiday");
	    Assert.assertTrue(driver.getTitle().contains("MakeMyTrip - #1 Travel Website 50% OFF on Hotels, Flights & Holiday"));    
	    Reporter.log("User clicks on View All and Filters Page is visible", true);
	}
	

	@Then("user clicks on Trains Options")
	public void user_clicks_on_trains_options()  {
		WebElement trainsOption = trainOffers_Page.getClickTrainsOption();
		javaScriptUtil.jsClick(trainsOption);
//	    Identify an element on the Filters Page
	    WebElement filtersPageElement = trainOffers_Page.getFiltersPageElement(); 
	    webDriverUtility.waitForElementPresent(driver, filtersPageElement);	    
//	    Assert that the element is visible
	    Assert.assertTrue(filtersPageElement.isDisplayed(), "Filters Page should be visible after clicking View All.");
		Reporter.log("user clicks on Trains Options",true);
	}

	@When("user clicks on Trains icon")
	public void user_clicks_on_trains_icon() {
		WebElement clickTrainIcon = trainOffers_Page.getClickTrainIcon(); 
		webDriverUtility.waitForElementPresent(driver, clickTrainIcon);
		javaScriptUtil.jsClick(clickTrainIcon);
		Reporter.log("user clicks on Trains icon",true);
	}

	@Then("user should be navigated to the offer page")
	public void user_should_be_navigated_to_the_offer_page() {
		Assert.assertTrue(driver.getTitle().contains("MakeMyTrip"));
		Reporter.log("user should be navigated to the offer page",true);
	}
}
