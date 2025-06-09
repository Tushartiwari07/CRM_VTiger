package com.tek.opportunities;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.tek.crm.generic.baseutility.BaseClass;
import com.tek.crm.object_repository.ContactCreatedPage;
import com.tek.crm.object_repository.ContactInfoPage;
import com.tek.crm.object_repository.ContactPage;
import com.tek.crm.object_repository.HomePage;
import com.tek.crm.object_repository.OpportunityCreatedPage;
import com.tek.crm.object_repository.OpportunityInfoPage;
import com.tek.crm.object_repository.OpportunityPage;
import com.tek.crm.object_repository.OrganizationCreatedPage;
import com.tek.crm.object_repository.OrganizationPage;
import com.tek.crm.object_repository.OrganizationsInfoPage;
import com.tek.crm.webdriverutility.WebDriverUtility;

@Listeners(com.tek.crm.genericutility.ListnerImplimentation.class)

public class OpportunitiesModule extends BaseClass {
	@Test(priority = 1)
	public void createopportunitiesAndRelateToContact() throws FileNotFoundException, IOException, ParseException, InterruptedException
	{		
				//To read TestScript Data From Excel
				String lastName = elib.getStringDataFromExcel("organization", 1, 5)+jlib.ramdonNumber();
				String oppName = elib.getStringDataFromExcel("organization", 1, 6)+jlib.ramdonNumber();
				
				OpportunityPage oppPage= new OpportunityPage(driver);
				OpportunityInfoPage oppInfo = new OpportunityInfoPage(driver);
				OpportunityCreatedPage oppCreated = new OpportunityCreatedPage(driver);
				ContactPage cpage= new ContactPage(driver);
				ContactInfoPage cinfo= new ContactInfoPage(driver);
				ContactCreatedPage contCreated= new ContactCreatedPage(driver);
				hp= new HomePage(driver);
				hp.getContactsLink().click();
				cpage.getCreateContactIcon().click();
				cinfo.getLastNameTextField().sendKeys(lastName);
				cinfo.getSaveBtn().click();
				//verify
				Assert.assertEquals(contCreated.getActualLastName().getText().trim(),lastName);
					hp.getOpportunitiesLink().click();
					oppPage.getCreateOpportunityIcon().click();
					oppInfo.getOpportunityNameTextfield().sendKeys(oppName);
					String parentId= driver.getWindowHandle();
					wlib= new WebDriverUtility(oppInfo.getRelatedDropDown());
					wlib.selectByValue("Contacts");
					oppInfo.getRelateIcon().click();
					wlib.switchToNewWindowWithURL(driver,"http://localhost:8888/index.php?module=Contacts&action=Popup&html=Popup_picker&");
					
					driver.findElement(By.id("search_txt")).sendKeys(lastName,Keys.ENTER);
					driver.findElement(By.linkText(lastName)).click();
					driver.switchTo().window(parentId);
					oppInfo.getSaveBtn().click();
					//verify
					sAssert.assertEquals(oppCreated.getActualContactRelated().getText().trim(),lastName);

	}

	@Test(priority = 2)
	public void opportunitiesAndRelateOrg() throws FileNotFoundException, IOException, ParseException, InterruptedException
	{
		String orgName = elib.getStringDataFromExcel("organization", 1, 1)+jlib.ramdonNumber();
		String oppName = elib.getStringDataFromExcel("organization", 1, 6)+jlib.ramdonNumber();

		OrganizationPage org= new OrganizationPage(driver);
		OrganizationsInfoPage orginfo= new OrganizationsInfoPage(driver);
		OrganizationCreatedPage orgCreated= new OrganizationCreatedPage(driver);
		OpportunityPage oppPage= new OpportunityPage(driver);
		OpportunityInfoPage oppInfo = new OpportunityInfoPage(driver);
		OpportunityCreatedPage oppCreated = new OpportunityCreatedPage(driver);
		hp= new HomePage(driver);

	
			//Create org
		hp.getOrgainzationLink().click();
		org.getCreateOrgainzationIcon().click();
		orginfo.getOrganizationNameTextFiled().sendKeys(orgName);
		orginfo.getSaveBtn().click();

			//Validate org created
		Assert.assertEquals(orgCreated.getActualOrganizationName().getText(),orgName);
		//Create Opportunities
		hp.getOpportunitiesLink().click();
		oppPage.getCreateOpportunityIcon().click();
			String parentId= driver.getWindowHandle();
				Thread.sleep(2000);
				oppInfo.getOpportunityNameTextfield().sendKeys(oppName);
				oppInfo.getRelateIcon().click();
//				Switchto Window And Relate
				wlib.switchToNewWindowWithURL(driver, "http://localhost:8888/index.php?module=Accounts&action=Popup");
			driver.findElement(By.id("search_txt")).sendKeys(orgName);
			driver.findElement(By.name("search")).click();
			driver.findElement(By.linkText(orgName)).click();
			
			driver.switchTo().window(parentId);
			oppInfo.getSaveBtn().click();
//			Verify  org related
			sAssert.assertEquals(oppCreated.getActualOrgRelatedName().getText(),orgName);
	}


}
