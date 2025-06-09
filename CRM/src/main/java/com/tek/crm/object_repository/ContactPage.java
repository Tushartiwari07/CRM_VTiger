package com.tek.crm.object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
	public ContactPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath = "//img[@title='Create Contact...']")
	private WebElement createContactIcon;
	@FindBy(name = "search_text")
	private WebElement searchTextField;
	@FindBy(id = "bas_searchfield")
	private WebElement searchselectDropDown;
	@FindBy(name = "submit")
	private WebElement searchBtn;
	public WebElement getCreateContactIcon() {
		return createContactIcon;
	}
	public WebElement getSearchTextField() {
		return searchTextField;
	}
	public WebElement getSearchselectDropDown() {
		return searchselectDropDown;
	}
	public WebElement getSearchBtn() {
		return searchBtn;
	}
}
