package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourCart {
	
	@FindBy(linkText="Check out")
	private WebElement checkOutButton;
	
	public YourCart(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getCheckOutButton() {
		return checkOutButton;
	}

	public void clickCheckOutButton() {
		checkOutButton.click();
	}

}
