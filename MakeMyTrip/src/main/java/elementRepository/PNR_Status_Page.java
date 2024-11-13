package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PNR_Status_Page {
  
	
	@FindBy(xpath = "//span[@data-cy='checkPnrStatus']")	
	private static WebElement clickCheckPnrStatus;
	
	@FindBy(xpath = "//div[contains(@class,'inputContainer make')]")	
	private static WebElement inputForPnr;

	@FindBy(id = "pnr")	
	private static WebElement enterPnr;
	
	@FindBy(xpath = "//a[text()='CHECK STATUS']")	
	private static WebElement clickCheckStatus;
	
	@FindBy(xpath = "//p[contains(text(),'This PNR')]")	
	private static WebElement pnrFlushedText;
	
	public PNR_Status_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getClickCheckPnrStatus() {
		return clickCheckPnrStatus;
	}
	public WebElement getInputForPnr() {
		return inputForPnr;
	}

	public WebElement getEnterPnr() {
		return enterPnr;
	}

	public WebElement getClickCheckStatus() {
		return clickCheckStatus;
	}

	public WebElement getPnrFlushedText() {
		return pnrFlushedText;
	}
	
	
}
