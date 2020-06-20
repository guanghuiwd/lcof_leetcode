package com.yaco.icof;


public class Icof12_2 {
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if(backTrace(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean backTrace(char[][] board, String word, int n, int x, int y) {
        if (n == word.length()) {
            return true;
        }
        boolean res = false;
        // 元素匹配
        if (x >= 0 && x < board.length && y >= 0 && y < board[0].length && board[x][y] == word.charAt(n)) {
            char temp = board[x][y];
            // 判断该元素是否已经使用过
            board[x][y] = '/';
            res = backTrace(board, word, n + 1, x, y + 1)
                    || backTrace(board, word, n + 1, x + 1, y)
                    || backTrace(board, word, n + 1, x - 1, y)
                    || backTrace(board, word, n + 1, x, y - 1);
            board[x][y] = temp;
        }

        return res;
    }

}
