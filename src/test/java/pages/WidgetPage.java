package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BaseTest;

import java.time.Duration;

public class WidgetPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final String pageUrl = "https://demoqa.com/widgets";

    @FindBy(xpath = "//ul[@class='menu-list']//span[text()='Slider']")
    private WebElement sliderButton;

    public WidgetPage() {
        this.driver = BaseTest.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
        System.out.println("HomePage Initialized with WebDriver: " + driver);
    }

    public void openWidgetPage() {
        driver.get(pageUrl);
    }

    public void clickSliderButton() {
        wait.until(ExpectedConditions.elementToBeClickable(sliderButton));
        sliderButton.click();
    }

    public void verifyPageUrl(){
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals("The current URL is not correct.",pageUrl, currentUrl);
    }
}