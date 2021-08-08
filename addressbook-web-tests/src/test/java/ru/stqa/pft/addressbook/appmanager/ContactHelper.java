package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

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

    public void buttonEditContact(int index) {
        wd.findElements(By.xpath("//td[@class = 'center']//*[@title = 'Edit']")).get(index).click();
  //      wd.findElements(By.name("(//td[@class = 'center']//*[@title = 'Edit'])[1]")).get(index).click();
 //   click(By.xpath("(//td[@class = 'center']//*[@title = 'Edit'])[1]"));
    }

    public void buttonUpdateContact() {
        click(By.name("update"));
    }

    public void checkboxContact(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();


    }

    public void buttonDeleteContact() {
    click(By.xpath("//div[@class = 'left'][2]"));

    }

    public void alertmessage() {
        wd.switchTo().alert().accept();
        wd.findElement(By.cssSelector("div.msgbox"));
    }

    public void waitSecond() {
        WebDriverWait wait = new WebDriverWait(wd, 10);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("maintable")));

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

    public void modifyGroup(int index, ContactData newcontact) {
        buttonEditContact(index);
        fillingFieldsNewContact(newcontact, false);
        buttonUpdateContact();
        goToHomePage();
    }






    public boolean chekingContact() {
        return isElementPresent(By.xpath("(//td[@class = 'center']//*[@title = 'Edit'])[1]"));
  //      return isElementPresent(By.name("selected[]"));
    }

    public int getContactCount() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public List<ContactData> getContactList() {
        List<ContactData> contacts = new ArrayList<ContactData>();
        List<WebElement> sernames = wd.findElements(By.cssSelector("tr[name=\"entry\"]"));
        for (WebElement element: sernames) {
            List<WebElement> cells = element.findElements(By.tagName("td"));
            String sername = cells.get(1).getText();
            String name = cells.get(2).getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            ContactData contact = new ContactData(id, name, sername, null, null, null, null);
            contacts.add(contact);
        }
        return contacts;
    }
}

