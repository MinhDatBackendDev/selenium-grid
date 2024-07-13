package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import supports.Browser;

import java.util.List;

public class BrokenLinkPage {

    int imageBrokenCount = 0;

    int imageDisplayedCount = 0;

    List<WebElement> images;

    public void open() {
        Browser.visit("https://the-internet.herokuapp.com/broken_images");
        images = Browser.getElementList(By.xpath("//*[@class='example']/img"));
    }

    public int countImagesBroken() {
        for (WebElement image : images) {
            if (image.getAttribute("naturalWidth").equals("0")) {
                imageBrokenCount++;
            }
        }
        return imageBrokenCount;
    }

    public int countImageDisplayed() {
        for (WebElement image : images) {
            if (!image.getAttribute("naturalWidth").equals("0")) {
                imageDisplayedCount++;
            }
        }
        return imageDisplayedCount;
    }
}
