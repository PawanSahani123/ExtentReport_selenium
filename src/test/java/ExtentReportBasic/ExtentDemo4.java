package ExtentReportBasic;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentDemo4 {

	public static void main(String[] args) throws IOException {
		
		ExtentReports extentReports =new ExtentReports();
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("C:\\Users\\PSahani\\eclipse-workspace\\ExtentReportDemo2\\Extent_Report.html");
        extentReports.attachReporter(sparkReporter);
        
       extentReports.createTest("Test 1")
       .log(Status.INFO ,"info1") 
       .log(Status.INFO ,"info2")
       
       .log(Status.PASS ,"<b>pass</b>")
       .log(Status.WARNING ,"Warning ")
       
       .log(Status.SKIP ,"<b><i>skip </i></b>")
       
       .log(Status.FAIL ,"Fail")
       .log(Status.PASS ,"pass");
        
       String xmlData = "<menu id=\"file\" value=\"File\">\r\n"
       		+ "  <popup>\r\n"
       		+ "    <menuitem value=\"New\" onclick=\"CreateNewDoc()\" />\r\n"
       		+ "    <menuitem value=\"Open\" onclick=\"OpenDoc()\" />\r\n"
       		+ "    <menuitem value=\"Close\" onclick=\"CloseDoc()\" />\r\n"
       		+ "  </popup>\r\n"
       		+ "   </menu>";
       
       String jsonData = "{\"menu\": {\r\n"
       		+ "  \"id\": \"file\",\r\n"
       		+ "  \"value\": \"File\",\r\n"
       		+ "  \"popup\": {\r\n"
       		+ "    \"menuitem\": [\r\n"
       		+ "      {\"value\": \"New\", \"onclick\": \"CreateNewDoc()\"},\r\n"
       		+ "      {\"value\": \"Open\", \"onclick\": \"OpenDoc()\"},\r\n"
       		+ "      {\"value\": \"Close\", \"onclick\": \"CloseDoc()\"}\r\n"
       		+ "    ]\r\n"
       		+ "  }\r\n"
       		+ "}}";
       
       extentReports.createTest("Json Based Test ")
       .info(MarkupHelper.createCodeBlock(jsonData ,CodeLanguage.JSON));
        
       extentReports.createTest("XML based test")
       .info(MarkupHelper.createCodeBlock(xmlData,CodeLanguage.XML));
       
       //List 
       List<String>listData =new ArrayList<String>();
       listData.add("Pawan");
       listData.add("Sai");
       listData.add("kirshan");
      
       
   
       extentReports.createTest("List Based Test")
       .info(MarkupHelper.createOrderedList(listData));
       
       extentReports.createTest("List Based Test")
       .info(MarkupHelper.createUnorderedList(listData));
        extentReports.flush();
        Desktop.getDesktop().browse(new File("Extent_Report.html").toURI());

	}

	
}
