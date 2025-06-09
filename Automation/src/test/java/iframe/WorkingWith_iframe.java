package iframe;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WorkingWith_iframe {
	@Test
	public void iframeTest() throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("file:///C:/Users/tusha/OneDrive/Desktop/iFrame.html");
		Thread.sleep(2000);
//		driver.switchTo().frame(0);
		driver.switchTo().frame("FR1");
		driver.findElement(By.linkText("Log in")).click();
		Thread.sleep(2000);
		driver.navigate().back();
		driver.switchTo().defaultContent();
		driver.findElement(By.linkText("Google")).click();
		
	}

}
