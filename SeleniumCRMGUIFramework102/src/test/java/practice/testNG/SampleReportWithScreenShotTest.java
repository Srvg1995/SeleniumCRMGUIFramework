package practice.testNG;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class SampleReportWithScreenShotTest {

	ExtentReports report; //this we made it global in order to access it inside the testscripts.
	@BeforeSuite
	public void configBS() {
		//Spark report config
		ExtentSparkReporter spark=new ExtentSparkReporter("./AdvanceReport/report.html");
		spark.config().setDocumentTitle("CRM Test Suite Results");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);

		//add Environment information & create test
	    report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-11");
		report.setSystemInfo("BROWSER", "CHROME-100");
	}
	
	@AfterSuite
	public void configAS() {
		report.flush();
	}

	@Test
	public void createContactTest() {
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888");
		TakesScreenshot eDriver=(TakesScreenshot) driver;
		String filePath = eDriver.getScreenshotAs(OutputType.BASE64); //Here instead of FILE ,we should select BASE64-Because in my extent report if we want to attach a screenshot(ie,test.addScreenCaptureFromBase64String(filePath, "ErrorFile");),we have to use BASE64 only. 

		ExtentTest test = report.createTest("createContactTest");
		test.log(Status.INFO, "login to app");
		test.log(Status.INFO, "navigate to contact page");
		test.log(Status.INFO, "create contact");
		if("HDFC".equals("HDFC")) {
			test.log(Status.PASS,"contact is created");
		}else {
			test.addScreenCaptureFromBase64String(filePath, "ErrorFile"); //Here ErrorFile is a name given by us for failed one.
		}
		driver.close();
	}
	
	
}
