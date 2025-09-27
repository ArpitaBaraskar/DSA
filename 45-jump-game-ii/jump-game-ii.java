class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int currEnd = 0;
        int count = 0;
        int farther = 0;;

        for(int i = 0; i < n-1; i++){
            farther = Math.max(farther, i + nums[i]);

            if(i == currEnd){
                count++;
                currEnd = farther;
            }
        }
        return count;
    }
}