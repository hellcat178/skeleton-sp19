package hw2;

import edu.princeton.cs.introcs.StdRandom;
import edu.princeton.cs.introcs.StdStats;

public class PercolationStats {
     private double[] fraction;

    // perform T independent experiments on an N-by-N grid
    public PercolationStats(int N, int T, PercolationFactory pf) {
        fraction = new double[T];

        for (int i = 0; i < T; i++) {
            Percolation percolationGrid = pf.make(N);
            while(!percolationGrid.percolates()){
                randomOpen(percolationGrid);
            }
            fraction[i] = percolationGrid.numberOfOpenSites()*1.0 / (N * N);
        }

    }
    //Randomly open a blocked site
    private void randomOpen(Percolation p) {
        int r = StdRandom.uniform(p.length);
        int c = StdRandom.uniform(p.length);
        while (p.isOpen(r, c)) {
            r = StdRandom.uniform(p.length);
            c = StdRandom.uniform(p.length);
        }
        p.open(r, c);
    }

    // sample mean of percolation threshold
    public double mean(){
        return StdStats.mean(fraction);
    }

    // sample standard deviation of percolation threshold
    public double stddev(){
        return StdStats.stddev(fraction);
    }

    // low endpoint of 95% confidence interval
    public double confidenceLow(){
        return mean() - 1.96 * stddev()/Math.sqrt(fraction.length);
    }
    public double confidenceHigh(){
        return mean() + 1.96 * stddev()/Math.sqrt(fraction.length);
    }



}
