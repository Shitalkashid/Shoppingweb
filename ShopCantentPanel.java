package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShopCantentPanel {
	public WebDriver driver;
	By continueShoppingBtn = By.xpath("//button[contains(text(), 'Continue')]");
	By checkoutBtn = By.linkText("PROCEED TO CHECKOUT");
	
	
	public ShopCantentPanel(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getContinueShopBtn() {
		return driver.findElement(continueShoppingBtn);
	}
	
	public WebElement getCheckoutBtn() {
		return driver.findElement(checkoutBtn);
	}
	
		

}
