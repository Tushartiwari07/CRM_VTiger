package com.tek.product;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.tek.crm.generic.baseutility.BaseClass;
import com.tek.crm.object_repository.HomePage;
import com.tek.crm.object_repository.ProductCreatedPage;
import com.tek.crm.object_repository.ProductInfoPage;
import com.tek.crm.object_repository.ProductPage;
@Listeners(com.tek.crm.genericutility.ListnerImplimentation.class)

public class ProductModule extends BaseClass {
	@Test
	public void productCreate() throws FileNotFoundException, IOException
	{
		//To read TestScript Data From Excel
		String productName = elib.getStringDataFromExcel("organization", 1, 7)+jlib.ramdonNumber();

		ProductPage proPage= new ProductPage(driver);
		ProductInfoPage proInfo = new ProductInfoPage(driver);
		ProductCreatedPage proCreated= new ProductCreatedPage(driver);
		hp= new HomePage(driver);

		hp.getProductsLink().click();
			proPage.getCreateProductIcon().click();
			proInfo.getProductNameTextFeild().sendKeys(productName);
			proInfo.getSaveBtn().click();			
			Assert.assertEquals(proCreated.getActualProductName().getText(),productName);
	}

	@Test
	public void productWithStartandEndDate() throws EncryptedDocumentException, IOException, ParseException
	{
		String productName = elib.getStringDataFromExcel("organization", 1, 7)+jlib.ramdonNumber();	
		ProductPage proPage= new ProductPage(driver);
		ProductInfoPage proInfo = new ProductInfoPage(driver);
		ProductCreatedPage proCreated= new ProductCreatedPage(driver);
		hp= new HomePage(driver);

		hp.getProductsLink().click();
			proPage.getCreateProductIcon().click();
			proInfo.getProductNameTextFeild().sendKeys(productName);
			proInfo.getSaleSartdate().sendKeys(jlib.getSystemDateyyyyMMdd());
			proInfo.getSalesEndSartdate().sendKeys(jlib.getRequiredDate(30));
			proInfo.getSaveBtn().click();
			//verify product
			Assert.assertEquals(proCreated.getActualProductName().getText(),productName);
			Assert.assertEquals(proCreated.getActualSalesStartDate().getText(),jlib.getSystemDateyyyyMMdd());
			Assert.assertEquals(proCreated.getActualSalesEndDate().getText(),jlib.getRequiredDate(30));
	}
}
