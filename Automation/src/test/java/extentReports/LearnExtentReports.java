package extentReports;
import java.util.Set;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class LearnExtentReports {
	@Test
	public void extentReports() throws InterruptedException 
	{
		ExtentSparkReporter spark= new ExtentSparkReporter("./AdvanceReports/extentReport.html");
		spark.config().setDocumentTitle("CRM Test Suite file Results");
		spark.config().setReportName("Crm Reports");
		spark.config().setTheme(Theme.STANDARD);
		
		ExtentReports report= new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS","Windows 11");
		report.setSystemInfo("Browser","Chrome");
		ExtentTest test = report.createTest("extentReports For CRM");
		test.log(Status.INFO, "Execution started");	

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		Thread.sleep(5000);
		TakesScreenshot ts= (TakesScreenshot)driver;
		String googleFilePath = ts.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(googleFilePath,"googleScreenShot");
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://www.amazon.in/");
		String amazonFilePath = ts.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(amazonFilePath,"amazonScreenShot");


		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://www.flipkart.com/");
		String flipkartFilepath = ts.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(flipkartFilepath,"flipartScreenShot");
		Set<String> wins=driver.getWindowHandles();
		test.log(Status.INFO,"Size: "+wins.size());
		test.addScreenCaptureFromBase64String(amazonFilePath, "amazooooooooooooooon");
		report.flush();
		driver.quit();
		
	
	}
}
