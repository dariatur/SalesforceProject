package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Dropdown {
    private WebDriver driver;
    private String label;
    private WebDriverWait wait;
    private static final String ACCOUNT_DROPDOWN_XPATH = "//*[contains(text(), '%s') and @part='label']/ancestor::div[1]//button";
    private static final String ACCOUNT_DROPDOWN_OPTION_XPATH = "//*[contains(@data-value, '%s')]";

    public Dropdown(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void accountSelectOption(String option) {
        driver.findElement(By.xpath(String.format(ACCOUNT_DROPDOWN_XPATH, label))).click();
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(String.format(ACCOUNT_DROPDOWN_OPTION_XPATH, option))))).click();
    }
}
