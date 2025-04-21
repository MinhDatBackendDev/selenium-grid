package herokuapp;

import commons.TestBase;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.DragDropPage;
import supports.Browser;

import java.net.MalformedURLException;

public class DragDropTest extends TestBase {
    DragDropPage dragDropPage;

    @BeforeMethod
    void openDragDropPage() throws MalformedURLException {
        Browser.launchBrowser("chrome");
        dragDropPage = new DragDropPage();
        Browser.timeoutManageWait(10);
        dragDropPage.open();
    }

    @Test
    void verifyDragADropBSuccessfully() {
        dragDropPage.dragAtoB();
        Assert.assertEquals(dragDropPage.getSquareAText(), "B");
        Assert.assertEquals(dragDropPage.getSquareBText(), "A");
    }

    @Test
    void verifyDragBDropASuccessfully() {
        dragDropPage.dragBtoA();
        Assert.assertEquals(dragDropPage.getSquareAText(), "B");
        Assert.assertEquals(dragDropPage.getSquareBText(), "A");
    }

    @AfterMethod
    void tearDown() {
        Browser.quit();
    }
}
