package shadowRoot;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Open_ShadowRoot_Demo_Qspiders {
	@Test
	public void openShadowRoot() throws InterruptedException
	{
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://demoapps.qspiders.com/");
		driver.findElement(By.xpath("//p[text()='UI Testing Concepts']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//section[text()='Shadow Root Elements']")).click();
		driver.findElement(By.xpath("//section[text()='Shadow Root']")).click();
		Thread.sleep(2000);
		SearchContext userNameShadowRoot = driver.findElement(By.xpath("//form/div[1]")).getShadowRoot();
		userNameShadowRoot.findElement(By.cssSelector("input[type='text']")).sendKeys("Tushar");
		Thread.sleep(1000);
		SearchContext passwordShadowRoot = driver.findElement(By.xpath("//form/div[2]")).getShadowRoot();
		passwordShadowRoot.findElement(By.cssSelector("input[type='text']")).sendKeys("Tiwari");
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		
		
		
		
	}

}
