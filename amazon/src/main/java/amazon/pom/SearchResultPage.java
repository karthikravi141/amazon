package amazon.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {
	
	@FindBy(xpath="//div[@data-component-type='s-search-result']//h2//span")
	private List<WebElement> searchedResult ;
	
	@FindBy(id = "nav-cart-count-container")
	private WebElement cartICon;
	
	
	public WebElement getCartICon() {
		return cartICon;
	}


	public SearchResultPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}


	public List<WebElement> getSearchedResult() {
		return searchedResult;
	}


	
}
