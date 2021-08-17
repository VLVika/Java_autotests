package ru.stqa.pft.addressbook.tests;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ContactCreationsTests extends TestBase {


    @DataProvider
    public Iterator<Object[]> validContacts(){
        List<Object[]> list = new ArrayList<Object[]>();
        File photo = new File("src\\test\\resources\\photo.png");
        list.add(new Object[]{new ContactData()
                .withName("Viktirya").withSername("Ledovskikh").withNikename("LedoVik").withPhoto(photo)
                .withPhoneHome("556-58-85").withphoneMobile("965-88-52").withphoneWork("658-94-77")
                .withMail("addressnew@mail.ru").withMail2("addressnew2@mail.ru").withMail3("addressnew3@mail.ru").withGroup("test1")});
        list.add(new Object[]{new ContactData()
                .withName("Viktirya2").withSername("Ledovskikh2").withNikename("LedoVik3").withPhoto(photo)
                .withPhoneHome("556-58-88").withphoneMobile("965-88-72").withphoneWork("658-54-77")
                .withMail("addressnew@mail.ru2").withMail2("addressnew2@mail.ru2").withMail3("addressnew3@mail.ru2").withGroup("test2")});
        list.add(new Object[]{new ContactData()
                .withName("Viktirya3").withSername("Ledovskikh3").withNikename("LedoVik3").withPhoto(photo)
                .withPhoneHome("556-58-89").withphoneMobile("965-88-22").withphoneWork("658-14-77")
                .withMail("addressnew@mail.ru3").withMail2("addressnew2@mail.ru3").withMail3("addressnew3@mail.ru3").withGroup("test3")});
        return list.iterator();

    }

    @Test (dataProvider = "validContacts")
    public void testContactCreations(ContactData newcontact) throws Exception {
        Contacts before = app.contact().all();
        app.contact().clickButtonNewContact();
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