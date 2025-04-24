package org.minhdat.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

    private static final ExtentReports extentReports = new ExtentReports();

    public synchronized static ExtentReports getExtentReports() {
        ExtentSparkReporter reporter = new ExtentSparkReporter("target/reports/extentreport/extentreport.html");
        reporter.config().setReportName("Extent Report | Minh Dat Tester");
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Framework Name", "Selenium Java | Minh Dat Tester");
        extentReports.setSystemInfo("Author", "Minh Dat Tester");
        return extentReports;
    }

}