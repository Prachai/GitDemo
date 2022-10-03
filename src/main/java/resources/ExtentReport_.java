package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport_ 
{

public static ExtentReports extentReport() 
{
String path=System.getProperty("user.dir")+"//reports//index.html";
ExtentSparkReporter sparkReporter=new ExtentSparkReporter(path);
sparkReporter.config().setDocumentTitle("scripts results");
sparkReporter.config().setReportName("Web Automation Results");

ExtentReports extentReports=new ExtentReports();
extentReports.attachReporter(sparkReporter);
extentReports.setSystemInfo("tester", "prachai");
return extentReports;
}	
	
}
