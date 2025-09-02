import java.util.*;

class Solution {
    public int numberOfPairs(int[][] points) {
        Arrays.sort(points, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            else return b[1] - a[1];
        });

        int n = points.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            int yA = points[i][1];
            int maxY = Integer.MIN_VALUE;

            for (int j = i + 1; j < n; j++) {
                int yB = points[j][1];
                if (yB <= yA && yB > maxY) {
                    count++;
                    maxY = yB;
                }
            }
        }

        return count;
    }
}
