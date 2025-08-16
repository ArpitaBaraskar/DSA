class Solution {
    public List<Integer> intersection(int[][] nums) {
        int n = nums.length;
        int[] freq = new int[1001];

         for (int[] row : nums) {
            //HashSet<Integer> set = new HashSet<>();
            // for (int num : row) {
            //     set.add(num); // avoid counting duplicates in the same row
            // }
            for (int num : row) {
                freq[num]++;
            }
        }

        List<Integer> map = new ArrayList<>();

        for(int i =1; i < 1001; i++){
            if(freq[i] == n){
                map.add(i);
            }
        }
        return map;
    }
}