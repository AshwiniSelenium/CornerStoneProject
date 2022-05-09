package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage {
	
	@FindBy(id="email")
	private WebElement emailId;
	
	@FindBy(id="privacyPolicy")
	private WebElement privacyPolicy;
	
	@FindBy(id="checkout-customer-continue")
	private WebElement customerContinueButton;
	
	@FindBy(id="firstNameInput")
	private WebElement firstName;
	
	public WebElement getShippingContinueButton() {
		return shippingContinueButton;
	}

	@FindBy(id="lastNameInput")
	private WebElement lastName;
	
	@FindBy(id="addressLine1Input")
	private WebElement address;
	
	@FindBy(id="cityInput")
	private WebElement city;
	
	@FindBy(id="postCodeInput")
	private WebElement postCode;
	
	@FindBy(id="phoneInput")
	private WebElement phone;
	
	@FindBy(id="checkout-shipping-continue")
	private WebElement shippingContinueButton;

	@FindBy(id="ccNumber")
	private WebElement ccNum;
	
	@FindBy(id="ccExpiry")
	private WebElement ccExp;
	
	@FindBy(id="ccName")
	private WebElement ccName;
	
	@FindBy(id="countryCodeInput")
	private WebElement country;
	
	public WebElement getEmailId() {
		return emailId;
	}

	public WebElement getCustomerContinueButton() {
		return customerContinueButton;
	}

	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getAddress() {
		return address;
	}

	public WebElement getCity() {
		return city;
	}

	public WebElement getPostCode() {
		return postCode;
	}

	public WebElement getPhone() {
		return phone;
	}

	public WebElement getCcNum() {
		return ccNum;
	}

	public WebElement getCcExp() {
		return ccExp;
	}

	public WebElement getCcName() {
		return ccName;
	}

	public WebElement getCcCvv() {
		return ccCvv;
	}

	public WebElement getPaymentButton() {
		return paymentButton;
	}

	@FindBy(id="ccCvv")
	private WebElement ccCvv;
	
	@FindBy(id="checkout-payment-continue")
	private WebElement paymentButton;
	
	public CheckOutPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void provideInput(WebElement inputElement, String val) {
		inputElement.sendKeys(val);
	}

	public WebElement getPrivacyPolicy() {
		return privacyPolicy;
	}
	
	public void clickElement(WebElement clickableElement) {
		clickableElement.click();
	}

	public WebElement getCountry() {
		return country;
	}
	
	
}
