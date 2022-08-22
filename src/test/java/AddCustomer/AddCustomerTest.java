package AddCustomer;

import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
//import org.apache.logging.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cra.qa.util.TestUtil;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class AddCustomerTest extends TestBase{
	
	private static final String SheetName = "AddCustomer";
	//private static final String "gettestdata() = null;
	public WebDriver driver;
	public static Logger log;
	AddCustomer cust = new AddCustomer(driver);
	//public WebDriver driver;
	public ExtentReports extent;
	static ExtentTest extentTest;
	
	public void AddCustomerTes()
	{
		//super();
		extent = new ExtentReports(System.getProperty("user.dir")+"/test-output/ExtentReport.html",true);
		extent.addSystemInfo("Host Name", "Tanuja");
		extent.addSystemInfo("Environment", "QA");
		driver.get("https://demo.guru99.com/V1/html/addcustomerpage.php");
		Logger log =Logger.getLogger("AddCustome");
		log.info("GET THE TITLE");
		
	}
	
	@DataProvider()
	
	public Object[][] brt() throws InvalidFormatException
	{
		
		Object data[][] = TestUtil.getTestData(SheetName);
		return brt();
		
	}
	
		@Test(dataProvider = "brt")
		public void Amma(String Name,String Address,String City)
		{
			
			driver.get("https://www.commbank.com.au/digital/home-loans/calculator/how-much-can-i-borrow");
			cust = new AddCustomer(driver);
			cust.custname(Name);
			cust.custaddr(Address);
			cust.custcity(City);
	}
	


@AfterTest
public void endReport(){
	extent.flush();
	extent.close();
}

public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException{
//	String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	TakesScreenshot ts = (TakesScreenshot) driver;
	File source = ts.getScreenshotAs(OutputType.FILE);
	// after execution, you could see a folder "FailedTestsScreenshots"
	// under src folder
	String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/" + screenshotName 
			+ ".png";
	File finalDestination = new File(destination);
	FileUtils.copyFile(source, finalDestination);
	return destination;
}

@AfterMethod
public void tearDown(ITestResult result) throws IOException{
	
	if(result.getStatus()==ITestResult.FAILURE){
		extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getName()); //to add name in extent report
		extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getThrowable()); //to add error/exception in extent report
		
		String screenshotPath = AddCustomerTest.getScreenshot(driver, result.getName());
		extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath)); //to add screenshot in extent report
		//extentTest.log(LogStatus.FAIL, extentTest.addScreencast(screenshotPath)); //to add screencast/video in extent report
	}
	else if(result.getStatus()==ITestResult.SKIP){
		extentTest.log(LogStatus.SKIP, "Test Case SKIPPED IS " + result.getName());
	}
	else if(result.getStatus()==ITestResult.SUCCESS){
		extentTest.log(LogStatus.PASS, "Test Case PASSED IS " + result.getName());

	}
	
	
	extent.endTest(extentTest); //ending test and ends the current test and prepare to create html report
	driver.quit();
}
}

