package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import java.util.Set;

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
      Set<ContactData> before = app.contact().all();
        ContactData modifiedContact = before.iterator().next();
        ContactData newcontact = new ContactData()
                .withId(modifiedContact.getId()).withName("Maria").withSername("Semakina").withNikename("MarSem")
                .withPhone("624-55-57").withMail("addressnew2@mail.ru");
      app.contact().modify(newcontact);
      Set<ContactData> after = app.contact().all();
      Assert.assertEquals(after.size(), before.size());

      before.remove(modifiedContact);
      before.add(newcontact);
      Assert.assertEquals(before, after);

      app.getSessionHelper().logOut();
    }

}
