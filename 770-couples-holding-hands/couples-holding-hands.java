
class Solution {
    public int minSwapsCouples(int[] row) {
        int n = row.length;
        Map<Integer, Integer> pos = new HashMap<>();

        for (int i = 0; i < n; i++) {
            pos.put(row[i], i);
        }

        int swaps = 0;

        for (int i = 0; i < n; i += 2) {
            int first = row[i];
            int second = row[i + 1];
            
            int partner = first ^ 1;            
            if (second != partner) {
                swaps++;
                
                int partnerIndex = pos.get(partner);
                if (partnerIndex != i + 1) {  
                    row[partnerIndex] ^= row[i + 1];
                    row[i + 1] ^= row[partnerIndex];
                    row[partnerIndex] ^= row[i + 1];
                }

                pos.put(row[partnerIndex], partnerIndex);
                pos.put(row[i + 1], i + 1);
            }
        }

        return swaps;
    }
}
