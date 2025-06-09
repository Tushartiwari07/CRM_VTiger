package demo;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.tek.crm.genericutility.ExcelUtility;
import com.tek.crm.webdriverutility.WebDriverUtility;

public class GetProductPriceAndWriteIntoExcel {
	@Test
	public void rightProductPriceIntoExcel() throws EncryptedDocumentException, IOException, InterruptedException {
		WebDriver driver = new ChromeDriver();
		WebDriverUtility wlib = new WebDriverUtility(driver);
		wlib.maximizeBrowser(driver);
		wlib.waitForWebPageToLoad(driver);

		ExcelUtility elib = new ExcelUtility();
		String brandName = elib.getStringDataFromExcel("ProductPrice", 1, 0);
		String iphone16 = elib.getStringDataFromExcel("ProductPrice", 1, 1);
		String urlIphone16 = elib.getStringDataFromExcel("ProductPrice", 1, 3);
		String iphone13 = elib.getStringDataFromExcel("ProductPrice", 2, 1);
		String urlIphone13 = elib.getStringDataFromExcel("ProductPrice", 2, 3);
		String iphoneTeal = elib.getStringDataFromExcel("ProductPrice", 3, 1);
		String urlIphoneTeal = elib.getStringDataFromExcel("ProductPrice", 3, 3);
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//input[@title='Search for Products, Brands and More']")).sendKeys(brandName,
				Keys.ENTER);
		driver.findElement(By.xpath("//div[text()='" + iphone16 + "']")).click();
		wlib.switchToNewWindowWithURL(driver, urlIphone16);
		String priceOfIpone16 = driver
				.findElement(By.xpath("//span[text()='" + iphone16 + "']/../../..//div[contains(@class,'Nx9bqj')]"))
				.getText();
		System.out.println(priceOfIpone16);
		int rowIndex = 1;
		elib.setDataIntoExcel("ProductPrice", rowIndex, 2, priceOfIpone16);
		rowIndex++;
		driver.close();
		wlib.switchToNewWindowWithURL(driver, "https://www.flipkart.com/search?");
		driver.findElement(By.xpath("//div[text()='" + iphone13 + "']")).click();
		wlib.switchToNewWindowWithURL(driver, urlIphone13);
		String priceOfIpone13 = driver
				.findElement(By.xpath("//span[text()='" + iphone13 + "']/../../..//div[contains(@class,'Nx9bqj')]"))
				.getText();
		System.out.println(priceOfIpone13);
		elib.setDataIntoExcel("ProductPrice", rowIndex, 2, priceOfIpone13);
		rowIndex++;
		driver.close();
		wlib.switchToNewWindowWithURL(driver, "https://www.flipkart.com/search?");
		driver.findElement(By.xpath("//div[text()='" + iphoneTeal + "']")).click();
		wlib.switchToNewWindowWithURL(driver, urlIphoneTeal);
		String priceOfIponeteal = driver
				.findElement(By.xpath("//span[text()='" + iphoneTeal + "']/../../..//div[contains(@class,'Nx9bqj')]"))
				.getText();
		System.out.println(priceOfIponeteal);
		elib.setDataIntoExcel("ProductPrice", rowIndex, 2, priceOfIponeteal);
		rowIndex++;
		driver.quit();

	}
}
