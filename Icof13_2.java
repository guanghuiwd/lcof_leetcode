package com.yaco.icof;

import java.util.Map;

public class Icof13_2 {
    public int movingCount(int m, int n, int k) {
        int[][] record = new int[m][n];
        int result = 0;
        for (int i =0 ; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(i == 0 && j == 0) {
                    record[0][0] = 1;
                    continue;
                }
                // 先判断上和左是否可达
                int count = i % 10 + i / 10 + j % 10 + j / 10;
                // 满足k的条件
                if (count <= k && (isPointAccessible(i - 1, j, record) || isPointAccessible(i, j -1, record))) {
                    record[i][j] = 1;
                    result++;
                }
            }
        }
        return  result;
    }

    public boolean isPointAccessible(int x, int y, int[][] record) {
        return x >= 0 && y>=0 && record[x][y] == 1;
    }
}
