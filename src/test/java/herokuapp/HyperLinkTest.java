package herokuapp;

import commons.TestBase;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.HyperlinkPage;
import supports.Browser;

import java.net.MalformedURLException;

public class HyperLinkTest extends TestBase {
    HyperlinkPage hyperlinkPage;

    @BeforeMethod
    void openHyperlinkPage() throws MalformedURLException {
        Browser.launchBrowser("chrome");
        hyperlinkPage = new HyperlinkPage();
        Browser.timeoutManageWait(5);
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

    @AfterMethod
    void tearDown() {
        Browser.quit();
    }
}
