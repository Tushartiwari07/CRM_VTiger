package demo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FilpkartWriteBackToExcel {
	@Test
	public void readBackDataToExcel() throws EncryptedDocumentException, IOException
	{
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	
	driver.get("https://www.flipkart.com/");
	driver.findElement(By.xpath("//img[@alt='Fashion']")).click();
	driver.findElement(By.linkText("Men's T-Shirts")).click();
	WebElement mens = driver.findElement(By.xpath("//span[text()='Men']"));
	mens.click();
	List<WebElement> mensOption = driver.findElements(By.xpath("(//div[@class='wZsanD'])[2]/a"));
	int rownum=1;
	
	for(WebElement ele:mensOption)
	{
		    String text = ele.getText();
		    System.out.println(text);
			FileInputStream fis = new FileInputStream("./src/test/resources/TestDataCRM.xlsx");
			Workbook workbook = WorkbookFactory.create(fis);
			Sheet sh = workbook.getSheet("Flipkart");
			for(int i=1;i<=mensOption.size();i++) {
			 Row row = sh.createRow(rownum);
			 row.createCell(0).setCellValue(text); 
			FileOutputStream fos= new FileOutputStream("./src/test/resources/TestDataCRM.xlsx");
			workbook.write(fos);
			break;
			}
			rownum++;
		}
	
	driver.close();
	
	}
}
