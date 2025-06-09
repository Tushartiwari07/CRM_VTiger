package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Working_with_Properties_File {
	@Test
	public void propertiesFile() throws IOException 
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/CommonData.properties");
		Properties prop= new Properties();
		prop.load(fis);
		String browser = prop.getProperty("Browser");
		String url = prop.getProperty("Url");
		String firstname = prop.getProperty("Firstname");
		String lastname= prop.getProperty("Lastname");
		String company=prop.getProperty("Company");
		String location=prop.getProperty("Location");
		String age=prop.getProperty("Age");
		String gender=prop.getProperty("Gender");
		String mobileNumber=prop.getProperty("MobileNumber");
		String address=prop.getProperty("Address");
		WebDriver driver;
		if(browser.equals("chrome"))
		{
			driver= new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(browser.equals("edge"))
		{
			driver=new EdgeDriver();
		}
		else
			driver=new ChromeDriver();
		
		driver.get(url);
		driver.findElement(By.xpath("//div[1]/input[1]")).sendKeys(firstname);
		driver.findElement(By.xpath("//div[1]/input[2]")).sendKeys(lastname);
		driver.findElement(By.xpath("//div[2]/input[1]")).sendKeys(company);
		driver.findElement(By.xpath("//div[2]/input[2]")).sendKeys(location);
		driver.findElement(By.xpath("//div[3]/input[1]")).sendKeys(age);
		driver.findElement(By.xpath("//div[3]/input[2]")).sendKeys(gender);
		driver.findElement(By.xpath("//div[3]/input[3]")).sendKeys(mobileNumber);
		driver.findElement(By.xpath("//div[3]/input[4]")).sendKeys(address);


		

		
		







	}

}
