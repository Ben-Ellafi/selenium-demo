package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Before;
import org.junit.After;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            System.out.println("Initializing WebDriver...");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            System.out.println("WebDriver Initialized!");
        }
        return driver;
    }

    // Close WebDriver properly
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;  // Reset WebDriver instance for next test
            System.out.println("WebDriver Closed!");
        }
    }
}
