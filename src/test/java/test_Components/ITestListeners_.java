package test_Components;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.ExtentReport_;

public class ITestListeners_ extends BaseClass implements ITestListener
{

	ExtentReports report =ExtentReport_.extentReport();	
	ExtentTest extentTest;
	ThreadLocal<ExtentTest> local=new ThreadLocal<ExtentTest>();
	@Override
	public void onTestStart(ITestResult result) {
		extentTest=report.createTest(result.getMethod().getMethodName());
		local.set(extentTest);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		local.get().log(Status.PASS, "Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		local.get().log(Status.FAIL, "Failed");
		
		try {
			driver=(WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e1) {
			e1.printStackTrace();
		} 
		String path = null;
		try {
			path = takeScreenshot(result.getMethod().getMethodName(), driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		local.get().addScreenCaptureFromPath(path,result.getMethod().getMethodName());
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		
	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
	}

}
