package herokuapp;

import commons.TestBase;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.FormAuthenticationPage;
import supports.Browser;

import java.net.MalformedURLException;

public class FormAuthenticationTest {
    FormAuthenticationPage formAuthenticationPage;

    @DataProvider(name = "LoginData", parallel = true)
    public Object[][] dpMethod() {
        return new Object[][]{
                {"tomsmith", "SuperSecretPassword", "https://the-internet.herokuapp.com/login", "error"},
                {"tomsmith", "SuperSecretPassword!", "https://the-internet.herokuapp.com/secure", "success"},
        };
    }

    @BeforeMethod
    void setUp() throws MalformedURLException {
        Browser.launchBrowser("chrome");
        formAuthenticationPage = new FormAuthenticationPage();
        Browser.timeoutManageWait(10);
        formAuthenticationPage.open();
    }

    @Test(dataProvider = "LoginData")
    void checkCredential(String username, String password, String targetUrl, String className) {

        formAuthenticationPage.login(username, password);

//        formAuthenticationPage.open();
//        formAuthenticationPage.login(username, password);

        Assert.assertEquals(Browser.getCurrentUrl(), targetUrl);

        Assert.assertTrue(formAuthenticationPage.isMessageDisplayed(className));
    }

    @AfterMethod
    void tearDown() {
        Browser.quit();
    }
}
