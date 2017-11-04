package main.pers.qinaoyun.fundamentals.exercises;

import java.util.Stack;

/**
 * Description:用两个栈实现队列（栈先进后出，队列，先进先出）
 *
 * @author qinaoyun
 *         Date: 2017-11-04
 *         Time: 10:35
 */
public class QueueWithTwoStack<T> {
    private Stack<T> inbox = new Stack<T>();
    private Stack<T> outbox = new Stack<T>();

    public void enqueue(T item) {
        inbox.push(item);
    }

    public T dequeue() {
        if (outbox.isEmpty()) {
            while (!inbox.isEmpty()) {
                outbox.push(inbox.pop());

            }
        }
        return outbox.pop();
    }

    public static void main(String[] args) {
        QueueWithTwoStack<Integer> test = new QueueWithTwoStack<Integer>();
        for (int i = 0; i < 5; i++) {
            test.enqueue(i);
        }

        for (int i = 0; i < 5; i++) {
            int j = test.dequeue();
            System.out.println(j);
        }
    }
}
