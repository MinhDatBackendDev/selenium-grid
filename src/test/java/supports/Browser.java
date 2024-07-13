package supports;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

//Selenium Owner method
public class Browser {
    private static WebDriver driver;

    private static Actions actions;

    private static WebDriverWait wait;

    public static void launchBrowser(String name) {
        switch (name) {
            case "chrome": {
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless=new");
                driver = new ChromeDriver(chromeOptions);
                break;
            }
            case "firefox": {
                driver = new FirefoxDriver();
                break;
            }
            case "safari": {
                driver = new SafariDriver();
                break;
            }
            default:
                throw new IllegalStateException("Unexpected value: " + name);
        }

        actions = new Actions(driver);
    }

    //Window Handle functions
    public static void maximizeWindow() {
        driver.manage().window().maximize();
    }

    public static void visit(String url) {
        driver.get(url);
    }

    public static String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public static void quit() {
        if (driver != null) {
            driver.quit();
        }
    }

    // Wait functions
    public static void implicitWaitInMilliSecond(long milliSecond) throws InterruptedException {
        Thread.sleep(milliSecond);
    }

    public static WebDriverWait explicitWaitInSecond(long second) {
        return wait = new WebDriverWait(driver, Duration.ofSeconds(second));
    }

    public static WebElement waitUntilElementVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    //    Basic functions handling Web Element
    public static WebElement getElement(By locator) {
        return driver.findElement(locator);
    }

    public static List<WebElement> getElementList(By locator) {
        return driver.findElements(locator);
    }

    public static String getText(By locator) {
        return getElement(locator).getText();
    }

    public static void click(By locator) {
        getElement(locator).click();
    }

    public static void check(By locator) {
        if (!getElement(locator).isSelected()) {
            click(locator);
        }
    }

    public static void uncheck(By locator) {
        if (getElement(locator).isSelected()) {
            click(locator);
        }
    }

    public static void fill(By locator, CharSequence... keyToSend) {
        getElement(locator).sendKeys(keyToSend);
    }

    public static boolean isDisplayed(By locator) {
        return getElement(locator).isDisplayed();
    }

    public static boolean isSelected(By locator) {
        return getElement(locator).isSelected();
    }

    //    Functions handling dropdown
    public static Select getDropdown(By dropdownLocator) {
        WebElement select = getElement(dropdownLocator);
        Select dropdown = new Select(select);
        return dropdown;
    }

    public static void selectOptionByName(Select dropdown, String optionName) {
        dropdown.selectByVisibleText(optionName);
    }

    public static void deselectOptionByName(Select dropdown, String optionName) {
        dropdown.deselectByValue(optionName);
    }

    public static void deselectAllOptions(Select dropdown, String optionName) {
        dropdown.deselectAll();
    }

    //    Functions moving within Frames
    public static void moveToFrame(String frameName) {
        driver.switchTo().frame(frameName);
    }

    public static void moveBackToParentFrame() {
        driver.switchTo().parentFrame();
    }

    public static void moveToDefaultFrame() {
        driver.switchTo().defaultContent();
    }

    //    Functions handling JS Alert
    public static void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    public static void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    public static void fillAlert(String keyToSend) {
        driver.switchTo().alert().sendKeys(keyToSend);
    }

    public static String getAlertText() {
        return driver.switchTo().alert().getText();
    }

    //    Actions functions
    public static void hover(By locator) {
        actions.moveToElement(getElement(locator)).perform();
    }

    public static void rightClick(By locator) {
        actions.contextClick(getElement(locator)).perform();
    }

    public static void dragAndDrop(By source, By target) {
        actions.dragAndDrop(getElement(source), getElement(target)).perform();
    }

    public static void dragAndDropPointer(WebElement pointer, int xOffset, int yOffset) {
        actions.dragAndDropBy(pointer, xOffset, yOffset).perform();
    }

    public static void holdAndMovePointerHorizontallyByOffset(WebElement pointer, int xOffset) {
        actions.clickAndHold(pointer).moveByOffset(xOffset, 0).build().perform();
    }

    public static void holdAndMovePointerVerticallyByOffset(WebElement pointer, int yOffset) {
        actions.clickAndHold(pointer).moveByOffset(0, yOffset).build().perform();
    }

    public static void releasePointer(WebElement pointer) {
        actions.clickAndHold(pointer).release().perform();
    }

    //    Functions handling taking screenshot when testcase failed
    public static void takeScreenShot(String name) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

        File destFile = new File(String.format("target/screenshot-%s-%s.png", name, System.currentTimeMillis()));
        try {
            FileUtils.copyFile(srcFile, destFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}