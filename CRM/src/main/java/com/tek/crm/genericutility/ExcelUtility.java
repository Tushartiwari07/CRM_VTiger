package com.tek.crm.genericutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public String getStringDataFromExcel(String sheetName, int rowNum, int cellNum) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/TestDataCRM.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		String value = workbook.getSheet(sheetName).getRow(rowNum).getCell(cellNum).toString();
		return value;
	}
	
	public int getNumericDataFromExcel(String sheetName, int rowNum, int cellNum) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/TestDataCRM.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		 int value = (int)workbook.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getNumericCellValue();
		return value;
	}
	
	public int getRowPhysicalCount(String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/TestDataCRM.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		 int rowCount = workbook.getSheet(sheetName).getPhysicalNumberOfRows();
		return rowCount;
	}
	public int getCellPhysicalCount(String sheetName ,int rowNum) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/TestDataCRM.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		 int rowCount = workbook.getSheet(sheetName).getRow(rowNum).getPhysicalNumberOfCells();
		return rowCount;
	}
	
	public void setDataIntoExcel(String sheetName,int rowNum, int cellNum,String data) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/TestDataCRM.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		workbook.getSheet(sheetName).getRow(rowNum).createCell(cellNum).setCellValue(data);
		
		FileOutputStream fos = new FileOutputStream("./src/test/resources/TestDataCRM.xlsx");
		workbook.write(fos);
		workbook.close();
	}
	
	public boolean getBooleanDataFromExcel(String sheetName, int rowNum, int cellNum) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/TestDataCRM.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		 boolean value = workbook.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getBooleanCellValue();
		return value;
	}
	
	

}
