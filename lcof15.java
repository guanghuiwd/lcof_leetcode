public int hammingWeight2(int n) {
    int result = 0;
    while(n != 0) {
        result += n % 2;  // 负数要避免这种操作
        n = n / 2;
    }
    return result;
}

public int hammingWeight(int n) {
    int res=0;
    while (n != 0) {
        res += n & 1;
        n = n >>> 1;
    }
    return res;
}
