class Solution {
    public int minPartitions(String n) {
        int maxDig = 0;

        for(char c : n.toCharArray()){
            maxDig = Math.max(maxDig, c - '0');
        }

        return maxDig;
    }
}