package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;


public class GroupDeletionsTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){

    if(app.db().groups().size()==0){
    app.goTo().groupPage();
    app.group().create(new GroupData().withName("test1").withHeader("test2").withFooter("test3"));
    }
  }


  @Test
  public void testGroupDeletions() throws Exception {
    Groups before = app.db().groups();
    GroupData deletedGroup = before.iterator().next();
    app.goTo().groupPage();
    app.group().delete(deletedGroup);
    Groups after = app.db().groups();
    assertEquals(after.size(), before.size()-1);
    assertThat(after, CoreMatchers.equalTo(before.withOut(deletedGroup)));
    verifyGroupListInUI();
    app.getSessionHelper().logOut();
  }

}
