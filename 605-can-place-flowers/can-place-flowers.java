class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0, len = flowerbed.length;
        if(n == 0) return true;

        if(len == 1 && flowerbed[0] == 0 && n == 1) return true;
        if(flowerbed[0] == 0 && flowerbed[1] == 0){
            count++;
            flowerbed[0] = 1;
        }

        for(int i = 1; i < flowerbed.length - 1; i++){
            if(flowerbed[i] + flowerbed[i-1] + flowerbed[i+1] == 0){
               count++; 
               flowerbed[i] = 1;
            } 
            
        }
        if (flowerbed[len-1] == 0 && flowerbed[len-2] == 0) count++;
        return count >= n;
    }
}