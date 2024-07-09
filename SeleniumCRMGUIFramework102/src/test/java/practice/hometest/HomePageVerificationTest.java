package practice.hometest;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageVerificationTest {
	@Test
	public void homePageTest(Method mtd){  //here,Method mtd(comes from java.lang.reflect) followed with getName() in sopln-This is to insert the method name into sopln statement.
		System.out.println(mtd.getName()+" Test Start");
		String expectedPage="Home page";
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://localhost:8888");

		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();

		String actTitle=driver.findElement(By.xpath("//a[contains(text(),'Home')]")).getText();
		//Hard Assert
		Assert.assertEquals(actTitle, expectedPage);
		driver.close();
		System.out.println(mtd.getName()+" Test End"); 
	}


	@Test
	public void verifyLogoHomePageTest(Method mtd) {
		System.out.println(mtd.getName()+" Test Start");
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://localhost:8888");

		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		 
		boolean status=driver.findElement(By.xpath("//img[@title='vtiger-crm-logo.gif']")).isEnabled();
		//Hard Assert
		Assert.assertTrue(status);//here we can use the same method which is used in above testscript(Assert.assertEquals(actTitle, expectedPage);) (or) we can use this as well(Assert.assertTrue(status) both will result the same.)
		driver.close();
		System.out.println(mtd.getName()+" Test End"); 

	}
}
