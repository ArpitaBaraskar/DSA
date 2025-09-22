import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        int maxFrequency = 0;
        int totalFrequency = 0;

        for (int num : nums) {
            int freq = frequencyMap.getOrDefault(num, 0) + 1;
            frequencyMap.put(num, freq);

            if (freq > maxFrequency) {
                maxFrequency = freq;
                totalFrequency = freq;
            } else if (freq == maxFrequency) {
                totalFrequency += freq;
            }
        }

        return totalFrequency;
    }
}
