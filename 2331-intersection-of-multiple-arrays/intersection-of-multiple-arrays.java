class Solution {
    public List<Integer> intersection(int[][] nums) {
        int n = nums.length;
        int[] freq = new int[1001]; // given constraint: nums[i][j] <= 1000

        for (int[] row : nums) {
            HashSet<Integer> set = new HashSet<>();
            for (int num : row) {
                set.add(num); // avoid counting duplicates in the same row
            }
            for (int num : set) {
                freq[num]++;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= 1000; i++) {
            if (freq[i] == n) { // must appear in all arrays
                result.add(i);
            }
        }
        return result;
    }
}
