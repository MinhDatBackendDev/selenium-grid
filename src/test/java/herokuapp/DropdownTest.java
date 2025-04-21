package herokuapp;

import commons.TestBase;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.DropdownPage;
import supports.Browser;

import java.net.MalformedURLException;

public class DropdownTest extends TestBase {
    DropdownPage dropdownPage;

    @BeforeMethod
    void openPages() throws MalformedURLException {
        Browser.launchBrowser("chrome");
        dropdownPage = new DropdownPage();
        Browser.timeoutManageWait(10);
        dropdownPage.open();
    }

    @Test
    void selectOption1() {
        dropdownPage.selectOptionNameInDropdown("Option 1");
        Assert.assertTrue(dropdownPage.isOptionSelectedInDropdown("Option 1"));
    }

    @Test
    void selectOption2() {
        dropdownPage.selectOptionNameInDropdown("Option 2");
        Assert.assertTrue(dropdownPage.isOptionSelectedInDropdown("Option 2"));
    }

    @Test
    void changeOption() {
        selectOption1();
        selectOption2();
        selectOption1();
        Assert.assertTrue(dropdownPage.isOptionSelectedInDropdown("Option 1"));
    }

    @AfterMethod
    void tearDown() {
        Browser.quit();
    }
}
