package amazon.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	
	@FindBy(id = "twotabsearchtextbox")
	private WebElement searchTextbox;
	
	@FindBy(id = "nav-search-submit-button")
	private WebElement searchButton;
	

	public WebElement getSearchTextbox() {
		return searchTextbox;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}

	public Homepage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
}
