package trafilea.trafileacollection;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends MainClass {

	public ProductPage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(xpath = "//div[@class='styles_product_list__tnyvu']/div")
	public List<WebElement> allproducts;
	
	@FindBy(xpath = "//button[contains(text(),'ADD TO CART')]")
	WebElement addToCart;
	
	@FindBy(xpath =  "//iframe[contains(@name, 'iframe')]")
	WebElement frame;
	
	@FindBy(xpath = "//font[contains(text(),'x')]")
	WebElement closebutton;
	
	@FindBy (xpath = "(//button[contains(text(),'PROCEED TO CHECKOUT')])[1]")
	WebElement prodceedToCheckout;
	
	public void selectproduct() {
		//for(int i=0; i<allproducts.size();i++) {
			clickOnButton(allproducts.get(0));
			//break;
		//}
	}
		public void addToCart() {
			executeJavaScript("arguments[0].click();", addToCart);
		}
		public void switchtoframe() {
			switchtoframeandDoOneAction(frame, closebutton);
		}
		public void clickOnProceed() {
			executeJavaScript("arguments[0].click();", prodceedToCheckout);
		}
	}