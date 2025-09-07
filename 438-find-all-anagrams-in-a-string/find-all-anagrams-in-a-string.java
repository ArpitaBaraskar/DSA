class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if(s.length() < p.length()) return res;

        int[] pCount = new int[26];
        int[] sCount = new int[26];

        for(char c : p.toCharArray()) pCount[c - 'a']++;

        int left = 0;
        for(int right = 0; right < s.length(); right++){
            sCount[s.charAt(right) - 'a']++;

            if(right - left + 1 == p.length()){  
                if(Arrays.equals(sCount, pCount)) res.add(left);
                sCount[s.charAt(left) - 'a']--;  
                left++;
            }
        }
        return res;
    }
}
