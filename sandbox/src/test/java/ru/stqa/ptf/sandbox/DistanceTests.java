package ru.stqa.ptf.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.sandbox.Point;

public class DistanceTests {

    @Test
    public void testPointv1() {
        Point p1 = new Point(2, 6);
        Point p2 = new Point(5,9);

        Assert.assertEquals( p1.distance(p2), 4.242640687119285);

    }


    @Test
    public void testPointv2(){
        Point p1 = new Point(8, 2);
        Point p2 = new Point(15,6);

        Assert.assertEquals( p1.distance(p2), 8.06225774829855);
    }

    @Test
    public void testPointv3(){
        Point p1 = new Point(7, 5);
        Point p2 = new Point(15,8);

        Assert.assertEquals( p1.distance(p2), 8.54400374531753);
    }


}
