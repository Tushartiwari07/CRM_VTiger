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

public class FlipkartAssinement {
	@Test
	public void testFlipkart() throws FileNotFoundException, IOException, ParseException, InterruptedException
	{
		JSONParser jsp= new JSONParser();
		Object obj = jsp.parse(new FileReader("./src/test/resources/TestData.json"));
		JSONObject jobj=(JSONObject)obj;
		 String url = jobj.get("FlipUrl").toString();
		 
		 WebDriver driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		 driver.get(url);
		 driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Nike air");
		 driver.findElement(By.xpath("//button[@type='submit']")).click();
		 String text = driver.findElement(By.xpath("(//a[contains(text(),'Air Force 1 Flyknit 2.0 Running Shoes')])[1]/..")).getText();
		 System.out.println(text);
		 driver.close();
//		 driver.findElement(By.partialLinkText("men sneakers")).click();
	}

}
