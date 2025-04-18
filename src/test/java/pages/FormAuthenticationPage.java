package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static supports.Browser.*;

public class FormAuthenticationPage {

    public FormAuthenticationPage open() {
        visit("https://the-internet.herokuapp.com/login");

        return this;
    }

    public FormAuthenticationPage login(String username, String password) {
        fill(By.id("username"), username);
        fill(By.id("password"), password);

        click(By.xpath("//*[@type='submit']"));

        return this;
    }

    public boolean isMessageDisplayed(String messageType) {
        return isDisplayed(By.className(messageType));
    }
}
