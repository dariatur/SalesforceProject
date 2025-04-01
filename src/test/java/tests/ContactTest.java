package tests;

import entity.Account;
import entity.Contact;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Random;

public class ContactTest extends BaseTest {

    @Test
    public void createContactTest(){
        Contact contact = new Contact();
        contact.setSalutation("Mrs.");
        contact.setLastName("Tur");
        contact.setAccountName("account3");

        loginPage.openPage(LOGIN_URL)
                .login(username, password);
        newContactModalPage.openPage(NEW_CONTACT_URL)
                .createNewContact(contact);
        contactListPage.openPage(CONTACT_LIST_URL);
        Assert.assertEquals(contactListPage.getExistContactName(contact.getLastName()), contact.getLastName());
        Assert.assertEquals(contactListPage.getAccountNameByContactName(contact.getAccountName()), contact.getAccountName());
    }

    @Test
    public void checkCreatedContact(){
        loginPage.openPage(LOGIN_URL)
                .login(username, password);
        contactListPage.openPage(CONTACT_LIST_URL)
                .clickOnContactName("Tur");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(contactPage.getFieldValueByName("Name"), "Mrs. Tur");
        softAssert.assertEquals(contactPage.getAccountName(), "account3");
        softAssert.assertAll();
    }
}
