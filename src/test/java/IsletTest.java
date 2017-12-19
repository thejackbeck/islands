import org.junit.Assert;

import static org.junit.Assert.*;

public class IsletTest {
    @org.junit.Test
    public void isDiagonalAdjacentTo() throws Exception {
        Islet i1 = new Islet(0,0);
        Islet i2 = new Islet(1,1);
        Assert.assertTrue(i1.isAdjacentTo(i2));
        Assert.assertTrue(i2.isAdjacentTo(i1));
    }

    @org.junit.Test
    public void isHorizontalAdjacentTo() throws Exception {
        Islet i1 = new Islet(0,0);
        Islet i2 = new Islet(1,0);
        Assert.assertTrue(i1.isAdjacentTo(i2));
        Assert.assertTrue(i2.isAdjacentTo(i1));
    }

    @org.junit.Test
    public void isVerticalAdjacentTo() throws Exception {
        Islet i1 = new Islet(0,0);
        Islet i2 = new Islet(0,1);
        Assert.assertTrue(i1.isAdjacentTo(i2));
        Assert.assertTrue(i2.isAdjacentTo(i1));
    }

    @org.junit.Test
    public void isNotDiagonalAdjacentTo() throws Exception {
        Islet i1 = new Islet(0,0);
        Islet i2 = new Islet(2,2);
        Assert.assertFalse(i1.isAdjacentTo(i2));
        Assert.assertFalse(i2.isAdjacentTo(i1));
    }

    @org.junit.Test
    public void isNotHorizontalAdjacentTo() throws Exception {
        Islet i1 = new Islet(0,0);
        Islet i2 = new Islet(2,0);
        Assert.assertFalse(i1.isAdjacentTo(i2));
        Assert.assertFalse(i2.isAdjacentTo(i1));
    }

    @org.junit.Test
    public void isNotVerticalAdjacentTo() throws Exception {
        Islet i1 = new Islet(0,0);
        Islet i2 = new Islet(0,2);
        Assert.assertFalse(i1.isAdjacentTo(i2));
        Assert.assertFalse(i2.isAdjacentTo(i1));
    }
}