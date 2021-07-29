package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupCreationsTests extends TestBase {


  @Test
  public void testGroupCreations() throws Exception {
    app.getNavigationHelper().goToGroupPage();
    app.getGroupHelper().createGroup(new GroupData("test1", "test2", "test3"));
    app.getSessionHelper().logOut();

  }


}
