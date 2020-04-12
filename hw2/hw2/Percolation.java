package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private boolean[][] grid;
    protected int length;
    private int ceiling = 0;
    private int ground;
    private WeightedQuickUnionUF uf;
    private int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    protected int count = 0;

    public Percolation(int N){
        if (N <= 0) {
            throw new IllegalArgumentException();
        }
        this.grid = new boolean[N][N];
        this.length = N;
        ground = length * length + 1;
        uf = new WeightedQuickUnionUF(ground+1);
        for (int i = 1; i < length + 1; i++) {
            uf.union(ceiling, i);
            uf.union(ground, ground - i);
        }
    }

    public void open(int row, int col){
        if (row < 0 || col < 0 || row >= length || col >= length) {
            throw new IllegalArgumentException();
        }
        grid[row][col] = true;
        count += 1;
        for (int[] dir : dirs) {
            int adjRow = row + dir[0];
            int adjCol = col + dir[1];
            if (adjRow < 0 || adjRow == length|| adjCol < 0 || adjCol == length || grid[adjRow][adjCol] == false) {
                continue;
            }
            if (grid[adjRow][adjCol] == true) {
                uf.union(xyTo1D(row,col),xyTo1D(adjRow,adjCol));
            }
        }

    }

    public boolean isOpen(int row, int col){
        if (row < 0 || col < 0 || row >= length || col >= length) {
            throw new IllegalArgumentException();
        }
        return grid[row][col];
    }

    public boolean isFull(int row, int col){
        if (row < 0 || col < 0 || row >= length || col >= length) {
            throw new IllegalArgumentException();
        }
        return uf.connected(xyTo1D(row,col),ceiling);
    }

    public int numberOfOpenSites(){
        return count;
    }

    public boolean percolate(){
        return uf.connected(ceiling, ground);
    }

    private int xyTo1D(int row, int col){
        return row * length + col + 1;
    }

    public static void main(String[] args) {


    }

}
