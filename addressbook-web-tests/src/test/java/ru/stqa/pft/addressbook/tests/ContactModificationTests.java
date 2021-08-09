package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.contact().list().size() == 0) {
            app.contact().create(new ContactData()
                    .withName("Viktirya").withSername("Ledovskikh").withNikename("LedoVik").withPhone("965-88-52")
                    .withMail("addressnew@mail.ru").withGroup("test5"), true);
        }
    }


    @Test
    public void testContactModification() {
      List<ContactData> before = app.contact().list();
      int index = before.size()-1;
        ContactData newcontact = new ContactData()
                .withId(before.get(index).getId()).withName("Maria").withSername("Semakina").withNikename("MarSem")
                .withPhone("624-55-57").withMail("addressnew2@mail.ru");
      app.contact().modify(index, newcontact);
      List<ContactData> after = app.contact().list();
      Assert.assertEquals(after.size(), before.size());

      before.remove(index);
      before.add(newcontact);
        Comparator<? super ContactData> byid = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byid);
        after.sort(byid);
      Assert.assertEquals(before, after);

      app.getSessionHelper().logOut();
    }

}
