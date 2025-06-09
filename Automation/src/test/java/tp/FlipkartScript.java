package tp;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FlipkartScript {
	@Test
	public void priceOfFirstProduct() throws FileNotFoundException, IOException, ParseException
	{
		JSONParser jsp= new JSONParser();
		Object obj = jsp.parse(new FileReader("./src/test/resources/TestData.json"));
		JSONObject jobj=(JSONObject)obj;
		 String url = jobj.get("FlipUrl").toString();
		 
		 WebDriver driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		 driver.get(url);
		 driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Samsung s23 fe");
		 driver.findElement(By.xpath("//button[@type='submit']")).click();
//		 String text = driver.findElement(By.cssSelector("div[style=\"width: 25%;\"]")).getText();
//		 String price = driver.findElement(By.xpath("//a[@target=\"_blank\"][2]/..//div[@class='Nx9bqj']")).getText();
		 String price= driver.findElement(By.xpath("//a[@target='_blank']/..//div[@class=\"Nx9bqj _4b5DiR\" or @class='Nx9bqj']")).getText();
		 System.out.println(price);
		 driver.quit();
		 
		 
		 
		 
		 
		 
		 
		 
//		div[style="width: 25%;"]
		//a[@target='_blank']/..//div[@class="Nx9bqj _4b5DiR"]
	}

}
