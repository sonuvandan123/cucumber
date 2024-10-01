package utils;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumDriver {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    private static ThreadLocal<WebDriverWait> waitDriver = new ThreadLocal<WebDriverWait>();
    public final static int TIMEOUT = 10;
    public final static int PAGE_LOAD_TIMEOUT = 5;

    private SeleniumDriver() {
        // Private constructor to prevent instantiation
    }

    public static void setUpDriver() {
        if (driver.get() == null) {
            WebDriver webDriver = new ChromeDriver();
            webDriver.manage().window().maximize();
            driver.set(webDriver);

            WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(TIMEOUT));
            waitDriver.set(webDriverWait);

            webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
            webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        }
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void openPage(String url) {
        getDriver().get(url);
    }

    public static void tearDown() {
        if (driver.get() != null) {
            getDriver().close();
            getDriver().quit();
            driver.remove();
            waitDriver.remove();
        }
    }
}
