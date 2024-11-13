package stepDefinition;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import elementRepository.LiveTrainStatus_Page;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilPackage.DriverFactory;
import utilityClasses.FileUtility;
import utilityClasses.JavaScriptUtil;
import utilityClasses.WebDriverUtility;

public class LiveTrainStatus {

	public WebDriver driver = DriverFactory.getDriver();
	FileUtility fileUtility = new FileUtility();
	WebDriverUtility webDriverUtility = new WebDriverUtility();
	LiveTrainStatus_Page liveTrainStatusPage = new LiveTrainStatus_Page(driver);
	JavaScriptUtil javaScriptUtil = new JavaScriptUtil(driver);

	@Then("user should click on Live Train Status")
	public void user_should_click_on_live_train_status() {
		WebElement clickLiveTrainStatus = liveTrainStatusPage.getClickLiveTrainStatus();
		webDriverUtility.waitForElementPresent(driver, clickLiveTrainStatus);
		liveTrainStatusPage.clickElement(clickLiveTrainStatus);
		Assert.assertTrue(clickLiveTrainStatus.isDisplayed(), "Live Train Status should be visible.");
		Reporter.log("User should click on Live Train Status", true);
	}

	@When("user clicks on TrainNumberOrName")
	public void user_clicks_on_train_number_or_name() {
		WebElement clickTrainNumberOrName = liveTrainStatusPage.getClickTrainNumberOrName();
		webDriverUtility.waitForElementPresent(driver, clickTrainNumberOrName);
		javaScriptUtil.jsClick(clickTrainNumberOrName);
		Assert.assertTrue(liveTrainStatusPage.getEnterTrainNumberOrNameInput().isDisplayed(), "Train Number or Name input should be visible.");
		Reporter.log("User clicks on TrainNumberOrName", true);
	}

	@Then("user enters Train Number in TrainNumberOrName dropdown and select")
	public void user_enters_train_number_in_train_number_or_name_dropdown_and_select() throws Exception {

		WebElement enterTrainNumberOrNameInput = liveTrainStatusPage.getEnterTrainNumberOrNameInput();
		webDriverUtility.waitForElementPresent(driver, enterTrainNumberOrNameInput);
		String trainNumber = fileUtility.getDataFromExcel("Sheet1", 1, 1);
		liveTrainStatusPage.sendKeysToElement(enterTrainNumberOrNameInput, trainNumber);	
		enterTrainNumberOrNameInput.sendKeys(Keys.ARROW_DOWN + "" + Keys.ENTER);
		Assert.assertTrue(liveTrainStatusPage.getDispaytrainNo().isDisplayed(), "Train Number input field should be displayed.");
		Reporter.log("User enters Train Number in TrainNumberOrName dropdown and select", true);
	}

	@Then("user clicks on Your Stop dropdown and select any Stop")
	public void user_clicks_on_your_stop_dropdown_and_select_any_stop() throws InterruptedException {
		WebElement enterYourStop = liveTrainStatusPage.getEnterYourStop();
		webDriverUtility.waitForElementPresent(driver, enterYourStop);	
//		liveTrainStatusPage.clickElement(enterYourStop);
		WebElement clickOnStop =liveTrainStatusPage.getClickYourStop();
		javaScriptUtil.jsClick(clickOnStop);
		Assert.assertTrue(liveTrainStatusPage.getDisplayStop().isDisplayed(),"User should select Your Stop");		
	}

	@When("user clicks on Train Start Date and select any date")
	public void user_clicks_on_train_start_date_and_select_any_date() {
		WebElement clickTrainStartDate = liveTrainStatusPage.getClickTrainStartDate();
		webDriverUtility.waitForElementPresent(driver, clickTrainStartDate);
		javaScriptUtil.jsClick(clickTrainStartDate);
    	WebElement clickTheDay = LiveTrainStatus_Page.getClickTheDay();
		webDriverUtility.waitForElementPresent(driver, clickTheDay);
		liveTrainStatusPage.clickElement(clickTheDay);
		Assert.assertTrue(liveTrainStatusPage.getDisplayDay() .isDisplayed(), "Train Start Date should be selected.");
		Reporter.log("user clicks on Train Start Date and select any date", true);
	}

	@Then("click on Check Status button")
	public void click_on_check_status_button() {

		WebElement checkStatusButton = liveTrainStatusPage.getCheckStatusButton();
		webDriverUtility.waitForElementPresent(driver, checkStatusButton);
		javaScriptUtil.jsClick(checkStatusButton);
		Assert.assertTrue(checkStatusButton.isDisplayed(), "Check Status button should be visible and clickable.");
		Reporter.log("click on Check Status button", true);
	}

	@Then("user Train Number should be displayed")
	public void user_train_number_should_be_displayed() {
		WebElement trainNumberDisplay = liveTrainStatusPage.getTrainNumberDisplay();
		webDriverUtility.waitForElementPresent(driver, trainNumberDisplay);
		String displayedTrainNumber = trainNumberDisplay.getText();
		Assert.assertTrue(trainNumberDisplay.isDisplayed(), "Train Number should be displayed correctly.");
		Reporter.log("Displayed Train Number: " + displayedTrainNumber, true);
	}

}
