package amazon.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DelevieryOptionsPage {
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement continueButton;
	
	public DelevieryOptionsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getContinueButton() {
		return continueButton;
	}
	
}
