class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int i = 0, j = n-1;
        int maxSum = 0;
        while( i < j){
            if(nums[i] + nums[j] > maxSum){
                 maxSum = nums[i] + nums[j];
            }
        
            i++;
            j--;
           
        }

        return maxSum;
    }
}