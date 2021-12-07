import java.util.List;

public class AStarTest {
    private static Integer ROWS_COUNT = 14;
    private static Integer COLS_COUNT = 10;

    public static void main(String[] args) {
        Node initialNode = new Node(0, 0);
        Node finalNode = new Node(0, 9);
        AStar aStar = new AStar(ROWS_COUNT, COLS_COUNT, initialNode, finalNode);
        int[][] blocksArray = new int[][]{{0, 3}, {1, 3}, {1, 6}, {1, 8}, {2, 1}, {2, 4}, {4, 9}, {5, 9}, {5, 0}
                , {6, 4}, {6, 5}, {6, 6}, {8, 1}, {9, 1}, {10, 1}, {11, 5}, {12, 5}, {12, 2}, {12, 9}, {13, 8}, {13, 9}};

        char[][] board = new char[ROWS_COUNT][COLS_COUNT];
        List<Node> blockNodes = aStar.setBlocks(blocksArray);
        List<Node> path = aStar.findPath();


        for (int i = 0; i < ROWS_COUNT; i++) {
            for (int j = 0; j < COLS_COUNT; j++) {
                if (path.contains(new Node(i, j))) {
                    board[i][j] = '*';
                } else if (blockNodes.contains(new Node(i, j))) {
                    board[i][j] = '|';
                } else
                    board[i][j] = '.';
            }
        }

        printBoard(board);

    }

    public static void printBoard(char[][] board) {
        for (int i = 0; i < ROWS_COUNT; i++) {
            for (int j = 0; j < COLS_COUNT; j++) {
                System.out.print(board[i][j] + "    ");
            }
            System.out.println();
        }
    }

}

