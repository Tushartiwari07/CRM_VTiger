package demo;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.tek.crm.genericutility.JsonUtility;
import com.tek.crm.object_repository.HomePage;
import com.tek.crm.object_repository.LoginPage;
import com.tek.crm.object_repository.OrganizationPage;
import com.tek.crm.webdriverutility.WebDriverUtility;

public class DeleteOrganization {
	@Test
	public void deleteOrgTest() throws FileNotFoundException, IOException, ParseException
	{
		JsonUtility jlib= new JsonUtility();
		String browser = jlib.getDataFromJson("Browser");
		String url=jlib.getDataFromJson("Url");
		String username=jlib.getDataFromJson("Username");
		String password= jlib.getDataFromJson("Password");
		
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
		WebDriverUtility wlib= new WebDriverUtility(driver);
		OrganizationPage org = new OrganizationPage(driver);
		HomePage hp= new HomePage(driver);
		LoginPage lp = new LoginPage(driver);
		driver.get(url);
		lp.login(username, password);
		hp.getOrgainzationLink().click();
		org.getOrgSearchTextField().sendKeys("Instagram_877");
		wlib= new WebDriverUtility(org.getOrgInfoSelectDropDown());
		wlib.selectByValue("accountname");
		org.getSearchBtn().click();	
		wlib.switchToAlertAccept(driver);
		driver.findElement(By.name("selected_id")).click();
		driver.findElement(By.xpath("//input[@value='Delete']")).click();
		wlib.switchToAlertAccept(driver);

		
	}

}
