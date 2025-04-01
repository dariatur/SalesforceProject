package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactListPage extends BasePage{
    private static final String TABLE_XPATH = "//table";
    private static final String CONTACT_NAME_FIELD_XPATH = TABLE_XPATH + "//a[contains(@title, '%s')]";
    private static final String ACCOUNT_NAME_BY_CONTACT_NAME_XPATH = CONTACT_NAME_FIELD_XPATH + "/ancestor::tbody//td[3]//a";
    private static final String ACCOUNT_OWNER_BY_CONTACT_NAME_XPATH = CONTACT_NAME_FIELD_XPATH + "/ancestor::tbody//td[6]/span/span";

    public ContactListPage(WebDriver driver){
        super(driver);
    }

    public ContactListPage openPage(String url){
        driver.get(url);
        return this;
    }

    public String getExistContactName(String accountName) {
        return driver.findElement(By.xpath(String.format(CONTACT_NAME_FIELD_XPATH, accountName))).getText();
    }

    public String getAccountNameByContactName(String accountName) {
        return driver.findElement(By.xpath(String.format(ACCOUNT_NAME_BY_CONTACT_NAME_XPATH, accountName))).getText();
    }

    public String getExistAccountOwnerByContactName(String accountName) {
        return driver.findElement(By.xpath(String.format(ACCOUNT_OWNER_BY_CONTACT_NAME_XPATH, accountName))).getText();
    }

    public AccountPage clickOnContactName(String accountName){
        driver.findElement(By.xpath(String.format(CONTACT_NAME_FIELD_XPATH, accountName))).click();
        return new AccountPage(driver);
    }
}
