package com.kodilla.testing2.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

/**
 * The WebDriverConfig class implements the "Factory" pattern. As an input parameter to the getDriver(String driver) method, it receives information about the browser type (using the CHROME constant and potentially other constants in the future - for other browsers) and, depending on the value of this parameter, returns an object of the class implementing the WebDriver interface in the Chrome browser variant (or others that you will put here in the future).
 */
public class WebDriverConfig {
    public final static String CHROME = "CHROME_DRIVER";
    public final static String SAFARI = "SAFARI_DRIVER";
    private static WebDriverManager webDriverManager;

    public static WebDriver getDriver(final String driver) {
        // We instruct Selenium WebDriver where the Chrome browser driver is located on the disk
//        System.setProperty("webdriver.chrome.driver", "/Users/markow/IdeaProjects/Module29/chromedriver_mac64/chromedriver");
        // Safari browser driver is already installed by default -> to activate safaridriver type in terminal: safaridriver --enable

        // Use WebDriverManager which automatically manages the appropriate version of WebDriver binaries.
        WebDriverManager.chromedriver().setup();

        if (driver.equals(CHROME)) {
            return new ChromeDriver();
        } else if (driver.equals(SAFARI)) {
            return new SafariDriver();
        } else {
            return null;
        }
    }
}
