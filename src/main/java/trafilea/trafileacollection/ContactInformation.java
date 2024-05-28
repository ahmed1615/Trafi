package trafilea.trafileacollection;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactInformation extends MainClass{

	public ContactInformation(WebDriver driver) {
		super(driver);	
	}
	
	@FindBy(xpath= "//input[@data-testid='email-field']")
	WebElement email;
	
	@FindBy(xpath = "//input[@data-testid='first-name-shipping-field']")
	WebElement firstName;
	
	@FindBy(xpath = "//input[@data-testid='last-name-shipping-field']")
	WebElement lastName;
	
	@FindBy(xpath = "//input[@data-testid='address-shipping-field']")
	WebElement adress;
	
	@FindBy(xpath = "//input[@data-testid='apt-shipping-field']")
	WebElement APT;
	
	@FindBy(xpath = "//button[@data-testid='country-field']")
	WebElement country;
	
	@FindBy(xpath = "//ul[@class='css-cnpfpg']/li")
	List<WebElement>allCountriesansstates;
	
	@FindBy(xpath = "//button[@data-testid='state-field']")
	WebElement state;
	
	@FindBy(xpath = "//input[@data-testid='zipcode-shipping-field']")
	WebElement zipCode;
	
	@FindBy(xpath = "//input[@data-testid='city-shipping-field']")
	WebElement city;
	
	@FindBy(xpath = "//input[@data-testid='phone-shipping-field']")
	WebElement phone;
	
	@FindBy(xpath = "(//p[@class='css-1s7gphs'])[1]")
	public WebElement StanderDelivery;
	
	//card
	@FindBy (xpath = "(//div[@class='__PrivateStripeElement'])[1]/iframe")
	WebElement frames;
	
	@FindBy(xpath = "//input[@name='cardnumber' and @placeholder='Card number']")
	WebElement cardNumber;
	
	@FindBy(xpath = "//input[@data-testid='base-input' and @placeholder='Name on card']")
	WebElement nameOnCard;
	
	@FindBy(xpath = "//span[contains(text(),'Your card number is invalid.')]")
	public WebElement errormessageforCrad;
	
	@FindBy(xpath = "//div[@class='css-19idpu1']/div/img ")
	public WebElement accetpedCridetCrads;
	
	public void fillForm(String EMAIL, String FIRSTNAME, String LASTNAME, String ADRESS,String apt, String PHONE ) {
		filladdvalue(email, EMAIL);
		filladdvalue(firstName, FIRSTNAME);
		filladdvalue(lastName, LASTNAME);
		filladdvalue(adress, ADRESS);
		arrowDownAndEnter();
		filladdvalue(APT, apt);
		filladdvalue(phone, PHONE);
	}
	
	public void deliveryselected() {
		Scrolldowntoelement(StanderDelivery);
		AssertisdisayplesAndSelected(StanderDelivery);
	}
	
	public void writeCardNumber(String CARDNUMBER, String NAMECARD, String MMYY, String CVV ) {
		fillcarddetils(frames, cardNumber, CARDNUMBER, NAMECARD, MMYY, CVV);
	}
	
	public void verifyimagecard(String Atribute) {
		verifyAttribute(accetpedCridetCrads, "alt", Atribute);
	}
}