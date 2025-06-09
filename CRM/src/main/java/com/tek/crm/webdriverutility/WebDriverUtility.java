package com.tek.crm.webdriverutility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tek.javautility.JavaUtility;

public class WebDriverUtility {
	//=========Maximize Browser=============
	public void maximizeBrowser(WebDriver driver)
	{
		driver.manage().window().maximize();
	}

	//=========IMPLICITLY WAIT=============

	public void waitForWebPageToLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	//=========EXPLICITLY WAIT=============

	public void waitForElementToBeClickable(WebDriver driver, WebElement ele)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(ele));	
	}
	//=========SWITCH TO WINDOW===============

	public void switchToNewWindowWithURL(WebDriver driver,String url)
	{
		Set<String> allWindowIds = driver.getWindowHandles();
		for(String id:allWindowIds) 
		{
			String actUrl = driver.switchTo().window(id).getCurrentUrl();
			if (actUrl.contains(url)) {
				break;
			}
		}	
	}
	public void switchToNewWindowWithTittle(WebDriver driver,String tittle)
	{
		Set<String> allWindowIds = driver.getWindowHandles();
		for(String id:allWindowIds) 
		{
			String actTittle = driver.switchTo().window(id).getTitle();
			if (actTittle.contains(tittle)) {
				break;
			}
		}	
	}
	//=========SWITCH TO FRAME=============
	public void switchToFrameByNameOrID(WebDriver driver, String nameOrID)
	{
		driver.switchTo().frame(nameOrID);	
	}
	public void switchToFrameByIndex(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);	
	}
	public void switchToFrameByWebElement(WebDriver driver, WebElement ele)
	{
		driver.switchTo().frame(ele);	
	}
	//=========SWITCH TO ALERT=============
	public void switchToAlertAccept(WebDriver driver)
	{
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	public void switchToAlertDismiss(WebDriver driver)
	{
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}
	public String switchToAlertSendKeys(WebDriver driver)
	{
		Alert alert = driver.switchTo().alert();
		String alertMsg = alert.getText();
		return alertMsg;
	}
	//========= ACTIONS CLASS=============
	Actions act;
	public WebDriverUtility(WebDriver driver) {
		act= new Actions(driver);
	}
	public void rightClick(WebElement element) {
		act.contextClick(element).perform();
	}
	public void rightClick() {
		act.contextClick().perform();
	}
	public void doubleClick(WebElement element) {
		act.doubleClick(element).perform();
	}
	public void doubleClick() {
		act.doubleClick().perform();
	}
	
	public void clickAndHold(WebElement element) {
		act.clickAndHold(element).perform();
	}
	public void clickAndHold() {
		act.clickAndHold().perform();
	}
	
	public void moveToELement(WebElement element) {
		act.moveToElement(element).perform();
	}
	public void moveByOfSet(int x,int y)
	{
		act.moveByOffset(x, y).perform();
	}
	public void scrollToElement(WebElement element) {
		act.scrollToElement(element).perform();
	}
	public void scrollByAmoumt(int x,int y) {
		act.scrollByAmount(x,y).perform();
	}
	public void dragAndDrop(WebElement source,WebElement target) {
		act.dragAndDrop(source,target).perform();
	}
	
	//========= Select CLASS=============
	Select sel;
	public WebDriverUtility(WebElement element) {
		sel = new Select(element);
	}
	
	public void selectByIndex(int index)
	{
		sel.selectByIndex(index);
	}
	public void selectByValue(String value)
	{
		sel.selectByValue(value);
	}
	public void selectByVisibleText(String visibleText)
	{
		sel.selectByVisibleText(visibleText);
	}
	public void deSelectByIndex(int index)
	{
		sel.deselectByIndex(index);
	}
	public void deSelectByValue(String value)
	{
		sel.deselectByValue(value);
	}
	public void deSelectByVisibleText(String visibleText)
	{
		sel.deselectByVisibleText(visibleText);
	}
	public void deSelectAll()
	{
		sel.deselectAll();
	}
	public List<WebElement> getAllOptions()
	{
		List<WebElement> allOptions = sel.getOptions();
		return allOptions;
	}
	public WebElement getFirstSelected()
	{
		WebElement firstSelected = sel.getFirstSelectedOption();
		return firstSelected;
	}
	public List<WebElement> getAllSelected()
	{
		List<WebElement> allSelected = sel.getAllSelectedOptions();
		return allSelected;
	}
	public boolean isMultiple()
	{
	     return sel.isMultiple();
	}
	//========= SCREEENSHOT=============
	public void getScreenShot(WebDriver driver, String methodName) throws IOException
	{
		JavaUtility jlib = new JavaUtility();
		TakesScreenshot ts= (TakesScreenshot)driver;
		File tempFile = ts.getScreenshotAs(OutputType.FILE);
		File destFile = new File("./ScreenShots/"+methodName+jlib.getSystemTime()+".png");
		FileHandler.copy(tempFile, destFile);
		
	}
	public void getScreenShotOnWEBElement(WebElement element, String methodName) throws IOException
	{	
		JavaUtility jlib = new JavaUtility();
		File tempFile=element.getScreenshotAs(OutputType.FILE);
		File destFile = new File("./ScreenShots/"+methodName+jlib.getSystemTime()+".png");
		FileHandler.copy(tempFile, destFile);
		
	}




}
