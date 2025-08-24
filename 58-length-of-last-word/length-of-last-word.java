class Solution {
    public int lengthOfLastWord(String s) {
        String[] words = s.trim().split(" ");
        int length = 0;

        return words[words.length - 1].length();
    }
}