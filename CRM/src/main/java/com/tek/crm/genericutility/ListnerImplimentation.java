package com.tek.crm.genericutility;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.tek.javautility.JavaUtility;
public class ListnerImplimentation implements ITestListener,ISuiteListener
{
	public ExtentSparkReporter spark;
	public ExtentReports reports;
	public ExtentTest test;
	@Override
	public void onStart(ISuite suite) {
		JavaUtility jlib= new JavaUtility();
		spark= new ExtentSparkReporter("./AdvanceReportsCrm/ExtentsReports"+jlib.getSystemTime()+".html");
		spark.config().setDocumentTitle("CRM Test suite Results");
		spark.config().setReportName("CRM reports");
		spark.config().setTheme(Theme.STANDARD);
		reports= new ExtentReports();
		reports.attachReporter(spark);
		reports.setSystemInfo("OS","Windows 11");
		reports.setSystemInfo("Browser", "Chrome");
	}

	@Override
	public void onFinish(ISuite suite) {
		reports.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		test=reports.createTest(result.getMethod().getMethodName());
		UtilityClassObject.setTest(test);
		UtilityClassObject.getTest().log(Status.INFO,"Test execution Started");
		
	}
	

	@Override
	public void onTestSuccess(ITestResult result) {
		UtilityClassObject.getTest().log(Status.PASS,"Test execution Completed");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		UtilityClassObject.getTest().log(Status.FAIL, result.getThrowable());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		JavaUtility jlib= new JavaUtility();
		String methodName=result.getMethod().getMethodName();
		TakesScreenshot ts = (TakesScreenshot)UtilityClassObject.getDriver();
			String filePath = ts.getScreenshotAs(OutputType.BASE64);
			test.addScreenCaptureFromBase64String(filePath,methodName+jlib.getSystemTime());
			UtilityClassObject.getTest().log(Status.FAIL,"Test execution Failed");
		UtilityClassObject.getTest().log(Status.FAIL, result.getThrowable());
	}
}
