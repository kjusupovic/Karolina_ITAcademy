package steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.DriverFactory.getDriver;
import static com.Helpers.*;
import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MyStore {

    private static final By FIRST_NAME = By.name("firstname");
    private String randomEmail = randomNumeric(6) + "_pietaszek@gmail.com";

    @Before
    public void setUp() {
        chromedriver().setup();
    }

    @Given("^Navigate to shop page$")
    public void navigateToShopPage() {
        getDriver().get("https://prod-kurs.coderslab.pl/index.php");
    }

    @When("^I click Sign in$")
    public void iClickSignIn() {

        getDriver().findElement(By.className("user-info")).click();
    }

    @And("^I click Create an account$")
    public void iClickCreateAnAccount() {

        getDriver().findElement(By.partialLinkText("Create one here")).click();
    }

    @And("^I fill a form$")
    public void iFillAForm() {
        getDriver().findElements(By.className("custom-radio")).get(1).click();
        getElement(FIRST_NAME).sendKeys("Adelajda");
        getElement(By.name("lastname")).sendKeys("Piętaszek");
        getElement(By.name("email")).sendKeys(randomEmail);
        getElement(By.name("password")).sendKeys("Kotek");
        getElement(By.name("birthday")).sendKeys("04/25/1999");
    }

    @And("^I click save$")
    public void iClickSave() {
        getDriver().findElement(By.className("form-control-submit")).click();
    }

    @Then("^I can see I am logged in$")
    public void iCanSeeIAmLoggedIn() {
        WebElement account = getDriver().findElement(By.className("account"));
        assertTrue(account.getText().contains("Adelajda Piętaszek"));
        WebElement sign = getDriver().findElement(By.className("logout"));
        assertTrue(sign.getText().contains("Sign out"));
        assertFalse(sign.getText().contains("Sign in"));
    }


    @After
    public void tearDown() {
        getDriver().quit();

    }


}
