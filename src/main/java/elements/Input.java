package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Input {
    private WebDriver driver;
    private String label;
    private WebDriverWait wait;
    private static final String INPUT_XPATH = "//label[text()='%s']/ancestor::div[1]//input";
    private static final String TEXTAREA_XPATH = "//*[contains(text(), '%s')]/ancestor::*[contains(@slot, \"inputField\")]//textarea";


    public Input(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void writeTextToInput(String text) {
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(String.format(INPUT_XPATH, label))))).sendKeys(text);
    }

    public void writeTextToTextarea(String text) {
        driver.findElement(By.xpath(String.format(TEXTAREA_XPATH, label))).sendKeys(text);
    }
}
