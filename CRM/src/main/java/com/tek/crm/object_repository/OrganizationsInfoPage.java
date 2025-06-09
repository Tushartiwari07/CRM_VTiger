package com.tek.crm.object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsInfoPage {
	public OrganizationsInfoPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	public WebElement getOrganizationNameTextFiled() {
		return organizationNameTextFiled;
	}
	public WebElement getIndustryDropDown() {
		return industryDropDown;
	}
	public WebElement getTypeDropDown() {
		return typeDropDown;
	}
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	public WebElement getPhoneNumberTextField() {
		return phoneNumberTextField;
	}
	@FindBy(name = "accountname")
	private WebElement organizationNameTextFiled;
	@FindBy(name = "industry")
	private WebElement industryDropDown;
	@FindBy(name = "accounttype")
	private WebElement typeDropDown;
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	@FindBy(id = "phone")
	private WebElement phoneNumberTextField;
	

}
