package ru.stqa.pft.addressbook.tests;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class GroupCreationsTests extends TestBase {

  @DataProvider

  public Iterator<Object[]> validGroups() throws IOException {
    List<Object[]> list = new ArrayList<Object[]>();
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/group.json")));
    String line = reader.readLine();
    while (line !=null){
      String[] split = line.split(";");
      list.add(new Object[] {new GroupData().withName(split[0]).withHeader(split[1]).withFooter(split[2])});
      line = reader.readLine();
    }
    // list.add(new Object[] {new GroupData().withName("test1").withHeader("header1").withFooter("footer1")});
  //  list.add(new Object[] {new GroupData().withName("test2").withHeader("header2").withFooter("footer2")});
 //   list.add(new Object[] {new GroupData().withName("test3").withHeader("header3").withFooter("footer3")});
    return list.iterator();
  }


  @Test (dataProvider = "validGroups")
  public void testGroupCreations(GroupData group) throws Exception {
    app.goTo().groupPage();
    Groups before = app.group().all();
    app.group().create(group);
    Groups after = app.group().all();
    assertThat(after.size(), equalTo(before.size()+1));
    assertThat(after, equalTo(
            before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    app.getSessionHelper().logOut();
  }


}
