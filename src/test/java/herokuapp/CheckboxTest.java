package herokuapp;

import commons.TestBase;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.CheckboxPage;
import supports.Browser;

import java.net.MalformedURLException;

//Linear Script and Moduler Script
public class CheckboxTest extends TestBase{
    CheckboxPage checkboxPage;

    @BeforeMethod
    void openCheckboxPage() throws MalformedURLException {
        Browser.launchBrowser("chrome");
        checkboxPage = new CheckboxPage();
        Browser.timeoutManageWait(5);
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

    @AfterMethod(alwaysRun = true)
    void tearDown() {
        Browser.quit();
    }
}
