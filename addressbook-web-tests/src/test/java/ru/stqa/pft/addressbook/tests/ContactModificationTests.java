package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {


    @Test

    public void testContactModification() {
        if( ! app.getContactHelper().chekingContact()){
            app.getContactHelper().createContact(new ContactData("Viktirya", "Ledovskikh", "LedoVik", "965-88-52", "addressnew@mail.ru", "test5"), true);
        }
      app.getContactHelper().buttonEditContact();
      app.getContactHelper().fillingFieldsNewContact(new ContactData("Maria", "Semakina", "MarSem", "624-55-57", "addressnew2@mail.ru", null), false);
      app.getContactHelper().buttonUpdateContact();
      app.getContactHelper().goToHomePage();
      app.getSessionHelper().logOut();
    }
}
