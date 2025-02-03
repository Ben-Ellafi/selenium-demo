package stepDefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.SliderPage;
import pages.WidgetPage;
import pages.HomePage;
import utils.BaseTest;

public class WidgetSteps extends BaseTest {
    private HomePage homePage;
    private WidgetPage widgetPage;
    private SliderPage sliderPage;

    @Given("I open the home page")
    public void iOpenTheHomePage() {
        System.out.println("🔄 Initializing HomePage in WidgetSteps...");
        homePage = new HomePage();
        homePage.openHomePage();
        System.out.println("✅ HomePage successfully initialized.");
    }

    @Given("I open the widget page")
    public void iOpenTheWidgetPage() {
        System.out.println("🔄 Initializing WidgetPage in WidgetSteps...");
        widgetPage = new WidgetPage();
        widgetPage.openWidgetPage();
        System.out.println("✅ WidgetPage successfully initialized.");
    }

    @Given("I open the slider page")
    public void iOpenTheSliderPage() {
        System.out.println("🔄 Initializing SliderPage in WidgetSteps...");
        sliderPage = new SliderPage();
        sliderPage.openSliderPage();
        System.out.println("✅ SliderPage successfully initialized.");
    }

    @When("I click the widget card")
    public void iClickTheWidgetCard() {
        System.out.println("🛠️ Executing `clickWidgetsCard()`...");
        homePage.clickWidgetsCard();
        System.out.println("✅ `clickWidgetsCard()` executed successfully.");
    }

    @When("I click the slider button")
    public void iClickTheSliderButton() {
        System.out.println("🛠️ Executing `clickSliderButton()`...");
        widgetPage.clickSliderButton();
        System.out.println("✅ `clickSliderButton()` executed successfully.");
    }

    @When("I press the right arrow key {int} times")
    public void iPressTheRightArrowKeyTimes(int times) {
        System.out.println("🔄 Pressing right arrow key " + times + " times...");
        sliderPage.clickSlider();
        for (int i = 0; i < times; i++) {
            sliderPage.moveSliderWithKeyboard();
        }
    }

    @Then("I am taken to the widget page")
    public void iAmTakenToTheWidgetPage() {
        if (widgetPage == null) {
            System.out.println("🚨 WidgetPage is null! Initializing it now...");
            widgetPage = new WidgetPage();
        }
        System.out.println("🔍 Verifying Widget Page URL...");
        widgetPage.verifyPageUrl();
        System.out.println("✅ Widget Page URL Verified!");
    }

    @Then("The slider value is {string}")
    public void theSliderValueIs(String value) {
        String actualValue = sliderPage.getSliderValue();
        Assert.assertEquals("The current slider value does not match the value provided.",value, actualValue);
    }

    @Then("I am taken to the slider page")
    public void iAmTakenToTheSliderPage() {
        if (sliderPage == null) {
            System.out.println("🚨 SliderPage is null! Initializing it now...");
            sliderPage = new SliderPage();
        }
        System.out.println("🔍 Verifying Slider Page URL...");
        sliderPage.verifyPageUrl();
        System.out.println("✅ Slider Page URL Verified!");
    }

    @Then("I move the slider to the minimum value")
    public void iMoveTheSliderToMin() {
        sliderPage.moveSliderToMin();
    }

    @Then("I move the slider to the maximum value")
    public void iMoveTheSliderToMax() {
        sliderPage.moveSliderToMax();
    }

    @Then("the slider value should be {string}")
    public void theSliderValueShouldBe(String value) {
        sliderPage.verifySliderValue(value);
    }
}
