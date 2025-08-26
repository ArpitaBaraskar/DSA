import java.util.*;

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(String s, int index, List<String> path, List<String> result) {
        // If we already have 4 parts but not reached end, stop
        if (path.size() > 4) return;

        // If we have 4 parts and reached end → valid IP
        if (path.size() == 4 && index == s.length()) {
            result.add(String.join(".", path));
            return;
        }

        // Try to take 1 to 3 digits
        for (int len = 1; len <= 3; len++) {
            if (index + len > s.length()) break; // out of bounds
            String part = s.substring(index, index + len);

            // Skip invalid numbers (leading zero or >255)
            if (part.length() > 1 && part.startsWith("0")) continue;
            if (Integer.parseInt(part) > 255) continue;

            // Choose
            path.add(part);
            // Recurse
            backtrack(s, index + len, path, result);
            // Undo choice
            path.remove(path.size() - 1);
        }
    }
}
