package demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.tek.crm.object_repository.LoginPage;
import com.tek.crm.object_repository.OrganizationCreatedPage;

public class Verify {
	@Test
	public void verifyTest()
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		LoginPage lp = new LoginPage(driver);
		OrganizationCreatedPage orgCreated = new OrganizationCreatedPage(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://localhost:8888/index.php?module=Accounts&parenttab=Marketing&action=DetailView&record=94");
		lp.login("admin", "admin");
		System.out.println(driver.findElement(By.id("mouseArea_Industry")).getText());
		System.out.println(driver.findElement(By.id("mouseArea_Type")).getText());
		
		System.out.println(orgCreated.getActualIndustryName().getText());
		
		
		
		
		
		

		
	}
	

}
