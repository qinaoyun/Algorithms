package main.pers.qinaoyun.fundamentals.exercises;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Description:
 *
 * @author qinaoyun
 *         Date: 2017-11-04
 *         Time: 14:09
 */
public class Deque<Item> implements Iterable<Item> {
    private int n;
    private Node first;
    private Node last;
    private Node sentinel;

    public class Node {
        private Item item;
        private Node next;
        private Node prev;
    }

    public Deque() {
        first = null;
        last = first;
        sentinel = new Node();
        sentinel.next = first;
        n = 0;
    }

    public boolean isEmpty() {
        return sentinel.next == null;
    }

    private int size() {
        return n;
    }

    public void addFirst(Item item) {
        if (item == null) {
            throw new NullPointerException("NUll item");
        }
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        first.prev = sentinel;
        if (!isEmpty()) {
            oldFirst.prev = first;
        } else {
            last = first;
        }
        sentinel.next = first;
        n++;
    }

    public void addLast(Item item) {
        if (item == null) {
            throw new NullPointerException("Null item");
        }
        if (isEmpty()) {
            addFirst(item);
        } else {
            Node oldLast = last;

            last = new Node();
            last.item = item;
            oldLast.next = last;
            last.prev = oldLast;
            last.next = null;
            n++;
        }
    }

    public Item removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque underflow");
        }

        Item item = first.item;     // save item to return

        first = first.next;
        sentinel.next = first;          // delete first node
        if (isEmpty()) {
            last = null; // to avoid loitering
        } else {
            first.prev = sentinel;
        }
        n--;
        return item;                // return the saved item
    }

    public Item removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque underflow");
        }

        Item item = last.item;

        last = last.prev;
        last.next = null;
        if (isEmpty()) // to avoid loitering
        {
            first = null;
            last = first;
        }
        n--;
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            Item item = current.item;

            current = current.next;
            return item;
        }
    }

    public static void main(String[] args) {
        Deque<String> deque = new Deque<String>();

        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) {
                deque.addLast(item);
            } else if (!deque.isEmpty()) {
                deque.removeFirst();
            }
            for (String str : deque) {
                StdOut.print(str + " ");
            }
            StdOut.println("\t" + deque.isEmpty());
        }
    }
}
