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
        if (app.contact().all().size() == 0) {
            app.contact().create(new ContactData()
                    .withName("Viktirya").withSername("Ledovskikh").withNikename("LedoVik").withPhone("965-88-52")
                    .withMail("addressnew@mail.ru").withGroup("test5"), true);
        }
    }


    @Test
    public void testContactModification() {
      Contacts before = app.contact().all();
      ContactData modifiedContact = before.iterator().next();
      ContactData newcontact = new ContactData()
                .withId(modifiedContact.getId()).withName("Maria").withSername("Semakina").withNikename("MarSem")
                .withPhone("624-55-57").withMail("addressnew2@mail.ru");
      app.contact().modify(newcontact);
      Contacts after = app.contact().all();
      assertEquals(after.size(), before.size());
      assertThat(after, equalTo(before.withOut(modifiedContact).withAdded(newcontact)));
      app.getSessionHelper().logOut();
    }

}
