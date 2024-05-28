package trafilea.trafileacollection;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {
	public static WebDriver driver;
	public static String user=System.getProperty("user.dir");
	public String applink="https://shapermint.com/";

	@BeforeSuite
	@Parameters({"browser"})
	public void StartDriver(@Optional("chrome") String browsername) {
		if(browsername.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver",user+"/drivers/chromedriver.exe");
		driver=new ChromeDriver();}
		else if(browsername.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.chrome.driver",user+"/drivers/geckodriver.exe");
			driver=new FirefoxDriver(); 
		}
		else if (browsername.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.chrome.driver",user+"/drivers/msedgedriver.exe");
			driver=new EdgeDriver(); 
		}
		driver.manage().window().maximize();
		driver.get(applink);
		driver.manage().deleteAllCookies();

	}
	
	@AfterSuite
	public void CloseTab() {
		driver.quit();
	}
}