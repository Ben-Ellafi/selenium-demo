package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Before;
import org.junit.After;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            System.out.println("Initializing WebDriver...");
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            if (System.getenv("CI") != null) { // Only in GitHub Actions
                options.addArguments("--headless");
                options.addArguments("--disable-gpu");
            }
            options.addArguments("--no-sandbox");  // Helps prevent permission issues
            options.addArguments("--disable-dev-shm-usage");  // Prevents shared memory issues
            driver = new ChromeDriver(options);
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
