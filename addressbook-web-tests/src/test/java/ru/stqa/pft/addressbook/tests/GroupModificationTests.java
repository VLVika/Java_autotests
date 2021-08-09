package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class GroupModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().groupPage();
    if(app.group().list().size() ==0){
      app.group().create(new GroupData().withName("test1").withHeader("test2").withFooter("test3"));
    }
  }

    @Test

    public void testGroupModification () {
      List<GroupData> before = app.group().list();
      int index= before.size()-1;
      GroupData groupdata = new GroupData().withName("test5").withHeader("test6").withFooter("test7").withId(before.get(index).getId());
      app.group().modify(index, groupdata);
      List<GroupData> after = app.group().list();
      Assert.assertEquals(after.size(), before.size());
      app.getSessionHelper().logOut();

      before.remove(index);
      before.add(groupdata);
        Comparator<? super GroupData> byId = (g1,g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
      Assert.assertEquals(before, after);

    }



}
