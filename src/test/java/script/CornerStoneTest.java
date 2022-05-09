package script;

import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibraries.BaseClass;
import pomPages.CheckOutPage;
import pomPages.CornerStoneDemoHomePage;
import pomPages.YourCart;

public class CornerStoneTest extends BaseClass {

	@Test
	public void tc1() throws IOException, InterruptedException {
		CornerStoneDemoHomePage cornerStoneHP = new CornerStoneDemoHomePage(driver);
		cornerStoneHP.clickSearchTab();
		cornerStoneHP.searchByProductName(pdata.getPropertyData("productName"));
		
		Thread.sleep(3000);
		driverUtilities.mouseHover(driver,cornerStoneHP.getProduct());
		cornerStoneHP.clickAddToCart();
		
		
		YourCart cart = new YourCart(driver);
		driverUtilities.scrollBar(driver,cart.getCheckOutButton().getLocation());
		cart.clickCheckOutButton();
		
		CheckOutPage checkoutPg = new CheckOutPage(driver);
		checkoutPg.provideInput(checkoutPg.getEmailId(),pdata.getPropertyData("email").replace("@",new Random().nextInt(1000) +"@"));
		driverUtilities.jsClick(driver, checkoutPg.getPrivacyPolicy());
		checkoutPg.clickElement(checkoutPg.getCustomerContinueButton());
		
		driverUtilities.dropDown(checkoutPg.getCountry(),pdata.getPropertyData("country"));
		checkoutPg.provideInput(checkoutPg.getFirstName(),pdata.getPropertyData("firstName"));
		checkoutPg.provideInput(checkoutPg.getLastName(),pdata.getPropertyData("lastName"));
		checkoutPg.provideInput(checkoutPg.getAddress(),pdata.getPropertyData("address"));
		checkoutPg.provideInput(checkoutPg.getCity(),pdata.getPropertyData("city"));
		checkoutPg.provideInput(checkoutPg.getPostCode(),pdata.getPropertyData("postalCode"));
		checkoutPg.provideInput(checkoutPg.getPhone(),pdata.getPropertyData("phoneNumber"));
		
		Thread.sleep(5000);
		
		
		driverUtilities.scrollBar(driver, checkoutPg.getShippingContinueButton().getLocation());
		driverUtilities.jsClick(driver, checkoutPg.getShippingContinueButton());
		
		checkoutPg.provideInput(checkoutPg.getCcNum(),pdata.getPropertyData("ccNumber"));
		checkoutPg.provideInput(checkoutPg.getCcExp(),pdata.getPropertyData("ccExpiry"));
		checkoutPg.provideInput(checkoutPg.getCcName(),pdata.getPropertyData("ccName"));
		checkoutPg.provideInput(checkoutPg.getCcCvv(),pdata.getPropertyData("ccCvv"));
		
		checkoutPg.clickElement(checkoutPg.getPaymentButton());
		
		Thread.sleep(5000);
		 Reporter.log(driver.getTitle(),true);
		 Reporter.log(driver.getCurrentUrl(),true);
		 
		// Assert.assertTrue(driver.getCurrentUrl().contains(pdata.getPropertyData("orderConfirmationPageExtension")));
		 SoftAssert a = new SoftAssert();
		 a.assertTrue(driver.getCurrentUrl().contains(pdata.getPropertyData("orderConfirmationPageExtension")), "Presented with a purchase confirmation page for my order ?");
		 
		 WebElement orderNumber =  driver.findElement(By.xpath("//span[text()='Your order number is ']/strong"));
		 a.assertTrue(orderNumber != null, "Order Confirmation Message displayed ?");
		 
		 if(orderNumber != null) {
			 a.assertTrue(orderNumber.getText() != null, "Order Number Generated ?");
			 Reporter.log("Your order number is "+orderNumber.getText(),true);
		 }

		 //WebElement orderSummaryItem = driver.findElement(By.xpath("//h5[contains(text(),"+pdata.getPropertyData("ProductName")+")]"));
		 //a.assertTrue(orderSummaryItem != null,"Is Added Product Present in OrderSummary?");
		 
		 a.assertAll();
	}
}
