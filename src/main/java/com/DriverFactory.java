package com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
    static WebDriver driver;

    public static WebDriver setDriver() {
        return new ChromeDriver();
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = setDriver();
        }
        return driver;
    }
}
