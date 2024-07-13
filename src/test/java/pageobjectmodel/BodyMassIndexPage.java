package pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import supports.Browser;

public class BodyMassIndexPage {
    /**
     * Suffix:
     * Tab
     * Button -> btn
     * TextBox
     * Label ->
     * ...
     */
    WebDriver driver;
    By metricUnitTab = By.xpath("//a[.='Metric Units']");
    By clearButton = By.cssSelector("input[value=Clear]");
    By ageTextBox = By.id("cage");
    By maleRadioButton = By.id("csex1");
    By femaleRadioButton = By.id("csex2");
    By heightTextBox = By.id("cheightmeter");
    By weightTextBox = By.id("ckg");
    By resultLabel = By.className("bigtext");


    public void open() {
        Browser.visit("https://www.calculator.net/bmi-calculator.html");
    }


    public void selectMetricTab() {
        Browser.click(metricUnitTab);
    }

    public void clearForm() {
        Browser.click(clearButton);
    }

    public void fillForm(String age, String gender, String height, String weight) {
        Browser.fill(ageTextBox, age);

        if (gender.equalsIgnoreCase("male")) Browser.check(maleRadioButton);
        else Browser.check(femaleRadioButton);

        Browser.fill(heightTextBox, height);
        Browser.fill(weightTextBox, weight);
    }

    public String getResult() {
        return Browser.getText(resultLabel);
    }
}