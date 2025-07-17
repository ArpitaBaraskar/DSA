class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        Set<Integer> seenA = new HashSet<>();
        Set<Integer> seenB = new HashSet<>();
        Set<Integer> common = new HashSet<>();
        int[] result = new int[n];
        int count = 0;

        for(int i = 0; i < n; i++){
            int a = A[i];
            int b = B[i];

            if(seenB.contains(a)){
                common.add(a);
                count++;
            }
            seenA.add(a);

            if(seenA.contains(b)){
                common.add(b);
                count++;
            }
            seenB.add(b);

            result[i] = count;
        }
        return result;
    }
}