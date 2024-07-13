package pages;

import org.openqa.selenium.By;
import supports.Browser;

public class DynamicLoadingPage {

    String textResult;

    public void open() {
        Browser.visit("https://the-internet.herokuapp.com/dynamic_loading/1");
    }

    public void clickButtonStart() {
        Browser.click(By.xpath("//button[.='Start']"));
    }

    public void wait5Seconds() throws InterruptedException {
        Browser.implicitWaitInMilliSecond(5000);
    }

    public String wait5SecondUntilTextAppear() {
        Browser.explicitWaitInSecond(5000);
        return textResult = Browser.waitUntilElementVisible(By.cssSelector("#finish h4")).getText();
    }

    public String getTextResult() {
        return textResult = Browser.getText(By.cssSelector("#finish h4"));
    }
}
