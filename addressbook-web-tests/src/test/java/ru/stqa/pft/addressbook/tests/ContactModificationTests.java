package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().contacts().size()==0) {
            app.contact().create(new ContactData()
                    .withName("Viktirya").withSername("Ledovskikh").withNikename("LedoVik").withPhoneHome("556-58-85")
                    .withphoneMobile("965-88-52").withphoneWork("658-94-77").withMail("addressnew@mail.ru").withMail2("addressnew2@mail.ru").withMail3("addressnew6@mail.ru").withGroup("test5"), true);
        }
    }


    @Test
    public void testContactModification() {
      Contacts before = app.db().contacts();
      ContactData modifiedContact = before.iterator().next();
      ContactData newcontact = new ContactData()
                .withId(modifiedContact.getId()).withName("Maria").withSername("Semakina").withNikename("MarSem").withPhoneHome("556-58-86")
                .withphoneMobile("624-55-57").withphoneWork("658-94-66").withMail("addressnew2@mail.ru").withMail2("addressnew4@mail.ru").withMail3("addressnew4@mail.ru");
      app.contact().modify(newcontact);
      Contacts after = app.db().contacts();
      assertEquals(after.size(), before.size());
      assertThat(after, equalTo(before.withOut(modifiedContact).withAdded(newcontact)));
      verifyContactListInUI();
      app.getSessionHelper().logOut();
    }

}
