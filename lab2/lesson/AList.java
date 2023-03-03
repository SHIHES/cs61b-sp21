package lesson;

/**
 * @author SHIHS 2023/2/10
 * @resource <a href="https://joshhug.gitbooks.io/hug61b/content/chap2/chap25.html">...</a>
 */
public class AList {
    /**
     * Creates an empty list.
     */
    int size;
    int[] array;

    public AList() {
        array = new int[1000];
        size = 0;
    }

    /**
     * Inserts X into the back of the list.
     */
    public void addLast(int x) {
        size++;
    }

    /**
     * Returns the item from the back of the list.
     */
    public int getLast() {
        return array[size - 1];
    }

    /**
     * Gets the ith item in the list (0 is the front).
     */
    public int get(int i) {
        return array[i];
    }

    /**
     * Returns the number of items in the list.
     */
    public int size() {
        return size;
    }

    /**
     * Deletes item from back of the list and
     * returns deleted item.
     */
    public int removeLast() {
        int temp = getLast();
        size--;
        return temp;
    }
}
