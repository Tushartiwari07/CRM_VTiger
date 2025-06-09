package demo;
import static org.junit.Assert.fail;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(demo.ImplimentationConfig.class)
public class ConfigAnnotationAndListnerInterfaceMethodsFlow {
	
	@BeforeSuite
	public void beforeSuite()
	{
		System.out.println("=========BEFORE SUITE==========");
	}
	@BeforeTest
	public void beforeTest()
	{
		System.out.println("=========BEFORE TEST==========");
	}
	@BeforeClass
	public void beforeClass()
	{
		System.out.println("=========BEFORE CLASS==========");
	}
	@BeforeMethod
	public void beforeMethod()
	{
		System.out.println("=========BEFORE Method==========");
	}
	@AfterMethod
	public void AfterMethod()
	{
		System.out.println("=========AFTER Method==========");
	}
	@AfterClass
	public void afterClass()
	{
		System.out.println("=========AFTER CLASS==========");
	}
	@AfterTest
	public void afterTest()
	{
		System.out.println("=========AFTER TEST==========");
	}
	@AfterSuite
	public void AfterSuite()
	{
		System.out.println("=========AFTER SUITE==========");
	}
	@Test
	public void test1()
	{
		System.out.println("=========Test1===========");
	}
	@Test
	public void test2()
	{
		fail();
		System.out.println("=========Test2===========");
	}
	@Test(dependsOnMethods = "test2" )
	public void test3()
	{
		System.out.println("=========Test3===========");
	}
	@Test
	public void test4()
	{
		System.out.println("=========Test4===========");
	}
	
}
