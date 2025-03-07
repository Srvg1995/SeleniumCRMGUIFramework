package practice.contacttest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateContactTest {

	public static void main(String[] args) throws Throwable {
		 // read common data from PROPERTIES FILE
		FileInputStream fis =new FileInputStream("C:\\Users\\gagan\\OneDrive\\Desktop\\data\\commondata.properties");
		Properties p=new Properties();
		p.load(fis);
		
		String BROWSER = p.getProperty("browser");
		String URL = p.getProperty("url");
		String USERNAME = p.getProperty("username");
		String PASSWORD = p.getProperty("password");
		
		//generate the random number
		Random random=new Random();
		int randomInt = random.nextInt(1000);
		
		//read testscript data from Excel file
		FileInputStream fis1=new FileInputStream("C:\\Users\\gagan\\OneDrive\\Desktop\\data\\testScriptdata.xlsx");
		 Workbook wb = WorkbookFactory.create(fis1);
		  Sheet sh = wb.getSheet("contact");
		  Row row = sh.getRow(1);
		  String lastName = row.getCell(2).toString()+randomInt;
		  wb.close();
		  
		  WebDriver driver=null;
		  if(BROWSER.equals("chrome")) {
			  driver=new ChromeDriver();}
		  
			  else if(BROWSER.equals("firefox")) {
				  driver=new FirefoxDriver();}
			  
			  else if(BROWSER.equals("edge")) {
				  driver=new EdgeDriver();}
			  else  {
				  driver=new ChromeDriver();}
		  
		  //step1: login to app
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		  driver.get(URL);
		  driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		  driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		  driver.findElement(By.id("submitButton")).click();
		  
		  //step2:navigate to contact module
		  driver.findElement(By.linkText("Contacts")).click();
		  
		  //step3: click on "create contact" Button
		  driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		  
		  //step4:enter all the details & create new contact
		  driver.findElement(By.name("lastname")).sendKeys(lastName);
		  driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		  
		  //verify Header msg Expected result
		  String actLastName = driver.findElement(By.id("dtlview_Last Name")).getText();
		  if(actLastName.equals(lastName))
		  {
			  System.out.println(lastName + " information is verified==PASS");
		  }
		  else {
			  System.out.println(lastName + " information is not verified==FAIL");
		  }
		      
		 
		  
		  //step5:logout
		  driver.quit();
	}
	
		
		
	

	}


