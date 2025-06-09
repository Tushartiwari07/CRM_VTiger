package com.tek.crm.object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.bytebuddy.asm.MemberSubstitution.FieldValue;

public class OrganizationPage{
 public OrganizationPage(WebDriver driver) {
	 PageFactory.initElements(driver,this);

}	
 @FindBy(xpath = "//img[@title='Create Organization...']")
	private WebElement createOrgainzationIcon;
	@FindBy(xpath = "//input[@name='search_text']")
	private WebElement orgSearchTextField;
	@FindBy(id = "bas_searchfield")
	private WebElement orgInfoSelectDropDown;
	@FindBy(name = "submit")
	private WebElement searchBtn;
	@FindBy(name = "selectall")
	private WebElement selectAllCheckBox;
	@FindBy(xpath = "//a[@title='Next']")
	private WebElement nextPageIcon;
	@FindBy(xpath = "//img[@src=\"themes/images/previous_disabled.gif\"]")
	private WebElement previousPageIcon;
	@FindBy(xpath = "//input[@value='Delete']")
	private WebElement deleteIcon;
	
	public WebElement getSelectAllCheckBox() {
		return selectAllCheckBox;
	}
	public WebElement getNextPageIcon() {
		return nextPageIcon;
	}
	public WebElement getPreviousPageIcon() {
		return previousPageIcon;
	}
	public WebElement getDeleteIcon() {
		return deleteIcon;
	}
	public WebElement getCreateOrgainzationIcon() {	
	return createOrgainzationIcon;
}
public WebElement getOrgSearchTextField() {
	return orgSearchTextField;
}	
public WebElement getOrgInfoSelectDropDown() {
	return orgInfoSelectDropDown;
}
public WebElement getSearchBtn() {
	return searchBtn;
}
	
	
	

}
