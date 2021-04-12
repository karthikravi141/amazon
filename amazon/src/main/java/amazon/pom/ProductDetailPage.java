package amazon.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailPage {

	
	@FindBy(id="add-to-cart-button")
	private WebElement addToCart;
	
	
	@FindBy(xpath="(//h4[.='Added to Cart'])[2]")
	private WebElement addedtoCartAlert;
	
	
	public WebElement getAddToCart() {
		return addToCart;
	}
	public WebElement getAddedtoCart() {
		return addedtoCartAlert;
	}

	
	
	public WebElement getCheckOutButton() {
		return checkOutButton;
	}

	@FindBy(xpath="//*[contains(@id,'checkout-button')]")
	private WebElement checkOutButton;
	
	public ProductDetailPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
}
