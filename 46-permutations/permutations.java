import java.util.*;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), new boolean[nums.length], result);
        return result;
    }

    private void backtrack(int[] nums, List<Integer> curr, boolean[] used, List<List<Integer>> result) {
        if (curr.size() == nums.length) {   // ✅ ArrayList has size()
            result.add(new ArrayList<>(curr)); // ✅ make a copy
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue; // skip if already used

            used[i] = true;
            curr.add(nums[i]);              // ✅ ArrayList add()
            backtrack(nums, curr, used, result);
            curr.remove(curr.size() - 1);   // ✅ undo (backtrack)
            used[i] = false;
        }
    }
}
