package reportextent;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Extentrepoort {
	
	public static ExtentReports getextentreport() {
		String path=System.getProperty("user.dir")+"\\Report\\report.html";
		ExtentSparkReporter sreport=new ExtentSparkReporter(path);
		sreport.config().setReportName("DatadrivenframworkDemo");
		sreport.config().setDocumentTitle("Datadriven Report for Demo");
		ExtentReports ereport=new ExtentReports();
		ereport.attachReporter(sreport);
		ereport.setSystemInfo("selenium","selenium version 4.4.0");
		ereport.setSystemInfo("operating","window");
		return ereport;
	}
}
