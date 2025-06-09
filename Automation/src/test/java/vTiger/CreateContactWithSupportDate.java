package vTiger;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class CreateContactWithSupportDate {
	@Test
	public void contactWithSupportDate() throws EncryptedDocumentException, IOException, ParseException
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
				
				//Capture current and next date
				
				//START DATE
				Date date= new Date();
				SimpleDateFormat simpleDate= new SimpleDateFormat("yyyy-MM-dd");
				String startDate = simpleDate.format(date);
				System.out.println(startDate);
				Calendar cal = simpleDate.getCalendar();
		        cal.add(Calendar.DAY_OF_MONTH,30);
		        //EndDate
		        String endDate = simpleDate.format(cal.getTime());
		        System.out.println(endDate);
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
					WebElement sdateEle = driver.findElement(By.name("support_start_date"));
					WebElement EdateEle = driver.findElement(By.name("support_end_date"));
					sdateEle.clear();
					sdateEle.sendKeys(startDate);
					EdateEle.clear();
					EdateEle.sendKeys(endDate);
					//save Button
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
					String actualStartDate = driver.findElement(By.id("dtlview_Support Start Date")).getText();
					String actualEndDate = driver.findElement(By.id("dtlview_Support End Date")).getText();
							if(actualStartDate.equals(startDate))
							{
								System.out.println(startDate+" is added successfully==== PASS");
							}
							else 
							{
								System.out.println(startDate+" is not added==== Fail");
							}
							if(actualEndDate.equals(endDate))
							{
								System.out.println(endDate+" is added successfully==== PASS");
							}
							else 
							{
								System.out.println(endDate+" is not added==== Fail");
							}
					//Logout Action
					driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
					driver.findElement(By.linkText("Sign Out")).click();
					driver.quit();
			
	
	
	}

}
