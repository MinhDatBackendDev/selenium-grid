package herokuapp;

import commons.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DropdownPage;
import supports.Browser;

public class DropdownTest extends TestBase {
    DropdownPage dropdownPage;

    @BeforeClass
    void launchBrowser() {
        Browser.launchBrowser("chrome");
    }

    @BeforeMethod
    void openPages() {
        dropdownPage = new DropdownPage();
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
    }

    @AfterClass
    void tearDown() {
        Browser.quit();
    }
}
