class Solution {
    public int maxSubArray(int[] nums) {
        int cs =0;
        int max_sum = nums[0];

        for(int i = 0; i < nums.length; i++){
            cs += nums[i];
            max_sum = Math.max(cs, max_sum);
            if(cs < 0){
                cs = 0;
            }

        }
        return max_sum;
    }
}