package com.tek.organization;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.tek.crm.generic.baseutility.BaseClass;
import com.tek.crm.genericutility.UtilityClassObject;
import com.tek.crm.object_repository.HomePage;
import com.tek.crm.object_repository.OrganizationCreatedPage;
import com.tek.crm.object_repository.OrganizationPage;
import com.tek.crm.object_repository.OrganizationsInfoPage;
import com.tek.crm.webdriverutility.WebDriverUtility;
@Listeners(com.tek.crm.genericutility.ListnerImplimentation.class)

public class OrgainzationModuleTest extends BaseClass {
	@Test(groups = "smokeTest", priority = 1)
	public void createOrgainzation() throws Throwable
	{
		String orgName=elib.getStringDataFromExcel("organization", 1, 1)+ jlib.ramdonNumber();
		OrganizationPage org= new OrganizationPage(driver);
		OrganizationsInfoPage orginfo= new OrganizationsInfoPage(driver);
		OrganizationCreatedPage orgCreated= new OrganizationCreatedPage(driver);
		//Create org
		hp= new HomePage(driver);
		hp.getOrgainzationLink().click();
		org.getCreateOrgainzationIcon().click();
		orginfo.getOrganizationNameTextFiled().sendKeys(orgName);
		orginfo.getSaveBtn().click();

        //Verify Org Created
		Assert.assertEquals(orgCreated.getActualOrganizationName().getText(),orgName);
		UtilityClassObject.getTest().log(Status.PASS," Orgnization Created : "+orgName);
	}

	@Test(groups = "regressionTest",priority = 2)
	public void orgWithNumber() throws FileNotFoundException, IOException, ParseException {
		String orgName = elib.getStringDataFromExcel("organization", 1, 1) + jlib.ramdonNumber();
		String number = elib.getStringDataFromExcel("organization", 1, 4) + jlib.ramdonNumber();

		OrganizationPage org = new OrganizationPage(driver);
		OrganizationsInfoPage orginfo = new OrganizationsInfoPage(driver);
		OrganizationCreatedPage orgCreated = new OrganizationCreatedPage(driver);
		hp=new HomePage(driver);

		hp.getOrgainzationLink().click();
		org.getCreateOrgainzationIcon().click();
		orginfo.getOrganizationNameTextFiled().sendKeys(orgName);
		
		// Enter mobile number
		orginfo.getPhoneNumberTextField().sendKeys(number);
		orginfo.getSaveBtn().click();
		Assert.assertEquals(orgCreated.getActualPhoneNumber().getText().trim(),number);
		UtilityClassObject.getTest().log(Status.PASS," Orgnization Created with mobile number: "+number);


	}
	@Test(groups = "regressionTest", priority = 3)

	public void createOrgWithIndustryAndTypee() throws FileNotFoundException, IOException, ParseException, InterruptedException
	{
		String orgName=elib.getStringDataFromExcel("organization", 1, 1)+jlib.ramdonNumber();	
		String industry =elib.getStringDataFromExcel("organization", 1, 2);
		String type =elib.getStringDataFromExcel("organization", 1, 3);

		OrganizationPage org= new OrganizationPage(driver);
		OrganizationsInfoPage orginfo= new OrganizationsInfoPage(driver);
		OrganizationCreatedPage orgCreated= new OrganizationCreatedPage(driver);
		hp= new HomePage(driver);

		hp.getOrgainzationLink().click();
    	org.getCreateOrgainzationIcon().click();
		orginfo.getOrganizationNameTextFiled().sendKeys(orgName);

			wlib = new WebDriverUtility(orginfo.getIndustryDropDown());
			wlib.selectByValue(industry);
			wlib = new WebDriverUtility(orginfo.getTypeDropDown());
			wlib.selectByValue(type);
			orginfo.getSaveBtn().click();					
//			Verify industry and type
//			sAssert.assertEquals(orgCreated.getActualIndustryName().getText(),industry);
			String actualIndustryName = driver.findElement(By.id("dtlview_Industry")).getText();
			sAssert.assertEquals(actualIndustryName, industry);		
			UtilityClassObject.getTest().log(Status.PASS,"Industry selected : "+industry);

			sAssert.assertEquals(orgCreated.getActualTypeName().getText(),type);
			UtilityClassObject.getTest().log(Status.PASS,"Type Selected : "+type);

	}
}
