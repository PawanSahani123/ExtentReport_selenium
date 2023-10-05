package ExtentReportBasic;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenShortExtentDemo6 {
    static WebDriver driver;
	public static void main(String[] args) throws IOException {
		ExtentReports extentReports=new ExtentReports();
		ExtentSparkReporter sparkReporter =new ExtentSparkReporter("Report.html");
		extentReports.attachReporter(sparkReporter);
		
		WebDriverManager.chromedriver().setup();
		driver =new ChromeDriver();
		driver.get("https://www.google.com/");
				
		
		
		extentReports.createTest(" Screenshort Test 1 " , " This is for attaching the screenshort ")
        .info("this is a Google Page")
        .addScreenCaptureFromPath(CaptureScreenshot(driver) ,"google Home page");
		
		driver.get("https://chat.openai.com/");
		
		extentReports.createTest("Test 2 " , " This is for attaching the screenshort ")
        .info("this is a chat GPT")
        .addScreenCaptureFromPath(CaptureScreenshot2(driver) ,"Chat GPT Image");
		
		extentReports.createTest("Test 3" , " Not information ")
        .info("this is a page ")
        .addScreenCaptureFromPath( "This is blank Image");
		
        extentReports.flush();
        driver.quit();
        Desktop.getDesktop().browse(new File("Report.html").toURI());
        
       
	}
	public static String  CaptureScreenshot(WebDriver driver) throws IOException  {

    TakesScreenshot takesScreenshot =((TakesScreenshot)driver);
	File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
	File destFile = new File("C:\\Users\\PSahani\\eclipse-workspace\\ExtentReportDemo2\\screenshot4.jpg");
	
	FileUtils.copyFile(sourceFile, destFile);
	
	return destFile.getAbsolutePath();

	}
	public static String  CaptureScreenshot2(WebDriver driver) throws IOException  {

	    TakesScreenshot takesScreenshot =((TakesScreenshot)driver);
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		File destFile = new File("C:\\Users\\PSahani\\eclipse-workspace\\ExtentReportDemo2\\chatGPTscreenshot6.jpg");
		
		FileUtils.copyFile(sourceFile, destFile);
		
		return destFile.getAbsolutePath();

		}
	
		
	
}
