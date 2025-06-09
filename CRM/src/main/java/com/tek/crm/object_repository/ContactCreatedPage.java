package com.tek.crm.object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactCreatedPage {
	public ContactCreatedPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(id = "dtlview_Last Name")
	private WebElement actualLastName;
	@FindBy(id = "mouseArea_Organization Name")
	private WebElement actualOrgRealted;
	@FindBy(id = "dtlview_Support Start Date")
	private WebElement acutalStartdate;
	@FindBy(id = "dtlview_Support End Date")
	private WebElement acutalEnddate;
	@FindBy(name = "Edit")
	private WebElement editBtn;
	@FindBy(name = "Delete")
	private WebElement deleteBtn;
	public WebElement getActualLastName() {
		return actualLastName;
	}
	public WebElement getActualOrgRealted() {
		return actualOrgRealted;
	}
	public WebElement getAcutalStartdate() {
		return acutalStartdate;
	}
	public WebElement getAcutalEnddate() {
		return acutalEnddate;
	}
	public WebElement getEditBtn() {
		return editBtn;
	}
	public WebElement getDeleteBtn() {
		return deleteBtn;
	}
	

}
