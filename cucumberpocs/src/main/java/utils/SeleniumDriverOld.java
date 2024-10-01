package utils;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumDriverOld {

    // Use explicit type parameters for older Java versions
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    private static ThreadLocal<WebDriverWait> waitDriver = new ThreadLocal<WebDriverWait>();
    
    public final static int TIMEOUT = 3;
    public final static int PAGE_LOAD_TIMEOUT = 5;

    private SeleniumDriverOld() {
        // Private constructor to prevent instantiation
    }

    public static void setUpDriver() {
        if (driver.get() == null) {
            // Initialize the WebDriver for the current thread
            WebDriver webDriver = new ChromeDriver(); // Or FirefoxDriver() based on your requirement
            webDriver.manage().window().maximize();
            webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
            
            driver.set(webDriver);
            waitDriver.set(new WebDriverWait(webDriver, Duration.ofSeconds(TIMEOUT)));
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
            driver.get().quit();
            driver.remove();
            waitDriver.remove();
        }
    }

    public static void waitForPageToLoad() {
        try {
            Thread.sleep(5000); // Not the best practice, but keeping it as per the original code
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
