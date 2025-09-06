import java.util.*;

class Solution {
    private int[] counts;   // stores the result
    private int[] indexes;  // tracks original indexes

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        counts = new int[n];
        indexes = new int[n];
        for (int i = 0; i < n; i++) indexes[i] = i;

        mergeSort(nums, 0, n - 1);

        // convert result to list
        List<Integer> res = new ArrayList<>();
        for (int c : counts) res.add(c);
        return res;
    }

    private void mergeSort(int[] nums, int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;

        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);

        merge(nums, left, mid, right);
    }

    private void merge(int[] nums, int left, int mid, int right) {
        int[] tempIndexes = new int[right - left + 1];

        int i = left;     // left part
        int j = mid + 1;  // right part
        int k = 0;
        int rightCount = 0; // how many right elements are smaller

        while (i <= mid && j <= right) {
            if (nums[indexes[j]] < nums[indexes[i]]) {
                // right element smaller → increases count
                tempIndexes[k++] = indexes[j++];
                rightCount++;
            } else {
                counts[indexes[i]] += rightCount;
                tempIndexes[k++] = indexes[i++];
            }
        }

        while (i <= mid) {
            counts[indexes[i]] += rightCount;
            tempIndexes[k++] = indexes[i++];
        }

        while (j <= right) {
            tempIndexes[k++] = indexes[j++];
        }

        // copy back
        for (int p = 0; p < tempIndexes.length; p++) {
            indexes[left + p] = tempIndexes[p];
        }
    }
}
