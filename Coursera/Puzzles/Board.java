
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {
    private int[][] initBoard;
    private int hamming;
    private int manhattan;
    private final int n; // n-by-n grid

    // create a board from an n-by-n array of tiles,
    // where tiles[row][col] = tile at (row, col)
    public Board(int[][] tiles) {
        initBoard = tiles;
        n = tiles.length;

        int ham = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int number = initBoard[i][j];
                if (number != i * n + j + 1 && number != 0) {
                    ham++;
                }
            }
        }
        hamming = ham;

        int man = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int number = initBoard[i][j];
                if (number != 0 && number != i * n + j + 1) {
                    int correctRow = (number - 1) / n;
                    int correctCol = (number - 1) % n;
                    int manOfTiles = Math.abs(correctRow - i) + Math.abs(correctCol - j);
                    man += manOfTiles;
                }
            }
        }
        manhattan = man;
    }

    // string representation of this board
    public String toString() {
        StringBuilder s;
        s = new StringBuilder(n + "\n");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                s.append(initBoard[i][j]).append(" ");
            }
            s.append("\n");
        }
        return s.toString();
    }

    // board dimension n
    public int dimension() {
        return n;
    }

    // number of tiles out of place
    public int hamming() {
        return this.twin().hamming;
    }

    // sum of Manhattan distances between tiles and goal
    public int manhattan() {
        return this.twin().manhattan;
    }

    // is this board the goal board?
    public boolean isGoal() {
        return manhattan == 0;
    }

    // does this board equal y?
    public boolean equals(Object y) {
        if (!(y instanceof Board)) return false;
        if (y == this) return true;
        if (n == ((Board) y).n && Arrays.deepEquals(this.initBoard, ((Board) y).initBoard)) return true;
        return false;
    }

    // all neighboring boards
    public Iterable<Board> neighbors() {
        List<Board> neighbors = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (this.initBoard[i][j] == 0) {
                    if (check(i + 1, j)) {
                        Board neigh = new Board(neighborsBoard(i, j, i + 1, j));
                        neighbors.add(neigh);
                    }
                    if (check(i - 1, j)) {
                        Board neigh = new Board(neighborsBoard(i, j, i - 1, j));
                        neighbors.add(neigh);
                    }
                    if (check(i, j + 1)) {
                        Board neigh = new Board(neighborsBoard(i, j, i, j + 1));
                        neighbors.add(neigh);
                    }
                    if (check(i, j - 1)) {
                        Board neigh = new Board(neighborsBoard(i, j, i, j - 1));
                        neighbors.add(neigh);
                    }
                }
            }
        }
        return neighbors;
    }

    // copy board vao 1 board moi
    private int[][] cloneBoard() {
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            board[i] = initBoard[i].clone();
        }
        return board;
    }

    // Tim cac neighbors cua board
    private int[][] neighborsBoard(int blankRow, int blankCol, int row, int col) {
        int[][] neighbor = this.cloneBoard();
        int tmp = neighbor[blankRow][blankCol];
        neighbor[blankRow][blankCol] = neighbor[row][col];
        neighbor[row][col] = tmp;

        return neighbor;
    }

    // Kiem tra co ton tai o (r,c) hay khong
    private boolean check(int r, int c) {
        return r >= 0 && r < this.n && c >= 0 && c < this.n;
    }

    // a board that is obtained by exchanging any pair of tiles
    public Board twin() {
        Board twin = new Board(this.cloneBoard());
        if (twin.initBoard[0][0] != 0 && twin.initBoard[0][1] != 0) {
            int tmp = twin.initBoard[0][0];
            twin.initBoard[0][0] = twin.initBoard[0][1];
            twin.initBoard[0][1] = tmp;
        } else {
            int tmp = twin.initBoard[1][0];
            twin.initBoard[1][0] = twin.initBoard[1][1];
            twin.initBoard[1][1] = tmp;
        }

        return twin;

    }

    // unit testing (not graded)
    public static void main(String[] args) {

    }
}
