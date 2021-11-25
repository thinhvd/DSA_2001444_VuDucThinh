
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class Solver {
    private Stack<Board> solutions;
    private boolean isSolvable;

    private class searchNode implements Comparable<searchNode> {
        private Board currBoard;
        private searchNode prevNode;
        private int moves;

        public searchNode(Board curr, searchNode prevNode) {
            this.currBoard = curr;
            this.prevNode = prevNode;

            if (this.prevNode != null) {
                this.moves = this.prevNode.moves + 1;
            } else {
                this.moves = 0;
            }
        }

        @Override
        public int compareTo(searchNode other) {
            int priority = (this.currBoard.manhattan() + this.moves) - (other.currBoard.manhattan() + other.moves);
            if (priority == 0) {
                return this.currBoard.manhattan() - other.currBoard.manhattan();
            }
            return priority;
        }
    }

    // find a solution to the initial board (using the A* algorithm)
    public Solver(Board initial) {
        if (initial == null) throw new IllegalArgumentException();
        solutions = new Stack<>();
        isSolvable = true;
        MinPQ<searchNode> searchTree = new MinPQ<>();
        MinPQ<searchNode> twinTree = new MinPQ<>();

        searchTree.insert(new searchNode(initial,null));
        twinTree.insert(new searchNode(initial.twin(),null));

        searchNode currentNode = searchTree.delMin();
        searchNode twinNode = twinTree.delMin();

        while (!currentNode.currBoard.isGoal()) {
            if (twinNode.currBoard.isGoal()) {
                isSolvable = false;
                break;
            }
            for (Board board : currentNode.currBoard.neighbors()) {
                if (currentNode.prevNode == null || !board.equals(currentNode.prevNode.currBoard)) {
                    searchTree.insert(new searchNode(board,currentNode));
                }
            }

            for (Board board : twinNode.currBoard.neighbors()) {
                if (twinNode.prevNode == null || !board.equals(twinNode.prevNode.currBoard)) {
                    twinTree.insert(new searchNode(board,twinNode));
                }
            }

            currentNode = searchTree.delMin();
            twinNode = twinTree.delMin();
        }

        if (isSolvable) {
            while (currentNode != null) {
                solutions.push(currentNode.currBoard);
                currentNode = currentNode.prevNode;
            }
        }
    }

    // is the initial board solvable? (see below)
    public boolean isSolvable() {
        return isSolvable;
    }

    // min number of moves to solve initial board; -1 if unsolvable
    public int moves() {
        if (!isSolvable()) return -1;
        return solutions.size() - 1;
    }

    // sequence of boards in a shortest solution; null if unsolvable
    public Iterable<Board> solution() {
        if (!isSolvable()) return null;
        return solutions;
    }

    // test client (see below)
    public static void main(String[] args) {
        // create initial board from file
        In in = new In(args[0]);
        int n = in.readInt();
        int[][] tiles = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                tiles[i][j] = in.readInt();
        Board initial = new Board(tiles);

        // solve the puzzle
        Solver solver = new Solver(initial);

        // print solution to standard output
        if (!solver.isSolvable())
            StdOut.println("No solution possible");
        else {
            StdOut.println("Minimum number of moves = " + solver.moves());
            for (Board board : solver.solution())
                StdOut.println(board);
        }
    }
}
