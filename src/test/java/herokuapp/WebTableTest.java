package herokuapp;

import commons.TestBase;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.WebTablePage;
import supports.Browser;

import java.net.MalformedURLException;
import java.util.List;

public class WebTableTest extends TestBase {
    WebTablePage webTablePage;

    @BeforeMethod
    void launchBrowser() throws MalformedURLException {
        Browser.launchBrowser("chrome");
        webTablePage = new WebTablePage();
        Browser.timeoutManageWait(5);
        webTablePage.open();
    }

    @Test
    void verifyLargestDuePerson() {
        Assert.assertEquals(webTablePage.getMaxDuePerson(), List.of("Doe Jason"));
    }

    @Test
    void verifySmallestDuePerson() {
        Assert.assertEquals(webTablePage.getMinDuePerson(), List.of("Smith John", "Conway Tim"));
    }

    @AfterMethod
    void quit() {
        Browser.quit();
    }
}
