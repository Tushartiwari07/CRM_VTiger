package selenium4Methods;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewTab {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		Thread.sleep(5000);
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://www.amazon.in/");
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://www.flipkart.com/");
		Set<String> wins=driver.getWindowHandles();
		System.out.println("Size:"+wins.size());
		
	}

}
