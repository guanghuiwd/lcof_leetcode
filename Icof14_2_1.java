package com.yaco.icof;

public class Icof14_2 {
    public int cuttingRope(int n) {
        if(n == 2) return  1;
        if(n == 3) return  2;
        long res = 1;
        while (n > 4) {
            res *= 3;
            res %= 1000000007;
            n -= 3;
        }

        return (int)(res * n % 1000000007);
    }

    public static void main(String[] args) {
        Icof14_2 icof142 = new Icof14_2();
        System.out.println(icof142.cuttingRope(5));
    }
}
