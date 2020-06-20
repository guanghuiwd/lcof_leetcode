package com.yaco.icof;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Icof12 {
    private boolean flag = false;
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                Map<String, Boolean> booleanMap = new HashMap<>();
                if (board[i][j] == word.charAt(0)) {
                    booleanMap.put(String.valueOf(i) + String.valueOf(j), true);
                    backTrace(board, word, 1, i, j, booleanMap);
                    if (flag) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void backTrace(char[][] board, String word, int n, int i, int j, Map<String, Boolean> booleanMap) {
        if (n == word.length()) {
            flag = true;
            return;
        }
        List<Integer[]> integers = new ArrayList<>();
        integers.add(new Integer[]{i + 1, j});
        integers.add(new Integer[]{i, j + 1});
        integers.add(new Integer[]{i, j - 1});
        integers.add(new Integer[]{i - 1, j});



        for (int idx = 0; idx < integers.size(); idx++) {
            int x = integers.get(idx)[0];
            int y = integers.get(idx)[1];
            Map<String, Boolean> newMap = new HashMap<>(booleanMap);
            // 元素匹配
            if (x >= 0 && x < board.length && y >= 0 && y < board[0].length && board[x][y] == word.charAt(n)) {
                // 判断该元素是否已经使用过
                String key = String.valueOf(x) + String.valueOf(y);
                if(newMap.get(key) == null) {
                    newMap.put(key, true);
                    backTrace(board, word, n + 1, x, y, newMap);
                }
            }
            if(flag) {
                return;
            }
        }
    }

    public static void main(String[] args) {
        Icof12 icof12 = new Icof12();
        System.out.println(icof12.exist(new char[][]{{'A', 'B', 'C', 'E'}}, "ABC"));
    }
}
