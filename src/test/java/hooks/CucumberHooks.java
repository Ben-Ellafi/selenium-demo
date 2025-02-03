package hooks;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.BaseTest;
import org.openqa.selenium.WebDriver;

import static utils.BaseTest.getDriver;

public class CucumberHooks {
    private WebDriver driver;

    // Ensure WebDriver is initialized before each scenario
    @Before
    public void beforeScenario(Scenario scenario) {
        System.out.println("Before Scenario: " + scenario.getName());
        driver = getDriver(); // Retrieve WebDriver from BaseTest
    }

    // Quit WebDriver after each scenario
    @After
    public void afterScenario(Scenario scenario) {
        System.out.println("After Scenario: " + scenario.getName());
        BaseTest.quitDriver(); // Ensure WebDriver is closed after each test
    }
}
