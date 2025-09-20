import java.util.*;

class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);

        int totalUnits = 0;

        for (int[] box : boxTypes) {
            int boxCount = box[0];   
            int unitsPerBox = box[1]; 

            if (truckSize >= boxCount) {
                totalUnits += boxCount * unitsPerBox;
                truckSize -= boxCount;
            } else {
                totalUnits += truckSize * unitsPerBox;
                break; 
            }
        }

        return totalUnits;
    }
}
