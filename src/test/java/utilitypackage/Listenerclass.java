package utilitypackage;

import org.testng.IDynamicGraph.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import reportextent.Extentrepoort;

public class Listenerclass implements ITestListener {
    ExtentReports ereport=Extentrepoort.getextentreport();
    ExtentTest extenttest;
	@Override
	public void onTestStart(ITestResult result) {
		extenttest=ereport.createTest(result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extenttest.log(com.aventstack.extentreports.Status.PASS ,"Test pass");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
	extenttest.log(com.aventstack.extentreports.Status.FAIL, "Test failed");
	extenttest.fail(result.getThrowable());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
	
	}

	@Override
	public void onFinish(ITestContext context) {
		ereport.flush();
	}
	

}
