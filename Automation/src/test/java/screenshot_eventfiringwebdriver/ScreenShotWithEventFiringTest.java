//package screenshot_eventfiringwebdriver;
//
//import java.io.File;
//import java.io.IOException;
//
//import org.apache.commons.io.FileUtils;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.events.EventFiringWebDriver;
//import org.testng.annotations.Test;
//
//public class ScreenShotWithEventFiringTest {
//	@Test
//	public void screenshot() throws IOException
//	{
//		WebDriver driver = new ChromeDriver();
//		driver.get("https://www.google.com/");
//		EventFiringWebDriver efd= new EventFiringWebDriver(driver);
//		File tempfile = efd.getScreenshotAs(OutputType.FILE);
//		FileUtils.copyFile(tempfile, new File("./screenshot/eventfiringScreenshot.png"));
//		
//	}
//
//}
