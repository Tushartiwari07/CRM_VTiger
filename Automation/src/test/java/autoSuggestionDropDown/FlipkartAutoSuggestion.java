package autoSuggestionDropDown;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FlipkartAutoSuggestion {
	@Test
	public void AutoSuggestionFlipkart()
	{
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("nike");
		driver.findElement(By.xpath("(//div[text()=' shoes'])[2]")).click();
	}

}
