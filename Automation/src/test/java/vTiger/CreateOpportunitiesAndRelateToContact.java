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
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class CreateOpportunitiesAndRelateToContact {
	@Test
	public void opportunitiesAndRelateToContact() throws FileNotFoundException, IOException, ParseException, InterruptedException
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
				String lastName = row.getCell(5).toString()+randomNumber;	
				String oppName = row.getCell(6).toString()+randomNumber;

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
					
					// crate contact
					driver.findElement(By.linkText("Contacts")).click();
					driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
					driver.findElement(By.name("lastname")).sendKeys(lastName);					
					driver.findElement(By.name("button")).click();
					String actualLastname= driver.findElement(By.id("mouseArea_Last Name")).getText();
//					System.out.println("A:"+actualLastname+" L:"+lastName);
					if((actualLastname.trim()).equals(lastName))
					{
						System.out.println(lastName+" contact is added successfully==== PASS");
					}
					else
					{
						System.out.println(lastName+" contact is not added==== Fail");
					}
					// Create Opportunities
					driver.findElement(By.linkText("Opportunities")).click();
					driver.findElement(By.xpath("//img[@title='Create Opportunity...']")).click();
					String parentId= driver.getWindowHandle();
					driver.findElement(By.name("potentialname")).sendKeys(oppName);
					Select sel = new Select(driver.findElement(By.id("related_to_type")));
					sel.selectByValue("Contacts");
					driver.findElement(By.xpath("(//img[@title='Select'])[1]")).click();
					Set<String> windowIds = driver.getWindowHandles();
					for(String id:windowIds)
					{
						driver.switchTo().window(id);
						if(!id.equals(parentId))
						{
							break;
						}
					}
					driver.findElement(By.id("search_txt")).sendKeys(lastName,Keys.ENTER);
					driver.findElement(By.linkText(lastName)).click();
					driver.switchTo().window(parentId);
					driver.findElement(By.xpath("(//input[@type='submit'])[1]")).click();
					
					//verify
					String ActualrelatedContact=driver.findElement(By.linkText(lastName)).getText();
					if((ActualrelatedContact.trim()).equals(lastName))
					{
						System.out.println(lastName+" contact is related to Opportunities successfully==== PASS");
					}
					else
					{
						System.out.println(lastName+" contact is not related to Opportunities ==== Fail");

					}
					//Logout Action
					driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
					driver.findElement(By.linkText("Sign Out")).click();
					driver.quit();
			
	
	
	}
	

}
