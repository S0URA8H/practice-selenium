package vtiger.GeneralUtitltiy;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

/**
 * EXAMPLE OF ABSTRACT
 * @author user
 *
 */

public class ListenerImplementationClass implements ITestListener {
	ExtentReports report;
	ExtentTest test;
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName=result.getMethod().getMethodName();
				System.out.println("----Execution started---"+methodName);
				test=report.createTest(methodName);
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName=result.getMethod().getMethodName();
		System.out.println("----Pass---"+methodName);
		test.log(Status.PASS, "--- PASS --- "+methodName);
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName=result.getMethod().getMethodName();
		System.out.println("----Fail---"+methodName);
		test.log(Status.FAIL, "--- FAIL --- "+methodName);
		String methodName1=result.getMethod().getMethodName();
		System.out.println("----Fail---"+methodName1);
		System.out.println(result.getThrowable());
		
		webDriverUtility wu= new webDriverUtility();
				javaUtility ju = new javaUtility();
				String screenshotName = methodName1+ju.getSystemDateInFormat();
				String path = null;
				try {
					path = wu.takescreenshot(BaseClass.sdriver, screenshotName);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				test.addScreenCaptureFromPath(path);
	}	

	

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName=result.getMethod().getMethodName();
		System.out.println("---Skip----"+methodName);
		test.log(Status.SKIP, "--- SKIP --- "+methodName);
		//System.out.println(result.getThrowable());
		
				test.log(Status.INFO, result.getThrowable());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
	

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("---SUITE EXECUTION STARTED----");
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("---SUITE EXECUTION ENDED----");
	}

	

}
