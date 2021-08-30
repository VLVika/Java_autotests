package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.contact().all().size() == 0) {
            Groups groups = app.db().groups();
            app.contact().create(new ContactData()
                    .withName("Viktirya").withSername("Ledovskikh").withNikename("LedoVik").withPhoneHome("556-58-85")
                    .withphoneMobile("965-88-52").withphoneWork("658-94-77").withMail("addressnew@mail.ru")
                    //.withMail2("addressnew2@mail.ru").withMail3("addressnew3@mail.ru").withGroup("test5"), true);
                    .withMail2("addressnew2@mail.ru").withMail3("addressnew3@mail.ru").inGroup(groups.iterator().next()), true);
        }
    }

    @Test

        public void testContactPhone() {
        ContactData checKContact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFormEditForm(checKContact);

        assertThat(checKContact.getAllPhones(), equalTo(mergePhohes(contactInfoFromEditForm)));
        assertThat(checKContact.getAllEmail(), equalTo(mergeEmail(contactInfoFromEditForm)));

    }

    private String mergePhohes(ContactData contact) {
        return Arrays.asList(contact.getPhoneHome(), contact.getPhoneMobile(), contact.getPhoneWork())
                .stream().filter((s) -> ! s.equals(""))
                .map(ContactPhoneTests::cleaned)
                .collect(Collectors.joining("\n"));

    }

    private String mergeEmail(ContactData contact) {
        return Arrays.asList(contact.getMail(), contact.getMail2(), contact.getMail3())
                .stream().filter((s) -> ! s.equals(""))
                .collect(Collectors.joining("\n"));

    }



    public static String cleaned(String phone) {
        return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
    }



}
