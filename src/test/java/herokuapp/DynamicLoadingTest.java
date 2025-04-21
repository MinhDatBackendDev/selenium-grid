package herokuapp;

import org.testng.Assert;
import org.testng.annotations.*;
import pages.DynamicLoadingPage;
import supports.Browser;

import java.net.MalformedURLException;

public class DynamicLoadingTest {
    DynamicLoadingPage dynamicLoadingPage;

    @BeforeMethod
    void openDynamicLoadingPage() throws MalformedURLException {
        Browser.launchBrowser("chrome");
        dynamicLoadingPage = new DynamicLoadingPage();
        Browser.timeoutManageWait(10);
        dynamicLoadingPage.open();
    }

    @Test
    void wait5Seconds() throws InterruptedException {
        dynamicLoadingPage.clickButtonStart();
        dynamicLoadingPage.wait5Seconds();
        Assert.assertEquals(dynamicLoadingPage.getTextResult(), "Hello World!");
    }

    @Test
    void wait5SecondsUntilTextAppear() {
        dynamicLoadingPage.clickButtonStart();
        Assert.assertEquals(dynamicLoadingPage.wait5SecondUntilTextAppear(), "Hello World!");
    }

    @AfterMethod
    void quit() {
        Browser.quit();
    }
}
