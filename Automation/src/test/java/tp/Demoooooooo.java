package tp;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Demoooooooo {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {FileInputStream fis = new FileInputStream("./src/test/resources/TestCase.xlsm");
	Workbook workbook = WorkbookFactory.create(fis);
	Sheet sh = workbook.getSheet("Flipkart");
	Row row = sh.getRow(1);
	Cell cel = row.createCell(5);
	cel.setCellType(CellType.STRING);
	cel.setCellValue("Browser lunched successfully");
	sh.getRow(2).createCell(5).setCellValue("Window Maximized successfully");
	
	FileOutputStream fos= new FileOutputStream("./src/test/resources/TestCase.xlsm");
	workbook.write(fos);
	workbook.close();}

}
