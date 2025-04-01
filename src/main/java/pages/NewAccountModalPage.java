package pages;

import elements.Button;
import elements.Dropdown;
import elements.Input;
import entity.Account;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewAccountModalPage extends BasePage {

    @FindBy(xpath = "//button[@name=\"SaveEdit\"]")
    public WebElement saveButton;

    @FindBy(xpath = "/button[@name=\"SaveAndNew\"]")
    public WebElement saveAndNewButton;

    @FindBy(xpath = "/button[@name=\"CancelEdit\"]")
    public WebElement cancelButton;

    public NewAccountModalPage(WebDriver driver){
        super(driver);
    }

    public NewAccountModalPage openPage(String url){
        driver.get(url);
        return this;
    }

    public void createNewAccount(Account account){
        new Input(driver, "Account Name").writeTextToInput(account.getAccountName());
        new Input(driver, "Website").writeTextToInput(account.getWebSite());
        new Dropdown(driver, "Type").accountSelectOption(account.getType());
        new Input(driver, "Description").writeTextToTextarea(account.getDescription());
        new Input(driver, "Phone").writeTextToInput(account.getPhone());
        new Button(driver).clickButton(saveButton);
    }
}
