class Solution {
    public int minAddToMakeValid(String s) {
        int open = 0;       // count of unmatched '('
        int insertions = 0; // count of insertions needed

        for (char c : s.toCharArray()) {
            if (c == '(') {
                open++;
            } else { // c == ')'
                if (open > 0) {
                    open--; // match with a previous '('
                } else {
                    insertions++; // need an extra '('
                }
            }
        }

        return insertions + open;
    }
}
