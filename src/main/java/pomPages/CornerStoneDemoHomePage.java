package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CornerStoneDemoHomePage {

	@FindBy(id="quick-search-expand")
	private WebElement searchTab;
	
	@FindBy(id="nav-quick-search")
	private WebElement searchBox;
	
	//@FindBy(className="card-img-container")
	@FindBy(xpath="//a[contains(text(),'Hand Soap')]/../../..")
	private WebElement product;
	
	@FindBy(linkText="Add to Cart")
	private WebElement addToCart;
	
	public CornerStoneDemoHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickSearchTab() {
		searchTab.click();
	}

	public void searchByProductName(String productName) {
		searchBox.sendKeys(productName);
	}
	
	public void clickAddToCart() {
		addToCart.click();
	}

	public WebElement getProduct() {
		return product;
	}
	
}
