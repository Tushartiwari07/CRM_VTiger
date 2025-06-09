package com.tek.crm.object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	@FindBy(linkText = "Organizations")
	private WebElement orgainzationLink;
	@FindBy(linkText = "Contacts")
	private WebElement contactsLink;
	@FindBy(linkText = "Opportunities")
	private WebElement opportunitiesLink;
	@FindBy(linkText = "Products")
	private WebElement productsLink;
	@FindBy(linkText = "More")
	private WebElement moreLink;
	@FindBy(linkText = "Documents")
	private WebElement documentsLink;
	@FindBy(linkText = "Email")
	private WebElement emailLink;
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorlogo;
	@FindBy(linkText = "Sign Out")
	private WebElement signOutLink;
	
	
	public WebElement getOrgainzationLink() {
		return orgainzationLink;
	}
	public WebElement getContactsLink() {
		return contactsLink;
	}
	public WebElement getOpportunitiesLink() {
		return opportunitiesLink;
	}
	public WebElement getProductsLink() {
		return productsLink;
	}
	public WebElement getMoreLink() {
		return moreLink;
	}
	public WebElement getDocumentsLink() {
		return documentsLink;
	}
	public WebElement getEmailLink() {
		return emailLink;
	}
	public WebElement getAdministratorlogo() {
		return administratorlogo;
	}
	public WebElement getSignOutLink() {
		return signOutLink;
	}
	public void logOut()
	{
		administratorlogo.click();
		signOutLink.click();
	}

}
