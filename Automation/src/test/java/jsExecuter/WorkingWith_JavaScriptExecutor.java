package jsExecuter;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WorkingWith_JavaScriptExecutor {
	@Test
	public void javaScript()
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://demowebshop.tricentis.com/");
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("document.getElementById('small-searchterms').value='computers';");
		WebElement searchbtn = driver.findElement(By.xpath("//input[@type='submit']"));
		js.executeScript("arguments[0].click();",searchbtn);
		WebElement searchKeywordTextField = driver.findElement(By.id("Q"));
		js.executeScript("arguments[0].value='';",searchKeywordTextField);
		js.executeScript("arguments[0].value='mobiles';",searchKeywordTextField);

		

	}

}
