package herokuapp;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DynamicLoadingPage;
import supports.Browser;

public class DynamicLoadingTest {
    DynamicLoadingPage dynamicLoadingPage;

    @BeforeClass
    void launchBrowser() {
        Browser.launchBrowser("chrome");
    }

    @BeforeMethod
    void openDynamicLoadingPage() {
        dynamicLoadingPage = new DynamicLoadingPage();
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

    @AfterClass
    void quit() {
        Browser.quit();
    }
}
