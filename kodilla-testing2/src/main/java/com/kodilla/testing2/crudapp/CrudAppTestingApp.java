package com.kodilla.testing2.crudapp;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CrudAppTestingApp {
    private final static String XPATH_INPUT = "//html/body/main/section/form/fieldset/input";
    private final static String XPATH_TEXTAREA = "//html/body/main/section/form/fieldset[2]/textarea";
    private final static String XPATH_WAIT_FOR_SELECT = "//select[1]";
    public static final String XPATH_SELECT = "//div[contains(@class, \"tasks-container\")]/form/div/fieldset/select[1]";

    public static void main(String[] args) {
        WebDriver webDriver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        webDriver.get("https://martkow.github.io");

        WebElement searchField = webDriver.findElement(By.xpath(XPATH_INPUT));
        searchField.sendKeys("New robotic task");

        WebElement textareaField = webDriver.findElement(By.xpath(XPATH_TEXTAREA));
        textareaField.sendKeys("The robotic content");

        while (!webDriver.findElement(By.xpath(XPATH_WAIT_FOR_SELECT)).isDisplayed()); // Waiting until element is displayed

        WebElement selectCombo = webDriver.findElement(By.xpath(XPATH_SELECT)); // Field of type Dropdown; ComboBox
        Select selectBoard = new Select(selectCombo);
        selectBoard.selectByIndex(1);
    }
}
