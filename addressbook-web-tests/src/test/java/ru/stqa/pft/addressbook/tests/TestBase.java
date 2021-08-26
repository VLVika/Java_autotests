package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.stqa.pft.addressbook.appmanager.ApplicationManager;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class TestBase {

    protected final ApplicationManager app
            = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws Exception {
        app.init();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() throws Exception {
        app.stop();

    }

    public void verifyGroupListInUI() {
        if (Boolean.getBoolean("verifyUI")) {
            Groups dbGroups = app.db().groups();
            Groups uiGroups = app.group().all();
            assertThat(uiGroups, equalTo(dbGroups.stream()
                    .map((g) -> new GroupData().withName(g.getName()).withId(g.getId()))
                    .collect(Collectors.toSet())));

        }
    }

    public void verifyContactListInUI(){
        Contacts dbContacts = app.db().contacts();
        Contacts uiContacts = app.contact().allcompare();
        assertThat(uiContacts, CoreMatchers.equalTo(dbContacts.stream().map((c) -> new ContactData()
                .withId(c.getId()).withName(c.getName()).withSername(c.getSername())
             //   .withPhoneHome(c.getPhoneHome()).withphoneMobile(c.getPhoneMobile())
                .withMail(c.getMail()).withMail2(c.getMail2()).withMail3(c.getMail3())).collect(Collectors.toSet())));
    }
}
