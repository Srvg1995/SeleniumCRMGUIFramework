package practice.hometest;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HomePageSampleTest {
	@Test
	public void homePageTest(Method mtd){  //here,Method mtd(comes from java.lang.reflect) followed with getName() in sopln-This is to insert the method name into sopln statement.
		Reporter.log(mtd.getName()+" Test Start");
		Reporter.log("step-1",true);
		Reporter.log("step-2",true);
		Reporter.log("step-3",true);
		Reporter.log("step-4",true);
		Reporter.log(mtd.getName()+" Test End"); 
	}


	@Test
	public void verifyLogoHomePageTest(Method mtd) {
		Reporter.log(mtd.getName()+" Test Start");
		Reporter.log("step-1",true);
		Reporter.log("step-2",true);
		Reporter.log("step-3",true);
		Reporter.log("step-4",true);
		Reporter.log(mtd.getName()+" Test End"); 

	}
}
