package sort;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test of the sorting list ascending.
 * @author SHIHS 2023/1/28
 * @resource https://joshhug.gitbooks.io/hug61b/content/chap3/chap31.html
 */

public class SortTest {
    @Test
    public void sortTest() {
        String[] input1 = {"i", "eat", "banana", "dear"};
        String[] expected = {"banana", "dear", "eat", "i"};
        String[] actual = Sort.sort(input1);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void findSmallestTest() {
        String[] input1 = {"i", "eat", "banana", "dear"};
        int expected = 2;
        int actual = Sort.findSmallest(input1, 2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void swapTest() {
        String[] input1 = {"i", "eat", "banana", "dear"};
        String[] expected = {"banana", "eat", "i", "dear"};
        int a = 0;
        int b = 2;
        String[] actual = Sort.swap(input1, a, b);
        Assert.assertArrayEquals(expected, actual);
    }
}
