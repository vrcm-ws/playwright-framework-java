package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

    private static ExtentReports report;

    public static synchronized ExtentReports getInstance() {

        if (report == null) {

            ExtentSparkReporter reporter = new ExtentSparkReporter("test-output/ExtentReport.html");

            reporter.config().setTheme(Theme.STANDARD);
            reporter.config().setDocumentTitle("Test Report");

            report = new ExtentReports();
            report.attachReporter(reporter);
        }

        return report;
    }
}
