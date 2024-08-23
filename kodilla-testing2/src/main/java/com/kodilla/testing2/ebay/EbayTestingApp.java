package com.kodilla.testing2.ebay;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EbayTestingApp {
    private static final String SEARCH_PHRASE = "Laptop";

    public static void main(String[] args) {
        WebDriver driverChrome = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driverChrome.get("https://www.ebay.com/");

        WebElement webElementSearchField = driverChrome.findElement(By.id("gh-ac"));
        webElementSearchField.sendKeys(SEARCH_PHRASE);

        WebElement webElementSubmitButton = driverChrome.findElement(By.id("gh-btn"));
        webElementSubmitButton.click();
    }
}
