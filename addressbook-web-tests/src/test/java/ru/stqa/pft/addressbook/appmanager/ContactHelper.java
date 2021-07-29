package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void sabmitContactCreation() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void fillingFieldsNewContact(ContactData contactData, boolean creation) {
        type(By.name("firstname"), contactData.getName());
        click(By.name("lastname"));
        type(By.name("lastname"), contactData.getSername());
        type(By.name("nickname"), contactData.getNikename());
        type(By.name("mobile"), contactData.getPhone());
        type(By.name("email"), contactData.getMail());

        if(creation){
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new group")));
        }

    }


    public void clickButtonNewContact() {
        click(By.linkText("add new"));
    }

    public void buttonEditContact() {
    click(By.xpath("(//td[@class = 'center']//*[@title = 'Edit'])[1]"));
    }

    public void buttonUpdateContact() {
    click(By.name("update"));
    }

    public void checkboxContact() {
    click(By.name("selected[]"));

    }

    public void buttonDeleteContact() {
    click(By.xpath("//div[@class = 'left'][2]"));

    }

    public void alertmessage() {
        wd.switchTo().alert().accept();
    }


    public void goToHomePage() {
        if(isElementPresent(By.id("maintable"))){
            return;
        }
        click(By.linkText("home page"));
    }


    public void createContact(ContactData contact, boolean groupField) {
        clickButtonNewContact();
        fillingFieldsNewContact(contact, groupField);
        sabmitContactCreation();
        goToHomePage();
    }

    public boolean chekingContact() {
        return isElementPresent(By.xpath("(//td[@class = 'center']//*[@title = 'Edit'])[1]"));
  //      return isElementPresent(By.name("selected[]"));
    }
}
