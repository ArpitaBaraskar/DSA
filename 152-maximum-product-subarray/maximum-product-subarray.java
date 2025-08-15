class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int result = nums[0];

        for(int i = 1; i < nums.length; i++){
            int curr = nums[i];
            int tempmax = Math.max(curr, Math.max(min*curr, max * curr));
            int tempmin = Math.min(curr, Math.min(max*curr, min * curr));
            max = tempmax;
            min = tempmin;
            result = Math.max(result, max);
        }
        return result;
    }
}