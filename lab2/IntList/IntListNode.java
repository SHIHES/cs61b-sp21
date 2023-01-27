package IntList;

/**
 * Practice to make a linkedList
 * @author SHIHS 2023/1/27
 * @resource <a href="https://joshhug.gitbooks.io/hug61b/content/chap2/chap21.html">...</a>
 */
public class IntListNode {

    int _value;
    IntListNode _pointer;

    public IntListNode(int value, IntListNode pointer) {
        _value = value;
        _pointer = pointer;
    }

    public static void main(String[] args) {
        // [1, 指向下一個]  -> [8, 指向下一個] -> [10, null](最後一個)
        IntListNode L = new IntListNode(1, null);
        L._pointer = new IntListNode(8, null);
        L._pointer._pointer = new IntListNode(10, null);

        System.out.print(L.size());

        // 或是有倒序法(最後一個開始寫)
//        IntListPractice L = new IntListPractice(10, null);
//        L = new IntListPractice(8, L);
//        L = new IntListPractice(1, L);
    }

    public int size() {
        while (_pointer != null) {
            return 1 + _pointer.size();
        }
        return 1;
    }

    public int iterativeSize() {
        int size = 1;
        IntListNode p = this;
        while (p != null) {
            size += 1;
            p = p._pointer;
        }
        return size;
    }

    public int get(int index) {
        int counter = 0;
        IntListNode pointer = this;
        while (counter != index) {
            counter++;
            pointer = pointer._pointer;
        }
        return pointer._value;

        //recursion way
//        if (index == 0) {
//            return _value;
//        }
//        return _pointer.get(index - 1);
    }

    // 不改變原始listNode方法
    public static IntListNode incrList(IntListNode L, int x) {
        //  newList持有第一個node ref
        IntListNode newList = new IntListNode(L._value + x, null);
        IntListNode oldListPointer = L._pointer;
        // 負責跌代存新node使用
        IntListNode iterableNode = newList;
        while (oldListPointer != null) {
            iterableNode._pointer = new IntListNode(oldListPointer._value + x, null);
            iterableNode = iterableNode._pointer;
            oldListPointer = oldListPointer._pointer;
        }
        return newList;
    }

    // 改變原始listNode方法
    public static IntListNode dincrList(IntListNode L, int x) {
        IntListNode newList = L;
        IntListNode iterableNode = L;
        // Note: 用recursion的size()，method call要執行107步
        for (int i = 0; i < L.size(); i++) {
            iterableNode._value += x;
            iterableNode = iterableNode._pointer;
        }
        return newList;
    }

}
