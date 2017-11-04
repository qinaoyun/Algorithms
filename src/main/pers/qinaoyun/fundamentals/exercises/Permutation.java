package main.pers.qinaoyun.fundamentals.exercises;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Description:
 *
 * @author qinaoyun 随机队列
 *         Date: 2017-11-04
 *         Time: 16:27
 */
public class Permutation {
    /**
     * Creates one {@code RandomizedQueue} object
     * of maximum size at most k.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        RandomizedQueue<String> rq = new RandomizedQueue<String>();
        StringBuilder builder = new StringBuilder();
        int cnt = 0;

        while (!StdIn.isEmpty()) {
            builder.append(StdIn.readString()).append(' ');
            cnt++;
        }
        if (builder.length() > 0) {
            builder.deleteCharAt(builder.length() - 1);
        }

        String[] strs = builder.toString().split(" "); // splits converted str into a String array
        int k = Integer.parseInt(args[0]);
        int[] indices = StdRandom.permutation(cnt, k);

        for (int i = 0; i < k; ++i) {
            rq.enqueue(strs[indices[i]]);
        }
        for (String s : rq) {
            StdOut.println(s);
        }
    }
}