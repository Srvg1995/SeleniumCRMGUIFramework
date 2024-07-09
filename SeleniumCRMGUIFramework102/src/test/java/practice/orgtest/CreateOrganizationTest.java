package practice.orgtest;

import java.io.File;
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

public class CreateOrganizationTest {

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
		  Sheet sh = wb.getSheet("org");
		  Row row = sh.getRow(1);
		  String orgName = row.getCell(2).toString()+randomInt;
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
		  
		  //step2:navigate to organization module
		  driver.findElement(By.linkText("Organizations")).click();
		  
		  //step3: click on "create organization" Button
		  driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		  
		  //step4:enter all the details & create new organization
		  driver.findElement(By.name("accountname")).sendKeys(orgName);
		  driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		  
		  //verify Header msg Expected result
		  String headerInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		  if(headerInfo.contains(orgName))
		  {
			  System.out.println(orgName+ "is created==PASS");
		  }
		  else {
			  System.out.println(orgName+ "is not created==FAIL");
		  }
		      
		  //verify Header orgName info Expected result
		  String actOrgName = driver.findElement(By.id("dtlview_Organization Name")).getText();
		  if(actOrgName.equals(orgName))
		  {
			  System.out.println(orgName+ "information is created==PASS");
		  }
		  else {
			  System.out.println(orgName+ "information is not created==FAIL");
		  }
		  
		  //step5:logout
		  driver.quit();
	}
	
		
		
	}


