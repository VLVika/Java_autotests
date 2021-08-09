package ru.stqa.pft.addressbook.tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;


public class ContactCreationsTests extends TestBase {


  @Test
  public void testContactCreations() throws Exception {
    Set<ContactData> before = app.contact().all();
    app.contact().clickButtonNewContact();
    ContactData newcontact = new ContactData()
            .withName("Viktirya").withSername("Ledovskikh").withNikename("LedoVik")
            .withPhone("965-88-52").withMail("addressnew@mail.ru").withGroup("test1");
    app.contact().create((newcontact), true);
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size()+1);

    newcontact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt());
    before.add(newcontact);
    Assert.assertEquals(before, after);

    app.getSessionHelper().logOut();
  }


}
