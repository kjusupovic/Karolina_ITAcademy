package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static com.DriverFactory.getDriver;
import static com.Helpers.waitUntilVisible;
import static org.junit.Assert.assertTrue;

public class UserAddress {

    public static final String EMAIL = "adelajda@gmail.com";
    public static final String PASSWORD = "Kotek";

    @And("^I log in$")
    public void iLogIn() {
        getDriver().findElement(By.name("email")).sendKeys(EMAIL);
        getDriver().findElement(By.name("password")).sendKeys(PASSWORD);
        getDriver().findElement(By.id("submit-login")).click();
    }


    @And("^I choose to add new address$")
    public void iChooseToAddNewAddress() {
        getDriver().findElement(By.id("address-link")).click();
    }

    @And("^I fill address form$")
    public void iFillAddressForm() {
        getDriver().findElement(By.name("address1")).sendKeys("ul. Jednorożców 18");
        getDriver().findElement(By.name("postcode")).sendKeys("00-001");
        getDriver().findElement(By.name("city")).sendKeys("Warszawa");
        Select country = new Select(getDriver().findElement(By.name("id_country")));
        country.selectByValue("17");
    }

    @And("^I click save address$")
    public void iClickSaveAddress() {
        getDriver().findElement(By.xpath("//*[@id=\"content\"]/div/div/form/footer/button")).click();
    }

    @Then("^I can see I have added first address$")
    public void iCanSeeIHaveAddedFirstAddress() {
        WebElement addressAdded = getDriver().findElement(By.className("alert-success"));
        assertTrue(addressAdded.getText().contains("Address successfully added!"));
    }
}
