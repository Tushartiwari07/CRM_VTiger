package relative_locators;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.Test;

public class toLeftOfMethod {
	@Test
	public void relattivetoLeftOfMethod()
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demowebshop.tricentis.com/");
		driver.findElement(RelativeLocator.with(By.tagName("a")).toLeftOf(By.xpath("(//a[@class='ico-cart'])[1]"))).click();
	}
	

}
