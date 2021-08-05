package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContactModificationTests extends TestBase {


    @Test

    public void testContactModification() {
        if( ! app.getContactHelper().chekingContact()){
            app.getContactHelper().createContact(new ContactData("Viktirya", "Ledovskikh", "LedoVik", "965-88-52", "addressnew@mail.ru", "test5"), true);
        }
      List<ContactData> before = app.getContactHelper().getContactList();
      app.getContactHelper().buttonEditContact(before.size()-1);
      ContactData newcontact = new ContactData(before.get(before.size()-1).getId(),"Maria", "Semakina", "MarSem", "624-55-57", "addressnew2@mail.ru", null);
      app.getContactHelper().fillingFieldsNewContact((newcontact), false);
      app.getContactHelper().buttonUpdateContact();
      app.getContactHelper().goToHomePage();
      List<ContactData> after = app.getContactHelper().getContactList();
      Assert.assertEquals(after.size(), before.size());

      before.remove(before.size()-1);
      before.add(newcontact);
        Comparator<? super ContactData> byid = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byid);
        after.sort(byid);
      Assert.assertEquals(before, after);

      app.getSessionHelper().logOut();
    }
}
