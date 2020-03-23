import java.util.Arrays;

public class UnionFind {


    private int[] parent;
    private int[] size;

    /* Creates a UnionFind data structure holding n vertices. Initially, all
       vertices are in disjoint sets. */
    public UnionFind(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = -1;
            size[i] = 1;
        }
    }

    /* Throws an exception if v1 is not a valid index. */
    private void validate(int vertex) {
        if (vertex >= parent.length) {
            throw new IndexOutOfBoundsException();
        }
    }

    /* Returns the size of the set v1 belongs to. */
    public int sizeOf(int v1) {
        validate(v1);
        return size[find(v1)];
    }

    /* Returns the parent of v1. If v1 is the root of a tree, returns the
       negative size of the tree for which v1 is the root. */
    private int parent(int v1) {
        validate(v1);
        if (parent[v1] > 0) {
            return parent[v1];
        }
        else {
            return sizeOf(v1)*(-1);
        }

    }

    /* Returns true if nodes v1 and v2 are connected. */
    //complete
    public boolean connected(int v1, int v2) {
        validate(v1);
        validate(v2);
        return find(v1) == find(v2);
    }

    /* Connects two elements v1 and v2 together. v1 and v2 can be any valid 
       elements, and a union-by-size heuristic is used. If the sizes of the sets
       are equal, tie break by connecting v1's root to v2's root. Unioning a 
       vertex with itself or vertices that are already connected should not 
       change the sets but may alter the internal structure of the data. */
    public void union(int v1, int v2) {

        int i = find(v1);
        int j = find(v2);
        if (i == j) {
            return;
        }
        if (size[i] <= size[j]) {
            parent[i] = j;
            size[j] += size[i];
        }
        else {
            parent[j] = i;
            size[i] += size[j];
        }

    }

    /* Returns the root of the set V belongs to. Path-compression is employed
       allowing for fast search-time. */
    //complete, not included path compression
    private int find(int vertex) {
        validate(vertex);

        if (parent[vertex] < 0) {
            return vertex;
        }
        else
            return parent[vertex] = find(parent[vertex]);
    }

}
