package xPath;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class PrecesingAndFollowingSibling {
	@Test
	public void testPrecedingAndFollowing()
	{
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("file:///C:/Users/tusha/OneDrive/Desktop/Tabel.html");
		//Preceding Sibling
		driver.findElement(By.xpath("//div[contains(text(), 'FirstName')]/input[2]/preceding-sibling::input"))
		.sendKeys("Tushar");
		//Following Sibling
		driver.findElement(By.xpath("//div[contains(text(), 'FirstName')]/input[1]/following-sibling::input"))
		.sendKeys("Tiwari");
		//Going to Parent Directly
		driver.findElement(By.xpath("//div[contains(text(), 'FirstName')]/input[1]/parent::div/following-sibling::div//input[1]"))
		.sendKeys("TekPyramid");
		driver.findElement(By.xpath("//div[contains(text(), 'Company')]/input[2]")).sendKeys("Bengaluru");
	}

}
