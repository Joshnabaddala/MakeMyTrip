package stepDefinition;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import elementRepository.BookTrainTicket_Page;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilPackage.DriverFactory;
import utilityClasses.FileUtility;
import utilityClasses.JavaScriptUtil;
import utilityClasses.WebDriverUtility;

public class BookTrainTickets {

	public WebDriver driver=DriverFactory.getDriver();
	BookTrainTicket_Page bookTrainTicket_Page=new BookTrainTicket_Page(driver);
	FileUtility fileUtility=new FileUtility();
	WebDriverUtility webDriverUtility=new WebDriverUtility();
	JavaScriptUtil javaScriptUtil = new JavaScriptUtil(driver);
	
	@When("user clicks on From dropdown")
	public void user_clicks_on_from_dropdown() {
		WebElement fromDropDown = bookTrainTicket_Page.getFromDropDown();
		bookTrainTicket_Page.clickElement(fromDropDown);
		Assert.assertTrue(fromDropDown.isDisplayed(), "From dropdown should be displayed after clicking.");
	    Reporter.log("user clicks on From dropdown", true);
	}

	@Then("enter city name in From dropdown and select")
	public void enter_city_name_in_from_dropdown_and_select() throws Exception {
		
		WebElement enterCityOnFrom = bookTrainTicket_Page.getEnterCityOnFromInput();
		String fromCity = fileUtility.getDataFromExcel("Sheet1", 2, 0);
		bookTrainTicket_Page.sendKeysToElement(enterCityOnFrom , fromCity);
//		enterCityOnFrom.sendKeys(fromCity);	
		Thread.sleep(1000);
		enterCityOnFrom.sendKeys(Keys.ARROW_DOWN+""+Keys.ENTER);
		Assert.assertTrue(enterCityOnFrom.isDisplayed(), "City name should be entered in From dropdown.");
	    Reporter.log("enter city name in From dropdown and select", true);
	}

	@When("user clicks on To dropdown") 
	public void user_clicks_on_to_dropdown() { 
		WebElement toDropDown = BookTrainTicket_Page.getToDropDown(); 
//		toDropDown.click(); 
		bookTrainTicket_Page.clickElement(toDropDown);
		Reporter.log("user clicks on To dropdown", true); 
		Assert.assertTrue(toDropDown.isDisplayed(), "To dropdown should be displayed after clicking."); 
	}
		
	@When("enter city name in To dropdown and select")
	public void enter_city_name_in_to_dropdown_and_select() throws Exception {
	    // Verify and wait for the "To" dropdown input field
	    WebElement enterCityOnTo = BookTrainTicket_Page.getEnterCityOnToInput();
	    webDriverUtility.waitForElementPresent(driver, enterCityOnTo);   
	    // Enter the city name and select
	    String toCity = fileUtility.getDataFromExcel("Sheet1", 3, 0);
	    bookTrainTicket_Page.sendKeysToElement(enterCityOnTo , toCity);
	    Thread.sleep(1000);
	    enterCityOnTo.sendKeys(Keys.ARROW_DOWN + "" + Keys.ENTER);	    
	    Assert.assertEquals(bookTrainTicket_Page.getSelectedCityOnTo(driver), toCity, "The city name entered in 'To' dropdown does not match the expected city name."); 
	    Reporter.log("Entered city name in To dropdown and selected", true);
	}

	
	
	@Then("user clicks on Travel Date dropdown and select any date") 
	public void user_clicks_on_travel_date_dropdown_and_select_any_date() throws Exception { 
		String month = fileUtility.getDataFromExcel("Sheet2", 0, 0); 
		bookTrainTicket_Page.getscrollByAmount(driver); 
		String date = fileUtility.getDataFromExcel("Sheet2", 0, 1); 
		WebElement travelDateElement = bookTrainTicket_Page.getInDate(driver, month, date); 
//		travelDateElement.click(); 
	    WebElement displaydate = BookTrainTicket_Page.getDisplaydate();
	    Assert.assertTrue(displaydate.isDisplayed(), "The displayed date element is not visible on the page.");		
		Reporter.log("user clicks on Travel Date dropdown and select any date", true);
	}

	@Then("user clicks on class dropdown and select any class")
	public void user_clicks_on_class_dropdown_and_select_any_class() throws Exception {
		WebElement clickClassInClassDropdown = bookTrainTicket_Page.getClickClassInClassDropdown();
	    webDriverUtility.waitForElementPresent(driver, clickClassInClassDropdown); 
	    javaScriptUtil.jsClick(clickClassInClassDropdown);
	    WebElement selectClassInClassDropdown = bookTrainTicket_Page.getSelectClassInClassDropdown();
	    webDriverUtility.waitForElementPresent(driver, selectClassInClassDropdown); 
	    javaScriptUtil.jsClick(selectClassInClassDropdown);
		Reporter.log("user clicks on class dropdown and select any class",true);
		String expectedClass =selectClassInClassDropdown.getText();
		String actualClass = bookTrainTicket_Page.getSelectedClass(driver); 
		Assert.assertEquals(actualClass, expectedClass, "The class selected from dropdown does not match the expected class.");
	}

	@When("user should click on Search button")
	public void user_should_click_on_search_button() {
		WebElement clickSearchButton = BookTrainTicket_Page.getClickSearchButton();
		webDriverUtility.waitForElementPresent(driver, clickSearchButton ); 
	    javaScriptUtil.jsClick(clickSearchButton);
	    Reporter.log("user should click on Search button",true);
	}

	@Then("Quick Filters should be displayed")
	public void quick_filters_should_be_displayed() {

		WebElement quickFilters =BookTrainTicket_Page.getQuickFilters();
	    Assert.assertTrue(quickFilters.isDisplayed(),"Quick Filters is not displayed");
	    Reporter.log("Quick Filters should be displayed",true);
	}

}
