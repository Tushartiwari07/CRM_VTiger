package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class ReadMultipleDataFromExcel {
	@Test
	public void fetchMultipleData1() throws IOException
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/TestDataCRM.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sh = workbook.getSheet("Sheet1");
		int cellCount= sh.getRow(0).getPhysicalNumberOfCells();
		int rowCount=sh.getPhysicalNumberOfRows();
		String str[][]=new String[(rowCount-1)][cellCount];
		System.out.println(rowCount+" "+cellCount);
		
		for(int i=0;i<(rowCount-1);i++)
		{
			for (int j=0;j<cellCount;j++)
			{
				try {
					str[i][j]=sh.getRow((i+1)).getCell(j).toString();
				} catch (Exception e) {
					str[i][j]="NULL";
				}
			}
		}
		for(int i=0;i<(rowCount-1);i++)
		{
			for (int j=0;j<cellCount;j++)
			{
				System.out.print(str[i][j] +" ");
			}
			System.out.println();
		}
		
		}
		
	}
