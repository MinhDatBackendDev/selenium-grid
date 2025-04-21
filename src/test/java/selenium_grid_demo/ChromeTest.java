package selenium_grid_demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class ChromeTest {

    @Test
    public void ChromeTestMethod01() throws MalformedURLException {
        System.out.println("Initializing the Google Chrome Driver");
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444"), chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //Initialize the chrome driver
        System.out.println("The thread ID for Chrome is " + Thread.currentThread().getId());
        driver.get("https://anhtester.com");
        driver.findElement(By.xpath("//h3[normalize-space()='Website Testing']")).click();
        driver.quit();
    }

    @Test
    public void ChromeTestMethod02() throws MalformedURLException {
        System.out.println("Initializing the Google Chrome Driver");
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444"), chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //Initialize the chrome driver
        System.out.println("The thread ID for Chrome is " + Thread.currentThread().getId());
        driver.get("https://anhtester.com");
        driver.findElement(By.xpath("//h3[normalize-space()='API Testing']")).click();
        driver.quit();
    }

}
