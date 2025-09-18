class Solution {
    public int longestPalindrome(String s) {
        if(s.length() == 1) return 1;
        HashSet<Character> cSet = new HashSet<>();
        int length = 0;

        for( char c : s.toCharArray()){
            if(cSet.contains(c)){
                length += 2;
                cSet.remove(c);
            }else{
                cSet.add(c);
            }
        }

        if(!cSet.isEmpty()) length +=1;

        return length;
    }
}