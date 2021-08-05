package ru.stqa.pft.addressbook.tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;


public class ContactCreationsTests extends TestBase {


  @Test
  public void testContactCreations() throws Exception {
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().clickButtonNewContact();
    ContactData newcontact = new ContactData("Viktirya", "Ledovskikh", "LedoVik", "965-88-52", "addressnew@mail.ru", "test5");
    app.getContactHelper().createContact ((newcontact), true);
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size()+1);

    before.add(newcontact);

    app.getSessionHelper().logOut();
  }


}
