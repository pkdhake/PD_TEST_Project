package com.inet.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.utils.FileUtil;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class BaseClass {
    public String baseURL = "https://www.nseindia.com/";
    public WebDriver driver;
    public ExtentHtmlReporter htmlReporter;
    public ExtentReports extentReports;
    public ExtentTest extentTest;

    @BeforeSuite
    public void setup() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//Drivers//chromedriver.exe");
        driver = new ChromeDriver();
        //Maximize the screen
        driver.manage().window().maximize();
        //Delete all the cookies
        driver.manage().deleteAllCookies();

        // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //PageLoad TimeOuts
        // driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
        driver.get(baseURL);
    }

    @BeforeTest
    public void launchBrowser() {
        setExtent();
    }

    @AfterTest
    public void tearDown() {
        //  driver.quit();
        entReport();
    }


    public void setExtent() {
        //htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/ExtentReports/Report.html");
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/ExtentReports/Report.html");

        htmlReporter.config().setDocumentTitle("Automation Test Report");
        htmlReporter.config().setReportName("PD_Test_Report Report");
        extentReports = new ExtentReports();
        extentReports.attachReporter(htmlReporter);
        extentReports.setSystemInfo("OS", "Windows 11");
    }

    @AfterMethod
    public void tearDown1(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            extentTest.log(Status.FAIL, "ITEST CASE FAILED IS " + result.getName());
            extentTest.log(Status.FAIL, "TEST CASE FAILED IS " + result.getThrowable());
            String s = getScreenshot(result.getName());
            extentTest.addScreenCaptureFromPath(s);

        } else if (result.getStatus() == ITestResult.SKIP) {
            extentTest.log(Status.SKIP, "Test Case SKIPPED IS " + result.getName());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            extentTest.log(Status.PASS, "Test Case PASSED IS " + result.getName());
        }
    }

    public void entReport() {
        extentReports.flush();
    }

    public String getScreenshot(String screenshotName) throws IOException {
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot)driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        // after execution, you could see a folder "FailedTestsScreenshots" under src folder
        String destination = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + dateName + ".png";
        File finalDestination = new File(destination);
        FileUtils.copyFile(source, finalDestination);
        return destination;
    }

}
