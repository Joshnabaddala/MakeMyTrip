package elementRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookTrainTicket_Page {

	public BookTrainTicket_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
    @FindBy(xpath = "//span[@class='appendBottom2' and text()='From']/..")
	private static WebElement fromDropDown;
    
    @FindBy(xpath = "//input[contains(@class,'react')]")
    private static WebElement enterCityOnFromInput;

    @FindBy(xpath = "//div[@id='react-autowhatever-1']//div[contains(@class,'react-autosuggest__section-container react-autosuggest')]//li[1]")  
    private static WebElement selectCityOnFromInput;

	@FindBy(xpath = "//input[@id='toCity']/../..")
    private static WebElement toDropDown;
  
    @FindBy(xpath = "//input[contains(@class,'react-autosuggest')]")
	private static WebElement enterCityOnToInput;
       
    @FindBy(xpath = "//input[@id='toCity']")
    private static WebElement checkToInput;
    
    @FindBy(xpath = "//div[@id='react-autowhatever-1']//div[contains(@class,'react-autosuggest__section-container react-autosuggest')]//li[1]")
    private static WebElement selectCityOnToInput;

    @FindBy(xpath = "//label[@for='travelDate']")
    private static WebElement dateDropDown;
    
//    WebElement displaydate = driver.findElement(By.xpath("//span[@class='font32 latoBlack']"));
    @FindBy(xpath = "//span[@class='font32 latoBlack']")
    private static WebElement displaydate;
   
    @FindBy(xpath = "//ul[@class='travelForPopup']")
    private static WebElement clickClassInClassDropdown;
    
    @FindBy(xpath = "//input[@id='travelClass']")
    private static WebElement checkClassInClassDropdown;
    
    @FindBy(xpath = "//div[@data-cy='classValue']/p")
    private static WebElement selectClassInClassDropdown;

	@FindBy(xpath = "//a[text()='Search']")
    private static WebElement clickSearchButton;
    
	@FindBy(xpath = "//span[text()='Quick Filters']")
	private static WebElement quickFilters;

	public WebElement getInDate(WebDriver driver,String month,String date) {    	
    	return driver.findElement(By.xpath("//div[contains(text(),'"+month+"')]/../..//div[contains(@aria-label,'"+month.substring(0,3)+" "+ date+"')]"));
	}
    
    public WebDriver getscrollByAmount(WebDriver driver) {
    	Actions action=new Actions(driver);
		action.scrollByAmount(0, 200).perform();
		return driver; 	
    }
	public String getSelectedCityOnTo(WebDriver driver) {
		WebElement enterCityOnTo = getCheckToInput();
		return enterCityOnTo.getAttribute("value");
	}
	
	public String getSelectedClass(WebDriver driver) { 
		WebElement classInputField = getCheckClassInClassDropdown(); 
		return classInputField.getAttribute("value"); 
	}
  
	public WebElement getFromDropDown() {
		return fromDropDown;
	}
	public WebElement getEnterCityOnFromInput() {
		return enterCityOnFromInput;
	}
	public static WebElement getSelectCityOnFromInput() {
		return selectCityOnFromInput;
	}
	public static WebElement getToDropDown() {
		return toDropDown;
	}
	public static WebElement getEnterCityOnToInput() {
		return enterCityOnToInput;
	}
	public static WebElement getSelectCityOnToInput() {
		return selectCityOnToInput;
	}
	public static WebElement getCheckToInput() {
		return checkToInput;
	}

	public static WebElement getDateDropDown() {
		return dateDropDown;
	}
	
	public static WebElement getDisplaydate() {
		return displaydate;
	}

	public WebElement getClickClassInClassDropdown() {
		return clickClassInClassDropdown;
	}

	public static WebElement getCheckClassInClassDropdown() {
		return checkClassInClassDropdown;
	}

	public WebElement getSelectClassInClassDropdown() {
		return selectClassInClassDropdown;
	}
	public static WebElement getClickSearchButton() {
		return clickSearchButton;
	}

	public static WebElement getQuickFilters() {
		return quickFilters;
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
