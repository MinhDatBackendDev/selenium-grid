package herokuapp;

import commons.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BrokenLinkPage;
import supports.Browser;

public class BrokenLinkTest extends TestBase {
    BrokenLinkPage brokenLinkPage;

    @BeforeClass
    void launchBrowser() {
        Browser.launchBrowser("chrome");
    }

    @BeforeMethod
    void openBrokenLinkPage() {
        brokenLinkPage = new BrokenLinkPage();
        brokenLinkPage.open();
    }

    @Test
    void verifyBrokenImagesAndDisplayedImages() {
        Assert.assertEquals(brokenLinkPage.countImagesBroken(), 2);
        Assert.assertEquals(brokenLinkPage.countImageDisplayed(), 1);
    }


    @AfterClass
    void tearDown() {
        Browser.quit();
    }
}
