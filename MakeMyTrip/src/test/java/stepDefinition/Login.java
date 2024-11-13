package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilPackage.DriverFactory;
import utilityClasses.JavaScriptUtil;

public class Login {

	public WebDriver driver=DriverFactory.getDriver();
	
	@Then("personal account page will be displayed")
	public void personal_account_page_will_be_displayed() {
		//li[text()='Personal Account']
		WebElement personalAccount = driver.findElement(By.xpath("//li[text()='Personal Account']"));
		Assert.assertTrue(personalAccount.isDisplayed(),"Personal Account");
		Reporter.log("personal account page will be displayed");
	}


	@Then("user enters their Mobile Number")
	public void user_enters_their_mobile_number() {
		WebElement mobileNumber = driver.findElement(By.xpath("//input[@class='font14 fullWidth']"));
		mobileNumber.sendKeys("7330610802");
		Reporter.log("user enters their Mobile Number");
	}

	@Then("user clicks on continue button")
	public void user_clicks_on_continue_button() {
		//button[@class='capText font16']/span
		WebElement continueButton = driver.findElement(By.xpath("//span[text()='Continue']"));
		JavaScriptUtil javaScriptUtil=new JavaScriptUtil(driver);
		javaScriptUtil.jsClick(continueButton);
		
		Reporter.log("user enters their Mobile Number");
	}

	@Then("Verify Your Mobile Number will be displayed")
	public void verify_your_mobile_number_will_be_displayed() throws InterruptedException {
		Reporter.log("Verify Your Mobile Number will be displayed");
		Thread.sleep(3000);
	}

	@Then("User enters otp")
	public void user_enters_otp() throws InterruptedException {
		WebElement otp = driver.findElement(By.xpath("//input[@id='otp']"));
		Thread.sleep(5000);
		Reporter.log("User enters otp");
	}

	@Then("user clicks on Login button")
	public void user_clicks_on_login_button() {
		driver.findElement(By.xpath("//button[@class='capText font16']")).click();
		Reporter.log("user clicks on Login button");
	}
}
