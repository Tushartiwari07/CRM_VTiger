package demo;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Flipkart {
	@Test
	public void test()
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//img[@alt='Fashion']")).click();
		driver.findElement(By.linkText("Men's T-Shirts")).click();
		WebElement mens = driver.findElement(By.xpath("//span[text()='Men']"));
		//div[@class='wZsanD'])[2]/a/
		mens.click();
		WebElement cloths = driver.findElement(By.xpath("//a[@title='Clothing']"));
//		System.out.println(cloths);
		List<WebElement> mensOption = driver.findElements(By.xpath("(//div[@class='wZsanD'])[2]/a"));
		//System.out.println(mensOption);
		for(WebElement ele:mensOption)
		{
			if(ele.getText().contains("Clothing"))
			{
				continue;
			}
			else
			{
				System.out.println(ele.getText());
			}	
		}
		driver.close();
		
	}

}
