import java.util.*;

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(String s, int index, List<String> path, List<String> result) {
        if (path.size() > 4) return;

        if (path.size() == 4 && index == s.length()) {
            result.add(String.join(".", path));
            return;
        }

        for (int len = 1; len <= 3; len++) {
            if (index + len > s.length()) break; // out of bounds
            String part = s.substring(index, index + len);

            if (part.length() > 1 && part.startsWith("0")) continue;
            if (Integer.parseInt(part) > 255) continue;

            path.add(part);
            backtrack(s, index + len, path, result);
            path.remove(path.size() - 1);
        }
    }
}
