class Solution {
    public int minSwaps(String s) {
        int maxImbalance = 0;
        int imbalance = 0;

        for(char c : s.toCharArray()){
            if(c == '['){
                imbalance--;
            }else{
                imbalance++;
            }
            maxImbalance = Math.max(maxImbalance, imbalance);
        }
        return (maxImbalance + 1)/2;
    }
}