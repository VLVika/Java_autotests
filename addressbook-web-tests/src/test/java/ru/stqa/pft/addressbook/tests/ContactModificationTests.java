package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {


    @Test

    public void testContactModification() {
      app.getContactHelper().buttonEditContact();
      app.getContactHelper().fillingFieldsNewContact(new ContactData("Maria", "Semakina", "MarSem", "624-55-57", "addressnew2@mail.ru"));
      app.getContactHelper().buttonUpdateContact();
      app.getNavigationHelper().goToHomePage();

    }
}
