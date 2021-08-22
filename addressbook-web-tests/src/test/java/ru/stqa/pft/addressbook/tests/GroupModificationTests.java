package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class GroupModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    if(app.db().groups().size()==0){
    app.goTo().groupPage();
    app.group().create(new GroupData().withName("test1").withHeader("test2").withFooter("test3"));
    }
  }

    @Test

    public void testGroupModification () {
      Groups before = app.db().groups();
      GroupData modifiedGroup = before.iterator().next();
      GroupData groupdata = new GroupData().withName("test5").withHeader("test6").withFooter("test7").withId(modifiedGroup.getId());
      app.goTo().groupPage();
      app.group().modify(groupdata);
      Groups after = app.db().groups();
      assertEquals(after.size(), before.size());
      assertThat(after, equalTo(before.withOut(modifiedGroup).withAdded(groupdata)));
      app.getSessionHelper().logOut();
    }

}
