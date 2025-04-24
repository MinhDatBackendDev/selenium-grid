package org.minhdat.testcases;

import org.minhdat.common.BaseTest;
import org.minhdat.helpers.PropertiesHelper;
import org.minhdat.listeners.TestListener;
import org.minhdat.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class LoginTest extends BaseTest {

    LoginPage loginPage;

    @Test
    public void testLoginSuccess() {
        loginPage = new LoginPage();

        //Gọi các hàm xử lý có sẵn để sử dụng
        loginPage.loginCRM(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        loginPage.verifyLoginSuccess();
    }

    @Test
    public void testLoginWithEmailInvalid() {
        loginPage = new LoginPage();

        //Gọi các hàm xử lý có sẵn để sử dụng
        loginPage.loginCRM(PropertiesHelper.getValue("invalid_email"), PropertiesHelper.getValue("password"));
        loginPage.verifyLoginFail();
    }
}
