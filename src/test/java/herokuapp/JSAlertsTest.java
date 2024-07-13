package herokuapp;

import commons.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.JSAlertsPage;
import supports.Browser;

public class JSAlertsTest extends TestBase {
    JSAlertsPage jsAlertsPage;

    @BeforeClass
    void launchBrowser() {
        Browser.launchBrowser("chrome");
    }

    @BeforeMethod
    void openJSAlertPage() {
        jsAlertsPage = new JSAlertsPage();
        jsAlertsPage.open();
    }

    @Test
    void clickOnJSAlertSuccessfully() {
        jsAlertsPage.clickJSAlertButton();
        Assert.assertEquals(jsAlertsPage.getTextInAlert(), "I am a JS Alert");
        jsAlertsPage.clickOKInAlert();
        Assert.assertEquals(jsAlertsPage.getResultText(), "You successfully clicked an alert");
    }

    @Test
    void acceptJSConfirmSuccessfully() {
        jsAlertsPage.clickJSConfirmButton();
        Assert.assertEquals(jsAlertsPage.getTextInAlert(), "I am a JS Confirm");
        jsAlertsPage.clickOKInAlert();
        Assert.assertEquals(jsAlertsPage.getResultText(), "You clicked: Ok");
    }

    @Test
    void cancelJSConfirmSuccessfully() {
        jsAlertsPage.clickJSConfirmButton();
        Assert.assertEquals(jsAlertsPage.getTextInAlert(), "I am a JS Confirm");
        jsAlertsPage.clickCancelInAlert();
        Assert.assertEquals(jsAlertsPage.getResultText(), "You clicked: Cancel");
    }

    @Test
    void inputEmptyJSPromptSuccessfully() {
        jsAlertsPage.clickJSPromptButton();
        Assert.assertEquals(jsAlertsPage.getTextInAlert(), "I am a JS prompt");
        jsAlertsPage.clickOKInAlert();
        Assert.assertEquals(jsAlertsPage.getResultText(), "You entered:");
    }

    @Test
    void inputTextJSPromptSuccessfully() {
        jsAlertsPage.clickJSPromptButton();
        Assert.assertEquals(jsAlertsPage.getTextInAlert(), "I am a JS prompt");
        jsAlertsPage.fillTextInPrompt("hello");
        jsAlertsPage.clickOKInAlert();
        Assert.assertEquals(jsAlertsPage.getResultText(), "You entered: hello");
    }

    @Test
    void cancelJSPromptSuccessfully() {
        jsAlertsPage.clickJSPromptButton();
        Assert.assertEquals(jsAlertsPage.getTextInAlert(), "I am a JS prompt");
        jsAlertsPage.clickCancelInAlert();
        Assert.assertEquals(jsAlertsPage.getResultText(), "You entered: null");
    }

    @Test
    void cancelTextJSPromptSuccessfully() {
        jsAlertsPage.clickJSPromptButton();
        Assert.assertEquals(jsAlertsPage.getTextInAlert(), "I am a JS prompt");
        jsAlertsPage.fillTextInPrompt("hello");
        jsAlertsPage.clickCancelInAlert();
        Assert.assertEquals(jsAlertsPage.getResultText(), "You entered: null");
    }

    @AfterClass
    void tearDown() {
        Browser.quit();
    }
}
