package com.tek.contact;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.tek.crm.generic.baseutility.BaseClass;
import com.tek.crm.genericutility.UtilityClassObject;
import com.tek.crm.object_repository.ContactCreatedPage;
import com.tek.crm.object_repository.ContactInfoPage;
import com.tek.crm.object_repository.ContactPage;
import com.tek.crm.object_repository.HomePage;
import com.tek.crm.object_repository.OrganizationCreatedPage;
import com.tek.crm.object_repository.OrganizationPage;
import com.tek.crm.object_repository.OrganizationsInfoPage;

@Listeners(com.tek.crm.genericutility.ListnerImplimentation.class)
public class ContactModuleTest extends BaseClass {
	@Test(groups = "smokeTest", priority = 1)
	public void createContact() throws IOException, ParseException {
		UtilityClassObject.getTest().log(Status.INFO, " Login to the application");
		// To read TestScript Data From Excel
		String lastName = elib.getStringDataFromExcel("organization", 1, 5) + jlib.ramdonNumber();
		ContactPage cpage = new ContactPage(driver);
		ContactInfoPage cinfo = new ContactInfoPage(driver);
		ContactCreatedPage contCreated = new ContactCreatedPage(driver);
		hp = new HomePage(driver);
		// create contact
		hp.getContactsLink().click();
		UtilityClassObject.getTest().log(Status.INFO, "Navigated to the contacts page");
		cpage.getCreateContactIcon().click();
		cinfo.getLastNameTextField().sendKeys(lastName);
		cinfo.getSaveBtn().click();
		// verify
		// contact Created
		Assert.assertEquals(contCreated.getActualLastName().getText().trim(), lastName);
		UtilityClassObject.getTest().log(Status.INFO, "Contact created with: " + lastName);
	}
	@Test(groups = "regressionTest", priority = 2)
	public void createContactAndRelatedToOrg() throws IOException, ParseException {
		UtilityClassObject.getTest().log(Status.INFO, " Login to the application");
		String orgName = elib.getStringDataFromExcel("organization", 1, 1) + jlib.ramdonNumber();
		String lastName = elib.getStringDataFromExcel("organization", 1, 5) + jlib.ramdonNumber();
		String childWindowUrl = elib.getStringDataFromExcel("organization", 1, 8);
		OrganizationPage org = new OrganizationPage(driver);
		OrganizationsInfoPage orginfo = new OrganizationsInfoPage(driver);
		OrganizationCreatedPage orgCreated = new OrganizationCreatedPage(driver);
		ContactPage cpage = new ContactPage(driver);
		ContactInfoPage cinfo = new ContactInfoPage(driver);
		ContactCreatedPage contCreated = new ContactCreatedPage(driver);
		hp = new HomePage(driver);
		hp.getOrgainzationLink().click();
		UtilityClassObject.getTest().log(Status.INFO, "Navigated to the Organization page");
		org.getCreateOrgainzationIcon().click();
		orginfo.getOrganizationNameTextFiled().sendKeys(orgName);
		orginfo.getSaveBtn().click();
		// Verify OrgCreated
		Assert.assertEquals(orgCreated.getActualOrganizationName().getText(), orgName);
		UtilityClassObject.getTest().log(Status.INFO, "Organization created with: " + orgName);
		// Create contact and select orgainzation
		hp.getContactsLink().click();
		UtilityClassObject.getTest().log(Status.INFO, "Navigated to the contacts page");
		String parentId = driver.getWindowHandle();
		cpage.getCreateContactIcon().click();
		cinfo.getLastNameTextField().sendKeys(lastName);
		cinfo.getOrgNameIcon().click();
		// switchtochild window
		wlib.switchToNewWindowWithURL(driver, childWindowUrl);
		driver.findElement(By.id("search_txt")).sendKeys(orgName);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.linkText(orgName)).click();
		// Switch back to parent window
		driver.switchTo().window(parentId);
		cinfo.getSaveBtn().click();
		UtilityClassObject.getTest().log(Status.INFO, "Contact created with: " + lastName);
		// Verify org related
		sAssert.assertEquals(contCreated.getActualOrgRealted().getText().trim(), orgName);
		UtilityClassObject.getTest().log(Status.INFO, "Contact related with: " + orgName);
	}
	@Test(groups = "regressionTest", priority = 3)
	public void contactWithSupportDate() throws EncryptedDocumentException, IOException, ParseException {
		UtilityClassObject.getTest().log(Status.INFO, " Login to the application");
		String lastName = elib.getStringDataFromExcel("organization", 1, 5) + jlib.ramdonNumber();
		// Capture current and next date
		String startDate = jlib.getSystemDateyyyyMMdd();
		String endDate = jlib.getRequiredDate(30);
		ContactPage cpage = new ContactPage(driver);
		ContactInfoPage cinfo = new ContactInfoPage(driver);
		ContactCreatedPage contCreated = new ContactCreatedPage(driver);
		hp = new HomePage(driver);
		// crate contact
		hp.getContactsLink().click();
		UtilityClassObject.getTest().log(Status.INFO, "Navigated to the Contact page");
		cpage.getCreateContactIcon().click();
		cinfo.getLastNameTextField().sendKeys(lastName);
		// ADD SUPPORT DATE
		cinfo.getSupportStartDate().click();
		cinfo.getSupportStartDate().sendKeys(startDate);
		cinfo.getSupportEndDate().clear();
		cinfo.getSupportEndDate().sendKeys(endDate);
		// save Button
		cinfo.getSaveBtn().click();
		// verify contact created
		Assert.assertEquals(contCreated.getActualLastName().getText().trim(), lastName);
		UtilityClassObject.getTest().log(Status.INFO, "Contact created with: " + lastName);
		// Verify dates
		sAssert.assertEquals(contCreated.getAcutalStartdate().getText(), startDate);
		UtilityClassObject.getTest().log(Status.INFO, "Contact SupportStartDate: " + startDate);
		sAssert.assertEquals(contCreated.getAcutalEnddate().getText(), endDate);
		UtilityClassObject.getTest().log(Status.INFO, "Contact SupportEndDate: " + endDate);

	}
}
