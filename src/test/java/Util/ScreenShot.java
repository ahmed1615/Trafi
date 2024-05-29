package Util;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShot  {
	WebDriver driver;
	    public static void takeSnapShot(WebDriver driver, String methodName) throws Exception {
	        TakesScreenshot scrShot = ((TakesScreenshot) driver);
	        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
	        File DestFile = new File("captures/" + methodName + ".png");
	        FileUtils.copyFile(SrcFile, DestFile);
	    }
}
