class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> numMap = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            int result = target - nums[i];

            if(numMap.containsKey(result)){
                return new int[] {numMap.get(result), i};
            }

            numMap.put(nums[i], i);
        }

        return new int[] {};
    }
}