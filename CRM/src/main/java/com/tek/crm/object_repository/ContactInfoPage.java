package com.tek.crm.object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {
	public ContactInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public WebElement getLastNameTextField() {
		return lastNameTextField;
	}
	public WebElement getFirstnameTextField() {
		return firstnameTextField;
	}
	public WebElement getOrgNameIcon() {
		return orgNameIcon;
	}
	public WebElement getSupportStartDate() {
		return supportStartDate;
	}
	public WebElement getSupportEndDate() {
		return supportEndDate;
	}
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	public WebElement getCancelBtn() {
		return cancelBtn;
	}
	@FindBy(name = "lastname")
	private WebElement lastNameTextField;
	@FindBy(name = "firstname")
	private WebElement firstnameTextField;
	@FindBy(xpath = "(//img[@title='Select'])[1]")
	private WebElement orgNameIcon;
	@FindBy(name = "support_start_date")
	private WebElement supportStartDate;
	@FindBy(name = "support_end_date")
	private WebElement supportEndDate;
	@FindBy(xpath = "(//input[@title=\"Save [Alt+S]\"])[1]")
	private WebElement saveBtn;
	@FindBy(xpath = "(//input[@title='Cancel [Alt+X]'])[1]")
	private WebElement cancelBtn;



}
