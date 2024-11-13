package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='Trains']/..//span[contains(@class,'headerIconWrapper')]")
	private static WebElement trainIcon;

	public static WebElement getTrainIcon() {
		return trainIcon;
	}

	// Generic click method
	public void clickElement(WebElement element) {
		element.click();
	}
}
