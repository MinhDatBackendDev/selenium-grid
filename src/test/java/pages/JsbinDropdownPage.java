package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import supports.Browser;

public class JsbinDropdownPage {
    private Select fruitDropdown;

    public void open() {
        Browser.visit("https://output.jsbin.com/osebed/2");
        fruitDropdown = Browser.getDropdown(By.id("fruits"));
    }

    public void selectOptionNameInFruitDropdown(String optionName) {
        Browser.selectOptionByName(fruitDropdown, optionName);
    }

    public boolean isOptionNameInFruitDropdown(String optionName) {
        return Browser.isSelected(By.xpath(String.format("//option[.='%s']", optionName)));
    }

    public void deselectAllOptionInFruitDropdown() {
        fruitDropdown.deselectAll();
    }
}
