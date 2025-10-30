class Solution {
    public String reversePrefix(String word, char ch) {
        Stack<Character> a = new Stack<>();
        Stack<Character> b = new Stack<>();

        for(int i = 0; i < word.length(); i++){
            a.push(word.charAt(i));
            if(word.charAt(i) == ch){
               while(!a.isEmpty()){
                b.push(a.pop());
               }
               int idx = i + 1;
                
              
                for (int j = idx; j < word.length(); j++) {
                    b.push(word.charAt(j));
                }
                break;
            }
        }

        if (word.indexOf(ch) == -1) {
            return word;
        }

        StringBuilder sb = new StringBuilder();
        for (Character c : b) {
            sb.append(c);
        }
        
        return sb.toString();
    }
}