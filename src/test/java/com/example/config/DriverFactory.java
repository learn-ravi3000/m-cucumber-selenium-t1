package com.example.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Locale;

public final class DriverFactory {

    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();

    private DriverFactory() {
    }

    public static void createDriver() {
        if (DRIVER.get() != null) {
            return;
        }

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        String chromeBinary = System.getProperty("chromeBinary", "").trim();
        if (!chromeBinary.isEmpty()) {
            options.setBinary(chromeBinary);
        }

        boolean linuxHost = System.getProperty("os.name", "").toLowerCase(Locale.ROOT).contains("linux");
        boolean headless = Boolean.parseBoolean(System.getProperty("headless", linuxHost ? "true" : "false"));

        if (headless) {
            options.addArguments("--headless=new", "--window-size=1920,1080");
        }

        DRIVER.set(new ChromeDriver(options));
    }

    public static WebDriver getDriver() {
        WebDriver driver = DRIVER.get();
        if (driver == null) {
            throw new IllegalStateException("Driver not initialized. Call createDriver() before getDriver().");
        }
        return driver;
    }

    public static void quitDriver() {
        WebDriver driver = DRIVER.get();
        if (driver != null) {
            driver.quit();
            DRIVER.remove();
        }
    }
}
