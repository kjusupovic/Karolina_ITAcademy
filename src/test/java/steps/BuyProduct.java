package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.DriverFactory.getDriver;
import static com.Helpers.*;
import static org.junit.Assert.assertTrue;

public class BuyProduct {
    @And("^I navigate to accessories$")
    public void iNavigateToAccessories() {
        getElement(By.id("category-6")).click();
    }

    @And("^I choose Mountain Fox Cushion$")
    public void iChooseMountainFoxCushion() {
        getElement(By.xpath("//*[@id=\"js-product-list\"]/div[1]/article[5]/div/a/img")).click();
    }

    @And("^I choose black color$")
    public void iChooseBlackColor() {
        getElements(By.className("input-color")).get(1).click();
    }

    @And("^I add two cushions to cart$")
    public void iAddTwoCushionsToCart() throws InterruptedException {
        Thread.sleep(2000);
        getElement(By.id("quantity_wanted")).clear();

        getElement(By.id("quantity_wanted")).sendKeys("2");
        getWait().until(ExpectedConditions.elementToBeClickable(By.className("add-to-cart")));
        getElement(By.className("add-to-cart")).click();
    }

    @And("^I go to cart$")
    public void iGoToCart() {
        getWait().until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[1]/button")));
        getElement(By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[1]/button")).click();
        getElement(By.xpath("//*[@id=\"_desktop_cart\"]/div/div/a")).click();
    }

    @And("^I can see I have two cushions in my cart$")
    public void iCanSeeIHaveTwoCushionsInMyCart() {
        String quantityInBasket = getElement(By.name("product-quantity-spin")).getAttribute("value");
        assertTrue(quantityInBasket.equals("2"));

    }

    @And("^I remove one cushion from cart$")
    public void iRemoveOneCushionFromCart() {
        getElement(By.xpath("//*[@id=\"main\"]/div/div[1]/div/div[2]/ul/li/div/div[3]/div/div[2]/div/div[1]/div/span[3]/button[2]")).click();
    }

    @And("^I finish my purchase$")
    public void iFinishMyPurchase() {
        getElement(By.xpath("//*[@id=\"main\"]/div/div[2]/div[1]/div[2]/div/a")).click();
        getElement(By.className("btn-primary")).click();
        getElement(By.xpath("//*[@id=\"js-delivery\"]/button")).click();
//        getWait().until(ExpectedConditions.elementToBeClickable(By.id("payment-option-2")));
        getElement(By.id("payment-option-2")).click();
        getElement(By.id("conditions_to_approve[terms-and-conditions]")).click();
        getWait().until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"payment-confirmation\"]/div[1]/button")));
        getElement(By.xpath("//*[@id=\"payment-confirmation\"]/div[1]/button")).click();
    }

    @Then("^I can see my order is confirmed$")
    public void iCanSeeMyOrderIsConfirmed() {
        getWait().until(ExpectedConditions.presenceOfElementLocated(By.className("h1")));
        WebElement orderConfirmation = getElement(By.xpath("//*[@id=\"content-hook_order_confirmation\"]/div/div/div/h3"));
        assertTrue(orderConfirmation.getText().contains("Your order is confirmed"));
    }
}
