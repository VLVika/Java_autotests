package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void sabmitContactCreation() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void fillingFieldsNewContact(ContactData contactData) {
        type(By.name("firstname"), contactData.getName());
        click(By.name("lastname"));
        type(By.name("lastname"), contactData.getSername());
        type(By.name("nickname"), contactData.getNikename());
        type(By.name("mobile"), contactData.getPhone());
        type(By.name("email"), contactData.getMail());
    }

    public void clickButtonNewContact() {
        click(By.linkText("add new"));
    }
}
