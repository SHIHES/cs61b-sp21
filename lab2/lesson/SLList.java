package lesson;

/**
 * @author SHIHS 2023/2/3
 * @resource <a href="https://joshhug.gitbooks.io/hug61b/content/chap2/chap22.html">...</a>
 */
public class SLList {
    public static class IntNode {
        public int item;
        public IntNode next;

        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }

    /**
     * The sentinel or dummy item will always the first of the list. It can prevent the null exception happening.
     */
    private IntNode sentinel;
    private int fastSize;

    /* The first item (if it exists) is at sentinel.next */
    public SLList(int x) {
        sentinel = new IntNode(9487, null);
        sentinel.next = new IntNode(x, null);
        fastSize = 1;
    }

    public SLList () {
        sentinel = new IntNode(9487, null);
        fastSize = 0;
    }

    public SLList(int[] list) {
        sentinel = new IntNode(9487, null);
        IntNode p = sentinel;
        for(int i = 0; i < list.length; i++) {
            p.next = new IntNode(list[i], null);
            p = p.next;
        }
        fastSize = list.length;
    }

    public void addFirst(int i) {
        fastSize++;
        sentinel.next = new IntNode(i, sentinel.next);
    }

    public int getFirst() {
        if (sentinel.next != null) {
            return sentinel.next.item;
        } else {
            return -1;
        }

    }

    public int getLast() {
        IntNode p = sentinel;
        /* The first item (if it exists) is at sentinel.next */
        while (p.next != null) {
            p = p.next;
        }

        return p.item;
    }

    public void addLast(int i) {
        fastSize++;
        IntNode p = sentinel;
        /* Move p until it reaches the end of the list. */
        while (p.next != null) {
            p = p.next;
        }
        p.next = new IntNode(i, null);
    }

    /**
     * Encapsulate the size method
     * @param node
     * @return
     */
    private int size(IntNode node) {
        if (node.next == null) {
            return 1;
        }
        return 1 + size(node.next);
    }

    public int size() {
        // or just use fastSize;
        return size(sentinel.next);
    }

    public void deleteFirst() {
        IntNode p = sentinel;
        // 存在第一項
        if (p.next != null) {
            fastSize--;
            // 存在第二項
            if (p.next.next != null) {
                IntNode second = sentinel.next;
                p.next = p.next.next;

                // Remove the remove item ref. to prevent memory leak
                second.next = null;
            } else {
                sentinel.next = null;
            }

        }
    }

    public static void main(String[] args) {
        SLList l = new SLList(new int[]{2,7,10,11});
        l.addLast(80);
        l.addFirst(7);
        l.addLast(88);
        System.out.println(l.getLast());
        System.out.println(l.size());
        l.deleteFirst();
        l.deleteFirst();
        System.out.println(l.getFirst());
    }
}
