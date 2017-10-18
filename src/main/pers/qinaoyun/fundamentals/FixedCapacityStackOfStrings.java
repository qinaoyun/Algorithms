package main.pers.qinaoyun.fundamentals;

/**
 * Created  on 2017/10/18  栈
 *
 * @author qinaoyun
 */
public class FixedCapacityStackOfStrings {
    /**
     * stack entries
     */
    private String[] a;
    /**
     * size
     */
    private int n;

    public FixedCapacityStackOfStrings(int cap) {
        a = new String[cap];
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void push(String item) {
        a[n++] = item;
    }

    public String pop() {
        return a[--n];
    }
}
