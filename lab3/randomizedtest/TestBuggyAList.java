package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Assert;
import org.junit.Test;
import timingtest.AList;

/**
 * Created by hug.
 */
public class TestBuggyAList {
    @Test
    public void testThreeAddThreeRemove() {
        BuggyAList<Integer> buggy = new BuggyAList<>();
        AList<Integer> aList = new AList<>();

        buggy.addLast(4);
        aList.addLast(4);
        buggy.addLast(5);
        aList.addLast(5);
        buggy.addLast(6);
        aList.addLast(6);

        Assert.assertEquals(aList.removeLast(), buggy.removeLast());
        Assert.assertEquals(aList.removeLast(), buggy.removeLast());
        Assert.assertEquals(aList.removeLast(), buggy.removeLast());
    }

    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> good = new AListNoResizing<>();
        BuggyAList<Integer> bad = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 3);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                good.addLast(randVal);
                bad.addLast(randVal);
                System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                if(good.size() != 0) {
                    System.out.println("good removeLast(" + good.removeLast() + ")");
                    System.out.println("good removeLast(" + bad.removeLast() + ")");
                }
            } else if (operationNumber == 2) {
                if(good.size() != 0) {
                    System.out.println("getLast(" + good.getLast() + ")");
                    System.out.println("getLast(" + bad.getLast() + ")");
                }
            }
        }
    }

}
