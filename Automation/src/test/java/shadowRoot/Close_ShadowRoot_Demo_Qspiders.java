package shadowRoot;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Close_ShadowRoot_Demo_Qspiders {
	@Test
	public void closeShadowRoot() throws InterruptedException
	{
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://demoapps.qspiders.com/");
		driver.findElement(By.xpath("//p[text()='UI Testing Concepts']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//section[text()='Shadow Root Elements']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//section[text()='Shadow Root']")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Close Shadow Root")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//h1[text()='Login']")).click();
		Actions action = new Actions(driver);
		action.sendKeys(Keys.TAB).perform();
		action.sendKeys("Tushar").perform();
		action.sendKeys(Keys.TAB).perform();
		Thread.sleep(1000);
		action.sendKeys("Tiwari").perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		Thread.sleep(1000);
		driver.quit();

	}

}
