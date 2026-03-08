package com.example.pages;

import com.example.config.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExampleDomainPage {

    private static final String DEFAULT_BASE_URL = "https://example.com";

    private final WebDriver driver;
    private final WebDriverWait wait;

    public ExampleDomainPage() {
        this.driver = DriverFactory.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void open() {
        String baseUrl = System.getProperty("baseUrl", DEFAULT_BASE_URL);
        driver.get(baseUrl);
    }

    public String getHeadingText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1"))).getText().trim();
    }
}
