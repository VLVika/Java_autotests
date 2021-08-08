package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase {

    @Test

    @BeforeMethod
    public void ensurePreconditions() {
        if (!app.getContactHelper().chekingContact()) {
            app.getContactHelper().createContact(new ContactData("Viktirya", "Ledovskikh", "LedoVik", "965-88-52", "addressnew@mail.ru", "test5"), true);
        }
    }

    public void testContactDeletion() {
      List<ContactData> before = app.getContactHelper().getContactList();
      app.getContactHelper().checkboxContact(before.size()-1);
      app.getContactHelper().buttonDeleteContact();
      app.getContactHelper().alertmessage();
      app.getContactHelper().waitSecond();
      List<ContactData> after = app.getContactHelper().getContactList();
      Assert.assertEquals(after.size(), before.size()-1);

      before.remove(before.size()-1);
      Assert.assertEquals(before, after);

      app.getSessionHelper().logOut();
    }




}
