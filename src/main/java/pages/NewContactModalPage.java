package pages;

import elements.Button;
import elements.Dropdown;
import elements.Input;
import entity.Account;
import entity.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewContactModalPage extends BasePage{
    @FindBy(xpath = "//button[@name=\"SaveEdit\"]")
    public WebElement saveButton;

    @FindBy(xpath = "/button[@name=\"SaveAndNew\"]")
    public WebElement saveAndNewButton;

    @FindBy(xpath = "/button[@name=\"CancelEdit\"]")
    public WebElement cancelButton;

    public NewContactModalPage(WebDriver driver){
        super(driver);
    }

    public NewContactModalPage openPage(String url){
        driver.get(url);
        return this;
    }

    public void createNewContact(Contact contact){
        new Dropdown(driver, "Salutation").accountSelectOption(contact.getSalutation());
        new Input(driver, "Last Name").writeTextToInput(contact.getLastName());
        new Input(driver, "Account Name").writeTextToInput(contact.getAccountName());
        driver.findElement(By.xpath("//*[@id=\"dropdown-element-114\"]/ul/li[1]")).click();
        new Button(driver).clickButton(saveButton);
    }
}
