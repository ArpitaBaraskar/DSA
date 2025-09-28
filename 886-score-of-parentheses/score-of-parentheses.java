class Solution {
    public int scoreOfParentheses(String s) {
        int total = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.substring(i, i + 2).equals("()")) {
                // prefix till i
                String p = s.substring(0, i);
                // depth = count('(') - count(')')
                int d = 0;
                for (char c : p.toCharArray()) {
                    if (c == '(') d++;
                    else d--;
                }
                int score = 1 << d; // same as 2^d
                total += score;
            }
        }

        return total;
    }
}
