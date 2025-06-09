package com.tek.crm.object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductCreatedPage {
	public ProductCreatedPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	@FindBy(id = "dtlview_Product Name")
	private WebElement actualProductName;
	@FindBy(id = "dtlview_Sales Start Date")
	private WebElement actualSalesStartDate;
	public WebElement getActualProductName() {
		return actualProductName;
	}
	public WebElement getActualSalesStartDate() {
		return actualSalesStartDate;
	}
	public WebElement getActualSalesEndDate() {
		return actualSalesEndDate;
	}
	public WebElement getActualSupportStartDate() {
		return actualSupportStartDate;
	}
	public WebElement getActualSupportEndDate() {
		return actualSupportEndDate;
	}
	public WebElement getEditBtn() {
		return editBtn;
	}
	public WebElement getDeleteBtn() {
		return deleteBtn;
	}
	@FindBy(id = "dtlview_Sales End Date")
	private WebElement actualSalesEndDate;
	@FindBy(id = "mouseArea_Support Start Date")
	private WebElement actualSupportStartDate;
	@FindBy(id = "mouseArea_Support Expiry Date")
	private WebElement actualSupportEndDate;
	@FindBy(xpath = "//input[@title='Edit [Alt+E]']")
	private WebElement editBtn;
	@FindBy(xpath = "//input[@title='Delete [Alt+D]']")
	private WebElement deleteBtn;
	

}
