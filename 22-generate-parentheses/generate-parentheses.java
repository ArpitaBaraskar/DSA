class Solution {
    public static void helper(List<String> ans, int openCount, int closeCount, String str, int n){
        if(openCount == n && closeCount == n){
            ans.add(str);
            return;
        }
        if(openCount > closeCount){
            helper(ans, openCount, closeCount + 1, str + ")", n);
        }
        if(openCount < n){
            helper(ans, openCount + 1, closeCount, str + "(", n);
        }
    }
    public List<String> generateParenthesis(int n) {
        int openCount = 0;
        int closeCount = 0;
        String str = "";
        List<String> ans = new ArrayList<>();
        helper(ans, openCount , closeCount, str, n);
        return ans;
    }
}