package herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class HorizontalSliderTest {
    public int getPixelsToMove(WebElement slider, double amount, double sliderMax, double sliderMin) {
        int pixels = 0;
        double tempPixels = slider.getSize().getWidth();
        tempPixels = tempPixels / (sliderMax - sliderMin);
        tempPixels = tempPixels * (amount - sliderMin);
        pixels = (int) Math.round(tempPixels);
        return pixels;
    }

    @Test
    void verifyHorizonSlider() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/horizontal_slider");

        Actions actions = new Actions(driver);
        WebElement pointer = driver.findElement(By.cssSelector(".sliderContainer input"));

        int pixelToMove = getPixelsToMove(pointer, 0.5d, 5, 0);
        System.out.println(pixelToMove);
        actions.clickAndHold(pointer).moveByOffset(13, 0).release().build().perform();
//        Dimension sliderSize = pointer.getSize();
//        System.out.println(sliderSize);
//
//        int sliderWidth = sliderSize.getWidth();
//        System.out.println(sliderWidth);
//
//        int xCoord = pointer.getLocation().getX();
//        System.out.println(xCoord);
//
//        actions.clickAndHold(pointer).moveByOffset(-1, 0).perform();
    }
}
