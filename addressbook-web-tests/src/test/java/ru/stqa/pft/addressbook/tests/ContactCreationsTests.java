package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;



public class ContactCreationsTests extends TestBase {


  @Test
  public void testContactCreations() throws Exception {
    app.getContactHelper().clickButtonNewContact();
    app.getContactHelper().fillingFieldsNewContact(new ContactData("Viktirya", "Ledovskikh", "LedoVik", "965-88-52", "addressnew@mail.ru"));
    app.getContactHelper().sabmitContactCreation();
    app.getNavigationHelper().goToHomePage();
    app.getSessionHelper().logOut();
  }


}
