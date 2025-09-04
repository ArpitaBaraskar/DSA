// class Solution {
//     public int[] sortArray(int[] nums) {
//         mergeSort(nums, 0, nums.length - 1);
//         return nums;
//     }

//     private void mergeSort(int[] nums, int left, int right) {
//         if (left >= right) return;

//         int mid = left + (right - left) / 2;

//         mergeSort(nums, left, mid);       // sort left half
//         mergeSort(nums, mid + 1, right);  // sort right half

//         merge(nums, left, mid, right);    // merge halves
//     }

//     private void merge(int[] nums, int left, int mid, int right) {
//         int[] temp = new int[right - left + 1];
//         int i = left, j = mid + 1, k = 0;

//         // merge two sorted halves
//         while (i <= mid && j <= right) {
//             if (nums[i] <= nums[j]) {
//                 temp[k++] = nums[i++];
//             } else {
//                 temp[k++] = nums[j++];
//             }
//         }

//         // copy leftovers
//         while (i <= mid) {
//             temp[k++] = nums[i++];
//         }
//         while (j <= right) {
//             temp[k++] = nums[j++];
//         }

//         // copy back to original array
//         for (int p = 0; p < temp.length; p++) {
//             nums[left + p] = temp[p];
//         }
//     }
// }

class Solution {
    public int[] sortArray(int[] nums) {
        Arrays.sort(nums);
        return nums;
    }
}
