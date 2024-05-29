package trafilea.trafileacollection;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends MainClass {

	public HomePage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath = "//a[contains(text(),'Best Sellers')]")
	WebElement bestSellers;
	
	@FindBy(xpath = "//span[contains(@class, 'trafilea-close')]")
	List<WebElement> closetab;

	
	public void closemodule() {
		clickOnButton(closetab.get(0));
	}
	public void clickOnBestSellers() {
		clickOnButton(bestSellers);
	}
}