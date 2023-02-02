package lesson;

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
     *  The sentinel or dummy item will always the first of the list. It can prevent the null exception happening.
     */
    private IntNode sentinel;
    private int fastSize;

    /* The first item (if it exists) is at sentinel.next */
    public SLList(int x) {
        sentinel = new IntNode(9487, null);
        sentinel.next = new IntNode(x, null);
        fastSize = 1;
    }

    public SLList() {
        sentinel = new IntNode(9487, null);
        fastSize = 0;
    }

    public void addFirst(int i) {
        fastSize++;
        sentinel.next = new IntNode(i, sentinel.next);
    }

    public int getFirst() {
        return sentinel.next.item;
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

    public static void main(String[] args) {
        SLList l = new SLList();
        l.addLast(80);
        l.addFirst(7);
        l.addLast(88);
        System.out.println(l.getLast());
        System.out.println(l.size());
        System.out.println(l.getFirst());
    }
}
