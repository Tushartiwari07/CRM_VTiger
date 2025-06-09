package mocktask;	
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.tek.crm.genericutility.FileUtility;
import com.tek.crm.webdriverutility.WebDriverUtility;

public class PlaySongInSpotifyTest {
	@Test
	public void playsong() throws Exception
	{
		WebDriver driver= new ChromeDriver();
		FileUtility flib= new FileUtility();
		WebDriverUtility wlib= new WebDriverUtility(driver);
		wlib.waitForWebPageToLoad(driver);
		wlib.maximizeBrowser(driver);
		String url = flib.getDataFromProperties("SpotUrl");
		 driver.get(url);
		 driver.findElement(By.xpath("//span[text()='Log in']")).click();
		 driver.findElement(By.id("login-username")).sendKeys(flib.getDataFromProperties("SpotUN"));
		 driver.findElement(By.xpath("//span[text()='Continue']")).click();
		 Thread.sleep(3000);
		 driver.findElement(By.xpath("//input[@type='search']")).sendKeys(flib.getDataFromProperties("SpotSearch"),Keys.ENTER);
		 WebElement yoyoImgIcon =driver.findElement(By.xpath("//p[@id=\"card-title-spotify:artist:7uIbLdzzSEqnX0Pkrb56cR-0\"]"));
		 wlib.waitForElementToBeClickable(driver, yoyoImgIcon);
		 yoyoImgIcon.click();
		  driver.findElement(By.xpath("//button[@aria-label='Play Millionaire by Yo Yo Honey Singh']")).click();

		 List<WebElement> songsName = driver.findElements(By.xpath("//div[contains(@class,'e-9921-text encore-text-body-medium encore-internal-color-text-base b')]"));
		 System.out.println(songsName.size());
		 
		 List<WebElement> views = driver.findElements(By.xpath("//div[contains(@class,'e-9921-text encore-text-body-small H')]"));
		 System.out.println(views.size());
		 for(int i=1;i<=songsName.size() && i<=views.size();i++)
			{
			 System.out.println("Song Name:"+songsName.get(i).getText()+" Views:"+views.get(i).getText());
			}
		 
	}

}
