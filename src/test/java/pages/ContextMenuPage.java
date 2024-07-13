package pages;

import org.openqa.selenium.By;
import supports.Browser;

import static supports.Browser.rightClick;
import static supports.Browser.visit;

public class ContextMenuPage {

    public void open() {
        visit("https://the-internet.herokuapp.com/context_menu");
    }

    public void rightInsideContextBox() {
        rightClick(By.id("hot-spot"));
    }

    public void clickOKInAlert() {
        Browser.acceptAlert();
    }

    public String getAlertText() {
        return Browser.getAlertText();
    }
}
