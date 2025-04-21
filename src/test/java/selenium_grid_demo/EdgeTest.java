package selenium_grid_demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class EdgeTest {

    @Test
    public void EdgeTestMethod01() throws MalformedURLException {
        System.out.println("Initializing the Microsoft Edge driver");
        EdgeOptions edgeOptions = new EdgeOptions();
        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444"), edgeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //Initialize the Edge driver
        System.out.println("The thread ID for Edge is " + Thread.currentThread().getId());
        driver.get("https://anhtester.com");
        driver.findElement(By.xpath("//h3[normalize-space()='Mobile Testing']")).click();
        driver.quit();
    }

    @Test
    public void EdgeTestMethod02() throws MalformedURLException {
        System.out.println("Initializing the Microsoft Edge driver");
        EdgeOptions edgeOptions = new EdgeOptions();
        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444"), edgeOptions);        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //Initialize the Edge driver
        System.out.println("The thread ID for Edge is " + Thread.currentThread().getId());
        driver.get("https://anhtester.com");
        driver.findElement(By.xpath("//h3[normalize-space()='Desktop Testing']")).click();
        driver.quit();
    }

}
