package autoSuggestionDropDown;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DemoWebshopAutoSuggesstion {
	@Test
	public void AutoSuggesstion() throws InterruptedException
	{
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://demowebshop.tricentis.com/");
		//ByUsing Start-With
		driver.findElement(By.xpath("//input[starts-with(@class,'search-box-text')]")).sendKeys("compu");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[text()='Build your own computer'])[2]")).click();
		

	}


}
