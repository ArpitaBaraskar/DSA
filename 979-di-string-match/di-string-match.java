class Solution {
    public int[] diStringMatch(String s) {
        int d = s.length();
        int i = 0;

        int[] arr = new int[s.length() +1];

        for(int j = 0; j < s.length(); j++){
            if(s.charAt(j) == 'D'){
                arr[j] = d;
                d--;
            }else if(s.charAt(j) == 'I'){
                arr[j] = i;
                i++;
            }

        }
        arr[s.length()] = i;
        return arr;
    }
}