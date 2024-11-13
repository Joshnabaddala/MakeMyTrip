package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QuickFilters_Page {


	@FindBy(xpath = "(//span[@class='Checkbox_customCheckbox__x_y3g '])[1]//b")
	private static WebElement clickAcCheckBox;
	
	@FindBy(xpath = "(//div[@class='Cards_cardSection__wZahV']/a)[1]")
	private static WebElement clickFirstDisplayTrain;
	
	@FindBy(linkText = "OK, GO AHEAD")
	private static WebElement clickonGoAHead;
		
	@FindBy(xpath = "(//span[@class='Checkbox_customCheckbox__x_y3g '])[2]")
	private static WebElement clickAvailableCheckBox;
	
	
	public WebElement getClickAcCheckBox() {
		return clickAcCheckBox;
	}	
	public WebElement getClickFirstDisplayTrain() {
		return clickFirstDisplayTrain;
	}
	public WebElement getClickonGoAHead() {
		return clickonGoAHead;
	}
	public WebElement getClickAvailableCheckBox() {
		return clickAvailableCheckBox;
	}
	
	public QuickFilters_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
