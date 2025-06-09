package demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;

public class Working_FluentWait {
	@Test
	public void workingWithFulentWait()
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();		
		driver.get("https://shoppersstack.com/");
		 
		WebElement loginbttn = driver.findElement(By.id("loginBtn"));
		FluentWait wait = new FluentWait(driver);
		wait.pollingEvery(Duration.ofSeconds(1));
		wait.withTimeout(Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(loginbttn));
		loginbttn.click();
		
	}

}
