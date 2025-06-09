package iframe;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DemoQspidersIframe {
	@Test
	public void multiIframeDemoQspiders() throws InterruptedException
	{
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://demoapps.qspiders.com/");
		driver.findElement(By.xpath("//div[text()='Explore more']/../..//p[text()='UI Testing Concepts']")).click();
		driver.findElement(By.xpath("//section[text()='Frames']")).click();
		driver.findElement(By.xpath("//section[text()='iframes']")).click();
		driver.findElement(By.linkText("Multiple iframe")).click();
		Thread.sleep(2000);
		driver.switchTo().frame(0);
		driver.findElement(By.id("email")).sendKeys("Admin@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Admin@1234");
		driver.findElement(By.id("confirm-password")).sendKeys("Admin@1234");
		driver.findElement(By.id("submitButton")).click();
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		String signUpCnfMsg = driver.findElement(By.xpath("//div[text()='Sign up successful!']")).getText();
		System.out.println(signUpCnfMsg);
		Thread.sleep(1000);
		driver.switchTo().frame(1);
		driver.findElement(By.id("username")).sendKeys("SuperAdmin@gmail.com");
		driver.findElement(By.id("password")).sendKeys("SuperAdmin@1234");
		driver.findElement(By.id("submitButton")).click();
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		String loginSuccessfulMsg = driver.findElement(By.xpath("//div[text()='Login successful!']")).getText();
		System.out.println(loginSuccessfulMsg);
		
	}

}
