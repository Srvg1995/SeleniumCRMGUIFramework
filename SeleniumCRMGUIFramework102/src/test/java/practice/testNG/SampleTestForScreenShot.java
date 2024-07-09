package practice.testNG;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

public class SampleTestForScreenShot {
 @Test
 public void amazonTest() throws IOException //This below code of ScreenShot is very older one,so we can use the program which is done by Sandeep sir only.

{
	 WebDriver driver=new ChromeDriver();
	 driver.get("http://google.com");
	 
	 //step-1:create an object to EventFiring Webdriver
	 EventFiringWebDriver edriver=new EventFiringWebDriver(driver); //this is a depricated one.
	 
	//step-2:use getScreenshotAs method to get file type of screenshot
	 File srcFile = edriver.getScreenshotAs(OutputType.FILE);
	 
	 //Step-3:store screenshot on local driver
	 FileUtils.copyFile(srcFile, new File("./screenshot/test.png"));
	 
	 }
}
