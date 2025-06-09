package com.tek.crm.object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	public ProductPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath = "//img[@title='Create Product...']")
	private WebElement createProductIcon;
	@FindBy(xpath = "//input[@name='search_text']")
	private WebElement productSearchTextField;
	@FindBy(id = "bas_searchfield")
	private WebElement productInfoSelectDropDown;
	@FindBy(name = "submit")
	private WebElement productSearchBtn;
	public WebElement getCreateProductIcon() {
		return createProductIcon;
	}
	public WebElement getProductSearchTextField() {
		return productSearchTextField;
	}
	public WebElement getProductInfoSelectDropDown() {
		return productInfoSelectDropDown;
	}
	public WebElement getProductSearchBtn() {
		return productSearchBtn;
	}
	
	

}
