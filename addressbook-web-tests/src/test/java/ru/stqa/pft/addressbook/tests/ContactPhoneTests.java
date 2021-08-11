package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactPhoneTests extends TestBase {

    @Test

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.contact().all().size() == 0) {
            app.contact().create(new ContactData()
                    .withName("Viktirya").withSername("Ledovskikh").withSername("LedoVik").withPhone("965-88-52")
                    .withMail("addressnew@mail.ru").withGroup("test5"), true);

        }
    }






    public void testContactPhone() {

    }



}
