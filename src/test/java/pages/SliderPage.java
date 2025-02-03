package pages;

import org.jspecify.annotations.Nullable;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BaseTest;

import java.time.Duration;

public class SliderPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private Actions actions;
    private final String pageUrl = "https://demoqa.com/slider";

    @FindBy(xpath = "//input[starts-with(@class, 'range-slider')]")
    private WebElement slider;

    @FindBy(id = "sliderValue")
    private WebElement sliderValueInput;

    public SliderPage() {
        this.driver = BaseTest.getDriver();
        if (driver == null) {
            throw new IllegalStateException("WebDriver is null in SliderPage!");
        }
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
        this.actions = new Actions(driver);
        System.out.println("SliderPage Initialized with WebDriver: " + driver);
    }

    public void openSliderPage(){
        driver.get(pageUrl);
    }

    public void clickSlider(){
        wait.until(ExpectedConditions.elementToBeClickable(slider));
        slider.click();
    }

    public  String getSliderValue(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js.executeScript("return arguments[0].value;", slider).toString();
    }

    public void verifySliderValue(String expectedValue) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.attributeToBe(sliderValueInput, "value", expectedValue));
        String actualValue = sliderValueInput.getAttribute("value");
        System.out.println("✅ Expected: " + expectedValue + ", Actual: " + actualValue);
        assert actualValue.equals(expectedValue) : "❌ Slider did not move to the expected value!";
    }

    public void verifyPageUrl(){
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals("The current URL is not correct.",pageUrl, currentUrl);
    }

    public void moveSliderToMin() {
        System.out.println("🔄 Moving slider to MIN (0)");
        int sliderWidth = slider.getSize().getWidth();// Get slider width
        actions.clickAndHold(slider)
                .moveByOffset(-sliderWidth / 2, 0) // Move to min position
                .release()
                .perform();

        verifySliderValue("0"); // Verify slider is at min
    }

    public void moveSliderToMax() {
        System.out.println("🔄 Moving slider to MAX (100)");
        int sliderWidth = slider.getSize().getWidth();  // Get slider width
        actions.clickAndHold(slider)
                .moveByOffset(sliderWidth / 2, 0) // Move to max position
                .release()
                .perform();

        verifySliderValue("100"); // Verify slider is at max
    }

    public void moveSliderWithKeyboard(){
        slider.sendKeys(Keys.ARROW_RIGHT);
    }
}
