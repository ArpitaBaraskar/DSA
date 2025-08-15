class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] pos = new int[n/2];
        int[] neg = new int[n/2];

        int pIdx = 0, nIdx = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] < 0){
                neg[nIdx++] = nums[i];
            }else{
                pos[pIdx++] = nums[i];
            }
        }
        int idx = 0;
        for(int i = 0; i < pos.length; i++){
            nums[idx++] = pos[i];
            nums[idx++] = neg[i];
        }
        return nums;
    }
}