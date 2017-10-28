
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

/**
 * Description:
 *
 * @author qinaoyun
 *         Date: 2017-10-28
 *         Time: 11:14
 */
public class PercolationStats {
    /* t fractions 均为final是因为它们只在构造函数时初始化，后续其值未发生变化*/
    private final int t;//尝试次数
    private final double[] fractions;//每一次尝试的渗透率得分

    private double mean;
    private double stddev;

    public PercolationStats(int n, int trials) {
        // perform trials independent experiments on an n-by-n grid
        if (n <= 0 || trials <= 0)
            throw new IllegalArgumentException("n ≤ 0 or trials ≤ 0");
        t = trials;
        fractions = new double[t];
        for (int i = 0; i < t; i++) {//t次尝试
            Percolation p = new Percolation(n);
            int openNum = 0;
            //为了实现随机open一个site，模仿QuickUnion的定位方法
            //先生成一个[0,n*n)的数组，数组内容随机排序,依次读取数组内容，就相当于随机取site
            int[] rand = StdRandom.permutation(n * n);
            for (int pos : rand) {
                //pos = (row-1)*n + col -1
                int row = pos / n + 1;
                int col = pos % n + 1;
                p.open(row, col);
                openNum++;
                //只有openNum>=n时才有判断是否渗透的必要
                if (openNum >= n && p.percolates())
                    break;
            }
            double pt = (double) openNum / (n * n);//单次尝试的渗透率
            fractions[i] = pt;
        }
        /* 作业提交时的某个测试案例要求mean()、stddev()、confidenceLo()、confidenceHi()
         * 在任何时候任何次序调用的情况下都必须返回相同的值，故需要在构造函数中计算mean和stddev
         */
        //作业提交时的某个测试案例要调用一次StdStats.mean方法
        mean = StdStats.mean(fractions);
        //作业提交时的某个测试案例要求要调用一次StdStats.stddev方法
        stddev = StdStats.stddev(fractions);
    }

    public double mean() {
        // sample mean of percolation threshold
        return mean;
    }

    public double stddev() {
        // sample standard deviation of percolation threshold
        return stddev;
    }

    public double confidenceLo() {
        // low endpoint of 95% confidence interval
        return mean - 1.96 * stddev / Math.sqrt(t);
    }

    public double confidenceHi() {
        // high endpoint of 95% confidence interval
        return mean + 1.96 * stddev / Math.sqrt(t);
    }

    public static void main(String[] args) {
        // test client (described below)
        int n = Integer.parseInt(args[0]);
        int t = Integer.parseInt(args[1]);
        PercolationStats ps = new PercolationStats(n, t);
        StdOut.printf("%-25s %s %f \n", "means", "=", ps.mean());
        StdOut.printf("%-25s %s %f \n", "stddev", "=", ps.stddev());
        StdOut.printf("%-25s %s%f%s%f%s\n", "95% confidence interval", "= [", ps.confidenceLo(), ", ",
                ps.confidenceHi(), "]");
    }
}