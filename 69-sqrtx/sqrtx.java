class Solution {
    public int mySqrt(int x) {
        if(x == 0 || x == 1){
            return x;
        }

        int start = 1;
        int end = x;
        //int mid = -1;
        int ans = 0;

        while(start <= end){
            int mid = start + (end - start)/2;
            if((long) mid * mid <  x){
                ans = mid;
                 start = mid + 1;
            }else if(mid * mid == x){
                return mid;
            }else{
               
                end = mid - 1;
            }
        }
        return ans;
    }
}