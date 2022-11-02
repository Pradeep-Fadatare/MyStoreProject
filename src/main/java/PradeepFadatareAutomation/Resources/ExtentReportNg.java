package PradeepFadatareAutomation.Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNg {
public ExtentReports reports;
    public static ExtentReports getReportObject(){
        String path=System.getProperty("user.dir")+"//report/index.html";
        ExtentSparkReporter sparkReporter=new ExtentSparkReporter(path);
        sparkReporter.config().setReportName("Web Automation Config");
        sparkReporter.config().setDocumentTitle("Test Result");

        ExtentReports reports=new ExtentReports();
        reports.attachReporter(sparkReporter);
        reports.setSystemInfo("Tester","Pradeep Fadatare");
        reports.setSystemInfo("HostNAme","MyHost");
        reports.setSystemInfo("ProjectName","MyStoreProject");
        reports.setSystemInfo("OS","Win 10");
        reports.setSystemInfo("Browser","Chrome");
        reports.createTest(path);
        return reports;

    }
}
