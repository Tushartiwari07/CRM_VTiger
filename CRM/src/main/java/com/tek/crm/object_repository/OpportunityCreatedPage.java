package com.tek.crm.object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunityCreatedPage {
	public OpportunityCreatedPage(WebDriver drive) {
		PageFactory.initElements(drive,this);
	}
	@FindBy(id = "dtlview_Opportunity Name")
	private WebElement actualOpportunityName;
	
	@FindBy(xpath ="//a[@title='Organizations']")
	private WebElement actualOrgRelatedName;
	
	@FindBy(xpath = "//a[@title='Contacts']")
	private WebElement actualContactRelated;
	
	public WebElement getActualOrgRelatedName() {
		return actualOrgRelatedName;
	}

	public WebElement getActualContactRelated() {
		return actualContactRelated;
	}
	@FindBy(id = "dtlview_Type")
	private WebElement actualType;
	@FindBy(id = "mouseArea_Lead Source")
	private WebElement actualLeadSource;
	public WebElement getActualOpportunityName() {
		return actualOpportunityName;
	}
	
	public WebElement getActualType() {
		return actualType;
	}
	public WebElement getActualLeadSource() {
		return actualLeadSource;
	}
	public WebElement getEditBtn() {
		return editBtn;
	}
	public WebElement getDeleteBtn() {
		return deleteBtn;
	}
	@FindBy(xpath = "//input[@title='Edit [Alt+E]']")
	private WebElement editBtn;
	@FindBy(xpath = "//input[@title='Delete [Alt+D]']")
	private WebElement deleteBtn;

}