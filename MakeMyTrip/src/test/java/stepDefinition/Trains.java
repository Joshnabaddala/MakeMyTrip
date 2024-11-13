package stepDefinition;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import elementRepository.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilPackage.DriverFactory;
import utilityClasses.FileUtility;
import utilityClasses.WebDriverUtility;

public class Trains {
	public WebDriver driver=DriverFactory.getDriver();
	HomePage homePage=new HomePage(driver);
	FileUtility fileUtility = new FileUtility();
	
	@Given("Browser should be Launched and URL should be navigated")
	public void browser_should_be_launched_and_url_should_be_navigated() throws Exception {
		
		String url = fileUtility.getDataFromExcel("Urls", 0, 0);
		Assert.assertTrue(driver.getCurrentUrl().contains(url), "The URL does not contain the expected path: " + url); 
		Reporter.log("Browser should be Launched and URL should be navigated", true);
	}
	@Given("Handling Login Pop Up")
	public void handling_login_pop_up() throws Exception {
		WebDriverUtility driverUtility=new WebDriverUtility();
		driverUtility.moveByoffSetAndClick(driver, 1147, 0);
		String url = fileUtility.getDataFromExcel("Urls", 0, 0);
		Assert.assertTrue(driver.getCurrentUrl().contains(url), "The URL does not contain the expected path: " + url);
	}

	@When("user is able to click on Trains link")
	public void user_is_able_to_click_on_trains_link() {
	    WebElement trainIcon = HomePage.getTrainIcon();
	    homePage.clickElement(trainIcon);
		Reporter.log("user is able to click on Trains link", true);
	}

	@When("Trains page should be open")
	public void trains_page_should_be_open() {
		Assert.assertTrue(driver.getTitle().contains("Online Train Ticket Booking, IRCTC Ticket Booking Platform"));
		Reporter.log("Trains page should be open", true);
	}

}
