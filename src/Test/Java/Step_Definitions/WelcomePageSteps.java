package Step_Definitions;

import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import Pages.welcomePage;

import org.junit.Assert;

public class WelcomePageSteps {

    WebDriver driver;
    welcomePage welcomePage;

    @Given("The User Navigates to ASC welcome Page" )
    public void launchApplication() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://purchase.allstate.com/onlineshopping/welcome");
        welcomePage = new welcomePage(driver);
    }

    @When("the user navigates with valid renters flow")
    public void navigateWithRentersFlow() {
        welcomePage.welcomePageNavigation();
    }

    @When("the user tries to continue without entering ZIP")
    public void tryWithoutZip() {
        welcomePage.enterYourZipErrorMessage();
    }

    @And("The user adds a Zip code")
    public void addZipCode() {
        welcomePage.enterAZipCode();
    }

    @When("the user selects both renters and home")
    public void selectRentersAndHome() {
        welcomePage.welcomePageRenterHomeError();
    }

    @When("the user selects both renters and condo")
    public void selectRentersAndCondo() {
        welcomePage.welcomePageRenterCondoError();
    }

    @When("The user selects Renters only")
    public void selectRenters() {
        welcomePage.selectRentersButton();
    }

    @When("the user tries to continue without selecting a product")
    public void noProductSelected() {
        welcomePage.welcomePageAtLeastOneProductError();
    }

    @When("the user clicks the login to my account link")
    public void clickMyAccount() {
        welcomePage.myAccountLink();
    }

    @Then("the user should see the bundle message")
    public void validateBundleMessage() {
        welcomePage.saveWhenBundleMessage();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
