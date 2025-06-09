package multipleWindowHandling;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Multi_Windowhandles {
	@Test
	public void handleWindow() throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://demoapps.qspiders.com/ui/browser?sublist=0");
		String parentID = driver.getWindowHandle();
		Thread.sleep(2000);
		driver.findElement(By.id("browserLink1")).click();
		Set<String> windowiD = driver.getWindowHandles();
		for(String id:windowiD)
		{
			driver.switchTo().window(id);
			if(driver.getTitle().contains("Demoapps | Qspider"))
			{
				driver.findElement(By.id("email")).sendKeys("tushartiiwari@gmail.com");
				driver.findElement(By.id("password")).sendKeys("tushar2927");
				Thread.sleep(2000);
				driver.close();
			}
		}
		driver.switchTo().window(parentID);
		Thread.sleep(2000);
		driver.findElement(By.linkText("New Tab")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("browserButton4")).click();
		Set<String> tabiD = driver.getWindowHandles();
		for(String id:tabiD)
		{
			driver.switchTo().window(id);
			if(driver.getCurrentUrl().contains("https://demoapps.qspiders.com/ui/browser/SignUpPage"))
			{
				driver.findElement(By.id("email")).sendKeys("tushartiwari");
				driver.findElement(By.id("password")).sendKeys("tushar2927");
				Thread.sleep(2000);
				driver.close();
			}
		}
		driver.switchTo().window(parentID);
		driver.close();
		
	
	}

}
