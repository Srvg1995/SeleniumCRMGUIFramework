package practice.contacttest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateContactWithOrgTest {

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

		//read test script data from Excel file
		FileInputStream fis1=new FileInputStream("C:\\Users\\gagan\\OneDrive\\Desktop\\data\\testScriptdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet("contact");
		Row row = sh.getRow(7);
		String orgName = row.getCell(2).toString()+randomInt;
		String contactLastName = row.getCell(3).getStringCellValue();
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

		//verify Header orgName info Expected result
		String headerInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(headerInfo.contains(orgName))
		{
			System.out.println(orgName+ "header is verified==PASS");
		}
		else {
			System.out.println(orgName+ "header is not verified==FAIL");
		}


		//step5:navigate to contact module
		driver.findElement(By.linkText("Contacts")).click();

		//step6: click on "create contact" Button
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();

		//step7:enter all the details & create new contact
		driver.findElement(By.name("lastname")).sendKeys(contactLastName);
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click(); // XPATH BY FOLLOWING SIBLING CONCEPT USED HERE

		//switch to child window
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();

		while(it.hasNext())
		{
			String windowID = it.next();
			driver.switchTo().window(windowID);

			String actUrl = driver.getCurrentUrl();
			if(actUrl.contains("module=Accounts"))
			{
				break;
			}
		}

		driver.findElement(By.name("search_text")).sendKeys(orgName);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();  //DYNAMIC XPATH USED HERE-***VVIMP



		//switch to parent window
		Set<String> set1 = driver.getWindowHandles();
		Iterator<String> it1 = set1.iterator();

		while(it1.hasNext())
		{
			String windowID = it1.next();
			driver.switchTo().window(windowID);

			String actUrl1 = driver.getCurrentUrl();
			if(actUrl1.contains("Contacts&action")) //this is an url @ address bar
			{
				break;
			}
		}

		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		//verify Header phone Number info Expected result
		 headerInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(headerInfo.contains(contactLastName))
		{
			System.out.println(contactLastName + " header is verified==PASS");
		}
		else {
			System.out.println(contactLastName + " header is not verified==FAIL");
		}

		//verify Header orgName info Expected result
		String actOrgName = driver.findElement(By.id("mouseArea_Organization Name")).getText();
		System.out.println(actOrgName);
		if(actOrgName.trim().equals(orgName))
		{
			System.out.println(orgName + " information is verified==PASS");
		}
		else {
			System.out.println(orgName + " information is not verified==FAIL");
		}


		//step5:logout
		driver.quit();
	

}

}
