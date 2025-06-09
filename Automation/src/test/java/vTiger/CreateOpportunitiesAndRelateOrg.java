package vTiger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class CreateOpportunitiesAndRelateOrg {
	@Test
	public void opportunitiesAndRelateOrg() throws FileNotFoundException, IOException, ParseException, InterruptedException
	{

		// to Read commonData from Json
		JSONParser jp = new JSONParser();
		Object obj = jp.parse(new FileReader("./src/test/resources/VtigerTestData.json"));
		JSONObject jobj=(JSONObject)obj;
		String browser = jobj.get("Browser").toString();
		String url = jobj.get("Url").toString();
		String username = jobj.get("Username").toString();
		String password = jobj.get("Password").toString();
		
		//TO create random Numbers
		Random rom = new Random();
		int randomNumber = rom.nextInt(1000);

		//To read TestScript Data From Excel
		FileInputStream fis = new FileInputStream("./src/test/resources/TestCase.xlsm");
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sh = workbook.getSheet("organization");
		Row row = sh.getRow(1);
		String orgName = row.getCell(1).toString()+randomNumber;
		String oppName = row.getCell(6).toString()+randomNumber;
		
		ChromeOptions options= new ChromeOptions();
		options.addArguments("--disable-notifications");

	
		//To launch browser based on commondata
		WebDriver driver;
		if(browser.contains("chrome"))
		{
			 driver= new ChromeDriver();
		}else if(browser.contains("firefox"))
		{
			 driver= new FirefoxDriver();
		}else if(browser.contains("edge"))
		{
			 driver= new EdgeDriver();
		}else
		{
			driver= new ChromeDriver(options);
		}
		
		 //Navigate to the application
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(url);
		
		//Login to Application
			driver.findElement(By.name("user_name")).sendKeys(username);
			driver.findElement(By.name("user_password")).sendKeys(password);
			driver.findElement(By.id("submitButton")).click();
			
			//Create org
			driver.findElement(By.linkText("Organizations")).click();
			driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
			driver.findElement(By.name("accountname")).sendKeys(orgName);
			driver.findElement(By.name("button")).click();

			//Validate org
			String actualOrgName = driver.findElement(By.id("dtlview_Organization Name")).getText();
			if(actualOrgName.equals(orgName))
			{
				System.out.println(orgName+" is created successfully==== PASS");
			}
			else
			{
				System.out.println(orgName+" is not created successfully==== Fail");
			}
			driver.findElement(By.linkText("Opportunities")).click();
			driver.findElement(By.xpath("//img[@title='Create Opportunity...']")).click();
			String parentId= driver.getWindowHandle();
		
				Thread.sleep(2000);
				driver.findElement(By.name("potentialname")).sendKeys(oppName);
				driver.findElement(By.xpath("//img[@title='Select']")).click();
				
			Set<String> windowId = driver.getWindowHandles();
			for(String id:windowId)
			{
				driver.switchTo().window(id);
				if(driver.getCurrentUrl().contains("http://localhost:8888/index.php?module=Accounts&action=Popup"))
				{
					driver.findElement(By.id("search_txt")).sendKeys(orgName);
					driver.findElement(By.name("search")).click();
					driver.findElement(By.linkText(orgName)).click();
				}
			}
			
			driver.switchTo().window(parentId);
			driver.findElement(By.name("button")).click();
			String ActualRelatedORG = driver.findElement(By.linkText(orgName)).getText();
			if(ActualRelatedORG.equals(orgName))
			{
				System.out.println(orgName+" is related successfully==== PASS");
			}
			else
			{
				System.out.println(orgName+" is not related ==== Fail");
			}
			Thread.sleep(10000);
			//Logout Action
			driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
			driver.findElement(By.linkText("Sign Out")).click();
	
	}

}
