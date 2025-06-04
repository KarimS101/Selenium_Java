package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class welcomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    public By selectRenters = By.xpath("//span[contains(text(),'renters')]");
    private By selectHome = By.xpath("//span[contains(text(),'home')]");
    private By selectCondo = By.xpath("//span[contains(text(),'condo')]");
    private By selectAuto = By.xpath("//span[contains(text(),'auto')]");
    private By enterZip = By.xpath("//input[@id='zipCodeInputEl']");
    private By startMyQuoteBtn = By.xpath("//button[@id='btnStart']");
    private By disableCookie = By.xpath("//button[contains(text(),'Continue')]");
    private By multiplePropertyError = By.xpath("//*[contains(text(),' You can only choose one property. Please try again.')]");
    private By enterYourZipError = By.xpath("//span[contains(text(),'Please enter your ZIP code.')]");
    private By enterAtLeastOneProductError = By.xpath("//*[contains(text(),' Please select at least one product to continue.')]");
    private By logIntoMyAccountLink = By.xpath("//*[contains(text(),'Log in to My Account')]");
    private By saveWhenYouBundle = By.xpath("//div[contains(text(),'Save up to 25% when you bundle*')]");

    public welcomePage(WebDriver driver ) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    private void type(By locator, String text) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.clear();
        element.sendKeys(text);
    }

    private boolean isVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
    }

    public void enterYourZipErrorMessage() {
        click(disableCookie);
        click(selectAuto);
        click(startMyQuoteBtn);
        isVisible(enterYourZipError);
    }

    public void welcomePageNavigation() {
        click(disableCookie);
        click(selectRenters);
        type(enterZip, "60025");
        click(startMyQuoteBtn);
    }

    public void welcomePageRenterHomeError() {
        click(disableCookie);
        click(selectRenters);
        click(selectHome);
        type(enterZip, "60025");
        click(startMyQuoteBtn);
        isVisible(multiplePropertyError);
    }

    public void welcomePageRenterCondoError() {
        click(disableCookie);
        click(selectRenters);
        click(selectCondo);
        type(enterZip, "60025");
        click(startMyQuoteBtn);
        isVisible(multiplePropertyError);
    }

    public void welcomePageAtLeastOneProductError() {
        click(disableCookie);
        click(startMyQuoteBtn);
        isVisible(enterAtLeastOneProductError);
    }

    public void myAccountLink() {
        click(disableCookie);
        click(logIntoMyAccountLink);
    }

    public void saveWhenBundleMessage() {
        click(disableCookie);
        click(selectAuto);
        click(selectHome);
        isVisible(saveWhenYouBundle);
    }

    public void enterAZipCode() {
        click(disableCookie);
        click(enterZip);
        type(enterZip, "60025");

    }

    public void selectRentersButton() {
        click(disableCookie);
        click(selectRenters);

    }
}
