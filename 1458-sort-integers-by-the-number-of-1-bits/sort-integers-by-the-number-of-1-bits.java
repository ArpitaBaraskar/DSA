class Solution {
    public int[] sortByBits(int[] arr) {
        Integer[] nums = new Integer[arr.length];

        for(int i = 0; i < arr.length; i++){
            nums[i] = arr[i];
        }
       Arrays.sort(nums, (a, b) -> {
        int bitA = Integer.bitCount(a);
        int bitB = Integer.bitCount(b);

        if(bitA == bitB) return Integer.compare(a, b);
        return Integer.compare(bitA, bitB);
       } );
       for(int i = 0; i < arr.length; i++){
            arr[i] = nums[i];
        }
       return arr;
    }
}