class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int sum = 0, n= nums.length;
        int maxSum = 0;

        for(int i = n-1; i >= 2; i--){
            if(nums[i] < nums[i-1]+nums[i-2]){
                sum = nums[i] + nums[i-1] + nums[i-2];
                maxSum = Math.max(sum, maxSum);
            }
        }
        return maxSum;
    }
}