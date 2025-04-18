package herokuapp;

import commons.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.FormAuthenticationPage;
import supports.Browser;

public class FormAuthenticationTest  {

    @DataProvider(name = "LoginData")
    public Object[][] dpMethod() {
        return new Object[][]{
                {"tomsmith", "SuperSecretPassword", "https://the-internet.herokuapp.com/login", "error"},
                {"tomsmith", "SuperSecretPassword!", "https://the-internet.herokuapp.com/secure", "success"},
        };
    }

    @BeforeClass
    void setUp() {
        Browser.launchBrowser("chrome");
    }

    @Test(dataProvider = "LoginData")
    void checkCredential(String username, String password, String targetUrl, String className) {
        FormAuthenticationPage formAuthenticationPage = new FormAuthenticationPage();

        formAuthenticationPage
                .open()
                .login(username, password);

//        formAuthenticationPage.open();
//        formAuthenticationPage.login(username, password);

        Assert.assertEquals(Browser.getCurrentUrl(), targetUrl);

        Assert.assertTrue(formAuthenticationPage.isMessageDisplayed(className));
    }

    @AfterClass
    void tearDown() {
        Browser.quit();
    }
}
