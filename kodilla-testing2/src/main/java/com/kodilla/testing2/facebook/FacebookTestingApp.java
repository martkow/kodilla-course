package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FacebookTestingApp {
    private final static String XPATH_ALOW_ALL_COOKIES = "//span[@class=\"x193iq5w xeuugli x13faqbe x1vvkbs xlh3980 xvmahel x1n0sxbx x1lliihq x1s928wv xhkezso x1gmr53x x1cpjm7i x1fgarty x1943h6x x4zkp8e x3x7a5m x6prxxf xvq8zen x1s688f xtk6v10\"]";
    private final static String XPATH_OPEN_REGISTRATION_FORM_BUTTON = "//a[@data-testid=\"open-registration-form-button\"]";
    private final static String XPATH_DAY = "//select[@id=\"day\"]";
    private final static String XPATH_MONTH = "//select[@id=\"month\"]";
    private final static String XPATH_YEAR = "//select[@id=\"year\"]";

    public static void main(String[] args) {
        WebDriver webDriver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        webDriver.get("https://www.facebook.com/");

        WebElement allowAllCookiesButton = webDriver.findElement(By.xpath(XPATH_ALOW_ALL_COOKIES));
        allowAllCookiesButton.click();

        WebElement openRegistrationFormButton = webDriver.findElement(By.xpath(XPATH_OPEN_REGISTRATION_FORM_BUTTON));
        openRegistrationFormButton.click();

        // Wait until field will be displayed - 10s
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        WebElement day = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XPATH_DAY)));
        // Select day
        Select selectDay = new Select(day);
        selectDay.selectByIndex(0);

        WebElement month = webDriver.findElement(By.xpath(XPATH_MONTH));
        Select selectMonth = new Select(month);
        selectMonth.selectByIndex(0);

        WebElement year = webDriver.findElement(By.xpath(XPATH_YEAR));
        Select selectYear = new Select(year);
        selectYear.selectByIndex(17);
    }
}
