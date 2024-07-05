package uk.co.automationtesting;

import java.io.IOException;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import BasePage.base;
import pageObjects.Homepage;
import pageObjects.OrderFromDelivery;
import pageObjects.Orderfrompayment;
import pageObjects.OrderFrompersonalinfo;
import pageObjects.OrderFromShippingMethod;
import pageObjects.ShopCantentPanel;
import pageObjects.ShopHomepage;
import pageObjects.ShopProductPage;
import pageObjects.ShoppingCart;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import BasePage.base;

import pageObjects.Homepage;
import pageObjects.ShopHomepage;

public class OrderCompleteTest extends base{
	public OrderCompleteTest() throws IOException {
		super();
	}

	@BeforeTest
	public void setup() throws IOException {
		driver = getDriver();
		driver.get(getUrl());
	}

	@AfterTest
	public void tearDown() {
		driver.close();
		driver = null;
	}

	@Test
	public void endToEndTest() throws InterruptedException, IOException {

		// creating an object of the automationtesting.co.uk webpage
		Homepage home = new Homepage(driver);

		//handles cookie prompt
		home.getCookie().click();
		
		home.getTestStoreLink().click();

		// creating an object of the test store homepage
		ShopHomepage shopHome = new ShopHomepage(driver);
		shopHome.getProdOne().click();

		// creating an object of the shop products page (when a product has been selected)
		ShopProductPage shopProd = new ShopProductPage(driver);
		Select option = new Select(shopProd.getSizeOption());

		option.selectByVisibleText("M");
		shopProd.getQuantIncrease().click();
		shopProd.getAddToCartBtn().click();

		// creating an object of the cart content panel (once an item was added)
		ShopCantentPanel cPanel = new ShopCantentPanel(driver);
		cPanel.getCheckoutBtn().click();

		// creating an object of the shopping cart page (all items selected)
		ShoppingCart cart = new ShoppingCart(driver);
		cart.getHavePromo().click();
		cart.getPromoTextbox().sendKeys("20OFF");
		cart.getPromoAddBtn().click();
		cart.getProceedCheckoutBtn().click();

		// creating an object of the order personal information page
		OrderFrompersonalinfo pInfo = new OrderFrompersonalinfo(driver);
		pInfo.getGenderMr().click();
		pInfo.getFirstNameField().sendKeys("John");
		pInfo.getLastnameField().sendKeys("Smith");
		pInfo.getEmailField().sendKeys("johnsmith@test.com");
		pInfo.getTermsConditionsCheckbox().click();
		pInfo.getContinueBtn().click();

		// creating an object of the order delivery info page
		OrderFromDelivery orderDelivery = new OrderFromDelivery(driver);
		orderDelivery.getAddressField().sendKeys("123 Main Street");
		orderDelivery.getCityField().sendKeys("Houston");
		Select state = new Select(orderDelivery.getStateDropdown());
		state.selectByVisibleText("Texas");
		orderDelivery.getPostcodeField().sendKeys("77021");
		orderDelivery.getContinueBtn().click();

		// creating an object of the shipping method page
		OrderFromShippingMethod shipMethod= new OrderFromShippingMethod(driver);
		shipMethod.getDeliveryMsgTextbox().sendKeys("If I am not in, please leave my delivery on my porch.");
		shipMethod.getContinueBtn().click();

		// creating an object of the payment options page
		Orderfrompayment orderPay = new Orderfrompayment(driver);
		orderPay.getPayByCheckRadioBtn().click();
		orderPay.getTermsConditionsCheckbox().click();
		orderPay.getOrderBtn().click();
	}


}




