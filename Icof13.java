package com.yaco.icof;

import com.sun.org.apache.regexp.internal.RE;

import java.util.*;

public class Icof13 {
    private int result;
    private int m;
    private int n;
    LinkedList<List<Integer>> coordinateList;
    Map<String, Boolean> recordMap;
    public int movingCount(int m, int n, int k) {
        result = 0;
        this.m = m;
        this.n = n;
        coordinateList = new LinkedList<>();
        recordMap = new HashMap<>();
        // 初始点
        List<Integer> startPoint = new ArrayList<>();
        startPoint.add(0);
        startPoint.add(0);
        // 初始点比可达
        recordMap.put("0,0", true);
        coordinateList.add(startPoint);
        result++;
        while (!coordinateList.isEmpty()) {
            // 列表中的都是可达的，判断其周围的点是否满足可达的条件
            List<Integer> point = coordinateList.poll();
            int x = point.get(0);
            int y = point.get(1);
            isPointAccessible(x -1, y, k);
            isPointAccessible( x, y - 1, k);
            isPointAccessible(x + 1, y, k);
            isPointAccessible( x, y + 1, k);
        }
        return result;
    }

    public void isPointAccessible(int x, int y, int k) {
        String key = String.valueOf(x) + "," + String.valueOf(y);
        // 点在范围内, 且未访问过
        if(x >= 0 && y >=0 && x < m && y < n && recordMap.get(key) == null) {
            int count = 0;
            count += x % 10 + x / 10;
            count += y % 10 + y / 10;
            // 满足k的条件
            if (count <= k) {
                List<Integer> point = new ArrayList<>();
                point.add(x);
                point.add(y);
                // 该点可达
                coordinateList.add(point);
                recordMap.put(key, true);
                result++;
            } else {
                recordMap.put(key, false);
            }
        }

    }

    public static void main(String[] args) {
        Icof13 icof13 = new Icof13();
        System.out.println(icof13.movingCount(3, 1, 0));
    }
}
