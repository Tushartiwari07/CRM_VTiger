package mocktask;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.tek.crm.webdriverutility.WebDriverUtility;

public class FlipkartFilters {
	@Test
	public void filterAndtakeScreenshot()
	{
		WebDriver driver = new ChromeDriver();
		WebDriverUtility wlib= new WebDriverUtility(driver);
		wlib.waitForWebPageToLoad(driver);
		wlib.maximizeBrowser(driver);
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Jeans for men",Keys.ENTER);
		driver.findElement(By.xpath("//div[text()='Brand']")).click();
		driver.findElement(By.xpath("//div[contains(@title,'LEVI')]")).click();
		WebElement minDropdown = driver.findElement(By.xpath("(//select[@class='Gn+jFg'])[1]"));
		wlib= new WebDriverUtility(minDropdown);
		wlib.selectByValue("500");
		WebElement maxDropdown = driver.findElement(By.xpath("(//select[@class='Gn+jFg'])[2]"));
		wlib= new WebDriverUtility(maxDropdown);
		wlib.selectByValue("2000");
		
	}

}
