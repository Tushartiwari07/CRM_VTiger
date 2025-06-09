package com.tek.crm.generic.baseutility;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;
import com.tek.crm.genericutility.ExcelUtility;
import com.tek.crm.genericutility.JsonUtility;
import com.tek.crm.genericutility.UtilityClassObject;
import com.tek.crm.object_repository.ContactCreatedPage;
import com.tek.crm.object_repository.ContactInfoPage;
import com.tek.crm.object_repository.ContactPage;
import com.tek.crm.object_repository.HomePage;
import com.tek.crm.object_repository.LoginPage;
import com.tek.crm.object_repository.OrganizationCreatedPage;
import com.tek.crm.object_repository.OrganizationPage;
import com.tek.crm.object_repository.OrganizationsInfoPage;
import com.tek.crm.webdriverutility.WebDriverUtility;
import com.tek.javautility.JavaUtility;

/**
 * @author Tushar 
 * Contains all the configuration annotations with Pre and Post
 *         conditions
 */
@Listeners(com.tek.crm.genericutility.ListnerImplimentation.class)
public class BaseClass {
	public WebDriver driver = null;
	public JsonUtility jsonlib = new JsonUtility();
	public JavaUtility jlib = new JavaUtility();
	public ExcelUtility elib = new ExcelUtility();
	public SoftAssert sAssert = new SoftAssert();
	public WebDriverUtility wlib;
	public LoginPage lp;
	public HomePage hp;
	public OrganizationPage org;
	public OrganizationsInfoPage orginfo;
	public OrganizationCreatedPage orgCreated;
	public ContactPage cpage;
	public ContactInfoPage cinfo;
	public ContactCreatedPage contCreated;

	@BeforeSuite(groups = { "smokeTest", "regressionTest" })
	public void dataBaseConnection() {
		System.out.println("DataBase Connected");
	}

	@Parameters("Browser")
	@BeforeClass(groups = { "smokeTest", "regressionTest" })
	public void lunchBrowser(@Optional("chrome") String xmlBrowser) throws Exception {
//		String browser = jsonlib.getDataFromJson("Browser");
		String url = jsonlib.getDataFromJson("Url");

		String browser = xmlBrowser;
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}
		UtilityClassObject.setDriver(driver);
		wlib = new WebDriverUtility(driver);
		wlib.maximizeBrowser(driver);
		driver.get(url);
		wlib.waitForWebPageToLoad(driver);
	}

	@BeforeMethod(groups = { "smokeTest", "regressionTest" })
	public void login() throws FileNotFoundException, IOException, ParseException {
		String username = jsonlib.getDataFromJson("Username");
		String password = jsonlib.getDataFromJson("Password");
		lp = new LoginPage(driver);
		lp.login(username, password);
	}

	@AfterMethod(groups = { "smokeTest", "regressionTest" })
	public void logOut() {
		sAssert.assertAll();
		hp = new HomePage(driver);
		hp.logOut();
	}

	@AfterClass(groups = { "smokeTest", "regressionTest" })
	public void closeBrowser() {
		driver.quit();
	}

	@AfterSuite(groups = { "smokeTest", "regressionTest" })
	public void closeDataBaseConnection() {
		System.out.println("DataBase Closed");
	}

}
