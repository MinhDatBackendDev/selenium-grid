package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import supports.Browser;

public class HorizontalSliderPage {
    WebElement pointer;

    public void open() {
        Browser.visit("https://the-internet.herokuapp.com/horizontal_slider");
        pointer = Browser.getElement(By.cssSelector(".sliderContainer input"));
    }

    public void holdAndSlide() {

    }
}
