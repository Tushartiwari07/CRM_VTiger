package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.tek.crm.webdriverutility.WebDriverUtility;

public class Google {
	@Test
	public void googleTest()
	{
		WebDriver driver= new ChromeDriver();
		WebDriverUtility wlib = new WebDriverUtility(driver);
		wlib.maximizeBrowser(driver);
		wlib.waitForWebPageToLoad(driver);
		driver.get("https://www.google.com/");
		driver.findElement(By.xpath("//a[@aria-label='Google apps']")).click();
		wlib.switchToFrameByWebElement(driver, driver.findElement(By.xpath("//iframe[@name='app']")));
		WebElement sheets = driver.findElement(By.xpath("//span[text()='Sheets']"));
		wlib.scrollToElement(sheets);
		sheets.click();
	}

}
