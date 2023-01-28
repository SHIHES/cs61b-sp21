package sort;

/**
 * Sorting the list ascending.
 * @author SHIHS 2023/1/28
 * @resource https://joshhug.gitbooks.io/hug61b/content/chap3/chap31.html
 */

public class Sort {

    /**
     * Sorts strings destructively.
     */
    public static String[] sort(String[] x) {
        sort(x, 0);
        return x;
    }

    /**
     * Helps to sort the list from start index
     */
    private static void sort(String[] x, int start) {
        if (start == x.length) {
            return;
        }
        int smallestIndex = findSmallest(x, start);
        swap(x, start, smallestIndex);
        sort(x, start + 1);
    }

    /**
     * Returns the smallest index in x.
     */
    public static int findSmallest(String[] x, int start) {
        int smallest = start;
        for (int i = start; i < x.length; i += 1) {
            int cmp = x[i].compareToIgnoreCase(x[smallest]);
            if (cmp < 0) {
                smallest = i;
            }
        }
        return smallest;
    }

    /**
     * Swap the number
     */
    public static String[] swap(String[] input, int a, int b) {
        String temp = input[a];
        input[a] = input[b];
        input[b] = temp;
        return input;
    }
}
