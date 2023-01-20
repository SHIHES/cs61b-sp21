/**
 * Sum up the input from terminal.
 * @author SHIHS 2023/1/21
 * @resourse <a href="https://joshhug.gitbooks.io/hug61b/content/chap1/chap12.html">...</a>
 */
public class SumUpArgs {
    public static void main (String[] args) {
        int item = 0;
        int sum = 0;
        while(args.length > item) {
            sum += Integer.parseInt(args[item]);
            item += 1;
        }
        System.out.println(sum);
    }
}
