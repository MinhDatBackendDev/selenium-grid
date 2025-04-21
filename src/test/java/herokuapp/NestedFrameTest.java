package herokuapp;

import commons.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.NestedFramePage;
import supports.Browser;

import java.net.MalformedURLException;

public class NestedFrameTest extends TestBase {
    NestedFramePage nestedFramePage;

    @BeforeMethod
    void openNestedFramePage() throws MalformedURLException {
        Browser.launchBrowser("chrome");
        nestedFramePage = new NestedFramePage();
        Browser.timeoutManageWait(5);
        nestedFramePage.open();
    }

    @Test
    void verifyAllFrameContent() {
        Assert.assertEquals(nestedFramePage.getLeftFrameContent(), "LEFT");
        Assert.assertEquals(nestedFramePage.getMiddleFrameContent(), "MIDDLE");
        Assert.assertEquals(nestedFramePage.getRightFrameContent(), "RIGHT");
        Assert.assertEquals(nestedFramePage.getBottomFrameContent(), "BOTTOM");
    }

    @AfterMethod
    void tearDown() {
        Browser.quit();
    }
}
