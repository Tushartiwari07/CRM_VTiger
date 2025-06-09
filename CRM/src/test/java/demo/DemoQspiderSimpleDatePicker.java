package demo;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.tek.crm.webdriverutility.WebDriverUtility;

public class DemoQspiderSimpleDatePicker {
	@Test
	public void simpleDatePicker() throws IOException
	{
		WebDriver driver = new ChromeDriver();
		WebDriverUtility wlib = new WebDriverUtility(driver);
		driver.get("https://demoapps.qspiders.com/ui/datePick?sublist=0");
		wlib.maximizeBrowser(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("//input[@placeholder='Select A Date']")).click();
		 WebElement nextMonthIcon=driver.findElement(By.xpath("//button[@aria-label='Next Month']"));
//		String month="August";
//		int date=15;
//		int year=2025;
		for(;;)
		{
			try {
				driver.findElement(By.xpath("//div[text()='August 2025']/../..//div[text()='15']")).click();
				break;	
			}
			catch (Exception e) {
//				wlib.waitForElementToBeClickable(driver, nextMonthIcon);
//				wlib.moveToELement(nextMonthIcon);
				nextMonthIcon.click();
				
			}
		}
		wlib.getScreenShot(driver, "DemoQspiderDatePicker");
		driver.close();
	}

}
