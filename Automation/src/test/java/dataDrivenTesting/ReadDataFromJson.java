package dataDrivenTesting;

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

public class ReadDataFromJson {
	@Test
	public void jSonDataReading() throws FileNotFoundException, IOException, ParseException
	{
		JSONParser jsp= new JSONParser();
		Object obj=jsp.parse(new FileReader("./src/test/resources/TestData.json"));
		JSONObject jso=(JSONObject)obj;
		String url = jso.get("Url").toString();
	     int timeout = Integer.parseInt(jso.get("timeout").toString());
		String firstName = jso.get("FirstName").toString();
		String lastName = jso.get("LastName").toString();
		String company = jso.get("Company").toString();
		String location = jso.get("Location").toString();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
		driver.get(url);
		driver.findElement(By.xpath("//div[1]/input[1]")).sendKeys(firstName);
		driver.findElement(By.xpath("//div[1]/input[2]")).sendKeys(lastName);
		driver.findElement(By.xpath("//div[2]/input[1]")).sendKeys(company);
		driver.findElement(By.xpath("//div[2]/input[2]")).sendKeys(location);
	}

}
