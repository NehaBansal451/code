class Solution {

    public List<List<String>> solveNQueens(int n) {

        boolean[][] board = new boolean[n][n];
        List<List<String>> ans = new ArrayList<>();

        queen(board, 0, ans);

        return ans;
    }

    static void queen(boolean[][] board, int row, List<List<String>> ans) {

        if (row == board.length) {
            ans.add(construct(board));
            return;
        }

        for (int col = 0; col < board.length; col++) {

            if (isSafe(board, row, col)) {

                board[row][col] = true;

                queen(board, row + 1, ans);

                board[row][col] = false;
            }
        }
    }

    private static boolean isSafe(boolean[][] board, int row, int col) {

        // vertical
        for (int i = 0; i < row; i++) {
            if (board[i][col]) {
                return false;
            }
        }

        // left diagonal
        int maxLeft = Math.min(row, col);

        for (int i = 1; i <= maxLeft; i++) {
            if (board[row - i][col - i]) {
                return false;
            }
        }

        // right diagonal
        int maxRight = Math.min(row, board.length - col - 1);

        for (int i = 1; i <= maxRight; i++) {
            if (board[row - i][col + i]) {
                return false;
            }
        }

        return true;
    }

    private static List<String> construct(boolean[][] board) {

        List<String> res = new ArrayList<>();

        for (boolean[] row : board) {

            StringBuilder sb = new StringBuilder();

            for (boolean cell : row) {
                if (cell) {
                    sb.append('Q');
                } else {
                    sb.append('.');
                }
            }

            res.add(sb.toString());
        }

        return res;
    }
}