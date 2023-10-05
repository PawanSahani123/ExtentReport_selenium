package ExtentReportBasic;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentDemo3 {

	public static void main(String args[]) throws IOException
	{
		ExtentReports extentReports =new ExtentReports();
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("C:\\Users\\PSahani\\eclipse-workspace\\ExtentReportDemo2\\Extent_Report.html");
        extentReports.attachReporter(sparkReporter);
        
       ExtentTest test1=  extentReports.createTest("Test1");
       test1.pass("This is Passed");
       
       ExtentTest test2 = extentReports.createTest("Test 2");
       test2.log(Status.FAIL, "This is failed");
       
       ExtentTest test3 = extentReports.createTest("Test 3");
       test3.skip("This is skip");
        
        extentReports.flush();
        Desktop.getDesktop().browse(new File("Extent_Report.html").toURI());
	}
}
