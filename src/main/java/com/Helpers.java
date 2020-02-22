package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static com.DriverFactory.getDriver;

public class Helpers {
    private WebDriverWait wait;

    public static WebDriverWait getWait() {
        return new WebDriverWait(getDriver(), 15);
    }

    public static void waitUntilVisible(By locator) {
        getWait().until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public static WebElement getElement(By locator) {
        return getDriver().findElement(locator);
    }

    public static List<WebElement> getElements(By locator) {
        return getDriver().findElements(locator);
    }
}
