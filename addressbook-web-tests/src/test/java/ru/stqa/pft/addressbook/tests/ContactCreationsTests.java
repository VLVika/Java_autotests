package ru.stqa.pft.addressbook.tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;


public class ContactCreationsTests extends TestBase {


  @Test
  public void testContactCreations() throws Exception {
    List<ContactData> before = app.getContactHelper().getContactList();
//    int before = app.getContactHelper().getContactCount();
    app.getContactHelper().clickButtonNewContact();
    app.getContactHelper().createContact(new ContactData("Viktirya", "Ledovskikh", "LedoVik", "965-88-52", "addressnew@mail.ru", "test5"), true);
    List<ContactData> after = app.getContactHelper().getContactList();
 //   int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after.size(), before.size()+1);
    app.getSessionHelper().logOut();
  }


}
