package dataDrivenTesting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;



//To execute  Script mvn -Dtest=CommandLineTest test
public class CommandLineTest {
	WebDriver driver;
	@Test
	public void executeWithCommandLine() {
		System.out.println("Program is executing from Command prompt");
		//mvn -Dtest=CommandLineTest test -DuName="Tushar"
//	System.out.println(System.getProperty("uName"));
		
	}
	@Test()

//mvn test -Dtest=CommandLineTest#testCmd
//	-DUrl="file:///C:/Users/tusha/OneDrive/Desktop/Tabel.html" 
//	-DFirstName="Tushar"
//	-DLastName="Tiwari" 
//	-DCompany="Tek Pyramid"
//	-DLocation="Bengaluru"
	public void testCmd()
	{
		 driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			String url= System.getProperty("Url");
			driver.get(url);
		String fName = System.getProperty("FirstName");
		String lName = System.getProperty("LastName");
		String company = System.getProperty("Company");
		String location = System.getProperty("Location");
		driver.findElement(By.xpath("//div[1]/input[1]")).sendKeys(fName);
		driver.findElement(By.xpath("//div[1]/input[2]")).sendKeys(lName);
		driver.findElement(By.xpath("//div[2]/input[1]")).sendKeys(company);
		driver.findElement(By.xpath("//div[2]/input[2]")).sendKeys(location);
		driver.close();
		
		


	}

}
