package game2048;

import org.junit.Assert;
import org.junit.Test;

public class TestSide {

    /**
     * (2,1) -> E(1,1)
     */
    @Test
    public void testSide1() {
        Side east = Side.EAST;
        int size = 4;
        int[] expected = {1, 1};
        int[] actual = new int[2];
        actual[0] = east.col(2, 1, size);
        actual[1] = east.row(2, 1, size);
        Assert.assertArrayEquals(expected, actual);
    }

    /**
     * (3,1) -> W(2,3)
     */
    @Test
    public void testSide2() {
        Side east = Side.WEST;
        int size = 4;
        int[] expected = {2, 3};
        int[] actual = new int[2];
        actual[0] = east.col(3, 1, size);
        actual[1] = east.row(3, 1, size);
        Assert.assertArrayEquals(expected, actual);
    }

    /**
     *  (2,3) -> N(2,3)
     */
    @Test
    public void testSide3() {
        Side east = Side.NORTH;
        int size = 4;
        int[] expected = {2, 3};
        int[] actual = new int[2];
        actual[0] = east.col(2, 3, size);
        actual[1] = east.row(2, 3, size);
        Assert.assertArrayEquals(expected, actual);
    }
}
