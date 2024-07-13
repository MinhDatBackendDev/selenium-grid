package pageobjectmodel;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Open browser
 * <p>
 * Navigate to https://www.calculator.net/bmi-calculator.html
 * <p>
 * Select metric unit tab
 * <p>
 * Fill calculator with age, gender, weight, height
 * <p>
 * Validate result is correct
 */
public class BodyMassIndexPageTest {
    WebDriver driver;

    @BeforeClass
    void setUp() {
        driver = new ChromeDriver();
    }

    @BeforeMethod
    void openSite() {
        driver.get("https://www.calculator.net/bmi-calculator.html");
    }

    @Test
    void fillCalculator() {
        driver.findElement(By.xpath("//a[.='Metric Units']"));
        driver.findElement(By.xpath("//input[@value='Clear']")).click();
        driver.findElement(By.id("cage")).sendKeys("24");
        if (!driver.findElement(By.id("csex1")).isSelected()) {
            driver.findElement(By.id("csex1")).click();
        }
        driver.findElement(By.id("csex1")).click();
        driver.findElement(By.id("cheightmeter")).sendKeys("173");
        driver.findElement(By.id("ckg")).sendKeys("65");
        driver.findElement(By.xpath("//input[@value='Calculate']")).click();
    }

}
