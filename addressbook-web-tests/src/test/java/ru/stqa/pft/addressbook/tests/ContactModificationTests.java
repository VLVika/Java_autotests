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
        if (!app.getContactHelper().chekingContact()) {
            app.getContactHelper().createContact(new ContactData("Viktirya", "Ledovskikh", "LedoVik", "965-88-52", "addressnew@mail.ru", "test5"), true);
        }
    }


    @Test
    public void testContactModification() {
      List<ContactData> before = app.getContactHelper().getContactList();
      int index = before.size()-1;
      ContactData newcontact = new ContactData(before.get(index).getId(),"Maria", "Semakina", "MarSem", "624-55-57", "addressnew2@mail.ru", null);
      app.getContactHelper().modifyGroup(index, newcontact);
      List<ContactData> after = app.getContactHelper().getContactList();
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
