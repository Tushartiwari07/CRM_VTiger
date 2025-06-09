package com.tek.crm.object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunityInfoPage {
	public OpportunityInfoPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	@FindBy(name = "potentialname")
	private WebElement opportunityNameTextfield;
	@FindBy(id = "related_to_type")
	private WebElement relatedDropDown;
	@FindBy(xpath = "(//img[@src=\"themes/softed/images/select.gif\"])[1]")
	private  WebElement relateIcon;
	@FindBy(name = "opportunity_type")
	private WebElement oppTypeDropDown;
	@FindBy(name = "leadsource")
	private WebElement leadSourceDropDown;
	@FindBy(xpath = "(//img[@src=\"themes/softed/images/select.gif\"])[2]")
	private WebElement campaingnSource;
	@FindBy(xpath = "//input[@title=\"Save [Alt+S]\"]")
	private WebElement saveBtn;
	@FindBy(name = "closingdate")
	private WebElement clodeDate;
	public WebElement getOpportunityNameTextfield() {
		return opportunityNameTextfield;
	}
	public WebElement getRelatedDropDown() {
		return relatedDropDown;
	}
	public WebElement getRelateIcon() {
		return relateIcon;
	}
	public WebElement getOppTypeDropDown() {
		return oppTypeDropDown;
	}
	public WebElement getLeadSourceDropDown() {
		return leadSourceDropDown;
	}
	public WebElement getCampaingnSource() {
		return campaingnSource;
	}
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	public WebElement getClodeDate() {
		return clodeDate;
	}
	

}
