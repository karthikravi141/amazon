package amazon.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	
	
	@FindBy(xpath="//*[@value='Delete']")
	private WebElement deleteButton;
	@FindBy(xpath="//span[@class='a-truncate-full a-offscreen']")
	private List<WebElement> cartItemsNameList;
	
	public CartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getDeleteButton() {
		return deleteButton;
}

	public List<WebElement> getCartItemsNameList() {
		return cartItemsNameList;
	}

	
}