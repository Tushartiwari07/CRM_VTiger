package com.tek.crm.genericutility;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderUtility {
	@DataProvider
	public Object[][] getDataFromDataProvider() throws EncryptedDocumentException, IOException
	{
		ExcelUtility elib= new ExcelUtility();
		int rowcount = elib.getRowPhysicalCount("ProductPrice");
		int cellcount=elib.getCellPhysicalCount("ProductPrice", 1);
		Object[][] objarr= new Object[cellcount][rowcount];
		for(int i=1;i<=rowcount;i++)
		{
			for(int j=0;j<=cellcount;j++)
			{
				objarr[i][j]=elib.getStringDataFromExcel("ProductPrice", i, j);
			}	
		}
		return objarr;	
	}
	@Test(dataProvider = "getDataFromDataProvider")
	public void getData(String brandName,String ModuleName, String price,String Url) throws EncryptedDocumentException, IOException
	{		
		System.out.println(brandName);
		System.out.println(ModuleName);
		System.out.println(price);
		System.out.println(Url);	
	}
}
