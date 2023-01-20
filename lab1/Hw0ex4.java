/**
 * Add the number by condition.
 * @author SHIHS
 */
public class Hw0ex4 {
    // For i th item, plus the number for i th to i+n th item.
    // If the item is negative, skip it.
    public static void windowPosSum(int[] a, int n) {
        // i 為正在處理的項目
        for (int i = 0; i < a.length; i += 1) {
            if (a[i] < 0) {
                continue;
            }
            // j 表示為準備要加的項目
            for (int j = i; j < i + n; j += 1) {
                if (j < a.length - 1) {
                    a[i] = a[i] + a[j + 1];
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, -3, 4, 5, 4};
        int n = 3;
        windowPosSum(a, n);

        // Should print 4, 8, -3, 13, 9, 4
        System.out.println(java.util.Arrays.toString(a));
    }
}
