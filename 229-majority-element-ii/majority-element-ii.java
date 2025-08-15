class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;

        int n = nums.length;
        Arrays.sort(nums);
        int count = 1;

        for(int i = 1; i <= n; i++){
            if(i < n && nums[i] == nums[i-1]){
                count++;
            }else{
                if(count > n/3){
                    result.add(nums[i-1]);
                }
                count = 1;
            }

        }
        return result;
    }
}