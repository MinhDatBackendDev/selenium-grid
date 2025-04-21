package herokuapp;

import commons.TestBase;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.BrokenLinkPage;
import supports.Browser;

import java.net.MalformedURLException;

public class BrokenLinkTest extends TestBase {
    BrokenLinkPage brokenLinkPage;

    @BeforeMethod
    void openBrokenLinkPage() throws MalformedURLException {
        Browser.launchBrowser("chrome");
        brokenLinkPage = new BrokenLinkPage();
        Browser.timeoutManageWait(5);
        brokenLinkPage.open();
    }

    @Test
    void verifyBrokenImagesAndDisplayedImages() {
        Assert.assertEquals(brokenLinkPage.countImagesBroken(), 2);
        Assert.assertEquals(brokenLinkPage.countImageDisplayed(), 1);
    }


    @AfterMethod
    void tearDown() {
        Browser.quit();
    }
}
