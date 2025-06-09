package demo;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.tek.crm.webdriverutility.WebDriverUtility;
import com.tek.javautility.JavaUtility;

public class CheckUtilityMethods {
	@Test
	public void test() throws IOException
	{
//		WebDriver driver = new ChromeDriver();
//		WebDriverUtility wlib = new WebDriverUtility(driver);
//		wlib.maximizeBrowser(driver);
//		driver.get("https://demowebshop.tricentis.com/");
//		wlib.waitForWebPageToLoad(driver);
//		wlib.getScreenShot(driver, "demoWebShop");
//		wlib.getScreenShotOnWEBElement(driver.findElement(By.xpath("//img[@alt='Tricentis Demo Web Shop']")),"DemoWebShopTittle");
//		wlib.moveToELement(driver.findElement(By.partialLinkText("Digital downloads")));
//		wlib.rightClick(driver.findElement(By.linkText("Register")));
		JavaUtility jlib= new JavaUtility();
		System.out.println(jlib.getRequiredDate(30));
		System.out.println(jlib.getSystemDateyyyyMMdd());
//		

		
	}

}
