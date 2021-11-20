import edu.princeton.cs.algs4.WeightedQuickUnionUF;
public class Percolation {
    // creates n-by-n grid, with all sites initially blocked
    private boolean[][] site;
    private final int n;
    private final WeightedQuickUnionUF uf;
    private int open;

    public Percolation(int n) {
        if (n <= 0) throw new IllegalArgumentException();
        this.n = n;
        site = new boolean[n][n];
        uf = new WeightedQuickUnionUF(n * n + 2);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                site[i][j] = false;
            }
        }
        open = 0;
    }

    private int oneDim(int row, int col) {
        return n * (row - 1) + col - 1;
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        if (row < 1 || col < 1 || row > n || col > n) throw new IllegalArgumentException();

        if (isOpen(row, col)) {
            return;
        }

        site[row - 1][col - 1] = true; // open node
        open++;

        if (row == 1) {
            uf.union(col - 1, n * n); // connect to top
        }
        if (row == n) {
            uf.union(oneDim(row, col), n * n + 1); // connect to bottom
        }
        // connect to surrounding node
        if (col > 1 && isOpen(row, col - 1)) {
            uf.union(oneDim(row, col), oneDim(row, col - 1));
        }
        if (col < n && isOpen(row, col + 1)) {
            uf.union(oneDim(row, col), oneDim(row, col + 1));
        }
        if (row > 1 && isOpen(row - 1, col)) {
            uf.union(oneDim(row, col), oneDim(row - 1, col));
        }
        if (row < n && isOpen(row + 1, col)) {
            uf.union(oneDim(row, col), oneDim(row + 1, col));
        }

    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        if (row < 1 || col < 1 || row > n || col > n) throw new IllegalArgumentException();
        return site[row - 1][col - 1];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        if (row < 1 || col < 1 || row > n || col > n) throw new IllegalArgumentException();
        return uf.find(oneDim(row, col)) == uf.find(n * n);
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return open;
    }

    // does the system percolate?
    public boolean percolates() {
        return uf.find(n * n) == uf.find(n * n + 1);
    }
}
