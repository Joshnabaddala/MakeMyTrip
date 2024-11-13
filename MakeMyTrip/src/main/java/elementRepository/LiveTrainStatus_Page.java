package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LiveTrainStatus_Page {

	
	@FindBy(xpath = "//span[@data-cy='liveTrainStatus']")	
	private static WebElement clickLiveTrainStatus;
	
	@FindBy(xpath = "//label[contains(@class,'makeFlex column la')]")
	private static WebElement clickTrainNumberOrName;
	
	@FindBy(xpath = "//input[contains(@class,'react')]")
	private static WebElement enterTrainNumberOrNameInput;
	
	@FindBy(id = "trainNum")
	private static WebElement dispaytrainNo;
	
	@FindBy(xpath = "//label[contains(@class,'lato') and @data-cy='selectStation']")
	private static WebElement enterYourStop;
	
	@FindBy(xpath = "//ul[@class='travelForPopup']/li[1]")
	private static WebElement clickYourStop;
	
	@FindBy(xpath = "//input[@id='userStationCode']/..//p[@class='appendBottom7 nrlText']")
	private static WebElement displayStop;
	
	@FindBy(xpath = "//span[@data-cy='trainStartDate']/..")
	private static WebElement clickTrainStartDate;
	
	@FindBy(xpath = "//li[@data-cy='RailTravellingDate_346']")
	private static WebElement clickTheDay;
	
	@FindBy(xpath = "//input[@id='travelDate']/..//p[@class='appendBottom7 nrlText']")
	private static WebElement displayDay;	
	
	@FindBy(xpath = "//a[contains(@class,'primaryBtn')]")
	private static WebElement checkStatusButton;
	
	@FindBy(xpath = "//h2[@data-cy='trainNum']")
	private static WebElement trainNumberDisplay;
	
	public LiveTrainStatus_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

//	getters
	public WebElement getClickLiveTrainStatus() {
		return clickLiveTrainStatus;
	}

	public WebElement getClickTrainNumberOrName() {
		return clickTrainNumberOrName;
	}	

	public WebElement getEnterTrainNumberOrNameInput() {
		return enterTrainNumberOrNameInput;
	}
	
	public WebElement getDispaytrainNo() {
		return dispaytrainNo;
	}

	public WebElement getEnterYourStop() {
		return enterYourStop;
	}
	public WebElement getClickYourStop() {
		return clickYourStop;
	}
	
	public WebElement getDisplayStop() {
		return displayStop;
	}

	public WebElement getClickTrainStartDate() {
		return clickTrainStartDate;
	}

	public static WebElement getClickTheDay() {
		return clickTheDay;
	}

	public WebElement getDisplayDay() {
		return displayDay;
	}

	public WebElement getCheckStatusButton() {
		return checkStatusButton;
	}

	public WebElement getTrainNumberDisplay() {
		return trainNumberDisplay;
	}
	
	// Generic click method 
	public void clickElement(WebElement element) { 
		element.click(); 
	} 
	// Generic sendKeys method 
	public void sendKeysToElement(WebElement element, String keys) { 
		element.sendKeys(keys);
	}
   
}
