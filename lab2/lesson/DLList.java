package lesson;

/**
 * @author SHIHS 2023/2/5
 * @resource <a href="https://joshhug.gitbooks.io/hug61b/content/chap2/chap23.html">...</a>
 */
public class DLList<E> {

    private class Node {
        Node _pre;
        E _value;
        Node _next;

        private Node(Node pre, E value, Node next) {
            _pre = pre;
            _value = value;
            _next = next;
        }
    }

    /**
     * Use sentinel at the front and the end.
     */
    private Node sentinel;

    public DLList() {
        sentinel = new Node(null, null, null);
        sentinel._next = sentinel;
        sentinel._pre = sentinel;
    }

    public DLList(E x) {
        sentinel = new Node(null, x, null);
        sentinel._next = sentinel;
        sentinel._pre = sentinel;
    }

    public void addFirst(E x) {
        // list 裡面還有其他node
        if (sentinel._next != sentinel) {
            Node element = new Node(sentinel, x, sentinel._next);
            //原本的第一項，會變成第二項，pre要接新node
            sentinel._next._pre = element;
            //哨兵的下一項要更新成新node
            sentinel._next = element;
        } else {
            sentinel._next = new Node(sentinel, x, sentinel);
            sentinel._pre = sentinel._next;
        }
    }

    public void addLast(E x) {
        // list 裡面還有其他node
        if (sentinel._next != sentinel) {
            Node element = new Node(sentinel._pre, x, sentinel);
            sentinel._pre._next = element;
            sentinel._pre = element;
        } else {
            sentinel._next = new Node(sentinel, x, sentinel);
            sentinel._pre = sentinel._next;
        }
    }

    public E getFirst() {
        return sentinel._next._value;
    }

    public E getLast() {
        return sentinel._pre._value;
    }

    private int size(Node node) {
        //因為現在第一項跟最後一項都是同隻哨兵，所以可以直接用node == sentinel回傳0來停止recursive
        if (node == sentinel) {
            return 0;
        }
        return 1 + size(node._next);
    }

//    private void removeFirst() {
//        // 存在一項
//        if (sentinel._next != sentinel) {
//            // 存在第二項
//            if (sentinel._next._next != sentinel) {
//                Node removeThis = sentinel._next;
//                sentinel._next = sentinel._next._next._pre;
//                sentinel._next._pre = sentinel;
//                removeThis._pre = null;
//                removeThis._next = null;
//            } else {
//                sentinel._next._next = null;
//                sentinel._next._pre = null;
//                sentinel._next = sentinel;
//                sentinel._pre = sentinel;
//            }
//        }
//    }
//    private void removeLast() {
//
//    }
    public int size() {
        return size(sentinel._next);
    }

    public static void main(String[] args) {
        DLList<String> d = new DLList<>();
        d.addLast("sure");
        d.addLast("yes");
        d.addLast("really");
        System.out.println(d.getFirst());
        System.out.println(d.getLast());
        System.out.println(d.size());
    }
}
