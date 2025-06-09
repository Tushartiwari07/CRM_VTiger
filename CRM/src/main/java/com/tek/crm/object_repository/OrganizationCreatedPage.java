package com.tek.crm.object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationCreatedPage {
	public OrganizationCreatedPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	@FindBy(id = "dtlview_Organization Name")
	private WebElement actualOrganizationName;
	@FindBy(xpath = "dtlview_Industry")
	private WebElement actualIndustryName;
	@FindBy(id = "mouseArea_Type")
	private WebElement actualTypeName;
	public WebElement getActualTypeName() {
		return actualTypeName;
	}
	@FindBy(id = "dtlview_Phone")
	private WebElement actualPhoneNumber;
	@FindBy(xpath = "//input[@title='Edit [Alt+E]']")
	private WebElement editBtn;
	@FindBy(name = "Delete")
	private WebElement deleteBtn;
	public WebElement getActualOrganizationName() {
		return actualOrganizationName;
	}
	public WebElement getActualIndustryName() {
		return actualIndustryName;
	}
	public WebElement getActualPhoneNumber() {
		return actualPhoneNumber;
	}
	public WebElement getEditBtn() {
		return editBtn;
	}
	public WebElement getDeleteBtn() {
		return deleteBtn;
	}
	

}
