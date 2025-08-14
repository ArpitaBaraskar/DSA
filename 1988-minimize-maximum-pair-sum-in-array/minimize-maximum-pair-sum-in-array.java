class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int i = 0, j = n-1;
        int maxSum = 0;
        while( i < j){
            int pairSum = nums[i] + nums[j];
            i++;
            j--;
            maxSum = Math.max(pairSum, maxSum);
        }

        return maxSum;
    }
}