class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;

        int n = nums.length;
        int longest = 1;
        Arrays.sort(nums);
        int count = 1;
        for(int i = 1; i < n; i++){
            if(nums[i]==nums[i-1]) continue;
            if(nums[i] == nums[i-1] + 1){
                count++;
            }else{
                count = 1;
            }
            longest = Math.max(longest, count);
        }
        return longest;
    }
}