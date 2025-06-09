package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class ExcelPracticeTest {
	@Test
	public void workingWithExcel() throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/TestDataCRM.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Flipkart");
		int rowCount = sheet.getPhysicalNumberOfRows();
		System.out.println("row count : "+rowCount);
		System.out.println("Last row Number : "+sheet.getLastRowNum());
		Row row = sheet.getRow(0);
		int cellCount = row.getPhysicalNumberOfCells();
		System.out.println("Cell count : "+cellCount);
		System.out.println("Last Cell Number : "+row.getLastCellNum());
		
	}

}
