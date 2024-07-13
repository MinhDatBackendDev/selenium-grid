package herokuapp;

import commons.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ContextMenuPage;
import supports.Browser;

public class ContextMenuTest extends TestBase {
    ContextMenuPage contextMenuPage;

    @BeforeClass
    void launchBrowser() {
        Browser.launchBrowser("chrome");
    }

    @BeforeMethod
    void openContextMenuPage() {
        contextMenuPage = new ContextMenuPage();
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
