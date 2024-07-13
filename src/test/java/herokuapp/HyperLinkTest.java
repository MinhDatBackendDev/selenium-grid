package herokuapp;

import commons.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HyperlinkPage;
import supports.Browser;

public class HyperLinkTest extends TestBase {
    HyperlinkPage hyperlinkPage;

    @BeforeClass
    void launchBrowser() {
        Browser.launchBrowser("chrome");
    }

    @BeforeMethod
    void openHyperlinkPage() {
        hyperlinkPage = new HyperlinkPage();
        hyperlinkPage.open();
    }

    @Test
    void verifyRedirector() {
        hyperlinkPage.clickLinkByText("here");
        Assert.assertEquals(hyperlinkPage.getCurrentUrl(), "https://the-internet.herokuapp.com/status_codes");

        hyperlinkPage.clickLinkByText("200");
        Assert.assertEquals(hyperlinkPage.getCurrentUrl(), "https://the-internet.herokuapp.com/status_codes/200");
        Assert.assertTrue(hyperlinkPage.isContentContain("This page returned a 200 status code."));
        hyperlinkPage.clickLinkByText("here");

        hyperlinkPage.clickLinkByText("301");
        Assert.assertEquals(hyperlinkPage.getCurrentUrl(), "https://the-internet.herokuapp.com/status_codes/301");
        hyperlinkPage.clickLinkByText("here");

        hyperlinkPage.clickLinkByText("404");
        Assert.assertEquals(hyperlinkPage.getCurrentUrl(), "https://the-internet.herokuapp.com/status_codes/404");
        hyperlinkPage.clickLinkByText("here");

        hyperlinkPage.clickLinkByText("500");
        Assert.assertEquals(hyperlinkPage.getCurrentUrl(), "https://the-internet.herokuapp.com/status_codes/500");
        hyperlinkPage.clickLinkByText("here");

        hyperlinkPage.clickLinkByText("here");
        Assert.assertEquals(hyperlinkPage.getCurrentUrl(), "https://www.iana.org/assignments/http-status-codes/http-status-codes.xhtml");
    }

    @AfterClass
    void tearDown() {
        Browser.quit();
    }
}
