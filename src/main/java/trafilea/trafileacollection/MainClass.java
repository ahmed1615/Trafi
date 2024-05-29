package trafilea.trafileacollection;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainClass {

	public static WebDriver driver;
	public Select select;
	public JavascriptExecutor js;
	
	public MainClass(WebDriver driver) {
		PageFactory.initElements(driver, this);
		MainClass.driver = driver;		
	}
	
	protected WebDriver getDriver() {
        return driver;
        
    }
	
	public static void clickOnButton(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(50));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();	
	}
	
	public static void selectvalue(List <WebElement> elements, String Value) {
		for(int i=0; i<elements.size();i++) {
			if(elements.get(i).getText()==Value) {
				WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(50));
				wait.until(ExpectedConditions.invisibilityOfAllElements(elements));
				WebElement element =elements.get(i);
				element.click();
				break;
			}
		}
	}
	
	public static void filladdvalue(WebElement element, String value)  {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(50));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.sendKeys(value);
	}
	
	protected void executeJavaScript(String script, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(script, element);
	}
	
	public static void switchtoframeandDoOneAction(WebElement element, WebElement elementtwo) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(50));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
		wait.until(ExpectedConditions.elementToBeClickable(elementtwo));
		elementtwo.click();
		driver.switchTo().defaultContent();
	}
	
	public static void fillcarddetils( WebElement element, WebElement elementtwo, String value, String vaule2, String value3, String value4) {
		Actions a = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(50));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
		wait.until(ExpectedConditions.elementToBeClickable(elementtwo));
		elementtwo.click();
		elementtwo.sendKeys(value);
		driver.switchTo().defaultContent();
		a.sendKeys(Keys.TAB).build().perform();
		a.sendKeys(vaule2).build().perform();
		a.sendKeys(Keys.TAB).build().perform();
		a.sendKeys(value3).build().perform();
		a.sendKeys(Keys.TAB).build().perform();
		a.sendKeys(value4).build().perform();
	}
	
	public static void arrowDownAndEnter() {
		Actions a = new Actions(driver);
		a.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
	}
	
	public static void goToTheNextField() {
		Actions a = new Actions(driver);
		a.sendKeys(Keys.TAB).build().perform();
	}
	
	public static boolean AssertisdisayplesAndSelected(WebElement element) {
		if(element.isDisplayed()&&element.isEnabled()&&element.isSelected()) {
		return true;}
		else {
		return false;
		}
	}
	
	protected void Scrolldowntoelement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);;
	}
	
	public static boolean verifyAttribute(WebElement element , String attribute, String expectedAttribute) {
		String ATTRIBUTE = element.getAttribute(attribute).toString();
		if(ATTRIBUTE==expectedAttribute) {
		return true;
		}
		else {
			return false;
		}
	}	
}	