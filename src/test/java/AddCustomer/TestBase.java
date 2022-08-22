package AddCustomer;

import java.io.File;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
	private static final String PropertyConfigurator = null;
	WebDriver driver;
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32 (10)\\chromedriver.exe");
		driver = new ChromeDriver();
		Logger.getLogger("ebanking");
	//	PropertyConfigurator.configure("Log4j.properties");
		driver.get("https://www.commbank.com.au/digital/home-loans/calculator/how-much-can-i-borrow");
	}
	
	 public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{
	{

        WebDriver driver;
		TakesScreenshot scrShot =((TakesScreenshot)webdriver);

        //Call getScreenshotAs method to create image file

                File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

            //Move image file to new destination

                File DestFile=new File(fileWithPath);

                //Copy file at destination

                FileUtils.copyFile(SrcFile, DestFile);
	}

	 }
}
