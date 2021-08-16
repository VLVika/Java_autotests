package ru.stqa.pft.addressbook.tests;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ContactCreationsTests extends TestBase {


    @Test
    public void testContactCreations() throws Exception {
        Contacts before = app.contact().all();
        app.contact().clickButtonNewContact();
        File photo = new File("src\\test\\resources\\photo.png");
        ContactData newcontact = new ContactData()
                .withName("Viktirya").withSername("Ledovskikh").withNikename("LedoVik").withPhoto(photo)
                .withPhoneHome("556-58-85").withphoneMobile("965-88-52").withphoneWork("658-94-77")
                .withMail("addressnew@mail.ru").withMail2("addressnew2@mail.ru").withMail3("addressnew3@mail.ru").withGroup("test1");
        app.contact().create((newcontact), true);
        Contacts after = app.contact().all();
        assertThat(after.size(), equalTo(before.size() + 1));
        assertThat(after, equalTo(
                before.withAdded(newcontact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
        app.getSessionHelper().logOut();
    }


    @Test(enabled = false)
    public void testCurrentDir() {
        File currentDir = new File(".");
        System.out.println(currentDir.getAbsolutePath());
        File photo = new File("src\\test\\resources\\photo.png");
        System.out.println(photo.getAbsolutePath());
        System.out.println(photo.exists());
    }
}