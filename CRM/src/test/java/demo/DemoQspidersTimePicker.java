package demo;


import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.tek.crm.webdriverutility.WebDriverUtility;

public class DemoQspidersTimePicker {
	@Test(priority = 0)
	public void defaultTimePicker() throws IOException, InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		WebDriverUtility wlib = new WebDriverUtility(driver);
		driver.get("https://demoapps.qspiders.com/ui/timePick?sublist=0");
		wlib.maximizeBrowser(driver);
		wlib.waitForWebPageToLoad(driver);
		driver.findElement(By.xpath("(//*[local-name()='svg'])[1]")).click();
		WebElement hour = driver.findElement(By.xpath("//li[@aria-label='5 hours']"));
		wlib.scrollToElement(hour);
		hour.click();
		WebElement minute = driver.findElement(By.xpath("//li[@aria-label='50 minutes']"));
		wlib.scrollToElement(minute);
		minute.click();
		driver.findElement(By.xpath("//li[@aria-label='PM']")).click();
		wlib.getScreenShot(driver, "defaultTimePicker");
		driver.findElement(By.xpath("//button[text()='OK']")).click();
		Thread.sleep(2000);
		driver.close();
	}
	
	@Test(priority = 1)
	public void timePickerclock() throws IOException, InterruptedException
	{

		WebDriver driver = new ChromeDriver();
		WebDriverUtility wlib = new WebDriverUtility(driver);
		driver.get("https://demoapps.qspiders.com/ui/timePick?sublist=0");
		wlib.maximizeBrowser(driver);
		wlib.waitForWebPageToLoad(driver);
		driver.get("https://demoapps.qspiders.com/ui/timePick/timeClock?sublist=1");
		driver.findElement(By.xpath("//input[@placeholder='hh:mm aa']")).click();
		WebElement source = driver.findElement(By.xpath("//span[text()='12']"));
		WebElement target =  driver.findElement(By.xpath("//span[text()='9']"));
		wlib.dragAndDrop(source, target);
		WebElement sourceMin= driver.findElement(By.xpath("(//span[text()='00'])[2]"));
		WebElement targetMin= driver.findElement(By.xpath("//span[text()='15']"));
		wlib.dragAndDrop(sourceMin, targetMin);
		driver.findElement(By.xpath("//span[text()='PM']")).click();
		driver.findElement(By.xpath("//button[text()='OK']")).click();
		Thread.sleep(2000);
		wlib.getScreenShot(driver, "timePickerclock");
		driver.close();
		
	}

}
