package com.kodilla.testing2.crudapp;

import com.kodilla.testing2.config.WebDriverConfig;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

@DisplayName("Integration tests for Crud App")
public class CrudAppTests {
    private static final String BASE_URL = "https://martkow.github.io";
    private WebDriver webDriver;
    private Random random;

    @BeforeEach
    void setUp() {
        webDriver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        webDriver.get(BASE_URL);

        random = new Random();
    }

    @AfterEach
    void cleanUp() {
        webDriver.close();
    }

    private String createTask() throws InterruptedException {
        String XPATH_TASK_TITLE = "//input[@name=\"title\"]";
        String XPATH_TASK_CONTENT = "//textarea[@name=\"content\"]";
        String XPATH_ADD_BUTTON = "//button[@class=\"datatable__button\"]";
        String taskName = "Task number " + random.nextInt(100000);            // [1]
        String taskContent = taskName + " content";

        webDriver.findElement(By.xpath(XPATH_TASK_TITLE)).sendKeys(taskName);
        webDriver.findElement(By.xpath(XPATH_TASK_CONTENT)).sendKeys(taskContent);
        webDriver.findElement(By.xpath(XPATH_ADD_BUTTON)).click();

        Thread.sleep(2000);

        return taskName;
    }

    private void sendTaskToTrello(String taskName) throws InterruptedException {
        webDriver.navigate().refresh(); // Refresh webpage

        // Waiting for the data "pulled" using AJAX technology to load. We wait until any select field appears on the page (this is the ComboBox used to select the Trello board).
        while(!webDriver.findElement(By.xpath("//select[1]")).isDisplayed());

        webDriver.findElements(
                        By.xpath("//form[@class=\"datatable__row\"]")).stream()
                .filter(anyForm ->
                        anyForm.findElement(By.xpath(".//p[@class=\"datatable__field-value\"]")) // XPath expression starts with a dot before the slashes, which means searching in the context of the current element (.//), rather than the entire web page.
                                .getText().equals(taskName))
                .forEach(theForm -> {
                    WebElement selectElement = theForm.findElement(By.xpath(".//select[1]"));
                    Select select = new Select(selectElement);
                    select.selectByIndex(1);

                    WebElement buttonCreateCard =
                            theForm.findElement(By.xpath(".//button[contains(@class, \"card-creation\")]"));
                    buttonCreateCard.click();
                });

        // Waiting for alert
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        // Switch to alert
        Alert alert = webDriver.switchTo().alert();
        // Get alert's content
        String alertText = alert.getText();
        System.out.println("Alert text: " + alertText);
        // Accept (click Close)
        alert.accept();

        Thread.sleep(5000);
    }

    private void deleteTask(String taskName) {
        webDriver.navigate().refresh(); // Refresh webpage

        while(!webDriver.findElement(By.xpath("//select[1]")).isDisplayed());

        webDriver.findElements(By.xpath("//form[@class=\"datatable__row\"]")).stream()
                .filter(anyForm -> anyForm.findElement(By.xpath(".//p[@class=\"datatable__field-value\"]"))
                            .getText().equals(taskName))
                .forEach(theForm -> {
                    theForm.findElement(By.xpath(".//button[@class=\"datatable__button\"]")).click();
                });
    }


    @Test
    void shouldCreateTask() throws InterruptedException {
        String taskName = createTask();
        sendTaskToTrello(taskName);
        deleteTask(taskName);
    }
}
