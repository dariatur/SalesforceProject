package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage extends BasePage{
    private static final String DATA_BY_FIELD_NAME_XPATH = "//*[@class='record-body-container']//*[text()='%s']//following::lightning-formatted-text[1]";
    private static final String DATA_WITH_LINK_BY_FIELD_NAME_XPATH = "//*[@class='record-body-container']//*[text()='%s']//following::a";

    public AccountPage(WebDriver driver){
        super(driver);
    }

    public String getFieldValueByName(String name){
        return driver.findElement(By.xpath(String.format(DATA_BY_FIELD_NAME_XPATH, name))).getText();
    }

    public String getDataWithLinkByFieldNameXpath(String name){
        return driver.findElement(By.xpath(String.format(DATA_WITH_LINK_BY_FIELD_NAME_XPATH, name))).getText();
    }
}
