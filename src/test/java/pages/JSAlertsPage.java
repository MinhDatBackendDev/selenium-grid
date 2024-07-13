package pages;

import org.openqa.selenium.By;

import static supports.Browser.*;

public class JSAlertsPage {
    public void open() {
        visit("https://the-internet.herokuapp.com/javascript_alerts");
    }

    public void clickJSAlertButton() {
        click(By.xpath("//button[.='Click for JS Alert']"));
    }

    public void clickJSConfirmButton() {
        click(By.xpath("//button[.='Click for JS Confirm']"));
    }

    public void clickJSPromptButton() {
        click(By.xpath("//button[.='Click for JS Prompt']"));
    }

    public void clickOKInAlert() {
        acceptAlert();
    }

    public void clickCancelInAlert() {
        dismissAlert();
    }

    public String getTextInAlert() {
        return getAlertText();
    }

    public void fillTextInPrompt(String text) {
        fillAlert(text);
    }

    public String getResultText() {
        return getText(By.id("result"));
    }
}
