import java.util.*;

class Solution {
    private long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }

    public List<Integer> replaceNonCoprimes(int[] nums) {
        Stack<Long> stack = new Stack<>();
        
        for (int num : nums) {
            long curr = num;
            while (!stack.isEmpty() && gcd(stack.peek(), curr) > 1) {
                curr = lcm(stack.pop(), curr);
            }
            stack.push(curr);
        }
        
        List<Integer> result = new ArrayList<>();
        for (long val : stack) {
            result.add((int) val);
        }
        return result;
    }
}
