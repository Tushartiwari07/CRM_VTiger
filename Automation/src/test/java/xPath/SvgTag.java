package xPath;

import java.time.Duration;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class SvgTag {
	@Test
	public void svgXpath() throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		//Action on SvG tag Directly
//		driver.findElement(By.xpath("(//*[local-name()='svg'])[3]")).click();
		
		//Action on SVG tag through child tag
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//*[local-name()='svg'])[1]")).click();
//		driver.findElement(By.xpath("(//*[local-name()='svg'])[1]/*[name()='g']"))
//		.click();
		
	}

}
