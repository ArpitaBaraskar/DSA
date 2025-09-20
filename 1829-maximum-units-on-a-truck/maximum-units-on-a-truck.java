import java.util.*;

class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        // Sort by number of units per box in descending order
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);

        int totalUnits = 0;

        for (int[] box : boxTypes) {
            int boxCount = box[0];   // number of boxes
            int unitsPerBox = box[1]; // units per box

            if (truckSize >= boxCount) {
                totalUnits += boxCount * unitsPerBox;
                truckSize -= boxCount;
            } else {
                totalUnits += truckSize * unitsPerBox;
                break; // truck is full
            }
        }

        return totalUnits;
    }
}
