package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import supports.Browser;

public class DropdownPage {
    private Select dropdown;

    public void open() {
        Browser.visit("https://the-internet.herokuapp.com/dropdown");
        dropdown = Browser.getDropdown(By.id("dropdown"));
    }

    public void selectOptionNameInDropdown(String optionName) {
        Browser.selectOptionByName(dropdown, optionName);
    }

    public boolean isOptionSelectedInDropdown(String optionName) {
        return Browser.isSelected(By.xpath(String.format("//option[.='%s']", optionName)));
    }
}
