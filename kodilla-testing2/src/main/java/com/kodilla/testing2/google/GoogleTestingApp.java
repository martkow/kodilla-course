package com.kodilla.testing2.google;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

/**
 * WebDriver = Sterownik Przeglądarki<br><br>
 * In line [1], we define a constant named SEARCH_FIELD that holds the identifier of the input field on the page. This field is a control used for entering the text to search on the internet.<br><br>
 * In lines [2]-[3], we create a {@code Selenium WebDriver} instance and open the Google page.<br><br>
 * Line [4] contains a string. It's used to bypass the pop-up window asking for acceptance of Google's terms and conditions.<br><br>
 * Line [5] involves calling the {@code findElement(By by)} method. It returns an element of type {@code WebElement} based on various search criteria: name, identifier, class, CSS selector, XPath expression, and others. In our case, we are using the identifier of the input field from the webpage.
 * The {@code By} class has a number of static methods that are used to identify controls in different ways.<br><br>
 * In line [6], we send simulated keystrokes to the found WebElement – we enter the search term, which is the word "Kodilla", into this field.<br><br>
 * In line [7], we confirm the entered text (i.e. simulate pressing the Enter button in the search field)
 */
public class GoogleTestingApp {
    public static final String SEARCH_FIELD = "q"; // [1]

    public static void main(String[] args) throws InterruptedException {
        // We create a driver object. Then we call its get(String url) method, which starts the browser and goes to the specified website address.
        WebDriver driverChrome = WebDriverConfig.getDriver(WebDriverConfig.CHROME); // [2]
        driverChrome.get("https://www.google.com");  // [3]
        Thread.sleep(5000);
        driverChrome.findElement(By.xpath("//*[@id=\"L2AGLb\"]/div")).click(); // [4]

         WebElement searchField = driverChrome.findElement(By.name(SEARCH_FIELD));      // [5]
         searchField.sendKeys("Kodilla");  // [6]
         searchField.submit(); // [7]

//        WebDriver driverSafari = WebDriverConfig.getDriver(WebDriverConfig.SAFARI);
//        driverSafari.get("https://www.google.com");
    }
}
