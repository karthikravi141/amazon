package amazon;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import amazon.generics.BaseClass;
import amazon.pom.AddressPage;
import amazon.pom.CartPage;
import amazon.pom.DelevieryOptionsPage;
import amazon.pom.Homepage;
import amazon.pom.ProductDetailPage;
import amazon.pom.SearchResultPage;
import amazon.pom.SignInPage;

public class AddProduct extends BaseClass {
	String itemName;

	@Test
	public void addProduct() throws IOException {
		String searchKey=fl.getProperty("searchKey");
		String email=fl.getProperty("email");
		String password=fl.getProperty("password");
		String price=fl.getProperty("price");
		Homepage hm=new Homepage(driver);
		SoftAssert sat=new SoftAssert();
		hm.getSearchTextbox().sendKeys(searchKey);
		hm.getSearchButton().click();
		SearchResultPage srp=new SearchResultPage(driver);
		String main = driver.getWindowHandle();
		for(WebElement element:srp.getSearchedResult()) {
			if(element.getText().contains(searchKey)) {
				itemName=element.getText();
				element.click();
				break;
			}
		}
		Set<String> whs = driver.getWindowHandles();
		whs.remove(main);
		Iterator<String> it = whs.iterator();
		driver.switchTo().window(it.next());
		
		ProductDetailPage pdp=new ProductDetailPage(driver);
		pdp.getAddToCart().click();
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(pdp.getCheckOutButton()));
		sat.assertEquals(pdp.getAddedtoCart().isDisplayed(), true);//validating item added to cart or not
		pdp.getCheckOutButton().click();
		SignInPage sip=new SignInPage(driver);
		sip.getEmailTextBox().sendKeys(email);
		sip.getContinueButton().click();
		sip.getPasswordTextBox().sendKeys(password);
		sip.getSignInButton().click();
		AddressPage ap=new AddressPage(driver);
		ap.getAddressButton().click();
		DelevieryOptionsPage dop=new DelevieryOptionsPage(driver);
		dop.getContinueButton().click();
		driver.switchTo().window(main);
		srp.getCartICon().click();
		CartPage cp=new CartPage(driver);
		cp.getDeleteButton().click();
		boolean deleted = true;//for validating item deleted or not
		for(WebElement element:cp.getCartItemsNameList()) {
			if(element.getText().equals(itemName)) {
				deleted = false;
			}
		}
		sat.assertEquals(deleted, true);
		sat.assertAll();
	}
}
