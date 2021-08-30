package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;


public class ContactDeletionTests extends TestBase {


    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().contacts().size()==0) {
            Groups groups = app.db().groups();
            app.contact().create(new ContactData()
                    .withName("Viktirya").withSername("Ledovskikh").withNikename("LedoVik").withPhoneHome("556-58-85")
                    .withphoneMobile("965-88-52").withphoneWork("658-94-77").withMail("addressnew@mail.ru")
                   // .withMail2("addressnew2@mail.ru").withMail3("addressnew3@mail.ru").withGroup("test5"), true);
                    .withMail2("addressnew2@mail.ru").withMail3("addressnew3@mail.ru").inGroup(groups.iterator().next()), true);
        }
    }

    @Test

    public void testContactDeletion() {
      Contacts before = app.db().contacts();
      ContactData deletedContact = before.iterator().next();
      app.contact().delete(deletedContact);
      Contacts after = app.db().contacts();
      assertEquals(after.size(), before.size()-1);
      assertThat(after, equalTo(before.withOut(deletedContact)));
      verifyContactListInUI();
      app.getSessionHelper().logOut();
    }

}
