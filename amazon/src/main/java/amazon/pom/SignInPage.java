package amazon.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {


	@FindBy(id="ap_email")
	private WebElement emailTextBox ;
	
	@FindBy(id="ap_password")
	private WebElement passwordTextBox ;
	
	@FindBy(id="signInSubmit")
	private WebElement signInButton ;
	
	@FindBy(id="continue")
	private WebElement continueButton;
	
	public SignInPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getEmailTextBox() {
		return emailTextBox;
	}

	public WebElement getPasswordTextBox() {
		return passwordTextBox;
	}

	public WebElement getSignInButton() {
		return signInButton;
	}

	public WebElement getContinueButton() {
		return continueButton;
	}
}
