class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        for(int i = 1; i < n; i++){
            if(nums[i] == nums[i-1]+1){
                continue;
            }else{
                return nums[i-1]+1;
            }
        }
        if(nums[n-1] < n){
            return n;
        }
        return 0;
    }
}