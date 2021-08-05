package Helpers;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Report_Class {

    private ExtentHtmlReporter htmlReporter;
    protected ExtentReports extent;
    protected ExtentTest test;

    @BeforeSuite
    public void reportSetup()
    {
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/Guru 99 Report/Guru_99_Report_.html");
        htmlReporter.config().setDocumentTitle("Execution Report");
        htmlReporter.config().setReportName("End To End Report");
        htmlReporter.config().setTheme(Theme.DARK);
        extent= new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Hostname","Localhost");
        extent.setSystemInfo("OS","Windows");
        extent.setSystemInfo("OS","MAC");
        extent.setSystemInfo("Browser","Chrome");
        extent.setSystemInfo("Environment","Test_Env");
        extent.setSystemInfo("Tester Name","Tester Name");
    }
    //This will happen when your test are done running // @AfterMethod
    @AfterMethod
    public void tearDown(ITestResult result) {
        //Logging the failure on the report
        if (result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, "Test Case Failed Is " + result.getName());
            test.log(Status.FAIL, "Test Case Failed Is " + result.getThrowable());
        //Logging the SKIPPEd tests on the report
        } else if (result.getStatus() == ITestResult.SKIP) {
            test.log(Status.SKIP, "Test Case Skipped Is " + result.getName());
        //Logging the Passed tests on the report
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, "Test Case Passed Is " + result.getName());
        }

    }
    //Once everything is done , flush the report....almost the same as driver.quit
    @AfterSuite
    public void reportTeardown()
    {
        extent.flush();
    }
}