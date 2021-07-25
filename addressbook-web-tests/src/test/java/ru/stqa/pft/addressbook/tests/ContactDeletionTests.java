package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {

    @Test

    public void testContactDeletion() {
      app.getContactHelper().checkboxContact();
      app.getContactHelper().buttonDeleteContact();
      app.getContactHelper().alertmessage();
      app.getSessionHelper().logOut();
    }




}
