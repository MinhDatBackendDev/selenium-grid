package herokuapp;

import commons.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DragDropPage;
import supports.Browser;

public class DragDropTest extends TestBase {
    DragDropPage dragDropPage;

    @BeforeClass
    void launchBrowser() {
        Browser.launchBrowser("chrome");
    }

    @BeforeMethod
    void openDragDropPage() {
        dragDropPage = new DragDropPage();
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

    @AfterClass
    void tearDown() {
        Browser.quit();
    }
}
