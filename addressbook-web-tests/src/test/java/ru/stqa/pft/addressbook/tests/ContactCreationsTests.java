package ru.stqa.pft.addressbook.tests;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ContactCreationsTests extends TestBase {


  @Test
  public void testContactCreations() throws Exception {
    Contacts before = app.contact().all();
    app.contact().clickButtonNewContact();
    ContactData newcontact = new ContactData()
            .withName("Viktirya").withSername("Ledovskikh").withNikename("LedoVik")
            .withPhone("965-88-52").withMail("addressnew@mail.ru").withGroup("test1");
    app.contact().create((newcontact), true);
    Contacts after = app.contact().all();
    assertThat(after.size(), equalTo(before.size()+1));
    assertThat(after, equalTo(
              before.withAdded(newcontact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
    app.getSessionHelper().logOut();
  }


}
