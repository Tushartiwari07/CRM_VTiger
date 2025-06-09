package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class WriteDataBackToExcel {
	@Test
	public void storeDataInExcelThroughSelenium() throws IOException
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/TestDataCRM.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sh = workbook.getSheet("Sheet1");
		Row row = sh.getRow(1);
		Cell cel = row.createCell(5);
		cel.setCellType(CellType.STRING);
		cel.setCellValue("Browser lunched successfully");
		sh.getRow(2).createCell(5).setCellValue("Window Maximized successfully");
		
		FileOutputStream fos= new FileOutputStream("./src/test/resources/TestCase.xlsm");
		workbook.write(fos);
		workbook.close();
		
	}

}
