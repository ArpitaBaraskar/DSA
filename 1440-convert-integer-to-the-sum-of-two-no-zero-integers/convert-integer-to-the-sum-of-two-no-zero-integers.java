class Solution {
    public int[] getNoZeroIntegers(int n) {
        for(int a = 1; a < n; a++){
            int b = n - a;
            if(!containsZero(a) && !containsZero(b)){
                return new int[]{a, b};
            }
        }

        return new int[0];
    }

    public static boolean containsZero(int s){
        while(s > 0){
            if(s % 10 == 0){
                return true;
            }
            s = s/10;
        }
        return false;
    }
}