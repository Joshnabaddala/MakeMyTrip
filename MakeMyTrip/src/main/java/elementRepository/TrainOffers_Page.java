package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrainOffers_Page {

	@FindBy(xpath = "//span[text()='View All']/span")
	private static WebElement clickViewAll;
	
	@FindBy(xpath = "//label[@for='RAIL']")
	private static WebElement clickTrainsOption; 
	
	@FindBy(xpath = "(//p[contains(text(),'For Your GRAND Year-end Getaway: Up to 40% OFF*')]/../../..//img[@class='lobIcon'])[6]")
	private static WebElement clickTrainIcon;
	
	//span[text()='FILTERS']
	@FindBy(xpath = "//a[@data-cy='Logo_38']")
	private static WebElement filtersPageElement;
	
	public TrainOffers_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getClickViewAll() {
		return clickViewAll;
	}
	public WebElement getClickTrainsOption() {
		return clickTrainsOption;
	}
	public WebElement getFiltersPageElement() {
		return filtersPageElement;
	}
	public WebElement getClickTrainIcon() {
		return clickTrainIcon;
	}

	
}
