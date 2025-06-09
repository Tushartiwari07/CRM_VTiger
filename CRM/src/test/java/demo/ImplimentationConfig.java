package demo;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ImplimentationConfig implements ITestListener,ISuiteListener{
	@Override
	public void onStart(ISuite suite) {
		System.out.println("======ON START===========");
	}
	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		System.out.println("======ON FINISH===========");
	}
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
	System.out.println("======ONTEST-START===========");
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("======ON-TEST-SUCESS===========");
	}
	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("======ON-TEST-FAILURE===========");
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("======ON-TEST-SKIPPED===========");
	}
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("======ON-TEST-FAILED-WITH-SUCCESS-PERCENTAGE===========");
	}
	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("======ON-TEST-FAILED-WITH-TIMEOUT===========");
	}
	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("======ON START CONTEXT===========");
	}
	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("======ON FINISH CONTEXT===========");
	}

}
