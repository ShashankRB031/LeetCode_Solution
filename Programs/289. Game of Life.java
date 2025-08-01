class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;
        int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1},{1,1},{-1,-1},{1,-1},{-1,1}};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int live = 0;

                for (int[] d : dirs) {
                    int x = i + d[0], y = j + d[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && (board[x][y] == 1 || board[x][y] == 2)) {
                        live++;
                    }
                }

                if (board[i][j] == 1 && (live < 2 || live > 3)) {
                    board[i][j] = 2;
                }

                if (board[i][j] == 0 && live == 3) {
                    board[i][j] = 3;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] %= 2;
            }
        }
    }
}
