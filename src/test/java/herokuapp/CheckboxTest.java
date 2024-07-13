package herokuapp;

import commons.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CheckboxPage;
import supports.Browser;

//Linear Script and Moduler Script
public class CheckboxTest extends TestBase {
    CheckboxPage checkboxPage;

    @BeforeClass
    void reloadPage() {
        Browser.launchBrowser("chrome");
    }

    @BeforeMethod
    void openCheckboxPage() {
        checkboxPage = new CheckboxPage();
        checkboxPage.open();
    }

    @Test
    void theCheckboxesShouldSelected() {
        checkboxPage.selectCheckbox("1");
        Assert.assertTrue(checkboxPage.isCheckboxSelected("1"));

        checkboxPage.selectCheckbox("2");
        Assert.assertTrue(checkboxPage.isCheckboxSelected("2"));
    }

    @Test
    void theCheckboxesShouldDeSelected() {
        checkboxPage.deselectCheckbox("1");
        Assert.assertFalse(checkboxPage.isCheckboxSelected("1"));

        checkboxPage.deselectCheckbox("2");
        Assert.assertFalse(checkboxPage.isCheckboxSelected("2"));
    }

    @AfterClass
    void tearDown() {
        Browser.quit();
    }
}
