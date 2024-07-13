package pages;

import org.openqa.selenium.By;

import static supports.Browser.*;

public class CheckboxPage {

    public void open() {
        visit("https://the-internet.herokuapp.com/checkboxes");
    }

    public void selectCheckbox(String checkboxNumber) {
        check(getCheckboxByIndex(checkboxNumber));
    }

    public void deselectCheckbox(String checkboxNumber) {
        uncheck(getCheckboxByIndex(checkboxNumber));
    }

    public boolean isCheckboxSelected(String checkboxNumber) {
        return isSelected(getCheckboxByIndex(checkboxNumber));
    }

    private By getCheckboxByIndex(String index) {
        String checkboxLocator = "//form[@id='checkboxes']/input[%s]";
        return By.xpath(String.format(checkboxLocator, index));
    }
}
