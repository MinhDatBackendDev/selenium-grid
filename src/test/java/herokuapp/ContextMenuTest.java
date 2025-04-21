package herokuapp;

import commons.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ContextMenuPage;
import supports.Browser;

import java.net.MalformedURLException;

public class ContextMenuTest extends TestBase {
    ContextMenuPage contextMenuPage;

    @BeforeMethod
    void openContextMenuPage() throws MalformedURLException {
        Browser.launchBrowser("chrome");
        contextMenuPage = new ContextMenuPage();
        Browser.timeoutManageWait(10);
        contextMenuPage.open();
    }

    @Test
    void verifyContextMenu() {
        contextMenuPage.rightInsideContextBox();
        Assert.assertEquals(contextMenuPage.getAlertText(), "You selected a context menu");
        contextMenuPage.clickOKInAlert();
//
    }

    @AfterClass
    void tearDown() {
        Browser.quit();
    }
}
