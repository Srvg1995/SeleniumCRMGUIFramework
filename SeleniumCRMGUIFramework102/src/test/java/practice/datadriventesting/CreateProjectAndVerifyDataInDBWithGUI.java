package practice.datadriventesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.mysql.cj.jdbc.Driver;

public class CreateProjectAndVerifyDataInDBWithGUI {

	public static void main(String[] args) throws Throwable {
		//Create Project in GUI using selenium code(In FRONT END)
		String projectName = "Instagram_1253";
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://106.51.90.215:8084");
		driver.findElement(By.id("username")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");

		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		driver.findElement(By.linkText("Projects")).click();
		driver.findElement(By.xpath("//span[text()='Create Project']")).click();
		driver.findElement(By.xpath("//input[@name='projectName']")).sendKeys(projectName);
		driver.findElement(By.name("createdBy")).sendKeys("gagan");

		WebElement status = driver.findElement(By.xpath("//label[text()='Project Status ']/..//select[@name='status']")); //independent-dependent Xpath
		Select sel=new Select(status);
		sel.selectByVisibleText("On Going");
		driver.findElement(By.xpath("//input[@value='Add Project']")).click();

		//Verify the Project in DB using JDBC(BACK END)
		boolean flag=false;
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
		System.out.println("=====Done======");

		Statement stat = conn.createStatement();

		ResultSet resultset = stat.executeQuery("select * from project");
		while(resultset.next())
		{
			String actProjectName = resultset.getString(4);
			//if(actProjectName.equals("flipkart"))
			if(actProjectName.equals("projectName"))
			{
				flag=true;
				System.out.println(projectName + "is available in Db==PASS");
			}
		}
		if(flag==false) {
			System.out.println(projectName + "is not available in Db==FAIL");
			conn.close();

		}

	}
}

