import java.util.*;

class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;
        // Step 1: Create pair of value and index
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i]; // value
            arr[i][1] = i;       // index
        }

        // Step 2: Sort by value descending
        Arrays.sort(arr, (a, b) -> b[0] - a[0]);

        // Step 3: Pick top k elements
        int[][] topK = Arrays.copyOfRange(arr, 0, k);

        // Step 4: Sort those k elements by original index
        Arrays.sort(topK, Comparator.comparingInt(a -> a[1]));

        // Step 5: Build result
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = topK[i][0];
        }

        return result;
    }
}
