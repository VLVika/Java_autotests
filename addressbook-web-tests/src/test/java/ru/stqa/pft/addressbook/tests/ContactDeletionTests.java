package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactDeletionTests extends TestBase {

    @Test

    public void testContactDeletion() {
        if( ! app.getContactHelper().chekingContact()){
            app.getContactHelper().createContact(new ContactData("Viktirya", "Ledovskikh", "LedoVik", "965-88-52", "addressnew@mail.ru", "test5"), true);
        }
      app.getContactHelper().checkboxContact();
      app.getContactHelper().buttonDeleteContact();
      app.getContactHelper().alertmessage();
      app.getSessionHelper().logOut();
    }




}
