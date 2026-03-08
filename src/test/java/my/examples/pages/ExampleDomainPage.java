package my.examples.pages;

import my.examples.config.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class ExampleDomainPage {

    private static final String DEFAULT_BASE_URL = "https://www.homedepot.com/";

    private static final List<By> SEARCH_INPUT_LOCATORS = Arrays.asList(
            By.id("headerSearch"),
            By.cssSelector("input[data-testid='headerSearch']"),
            By.name("keyword"),
            By.cssSelector("input[type='search']")
    );

    private final WebDriver driver;
    private final WebDriverWait wait;

    public ExampleDomainPage() {
        this.driver = DriverFactory.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void openHomeDepotHomePage() {
        String baseUrl = System.getProperty("baseUrl", DEFAULT_BASE_URL);
        driver.get(baseUrl);
    }

    public void searchFor(String searchTerm) {
        WebElement searchInput = findSearchInput();
        searchInput.click();
        searchInput.clear();
        searchInput.sendKeys(searchTerm);
        searchInput.sendKeys(Keys.ENTER);
    }

    public boolean isSearchTermReflected(String searchTerm) {
        String expected = searchTerm.toLowerCase(Locale.ROOT).trim();
        String expectedDash = expected.replace(" ", "-");
        String expectedPlus = expected.replace(" ", "+");

        try {
            wait.until(ExpectedConditions.or(
                    ExpectedConditions.urlContains("/s/"),
                    ExpectedConditions.urlContains(expected),
                    ExpectedConditions.urlContains(expectedDash),
                    ExpectedConditions.urlContains(expectedPlus)
            ));
        } catch (Exception ignored) {
            return false;
        }

        String currentUrl = driver.getCurrentUrl().toLowerCase(Locale.ROOT);
        return currentUrl.contains("/s/")
                && (currentUrl.contains(expected)
                || currentUrl.contains(expectedDash)
                || currentUrl.contains(expectedPlus));
    }

    private WebElement findSearchInput() {
        for (By locator : SEARCH_INPUT_LOCATORS) {
            try {
                return wait.until(ExpectedConditions.elementToBeClickable(locator));
            } catch (Exception ignored) {
                // Try the next known selector.
            }
        }

        throw new IllegalStateException("Unable to locate Home Depot search input with known selectors.");
    }
}
