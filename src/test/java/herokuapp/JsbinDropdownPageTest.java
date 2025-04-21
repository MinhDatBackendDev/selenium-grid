package herokuapp;

import commons.TestBase;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.JsbinDropdownPage;
import supports.Browser;

import java.net.MalformedURLException;

public class JsbinDropdownPageTest extends TestBase {
    JsbinDropdownPage jsbinDropdownPage;

    @BeforeMethod
    void openJsbinPage() throws MalformedURLException {
        Browser.launchBrowser("chrome");
        jsbinDropdownPage = new JsbinDropdownPage();
        Browser.timeoutManageWait(5);
        jsbinDropdownPage.open();
    }

    @Test
    void verifyMultiSelectableOptions() {
        jsbinDropdownPage.selectOptionNameInFruitDropdown("Banana");
        jsbinDropdownPage.selectOptionNameInFruitDropdown("Orange");

        Assert.assertTrue(jsbinDropdownPage.isOptionNameInFruitDropdown("Banana"));
        Assert.assertTrue(jsbinDropdownPage.isOptionNameInFruitDropdown("Orange"));

        jsbinDropdownPage.deselectAllOptionInFruitDropdown();
        Assert.assertFalse(jsbinDropdownPage.isOptionNameInFruitDropdown("Banana"));
        Assert.assertFalse(jsbinDropdownPage.isOptionNameInFruitDropdown("Orange"));
        Assert.assertFalse(jsbinDropdownPage.isOptionNameInFruitDropdown("Apple"));
        Assert.assertFalse(jsbinDropdownPage.isOptionNameInFruitDropdown("Grape"));

    }

//    @Test
//    void verifyAbleSelectOptionTicketBox() {
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://ticketbox.vn/sign-in?ref=/events/22204/bookings/68085928612713/select-ticket");
//        driver.findElement(By.xpath("//*[contains(@class, 'Countries__Container')]")).click();
//        driver.findElement(By.xpath("//*[.='Canada']")).click();
//    }

    @AfterMethod
    void tearDown() {
        Browser.quit();
    }
}
