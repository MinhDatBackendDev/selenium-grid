package pages;

import org.openqa.selenium.By;

import static supports.Browser.*;

public class HoverPage {
    public void open() {
        visit("https://the-internet.herokuapp.com/hovers");
    }

    public void hoverPerson(String index) {
        hover(getPersonByIndex(index));
    }

    private By getPersonByIndex(String index) {
        String personLocator = "//div[@class='example']/div[@class='figure'][%s]";
        return By.xpath(String.format(personLocator, index));
    }

    public String getPersonName(String index) {
        String personNameLocator = "//div[@class='example']/div[@class='figure'][%s]//h5";
        return getText(By.xpath(String.format(personNameLocator, index)));
    }

    public String getPersonLink(String index) {
        String personLinkLocator = "//div[@class='example']/div[@class='figure'][%s]//a";
        return getText(By.xpath(String.format(personLinkLocator, index)));
    }


}
