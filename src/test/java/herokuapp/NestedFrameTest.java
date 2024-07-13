package herokuapp;

import commons.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.NestedFramePage;
import supports.Browser;

public class NestedFrameTest extends TestBase {
    NestedFramePage nestedFramePage;

    @BeforeClass
    void launchBrowser() {
        Browser.launchBrowser("chrome");
    }

    @BeforeMethod
    void openNestedFramePage() {
        nestedFramePage = new NestedFramePage();
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
