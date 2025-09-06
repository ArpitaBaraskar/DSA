class Solution {
    public int makeTheIntegerZero(int num1, int num2) {
        if (num1 == 0) return 0;
        // try k from 1..60 (safe upper bound)
        for (int k = 1; k <= 60; k++) {
            long res = (long)num1 - (long)k * (long)num2;
            if (res < k) break;                 // can't represent with k powers if res < k
            int bits = Long.bitCount(res);      // popcount
            if (bits <= k && k <= res) return k;
        }
        return -1;
    }
}
