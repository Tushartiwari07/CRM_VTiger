package demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DmoTest {
	@Test()
	@Parameters("Browser")
	public void test(String browser)
	{
		WebDriver driver = new FirefoxDriver();
		
		System.out.println(browser);
	}

}
