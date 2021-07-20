package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;


public class ContactCreationsTests extends TestBase {


  @Test
  public void testContactCreations() throws Exception {
    clickButtonNewContact();
    fillingFieldsNewContact(new ContactData("Viktirya", "Ledovskikh", "LedoVik", "965-88-52", "addressnew@mail.ru"));
    sabmitContactCreation();
    goToHomePage();
    logOut();
  }


}
