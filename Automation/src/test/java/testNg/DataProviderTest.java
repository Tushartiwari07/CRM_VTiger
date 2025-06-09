package testNg;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
	@Test(dataProvider = "getData")
	public void dataProviderTest(String brandName, String moduleName) throws InterruptedException
	{
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(brandName,Keys.ENTER);
		String xp="//span[text()='"+moduleName+"']/../../../..//span[@class='a-price-whole']";
		Thread.sleep(3000);
		String price = driver.findElement(By.xpath(xp)).getText();
		System.out.println(moduleName+"  Price :"+price);
		driver.close();
	}
	@DataProvider
	public Object[][] getData()
	{
		Object[][] objArr= new Object[4][2];
		objArr[0][0]="nike shoes for man";
		objArr[0][1]="Revolution 7-Black/University Red-White-Fb2207-003-6Uk - Mens, Running Shoes";
		objArr[1][0]="iphone";
		objArr[1][1]="iPhone 16 Pro Max 256 GB: 5G Mobile Phone with Camera Control, 4K 120 fps Dolby Vision and a Huge Leap in Battery Life. Works with AirPods; Desert Titanium";
		objArr[2][0]="lenovo loq i5 12th gen rtx 3050";
		objArr[2][1]="Lenovo Smartchoice LOQ, Intel Core i5-12450HX, 12th Gen, RTX 3050-6GB, 16GB RAM, 512GB SSD, FHD 144Hz 300Nits, 15.6\"/39.6cm, Windows 11, MS Office 21, Grey, 2.4Kg, 83GS003UIN, Gaming Laptop";
		objArr[3][0]="samsung s24";
		objArr[3][1]="Samsung Galaxy S24 Ultra 5G AI Smartphone with Galaxy AI (Titanium Gray, 12GB, 256GB Storage), Snapdragon 8 Gen 3, 200 MP Camera with ProVisual Engine and 5000mAh Battery";
		return objArr;
		
	}

}
