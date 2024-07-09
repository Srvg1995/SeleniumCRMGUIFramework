package practice.hometest;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HomePageSampleTest2 {
	@Test
	public void homePageTest(Method mtd){  //here,Method mtd(comes from java.lang.reflect) followed with getName() in sopln-This is to insert the method name into sopln statement.
		System.out.println(mtd.getName()+" Test Start");
		SoftAssert assertObj=new SoftAssert();
		System.out.println("step-1");
		System.out.println("step-2");
		Assert.assertEquals("Home", "Home");  //here arguments used in (boolean,boolean)
		System.out.println("step-3");
		assertObj.assertEquals("Title", "Title-1");
		System.out.println("step-4");
		assertObj.assertAll();
		System.out.println(mtd.getName()+" Test End"); 
	}


	@Test
	public void verifyLogoHomePageTest(Method mtd) {
		System.out.println(mtd.getName()+" Test Start");
		SoftAssert assertObj=new SoftAssert();
		System.out.println("step-1");
		System.out.println("step-2");
		assertObj.assertTrue(true);
		System.out.println("step-3");
		System.out.println("step-4");
		assertObj.assertAll();
		System.out.println(mtd.getName()+" Test End"); 

	}
}
