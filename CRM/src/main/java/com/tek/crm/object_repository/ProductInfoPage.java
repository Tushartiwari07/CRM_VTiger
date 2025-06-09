package com.tek.crm.object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInfoPage {
	public ProductInfoPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	@FindBy(name = "productname")
	private WebElement productNameTextFeild;
	@FindBy(name = "sales_start_date")
	private WebElement saleSartdate;
	@FindBy(name = "sales_end_date")
	private WebElement endSartdate;
	@FindBy(name = "productcategory")
	private WebElement productCategory;
	@FindBy(xpath = "//img[@title='Select']")
	private WebElement venderNameIcon;
	@FindBy(name = "start_date")
	private WebElement supportStartDate;
	@FindBy(name = "expiry_date")
	private WebElement supportEndDate;
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	public WebElement getProductNameTextFeild() {
		return productNameTextFeild;
	}
	public WebElement getSaleSartdate() {
		return saleSartdate;
	}
	public WebElement getSalesEndSartdate() {
		return endSartdate;
	}
	public WebElement getProductCategory() {
		return productCategory;
	}
	public WebElement getVenderNameIcon() {
		return venderNameIcon;
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
	

}
