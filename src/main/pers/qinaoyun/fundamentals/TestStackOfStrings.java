package main.pers.qinaoyun.fundamentals;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Description: 测试栈的小方法
 *
 * @author qinaoyun
 *         Date: 2017-10-18
 *         Time: 15:11
 */
public class TestStackOfStrings {
    public static void main(String[] args) {
        FixedCapacityStackOfStrings s;
        s = new FixedCapacityStackOfStrings(100);
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) {
                s.push(item);
            } else if (!s.isEmpty()) {
                StdOut.print(s.pop() + "");
            }
        }
        StdOut.println("(" + s.size() + "left on stack)");
    }

}
