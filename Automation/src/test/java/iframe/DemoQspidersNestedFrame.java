package iframe;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DemoQspidersNestedFrame {
	@Test
	public void nestedFrameQspiders() throws InterruptedException
	{
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://demoapps.qspiders.com/");
		driver.findElement(By.xpath("//div[text()='Explore more']/../..//p[text()='UI Testing Concepts']")).click();
		driver.findElement(By.xpath("//section[text()='Frames']")).click();
		driver.findElement(By.xpath("//section[text()='iframes']")).click();
		driver.findElement(By.linkText("Nested iframe")).click();
		Thread.sleep(1000);
		driver.switchTo().frame(0);
		Thread.sleep(1000);
		driver.switchTo().frame(1);
		driver.findElement(By.id("email")).sendKeys("Admin@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Admin@1234");
		driver.findElement(By.id("confirm-password")).sendKeys("Admin@1234");
		driver.findElement(By.id("submitButton")).click();
	}

}
