class Solution {
    public int findNumbers(int[] nums) {
        int n = 0;
        for(int num: nums){
            int i = 0;
            while(num > 0){
               int m = num % 10;
               i++;
               num /= 10;
            }
            if(i % 2 == 0){
                n++;
            }
        }
        return n;
    }
}