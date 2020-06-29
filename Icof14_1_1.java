package com.yaco.icof;

public class Icof14_1 {
    public int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int temp = 0;
            for (int j = 1; j <= i / 2; j++) {
                temp = Math.max(temp, Math.max(dp[j], j) * Math.max(dp[i - j], i - j));
            }
            dp[i] = temp;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Icof14_1 icof141 = new Icof14_1();
        System.out.println(icof141.cuttingRope(100));
    }
}
