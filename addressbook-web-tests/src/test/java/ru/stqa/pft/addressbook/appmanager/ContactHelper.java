package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.List;


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
        attach(By.name("photo"), contactData.getPhoto());
        type(By.name("home"), contactData.getPhoneHome());
        type(By.name("mobile"), contactData.getPhoneMobile());
        type(By.name("work"), contactData.getPhoneWork());
        type(By.name("email"), contactData.getMail());
        type(By.name("email2"), contactData.getMail2());
        type(By.name("email3"), contactData.getMail3());

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
    }

    public void buttonEditContactById(int id) {
        wd.findElement(By.cssSelector("a[href='edit.php?id="+id+"']")).click();
    }



    public void buttonUpdateContact() {
        click(By.name("update"));
    }

    public void checkboxContact(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }

    public void checkboxContactById(int id) {
        wd.findElement(By.cssSelector("input[id = '"+ id + "']")).click();
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


    public void create(ContactData contact, boolean groupField) {
        clickButtonNewContact();
        fillingFieldsNewContact(contact, groupField);
        sabmitContactCreation();
        //contactCache = null;
        goToHomePage();
    }
    public void modify(ContactData newcontact) {
        buttonEditContactById(newcontact.getId());
        fillingFieldsNewContact(newcontact, false);
        buttonUpdateContact();
      //  contactCache = null;
        goToHomePage();
    }


    public void delete(ContactData contact) {
        checkboxContactById(contact.getId());
        buttonDeleteContact();
     //   contactCache = null;
        alertmessage();
        waitSecond();
    }


    public boolean chekingContact() {
        return isElementPresent(By.xpath("(//td[@class = 'center']//*[@title = 'Edit'])[1]"));
    }

    public int getContactCount() {
        return wd.findElements(By.name("selected[]")).size();
    }

 //   private Contacts contactCache = null;


    public Contacts allcompare() {
        Contacts contacts = new Contacts();
        List<WebElement> sernames = wd.findElements(By.cssSelector("tr[name=\"entry\"]"));
        for (WebElement element: sernames) {
            List<WebElement> cells = element.findElements(By.tagName("td"));
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            String sername = cells.get(1).getText();
            String name = cells.get(2).getText();
            String[] emails = cells.get(4).getText().split("\n");
          // String[] phones = cells.get(5).getText().split("\n");
          //  contacts.add(new ContactData().withId(id).withName(name).withSername(sername).withPhoneHome(phones[0]).withphoneMobile(phones[1]).withphoneWork(phones[2])
            contacts.add(new ContactData().withId(id).withName(name).withSername(sername)
                    .withMail(emails[0]).withMail2(emails[1]).withMail3(emails[2]));
        }
        return contacts;
    }

    public Contacts all() {
        Contacts contacts = new Contacts();
        List<WebElement> sernames = wd.findElements(By.cssSelector("tr[name=\"entry\"]"));
        for (WebElement element: sernames) {
            List<WebElement> cells = element.findElements(By.tagName("td"));
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            String sername = cells.get(1).getText();
            String name = cells.get(2).getText();
            String allEmail = cells.get(4).getText();
            String allPhones = cells.get(5).getText();
            contacts.add(new ContactData().withId(id).withName(name).withSername(sername).withAllPhones(allPhones).withAllEmail(allEmail));
        }
        return contacts;
    }

    public ContactData infoFormEditForm(ContactData contact) {
        buttonEditContactById(contact.getId());
        String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
        String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
        String home = wd.findElement(By.name("home")).getAttribute("value");
        String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
        String work = wd.findElement(By.name("work")).getAttribute("value");
        String email1 = wd.findElement(By.name("email")).getAttribute("value");
        String email2 = wd.findElement(By.name("email2")).getAttribute("value");
        String email3 = wd.findElement(By.name("email3")).getAttribute("value");
        wd.navigate().back();
        return new ContactData().withId(contact.getId()).withName(firstname).withSername(lastname).withPhoneHome(home)
                .withphoneMobile(mobile).withphoneWork(work).withMail(email1).withMail2(email2).withMail3(email3);
    }
}

