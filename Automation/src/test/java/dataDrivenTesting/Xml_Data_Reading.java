package dataDrivenTesting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class Xml_Data_Reading {
	@Test
	public void xmlData(XmlTest test)
	{
		String browser = test.getParameter("Browser");
		String url =test.getParameter("Url");
		String username =test.getParameter("Username");
		String password =test.getParameter("Password");
		/*
		 * WebDriver driver; if(browser.equals("chrome")) { driver= new ChromeDriver();
		 * } else if(browser.equals("firefox")) { driver=new FirefoxDriver(); } else
		 * if(browser.equals("edge")) { driver=new EdgeDriver(); } else { driver=new
		 * ChromeDriver(); } driver.manage().window().maximize();
		 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		 * driver.get(url);
		 * 
		 * driver.findElement(By.linkText("Log in")).click();
		 * driver.findElement(By.id("Email")).sendKeys(username);
		 * driver.findElement(By.id("Password")).sendKeys(password);
		 * driver.findElement(By.xpath("//input[@value='Log in']")).click();
		 * driver.findElement(By.linkText("tiwaritushar777@gmail.com")).click();
		 * driver.navigate().back(); driver.findElement(By.linkText("Log out")).click();
		 */
		
		
	}

}
