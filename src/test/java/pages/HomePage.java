package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BaseTest;

import java.time.Duration;

public class HomePage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final String pageUrl = "https://demoqa.com/";

    @FindBy(xpath = "//div[@class='category-cards']//h5[text()='Elements']")
    private WebElement elementsCard;

    @FindBy(xpath = "//div[@class='card-body']//h5[text()='Widgets']")
    private WebElement widgetsCard;

    @FindBy(xpath = "//div[@class='category-cards']//h5[text()='Forms']")
    private WebElement formsCard;

    @FindBy(xpath = "//div[@class='category-cards']//h5[text()='Alerts, Frame & Windows']")
    private WebElement alertsFrameWindowsCard;

    @FindBy(xpath = "//div[@class='category-cards']//h5[text()='Interactions']")
    private WebElement interactionsCard;

    @FindBy(xpath = "//div[@class='category-cards']//h5[text()='Book Store Application']")
    private WebElement bookStoreCard;

    public HomePage() {
        this.driver = BaseTest.getDriver();
        if (driver == null) {
            throw new IllegalStateException("WebDriver is null in HomePage!");
        }
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
        System.out.println("HomePage Initialized with WebDriver: " + driver);
    }

    public void openHomePage(){
        driver.get(pageUrl);
    }

    public void clickWidgetsCard() {
        try {
            System.out.println("🔄 Ensuring Widgets Card is visible...");
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",widgetsCard);

            System.out.println("⏳ Waiting for Widgets Card to be clickable...");
            wait.until(ExpectedConditions.visibilityOf(widgetsCard));
            wait.until(ExpectedConditions.elementToBeClickable(widgetsCard));

            System.out.println("✅ Clicking Widgets Card...");
            widgetsCard.click();

        } catch (Exception e) {
            System.out.println("❌ Normal click failed," + e.getMessage());
        }
    }


    public void clickFormsCard(){
        wait.until(ExpectedConditions.elementToBeClickable(formsCard));
        formsCard.click();
    }

    public void clickAlertsFrameWindowsCard(){
        wait.until(ExpectedConditions.elementToBeClickable(alertsFrameWindowsCard));
        alertsFrameWindowsCard.click();
    }

    public void clickInteractionsCard(){
        wait.until(ExpectedConditions.elementToBeClickable(interactionsCard));
        interactionsCard.click();
    }

    public void clickBookStoreCard(){
        wait.until(ExpectedConditions.elementToBeClickable(bookStoreCard));
        bookStoreCard.click();
    }
}