package pages;

import org.openqa.selenium.By;
import supports.Browser;

public class HyperlinkPage {

    public void open() {
        Browser.visit("https://the-internet.herokuapp.com/redirector");
    }

    public void clickLinkByText(String linkText) {
        Browser.click(By.linkText(String.format("%s", linkText)));
    }

    public boolean isContentContain(String containedText) {
        return (Browser.getText(By.id("content"))).contains(containedText);
    }

    public String getCurrentUrl() {
        return Browser.getCurrentUrl();
    }
}
