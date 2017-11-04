package main.pers.qinaoyun.fundamentals.exercises;

import java.util.Stack;

/**
 * Description: 查找栈的最大值和最小值
 *
 * @author qinaoyun
 *         Date: 2017-11-04
 *         Time: 11:03
 */
public class FindMaxMin extends Stack<Integer> {

    private Stack<Integer> minStack;
    private Stack<Integer> maxStack;
    private Stack<Integer> store;

    public FindMaxMin() {
        minStack = new Stack<Integer>();
        maxStack = new Stack<Integer>();
        store = new Stack<Integer>();
    }

    public void push(int value) {

        if (value >= MaxValue()) { //note the sign "=";
            maxStack.push(value);
        }
        if (value <= MinValue()) {
            minStack.push(value);
        }
        store.push(value);

    }

    public Integer pop() {

        int value = store.pop();
        if (value == MaxValue()) {
            maxStack.pop();
        }
        if (value == MinValue()) {
            minStack.pop();
        }
        return value;
    }

    public int MaxValue() {
        if (maxStack.isEmpty()) {
            return Integer.MIN_VALUE;
        } else {
            return maxStack.peek();//return but not remove  the most recently added element
        }

    }

    public int MinValue() {
        if (minStack.isEmpty()) {
            return Integer.MAX_VALUE;
        } else {
            return minStack.peek();
        }

    }

    /**
     * 本地测试
     *
     * @param args
     */
    public static void main(String args[]) {
        FindMaxMin test = new FindMaxMin();
        test.push(9);
        test.pop();
        test.push(5);
        test.push(3);
        test.push(7);
        test.push(1);
        test.pop();
        System.out.println("the biggest is " + test.MaxValue() + " and the smallest is " + test.MinValue());

    }

}
