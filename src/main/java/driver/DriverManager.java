package driver;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Optional;

import static org.openqa.selenium.chrome.ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY;

public class DriverManager {

    private static final int WAIT_TIMEOUT = 40;
    // Driver version 99.0.4844.51
    // Path to Chrome driver for Windows OS
    // private static final String CHROME_DRIVER_PATH = "./src/main/resources/chromedriver.exe";
    private static final String CHROME_DRIVER_PATH = "./src/main/resources/chromedriver";
    private static final Dimension CHROME_WINDOW_DIMENSIONS = new Dimension(1408, 1152);
    private static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();

    private DriverManager() {
    }

    public static void setupDriver() {
        WebDriver driver = getChromeDriver();
        driver.manage().window().setSize(CHROME_WINDOW_DIMENSIONS);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WAIT_TIMEOUT));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(WAIT_TIMEOUT));
        threadLocalDriver.set(driver);
    }

    private static ChromeDriver getChromeDriver() {
        System.setProperty(CHROME_DRIVER_EXE_PROPERTY, CHROME_DRIVER_PATH);
        return new ChromeDriver();
    }

    public static WebDriver getDriver() {
        return threadLocalDriver.get();
    }

    public static WebDriverWait getWebDriverWait() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        return wait;
    }

    public static void quitDriver() {
        Optional.ofNullable(getDriver()).ifPresent(driver -> {
            driver.quit();
            threadLocalDriver.remove();
        });
    }
}
