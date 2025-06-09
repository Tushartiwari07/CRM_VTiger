package com.tek.crm.object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunityPage {
	public OpportunityPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath = "//img[@title='Create Opportunity...']")
	private WebElement createOpportunityIcon;
	@FindBy(xpath = "//input[@name='search_text']")
	private WebElement oppSearchTextField;
	@FindBy(id = "bas_searchfield")
	private WebElement oppInfoSelectDropDown;
	@FindBy(name = "submit")
	private WebElement oppsearchBtn;
	public WebElement getCreateOpportunityIcon() {
		return createOpportunityIcon;
	}
	public WebElement getOppSearchTextField() {
		return oppSearchTextField;
	}
	public WebElement getOppInfoSelectDropDown() {
		return oppInfoSelectDropDown;
	}
	public WebElement getOppsearchBtn() {
		return oppsearchBtn;
	}
	
	

}
