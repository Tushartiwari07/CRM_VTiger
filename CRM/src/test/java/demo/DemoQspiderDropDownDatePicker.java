package demo;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.tek.crm.webdriverutility.WebDriverUtility;

public class DemoQspiderDropDownDatePicker {
	@Test
	public void dropDownDatePicker() throws IOException
	{
		WebDriver driver = new ChromeDriver();
		WebDriverUtility wlib = new WebDriverUtility(driver);
		driver.get("https://demoapps.qspiders.com/ui/datePick/datedropdown?sublist=1");
		wlib.maximizeBrowser(driver);
		wlib.waitForWebPageToLoad(driver);
		driver.findElement(By.xpath("//input[@placeholder='Select A Date']")).click();
		driver.findElement(By.xpath("//div[@class='react-datepicker__month-read-view']")).click();
		driver.findElement(By.xpath("//div[text()='Oct']")).click();
		driver.findElement(By.xpath("//div[@aria-label='Choose Wednesday, October 1st, 2025']")).click();
		wlib.getScreenShot(driver, "dropDownDatePicker");
		driver.close();	
	}

}
