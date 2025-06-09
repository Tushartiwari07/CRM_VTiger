package vTiger;

import java.io.FileInputStream;
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
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class CreateContactAndSelectOrg {
	@Test
	public void selectOrgInContact() throws IOException, ParseException
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
		String lastName = row.getCell(5).toString()+randomNumber;			

	
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
			driver= new ChromeDriver();
		}
		
		 //Navigate to the application
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(url);
		
		//Login to Application
			driver.findElement(By.name("user_name")).sendKeys(username);
			driver.findElement(By.name("user_password")).sendKeys(password);
			driver.findElement(By.id("submitButton")).click();
			
			driver.findElement(By.linkText("Organizations")).click();
			driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
			driver.findElement(By.name("accountname")).sendKeys(orgName);
			driver.findElement(By.name("button")).click();
			
			
			String actualOrgName = driver.findElement(By.id("dtlview_Organization Name")).getText();
			if(actualOrgName.equals(orgName))
			{
				System.out.println(orgName+" is created successfully==== PASS");
			}
			else
			{
				System.out.println(orgName+" is not created successfully==== Fail");
			}
			// Create contact and select orgainzation
			driver.findElement(By.linkText("Contacts")).click();
			String parentId = driver.getWindowHandle();
			driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
			driver.findElement(By.name("lastname")).sendKeys(lastName);
			driver.findElement(By.xpath("(//img[@title='Select'])[1]")).click();
			Set<String> windowID = driver.getWindowHandles();
			for(String id: windowID)
			{
				driver.switchTo().window(id);
				if(driver.getCurrentUrl().contains("http://localhost:8888/index.php?module=Accounts&action=Popup&popu"))
				{
					break;
				}
			}
			driver.findElement(By.id("search_txt")).sendKeys(orgName);
			driver.findElement(By.name("search")).click();
			driver.findElement(By.linkText(orgName)).click();
			//Switch back to parent window
			driver.switchTo().window(parentId);
			String actualOrgSelected= driver.findElement(By.name("account_name")).getText();
			if((actualOrgName.trim()).equals(orgName))
			{
				System.out.println(orgName+" is selected successfully==== Pass");
			}
			else
			{
				System.out.println(orgName+" is not selected ==== Fail");
			}
			//save the contact
			driver.findElement(By.name("button")).click();

			
			//Logout Action
			driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
			driver.findElement(By.linkText("Sign Out")).click();
			driver.close();
		
	}

}
