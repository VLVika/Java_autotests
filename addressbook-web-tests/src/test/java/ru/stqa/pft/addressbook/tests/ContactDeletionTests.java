package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;


public class ContactDeletionTests extends TestBase {

    @Test

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.contact().all().size() == 0) {
            app.contact().create(new ContactData()
                    .withName("Viktirya").withSername("Ledovskikh").withSername("LedoVik").withPhone("965-88-52")
                    .withMail("addressnew@mail.ru").withGroup("test5"), true);

        }
    }

    public void testContactDeletion() {
      Contacts before = app.contact().all();
      ContactData deletedContact = before.iterator().next();
      app.contact().delete(deletedContact);
      Contacts after = app.contact().all();
      assertEquals(after.size(), before.size()-1);
      assertThat(after, equalTo(before.withOut(deletedContact)));
      app.getSessionHelper().logOut();
    }

}
