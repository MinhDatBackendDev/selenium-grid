package herokuapp;

import commons.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.WebTablePage;
import supports.Browser;

import java.util.List;

public class WebTableTest extends TestBase {
    WebTablePage webTablePage;

    @BeforeClass
    void launchBrowser() {
        Browser.launchBrowser("chrome");
        webTablePage = new WebTablePage();
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

    @AfterClass
    void quit() {
        Browser.quit();
    }
}
