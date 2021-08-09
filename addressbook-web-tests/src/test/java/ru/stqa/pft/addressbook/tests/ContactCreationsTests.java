package ru.stqa.pft.addressbook.tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;


public class ContactCreationsTests extends TestBase {


  @Test
  public void testContactCreations() throws Exception {
    List<ContactData> before = app.contact().list();
    app.contact().clickButtonNewContact();
    ContactData newcontact = new ContactData()
            .withName("Viktirya").withSername("Ledovskikh").withNikename("LedoVik")
            .withPhone("965-88-52").withMail("addressnew@mail.ru").withGroup("test1");
    app.contact().create((newcontact), true);
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size()+1);

    before.add(newcontact);
    Comparator<? super ContactData> byid = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byid);
    after.sort(byid);
    Assert.assertEquals(before, after);

    app.getSessionHelper().logOut();
  }


}
