class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean[][] found = new boolean[board.length][board[0].length];
                if (step(i, j, 0, found, board, word)) {
                    return true;
                }
            }
        }
        return false;
    }
    boolean step(int i, int j, int cur, boolean[][] found, char[][] board, String word) {
            if (i < 0 || i == found.length || j < 0 || j == found[0].length || found[i][j]) {
                return false;
            }
            if (board[i][j] == word.charAt(cur)) {
                cur++;
                if (cur == word.length()) {
                    return true;
                }
                found[i][j] = true;
                if (step(i + 1, j, cur, found, board, word) ||
                    step(i - 1, j, cur, found, board, word) ||
                    step(i, j + 1, cur, found, board, word) ||
                    step(i, j - 1, cur, found, board, word)) {
                        return true;
                } else {
                    found[i][j] = false;
                    return false;
                }
            } else {
                return false;
            }
        }
    
}
