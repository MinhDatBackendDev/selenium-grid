package herokuapp;

import commons.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HoverPage;
import supports.Browser;

public class HoverTest extends TestBase {
    HoverPage hoverPage;

    @BeforeClass
    void launchBrowser() {
        Browser.launchBrowser("chrome");
    }

    @BeforeMethod
    void openHoverPage() {
        hoverPage = new HoverPage();
        hoverPage.open();
    }

    @Test
    void checkHover() {
        hoverPage.hoverPerson("1");
        Assert.assertEquals(hoverPage.getPersonName("1"), "name: user1");
        Assert.assertEquals(hoverPage.getPersonLink("1"), "View profile");

        hoverPage.hoverPerson("2");
        Assert.assertEquals(hoverPage.getPersonName("2"), "name: user2");
        Assert.assertEquals(hoverPage.getPersonLink("2"), "View profile");

        hoverPage.hoverPerson("3");
        Assert.assertEquals(hoverPage.getPersonName("3"), "name: user3");
        Assert.assertEquals(hoverPage.getPersonLink("3"), "View profile");
    }

    @AfterClass
    void tearDown() {
        Browser.quit();
    }
}
