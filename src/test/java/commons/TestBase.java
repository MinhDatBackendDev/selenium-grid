package commons;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import supports.Browser;

public class TestBase {

    @AfterMethod(alwaysRun = true)
    protected void tearDown(ITestResult iTestResult) {
        if (!iTestResult.isSuccess()) Browser.takeScreenShot(iTestResult.getMethod().getMethodName());
    }
}
