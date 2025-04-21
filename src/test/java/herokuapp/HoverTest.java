package herokuapp;

import commons.TestBase;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.HoverPage;
import supports.Browser;

import java.net.MalformedURLException;

public class HoverTest extends TestBase {
    HoverPage hoverPage;

    @BeforeMethod
    void openHoverPage() throws MalformedURLException {
        Browser.launchBrowser("chrome");
        hoverPage = new HoverPage();
        Browser.timeoutManageWait(5);
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

    @AfterMethod
    void tearDown() {
        Browser.quit();
    }
}
