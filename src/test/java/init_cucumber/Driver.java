package init_cucumber;

import exception.CouldNotCreateDriverException;
import exception.ElementNotFoundException;
import exception.WebsiteNotFoundException;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.*;
import setup.Selenium;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class Driver {
    static WebDriver driver;
    public static void startChromeBrowser(String website) throws Exception{
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        try {
            driver = new ChromeDriver(options);
            driver.get(getWebsiteUrl(website));
        } catch (Exception e) {
            throw new CouldNotCreateDriverException(e);
        }
    }

    public static void closeChromeDriver() {
        if(driver != null) {
            driver.close();
            driver.quit();
        }
    }

    public static WebElement getElementByXpath(String xpath) throws ElementNotFoundException {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                        .withTimeout(Duration.ofSeconds(Selenium.TIMEOUT))
                        .pollingEvery(Duration.ofSeconds(Selenium.POLLING))
                        .ignoring(NoSuchElementException.class);

        try {
            wait.until(ExpectedConditions.and(presenceOfElementLocated(By.xpath(xpath)),
                    visibilityOfElementLocated(By.xpath(xpath))));

            return driver.findElement(By.xpath(xpath));
        } catch (Exception e) {
            throw new ElementNotFoundException(xpath);
        }

    }

    private static String getWebsiteUrl(String website) throws WebsiteNotFoundException {
        switch (website) {
            case "google":
                return "https://www.google.com";
            case "linkedin":
                return "https://www.linkedin.com";
            default:
                throw new WebsiteNotFoundException(website);
        }
    }

}
