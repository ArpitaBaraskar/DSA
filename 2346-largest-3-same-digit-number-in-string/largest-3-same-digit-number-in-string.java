class Solution {
    public String largestGoodInteger(String num) {
        String ans = "";
        for(int i = 0; i < num.length() - 2; i++){
            if(num.charAt(i) == num.charAt(i+1) && num.charAt(i) == num.charAt(i+2)){
                String sub = num.substring(i, i+3);
                if(ans.equals("") || sub.compareTo(ans) > 0){
                    ans = sub;
                }
            }
        }
        return ans;
    }
}