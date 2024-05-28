package trafilea.trafileacollection;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

public class TestFinal extends BaseTest{
	HomePage home;
	ProductPage product;
	ContactInformation contact;
	public String Dmeassage="Standard Delivery (4-8 business days)";
	public String ERROR ="Your card number is invalid.";
	
	@Test(alwaysRun = true, priority = 1)
	public void homepagetest() {
		home= new HomePage(driver);
		home.closemodule();
		home.clickOnBestSellers();
	}
	
	@Test(priority = 2, dependsOnMethods = "homepagetest")
	public void selecTheFirstProduct() {
		product = new ProductPage(driver);
		product.selectproduct();
		product.addToCart();
		product.switchtoframe();
		product.clickOnProceed();
	}
	
	@Test(priority = 3, dependsOnMethods = "selecTheFirstProduct")
	public void fillForm() {
		contact = new ContactInformation(driver);
		contact.fillForm("QA.mail@gmail.com",
		"My name",
		"My lastname",
		"123 William Street",
		"apt 1",
		"1234567890");
	}
	
	@Test(priority = 4, dependsOnMethods = "fillForm")
	public void isDeliverySelected() {
		contact = new ContactInformation(driver);
		contact.deliveryselected();
		assertEquals(contact.StanderDelivery.getText(), Dmeassage);
	}
	
	@Test(priority = 5)
	public void FillCridetCard() {
		contact = new ContactInformation(driver);
		contact.writeCardNumber("1234123412341234", "test test", "0128", "999");
	}
	
	@Test(priority = 6, dependsOnMethods = "FillCridetCard")
	public void asserterrormessage() {
		contact = new ContactInformation(driver);
		assertEquals(contact.errormessageforCrad.getText(), ERROR);
		contact.verifyimagecard("CreditCards accepted");
	}
	

}
