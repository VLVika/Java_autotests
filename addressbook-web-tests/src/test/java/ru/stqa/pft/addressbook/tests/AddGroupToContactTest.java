package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

public class AddGroupToContactTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.contact().goNoGroupInContact();
        if (app.contact().all().size() == 0) {
            app.contact().create(new ContactData()
                    .withName("ТестНаДобавлениеГруппы").withSername("Ledovskikh").withNikename("LedoVik").withPhoneHome("556-58-85")
                    .withphoneMobile("965-88-52").withphoneWork("658-94-77").withMail("addressnew@mail.ru").withMail2("addressnew2@mail.ru")
                    //           .withMail3("addressnew6@mail.ru").withGroup("test5"), true);
                    .withMail3("addressnew6@mail.ru"), false);
        }
        if(app.db().groups().size()==0){
            app.goTo().groupPage();
            app.group().create(new GroupData().withName("группаДляКонтакта").withHeader("траляля").withFooter("ляляля"));
        }
    }



    @Test
    public void testAddGroupToContact() {

        System.out.println("БЕБЕ");
    }

}
